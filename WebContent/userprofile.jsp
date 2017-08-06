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
<form action='UserProfileAction' method='post'>
	<h2>Select a WatchList </h2>
	<select name='watchList'>
		<c:forEach items="${session.watchLists.getWatchlists()}" var="item">
		<option value="${item.getWatchListName()}" selected>${item.getWatchListName()}</option>	
		</c:forEach>	
	</select>
</form>


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