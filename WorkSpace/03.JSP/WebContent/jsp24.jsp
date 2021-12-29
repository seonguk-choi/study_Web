<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP24</title>
</head>
<body>
<%
String name = request.getParameter("name");
out.println("회원님의 이름은 " + name + "님 입니다.<br/>");
out.println(name + "님께서 키우고 싶은 애완 동물은 ");

String[] animal = request.getParameterValues("animal");
if(animal != null){	//선택한 항목이 있다.
	for(int i = 0; i < animal.length; i++){
		if(i != animal.length - 1){	//마지막 항목이 아니므로 구분기호(,)를 작성
			out.println(animal[i] + ", ");
		}else{	//마지막 항목
			out.println(animal[i] + " 입니다.<br/>");
		}
	}
}else{	//선택한 항목이 없다.
	out.println("선택하신 항목이 없습니다.<br/>");
}
%>
<br/>
회원님의 이름은 ${param.name}님 입니다.<br/>
${param.name}님께서 키우고 싶은 애완 동물은 
	${paramValues.animal[0] }
	${paramValues.animal[1] }
	${paramValues.animal[2] }
	${paramValues.animal[3] }
	${paramValues.animal[4] } 입니다.
</body>
</html>