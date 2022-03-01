<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add movie</title>
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
height: 420px;
}
</style>
<jsp:include page="Bootstrap.jsp"></jsp:include>
</head>

<body>



<nav class="navbar navbar-expand-lg navbar-dark bg-secondary" >
  <a class="navbar-brand px-3 pl-3  text-white" href="#">Admin</a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link px-3 text-white" href="adminLoginView">Home</a>
      <a class="nav-item nav-link px-3 text-white" href="endsession">Logout</a>
    </div>
    <div class="dropdown px-3">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Movie
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addMovie">Add Movie</a>
    <a class="dropdown-item" href="removeMovie">Remove Movie</a>
    <a class="dropdown-item" href="showMovies">Show All Movies</a>
  </div>
</div>

<div class="dropdown px-3">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Theatres
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addTheatre">Add Theatre</a>
    <a class="dropdown-item" href="removeTheatre">Remove Theatre</a>
    <a class="dropdown-item" href="showTheatre">Show All Theatres</a>
  </div>
</div>

<div class="dropdown px-3">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Shows
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addShow">Add Show</a>
    <a class="dropdown-item" href="removeShow">Remove Show</a>
    <a class="dropdown-item" href="updateShow">Update Shows</a>
    <a class="dropdown-item" href="showAllShows">All Shows</a>
  </div>
</div>
 <a class="nav-item nav-link px-3 text-white" href="endsession">Logout</a>

  </div>
</nav>



	<div class="text-center">
		<form method="POST" action="addMovietoDB" enctype="multipart/form-data">
			<h1 class="h3 font-weight-normal mt-3">Add Movie</h1>
		<hr style="border:1px solid black;"/>
		<input  class="form-control mt-2 mb-3" id="movieName" type="text" name="movieName" placeholder="Movie Name" required autofocus autocomplete="off"/>
		<input  class="form-control mt-2 mb-3" id="actorsName" type="text" name="actorsName" placeholder="Actors Name" required autofocus autocomplete="off"/>
		<input  class="form-control mt-2 mb-3" id="directorName" type="text" name="directorName" placeholder="Director Name" required autofocus autocomplete="off"/>
		<input class="form-control mt-2 mb-3" name="PosterName" type="file" value="Poster"/>	
			<input class="btn btn-lg btn-success btn-block mt-4" type="submit" value="Add" style="width:100%;"/>
		</form>
	</div>
</body>
</html>