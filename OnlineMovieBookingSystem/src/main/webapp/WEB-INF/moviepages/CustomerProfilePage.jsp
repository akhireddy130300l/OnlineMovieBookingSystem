<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Profile</title>
<script type="text/javascript" src="  <c:url value="/resources/js/script.js"/>   "></script>
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

#maindiv{
 background-color:#ffffff;
 max-width: 600px;
  margin: auto; 
 margin-top: 80px;
  border: 3px solid black; 
 padding: 40px;
  padding-top: 0;
}
	</style>
	
</head>
<body>
<jsp:include page="NavigationBarCustomer.jsp"></jsp:include>
<div class="text-center">
		<div id="maindiv">
			<h1 class="h3 font-weight-normal mt-4">Customer Profile</h1>
		<hr style="border:1px solid black;"/>
		<label for="userSigninName" class="fw-bold fs-5">Name : </label>
		   <input class="form-control mt-2 mb-3" id="userSigninName" name="userSigninName" value="${Logininfo.getName()}" disabled/>
		   
		   
		   <label for="userSigninEmail" class="fw-bold fs-5">Email : </label>
		    <input class="form-control mt-2 mb-3" name="userSigninEmail" value="${Logininfo.getEmail()}" disabled/>
		    
		    
		<label for="userSigninPhoneno" class="fw-bold fs-5">Mobile Number : </label> 	
			<input class="form-control mt-2 mb-3" id="userSigninPhoneno" name="userSigninPhoneno" value="${Logininfo.getPhoneno()} " disabled/>
			
			<a href="editProfile"><button class="btn btn-lg btn-success btn-block mt-3" style="width:100%;">Edit Profile</button></a>
		  	<a href="changePassword"><button class="btn btn-lg btn-success btn-block mt-4" style="width:100%;">Change Password</button></a>
		  	
		</div>
	</div>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>