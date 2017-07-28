<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="dashboard.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"> </script>
<title>Bull-Notes "path of the Bulls"</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BullNotes</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Dashboard</a></li>
      <li><a href="#">Watchlist</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<footer class="bottom-footer">
<div class="container-fluid"> 
     <div class="row">
          <div class="col-sm-4">
                <span class="label label-default"> DOW</span>
                <span name="dow" class="">DATA</span>
                </div>
                <div class="col-sm-4">
                    <span class="label label-default">NASDAQ</span>
                    <span name="nasdaq" class="">DATA</span>
                </div>
                <div class="col-sm-4">
                    <span class="label label-default">S&#38;P 500</span>
                    <span name="sp500" class="">DATA</span>
                </div>
            </div>
        </div>
</footer>
</body>
</html>