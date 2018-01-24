package org.apz.xxx.dao.seguridad;

import java.util.HashMap;
import java.util.List;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.UsuarioBean;


public interface UsuariosDao {

	UsuarioBean getUsuarioById(Long id);
	List<UsuarioBean> getUsuarios(FiltroListado filtro);
	UsuarioBean getUsuarioByLogin(String name);
	long insertUsuario(UsuarioBean bUsu);
	void insertUsuarioRol(HashMap<String, Object> mapa);
	long updateUsuario(UsuarioBean bUsu);
	int getNumUsuariosWithLogin(UsuarioBean bUsu);
	void deleteUsuarioRoles(Long id);
	void deleteUsuario(Long id);
	Integer getActualizadoUsuario(Long id);
	void updateNoActualizadoUsuario(Long id);
	void updateMarcarActualizadosByRol(Long id);
	
}
