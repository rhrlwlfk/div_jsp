<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String htest1 = request.getParameter("htest1");
	String htest2 = request.getParameter("htest2");
	String htest3 = request.getParameter("htest3");
	String htest4 = request.getParameter("htest4");
	out.print(htest1 +" " + htest2 +" " +htest3 +" " + htest4);
	
	String b_no = request.getParameter("b_no");
	String b_name = request.getParameter("h_name");
	out.print(" <br> ");
	out.print(b_no + "," + b_name);//null,null
%>
<form method="get" action="account.jsp">
<input type="hidden" name="htest1" value="<%=htest1 %>">
<input type="hidden" name="htest2" value= "<%=htest2 %>">
<input type="hidden" name="htest3" value= "<%=htest3 %>">
<input type="hidden" name="htest4" value= "<%=htest4 %>">
<input type="submit" value= "체점하기"></button>
</form>