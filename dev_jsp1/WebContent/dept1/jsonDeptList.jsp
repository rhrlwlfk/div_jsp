<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//total레코드가 필요하다.
	List<Map<String,Object>> deptList = 
		(List<Map<String,Object>>)request.getAttribute("rlist");//getAttribute이나오면 forward이다 servlet이다.
	Gson g = new Gson();
	String imsi = g.toJson(deptList);
	out.print(imsi);
%>