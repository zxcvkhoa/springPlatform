<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Tracks</title>

</head>
<body>
<div>
<h1>Top Ten Songs:</h1>
<a href="/dashboard">Dashboard</a>
</div>
<ul>
<c:forEach items="${sortedSongs}" var="song">
<li>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</li>
</c:forEach>
</ul>
</body>
</html>