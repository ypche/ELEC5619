<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Publish new topic</title>
	<script>
		function mySubmit(){
		      with(document){
		         var topicTitle = getElementById("topicTitle");
		         if(topicTitle.value == null || topicTitle.value.length ==0){
		            alert("Cannot be empty.");
		            topicTitle.focus();
		            return false;
		         }else if(topicTitle.value.length > 100){
		            alert("Cannot > 100.");
		            boardName.focus();
		            return false;
		         }
		          
		         var postText = getElementById("mainPost.postText");
		         if(postText.value == null || postText.value.length < 10 ){
		            alert("Must > 10");
		            postText.focus();
		            return false;
		         }
		           
		         return true;
		      }
		      
		 }
	</script>
</head>
<body>
<form action="<c:url value="/board/addTopic.html" />" method="post" onsubmit="return mySubmit()">
<table border="1px" width="100%">
	<tr>
		<td width="20%">Title</td>
		<td width="80%">
		<input style="width:80%;"  name="topicTitle" value="${topic.topicTitle}">
	</tr>
	<tr>
		<td width="20%">Content</td>
		<td width="80%">
		<textarea style="width:100%;height:400px"  name="mainPost.postText">${topic.mainPost.postText}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		   <input type="submit" value="save">
		   <input type="reset" value="reset">
		   <input type="hidden" name="boardId" value="${boardId}"> 
		</td>
	</tr>
</table>
</form>
</body>
</html>