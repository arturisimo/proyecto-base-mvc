<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="principal" class="mt20 col-md-12">

<c:set var="actionForm"><c:url value="/administracion/${filtroListado.modulo}/busqueda"/></c:set>

<form:form cssClass="mt15 mb10 form-horizontal" modelAttribute="filtroListado" method="POST" action="${actionForm}">
		<div class="borde margin-top" > 
			<div class="subtitulofiltros fondosubtitulos" style="float:left; display:block;">BÚSQUEDA DE ROLES</div>
	
		    <div class="container-fluid ">
			 	
				<div class="row">
					<div id="bloqFiltros" class="row col-md-12"style="padding-top: 8px !important;line-height: 14px;padding-bottom: 8px !important;">
						
						<div class="row form-group col-md-12 control-label" style="margin-bottom: 0px">
			
								<div class="dir-filtros">
									<!-- Nombre -->
									<label for="nombre"	class="col-md-offset-1 col-md-1 control-label texto-label">Nombre</label>
									<div class="col-md-2" style="padding: 0px;">
										<div class="input-group">
											<form:input path="nombre" cssStyle="form-control input-round" id="nombre" />
										</div>
										<!-- /input-group -->
									</div>
									
									<!-- Login -->
									<label for="login"	class="col-md-1 control-label texto-label">Login</label>
									<div class="col-md-2" style="padding: 0px;">
										<div class="input-group">
											<form:input path="login" cssStyle="form-control input-round" id="login" />
										</div>
										<!-- /input-group -->
									</div>
									
								</div>
							
							</div>
						
					</div>
				</div>
				
			</div>
			
		</div>
		
		<div style="width:100%;" class="filtroscenter">
			<button title="Buscar" type="submit" id="buscar" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" style="margin:20px 0px; text-align:center; float:center;">Buscar</button>
			<a title="Nuevo" href="<c:url value='/admin/${filtroListado.modulo}/alta/'/>" class="titulosbotones2 btn btn-default bread-active colortext btn btn-primary btn-lg active" style="margin:20px 0px; text-align:center; float:center;" >Nuevo Rol</a>
		</div>

	</form:form>
	
	<c:choose>
		<c:when test="${not empty listado}">
			<tiles:insertAttribute name="listado-${filtroListado.modulo}"/>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning alert-dismissable" style="text-align: center;">
			  No se han encontrado registros.
			</div>
		</c:otherwise>
	</c:choose>
	
</div>