<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
</head>
<body>
<spring:url value="/user/saveUser" var="addURL"/>
    <h3>Register New Account</</h3>
    <form:form action="${addURL}" method="post" modelAttribute="userForm" enctype="multipart/form-data">
        <table>
            <form:hidden path="id" />
            <tr>
                <td>email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><form:password path="password" /></td>
            </tr>
            <tr>
                <td>role:</td>
                <td><form:input path="role" /></td>
            </tr>
                    
            <tr>
                <td><input type="submit" value="save" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>

