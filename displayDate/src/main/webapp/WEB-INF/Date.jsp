<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/app.js" ></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1 id="date"> <c:out value="${weekDay}"/>, the <c:out value="${numDay}"/> of <c:out value="${month}"/>, <c:out value="${year}"/></h1>
	</body>
</html>