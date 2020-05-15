<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제2</title>
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
   //이전문제로 이동하기
   function prev(){
	   //이렇게 이동하기는 주소가 바뀌는 성격이다. 그래서 redirect이다. 특징 유지가안된다,주소가 바뀐다,get(방식)
	   location.href="test1.jsp";
   }
   //다음문제로 넘길 때
   function next(){
	   //수험자가 입력한 답안 저장하기
	   var temp = 1;
	   for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
		   if(document.getElementById("f_test1").cb[i].checked==1){
			   document.getElementById("f_test1").htest2.value = temp;
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
<form id="f_test1" method="get" action="test3.jsp">
<input type="hidden" name="htest1" value="<%= request.getParameter("htest1")%>">
<input type="hidden" name="htest2" valye="0">
문제2
조회한 결과를 DB서버에서 가져온 후 결과를 List에 담았다. <br>
이것을 화면단에 출력하고자 할 때 사용할 메소드 이름은 무엇인지 고르시오. <br>
<input id="chk" name="cb" type="checkbox" onChange="test(0)">
① forward(request, response)<!-- 유지하고자할떄 --><br>
<input id="chk" name="cb" type="checkbox" onChange="test(1)">
② sendRedirect("페이지 이름“)<!-- 얘는 아니다 --><br>
<input id="chk" name="cb" type="checkbox" onChange="test(2)">
③ toString()<!-- 애는 아니다. --><br>
<input id="chk" name="cb" type="checkbox" onChange="test(3)">
④ print()<!-- 애는아니다. --><br>
</form>
<br>
<button onClick="prev()">이전문제</button>
<button onClick="next()">다음문제</button>
</body>
</html>