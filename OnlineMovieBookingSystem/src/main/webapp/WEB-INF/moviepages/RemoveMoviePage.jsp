<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RemoveMoviePage</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
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
height: 300px;
}
</style>
<jsp:include page="Bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="NavigationBar.jsp"></jsp:include>
<div class="text-center">
		<form method="POST" action="removeMovieFromDB">
			<h1 class="h3 font-weight-normal mt-3">Remove Movie</h1>
		<hr style="border:1px solid black;"/>	
		<input class="form-control mt-2 mb-3" type="number" name="DeletingMovieId" placeholder="Movie Id" required autofocus autocomplete="off"/>
		<input class="form-control mt-2 mb-3" type="text" name="DeletingMovieName" placeholder="Movie Name" required autofocus autocomplete="off"/>
			<input class="btn btn-lg btn-success btn-block" type="submit" value="Add" style="width:100%;"/>
		</form>
	</div>

</body>
</html>