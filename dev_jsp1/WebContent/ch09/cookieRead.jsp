<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키에 담긴정보를 읽는다.</title>
<script type="text/javascript">
	function cookDel() {
		location.href = "cookieDelete.jsp";
	}
</script>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(int i=0; i<cookies.length;i++) {
			out.print(cookies[i].getName()+ "," +cookies[i].getValue()+"<br>");
		}
	}
	else{
		out.print("쿠키 정보 없음");
	}
			out.print("<br>");
%>
<input type="button" value="쿠키삭제" onClick = "cookieDel()">
</body>
</html>