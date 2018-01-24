package  org.apz.xxx.beans.seguridad;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
 
/**	
 *	Tabla [XXX_SEG_ROLES]
 */

public class RolBean implements Serializable{

	//-------------------------------
	//		ATRIBUTOS
	//-------------------------------
	
	private static final long serialVersionUID = 1L;
	
	private Long 				id;
	private String 				nombre;
	private String 				descripcion;
	private Short				tipo;  			//1:Estático; 0:Modificable
	
	private List<PermisoBean>	permisos;
	private Boolean				borrado;
	
	//Atributos para la busqueda e insercion
	private Boolean				seleccionado;
	private String[]			list_id_permisos;
	private Boolean				alta_busqueda;
	private Boolean				baja_busqueda;
	
	//-------------------------------
	//		CONSTRUCTORES
	//-------------------------------
	
	public RolBean() {
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

	public List<PermisoBean> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermisoBean> permisos) {
		this.permisos = permisos;
	}
	
	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}
	
	public String[] getList_id_permisos() {
		return list_id_permisos;
	}

	public void setList_id_permisos(String[] list_id_permisos) {
		this.list_id_permisos = list_id_permisos;
	}

	public Boolean getAlta_busqueda() {
		return alta_busqueda;
	}

	public void setAlta_busqueda(Boolean alta_busqueda) {
		this.alta_busqueda = alta_busqueda;
	}

	public Boolean getBaja_busqueda() {
		return baja_busqueda;
	}

	public void setBaja_busqueda(Boolean baja_busqueda) {
		this.baja_busqueda = baja_busqueda;
	}
	
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public Short getTipo() {
		return tipo;
	}

	public void setTipo(Short tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "RolBean [id=" + id + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", tipo=" + tipo + ", list_permisos="
				+ permisos + ", borrado=" + borrado + ", seleccionado="
				+ seleccionado + ", list_id_permisos="
				+ Arrays.toString(list_id_permisos) + ", alta_busqueda="
				+ alta_busqueda + ", baja_busqueda=" + baja_busqueda + "]";
	}
	
}