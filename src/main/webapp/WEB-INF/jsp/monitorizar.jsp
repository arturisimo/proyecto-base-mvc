<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%%><%-- TAGLIBS --%>
<%%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%
%><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%><%
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%><%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><%
%>

<h2>Monitorización del Servidor</h2>

<style>

.ocultar {
	cursor:pointer
}

td {
	background: #fff;
}

</style>

<script type="text/javascript">


$(document).ready(function() {
	
	$(".ocultar").click(function(){
		
		if ($(this).hasClass("glyphicon-eye-open"))
		{
			$("." + $(this).attr("id")).fadeIn( "slow" );
			$(this).removeClass("glyphicon-eye-open");
			$(this).addClass("glyphicon-eye-close");
		}
		else 
		{
			$("." + $(this).attr("id")).hide();
			$(this).addClass("glyphicon-eye-open");
			$(this).removeClass("glyphicon-eye-close");
		}
		
	});
	
});

</script>

<table class="table table-bordered">
	<tbody>
		
		<tr>
 			<td style="background: #20A7B2; color: #fff; font-weight: bold;" colspan="2">
 				<span id="d1" class="ocultar glyphicon glyphicon-eye-open"></span> Datos de interés
 			</td>
		</tr>
	
		<c:forEach items="${datos}" var="dato">
			<tr class="d1" style="display:none">
	 			<td><b>${dato.key}</b></td>
	 			<td>${dato.value}</td>
			</tr>
		</c:forEach>
		
		<tr>
  			<td style="background: #20A7B2; color: #fff; font-weight: bold;" colspan="2">
 				<span id="d2" class="ocultar glyphicon glyphicon-eye-open"></span> Propiedades del Log4j
 			</td>
		</tr>
		
		<c:forEach items="${propiedadesLog4j}" var="p4j">
			<tr class="d2" style="display:none">
	 			<td><b>${p4j.key}</b></td>
	 			<td>${p4j.value}</td>
			</tr>
		</c:forEach>
		
		<tr>
 			<td style="background: #20A7B2; color: #fff; font-weight: bold;" colspan="2">
 				<span id="d3" class="ocultar glyphicon glyphicon-eye-open"></span> Propiedades del Sistema
 			</td>
		</tr>
		
		<c:forEach items="${propiedadesSistema}" var="pSis">
			<tr class="d3" style="display:none">
	 			<td><b>${pSis.key}</b></td>
	 			<td>${pSis.value}</td>
			</tr>
		</c:forEach>
		
		<tr>
 			<td style="background: #20A7B2; color: #fff; font-weight: bold;" colspan="2">
 				<span id="d4" class="ocultar glyphicon glyphicon-eye-open"></span> Propiedades JVM
 			</td>
		</tr>
		<c:forEach items="${propiedadesJvm}" var="pJvm">
			<tr class="d4" style="display:none">
	 			<td><b>${pJvm.key}</b></td>
	 			<td>${pJvm.value}</td>
			</tr>
		</c:forEach>
		
		<tr>
 			<td style="background: #20A7B2; color: #fff; font-weight: bold;" colspan="2">
 				<span id="d5" class="ocultar glyphicon glyphicon-eye-open"></span> Parametros BD
 			</td>
		</tr>
		<c:forEach items="${parametrosDB}" var="parDBmapa">
			<tr class="d5" style="display:none">
				<c:forEach items="${parDBmapa}" var="parDB" varStatus="vs">
		 			<td>
		 				<c:choose>
					 		<c:when test="${vs.count == 1}">
					 			<b>${parDB.value}</b>
					 		</c:when>
					 		<c:otherwise>
					 			${parDB.value}
					 		</c:otherwise>
				 		</c:choose>
		 			</td>
				</c:forEach>
			</tr>
		</c:forEach>
		
		<tr>
 			<td style="background: #20A7B2; color: #fff; font-weight: bold;" colspan="2">
 				<span id="d6" class="ocultar glyphicon glyphicon-eye-open"></span> Privilegios en BD para el usuario ${usuarioBD}
 			</td>
		</tr>
		<c:forEach items="${privilegiosDB}" var="priDBmapa">
			<tr class="d6" style="display:none">
				<c:forEach items="${priDBmapa}" var="priDB" varStatus="vs">
			 		<td>
			 			<c:choose>
					 		<c:when test="${vs.count == 1}">
					 			<b>${priDB.value}</b>
					 		</c:when>
					 		<c:otherwise>
					 			${priDB.value}
					 		</c:otherwise>
				 		</c:choose>
			 		</td>
				</c:forEach>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
	
	

