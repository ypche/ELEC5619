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
<title>add books</title>
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
    <%@ include file="header.jsp" %>
    </header>
 <spring:url value="/book/saveBook" var="addURL"/>
 <%-- <a href="${addURL}">save a Book</a> --%>
    <main role="main">
      <section class="jumbotron text-center" >
        <div class="container">
          <h1 class="jumbotron-heading">HappyReader</h1>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
  			<a class="navbar-brand" href="#">Category</a>		
	  		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	   			 <div class="navbar-nav">
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/children">Children</a>
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/Science">Science</a>
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/Toolbook">Toolbook</a>
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/Family">Family</a>
	   			 </div>
	  		</div>
		</nav>
          <form class="input-group" action="search/${keyword}">
			<input type="text" class="form-control input-lg"  method="post" name="keyword"  >
			<button class="input-group-addon btn btn-primary" type="submit" > Search</button>
		  </form>
        </div>
      </section>
   		<div class="container-fluid" >
   			<div class="container" >
   				<div align="center">
			    <h3 style="font-family: sans-serif; color: gray; font-size: 30 em;">Add a book</h3>
			    <form:form action="${addURL}" method="post" modelAttribute="bookForm" enctype="multipart/form-data" class = "form-group" >
			        <table style="font-family: sans-serif;">
			            <form:hidden path="id" />
			            <tr>
			                <td>title:</td>
			                <td><form:input path="title" /></td>
			            </tr>
			            <tr>
			                <td>author:</td>
			                <td><form:input path="author" /></td>
			            </tr>
			            <tr>
			                <td>genre:</td>
			                <td><form:select path="genre" id="gen" method="POST">
							  <option value ="Children">Children</option>
							  <option value ="Science">Science</option>
							  <option value="Family">Family</option>
							  <option value="Toolbook">Toolbook</option>
							</form:select>
							</td>
			            </tr>
			            <tr>
			                <td>price:</td>
			                <td><form:input path="price" /></td>
			            </tr>
			            <tr>
			                <td>url:</td>
			                <td><form:input path="bookpath" /></td>
			            </tr> 
			            <tr>
			                <td>description:</td>
			                <td><form:input path="description" /></td>
			            </tr> 
			            <tr>
			                <td>image:</td>
			                <td>
			                	<input type="file" name="imgFile"/>
			                </td>
			            </tr>
			                    
			            <tr>
			                <td><input type="submit" value="save" /></td>
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
 
    <h3>add books</</h3>
    <form:form action="${addURL}" method="post" modelAttribute="bookForm" enctype="multipart/form-data">
        <table>
            <form:hidden path="id" />
            <tr>
               <td>title:</td>
                <td><form:input path="title" /></td>
            </tr>
            <tr>
                <td>author:</td>
                <td><form:input path="author" /></td>
            </tr>
            <tr>
                <td>genre:</td>
                <td><form:select path="genre" id="gen" method="POST">
				  <option value ="Children">Children</option>
				  <option value ="Science">Science</option>
				  <option value="Family">Family</option>
				  <option value="Toolbook">Toolbook</option>
				</form:select>
				</td>
            </tr>
            <tr>
                <td>price:</td>
                <td><form:input path="price" /></td>
            </tr>
           <tr>
                <td>url:</td>
                <td><form:input path="bookpath" /></td>
            </tr> 
            <tr>
                <td>description:</td>
                <td><form:input path="description" /></td>
           </tr> 
           <tr>
                <td>image:</td>
                <td>
                	<input type="file" name="imgFile"/>
                </td>
            </tr>
                    
            <tr>
                <td><input type="submit" value="save" /></td>
            </tr>
        </table>
    </form:form>
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
 </body>
 </html>
 
