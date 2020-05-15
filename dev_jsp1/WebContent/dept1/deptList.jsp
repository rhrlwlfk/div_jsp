<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서목록</title>
<%@ include file="../common/jEasyUICommon.jsp" %>
</head>
<body>
조회
<table id="dg_datgrid" class="easyui-datagrid">
</table>
	<table id ="dg_datagrid" class="easyui-datagrid">
	</table>
<script type="text/javascript">
	function searchList() {
		$("#dg_datgrid").datagrid({
			url:"deptList.do"
	});
	}
	$("#dg_datgrid").datagrid({
		title:"부서정보",
		 columns:[[//columns2로 바꾸면 화면이 화면이 깨진다.
		        {field:'DNAME',title:'부서명',width:100},
		        {field:'LOC',title:'지역',width:100},
		        {field:'DEPTNO',title:'부서번호',width:100},
		    ]]
		,toolbar: [{
				text: '조회'				
				,iconCls: 'icon-search'
				,handler: function(){searchList();}
		}]
	});
</script>
</body>
</html>