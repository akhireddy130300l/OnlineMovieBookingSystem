<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer Profile</title>
<link rel="icon" href="<c:url value="/resources/images/titleLogo.png"/>"/>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	<script src="https://kit.fontawesome.com/cc8003d83e.js" crossorigin="anonymous"></script>
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
height: 320px;
}
	</style>
</head>
<body>
<jsp:include page="NavigationBarCustomer.jsp"></jsp:include>
<div class="text-center">
		<form method="POST" action="editProfileToDB">
			<h1 class="h3 font-weight-normal mt-4">EDIT PROFILE</h1>
		<hr style="border:1px solid black;"/>
		<input  name="customerId" type="number" value="${Logininfo.getId()}" hidden="true"/>
		
		<input  class="form-control mt-2 mb-4" id="newName" type="text" name="newName" placeholder="New Name" required autofocus autocomplete="off" value="${Logininfo.getName()}"/>
		
		<input  class="form-control mt-2 mb-4" id="newPhoneNumber" type="text" name="newPhoneNumber" pattern="[7-9]{1}[0-9]{9}" title="10 Digit Number starting with 7/8/9 " placeholder="Phone Number" required autofocus autocomplete="off" value="${Logininfo.getPhoneno()}"/>
			<input class="btn btn-lg btn-success btn-block" type="submit" value="Edit" style="width:100%;"/>
		</form>
	</div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>