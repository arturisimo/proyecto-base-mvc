<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="principal" class="mt20 col-md-12">

<c:set var="actionForm"><c:url value="/administracion/roles/busqueda"/></c:set>

<form:form cssClass="mt15 mb10 form-horizontal" modelAttribute="filtroListado" method="POST" action="${actionForm}">
		<div class="borde margin-top" > 
			<div class="subtitulofiltros fondosubtitulos" style="float:left; display:block;">BÚSQUEDA DE ROLES</div>
	
		    <div class="container-fluid ">
			 	
				<div class="row">
					<div id="bloqFiltros" class="row col-md-12"style="padding-top: 8px !important;line-height: 14px;padding-bottom: 8px !important;">
						<div class="col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6 col-xs-12">
							<div class="has-feedback">
						        <input name="nombre" type="text" class="form-control" id="file_nombre" value="${nombre}">
						        <span>
									<span class="lupita"> 
									<img src='<c:url value="/img/lupita.png"/>'/></span>
								</span>
						     </div>
						</div>
					</div>
				</div>
				
			</div>
			
		</div>
		
		<div style="width:100%;" class="filtroscenter">
			<button title="Buscar" type="submit" id="buscar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" style="margin:20px 0px; text-align:center; float:center;">Buscar</button>
			<a title="Nuevo rol" href="<c:url value='/administracion/roles/alta/'/>" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" style="margin:20px 0px; text-align:center; float:center;" >Nuevo Rol</a>
		</div>

	</form:form>
	
	<c:choose>
		<c:when test="${not empty listaRoles}">
			<div class="tablaAdmin">
				<table>
					<thead>
						<tr class="alturatablas">
							<th>NOMBRE</th>
							<th class="no-movil">DESCRIPCIÓN</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaRoles}" var="rol">
								<tr class="alturatablas">
									<td class="cortar100" id="name_${rol.id}">${rol.nombre}</td>
									<td class="no-movil">${rol.descripcion}</td>
									<td>
				  						<div style="text-align: center; margin: auto;">
						  					<a  id="btnDetalle"
												title="Detalle"
											 	href="<c:url value="/administracion/roles/detalle/${rol.id}/"/>">
											 	<img  src='<c:url value="/img/detalle.png"/>'/></a>
											
											<a  id="btnModificar"
												title="Modificar"
											 	href="<c:url value="/administracion/roles/editar/${rol.id}/"/>">
											 	<img id="imagen1" src='<c:url value="/img/modificar_ok.png"/>'/></a>		
											
											<c:if test="${rol.tipo == 0}">
												<a  
													title="Eliminar" 
													class="delRol"
													id="delete_${rol.id}"
													
												 	href="<c:url value="/administracion/roles/eliminar/${rol.id}/"/>">
												 	<img src='<c:url value="/img/eliminar.png"/>'/></a>
											 </c:if>
										</div>
					  				</td>
					  			</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning alert-dismissable" style="text-align: center;">
			  No se han encontrado roles.
			</div>
		</c:otherwise>
	</c:choose>
	
	
	<!-- ..................................... -->
	<!-- Modal Confirmar eliminar Roles 	   -->
	<!-- ..................................... -->
	<div class="modal" id="myModalConfirmDeleteRol" 
	  			tabindex="-1" role="dialog" 
	  			aria-labelledby="myModalConfirmDeleteRol" 
	  			aria-hidden="true">
		<form
	  		method="post"
	  		id="fDelete"
	  		action="<c:url value='/administracion/roles/eliminar/'/>"
	  	>
		  <input type="hidden" id="RolToDelete"/>
		  	
		  <div class="modal-dialog">
		    <div class="modal-content">
		      
			      <div class="modal-header">
			       	 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			       	 <h4 class="modal-title" id="myModalConfirmDeleteInciLabel">¿Eliminar rol?</h4>
			      </div>
		      
			      <div class="modal-body"> 
					
					<label id="modalNameRol"></label>
						
					<div class="row">
									
						<%-- pie botones --%>
						<div id="divEditarBotones1" class="modal-footer" style="border:none">
		        			<button type="button" title="Cancelar" class="titulosbotones3 btn btn-default bread-active colortext btn btn-default btn-lg active cancelar" id="btnEditUsuario" data-dismiss="modal">Cancelar</button>
		        			<button type="submit" title="Eliminar el rol" id="btnAceptarEliminarRol"  data-dismiss="modal"   class="titulosbotonesDelete btn btn-default bread-active colortext btn btn-default btn-lg active cancelar">Eliminar</button>
		      			</div>
	
			      	</div>
		      </div>
		    </div>
		  </div> 
	  
	 	 </form>
 	 </div>
	
</div>