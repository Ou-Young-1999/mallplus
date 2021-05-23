<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>操作列表</title>
<link rel="stylesheet" href="css/bootstrap.css"/> 
<script src="js/echarts.min.js"></script>
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp" %>
	
	<br>
	
	<ul role="tablist" class="nav nav-tabs">
        <li <c:if test='${status==0}'>class="active"</c:if> role="presentation"><a href="showChart">销售报表</a></li>
    </ul>
    
    <br>
		<table class="table table-bordered table-hover">
<script>
var myChart = echarts.init(document.getElementById('complaintClassValidTrue'));

// 指定图表的配置项和数据
var option = {
            title: {
	            text: '投诉类型',
	        },
	        tooltip: {
	            trigger: 'axis'
	        },
	        legend: {
	            data: ['所有投诉','无效投诉', '有效投诉']
	        },
	        toolbox: {
	            show: true,
	            feature: {
	                dataView: {show: true, readOnly: false}, // 数据视图
	                magicType: {show: true, type: ['line', 'bar']},//line  折线图  bar 柱状图 
	                restore: {show: true},    //刷新
	                saveAsImage: {show: true} //是否能下载成图片
	            }
	        },
	        calculable: true,
	        xAxis: [  //X轴
	            {
	                type: 'category',
	                data: ['房屋管理类', '设备管理类', '秩序安全类', '环境管理类', '地产相关类', '客户纠纷类', '其他类（IT相关类）', '客户纠纷类（综合服务类)'],
	                show:true,
	                axisLabel: {
	                    interval:0,
	                    rotate:20,  //	倾斜度数
	
	                },
	                grid: {
	                    left: '10%',
	                    bottom:'15%'
	                }
	            }
	        ],
	        yAxis: [  //Y轴
	            {
	                type: 'value'
	            }
	        ],
	        series: [ //内容
	            {
	                name: '所有投诉',
	                type: 'bar',
	                data: [1,5,3,6,9,8,10,6],
	                //标签
	                label: {
	                    normal: {
	                        show: true,
	                        position:'insideTop',
	                        formatter:'{c}',//模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。{d}数据会根据value值计算百分比
	                    },
	                }
	
	            },
	            {
	                name: '无效投诉',
	                type: 'bar',
	                data:[6,9,4,4,2,4,9,7],
	                //标签
	                label: {
	                    normal: {
	                        show: true,
	                        position:'insideTop',
	                        formatter:'{c}',//模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。{d}数据会根据value值计算百分比
	                    },
	                }
	            },
	            {
	                name: '有效投诉',
	                type: 'bar',
	                data: [6,1,9,7,2,4,4,7],
	                //标签
	                label: {
	                    normal: {
	                        show: true,
	                        position:'insideTop',
	                        formatter:'{c}',//模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。{d}数据会根据value值计算百分比
	                    },
	                }
	            }
	        ]
        };
 </script>
</table>
<br>${pageTool}<br>
</div>
</body>
</html>