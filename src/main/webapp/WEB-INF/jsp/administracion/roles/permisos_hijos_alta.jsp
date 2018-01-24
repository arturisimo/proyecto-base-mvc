<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
%><%-- TAGLIBS --%><% 
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%>

<tr class="tree-tr treegrid-${permiso.id} treegrid-parent-${permiso.permisoPadre}">
	<td>
		<div class="checkbox tree-checkbox">
			<label>
				<input type="checkbox" class="checkPerm cpad-${permiso.permisoPadre}" id="perm-${permiso.id}" name="perm-${permiso.id}" <c:if test="${permiso.seleccionado}">checked="checked"</c:if>/>
				${permiso.nombre}
			</label>
		</div>
	</td>
</tr>
<c:if test="${not empty permiso.list_permisos_hijos}">
	<c:forEach items="${permiso.list_permisos_hijos}" var="permNieto">
		<c:set var="permiso" value="${permNieto}" scope="request"/>
		<jsp:include page="permisos_hijos_alta.jsp"/>
	</c:forEach>
</c:if>