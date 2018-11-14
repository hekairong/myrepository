
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
body {padding-top:55px;}

</style>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      	<!--定义在容器顶部  -->	
	  <div class="container-fluid">
		  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </button>
		<!-- Brand and toggle get grouped for better mobile display -->
		<!-- 头部信息 -->
		<div class="navbar-header">
		  <a class="navbar-brand glyphicon glyphicon-globe" href="#" id="menu-toggle">
		全部应用
		  </a>
		</div>

      	
	<!-- 右边的    导航 按钮 -->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">消息</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户名称<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">用户中心</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
          </ul>
        </li>
      </ul>
		</div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
</nav>
<!-- ============================导航结束==================================-->
<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<div id="myTree"></div>
			</div>
			<div class="col-md-10">
					<div id="myTabs">
							<!-- 新选项卡 -->
							<ul class="nav nav-tabs" id="tablist">
							 <li role="presentation" class="active">
								<a href="#home" role="tab" data-toggle="tab">学生管理页面</a>
							 </li>
							</ul>
						
							<!-- 选项卡下内容 -->
							<div class="tab-content">
							 <div role="tabpanel" class="tab-pane active" id="home">
							 </div>
							</div>
					</div>
			</div>
		</div>
	</div>	
<script>
	$(function(){
		initTable();
	})
	function initTable(){
		$.ajax({
			url:'<%=request.getContextPath()%>/ytl/selectTree.do',
			type:'post',
			data:{},
			success:function(result){
				$('#myTree').treeview({
					data:result,
					onNodeSelected:function(event, node) {
							alert(node.href)
						$.addtabs({iframeHeight: 650});
						$.addtabs.add({
							id:node.id,
							title:node.text,
							url:'<%=request.getContextPath()%>'+node.href
						});

					}
			      });
			   	}
			});
		}
	</script>
</body>
</html>