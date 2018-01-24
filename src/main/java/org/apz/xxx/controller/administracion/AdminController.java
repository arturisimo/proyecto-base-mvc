package org.apz.xxx.controller.administracion;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.service.def.AdminService;
import org.apz.xxx.service.def.RolesService;
import org.apz.xxx.service.def.UsuariosService;
import org.apz.xxx.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "")
	public ModelAndView aadmin(Model model, HttpServletRequest request) throws Exception {
		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion");
		return mv;
	}
	
	@RequestMapping(value = "/{modulo}")
	public ModelAndView usuarios(Model model, @PathVariable("modulo") String modulo) throws Exception {
		
		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion."+modulo+".listado");
		final FiltroListado filtro = new FiltroListado(Utilidades.MAP_MODULOS.get(modulo));
		mv.addObject("listado", adminService.getListado(filtro));
		mv.addObject("filtroListado", filtro);
		
		return mv;
	}
	
	@RequestMapping(value = "/busqueda", method = RequestMethod.POST)
    public ModelAndView busqueda(@ModelAttribute("filtroListado") FiltroListado filtro, Model model) {
		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion."+filtro.getModulo()+".listado");
		mv.addObject("listado", adminService.getListado(filtro));
		return mv;
    }
	
	  /****************************************************************************
	  * Metodo controlador Listado de Administracion -> Usuarios -> Detalle
	  * @param model
	  * @param request
	  * @param id
	  * 
	  * @return
	  * @throws Exception
	  **************************************************************************
	 @RequestMapping(value = "/administracion/{modulo}/detalle/{idUsuario}/")
	 public ModelAndView detalle_usuario(
		 Model model, @PathVariable("modulo") String modulo,
		 @PathVariable("idUsuario") Long id) throws Exception  {
		 
		 ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion"+modulo+".detalle");
		 
	 	//Obtengo el usuario
	 	Map<String,Object> parametros = usuariosService.getDetalleUsuario(id);
	 	
	 	//Muestro la vista
		
		
		mv.addObject("bUsu", parametros.get("bUsu"));
		
		mv.addObject("nodosRaices", parametros.get("nodosRaices"));
		mv.addObject("arbolPermisos", parametros.get("arbolPermisos"));
		mv.addObject("listaRoles", parametros.get("listaRoles"));
		
	 	return mv;
	  }*/
	 

		
}