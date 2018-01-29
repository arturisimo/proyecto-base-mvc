package org.apz.xxx.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.service.def.AdminService;
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
	private AdminService adminService;
	
	@RequestMapping({"/inicio", "/"})
	public ModelAndView inicioConSpringAnterior(HttpServletRequest request, 
												HttpSession session) throws Exception {
		logger.debug("---------- inicio ");
		
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("redirect:/portada");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UsuarioBean usuario = null;
		
		if (auth != null) {
			
			String login =  auth.getName();
			
			usuario = adminService.getUsuarioByLogin(login);
		
			String lang = "es";
			Locale loc = new Locale(lang);
			Config.set(request.getSession(), Config.FMT_LOCALE, loc);
			
			request.getSession().setAttribute("bUsuario", usuario);
			
			logger.debug("login: " + usuario.getLogin());
			
			session.setAttribute("usuarioSession", usuario);
			
			logger.debug("[USuario_id] : " + usuario.getId());
		}
		else {
			logger.error("[auth]: null");
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
