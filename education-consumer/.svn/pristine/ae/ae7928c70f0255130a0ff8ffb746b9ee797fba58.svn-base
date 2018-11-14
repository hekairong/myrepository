<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/commons/mystyle.jsp" %>
</head>
<body>
<br>
<div>
<div style="background-color: #c0c0c0;border:1px solid #c0c0c0;margin-left: 20px;margin-top: 20px">
我的云学堂>课堂祥情<br>
<input type="hidden" name="classroomid" value="${hx.classroomid }">
<h2 class="hLh30 txtOf mt10" id="times">
	    ${hx.classroomname}
	    </h2>
<h6 class="hLh30 txtOf mt10" id="times">
		   开课时间:<font color="red">${hx.classroomstarttime }</font>
		</h6>
<h4 class="hLh30 txtOf mt10">
	            授课年段:<font>${hx.classroomgrade }</font>
		</h4><br><br>
		<button type="button" onclick="enterClassRoom()" class="btn btn-primary">进入课堂</button>
</div>
<div style="margin-left: 20px;margin-top: 20px;float: left;">
课程计划&nbsp;&nbsp;&nbsp;&nbsp;课程信息<br><br>
课时:共计1课时<br><br>
课程简介：<font>${hx.classroominfo }</font><br><br>
学生：<font>${hx.classroomstudent }</font>
</div>
<div style="margin-right: 20px;margin-top: 20px;float: right">
任课老师<br><br>
<section class="course-img">
	<img  src="<%=request.getContextPath() %>/img/123.jpg" width="50" height="50">
</section>
<h2>${hx.instructor }</h2>
</div>
<script type="text/javascript">
function enterClassRoom(){
	//alert(imgid);
	dialog("<%=request.getContextPath()%>/yunschool/zhibo.do?imgid="+imgid+"&&mvid="+mvid,"<%=request.getContextPath()%>/book/updateUser.do","视频播放");
}
</script>
</body>
</html>