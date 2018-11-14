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
<body ><br>
<div>
<c:forEach items="${list }" var="yun">

	<div class="col-xs-4" style="width:260px;height:240px;border:1px solid #c0c0c0;margin-right: 20px;margin-top: 20px;" >
		<section class="course-img">
			<img  src="<%=request.getContextPath() %>/img/123.jpg" width="100px" height="100px" class="img-responsive" alt="${yun.classroomname}">
		</section>
		<h6 class="hLh30 txtOf mt10" id="times">
		   开课时间:<font color="red">${yun.classroomstarttime }</font>
		</h6>
		<h4 class="hLh30 txtOf mt10">
			<a href="<%=request.getContextPath() %>/yunschool/queryYunSchoolById.do?classroomid=${yun.classroomid }" title="${yun.classroomname}" class="course-title fsize18 c-333">${yun.classroomname}</a>
		</h4>
		<section class="mt10 hLh20 of">
			<span class="fr jgTag bg-green">
			<tt class="c-fff fsize12 f-fA">
			<c:if test="${yun.approvalstatus =='1'}">
			   <font>进行中...</font>
			</c:if>
			<c:if test="${yun.approvalstatus == '2'}">
			  <font>审批中...</font>
			</c:if>
			<c:if test="${yun.approvalstatus == '3'}">
			  <font>未通过审批...</font>
			</c:if>
			<c:if test="${yun.approvalstatus == '4'}">
			  <font>课程已结束...</font>
			</c:if>
			</tt>
			</span>
		</section>
	</div>
</c:forEach>
</div>
<!-- <script type="text/javascript">  
    function countTime() {  
        //获取当前时间  
        var date = new Date();  
        var now = date.getTime();  
        //设置截止时间  
        var str="2018/11/11 00:00:00";
        var endDate = new Date(str); 
        var end = endDate.getTime();  
        
        //时间差  
        var leftTime = end-now; 
        //定义变量 d,h,m,s保存倒计时的时间  
        var d,h,m,s;  
        if (leftTime>=0) {  
            d = Math.floor(leftTime/1000/60/60/24);  
            h = Math.floor(leftTime/1000/60/60%24);  
            m = Math.floor(leftTime/1000/60%60);  
            s = Math.floor(leftTime/1000%60);                     
        }  
        //将倒计时赋值到div中  
        document.getElementById("_d").innerHTML = d+"天";  
        document.getElementById("_h").innerHTML = h+"时";  
        document.getElementById("_m").innerHTML = m+"分";  
        document.getElementById("_s").innerHTML = s+"秒";  
        //递归每秒调用countTime方法，显示动态时间效果  
        setTimeout(countTime,1000);  

    }  
</script>   -->
</body>
</html>