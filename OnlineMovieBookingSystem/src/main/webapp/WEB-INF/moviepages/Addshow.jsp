<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Show</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
	<link rel="icon" href="<c:url value="/resources/images/titleLogo.png"/>"/>
<style type="text/css">
body{
background-image: url("<c:url value="/resources/images/background1.jpg"/>");
}
form{
background-color:#FFFFFF;
max-width:700px;
margin:auto;
margin-top:190px;
border:3px solid black;
padding:40px;
padding-top:0;
height: 320px;
}
</style>
<jsp:include page="Bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="NavigationBar.jsp"></jsp:include>
<div class="text-center">
		<form method="POST" action="addShowtoDB" enctype="multipart/form-data">
			<h1 class="h3 font-weight-normal">Add Show</h1>
		<hr style="border:1px solid black;"/>
		<input  class="form-control mt-2 mb-3" id="movieStartTime" type="text" name="movieStartTime" placeholder="movie Start Time(HH-MM AM/PM)" required autofocus autocomplete="off"/>
		<!-- <input  class="form-control mt-2 mb-3" id="MovieId" type="text" name="MovieId" placeholder="Movie Id" required autofocus autocomplete="off"/> -->
		
		<select class="form-select form-control mt-2 mb-3" aria-label="Default select example" name="MovieId">
		<option selected>Select Movie</option>
		<c:forEach var="loc" items="${allMovieList}">
		<option value="${loc.getId()}" >${loc.getName()}</option>
		</c:forEach>
		</select>
		
		<!-- <input  class="form-control mt-2 mb-3" id="TheatreId" type="number" name="TheatreId" placeholder="Theatre Id" required autofocus autocomplete="off"/> -->
		
		<select class="form-select form-control mt-2 mb-3" aria-label="Default select example" name="TheatreId">
		<option selected>Select Location</option>
		<c:forEach var="loc" items="${allTheatreLoaction}">
		<option value="${loc.getId()}" >${loc.getName()}</option>
		</c:forEach>
		</select>
		
			<input class="btn btn-lg btn-success btn-block" type="submit" value="Add" style="width:100%;"/>
		</form>
	</div>
</body>
</html>