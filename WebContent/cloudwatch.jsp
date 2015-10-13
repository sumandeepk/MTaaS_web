<%@page import="java.util.*"%>
<%@page import="cloudwatch.Monitor"%>
<%@page import="com.amazonaws.services.cloudwatch.model.Datapoint"%>
<%@ page import="cloudwatch.Monitor"%>
<%@ page import="connection.Instance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.5.1.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdn.oesmith.co.uk/morris-0.5.1.min.js"></script>
</head>
<body>
<div id="divname"></div>
<% 
Monitor m = new Monitor(); 
String id = request.getParameter("id");
String location = request.getParameter("location");
String metric = "CPUUtilization";
java.util.List<Datapoint> dataList  = m.monitorInstances(id, location,metric); %>


				<script>
				new Morris.Line({
					  // ID of the element in which to draw the chart.
					  element: 'divname',
					  // Chart data records -- each entry in this array corresponds to a point on
					  
					  // the chart.
					  data: [
					    { Timestamp: '18:55:00', Maximum: 0.16, Minimum:0.0 , Average: 0.066 },
					    { Timestamp: '19:15:00', Maximum: 0.16, Minimum:0.0 , Average: 0.032 },
					    { Timestamp: '19:40:00', Maximum: 0.17, Minimum:0.0 , Average: 0.068 },
					    { Timestamp: '19:05:00', Maximum: 0.16, Minimum:0.0 , Average: 0.032 },
					    { Timestamp: '19:45:00', Maximum: 0.17, Minimum:0.0 , Average: 0.066 }
					  ],

// 					  // The name of the data record attribute that contains x-values.
// 					  xkey: 'year',
// 					  // A list of names of data record attributes that contain y-values.
// 					  ykeys: ['value'],
// 					  // Labels for the ykeys -- will be displayed when you hover over the
// 					  // chart.
// 					  labels: ['Value']
				
				xkey : 'Timestamp',
				ykeys : [ 'Average', 'Maximum' , 'Minimum'],
				labels : [ 'Average CPU' , 'Maximum CPU' , 'Minimum CPU' ],
				parseTime : false,
				ymin : 0,
				postUnits : '%'
					});
				</script>
				
				</body>