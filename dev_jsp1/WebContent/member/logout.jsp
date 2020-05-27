<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	session.invalidate();//호출하는 
	response.sendRedirect("mapDesign3.jsp");
%>