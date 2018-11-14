<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="img/favicon-20180516113030532.ico" type="image/x-icon">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/kindeditor.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/lang/zh_CN.js"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/easyui/themes/icon.css">
<script type="text/javascript" src="js/verify.js"></script>
<link rel="stylesheet" type="text/css" href="js/verify.css">
<link rel="stylesheet" type="text/css" href="js/demo.css">
<style>
			* {
				margin: 0;
				padding: 0;
				font-family: "黑体";/*微软雅黑  */
			}
			
			body {
				 background: #F7F7F7;
			}
			
			.form {
				position: absolute;
				top: 50%;
				left: 50%;
				margin-left: -250px;
				margin-top: -210px;
				height: 500px;
				width: 520px;
				font-size: 18px;
				-webkit-box-shadow: 0px 0px 10px #A6A6A6;
				  background-color:rgba(10%,20%,30%,0.3);/* 红绿蓝颜色配比，不透明度30% */
			}
			
			.border-btn {
				border-bottom: 1px solid #ccc;
			}
			
			#landing,
			#registered,
			#registere{
				float: left;
				text-align: center;
				width: 170px;
				padding: 15px 0;
				color: #f47920;/*字体颜色  */
			}
			
			
			
			#landing-content {
				 clear: both; 
			}
			
			.inp {
				height: 25px;
				margin: 0 auto;
				margin-bottom: 30px;
				width: 200px;
				
			}
			
			.inp>input {
				text-align: center;
				height: 30px;
				width: 200px;
				margin: 0 auto;
				transition: all 0.3s ease-in-out;
				color: #f47920;/*字体颜色  */
				/*  color:#401c44; *//*字体颜色  */
				   background-color:rgba(60%,70%,80%,0.6); /* 红绿蓝颜色配比，不透明度30% */
			}
			
			.login {
				border: 1px solid #A6A6A6;
				color: #a6a6a6;
				height: 30px;
				width: 202px;
				text-align: center;
				font-size: 13.333333px;
				margin-left: 70px;
				line-height: 30px;
				margin-top: 30px;
				transition: all 0.3s ease-in-out;
			}
			
			.login:hover {
				background: #A6A6A6;
				color: #fff;
			}
			
			#bottom {
				margin-top: 35px;
				font-size: 13.333333px;
				color: #a6a6a6;
			}
			
			#registeredtxt {
				float: left;
				margin-left: 80px;
			}
			
			#forgotpassword {
				float: right;
				margin-right: 80px;
			}
			
			#photo {
				border-radius: 80px;
				border: 1px solid #ccc;
				height: 80px;
				width: 80px;
				margin: 0 auto;
				overflow: hidden;
				clear: both;
				margin-top: 30px;
				margin-bottom: 30px;
			}	
			
			#photo>img:hover {
				-webkit-transform: rotateZ(360deg);
				-moz-transform: rotateZ(360deg);
				-o-transform: rotateZ(360deg);
				-ms-transform: rotateZ(360deg);
				transform: rotateZ(360deg);
			}
			
			#photo>img {
				height: 80px;
				width: 80px;
				-webkit-background-size: 220px 220px;
				border-radius: 60px;
				-webkit-transition: -webkit-transform 1s linear;
				-moz-transition: -moz-transform 1s linear;
				-o-transition: -o-transform 1s linear;
				-ms-transition: -ms-transform 1s linear;
			}
			
			
			#registered-content {
				margin-top: 40px;
				display: none;
			}
			
			#registere-content {
				margin-top: 40px;
				display: none;
			}
			
			.fix {
				clear: both;
			}
			.form{
				display: none;
			}
		</style>
	<style type="text/css">
   .col-center-block {  
    float: none;  
    display: block;
    padding-top:50px;
	margin-top:130px;  
    margin-left: auto;  
    margin-right: auto;  
	}
	
	body{
		background-color:#eee;
		background-image: url(<%=request.getContextPath()%>/img/timg.jpg); 
		background-size:100%;
	} 
	</style>
</head>
	<body>
	<!-- 登录 -->
		<div class="form" style="display: block;">
			<div id="landing" class="border-btn">登录</div>
			<div class="fix"></div>
			<div id="landing-content" style="display: block;">
				<div id="photo"><img src="js/index_data/photo.jpg"></div>
				<div class="inp"><input  name="username" placeholder="用户名" type="text" id="uname" value="${username }"></div>
				<div class="inp"><input  name="userpassword" placeholder="密码" type="password" id="pwd"></div>
				
				<div id="mpanel1">
				<div class="verify-bar-area" style="width: 1202.4px; height: 40px; line-height: 40px;"><span class="verify-msg">向右滑动解锁</span><span class="verify-msg"></span></div></div>				
				<center><button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;margin-top:20px" onclick='login()'>登录</button></center> 
				<div id="bottom"  onclick="getAA()"><span id="registeredtxt">免登录？来这儿</span><span id="forgotpassword">忘记密码</span></div>
			<!-- 	<div class="verify-bar-area" style="width: 1202.4px; height: 40px; line-height: 40px;"><span class="verify-msg">向右滑动解锁</span><span class="verify-msg"></span></div></div>				 -->
				
				
				<%-- <center><button style="border:none;width:120px;height:40px; border-radius:18px;background-color:while;margin-top:20" onclick='login()'>登录</button></center> 
				<div id="bottom"><span id="registeredtxt">立即注册</span><span id="forgotpassword">忘记密码</span></div>
				<div class="verify-bar-area" style="width: 1202.4px; height: 40px; line-height: 40px;background-color:rgba(60%,70%,80%,0.6);"><span class="verify-msg">向右滑动解锁</span><span class="verify-msg"></span></div></div>				
				<br> --%>
				<%-- <center><button style="border:none;width:120px;height:40px; border-radius:18px;background-color:while;margin-top:20" onclick='login()'>登录</button></center> 
				<div id="bottom"><span id="registeredtxt">立即注册</span><span id="forgotpassword">忘记密码</span></div> --%>
			</div>
			
			<!-- 注册 -->
			<div id="registered-content" style="display: none;">
				<div class="inp"><input placeholder="输入用户名" type="text" name="username" id="name"><span id="sp"></span></div>
				<div class="inp"><input placeholder="输入密码" type="password" name="userpassword" id="password"></div>
				<div class="inp"><input placeholder="再次输入密码" type="password"></div>
				<div class="inp"><input placeholder="输入手机号获取验证码" type="text" name="phone" id="phone"></div>
				<div class="inp"><center> <button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" id="anniu" onclick="fasongyz()">发送验证码</button> 
				<!-- <div class="inp"><input type="button" id="anniu" onclick="fasongyz()">发送验证码 -->
 				<button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" id="anniu">(<strong class="a">60</strong>秒 )</button></center> </div>
 				<!-- <a  class="easyui-linkbutton" id="anniu" >(<strong class="a">60</strong>秒 )</a> -->
 				<div class="inp"><input placeholder="输入手机验证码" type="text" name="checkcode" id=checkcode></div>
				<center><button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" onclick="zhuce()">立即注册</button>
				<button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" onclick="fanhui()">已有账号？</button></center> 
			</div >
			
			<!-- 人脸识别 -->
			<div id="registere-content">
			<center><canvas id="canvas"></canvas>
			<video id="video" autoplay width="200" height="150"></video>
			<button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" onclick="saomiao()">开始扫描</button>
			<button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" onclick="zhuapai()">抓拍</button>
			<button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" onclick="guanbi()">关闭扫描</button>
			  <span id="daojishi"></span>
			<button style="border:none;width:70px;height:30px; border-radius:18px;background-color:while;" onclick="UploadPic()">登录</button>
			</center>
			</div>
		</div>
	
<script type="text/javascript">


$("#name").blur(function (){
    $.ajax({
    	url:"getUserByLoginName.do",
    	type:"post",
    	data:{"name":$("#name").val()},
    	dataType:"text",
    	async:false,
    	success:function (data){
    		if(data==0){
    			$("#sp").html("<font color='red' size='1'>该账号已存在</font>");
    		}else{
    			$("#sp").text("√");
    		}
    	},
    	error:function (){
    		alert("后台错误，请联系管理员");
    	}
    })		  
  })


function fanhui(){
	
	location.href="<%=request.getContextPath()%>/index.jsp";
	
}

function fasongyz(){
	
	var phone=$("#phone").val();
	if(phone==null||phone==""){
		
		alert("请输入合法号码")
		
	}else{
		$("#anniu").prop("disabled",true);
		$("#anniu").html("再次发送")
		$(document).ready(function() {
			var times = 60 * 100; // 60秒
			countTime = setInterval(function() {
				times = --times < 0 ? 0 : times;
				var ms = Math.floor(times / 100).toString();

				if(ms.length <= 1) {
					ms = "0" + ms;
				}
				var hm = Math.floor(times % 100).toString();
				if(hm.length <= 1) {
					hm = "0" + hm;
				}
				if(times == 0) {
					
					$("#anniu").removeAttr("disabled");
				
					clearInterval(countTime);
				}
				// 获取分钟、毫秒数
				$(".a").html(ms);
				$(".b").html(hm);
			}, 10);
		});
		
		$.ajax({
			url:"<%=request.getContextPath()%>/getyanzhengma.do",
			type:"post",
			data:{"phone":phone},
			dataType:"json",
			async:false,
			success:function (){
				
			},
			error:function(){
				alert("注册出错！！！")
			}				
		})
	}}
		
		function login(){
			
			$.ajax({
				
				url:"<%=request.getContextPath()%>/Wscon/getLogin.do",
				type:"post",
				data:{"username":$("#uname").val(),"userpassword":$("#pwd").val()},
				dataType:"json",
				success:function(data){

					if(data=="1"){
						
						$.messager.alert("提示","登录成功");
						location.href = "<%=request.getContextPath()%>/index/toshouye.do";
						
					}else if(data=="3"){
						
						$.messager.alert("提示","账号输入有误");
						
					}else if(data=="2"){
						
						$.messager.alert("提示","密码输入有误");
						
					}
				}
			}) 
		}
		
		
		function zhuce(){
			$.ajax({
				url:"<%=request.getContextPath()%>/saveuserinfo.do",
				type:"post",
				data:{"username":$("#name").val(),"userpassword":$("#password").val(),"phone":$("#phone").val(),"checkcode":$("[name='checkcode']").val()},
				dataType:"json",
				async:false,
				success:function (result){
					
					if(result=="1"){
						
						alert("注册成功");
						
						location.href="<%=request.getContextPath()%>/index.jsp"
					}
					if(result=="2"){
						
						alert("注册失败")
					}
					
				},
				error:function(){
					
					alert("注册出错！！！")
				}				
			})
		
		}		
</script>
<script>
			$(document).ready(function() {
				
				$(".form").slideDown(500);
				
				$("#landing").addClass("border-btn");

				$("#registered").click(function() {
					$("#landing").removeClass("border-btn");
					$("#registere").removeClass("border-btn");
					$("#landing-content").hide(500);
					$("#registere-content").hide(500);
					$(this).addClass("border-btn");
					$("#registered-content").show(500);
					
				})
				
				$("#registere").click(function() {
					$("#landing").removeClass("border-btn");
					$("#registered").removeClass("border-btn");
					$("#landing-content").hide(500);
					$("#registered-content").hide(500);
					$(this).addClass("border-btn");
					$("#registere-content").show(500);
					
				})

				$("#landing").click(function() {
					$("#registered").removeClass("border-btn");
					$("#registere").removeClass("border-btn");
					$(this).addClass("border-btn");
					$("#landing-content").show(500);
					$("#registered-content").hide(500);
					$("#registere-content").hide(500);
				})
				
			});
		</script>
		
		
		<script type="text/javascript">
		$('#mpanel1').slideVerify({
			type : 1,		//类型
			vOffset : 5,	//误差量，根据需求自行调整
			barSize : {
				width : '100%',
				height : '40px',
			},
			ready : function() {
			},
			success : function() {
				alert('验证成功！');
				//......后续操作
			},
			error : function() {
			     alert('验证失败！')
			}
			
		});
		</script>
		
		

</body>