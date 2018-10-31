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
  </head>
<body >
	<%@ include file="header.jsp" %>
	<div class="container-fluid" style="padding-top: 50px">
		<div class="row">
			<div class="col-md-4">
				<img class="card-img-top" alt="" src="${book.image}" width="200">
			</div>
			<div class="col-md-6" style="padding-top: 40px">
				<h1 style="font: bold; padding-left: 40px; font-family: fantasy;">
					${book.title}
				</h1>
				<br>
				<h5 style="font: bold; color:olive; padding-left: 40px">Author</h5>
				<h6  style="font-style: oblique;  padding-left: 40px" >
					${book.author}
				</h6>
				<br><br><br><br>
				<div class="row">
					<h4 style="font: bold;color:olive; padding-left: 60px; ">price: &nbsp;&nbsp;<span style="color: red;">$${book.price}</span></h4>
					  &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp;&nbsp;
					 <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">To Wishlist</button>
	                      <c:choose>
	                      	<c:when test="${book.status == 'InCart' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" disabled>In Cart</button>
	                      	</c:when>
	                      	<c:when test="${book.status == 'Bought' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" disabled>Bought</button>
	                      	</c:when>
	                      	<c:when test="${book.status == 'Delivered' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#downloadModal">Download</button>
		                      	<div class="modal fade" id="downloadModal" tabindex="-1" role="dialog" aria-labelledby="downloadModalLabel" aria-hidden="true">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="downloadModalLabel">Download</h5>
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								      <div class="modal-body">
								      	<div class="form-group">
											<label for="inputCode">Purchase Code</label>
											<input class="form-control" id="inputCode" placeholder="Enter Purchase Code" />
										</div>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								        <button type="button" class="btn btn-primary" onClick="download('${book.id}')">OK</button>
								      </div>
								    </div>
								  </div>
								</div>
							</c:when>
	                      	<c:otherwise>
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" onClick="location.href='/onlineshopping/cart/addItem/${book.id}';">Add Cart</button>
	                      	</c:otherwise>
	                      </c:choose>
                    </div>
				</div>
				<hr>
			</div>
			<div style="padding-top: 40px; padding-left:40px; " >
				<div class="col-md-8 card">
				<h2 style="font-family: cursive;">Description</h2>
				<p style="padding-top: 20px; padding-left: 20px">
					${book.description}
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