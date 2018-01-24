package  org.apz.xxx.beans.seguridad;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

 
/**	
 *	Tabla [XXX_SEG_USUARIOS]
 */
 
public class UsuarioBean implements Serializable{
	
	protected static Logger logger = Logger.getLogger(UsuarioBean.class);

	//-------------------------------
	//		ATRIBUTOS
	//-------------------------------

	private static final long serialVersionUID = 1L;
	
	private Long 				id;
	
	private String				nombre;
	private String 				login;
	private String 				password;
	private String				email;
	
	private List<RolBean>		roles;
	private List<PermisoBean>	permisos;
	
	//Determina si un usuario se encuentra habilitado (borrado=false) o inhabilitado (borrado=true)
	private Boolean				borrado;
	
	//Atributos para la busqueda e insercion
	private Boolean				alta_busqueda;
	private Boolean				baja_busqueda;
	
	private String[]			list_id_permisos;
	private String[]			list_id_roles;
	
	/** 1:Oculto; 0:Normal. Un usuario oculto no aparecer� en la aplicaci�n por ning�n sitio y tendr� todos los permisos.**/
	private Short 				oculto;
	
	//-------------------------------
	//		CONSTRUCTORES
	//-------------------------------
	
	public UsuarioBean() {
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RolBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RolBean> roles) {
		this.roles = roles;
	}
	

	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
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
	
	public String[] getList_id_permisos() {
		return list_id_permisos;
	}

	public void setList_id_permisos(String[] list_id_permisos) {
		this.list_id_permisos = list_id_permisos;
	}

	public String[] getList_id_roles() {
		return list_id_roles;
	}

	public void setList_id_roles(String[] list_id_roles) {
		this.list_id_roles = list_id_roles;
	}

	public List<PermisoBean> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermisoBean> permisos) {
		this.permisos = permisos;
	}

	public Short getOculto() {
		return oculto;
	}

	public void setOculto(Short oculto) {
		this.oculto = oculto;
	}


}