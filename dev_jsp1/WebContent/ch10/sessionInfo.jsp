<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat();
	
%>
<head><title>세션정보</title></head>
<body>
세션ID : <%= session.getId() %> <br>
<%
	time.setTime(session.getCreationTime());
%>
세션생성 시간 : <%= formatter.format(time) %><br>
<%
	time.setTime(session.getLastAccessedTime());
%>
최근 접근시간: <%=formatter.format(time) %>
</body>