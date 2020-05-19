<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Cookie[] cookies = request.getCookies();
	String h_no = null;
	if(cookies!=null && cookies.length > 0) {
		for(int i=0;i<cookies.length;i++) {
			if("c_hno".equals(cookies[i].getName())){
				h_no = cookies[i].getValue();
			}
		}
	}
	out.print("h_no:" + h_no+" ");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>onLineTest쿠키활용</title>

</script>
</head>
<body>
<form method="get" action="test1.jsp">
	수험번호:<input type="hidden" name="h_no" value ="20200515001">
	수험이름<input type="hidden" name="h_name" value ="이순신">
<input type="submit" value="시험시작">
</form>
</body>
</html>