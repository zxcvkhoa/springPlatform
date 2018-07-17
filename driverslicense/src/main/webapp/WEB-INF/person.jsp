<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Driver's License</title>
</head>
<body>
	<h1>New Person</h1> <br>

	<c:out value="${error}"/>
		
        <form:form action="/addPerson" method="post" modelAttribute="person" enctype="multipart/form-data">
        <div class="form-group">
	            <label for="firstName">First Name:</label>
	            <form:input path="firstName" class="form-Control"/>
	            <form:errors path="firstName"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <form:input path="lastName" class="form-Control"/>
            <form:errors path="lastName"/>
        </div>
		<input type="submit" value="Create" class="btn btn-primary btn-lg">
		<a href="/"><button class="btn btn-primary btn-lg">Cancel</button></a>
        </form:form>

</body>
</html>