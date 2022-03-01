<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="icon" href="<c:url value="/resources/images/titleLogo.png"/>"/>
<link href="  <c:url value="/resources/css/style.css"/>   ">
<script type="text/javascript" src="  <c:url value="/resources/js/script.js"/>   "></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
	
	
	
 	
<script>
function changepasswordtype() {
	  var x = document.getElementById("userinputpassword");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
	
</script> 

<style type="text/css">
body{
background-image: url("<c:url value="/resources/images/background1.jpg"/>");
}
form{
background-color:#FFFFFF;
max-width:700px;
margin:auto;
margin-top:170px;
border:3px solid black;
padding:40px;
padding-top:0;
height: 460px;
}
#signinLink{
text-decoration: none;
}
</style>



</head>
<body>
	<div class="text-center">
		<form method="POST" action="logincheck">
		<h1 class="h3 font-weight-normal pt-3">Login</h1>
		<hr style="border:1px solid black;" class="mb-3"/>
		<input  class="form-control mt-2 mb-4" id="userinputfield" type="email" name="userEmail" placeholder="Email Address" required autofocus autocomplete="off"/>
		<input type="password" name="userpassword" id="userinputpassword" class="form-control mt-1 mb-4" placeholder="Password"/>
		<div class="checkbox mb-3">
		<input type="checkbox" value="show Password" id="checkboxelement" onclick="changepasswordtype()"/>  Show Password
		</div>
		<input class="btn btn-lg btn-success btn-block pb-3 mb-3" type="submit" value="Login" style="width:100%;"/>
		<%String LoginFailString  =(String)request.getAttribute("LoginFailMessage"); %>
		
		<div class="alert alert-danger mt-2" role="alert"><%=LoginFailString %></div>
		
		<div class="mt-3">Not a Registered User? <a href="SignIn" id="signinLink">Sign in</a></div>
		</form>
	</div>


</body>
</html>