<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
<form action="login-user" method="post">
<input type="text" name="login" placeholder="Enter Login">
<input type="password" name="password" placeholder="Enter Password">
<input type="submit" value="Login">
</form>
<p style="color:red">${error}</p>
</body>
</html>