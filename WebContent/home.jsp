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
                        <h1>Testing on Cloud</h1>
                        <p>A mobile TaaS Infrastructure Service System to allow users to submit on-demand service requests for mobile TaaS resources to perform their desirable a mobile testing infrastructure.
Here we have
 - Developed simulated mobile service request loader using Amazon SQS
 - Developed resource provision and management Engine using Ant colony algorithm.
 - Developed mobile service monitor with Dashboard using Amazon CloudWatch.
 - Developed Service billing component.</p>
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