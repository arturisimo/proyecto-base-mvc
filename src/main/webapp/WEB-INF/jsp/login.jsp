<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container row">
	<c:if test="${not empty error}">
      	<div class="alert alert-warning alert-dismissible col-md-offset-4 col-md-4" role="alert" style="margin-top: 20px;margin-bottom: -25px;font-size: 11px;text-align: center;line-height: 18px;">
	  		<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	  		<strong>Error en el acceso  </strong> El usuario y/o la contraseña no son correctos.
		</div>
    </c:if>

	<div class="login_container_sup col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-5 col-xs-12">
		<div class="row">
         	<div class="form-box col-md-offset-3 col-md-6">
             	<form name="f" action="<c:url value='/j_spring_security_check'/>" method="post">
					<span class="fontlogin">Usuario</span>
					<input name="j_username" type="text"  placeholder="usuario"> 
	                <span class="fontlogin">contraseña</span>
	                <input name="j_password" type="password"  placeholder="contraseña"> 
	                <button class="btn btn-info2 btn-block login loginajustes"  type="submit">Entrar</button>
             	</form> 
             </div> 
     	</div>
    </div>
</div>