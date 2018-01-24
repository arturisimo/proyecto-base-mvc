package org.apz.xxx.service.def;

import java.util.List;
import java.util.Map;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.UsuarioBean;

/**
 * Servicio de los usuarios
 * 
 *
 */
public interface UsuariosService {
	/**
	 * Sacar listado usuarios
	 * @param bUsuario
	 * @return
	 */
	List<UsuarioBean> getListadoUsuarios(FiltroListado filtro);
	/**
	 * Sacar usuario por id
	 * @param id
	 * @return
	 */
	UsuarioBean	getUsuarioById(Long id);
	/**
	 * Sacar detalle usuario
	 * @param id
	 * @return
	 */
	Map<String, Object> 	getDetalleUsuario(Long id);
	
	/**
	 * Insertar usuario
	 * @param parametros
	 * @return
	 */
	Map<String, Object> 		guardarUsuario(Map<String, Object> parametros);
	
	/**
	 * 
	 * @date 21/5/2015 9:00:30
	 * @param parametros
	 */
	void  					eliminarUsuario(Map<String, Object> parametros);
	/**
	 * Modificar usuario
	 * @param parametros
	 * @return
	 */
	Map<String, Object> 		modificarUsuario(Map<String, Object> parametros);

	/**
	 * Obtener todos los registros del historico de usuario.
	 * @date 20/5/2015 14:22:54
	 * @param parametros
	 * @return
	 */
	Map<String, Object> historicosUsuario(Map<String, Object> parametros);
		
}

