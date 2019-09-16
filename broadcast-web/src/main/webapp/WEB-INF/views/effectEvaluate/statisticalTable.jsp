<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
%>
<html>

<head>
	<meta charset="UTF-8">
	<title>统计报表</title>
	<%@include file="../common/css.jsp" %>
	<style type="text/css">					
		body{
			font-size: 14px !important;
			
		}
		table {
			font-size: 14px !important;
		}
			
	</style>
</head>

<body>
<h4><b>当前位置:效果评估>>统计报表</b></h4>
<div class="content_table container">
	<div class="row" style="height:40%">
	     <div class="col-md-4" style="height:100%">                         
               <div id="historyBro_pie" style="width: 100%; height: 100%;"></div>           
         </div>
         <div class="col-md-4" style="height:100%">	      
               <div id="historyAveCoverage_bar" style="width: 100%; height: 100%;"></div>
         </div>
          <div class="col-md-4" style="height:100%">
               <div id="historyAveAnswerTime_bar" style="width: 100%; height: 100%;"></div>
         </div>
	<div>
	<div class="row" style="height:110%">
	     <div class="col-md-5" style="height:100%">
           	   <div id="todayworkInfo_line" style="height: 120%;width: 100%;"></div>
         </div>
         <div class="col-md-7" style="height:100%">
         	   <div style="margin:0 auto;font-size:18px;font-weight:bold;text-align:center">实时广播信息</div>
               <table class="table" id="brocastingTable" style="height: 50%;width: 100%;"></table>
         </div>
	<div>
</div>	

<%@include file="../common/js.jsp" %>
<script type="text/javascript">
//历史播发任务统计
var historyBro_pie = echarts.init(document.getElementById('historyBro_pie'));  
$.post("${ctx}/effectEvaluate/statisticalTable/showBroTypePie", function(result) {
	 var data = result.data;
	 console.log(data);
	 var broTypeData=[];
	 for(var i=0;i<data.names.length;i++){
	     var obj=new Object();
	     obj.name=data.names[i]; 
	     obj.value=data.values[i];
	     broTypeData[i]=obj;
	 }
   
	 historyBro_pie.setOption({
        title : {  
            text: '历史播发任务统计',  
            x:'center'  
        },  
        tooltip : {  
            trigger: 'item',  
            formatter: "{b} <br/>{c} : {d} %"      //a 系列名称，b 数据项名称，c 数值，d 百分比
        },  
        legend: {  
       	    bottom: -5,
            left: 'center',
            textStyle: {
                color: '#ffffff'
            },
            data:data.names 
        },    
        color:['#C23531','#61A0A8','#2F4554'],
        series : [  
            {  
                name:'广播数量',  
                type:'pie',  
                radius : '54%',//饼图的半径大小  
                center: ['50%', '53%'],//饼图的位置  
                data:broTypeData,
                left: 'left',
                label: {
                    normal: {
                        show: true,
                        position: 'outside',                 
                        formatter: '{d}%',
                        //模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。
                        //{d}数据会根据value值计算百分比
                        textStyle: {
                            align: 'center',
                            baseline: 'middle',
                            color: 'white'
                        }
                    },
                },
            }  
        ]    
    })
}) 

//历史任务平均覆盖率
var historyAveCoverage_bar = echarts.init(document.getElementById('historyAveCoverage_bar'));  
$.post("${ctx}/effectEvaluate/statisticalTable/showAveCoverageBar", function(result) {
	 var data = result.data;
	 console.log(data);	
   
	 historyAveCoverage_bar.setOption({
   		title : {  
            text: '历史任务平均覆盖率',  
            x:'center',
        },  
        color: ['#44A843'],
        toolbox: {
            show: true,
            feature: {
            	magicType: {type: ['line', 'bar']},
                saveAsImage: {show: true},
            },
	        iconStyle:{
                normal:{
                	color:'#2F4554',
                }
            },
            top: '8%',
        },
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : data.names,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                min : 0,
                max : 100,
               	axisLabel: {
                     formatter: '{value} %'
                }
            }
        ],
        series : [
            {
                name:'平均覆盖率',
                type:'bar',
                barWidth: '60%',
                data:data.values,
                label: {
  			      normal: {
  			          show: true,
  			          position: 'top',
  			          formatter: '{c}%',
  			          textStyle: {
  			            color: 'white'
  			          }
  			      }
  			 },
            }
        ]
    })
}) 

//历史任务平均时效
var historyAveAnswerTime_bar = echarts.init(document.getElementById('historyAveAnswerTime_bar'));  
$.post("${ctx}/effectEvaluate/statisticalTable/showAveAnswerTimeBar", function(result) {
	 var data = result.data;
	 console.log(data);	
   
	 historyAveAnswerTime_bar.setOption({
    	 title : {  
             text: '历史任务平均时效',  
             x:'center'  
         },  
        color: ['#44A843'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            show: true,
            feature: {
            	magicType: {type: ['line', 'bar']},
                saveAsImage: {show: true},
            },
	        iconStyle:{
                normal:{
                	color:'#2F4554',
                }
            },
            top: '8%',
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : data.names,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                min : 0,
               	axisLabel: {
                     formatter: '{value}s'
                }
            }
        ],
        series : [
            {
                name:'平均时效',
                type:'bar',
                barWidth: '60%',
                data:data.values,
                label: {
  			      normal: {
  			          show: true,
  			          position: 'top',
  			          formatter: '{c}s',
  			          textStyle: {
  			            color: 'white'
  			          }
  			    }
  			 },
            }
        ]
    })
}) 

//实时广播播发状况
var todayworkInfo_line = echarts.init(document.getElementById('todayworkInfo_line'));  
$.post("${ctx}/effectEvaluate/statisticalTable/showRealtimeBroInfoLine", function(result) {
	 var data = result.data;
	 console.log(data);	
	 todayworkInfo_line.setOption({
	        tooltip: {
	            trigger: 'axis',
	        },
	        title: {
	            left: 'center',
	            text: '实时广播播发状况',
	        },
	        toolbox: {
	            show: true,
	            feature: {
	            	magicType: {type: ['line', 'bar']},
	                saveAsImage: {show: true},
	            },
		        iconStyle:{
	                normal:{
	                  color:'#2F4554',//设置颜色
	                }
	            },
	            right: '8%',
	            top: '6%',
	        },
	        calculable: true,
	        xAxis: [
	            {
	                type: 'category',
	                boundaryGap: false,
	                data: data.names,
	                "axisLabel":{
	            		interval: 0
	            	},
	            }
	        ],
	        yAxis: [
	            {
	                type: 'value',
	            }
	        ],
	        series: [
	            {
	                name: '广播数量',
	                type: 'line',
	                data: data.values,
	                label: {
    			       normal: {
    			          show: true,
    			          position: 'top',
    			          formatter: '{c}',
    			          textStyle: {
    			            color: 'white'
    			          }
	    			   },
	                }
	             /*    markPoint: {
	                    data: [
	                        {type: 'max', name: '最大值'},
	                        //{type: 'min', name: '最小值'}
	                    ]
	                },  */
	           /*      markLine: {
	                    data: [
	                        {type: 'average', name: '平均值'}
	                    ]
	                } */
	            }
	        ]
	    })
}) 

//实时广播信息
var columns= [
        [ {
            field: 'broId',
            title: '广播ID',
            align: 'center',
            width: "15%",
        }, {
            field: 'messageLevel',
            title: '消息级别',
            align: 'center',
            width: "10%",

        }, {
            field: 'broArea',
            title: '播发区域',
            align: 'center',   
            width: "15%",
        }, {
            field: 'startTime',
            title: '开播时间',
            align: 'center',
            width: "15%",
            formatter: function (time) {
                return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : "";
            },
        }, {
            field: 'coverageRate',
            title: '覆盖率',
            align: 'center',
            width: "10%",
            formatter: function (coverage) {
                return coverage+"%";
            },
        }, {
            field: 'responseTime',
            title: '发布时效',
            align: 'center',
            formatter: function (responseTime) {
                return responseTime/1000+"s";
            },
        }]
    ];

$(function () {
	$('#brocastingTable').bootstrapTable({
			url: "${ctx}/effectEvaluate/statisticalTable/selectBroadcastingInfo",
			method: 'get',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            search: false, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            toolbar: '#toolbarComputer', // 工具按钮用哪个容器
            sortable: false, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: false, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                };
            },
            responseHandler: function (result) {
                daily_data = result.data.list;
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },
      
        });
})
</script> 
</body>
</html>