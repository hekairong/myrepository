<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap3/css/bootstrap.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap3/css/bootstrap-theme.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap-table/bootstrap-table.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">

<script  src="<%=request.getContextPath()%>/ytl/js/jquery.min.js"></script>
<script  src="<%=request.getContextPath()%>/ytl/js/bootstrap3/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-table/bootstrap-table.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-bootbox/bootbox.js"></script>


</head>
<body>
<div class="container-fluid">
		<div class="row">
				<div class="table" id="course">
				</div>
				<input type="hidden" value="${id}" id="id">
			</div>
</div>
	
</body>
<script>
	$(function(){
		searchUser();
	})
	//列表展示
	function searchUser(){
		var id=$("#id").val();
		$('#course').bootstrapTable({
			//toolbar:'#toolbar',
			url:'<%=request.getContextPath()%>/ytl/querycourseid.do?id='+id,  //获取数据地址 
// 			pagination:true, //是否展示分页
			method:'post',
// 			pageList:[5, 10, 20, 50],//分页组件
			pageNumber:1,
// 			pageSize:5,//默认每页条数
			//search:true,//是否显示搜索框
			//searchText:'试试',//初始化搜索文字
			showColumns:false,//是否显示 内容列下拉框
			showToggle:false,//是否显示 切换试图（table/card）按钮
			showPaginationSwitch:false,//是否显示 数据条数选择框
			showRefresh:false,//是否显示刷新按钮
			detailView:false,//设置为 true 可以显示详细页面模式。
			showFooter:false,//是否显示列脚
			clickToSelect: false, //是否启用点击选中行
			contentType:"application/x-www-form-urlencoded;charset=UTF-8",
			sidePagination:'server',//分页方式：client客户端分页，server服务端分页（*
			striped:true,
// 			queryParams:function(){
// 				var name = $('#name').val();
// 				var starttime = $('#starttime').val();
// 				var endtime = $('#endtime').val();
// //	 			alert(endtime)
// 				return {
// 					page: this.pageNumber,
// 					rows: this.pageSize
					
// 					};
// 			},

			columns:[
			        {checkbox:true},
					{field:'soncounrseid',title:'系列课程ID',align:'center',width:150},
					{field:'soncoursename',title:'年级',align:'center',width:150},
					{field:'soncoursestarttime',title:'学科',align:'center',width:150},
					{field:'soncourseendtime',title:'教师类型',align:'center',width:150},
				
		          ]
		});
		
	}
	</script>
</html>