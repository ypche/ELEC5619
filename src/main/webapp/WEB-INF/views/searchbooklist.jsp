<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
	<title>Books</title>
</head>
<body>
<table>
	<tr>
		<td>title</td>
		<td>author</td>
		<td>genre</td>
		<td>price</td>
		<td>bookpath</td>
	</tr>
	
	<c:forEach items="${searchlist}" var="book">
		<tr>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.genre}</td>
			<td>${book.price}</td>
			<td>${book.bookpath}</td>
		</tr>
	
	</c:forEach>
</table>	
</body>
</html>