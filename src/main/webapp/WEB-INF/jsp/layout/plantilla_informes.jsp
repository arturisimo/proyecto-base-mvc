<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
%><%-- TAGLIBS --%><% 
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %><%
%><%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page import="java.util.Date" %>
<%
 Date date = new java.util.Date();
 pageContext.setAttribute("date", date);
%>
<!DOCTYPE html>
<html>

	<head>
		<!--[if lte IE 8]><script language="javascript" type="text/javascript"	src="<%=request.getContextPath()%>/js/flot/excanvas.min.js"></script><![endif]-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	 	<tiles:insertAttribute name="header"/>
	 	<link rel="shortcut icon" href="<c:url value="/favicon.ico"/>"/>
	 	<title>XXX - Renfe Viajeros</title>
	</head>  
	
	<body>
		
		<div id="datoscabecera" class="datoscabecera"> 
				
				<!-- Formulario para Tomcat -->
				<form method="post"  id="fLogout" 
					 	 action="<c:url value='/j_spring_security_logout'/>">
	   		 			<input type="hidden" name="logoutExitPage" value="/logout"/>
	  		  		<span id="idLogout">Salir</span>
	  		  		<img class="imgpositioncabecera" src='<c:url value="/img/salir_cabecera.png"/>'/>
				</form>
				
		</div>
	  	<c:set var="now" value="${date}" />
		<div id="datosfecha"class="datosfecha">
		 	<c:set var="today" value="<%=new Date()%>"/>
		  	<fmt:setLocale value="es" />
		  	<fmt:formatDate type="date" value="${today}" dateStyle="long"/>  
		</div>
	 
		<div id="fondoblanco">
			<div id="capablanca"></div>
			<div id="capagris"></div>	
		</div>
		
		<div id="wrapper" class="container2">
			<div class="row">	
				<tiles:insertAttribute name="cabeceraPlantilla"/>
			</div>
			<div class="row rowPrincipal">	
				<tiles:insertAttribute name="zonaPrincipalPlantilla"/>
			</div>
		</div>
		
	</body>
	
</html>