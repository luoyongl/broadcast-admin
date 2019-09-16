<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>发射机设备</title>
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
<h4><b>当前位置:监测监控>>发射机设备</b></h4>
<!-- <div class="tab_driver">
    <ul class="nav nav-tabs">
        <li class="selected_tab"><a>实时状态</a></li>
        <li><a>播放记录</a></li>
        <span class="driverspan"></span>
    </ul>
</div> -->
<div class="content_table">
    <div class="tab_modal show ">
        <table data-height="550" id="tab_transmitterStatus" class="table table-hover"></table>
    </div>
</div>

<div class="modal fade" id="infoModal_transmitter" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog detail">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">详情</h4>
                </div>
                <div class="modal-body">
                    <div class="content col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机编号:</label>
                            <div class="col-sm-7">
                                <span id="transmitterId2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机名称:</label>
                            <div class="col-sm-7">
                                <span id="transmitterName2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">绑定适配器:</label>
                            <div class="col-sm-7">
                                <span id="adapterName2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">所属区域:</label>
                            <div class="col-sm-7">
                                <span id="region2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">安装地址:</label>
                            <div class="col-sm-7">
                                <span id="installArea2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">物理编码:</label>
                            <div class="col-sm-7">
                                <span id="physicalCode2"></span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">资源编码:</label>
                            <div class="col-sm-7">
                                <span id="resourceCode2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机状态:</label>
                            <div class="col-sm-7">
                                <span id="transmitterState2"></span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机输出频率:</label>
                            <div class="col-sm-7">
                                <span id="transmitterOutputFrequency2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">输出功率:</label>
                            <div class="col-sm-7">
                                <span id="outputPower2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">设备温度:</label>
                            <div class="col-sm-7">
                                <span id="equipmentTemperature2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机工作电压:</label>
                            <div class="col-sm-7">
                                <span id="transmitterOperatingVoltage2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机工作电流:</label>
                            <div class="col-sm-7">
                                <span id="transmitterOperatingCurrent2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机反射功率:</label>
                            <div class="col-sm-7">
                                <span id="transmitterReflectionPower2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">左声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="leftChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">右声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="rightChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">和声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="harmonicChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">差声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="differentialChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">RF锁定状态:</label>
                            <div class="col-sm-7">
                                <span id="rfLockInState2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">RF锁定状态:</label>
                            <div class="col-sm-7">
                                <span id="pllLockInState2"></span>
                            </div>
                        </div>                      
                    </div>
                </div>
                <div class="modal-footer ">
                    <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                </div>
            </form>
        </div>
    </div>
</div>


<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    var terminalStatusRealStatus;
    var terminalStatusRealRecord;
    var fStartTime;
    var fEndTime;
   
    var columns_transmitter = [
        [{
            checkbox: true,
        }, {
            field: 'transmitterName',
            title: '发射机名称',
            align: 'center',
            width: '7%',
        }, {
            field: 'resourceCode',
            title: '资源编码',
            align: 'center',
            width: '10%',
        },{
            field: 'adapterName',
            title: '绑定适配器',
            sortable: false,
            align: 'center',
            width: '10%'
        }, {
            field: 'region',
            title: '所属区域',
            sortable: false,
            align: 'center',
            width: '13%'
        }, {
            field: 'outputPower',
            title: '输出功率',
            sortable: false,
            align: 'center',
            width: '7%',

        }, {
            field: 'transmitterOperatingVoltage',
            title: '工作电压',
            sortable: false,
            align: 'center',
            width: '7%'
        }, {
            field: 'transmitterReflectionPower',
            title: '反射功率',
            align: 'center',
            sortable: false,
            width: '7%',
        },{
            field: 'transmitterState',
            title: '发射机状态',
            align: 'center',
            sortable: false,
            width: '7%',
        },{
            field: 'backTime',
            title: '回传时间',
            align: 'center',
            sortable: false,
            width: '13%',
        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .detail-btn': function (e, val, row) {
                	
                	$('#transmitterId2').text(row.transmitterId);
                	$('#transmitterName2').text(row.transmitterName);
                	$('#adapterName2').text(row.adapterName);
                	$('#region2').text(row.region);
                	$('#installArea2').text(row.installArea);
                	$('#physicalCode2').text(row.physicalCode);
                	$('#resourceCode2').text(row.resourceCode);
                	$('#transmitterState2').text(row.transmitterState);
                	$('#transmitterOutputFrequency2').text(row.transmitterOutputFrequency);
                	$('#outputPower2').text(row.outputPower);
                	$('#equipmentTemperature2').text(row.equipmentTemperature);
                	$('#transmitterOperatingVoltage2').text(row.transmitterOperatingVoltage);
                	$('#transmitterOperatingCurrent2').text(row.transmitterOperatingCurrent);
                	$('#transmitterReflectionPower2').text(row.transmitterReflectionPower);
                	$('#leftChannelModulation2').text(row.leftChannelModulation);
                	$('#rightChannelModulation2').text(row.rightChannelModulation);
                	$('#harmonicChannelModulation2').text(row.harmonicChannelModulation);
                	$('#differentialChannelModulation2').text(row.differentialChannelModulation);
                	$('#rfLockInState2').text(row.rfLockInState);
                	$('#pllLockInState2').text(row.pllLockInState);
                	$('#backTime2').text(row.backTime);
                    /* $.each(row, function (key, value) {
                        $("#" + key).text(value ? value : "");
                    })
                    $('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                    $('#fUpdateTime').text(row.fUpdateTime ? new Date(row.fUpdateTime).format('yyyy-MM-dd HH:mm:ss') : "");
                    $('#fEnableState').text((row.fEnableState == true) ? "启用" : "未启用");
                    $('#div_url').attr("style", "display:none;");
                    $('#div_mainter').attr("style", "display:none;"); */
                    $('#infoModal_transmitter').modal();
                }
            }, formatter: function () {
                return '<button class="btn btn-info btn-sm detail-btn">详情</button>';
            }
        }]];

    $('#tab_transmitterStatus').bootstrapTable({
        url: "${ctx}/monitor/transmitterEquipment/querytransmitterEquipment", // 请求后台的URL（*）
        method: 'post',
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        search: true, //是否显示表格搜索
        columns: columns_transmitter,
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
</script>