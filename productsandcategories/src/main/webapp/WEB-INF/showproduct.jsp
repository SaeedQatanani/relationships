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
<title>Product Page</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<p><a href="/">Home</a></p>
		<c:forEach var="categ" items="${product.categories}">
    		<p><c:out value="${categ.name}"/></p>
		</c:forEach>
		
		<form action="/products/addCat" method="post">
		<input type="hidden" name="product" value="${product.id}">
		<select name="category">
		<c:forEach var="category" items="${categories}">
    		<option value="${category.id}"><c:out value="${category.name}"/></option>
		</c:forEach>
		</select>
		<input type="submit" value="add">
		</form>
</body>
</html>