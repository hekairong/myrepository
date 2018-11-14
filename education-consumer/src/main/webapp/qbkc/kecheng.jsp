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
			<form id="pro_from" class="form-inline">
				  <div class="form-group">	
					<input type="text" class="form-control" id="coursename" placeholder="课程名称">
					  <select id="approvalstatus" style="width:35%"  class="form-control">
		               <option value="0">-请选择状态-</option>
		               <option value="1">进行中</option>
		               <option value="2">待审批</option>
		               <option value="3">审批未通过</option>
		               <option value="4">已拒绝</option>
	                  </select>
				  </div>
				  <button type="button" class="btn btn-success" onclick="search()">搜索</button>
				  <button type="button" class="btn btn-primary" onclick="reset()">重置</button>
			</form> 
<table id="mycloudschoolTable"></table>
<script type="text/javascript">

function search(){
	
	$("#mycloudschoolTable").bootstrapTable('refresh',
			{query: {
				"coursename":$("#coursename").val(),
				"approvalstatus":$("#approvalstatus").val()
			}}
	);
	
}





$(function(){

	$("#mycloudschoolTable").bootstrapTable({
		 url:"<%=request.getContextPath()%>/controlleer/queryKeCheng.do",	
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
			{checkbox:true,title:'选项',width:20},						
	     	{field:'cousrseid',title:'课程序号',width:100},
			{field:'coursename',title:'课程名称',width:100},
	     	{field:'teachername',title:'课程教师',width:100},						
			{field:'classroomstarttime',title:'开课时间',width:100,sortable:true},
			{field:'approvalstatus',title:'状态',width:100,
			formatter: function(value,row,index){
				if(value=="1"){
					return "进行中";
				}if(value=="2"){
					return "待审批";
				}if(value=="3"){
					return "审批未通过";
				}if(value=="4"){
					return "已拒绝";
				}	    	        		
        	}
			},
			{field:'approvalstatus',title:'操作',width:100,
				formatter: function(value,row,index){
					if(value=="1"){
						return "<input type='button' value='课程详情' class='btn btn-primary' onClick=\"toEditBook('" + row.cousrseid+ "')\">";
					}if(value=="2"){
						return "<input type='button' value='课程详情' class='btn btn-primary' onClick=\"toEditBook('" + row.cousrseid+ "')\" disabled>";
					}if(value=="3"){
						return "<input type='button' value='课程详情' class='btn btn-primary' onClick=\"toEditBook('" + row.cousrseid+ "')\" disabled>";
					}if(value=="4"){
						return "<input type='button' value='课程详情' class='btn btn-primary' onClick=\"toEditBook('" + row.cousrseid+ "')\" disabled>";
					}	    	        		
	        	}
			}],
		         //传递参数（*）
				 queryParams: function(params) {
					 
					 	var whereParams = {    
					 			/*
					 				分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
					 			*/
					 			 page: this.pageNumber,
								 rows: this.pageSize,
					 			"coursename":coursename.search,//精确搜索产品名称
				                 "approvalstatus":approvalstatus.search,
					 	}
						 return whereParams;
					 },
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