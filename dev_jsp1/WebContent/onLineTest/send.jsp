<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String htest_4 = request.getParameter("htest4");		
	Cookie chtest4 = new Cookie("c_htest4", htest_4);
	chtest4.setMaxAge(60*60);
	response.addCookie(chtest4);
%>

<form method="get" action="account.jsp">
<input type="submit" value= "체점하기"></button>
</form>