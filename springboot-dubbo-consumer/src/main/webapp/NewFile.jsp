<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 引入bootstrap的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet" >

<!-- 引入bootstrap-treeview的css -->
<link  href="<%=request.getContextPath()%>/static/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet" >

<!-- 引入bootstrap-addTabs的css -->
<link  href="<%=request.getContextPath()%>/static/bootStrap-addTabs/bootstrap.addtabs.css" rel="stylesheet" >

<!-- 引入jquery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/jquery.min.js"></script>

<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap3/js/bootstrap.min.js"></script>

<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap-treeview/bootstrap-treeview.min.js"></script>

<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
</head>
<body>
			<!-- 导航头 -->
	<nav class="navbar  navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">金科在线教育系统</a>
    </div>
   
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">消息</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户名称 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">用户中心</a></li>
            <li><a href="#">注销</a></li>
         
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>



	<div class="row">
		  <div class="col-md-2">
				<div id="myTree"></div>
				
			</div>
			<div class="col-md-10">
				<div id="myTabs">
					<!-- 新选项卡 -->
					<ul class="nav nav-tabs" id="tablist">
					 <li role="presentation" class="active">
						<a href="#home" role="tab" data-toggle="tab">欢迎</a>
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
	
	
	
	
	
		            
						
<script type="text/javascript">
	
	 $(function(){
		initTree();
		
	})
	function initTree(){		
		$.ajax({			
			url:'<%=request.getContextPath()%>/area/getNavTree.do',
			type:'post',
			data:{},
			dataType:'json',
			success:function(result){
				$('#myTree').treeview({
					data:result,
					onNodeSelected:function(event, node) {
						
						$.addtabs({iframeHeight: 800});
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