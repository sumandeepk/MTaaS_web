<!DOCTYPE html>
<html lang="en">

<head>


<link rel="stylesheet" href="css/morris.css">
 <script src="js/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="js/morris.min.js"></script>

 
 

</head>

<body>
 
	
						<h1>Dashboard</h1>
						
						<table>
							<tr>
								<td><div id="pie-chart_cloud1"></div></td>
								<td><div id="pie-chart_cloud2"></div></td>
								<td><div id="pie-chart_cloud3"></div></td>

							</tr>

						</table>

						
						
					
    
    <script>
    new Morris.Donut({
    	  element: 'pie-chart_cloud1',
    	  data: [
    	    {label: "Used instances", value: 2},
    	    {label: "Abilable instances", value: 3},
    	   
    	  ]
    	});
    
    new Morris.Donut({
  	  element: 'pie-chart_cloud2',
  	  data: [
  	    {label: "Used instances", value: 2},
  	    {label: "Avialable instances", value: 3},
  	    
  	  ]
  	});
    
    new Morris.Donut({
    	  element: 'pie-chart_cloud3',
    	  data: [
    	    {label: "Used instances", value: 1},
    	    {label: "Avialable instances", value: 4},
    	    
    	  ]
    	});
    
    </script>

</body>

</html>