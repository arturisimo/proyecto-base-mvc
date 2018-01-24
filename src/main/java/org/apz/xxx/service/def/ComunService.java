package org.apz.xxx.service.def;

import java.util.HashMap;
import java.util.List;

/**
 * Servicio para funcionalidades comunes 
 */
public interface ComunService {

	/**
	 * Obtener los parametros de configuracion de la base de datos
	 * @date 26/11/2015 09:32:59
	 * @return
	 */
	public List<HashMap<String,Object>> getParametrosDatabase();

	/**
	 * Obtiene el usuario actual de la base de datos
	 * @date 26/11/2015 11:06:43
	 * @return
	 */
	public String getUsuarioDatabase();

	/**
	 * Obtiene los privilegios del usuario actual en la base de datos
	 * @date 26/11/2015 11:06:55
	 * @return
	 */
	public List<HashMap<String, Object>> getPrivilegiosUsuario();
	
}
