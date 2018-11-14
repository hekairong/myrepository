<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/ytl/js/easyui/jquery.min.js"></script>
	  <script type="text/javascript" src="<%=request.getContextPath()%>/ytl/js/hichar/highcharts.js"></script>
	  <script type="text/javascript" src="<%=request.getContextPath()%>/ytl/js/hichar/modules/exporting.js"></script>
</head>
<body>
<div id="container" style="min-width:400px;height:400px"></div>

<script>
	var chart=null;
	   var options = {
	        chart: {
	        	renderTo: 'container',
	            type: 'column',
	            backgroundColor: {
					linearGradient: [0, 0, 500, 500],
					stops: [
						[0, 'rgb(255, 255, 255)'],
						[1, 'rgb(200, 200, 255)']
					]
				},
	        },
	        title: {
	            text: '老板们'
	        },
	        subtitle: {
	            text: '的钱'
	        },
	        xAxis: {
	        	 title: {
	                 text: '数据'
	             },
	            categories: [],
	            crosshair: true
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '钱'
	            }	
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	            '<td style="padding:0"><b>{point.y:.1f}万</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: []
	    };
	
	$(function () {
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/user/queryChart.do",
			dataType:"json",
			 contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			 success:function (data){
				 alert(data);
				 options.xAxis.categories=data.Xax;
				 $.each(data.userName,function (i){
					var price=eval("data.userPrice_"+i);
					var msg={
		 	 				 name:this.a,
		 	 				 data:price    //数据重复了  线也会重复
		 	 				};
		 				options.series.push(msg);
				 });	 
			chart=new Highcharts.Chart(options);
			 }
		});
    		
});
</script>
</body>
</html>