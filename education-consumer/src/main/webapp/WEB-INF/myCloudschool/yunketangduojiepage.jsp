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
<body><br>
<div>
<c:forEach items="${morelist }" var="moreyun">

	<div class="col-xs-4" style="width:260px;height:240px;border:1px solid #c0c0c0;margin-right: 20px;margin-top: 20px;" >
		<section class="course-img">
			<img  src="<%=request.getContextPath() %>/img/123.jpg" width="100px" height="100px" class="img-responsive" alt="${moreyun.classroomname}">
		</section>
		<h4 class="hLh30 txtOf mt10">
			<a href="<%=request.getContextPath() %>/yunschool/queryMoreYunSchoolById.do?classroomid=${moreyun.classroomid }" title="${moreyun.classroomname}" class="course-title fsize18 c-333">${moreyun.classroomname}</a>
		</h4>
		<section class="mt10 hLh20 of">
			<span class="fr jgTag bg-green">
			<tt class="c-fff fsize12 f-fA">
			<c:if test="${moreyun.approvalstatus =='1'}">
			   <font>审批已通过</font>
			</c:if>
			<c:if test="${moreyun.approvalstatus == '2'}">
			  <font>审批未通过</font>
			</c:if>
			</tt>
			</span>
		</section>
	</div>
</c:forEach>
</div>
</body>
</html>