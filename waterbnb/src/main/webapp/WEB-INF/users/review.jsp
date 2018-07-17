<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WaterBnB</title>
</head>
<body>
	<a href="/logout">Logout</a><br>
	<a href="/">Home</a><br>
	
	<div class="newReview">
	   
	  	<h2>Review of <c:out value="${bnb.address}"/></h2>
	    <form:form method="POST" action="/newReview" modelAttribute="review">	
			<p>
	            <form:label path="review"></form:label>
	            <form:textarea path="review"/>
	            <form:errors path="review"/>
	        </p>
	  
	        	<form:select path="rating">	
					<form:option value="1" label="1"/>
					<form:option value="2" label="2"/>
					<form:option value="3" label="3"/>	
					<form:option value="4" label="4"/>
					<form:option value="5" label="5"/>	   	
		   		</form:select>
		   		<br><br>
	        <input type="submit" value="Submit Review"/>
	    </form:form>
    </div>
</body>
</html>