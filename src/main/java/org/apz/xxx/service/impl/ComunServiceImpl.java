package org.apz.xxx.service.impl;


import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apz.xxx.dao.ComunDao;
import org.apz.xxx.service.def.ComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ComunServiceImpl implements ComunService {

	protected static Logger logger = Logger.getLogger(ComunServiceImpl.class);
	
	@Autowired
	ComunDao comunDao;
	
	public ComunServiceImpl() {
		super();
	}

	@Override
	public List<HashMap<String,Object>> getParametrosDatabase() {
		return comunDao.getParametrosDatabase();
	}

	@Override
	public String getUsuarioDatabase() {
		return comunDao.getUsuarioDatabase();
	}

	@Override
	public List<HashMap<String, Object>> getPrivilegiosUsuario() {
		return comunDao.getPrivilegiosUsuario();
	}

	
}
