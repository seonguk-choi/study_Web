<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//매개변수를 받는다(가져온다) : getParameter();
String name = request.getParameter("name");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
int age = Integer.parseInt(request.getParameter("age"));
String addr = request.getParameter("addr");
String tel = request.getParameter("tel");

//DTO 객체를 생성
MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);

//현재 페이지에서만 사용할 바인딩(연결) 객체 생성 : EL문법(표현식)에서 사용하기 위해서
pageContext.setAttribute("dto", dto);
%>

<jsp:useBean id="actionDTO" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="actionDTO"/>
</jsp:useBean>

<%-- dto 객체를 jsp18.jsp 넘겨서 출력 : 동적페이지전환(forward()) --%>
<%
request.setAttribute("dto", dto);	//요청한 페이지에서 사용할 바인딩(연결) 객체 : request scope
//RequestDispatcher rd = request.getRequestDispatcher("jsp18.jsp");	//페이지호출
//rd.forward(request, response);	//페이지 전환
%>
<jsp:forward page="jsp18.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP17</title>
</head>
<body>
○ 이름[JAVA(Parameter)] : <%= name %><br/>
○ 이름[JAVA(dto)] : <%= dto.getName() %><br/>
○ 이름[JAVA(actionDTO)] : <%= actionDTO.getName() %><br/>
<br/>

○ 아이디[Action Tag(Parameter)] : 매개변수로 전달 받은 상태에서는 사용 불가능<br/>
○ 아이디[Action Tag(dto)] : [jsp:useBean]으로 생성된 객체에서만 사용 가능<br/>
○ 아이디[Action Tag(actionDTO)] : <jsp:getProperty property="id" name="actionDTO"/><br/>
<br/>

○ 주소[EL(Parameter)] : ${param.addr }<br/>
○ 주소[EL(dto)] : ${dto.addr }<br/>
○ 주소[EL(actionDTO)] : ${actionDTO.addr }
</body>
</html>
