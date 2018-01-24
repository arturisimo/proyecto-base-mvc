<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
%><%-- TAGLIBS --%><% 
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%>

<div id="principal" class="mt20 col-md-12 no-movil-padding">

	<c:if test="${not empty error}">
		<div class="alert alert-danger alert-dismissable" style="text-align:center">
		  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		  <strong>¡Error!</strong> ${mensajeError}
		</div>
	</c:if>

	<form class="mt15 mb10 form-horizontal"
		  method="post"
		  id="f1"
		  action='<c:url value="/administracion/usuarios/guardar/"/>'>

		<div class="row no-movil-padding">  
			<div class="col-md-offset-3 col-md-6 div_edicion">   
				   
				<!-- Nombre -->
				<div  id="dvNombre" class="form-group">
					<label for="nombre" class="col-md-offset-1 col-md-3  control-label">Nombre(*)</label>
					<div class="col-md-5">
						<input name="nombre" type="text" class="form-control" id="nombre" value="${bUsu.nombre}">
					</div>
				</div> 
				  
			 	<!-- Login -->
				<div  id="dvLogin" class="form-group <c:if test='${error == 1}'>has-error</c:if>">
					<label for="login" class="col-md-offset-1 col-md-3  control-label">Login(*)</label>
					<div class="col-md-5">
						<input name="login" type="text" class="form-control" id="login" value="${bUsu.login}">
					</div>
				</div> 
				
				<!-- Email -->
				<div  id="dvLogin" class="form-group <c:if test='${error == 1}'>has-error</c:if>">
					<label for="email" class="col-md-offset-1 col-md-3  control-label">Correo electrónico(*)</label>
					<div class="col-md-5">
						<input name="email" type="text" class="form-control" id="email" value="${bUsu.email}">
					</div>
				</div> 
					
				<!-- Password -->
				<div  id="dvPassword" class="form-group">
					<label for="password" class="col-md-offset-1 col-md-3  control-label">Contraseña(*)</label>
					<div class="col-md-5">
						<input name="password" type="password" class="form-control" id="password" value="">
					</div>
				</div> 
				
				<!-- Confirm password -->
				<div  id="dvRePassword" class="form-group">
					<label for="repassword" class="col-md-offset-1 col-md-3  control-label">Confirmar contraseña(*)</label>
					<div class="col-md-5">
						<input name="repassword" type="password" class="form-control" id="repassword" value="">
					</div>
				</div> 
			 	
			
				<hr/> 
			
				<%-- ..................... --%>
				<%-- SECCION DE ROLES	   --%>
				<%-- ..................... --%>
				<div id="dvSeccionRoles">
					<div class="form-group">
						<div>
							<label for="optionsChk1" class="col-md-offset-1 col-md-3  control-label">Roles</label>
						</div>
						<div class="col-md-5">
							<c:forEach items="${listaRoles}" var="rol">
								<div class="checkbox" style="max-width:240px">
									<label>
										<input name="rol-${rol.id}" id="chkRol_${rol.id}" type="checkbox" value="${rol.id}"
											<c:if test="${rol.seleccionado}"> checked="checked" </c:if>>${rol.nombre}
									</label>
								</div>
							</c:forEach>
						</div>
					</div>
				</div> 
			</div>
		</div>
		
		<div class="form-group" style="margin-top:15px; text-align: center;">
			<div class="margeninferior">
				<a href="<c:url value='/administracion/usuarios/'/>" title="Cancelar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" >Cancelar</a>
				<button id="guardarUsuario" title="Guardar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active">Guardar</button>
			</div>
		</div>
		
	
	</form>

</div>