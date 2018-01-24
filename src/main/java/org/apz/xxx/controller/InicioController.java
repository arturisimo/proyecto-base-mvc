package org.apz.xxx.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.service.def.SeguridadService;
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
		
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("redirect:/portada");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UsuarioBean bUsuario = null;
		
		if (auth != null) {
			
			String sUserName =  auth.getName();
			
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

	@RequestMapping(value = "/portada")
	public ModelAndView portada(Model model) throws Exception {
		return new ModelAndView("tiles.portada");
	}

	@RequestMapping("/logout")
	public ModelAndView logout (HttpServletRequest request) throws IOException {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/inicio");
	}

	@RequestMapping(value = "/error/{error}")
	public ModelAndView error(@PathVariable("error") Integer error) {
		return new ModelAndView("tiles.xxxxx."+error);
	}


}
