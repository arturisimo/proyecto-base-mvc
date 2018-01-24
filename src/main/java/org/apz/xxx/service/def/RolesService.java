package org.apz.xxx.service.def;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.RolBean;

/**
 * Servicio para los roles
 */
public interface RolesService {
	/**
	 * Sacar listado de roles
	 * @param bRol
	 * @return
	 */
	List<RolBean> getListadoRoles(FiltroListado filtro);
	/**
	 * Guardar Rol
	 * @param parametros
	 * @return
	 */
	Map<String, Object> 		guardarRol(Map<String, Object> parametros);
	/**
	 * 
	 * @param id
	 * @return
	 */
	HashMap<String, Object> 	getDetalleRol(Long id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	HashMap<String, Object> 	getEdicionRol(Long id);
	/**
	 * 
	 * @return
	 */
	HashMap<String, Object> 	getAltaRol();
	/**
	 * Modificar datos del rol
	 * @param parametros
	 * @return
	 */
	Map<String, Object> 		modificarRol(Map<String, Object> parametros);
	/**
	 * Eliminar rol
	 * @param id
	 */
	void 					eliminarRol(Long id);
}
