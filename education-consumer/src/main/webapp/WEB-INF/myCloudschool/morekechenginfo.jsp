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
	我的云学堂>课堂详情
	<input type="hidden" name="classroomid" value="${hx.classroomid }">
	<h2 class="hLh30 txtOf mt10" id="times">
		    ${hx.classroomname}
		    </h2>
	<h5 class="hLh30 txtOf mt10">
		            授课年段:<font>${hx.classroomgrade }</font>
			</h5>
			<h5 class="hLh30 txtOf mt10">
		           学科范围:<font>${hx.coursename }</font>
			</h5>
			<br><br>
			<button type="button" onclick="enterClassRoom()" class="btn btn-primary">进入课堂</button>
	</div>
	
	<div style="background-color: #ffffcc;width:500px;height:550px;margin-bottom: 10px;margin-top: 10px;margin-left:10px;float:left">
	<br>
	课堂详情<br><br>
	课程简介：<font>${hx.classroominfo }</font><br><br>
	学生：<font>${hx.classroomstudent }</font><br><br>
	课程列表
	<table id="zikecheng"></table>
	</div>
	<div style="background-color: #ffffcc;width:410px;height:270px;margin-bottom: 10px;margin-top: 10px;margin-left:10px;float:right;margin-right: 10px">
	任课老师<br><br>
	<section class="course-img">
		<img  src="<%=request.getContextPath() %>/img/123.jpg" width="50" height="50">
	</section>
	<h4>${hx.teachername }</h4>
	</div>
	<div style="background-color: #ffffcc;width:410px;height:270px;margin-bottom: 10px;float:right;margin-right: 10px">
	助理教师<br><br>
	<section class="course-img">
		<img  src="<%=request.getContextPath() %>/img/123.jpg" width="50" height="50">
	</section>
	<h2>${hx.helpteachername }</h2>
	</div>
</div>
<input type="hidden" id = "kkk" value = "${hx.classroomid }">
<script type="text/javascript">

$(function(){
	seach();
})
function seach(){
	var kkkk = $("#kkk").val();
	$("#zikecheng").bootstrapTable({
		 url:"<%=request.getContextPath()%>/yunschool/queryzikechenglist.do",	
		 method:"post",
		 striped: true,  	// 斑马线效果     默认false 
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[	
			     	{field:'soncounrseid',title:'序号',width:100},
					{field:'soncoursename',title:'名称',width:100},
					{field:'soncoursestarttime',title:'开课时间',width:100,sortable:true	},
/* 					{field:'approvalstatus',title:'状态',width:100,sortable:true,
						formatter:function(value,row,index){
							if(value=="1"){
								return"进行中"
							}if(value=="2"){
								return"已结束"
							}
						}
					}, */
				],
					 sidePagination:'server',
					 queryParams: function(params) {
						 	var whereParams = {    
						 			"classroomid":kkkk
						 	}
							 return whereParams;
					}
	});
}

</script>
</body>
</html>