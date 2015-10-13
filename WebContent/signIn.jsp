


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>MTaaS IaaS</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Load jQuery and the validate plugin -->
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

<!-- jQuery Form Validation code -->
<script>
	// When the browser is ready...
	$(function() {

		// Setup form validation on the #register-form element
		$("#signInForm")
				.validate(
						{

							// Specify the validation rules
							rules : {

								email : {
									required : true,
									email : true
								},
								password : {
									required : true,
									minlength : 3
								}

							},

							// Specify the validation error messages
							messages : {

								password : {
									required : "Please provide a password",
									minlength : "Your password must be at least 3 characters long"
								},
								email : "Please enter a valid email address"

							},

							submitHandler : function(form) {
								form.submit();
							}
						});

	});
</script>

</head>

<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div>
							<p>
								<strong>Images</strong>
							</p>
						</div>
						<form id="signInForm" method="post" action="SignIn">
							<table>
								<tr>
									<td>Email</td>
									<td><input type="text" name="email" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="password" /></td>
								</tr>
								<tr>
									<td></td>
									<td><input class="submit" type="submit" value="Submit"></td>
								</tr>
							</table>


						</form>

					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>

</html>