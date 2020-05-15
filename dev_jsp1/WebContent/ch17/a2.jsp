<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a2.jsp</title>
</head>
<body>
<!-- html영역 로컬pc의 브라우저가 처리 주체-->
<%
//스크립틀릿 - Tomcat이 처리 주체다.
	String  name="김유신";
	out.print("이름:"+name);//결정된 정보인 이순신만 보임
	request.setAttribute("name", name);//request저장소에 기록하기  저장하는 코드 이다.
	RequestDispatcher view = 
	request.getRequestDispatcher("b2.jsp");
	view.forward(request, response);//url이 유지되고 화면값이 b2가 표시된다.
	//먼저 여기가 처리 하고 위에 title처리가됨
	//처리는 톰켓안에서 끝났다 페이지소스보기 누르면 
%>
</body>
</html>