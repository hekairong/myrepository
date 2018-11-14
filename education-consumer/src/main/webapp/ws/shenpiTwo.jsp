<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/commons/mystyle.jsp" %>
</head>
<body>
<br>
<div style="background-color: #ffcc33;width:940px;height:800px">
	<div style="background-color: #8a8a8a;width:920px;height:230px;margin-top: 10px;margin-left: 10px;margin-right: 10px">
	<br>
	<h2>
             系列课程:
	</h2>
	<h2 class="hLh30 txtOf mt10" id="times">
		    ${hx.}
	</h2>
	<input type="hidden" name="classroomid" value="${hx. }">	
    <h3>开课时间:</h3>
	<h2 class="hLh30 txtOf mt10" id="times">
		    ${hx.}
	</h2>
    <h4 class="hLh30 txtOf mt10">
	授课年段:<font>${hx.}</font>
	</h4>
	<h4 class="hLh30 txtOf mt10">
	学科范畴:<font>${hx.}</font>
	</h4>  
<br><br> 
	</div>
	<div style="background-color: #ffffcc;width:920px;height:550px;margin-bottom: 10px;margin-top: 10px;margin-left:10px;float:left">
	<br>
	<h4 class="hLh30 txtOf mt10">
	授课年段:<br/><h5><font>${hx.}</font></h5>
	</h4> 
	<h4 class="hLh30 txtOf mt10">
	课时:<br/><h5>共计1课时</h5>
	</h4>
	<h4 class="hLh30 txtOf mt10">
	课程简介:<br/><font>${hx.}</font>
	</h4>
	<h4 class="hLh30 txtOf mt10">
	学生:<br/><h5><font>${hx. }</font>
	</h4>
	<h4 class="hLh30 txtOf mt10">
	课程计划:
	</h4>
	<br/><table id="zijie"></table>	
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("#zijie").bootstrapTable({
		 url:"<%=request.getContextPath()%>/controlleer/queryZiJie.do",	
		 method:"post",
		 striped: true,  	// 斑马线效果     默认false 
		 //只允许选中一行
		 singleSelect:false,
		 //选中行是不选中复选框或者单选按钮
		 clickToSelect:true,
		 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		 cardView: false,                    //是否显示详细视图
		 uniqueId: "id",                 //每一行的唯一标识，一般为主键列
		 showColumns: true,                  //是否显示所有的列
		 showRefresh: true,                  //是否显示刷新按钮
		 minimumCountColumns: 2,     //  最少留两列
		 detailView: false,                  //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[						
	     	{field:'soncounrseid',title:'课程序号',width:100},
			{field:'soncoursename',title:'课程名称',width:100},						
			{field:'soncoursestarttime',title:'开课时间',width:100,sortable:true},
			],
					 //前台--排序字段
					 //sortName:'proPrice',
					 //sortOrder:'desc',
					 //前台--搜索框
					 //search:true,
					 //启动回车键做搜索功能
					 searchOnEnterKey:true,
			   	    //分页方式   后台请求的分页方式
					 //sidePagination:'server',
					 pagination: true,                   //是否显示分页（*）
					 pageNum: 1,                       //每页的记录行数（*）
					 pageSize: 3,                       //每页的记录行数（*）
					 pageList: [3, 6, 9,12],        //可供选择的每页的行数（*） 
	});
});
</script>
</body>
</html> 