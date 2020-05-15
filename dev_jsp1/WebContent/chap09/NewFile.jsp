<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function search() {
		
			alert("안녕");
	
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<form id="ff">
	문제1번<br>
    <div style="margin-bottom:20px">
        <input class="easyui-checkbox" name="fruit" value="one" >
        ① init() - service() - destroy()
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-checkbox" name="fruit" value="two" >
        ② service() - destroy() - init()
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-checkbox" name="fruit" value="three" >
        ③ destroy() - init() - service()
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-checkbox" name="fruit" value="four" >
       ④ doGet() - destroy() - init() - service()
    </div>
        <div style="margin-bottom:20px">
        <input class="easyui-linkbutton" name="fruit" value="제출" onclick="search()">
     
    </div>
</form>
</body>
</html>