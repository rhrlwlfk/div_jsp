<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>폼 생성</title>
</head>
<body>r
<form action="/ch03/parameterAction.do" method="post">
이름:<input type="text" name="name" size="10"> <br>
주소:<input type="text" name="address" size="10"> <br>
좋아하는 동물
주소:<input type="checkbox" name="pet" value="dog">강아지 <br>
주소:<input type="checkbox" name="pet" value="cat"> 고양이<br>
주소:<input type="checkbox" name="pet" value="pig"> 돼지<br>
<br>
<input type="submit" value="전송">
</form>
</body>
</html>