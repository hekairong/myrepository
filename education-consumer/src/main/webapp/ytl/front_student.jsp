<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/commons/mystyle.jsp" %>
</head>
<body>
<div>
<c:forEach items="${list }" var="yun">

	<div class="col-xs-4" style="width:300px;height:200px;border:1px;solid:#F00" >
		<section class="course-img">
			<img  src="<%=request.getContextPath() %>/ytl/img/jiaoshi2.jpg" width="100px" height="100px" class="img-responsive">
		</section>
		<h6 class="hLh30 txtOf mt10">
		   课程名称:<font color="red">${yun.coursename }</font>
		</h6>
		<h6 class="hLh30 txtOf mt10">
		   开课时间:<font color="red">${yun.starttime }</font>
		</h6>
		<div>  

        </div> 
	</div>
</c:forEach>
</div>
<script type="text/javascript">
 
</script>
</body>
</html>