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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>css/album.css" type="text/css" rel="stylesheet">
    
    <title>Login</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<div class="container">
      <a href="<%=basePath %>book/getBooks" class="navbar-brand d-flex align-items-center">
        <img width="20" height="20" alt="" src="https://doc-00-88-docs.googleusercontent.com/docs/securesc/1lhra9ur6rbc8etdjasmei79ag64jeuu/725dvpemcaa8gcnqjp5f9elovo0tunp2/1540900800000/01552601290929276177/01552601290929276177/1xsv1SLUU0uBRiop9xazGwArXswPAl3XW?e=download&nonce=f1ju7vdo00m3m&user=01552601290929276177&hash=omdjkaps6nrjuinda3nnlllp0o6huvj2">
        <strong>&nbspHappyReader</strong>
      </a>
      <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="<%=basePath%>">Home</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="<%=basePath%>cart">Cart</a>
          </li>
          
        </ul>
        <c:choose>
        	<c:when test="${sessionScope.userID eq null}">
        		<div class="span12">
					<a class="btn btn-outline-info" href="<%=basePath%>user/register" role="button">Signup</a>&nbsp
					<a class="btn btn-outline-success" href="<%=basePath%>user/login" role="button">Signin</a>
				</div>
        	</c:when>
        	<c:otherwise>
        		<a class="btn btn-dark" href="" role="button">${username}</a>&nbsp
        		<a class="btn btn-secondary" href="<%=basePath %>user/logout" role="button">Logout</a>
        	</c:otherwise>
        </c:choose>
      </div>
      </div>
    </nav>
	<spring:url value="/user/loginUser" var="loginURL" />
	<form class="container">
  		<div class="row" style="margin-top: 100px">
  			<div class="col-md-2"></div>
  			<div class="col-md-8 text-left">
  				<h1 style="font-family: Baskerville; font-weight: bolder;">
				<span>
  					<img width="50" height="50" alt="" src="https://doc-0c-88-docs.googleusercontent.com/docs/securesc/1lhra9ur6rbc8etdjasmei79ag64jeuu/rdsu6qom73rjs71q77sr5lrdjqt6va02/1540900800000/01552601290929276177/01552601290929276177/1R7koohRf-8dTdlGlVgAPOfCgUsV4ms7W?e=download">
  				</span>
  				Login
				</h1>
  			</div>
  			<div class="col-md-2"></div>
  		</div>
	</form>
			<%-- <form:form class="form-horizontal" action="${loginURL}" method="post"
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
						<a type="button" class="btn btn-primary" href="${loginURL}">Login</a>
					</div>
				</div>
			</form:form> --%>
			<form:form action="${loginURL}" method="post" modelAttribute="userForm"
				enctype="multipart/form-data"
				class="container">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="form-group">
						<label for="inputUserName">Name</label>
						<form:input id="inputUserName" path="name" placeholder="Enter User Name" class="form-control" />
					</div>
					<div class="form-group">
						<label for="inputPassword">Password</label>
						<form:password id="inputPassword" path="password" placeholder="Enter Password" class="form-control" />
					</div>
					<input type="submit" value="Login" class="btn btn-primary" />
				</div>
				<div class="col-md-2"></div>
			</form:form>




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
