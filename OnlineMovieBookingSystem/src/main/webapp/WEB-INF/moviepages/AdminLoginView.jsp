<%@page import="com.moviebooking.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ page import="com.moviebooking.bean.*" %>
      <%@ page import="java.util.*" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<jsp:include page="Bootstrap.jsp"></jsp:include>
<title>AdminLoginView</title>

</head>
<body>
<%-- <%Admin admin =(Admin) request.getAttribute("Admin"); %> --%>
<%-- <h1 class="text-center">Welcome Admin <%=admin.getName() %></h1> --%>


<jsp:include page="NavigationBar.jsp"></jsp:include>

<h2 class="text-center">Latest Movies</h2>
<div class="row row-cols-1  row-cols-md-3" style="margin-top: 10px;">
<c:forEach var="v" items="${latestmovies}">
    <div class="card mb-5 border border-dark p-2 my-3">
      <img src="getUserImage/<c:out value="${v.getId()}"/>.do" class="card-img-top p-2" alt="..." style="width:100%;height:400px;">
      <div class="card-body">
        <h3 class="card-title" style="margin-left: 10%;">Movie:- ${v.getName().toUpperCase()}</h3>
        <h5 class="card-text" style="margin-left: 10%;">Cast:- ${v.getActors()}</h5>
        <h5 class="card-text mb-3" style="margin-left: 10%;">Director:- ${v.getDirector()}</h5>
      </div>
    </div>
  </c:forEach>
</div>








 <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" style="height:500px;">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
  <c:forEach var="v" items="${latestmovies}" varStatus="p">
  
 <c:choose>
 <c:when test="${p.count==1}">
 <div class="carousel-item active">
      <img src="getUserImage/<c:out value="${v.getId()}"/>.do" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h3>${v.getName()}</h3>
        <p>${v.getDirector()}</p>
      </div>
    </div>
 </c:when>
 <c:otherwise>
 <div class="carousel-item">
      <img src="getUserImage/<c:out value="${v.getId()}"/>.do" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h3>${v.getName()}</h3>
        <p>${v.getDirector()}</p>
      </div>
    </div>
 </c:otherwise>
 </c:choose>
  </c:forEach>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>














<div class="text-center pt-4" hidden="true">
<div class="row">
    <div class="col-sm" ><a href="addMovie"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Add Movie</button></a></div>
    <div class="col-sm" ><a href="removeMovie"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Remove Movie</button></a></div>
    <div class="col-sm" ><a href="showMovies"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Show All Movies</button></a></div>
  </div>  
</div>

<div class="text-center pt-4" hidden="true">
<div class="row">
    <div class="col-sm" ><a href="addTheatre"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Add Theatre</button></a></div>
    <div class="col-sm" ><a href="removeTheatre"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Remove Theatre</button></a></div>
    <div class="col-sm" ><a href="showTheatre"><button type="button" class="btn btn-primary btn-lg" style="width:90%;"> Show All Theatres</button></a></div>
  </div>  
</div>

<div class="text-center pt-4" hidden="true">
<div class="row">
    <div class="col-sm" ><a href="addShow"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Add Show</button></a></div>
    <div class="col-sm" ><a href="removeShow"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Remove Show</button></a></div>
    <div class="col-sm" ><a href="updateShow"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">Update Show</button></a></div>
    <div class="col-sm" ><a href="showAllShows"><button type="button" class="btn btn-primary btn-lg" style="width:90%;">All Shows</button></a></div>
  </div>  
</div>

<div class="text-center pt-4">
<div class="row">

  </div>  
</div>

<%-- <p>${Logininfo}</p> --%>
</body>
</html>