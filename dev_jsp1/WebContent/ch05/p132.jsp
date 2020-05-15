<%@page import="jsp_ch05.Sonata"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체의 영역[scope 관해서]</title>
</head>
<body>
<jsp:useBean id="himCar" scope="session" class="jsp_ch05.Sonata"/>

<%
	out.print(himCar.carColor);
	request.setAttribute("carColor", himCar.carColor);//저장소 역할 forward되는 페이지 _1들어있으니까 
	request.setAttribute("wheelNum", 4);
	RequestDispatcher view = request.getRequestDispatcher("p132-1.jsp");
	view.forward(request, response);
%>
</body>
</html>