package org.apz.xxx.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ComunDao {

	/**
	 * Obtiene la fecha actual de la base de datos
	 * @date 25/11/2015 16:10:35
	 * @return
	 */
	public Date getFechaActual();
	
	/**
	 * Obtiene los parametros de configuracion de la base de datos
	 * @date 25/11/2015 16:10:35
	 * @return
	 */
	public List<HashMap<String,Object>> getParametrosDatabase();
	
	/**
	 * Obtiene el usuario actual de base de datos
	 * @date 26/11/2015 11:05:57
	 * @return
	 */
	public String getUsuarioDatabase();

	/**
	 * Obtiene los privilegios que tiene el usuario en base de datos 
	 * @date 26/11/2015 11:06:09
	 * @return
	 */
	public List<HashMap<String,Object>> getPrivilegiosUsuario();
	
}


