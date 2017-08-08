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
      <li class="active"><a href="/Bull-Notes/">Home</a></li>
<!--       <li><a href="#">Dashboard</a></li> -->
      <li><a href="/Bull-Notes/userprofile.jsp">Watchlist</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/Bull-Notes/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div class="container">
	<div class="row search">
	    <div class="col-sm-8 col-sm-offset-2">
	        <form action="searchSymbol" method="post">
	            <div class="input-group">
	                <input type="text" id="symbol" name="symbol" class="form-control input-lg" placeholder="Search Symbol...">
	                <span class="input-group-btn">
						<button class="btn btn-default btn-lg" type="submit">
							<span class="glyphicon glyphicon-search"></span>
						</button>
	                </span>
	            </div>
	        </form>
	    </div>
	</div><br><br><br><br>
	
	<c:forEach items="${query}" var="quote">
		<c:out value="${quote.symbol}"/> <c:out value="${quote.price}"/>
	</c:forEach>
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