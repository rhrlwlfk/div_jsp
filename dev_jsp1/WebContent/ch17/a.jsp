<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
<!-- html영역 로컬pc의 브라우저가 처리 주체-->
<%
//스크립틀릿 - Tomcat이 처리 주체다.
	String  name="이순신";
	out.print("이름:"+name);//결정된 정보인 이순신만 보임
	response.sendRedirect("b.jsp");
	//먼저 여기가 처리 하고 위에 title처리가됨
	//처리는 톰켓안에서 끝났다 페이지소스보기 누르면 
%>
</body>
</html>