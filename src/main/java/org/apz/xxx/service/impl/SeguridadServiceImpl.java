package org.apz.xxx.service.impl;


import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.dao.seguridad.UsuariosDao;
import org.apz.xxx.service.def.SeguridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SeguridadServiceImpl implements SeguridadService {

	protected static Logger logger = Logger.getLogger(SeguridadServiceImpl.class);
	
	@Autowired
	UsuariosDao dao_usuario;
	
	public SeguridadServiceImpl() {
		super();
	}

	@Override
	public UsuarioBean getUsuarioById(Long id) {
		return dao_usuario.getUsuarioById(id);
	}
	
	@Override
	public UsuarioBean getUsuarioByLogin(String name) {
		return dao_usuario.getUsuarioByLogin(name);
	}

	@Override
	public HashMap<Long, String> obtenerMapaPermisos(UsuarioBean bUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
