<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Board</title>
	<script>
		function mySubmit(){
			with(document){
				var boardName = getElementById("board.boardName");
				if (boardName.value == null || boardName.value.length == 0){
					alert("Cannot be empty");
					boardName.focus();
					return false;
				}else if (boardName.value.length > 150){
					alert("The max number of board cannot exceed 50");
					boardName.focus();
					return false;
				}
				
				var boardDesc = getElementById("board.boardDesc");
				if(boardDesc.value != null && boardDesc.value.length > 255){
					alert("the description of board cannot exceed 255");
					boardDesc.focus();
					return false;
				}
				
				return true;
			}
		}
	</script>
</head>
<body>
<form action="<c:url value="/forum/addBoard.html"/>" method="post" onsubmit="return mySubmit()">
<table border="1px" width="100%">
	<tr>
		<td width="20%">The title of Board</td>
		<td width="80%"><input type="text" name="boardName" style="width:60%;"/></td>
	</tr>
	<tr>
		<td width="20%">The description of board></td>
		<td width="80%">
			<textarea style="width:80%;height:120px" name="boardDesc"></textarea>
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="save">
			<input type="reset" value="reset">
			<input type="hidden" name="_method" value="PUT">
		</td>
	</tr>
</table>
</form>
</body>
</html>