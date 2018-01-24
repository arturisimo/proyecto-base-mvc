package org.apz.xxx.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apz.xxx.util.ConstantesGenerales.Modulo;



public class Utilidades {


	protected static Logger logger = Logger.getLogger(Utilidades.class);
	
	
	/**
	 * 
	 * @param t
	 * @return	Volcado de  la excepcion en formato String
	 */
	public static  String getStackTrace(Throwable t){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }
	
	
	public static final Map<String, Modulo> MAP_MODULOS;
	static {
		final Map<String, Modulo> map = new HashMap<>();
		map.put(Modulo.roles.name(), Modulo.roles);
		map.put(Modulo.usuarios.name(), Modulo.usuarios);
		MAP_MODULOS = Collections.unmodifiableMap(map);
	}
	
	public static String convertToMD5(String password) {
		
		String result = "";
	    
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		
		    md.update(password.getBytes());
		
		    byte byteData[] = md.digest();
		
		    StringBuffer sb = new StringBuffer();
		    
		    for (int i = 0; i < byteData.length; i++) {
		    	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		    }
	    
	    result = sb.toString();
	    
		} catch (NoSuchAlgorithmException e) {
			logger.error(Utilidades.getStackTrace(e));
		}	    
		
	    return result;
	}
	
	public static void  tracear_request(HttpServletRequest req){
		logger.debug("----- _START --> Traceando_Request_Parametros ----]");
		for (Enumeration e = req.getParameterNames(); e.hasMoreElements();) {
			String sParam = (String) e.nextElement();
			logger.debug("[request_param_name] : " + sParam + " = "
					+ req.getParameter(sParam));
		}
		logger.debug("----- _END  --> Traceando_Request_Parametros  ----]");
		
	}
}
