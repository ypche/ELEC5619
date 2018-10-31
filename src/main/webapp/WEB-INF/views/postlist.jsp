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

      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
            <strong>HappyReader</strong>
          </a>
        </div>
      </div>
    </header>

    <main role="main">

	<div>
		
	</div>
      <div class="album py-5 bg-light">
        <div class="container">
		<form>
			UserName： Peter
			<br>
			<a class="navbar-brand" href="<%=basePath %>forum/addComments">Content: The science Book is good!</a>
		</form>
		<br>
		<br>
		<form>
			UserName:  Bob
			<br>
			<a class="navbar-brand" href="<%=basePath %>forum/addComments">Content: The children book is good!</a>
			
		</form>
		<form>
          <div class="row">
         	<c:forEach items="${cs}" var="post" varStatus="st">
	            <div class="col-md-3">
	              <div class="card mb-4 box-shadow">
	                <div class="card-body">
	                <p class="card-text" style="color: navy; font-family: sans-serif; font-weight: bold;">${post.id}</p>
	                 <div >
	                 	<span class="card-text" style="color:activeborder; font-family: sans-serif;"> ${post.name}</span>
	                 </div>
	                 <hr>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Add comment</button>
	                    </div>
	                    <small class="text-muted">${post.time}</small>
	     
						
	                  </div>
	                </div>
	              </div>
	            </div>
			</c:forEach>
          </div>
          </form>
        </div>
      </div>
	 <div>
	 	<a class="navbar-brand" href="<%=basePath %>forum/addPost">Add a new Post.</a>
	 	<br>
	 	<spring:url value = "/forum/delete/${post.id}" var="deleteURL"></spring:url>	
						<a class="navar-brand" href="${deleteURL}"> delete</a>
	 </div>
    </main>


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









