<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.khoa.relationships.models.License" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/licenses" method="post" modelAttribute="license">
		<form:label path="person">Person: 
	   	<form:select path="person">
	   		<c:forEach items="${persons}" var="person">
	   			<option value="${person.id}">${person.firstName} ${person.lastName}</option>
	   		</c:forEach>
	   	</form:select>
	    </form:label>
	    <br>
	    <form:label path="state">State: 
	    <form:errors path="state"/>
	    <form:input path="state"/>
	    </form:label>
	    <br>
	    <form:label path="expiration_date">Expiration Date:
	    <form:errors path="expiration_date"/>
	    <form:input path="expiration_date" type="date"/>
	    </form:label>
	   	<br>
    	<input type="submit" value="Create"/>
	</form:form>    
</body>
</html>
