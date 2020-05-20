<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie notebook = new Cookie("notebook" ,"삼성노트북");
	response.addCookie(notebook);//ch09-읽을수 잇음 , ch09-에서는 불가
	Cookie hp = new Cookie("hp" ,"갤럭시노트9");
	response.addCookie(hp);//읽을수있음 , ch09-1에서 불가
	hp.setPath("/ch09");
	hp.setMaxAge(60);
	Cookie coffie = new Cookie("coffee" ,"아이스아메리카노");
	coffie.setMaxAge(80);
	coffie.setPath("/");//읽기가능,//읽을수 잇음 ,불가
	response.addCookie(coffie);
%>
</body>
</html>