<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			
			<div id="tabs" class="col-md-offset-2 col-md-8 no-movil-padding" style="text-align:center;">
			  
			  <ul class="ul_pestanas">
			    <li><a href="#tabs-1">Información general</a></li>
			    <li><a href="#tabs-2">Permisos</a></li>
			  </ul>
			  
			  <!-- Info general -->
			  <div id="tabs-1" class="div_detalle_pestana">
			  	<div class="tablaAdminDetalle">
					<table style="position: relative;">				
						<tbody>
							<tr>
								<td class="td_th">Nombre</td>
								<td><div>${detalle.nombre}</div></td>
							</tr>
							<tr>	
								<td class="td_th">Descripción</td>
								<td><div>${detalle.descripcion}</div></td>
							</tr>
							</tbody>
					</table>
				</div>
			  </div>
			  
			  <!-- Permisos -->
			  <div id="tabs-2" class="div_detalle_pestana">
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
	
			<a href="<c:url value='/admin/roles/'/>" title="Volver al listado" class="titulosbotones3 btn btn-default bread-active colortext btn btn-default btn-lg active cancelar" >Volver al listado</a>
			<a href="<c:url value='/admin/roles/editar/${detalle.id}/'/>" title="Editar" class="titulosbotones3 btn btn-default bread-active colortext btn btn-default btn-lg active cancelar" >Editar</a>
			
			<c:if test="${bRol.tipo == 0}">
				<a  
					title="Eliminar" 
					class="delRol titulosbotonesDelete btn btn-default bread-active colortext btn btn-default btn-lg active cancelar"
					id="delete_${bRol.id}"
				 	href="<c:url value="/admin/roles/eliminar/${bRol.id}/"/>">
				 	Eliminar</a>
			 </c:if>
		</div>
	</div>
		
</div>