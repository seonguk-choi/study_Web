<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP31</title>
</head>
<body>
제품코드 : ${code}<br/>
제품명 : ${name}<br/>
제품가격 : ${price}

<%--
request.setCharacterEncoding("utf-8");
String code = (String) request.getAttribute("code");
String name = (String) request.getAttribute("name");
Integer price = (Integer) request.getAttribute("price");

out.println("제품코드 : " + code);
out.println("제품명 : " + name);
out.println("제품가격 : " + price);
--%>
</body>
</html>