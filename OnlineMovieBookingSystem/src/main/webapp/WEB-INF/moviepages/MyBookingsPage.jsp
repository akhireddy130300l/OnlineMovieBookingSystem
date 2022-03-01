<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Bookings</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-2 mt-3">
  <a class="navbar-brand px-3 pl-3 text-white" href="#">BookaTicket</a>
  
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





<div class="row row-cols-1  row-cols-md-3">
<c:forEach var="v" items="${ticketsByCustomerId}">
    <div class="card mb-4" style="border:1px solid black;">
      <img src="../getUserImage/<c:out value="${movieMap.get(v.getMovieid()).getId()}"/>.do" class="card-img-top" alt="..." style="width:100%;height:400px;">
      <div class="card-body" style="">
       <h5 class="card-title mt-2" style="padding-left: 10%;">Movie name:- ${movieMap.get(v.getMovieid()).getName().toUpperCase()}</h5>
       <h5 class="card-title mt-2" style="padding-left: 10%;">Theatre name:- ${TheatreMap.get(v.getTheatreid()).getName().toUpperCase()}</h5>   
       <h5 class="card-title mt-2" style="padding-left: 10%;">Theatre Location:- ${TheatreMap.get(v.getTheatreid()).getLocation().toUpperCase()}</h5>
       <h5 class="card-title mt-2" style="padding-left: 10%;">Date:- ${v.getDateofbooking()}</h5>
       <h5 class="card-title mt-2" style="padding-left: 10%;">Seats:- ${seatMap.get(v.getId())}</h5>
       <h5 class="card-title mt-2" style="padding-left: 10%;">TIme:- ${uniqueshows.get(v.getShowid()).getStarttime()}</h5>
      </div>
    </div>
  </c:forEach>
</div>




</body>
</html>