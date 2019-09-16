<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>服务器状态</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .panel {
            border: 1px solid #0083f0;
            border-radius: 10px;
            margin: 10px 0;
            background: rgba(0, 0, 0, 0.0); 
        }

        .panel .panel-header {
            color: #0083f0;
            padding: 10px;
            background: rgba(0, 0, 0, 0.1);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .panel .panel-body {
            height: 200px;
            padding: 0;
        }
        b {
        	color:#fff;
        }
    </style>
</head>
<body>
<h4><b>当前位置:系统管理>>服务器状态</b></h4>
<ul class="nav nav-tabs">
    <li class="selected_tab"><a>CPU/内存</a></li>
    <li><a>网卡</a></li>
    <li><a>磁盘分区</a></li>
    <!-- <li><a>进程</a></li> -->
    <li><a>关键服务进程</a></li>
</ul>
<div class="tab_modal show">
    <div class="row">
        <div class="col-sm-5">
            <div class="panel">
                <div class="panel-header"><b>CPU使用率</b></div>
                <div class="panel-body">
                    <div id="cpuUsedRatio" style="height: 200px"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="panel">
                <div class="panel-header"><b>CPU使用记录</b></div>
                <div class="panel-body">
                    <div id="cpuUsedRecord" style="height: 200px"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="panel">
                <div class="panel-header"><b>内存使用分布</b></div>
                <div class="panel-body">
                    <div id="memoryUsedRatio" style="height: 200px"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="panel">
                <div class="panel-header"><b>内存使用记录</b></div>
                <div class="panel-body">
                    <div id="memoryUsedRecord" style="height: 200px"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="tab_modal">
    <table id="network-table" class="table table-hover"></table>
</div>
<div class="tab_modal">
    <table id="disk-table" class="table table-hover"></table>
</div>
<div class="tab_modal">
    <table id="process-table" class="table table-hover"></table>
</div>
</body>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    $(function () {
        var cpuUsedRatioChart = echarts.init(document.getElementById("cpuUsedRatio"));
        cpuUsedRatioChart.setOption(getOption('shadow', 'CPU使用率', 'bar'), true);
        var cpuUsedRecordChart = echarts.init(document.getElementById("cpuUsedRecord"));
        cpuUsedRecordChart.setOption(getOption('cross', 'CPU使用记录', 'line'), true);
        var memoryUsedRecordChart = echarts.init(document.getElementById("memoryUsedRecord"));
        memoryUsedRecordChart.setOption(getOption('cross', '内存使用记录', 'line'), true);
        var memoryUsedRatioChart = echarts.init(document.getElementById("memoryUsedRatio"));
        var option = {
            color: ['#02FFFF', 'grey'],
            tooltip: {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            series: [
                {
                    type: 'pie',
                    radius: '90%',
                    center: ['50%', '50%'],
                    selectedMode: 'single',
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: "{b}:({d}%)"
                        }
                    }
                }
            ]
        };
        memoryUsedRatioChart.setOption(option, true);
        $('#network-table').bootstrapTable({
            data: [],
            sortable: false,
            smartDisplay: false,
            search: true,
            columns: [[
                {
                    field: 'cardName',
                    title: '网卡',
                    align: 'center',
                    width: "10%"
                }, {
                    field: 'ipAddr',
                    title: 'IP',
                    align: 'center',
                    width: "20%"
                }, {
                    field: 'macAddr',
                    title: 'MAC',
                    align: 'center',
                    width: "20%"
                }, {
                    field: 'packetsRecv',
                    title: '数据包',
                    align: 'center',
                    width: "25%",
                    formatter: function (value, row) {
                        return '接收包数量:' + value + ',发送包数量:' + row.packetsSent;
                    }
                }, {
                    field: 'bytesRecv',
                    title: '数据流量',
                    align: 'center',
                    formatter: function (value, row) {
                        return '接收的数据量:' + formatBytes(value) + ',下发的数据量:' + formatBytes(row.bytesSent);
                    }
                }
            ]]
        });
        $('#disk-table').bootstrapTable({
            data: [],
            search: true,
            columns: [[
                {
                    field: 'partitionName',
                    title: '硬盘分区',
                    align: 'center',
                    width: "20%",
                }, {
                    field: 'totalValue',
                    title: '硬盘总容量',
                    align: 'center',
                    width: "20%",
                    formatter: function (value) {
                        return formatBytes(value);
                    }
                }, {
                    field: 'freeValue',
                    title: '空闲容量',
                    align: 'center',
                    width: "20%",
                    formatter: function (value) {
                        return formatBytes(value);
                    }
                }, {
                    field: 'usedValue',
                    title: '使用容量',
                    align: 'center',
                    width: "20%",
                    formatter: function (value) {
                        return formatBytes(value);
                    }
                }, {
                    field: 'percentUsed',
                    title: '使用比例',
                    align: 'center',
                    width: "20%",
                    formatter: function (value) {
                        return value + '%';
                    }
                }
            ]]
        });
        $('#process-table').bootstrapTable({
            data: [],
            search: true,
            columns: [[
                {
                    field: 'processName',
                    title: '服务进程',
                    align: 'center',
                    width: "50%",
                }, {
                    field: 'processStatus',
                    title: '状态',
                    align: 'center'
                }
            ]]
        });

        /**
         * 请求数据
         */
        function getData() {
        	
        	
            $.getJSON('serverState/data', function (result) {
                if (result.status === 200) {
                    //使用率
                    setCpuUsed(result.data.cpuUsedRatio);
                    //CPU使用记录
                    setCpuRecord(result.data.cpuUsedRecord);
                    //内存使用记录
                    setMemoryRecord(result.data.memoryUsedRecord);
                    //内存使用率
                    setMemoryRatio(result.data.memoryUsedRatio);
                    //磁盘
                    $('#disk-table').bootstrapTable('load', result.data.partitions);
                    $('#process-table').bootstrapTable('load', [{
                        processName: '县平台服务',
                        processStatus: '正常'
                    },{
                    	processName: '调控服务',
                        processStatus: result.data.serverControl===1?'正常' : '异常'
                    },{
                    	processName: '回传服务',
                        processStatus: result.data.serverReturn===1?'正常' : '异常'
                    },{
                    	processName: '省平台解析服务',
                        processStatus: result.data.serverResolve===1?'正常' : '异常'
                    },{
                        processName: '数据库服务',
                        processStatus: result.data.mysqlStatus ? '正常' : '异常'
                    }
                    ]);
                }
            });
            $.getJSON('serverState/network', function (result) {
                if (result.status === 200) {
                    $('#network-table').bootstrapTable('load', result.data);
                }
            });
        }

        getData();
        setInterval(getData, 30000);

        /**
         * 获取图形配置
         */
        function getOption(tooltipType, seriesName, seriesType) {
            return {
                color: ['#02FFFF'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: tooltipType,
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                grid: {
                    top: '20%',
                    left: '2%',
                    right: '5%',
                    bottom: '5%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: seriesType !== 'line',
                        axisLine: {
                            lineStyle: {
                                color: '#fff'
                            }
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: '#fff'
                            }
                        },
                        max: 100,
                        min: 0
                    }
                ],
                series: [
                    {
                        name: seriesName,
                        type: seriesType,
                        barWidth: '100%',
                        areaStyle: {color: '#02FFFF'},
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: function (item) {
                                    return item.value + "%";
                                }
                            }
                        },
                        lineStyle: {
                            color: '#02FFFF'
                        },
                        itemStyle: {
                            normal: {
                                color: '#02FFFF'
                            }
                        }
                    }
                ]
            }
        }

        function setCpuUsed(cpuUsedRatio) {
            var cpuUsedRatioLabel = [];
            $.each(cpuUsedRatio, function (i) {
                cpuUsedRatioLabel.push('CPU' + (i + 1));
            });
            cpuUsedRatioChart.setOption({
                xAxis: [
                    {
                        data: cpuUsedRatioLabel
                    }
                ],
                series: [
                    {
                        data: cpuUsedRatio
                    }
                ]
            });
        }

        function setCpuRecord(cpuUsedRecord) {
            var cpuUsedRecordLabel = [], cpuUsedRecordData = [];
            for (var i = cpuUsedRecord.length - 1; i >= 0; i--) {
                var item = cpuUsedRecord[i];
                cpuUsedRecordLabel.push(new Date(item.fCreateTime).format('HH:mm:ss'));
                cpuUsedRecordData.push(item.fPercentUsed);
            }
            cpuUsedRecordChart.setOption({
                xAxis: [
                    {
                        data: cpuUsedRecordLabel
                    }
                ],
                series: [
                    {
                        data: cpuUsedRecordData
                    }
                ]
            });
        }

        function setMemoryRecord(memoryUsedRecord) {
            var memoryUsedRecordLabel = [], memoryUsedRecordData = [];
            for (var i = memoryUsedRecord.length - 1; i >= 0; i--) {
                var item = memoryUsedRecord[i];
                memoryUsedRecordLabel.push(new Date(item.fCreateTime).format('HH:mm:ss'));
                memoryUsedRecordData.push(item.fPercentUsed);
            }
            memoryUsedRecordChart.setOption({
                xAxis: [
                    {
                        data: memoryUsedRecordLabel
                    }
                ],
                series: [
                    {
                        data: memoryUsedRecordData
                    }
                ]
            });
        }

        function setMemoryRatio(memoryUsedRatio) {
            memoryUsedRatioChart.setOption({
                series: [
                    {
                        data: [
                            {value: memoryUsedRatio.fFreeValue, name: '可用内存'},
                            {value: memoryUsedRatio.fUsedValue, name: '已使用内存'}
                        ]
                    }
                ]
            });
        }

        function formatBytes(bytes) {
            if (isNaN(bytes)) {
                return '';
            }
            var symbols = ['bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
            var exp = Math.floor(Math.log(bytes) / Math.log(2));
            if (exp < 1) {
                exp = 0;
            }
            var i = Math.floor(exp / 10);
            bytes = bytes / Math.pow(2, 10 * i);
            if (bytes.toString().length > bytes.toFixed(2).toString().length) {
                bytes = bytes.toFixed(2);
            }
            return bytes + ' ' + symbols[i];
        }
    });
</script>
</html>
