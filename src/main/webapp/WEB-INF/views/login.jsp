<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<!-- Bootstrap core CSS -->


<!-- Custom styles for this template -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<spring:url value="/user/loginUser" var="loginURL" />
	<div class="container">
		<div class="row" style="margin-top: 200px;">
			<h3 class="text-center col-md-3 col-md-offset-5"
				style="margin-bottom: 50px;">Login</h3>
		</div>

		<div class="row">
			<form:form class="form-horizontal" action="${loginURL}" method="post"
				modelAttribute="userForm" enctype="multipart/form-data">
				<div class="form-group">
					<label for="nameInput"
						class="col-md-1 col-md-offset-4 control-label">Name</label>
					<div class="col-md-3">
						<input type="text" path="name" class="form-control" id="nameInput"
							placeholder="Name">
					</div>
				</div>
				<div class="form-group">
					<label for="passwordInput"
						class="col-md-1 col-md-offset-4 control-label">Password</label>
					<div class="col-md-3">
						<input type="password" path="password" class="form-control"
							id="passwordInput" placeholder="Password">
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-6 col-md-1">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>




	<%-- <h3>Login</</h3>
	<form:form action="${loginURL}" method="post" modelAttribute="userForm"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><form:password path="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form:form> --%>
</body>
</html>
