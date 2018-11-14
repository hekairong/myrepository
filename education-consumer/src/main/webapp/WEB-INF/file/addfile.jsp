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
	<form id="logForm">
<!-- 	<div id="bus-append-div">
		  <div class="form-group">
		    <label for="proName">文件名称</label>
		    <input type="text" class="form-control"  name="filename"  id="proName" placeholder="文件名称">
		  </div>  -->
<!-- 		<div class="form-group">
		    <label for="exampleInputPassword1">上传时间</label>
		    <input type="date" name="time"   class="form-control" placeholder="上传时间" />
		  </div> -->
<!--  		  <div class="form-group">
		    <label for="exampleInputPassword1">文件大小</label>
		    <input type="text" name="size"   class="form-control" placeholder="文件大小" />
		  </div> --> 
			 <div class="form-group">
				 <label for="proImage">上传</label>
				 <input class="form-control" id="file" name="file"  type="file" />
				 <input class="form-control" id="fileImg"   type="hidden" />
			</div>
			</div>
		</form>

<script type="text/javascript">
	$(function (){
		$("#file").fileinput({
			//上传按钮
	    	showUpload:true,
	    	//移除按钮
		    showRemove : true,
		    //最大上传文件的个数，想要多选文件，input文件域必须加上multiple这个属性
		   // maxFileCount:2,
		    //主样式 
		    mainClass: "input-group-lg",
		    //按钮样式
		    browseClass: "btn btn-primary btn-block",
		    //语言设置：中文
		    language : 'zh',
		    //允许预览的文件类型
		    allowedPreviewTypes : [ 'image', 'text' ],
		    //允许选择的文件后缀名
		    allowedFileExtensions : [ 'jpg', 'png', 'gif','qsv','flv', 'swf', 'mkv', 'avi', 'rm', 'rmvb', 'mpeg', 'mpg', 'ogg', 'ogv', 'mov', 'wmv', 'mp4', 'webm', 'mp3'],
		    //最大上传文件的大小（KB）
		    maxFileSize : 9999999999999999999,
		    //是否显示路径文本框
		    showCaption:true,
		    //是否显示预览
		    showPreview:true,
		    //是否显示关闭预览框
		    showClose:false,
		    //是否显示文件选择按钮
		    showBrowse:true,
		  //文件上传的路径，设置可实现拖拽
			uploadUrl :'<%=request.getContextPath()%>/controlleer/headImgUpload.do',
		    validateInitialCount:true,
		    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
		    msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		});
		
		//fileuploaded 上传文件之后的方法
		$('#file').on('fileuploaded', function(event, data, previewId, index) {
			bootbox.alert("上传成功")
			//console.info(data.response.imgId);
			//图片主键回显到隐藏域
			$("#fileImg").val(data.response.file);
		});		
	})
	

</script>		
</body>
</html>