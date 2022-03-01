<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	  <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link rel="icon" href="<c:url value="/resources/images/titleLogo.png"/>"/>
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
height: 420px;
}
</style>
</head>
<body>

<div class="text-center">
		<form method="POST" action="changePasswordInDB">
		<h1 class="h3 font-weight-normal mt-4">CHANGE PASSWORD</h1>
		<hr class="mb-4" style="border:1px solid #000;"/>
		<input hidden="true" name="cusId" value="${Logininfo.getId()}"/>
		
		<input type="password" name="newPassword" id="userinputpassword" class="form-control mt-1 mb-4" placeholder="New Password"/>
		
		<input type="password" name="reenterNewPassword" id="userinputpassword" class="form-control mt-1 mb-4" placeholder="Re-enter Password"/>
		<div class="text-danger mb-3">${errormsg}</div>

		<input class="btn btn-lg btn-success btn-block" type="submit" value="Change" style="width:100%;"/>

		</form>
	</div>
</body>
</html>