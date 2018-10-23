<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add books</title>
</head>
<body>
<spring:url value="/book/saveBook" var="addURL"/>
<%-- <a href="${addURL}">save a Book</a> --%>

    <h3>add books</</h3>
    <form:form action="${addURL}" method="post" modelAttribute="bookForm" enctype="multipart/form-data">
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
                <td><form:select path="genre" id="gen" method="POST">
				  <option value ="Children">Children</option>
				  <option value ="Science">Science</option>
				  <option value="Family">Family</option>
				  <option value="Toolbook">Toolbook</option>
				</form:select>
				</td>
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
                <td>image:</td>
                <td>
                	<input type="file" name="imgFile"/>
                </td>
            </tr>
                    
            <tr>
                <td><input type="submit" value="save" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>

