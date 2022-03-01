<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Show</title>
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
height: 290px;
}
</style>
<jsp:include page="Bootstrap.jsp"></jsp:include>
</head>
<body>

<div class="text-center">
<jsp:include page="NavigationBar.jsp"></jsp:include>
		<form method="POST" action="updateShowtoDB" enctype="multipart/form-data">
			<h1 class="h3 font-weight-normal mt-3">Update Show</h1>
		<hr style="border:1px solid black;"/>
		

		<select class="form-select form-control mt-2 mb-3" aria-label="Default select example" name="showId">
		<c:forEach var="v" items="${allShows}">
		
		<option value="${v.getId()}">id=${v.getId()} ) ${v.getStarttime()} --- ${theatreMap.get(v.getTheatreid()).getName()}(${theatreMap.get(v.getTheatreid()).getLocation()}) </option>
		</c:forEach>
		
		</select>
		
		
		
		<select class="form-select form-control mt-2 mb-3" aria-label="Default select example" name="MovieId">
		<c:forEach var="v" items="${allMovieList}">
		<option value="${v.getId()}">id=${v.getId()} ) ${v.getName()}</option>
		</c:forEach>
		</select>
		
		
			<input class="btn btn-lg btn-success btn-block" type="submit" value="Update" style="width:100%;"/>
		</form>
	</div>



</body>
</html>



<%-- <input  class="form-control mt-2 mb-3" id="showId" type="text" name="showId" placeholder="show Id" required autofocus autocomplete="off"/>
		<select class="form-select form-control mt-2 mb-3" aria-label="Default select example" name="MovieId">
		<option selected>Select Movie</option>
		<c:forEach var="loc" items="${allMovieList}">
		<option value="${loc.getId()}" >${loc.getName()}</option>
		</c:forEach>
		</select> --%>