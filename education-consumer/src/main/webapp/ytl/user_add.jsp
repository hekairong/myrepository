<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap3/css/bootstrap.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap3/css/bootstrap-theme.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap-table/bootstrap-table.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap-fileinput/css/fileinput.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap-fileinput/css/fileinput.min.css">
<link rel="stylesheet"  href="<%=request.getContextPath()%>/ytl/js/uploadify/uploadify.css" type="text/css"/>

<script  src="<%=request.getContextPath()%>/ytl/js/jquery.min.js"></script>
<script  src="<%=request.getContextPath()%>/ytl/js/bootstrap3/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-table/bootstrap-table.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-fileinput/js/fileinput.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-fileinput/js/locales/zh-TW.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-fileinput/js/locales/zh.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-bootbox/bootbox.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/kindeditor-4.1.7/themes/default/default.css">
</head>
<body>

<center><h2>用户角色添加界面</h2></center>
<div class="container-filed">
		<form id="addorgform" class="inline">
			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
					    <label>用户名称</label>
					    <input type="text" id="username" class="form-control" >
					    <input type="hidden" name="userid" class="form-control" >
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
					    <label>用户密码</label>
					        <input type="password" id="userpassword" class="form-control">
		</div>
					</div>
				</div>
				
			</div>
			
			
				
				
			
			<div class="row">
				
				<div class="col-xs-6">
					<div class="form-group">
					    <label>角色：</label><br>
					    
					   
    <label>
        <input type="radio" id="ttid" name="powerid"  value="2" onclick="addtt()"> 老师
    </label>


    <label>
        <input type="radio" id="ssid" name="powerid"  value="1" onclick="addss()">学生
    </label><br>
    <span id="aa"></span>
					
				</div>
			</div>
			</div>
			
			<div class="col-xs-6">
					<div class="form-group">
					  <a class="btn btn-primary glyphicon " href="#"
						onclick="tijiao()" role="button">保存</a> 
					</div>
				</div>
			</div>
		</form>
<script type="text/javascript" src="<%=request.getContextPath()%>/ytl/js/uploadify/jquery.uploadify.min.js"></script>

<script type="text/javascript">
var html="";
function addtt(){
	html="";
	html+='<div class="row">'+
	'<div class="col-xs-6">'+
	'<div class="form-group">'+
	    '<label>教师名称</label>'+
	    '<input type="text" id="teachername" class="form-control" >'+
	    '<input type="hidden" id="teacherid" value="2" class="form-control" >'+
	'</div>'+
'</div>'+
'</div>'
	$("#aa").html(html)
	
}
function addss(){
	html="";
	
	html+='<div class="row">'+
	'<div class="col-xs-6">'+
	'<div class="form-group">'+
	    '<label>学生名称</label>'+
	    '<input type="text" id="studentname" class="form-control" >'+
	    '<input type="hidden" id="studentid" value="1" class="form-control" >'+
	'</div>'+
'</div>'+
'</div>'
	$("#aa").html(html)
	
}
</script>



<script type="text/javascript">
		    function tijiao(){
		    	
		    	$.ajax({
		    		url:"<%=request.getContextPath()%>/ytl/adduser.do",
		    		type:'post',
		    		data:{
		    			username:$("#username").val(),
		    			userpassword:$("#userpassword").val(),
		    			powerid:$("input[name='powerid']:checked").val(),
		    			studentname:$("#studentname").val(),
		    			studentpassword:$("#studentpassword").val(),
		    			teacherpassword:$("#teacherpassword").val(),
		    			teachername:$("#teachername").val()
		    		},
		    		dataType:'json',
		    		success:function(msg){
		    			bootbox.alert("新增成功");
		    			location=location;
		    		}
		    	})
		    	
		    	
		    }
		</script>
</body>
</html>