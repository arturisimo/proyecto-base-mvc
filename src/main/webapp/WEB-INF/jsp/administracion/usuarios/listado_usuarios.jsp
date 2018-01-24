	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
%><%-- TAGLIBS --%><% 
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%>
	

	<script type='text/javascript'>
		
		function verHistoricos() 
		{
			alert("/administracion/usuarios/historicos/");
			var url = "<c:url value='/administracion/usuarios/historicos/'/>";
		    window.location.href = url;
		}

	</script>	
	
	
<div id="principal" class="mt20 col-md-12">
	
	<form id="filtro" action="<c:url value='/administracion/usuarios/'/>" method="post">
		<input type="hidden" name="destino_seleccionado" id="destino_seleccionado" value="${destino}"/>
		<input type="hidden" name="ut_seleccionado" id="ut_seleccionado" value="${ut}"/>
		<input type="hidden" name="coche_seleccionado" id="coche_seleccionado" value="${coche}"/>

		<div class="borde margin-top" > 
			<div class="subtitulofiltros fondosubtitulos" style="float:left; display:block;">BÚSQUEDA DE USUARIOS</div>
		    <div class="container-fluid ">
			 	
				<div class="row">
					<div id="bloqFiltros" class="row col-md-12"style="padding-top: 8px !important; padding-bottom: 8px;">

							<div class="row form-group col-md-12 control-label" style="margin-bottom: 0px">
			
								<div class="dir-filtros">
									<!-- Nombre -->
									<label for="nombre"	class="col-md-offset-1 col-md-1 control-label texto-label">Nombre</label>
									<div class="col-md-2" style="padding: 0px;">
										<div class="input-group">
											<input name="nombre"  type="text" id="nombre" class="form-control input-round" value="${nombre}">
										</div>
										<!-- /input-group -->
									</div>
									
									<!-- Login -->
									<label for="login"	class="col-md-1 control-label texto-label">Login</label>
									<div class="col-md-2" style="padding: 0px;">
										<div class="input-group">
											 <input name="login"  type="text" id="login" class="form-control input-round" value="${login}">
										</div>
										<!-- /input-group -->
									</div>
									
								</div>
							
							</div>
						</div>
				</div>
				
			</div>
		</div>
		
		<div style="width:100%;" class="filtroscenter">
			<button title="Buscar" type="submit" id="buscar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" style="margin:20px 0px; text-align:center; float:center;">Buscar</button>
			
			<a title="Nuevo usuario" href="<c:url value='/administracion/usuarios/alta/'/>" 
				class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" 
				style="margin:20px 0px; text-align:center; float:center;" >
				Nuevo Usuario</a>
			
<!-- 			<a title="Históricos"  -->
<!-- 				id="historicos"  -->
<%-- 				href="<c:url value='/administracion/usuarios/historicos/'/>"  --%>
<!-- 				class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active"  -->
<!-- 				style="margin:20px 0px; text-align:center; float:center;">Ver históricos</a> -->
				<!--  onclick="verHistoricos()" -->
		</div>
	
	</form>
	
	<c:choose>
		<c:when test="${not empty listaUsuarios}">
			<div  class="tablaAdmin">
				<table>
					<thead>
						<tr class="alturatablas">
							<th width="30%">NOMBRE</th>
							<th width="20%"class="no-movil">LOGIN</th>
							<th width="30%"class="no-movil">EMAIL</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaUsuarios}" var="usuario">
								<tr class="alturatablas">
									<td width="30%" id="name_${usuario.id}">${usuario.nombre}</td>
									<td width="20%" class="no-movil">${usuario.login}</td>
									<td width="30%" class="no-movil">${usuario.email}</td>
									
									<td width="20%">
				  						<div  style="text-align: center; margin: auto;">
				  						
				  							<c:choose>
					  								<c:when test="${usuario.borrado eq false}">
					  								<a  id="btnDetalle"
														title="Detalle"
											 			href="<c:url value="/administracion/usuarios/detalle/${usuario.id}/"/>">
											 			<img  src='<c:url value="/img/detalle.png"/>'/></a>
											
															<a  id="btnModificar"
																title="Modificar"
															 	href="<c:url value="/administracion/usuarios/editar/${usuario.id}/"/>">
															 	<img id="imagen1" src='<c:url value="/img/modificar_ok.png"/>'/></a>		
															
															<a  
																title="Eliminar" 
																class="delUsuario"
																id="delete_${usuario.id}"
															 	href="<c:url value="/administracion/usuarios/eliminar/${usuarios.id}/"/>">
															 	<img src='<c:url value="/img/eliminar.png"/>'/></a>
					  								</c:when>
				  						
							  						<c:otherwise>
							  							Eliminado
							  						</c:otherwise>
						 					</c:choose>
				  						
						  					
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
			  No se han encontrado usuarios.
			</div>
		</c:otherwise>
	</c:choose>
	
	
	<!-- ..................................... -->
	<!-- Modal Confirmar eliminar Usuarios 	   -->
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
					
					<label id="modalNameUsuario"></label>
						
					<div class="row">
									
						<%-- pie botones --%>
						<div id="divEditarBotones1" class="modal-footer" style="border:none">
		        			<button type="button" title="Cancelar" class="titulosbotones3 btn btn-default bread-active colortext btn btn-default btn-lg active cancelar" id="btnEditUsuario" data-dismiss="modal">Cancelar</button>
		        			<button type="submit" title="Eliminar el usuario" id="btnAceptarEliminarUsuario"  data-dismiss="modal"   class="titulosbotonesDelete btn btn-default bread-active colortext btn btn-default btn-lg active cancelar">Eliminar</button>
		      			</div>

			      	</div>
		      </div>
		    </div>
		  </div> 
	  
	 	 </form>
 	 </div>
	
</div>