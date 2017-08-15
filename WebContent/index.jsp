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
<div class="content">
<c:if test="${param.user != null}">
	<c:set var="user" value="${param.user}" scope="session"></c:set>
</c:if>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/Bull-Notes/">BullNotes</a>
    </div>   
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="/Bull-Notes/">Home</a></li>
	      <c:if test="${user != null}" >
	      	<li><a href="/Bull-Notes/userprofile.jsp">Watchlist</a></li>	
	      </c:if>	      	
	    </ul>  
    <ul class="nav navbar-nav navbar-right">
		<c:choose>
    		<c:when test="${user != null}">
    			<c:set var="user" value="${null}" scope="session"></c:set>
    			<li><a href="/Bull-Notes/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    		</c:when>
    		<c:otherwise>
    			<li><a href="/Bull-Notes/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    		</c:otherwise>
    	</c:choose>
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
						<button class="btn btn-success btn-lg" type="submit">
							<span class="glyphicon glyphicon-search"></span>
						</button>
	                </span>
	            </div>
	        </form>
	    </div>
	</div><br><br>
	
	<c:set var="query" value="${query}"/>
	<c:if test="${ not empty query }">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="col-md-2"></div>
			<div class="col-md-5">
				<span class="queryName"><c:out value="${ query.name }" /></span> 
				(<c:out value="${ query.exchange }" />:<c:out value="${ query.symbol }" />)
				<br><span class="lastPrice"><c:out value="${ query.lastPrice }" /></span> 
				<c:choose>
					<c:when test="${ query.netChange > 0 }">
						<span class="positive"><c:out value="${ query.netChange }" /> (<c:out value="${ query.percentChange }" />)</span>
					</c:when>
					<c:when test="${ query.netChange < 0 }">
						<span class="negative"><c:out value="${ query.netChange }" /> (<c:out value="${ query.percentChange }" />)</span>
					</c:when>
					<c:otherwise>
						<span class="neutral"><c:out value="${ query.netChange }" /> (<c:out value="${ query.percentChange }" />)</span>
					</c:otherwise>
				</c:choose>
				<br><span class="details">Quote Time: <c:out value="${ query.tradeTimestamp }" /></span>
				<br><span class="details"><c:out value="${ query.exchange }" /> real-time data.</span>
				<br><span class="details">Currency in USD.</span>
			</div>
			<div class="col-md-3">
				<br><span class="moreinfo">Range: <c:out value="${ query.low }" /> - <c:out value="${ query.high }" />
				<br>52 Week: <c:out value="${ query.fiftyTwoWkLow }" /> - <c:out value="${ query.fiftyTwoWkHigh }" />
				<br>Open: <c:out value="${ query.open }" />
				<br>Volume: <c:out value="${ query.volume }" /></span>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
	</c:if>
	
	
</div>
<footer class="bottom-footer">
<div class="container-fluid">
     <div class="row">
                <jsp:useBean id="quotes" class="controllers.StaticSymbolsAction" />
				<jsp:getProperty name="quotes" property="sym" /> 
     </div>
</div>
</footer>
</div>
</body>
</html>