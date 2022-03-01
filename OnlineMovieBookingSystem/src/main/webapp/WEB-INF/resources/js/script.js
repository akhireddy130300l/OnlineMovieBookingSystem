/**
 * 
 */
 
 function changepasswordtype() {
	  var x = document.getElementById("userinputpassword");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
	
function disabletoenable(){
 document.getElementById("userSigninName").removeAttribute("disabled");
}