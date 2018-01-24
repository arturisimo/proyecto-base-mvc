<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%%><%-- TAGLIBS --%>
<%%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%
%><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%><%
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%
%>

<script>
	$(document).ready(function() {
		$( "#tabs" ).tabs({ active: 0 });
	});
</script>

<div id="principal" class="mt20 col-md-12 no-movil-padding">

	<div class="row no-movil-padding">
		
		<div class="col-md-12 no-movil-padding">
			
			<div id="tabs" class="col-md-offset-2 col-md-8" style="text-align:center;">
			  
			  <ul class="ul_pestanas">
			    <li><a href="#tabs-1">Información general</a></li>
			    <li><a href="#tabs-3">Roles</a></li>
			    <li><a href="#tabs-4">Permisos</a></li>
			  </ul>
			  
			  <!-- Info general -->
			  <div id="tabs-1" class="div_detalle_pestana">
			  	<div class="tablaAdminDetalle">
					<table style="position: relative;">				
						<tbody>
							<tr>
								<td class="td_th">Nombre</td>
								<td>
									<div>
										${bUsu.nombre}
									</div>
								</td>
							</tr>
							<tr>	
								<td class="td_th">Login</td>
								<td>
									<div>
										${bUsu.login}
									</div>
								</td>
							</tr>
							<tr>	
								<td class="td_th">Correo electrónico</td>
								<td>
									<div>
										${bUsu.email}
									</div>
								</td>
							</tr>
							
						</tbody>
					</table>
				</div>
			  </div>
			  
			  <!-- Roles -->
			  <div id="tabs-3" class="div_detalle_pestana">
			  	<c:choose>
					<c:when test="${empty bUsu.roles}">
						<span class="label detail-label-warning label-warning">Sin roles</span>
					</c:when>
					<c:otherwise>
						<ul class="listAdminDetail">
							<c:forEach items="${bUsu.roles}" var="rol">
								<li>
									<a href="<c:url value='/administracion/roles/detalle/${rol.id}/'/>">${rol.nombre}</a>
								</li>
							</c:forEach>
						</ul>
					</c:otherwise>
				</c:choose>
			  </div>
			  
			  <!-- Permisos -->
			  <div id="tabs-4" class="div_detalle_pestana">
			  	<c:choose>
					<c:when test="${empty arbolPermisos	}">
						<span class="label detail-label-warning label-warning">Sin permisos</span>
					</c:when>
					<c:otherwise>
						<table class="tree" style="text-align:left;">
							<c:forEach items="${arbolPermisos}" var="permiso">
								
								<tr class="tree-tr-detalle treegrid-${permiso.id} <c:if test="${(not empty permiso.permisoPadre) && (not empty nodosRaices[permiso.permisoPadre])}">treegrid-parent-${permiso.permisoPadre}</c:if>">
									<td>
										<div class="tree-checkbox">
											${permiso.nombre}
										</div>
									</td>
								</tr>
								<c:if test="${not empty permiso.list_permisos_hijos}">
									<c:forEach items="${permiso.list_permisos_hijos}" var="permHijo">
										<c:set var="permiso" value="${permHijo}" scope="request"/>
										<jsp:include page="permisos_hijos_detalle.jsp"/>
									</c:forEach>
								</c:if>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			  </div>
			  
			</div>
			
		</div>
	</div>
	
	<div class="col-md-12 form-group no-movil-padding" style="margin-top:15px; text-align: center;">
		<div class="margeninferior">
	
			<a href="<c:url value='/administracion/usuarios/'/>" title="Volver al listado" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" >Volver al listado</a>
			<a href="<c:url value='/administracion/usuarios/editar/${bUsu.id}/'/>" title="Editar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" >Editar</a>
			<a  
				title="Eliminar" 
				class="delUsuario titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active cancelar"
				id="delete_${bUsu.id}"
				
			 	href="<c:url value="/administracion/usuarios/eliminar/${bUsu.id}/"/>">
			 	Eliminar</a>
			
		</div>
	</div>
	
	<!-- ..................................... -->
	<!-- Modal Confirmar eliminar Usuario 	   -->
	<!-- ..................................... -->
	<div class="modal" id="myModalConfirmDeleteUsuario" 
	  			tabindex="-1" role="dialog" 
	  			aria-labelledby="myModalConfirmDeleteUsuario" 
	  			aria-hidden="true">
		<form
	  		method="post"
	  		id="fDelete"
	  		action="<c:url value='/administracion/usuarios/eliminar/'/>"
	  	>
		  <input type="hidden" id="UsuarioToDelete"/>
		  	
		  <div class="modal-dialog">
		    <div class="modal-content">
		      
			      <div class="modal-header">
			       	 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			       	 <h4 class="modal-title" id="myModalConfirmDeleteInciLabel">¿Eliminar usuario?</h4>
			      </div>
		      
			      <div class="modal-body"> 
						
						<label>${bUsu.nombre}</label>
						
						<div class="row">
							<%-- pie botones --%>
							<div id="divEditarBotones1" class="modal-footer" style="border:none">
			        			<button type="button" title="Cancelar" class="titulosbotones3 btn btn-default bread-active colortext btn btn-default btn-lg active cancelar" id="btnEditUsuario" data-dismiss="modal">Cancelar</button>
			        			<button type="submit" title="Eliminar el usuario" id="btnAceptarEliminarUsuario"  data-dismiss="modal"   class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active cancelar">Eliminar</button>
			      			
			      			
			      			</div>
		
				      	</div>
		    	  </div>
		    </div>
		  </div> 
	  
	 	 </form>
 	 </div>
 	 

	
	

</div>