<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Grocery Store a Ecommerce Online Shopping Category Flat
	Bootstrap Responsive Website Template | Products :: w3layouts</title>

</head>

<body>
<h1>Welcom ${user.name}</h1>
<form action="create-category" method="post">
<input type="text" name="categoryName" placeholder="Category Name">
<input type="text" name="categoryDescription" placeholder="Category Description">
<input type="submit" value="Crreate">
</form>

<a href="logout">Logout</a>

</body>
</html>