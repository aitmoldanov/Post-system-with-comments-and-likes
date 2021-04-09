<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin Login Page</title>
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Google Fonts -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<!-- Bootstrap core CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">

	<!-- JQuery -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserHome JSP</title>
<style>
body {
	margin: 0px;
	background: url(/images/bg.png) repeat;
}

a {
	list-style: none;
	'
}

#ux-header {
	line-height: 100px;
	min-width: 998px;
	background-color: rgb(40, 40, 40);
	color: rgb(207, 207, 207);
	margin-top: -21px;
}

</style>

</head>
<body>
	<div id="ux-header">
		<h1 align="center">SignUp User</h1>
	</div>
	<div align="center">
		<form action="UserRegisterServlet" method="post">
			<table>
				<tr>
					<td>User Name :</td>
					<td><input type="text" name="form-username" required="true"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="form-password" required="true"></td>
				</tr>
				<tr>
					<td>Confirm Password :</td>
					<td><input type="password" name="confirm-password" required="true"></td>
				</tr>
				<tr>
					<td>Email Id :</td>
					<td><input type="email" name="form-email" required="true"></td>
				</tr>
				<tr>
					<td>Mobile No :</td>
					<td><input type="text" name="form-mobno" required="true" pattern="[0-9.]+"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
