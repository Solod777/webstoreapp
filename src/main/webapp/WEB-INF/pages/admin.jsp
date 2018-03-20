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
	<h1>Welcome ${user.name}</h1>
	<br>
	<form action="create-category" method="post">
		Create new category:
		<br>
		<input type="text" name="categoryName" placeholder="Category Name">
		<input type="text" name="categoryDescription" placeholder="Category Description">
		<input type="submit" value="Create">
	</form>
	<br>

	<form action="delete-category" method="get">
		Choose category to delete:
		<br>
		<input type="text" name="categoryId" placeholder="Category ID">
		<input type="submit" value="Delete">
	</form>
	<br>

	<form action="create-product" method="post">
		Create new product: 
		<br>
		<!-- <input type="text" name="categoryId" placeholder="Category ID">  -->
		<select name="category_list" size="1">
			<c:forEach items="${categories}" var="categ">
				<option value="${categ.id}">${categ.categoryName}
			</c:forEach>
		</select>
		<input type="text" name="productName" placeholder="Product Name">
		<input type="text" name="productDescription" placeholder="Product Description">
		<input type="text" name="supplier" placeholder="Supplier">
		<input type="text" name="price" placeholder="Price">
		<input type="text" name="productImage" placeholder="Product Image URL">
		<input type="submit" value="Create">
	</form>
	<br>

	<form action="delete-product-by-id" method="get">
		Choose product to delete:
		<br>
		<select name="product_list" size="1">
			<c:forEach items="${products}" var="prod">
				<option value="${prod.id}">${prod.productName}
			</c:forEach>
		</select>
		<input type="submit" value="Delete">
	</form>
	<br> ${result}
	<a href="logout">Logout</a>





</body>
</html>