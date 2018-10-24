<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
	<title>Shopping Cart</title>
	<script type="text/javascript">
		function buyCheckedItems() {
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
			window.location.href = "buyItems/" + str;
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
<table>
	<c:forEach items="${OrderDetail}" var="order">
		<tr>
			<td>user</td>
			<td>${order.userName}</td>
			<td>total: $</td>
			<td>${order.total}</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td><input type="checkbox" name="checkAll" onClick="checkAllItems()"></td>
		<td>Book Title</td>
		<td>Book Price</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${ItemList}" var="orderItem">
		<tr>
			<td><input type="checkbox" id="checkIds" name="checkIds" value="${orderItem.id}"></td>
			<td>${orderItem.bookTitle}</td>
			<td>${orderItem.bookPrice}</td>
			<td>
				<spring:url value="/cart/delete/${orderItem.id}" var="deleteURL"></spring:url>
				<a href="${deleteURL}">Delete</a>
			</td>
		</tr>
	
	</c:forEach>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td><input type="submit" onClick="buyCheckedItems()" value="Buy Now"></td>
	</tr>
</table>	
</body>
</html>
