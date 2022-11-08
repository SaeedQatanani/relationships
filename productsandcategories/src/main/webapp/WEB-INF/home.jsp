<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	<p><a href="/products/new">New Product</a></p>
	<p><a href="/categories/new">New Category</a></p>
	<div></div>
	<table>
		<thead>
			<tr>
				<th>Products</th>
				<th>Categories</th>
			</tr>
		</thead>
		<tr>
			<td><ul>
			<c:forEach var="product" items="${products}">
			<li>
				<a href="/products/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a>
			</li>
			</c:forEach>
			</ul></td>
			<td><ul>
			<c:forEach var="category" items="${categories}">
			<li>
				<a href="/categories/<c:out value="${category.id}"/>"><c:out value="${category.name}"/></a>
			</li>
			</c:forEach>
			</ul></td>
		</tr>
	</table>
	
</body>
</html>