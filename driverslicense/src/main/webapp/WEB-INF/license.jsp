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
	<h1>New License</h1> <br>

	<c:out value="${error}"/>
		
        <form:form action="/addLicense" method="post" modelAttribute="license" enctype="multipart/form-data">
        <div class="form-group">
			<label for="person">Person:</label>
			<select name="person" >
			<c:forEach items="${people}" var="person">
				<option value="${person.id}">${person.firstName} ${person.lastName}</option>
			</c:forEach>
			</select>
        </div>
        <div class="form-group">
            <label for="state">State:</label>
            <form:input path="state" class="form-Control"/>
            <form:errors path="state"/>
        </div>
        <div class="form-group">
            <label for="expiration_date">Expiration Date:</label>
            <form:input type="date" path="expiration_date" class="form-Control"/>
            <form:errors path="expiration_date"/>
        </div>
		<input type="submit" value="Create" class="btn btn-primary btn-lg">
		<a href="/"><button class="btn btn-primary btn-lg">Cancel</button></a>
        </form:form>

</body>
</html>