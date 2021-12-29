<%@ page import="com.hanul.DTO.StudentDTO"%>
<%@ page import="com.hanul.DAO.OmrDAO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
StudentDTO dto = (StudentDTO) request.getAttribute("dto");
pageContext.setAttribute("dto", dto);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student Insert From</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function fnSubmit(){
	if(confirm("학생을 추가하시겠습니까?")){
		return true;
	}
	return false;
}

function fnReset(){
	var msg = "입력하신 내용이 모두 지워집니다!";
	msg += "\n계속 진행하시겠습니까?";
	if(confirm(msg)){
		return true;
	}
	return false;
}
</script>
</head>
<body>
<div class="middle" align="center">
<h3>수험생정보 추가화면</h3>
<form action="adminInsert.do" method="post" onsubmit="return fnSubmit()" onreset="return fnReset()">
<table class="styled-table" >
	<tr>                                                                                                                   
		<th>이름</th>                                                                                                      
		<td><input type="text" name="name" value="${dto.name}" required="required" class="in"/></td>                       
	</tr>                                                                                                                  
	<tr>                                                                                                                   
		<th>수험번호</th>
		<td><input type="number" name="std_code" value="${dto.std_code}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>점수</th>
		<td><input type="number" name="score" value="${dto.score}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>합격결과</th>
		<td><input type="text" name="result" value="${dto.result}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>응시여부</th>
		<td><input type="text" name="apply" value="${dto.apply}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>매니저유무</th>
		<td><input type="text" name="manager" value="${dto.manager}" required="required" class="in"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="학생추가"/>
			<input type="reset" value="초기화하기"/>
			<input type="button" value="목록보기" onclick="location.href='adminList.do'"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>