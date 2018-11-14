<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入bootstrap的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<!-- 引入bootstrap-treeview的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" >
<!-- 引入bootstrap-addTabs的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/addTabs/addTabs.css" rel="stylesheet" >
<!-- 引入bootstrap-table的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/table/bootstrap-table.min.css" rel="stylesheet" >
<!-- 引入fileinput的css -->
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/fileinput/css/fileinput.min.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">


<!-- 引入jquery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/jquery.min.js"></script>
<!-- 引入my97 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/my97/WdatePicker.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootstrap/js/bootstrap.min.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/treeview/bootstrap-treeview.min.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/addTabs/addTabs.js"></script>
<!-- 引入bootstrap-table的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- 引入bootbox.js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootbox/bootbox.js"></script>
<!-- 引入fileinput的js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/fileinput/js/fileinput.min.js"></script>
<!--  引入fileinput的js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/fileinput/js/locales/zh.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/fileinput/themes/fa/theme.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>



</head>
<body>
 <button type="button" class="btn btn-default btn-lg"  onclick="addnewInfo()">新增</button>
<table id="userTable"></table>
<script type="text/javascript">


$(function (){
	$("#userTable").bootstrapTable({
		 url:"<%=request.getContextPath()%>/area/queryUser.do",	
		 method:"post",
		 striped: true,  	// 斑马线效果     默认false 
		 //只允许选中一行
		// singleSelect:true,
		 //选中行是不选中复选框或者单选按钮
		 //clickToSelect:true,
		 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		 cardView: false,                    //是否显示详细视图
		 uniqueId: "sid",                 //每一行的唯一标识，一般为主键列
		 showColumns: true,                  //是否显示所有的列
		 showRefresh: true,                  //是否显示刷新按钮
		 minimumCountColumns: 2,     //  最少留两列
		 detailView: false,                  //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[
		                  {checkbox: true,  
		                      	 visible: true },

		     	/* {field:'111',title:'ID',width:50,
					formatter:function(value,row,index){   //  格式化  当前单元格内容
						return "<input type='checkbox'  name='click'/>";
					}}, */
		     	{field:'userid',title:'ID',width:50,},
				{field:'username',title:'用户姓名',width:100},
				{field:'userpwd',title:'用户密码',width:100},
				{field:'usertype',title:'用户类型',width:100},
				{field:'enabled',title:'用户年龄',width:100},
				{field:'qq',title:'用户QQ',width:100},
				{field:'email',title:'用户邮箱',width:100},
				{field:'userphone',title:'用户手机',width:100},
				{field:'loginnumber',title:'账号',width:100},
			       {field:'111',title:'操作',width:50,
					formatter:function(value,row,index){   //  格式化  当前单元格内容
						return '<button type="button" class="btn btn-success"  onclick="delUser(\''+row.userid+'\')">删除</button><br><br><button type="button" class="btn btn-success" " onclick="updatenewInfo(\''+row.userid+'\')">修改</button>';
					}},
	
			
		         ],
		         //传递参数（*）
				 queryParams: function(params) {
					 	var whereParams = {    
					 			/*
					 				分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
					 			*/
					 			/* "pageSize":params.limit,
					 			"start":params.offset,
					 			"createtimeMin":$("#minTime").val(),
					 			"createtimeMax":$("#maxTime").val() */
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
					// sidePagination:'server',
					 pagination: true,                   //是否显示分页（*）
					 pageNum: 1,                       //每页的记录行数（*）
					 pageSize: 5,                       //每页的记录行数（*）
					 pageList: [5, 10, 15,20],        //可供选择的每页的行数（*） 
	});	
})
/*
*发送ajax请求获取jsp页面内容
*/
 function getJspHtml(urlStr){
	 var  jspHtml = "";
//	 async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
//注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
		$.ajax({
			url:urlStr,
			type:'post',
			//同步的ajax
			async:false,
			success:function(data){
				//alert(data);//data--addProduct.jsp页面内容
				jspHtml = data;
			},
			error:function(){
				bootbox.alert("ajax失败");
			}
		});
	return jspHtml;
}


function  dialog(HTMLurl,submitUrl,title){
	
	var dialog = bootbox.dialog({
		 title: title,
	    message: getJspHtml(HTMLurl),   //调用方法  
	    buttons:{
	    				"save":{
						  label: '保存',
						  //自定义样式
						  className: "btn-success",
						  callback: function() {
								$.ajax({
									url:submitUrl,
									type:'post',
									data:$("#userForm").serialize(),
									success:function(data){
											bootbox.alert("保存成功");
									$("#userTable").bootstrapTable('refresh');
									},
									error:function(){
										bootbox.alert("ajax失败");
									}
								});
						  }
						},
						"unSave":{
							  label: '取消',
							  //自定义样式
							 className: "btn-info",
							  callback: function() {
								 // return false;  //dialog不关闭
							  }
							}
					}
});
}


function addnewInfo(userid){
	dialog("<%=request.getContextPath()%>/area/tomongodialog.do?userid="+userid,"<%=request.getContextPath()%>/area/addUser.do","新增用户");

}
function updatenewInfo(userid){
	dialog("<%=request.getContextPath()%>/area/tomongodialog.do?userid="+userid,"<%=request.getContextPath()%>/area/addUser.do","新增用户");

}

function delUser(userid){
	alert(userid);
	$.ajax({
	url:'<%=request.getContextPath()%>/area/delUser.do',
	data:{
			userid : userid
	},
	success:function(){
		bootbox.alert("删除成功");
		$("#userTable").bootstrapTable('refresh');
	}
	})

}
</script>

</body>
</html>