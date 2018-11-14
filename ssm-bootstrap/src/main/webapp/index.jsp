<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/mystyle.jsp" %>
<style type="text/css">
body {padding-top:55px;}
</style>
</head>
<body>
<!--导航条  -->
<nav class="navbar navbar-inverse navbar-fixed-top">
      	<!--定义在容器顶部  -->	
	  <div class="container-fluid">
           <a class="navbar-brand">主页</a>
	  </div>
</nav>
<div class="container-fluid">
        <div class="col-xs-2">
			<div id="tree"></div>
		</div>

	    <div class="col-xs-10">
			<ul id="myTab" class="nav nav-tabs"></ul>
            <div class="tab-content"></div>
		</div>
</div>
<script type="text/javascript">
	
		$('#tree').treeview(
                {
                    data:getTreeData(),
                    onNodeSelected:function(event,node){
                        //alert(node.href)
                        console.info(node);
                        if(node.url!=null && node.url!=""){
                        	addTabs(node.text,node.url);
                                
                        }
                        
                    }
                })
		
	function addTabs(titleStr,urlStr){//标题和路径
    		$.ajax({
    			url:"<%=request.getContextPath()%>/"+urlStr,
    			success:function(info){	//info返回的是整个页面
    				$.addtabs.add({
    	                id:titleStr,
    	                title:titleStr,
    	                content:info,
    	        	})
    			}		
    		})		
    	}

	
	function getTreeData(){
            var tree_data = "";
            $.ajax({
                url:"<%=request.getContextPath()%>/tree/queryTreeList.do",
                type:"post",
                dataType:"json",
                async:false,
                success:function(data){
                    tree_data = data;
                },
                error:function(){
                    alert("查询出错");
                }
            });
            return tree_data;
        }
</script>
</body>
</html>