<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			<c:forEach items="${listado}" var="rol">
					<tr class="alturatablas">
						<td class="cortar100" id="name_${rol.id}">${rol.nombre}</td>
						<td class="no-movil">${rol.descripcion}</td>
						<td>
	  						<div style="text-align: center; margin: auto;">
			  					<a  id="btnDetalle"
									title="Detalle"
								 	href="<c:url value="/admin/${filtroListado.modulo}/detalle/${rol.id}/"/>">
								 	<i class="fa fa-info"></i></a>
								
								<a  id="btnModificar"
									title="Modificar"
								 	href="<c:url value="/admin/${filtroListado.modulo}/editar/${rol.id}/"/>">
								 	<i class="fa fa-pencil"></i></a>		
								
								<c:if test="${rol.tipo == 0}">
									<a  title="Eliminar" 
										class="delRol"
										id="delete_${rol.id}"
									 	href="<c:url value="/admin/${filtroListado.modulo}/eliminar/${rol.id}/"/>">
									 	<i class="fa fa-delete-o"></i></a>
								 </c:if>
							</div>
		  				</td>
		  			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>