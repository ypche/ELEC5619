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

  <body>

    <header>
      <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <h4 class="text-white">Contact</h4>
              <ul class="list-unstyled">
                <li><a href="#" class="text-white">Follow on Twitter</a></li>
                <li><a href="#" class="text-white">Like on Facebook</a></li>
                <li><a href="#" class="text-white">Email me</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
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
    </header>

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
						<img class="card-img-top" alt="" src="/image/${book.image}" width="200" height="300">
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
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Add Cart</button>
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


