<%@ page import="ec2_device_manager.DeleteInstances"%>
<%@ page import="connection.Instance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	DeleteInstances d = new DeleteInstances();
	d.deleteInstances(request.getParameter("id"),request.getParameter("location"));
	
%>
<jsp:forward page="/home.jsp" />
