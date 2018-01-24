package org.apz.xxx.beans.comun;

import java.io.Serializable;

 
/**	
 *	Accion global - Tabla [XXX_GLOBAL_ACCIONES]
 */
public class GlobalAccionBean implements Serializable{

	//-------------------------------
	//		ATRIBUTOS
	//-------------------------------
	
	private static final long serialVersionUID = 1L;
	
	private Long 				id;
	private String				descripcion;
	
	
	//-------------------------------
	//		CONSTRUCTORES
	//-------------------------------
	
	public GlobalAccionBean() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "GlobalAccionBean [id=" + id + ", descripcion=" + descripcion + "]";
	}

	
}