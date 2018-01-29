<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--  textos de cada nivel del rastro migas -->
<tiles:importAttribute  name="menuMainOption"    toName="MIGA_NIV_1"/>
<tiles:importAttribute  name="menuSecondOption"  toName="MIGA_NIV_2"/>	
<tiles:importAttribute  name="menuThirdOption"   toName="MIGA_NIV_3"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
   <div class="container">
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href='<c:url value="/portada"/>'>Projecto base MVC</a>
     </div>
     <div id="navbar" class="collapse navbar-collapse">
       <ul class="nav navbar-nav">
         <li class="dropdown">
         	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Administración
        	<span class="caret"></span></a>
       		<ul class="dropdown-menu">
         		<li><a href='<c:url value="/admin/usuarios"/>'>Usuarios</a></li>
         		<li><a href='<c:url value="/admin/roles"/>'>Roles</a></li>
       		</ul>
      	</li>
       </ul>
       <ul class="nav navbar-nav pull-right">
        	 <li><a id="usuarioLogin" href="#"><i class="fa fa-user"></i> ${usuarioSession.login}</a></li>
        	 <li><a id="logout" href="#"><i class="fa fa-power-off "></i></a></li>
       	</ul>
       	<ul id="userSession" class="usuario-menu list-group hidden">
       		<li class="list-group-item"><strong><a href="<c:url value="/admin/usuarios/detalle/${usuarioSession.id}"/>">${usuarioSession.login}</strong></a></li>
       		<li class="list-group-item">${usuarioSession.nombre}</li>
     		<li class="list-group-item">${usuarioSession.email}</li>
     	</ul>
     </div><!--/.nav-collapse -->
   </div>
 </nav>


<!--  ................................................  -->
<!-- Cabecera 2 con Seccion Principal y rastro de migas -->
<!--  ................................................  -->
<c:set var="urlMigas"><c:url value="/"/></c:set> 
 
<!--  Urls de cada nivel del rastro migas -->	
<c:set var="urlMigasNivel1" value="${urlMigas}"/>
<c:set var="urlMigasNivel2" value="${urlMigas}"/>
<c:set var="urlMigasNivel3" value="${urlMigas}"/>

<%-- BREADCRUMB  --%>
<c:set var="TEXTO_NIV_1">	
	<c:choose>
			<c:when test="${MIGA_NIV_1 == 'ADMINISTRACION'}">ADMINISTRACIÓN
				
					<c:set var="urlMigasNivel1" value="${urlMigas}admin"/>
					<c:set var="TEXTO_NIV_2">
							<c:choose>
									<c:when test="${MIGA_NIV_2 == 'USUARIOS'}">
										USUARIOS
										<c:set var="urlMigasNivel2" value="${urlMigas}admin/usuarios"/>
										<c:set var="TEXTO_NIV_3">
												<c:choose>
														<c:when test="${MIGA_NIV_3 == 'DETALLE'}">
															DETALLE
															<c:set var="urlMigasNivel3" value="${urlMigasNivel1}detalle"/>
														</c:when>
														<c:when test="${MIGA_NIV_3 == 'ALTA'}">
															ALTA
															<c:set var="urlMigasNivel3" value="${urlMigasNivel1}alta"/>
														</c:when>
														<c:when test="${MIGA_NIV_3 == 'EDITAR'}">
															 EDITAR
														<c:set var="urlMigasNivel3" value="${urlMigasNivel1}editar"/>
													</c:when>
												</c:choose>
										</c:set>
									</c:when>
									<c:when test="${MIGA_NIV_2 == 'ROLES'}">
										ROLES
										<c:set var="urlMigasNivel2" value="${urlMigas}admin/roles"/>
										<c:set var="TEXTO_NIV_3">
												<c:choose>
														<c:when test="${MIGA_NIV_3 == 'DETALLE'}">
															DETALLE
															<c:set var="urlMigasNivel3" value="${urlMigasNivel1}detalle"/>
														</c:when>
														<c:when test="${MIGA_NIV_3 == 'ALTA'}">
															ALTA
															<c:set var="urlMigasNivel3" value="${urlMigasNivel1}alta"/>
														</c:when>
														<c:when test="${MIGA_NIV_3 == 'EDITAR'}">
															 EDITAR
														<c:set var="urlMigasNivel3" value="${urlMigasNivel1}editar"/>
													</c:when>
												</c:choose>
										</c:set>
									</c:when>
							</c:choose>
					</c:set>
			</c:when>	
	
		</c:choose>
		
</c:set>	
<h2 class="titleSeccionPrincipal">
	<c:choose>
		<c:when test="${not empty TEXTO_NIV_3}">${MIGA_NIV_3}</c:when>
		<c:when test="${not empty TEXTO_NIV_2}">${MIGA_NIV_2}</c:when>
		<c:when test="${not empty TEXTO_NIV_1}">${MIGA_NIV_1}</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</h2>
		
<div id="cab2"> 
	<c:set var="miga_activa">
		<c:choose>
			<c:when test="${not empty TEXTO_NIV_3}">3</c:when>
			<c:when test="${not empty TEXTO_NIV_2}">2</c:when>
			<c:when test="${not empty TEXTO_NIV_1}">1</c:when>
			<c:otherwise>0</c:otherwise>
		</c:choose>
	</c:set>	

	<div id="titCab2">
	 
 	  <%-- TEXTO_NIV_2 = ${TEXTO_NIV_2}  - TEXTO_NIV_3 = ${TEXTO_NIV_3}--%> 
 
	    <div class="rastromigas">
	    	        <div class="btn-group btn-breadcrumb ajusteamedia">
	        
	        	<c:if test="${not empty TEXTO_NIV_1}"> 
	            	<a href="<c:url value="/portada"/>" class="btn btn-default bread-active"><i  class="fa fa-home"></i></a>
	            </c:if>
	            
	            <c:if test="${not empty TEXTO_NIV_1}"> 
		 			<c:choose> 
		 					<c:when test="${not empty TEXTO_NIV_2}">
		 						<a href="${urlMigasNivel1}"   class="btn btn-default bread-active <c:if test="${miga_activa==1}">active</c:if>">${TEXTO_NIV_1}</a>
		 					</c:when> 
		 					<c:otherwise>
		 						<a href="#"   class="btn btn-default bread-active <c:if test="${miga_activa==1}">active</c:if>">${TEXTO_NIV_1}</a>
		 					</c:otherwise>
		 			</c:choose> 
	 			</c:if>
				
				<c:if test="${not empty TEXTO_NIV_2}">
					<c:choose> 
		 					<c:when test="${not empty TEXTO_NIV_2}">
		 						<a href="${urlMigasNivel2}"   class="btn btn-default bread-active <c:if test="${miga_activa==2}">active</c:if>">${TEXTO_NIV_2}</a>
		 					</c:when> 
		 					<c:otherwise>
		 						<a href="#"   class="btn btn-default bread-active <c:if test="${miga_activa==2}">active</c:if>">${TEXTO_NIV_2}</a>
		 					</c:otherwise>
		 			</c:choose> 
				</c:if>
				
				<c:if test="${not empty TEXTO_NIV_3}">
					 <a href="#" class="btn btn-default bread-active <c:if test="${miga_activa ==3}">active</c:if>">${TEXTO_NIV_3}</a>
				</c:if>
				
	        </div>
	        
		</div>

	</div>

</div>