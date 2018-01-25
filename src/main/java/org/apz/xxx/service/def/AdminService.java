package org.apz.xxx.service.def;

import java.util.List;

import org.apz.xxx.beans.comun.FiltroListado;
import org.apz.xxx.beans.seguridad.RolBean;
import org.apz.xxx.beans.seguridad.UsuarioBean;

public interface AdminService {

	List<?> getListado(FiltroListado filtro);

	UsuarioBean getUsuarioDetalle(FiltroListado filtro);

	RolBean getRolDetalle(FiltroListado filtro);

	UsuarioBean getUsuarioByLogin(String login);

}
