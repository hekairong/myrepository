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
			    <label for="proName">课程名称</label>
			    <input type="text" class="form-control" id="classroomname" placeholder="课程名称">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">课程学科</label>
			    <select  id="classroomproject" class="form-control">
				</select>
			  </div>
			 <span id="add"></span>
			  <button type="button" class="btn btn-primary" onclick="reset()">重置</button>
			  <br>
</form>
<table id="classMongo"></table>
</body>
<script type="text/javascript">


function search(){
	$("#classMongo").bootstrapTable('destroy');
	$("#add").html('<button type="button" class="btn btn-success" onclick="search()">搜索</button>');
 	$("#classMongo").bootstrapTable('refresh');
 	$("#classMongo").bootstrapTable({
		 url:"<%=request.getContextPath()%>/Wscon/findclass.do",	
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
		     	{field:'classroomid',title:'编号',width:50,
					formatter:function(value,row,index){   //  格式化  当前单元格内容
						return "<input type='checkbox' value="+value+" name='chk'/>";
					}
				},
				{field:'classroomname',title:'课程名称',width:100},
				{field:'classroomgrade',title:'开课年级',width:100,sortable:true},
				{field:'classroomstarttime',title:'开课时间',width:100
				},
				{field:'classroomsubject',title:'课程学科',width:100},
				{field:'instructor',title:'老师名称',width:100},
				{field:'specifyteacher',title:'课程助教',width:100},
				{field:'classroominfo',title:'课程详情',width:100},
				{field:'approvalstatus',title:'审核状态',width:100,
				 	formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
						
				 		if(value == "1"){
				 			
				 			return "审核通过";
				 		}else if(value == "2"){
				 			
				 			return "审核未通过";
				 		}
				 		
					}
				},
				{field:'caozuo',title:'操作',width:100,
				 	formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
						
				 		if(row.approvalstatus == "2"){
				 			
				 			return "<button class='btn btn-info' onclick = 'del(\""+row.classroomid+"\")'>删除</button><br><button class='btn btn-info' onclick = 'update(\""+row.classroomid+"\")'>通过审核</button>";
				 		}else{
				 			
				 			return "<button class='btn btn-info' onclick = 'del(\""+row.classroomid+"\")'>删除</button>";
				 		}
				 		
					}
				}
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
					 			"pageSize":params.limit,
					 			"start":params.offset,
					 			"classroomname":$("#classroomname").val(),
					 			"classroomproject":$("#classroomproject").val()
					 	}
						 return whereParams;
				}
	});
}

	$(function(){
		
		search();
		
		$.ajax({
			
			url: "<%=request.getContextPath()%>/Wscon/queryType.do",
			type: "post",
			dataType: "json",
			success: function(data){
				
				var html='<option value="">'+"请选择"+'</option>'
				for(var i=0;i<data.length;i++){
					html+='<option value="'+data[i].cousrseid+'">'+data[i].coursename+'</option>'
				}
				$("#classroomproject").html(html);
				
			},
			error: function(){
				
				bootbox.alert("请求失败");
			}
			
		})
		
		
		
	})
	
	function del(classroomid){
		$.ajax({
			
			url: "<%=request.getContextPath()%>/Wscon/delclass.do?classroomid="+classroomid,
			type: "post",
			dataType: "json",
			success: function(data){
				
				$("#classMongo").bootstrapTable('refresh');
				
			},
			error: function(){
				
				$("#classMongo").bootstrapTable('refresh');
			}
			
		})
		
	}
	
	function update(classroomid){
		
		$.ajax({
			
			url: "<%=request.getContextPath()%>/Wscon/updateclass.do?classroomid="+classroomid,
			type: "post",
			dataType: "json",
			success: function(data){
				
				$("#classMongo").bootstrapTable('refresh');
				
			},
			error: function(){
				
				$("#classMongo").bootstrapTable('refresh');
			}
			
		})
		
	}


</script>
</html>