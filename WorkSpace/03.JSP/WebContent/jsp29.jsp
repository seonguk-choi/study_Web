<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- JSTL core Tag를 사용하기 위해서는 반드시 문서 상단에 기술 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP29</title>
</head>
<body>
1. 기본프로그래밍 Tag : 변수, 배열, 조건문(if), 반복문(for) 등 ▶ core<br/>
<%
//JAVA에서의 변수 선언 및 초기화
int num1 = 100;
%>
○ JAVA num1 : <%= num1 %><br/>

<%-- JSTL 변수 선언 및 초기화 : <c:set ~~> --%>
<c:set var="num2" value="200"/>
○ JSTL num2 : ${ num2 }<br/>

<%-- JAVA num1값을 JSTL num3 할당 --%>
<c:set var="num3" value="<%= num1 %>"/>
○ JSTL num3 : ${ num3 }<br/>

<%-- JSTL num2값과 num3값을 더한 값을 result 변수에 할당 --%>
<c:set var="result" value="${num2 + num3}"/>
○ JSTL result : ${ result }
</body>
</html>
