package org.apz.xxx.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.PermisoBean;
import org.apz.xxx.beans.seguridad.RolBean;
import org.apz.xxx.dao.seguridad.PermisosDao;
import org.apz.xxx.dao.seguridad.RolDao;
import org.apz.xxx.dao.seguridad.UsuariosDao;
import org.apz.xxx.service.def.PermisosService;
import org.apz.xxx.service.def.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * Esta clase actua como un servicio (BO) para realizar todas las tareas desde el controller
 * para Adminstracion -> Roles
 */
@Service
public class RolesServiceImpl implements RolesService {	  
	
	protected static Logger logger = Logger.getLogger(RolesServiceImpl.class);
	
	@Autowired
	RolDao rolDao;
	
	@Autowired
	UsuariosDao usuariosDao;
	
	@Autowired
	PermisosDao permisosDao;
	
	@Autowired
	PermisosService permisosService;
	
	
	@Override
	public List<RolBean> getListadoRoles(FiltroListado filtro) {
		return rolDao.getRoles(filtro);
	}

	@Override
	public Map<String, Object> guardarRol(Map<String, Object> parametros) {
		
		String nombre = (String) parametros.get("nombre");
		String descripcion = (String) parametros.get("descripcion");
		
		RolBean bRol = new RolBean();
		
		bRol.setNombre(nombre);
		bRol.setDescripcion(descripcion);
		bRol.setList_id_permisos((String[])parametros.get("arrayPermisos"));
		
		long id_result = rolDao.insertRol(bRol);

		if (id_result != -1){
			
			HashMap<String, Object> mapa = new HashMap<String, Object>();
			for (int i = 0; i < bRol.getList_id_permisos().length; i++) {
    			mapa.put("idrol", bRol.getId());
            	mapa.put("idpermiso", bRol.getList_id_permisos()[i]);
    			rolDao.insertRolPermiso(mapa);
			}
			
			parametros.put("id_result", bRol.getId());
			
		}
		
		return parametros;
	}

	@Override
	public HashMap<String, Object> getDetalleRol(Long id) {
		
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		RolBean bRol = rolDao.getRolById(id);
		
		List<PermisoBean> arbolPermisos = permisosService.getPermisosParaDetalle(bRol.getPermisos());
		  
	    Map<Long,Long> nodosRaices = new HashMap<Long,Long>();
	    Iterator<PermisoBean> it = arbolPermisos.iterator();
	    while(it.hasNext()){
		    PermisoBean b = it.next();
		    nodosRaices.put(b.getId(), b.getId());
	    } 

	    parametros.put("bRol", bRol);
	   
	    parametros.put("nodosRaices", nodosRaices);
	    parametros.put("arbolPermisos", arbolPermisos);
		
		return parametros;
	}

	@Override
	public HashMap<String, Object> getEdicionRol(Long id) {
		
		RolBean bRol = rolDao.getRolById(id);
		
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		List<PermisoBean> permisos = permisosDao.getPermisos();
		
		//Crear lista de permisos seleccionados para la busqueda
		Boolean encontrado;
		for (int i = 0; i < permisos.size(); i++) {
			encontrado = false;
			int cont = 0;
			if (bRol.getPermisos() != null) {
				while (cont<bRol.getPermisos().size() && !encontrado){
					if(permisos.get(i).getId().equals(bRol.getPermisos().get(cont).getId())){
						permisos.get(i).setSeleccionado(true);
					}
					cont++;
				}
			}
		}
		
		parametros.put("bRol", bRol);
		
		List<PermisoBean> arbolPermisos = permisosService.getArbolPermisos(permisos);
		
		parametros.put("arbolPermisos", arbolPermisos);
		parametros.put("listaPermisos", permisos);	
		
		return parametros;
	}

	@Override
	public HashMap<String, Object> getAltaRol() {
		
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		List<PermisoBean> permisos = permisosDao.getPermisos();
		
		List<PermisoBean> arbol_permisos = permisosService.getArbolPermisos(permisos);
		
		parametros.put("arbolPermisos", arbol_permisos);
		parametros.put("listaPermisos", permisos);
		
		return parametros;
	}

	@Override
	public Map<String, Object> modificarRol(Map<String, Object> parametros) {
		
		String idRol = (String) parametros.get("id");
		String nombre = (String) parametros.get("nombre");
		String descripcion = (String) parametros.get("descripcion");
		
		RolBean bRol = rolDao.getRolById(Long.parseLong(idRol));
		
		long id_result = -1;
		
		if (!bRol.getTipo().equals((short)1)){
		
			bRol.setNombre(nombre);
			bRol.setDescripcion(descripcion);
			
			id_result = rolDao.updateRol(bRol);
		
		} else {
			id_result = bRol.getId();
		}
		
		bRol.setList_id_permisos((String[])parametros.get("arrayPermisos"));
		
		if (id_result != -1){
			
			//Eliminacion de las relaciones antiguas con los permisos
    		rolDao.deleteRolPermisos(bRol.getId());
			
			HashMap<String, Object> mapa = new HashMap<String, Object>();
			for (int i = 0; i < bRol.getList_id_permisos().length; i++) {
    			mapa.put("idrol", bRol.getId());
            	mapa.put("idpermiso", bRol.getList_id_permisos()[i]);
    			rolDao.insertRolPermiso(mapa);
			}
			
			parametros.put("id_result", bRol.getId());
			
			//Marcar como actualizables los usuarios que tengan el rol
			usuariosDao.updateMarcarActualizadosByRol(bRol.getId());
		}
		
		return parametros;
	}

	@Override
	public void eliminarRol(Long id) {
		
		//Eliminacion de las relaciones antiguas con los permisos
		rolDao.deleteRolPermisos(id);
		
		rolDao.deleteRol(id);
		
		//Marcar como actualizables los usuarios que tengan el rol
		usuariosDao.updateMarcarActualizadosByRol(id);
		
	}

}
