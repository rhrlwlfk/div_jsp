<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="himCar" scope="session" class="jsp_ch05.Sonata"/>

<%
	String imsi =(String)request.getAttribute("carColor");
	out.print("carColor:" +imsi);
	out.print("<hr>");
	out.print("carColor:" +request.getAttribute("wheelNum"));
%>
</body>
</html>