<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp[include 디렉티브.태그]</title>
</head>
<body>
include도 요청을 계속 유지하고 있는것으로 판단함.
첫째<br>
둘째<br>
<%
	String id ="test";
%>
<jsp:include page="b2.jsp" flush="true">
<jsp:param value="" name=""/> 
넷째<br>
다섯째<br>
</body> 
</html>