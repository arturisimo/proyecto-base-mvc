package org.apz.xxx.controller.administracion;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.RolBean;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.service.def.AdminService;
import org.apz.xxx.util.ConstantesGenerales.Modulo;
import org.apz.xxx.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
@SessionAttributes("usuarioSession")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "")
	public ModelAndView aadmin(Model model, @ModelAttribute("usuarioSession") UsuarioBean usuarioSession) throws Exception {
		final ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion");
		return mv;
	}
	
	@RequestMapping(value = "/{modulo}")
	public ModelAndView usuarios(Model model, @PathVariable("modulo") String modulo,
			@ModelAttribute("usuarioSession") UsuarioBean usuarioSession) throws Exception {
		
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
	
	 @RequestMapping(value = "/{modulo}/{accion}/{idAdmin}")
	 public ModelAndView detalle_usuario(
		 Model model, @PathVariable("modulo") String modulo, @PathVariable("idAdmin") Long id,
		 		@PathVariable("accion") String accion, @ModelAttribute("usuarioSession") UsuarioBean usuarioSession) throws Exception  {
		 
		ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion."+modulo+"."+accion);
		
		final FiltroListado filtro = new FiltroListado(Utilidades.MAP_MODULOS.get(modulo));
		filtro.setId(id);
		
		switch (filtro.getModulo()) {
			case usuarios:
				mv.addObject("roles", adminService.getListado(new FiltroListado(Modulo.roles)));
				mv.addObject("detalle", adminService.getUsuarioDetalle(filtro));
				break;
	
			case roles:
				mv.addObject("detalle", adminService.getRolDetalle(filtro));
				break;
			
			default:
				break;
		}
		
	 	return mv;
	  }
	 
	 @RequestMapping(value = "/{modulo}/alta")
	 public ModelAndView detalle (
		 Model model, @PathVariable("modulo") String modulo, @ModelAttribute("usuarioSession") UsuarioBean usuarioSession) throws Exception  {
		 
		ModelAndView mv = new ModelAndView("tiles.xxxxx.administracion."+modulo+".editar");
		
		final FiltroListado filtro = new FiltroListado(Utilidades.MAP_MODULOS.get(modulo));
		
		switch (filtro.getModulo()) {
			case usuarios:
				mv.addObject("detalle", new UsuarioBean());
				mv.addObject("roles", adminService.getListado(new FiltroListado(Modulo.roles)));
				break;
	
			case roles:
				mv.addObject("detalle", new RolBean());
				break;
			
			default:
				break;
		}
		
	 	return mv;
	  }
		
}