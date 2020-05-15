<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function search(){
		var value = document.getElemensByNAME
	}
</script>
</head>
<body>
문제1
서블릿 메소드의 호출 순서로 맞는 것은?
<form  method="post" action="dop.jsp">
<br>
<input type="checkbox" name="lang" value="1"> ① init() - service() - destroy()
<br>
<input type="checkbox" name="lang" value="2"> ② service() - destroy() - init()
<br>
<input type="checkbox" name="lang" value="3"> ③ destroy() - init() - service()
<br>
<input type="checkbox" name="lang" value="4"> ④ doGet() - destroy() - init() - service()
<br>
<input type="submit" onclick="search()"value="제출" ></input>
</form>
</body>
</html>