<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lookify!</title>
</head>

<body>
	<a href="/songs/new">Add New</a>
	<a href="/search/top">Top Songs</a>
	<form action="/songs/search" method="post">
		<input type="text" name="artistSearch"><br><br>
    	<input type="submit" value="Search Artists"/>
	</form> 
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Rating</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${lookify}" var="lookify">
	        <tr>
	            <td><a href="/songs/${lookify.id}"><c:out value="${lookify.title}"/></a></td>
	            <td><c:out value="${lookify.rating}"/></td>
	            <td><a href="/songs/delete/${lookify.id}">delete</a></td>	            
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>