<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//jsp17.jsp에서 넘겨준 바인딩(연결) 객체를 받는다 : getAttribute(); ▶ Class Type, Casting
request.setCharacterEncoding("utf-8");
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>

<%
//dto 객체를 jsp19.jsp로 넘겨서 출력 : 동적페이지 전환(forward())
request.setAttribute("dto", dto);
%>
<jsp:forward page="jsp19.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP18</title>
</head>
<body>
○ 이름(JAVA) : <%= dto.getName() %><br/>
○ 주소(EL) : ${dto.addr }
</body>
</html>