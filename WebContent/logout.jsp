<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="3;url=/Bull-Notes/" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="dashboard.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"> </script>
<title>Bull-Notes "path of the Bulls"</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/Bull-Notes/">BullNotes</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/Bull-Notes/">Home</a></li>
    </ul>
  </div>
</nav>
<div class="goodbye">
	<h2>You have successfully logged out.</h2>
</div>
<footer class="bottom-footer">
<div class="container-fluid">
	<div class="row">
		<jsp:useBean id="quotes" class="controllers.StaticSymbolsAction" />
		<jsp:getProperty name="quotes" property="sym" /> 
	</div>
</div>
</footer>
</body>
</html>