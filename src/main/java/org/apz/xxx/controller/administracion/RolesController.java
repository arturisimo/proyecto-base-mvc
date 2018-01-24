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
//import org.apache.log4j.Logger;
//import org.apz.xxx.beans.comun.FiltroListado;
//import org.apz.xxx.service.def.RolesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * Controlador del apartado de administracion de roles
// */
//@Controller
//public class RolesController {
//	
//	private static Logger logger = Logger.getLogger(UsuariosController.class);
//	
//	@Autowired
//	private RolesService rolesService;
//	
//	/**
//	 * Metodo controlador Listado de Administracion -> Roles
//	 * @param model
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/administracion/roles/")
//	public ModelAndView roles(Model model) throws Exception {
//		
//		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.roles.listado");
//		
//		final FiltroListado filtro = new FiltroListado();
//		
//		//Mestro la vista
//		mv.addObject("listado", rolesService.getListadoRoles(filtro));
//		mv.addObject("filtroListado", filtro);
//		mv.addObject("modulo", "roles");
//		return mv;
//	}
//	
//	@RequestMapping(value = "/administracion/roles/busqueda", method = RequestMethod.POST)
//    public ModelAndView submit(@ModelAttribute("filtroListado") FiltroListado filtro, Model model) {
//		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.roles.listado");
//		mv.addObject("listado", rolesService.getListadoRoles(filtro));
//		mv.addObject("filtroListado", filtro);
//		mv.addObject("modulo", "roles");
//		return mv;
//    }
//	
//	
//	/**
//	 * Metodo controlador alta de Rol. Administracion -> Roles -> Alta
//	 * @param model
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/administracion/roles/alta/")
//	public ModelAndView alta_rol(Model model) throws Exception {
//		
//		HashMap<String,Object> parametros = rolesService.getAltaRol();
//		
//		//Muestro la vista
//		ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.roles.nuevo");
//		mv.addObject("listaPermisos", parametros.get("listaPermisos"));
//		mv.addObject("arbolPermisos", parametros.get("arbolPermisos"));
//		
//		return mv;
//	}
//	
//	
//	/****************************************************************************
//	  * Metodo controlador Listado de Administracion -> Roles -> Detalle
//	  * @param model
//	  * @param request
//	  * @param id
//	  * @return
//	  * @throws Exception
//	  ***************************************************************************/
//	 @RequestMapping(value = "/administracion/roles/detalle/{idRol}/")
//	 public ModelAndView detalle_usuario(
//			 Model model, HttpServletRequest request,HttpServletResponse response,
//			 @PathVariable("idRol") Long id) throws Exception {
//		 	
//		 	HashMap<String,Object> parametros = rolesService.getDetalleRol(id);
//		 	
//		 	//Muestro la vista
//			ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.roles.detalle");
//			mv.addObject("bRol", parametros.get("bRol"));
//			
//			mv.addObject("nodosRaices", parametros.get("nodosRaices"));
//			mv.addObject("arbolPermisos", parametros.get("arbolPermisos"));
//		 	return mv;
//	 }
//	 
//	 /****************************************************************************
//	  * Metodo controlador Listado de Administracion -> Roles -> Editar
//	  * @param model
//	  * @param request
//	  * @param id
//	  * @return
//	  * @throws Exception
//	  ***************************************************************************/
//	 @RequestMapping(value = "/administracion/roles/editar/{idRol}/")
//	 public ModelAndView editar_usuario(
//			 Model model, HttpServletRequest request,HttpServletResponse response,
//			 @PathVariable("idRol") Long id) throws Exception {
//		 	
//		 	HashMap<String,Object> parametros = rolesService.getEdicionRol(id);
//		 	
//		 	//Muestro la vista
//			ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion.roles.editar");
//			mv.addObject("bRol", parametros.get("bRol"));
//			mv.addObject("listaPermisos", parametros.get("listaPermisos"));
//			mv.addObject("arbolPermisos", parametros.get("arbolPermisos"));
//			
//		 	return mv;
//	 }
//	
//	
//	/**
//	 * Metodo controlador alta de Rol. Administracion -> Roles -> Alta -> Guardar
//	 * @param model
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/administracion/roles/guardar/")
//	public ModelAndView guardar_rol(Model model, HttpServletRequest request) throws Exception {
//		
//		//Se recogen los datos del Request
//		Map<String,Object> parametros = new HashMap<String, Object>();   
//
//		parametros.put("nombre", request.getParameter("nombre"));
//		parametros.put("descripcion", request.getParameter("descripcion"));
//	  
//		//Recuperar permisos 
//		List<String> list_permisos_select = new ArrayList<String>();
//		Enumeration paramNames = request.getParameterNames();
//		String prefix = "perm-";
//		while(paramNames.hasMoreElements())
//		{
//			String paramName = (String)paramNames.nextElement();
//			if (paramName.startsWith(prefix)){
//				list_permisos_select.add(paramName.substring(prefix.length()));
//			}
//		}
//		String[] arrayPermisos = list_permisos_select.toArray(new String[list_permisos_select.size()]);		  
//		parametros.put("arrayPermisos", arrayPermisos);
//		
//		parametros = rolesService.guardarRol(parametros);
//
//		//Se crea la vista
//		ModelAndView mv = new ModelAndView();
//		  
//		long id_result = (Long) parametros.get("id_result");
//		  
//		if (id_result != -1){
//			//Se crea la vista		  
//			mv.setViewName("redirect:/administracion/roles/detalle/"+id_result+"/");
//		} else {				
//			//Se crea la vista
//			mv.setViewName("tiles.xxxxx.administracion.roles.nuevo");
//		}
//		return mv;
//	}
//	
//	/**
//	 * Metodo controlador modificar de Rol. Administracion -> Roles -> Editar -> Guardar
//	 * @param model
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/administracion/roles/modificar/")
//	public ModelAndView modificar_rol(Model model, HttpServletRequest request) throws Exception {
//		
//		//Se recogen los datos del Request
//		Map<String,Object> parametros = new HashMap<String, Object>();   
//
//		parametros.put("id", request.getParameter("id"));
//		parametros.put("nombre", request.getParameter("nombre"));
//		parametros.put("descripcion", request.getParameter("descripcion"));
//	  
//		//Recuperar permisos 
//		List<String> list_permisos_select = new ArrayList<String>();
//		Enumeration paramNames = request.getParameterNames();
//		String prefix = "perm-";
//		while(paramNames.hasMoreElements())
//		{
//			String paramName = (String)paramNames.nextElement();
//			if (paramName.startsWith(prefix)){
//				list_permisos_select.add(paramName.substring(prefix.length()));
//			}
//		}
//		String[] arrayPermisos = list_permisos_select.toArray(new String[list_permisos_select.size()]);		  
//		parametros.put("arrayPermisos", arrayPermisos);
//		
//		parametros = rolesService.modificarRol(parametros);
//
//		//Se crea la vista
//		ModelAndView mv = new ModelAndView();
//		  
//		long id_result = (Long) parametros.get("id_result");
//		  
//		if (id_result != -1){
//			//Se crea la vista		  
//			mv.setViewName("redirect:/administracion/roles/detalle/"+id_result+"/");
//		} else {				
//			//Se crea la vista
//			mv.setViewName("redirect:/administracion/roles/editar/"+id_result+"/");
//		}
//		
//		return mv;
//	}
//	
//	
//	 /****************************************************************************
//	  * Metodo controlador Listado de Administracion -> Roles -> Editar
//	  * @param model
//	  * @param request
//	  * @param id
//	  * @return
//	  * @throws Exception
//	  ***************************************************************************/
//	 @RequestMapping(value = "/administracion/roles/eliminar/{idRol}/")
//	 public ModelAndView eliminar_usuario(
//			 Model model, HttpServletRequest request,HttpServletResponse response,
//			 @PathVariable("idRol") Long id) throws Exception {
//		 	
//		 	rolesService.eliminarRol(id);
//		 	//Muestro la vista
//			ModelAndView mv = new ModelAndView("redirect:/administracion/roles/");
//		 	return mv;
//	 }
//	
//}
