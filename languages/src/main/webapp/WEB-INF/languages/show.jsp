<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${language.name}"/></title>
</head>
<body> 
	<h1><c:out value="${language.name}"/></h1>
	<p>Created by: <c:out value="${language.creator}"/></p>
	<p>Current Version: <c:out value="${language.currentVersion}"/></p>
	<a href="/languages/edit/${language.id}">edit</a>
	<a href="/languages/delete/${language.id}">delete</a>
</body>
</html>