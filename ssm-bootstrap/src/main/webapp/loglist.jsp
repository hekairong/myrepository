<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/mystyle.jsp" %>
</head>
<body>
 <!--  条件查询的 form  表单  -->
	<!-- 表单 -->
		<form id="pro_from" class="form-inline">
		<br>
			  <div class="form-group">
			    <label for="proName">方法名</label>
			    <input type="text" class="form-control" id="proName" placeholder="方法名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputFile">创建时间</label>
			    <input class="form-control " id="minTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'maxTime\')}'})" />至
				<input  class="form-control " id="maxTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'minTime\')}'})" /><br/>
			  </div>
			  <br><br>
			  <button type="button" class="btn btn-success" onclick="search()">搜索</button>
			  <button type="button" class="btn btn-primary" onclick="reset()">重置</button>
		</form>
<table id="findLog"></table>

<script type="text/javascript">

function search(){
	$("#findLog").bootstrapTable('refresh',
			{query: {
	 			"minDate":$("#minTime").val(),
	 			"maxDate":$("#maxTime").val(),
	 			//"product.proType":$("#proType").val(),
			}}
	);
	
}



$().ready(function(){
	$("#findLog").bootstrapTable({
		 url:"<%=request.getContextPath()%>/log/findLog.do",	
		 method:"post",
		 striped: true,  	// 斑马线效果     默认false 
		 //只允许选中一行
		 singleSelect:true,
		 //选中行是不选中复选框或者单选按钮
		 clickToSelect:true,
		 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		 cardView: false,                    //是否显示详细视图
		 uniqueId: "logInfoId",                 //每一行的唯一标识，一般为主键列
		 showColumns: true,                  //是否显示所有的列
		 showRefresh: true,                  //是否显示刷新按钮
		 minimumCountColumns: 2,     //  最少留两列
		 detailView: false,                  //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[
		     	{field:'logInfoId',title:'日志ID',width:50,
					formatter:function(value,row,index){   //  格式化  当前单元格内容
						return "<input type='checkbox' value="+value+" name='chk'/>";
					}
				},
				{field:'method',title:'方法名',width:100},
				{field:'paramVal',title:'参数',width:100,sortable:true},
				{field:'methDate',title:'创建时间',width:100,
					 	formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
							var simfomat = new Date();
			        		simfomat.setTime(value);   //转换时间           
			        		return  simfomat.toLocaleDateString();
						} 
					}
		         ],
		         //传递参数（*）
				 queryParams: function(params) {
					 	var whereParams = {    
					 			/*
					 				分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
					 			*/
					 			"pageSize":params.limit,
					 			"start":params.offset,
					 			"minDate":$("#minTime").val(),
					 			"maxDate":$("#maxTime").val(),
					 			//"pro_name":params.search,//精确搜索产品名称
					 	}
						 return whereParams;
					 },
					 //前台--排序字段
					 //sortName:'proPrice',
					 //sortOrder:'desc',
					 //前台--搜索框
					 search:true,
					 //启动回车键做搜索功能
					 searchOnEnterKey:true,
			   	    //分页方式   后台请求的分页方式
					 sidePagination:'server',
					 pagination: true,                   //是否显示分页（*）
					 pageNum: 1,                       //每页的记录行数（*）
					 pageSize: 3,                       //每页的记录行数（*）
					 pageList: [3, 6, 9,12],        //可供选择的每页的行数（*） 
	});
});
</script>
</body>
</html>