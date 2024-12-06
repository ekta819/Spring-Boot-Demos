<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h2>Welcome to Login Page</h2>

	<c:if test="${ not empty errorMsg}">
		<h4 style="color: red">${errorMsg}</h4>
	</c:if>

	<form action="loginForm" method="post">
		Email : <input type="text" name="email"><br />
		<br /> Password : <input type="password" name="password"><br />
		<br /> <input type="submit" value="Login" />
	</form>

	<br />
	<br /> If already NOT registered ....
	<a href="regPage"><b>Register Here</b></a>


</body>
</html>