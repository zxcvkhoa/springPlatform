<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@page import="com.khoa.lookify.models.Lookify" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add song</title>
</head>
<body>
	<c:out value="${errors}"/>
	<a href="/dashboard">Dashboard</a><br><br>
	    <form action="/songs" method="post">
		<label for="title">Title: <input type="text" name="title"></label><br>
		<label for="artist">Artist: <input type="text" name="artist"></label><br>
		<label for="rating">Rating(1-10): 
            <select name="rating" id="rating">
                <option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
            </select>
        </label><br>
    	<input type="submit" value="Submit"/>
	</form> 
</body>
</html>