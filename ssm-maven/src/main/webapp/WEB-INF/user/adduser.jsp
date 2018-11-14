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
<form id="add-form">
<center>
<table border="0px">
      <tr>
         <td>姓名：</td>
         <td><input type="text" class="easyui-textbox" name="name"><p></td>
      </tr>
      <tr>
         <td>性别：</td>
         <td><input type="radio" name="sex" value="1">男<input type="radio" name="sex" value="2">女<p></td>
      </tr>
      <tr>
         <td>年龄：</td>
         <td><input type="text" class="easyui-textbox" name="age"><p></td>
      </tr>
      <tr>
         <td>生日：</td>
         <td><input type="text" class="easyui-datetimebox" name="birthday" class="Wdate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd:HH-mm-ss'})"><p></td>
      </tr>
      <tr>
         <td>状态：</td>
         <td><input type="radio" name="userstatus" value="1" checked="checked">正常<input type="radio" name="userstatus" value="2">冻结<p></td>
      </tr>
      <tr>
         <td>手机号：</td>
         <td><input type="text" class="easyui-textbox" name="phone"><p></td>
      </tr>
      <tr>
         <td>邮箱：</td>
         <td><input type="text" class="easyui-textbox" name="email"><p></td>
      </tr>
      <tr>
         <td>个人简介：</td>
         <td><textarea id="editor_id" name="userinfo"></textarea><p></td>
      </tr>
</table>
</center>
</form>
<script type="text/javascript">
	$.getScript('<%=request.getContextPath()%>/jsr/kindeditor/kindeditor-all-min.js',
		function() {
				KindEditor.basePath = '<%=request.getContextPath()%>/jsr/kindeditor/';
				editor = KindEditor.create('#editor_id', {
					cssPath : '<%=request.getContextPath()%>/jsr/kindeditor/plugins/code/prettify.css',
					uploadJson : '<%=request.getContextPath()%>/jsr/kindeditor/jsp/upload_json.jsp',
					fileManagerJson : '<%=request.getContextPath()%>/jsr/kindeditor-/jsp/file_manager_json.jsp',
					afterBlur:function(){this.sync();}//和ajax同步
				});
        })
</script>
</body>
</html>