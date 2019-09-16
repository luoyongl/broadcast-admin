<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统告警记录</title>
    <%@include file="../common/css.jsp" %>
    <style>
        .left-container{
            border: 2px solid #fff;
            border-right: none;
            border-radius: 5px 0 0 5px;
            width: 50%;
            float: left;
        }
        .right-container{
            border: 2px solid #fff;
            border-radius: 0 5px 5px 0;
            width: 50%;
            float: left;
        }
        .fixed-table-pagination{
            padding: 0 5px;
        }
    </style>
</head>
<body>
<h4>
    <b>当前位置:系统管理>>系统告警记录</b>
</h4>
<div class="left-container">
    <table id="tab_record"></table>
</div>
<div class="right-container">
    <div id="chart" style="height: 100%"></div>
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    $(function () {
        var alarmTypeEnumMap = ${alarmTypeEnumMap},
            $table = $('#tab_record');
        $table.bootstrapTable({
            url: "${ctx}/systemManage/systemWarning/data",
            method: 'get',
            sortable: false,
            pagination: true,
            sidePagination: 'server',
            height:$(window).height() - 80,
            smartDisplay: false,
            queryParamsType: '',
            classes: 'table table-no-bordered',
            columns: [[
                {
                    field: 'fAlarmType',
                    title: '告警类型',
                    align: 'center',
                    width: "33%",
                    formatter: function (value) {
                        return alarmTypeEnumMap[value];
                    }
                }, {
                    field: 'fAlarmDesc',
                    title: '告警描述',
                    align: 'center',
                    width: "34%",
                }, {
                    field: 'fCreateTime',
                    title: '创建时间',
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                    }
                }]],
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
            }
        });
        $('.right-container').height($('.left-container').height());
        var chart = echarts.init(document.getElementById("chart"));
        var option = {
            tooltip: {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            legend: {
                data: ${alarmTypeTextList},
                textStyle:{
                    color: '#fff'
                }
            },
            series : [
                {
                    type: 'pie',
                    radius: '70%',
                    center: ['50%', '50%'],
                    selectedMode: 'single',
                    label: {
                        normal: {
                            show: true,
                            position: 'inside',
                            formatter: "{b}:({d}%)"
                        }
                    },
                    data:${chartData},
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        chart.setOption(option, true);
    });
</script>
</body>
</html>