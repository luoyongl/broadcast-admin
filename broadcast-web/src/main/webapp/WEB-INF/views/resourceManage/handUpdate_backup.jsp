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
    <%@include file="../common/css.jsp" %>
    <style>
        table {
            table-layout: fixed;
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .modal-dialog {
            width: 70%;
        }

        .device_configlist {
            height: 300px;
            overflow-y: scroll;
        }

        .device_configlist li {
            display: block;
            position: relative;
            padding-left: 10%;
            height: 25px;
            line-height: 25px;
            cursor: pointer;
        }

        .selected_config {
            color: orange;
        }

        .selected_config span {
            display: block !important;
        }

        .device_configlist::-webkit-scrollbar {
            width: 4px;
            height: 4px;
        }

        .device_configlist::-webkit-scrollbar-thumb {
            border-radius: 5px;
            -webkit-box-shadow: inset 0 0 5px orange;
            background: rgba(0, 0, 0, 0.2);
        }

        .device_configlist::-webkit-scrollbar-track {
            -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
            border-radius: 0;
            background: rgba(0, 0, 0, 0.1);
        }

        form::-webkit-scrollbar {
            width: 4px;
            height: 4px;
        }

        form::-webkit-scrollbar-thumb {
            border-radius: 5px;
            -webkit-box-shadow: inset 0 0 5px orange;
            background: rgba(0, 0, 0, 0.2);
        }

        form {
            overflow-y: scroll;
        }

        form::-webkit-scrollbar-track {
            -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
            border-radius: 0;
            background: rgba(0, 0, 0, 0.1);
        }

        .form-group {
            display: none !important;
            border-bottom: 1px solid #FFFFFF !important;
            padding: 15px 0 !important;
            margin: 10px 0;
            /*border-radius: 10px;*/
        }

        .show_form_group {
            display: block !important;
        }

        .form-group input {
            width: 50% !important;
        }

        .form-group select {
            width: 50% !important;
        }

        .form-group select option {
            height: 20px;
        }

        .cmdinput {
            display: none !important;
        }

        .modal-dialog {
            width: 75%;
        }

        .item {
            margin: 10px 0;
        }

        .fRebackType,.dtmb {
            display: none;
        }
        .show{
            display: block;
        }
        .none{
            display: none;
        }
    </style>
</head>
<body>
<h4>
    <b>当前位置:资源管理>>设备管理>>设备参数配置</b>
</h4>
<div class="content">
    <div class="show_table">
        <table data-height="450" id="handleDevice" class="table"></table>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="devicehandle_modal" tabindex="-1"
     role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title">配置</h4>
            </div>
            <div class="modal-body col-sm-12">
                <div class="col-sm-4" style="float: left">
                    <ul style="padding: 2% 0 0 2%;">请选择配置参数</ul>
                    <ul class="device_configlist">
                        <li>区域码<span></span></li>
                        <li>工作模式<span></span></li>
                        <li class="selected_config" style="pointer-events: none">锁定频率<span></span></li>
                        <li>回传方式和回传地址<span></span></li>
                        <li>音量<span></span></li>
                        <li>回传周期<span></span></li>
                        <li>RDS传输方式<span></span></li>
                        <li>终端巡检设置<span></span></li>
                        <li>终端控制PID设置<span></span></li>
                        <li>录音文件提取<span></span></li>
                        <li>音频实时回传<span></span></li>
                    </ul>
                </div>
                <div style="float: left" class="show_form col-sm-8">
                    <form style="height: 350px" id="deviceConfig" class="col-sm-12 form-inline">
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">物理地址</label>
                                <input type="text" name="fPhysicalAddress" class="form-control col-sm-8">
                            </div>
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">终端逻辑编码地址</label>
                                <input type="text" name="fLogicDdress" class="form-control col-sm-8">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">工作模式设置</label>
                                <select name="fWorkmode" class="form-control col-sm-8">
                                    <option disabled selected>请选择</option>
                                    <option value="1">主机全断电</option>
                                    <option value="2">待机</option>
                                    <option value="3">应急唤醒</option>
                                </select>
                            </div>

                        </div>
                        <div class="form-group col-sm-12 show_form_group">
                            <div class="col-sm-12 item">
                                <div class="col-sm-4">
                                    <label class="col-sm-12">DTMB和DVBC</label>
                                </div>
                                <div class="col-sm-8">
                                    <input type="checkbox" checked class="dtmbandvbc" style="width:50px!important"
                                           value="1" name="fDtmb">DTMB
                                    <input type="checkbox" checked class="dtmbandvbc" style="width:50px!important"
                                           value="1" name="fDvbc">DVBC
                                </div>
                            </div>

                            <div class="col-sm-12">
                                <div class="col-sm-12 dtmb show_form_group">
                                    <label class="col-sm-12" style="margin-top:15px">DTMB设置：</label>
                                    <input style="display: none;" name="fDtmb">
                                    <div class="col-sm-12 item">
                                        <label class="col-sm-4">频率(khz)</label>
                                        <input type="text" name="fDtmbFreq" class="form-control col-sm-8">
                                    </div>
                                    <div class="col-sm-12 item">
                                        <label class="col-sm-4">符号率</label>
                                        <input type="text" name="fDtmbSymbolrate" class="form-control col-sm-8">
                                    </div>
                                    <div class="col-sm-12 item">
                                        <label class="col-sm-4">调制方式</label>
                                        <select class="form-control" name="fDtmbQam">
                                            <option selected="selected"  value="0">QAM16</option>
                                            <option value="1">QAM32</option>
                                            <option value="2">QAM64</option>
                                            <option value="3">QAM128</option>
                                            <option value="4">QAM256</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-12 dtmb show_form_group">
                                    <label class="col-sm-12" style="margin-top:15px">DVBC设置：</label>
                                    <input style="display: none;" name="fDvbc">
                                    <div class="col-sm-12 item">
                                        <label class="col-sm-4">频率(khz)</label>
                                        <input type="text" name="fDvbcFreq" class="form-control col-sm-8">
                                    </div>
                                    <div class="col-sm-12 item">
                                        <label class="col-sm-4">符号率</label>
                                        <input type="text" name="fDvbcSymbolrate" class="form-control col-sm-8">
                                    </div>
                                    <div class="col-sm-12 item">
                                        <label class="col-sm-4">调制方式</label>
                                        <select class="form-control" name="fDvbcQam">
                                            <option selected="selected"  value="0">QAM16</option>
                                            <option value="1">QAM32</option>
                                            <option value="2">QAM64</option>
                                            <option value="3">QAM128</option>
                                            <option value="4">QAM256</option>
                                        </select>
                                        </select>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">回传方式</label>
                                <select name="fRebackType" class="form-control col-sm-8">
                                    <option disabled selected>请选择</option>
                                    <option value="1">方式1对应内容</option>
                                    <option value="2">方式2对应内容</option>
                                    <option value="3">方式3对应内容</option>
                                </select>
                            </div>
                            <div class="fRebackType">
                                <div class="col-sm-12 item">
                                    <label class="col-sm-4">回传电话号码</label>
                                    <input type="text" name="fRebackTelNumber" class="form-control col-sm-8">
                                </div>
                            </div>
                            <div class="col-sm-12 item fRebackType">
                                <div>
                                    <label class="col-sm-2">IP地址1</label>
                                    <div class="col-sm-5">
                                        <input type="text" name="fRebackIpAddress1" style="width: 80%!important" class="form-control">
                                    </div>
                                    <label class="col-sm-2">IP端口1</label>
                                    <div class="col-sm-2">
                                        <input type="text" name="fRebackIpPort1" style="width: 80%!important"
                                               class="form-control col-sm-3">
                                    </div>
                                </div>
                                <div class="col-sm-12 item ">
                                    <label class="col-sm-2">IP地址2</label>
                                    <div class="col-sm-5">
                                        <input type="text" name="fRebackIpAddress2" style="width: 80%!important" class="form-control">
                                    </div>
                                    <label class="col-sm-2">IP端口2</label>
                                    <div class="col-sm-2">
                                        <input type="text" name="fRebackIpPort2" style="width: 80%!important"
                                               class="form-control col-sm-3">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12 item fRebackType">
                                <label class="col-sm-2">域名</label>
                                <div class="col-sm-5">
                                    <input type="text" name="fRebackDomainName" style="width: 80%!important" class="form-control">
                                </div>
                                <label class="col-sm-2">端口号</label>
                                <div class="col-sm-2">
                                    <input type="text" name="fRebackDomainNameport" style="width: 80%!important"
                                           class="form-control col-sm-3">
                                </div>
                            </div>

                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">音量</label>
                                <input type="text" name="fColumn" class="form-control col-sm-8">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">回传周期(秒)</label>
                                <input type="text" name="fRebackPeriod" class="form-control col-sm-8">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">终端设备类型</label>
                                <%--<input type="text" name="fDataBackhaulipAddress1" class="form-control col-sm-8">--%>
                                <select name="fTerminalRdsSet" class="form-control col-sm-8">--%>
                                    <option disabled selected>请选择</option>
                                    <option value="1">应急广播适配器</option>
                                    <option value="2">收扩机</option>
                                    <option value="3">音柱</option>
                                    <option value="4">全部</option>
                                </select>
                            </div>
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">RDS编码指令数据</label>
                                <input type="text" name="fTerminalRdsData" class="form-control col-sm-8">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">终端响应回传方式</label>
                                <div class="col-sm-8">
                                    <input type="radio" name="fTerminalRebackType" value="1" style="width: 20px!important;">收到巡检指令后立刻回传
                                    <input type="radio" name="fTerminalRebackType" value="2" style="width: 20px!important;">自动周期回传
                                </div>
                            </div>
                            <div class="col-sm-12 item fTerminalRebackType none">
                                <label class="col-sm-4">回传周期</label>
                                <input type="text" name="fTerminalRebackPeriod" class="form-control col-sm-8">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">终端控制PID设置</label>
                                <div class="col-sm-8">
                                    <input type="radio" value="21" style="width: 20px!important;" name="fTerminalPidSet">0x21
                                    <input type="radio" value="22" style="width: 20px!important;" name="fTerminalPidSet">0x22
                                </div>
                            </div>

                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">录音文件名称</label>
                                <input type="text" name="fRecordFileName" class="form-control col-sm-8">
                            </div>
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">开始传输包序号</label>
                                <input type="text" name="fStartPackageNum" class="form-control col-sm-8">
                            </div>
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">音频回传模式</label>
                                <select name="fAudioRebackMode" class="form-control col-sm-8">--%>
                                    <option disabled selected>请选择</option>
                                    <option value="1">UDP</option>
                                    <option value="2">TCP</option>
                                </select>
                            </div>
                            <div class="col-sm-12 item">

                                <label class="col-sm-2">音频回传ip</label>
                                <div class="col-sm-5">
                                    <input type="text" name="fAudioRebackServerip"  style="width: 80%!important" class="form-control">
                                </div>
                                <label class="col-sm-2">音频回传端口</label>
                                <div class="col-sm-2">
                                    <input type="text" name="fAudioRebackPort" style="width: 80%!important"
                                           class="form-control col-sm-3">
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-12 item">
                                <label class="col-sm-4">开关</label>
                                <input type="radio"  style="width: 50px!important;" name="fKaiguan" value="1">ON
                                <input type="radio" style="width: 50px!important;" name="fKaiguan" value="2">OFF
                            </div>

                            <div class="col-sm-12 item">
                                <label class="col-sm-4">音频回传模式</label>
                                <select name="fAudioRebackMode2" class="form-control col-sm-8">--%>
                                    <option disabled selected>请选择</option>
                                    <option value="1">UDP</option>
                                    <option value="2">TCP</option>
                                </select>
                            </div>
                            <div class="col-sm-12 item">
                                <label class="col-sm-2">音频回传ip</label>
                                <div class="col-sm-5">
                                    <input type="text" name="fAudioRebackServerip2" style="width: 80%!important" class="form-control">
                                </div>
                                <label class="col-sm-2">音频回传端口</label>
                                <div class="col-sm-2">
                                    <input type="text" name="fAudioRebackPort2" style="width: 80%!important"
                                           class="form-control col-sm-3">
                                </div>
                            </div>
                        </div>
                        <%--以下为命令是否选中默认为不选中0  选中时为1--%>
                        <%--1.区域码指令--%>
                        <input class="cmdinput" type="text" value="0" name="fAddressSettingCmd">
                        <%--2.工作模式设置--%>
                        <input class="cmdinput" type="text" value="0" name="fWorkmodeSettingCmd">
                        <%--3.锁定频率设置--%>
                        <input class="cmdinput" type="text" value="1" name="fFreqSettingCmd">
                        <%--4.设置回传方式及回传地址--%>
                        <input class="cmdinput" type="text" value="0" name="fRebacktypeAndAddressCmd">
                        <%--5.音量设置--%>
                        <input class="cmdinput" type="text" value="0" name="fColumnSettingCmd">
                        <%--6.设置回传周期--%>
                        <input class="cmdinput" type="text" value="0" name="fRebackPeriodSettingCmd">
                        <%--7.终端采用RDS传输方式进行设置--%>
                        <input class="cmdinput" type="text" value="0" name="fRdsSettingCmd">
                        <%--8.终端巡检设置--%>
                        <input class="cmdinput" type="text" value="0" name="fTerminalInspectSettingCmd">
                        <%--9.终端控制PID设置--%>
                        <input class="cmdinput" type="text" value="0" name="fTerminalPidSettingCmd">
                        <%--10.录音文件提取--%>
                        <input class="cmdinput" type="text" value="0" name="fRecordExtractSettingCmd">
                        <%--11.音频实时回传--%>
                        <input class="cmdinput" type="text" value="0" name="fAudioRebackSettingCmd">


                    </form>
                </div>
            </div>
            <div class="null"></div>
            <div class="modal-footer">
                <button type="button" class="devicehandle btn btn-info">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<%@include file="../common/js.jsp" %>
<script>
    $(".device_configlist li").click(function () {
        $(this).toggleClass("selected_config");
        $("form .form-group").eq($(this).index()).toggleClass("show_form_group");
        var cmdvalue = $("form .cmdinput").eq($(this).index()).attr("value");
        //切换是否选中改指令 0不选中  1选中
        $("form .cmdinput").eq($(this).index()).attr("value", cmdvalue == 0 ? 1 : 0);
    });
    /**
     * 以下为dtmb联动
     */
    $(".item .dtmbandvbc").change(function () {
        var dtmbvalue = $("form .dtmbandvbc").eq($(this).index()).attr("value");
        //切换是否选中改指令 0不选中  1选中
        $("form .dtmbandvbc").eq($(this).index()).attr("value", dtmbvalue == 0 ? 1 : 0);
        $(".dtmb").eq($(this).index()).toggleClass("show_form_group");
        var $choosenum=$(".dtmbandvbc:checked").size();
        if ($choosenum==0){
            layer.msg("请至少选择一种调制方式",{icon:2});
            $(this).prop(   "checked",true);
            $("form .dtmbandvbc").eq($(this).index()).attr("value", 1);
            $(".dtmb").eq($(this).index()).toggleClass("show_form_group");
        }
    });

    //以下为回传方式联动
    $("select[name='fRebackType']").change(function () {
        $(".fRebackType").eq($(this).find("option:selected").attr("value")-1).addClass("show").siblings().removeClass("show");
    });

    //巡检联动
    $("input[name='fTerminalRebackType']").change(function () {
        if ($(this).index()==1){
            $(".fTerminalRebackType").toggleClass("none");
        }else {
            $(".fTerminalRebackType").addClass("none");
        }
    })
    $("select").change(function () {
        let text = $(this).find("option:selected").attr("value");
        $(this).attr("value", text);
    });
    $(function () {
        $('#handleDevice').bootstrapTable({
            url: "${ctx}/monitor/terminalSound/getDeviceList",
            method: 'get',
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


    var columns = [
        [{
            field: '',
            title: '编号',
            align: 'center',
            width: 100,
            formatter: function (value, row, index) {
                var pageSize = $('#handleDevice').bootstrapTable('getOptions').pageSize;
                var pageNumber = $('#handleDevice').bootstrapTable('getOptions').pageNumber;
                return pageSize * (pageNumber - 1) + index + 1;
            }
        }, {
            field: 'fDeviceName',
            title: '设备名称',
            align: 'left',
            width: "10%",
        }, {
            field: 'fDeviceResourceCode',
            title: '资源编码',
            align: 'center',
            width: "15%"
        }, {
            field: 'fRealDeviceModel',
            title: '设备类型',
            sortable: true,
            align: 'left',
            width: "10%"
        }, {
            field: 'fRealArea',
            title: '所属区域',
            sortable: true,
            align: 'left',
            width: "10%"
        }, {
            field: 'fRealFacture',
            title: '厂家信息',
            align: 'left',
            width: "10%"
        }, {
            field: 'fDeviceState',
            title: '设备状态',
            align: 'left',
            sortable: true,
            width: "8%",
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
            },
        }, {
            field: 'fUpdateTime',
            title: '操作日期',
            align: 'left',
            sortable: true,
            width: "15%",
            formatter: function (data, row, index) {
                return data ? new Date(data).format('yyyy-MM-dd HH:mm:ss') : "";
            },
        }, {
            title: '操作',
            align: 'center',
            width: "10%",
            events: {
                'click .detail-btn': function (e, val, row) {
                    //alert(row.fDeviceResourceCode);
                    if (row.fDeviceResourceCode==null) {
                        layer.msg("所选设备资源编码为空，请重新检查",{
                            icon:2
                        })
                    }else {
                        $("#devicehandle_modal").modal();
                        let fDeviceResourceCode=row.fDeviceResourceCode;
                        //alert(fDeviceResourceCode); 
                        $(".devicehandle").click(function () {
                            layer.confirm("是否确定保存该配置?", {
                                icon: 3,
                                title: ['操作提示'],
                                btn: ['确定', '取消'] //按钮
                            }, function () {
                                $.ajax({
                                    url: '${ctx}/resourceManage/handUpdate/saveConfig',
                                    type: 'post',
                                    data: $("#deviceConfig").serialize() + "&fDeviceId=" + row.fId+"&fDeviceResourceCode="+fDeviceResourceCode,
                                    success: function (data) {
                                        layer.msg(data.msg, {
                                            icon: 1
                                        });
                                        $("#devicehandle_modal").modal('hide');
                                    }
                                });
                            }, function () {
                            })
                        })
                    }
                }
            }, formatter: function () {
                return '<button class="btn btn-info btn-sm detail-btn">配置</button>';
            }
        }]];


    $(".modal-dialog").draggable();
    $('body').on('hidden.bs.modal', '.modal', function () {
        $('.modal input').val("");
        $(".device_configlist").find("li").eq(2).siblings().removeClass("selected_config");
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"})
        $(".form-group").eq(2).siblings().removeClass("show_form_group");
        $("form .cmdinput").eq(2).siblings().attr("value", 0);
    });
</script>
</body>
</html>