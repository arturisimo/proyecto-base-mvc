package org.apz.xxx.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.service.def.ComunService;
import org.apz.xxx.service.def.SeguridadService;
import org.apz.xxx.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
	
@Controller 
public class InicioController {

	private static Logger logger = Logger.getLogger(InicioController.class);

	@Autowired
	private SeguridadService seguridadService;
	
	@Autowired
	private ComunService comunService;
	
	/**
	 *			 Controller de Inicio. 
			
					[from]: 	login.jsp
					[to]: 	    inicio.jsp 
						
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({"/inicio", "/"})
	public ModelAndView inicioConSpringAnterior(HttpServletRequest request, 
												HttpSession session) throws Exception {
		logger.debug("---------- inicio ");
		
		if (Utilidades.PATHRAIZ == null || Utilidades.PATHRAIZ.equals("")){
			recogerContexto(request);
		}
		
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("redirect:/portada/");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UsuarioBean bUsuario = null;
		
		if (auth != null) {
			
			//Recoger URL 	y setearla en Utilidades 
			Utilidades.URL_APP = getUrlBaseApp(request);
			
			String sUserName =  auth.getName();
			
			System.out.println("[auth] : "  + sUserName);
			
			bUsuario = seguridadService.getUsuarioByLogin(sUserName);
		
			request.getSession().setAttribute("userPermissions", seguridadService.obtenerMapaPermisos(bUsuario));
			
			String lang = "es";
			Locale loc = new Locale(lang);
			Config.set(request.getSession(), Config.FMT_LOCALE, loc);
			
			request.getSession().setAttribute("bUsuario", bUsuario);
			
			logger.debug("[] : " +bUsuario);
			Long idUsuLogeado = bUsuario.getId();
			
			logger.debug("login: " + bUsuario.getLogin());
			
			session.setAttribute("bUsuario", bUsuario);
			session.setAttribute("idUsuLogeado", idUsuLogeado);
			session.setAttribute("user_login", bUsuario.getLogin());
			
			logger.debug("[USuario_id] : " + bUsuario.getId());
		}
		else {
			System.out.println("[auth]: null");
		}
		
		return mv;
	}
	
	/*************************************************************************************
	 * 
	 * Controller del login
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 **************************************************************************************/
	@RequestMapping(value = "/login")
	public ModelAndView login(Model model) throws Exception {
		logger.info("[---| Start_Method: [login] |-- )");
		return new ModelAndView("tiles.login");
	}
	
	@RequestMapping(value = "/login/failed")
	public ModelAndView loginFallo(Model model) throws Exception {
		ModelAndView mv = new ModelAndView("tiles.login");
		mv.addObject("error", true);
		return mv;
	}

	/*************************************************************************************
	 * 
	 * Controller de la portada
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 **************************************************************************************/
	@RequestMapping(value = "/portada")
	public ModelAndView portada(Model model) throws Exception {
		return new ModelAndView("tiles.portada");
	}
	
	/**
	 * Controller para monitorizar los datos del servidor, sesiones, etc... 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/monitorizar/")
	public ModelAndView monitorizar (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		LinkedHashMap<String,Object> datos = new LinkedHashMap<String, Object>(); 
		
		String defaultCharacterEncoding = System.getProperty("file.encoding");
		
		UsuarioBean bUsuario = (UsuarioBean) request.getSession().getAttribute("bUsuario");
		
		datos.put("reader.getEncoding()", defaultCharacterEncoding);
		datos.put("getDefaultCharEncoding()", getDefaultCharEncoding());
		datos.put("Charset.defaultCharset()", Charset.defaultCharset());
		datos.put("System.getProperty(\"file.encoding\")",System.getProperty("file.encoding"));
		datos.put("Locale.getDefault()", Locale.getDefault());
		
		if (bUsuario!=null)
		{
			datos.put("ID Usuario", bUsuario.getId());
		}
		
		datos.put("RUTA_BASE", Utilidades.RUTA_BASE);
		datos.put("SERVER_NAME", Utilidades.SERVER_NAME);
		datos.put("QUARTZ_ACTIVE", Utilidades.QUARTZ_ACTIVE);
		datos.put("MAIL_XXX_FROM", Utilidades.MAIL_XXX_FROM);
		datos.put("RUTA_MANUALES", Utilidades.RUTA_MANUALES);
		
		Properties properties = System.getProperties();
		HashMap<String,String> propiedadesSistema = new HashMap<String,String>(); 
		for (Iterator<Entry<Object,Object>> iterator = properties.entrySet().iterator(); iterator.hasNext();) 
		{
            Entry<Object, Object> entry = (Entry<Object, Object>) iterator.next();
            propiedadesSistema.put((String) entry.getKey(),(String)entry.getValue());
		} 
		
		Properties p4j = new Properties();
		InputStream is = new FileInputStream(Utilidades.PATH_LOG4J);
		p4j.load(is);
		is.close();

		HashMap<String,String> propiedadesLog4j = new HashMap<String,String>(); 
		for (Iterator<Entry<Object,Object>> iterator = p4j.entrySet().iterator(); iterator.hasNext();) 
		{
            Entry<Object, Object> entry = (Entry<Object, Object>) iterator.next();
            propiedadesLog4j.put((String) entry.getKey(),(String)entry.getValue());
		} 
		
		//Parametros pasados a la maquina virtual
		Properties pjvm = new Properties();
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		if (runtimeMxBean != null)
		{
			List<String> arguments = runtimeMxBean.getInputArguments();
			if (arguments != null) {
				for (String arg : arguments) 
				{
					if (arg.indexOf("=") >0 )
					{
						String[] aux = arg.split("=");
						pjvm.put(aux[0],aux[1]);	
					}
					
				}
			}
		}
		
		//Parametros de la base de datos
		List<HashMap<String,Object>> parametrosDB = comunService.getParametrosDatabase();
		
		
		//Privilegios en la base de datos
		String usuarioBD = comunService.getUsuarioDatabase();
		List<HashMap<String,Object>> privilegiosDB = comunService.getPrivilegiosUsuario();
		
		ModelAndView mv = new ModelAndView("tiles.xxxxx.monitorizar");
		
		mv.addObject("datos",datos);
		mv.addObject("propiedadesSistema", propiedadesSistema);
		mv.addObject("propiedadesLog4j", propiedadesLog4j);
		mv.addObject("propiedadesJvm", pjvm);
		mv.addObject("parametrosDB", parametrosDB);
		mv.addObject("usuarioBD", usuarioBD);
		mv.addObject("privilegiosDB", privilegiosDB);
		
		return mv;
	}
	
	
	private String getDefaultCharEncoding(){
		   
		byte [] bArray = {'w'};
	    InputStream is = new ByteArrayInputStream(bArray);
	    InputStreamReader reader = new InputStreamReader(is);
	    String defaultCharacterEncoding = reader.getEncoding();
	    return defaultCharacterEncoding;
	}
	
	
	/**
	 * Controller de logout
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/logout")
	public ModelAndView logout (HttpServletRequest request) throws IOException {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/inicio");
	}

	/**
	 * Ir a jsp con mensaje de Pagina no encontrada 
	 * @date 26/11/2015 09:37:02
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/error/{error}")
	public ModelAndView error(@PathVariable("error") Integer error) {
		return new ModelAndView("tiles.xxxxx."+error);
	}

	/** Setea el contexto de la aplicacion **/
	private void recogerContexto(HttpServletRequest request) {
	
		String path = request.getContextPath();
		String getProtocol = request.getScheme();
		String getDomain = request.getServerName();
		String getPort = Integer.toString(request.getServerPort());
		String pathRaiz = getProtocol+"://"+getDomain+":"+getPort+path+"/";
		Utilidades.PATHRAIZ = pathRaiz;
	}

	/**
	 * Metodo que devuelve url base
	 * @param request
	 * @return Url base de la aplicacion p.ej   http://localhost:8085/
	 * @throws UnsupportedEncodingException 
	 */
	private String getUrlBaseApp(HttpServletRequest request) throws UnsupportedEncodingException{
		//Recoger URL y setearla en Utilidades 

		//String path = Utilidades.UTF8_convert(request.getContextPath());
		String path = request.getContextPath();
		String getProtocol = request.getScheme();
		String getDomain = request.getServerName();
		String getPort = (Integer.toString(request.getServerPort()));
		String pathRaiz = getProtocol+"://"+getDomain+":"+getPort+path+"/";
		return pathRaiz;
	}

}
