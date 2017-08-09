<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="org.apache.struts2.dispatcher.HttpParameters"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="createaccount.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"> </script>
<title>Bull-Notes Account Creation</title>
</head>
<body>
<div class="content">
	<div class="title">Create Account</div>
	<h3><s:actionerror /></h3>
	<form action="createAccount" method="post">
	<ul>
	<li>
		<input type="text" name="firstname" class="fname split" placeholder="First Name"/>
		<input type="text" name="lastname" class="lname split" placeholder="Last Name"/>
	</li>
	<li>
		<input type="text" name="username" class="username full" placeholder="Username"/>
	</li>
	<li>
		<input type="password" name="password" class="password split" placeholder="Password"/>
		<input type="password" name="password2" class="compassword split"placeholder="Confirm Password"/>
	</li>
	<li>
		<input type="text" name="email" class="email full" placeholder="Email Address"/>
	</li>
	<li>
		<button type="submit" value="createAccount">Create Account</button>
	</li>
	</ul>
	</form>
	<input type="checkbox" id="rememberMe"/>
	<label for="rememberMe"></label><span>I have read and agree to the <a target="_blank" href="terms.jsp">Terms of Use </a>and <a target="_blank" href="privacy.jsp">Privacy Policy</a></span>
	
</div>	
</body>
</html>