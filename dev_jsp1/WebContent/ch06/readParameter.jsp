<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터출력</title>
</head>dd
<body>
name 파라미터값: <%=request.getParameter("name").toUpperCase() %>
</body>
</html>