<%@ page import="SQS.RequestGenerator"%>
<%@ page import="connection.DatabaseConnection"%>
<%@ page import="connection.Request"%>
<%@ page import="loadBalancer.AntColonyOptimizer"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

String requestType = "staticRequest";
RequestGenerator g = new RequestGenerator();

DatabaseConnection db = new DatabaseConnection();
Request[] requests = db.getRequests();

System.out.println("requests:"+ requests.length);

	g.sendRequest(requests,requestType);
	
	 for(int i=0 ;i<requests.length;i++){
		 //System.out.println("user id "+ requests[i].getUserId() );
        	AntColonyOptimizer o = new AntColonyOptimizer();
        	o.antColonyRequestProcesor(requests[i]);
        }

	
%>
<jsp:forward page="/dashboard.jsp" />