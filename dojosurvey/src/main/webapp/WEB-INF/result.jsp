<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <h2>Submitted Information:</h2>
        <div class="results">
            <p class="nameResult">Name: <c:out value="${name}"/></p>
            <p class="locationResult">Dojo Location: <c:out value="${location}"/></p>
            <p class="languageResult">Favorite Language: <c:out value="${language}"/></p>
            <p class="commentResult">Comment: <c:out value="${comment}"/></p>
        </div>
    </div>
</body>
</html>