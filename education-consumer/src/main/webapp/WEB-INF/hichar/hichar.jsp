<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title> 
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/hichar/highcharts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/hichar/modules/exporting.js"></script>
</head>
<body>
 
<div id="container" style="min-width:400px;height:400px"></div>
<script type="text/javascript">
var chart=null;
var options = {
        chart: {
        	renderTo: 'container',
            type: 'area',
            backgroundColor: {
				linearGradient: [0, 0, 500, 500],
				stops: [
					[0, 'rgb(255, 255, 255)'],
					[1, 'rgb(200, 200, 255)']
				]
			},
        },
        title: {
            text: '2018年课程学科安排'
        },
        subtitle: {
            text: '面积图'
        },
        xAxis: {
        	 title: {
                 text: '月份'
             },
            categories: [],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '学科'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
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
		url:"<%=request.getContextPath()%>/controlleer/queryChart.do",
		dataType:"json",
		 contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 success:function (data){
			
			 options.xAxis.categories=data.Xax;
			 $.each(data.userName,function (i){
				var price=eval("data.userPrice_"+i);
				var msg={
	 	 				 name:this.name,
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