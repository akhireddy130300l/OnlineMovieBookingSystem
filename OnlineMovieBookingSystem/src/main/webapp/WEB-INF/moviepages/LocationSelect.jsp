<%@page import="com.moviebooking.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="com.moviebooking.bean.*" %>
  <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Location</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
	<style type="text/css">
body{
background-image: url("<c:url value="/resources/images/background1.jpg"/>");
}
div{
background-color:#FFFFFF;
max-width:700px;
margin:auto;
margin-top:190px;
border:3px solid black;
padding:40px;
padding-top:0;
height: 370px;
}
</style>
	
</head>
<body>


<div class="text-center">
<h1>Welcome ${Logininfo.getName()}</h1>
<h2>Select Location</h2>
<hr style="border:1px solid black;"/>
<form action="home" method="POST" >
<select class="form-select" aria-label="Default select example" name="locationselected">



<c:forEach var="loc" items="${dtheatre}">
<option value="${loc}" >${loc}</option>

</c:forEach>
</select>

<select class="form-select mt-4" aria-label="Default select example" name="dateselected">



<c:forEach var="loc" items="${dates}">
<option value="${loc}" >${loc}</option>

</c:forEach>
</select>


<input class="btn btn-lg btn-success btn-block mt-4" type="submit" value="Select" style="width:100%;"/>
</form>
</div>




</body>
</html>


