<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.Action"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>Chat Login Page</title>
</head>
<body>
	<h2>Welcome to Bull Notes</h2>
	<s:actionerror />

	<table>
		<tr>
			<td>
				<form action="login" method="post">
					<label for="username">User Name:</label>
					<input type="text" name="username" /><br />
					<input type="submit" value="login" /><br />
				</form>
			</td>
		</tr>
	</table>
	
</body>
</html>