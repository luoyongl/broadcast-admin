<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>终端播放状态</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .content_table {
            padding: 1% 1.5%;
            width: 100%;

        }
        table {
            table-layout: fixed;
        }
        #tab_terminalStatus_realStatus tbody tr td {
            width: 150px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        #tab_terminalStatus_playRecord tbody tr td {
            width: 150px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
		/* 移动端样式 */
    	@media screen and (max-width: 480px) {
			.fixed-table-container {
				height: auto!important;
				padding-bottom: 10px!important;
			}
    		.fixed-table-container .fixed-table-body {
				height: auto!important;
			}
    	}
    </style>
</head>
<body>
<h4><b>当前位置:监测监控>>终端播放状态</b></h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li class="selected_tab"><a>实时状态</a></li>
        <li><a>播放记录</a></li>
        <span class="driverspan"></span>
    </ul>
</div>
<div class="content_table">
    <div class="tab_modal show ">
        <table data-height="550" id="tab_terminalStatus_realStatus" class="table table-hover"></table>
    </div>
    <div class="tab_modal ">
        <table data-height="550" id="tab_terminalStatus_playRecord" class="table table-hover"></table>
    </div>
</div>


<!-- 详情模态框（Modal） -->
<div class="modal fade" id="details_terminal_status_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="roleForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">详情</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">设备名称:</label>
                        <div class="col-sm-8">
                            <span id="fRealControlDevice"></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">资源编码:</label>
                        <div class="col-sm-8">
                            <span id="fCode"></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">广播来源:</label>
                        <div class="col-sm-8">
                            <span id="fRealMessageSource"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">广播类型:</label>
                        <div class="col-sm-8">
                            <span id="fRealBroadcastType"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">消息类型:</label>
                        <div class="col-sm-8">
                            <span id="fRealMessageType"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">消息级别:</label>
                        <div class="col-sm-8">
                            <span id="fRealMessageLevel"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2 control-label">音量:</label>
                        <div class="col-sm-10">
                            <span id="fVolumeControl"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2 control-label">播放音频:</label>
                        <div class="col-sm-10">
                            <span id="fProgramPass"></span>
                        </div>
                    </div>
                </div>
                <div class="modal-footer ">
                    <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>


<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    var terminalStatusRealStatus;
    var terminalStatusRealRecord;
    var fStartTime;
    var fEndTime;
   /* jeDate(".data-YYYY-MM-DD_update2", {
        format: "YYYY-MM-DD",
        multiPane: false,
        isToday: true,                               //是否显示今天或本月
        range: " 至 ",
        donefun: function (obj) {
            var fStartAndEndTime = $(".jeinpbox" + " " + "input[name='fStartAndEndDate']").val();
            if (fStartAndEndTime != null || fStartAndEndTime != "") {
                var attr = fStartAndEndTime.split("至");
                fStartTime = $.trim(attr[0]).toString();
                fEndTime = $.trim(attr[1]).toString();
                $('input[name="fStartTime"]').val(fStartTime);
                $('input[name="fEndTime"]').val(fEndTime);
                $("#tab_terminalStatus_playRecord").bootstrapTable('refresh');
            }

        }
    });*/


    var columns = [
        [{
            field:'',
            title:' ',
            width:20,
            formatter:function () {
                return '';
            }
        }, {
            field: 'fRealControlDevice',
            title: '设备名称',
            align: 'center',
            width: "10%",
        }, {
            field: 'fCode',
            title: '资源编码',
            width: "15%",
            align: 'center',

        }, {
            field: 'fId',
            title: '广播ID',
            align: 'center',
            width:  "5%",

        }, {
            field: 'fRealMessageSource',
            title: '广播来源',
            align: 'center',
            width:  "8%",
        }, {
            field: 'fBroadcastType',
            title: '广播类型',
            align: 'center',
            width:  "8%",
            formatter: function (value, row, index) {  if (row.fBroadcastType == 1) {
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
            width:  "8%",
        }, {
            field: 'fRealMessageLevel',
            title: '消息级别',
            align: 'center',
            width:  "10%",
        }, {
            field: 'fVolumeControl',
            title: '音量',
            align: 'center',
            width:  "5%",
        }, {
            field: 'fProgramPass',
            title: '播放音频',
            width:  "20%",
            align: 'center',

        }, {
            field: 'ee',
            title: '操作',
            align: 'center',
            formatter: function () {
                return '<button id="terminalStatusRealRecordDetail" class="btn btn-info btn-sm edit-base-btn">详情</button>';
            },
            events: {
                'click #terminalStatusRealRecordDetail': function (e, val, row) {
                    $('#fRealMessageType').text(row.fRealMessageType?row.fRealMessageType:"");
                    $('#fRealMessageSource').text(row.fRealMessageSource ? row.fRealMessageSource : "");
                    $('#fRealControlDevice').text(row.fRealControlDevice ? row.fRealControlDevice : "");
                    $('#fCode').text(row.fCode ? row.fCode : "");
                    $('#fVolumeControl').text(row.fVolumeControl ? row.fVolumeControl : "");
                    $('#fRealMessageLevel').text(row.fRealMessageLevel ? row.fRealMessageLevel : "");
                    var frealProgramPass = row.fProgramPass;                    
					if(frealProgramPass != null){
						while(frealProgramPass.indexOf("<br/>")!=-1){
							frealProgramPass = frealProgramPass.replace("<br/>","");
						}
						var programPassOfLineFeed = "";
						while(frealProgramPass.length>20){
							
							var tempProgramPass = frealProgramPass.substring(0,19);
							programPassOfLineFeed += tempProgramPass;
							frealProgramPass = frealProgramPass.replace(tempProgramPass, "");
						}
						programPassOfLineFeed +=frealProgramPass;
                        $('#fProgramPass').text(programPassOfLineFeed);
					}
                    //$('#fProgramPass').text(row.fProgramPass);
                    //$('#fProgramPass').text(row.fAudioUrl ? row.fAudioUrl : "");
                    var fRealBroadcastType="";
                    if (row.fBroadcastType == 1) {
                        fRealBroadcastType= "系统演练";
                    } else if (row.fBroadcastType == 2) {
                        fRealBroadcastType= "模拟演练";
                    } else if (row.fBroadcastType == 3) {
                        fRealBroadcastType= "实际演练";
                    } else if (row.fBroadcastType == 4) {
                        fRealBroadcastType= "应急广播";
                    } else if (row.fBroadcastType == 5) {
                        fRealBroadcastType= "日常广播";
                    } else if (row.fBroadcastType == 6) {
                        fRealBroadcastType= "升级广播";
                    } else if (row.fBroadcastType == 7) {
                        fRealBroadcastType= "广播预案-应急广播";
                    } else if (row.fBroadcastType == 8) {
                        fRealBroadcastType= "广播预案-日常广播";
                    } else if (row.fBroadcastType == 9) {
                        fRealBroadcastType= "广播预案-实际演练";
                    } else if (row.fBroadcastType == 10) {
                        fRealBroadcastType= "广播预案-系统演练";
                    } else if (row.fBroadcastType == 11) {
                        fRealBroadcastType= "广播预案-模拟演练";
                    } else if (row.fBroadcastType == 12) {
                        fRealBroadcastType= "定时广播";
                    }
                    $('#fRealBroadcastType').text(fRealBroadcastType);
                    $('#details_terminal_status_modal').modal('show');
                }
            }


        }]
    ];

    $('#tab_terminalStatus_playRecord').bootstrapTable({
        url: "${ctx}/monitor/terminalStatus/selectTerminalStatusList?fBroadcastType=2&fDeviceState=100", // 请求后台的URL（*）
        method: 'post',
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        search: true, //是否显示表格搜索
        columns: columns,
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
                pageNumber: params.pageNumber,//从数据库第几条记录开始
                pageSize: params.pageSize,//找多少条
                searchText: params.searchText, //查询内容
                sortOrder: params.sortOrder, //排序方式
                sortName: params.sortName, //排序名称
                fStartTime: $('input[name="fStartTime"]').val(),
                fEndTime: $('input[name="fEndTime"]').val()
            };
        },
        responseHandler: function (result) {
            if (result.status === 200) {
                //layer.close(ii);
            }
            terminalStatusRealRecord = result.data.list;
            return {
                total: result.data.total,
                rows: result.data.list
            };
        }
    });


    //=================================================================================================


    $(function () {
        $(".modal-dialog").draggable();
        $('#tab_terminalStatus_realStatus').bootstrapTable({
            method: 'post',
            url: "${ctx}/monitor/terminalStatus/selectTerminalStatusList?fBroadcastType=1&fDeviceState=0", // 请求后台的URL（*）
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            columns: columns,
            classes: 'table-no-bordered',
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）  *!/
            clickToSelect: true,
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
                //terminalStatusRealStatus = result.data.list;
                return {
                    total: result.data.total,
                    rows: result.data.list
                }
            }
        })
    })
</script>