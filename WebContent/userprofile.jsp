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
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript">
	function setRemoveSymbol(removeSymbol)
	{
        document.myForm.action = "removeQuoteFromWatchList.action";    //First set the form to navigate to the specific action
        $('input[name="removeSymbol"]').val(removeSymbol);
        document.myForm.submit();                             
   		return false;                                         
    }
</script>
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
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/Bull-Notes/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<div class="container">
	<div class="row search">
	    <div class="col-sm-8 col-sm-offset-2">
	    
	        <form action="searchSymbolUP" method="post">
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
	</div><br><br>
	
	<c:set var="query" value="${query}"/>
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
			<div class="col-md-2">
				<form action="addSymbol" method="post">
					<input type="submit" value="Add To Watchlist" />
		        </form>
			</div>
		</div>
	</div>
</div>

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
	
<s:set var="cwl" value="watchlistName"/>
<s:set var="rl" value="refreshList"/>
<s:set var="getTheQuotes" value="wlqhb.getWatchListHolder()" />
<s:set var="areTheQuotesEmpty" value="wlqhb" />
	Current Watch List: <s:property value="cwl"/><br>
	
<s:if test="%{#cwl != null || #rl == true}">
	<s:if test ="%{#getTheQuotes != null}">
		<s:form name="myForm" onsubmit="setRemoveSymbol()">
	    <s:hidden name="removeSymbol"/>
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
			<s:iterator value="%{getTheQuotes}" var="tsymbol" status="status">
            <tr>
                <td><s:property value="#tsymbol.name"/></td>
                <td><s:property value="#tsymbol.symbol"/></td>
                <td><s:property value="#tsymbol.price"/></td>
                <td><s:property value="#tsymbol.change"/></td>
                <td><s:property value="#tsymbol.percentChange"/></td>
                <td><s:property value="#tsymbol.volume"/></td>
                <td><s:property value="#tsymbol.open"/></td>
                <td><s:property value="#tsymbol.high"/></td>
                <td><s:property value="#tsymbol.low"/></td>
                <td><s:submit type="button" value="Remove from WatchList" action="remove" cssClass="" onclick="return setRemoveSymbol('%{#tsymbol.symbol}')"/>
                </td>
            </tr>
            </s:iterator>			
		</table>
		</s:form>
	</s:if>	
</s:if>

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