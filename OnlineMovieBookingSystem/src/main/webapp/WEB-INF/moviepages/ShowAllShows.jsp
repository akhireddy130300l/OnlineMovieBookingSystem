<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.moviebooking.bean.Shows" %>
    <%@ page import="java.util.List" %>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowAllShows</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="NavigationBar.jsp"></jsp:include>
<%-- <% List<Shows> shows = request.getAttribute("allShows"); %> --%>

<table class="table pt-5">
<thead class="thead-dark">
<tr>
<th scope="col">Id</th>
<th scope="col">Start Time</th>
<th scope="col">Movie Id)Movie Name</th>
<th scope="col">Theatre Id ) Theatre Name</th>
</tr>
</thead>

<c:forEach var="lst" items="${allShows}">
<tr>
<td scope="row">${lst.getId()}</td>
<td>${lst.getStarttime()}</td>
<td>${lst.getMovieid()}    ) ${movieMap.get(lst.getMovieid()).getName()}</td>
<td>${lst.getTheatreid()} ) ${theatreMap.get(lst.getTheatreid()).getName()}</td>
</tr>
</c:forEach>

</table>
</body>
</html>