<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.* " %>
<%@ page import="com.dao.SqlMapEmpDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%--반드시 jsp주석으로 처리 할 것  --%>
<%
   String empno = request.getParameter("empno");
   int iempno = 0;
   
   Map<String, Object> pmap = new HashMap<>();
   if(request.getParameter("empno") != null) {
      iempno = Integer.parseInt(empno);
      pmap.put("empno", iempno);
   }
   SqlMapEmpDao edao = new SqlMapEmpDao();
   List<Map<String, Object>> elist = edao.empList(pmap);
   Gson g = new Gson();
   String imsi = g.toJson(elist);
   out.print(imsi);
%>