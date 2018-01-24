<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>

<head>
	<script type="text/javascript">
	    var appRootUrl = '<c:url value="/"/>';
	</script>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<tiles:insertAttribute name="header"/>
	<link rel="shortcut icon" href="<c:url value="/favicon.ico"/>"/>
	<title>Proyecto base MVC</title>
</head>  
	
<body>
		
		<div id="datoscabecera" class="datoscabecera"> 
				
				<form method="post"  id="fLogout" action="<c:url value='/j_spring_security_logout'/>">
	   		 		<input type="hidden" name="logoutExitPage" value="/logout"/>
	  		  		<span id="idLogout">Salir</span>
	  		  		<img class="imgpositioncabecera" src='<c:url value="/img/salir_cabecera.png"/>'/>
				</form>
				
		</div>
	  	<!--
	  	<
		<div id="fondoblanco">
			<div id="capablanca"></div>
			<div id="capagris"></div>	
		</div>
		-->
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