<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="typeclassroom">
<div style="float:left">
<button type="button" class="btn btn-primary" onclick="toaddmore()">创建系列课程</button>
</div>
<div style="float:right">
<button type="button" class="btn btn-primary" onclick="toaddone()">创建单课程</button>
</div>
</div>
<script type="text/javascript">
 function toaddone(){
	 location.href="<%=request.getContextPath()%>/index/toaddonePage.do"
	 <%-- dialog("<%=request.getContextPath()%>/index/toaddonePage.do","<%=request.getContextPath()%>/yunschool/addClassRoom.do","新增课程"); --%>
 }
 
 function toaddmore(){
	 dialog("<%=request.getContextPath()%>/index/toaddmorePage.do","<%=request.getContextPath()%>/yunschool/addClassRoom.do","新增系列课程");
 }
</script>
</body>
</html>