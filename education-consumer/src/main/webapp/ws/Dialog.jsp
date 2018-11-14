<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- DIV第三个 --><!-- DIV第三个 --><!-- DIV第三个 --><!-- DIV第三个 -->
<input type="hidden" id="classroomidi" value = "${Xsession.classroomsubject }">
<input type="hidden" id="helpteacheridi" value = "${Xsession.instructor }">
<div id="myDiv3">
<table class="table">
<caption>课程信息</caption>
   <thead>
      <tr>
         <th>
         	<div class="col-xs-4">
 			<label for="name">课堂名称</label>
        	<input type="text" class="form-control" value = "${Xsession.classroomname }" id="kcmc" disabled >
			</div>
		 </th>
      </tr>
   </thead>
   <tbody>
      
      <tr>
         <td> 
         	<div class="col-xs-4">
		    <label for="name">开课年级</label>
		    <input type="text" class="form-control"  value = "${Xsession.classroomgrade }" id="kknj" disabled >
		  	</div>
		 </td>
      </tr>
      <tr>
         <td> 
         	<div class="col-xs-4">
		    <label for="name">学科范畴</label>
		   <span id = "xuekei"></span>
		  	</div>
		 </td>
      </tr>
      <tr>
         <td> 
         	<div class="col-xs-4">
		    <label for="name">课堂老师</label>
		   <span id = "laoshii"></span>
		  	</div>
		 </td>
      </tr>
      <tr>
         <td> 
         	<div class="col-xs-4">
		    <label for="name"> 听课学生 </label>
		    <span id="stu-count-span"></span>
		    <span id="test1111">
		    ${Xsession.classroomstudent }
		    </span>
		  	</div>
		  	
		 </td>
      </tr>
      <tr>
         <td> 
         	<div class="col-xs-4">
		    <label for="name"> 指定助教 </label>
		    <input type="text" class="form-control" value = "${Xsession.specifyteacher }" id="zdzj" disabled >
		  	</div>
		  </td>
      </tr>
      <tr>
         <td> 
         	<div class="col-xs-4">
		      <label for="name">课程说明</label>
		       <textarea class="form-control" rows="3" id="kcsm" disabled>
		       ${Xsession.classroominfo }
		       </textarea>
		  	</div>
		  </td>
      </tr>
   </tbody>
</table>

开课计划(共
	<span id="myspan"></span>
	
	<span id="class-son-span">
	${hhh }
	</span>
	
次课)
<br>
<font size="5">计划详情:</font>
<table class="table">
	<thead></thead>
	<tbody>
	${hhhh }
	</tbody>
</table>

</div>
<script>

	$(function(){
		
		var classroomsubject = $("#classroomidi").val();
		var instructor = $("#helpteacheridi").val();
		$("#laoshii").text(instructor);
		$("#xuekei").text(classroomsubject);
		
	})

</script>