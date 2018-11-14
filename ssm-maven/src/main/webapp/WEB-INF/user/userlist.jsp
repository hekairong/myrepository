<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../jsr/yinbao.jsp"></jsp:include>
</head>
<body>
<div id="userlistdiv" class="easyui-layout" data-options="fit:true">   
   <!-- <div data-options="region:'east',title:'个人信息',split:true" style="width:50%;">
         <table id="usertables"></table>
    </div> -->
    <div data-options="region:'north', height:65">
    <br>
    &nbsp;用户名：<input class="easyui-textbox" data-options="iconCls:'icon-key'" style="width:200px" id="usernameid">
    &nbsp;生日：<input type="text" class="easyui-datetimebox" id="startDate" class="Wdate"
			   onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">- 
       <input type="text" class="easyui-datetimebox" id="endDate" class="Wdate"
			   onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">
       <a id="btn" href="javascript:searchpage()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a><br><br> 
    </div>
    <div data-options="region:'center',title:'用户列表'" style="width:50%;">
         <table id="usertable"></table>
         <div id="userdiv"></div>
    </div>   
</div>  
<script type="text/javascript">
	$(function(){
		searchpage();
	})
	 
	function searchpage(){
		$("#usertable").datagrid({    
		    url:"<%=request.getContextPath()%>/user/finduser.do", 
	 	    checkOnSelect:false,
	 	    selectOnCheck:false,
	 	    singleSelect:true,
/* 	 	    onClickRow: function (rowIndex,rowData){
	 	    	var id=rowData.id;
	 	    	
	 	    		seachNewTable(id);
	 	    	
			}, */
		    pagination:true,//开启分页
		    pageNumber:1,//初始化页码
		    pageSize:3,//每页条数
		    pageList:[3,5,8],//每页条数的下拉选项
		    fit:true,
		    queryParams: {
		    	name: $("#usernameid").val(),
		    	startDate: $("#startDate").val(),
		    	endDate: $("#endDate").val(),
			},
			toolbar: [{
				text:"新增",
		    	iconCls: 'icon-add',
				handler: function(){
					$('#userdiv').dialog({    
			   		    title: '用户新增',    
			   		    width: 800,    
			   		    height: 600,    
			   		    closed: false,    
			   		    cache: false,    
			   		    href: '<%=request.getContextPath() %>/index/toadduserpage.do',    
			   		    modal: true,
				   		buttons:[{
							text:'保存',
							handler:function(){
								$.ajax({
									url:"<%=request.getContextPath()%>/user/adduser.do",
									data:$("#add-form").serialize(),
									type:"post",
									dataType:"text",
									async:false,
									success:function(msg){
										alert("新增成功");
										$("#userdiv").dialog("close");
		 								$("#usertable").datagrid("reload")
									}
								})
							}
						},{
							text:'关闭',
					 		handler:function(){
					 			$("#userdiv").window('close');
					 		}
						}]
			   		}); 
				}
		    },'-',{
				iconCls: 'icon-remove',
				text:'删除',
				handler: function(){
					var arr=$('#usertable').datagrid('getChecked')
					var str=""
					for(i=0;i<arr.length;i++){
						str+=","+arr[i].id;
					}
					str=str.substr(1)
					$.messager.confirm('确认','您确认想要删除这记录吗？',function(r){    
					    if (r){    
					    	$.ajax({
				    			url:"<%=request.getContextPath()%>/User/deleteUser.do",
				    			data:{ids:str},
				    			type:"post",
				    			success:function(result){
				    			$('#usertable').datagrid('reload');  
				    			}
				    		})  
					    }    
					});  
				}
			}],
		    columns:[[    
				{field:'usercheck',checkbox:true},
				{field:'id',title:'编号',width:50},    
		        {field:'name',title:'名称',width:60},    
		        {field:'sex',title:'性别',width:50,
		        	formatter: function(value,row,index){
		        		if(value==1){
		        			return "男";
		        		}if(value==2){
		        			return "女";
		        		}
		        	}
		        },
		        {field:'age',title:'年龄',width:50},
		        {field:'birthday',title:'生日',width:150},
		        {field:'userstatus',title:'状态',width:50,
		        	formatter: function(value,row,index){
		        		if(value==1){
		        			return "正常";
		        		}if(value==2){
		        			return "冻结";
		        		}
		        	}
		        },
		        {field:'loginname',title:'登录名',width:100},
		        {field:'userpwd',title:'密码',width:80},
		        {field:'phone',title:'手机号',width:120},
		        {field:'email',title:'邮箱',width:150},
		        {field:'userinfo',title:'用户简介',width:80,
		        	formatter: function(value,row,index){
		        		return "<input type='button' value='查看详情' onclick='xiangqing(\""+row.id+"\")'>"
		        	}
		        },
		        {field:'act',title:'操作',width:55,
    	        	formatter: function(value,row,index){
    	        		if(row.userstatus==1){
    	        			return "<input type='button' value='冻结' onclick='edit(\""+row.id+"\",2)'>";
    	        		}else if(row.userstatus==2){
    	        			return "<input type='button' value='解冻' onclick='edit(\""+row.id+"\",1)'>";
    	        		}
    	        	}	
    	        },
    	        {field:'act1',title:'操作',width:135,
    	        	formatter: function(value,row,index){
    	        			return "<input type='button' value='修改' onclick='edituser(\""+row.id+"\")'>&nbsp;<input type='button' value='分配角色' onclick='roleassignment(\""+row.id+"\")'>";
    	        	}	
    	        },
		    ]]    
		});  
	}
	
	function edituser(userid){
		$.messager.confirm('确认','您确认想要修改这条记录吗？',function(r){
		  if (r){ 
		 	$('#userdiv').dialog({    
		   		    title: '修改信息',    
		   		    width: 800,    
		   		    height: 650,    
		   		    closed: false,    
		   		    cache: false,    
		   		    href: '<%=request.getContextPath() %>/User/queryUserById.do?id='+userid,    
		   		    modal: true,
		   		    buttons:[{
			 			text:'保存',
			 			handler:function(){
		 					$.ajax({
								url:"<%=request.getContextPath()%>/User/updateUser.do",
								data:$("#edit-form").serialize(),
								type:"post",
								dataType:"text",
								async:false,
								success:function(msg){
									alert("修改成功");
									$("#userdiv").dialog("close");
									$("#usertable").datagrid("reload")
								}
							})
			 			}
			 		},{
			 			text:'关闭',
			 			handler:function(){
			 				$("#userdiv").window('close');
			 			}
			 		}]
		   		});    
			}
		})
	 }
	
	function edit(id,status){
		$.ajax({
			url:'<%=request.getContextPath()%>/User/updateStatus.do',
			type:'post',
			data:{id:id,userstatus:status},
			dataType:'json',
			success:function(result){
				$("#usertable").datagrid("reload")	
			}
		});
	}
	
	function xiangqing(id){
		$('#userdiv').dialog({    
   		    title: '个人简介',    
   		    width: 400,    
   		    height: 300,    
   		    closed: false,    
   		    cache: false,    
   		    href: '<%=request.getContextPath() %>/User/queryUserInfoById.do?id='+id,    
   		    modal: true,
   		}); 
	}
	
	function roleassignment(id){
		//alert(id);
			$("#userdiv").dialog({
				title: '用户赋角色',
				 width: 550,    
				 height: 400, 
				 href:"<%=request.getContextPath() %>/Role/queryUserRoleById.do?id="+id,
				 closed: false, 
				 modal: true,
				 iconCls:"icon-save",
				 buttons:[{      //  底部 按钮  
						text:'OK',
						iconCls:"icon-ok",
						handler:function(){    //提交   表单信息   添加   修改  用一个
					var rows=$("#roleTable").datagrid("getSelections");
					//  第一步  获取  复选框选中的值
						var roleIds="";	
						$.each(rows,function (index,obj){
							roleIds+=obj.id+",";
						});
						//  拼成一个ids      1,2,3
						
						$.ajax({
							type:"post",
							url:"<%=request.getContextPath() %>/Role/addUserRole.do",
							data:{
								"id":$("#id").val(),
								"roleIds":roleIds
							},
							success:function (msg){
								$.messager.alert('我的消息','提交成功！','info');
								$("#userdiv").dialog("close");	
								 $('#usertable').datagrid("load");
							}
						});

					
						}
					},{
						text:'关闭',
						iconCls:"icon-no",
						handler:function(){
							$("#userdiv").dialog("close");	
						}
					}],
					onLoad:function (){  // uploaddify  要做 dialog  加载时完成
						//editor.readonly(true);   // 设置  kindeditor   修改时只读
					}
			});
		} 
	
	
	
	
	 <%-- function seachNewTable(id){
		$("#usertables").datagrid({    
		    url:"<%=request.getContextPath()%>/User/queryUserList.do?id="+id, 
	 	    checkOnSelect:false,
	 	    selectOnCheck:false,
	 	    singleSelect:true,
		    pagination:true,//开启分页
		    pageNumber:1,//初始化页码
		    pageSize:3,//每页条数
		    pageList:[3,5,8],//每页条数的下拉选项
		     queryParams: {
		    	name: $("#usernameid").val(),
		    	startDate: $("#startDate").val(),
		    	endDate: $("#endDate").val(),
			},
		    fit:true,
		    columns:[[    
				{field:'usercheck',checkbox:true},
				{field:'id',title:'编号',width:100},    
		        {field:'name',title:'名称',width:100},    
		        {field:'sex',title:'性别',width:100,
		        	formatter: function(value,row,index){
		        		if(value==1){
		        			return "男";
		        		}if(value==2){
		        			return "女";
		        		}
		        	}
		        },
		        {field:'age',title:'年龄',width:100},
		        {field:'birthday',title:'生日',width:200},
		        {field:'rolename',title:'用户类型',width:100},
		        {field:'userstatus',title:'状态',width:100,
		        	formatter: function(value,row,index){
		        		if(value==1){
		        			return "正常";
		        		}if(value==2){
		        			return "冻结";
		        		}
		        	}
		        },
		        {field:'loginname',title:'登录名',width:100},
		        {field:'phone',title:'手机号',width:120},
		        {field:'email',title:'邮箱',width:180},
		        {field:'act',title:'操作',width:60,
    	        	formatter: function(value,row,index){
    	        			return "<input type='button' value='修改' onclick='edit(\""+row.id+"\")'>";
    	        	}	
    	        },
		    ]]  
		}); 
	}   --%>
	
	
</script>
</body>
</html>