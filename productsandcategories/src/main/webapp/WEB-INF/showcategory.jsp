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
<title>Category Page</title>
</head>
<body>
		<h1><c:out value="${category.name}"/></h1>
		<p><a href="/">Home</a></p>
		<c:forEach var="product" items="${category.products}">
    		<p><c:out value="${product.name}"/></p>
		</c:forEach>
		
		<form action="/products/addCat" method="post">
		<input type="hidden" name="category" value="${category.id}">
		<select name="product">
		<c:forEach var="product" items="${products}">
    		<option value="${product.id}"><c:out value="${product.name}"/></option>
		</c:forEach>
		</select>
		<input type="submit" value="add">
		</form>
</body>
</html>