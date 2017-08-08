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
  </div>
</nav>

<c:out value="Welcome: ${session.user}"/> <br>
<br>
<form action='loadWatchList' method='post'>
	<h2>Select a WatchList </h2>
	<select name='watchlistName' id="watchlist" onchange="this.form.submit()">
		<option value="default" selected>Select a watch list</option>
		<c:forEach items="${session.watchLists.getWatchlists()}" var="item">
		<option value="${item.getWatchListName().toString()}">${item.getWatchListName()}</option>	
		</c:forEach>	
	</select>
</form>


<s:set var="cwl" value="watchlistName"></s:set>

Current Watch List: <s:property value="cwl"/><br>

<s:if test="%{#cwl != null}">
<table style="border-collapse: separate; border-spacing: 10px;">
	    <tr>
			<th>Name</th>
			<th>Symbol</th>
			<th>Price</th>
			<th>Change</th>
			<th>Percent Change</th>
			<th>Volume</th>
			<th>Open</th>
			<th>High</th>
			<th>Low</th>
		</tr>
			<c:forEach items="${getTheQuotes}" var="quote">
				<tr>			
					<td><c:out value="${quote.name}"/></td>
					<td><c:out value="${quote.symbol}"/></td>
					<td><c:out value="${quote.price}"/></td>
					<td><c:out value="${quote.change}"/></td>
					<td><c:out value="${quote.percentChange}"/></td>
					<td><c:out value="${quote.volume}"/></td>
					<td><c:out value="${quote.open}"/></td>
					<td><c:out value="${quote.high}"/></td>
					<td><c:out value="${quote.low}"/></td>    
			    
				</tr>
			</c:forEach>	
	</table>	
</s:if>


<footer class="bottom-footer">
<div class="container-fluid"> 
     <div class="row">
          <div class="col-sm-4">
                <jsp:useBean id="quotes" class="controllers.StaticSymbolsAction" />
				<jsp:getProperty name="quotes" property="sym" /> 
           </div>
     </div>
</div>
</footer>
</body>
</html>