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
    <title></title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        html, body {
            height: 100%;
        }

        .home_content {
            height: 99%;
            width: 99%;
        }

        .left_1 {
            border: 1px solid #0083f0;
            border-radius: 10px;
            height: 50% !important;
            width: 100%;
        }

        .left_2 {
            margin-top: 1%;
            border: 1px solid #0083f0;
            border-radius: 10px;
            height: 50% !important;
            width: 100%;
        }

        .left {
            height: 100%;
        }

        .home_content li {
            list-style: none;
            color: #0083f0;
            padding: 10px;

        }

        .table tbody td {
            font-size: 14px !important;
        }

        .table thead tr th {
            font-size: 14px !important;
        }

        #waitingBroadcastUl {

            background: rgba(0, 0, 0, 0.3);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        #waitingBroadcastUl li {
            display: block;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        #pastWorking, #waitingBroadcastDiv {
            height: 80%;
            width: 98%;
            margin-left: 1%;
        }

        #beingBroadcastAnalysisUl {
            background: rgba(0, 0, 0, 0.3);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        #beingBroadcastAnalysis {
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .right {
            border: 1px solid #0083f0;
            border-radius: 10px;
        }

        .right li {
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        #historyBroadcastStatisticsUl {
            background: rgba(0, 0, 0, 0.3);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        #waitingBroadcastDiv::-webkit-scrollbar {
            display: none;
        }

        #pastWorking::-webkit-scrollbar {
            display: none;
        }

        .btn {
            padding: 9px 12px;
        }

        table {
            table-layout: fixed;
        }


        #table_home tbody tr td {
            width: 150px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .fixed-table-toolbar{
            height: 0!important;
        }

        #table_past tbody tr td {
            width: 150px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        /* 移动端样式 */
        @media screen and (max-width: 480px) {
    		body {
    			font-size: 12px!important;
    		}
        	.home_content {
			    width: 100%;
       		    height: auto;
        		overflow: unset;
        	}
			.home_content .left {
				width: 100%!important;
				height: auto;
			}
			.home_content .left .fixed-table-toolbar {
				display: none;
			}
			#waitingBroadcastDiv {
				height: auto;
			}
			.left_2 #pastWorking {
				height: auto;
			}
			.left td {
				font-size: 12px!important;
			}
			.left th:nth-child(2) {
				width: 120px!important;
			}
			.left td:nth-child(2) {
				width: 120px!important;
			}
			.left th:nth-child(3) {
				width: 50px!important;
			}
			.left td:nth-child(3) {
				width: 50px!important;
			}
			.left th:nth-child(4) {
				width: 80px!important;
			}
			.left td:nth-child(4) {
				width: 80px!important;
			}
			.left th:nth-child(5) {
				width: 80px!important;
			}
			.left td:nth-child(5) {
				width: 80px!important;
			}
			.left th:nth-child(6) {
				width: 80px!important;
			}
			.left td:nth-child(6) {
				width: 80px!important;
			}
			.left th:nth-child(7) {
				width: 120px!important;
			}
			.left td:nth-child(7) {
				width: 120px!important;
			}
			.left th:nth-child(8) {
				width: 50px!important;
			}
			.left td:nth-child(8) {
				width: 50px!important;
			}
			.left .fixed-table-container {
				height: auto!important;
				padding-bottom: 10px!important;
			}
			.left .fixed-table-container .fixed-table-body {
				height: auto!important;
			}
			.left .left_1, .left_2 {
				height: auto!important;
			}
			.left .left_1 .clearfix {
				display: none;
			}
			
			.right {
				width: 100%!important;
				margin-top: 10px;
			}
			
        	.table thead tr th {
        		font-size: 12px !important;
        	}
        	.fixed-table-container tbody td .th-inner, .fixed-table-container thead th .th-inner {
			    padding: 2px!important;
			    line-height: 22px;
			    text-align: center;
        	}
        	th {
        		text-align: center!important;
        	}
        	.btn {
        		padding: 3px;
        		font-size: 10px;
        	}
        	.fixed-table-pagination .pagination-info {
        		margin-right: 3px;
    			font-size: 10px;
        	}
        	.fixed-table-pagination .page-list {
        		font-size: 10px;
        	}
        	.home_content li {
        		padding: 0;
        		font-size: 14px;
        	}
        	.fixed-table-pagination .pagination a {
   				padding: 5px 8px;
   			}
   			.fixed-table-pagination .pagination-detail, .fixed-table-pagination div.pagination {
			    margin-top: 8px;
			    margin-bottom: 8px;
			}
			#waitingBroadcastUl,
			#beingBroadcastAnalysisUl,
			#historyBroadcastStatisticsUl {
				padding: 10px;
			}
			#waitingBroadcastUl li,
			#beingBroadcastAnalysisUl li{
				font-size: 14px;
			}
			canvas {
				font-size: 8px;
			}
		}
    </style>
</head>

<body>
<div class="home_content">

    <div class="left" style="width: 75%;float: left;margin-right: 1%;">
        <div class="left_1" style="height: 59%;">
            <ul id="waitingBroadcastUl">
                <li><b>设备实时播发状态</b></li>
            </ul>

            <div id="waitingBroadcastDiv" style="clear:both; overflow: scroll; overflow-x: scroll;">
                <table  data-height="280" class="table" id="table_home"></table>
            </div>
        </div>
        <div class="left_2">
            <ul id="beingBroadcastAnalysisUl">
                <li id="beingBroadcastAnalysis"><b>设备历史播放状态</b></li>
            </ul>
            <div id="pastWorking" style="clear:both; overflow: scroll; overflow-x: scroll;">
                <table data-height="280" class="table" id="table_past"></table>
            </div>
        </div>
    </div>
    <div class="right" style="width: 23%;float: left;">
        <ul id="historyBroadcastStatisticsUl">
            <li><b>历史播发信息统计</b></li>
        </ul>
        <div id="_pie" style="height: 45%;width: 100%;"></div>
        <div id="past" style="height: 45%;width: 100%;"></div>
    </div>
    <div class="null"></div>
</div>

<%@include file="../common/js.jsp" %>
<script>
    var windowHeight=$(window).height();

    echarts.init(document.getElementById('_pie')).setOption({
        title: {
            text: '历史播放信息占比',
            x: 'center',
            textStyle: {
                fontWeight: "normal",
                color: "#fff",
            },
        },
        legend: {
            //orient: 'vertical',
            left: 'center',
            bottom: -5,
            textStyle: {
                color: '#ffffff'
            }
        },
        tooltip: {
            trigger: 'item',
            //formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: {
            type: 'pie',
            radius: '60%',
            center: ['50%', '52%'],
            orient: 'vertical',
            left: 'left',
            startAngle: 100,
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
            labelLine: {
                normal: {
                    lineStyle: {
                        //color: 'black'
                    }
                }
            },
            data: [{
                name: '一级',
                value: ${rank_1},
            }, {
                name: '二级',
                value: ${rank_2},
            }, {
                name: '三级',
                value: ${rank_3},
            }, {
                name: '四级',
                value: ${rank_4},
            }],
            itemStyle: {
                normal: {
                    label: {
                        show: true,   //隐藏标示文字
                    },
                    labelLine: {
                        show: true,   //隐藏标示线
                    }
                }
            },
        }
    });

    echarts.init(document.getElementById('past')).setOption({
        /*tooltip : {
            trigger: 'item',
            show: true,
           // trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },*/
        tooltip: {
            trigger: 'item',
            //formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: ['一级', '二级', '三级', '四级'],
                axisTick: {
                    alignWithLabel: true
                },
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: "#ffffff"
                    },
                },
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                type: 'bar',
                // data:[${rank_1}, ${rank_2}, ${rank_3}, ${rank_4}],
                data: [{
                    name: '一级',
                    value: ${rank_1},
                }, {
                    name: '二级',
                    value: ${rank_2},
                }, {
                    name: '三级',
                    value: ${rank_3},
                }, {
                    name: '四级',
                    value: ${rank_4},
                }],
                barWidth: "70%",
                itemStyle: {
                    normal: {
                        color: function (params) {
                            var colorList = [
                                "#c23531",
                                "#2f4554",
                                "#61a0a8",
                                "#d48265",
                            ];
                            return colorList[params.dataIndex]
                        }
                    }
                },
                label: {
                    show: "true",
                    position: "top",
                    color: "#FFF",
                    fontSize: "12"
                },
            }
        ],

    });

</script>
<script type="text/javascript">
    var columns = [
        [{
            field: '',
            title: '',
            width: 10,
            formatter:function () {
                return '';
            }
        }, {
            field: 'fRealControlDevice',
            title: '设备名称',
            align: 'center',
            width: "15%",
        }, {
            field: 'fId',
            title: '广播ID',
            align: 'center',
            width: "12%",
        }, {
            field: 'fRealMessageSource',
            title: '广播来源',
            align: 'center',
            width: "15%",

        }, {
            field: 'fBroadcastType',
            title: '广播类型',
            align: 'center',
            width: "15%",
            formatter: function (value, row, index) {
                if (row.fBroadcastType == 1) {
                    return "系统演练";
                } else if (row.fBroadcastType == 2) {
                    return "模拟演练";
                } else if (row.fBroadcastType == 3) {
                    return "实际演练";
                } else if (row.fBroadcastType == 4) {
                    return "应急广播";
                } else if (row.fBroadcastType == 5) {
                    return "日常广播";
                } else if (row.fBroadcastType == 6) {
                    return "升级广播";
                } else if (row.fBroadcastType == 7) {
                    return "广播预案-应急广播";
                } else if (row.fBroadcastType == 8) {
                    return "广播预案-日常广播";
                } else if (row.fBroadcastType == 9) {
                    return "广播预案-实际演练";
                } else if (row.fBroadcastType == 10) {
                    return "广播预案-系统演练";
                } else if (row.fBroadcastType == 11) {
                    return "广播预案-模拟演练";
                } else if (row.fBroadcastType == 12) {
                    return "定时广播";
                }
            }
        }, {
            field: 'fRealMessageType',
            title: '消息类型',
            align: 'center',
            width: "15%",
        }, {
            field: 'fRealMessageLevel',
            title: '消息级别',
            width: "15%",
            align: 'center',
        }, {
            field: 'fVolumeControl',
            title: '音量',
            align: 'center',
        }]
    ];

    $("#cancelBroadcast").on('click', function () {

    });

    setInterval(function () {
        $('#table_home').bootstrapTable('refresh')
    }, 30000);

    $(function () {
        $('#table_home').bootstrapTable({
            height:(windowHeight-130)/2,
            method: 'get',
            dataType: "json",
           // search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            url: "${ctx}/monitor/terminalStatus/selectTerminalStatusList?fBroadcastType=1&fDeviceState=0",
            toolbar: '#toolbarComputer', // 工具按钮用哪个容器
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            //showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {


                if (result.status === 200) {
                    //layer.close(ii);
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            }
        });
 

        $('#table_past').bootstrapTable({
            height:(windowHeight-130)/2,
            method: 'get',
            dataType: "json",
           // search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            url: "${ctx}/monitor/terminalStatus/selectTerminalStatusList?fBroadcastType=2&fDeviceState=100",
            toolbar: '#toolbarComputer', // 工具按钮用哪个容器
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            //showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            /* responseHandler: function (result) {


                 if (result.status === 200) {
                     //layer.close(ii);
                 }
                 return {
                     total: result.data.total,
                     rows: result.data.list
                 };
             }*/
            formatNoMatches: function () {
                return '无记录';
            },
            formatRecordsPerPage: function (pageNumber) {
                return '每页 ' + pageNumber + ' 条';
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return '当前 ' + pageFrom + ' 到 ' + pageTo + ' 条，共 ' + totalRows + ' 条记录,';
            },
            responseHandler: function (result) {
                return {total: result.data.total, rows: result.data.list};
            },
            onCheck: function () {
                handleBatchDeleteBtn();
            },
            onUncheck: function () {
                handleBatchDeleteBtn();
            },
            onCheckAll: function () {
                handleBatchDeleteBtn();
            },
            onUncheckAll: function () {
                handleBatchDeleteBtn();
            }
        });
    });
</script>
</body>

</html>