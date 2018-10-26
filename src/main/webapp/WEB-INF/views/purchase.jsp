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
  </head>

  <body>
  	<form>
  		<div class="row">
  			<div class="col">
  			Book Title
  			</div>
  			<div class="col">
  			Book Price
  			</div>
  		</div>
  		<c:forEach items="${ItemsDetail}" var="item">
		  <div class="row">
		    <div class="col">
		      ${item.bookTitle}
		    </div>
		    <div class="col">
		      ${item.bookPrice}
		    </div>
		  </div>
		</c:forEach>
		<div class="row">
			<div class="col">
				<a href="/onlineshopping/cart/"><button type="button" class="btn btn-secondary">Back to Cart</button></a>
			</div>
			<div class="col">
				<button type="button" class="btn btn-primary" onClick="confirmPurchase()">Confirm and Purchase</button>
			</div>
		</div>
	</form>
	
	<br><br><br>
    <footer class="footerCus">
      <div class="container">
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? Visit the homepage or read our getting started guide.</p>
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
