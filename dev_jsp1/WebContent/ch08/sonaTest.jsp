<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jsp.ch08.Sonata"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		Sonata myCar = new Sonata();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sonata Test</title>
<script type="text/javascript">
	function moveB() {
		<%
		request.setAttribute("myCar", myCar);
		RequestDispatcher view = request.getRequestDispatcher("b.jsp");
		view.forward(request, response);
		%>
	}
</script>
</head>
<body>

<button onclick="moveB()"> b로 이동</button>
</body>
</html>