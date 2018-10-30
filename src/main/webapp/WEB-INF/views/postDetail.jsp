<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + path + "/";
%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Album example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>css/album.css" type="text/css" rel="stylesheet">
          <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
            <strong>HappyReader</strong>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
  </head>
<body >
	<div class="container-fluid" style="padding-top: 50px">
		<div class="row">
			<div class="col-md-4">
				<img class="card-img-top" alt="" src="/image/${book.image}" width="200" height="350">
			</div>
			<div class="col-md-6" style="padding-top: 40px">
				<h1 style="font: bold; padding-left: 40px; font-family: fantasy;">
					${post.Content}
				</h1>
				<br>
				<h5 style="font: bold; color:olive; padding-left: 40px">Author</h5>
				<h6  style="font-style: oblique;  padding-left: 40px" >
					${post.User}
				</h6>
				<br><br><br><br>
				<div class="row">
					<h4 style="font: bold;color:olive; padding-left: 60px; ">price: &nbsp;&nbsp;<span style="color: red;">$${book.price}</span></h4>
					  &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp;&nbsp;
					 <div class="btn-group">
	                 
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Add Comment</button>
                    </div>
				</div>
				<hr>
			</div>
			<div style="padding-top: 40px; padding-left:40px; " >
				<div class="col-md-8 card">
				<h2 style="font-family: cursive;">Description</h2>
				<p style="padding-top: 20px; padding-left: 20px">
					${post.content}
				</p>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br>
    <footer class="footerCus">
      <div class="container">
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? Visit the homepage or read our getting started guide.</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
  	<script src="<%=basePath %>js/popper.min.js"></script> 
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
	<script src="<%=basePath %>js/holder.min.js"></script> 
  </body>
</html>