package org.apz.xxx.dao.seguridad;

import java.util.HashMap;
import java.util.List;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.RolBean;


public interface RolDao {

	 List<RolBean> getRoles(FiltroListado filtro);
	 
	 long insertRol(RolBean bRol);
	 void insertRolPermiso(HashMap<String, Object> mapa);
	 RolBean getRolById(Long id);
	 long updateRol(RolBean bRol);
	 void deleteRolPermisos(Long id);
	 void deleteRol(Long id);
	 List<RolBean> getRolesWithPermiso(Long id_permiso);
	
}


