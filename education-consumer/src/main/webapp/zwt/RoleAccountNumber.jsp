<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../commons/mystyle.jsp" %>
</head>
<body>
	
   <table class="table table-hover" id="file-table">
      </table>
	
	
	
<script type="text/javascript">
      function search_list(){
		 $("#file-table").bootstrapTable("refresh",{offset:1})
		}
$("#file-table").bootstrapTable({
  	  url:"<%=request.getContextPath()%>/zwt/queryUserList.do",
  	method: "post",
  	 striped:true,
  	searchOnEnterKey:false,
  	showHeader:true,
  	showColumns:true,
  	showRefresh:true,
  	showToggle:true,
  	toolbar: '#toolbar',
  	 pagination: true,		   //开启分页
  	 pageNumber:1,              //初始化加载第几页,默认第1页
     pageSize: 3,               //每页几条数据,超过总条数右下角将没分页
     pageList: [3, 5, 8, 10],    //每页条数,设置为All将展示全部记录,超过总条数底部将不显示条数下拉框
     contentType:"application/x-www-form-urlencoded;charset=UTF-8",	//必须的否则条件查询时会乱码
     sidePagination: "server",  //分页方式:client客户端分页,server服务端分页
 		 columns: [{
 		        field: 'userid',
 		        title: '编号',
 		       	width: '100'
 		    }, {
 		        field: 'username',
 		        title: '用户名',
 		       	width: '200'
 		    },{
 		        field: 'userpassword',
 		        title: '密码',
 		       	width: '200'
 		    },{
 		        field: 'powerid',
 		        title: '角色',
 		       	width: '200',
 		       formatter:function(value,row,index){
 		    	   if(value==1){
 		    		   return "学生";
 		    	   }
 		    	   if(value==2){
		    		   return "老师";
		    	   }
 		    	   if(value==3){
		    		   return "管理员";
		    	   }
 		       }
 		    },{
  		    	field: 'cz',
  		        title: '操作',
  		        width: '500',
  		      formatter:function(value,row,index){	  
  			    return "<center>"+
  			    "<button id='btn_edit' type='button' class='btn btn-default' onclick='editUser(\""+row.userid+"\")'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>编辑</button>&#8195;&#8195;&#8195;"+
  			  	"<button id='btn_delete' type='button' class='btn btn-default' onclick='deleteUser(\""+row.userid+"\")'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span>删除</button>"+
  			    "</center>";
  		      }
 		    }
 		    ]
   })
   
   function deleteUser(userid){
	alert(userid)
	$.ajax({
		url:"<%=request.getContextPath()%>/zwt/deleteUser.do?userid="+userid,
		type:"post",
		success:function(result){
			$("#file-table").bootstrapTable('refresh');
		},
		error:function(){
			alert("删除失败");
		}
	})
}
   
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
									$("#file-table").bootstrapTable('refresh');
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

function  editUser(userid){
	dialog("<%=request.getContextPath()%>/zwt/queryOneUser.do?userid="+userid,"<%=request.getContextPath()%>/zwt/updateUser.do","编辑用户");
}
  </script>
</body>
</html>