<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
 
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<script type="text/javascript">
	var appRootUrl = '<c:url value="/"/>';
</script>

<tilesx:useAttribute  id="list1" name="cssfilesList" classname="java.util.List"/>
<c:forEach var="cssfileName" items="${list1}">
    <link rel="stylesheet" type="text/css" media="screen" href='<%=request.getContextPath()%>${cssfileName}' />
</c:forEach>

<tilesx:useAttribute id="list5" name="cssfilesList2" classname="java.util.List" />
<c:forEach var="cssfileName2" items="${list5}">
    <link rel="stylesheet" type="text/css" media="screen" href='<%=request.getContextPath()%>${cssfileName2}' />
</c:forEach>

<tilesx:useAttribute id="list7" name="cssfilesListPrint" classname="java.util.List" />
<c:forEach var="cssfilePrint" items="${list7}">
    <link rel="stylesheet" type="text/css" media="print" href='<%=request.getContextPath()%>${cssfilePrint}' />
</c:forEach>

<tilesx:useAttribute  id="list6" name="cssLastfilesList" classname="java.util.List"/>
<c:forEach var="cssLastfilesList" items="${list6}">
    <link rel="stylesheet" type="text/css" media="screen" href='<%=request.getContextPath()%>${cssLastfilesList}'/>
</c:forEach>

<tilesx:useAttribute id="list3" name="jsfilesList" classname="java.util.List" />
<c:forEach var="jsfileName" items="${list3}">
     <script type="text/javascript" src='<%=request.getContextPath()%>${jsfileName}'></script>
</c:forEach>

<tilesx:useAttribute id="list4" name="jsfilesList2" classname="java.util.List"/>
<c:forEach var="jsfileName2" items="${list4}">
     <script type="text/javascript" src='<%=request.getContextPath()%>${jsfileName2}'></script>
</c:forEach>

<script src="<%=request.getContextPath()%>/js/respond.min.js"></script>