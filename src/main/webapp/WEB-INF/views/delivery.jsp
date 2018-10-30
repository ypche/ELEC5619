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
    
	<title>Shopping Delivery</title>
	<script type="text/javascript">
		function deliveryCheckedItems() {
			var cks = document.getElementsByName("checkIds");
			var str = "";
			for (var i = 0; i < cks.length; i++) {
				if (cks[i].checked) {
					str += cks[i].value + ",";
				}
			}
			str = str.substring(0, str.length - 1);
			if (str == "") {
				return;
			}
			window.location.href = "delivery/sendCode/" + str;
		}
		
		function checkAllItems() {
			var ckAll = document.getElementsByName("checkAll");
			var cks = document.getElementsByName("checkIds");
			for (var i = 0; i < cks.length; i++) {
				if (ckAll[0].checked)
					cks[i].checked = true;
				else
					cks[i].checked = false;
			}
		}
	</script>
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
    <br /><br /><br /><br />
	<form class="container">
  		<div class="row">
  			<div class="col-md-2 text-right">
  				<img width="50" height="50" alt="" src="https://doc-0c-88-docs.googleusercontent.com/docs/securesc/1lhra9ur6rbc8etdjasmei79ag64jeuu/3j79fo8rtjrek7tpemvg594qtvi0ir5p/1540872000000/01552601290929276177/01552601290929276177/1fxRlj42b0zQuZlRTqA4QzolKHvDLeWPg?e=download&nonce=cbibeusd28dko&user=01552601290929276177&hash=pkoo7om700udaa1jk4guqgq">
  			</div>
  			<div class="col-md-8 text-left">
  				<h1 style="font-family: Baskerville; font-weight: bolder;">
				Delivery
				</h1>
  			</div>
  			<div class="col-md-2"></div>
  		</div>
	</form>
<table class="container table table-striped">
	<thead class="thead-light">
		<tr>
			<th scope="col"><input type="checkbox" name="checkAll" onClick="checkAllItems()"></th>
			<th scope="col">Book Title</th>
			<th scope="col">Buyer</th>
			<th scope="col">Operation</th>
		</tr>
	</thead>
	<c:forEach items="${ItemList}" var="deliveryItem">
		<tr>
			<td><input type="checkbox" id="checkIds" name="checkIds" value="${deliveryItem.id}"></td>
			<td>${deliveryItem.bookTitle}</td>
			<td>${deliveryItem.bookBuyer}</td>
			<td>
				<spring:url value="/delivery/sendCode/${deliveryItem.id}" var="sendURL"></spring:url>
				<a href="${sendURL}">Delivery</a>
			</td>
		</tr>
	
	</c:forEach>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td><input type="submit" onClick="deliveryCheckedItems()" value="Delivery Items"></td>
	</tr>
</table>	
    <footer style="position: fixed; left: 0; bottom: 0;height:50px ; width: 100%; background-color: black; color: white; text-align: center">
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
