<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add theatre</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
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
height: 410px;
}
</style>
<jsp:include page="Bootstrap.jsp"></jsp:include>
<body>

<jsp:include page="NavigationBar.jsp"></jsp:include>
<div class="text-center">
		<form method="POST" action="addTheatretoDB" enctype="multipart/form-data">
			<h1 class="h3 font-weight-normal mt-3">Add Theatre</h1>
		<hr style="border:1px solid black;"/>
		<input  class="form-control mt-2 mb-3" id="movieName" type="text" name="theatreName" placeholder="Theatre Name" required autofocus autocomplete="off"/>
		<input  class="form-control mt-2 mb-3" id="actorsName" type="text" name="theatreLocation" placeholder="Theatre Location" required autofocus autocomplete="off"/>
		<input  class="form-control mt-2 mb-3" id="directorName" type="number" name="noofSeats" placeholder="Number of Seats" required autofocus autocomplete="off"/>
		<input  class="form-control mt-2 mb-3" id="directorName" type="number" name="noofrows" placeholder="Number of Rows" required autofocus autocomplete="off"/>
			<input class="btn btn-lg btn-success btn-block" type="submit" value="Add" style="width:100%;"/>
		</form>
	</div>

</body>
</html>