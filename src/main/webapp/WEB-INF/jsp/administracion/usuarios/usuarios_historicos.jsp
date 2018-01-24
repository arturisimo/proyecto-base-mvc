	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
%><%-- TAGLIBS --%><% 
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%>
	
	
	<div class="subtitulofiltros" style="float:center; display:block;">HISTÓRICO DE USUARIOS</div>
<div id="principal" class="mt20 col-md-12">
	
	
	
	<c:choose>
		<c:when test="${not empty list_historicos_usuario}">
			<div  class="tablaAdmin">
				<table>
					<thead>
						<tr class="alturatablas">
							<th class="no-movil">USUARIO</th>
							<th class="no-movil">FECHA</th>
							<th class="no-movil">ACCIÓN</th>
							<th class="no-movil">REALIZADO POR</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list_historicos_usuario}" var="usuario">
								<tr class="alturatablas">
									<td id="name_${usuario.id}">${usuario.nombre_usuario}</td>
									<td class="no-movil">${usuario.fecha_accion}</td>
									<td class="no-movil">${usuario.accion.descripcion}</td>
									<td class="no-movil">										
										<c:choose>
											<c:when test="${not empty usuario.usuario}">
												<a href="<c:url value='/administracion/usuario/${usuario.usuario.id}/'/>">${usuario.usuario.login}</a>
											</c:when>
											<c:otherwise>
												${usuario.nombre_usuario_accion}
											</c:otherwise>
										</c:choose>
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
	
		<div class="form-group" style="margin-top:15px; text-align: center;">
			<div class="margeninferior">
				<a href="<c:url value='/administracion/usuarios/'/>" title="Cancelar" class="titulosbotones3 btn btn-default bread-active colortext btn btn-default btn-lg active cancelar" >Cancelar</a>
			</div>
		</div>

	
</div>