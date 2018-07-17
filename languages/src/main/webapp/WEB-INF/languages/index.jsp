<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>   
	<h1>All Languages</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Creator</th>
	            <th>Version</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="language">
	        <tr>
	            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
	            <td><c:out value="${language.creator}"/></td>
	            <td><c:out value="${language.currentVersion}"/></td>
	            <td>
	            	<a href="/languages/delete/${language.id}">delete</a>
	            	<a href="/languages/edit/${language.id}">edit</a>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<form action="/languages" method="post">
		<label for="name">Name: <input type="text" name="name"></label><br>
		<label for="creator">Creator: <input type="text" name="creator"></label><br>
		<label for="currentVersion">Version: <input type="text" name="currentVersion"></label><br>
    	<input type="submit" value="Submit"/>
	</form> 
	<c:out value="${errors}"/>
</body>
</html>