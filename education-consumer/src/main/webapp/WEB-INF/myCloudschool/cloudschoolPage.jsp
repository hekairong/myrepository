<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 引入bootstrap的css -->
<link  href="<%=request.getContextPath()%>/js2/bootstrap/css/bootstrap.min.css" rel="stylesheet" >

<!-- 引入bootstrap-treeview的css -->
<link  href="<%=request.getContextPath()%>/js2/treeview/bootstrap-treeview.min.css" rel="stylesheet" >

<!-- 引入bootstrap-addTabs的css -->
<link  href="<%=request.getContextPath()%>/js2/addTabs/addTabs.css" rel="stylesheet" >

<!-- 引入jquery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js2/jquery.min.js"></script>

<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js2/bootstrap/js/bootstrap.min.js"></script>

<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js2/treeview/bootstrap-treeview.min.js"></script>

<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js2/addTabs/addTabs.js"></script>
<style type="text/css">
body {padding-top:55px;}
</style>
</head>
<body>
<!--导航条  -->
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
		云学堂
		  </a>
		</div>

      	
	<!-- 右边的    导航 按钮 -->
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${login.username }<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/index/zhuxiao.do">注销</a></li>
          </ul>
        </li>
      </ul>
		</div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid">
        <div class="col-xs-3">
			<div id="tree"></div>
		</div>

	    <div class="col-xs-9">
			<ul id="myTab" class="nav nav-tabs"></ul>
            <div class="tab-content">
                <%--  <jsp:include page="../welcome.jsp"></jsp:include> --%>
            </div>
		</div>
</div>
<input type="hidden" id = "userid" value = "${login.userid }">
<script type="text/javascript">
	var userid = $("#userid").val()
	<%-- $.ajax({
		type:"post",
		url:"<%=request.getContextPath()%>/yunschool/queryTeacherTree.do?userid="+userid,
		datatype:"json",
		success:function (msg){
			//渲染树插件 treeview()
			$("#tree").treeview({
				//data属性 树节点信息 json数组
				  data: msg,         
				  //tree默认展开的节点级别默认为2
				  levels: 0,
				  //含有子节点的图标
				  collapseIcon:'glyphicon glyphicon-star-empty',
				  //没有子节点的图标
				  emptyIcon:'glyphicon glyphicon-usd',
				  //背景颜色
				  //backColor: 'green'
				  //是否显示复选框
				  showCheckbox:true,
				  //是否允许选中多个节点
				  //multiSelect:true,
				  //启用节点的超链接功能默认为false,节点需指定href属性
				  enableLinks:true,
				  //事件当节点选中时
				  onNodeSelected:function(event,node){
					  //动态向 nav-tabs 导航标签添加tab选项卡
					  //addTabs方法  add() 添加tab  close()关闭tab  closeAll() 关闭全部tab
					  if(null !=  node.url && node.url != ""){
							  addTabs();
					  }

				  }
		})
			

			
		}
	}); --%>
	
	 $(function(){
			initTree();
			
		})
		function initTree(){
			
			$.ajax({
				
				url:'<%=request.getContextPath()%>/yunschool/queryTeacherTree.do?userid='+userid,
				type:'post',
				data:{},
				dataType:'json',
				success:function(result){
					
					$('#tree').treeview({
						data:result,
						onNodeSelected:function(event,node) {
							
							$.addtabs({iframeHeight: 600});
							$.addtabs.add({
								id:node.id,
								title:node.text,
								url:node.url
							});
					   	}
					});
				}
			})
		} 
	
	
</script>
</body>
</html>