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
</head>
<body>
	<form id="logForm">
			<%-- <input type="hidden"  name="bookId"  value="${log.logInfoId}"> --%>

<span><font size="2px">&nbsp;&nbsp;&nbsp;基础信息:</font></span><br>
		
		  <div class="form-group">
		    <label for="proName">课堂名称</label>
		    <input type="text" class="form-control" value="${log.paramVal}"  name=""  id="" placeholder="课堂名称">
		  </div>
		<div class="form-group">
		    <label for="exampleInputPassword1">开课年级</label>
		    <input type="text" name="" value="${product.pro_price}" class="form-control" placeholder="开课年级" />
		  </div>
		
		<div class="form-group">
		    <label for="proType">学科范畴</label>
		    <select name="courseid" id="course" class="form-control">
			  
			</select>
		 </div>
		 
<hr title="分割线" lang="60%" align="center"><br>		

<span><font size="2px">&nbsp;&nbsp;&nbsp;授课信息:</font></span><br> 

		<div class="form-group">
		    <label for="proDate">授课老师</label>
		    <input type="text" class="form-control" value="${log.paramVal}"  name=""  id="" placeholder="授课老师">
		</div>
		<div class="form-group">
		    <label for="proDate">听课学生</label>
		            <button class="btn" onclick="xueshengDialog()">选择学生</button>
		</div>
		<div class="form-group">
		    <label for="proDate">指定助教</label>
		            <button class="btn" onclick="xueshengDialog()">选择助教</button>
		</div>

<span><font size="2px">&nbsp;&nbsp;&nbsp;其他信息:</font></span><br>  
  
		  <div class="form-group">
				    <label for="proImage">课程说明</label>
				   <input type="text" class="form-control" value="${log.paramVal}"  name=""  id="" placeholder="课程说明">
			</div>
			
		<center>
		        <button class="btn btn-success">保存</button>
		</center>	
			
	</form>
</body>
<script type="text/javascript">

	$.ajax({
		
		url: "<%=request.getContextPath()%>/Wscon/queryType.do",
		type: "post",
		dataType: "json",
		success: function(data){
			var html='<option value="">'+"请选择"+'</option>'
			for(var i=0;i<data.length;i++){
				html+='<option value="'+data[i].courseid+'">'+data[i].coursename+'</option>'
			}
			$("#course").html(html);
			
		},
		error: function(){
			
			bootbox.alert("请求失败");
		}
		
	})

</script>
</html>