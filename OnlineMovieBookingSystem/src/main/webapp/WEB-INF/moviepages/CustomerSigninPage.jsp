<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
	




</head>
<body>

<div class="text-center">
		<form method="POST" action="Signincheck" style="max-width:400px;margin:auto;margin-top:120px;border:2px solid black;padding:40px;padding-top:0;">
		<h1 class="h3 font-weight-normal">Sign In</h1>
		<hr style="border:1px solid black;"/>
		<input  class="form-control mt-2 mb-3" id="userinputname" type="text" name="userSigninName" placeholder="Username" required autofocus autocomplete="off"/>
		<input  class="form-control mt-2 mb-3" id="userinputemail" type="email" name="userSigninEmail" placeholder="Email Address" required autofocus autocomplete="off"/>
		
		<input  class="form-control mt-2 mb-3" id="userinputephone" type="text" name="userSigninPhoneno" pattern="[7-9]{1}[0-9]{9}" title="10 Digit Number starting with 7/8/9 " placeholder="Phone Number" required autofocus autocomplete="off"/>
		
		<input type="password" name="userpassword" id="userinputpassword" class="form-control mt-1 mb-3" placeholder="Password" required autofocus autocomplete="off"/>
		<input type="password" name="confirmuserpassword" id="confirmuserpassword" class="form-control mt-1 mb-3" placeholder="Confirm Password" required autofocus autocomplete="off"/>
		<div class="checkbox mb-3">
		
		
		</div>
		<input class="btn btn-lg btn-dark btn-block" id="signinbutton" type="submit" value="SignIn" style="width:100%;"/>
		
		<div class="mt-3">Already customer? <a href="Login">Login in</a></div>
		</form>
	</div>

</body>
</html>