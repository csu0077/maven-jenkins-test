<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee Page</title>
<style>
body {
	background-color: powderblue;
}
</style>
</head>

<body>
	<h1>Hello, this is the Employee Page</h1>
	
	<div>
		${Sess_username}
		<br>
		<form action="ViewOwnRequestsServlet">
			<input type="submit" value="View pending requests" />
		</form>
		<br>
		<form action="ViewClosedReimbsServlet">
			<input type="submit" value="View resolved requests" />
		</form>
		<br>
		<form action="ViewInfoServlet">
			<input type="submit" value="View your information" />
		</form>
		<br>
		<form action="Login.html">
			<input type="submit" value="Logout" />
		</form>
		<div id="demo">
			<h2>Update Info</h2>
			<button type="button" onclick="loadDoc()">Change Content</button>
		</div>
		<div id="demo2">
			<h2>Open Reimbursement</h2>
			<button type="button" onclick="loadForm()">Change1 Content</button>
		</div>
	</div>
	
	<script>
	function loadDoc() {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("demo").innerHTML =
		      this.responseText;
		    }
		  };
		  xhttp.open("GET", "UpdateInfo.html", true);
		  xhttp.send();
		}
	</script>
	<script>
	function loadForm() {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("demo2").innerHTML =
		      this.responseText;
		    }
		  };
		  xhttp.open("GET", "OpenReimbursement.html", true);
		  xhttp.send();
		}
	</script>
	
</body>