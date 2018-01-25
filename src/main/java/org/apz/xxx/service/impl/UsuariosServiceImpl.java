package org.apz.xxx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.HistoricoUsuariosBean;
import org.apz.xxx.beans.seguridad.PermisoBean;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.dao.seguridad.HistoricoUsuariosDao;
import org.apz.xxx.dao.seguridad.RolDao;
import org.apz.xxx.dao.seguridad.UsuariosDao;
import org.apz.xxx.service.def.UsuariosService;
import org.apz.xxx.util.ConstantesGenerales;
import org.apz.xxx.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService,ConstantesGenerales {	  
	
	protected static Logger logger = Logger.getLogger(UsuariosServiceImpl.class);
	
	@Autowired
	UsuariosDao usuariosDao;
	
	@Autowired
	RolDao rolDao;
	
	@Autowired
	HistoricoUsuariosDao  histUsuDao;                           
	
	@Override
	public List<UsuarioBean> getListadoUsuarios(FiltroListado filtro) {
		return usuariosDao.getUsuarios(filtro);
	}

	@Override
	public UsuarioBean getUsuarioById(Long id) {
		return (UsuarioBean) usuariosDao.getUsuarioById(id);
	}


	@Override
	public Map<String, Object> getDetalleUsuario(Long id) {
		
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		UsuarioBean usuarioBean;
		
		usuarioBean = usuariosDao.getUsuarioById(id);
		
		List<PermisoBean> arbolPermisos = new ArrayList<PermisoBean>();//serv_perm.getPermisosParaDetalle(usuarioBean.getPermisos());
		  
	    Map<Long,Long> nodosRaices = new HashMap<Long,Long>();
	    Iterator<PermisoBean> it = arbolPermisos.iterator();
	    while(it.hasNext()){
		    PermisoBean b = it.next();
		    nodosRaices.put(b.getId(), b.getId());
	    }  

	    parametros.put("bUsu",usuarioBean);
	   
	    parametros.put("nodosRaices", nodosRaices);
	    parametros.put("arbolPermisos", arbolPermisos);
		
		return parametros;
	}

	/*
	@Override
	public HashMap<String, Object> getEdicionUsuario(Long id) {
		
		UsuarioBean bUsu = usuariosDao.getUsuarioById(id);
		
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		RolBean bRol = new RolBean();
		List<RolBean> listaRoles = rolDao.getAllRoles(bRol);
		
		//Crear lista de roles seleccionados para la busqueda
		Boolean encontradoRol;
		for (int i = 0; i < listaRoles.size(); i++) {
			encontradoRol = false;
			int cont = 0;
			if (bUsu.getRoles() != null) {
				while (cont<bUsu.getRoles().size() && !encontradoRol){
					if(listaRoles.get(i).getId().equals(bUsu.getRoles().get(cont).getId())){
						listaRoles.get(i).setSeleccionado(true);
					}
					cont++;
				}
			}
		}
		
		parametros.put("bUsu", bUsu);
		parametros.put("listaRoles", listaRoles);

		return parametros;
	}*/

	@Override
	public Map<String, Object> guardarUsuario(Map<String, Object> parametros) {
		
		String nombre = (String) parametros.get("nombre");
		String login = (String) parametros.get("login");
		String email = (String) parametros.get("email");
		String password = (String) parametros.get("password");
		
		UsuarioBean usuario = new UsuarioBean();
		
		usuario.setLogin(login);
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		
		usuario.setPassword(Utilidades.convertToMD5(password));
		usuario.setList_id_roles((String[])parametros.get("arrayRoles"));
		
		long id_result = -1;
		
		int numUsuariosLogin = usuariosDao.getNumUsuariosWithLogin(usuario);
		
		if (numUsuariosLogin > 0) {
			parametros.put("error",1);
			parametros.put("mensajeError","Ya existe un usuario con el mismo login.");
		} else {
			id_result = usuariosDao.insertUsuario(usuario);
			
			//Se crea el historico de la creacion/modificacion
			Long idUser = (Long) parametros.get("id_usuario");
			String nombreUser = (String) parametros.get("nombre_usuario");
			  
			HistoricoUsuariosBean bHusuario = new HistoricoUsuariosBean();
			bHusuario.setId_usuario(idUser);
			bHusuario.setNombre_usuario(usuario.getLogin());
			bHusuario.setId_usuario_accion(idUser);
		    bHusuario.setNombre_usuario_accion(nombreUser);
		    
			bHusuario.setId_accion(new Long(ConstantesGenerales.GLOBAL_ACCION_CREAR));
						  
			histUsuDao.insertHistoricoUsuarios(bHusuario);
			
			parametros.put("bUsu", usuario);
			
			if (id_result != -1){
				HashMap<String, Object> mapa = new HashMap<String, Object>();
	
				for (int i = 0; i < usuario.getList_id_roles().length; i++) {
	    			mapa.put("idusuario", usuario.getId());
	            	mapa.put("idrol", usuario.getList_id_roles()[i]);
	    			usuariosDao.insertUsuarioRol(mapa);
				}
				
				id_result = usuario.getId();
				
			} else {
				parametros.put("error", 2);
				parametros.put("mensajeError","El usuario no se ha podido modificar.");
			}
		} 
		
		if (id_result == -1) {
			/*
			//Crear lista de roles seleccionados para la busqueda
			RolBean bRol = new RolBean();
			List<RolBean> listaRoles = rolDao.getRoles(bRol);
			Boolean encontradoRol;
			for (int i = 0; i < listaRoles.size(); i++) {
				encontradoRol = false;
				int cont = 0;
				if (usuario.getList_id_roles() != null) {
					while (cont<usuario.getList_id_roles().length && !encontradoRol){
						if(listaRoles.get(i).getId().equals(Long.parseLong(usuario.getList_id_roles()[cont]))){
							listaRoles.get(i).setSeleccionado(true);
						}
						cont++;
					}
				}
			}
			
			parametros.put("bUsu",usuario);
			parametros.put("listaRoles", listaRoles);
		*/
		}
		
		parametros.put("id_result", id_result);
		
		return parametros;
	}


	@Override
	public void eliminarUsuario(Map<String, Object> parametros) {
		//Eliminacion de las relaciones con los roles y grupos
		usuariosDao.deleteUsuarioRoles((Long) parametros.get("id"));
		
		UsuarioBean bUsu = usuariosDao.getUsuarioById((Long) parametros.get("id"));
		
		//Eliminacion del usuario
		usuariosDao.deleteUsuario((Long) parametros.get("id"));

		//Se crea el historico de la creacion/modificacion
		Long idUser = (Long) parametros.get("id_usuario");
		String nombreUser = (String) parametros.get("nombre_usuario");
		  
		HistoricoUsuariosBean bHusuario = new HistoricoUsuariosBean();
		bHusuario.setId_usuario(bUsu.getId());
		bHusuario.setNombre_usuario(bUsu.getLogin());
		bHusuario.setId_usuario_accion(idUser);
	    bHusuario.setNombre_usuario_accion(nombreUser);
	    
		bHusuario.setId_accion(new Long(ConstantesGenerales.GLOBAL_ACCION_ELIMINAR));
					  
		histUsuDao.insertHistoricoUsuarios(bHusuario);
		
	}

	@Override
	public Map<String, Object> modificarUsuario(Map<String, Object> parametros) {
		String idUsuario = (String) parametros.get("id");
		String nombre = (String) parametros.get("nombre");
		String login = (String) parametros.get("login");
		String email = (String) parametros.get("email");		 
		
		Integer tipo_usuario = Integer.parseInt((String) parametros.get("tipo_usuario"));
		
		Long id_coordinador = null;
		Long id_gerencia_mercado = null;
		
		if (parametros.get("id_coordinador") != null){
			id_coordinador = Long.parseLong((String) parametros.get("id_coordinador"));
		}
		if (parametros.get("id_gerencia_mercado") != null){
			id_gerencia_mercado	= Long.parseLong((String) parametros.get("id_gerencia_mercado"));
		}
		
		UsuarioBean bUsu = usuariosDao.getUsuarioById(Long.parseLong(idUsuario));
		String loginPrevio = bUsu.getLogin();
		
		bUsu.setNombre(nombre);
		bUsu.setLogin(login);
		bUsu.setEmail(email);
		
		bUsu.setList_id_roles((String[])parametros.get("arrayRoles"));
		
		int numUsuariosLogin = usuariosDao.getNumUsuariosWithLogin(bUsu);
		long id_result = -1;
		
		if ((!loginPrevio.equals(login) && numUsuariosLogin > 0) || (loginPrevio.equals(login) && numUsuariosLogin > 1)){
			
			parametros.put("error",1);
			parametros.put("mensajeError","Ya existe un usuario con el mismo login.");
			
		} else {
				
			String change = (String) parametros.get("change");
			
			Boolean cambioCorrecto = true;
			
			if (change!=null && change.equals("S")){
				String password = (String) parametros.get("password");
				String newpassword = (String) parametros.get("newpassword");
				String repassword = (String) parametros.get("repassword");
				
				if (password!=null && Utilidades.convertToMD5(password).equals(bUsu.getPassword())){
					if (newpassword!=null && !newpassword.equals("") && newpassword.equals(repassword)){
						bUsu.setPassword(Utilidades.convertToMD5(newpassword));
					}else{
						cambioCorrecto = false;
						parametros.put("mensajeError","Las nuevas contraseñas no coinciden.");
						parametros.put("error",3);
					}
				}else{
					cambioCorrecto = false;
					parametros.put("mensajeError","La contraseña no es correcta.");
					parametros.put("error",4);
				}
			}
				
			if (cambioCorrecto){
			
				
				id_result = usuariosDao.updateUsuario(bUsu);
				
				if (id_result != -1){
				
//					Eliminacion de las relaciones antiguas con los grupos y roles
		    		usuariosDao.deleteUsuarioRoles(bUsu.getId());
		    		
		    		HashMap<String, Object> mapa = new HashMap<String, Object>();
		
					for (int i = 0; i < bUsu.getList_id_roles().length; i++) {
		    			mapa.put("idusuario", bUsu.getId());
		            	mapa.put("idrol", bUsu.getList_id_roles()[i]);
		    			usuariosDao.insertUsuarioRol(mapa);
					}
					
					id_result = bUsu.getId();
					
				} else {
					parametros.put("error",2);
					parametros.put("mensajeError","El usuario no se ha podido modificar.");
				}

				//Se crea el historico de la creacion/modificacion
				Long idUser = (Long) parametros.get("id_usuario");
				String nombreUser = (String) parametros.get("nombre_usuario");
				  
				HistoricoUsuariosBean bHusuario = new HistoricoUsuariosBean();
				bHusuario.setId_usuario(bUsu.getId());
				bHusuario.setNombre_usuario(bUsu.getLogin());
				bHusuario.setId_usuario_accion(idUser);
			    bHusuario.setNombre_usuario_accion(nombreUser);
			    
				bHusuario.setId_accion(new Long(ConstantesGenerales.GLOBAL_ACCION_MODIFICAR));
							  
				histUsuDao.insertHistoricoUsuarios(bHusuario);
						
			} 
		}
		
		if (id_result == -1) {
			/*
			//Crear lista de roles seleccionados para la busqueda
			RolBean bRol = new RolBean();
			List<RolBean> listaRoles = rolDao.getRoles(bRol);
			Boolean encontradoRol;
			for (int i = 0; i < listaRoles.size(); i++) {
				encontradoRol = false;
				int cont = 0;
				if (bUsu.getList_id_roles() != null) {
					while (cont<bUsu.getList_id_roles().length && !encontradoRol){
						if(listaRoles.get(i).getId().equals(Long.parseLong(bUsu.getList_id_roles()[cont]))){
							listaRoles.get(i).setSeleccionado(true);
						}
						cont++;
					}
				}
			}
			parametros.put("bUsu",bUsu);
			parametros.put("listaRoles", listaRoles);
			*/
		}
		
		parametros.put("id_result",id_result);
		
		return parametros;
	}


	public Map<String, Object> historicosUsuario(Map<String, Object> parametros) {
		
		HistoricoUsuariosBean bHUsuario = new HistoricoUsuariosBean();
		
		List<HistoricoUsuariosBean> list_historicos = histUsuDao
				.getAllHistoricoUsuarios(bHUsuario);
		
		parametros.put("list_historicos_usuario", list_historicos);
		
		return parametros;
	}





	
	

	
	
}
