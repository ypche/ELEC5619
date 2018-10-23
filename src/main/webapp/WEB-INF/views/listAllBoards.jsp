<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; chartset=UTF-8">
<title>Home page of Forum</title>
</head>
<body>
<table border="1px" width="100%">
	<tr>
		<td colspan="3" bgcolor="#EEEEEE">BOARDS OF FORUM</td>
	</tr>
	<tr>
	<tr>
			<td>
				<script>
					function switchSelectBox(){
						var selectBoxs = document.all("boardIds");
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
				<input type="checkbox" onclick="swithSelectBox()"/>
			</td>
			<td width="20%">The title of Board</td>
			<td width="70%">The abstract of Board</td>
			<td width="10%">The number of boards</td>
	</tr>	
	<!--<c:forEach var="board" items="${boards}">	-->
		<tr>
			<td><input type="checkbox" name="boardIds" value="${board.boardId}"/>
			</td>
			<td>${board.boardDesc}</td>
			<td>${board.topicNum} </td>
		</tr>
	<!--</c:forEach> -->	
</table>
		<script>
			function getSelectedBoardIds(){
				var selectBoxs = document.all("boardIds");
				if(!selectBoxs) return null;
				if(typeof(selectBoxs.length) == "undefined" && selectBoxs.checked){
					return selectBoxs.value;
				}else{
					var ids = "";
					var split = ""
					for (var i=0; i< selectBoxs.length; i++){
						if(selectBoxs[i].checked){
							ids += split+selectBoxs[i].value;
							split = ",";
						}
					}
					return ids;
				}
			}
			function deleteBoards(){
				var ids = getSelectedBoardIds();
				if(ids){
					var url = "<c:url value ="/board/removeboard.html"/>?boardIds="+ids+";
					//alter(url);
					location.href = url;
				}
			}
		</script>
		<input type="button" value="delete" onclick="">
</body>
</html>