<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			<c:forEach items="${listado}" var="usuario">
					<tr class="alturatablas">
						<td width="30%" id="name_${usuario.id}">${usuario.nombre}</td>
						<td width="20%" class="no-movil">${usuario.login}</td>
						<td width="30%" class="no-movil">${usuario.email}</td>
						
						<td width="20%">
	  						<div  style="text-align: center; margin: auto;">
	  						
	  							<c:choose>
		  							<c:when test="${!usuario.borrado}">
		  								<a id="btnDetalle" title="Detalle"
								 			href="<c:url value="/admin/${filtroListado.modulo}/detalle/${usuario.id}/"/>">
								 			<i class="fa fa-info"></i></a>
								
										<a id="btnModificar" title="Modificar"
												 	href="<c:url value="/admin/${filtroListado.modulo}/editar/${usuario.id}/"/>">
												 	<i class="fa fa-pencil"></i></a>		
												
										<a title="Eliminar" class="delUsuario"
													id="delete_${usuario.id}"
												 	href="<c:url value="/admin/${filtroListado.modulo}/eliminar/${usuario.id}/"/>">
												 	<i class="fa fa-trash-o"></i></a>
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