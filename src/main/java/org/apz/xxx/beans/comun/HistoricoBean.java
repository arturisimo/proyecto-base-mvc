package org.apz.xxx.beans.comun;

import java.io.Serializable;
import java.util.Date;

/**
 * COMUN PARA HISTORICO: Los historicos concretos extenderan de esta clase
 * 
 * @author Renfe Viajeros
 * @date 05/10/2015 17:08:17
 */
public class HistoricoBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long 				id;
	private Date				fecha_accion;
	private String				nombre_usuario;
	private Long				id_usuario;
	private Long				id_accion;
	
	//-------------------------------
	//		CONSTRUCTORES
	//-------------------------------
	
	public HistoricoBean() {
		super();
	}

	//-------------------------------
	//		GETTERS AND SETTERS
	//-------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_accion() {
		return fecha_accion;
	}

	public void setFecha_accion(Date fecha_accion) {
		this.fecha_accion = fecha_accion;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_accion() {
		return id_accion;
	}

	public void setId_accion(Long id_accion) {
		this.id_accion = id_accion;
	}

	@Override
	public String toString() {
		return "HistoricoBean [id=" + id + ", fecha_accion=" + fecha_accion
				+ ", nombre_usuario=" + nombre_usuario + ", id_usuario="
				+ id_usuario + ", id_accion=" + id_accion + "]";
	}
	
}



