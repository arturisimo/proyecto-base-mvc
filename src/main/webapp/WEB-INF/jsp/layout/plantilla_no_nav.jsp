<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
 
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<tiles:insertAttribute name="header"/>
	</head> 
 
	<body> 
			<div class="container">
			 	<div class="row">
						<tiles:insertAttribute name="zonaPrincipalPlantilla"/>
				</div>
			</div>
	
	</body>
</html>