<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
    <form action="/submit" method="POST">
        <label for="name">Your Name: <input type="text" name="name"></label>
        <br>
        <label for="location">Dojo Location: 
            <select name="location" id="location">
                <option value="SanJose">San Jose</option>
                <option value="Seattle">Seattle</option>
                <option value="Tulsa">Tulsa</option>
                <option value="Dallas">Dallas</option>
            </select>
        </label>
        <br>
        <label for="location">Favorite Language: 
            <select name="language" id="language">
                <option value="Javascript">JavaScript</option>
                <option value="Python">Python</option>
                <option value="Ruby">Ruby</option>
                <option value="HTML">HTML</option>
            </select>
        </label>
        <br>
        <label for="comment">Comment (optional): <br>
            <input type="text" name="comment">
        </label>
        <br>
        <input type="submit">
    </form>
</body>
</html>