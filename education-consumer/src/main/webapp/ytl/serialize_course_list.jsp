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
				<div class="table" id="serializetable"></div>
			</div>
		</div>
	
	<script>
	$(function(){
		searchUser();
	})
	function searchUser(){
	//列表展示
	$("#serializetable").bootstrapTable({
			 url:"<%=request.getContextPath()%>/ytl/querySerializecourse.do",	
			 method:"post",
			 striped: true,  	// 斑马线效果     默认false 
			 //只允许选中一行
			 singleSelect:true,
			 //选中行是不选中复选框或者单选按钮
			 clickToSelect:true,
			 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
			 cardView: false,                    //是否显示详细视图
			 showColumns: true,                  //是否显示所有的列
			 showRefresh: true,                  //是否显示刷新按钮
			 minimumCountColumns: 2,     //  最少留两列
			 detailView: false,                  //是否显示父子表
			 //发送到服务器的数据编码类型  
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
			toolbar:'#tabToolBar',   //  工具定义位置
			columns:[
				        {checkbox:true},
						{field:'classroomid',title:'系列课程ID',align:'center',width:150},
						{field:'classroomname',title:'系列课程名称',align:'center',width:150,
							formatter:function(value,row,index){
							 
							return "<a  href='javascript:cklist(\""+row.classroomid+"\")' >"+value+"</a>";
						}},
						{field:'classroomgrade',title:'年级',align:'center',width:150},
						{field:'classroomsubject1',title:'学科',align:'center',width:150},
						{field:'teachername',title:'教师姓名',align:'center',width:150},
						{field:'tname',title:'助教',align:'center',width:150},
						{field:'classroominfo',title:'课程介绍',align:'center',width:150},
						{field:'approvalstatus',title:'审批状态',align:'center',width:150,formatter:function(value,row,index){
							var c="";
							if (value==1){
								c="审核通过";
							}
							if(value==2){
								c="未通过";
							}
							
							return c;
						}},
//	 					{field:'123',title:'操作',align:'center',width:150,formatter:function(value,row,index){
//	 						var a = '<i class = "glyphicon glyphicon-remove" onclick="deluser(\''+row.userid+'\')"></i>';
//	 						return a;
//	 					}},
					
			          ],
			         search:true,
					 //启动回车键做搜索功能
					 searchOnEnterKey:true,
			   	    //分页方式   后台请求的分页方式
					 sidePagination:'server',
					 pagination:true,                   //是否显示分页（*）
					 pageNum: 1,                       //每页的记录行数（*）
					 pageSize: 3,                       //每页的记录行数（*）
					 pageList: [3,6,9,12],
					 queryParams: function(params) {
						 	var whereParams = {    
						 			/*
						 				分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
						 			*/
						 			"rows":params.limit,
						 			"page":params.offset
						 	}
							 return whereParams;
					}
		});
		
	}
	</script>
	<script>
	
	function cklist(id){
		
// 		alert(id)
		 location.href="<%=request.getContextPath()%>/ytl/querycoursebyid.do?id="+id;
	}
	</script>
</body>
</html>