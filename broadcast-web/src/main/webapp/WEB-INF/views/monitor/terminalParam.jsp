<%--
  Created by IntelliJ IDEA.
  User: AYY
  Date: 2019/1/8
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData,cn.wtu.broadcast.config.SystemConfig" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    DictionaryConfig.getMap(request);
    request.setAttribute("regionJson", RegionData.getZTreeListJson());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>终端回传参数</title>
    <style>
        .content {
            padding: 1% 1.5%!important;
        }
        
        /* 移动端样式 */
        @media screen and (max-width: 480px) {
    		body {
    			font-size: 12px!important;
    		}
    		h4 {
    			display: none;
    		}
    		.bootstrap-table td {
    			white-space: nowrap;
    		}
    		.bootstrap-table .fixed-table-container {
    			height: auto!important;
    		}
    		#xiangqing_camera_modal .modal-dialog {
    			width: 100%!important;
    			margin: 0;
    		}
    		#xiangqing_camera_modal .modal-body .col-sm-8 {
    			display: inline-block;
    		}
   		}
    </style>
</head>
<%@include file="../common/css.jsp" %>

<body>
<h4><b>当前位置:监测监控>>终端回传参数</b></h4>
<div class="content">
    <div>
        <table data-height="450" id="tab_terminalParam" class="table table-hover"></table>
    </div>

</div>
<!-- 详情模态框（Modal） -->
<div class="modal fade" id="xiangqing_camera_modal" tabindex="-1" role="dialog"
     aria-hidden="true">
    <div class="modal-dialog" style="width: 75%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title">详情</h4>
            </div>
            <div class="modal-body" style="padding: 20px">
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备名称:</label>
                    <div class="col-sm-8">
                        <span name="fDeviceName"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备类型:</label>
                    <div class="col-sm-8">
                        <span name="fRealDeviceModel"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">电视模式:</label>
                    <div class="col-sm-8">
                        <span name="fDigitalTelevisionRadioMode"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">电视频率:</label>
                    <div class="col-sm-8">
                        <span name="fDigitalTelevisionRadioRate"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">电视信号质量:</label>
                    <div class="col-sm-8">
                        <span name="fDigitalTelevisionSignalQuality"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">电视信号强度:</label>
                    <div class="col-sm-8">
                        <span name="fDigitalTelevisionSignalStrength"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">调频频率:</label>
                    <div class="col-sm-8">
                        <span name="fSignalRateList"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">调频信号强度:</label>
                    <div class="col-sm-8">
                        <span name="fSignalStrengthList"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">电压:</label>
                    <div class="col-sm-8">
                        <span name="fVoltage"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">电流:</label>
                    <div class="col-sm-8">
                        <span name="fPowerCurrent"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备状态:</label>
                    <div class="col-sm-8">
                        <span name="fDeviceState"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">回传时间:</label>
                    <div class="col-sm-8">
                        <span name="fBackTime"></span>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    var jsonMap = JSON.parse('${dictionary}');
    var columns = [[{
        field: '',
        title: ' ',
        width: 20,
        formatter: function () {
            return '';
        }
    },
        {
            field: 'fDeviceName',
            title: '设备名称',
            width: "9%",
    		align : 'center',
        }, {
            field: 'fRealDeviceModel',
            title: '设备类型',
            width: "9%",
    		align : 'center',
        }, {
            field: 'fDigitalTelevisionRadioRate',
            title: '电视频率',
            width: "8%",
    		align : 'center',
        }, {
            field: 'fDigitalTelevisionSignalStrength',
            title: '电视信号强度',
            width: "10%",
    		align : 'center',
        }, {
            field: 'fSignalRateList',
            title: '调频一频率',
            width: "9%",
    		align : 'center',
            formatter: function (data) {
                if (data != null && data != "") {
                    var datas = data.split(",");
                    return datas[0]
                }

            }
        }, {
            field: 'fSignalStrengthList',
            title: '调频一信号强度',
            width: "10%",
    		align : 'center',
            formatter: function (data) {
                if (data != null && data != "") {
                    var datas = data.split(",");
                    return datas[0]
                }

            }
        }, {
            field: 'fVoltage',
            title: '工作电压(V)',
            width: "7%",
    		align : 'center',
        }, {
            field: 'fPowerCurrent',
            title: '电流',
            width: "5%",
    		align : 'center',
        }, {
            field: 'fDeviceState',
            title: '设备状态',
            align: 'center',
            sortable: true,
            width: '7%',
            formatter: function (data, row, index) {
                if (data == 0) {
                    return "正在广播";
                } else if (data == 1) {
                    return "在线";
                } else if (data == 2) {
                    return "离线";
                } else if (data == 3) {
                    return "停电";
                } else if (data == 4) {
                    return "故障";
                }
            }
        }, {
            field: 'fBackTime',
            title: '回传时间',
            width: "15%",
    		align: 'center',
            formatter: function (time) {
                return time ? new Date(time).format("yyyy-MM-dd HH:mm:ss") : "";
            }
        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .edit-btn': function (e, val, row) {
                    dataShow1(row, "#xiangqing_camera_modal");
                    $('#xiangqing_camera_modal').modal('show');
                },
            },
            formatter: function () {
                return '<button class="btn btn-info btn-sm edit-btn">详情</button> '
            }
        }]];

    $(function () {
        $('#tab_terminalParam').bootstrapTable({
            url: "${ctx}/monitor/terminalStatus/getDeviceList?state=1",
            columns: columns,
            method: 'get',
            // contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            search: true, //是否显示表格搜索
            classes: 'table-no-bordered',
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）  */
            showRefresh: true, // 是否显示刷新按钮 */
            clickToSelect: true,
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    Number: params.pageNumber,//从数据库第几条记录开始
                    Size: params.pageSize,//找多少条
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
            },
        });
    });

    function dataShow1(checked, modal) {
        for (var e in checked) {
            $(modal + " span[name='" + e + "']").text(checked[e] ? checked[e] : "");
        }
        var fDeviceState = '';
        if (checked.fDeviceState == 0) {
            fDeviceState = "正在广播";
        } else if (checked.fDeviceState == 1) {
            fDeviceState = "在线";
        } else if (checked.fDeviceState == 2) {
            fDeviceState = "离线";
        } else if (checked.fDeviceState == 3) {
            fDeviceState = "停电";
        } else if (checked.fDeviceState == 4) {
            fDeviceState = "故障";
        }
        $(modal + " span[name='fDeviceState']").text(fDeviceState);
        $(modal + " span[name='fBackTime']").text(checked.fBackTime ? new Date(checked.fBackTime).format("yyyy-MM-dd HH:mm:ss") : "");
    }

    //模态框拖动
    $(".modal-dialog").draggable();
    $('body').on('hidden.bs.modal', '.modal', function () {
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"})
    });
</script>
</body>
</html>

