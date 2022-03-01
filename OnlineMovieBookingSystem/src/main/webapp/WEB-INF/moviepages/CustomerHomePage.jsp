<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="icon" href="<c:url value="/resources/images/titleLogo.png"/>"/>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/cc8003d83e.js" crossorigin="anonymous"></script>
<style type="text/css">
body{
font-family: 'Roboto', sans-serif;
}
</style>
</head>
<body>
<jsp:include page="NavigationBarCustomer.jsp"></jsp:include>
<div style="color: green;text-align: center;">${ticketbookmsg}</div>
<div style="color: red;text-align: center;">${ticketbookmsgnotdone}</div>
<input name="locationselected" hidden="true" value="${locationselected}"/>

















<div class="row row-cols-1 row-cols-md-2">
<c:forEach var="v" items="${movielistByLocation}">
  <div class="col mb-4">
    <div class="card">
      <img src="getUserImage/<c:out value="${v.getId()}"/>.do" class="card-img-top" alt="..." style="width:100%;height:250px;">
      <div class="card-body">
        <h3 class="card-title" style="margin-left: 20%;">Movie:- ${v.getName().toUpperCase()}</h3>
        <h4 class="card-text" style="margin-left: 20%;">Cast:- ${v.getActors()}</h4>
        <h4 class="card-text mb-3" style="margin-left: 20%;"> Director:- ${v.getDirector()}</h4>
        <a href="theatreSelection/${v.getId()}"><button type="button" class="btn btn-primary mx-auto" style="width:100%;">Select Show</button></a>
      </div>
    </div>
  </div>
</c:forEach>
</div>










<div class="row row-cols-1  row-cols-md-3" style="margin-top: 200px;">
<c:forEach var="v" items="${movielistByLocation}">
    <div class="card mb-5 border border-dark p-2">
      <img src="getUserImage/<c:out value="${v.getId()}"/>.do" class="card-img-top p-2" alt="..." style="width:100%;height:400px;">
      <div class="card-body">
        <h3 class="card-title" style="margin-left: 10%;">Movie:- ${v.getName().toUpperCase()}</h3>
        <h5 class="card-text" style="margin-left: 10%;">Cast:- ${v.getActors()}</h5>
        <h5 class="card-text mb-3" style="margin-left: 10%;">Director:- ${v.getDirector()}</h5>
        <a href="theatreSelection/${v.getId()}"><button type="button" class="btn btn-primary mx-auto" style="width:100%;">Select Show</button></a>
      </div>
    </div>
  </c:forEach>
</div>





<div class="row row-cols-1  row-cols-md-3 " style="margin-top: 200px;">
<c:forEach var="v" items="${movielistByLocation}">
    <div class="card">
    <div class="row no-gutters">
    <div class="col-md-4">
      <img src="getUserImage/<c:out value="${v.getId()}"/>.do" class="card-img" alt="..." style="width:100%;height:100%;">
    </div>
    <div class="col-md-8">
      <div class="card-body">
       <h5 class="card-title">${v.getName()}</h5>
        <p class="card-text">${v.getActors()}</p>
        <p class="card-text">${v.getDirector()}</p>
        <a href="theatreSelection/${v.getId()}"><button type="button" class="btn btn-primary mx-auto" style="width:100%;">Select Show</button></a>
      </div>
    </div>
  </div>
    </div>
  </c:forEach>
</div>


<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>









