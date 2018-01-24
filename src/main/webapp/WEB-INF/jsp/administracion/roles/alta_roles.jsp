<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="principal" class="mt20 col-md-12 no-movil-padding">
	
	<form:form cssClass="mt15 mb10 form-horizontal" modelAttribute="rol" method="POST" action='<c:url value="/administracion/roles/guardar/"/>'>
		   
		<div class="row no-movil-padding">  
			<div class="col-md-offset-2 col-md-8 div_edicion">     
		   
				<!-- Nombre -->
				<div  id="dvNombre" class="form-group">
					<label for="nombre" class="col-md-offset-1 col-md-3  control-label">Nombre(*)</label>
					<div class="col-md-5">
						<form:input path="nombre" cssClass="form-control" id="nombre" />
					</div>
				</div> 
				  
			 	<!-- Descripcion -->
				<div  id="dvDescripcion" class="form-group">
					<label for="descripcion" class="col-md-offset-1 col-md-3  control-label">Descripción</label>
					<div class="col-md-5">
						<form:input path="descripcion" classClass="form-control" id="descripcion" />
					</div>
				</div> 
			 	
			
				<%-- ..................... --%>
				<%-- SECCION DE PERMISOS  --%>
				<%-- ..................... 
				<div id="dvSeccionPermisos">
					<div class="form-group">
						<div>
							<label for="optionsChk1" class="col-md-offset-1 col-md-3  control-label">Permisos</label>
						</div>
						<div class="col-md-8">
							<!-- Checkbox permisos   -->
							<table class="tree">
								<c:forEach items="${arbolPermisos}" var="permiso">
									<tr class="treegrid-${permiso.id} tree-tr  <c:if test="${not empty permiso.permisoPadre}">treegrid-parent-${permiso.permisoPadre}</c:if>">
										<td>
											<div class="checkbox tree-checkbox">
												<label><input type="checkbox" class="checkPerm" id="perm-${permiso.id}" name="perm-${permiso.id}" <c:if test="${permiso.seleccionado}">checked="checked"</c:if>/>
													${permiso.nombre}
												</label>
											</div>
										</td>
									</tr>
									<c:if test="${not empty permiso.list_permisos_hijos}">
										<c:forEach items="${permiso.list_permisos_hijos}" var="permHijo">
											<c:set var="permiso" value="${permHijo}" scope="request"/>
											<jsp:include page="permisos_hijos_alta.jsp"/>
										</c:forEach>
									</c:if>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>--%><!--  dvSeccionPermisos -->
			</div>
		</div>
		
		<div class="form-group" style="margin-top:15px; text-align: center;">
			<div class="margeninferior">
				<a href="<c:url value='/administracion/roles/'/>" title="Cancelar" class="titulosbotones3 btn btn-default bread-active colortext btn btn-default btn-lg active cancelar" >Cancelar</a>
				<button type="submit" id="guardarRol" title="Guardar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active">Guardar</button>
			</div>
		</div>
		
	
	</form:form>

</div>