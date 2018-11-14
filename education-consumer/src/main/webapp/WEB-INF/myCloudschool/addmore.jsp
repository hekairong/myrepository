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
<center><b><font color="#00ccff">第一步：填写课程信息</font></b>&nbsp;&nbsp;&nbsp;&nbsp;<font color="#00ccff">第二步：添加课程计划</font>&nbsp;&nbsp;&nbsp;&nbsp;<font color="#00ccff">第三步：创建完成</font></center>
<form id="add-moreform">
<input type="hidden" name="approvalstatus" value = "2">
<!-- DIV第一个 --><!-- DIV第一个 --><!-- DIV第一个 --><!-- DIV第一个 -->
<div id="myDiv">
<input type="hidden" id="classroomid" value = "${Xsession.classroomsubject }">
<input type="hidden" id="helpteacherid" value = "${Xsession.instructor }">
<div class="form-group">
		    <label for="proName">课堂名称</label>
		    <input type="text" style="width:30%" class="form-control" name="classroomname" value = "${Xsession.classroomname }"  id="classroomname" placeholder="课堂名称" width="30px">

	   </div>
<div class="form-group">

		    <label for="exampleInputPassword1">开课年级</label>
		    <input type="text" id="classroomgrade" style="width:30%" value = "${Xsession.classroomgrade }" name="classroomgrade" class="form-control" placeholder="开课年级" />
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
   <input type="text" class="form-control" style="width:30%" value = "${Xsession.classroomstudent }" name="classroomstudent" placeholder="听课学生" id="classroomstudent">
   <a class="btn btn-info " href="#" onclick = "toAddButbox()" role="button">添加学生</a>
</div>
<div class="form-group">
   <label for="exampleInputPassword1">指定助教</label>
    <input type="text" class="form-control" style="width:30%" value = "${Xsession.specifyteacher }" name="specifyteacher" placeholder="助教名称" size="30" id="specifyteacher">
	<a class="btn btn-info " href="#" onclick = "toAddzj()" role="button">添加助教</a>
 </div>
<div class="form-group">
<label for="exampleInputPassword1">课程说明</label>
   <textarea class="form-control" id="kcsm" style="width:30%" name="classroominfo" rows="3">${Xsession.classroominfo }</textarea>
</div>
<center><button type="button" class="btn btn-success" onclick="nextStep()">下一步:课程计划</button></center>
</div>
<!-- DIV第二个 --><!-- DIV第二个 --><!-- DIV第二个 --><!-- DIV第二个 -->
<div id="myDiv2" style="display:none">
<font size="4">添加子课程</font><br>
<div id = "shuju" class="div1">
<table id="bbbbtable" class="table" border="1">
   	  <tr>
         <td>
         	<div class="col-xs-4">
		    <label for="name"> 子课程名称 </label>
		    <input type="text" class="form-control" placeholder="子课程名称" id = "soncoursenameY0" name="format[0].soncoursename">
		  	</div>
		 </td>
      </tr>
      <tr>
         <td> 
         	<div class="col-xs-4">
		    <label for="Date">开课时间</label>
		    <input type="text" class="form-control date" placeholder="开课时间" id = "soncoursestarttimeY0"  name="format[0].soncoursestarttime">
    		</div>
    	 </td>
      </tr>			
      <tr>
         <td> 
         	<div class="col-xs-4">
		    <label for="Date">结课时间</label>
		    <input type="text" class="form-control date" placeholder="结课时间" id = "soncourseendtimeY0"  name="format[0].soncourseendtime">
    		</div>
    	 </td>
      </tr>			
</table>
	</div>
<div id="childCourseDIV">
    		<input class="btn btn-info" type="button" onclick="addChildCourse()" value="继续添加">
</div>
		<center>
		<button type="button" class="btn btn-success" onclick="lastStep()">上一步:课程信息</button>
		<button type="button" class="btn btn-success" onclick="nextStepTwo()">下一步:预览系列课程</button>
		</center>
</div>
</form>
<div id = "shuju11">
<span id = "shuju1">
${hhh }
</span>
</div>
<script type="text/javascript">

$(function(){
	
	document.getElementById("shuju11").style.display = "none";
	$("#classroomsubject").val($("#classroomid").val());
	$("#classroomsubject").trigger("chosen:updated"); 
	$("#instructor").val($("#helpteacherid").val());
	$("#instructor").trigger("chosen:updated"); 
	
})

function nextStep(){

	$.ajax({
		url:"<%=request.getContextPath()%>/index/cunSession.do",
		data:$("#add-moreform").serialize(),
		type:"post",
	    success:function(data){
	    	
	        document.getElementById("myDiv").style.display = "none";   //隐藏
	    	document.getElementById("myDiv2").style.display = "block"; //显示
        }
	})
}  

function lastStep(){
	document.getElementById("myDiv").style.display = "block";   //显示
	document.getElementById("myDiv2").style.display = "none"; 	//隐藏
}

function lastStepTwo(){
	document.getElementById("myDiv2").style.display = "block";   //显示
	document.getElementById("myDiv3").style.display = "none"; 	//隐藏
	
}

function nextStepTwo(){
	
	dialog("<%=request.getContextPath()%>/index/cunShujuS.do","<%=request.getContextPath()%>/yunschool/addMoreClassRoom.do","数据预览");
	
}

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
			data:
				$("#add-moreform").serialize(),
			async:false,
			success:function(data){
				//alert(data);//data--addProduct.jsp页面内容
				jspHtml = data;
/* 		    	document.getElementById("myDiv2").style.display = "none"; 	//隐藏
		    	$("#myDiv3").style.display = "block";   //显示 */
		    	var classroomsubject = $("#classroomid").val();
		    	var instructor = $("#helpteacherid").val();
		    	$("#laoshi").text(instructor);
		    	$("#xueke").text(classroomsubject);
			},
			error:function(){
				bootbox.alert("ajax失败");
			}
		});
	return jspHtml;
}
//弹窗跳页面封装方法
function  dialog(HTMLurl,submitUrl,title){
		
		var dialog = bootbox.dialog({
			 title: title,
		    message: getJspHtml(HTMLurl),   //调用方法  
		    buttons:{
		    				"save":{
							  label: '保存系列课程',
							  //自定义样式
							  className: "btn-success",
							  callback: function() {
									$.ajax({
										url:submitUrl,
										type:'post',
										data:$("#add-moreform").serialize(),
										success:function(data){
											
												$.ajax({
													url:'<%=request.getContextPath()%>/Wscon/hhhh.do',
													type:'post',
													success:function(data){
															
													},
													error:function(){
														bootbox.alert("error");
													}
												});
												bootbox.alert("保存成功");
												
										},
										error:function(){
											bootbox.alert("请求失败");
										}
									});
							  }
							},
							"unSave":{
								  label: '再改一下',
								  //自定义样式
								 className: "btn-info",
								  callback: function() {
									 // return false;  //dialog不关闭
								  }
								}
						}
	});
	}


$(function(){
	initDate();
})

function saveCourse(){
	$.ajax({
		url:"",
		type:"post",
		data:$("#add-moreform").serialize(),
		success:function(result){
			if(result==1){
				bootbox.alert("新增成功");
			}
		},
		error:function(){
			bootbox.alert("新增失败");
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
					$("#classroomstudent").val(b);
					
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
					$("#specifyteacher").val(b);
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
var hh = 0;
function addChildCourse(){
		
		hh = hh+1;
			$("#bbbbtable").append(
					
				   	  "<tr>"
				      +"   <td>"
				      +"   	<div class='col-xs-4'>"
				      +"    <label for='name'> 子课程名称 </label>"
				      +"    <input type='text' class='form-control' placeholder='子课程名称' id = 'soncoursenameY"+hh+"' name='format["+hh+"].soncoursename'>"
				      +"  	</div>"
				      +" </td>"
				      +"</tr>"
				      +"<tr>"
				      +"   <td> "
				      +"   	<div class='col-xs-4'>"
				      +"    <label for='Date'>开课时间</label>"
				      +"    <input type='text'  placeholder='开课时间' class='form-control date' id = 'soncoursestarttimeY"+hh+"' name='format["+hh+"].soncoursestarttime'>"
				      +"	</div>"
				      +" </td>"
				      +"</tr>"
				      +"   <td> "
				      +"   	<div class='col-xs-4'>"
				      +"    <label for='Date'>结课时间</label>"
				      +"    <input type='text'  placeholder='结课时间' class='form-control date' id = 'soncourseendtimeY"+hh+"' name='format["+hh+"].soncourseendtime'>"
				      +"	</div>"
				      +" </td>"
				      +"</tr>"
					
			)
			initDate();
		
}

<%-- //预览
function nextStepTwo(){
//---------------------------------------------------------------------------------------------
	$.ajax({
		url:"<%=request.getContextPath()%>/index/cunShujuS.do",
		data:
			$("#add-moreform").serialize(),
		type:"post",
	    success:function(data){
	    	
	    	document.getElementById("myDiv2").style.display = "none"; 	//隐藏
	    	document.getElementById("myDiv3").style.display = "block";   //显示
	    	var classroomsubject = $("#classroomid").val();
	    	var instructor = $("#helpteacherid").val();
	    	$("#laoshi").text(instructor);
	    	$("#xueke").text(classroomsubject);
	    	document.getElementById("myDiv3").load();
        }
	})
    
} --%>
</script>
</body>
</html>