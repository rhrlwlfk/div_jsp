<%@page import="jsp.ch08.Sonata"%>
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
	Sonata myCar = (jsp.ch08.Sonata)request.getAttribute("myCar");
	out.print("myCar:" + myCar.carColor);
%>
</body>
</html>