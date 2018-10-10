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
	<tr>
		<td>user</td>
		<td>total</td>
	</tr>
	
	<c:forEach items="${list}" var="order">
		<tr>
			<td>${order.user}</td>
			<td>${order.total}</td>
		</tr>
	
	</c:forEach>
</table>	
</body>
</html>