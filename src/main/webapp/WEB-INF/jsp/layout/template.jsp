<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html>
  <head>
    <title>Proyecto base MVC</title>
    <tiles:insertAttribute name="header"/>
  </head>

  <body>

    <div class="container">
	      <div class="row">	
				<tiles:insertAttribute name="cabeceraPlantilla"/>
		  </div>
		  <div class="row rowPrincipal">	
				<tiles:insertAttribute name="zonaPrincipalPlantilla"/>
		  </div>
    </div>
    <tiles:insertAttribute name="piePlantilla"/>

  </body>
</html>