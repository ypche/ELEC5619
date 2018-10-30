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

    <title>Search Result</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>css/album.css" type="text/css" rel="stylesheet">
  </head>

  <body>

    <header>
    	<%@ include file="header.jsp" %>
    </header>
	<br/><br/><br/><br/>
    <main role="main">

      <section class="jumbotron text-center" >
        <div class="container" >
    		<img alt="" src="http://www.e-publicationsscotland.com/graphics/ebooks_intro.png" width="800">
        </div>

      </section>

      <div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
         	<c:forEach items="${searchlist}" var="book">
	            <div class="col-md-4">
	              <div class="card mb-4 box-shadow">
              		<c:if test="${book.image!=null}">
						<img class="card-img-top" alt="" src="${book.image}" height="500">
					</c:if>
	<!--                 <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap"> -->
	                <div class="card-body">
	                <p class="card-text" style="color: navy; font-family: sans-serif; font-weight: bold;">${book.title}</p>
	                 <div >
	                 	Author:<span class="card-text" style="color:activeborder; font-family: sans-serif;"> ${book.author}</span>
	                 </div>
	                 <hr>
	                 <%--  <p class="card-text" style="font-weight:600; font-family: sans-serif;">Description:</p>
	                  <p class="card-text">${book.description}</p> --%>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Add Wishlist</button>
	                      <c:choose>
	                      	<c:when test="${book.status == 'InCart' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" disabled>In Cart</button>
	                      	</c:when>
	                      	<c:when test="${book.status == 'Bought' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" disabled>Bought</button>
	                      	</c:when>
	                      	<c:when test="${book.status == 'Delivered' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary">Download</button>
	                      	</c:when>
	                      	<c:otherwise>
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" onClick="location.href='/onlineshopping/cart/addItem/${book.id}';">Add Cart</button>
	                      	</c:otherwise>
	                      </c:choose>
	                    </div>
	                    <small class="text-muted">Price: $${book.price}</small>
	                  </div>
	                </div>
	              </div>
	            </div>
			</c:forEach>
          </div>
        </div>
      </div>

    </main>

    <footer class="text-muted">
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
  	<script src="<%=basePath %>js/popper.min.js"></script> 
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
	<<script src="<%=basePath %>js/holder.min.js"></script> 
  </body>
</html>


