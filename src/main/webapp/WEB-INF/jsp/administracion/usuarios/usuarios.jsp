<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="principal" class="mt20 col-md-12 no-movil-padding">

	<c:if test="${not empty error}">
		<div class="alert alert-danger alert-dismissable" style="text-align:center">
		  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		  <strong>¡Error!</strong> ${mensajeError}
		</div>
	</c:if>

	<form:form cssClass="mt15 mb10 form-horizontal" modelAttribute="detalle" method="post" action='<c:url value="/admin/${filtro.modulo}/guardar/"/>'>

		<div class="row no-movil-padding">  
			<div class="col-md-offset-3 col-md-6 div_edicion">   
				   
				<!-- Nombre -->
				<div  id="dvNombre" class="form-group">
					<form:label path="nombre" cssClass="col-md-offset-1 col-md-3  control-label">Nombre(*)</form:label>
					<div class="col-md-5">
						<form:input path="nombre" cssClass="form-control" id="nombre" />
					</div>
				</div> 
				  
			 	<!-- Login -->
				<div  id="dvLogin" class="form-group <c:if test='${error == 1}'>has-error</c:if>">
					<form:label path="login" cssClass="col-md-offset-1 col-md-3  control-label">Login(*)</form:label>
					<div class="col-md-5">
						<form:input path="login" cssClass="form-control" id="login" />
					</div>
				</div> 
				
				<!-- Email -->
				<div  id="dvLogin" class="form-group <c:if test='${error == 1}'>has-error</c:if>">
					<form:label path="email" cssClass="col-md-offset-1 col-md-3 control-label">Correo electrónico(*)</form:label>
					<div class="col-md-5">
						<form:input path="email" cssClass="form-control" id="email" />
					</div>
				</div> 
					
				<!-- Password -->
				<div  id="dvPassword" class="form-group">
					<form:label path="password" cssClass="col-md-offset-1 col-md-3 control-label">Contraseña(*)</form:label>
					
					<div class="col-md-5">
						<form:password path="password" cssClass="form-control" id="password" />
					</div>
				</div> 
				
				<!-- Confirm password -->
				<div  id="dvRePassword" class="form-group">
					<label for="repassword" class="col-md-offset-1 col-md-3  control-label">Confirmar contraseña(*)</label>
					<div class="col-md-5">
						<form:password path="password" cssClass="form-control" id="repassword" />
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
							<form:checkboxes items="${roles}" path="roles" itemLabel="nombre" itemValue="id" />
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="form-group" style="margin-top:15px; text-align: center;">
			<div class="margeninferior">
				<a href="<c:url value='/admin/usuarios'/>" title="Cancelar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" >Cancelar</a>
				<button id="guardarUsuario" title="Guardar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active">Guardar</button>
			</div>
		</div>
		
	
	</form:form>

</div>