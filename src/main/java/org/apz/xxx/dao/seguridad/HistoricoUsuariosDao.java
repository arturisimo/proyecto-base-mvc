package org.apz.xxx.dao.seguridad;

import java.util.List;

import org.apz.xxx.beans.seguridad.HistoricoUsuariosBean;


public interface HistoricoUsuariosDao {
	
    /**
     * Obtiene el historico de un usuario
     * @param bHUsuario
     * @return
     */
    public List<HistoricoUsuariosBean> getAllHistoricoUsuarios(HistoricoUsuariosBean bHUsuario);    
    
    
    /**
     * Inserta un historico de un usuario
     * @param bHUsuario
     */
    public long insertHistoricoUsuarios(HistoricoUsuariosBean bHUsuario);
    
  
}


