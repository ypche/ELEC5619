<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Board Page</title>
		<script>
		
		</script>
	</head>
	<body>
		<div>
			<table border="1px" width="100%">
				<tr>
					<td bgcolor="#EEEEEE">
						${board.boardName}
					</td>
					<td colspan="4" bgcolor="#EEEEEE" align="right">
						<a href="<c:url value="/board/addTopicPage-${board.boardId}.html"/>">Publish new topic</a>
					</td>
				</tr>
				<tr>
					<td>
						<script>
							function swithSelectBox(){
								var selectBoxs = document.all("topicIds");
								if(!selectBoxs) return;
								if(typeof(selectBoxs.length) == "underfined"){
									selectBoxs.checked = event.srcElement.checked;
								}else{
									for(var i=0; i < selectBoxs.length; i++){
										selectBoxs[i].checked = event.srcElement.checked;
									}
								}
							}
						</script>
						<input type="checkbox" onclick="swithchSelectBox()"/>
					</td>
					<td width="50%">
						Title
					</td>
					<td width="10%">
						Publisher
					</td>
					<td width="15%">
						Replies Number
					</td>
					<td width="15%">
						Latest Time
					</td>
				</tr>
				<c:forEach var="topic" items="${pagedTopic.result}">
				  <tr>
					<td><input type="checkbox" name="topicIds" value="${topic.topicId}"/>
					</td>
					<td>
						<a href="<c:url value="/board/listTopicPosts-${topic.topicId}.html"/>">
						<c:if test="${topic.digest > 0 }">
							<font color=red>*</font>
						</c:if>
						${topic.topicTitle}
						</a>
					</td>
					<td>
						${topic.user.userName }
						<br>
						<br>
					</td>
					<td>
						${topic.replies}
						<br>
						<br>
					</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${topic.createTime}"/>
					</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${topic.lastPost}"/>
					</td>
				  </tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>