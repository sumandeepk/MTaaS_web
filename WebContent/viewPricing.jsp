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

</head>

<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="home.jsp">
                        MTaaS IaaS
                    </a>
                </li>
                <li>
                    <a href="#">Dashboard</a>
                </li>
                <li>
                    <a href="/MTaaS_web/ViewClouds">Clouds Information</a>
                </li>
                <li>
                    <a href="/MTaaS_web/ViewPricing">Price List</a>
                </li>
                <li>
                    <a href="/MTaaS_web/addInstances.jsp">Add Resources</a>
                </li>
                <li>
                    <a href="/MTaaS_web/ManageInstances">Manage Resources</a>
                </li>
                <li>
                    <a href="/MTaaS_web/DeleteInstances">Delete Resources</a>
                </li>
                
                <li>
                    <a href="/MTaaS_web/MonitorInstances">Monitor Resources</a>
                </li>
                <li>
                    <a href="/MTaaS_web/ViewBilling">Billing Information</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
<div><p><strong>Images</strong></p></div>
<table border="1" style="width:100%">
					<tr>
					<td width="20%">Image Id</td>
					<td width="30%">Image Name </td>
					<td width="30%">Cloud Id</td>
					<td width="30%">Cost per minute</td>
					
					</tr>
</table>

		<c:forEach var="image" items="${images}">
			<form id="form1" method="get" action="/billing/ViewPricing">

				<table border="1" style="width:100%">
					<tr>
						<td width="20%"><c:out value="${image.imageId}" /></td>
						<td width="30%"><c:out value="${image.imageName}" /></td>
						<td width="30%"><c:out value="${image.cloudId}" /></td>
						<td width="30%"><c:out value="${image.cost}" /></td>
						
					</tr>
				</table>
			</form>
		</c:forEach>
		
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