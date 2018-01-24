package org.apz.xxx.service.def;

import java.util.HashMap;

import org.apz.xxx.beans.seguridad.UsuarioBean;


/**
 * Servicio de serguridad 
 * 
 *
 */
public interface SeguridadService {
	/**
	 * Sacar usuario por id
	 * @param id
	 * @return
	 */
	public UsuarioBean		    				getUsuarioById(Long id);
	/**
	 * Sacar usuario por login
	 * @param name
	 * @return
	 */
	public UsuarioBean 		    				getUsuarioByLogin(String name);
	/**
	 * Metodo que obtiene los permisos de un usuario
	 * @param bUsuario
	 * @return
	 */
	public HashMap<Long,String> 				obtenerMapaPermisos(UsuarioBean bUsuario);

}
