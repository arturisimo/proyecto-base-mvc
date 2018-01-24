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
		  action='<c:url value="/administracion/usuarios/modificar/"/>'>
		
		<div class="row no-movil-padding">  
			<div class="col-md-offset-3 col-md-6 div_edicion">     

				<input name="id" type="hidden" class="form-control" id="id" value="${bUsu.id}">
				
				<!-- Nombre -->
				<div  id="dvNombre" class="form-group">
					<label for="nombre" class="col-md-offset-1 col-md-3  control-label">Nombre(*)</label>
					<div class="col-md-5">
						<input name="nombre" type="text" class="form-control" id="nombre" value="${bUsu.nombre}">
					</div>
				</div> 
				  
			 	<!-- Login -->
				<div  id="dvLogin" class="form-group">
					<label for="login" class="col-md-offset-1 col-md-3 control-label">Login(*)</label>
					<div class="col-md-5">
						<input name="login" type="text" class="form-control" id="login" value="${bUsu.login}">
					</div>
				</div> 
				
				<!-- Email -->
				<div  id="dvEmail" class="form-group">
					<label for="email" class="col-md-offset-1 col-md-3 control-label">Email(*)</label>
					<div class="col-md-5">
						<input name="email" type="text" class="form-control" id="email" value="${bUsu.email}">
					</div>
				</div> 
			 	<hr/>
			 	
			 	<div class="checkbox col-md-offset-4 col-md-8" style="margin-bottom:20px">
					<label>
				    	<input id="change" name="change" type="checkbox" value="S"> Cambiar contraseña
				    </label>
				</div>
				
			 	<br clear="all"/>
			 	<!-- Contraseña Actual -->
				<div  id="dvPassword" class="form-group changepass">
					<label for="password" class="col-md-offset-1 col-md-3 control-label">Contraseña actual(*)</label>
					<div class="col-md-5">
						<input name="password" type="password" class="form-control" id="password">
					</div>
				</div> 
				
				<!-- Contraseña nueva -->
				<div  id="dvNewPassword" class="form-group changepass">
					<label for="newpassword" class="col-md-offset-1 col-md-3 control-label">Nueva contraseña(*)</label>
					<div class="col-md-5">
						<input name="newpassword" type="password" class="form-control" id="newpassword">
					</div>
				</div> 
				
				<!-- Confirmar contraseña -->
				<div  id="dvRePassword" class="form-group changepass">
					<label for="repassword" class="col-md-offset-1 col-md-3 control-label">Confirmar contraseña(*)</label>
					<div class="col-md-5">
						<input name="repassword" type="password" class="form-control" id="repassword">
					</div>
				</div> 
				
				<%-- ..................... --%>
				<%-- SECCION DE ROLES	   --%>
				<%-- ..................... --%>
				<div id="dvSeccionRoles">
					<div class="form-group">
						<div>
							<label for="optionsChk1" class="col-md-offset-1 col-md-3 control-label">Roles</label>
						</div>
						<div class="col-md-5">
							<!-- Checkbox roles   -->
							<c:forEach items="${listaRoles}" var="rol">
								<div class="checkbox">
									<label>
										<input name="rol-${rol.id}" id="chkRol_${rol.id}" type="checkbox" value="${rol.id}"
											<c:if test="${rol.seleccionado}"> checked="checked" </c:if>
										>
										${rol.nombre}
									</label>
								</div>
							</c:forEach>
						</div>
					</div>
				</div><!--  dvSeccionRoles -->
			</div>
		</div>
		
		<div class="form-group" style="margin-top:15px; text-align: center;">
			<div class="margeninferior">
				<a href="<c:url value='/administracion/usuarios/detalle/${bUsu.id}/'/>" title="Cancelar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" >Cancelar</a>
				<button type="submit" title="Guardar cambios" id="modificarUsuario" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active">Guardar</button>
			</div>
		</div>
		
	
	</form>

</div>