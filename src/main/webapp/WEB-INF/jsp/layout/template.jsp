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
	
	<%--
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Proyecto base MVC</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li>
        </ul>
      </div>
      <div id="datoscabecera" class="datoscabecera"> 
				
				<form method="post"  id="fLogout" action="<c:url value='/j_spring_security_logout'/>">
	   		 		<input type="hidden" name="logoutExitPage" value="/logout"/>
	  		  		<span id="idLogout">Salir</span>
	  		  		<img class="imgpositioncabecera" src='<c:url value="/img/salir_cabecera.png"/>'/>
				</form>
				
		</div>
    </nav>
 	--%>
    <div class="container">
	      <div class="row">	
				<tiles:insertAttribute name="cabeceraPlantilla"/>
		  </div>
		  <div class="row rowPrincipal">	
				<tiles:insertAttribute name="zonaPrincipalPlantilla"/>
		  </div>
    </div>
    <tiles:insertAttribute name="piePlantilla"/>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>
  </body>
</html>