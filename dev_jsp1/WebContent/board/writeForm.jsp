<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 새글 일때[list.jsp] 글쓰기 [버튼을 누르면]
새글과 댓글은 어떻게 구분하나요?  
  -->
  <form id="f_write">
  <div style="margin-bottom:10px">
			<input class="easyui-numberbox" id="bm_title" name="bm_title" label="제목" data-options="prompt:'Enter a 제목'" style="width:150px">
			</div>
			<div style="margin-bottom:10px">
			<input class="easyui-textbox" id="bm_write" name="bm_write" label="작성자" data-options="prompt:'Enter a 작성자'" style="width:250px">
			</div>
			<div style="margin-bottom:10px">
			<input class="easyui-textbox" id="bm_email" name="bm_email" label="이메일" data-options="prompt:'Enter a Email'" style="width:250px">
			</div>
			<div style="margin-bottom:10px">
			<input class="easyui-textbox" id="bm_content" name="bm_content" label="내용" data-options="prompt:'Enter a 내용'" style="width:250px">
			</div>
			<div style="margin-bottom:10px">
			<input class="easyui-textbox" id="bm_pw" name="bm_pw" label="비밀번호" data-options="prompt:'Enter a 비밀번호'" style="width:250px">
			</div>
					
		

			<div id="d_ins" style="margin-bottom:10px">
				<a id="btn_save"  href="javascript:emp_ins()" class= "easyui-linkbutton" data-options="iconCls:'icon-save'">저장</a>
				<a id="btn_close" href="javascript:$('#dlg_ins').dialog('close')" class= "easyui-linkbutton" data-options="iconCls:'icon-cancel'">닫기</a>
			</div>
  </form>
<!-- 댓글 일때[read.jsp] -->
<form>
			
	<input type="hidden" name ="bm_no" value="<%= 5%>"/>
	<input type="hidden" name ="bm_group" value="<%= 2%>"/>
	<input type="hidden" name ="bm_pos" value="<%= 0%>"/>
	<input type="hidden" name ="bm_step" value="<%= 0%>"/>
</form>
</body>
</html>