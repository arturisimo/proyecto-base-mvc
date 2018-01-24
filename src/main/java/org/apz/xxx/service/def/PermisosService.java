
package org.apz.xxx.service.def;

import java.util.List;

import org.apz.xxx.beans.seguridad.PermisoBean;
/**
 * Servicio de permisos
 * 
 *
 */
public interface PermisosService {
	/**
	 * Sacar listado de permisos
	 * @param bPermiso
	 * @return
	 */
	List<PermisoBean> getListadoPermisos();
	/**
	 * Sacar arbol de permisos
	 * @param list_permisos
	 * @return
	 */
	List<PermisoBean> getArbolPermisos(List<PermisoBean> permisos);
	/**
	 * Sacar permisos para el detalle de un rol o usuario
	 * @param list_permisos
	 * @return
	 */
	List<PermisoBean> getPermisosParaDetalle(List<PermisoBean> permisos);
}
