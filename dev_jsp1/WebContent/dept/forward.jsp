<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서목록</title>
</head>
<body>
<form action="deptList.do" method="get">
<br>부서번호
<input type="text" name="deptno">
<input type="submit" value="전송">
<%
	Map<String,Object>rmap = (Map<String,Object>) request.getAttribute("rmap");
	out.print(rmap);
%>
</form>
</body>
</html>