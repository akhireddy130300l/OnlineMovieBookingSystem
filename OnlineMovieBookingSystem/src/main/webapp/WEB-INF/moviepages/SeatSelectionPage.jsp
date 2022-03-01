<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seat Selection Page</title>
<link href="  <c:url value="/resources/css/style.css"/>   ">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" /> 
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<style type="text/css">
	input[type="checkbox"] {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;

  /* Styling checkbox */
  width: 16px;
  height: 16px;
  background-color:#dbd7d7;
}

input[type="checkbox"]:checked {
  background-color:#00ff37;
}

	body{
background-image: url("<c:url value="/resources/images/background1.jpg"/>");
}
	</style>
	
	
	
<script type="text/javascript">
/* $(document).ready(function(){
    $("form").submit(function(){
		if ($('input:checkbox').filter(':checked').length < 1){
        alert("Check at least one seat!");
		return false;
		}
    });
}); */

function fun()
{
	/* var checkbox = document.getElementsByName("seatsselected").length;
	var disabled = document.getElementsByName("seatsselected:disabled").length;
	alert(checkbox);
	return false; */
	
	const values = Array
	  .from(document.querySelectorAll('input[type="checkbox"]'))
	  .filter((checkbox) => checkbox.checked)
	  .map((checkbox) => checkbox.value);
	var valuesasstring  = JSON.stringify(values);
	var valuearraylength = valuesasstring.split(",").length;
	if(valuearraylength==1)
		{
		alert("Select Atleast 1 seat");
		return false;
		}
	else if(valuearraylength>=6)
		{
		alert("Maximum of 4 seats can be selected");
		return false;
		}
	else
		{
		return true;
		}
	
	
}

</script>	
</head>
<body>

<form action="../../bookseats" method="POST">
<div style="background-color:white;;margin: 10% 10% 30px 10%; margin-top: 15px; border: 2px solid black; padding: 10px; padding-top: 0;">
<h1 class="h3 font-weight-normal mt-3" style="text-align: center; font-size: 30px;">SELECT SEATS</h1>


<div class="mt-3" style="margin-left:32%;">

<span style="margin-right: 40px;">
<input type="checkbox" class="mx-1 border border-dark" id="btn-check-outlined"  value="${v.getId()}" autocomplete="off" disabled="disabled" style="background-color: red;">
<label  for="btn-check-outlined" style="margin-right:5px;font-weight: 500;">Booked</label>
</span>



<span style="margin-right: 40px;">
<input type="checkbox" class="mx-1 border border-dark" id="btn-check-outlined"  value="${v.getId()}" autocomplete="off" disabled="disabled">
<label  for="btn-check-outlined" style="margin-right:5px;font-weight: 500;">Available</label>
</span>


<span style="margin-right: 40px;">
<input type="checkbox" class="mx-1 border border-dark" id="btn-check-outlined"  value="${v.getId()}" autocomplete="off" disabled="disabled" checked="checked">
<label  for="btn-check-outlined" style="margin-right:5px;font-weight: 500;">Selected</label>
</span>

<div>${errormsg}</div>

</div>


		<hr style="border:1px solid black;"/>
<input name="movieId" value="${movieId}" hidden="true"/>
<input name="sId" value="${sId}" hidden="true"/>
<input name="movieIdbyShowId" value="${movieIdbyShowId}" hidden="true"/>
<input name="theatrebyShowId" value="${theatrebyShowId}" hidden="true"/>
<input name="seatsByTheatre" value="${seatsByTheatre}" hidden="true"/>
<input  name="noofSeatsPerrow" value="${noofSeatsPerrow}" hidden="true"/>
<p hidden="true">${theatrebyShowId.getNoofseats()}</p>
<div style="margin-top:50px;margin-left:3%;">



<%-- <c:forEach var="v" items="${seatsByTheatre}">


<input type="checkbox" class="mx-1 border border-dark" id="btn-check-outlined" name="seatsselected" value="${v.getId()}" autocomplete="off">
<label  for="btn-check-outlined" style="margin-right:5px;font-weight: 500;">${v.getSeatno()}</label>
<c:if test="${v.getSeatno()==noofSeatsPerrow}"> <span style="margin:6px 6px 6px 20px;font-weight: 900;font-size: 20px;">${v.getSeatrow()}</span> <br/>
<div style="margin:6px;"></div>
</c:if>

</c:forEach> --%>








<c:forEach  var="v" items="${seatsByTheatre}">


<c:choose>
<c:when test="${bookedseatids.contains(v.getId())}">

<input type="checkbox" class="mx-1 border border-dark" id="btn-check-outlined" name="seatsselected" value="${v.getId()}" autocomplete="off" disabled="disabled" style="background-color: red;">
<label  for="btn-check-outlined" style="margin-right:5px;font-weight: 500;">${v.getSeatno()}</label>

</c:when>

<c:otherwise>
<input type="checkbox" class="mx-1 border border-dark" id="btn-check-outlined" name="seatsselected" value="${v.getId()}" autocomplete="off">
<label  for="btn-check-outlined" style="margin-right:5px;font-weight: 500;">${v.getSeatno()}</label>
</c:otherwise>
</c:choose>

<c:if test="${v.getSeatno()==noofSeatsPerrow}"> <span style="margin:6px 6px 6px 20px;font-weight: 900;font-size: 20px;">${v.getSeatrow()}</span> <br/>
<div style="margin:6px;"></div>
</c:if>

</c:forEach>





</div>



<div style="border:3px solid black;width:70%;margin:50px 15% 20px 15%;color:black;text-align: center;"> Screen will be here</div>




</div>
<input class="btn btn-primary border border-dark w-75 btn-lg" style="margin-left:13%; margin-bottom: 100px;" type="submit" value="Next" onclick="return fun()"/>
</form>

</body>
</html>