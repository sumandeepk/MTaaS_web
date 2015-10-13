<%@ page import="ec2_device_manager.StopInstances"%>
<%@ page import="connection.Instance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
StopInstances stop = new StopInstances();
stop.stopInstances(request.getParameter("id"),request.getParameter("location"));
	
%>
<jsp:forward page="/home.jsp" />
