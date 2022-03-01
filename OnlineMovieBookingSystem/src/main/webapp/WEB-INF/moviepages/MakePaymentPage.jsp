<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
			 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
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

<form method="POST" action="confirmTicket" enctype="multipart/form-data">
			<h1 class="h3 font-weight-normal text-center pt-3">Payment Details</h1>
		<hr style="border:1px solid black;"/>
		
		
		<input name="movie" value="${movie}" hidden="true"/>
		<input name="theatre" value="${theatre}" hidden="true">	
		<input name="show" value="${show}" hidden="true">
		<input name="customerid" value="${Logininfo.getId()}" hidden="true">
		<input name="seatnumbers" value="${seatnumbers}" hidden="true"> 
		<input name="totalPrice" value="${totalPrice}" hidden="true">
		<input name="date" value="${date}" hidden="true">
<input  class="form-control mt-2 mb-3" id="cardNumber" type="text" name="cardNumber"  pattern="[0-9]{16}" minlength="16" maxlength="16" title="specify 16 numbers on card" placeholder="Card Number"  required autofocus autocomplete="off"/>
<input  class="form-control mt-2 mb-3" id="cardName" type="text" name="cardName" placeholder="Name As On card" required autofocus autocomplete="off"/>
<input  class="form-control mt-2 mb-3" id="cvv" type="password" name="cvv" placeholder="CVV" pattern="[0-9]{3}" minlength="3" maxlength="3" title="Enter all 3 numbers" required autofocus autocomplete="off"/>

		<input class="btn btn-lg btn-success btn-block mt-4" type="submit" value="Pay" style="width:100%;"/>

			<div>${ticketbookmsg}</div>
			</form>
		
</body>
</html>