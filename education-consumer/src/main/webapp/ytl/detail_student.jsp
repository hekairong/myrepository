<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap3/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap3/css/bootstrap-theme.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootstrap-treeview/bootstrap-treeview.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/ytl/js/bootStrap-addTabs/bootstrap.addtabs.css">


<script type="text/javascript" src="<%=request.getContextPath()%>/ytl/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/ytl/js/bootstrap3/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootstrap-treeview/bootstrap-treeview.min.js"></script>
<script src="<%=request.getContextPath()%>/ytl/js/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>

</head>
<style type="text/css">
body {padding-top:0px;}

</style>
<body>
<div class="row">
		  <div class="col-md-3">
			 <a class="list-group-item"  data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    	<img src="<%=request.getContextPath()%>/ytl/img/yonghu.bmp" /><br>
			    	用户：<font color="red">${username }</font><br>
			   </a>
			 <a class="list-group-item"  data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    	<label class="glyphicon glyphicon-home" onclick="javascript:tomain()"> 首页</label>
			   </a>
			 <a class="list-group-item" data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    	<label class="glyphicon glyphicon-menu-hamburger"> 我的课程</label>
			   </a>
			 <a class="list-group-item" data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    	<label class=" glyphicon glyphicon-pencil "> 我的作业</label>
			   </a>
			 <a class="list-group-item" data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    	<label class="glyphicon glyphicon-tasks"> 我的订单</label>
			   </a>
			 <a class="list-group-item" data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    	<label class="glyphicon glyphicon-heart-empty"> 我的收藏</label>
			   </a>
			 <a class="list-group-item" data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    	<label class=" glyphicon glyphicon-jpy "> 我的优惠券</label>
			   </a>
			
			 </div>
			 
			  <div class="col-md-9">
			   <a class="list-group-item" data-addtab="userMenu" data-target="#tabs" data-url="http://www.baidu.com">
			    
			   
			    
			   </a>
			   </div>
</div>			 
	<script>
	    
	
	
	</script>
</body>
</html>