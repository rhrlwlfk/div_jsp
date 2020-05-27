<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   		List<Map<String,Object>> memList = (List<Map<String,Object>>)request.getAttribute("memList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/jEasyUICommon.jsp" %>
<title>회원목록</title>
</head>
<body>
회원 목록보기
<table class="easyui-datagrid">
    <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
        </tr>
    </thead>
    <tbody>
<%
	if(memList.size()>0){//검색결과가 있을떄
		for(int i=0; i<memList.size(); i++) {
			Map<String,Object> rmap = memList.get(i);
		
%>
    <tr>
    	<td>
    		<%=rmap.get("MEM_ID") %>
    	</td>
    	<td>
    		<%=rmap.get("MEM_NAME") %>
    	</td>
    </tr>
<%
		}
	}else {//검색 결과가 없을 때
%>    
	<tr>
		<td colspan="2">목록이 없습니다</td>
	</tr>
<%
	}
%>
    </tbody>
</body>
</html>