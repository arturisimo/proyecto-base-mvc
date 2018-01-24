<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
%><%-- TAGLIBS --%><% 
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %><%
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%
%>

<div class="container row">

	<div class="login_container_sup col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-5 col-xs-12">
		<div class="row">
			     	
            	<h1 style="font-weight:bold; color:#B23162;">Error</h1>
			    
			    <p>Se ha producido un error en la aplicación<br></p>
             
				<c:if test="${not empty errMsg}">
					<!-- Error: ${errMsg} -->
			    </c:if>	
		
	    	</div>
	    </div>
</div>


   


