package org.apz.xxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.RolBean;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.dao.seguridad.RolDao;
import org.apz.xxx.dao.seguridad.UsuariosDao;
import org.apz.xxx.service.def.AdminService;
import org.apz.xxx.util.ConstantesGenerales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService, ConstantesGenerales {
	
	@Autowired
	UsuariosDao usuariosDao;
	
	@Autowired
	RolDao rolDao;
	
	
	@Override
	public List<?> getListado(FiltroListado filtro) {
		
		List<?> listado;
		
		switch (filtro.getModulo()) {
			case usuarios :
				listado = usuariosDao.getUsuarios(filtro);
				break;
			case roles :
				listado = rolDao.getRoles(filtro);
				break;
			default:
				listado = new ArrayList<>();
				break;
		}
		
		
		return listado;
	}


	@Override
	public UsuarioBean getUsuarioDetalle(FiltroListado filtro) {
		return usuariosDao.getUsuarioById(filtro.getId());
	}


	@Override
	public RolBean getRolDetalle(FiltroListado filtro) {
		return rolDao.getRolById(filtro.getId());
	}
	
	@Override
	public UsuarioBean getUsuarioByLogin(String login) {
		return usuariosDao.getUsuarioByLogin(login);
	}
	
}