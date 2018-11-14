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

<center><h2>机构添加界面</h2></center>
<div class="container-filed">
		<form id="addorgform" class="inline">
			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
					    <label>机构名称</label>
					    <input type="text" name="orgname" class="form-control" >
					    <input type="hidden" name="orgid" class="form-control" >
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
					    <label>机构logo</label>
<!--                         <input type="file" id="orgimg" name="orgimg" class="form-control" > -->
<!-- 					    <input type="hidden" id="imgName" name="imgId"  class="form-control" > -->
					    
					    <!-- 		文件域 -->
		 <input type="file" id="userphoto" >
<!-- 	图片回显的img标签 -->
		<div id="showImgDiv" style="width: 150px;height: 200px;border-style:solid;border-width:1px; border-color:black;">
			 <img src="" id="showImg" style="width: 150px;height: 200px;">
		</div>
<!-- 	显示进度条的div -->
		<div id="showswf" ></div>
		<input type="hidden" name="orgimg" id="userp">
					</div>
				</div>
				
			</div>
			
			<div class="row">
				
				<div class="col-xs-6">
					<div class="form-group">
					    <label>机构介绍</label>
					    <textarea id="editinfo" name="orgdetail"></textarea >
					</div>
				</div>
			</div>
			
			<div class="row">
				
				<div class="col-xs-6">
					<div class="form-group">
					    <label>机构荣誉</label>
					   	<input type="text" name="orgprice" class="form-control" >
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
$(function(){
	//文件域的id
	     $("#userphoto").uploadify({
	     //前台请求后台的url 不可忽略的参数
	     'uploader' :"<%=request.getContextPath()%>/ytl/uploadPhoto.do",
	     //插件自带 不可忽略的参数
	     'swf' : '<%=request.getContextPath()%>/ytl/js/uploadify/uploadify.swf',
	   //撤销按钮的图片路径
	     'cancelImg' : '<%=request.getContextPath() %>/ytl/js/uploadify/uploadify-cancel.png',
	   //如果为true 为自动上传 在文件后 为false 那么它就要我们自己手动点上传按钮
	     'auto' : true,
	     //可以同时选择多个文件 默认为true 不可忽略
	     'multi' : false,
	     //给上传按钮设置文字
	     'buttonText' : '上传头像',
	     //上传后队列是否消失
	     'removeCompleted' : true,
	     'removeTimeout' : 1,
	   //上传文件的个数
	     'uploadLimit' : 2,
	     'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
	     'fileSizeLimit' : '2MB',
	   //给div的进度条加背景 不可忽略
	     'queueID' : 'showswf',
	  // controller层方法中接收文件的参数名
	     'fileObjName' : 'fileimg',
	//      上传成功后的回调函数
	     'onUploadSuccess' : function(file, data, response) {
// 	    	 alert(data);
				//data : 图片上传成功后的 图片路径
				/*
				1.根据图片路径 通过img标签回显图片
				2.将图片路径 放到隐藏域中  保存用户数据时  直接添加到数据库
				
				*/
				
				$("#showImg").prop("src","<%=request.getContextPath()%>/"+data);
	    	 	$("#userp").val(data);
			}

	     });
	});
	
	
</script>		

		<script type="text/javascript">
		$(function(){
			$("#orgimg").fileinput({
				showUpload:true,
				showRemove:true,
				mainClass:"input-grop-lg",
				browseClass:"btn btn-primary btn-block",
				language:'zh',
				allowedPrviewTypes:['image','text'],
				allowedFileExtebsions:['jpg','png','gif'],
				maxFileSize:2000,
				showCaption:true,
				showPreview:true,
				showClose:false,
				showBrowse:true,
				uploadUrl:'<%=request.getContextPath()%>/ytl/ImgUpload.do',
				validateInitialCount:true,
				previewFileIcon:"<i class='glyphicon glyphicon-king'></i>",
				msgFilesTooMany:"选择要上传的文件",
				msgFilesTooMany:"选择上传的文件数({n})超过允许的最大数量({m})!",
			});
				$("#orgimg").on('fileuploaded',function(event,data,previewId,index){
					
//	 				alert(data.response.imgId);
					$("#imgName").val(data.response.imgId);
				})
			})
		</script>
		<script type="text/javascript">
$.getScript('<%=request.getContextPath()%>/ytl/js/kindeditor-4.1.7/kindeditor-all-min.js',
function() {
	KindEditor.basePath = '<%=request.getContextPath()%>/ytl/js/kindeditor-4.1.7/';
	editor = KindEditor.create('#editinfo', {
		cssPath : '<%=request.getContextPath()%>/ytl/js/kindeditor-4.1.7/plugins/code/prettify.css',
		uploadJson : '<%=request.getContextPath()%>/ytl/js/kindeditor-4.1.7/jsp/upload_json.jsp',
		fileManagerJson : '<%=request.getContextPath()%>/ytl/js/kindeditor-4.1.7/jsp/file_manager_json.jsp',
		afterBlur:function(){this.sync();},//和ajax同步
// 		items:['emoticons','fontsize']
		
	});
})
</script>
		<script>
		    function tijiao(){
		    	$.ajax({
		    		url:"<%=request.getContextPath()%>/ytl/addorg.do",
		    		method:"post",
		    		data:{},
		    		dataType:'json',
		    		success:function(msg){
		    			location.href="<%=request.getContextPath()%>/ytl/org_list.jsp";
		    			
		    		}
		    	})
		    	
		    	
		    }
		</script>
</body>
</html>