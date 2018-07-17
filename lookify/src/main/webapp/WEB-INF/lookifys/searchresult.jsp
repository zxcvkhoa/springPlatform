<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>

</head>
<body>
<div>
	<form action="/songs/search" method="POST">
		<input type="text" name="artistSearch">
		<input type="submit" value="Search Artists">
	</form>
	<a href="/dashboard">Dashboard</a>
</div>
<table>
<tr>
	<th>Name</th>
	<th>rating</th>
	<th>action</th>
</tr>
<c:forEach items="${found}" var="song">
<tr>
<td><a href="songs/${song.id}">${song.title}</a>
<td>${song.rating}</td>
<td>${song.artist}</td>
</tr>
</c:forEach>
</table>
</body>
</html>