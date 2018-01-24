package org.apz.xxx.service.def;

import java.util.List;

import org.apz.xxx.beans.comun.FiltroListado;

public interface AdminService {

	List<?> getListado(FiltroListado filtro);

}
