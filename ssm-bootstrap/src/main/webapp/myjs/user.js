$(function (){
	//   用户的表格
		$("#userTable").datagrid({// 定义一下  数据表格
			width:800,
			//fit:true,
			url:"user/findUser.do",
			title:"用户列表",
			toolbar:"#tb",  // 定义工具栏
			rownumbers:true,    //  显示序列号
			//loader:myLoader,
			columns:[[     //  列属性     因为 他们可以合并单元格
			           {field:'chkid',checkbox:true,width:100}, 
			           {field:'userId',title:'用户ID',width:100},      //  列    field   代表是 后台  传过来的值
			           {field:'userName',title:'用户名称',width:100},    
			           {field:'crud',title:'用户赋角色',width:100,
			        	formatter: function (value,row,index){ 
				        		return "<a href='javascript:findUserRole("+row.userId+")'>用户赋角色</a>";
				        }  
			           }
			       ]],
			       pagination:true,
			       pageSize: 3,//每页显示的记录条数，默认为10     
			        pageList: [3,5,7],//可以设置每页记录条数的列表 
		})
	 	  $('#userTable').datagrid('getPager').pagination({        //   独自声明   datagird   数据表格的分页
		        beforePageText: '第',//页数文本框前显示的汉字     
		        afterPageText: '页    共 {pages} 页',     
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		        showRefresh:false   
	});	
})
	function findUserRole(userId){
	$("#userRole").dialog({
		title: '用户赋角色',
		 width: 600,    
		 height: 400, 
		 href:"user/dialogRole.do?userId="+userId,
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
					roleIds+=obj.rid+",";
				});
				//  拼成一个ids      1,2,3
				
				$.ajax({
					type:"post",
					url:"user/saveUserRole.do",
					data:{
						"userId":$("#userId").val(),
						"roleIds":roleIds
					},
					success:function (msg){
						$.messager.alert('我的消息','提交成功！','info');
						$("#userRole").dialog("close");	
						 $('#userTable').datagrid("load");
					}
				});

			
				}
			},{
				text:'关闭',
				iconCls:"icon-no",
				handler:function(){
					$("#userRole").dialog("close");	
				}
			}],
			onLoad:function (){  // uploaddify  要做 dialog  加载时完成
				//editor.readonly(true);   // 设置  kindeditor   修改时只读
			}
	});
}




