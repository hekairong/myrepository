<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入bootstrap的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<!-- 引入bootstrap-treeview的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" >
<!-- 引入bootstrap-addTabs的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/addTabs/addTabs.css" rel="stylesheet" >
<!-- 引入bootstrap-table的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap/table/bootstrap-table.min.css" rel="stylesheet" >
<!-- 引入fileinput的css -->
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/fileinput/css/fileinput.min.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">


<!-- 引入jquery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/jquery.min.js"></script>
<!-- 引入my97 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/my97/WdatePicker.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootstrap/js/bootstrap.min.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/treeview/bootstrap-treeview.min.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/addTabs/addTabs.js"></script>
<!-- 引入bootstrap-table的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- 引入bootbox.js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootbox/bootbox.js"></script>
<!-- 引入fileinput的js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/fileinput/js/fileinput.min.js"></script>
<!--  引入fileinput的js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/fileinput/js/locales/zh.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/fileinput/themes/fa/theme.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

</head>

<body>
<form id="userForm">
			<input type="hidden"   name="userid" value="${c.userid}">
		
		  <div class="form-group">
		    <label for="proName">用户名称</label>
		    <input type="text" class="form-control" name="username" value="${c.username}"  id="proName" placeholder="用户名称">
		  </div>
		<div class="form-group">
		    <label for="exampleInputPassword1">用户密码</label>
		    <input  name="userpwd"  value="${c.userpwd}" class="form-control" placeholder="用户密码" />
		  </div>
		  
  <div class="form-group">
		    <label for="exampleInputPassword1">用户类型</label>
		   <select id= "typeid" name = "usertype"  class="form-control">
		    	<option value="0">--请选择--</option>
		    		<option  ${c.usertype=="普通用户"?"selected":"" } value="普通用户" >普通用户</option>
		    		<option   ${c.usertype=="黄金会员"?"selected":"" } value="黄金会员"  >黄金会员</option>
		    		<option    ${c.usertype=="白金会员"?"selected":"" } value="白金会员"  >白金会员</option>
		    		<option   ${c.usertype=="砖石会员"?"selected":"" }  value="砖石会员"  >砖石会员</option>
		    		
		    </select> 
		  </div> 

		  <div class="form-group">
		    <label for="exampleInputPassword1">用户年龄</label>
		    <input type="number" name="enabled"  value="${c.enabled}" class="form-control" placeholder="用户年龄" />
		  </div>
		  
		  	<div class="form-group">
		    <label for="exampleInputPassword1">用户QQ</label>
		    <input  name="qq"  value="${c.qq}" class="form-control" placeholder="用户QQ" />
		  </div>
	<div class="form-group">
		    <label for="exampleInputPassword1">用户邮箱</label>
		    <input  name="email"   value="${c.email}" class="form-control" placeholder="用户邮箱" />
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">用户手机</label>
		    <input  name="userphone"  value="${c.userphone}" class="form-control" placeholder="用户手机" />
		  </div>
		    <div class="form-group">
		    <label for="exampleInputPassword1">用户账号</label>
		    <input  name="loginnumber"   value="${c.loginnumber}" class="form-control" placeholder="用户账号" />
		  </div>


		</form>
<script type="text/javascript">
</script>

</body>
</html>