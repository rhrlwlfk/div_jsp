<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String htest_2 = request.getParameter("htest2");		
	Cookie chtest2 = new Cookie("c_htest2", htest_2);
	chtest2.setMaxAge(60*60);
	response.addCookie(chtest2);
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
			   document.getElementById("f_test1").htest3.value = temp;
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
<form id="f_test1" method="get" action="test4.jsp">
<input type="hidden" name="htest3" value="0">
문제3
자바를 이용하여 오라클과 같은 db서버에 접속하여 조회, 입력,수정, 삭제와 같은 업무처리를
하고 싶다. <br>이때 오라클에서 제공하는 드라이버 클래스를 가지고 있는 ojdbc6.jar를 참조해야
하는데 이 파일의 배포 위치로 맞는 것을 고르시오.<br>
<input id="chk" name="cb" type="checkbox" onChange="test(0)">
① WEB-INF\classes<br><!--컴파일된 걸 넣어준다.-->
<input id="chk" name="cb" type="checkbox" onChange="test(1)">
② WEB-INF\lib<br><!-- 드라이버클래스를 넣어준다.-->
<input id="chk" name="cb" type="checkbox" onChange="test(2)">
③ WEB-INF\jspBean<br>
<input id="chk" name="cb" type="checkbox" onChange="test(3)">
④ WEB-INF\jsp<br>
</form>
<br>
<button onClick="prev()">이전문제</button>
<button onClick="next()">다음문제</button>
</body>
</html>