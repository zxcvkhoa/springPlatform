<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WaterBnB</title>
</head>
<body>
	<a href="/waterbnb/loginReg">Login/Register</a>
	
	<h2>All Listings</h2>
	<table>
		<thead>
			<tr>
				<th>Address</th>
				<th>Pool Size</th>
				<th>Cost per night</th>
				<th>Details</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allListings}" var="bnb">
			<tr>
				<td><c:out value="${bnb.address}"/></td>
				<td><c:out value="${bnb.pool}"/></td>
				<td>$<c:out value="${bnb.cost}"/></td>
				<td>rating/5 - <a href="/waterbnb/<c:out value="${bnb.id}"/>">See more</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</body>
</html>