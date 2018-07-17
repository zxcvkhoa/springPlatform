<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>
<h1>${category.name}</h1>
<h2>Products</h2>
<ul>
<c:forEach items="${categoryProducts}" var="product">
	<li>${product.name}</li>
</c:forEach>
</ul>

<form action="/categories/addproduct" method="POST">
	<label for="productId">Add Product:</label>
	<select name="productId">
	<c:forEach items="${availableProducts}" var="product">
		<option value="${product.id}">${product.name}</option>
	</c:forEach>
	</select>
	<input type="hidden" name="categoryId" value="${category.id}">
	<input type="submit" value="Add">
</form>

</body>
</html>