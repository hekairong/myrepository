<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../jsr/yinbao.jsp"></jsp:include>
</head>
<body>
<form id="edit-form">
<input type="hidden" name="id" value="${hx.id }">
<center>
<table border="0px">
      <tr>
         <td>姓名：</td>
         <td><input type="text" class="easyui-textbox" name="name" value="${hx.name }"><p></td>
      </tr>
      <tr>
         <td>性别：</td>
         <td>
             <input type="radio" name="sex" value="1" 
             <c:if test="${hx.sex==1 }">checked</c:if>
             >男
             <input type="radio" name="sex" value="2" 
             <c:if test="${hx.sex==2 }">checked</c:if>
             >女<p>
         </td>
      </tr>
      <tr>
         <td>年龄：</td>
         <td><input type="text" class="easyui-textbox" name="age" value="${hx.age }"><p></td>
      </tr>
      <tr>
         <td>生日：</td>
         <td><input type="text" class="easyui-datetimebox" name="birthday" value="${hx.birthday }" class="Wdate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"><p></td>
      </tr>
      <tr>
         <td>状态：</td>
         <td>
	         <input type="radio" name="userstatus" value="1" checked="checked"
	         <c:if test="${hx.userstatus==1 }">checked</c:if>
	         >正常
	         <input type="radio" name="userstatus" value="2"
	         <c:if test="${hx.userstatus==2 }">checked</c:if>
	         >冻结<p>
         </td>
      </tr>
      <tr>
         <td>手机号：</td>
         <td><input type="text" class="easyui-textbox" name="phone" value="${hx.phone }"><p></td>
      </tr>
      <tr>
         <td>邮箱：</td>
         <td><input type="text" class="easyui-textbox" name="email" value="${hx.email }"><p></td>
      </tr>
      <tr>
         <td>登录名：</td>
         <td><input type="text" class="easyui-textbox" name="loginname" value="${hx.loginname }"><p></td>
      </tr>
      <tr>
         <td>密码：</td>
         <td><input type="text" class="easyui-textbox" name="userpwd" value="${hx.userpwd }"><p></td>
      </tr>
      <tr>
         <td>个人简介：</td>
         <td><textarea id="editor_id" name="userinfo">${hx.userinfo }</textarea><p></td>
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