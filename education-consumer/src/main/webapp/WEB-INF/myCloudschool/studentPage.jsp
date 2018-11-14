<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="studentTable"></table>
<script type="text/javascript">
$().ready(function(){
	$("#studentTable").bootstrapTable({
		 url:"<%=request.getContextPath()%>/yunschool/queryStudentList.do",	
		 method:"post",
		 striped: true,  	// 斑马线效果     默认false 
		 //只允许选中一行
		 singleSelect:false,
		 //选中行是不选中复选框或者单选按钮
		 clickToSelect:true,
		 //showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		 //cardView: false,                    //是否显示详细视图
		 uniqueId: "id",                 //每一行的唯一标识，一般为主键列
		 //showColumns: true,                  //是否显示所有的列
		 //showRefresh: true,                  //是否显示刷新按钮
		 //minimumCountColumns: 2,     //  最少留两列
		 detailView: false,                  //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
		columns:[
                {field:'act1',checkbox:true},
				{field:'studentname',title:'姓名',width:100},
				{field:'studentid',title:'帐号',width:100},
				],
	});
});
</script>
</body>
</html>