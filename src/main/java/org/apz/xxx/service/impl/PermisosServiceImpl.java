package org.apz.xxx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.seguridad.PermisoBean;
import org.apz.xxx.dao.seguridad.PermisosDao;
import org.apz.xxx.service.def.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * 
 * Esta clase actua como un servicio (BO) para realizar todas las tareas desde el controller
 * para Adminstracion Usuarios, grupos y roles
 */
@Service
public class PermisosServiceImpl implements PermisosService {	  
	
	protected static Logger logger = Logger.getLogger(PermisosServiceImpl.class);
	
	@Autowired
	PermisosDao permisosDao;

	@Override
	public List<PermisoBean> getListadoPermisos() {
		return permisosDao.getPermisos();
	}
	
	@Override
	public List<PermisoBean> getArbolPermisos(List<PermisoBean> permisos) {
		
		List<PermisoBean> arbol_permisos = new ArrayList<PermisoBean>();
		for (int i = 0; i < permisos.size(); i++) {
			if (permisos.get(i).getPermisoPadre() == null){
				PermisoBean bPermisoRaiz = getPermisoArbolado(permisos.get(i),permisos);
				arbol_permisos.add(bPermisoRaiz);
			}
		}
		
		return arbol_permisos;
	}

	private PermisoBean getPermisoArbolado(PermisoBean bPermisoPadre, List<PermisoBean> permisos) {
		
		List<PermisoBean> arbol_permisos_hijos = new ArrayList<PermisoBean>();
		
		for (int i = 0; i < permisos.size(); i++) {
			if (permisos.get(i).getPermisoPadre() == bPermisoPadre.getId()){
				PermisoBean bPermisoHijo = getPermisoArbolado(permisos.get(i),permisos);
				arbol_permisos_hijos.add(bPermisoHijo);
			}
		}
		
		bPermisoPadre.setList_permisos_hijos(arbol_permisos_hijos);
		
		return bPermisoPadre;
	}


	@Override
	public List<PermisoBean> getPermisosParaDetalle(List<PermisoBean> permisos){
		
		List<PermisoBean> result = new ArrayList<PermisoBean>();
		List<PermisoBean> listaAllPermisos = permisosDao.getPermisos();
		
		HashMap<Long,PermisoBean> mapDetallePermisos =  new HashMap<Long, PermisoBean>();
		Iterator<PermisoBean> itPerm = permisos.iterator();
		while(itPerm.hasNext()){
			PermisoBean bPerm = itPerm.next(); 
			mapDetallePermisos.put(bPerm.getId(),bPerm);
		}
		
		HashMap<Long ,PermisoBean> mapPermisosVisitados = new HashMap<Long,PermisoBean>();
		for (int i=0; i < listaAllPermisos.size() ; i++){
			PermisoBean bPerm 	  		= listaAllPermisos.get(i);
			PermisoBean bPermWithArbol 	= getPermisosDescendientes(mapPermisosVisitados, bPerm,listaAllPermisos);
		}
		
		Iterator<PermisoBean> itPermUsuarios =  permisos.iterator();
		while (itPermUsuarios.hasNext()) {
			PermisoBean permisoBean = (PermisoBean) itPermUsuarios.next();
			Long idPadre = permisoBean.getPermisoPadre();
			if   (idPadre==null  ||  mapDetallePermisos.get(idPadre) == null){
				result.add(mapPermisosVisitados.get(permisoBean.getId()));
			}
		}
		
		return result;
	}
	
	private PermisoBean getPermisosDescendientes(HashMap<Long ,PermisoBean> mapPermisosVisitados,
												PermisoBean bPermisoPadre, List<PermisoBean> permisos){
	
		List<PermisoBean> arbol_permisos_hijos 	= new ArrayList<PermisoBean>();
		
		//Si es Permiso raiz para este usuario
		if (mapPermisosVisitados.get(bPermisoPadre.getId()) == null){
	
		for (int i = 0; i < permisos.size(); i++) {

			if (permisos.get(i).getPermisoPadre() == bPermisoPadre.getId()){
				PermisoBean bPermisoHijo = getPermisoArbolado(permisos.get(i),permisos);
				arbol_permisos_hijos.add(bPermisoHijo);
			}
		}

		bPermisoPadre.setList_permisos_hijos(arbol_permisos_hijos);
		mapPermisosVisitados.put(bPermisoPadre.getId(), bPermisoPadre);
		}
		return bPermisoPadre;
	}

}
