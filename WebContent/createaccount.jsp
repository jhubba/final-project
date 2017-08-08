<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="org.apache.struts2.dispatcher.HttpParameters"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="dashboard.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"> </script>
<title>Bull-Notes Account Creation</title>
</head>
<body>
	<h1>Create a Bull-Notes account by filling out the from below</h1>
	<h3><s:actionerror /></h3>
	<form action="createAccount" method="post">
		<input type="text" name="username" placeholder="Username"/><br>
		<input type="password" name="password" placeholder="Password"/><br>
		<input type="password" name="password2" placeholder="Confirm Password"/><br>
		<input type="text" name="firstname" placeholder="First Name"/><br>
		<input type="text" name="lastname" placeholder="Last Name"/><br>
		<input type="text" name="email" placeholder="Email Address"/><br>
		<button type="submit" value="createAccount">Create Account</button>
	</form>
</body>
</html>