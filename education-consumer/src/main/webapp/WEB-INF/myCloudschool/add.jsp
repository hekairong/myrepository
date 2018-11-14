<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/commons/mystyle.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrapjs/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">
<script src="<%=request.getContextPath()%>/bootstrapjs/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/bootstrapjs/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body>
<form id="add-oneform">
<input type="hidden" name="approvalstatus" value = "2">
       <div class="form-group">
		    <label for="proName">课堂名称</label>
		    <input type="text" style="width:30%" class="form-control" name="classroomname"  id="proName" placeholder="课堂名称" width="30px">
	   </div>
       <div class="form-group">
		    <label for="classroomstarttime">开课时间</label>
		    <input type="text" name="classroomstarttime" id="classroomstarttime" style="width:30%" class="form-control date" placeholder="开课时间" />
	   </div>
	   <div class="form-group">
		    <label for="classroomstarttime">结课时间</label>
		    <input type="text" name="classroomendtime" id="classroomendtime" style="width:30%" class="form-control date" placeholder="结课时间" />
	   </div>
      <div class="form-group">
		    <label for="exampleInputPassword1">开课年级</label>
		    <input type="text" style="width:30%" name="classroomgrade" class="form-control" placeholder="开课年级" />
       </div>
      <div class="form-group">
      <label for="proDate">学科范畴</label>
      <select id="classroomsubject" style="width:30%" name="classroomsubject" class="form-control">
		  <option value="">-请选择-</option>
	  </select>
      </div>
   <div class="form-group">
   <label for="exampleInputPassword1">授课老师</label>
   &nbsp&nbsp&nbsp&nbsp&nbsp
   &nbsp&nbsp&nbsp&nbsp<span>${login.username }</span>
	  <input type="hidden" style="width:30%" name="instructor" value = "${login.teacherid }" class="form-control" placeholder="授课老师" />
 </div>
<div class="form-group">
   <label for="exampleInputPassword1">听课学生</label>
   <input type="text" style="width:30%" class="form-control" name="classroomstudent" placeholder="听课学生" id="span">
   <a class="btn btn-info " href="#" onclick = "toAddButbox()" role="button">添加学生</a>
</div>
<div class="form-group">
   <label for="exampleInputPassword1">指定助教</label>
    <input type="text" style="width:30%" class="form-control" name="specifyteacher" placeholder="助教名称" size="30" id="span2">
	<a class="btn btn-info " href="#" onclick = "toAddzj()" role="button">添加助教</a>
 </div>
<div class="form-group">
<label for="exampleInputPassword1">课程说明</label>
   <textarea class="form-control" style="width:30%" name="classroominfo" rows="3"></textarea> 
</div>
<center>
<button type="button" onclick="saveCourse()" class="btn btn-success">提交审批/创建</button>
<button type="button" class="btn btn-primary" onclick="reset()">重置</button>
</center>
</form>
<script type="text/javascript">
$(function(){
	initDate();
})

function saveCourse(){
	$.ajax({
		url:"<%=request.getContextPath()%>/yunschool/addClassRoom.do",
		type:"post",
		data:$("#add-oneform").serialize(),
	 success:function(result){
		 if(result==1){
			 bootbox.alert("新增成功")
		 }
	 }
	})
	initDate();
}

function initDate(){
	$('.date').datetimepicker({
		  language: 'zh-CN',//显示中文
		  format: 'yyyy-mm-dd hh:ii:ss',//显示格式
		  minView: "month",//设置只显示到月份
		  initialDate: new Date(),//初始化当前日期
		  autoclose: true,//选中自动关闭
		  todayBtn: true//显示今日按钮
		 });
	$("#classroomstarttime").datetimepicker({ 
		format: 'yyyy-mm-dd', 
		minView:'month', 
		language: 'zh-CN', 
		autoclose:true, 
		startDate:new Date() 
	    }).on("click",function(){ 
		$("#classroomstarttime").datetimepicker("setEndDate",$("#classroomendtime").val()) 
	    });
	
	$("#classroomendtime").datetimepicker({ 
		format: 'yyyy-mm-dd', 
		minView:'month', 
		language: 'zh-CN', 
		autoclose:true, 
		startDate:new Date() 
		}).on("click",function(){ 
		$("#classroomendtime").datetimepicker("setStartDate",$("#classroomstarttime").val())
		});
}


var res;
function createAddContent(url){
	$.ajax({
	url:url,
	async:false,
		success:function(data){
		res = data;
		}
	});
	return res;
}

function toAddButbox(){
	var url = "<%=request.getContextPath()%>/index/tostudentPage.do";	    
	bootbox.dialog({
		title:'学生',
		message:createAddContent(url),
		closeButton: true,
		buttons : {
			"success" : {
				"label" : "<i class='icon-ok'></i> 保存",
				"className" : "btn-sm btn-success",
				"callback" : function() {
					var b= "";
					var ma = $("#studentTable").bootstrapTable('getSelections', function (row) {
						          return row;
					});
					for (var i = 0; i < ma.length; i++) {					
							b+=","+ma[i].studentid;		
							
					}
					var b = b.substring(1);
					$("#span").val(b);
					
				}
			},
			"cancel" : {
				"label" : "<i class='icon-info'></i> 取消",
				"className" : "btn-sm btn-danger",
				"callback" : function() {
				}
			}
		}
	});
}

function toAddzj(){
	var url = "<%=request.getContextPath()%>/index/tohelpteacherPage.do";	    
	bootbox.dialog({
		title:'助教',
		message:createAddContent(url),
		closeButton: true,
		buttons : {
			"success" : {
				"label" : "<i class='icon-ok'></i> 保存",
				"className" : "btn-sm btn-success",
				"callback" : function() {
					var b= "";
					var ma = $("#helpTeacherTable").bootstrapTable('getSelections', function (row) {
						          return row;
					});
					for (var i = 0; i < ma.length; i++) {					
							b+=ma[i].helpteacherid;		
							
					}
					$("#span2").val(b);
					
				}
			},
			"cancel" : {
				"label" : "<i class='icon-info'></i> 取消",
				"className" : "btn-sm btn-danger",
				"callback" : function() {
				}
			}
		}
	});
}
//学科
$(function (){
	$.ajax({
		url:'<%=request.getContextPath()%>/yunschool/querySubjectList.do',
		data:{},
		type:'post',
		dataType:'json',
		success:function(result){
			//alert(result);
			var html ="<option value =''>-请选择-</option>";
			for(var i = 0; i < result.length; i++){
				html+="<option value ='"+result[i].cousrseid+"'>"+result[i].coursename+"</option>"
			}
			$('#classroomsubject').html(html);
		}
	}) 
})
//老师
$(function (){
	$.ajax({
		url:'<%=request.getContextPath()%>/yunschool/queryTeacherList.do',
		data:{},
		type:'post',
		dataType:'json',
		success:function(result){
			//alert(result);
			var html ="<option value =''>-请选择-</option>";
			for(var i = 0; i < result.length; i++){
				html+="<option value ='"+result[i].teacherid+"'>"+result[i].teachername+"</option>"
			}
			$('#instructor').html(html);
		}
	}) 
})
</script>
</body>
</html>