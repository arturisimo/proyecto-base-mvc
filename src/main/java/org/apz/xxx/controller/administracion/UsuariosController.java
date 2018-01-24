//package org.apz.xxx.controller.administracion;
//
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apz.xxx.beans.comun.FiltroListado;
//import org.apz.xxx.beans.seguridad.UsuarioBean;
//import org.apz.xxx.service.def.RolesService;
//import org.apz.xxx.service.def.UsuariosService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class UsuariosController {
//	
//	@Autowired
//	private UsuariosService usuariosService;
//	
//	@Autowired
//	private RolesService rolesService;
//	
//	/**
//	 * 
//	 *   
//	 * 
//	 * 			Metodo controlador Listado de Administracion -> Usuarios
//	 * 
//	 * @param model
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/administracion/usuarios/")
//	public ModelAndView usuarios(Model model, HttpServletRequest request) throws Exception {
//		
//		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.usuarios.listado");
//		final FiltroListado filtro = new FiltroListado();
//		mv.addObject("listado", usuariosService.getListadoUsuarios(new FiltroListado()));
//		mv.addObject("filtroListado", filtro);
//		mv.addObject("modulo", "usuarios");
//		
//		return mv;
//	}
//	
//	@RequestMapping(value = "/administracion/usuarios/busqueda", method = RequestMethod.POST)
//    public ModelAndView busqueda(@ModelAttribute("filtroListado") FiltroListado filtro, Model model) {
//		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.usuarios.listado");
//		mv.addObject("listado", usuariosService.getListadoUsuarios(filtro));
//		mv.addObject("modulo", "usuarios");
//		
//		return mv;
//    }
//	
//	  /****************************************************************************
//	  * Metodo controlador Listado de Administracion -> Usuarios -> Detalle
//	  * @param model
//	  * @param request
//	  * @param id
//	  * 
//	  * @return
//	  * @throws Exception
//	  ***************************************************************************/
//	 @RequestMapping(value = "/administracion/usuarios/detalle/{idUsuario}/")
//	 public ModelAndView detalle_usuario(
//		 Model model,HttpServletRequest request,HttpServletResponse response,
//		 @PathVariable("idUsuario") Long id) throws Exception  {
//		 
//		 ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.usuarios.detalle");
//		 
//	 	//Obtengo el usuario
//	 	Map<String,Object> parametros = usuariosService.getDetalleUsuario(id);
//	 	
//	 	//Muestro la vista
//		
//		
//		mv.addObject("bUsu", parametros.get("bUsu"));
//		
//		mv.addObject("nodosRaices", parametros.get("nodosRaices"));
//		mv.addObject("arbolPermisos", parametros.get("arbolPermisos"));
//		mv.addObject("listaRoles", parametros.get("listaRoles"));
//		
//	 	return mv;
//	  }
//	 
//	 
//	 
//	 /****************************************************************************
//	  * Metodo controlador Listado de Administracion -> Usuarios -> Edicion
//	  * @param model
//	  * @param request
//	  * @param id
//	  * @return
//	  * @throws Exception
//	  ***************************************************************************/
//	 @RequestMapping(value = "/administracion/usuarios/editar/{idUsuario}/")
//	 public ModelAndView editar_usuario(@PathVariable("idUsuario") Long id) throws Exception {
//		 	
//		 	//Muestro la vista
//			final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.usuarios.editar");
//			
//			mv.addObject("bUsu", usuariosService.getUsuarioById(id));
//			mv.addObject("listaRoles", rolesService.getListadoRoles(new FiltroListado()));	
//			
//		 	return mv;
//	 }
//	 
//	 
//	 /**
//	  * Metodo controlador modificar de Grupo. Administracion -> Usuarios -> Editar -> Guardar
//	  * @param model
//	  * @param request
//	  * @return 
//	  * @throws Exception
//	  */
//	 @RequestMapping(value = "/administracion/usuarios/modificar/")
//	 public ModelAndView modificar_usuario(Model model, HttpServletRequest request) throws Exception {
//		
//		 //Se recogen los datos del Request
//		 Map<String,Object> parametros = new HashMap<String, Object>();   
//
//		 parametros.put("id", request.getParameter("id"));
//		 parametros.put("nombre", request.getParameter("nombre"));
//		 parametros.put("login", request.getParameter("login"));
//		 parametros.put("email", request.getParameter("email"));
//		 
//		 parametros.put("tipo_usuario", request.getParameter("tipousuario"));
//		 parametros.put("id_coordinador", request.getParameter("coordinador"));
//		 parametros.put("id_gerencia_mercado", request.getParameter("gerenciamercado"));
//		 
//		 parametros.put("change", request.getParameter("change"));
//		 parametros.put("password", request.getParameter("password"));
//		 parametros.put("newpassword", request.getParameter("newpassword"));
//		 parametros.put("repassword", request.getParameter("repassword"));
//		 
//		 //Recuperar grupos y roles 
//		 List<String> list_roles_select = new ArrayList<String>();
//		 Enumeration paramNames = request.getParameterNames();
//		 String prefixRol = "rol-";
//		 while(paramNames.hasMoreElements()){
//			 String paramName = (String)paramNames.nextElement();
//			 if (paramName.startsWith(prefixRol)){
//				list_roles_select.add(paramName.substring(prefixRol.length()));
//			 }
//		 }
//		 String[] arrayRoles = list_roles_select.toArray(new String[list_roles_select.size()]);		  
//		 parametros.put("arrayRoles", arrayRoles);
//		 
//	    //Recogemos el usuario de sesion
//	     UsuarioBean bUsuario = (UsuarioBean) request.getSession().getAttribute("bUsuario");
//	     parametros.put("id_usuario", bUsuario.getId());
//	    parametros.put("nombre_usuario", bUsuario.getLogin());
//			  
//		 parametros = usuariosService.modificarUsuario(parametros);
//
//		 //Se crea la vista
//		 ModelAndView mv = new ModelAndView();
//		  
//		 long id_result = (Long) parametros.get("id_result");
//		  
//		 if (id_result != -1){
//			 //Se crea la vista		  
//			 mv.setViewName("redirect:/administracion/usuarios/detalle/"+id_result+"/");
//		 } else {				
//			 //Se crea la vista
//			 mv.setViewName("tiles.xxxxx.administracion.usuarios.editar");
//			 mv.addObject("bUsu",parametros.get("bUsu"));
//			 mv.addObject("error",parametros.get("error"));
//			 mv.addObject("mensajeError",parametros.get("mensajeError"));
//			 mv.addObject("listaRoles", parametros.get("listaRoles"));
//		 }
//		 return mv;
//	 }
//	 
//	 /****************************************************************************
//	  * Metodo controlador Listado de Administracion -> Usuarios -> Alta
//	  * @param model
//	  * @param request
//	  * @param id
//	  * @return
//	  * @throws Exception
//	  ***************************************************************************/
//	 @RequestMapping(value = "/administracion/usuarios/alta/")
//	 public ModelAndView altaUsuario(Model model) throws Exception {
//	 	
//	 	//Muestro la vista
//		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.usuarios.nuevo");
//		
//		mv.addObject("listaRoles", rolesService.getListadoRoles(new FiltroListado()));
//		
//	 	return mv;
//	 }
//	 
//	 
//	 
//	 
//	 /**
//	 * Metodo controlador alta de Grupo. Administracion -> Usuarios -> Alta -> Guardar
//	 * 
//	 * cal_personal:  [si  es true añadir calendario personal de usuario) 
//	 * 
//	 * @param model
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/administracion/usuarios/guardar/")
//	public ModelAndView guardar_usuario(Model model, HttpServletRequest request) throws Exception {
//		
//		//Se recogen los datos del Request
//		Map<String,Object> parametros = new HashMap<String, Object>();   
//		
//		parametros.put("nombre", request.getParameter("nombre"));
//		parametros.put("login", request.getParameter("login"));
//		parametros.put("email", request.getParameter("email"));
//		parametros.put("password", request.getParameter("password"));
//		
//		parametros.put("tipo_usuario", request.getParameter("tipousuario"));
//		parametros.put("id_coordinador", request.getParameter("coordinador"));
//		parametros.put("id_gerencia_mercado", request.getParameter("gerenciamercado"));
// 
//	    //Recogemos el usuario de sesion
//	    UsuarioBean bUsuario = (UsuarioBean) request.getSession().getAttribute("bUsuario");
//	    parametros.put("id_usuario", bUsuario.getId());
//	    parametros.put("nombre_usuario", bUsuario.getLogin());
//		  
//		//Recuperar  roles
//		List<String> list_roles_select = new ArrayList<String>();
//		Enumeration paramNames = request.getParameterNames();
//		String prefixRol = "rol-";
//			
//		while(paramNames.hasMoreElements()){
//			String paramName = (String)paramNames.nextElement();
//			
//			if (paramName.startsWith(prefixRol)){
//				list_roles_select.add(paramName.substring(prefixRol.length()));
//			}
//		}
//		
//		String[] arrayRoles = list_roles_select.toArray(new String[list_roles_select.size()]);		  
//		parametros.put("arrayRoles", arrayRoles);
//		
//		parametros = usuariosService.guardarUsuario(parametros);
//
//		//Se crea la vista
//		ModelAndView mv = new ModelAndView();
//		  
//		long id_result = (Long) parametros.get("id_result");
//		  
//		if (id_result != -1){
//			//Se crea la vista		  
//			mv.setViewName("redirect:/administracion/usuarios/detalle/"+id_result+"/");
//		} else {				
//			//Se crea la vista
//			mv.setViewName("tiles.xxxxx.administracion.usuarios.nuevo");
//			
//			mv.addObject("bUsu",parametros.get("bUsu"));
//			mv.addObject("error",parametros.get("error"));
//			mv.addObject("mensajeError",parametros.get("mensajeError"));
//			mv.addObject("listaRoles", parametros.get("listaRoles"));
//		}
//		
//		return mv;
//	}
//	
//	
//	 /****************************************************************************
//	  * Metodo controlador Listado de Administracion -> Usuarios -> Eliminar
//	  * @param model
//	  * @param request
//	  * @param id
//	  * @return
//	  * @throws Exception
//	  ***************************************************************************/
//	 @RequestMapping(value = "/administracion/usuarios/eliminar/{idUsuario}/")
//	 public ModelAndView eliminar_usuario(
//			 Model model, HttpServletRequest request,HttpServletResponse response,
//			 @PathVariable("idUsuario") Long id) throws Exception {
//		 	
//		 	Map<String,Object> parametros = new HashMap<String, Object>(); 
//
//		 	parametros.put("id", id);
//		 	
//		    //Recogemos el usuario de sesion
//		    UsuarioBean bUsuario = (UsuarioBean) request.getSession().getAttribute("bUsuario");
//		    parametros.put("id_usuario", bUsuario.getId());
//		    parametros.put("nombre_usuario", bUsuario.getLogin());
//			  
//		    usuariosService.eliminarUsuario(parametros);
//		 	
//		 	return new ModelAndView("redirect:/administracion/usuarios/");
//	 }
//	   
//	 
//	 
//		/**
//		 * Listado de historico de usuarios
//		 * @date 21/5/2015 11:20:30
//		 * @param req
//		 * @return
//		 */
//	   @RequestMapping("/administracion/usuarios/historicos/")
//	   public ModelAndView usuarios_historicos(HttpServletRequest req) {
//		  	  
//		  //Se recogen los datos del Request
//		  Map<String,Object> parametros = new HashMap<String, Object>(); 
//
//		  parametros = usuariosService.historicosUsuario(parametros); 
//
//		  //Se crea la vista		  
//		  ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.usuarios.historicos");  
//		  
//		  mv.addObject("list_historicos_usuario",parametros.get("list_historicos_usuario"));
//		  
//	      return mv;
//	   }
//		
//}