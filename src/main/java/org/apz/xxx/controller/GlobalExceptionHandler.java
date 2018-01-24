package org.apz.xxx.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apz.xxx.util.MyException;
import org.apz.xxx.util.Utilidades;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller para el manejo global de Excepciones.
 */
@ControllerAdvice 
public class GlobalExceptionHandler {
	
	    private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	    
	    @ExceptionHandler(MyException.class)
	    public ModelAndView c(HttpServletRequest request, MyException ex){
	    	logger.error("Ha ocurrido una excepcion en la siguiente URL="+request.getRequestURL());
	    	ModelAndView mv = new ModelAndView("tiles.xxxxx.500");
	    	mv.addObject("errCode", ex.getErrCode());
			mv.addObject("errMsg", ex.getErrMsg());
	        return mv;
	    }
	    
	    @ExceptionHandler(Exception.class)
	    public ModelAndView handleSQLException(HttpServletRequest request, Exception ex){
	    	logger.error("Ha ocurrido una excepcion en la siguiente URL="+request.getRequestURL());
	    	ModelAndView mv = new ModelAndView("tiles.xxxxx.500");
	        mv.addObject("errMsg", ex.getMessage() + "\n" + Utilidades.getStackTrace(ex));
	        return mv;
	    }
	    
}

