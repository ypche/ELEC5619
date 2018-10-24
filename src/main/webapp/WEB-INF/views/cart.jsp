<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
	<title>Shopping Cart</title>
</head>
<body>
<table>
	<c:forEach items="${OrderDetail}" var="order">
		<tr>
			<td>user</td>
			<td>${order.userName}</td>
			<td>total: $</td>
			<td>${order.total}</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td>Book Title</td>
		<td>Book Price</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${ItemList}" var="orderItem">
		<tr>
			<td>${orderItem.bookTitle}</td>
			<td>${orderItem.bookPrice}</td>
			<td>
				<spring:url value="/cart/delete/${orderItem.id}" var="deleteURL"></spring:url>
				<a href="${deleteURL}">Delete</a>
			</td>
		</tr>
	
	</c:forEach>
</table>	
</body>
</html>
