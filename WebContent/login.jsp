<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.Action"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="loginpage.css" rel="stylesheet" type="text/css">
<title>Welcome to Bull Notes</title>
</head>
<body>
<div class="content">
	<div class="title">Sign in</div>
	<s:actionerror />
	<form action="login" method="post">
		  <input type="text" name="username" placeholder="Username"/>
		  <input type="password" name="password" placeholder="Password"/>
		  <button type="submit" value="login">Sign In</button>
	</form>
    	<div class="already">Need to sign up? <a href="createaccount.jsp">CreateAccount</a></div>
    	<div class="goback"><a href="index.jsp">Return back as guest</a></div>
</div>
</body>
</html>
