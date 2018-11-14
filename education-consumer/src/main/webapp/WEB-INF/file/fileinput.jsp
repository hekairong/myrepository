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
<div class="container-fluid">
		<form id="pro_from" class="form-inline">
			  <div class="form-group">
			    <input type="text" class="form-control" id="filename" placeholder="请输入关键字">
			  </div>
			  <button type="button" class="btn btn-success" onclick="search()">搜索</button>
			  <button type="button" class="btn btn-primary" onclick="reset()">重置</button>
		</form> 
<button type="button" class="btn btn-error" onclick="addMongo()">新增</button>
</div>				
        <div> 
             <table id="fileMongo"></table>
       </div>

<script type="text/javascript">

function search(){
	
	$("#fileMongo").bootstrapTable('refresh',
			{query: {
				"filename":$("#filename").val(),
			}}
	);
	
}	


$(function (){
	$("#fileMongo").bootstrapTable({
		 url:"<%=request.getContextPath()%>/controlleer/findMongo.do",	
		 method:"post",
		 striped: true,  	// 斑马线效果     默认false 
		 //只允许选中一行
		 singleSelect:false,
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
					{checkbox:true,title:'选项',width:20},					
			     	{field:'fileid',title:'文件id',width:100},
					{field:'filename',title:'文件名称',width:100},
					{field:'time',title:'上传时间',width:100,sortable:true	},
					{field:'size',title:'大小',width:100,sortable:true},
					{field:'fileImg',title:'文件',width:100,sortable:true,
						formatter:function(value,row,index){//  格式化  当前单元格内容									 							
					      return '<img src='+value+' width="120px">'					
							
						}
					},
					{field:'edit',title:'操作',width:100,
						formatter:function(value,row,index){
							return "<input type='button' value='删除' class='btn btn-primary' onClick=\"delUser('" + row.fileid + "')\">";
						}	
					}
				],
		         //传递参数（*）
		         //
				 queryParams: function(params) {
					 var whereParams = {    
						 		//分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
					 			"pageSize":params.limit,
					 			"start":params.offset,
					 			"filename":filename.search,
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
	
})

function getJspHtml(urlStr){
 var  jspHtml = "";
// async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
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
								data:$("#logForm").serialize(),
								success:function(data){
										bootbox.alert("保存成功");
								$("#fileMongo").bootstrapTable('refresh');
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

function  addMongo(){
//  复选框  ID    

dialog("<%=request.getContextPath()%>/controlleer/tofilemogo.do");
}

function xiazai(ossName) {
	location.href = "<%=request.getContextPath()%>/controlleer /DownLoadLink.do?ossName"+ossName;
}                



function delUser(){
	
	var arr=$("#fileMongo").bootstrapTable("getSelections");
 
	var str=""
		for(i=0;i<arr.length;i++){
			str+=","+arr[i].fileid;
		}
	alert(str);
	if(str == null || str == ""){
		bootbox.alert("至少选中一项")
	}else{
		$.ajax({
			url:"<%=request.getContextPath()%>/controlleer/deleFile.do",
			type:"post",
			data:{did:str},
			success:function(){
			$("#fileMongo").bootstrapTable('refresh');
			}
		}) 
	}
	
}





</script>
</body>
</html>