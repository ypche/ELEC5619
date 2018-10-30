<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
<%
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + path + "/";
%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add post</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <title >Emergence Map</title>

    <style>
    body {
      font-family: sans-serif;
      font-size: 22px
    }

    .container1 {
        width: 500px;
        align-items: center;
        max-width: 1500px;
        margin: 0 auto;
        border-radius: 2px;
        box-shadow:
        0px 0px 0px 5px rgba( 255,255,255,0.4 ),
        0px 4px 20px rgba( 0,0,0,0.33 );
    }
    form {
       width: 500px;
        align-items: center;
        max-width: 1500px;
        margin: 0 auto;
      border-radius: 2px;
    }
    h2 {
        margin:0 0 50px 0;
        padding:10px;
        text-align:center;
        font-size:30px;
        text-color: #378070;
        border-bottom:solid 1px #e5e5e5;
    }
    input[type=submit] {
        align-content: center;
        width: 90%;
        background-color: #4CAF50;
        color: white;
        padding: 4px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type=text] {

        align-content: center;
        width: 80%;
        padding: 4px 20px;
        margin: 8px 0;
        border-color: rgba(17,27,14,0.83);
        border-radius: 4px;
    }
    input[type=password] {

        align-content: center;
        width: 80%;
        padding: 4px 20px;
        margin: 8px 0;
        border-color: rgba(17,27,14,0.83);
        border-radius: 4px;
    }


    </style>
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
 <spring:url value="/post/savePost" var="addURL"/>
 <%-- <a href="${addURL}">save a post</a> --%>
    <main role="main">
      <section class="jumbotron text-center" >
        <div class="container">
          <h1 class="jumbotron-heading">HappyReader</h1>
        </div>
      </section>
   		<div class="container-fluid" >
   			<div class="container" >
   				<div align="center">
			    <h3 style="font-family: sans-serif; color: gray; font-size: 30 em;">Add a comment</h3>
			    <form:form action="${addURL}" method="commentPost" modelAttribute="commentsForm" enctype="multipart/form-data" class = "form-group" >
			        <table style="font-family: sans-serif;">
			            <form:hidden path="id" />
			            <tr>
			                <td>Content:</td>
			                <td><form:input path="content"/></td>
			            </tr>
			            <tr>
			                <td><input type="submit" value="comment" /></td>
			            </tr>
			        </table>
			       
			    </form:form>
			     </div>
		    </div>
		    </div>
    </main>




    <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
  	<script src="<%=basePath %>js/popper.min.js"></script> 
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
	<script src="<%=basePath %>js/holder.min.js"></script> 
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous">
 
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
 </body>
 </html>
 

