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
			window.location.href = "/onlineshopping/delivery/sendCode/" + str;
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
	<%@ include file="header.jsp" %>
    <br /><br /><br /><br />
	<form class="container">
  		<div class="row">
  			<div class="col-md-2 text-right"></div>
  			<div class="col-md-8 text-left">
  				<h1 style="font-family: Baskerville; font-weight: bolder;">
  				<span>
	  				<img width="50" height="50" alt="delivery" src="/resources/delivery.png">
  				</span>
				Delivery
				</h1>
  			</div>
  			<div class="col-md-2"></div>
  		</div>
	</form>
	<form class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
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
						<td><button class="btn btn-primary" type="button" onClick="deliveryCheckedItems()">Delivery Items</button></td>
					</tr>
				</table>	
			</div>
			<div class="col-md-2"></div>
		</div>
	</form>
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
