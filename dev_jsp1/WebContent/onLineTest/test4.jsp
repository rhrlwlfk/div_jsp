<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String htest_3 = request.getParameter("htest3");		
	Cookie chtest3 = new Cookie("c_htest3", htest_3);
	chtest3.setMaxAge(60*60);
	response.addCookie(chtest3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제3</title>
<%@ include file="../common/jEasyUICommon.jsp"%>
<script type="text/javascript">
   //수험자가 선택한 답안을 
   function test(dap){
      //alert("당신이 선택한 답안은"+dap+" 입니다.");
      	for(var i=0;i<document.f_test.cb.length;i++){
      		if(dap == i) {
      			document.getElementById("f_test1").cb[i].checked = 1;
      		}else {
      			document.getElementById("f_test1").cb[i].checked = 0;
      		}
      	}
   }   
   //이전문제로 넘길떄
      function prev(){
	   //이렇게 이동하기는 주소가 바뀌는 성격이다. 그래서 redirect이다. 특징 유지가안된다,주소가 바뀐다,get(방식)
	   location.href="test2.jsp";
   }
   //다음문제로 넘길 때
   function next(){
	   //수험자가 입력한 답안 저장하기
	   var temp = 1;
	   for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
		   if(document.getElementById("f_test1").cb[i].checked==1){
			   document.getElementById("f_test1").htest4.value = temp;
		   }
		   else{
			   temp = temp + 1;
		   }
	   }
	   alert("temp:" + temp);
       document.getElementById("f_test1").submit();
       //$("#f_test1"){      } 
   }
</script>
</head>
<body>
<!--document -- 아들이 html임 form태크로 묶어놈 그리고 checkbox로 해놨음 
checkbox는 체크할수도있고 안할수도있다. true,false로 제어해야되고 이안에 체크된애들이  form태그로 넘어가는거다.
  다음문제에서 푸는사람의 답을 가져온다. 수험자 몰래 숨겨서 id로 접근하자  
  -->
<form id="f_test1" method="get" action="send.jsp">
<input type="hidden" name="htest4" value="0">
문제4
Bean의 Scope에 대한 설명으로 틀린 것은?<br>
<input id="chk" name="cb" type="checkbox" onChange="test(0)">
① page: 기본값이며 그 페이지 내에서만 접근할 수 있다.<br><!-- 답아님 -->
<input id="chk" name="cb" type="checkbox" onChange="test(1)">
② request: forward, include에서 사용가능하다.<br><!-- 답아님 -->
<input id="chk" name="cb" type="checkbox" onChange="test(2)">
③ session: 사용자가 로그인 하면 시간에 제약없이 무한히 유지된다.<br><!-- 답 -->
<input id="chk" name="cb" type="checkbox" onChange="test(3)">
④ application: 서버를 재기동하기 전까지는  시간에 제약없이 무한히 유지된다.<br><!-- 답아님 -->
</form>
<br>
<button onClick="prev()">이전문제</button>
<button onClick="next()">다음문제</button>
</body>
</html>