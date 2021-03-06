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
	<h1>Driver's License</h1>
	<br>
	<a href="/persons/new"><button class="btn btn-primary btn-lg">Create Person</button></a><br><br>
	<a href="/license/new"><button class="btn btn-primary btn-lg">Create License</button></a>
	
	<div>
		<h3>Licenses</h3>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>License #</th>
						<th>State</th>
						<th>Expiration Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${licenses}" var="license">
					<tr>
						<td><c:out value="${license.person.firstName}"/></td>
						<td><c:out value="${license.person.lastName}"/></td>
						<td><c:out value="${license.number}"/></td>
						<td><c:out value="${license.state}"/></td>
						<td><c:out value="${license.expiration_date}"/></td>
					</tr>
					</c:forEach>
				</tbody>
					</table>
				</div>
</body>
</html>