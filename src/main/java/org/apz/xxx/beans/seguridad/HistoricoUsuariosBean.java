package org.apz.xxx.beans.seguridad;

import java.io.Serializable;

import org.apz.xxx.beans.comun.GlobalAccionBean;
import org.apz.xxx.beans.comun.HistoricoBean;


/**	
 *	Historico de ficheros - Tabla [XXX_HIST_USUARIOS]
 */

public class HistoricoUsuariosBean extends HistoricoBean implements Serializable{
	
	//-------------------------------
	//		ATRIBUTOS
	//-------------------------------
	
	private static final long serialVersionUID = 1L;
	
	private String				nombre_usuario_accion;	
	private Integer				id_global_accion;
	private Long	            id_usuario_accion;
	
	private UsuarioBean 		usuario;
	private UsuarioBean 		usuario_accion;
	private GlobalAccionBean 	accion;
	
	//-------------------------------
	//		CONSTRUCTORES
	//-------------------------------
	
	public HistoricoUsuariosBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	//-------------------------------
	//		GETTERS AND SETTERS
	//-------------------------------

	public String getNombre_usuario_accion() {
		return nombre_usuario_accion;
	}

	public void setNombre_usuario_accion(String nombre_usuario_accion) {
		this.nombre_usuario_accion = nombre_usuario_accion;
	}
	
	public Integer getId_global_accion() {
		return id_global_accion;
	}

	public void setId_global_accion(Integer id_global_accion) {
		this.id_global_accion = id_global_accion;
	}

	public Long getId_usuario_accion() {
		return id_usuario_accion;
	}

	public void setId_usuario_accion(Long id_usuario_accion) {
		this.id_usuario_accion = id_usuario_accion;
	}

	
	
	public GlobalAccionBean getAccion() {
		return accion;
	}

	public void setAccion(GlobalAccionBean accion) {
		this.accion = accion;
	}

	public UsuarioBean getUsuario_accion() {
		return usuario_accion;
	}

	public void setUsuario_accion(UsuarioBean usuario_accion) {
		this.usuario_accion = usuario_accion;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "HistoricoUsuariosBean [id_usuario_accion=" + id_usuario_accion  
				+ ", nombre_usuario_accion=" + nombre_usuario_accion 
				+  ", id_global_accion=" + id_global_accion
				+ "]";
	}
	
}
