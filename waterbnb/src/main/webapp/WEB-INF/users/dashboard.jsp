<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<a href="/logout">Logout</a><br>
	<a href="/">Home</a><br>
	
	<div class="listingsTable">
	<h1>Welcome to the dashboard, <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></h1>
	
	<h2>Current Listings</h2>
	<table>
		<thead>
			<tr>
				<th>Address</th>
				<th>Pool Size</th>
				<th>Cost per night</th>
				<th>Details</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${currentListings}" var="bnb">
			<tr>
				<td><c:out value="${bnb.address}"/></td>
				<td><c:out value="${bnb.pool}"/></td>
				<td>$<c:out value="${bnb.cost}"/></td>
				<td>rating/5 - <a href="/waterbnb/<c:out value="${bnb.pool}"/>">edit</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<div class="newBnb">
	    <h2>New Listing</h2>
	    
	    <p><form:errors path="bnb.*"/></p>
	   
	    <form:form method="POST" action="/newBnb" modelAttribute="bnb">
			<p>
	            <form:label path="address">Address:</form:label>
	            <form:input path="address"/>
	        </p>
			<p>
	            <form:label path="details">Description:</form:label>
	            <form:input type="textarea" path="details"/>
	        </p>
	        <p>
	            <form:label path="cost">Cost per night:</form:label>
	            <form:input path="cost"/>
	        </p>
	        	<form:select path="pool">	
					<form:option value="Small" label="Small"/>
					<form:option value="Medium" label="Medium"/>
					<form:option value="Large" label="Large"/>		   	
		   		</form:select>
		   		<br><br>
	        <input type="submit" value="Add Listing"/>
	    </form:form>
    </div>

</body>
</html>