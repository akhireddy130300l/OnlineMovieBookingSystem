<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Selection</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body> 

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-2">
  <a class="navbar-brand px-3 pl-3 text-white" href="#"><img style="height: 35px;width: 100px;" src="<c:url value="/resources/images/Logo.png"/>"/></a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link px-3 text-white" href="../navigationBarCustomer">Home</a>
      <a class="nav-item nav-link px-3 text-white" href="../selectlocation">Change Location</a>
      <a class="nav-item nav-link px-3 text-white" href="../customerProfile">My Profile</a>
       <a class="nav-item nav-link px-3 text-white" href="../mybookings/${Logininfo.getId()}">My Bookings</a>
      <a class="nav-item nav-link px-3 text-white" href="../endsession">Logout</a>
    </div>
  </div>
</nav>
<input name="locationselected" hidden="true" value="${locationselected}" />




<c:forEach var="v" items="${theatresByMovieSelected}">

<div class="card pb-4 mb-4" style="width: 50%;">
  <div class="card-body">
    <h5 class="card-title">${v.getName()}</h5>
    <p class="card-text">${v.getLocation()}</p>
    
    
    <c:forEach var="s" items="${allShowsbyTheatre}">
    
    <c:if test="${v.getId()==s.getTheatreid()}">
    <a href="../${movieId}/seatselection/${s.getId()}" class="btn btn-primary">${s.getStarttime()}</a>
    </c:if>
    
    </c:forEach>
    
    
    
    
  </div>
</div>
</c:forEach>


</body>
</html>