<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b2.jsp</title>
</head>
<body>
<%
	String name = null;
	name = (String)request.getAttribute("name");
	out.print("이름:" +name);
%>
</body>
</html>