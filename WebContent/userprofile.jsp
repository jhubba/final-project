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
      <a class="navbar-brand" href="/Bull-Notes/">BullNotes</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/Bull-Notes/">Home</a></li>
      <!-- <li><a href="#">Dashboard</a></li> -->
      <li class="active"><a href="/Bull-Notes/userprofile.jsp">Watchlist</a></li>
    </ul>
  </div>
</nav>

<div class="container">
	<c:out value="Welcome: ${session.user}"/> <br>
	<br>
	<form action='loadWatchList' method='post'>
		<h3>Select a WatchList </h3>
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
		<c:forEach items="${getTheQuotes}" var="quote">
			<c:out value="${quote.symbol}"/> <c:out value="${quote.price}"/> <c:out value="${quote.change}"/><br>
		</c:forEach>	
	</s:if>
</div>


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