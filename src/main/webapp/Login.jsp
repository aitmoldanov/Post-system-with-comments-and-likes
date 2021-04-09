<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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

<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User SignIn</title>

<!--STYLESHEETS-->
<link href="css/style.css" rel="stylesheet" type="text/css" />

<!--SCRIPTS-->
<!-- <script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script> -->
	
<script type="text/javascript" src="js/jquery.min.js"> </script>
<!--Slider-in icons-->
<script type="text/javascript">
	$(document).ready(function() {
		$(".username").focus(function() {
			$(".user-icon").css("left", "-48px");
		});
		$(".username").blur(function() {
			$(".user-icon").css("left", "0px");
		});

		$(".password").focus(function() {
			$(".pass-icon").css("left", "-48px");
		});
		$(".password").blur(function() {
			$(".pass-icon").css("left", "0px");
		});
	});
</script>

</head>
<body>

	<!--WRAPPER-->
	<div id="wrapper">

		<!--SLIDE-IN ICONS-->
		<div class="user-icon"></div>
		<div class="pass-icon"></div>
		<!--END SLIDE-IN ICONS-->

		<!--LOGIN FORM-->
		<form name="login-form" class="login-form" action="LoginServlet" method="post">
			<!--HEADER-->
			<div class="header">
				<!--TITLE-->
				<h1>User SignIn</h1>
				<!--END TITLE-->
				<!--DESCRIPTION-->
				<span>Fill out the form below to login to User Control panel.</span>
				<!--END DESCRIPTION-->
			</div>
			<!--END HEADER-->

			<!--CONTENT-->
		
			<div class="content">
				<!--USERNAME-->
				<input name="form-username" type="text" class="input username"
					value="Username" onfocus="this.value=''" required="true"/>
				<!--END USERNAME-->
				<!--PASSWORD-->
				<input name="form-password" type="password" class="input password"
					value="Password" onfocus="this.value=''" required="true"/>
				<!--END PASSWORD-->
			</div>
			<!--END CONTENT-->

			<!--FOOTER-->
			<div class="footer">
				<!--LOGIN BUTTON-->
				<input type="submit" name="submit" value="Login" class="button" />
				<!--END LOGIN BUTTON-->
				<!--REGISTER BUTTON-->
				<!-- <input type="submit" name="submit" value="Register" class="register" /><br> -->
				<a href="SignUp.jsp" class="register" style="text-decoration: none;">Register</a>
				<!--END REGISTER BUTTON-->
			</div>
			<!--END FOOTER-->
		</form>
		<!--END LOGIN FORM-->
	</div>
	<!--END WRAPPER-->

	<!--GRADIENT-->
	<div class="gradient"></div>
	<!--END GRADIENT-->

</body>
</html>
