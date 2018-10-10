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
<spring:url value="/book/addBook" var="addURL"/>
<a href="${addURL}">add a Book</a>

<form action="search/${keyword}" method="GET" >
	<input type="text" method="post" name="keyword" >
	<button type="submit"  ></button>
</form>
<table>
	<tr>
		<td>title</td>
		<td>author</td>
		<td>genre</td>
		<td>price</td>
		<td>bookpath</td>
	</tr>
	
	<c:forEach items="${list}" var="book">
		<tr>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.genre}</td>
			<td>${book.price}</td>
			<td>${book.bookpath}</td>
			<td>
				<c:if test="${book.image!=null}">
					<img alt="" src="/image/${book.image}" width="300" height="200">
				</c:if>
			</td>
		<td>
				<spring:url value = "/book/delete/${book.id}" var="deleteURL"></spring:url>
				<a href="${deleteURL}"> delete</a>
		</td> 
		</tr>
	
	</c:forEach>
	
</table>	

</body>
</html>
