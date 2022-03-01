<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.moviebooking.bean.Movie" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.io.File" %>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of movies</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
	<jsp:include page="Bootstrap.jsp"></jsp:include>
</head>
<body>
<%-- <%List<Movie> movielist = (List<Movie>) request.getAttribute("movielist"); %> --%>
<jsp:include page="NavigationBar.jsp"></jsp:include>

<table class="table pt-5">
<thead class="thead-dark">
<tr>
<th scope="col">Id</th>
<th scope="col">Theatre Name</th>
<th scope="col">Theatre Location</th>
<th scope="col">Number of seats</th>
<th scope="col">Number of Rows</th>
</tr>
</thead>

<c:forEach var="lst" items="${allTheatreLoaction}">
<tr>
<td scope="row">${lst.getId()}</td>
<td>${lst.getName()}</td>
<td>${lst.getLocation()}</td>
<td>${lst.getNoofseats()}</td>
<td>${lst.getNoofrows()}</td>
</tr>
</c:forEach>

</table>


</body>
</html>