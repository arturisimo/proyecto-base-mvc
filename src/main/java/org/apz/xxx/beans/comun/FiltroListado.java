package org.apz.xxx.beans.comun;

import java.io.Serializable;

import org.apz.xxx.util.ConstantesGenerales;

public class FiltroListado implements Serializable, ConstantesGenerales {
	
	private static final long serialVersionUID = -4233056324659480894L;
	
	private Long id;
	private Modulo modulo;
	private String nombre;
	private String login;

	public FiltroListado(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	

}
