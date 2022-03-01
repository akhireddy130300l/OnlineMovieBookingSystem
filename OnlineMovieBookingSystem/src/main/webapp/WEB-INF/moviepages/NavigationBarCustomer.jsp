<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-2">
 <!--  <a class="navbar-brand px-3 pl-3 text-white" href="#">BookaTicket</a> -->
  <a class="navbar-brand px-3 pl-3 text-white" href="#"><img STYLE="height: 35px;width: 100px;" src="<c:url value="/resources/images/Logo.png"/>"/></a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link px-3 text-white" href="navigationBarCustomer">Home</a>
      <a class="nav-item nav-link px-3 text-white" href="selectlocation">Change Location</a>
      <a class="nav-item nav-link px-3 text-white" href="customerProfile">My Profile</a>
      <a class="nav-item nav-link px-3 text-white" href="mybookings/${Logininfo.getId()}">My Bookings</a>
      <a class="nav-item nav-link px-3 text-white" href="endsession" style="float: right;">Logout</a>
    </div>
  </div>
</nav>