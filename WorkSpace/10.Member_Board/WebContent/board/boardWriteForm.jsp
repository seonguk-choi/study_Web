<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%
request.setCharacterEncoding("utf-8");
String id = (String) session.getAttribute("id");
if(id == null){
	out.println("<script>alert('로그인 하시기 바랍니다!');");
	out.println("location.href='memberLogin.me';</script>");
}
 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fnSubmit(){
	if(confirm("작성하신 글을 등록하시겠습니까?")){
		return true;
	}
	return false;
}

function fnReset(){
	var msg = "입력하신 내용이 삭제됩니다.";
	msg += "\n계속 진행하시겠습니까?";
	if(confirm(msg)){
		return true;
	}
	return false;
}
</script>
</head>
<body>
<div align="center">
<h3>[게시판 글쓰기]</h3>
<form action="boardAddAction.bo" method="post" onsubmit="return fnSubmit()" onreset="return fnReset()" enctype="multipart/form-data">
<input type="hidden" name="board_id" value="${id}">
<table border="1">
	<tr>
		<th>작성자</th><td>${id}</td>
	</tr>
	<tr>
		<th>글제목</th>
		<td>
			<input type="text" name="board_subject" required="required" maxlength="50"/>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea rows="15" cols="50" name="board_content" required="required"></textarea>		
		</td>
	</tr>
	<tr>
		<th>파일첨부</th>
		<td>
			<input type="file" name="board_file"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글등록"/>
			<input type="reset" value="다시작성"/>
			<input type="button" value="게시판 목록보기" onclick="location.href='boardList.bo'"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>