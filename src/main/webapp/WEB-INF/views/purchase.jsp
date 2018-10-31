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

    <title>Purchase Items</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>css/album.css" type="text/css" rel="stylesheet">
    
    <script type="text/javascript">
    	function confirmPurchase() {
    		var url = window.location.href;
    		var urls = url.split('/');
    		var str = "";
    		if (urls.length > 1) {
    			str = urls[urls.length - 1];
    		}
    		window.location.href = "/onlineshopping/cart/confirm/" + str;
    	}
    </script>
   	<style type="text/css">
	.bodyFont{
		font-family: Comic Sans MS
	}
	</style>
  </head>

  <body>
  	<%@ include file="header.jsp" %>
    <br /><br /><br /><br />
  	<form class="container">
  		<div class="row">
  			<div class="col-md-2 text-right"></div>
  			<div class="col-md-8 text-center">
  				<h1 style="font-family: Baskerville; font-weight: bolder;">
  				<span><img width="50" height="50" alt="" src="/resources/books.png"></span>
  				Purchase List</h1>
  			</div>
  			<div class="col-md-2"></div>
  		</div>
  		<c:forEach items="${ItemsDetail}" var="item">
	  		<div class="row">
	  			<div class="col-md-3"></div>
	  			<div class="col-md-6">
	  				<div class="list-group">
			  			<div class="d-flex w-100 justify-content-between">
					      <h3 class="mb-1" style="font-family: Copperplate">${item.bookTitle}</h3>
					      <h3 style="font-family: American Typewriter">$ ${item.bookPrice}</h3>
					    </div>
					    <p class="mb-1" style="font-family: Book Antiqua; font-style: italic">${item.bookDescription}</p>
			  		</div>
	  			</div>
	  			<div class="col-md-3"></div>
	  		</div>
	  	</c:forEach>
	  	<div class="row">
	  		<div class="col-md-2"></div>
	  		<div class="col-md-8"><hr></div>
	  		<div class="col-md-2"></div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3"></div>
	  		<div class="col-md-6 text-right">
	  			<h3 style="font-family: Copperplate">
	  			<span><img width="30" height="30" alt="" src="/resources/coins.png"></span>
	  			Total: <span style="font-family: American Typewriter">$ ${totalPrice}</span></h3>
	  		</div>
	  		<div class="col-md-3"></div>
	  	</div>
  		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<a href="/onlineshopping/cart/"><button type="button" class="btn btn-secondary">Back to Cart</button></a>
			</div>
			<div class="col-md-3 text-right">
				<button type="button" class="btn btn-primary" onClick="confirmPurchase()">Confirm and Purchase</button>
			</div>
			<div class="col-md-3"></div>
		</div>
	</form>
	
	<br><br><br>
    <footer  style="position: fixed; left: 0; bottom: 0;height:50px ; width: 100%; background-color: black; color: white; text-align: center">
      <div class="container">
        <p style="font-family: Comic Sans MS">HappyReader is made by &copy; Bootstrap!</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
  	<script src="<%=basePath %>js/popper.min.js"></script> 
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
	<script src="<%=basePath %>js/holder.min.js"></script> 
  </body>
</html>
