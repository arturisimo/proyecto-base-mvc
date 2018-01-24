package org.apz.xxx.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apz.xxx.beans.seguridad.UsuarioBean;
import org.apz.xxx.dao.seguridad.UsuariosDao;
import org.apz.xxx.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService  implements UserDetailsService {

	protected static Logger logger = Logger.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UsuariosDao daoUsuarios;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    
		UsuarioBean bUsuario = null;
		try {
			bUsuario = daoUsuarios.getUsuarioByLogin(username);
		} catch (Exception e) {
			System.out.println("-------------- ERROR");
			e.printStackTrace();
		}
	    
		if (bUsuario == null) {
	    	System.out.println("busuario no encontrado");
	        throw new UsernameNotFoundException("Invalid username/password.");
	    }
	     
	    Collection<? extends GrantedAuthority> authorities =  new ArrayList<GrantedAuthority>();
		try {
			if (bUsuario.getPermisos() != null) {
				
				String[] listaPermisos = new String[bUsuario.getPermisos().size()];
				
				for (int i = 0; i < bUsuario.getPermisos().size(); i++) {
					listaPermisos[i] = "PERM_" + bUsuario.getPermisos().get(i).getId(); 
				}
				authorities = AuthorityUtils.createAuthorityList(listaPermisos);
			}
			logger.debug("[authorities: " + authorities);
			
		} catch (Exception e) {
			logger.error(Utilidades.getStackTrace(e));
		}
	
	    return new User(bUsuario.getLogin(), bUsuario.getPassword(), true, true, true, true, authorities);
	}
}