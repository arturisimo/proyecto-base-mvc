package  org.apz.xxx.beans.seguridad;

import java.io.Serializable;
import java.util.List;
 
/**	
 *	Tabla [XXX_SEG_PERMISOS]
 */

public class PermisoBean implements Serializable{

	//-------------------------------
	//		ATRIBUTOS
	//-------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long 				id;
	private String 				nombre;
	private String 				descripcion;
	private Long				permisoPadre;
	private List<PermisoBean>	list_permisos_hijos;
	
	//Atributos para la busqueda
	private Boolean				seleccionado;
	
	//-------------------------------
	//		CONSTRUCTORES
	//-------------------------------
	public PermisoBean() {
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getPermisoPadre() {
		return permisoPadre;
	}
	public void setPermisoPadre(Long permisoPadre) {
		this.permisoPadre = permisoPadre;
	}
	public Boolean getSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	public List<PermisoBean> getList_permisos_hijos() {
		return list_permisos_hijos;
	}
	
	public void setList_permisos_hijos(List<PermisoBean> list_permisos_hijos) {
		this.list_permisos_hijos = list_permisos_hijos;
	}


	@Override
	public String toString() {
		return "PermisoBean [id=" + id + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", permisoPadre="
				+ permisoPadre + ", list_permisos_hijos=" + list_permisos_hijos
				+ ", seleccionado=" + seleccionado
				+ "]";
	}

}