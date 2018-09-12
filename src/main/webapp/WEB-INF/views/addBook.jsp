<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add books</title>
</head>
<body>
    <h3>add books</</h3>
    <form:form action="addBook" method="post" modelAttribute="book">
        <table>
            <form:hidden path="id" />
            <tr>
                <td>title:</td>
                <td><form:input path="title" /></td>
            </tr>
            <tr>
                <td>author:</td>
                <td><form:input path="author" /></td>
            </tr>
            <tr>
                <td>genre:</td>
                <td><form:input path="genre" /></td>
            </tr>
            <tr>
                <td>price:</td>
                <td><form:input path="price" /></td>
            </tr>
<%--             <tr>
                <td>url:</td>
                <td><form:input path="bookpath" /></td>
            </tr> --%>
            <tr>
                <td>url:</td>
                <td><form:input path="bookpath" /></td>
            </tr> 
            <tr>
                <td>description:</td>
                <td><form:input path="description" /></td>
            </tr>          
            <tr>
                <td><input type="submit" value="save" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>

