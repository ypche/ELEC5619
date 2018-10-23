<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${topic.topicTitle}</title>
</head>
<body>
<div style="float=right"><a href="#replyZone">Reply</a></div>
<table border="1px" width="100%">
	<c:forEach var="post" items="${pagedPost.result}">
		<tr>
			<td colspan="2">${post.postTitle}</td>
		</tr>
		<tr>
			<td width="20%">
			User: ${post.user.userName}<br>
			Time: <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${post.createTime }"/></td>
		</tr>
	</c:forEach>
</table>
		<script>
			   function mySubmit(){
			      with(document){
			         var postTitle = getElementById("post.postTitle");
			         if(postTitle.value != null && postTitle.value.length > 50){
			            alert("Cannot exceed 50");
			            postTitle.focus();
			            return false;
			         }
			          
			         var postText = getElementById("post.postText");
			         if(postText.value == null || postText.value.length < 10){
			            alert("cannot less than 10");
			            postText.focus();
			            return false;
			         }
			           
			         return true;
			      }
			      
			   }
			</script>	
<form action="<c:url value="/board/addPost.html"/>" method="post" onsubmit="return mySubmit()">
Reply<hr>
<table border="1px" width="100%">
	<tr>
		<td width="20%">Title</td>
		<td width="80%"><input type="text" name="postTitle" style="width:100%" /></td>
	</tr>
	<tr>
		<td width="20%">Content</td>
		<td width="80%"><textarea style="width:100%;height:100px"  name="postText"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		   <input type="submit" value="save">
		   <input type="reset" value="reset">
		   <input type="hidden" name="boardId" value="${topic.boardId}"/>
		   <input type="hidden" name="topic.topicId" value="${topic.topicId}"/>
		</td>
	</tr>
</table>
</form>			
</body>
</html>