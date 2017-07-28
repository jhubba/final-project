<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.Action"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  		  <input type="checkbox" id="rememberMe"/>
		  <label for="rememberMe"></label><span>I have read and agree to the <a href="#">Terms of Use </a>and <a href="#">Privacy Policy</a></span>
  	<div class="already">Need to sign up? <a href="#">CreateAccount</a></div>
</div>
</body>
</html>