<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="dashboard.css" rel="stylesheet" type="text/css"/>

<title>Bull-Notes "Path of the Bulls"</title>
</head>
<body onload="laodQuotes()">
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
        <c:out value="${quotes}" />
    </div>
</div>
</footer>
<form name="quotesForm" id="quotesForm" action="loadQuotes" method="post">
	<input id="quoteButton" type="submit" value="" />
</form>
<script>
	// this code doesn't seem to trigger anything at all
	function loadQuotes() {
		document.quotesForm.submit();
	}
</script>

<%-- <script>
//this script doesn't work because of CORS
function loadQuotes() {
	var results; 
	var req = new XMLHttpRequest();
	req.open("GET", "http://marketdata.websol.barchart.com/getQuote.json?key=bd933c2d2f7d0545e237ce85a570637c&symbols=iyy%2Cvti%2Cvoo&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate&mode=I", false);
	req.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	req.setRequestHeader("Origin", "http://marketdata.websol.barchart.com/");
	req.onreadystatechange = function() {
	    if (this.readyState === 4) {
	        req.onreadystatechange = null;
	        if (this.status === 200) {
	            results = JSON.parse(this.response);
	        } else {
	            alert(this.statusText);
	        }
	    }
	};
	req.send();
	var html = new Array();
	for (var i = 0; i < results.results.length; i++) {
		switch (results.results[i].symbol) {
			case "VOO": 
				document.getElementById("sp500label").innerHTML = "S&#38;P 500";
				document.getElementById("sp500").innerHTML = results.results[i].lastPrice + " " + results.results[i].netChange;
				break;
			case "IYY":
				document.getElementById("dowlabel").innerHTML = "DOW Jones";
				document.getElementById("dow").innerHTML = results.results[i].lastPrice + " " + results.results[i].netChange;
				break;
			case "VTI":
				document.getElementById("nasdaqlabel").innerHTML = "NASDAQ";
				document.getElementById("nasdaq").innerHTML = results.results[i].lastPrice + " " + results.results[i].netChange;
				break;
			default: break;
		}
	}
}
</script> --%>
</body>
</html>