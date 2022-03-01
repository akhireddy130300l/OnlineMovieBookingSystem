<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
     <%@ page isELIgnored="false" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TicketDisplayPage</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

<jsp:include page="NavigationBarCustomer.jsp"></jsp:include>
<div class="text-center">

<input name="movieId" value="${movieId}" hidden="true"/>
<input name="sId" value="${sId}" hidden="true"/>
<input name="movieIdbyShowId" value="${movieIdbyShowId}" hidden="true"/>
<input name="theatrebyShowId" value="${theatrebyShowId}" hidden="true"/>
<input name="seatsByTheatre" value="${seatsByTheatre}" hidden="true"/>
<input  name="noofSeatsPerrow" value="${noofSeatsPerrow}" hidden="true"/>
<p hidden="true">${theatrebyShowId.getNoofseats()}</p>
		<form method="POST" action="makePayment" enctype="multipart/form-data"
			style="max-width: 600px; margin: auto; margin-top: 150px; border: 2px solid black; padding: 40px; padding-top: 0;">
			<h1 class="h3 font-weight-normal">Ticket details</h1>
		<hr style="border:1px solid black;"/>
		
		
		<input name="movie" value="${movie.getId()}" hidden="true"/>
		<input name="theatre" value="${theatre.getId()}" hidden="true">	
		<input name="show" value="${show.getId()}" hidden="true">
		<input name="customerid" value="${Logininfo.getId()}" hidden="true">
		<input name="seatnumbers" value="${seatnumbers}" hidden="true"> 
		<input name="totalPrice" value="${totalPrice}" hidden="true">
		<input name="date" value="${date}" hidden="true">
		
		
		<h4>MovieName : ${movie.getName()}</h4>
		<h4>Theatre Name: ${theatre.getName()}</h4>
		<h4>Theatre Location : ${theatre.getLocation()}</h4>
		<h4>Date :- ${date}</h4>
		<h4>Start Time : ${show.getStarttime()}</h4>
		<span style="font-weight: 500;font-size: 24px;">Seats:- </span>
		<c:forEach var="v" items="${seatName}">
		<span style="font-weight: 500;font-size: 24px;">${v}</span>
		</c:forEach>
		<h4>Price : ${totalPrice}</h4>
			<input class="btn btn-lg btn-dark btn-block mt-4" type="submit" value="Make Payment" style="width:90%;"/>
			<div>${ticketbookmsg}</div>
			</form>
	</div>
</body>
</html>