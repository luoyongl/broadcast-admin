<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
    request.setAttribute("map", DictionaryConfig.getAllMap());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>广播预案</title>
    <%@include file="../common/css.jsp" %>
    <style>
        form {
            height:99%;
        }

        .content {
            height: auto;
        }

        .modal-dialog.add {
            height: auto;

        }

        .modal-body {
            padding: 0;
        }

        table {
            table-layout: fixed;
        }

        .btn-group.bootstrap-select.show-tick.form-control {
            width: 58%;
            background: none;
        }

        .btn.dropdown-toggle.btn-default {
            background: none;
            color: #ffffff;
        }

    </style>
</head>
<body>
<h4>
    <b>当前位置:制作播发>>广播预案</b>
</h4>
<div class="content_table">
    <div class="handle pull-right">
        <button class="add_advance_modal btn btn-info" id="add" data-toggle="modal" data-target="advance_modal">新增</button>
        <button class="btn btn-info" id="edit">修改</button>
        <button class="btn btn-danger" id="delete">取消</button>
    </div>
    <table data-height="450" id="tab_advance" class="table table-hover"></table>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="advance_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog add">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 id="title" class="modal-title">新增</h4>
            </div>

            <div class="modal-body col-sm-12">
                <div class="content col-sm-12">
                    <form id="form_advance" class="form_broadcast form-inline"
                          data-validator-option="{theme:'simple_right',timely:1,focusCleanup:true}">
                        <div class="content_left col-sm-8">
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">预案名称</label>
                                <input type="hidden" id="fId" name="fId">
                                <input type="text" maxlength="6" class="form-control" id="advanceName2"
                                       name="fBroadcastName" onKeyUp="confirmName($(this))" style="width: 58%;">
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">广播类型</label>
                                <div class="col-sm-7">
                                    <select id="broadcastType2" class="form-control" name="fBroadcastType">
                                        <option value="10">应急广播</option>
                                        <option value="11">日常广播</option>
                                        <option value="9" >实际演练</option>
                                        <option value="7" >系统演练</option>
                                        <option value="8" >模拟演练</option>
                                    </select>
                                    <!-- <input id="broadcastType2" type="text" class="form-control" name="fBroadcastType"> -->
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">节目通道</label>
                                <div class="col-sm-7">
                                    <select class="form-control" name="fProgramPass">
                                        <c:forEach items="${channelList}" var="channel">
                                            <option type="base" number="${channel.fThirdCode}" value="${channel.fId}">${channel.fDictionaryContent}</option>
                                        </c:forEach>
                                         <c:forEach items="${programList}" var="program">
											 <option  region="${program.fBroadcastArea}" type="extra" value="${program.fId}">${program.fPassName}
											 </option>
										 </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">控制设备</label>
                                <div class="col-sm-7">
                                    <select id="controlDevice2" class="form-control" name="fControlDevice">
                                        <option selected value="" disabled>请选择</option>
                                        <c:forEach items="${frontDeviceInfoList}" var="frontDeviceInfoList">
                                            <option value="${frontDeviceInfoList.fId}" style="display:none">
                                                    ${frontDeviceInfoList.fDeviceName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">设备通道</label>
                                <div class="col-sm-7">
                                    <select class="form-control" data-validate="required" name="fPassSelect"
                                            id="channelSelect2">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">音量控制</label>
                                <input id="volume2" maxlength="3" disabled="disabled" name="fVolumeControl" type="text" class="form-control"
                                       value="100" style="width: 58%;">
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">消息类型</label>
                                <div class="col-sm-7">
                                    <select class="form-control" data-validate="required" name="fMessageType"
                                            id="messageType2">
                                        <c:forEach items="${messageList}" var="message_type">
                                            <option value="${message_type.fId}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${message_type.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label">消息级别</label>
                                <div class="col-sm-7">
                                    <select class="form-control" data-validate="required" name="fMessageLevel"
                                            id="messageGrade2">
                                        <c:forEach items="${messageGradeList}" var="messageGrade">
                                            <option value="${messageGrade.fId}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${messageGrade.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">有效期限</label>
                                 <input name="EffectiveTime" type="text" style="width: 58%;" class="jeinput form-control">
                            </div>
                            <div class="form-group pass col-sm-12">
                                <label class="col-sm-3">播发去向(可多选)</label>
                                <select name="fBroadcastTo" id="boardcastTo" title="请选择"
                                        class="selectpicker show-tick form-control" multiple data-live-search="false">
                                    <c:forEach items="${broadcastDestinate}" var="broadcastDestinate">
                                        <option value="${broadcastDestinate.fId}">${broadcastDestinate.fDictionaryContent}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div id="TTS" style="display: none;" class="form-group  col-sm-12">
                                <textarea name="tts" id="text_for_video" class="col-sm-12 form-control" rows="2"
                                          cols="20"
                                          style="width:70%;height: 50px; resize: none;"
                                          placeholder="请输入需要转换的文字"></textarea>
                                <button id="btn_tts" type="button" class="btn btn-info" style="height: 50px;">试听
                                </button>
                                <audio id="tts_audio" style="display: none" controls autoplay>
                                    <source id="tts_source" type="audio/mpeg"
                                            src="http://tts.baidu.com/text2audio/text2audio?lan=zh&amp;ie=UTF-8&amp;spd=5&amp;text=">
                                </audio>
                            </div>

                            <div class="form-group col-sm-12" id="localAudio">
                                <label class="col-sm-3">本地音源</label>
                                <div class="control-label col-sm-8">
                                    <input type="file" id="inputAudioFile" name="localAudio" accept="audio/x-mpeg">
                                </div>
                            </div>
                        </div>
                        <div class="content_right">
                            <label>&nbsp;播发区域</label>
                            <div class="right-tree" style="height:380px">
							<ul id="ztree" class="ztree"></ul>
						</div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer ">
                <div class="form-group" style="width: 100%">
                    <button type="button" id="confirm" class="btn btn-info">确定</button>
                    <button type="button" id="cancel" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 详情模态框（Modal） -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="roleForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">详情</h4>
                </div>
                <div class="modal-body">
                    <div class="content col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group col-sm-6 col-md-6 col-lg-6">
                            <label class="col-sm-4 control-label">预案名称:</label>
                            <div class="col-sm-8">
                                <span id="fBroadcastName"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6 col-md-6 col-lg-6">
                            <label class="col-sm-4 control-label">广播类型:</label>
                            <div class="col-sm-8">
                                <span id="fBroadcastType"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">控制设备:</label>
                            <div class="col-sm-8">
                                <span id="fRealControlDevice"></span>
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
                        <div class="form-group col-sm-6">
						<label class="col-sm-4 control-label">消息来源:</label>
						<div class="col-sm-8">
							<span id="fRealMessageSource"></span>
						</div>
					</div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">节目通道:</label>
                            <div class="col-sm-8">
                                <span id="fRealProgramPass"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">设备通道:</label>
                            <div class="col-sm-8">
                                <span id="fRealPassSelect"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">音量控制:</label>
                            <div class="col-sm-8">
                                <span id="fVolumeControl"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">有效期限:</label>
                            <div class="col-sm-8">
                                <span id="feffectiveTime"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">创建者:</label>
                            <div class="col-sm-8">
                                <span id="creator"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">创建时间:</label>
                            <div class="col-sm-8">
                                <span id="fCreateTime"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">修改者:</label>
                            <div class="col-sm-8">
                                <span id="operator"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">修改时间:</label>
                            <div class="col-sm-8">
                                <span id="fUpdtateTime"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">播发去向:</label>
                            <div class="col-sm-8">
                                <span id="fRealBroadcastTo"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-4 control-label">播发区域:</label>
                            <div class="col-sm-8">
                                <span id="fRealArea"></span>
                            </div>
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
    var flag = 0;  //标志新增或修改操作 0是新增 1是修改
    $(function () {
        $(".selectpicker").selectpicker('refresh');
        $(".modal-dialog").draggable();
        //页面加载完成后，执行这段代码----动态创建ztree
        var setting2 = {
            check: {
                enable: true
            }

        };
        //构造节点数据
        var regionData = ${regionList};
        //调用API初始化ztree
        loadRegionTree("ztree", regionData);
    });
    
    $(".add_advance_modal").click(function () {
    	var stateCheck = broadcastServerStateCheck("${ctx}");
    	if(!stateCheck){
    		return;
    	}
        $('#advance_modal').modal('show');
    });

    var columns = [[{
        field: 'a',
        checkbox: true
    }, {
        field: 'fId',
        title: 'ID',
        sortable: true,
        align: 'center',
        width: '5%'

    }, {
        field: 'fBroadcastName',
        title: '预案名称',
        align: 'center',
        width: '10%'

    }, {
        field: 'fBroadcastType',
        title: '广播类型',
        align: 'center',
        sortable: true,
        width: '10%',
        formatter: function (data, row, index) {
            if (data === 11 ||data ===5)
                return "日常广播";
            else if (data === 10 ||data === 4)
                return "应急广播";
            else if (data === 7 || data === 3)
                return "系统演练";
            else if (data === 9 || data === 1)
                return "实际演练";
            else if (data === 8 || data === 2)
                return "模拟演练";
        }
    }, {
        field: 'fRealMessageType',
        title: '消息类型',
        align: 'center',
        sortable: true,
        width: '10%',
    }, {
        field: 'fRealMessageLevel',
        title: '消息级别',
        align: 'center',
        sortable: true,
        width: '10%',
    }, {
        field: 'fRealMessageSource',
        title: '消息来源',
        align: 'center',
        sortable: true,
        width: '13%',

    }, {
        field: 'fRealArea',
        title: '播发区域',
        align: 'center',
        width: '13%',
        formatter: function (data, row, index) {
            var values = data;
            var span = document.createElement('span');
            span.setAttribute('title', values);
            span.innerHTML = data;
            return span.outerHTML;
        },
        cellStyle: {
            css: {
                "overflow": "hidden",
                "text-overflow": "ellipsis",
                "white-space": "nowrap"
            }

        }

    },
        {
            field: 'operator',
            title: '操作者',
            align: 'center',
            width: '8%',
            formatter: function (data, row, index) {
                if (data === null || data == "") {
                    return row.creator;
                } else {
                    return row.operator;
                }

            }
        }, {
            field: 'fState',
            title: '状态',
            align: 'center',
            sortable: true,
            width: '7%',
            formatter: function (data, row, index) {
                if (data == 0) {
                    return '<span class="label label-default">&nbsp;未开播&nbsp;</span>';
                } else if (data == 1) {
                    return '<span class="label label-warning">&nbsp;待审核&nbsp;</span>';
                } else if (data == 2) {
                    return '<span class="label label-success">&nbsp;待播发&nbsp;</span>';
                } else if (data == 3) {
                    return '<span class="label label-info">正在播发</span>';
                } else if (data == 4) {
                    return '<span class="label label-danger">&nbsp;已播发&nbsp;</span>';
                } else if (data == 5) {
                    return '<span class="label label-danger">&nbsp;不通过&nbsp;</span>';
                } else if (data == 6) {
                    return '<span class="label label-danger">&nbsp;已取消&nbsp;</span>';
                }else if (data == 7) {
                    return '<span  class="label label-default">&nbsp;已过期&nbsp;</span>';
                }
            }
        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .detail-btn': function (e, val, row) {
                    $.each(row, function (key, value) {
                        $("#" + key).text(value ? value : "");
                        $('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                        $('#fUpdtateTime').text(row.fUpdtateTime ? new Date(row.fUpdtateTime).format('yyyy-MM-dd HH:mm:ss') : "");

                    });
					$("#feffectiveTime").text(row.fEffectiveTime?new Date(row.fEffectiveTime).format("yyyy-MM-dd HH:mm:ss"):"");
                    if (row.fBroadcastType === 11 || row.fBroadcastType === 5) {
                        $('#fBroadcastType').text("日常广播");
                    } else if (row.fBroadcastType === 10 || row.fBroadcastType === 4) {
                        $('#fBroadcastType').text("应急广播");
                    } else if (row.fBroadcastType === 7 || row.fBroadcastType === 1) {
                        $('#fBroadcastType').text("系统演练");
                    } else if (row.fBroadcastType === 8 || row.fBroadcastType === 2) {
                        $('#fBroadcastType').text("模拟演练");
                    } else if (row.fBroadcastType === 9 || row.fBroadcastType === 3) {
                        $('#fBroadcastType').text("实际演练");
                    }
                    $('#infoModal').modal();
                }, 'click .start-btn': function (e, val, row) {
                    if (row.fState === 0) {
                        layer.confirm("确定要开播？", {
                            title: ['操作提示'],
                            btn: ['确定', '取消'] //按钮
                            , icon: 3
                        }, function () {
                            $.ajax({
                                url: "../broadcast/advance/submitReview.do",
                                type: 'post',
                                data: {
                                	id: row.fId,
                                    broadcastType: row.fBroadcastType,
                                    broadcastTo:row.fBroadcastTo,
                                    fBroadcastArea:row.fBroadcastArea,
                                },
                                success: function (data) {
                                    if (data.status === 200) {
                                        $('#tab_advance').bootstrapTable('refresh');
                                        layer.msg(data.msg, {icon: 1});
                                    } else {
                                        layer.msg(data.msg, {icon: 2});
                                    }
                                }
                            });

                        }, function () {
                            return;
                        })
                    } else if (row.fState === 3) {
                        layer.alert('该预案正在播发中，请勿重复提交！', {title: "操作提示", icon: 2});
                    } else if (row.fState === 2) {
                        layer.alert('该预案已处于待播发列表，请勿重复提交！', {title: "操作提示", icon: 2});
                    } else if (row.fState === 1) {
                        layer.alert('该预案正在等待管理员审核，请勿重复提交！', {title: "操作提示", icon: 2});
                    }
                }
            },
            formatter: function (data, row, index) {
                //若为待播发状态，待审核状态，,已播发,已取消状态或开播状态就隐藏掉开播按钮
                if (row.fState !=0) {
                    return ' <button class="btn btn-info btn-sm detail-btn">详情</button>';
                }
                return '<button class="btn btn-danger btn-sm start-btn">开播</button>  <button class="btn btn-info btn-sm detail-btn">详情</button>';
            }
        }]]

    /*$('#advance_modal').on('hidden.bs.modal', function () {

    });
*/

    $(function () {
        $('#tab_advance').bootstrapTable({
            url: "../broadcast/advance/getAdavanceList.do",
            method: 'get',
            sortable: true,
            search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            clickToSelect: true,
            trimOnSearch: true,
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: true, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    Number: params.pageNumber,//从数据库第几条记录开始
                    Size: params.pageSize, //找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                if (result.status === 200) {
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },
        });
    });


    $("#edit").on("click", function () {
        var SlectLineData = $("#tab_advance").bootstrapTable('getSelections');
        if (SlectLineData.length > 1) {
            layer.msg("一次只能修改一条记录", {icon: 2});
            return false;
        } else if (SlectLineData.length <= 0) {
            layer.msg("请选择要修改的记录", {icon: 2});
            return false;
        } else {
            if (SlectLineData[0].fState == 3) {
                layer.msg("该记录正在播发中，不能修改！", {icon: 2});
            } else if (SlectLineData[0].fState == 2) {
                layer.msg("该记录已待播发，不能修改！", {icon: 2});
            } else if (SlectLineData[0].fState == 6) {
                layer.msg("该记录已取消，不能修改！", {icon: 2});
            } else if (SlectLineData[0].fState == 4) {
                layer.msg("该记录已播发，不能修改！", {icon: 2});
            } else {
                $.each(SlectLineData[0], function (key, value) {
                    $("#advance_modal [name='" + key + "']").val(value);
                })
                 if (SlectLineData[0].fBroadcastType === 11 || SlectLineData[0].fBroadcastType === 5) {
                        $('#broadcastType2').val(11);
                    } else if (SlectLineData[0].fBroadcastType === 10 || SlectLineData[0].fBroadcastType === 4) {
                        $('#broadcastType2').val(10);
                    } else if (SlectLineData[0].fBroadcastType === 7 || SlectLineData[0].fBroadcastType === 1) {
                        $('#broadcastType2').val(7);
                    } else if (SlectLineData[0].fBroadcastType === 8 || SlectLineData[0].fBroadcastType === 2) {
                        $('#broadcastType2').val(8);
                    } else if (SlectLineData[0].fBroadcastType === 9 || SlectLineData[0].fBroadcastType === 3) {
                        $('#broadcastType2').val(9);
                    }
                var name = SlectLineData[0].fRealArea;
                $(".modal input[name='EffectiveTime']").val(new Date(SlectLineData[0].fEffectiveTime).format('yyyy-MM-dd HH:mm:ss'));
                var zTree_Menu = $.fn.zTree.getZTreeObj("ztree");
                var nodes = zTree_Menu.transformToArray(zTree_Menu.getNodes());
                if (nodes.length > 0) {
                    for (var i = 0; i < nodes.length; i++) {
                        if (name.indexOf(nodes[i].name) >= 0) {
                            nodes[i].checked = true;
                            zTree_Menu.updateNode(nodes[i]);
                        }
                    }
                }
                var str = SlectLineData[0].fBroadcastTo;
                if (str != null && str != "") {
                    var arr = str.split(',');
                    $('#boardcastTo').selectpicker('val', arr);
                } else {
                    $('#boardcastTo').val("");
                }
                $('#title').html('修改');
                $('#advance_modal').modal();
                flag = 1;
            }
        }
    });



    function confirmName(e) {
        var result = false;
        var title = e.val();
        if (title != null && title != "") {
            $.ajax({
                url: "${ctx}/broadcast/advance/selectAllAdvanceName",
                type: "post",
                async: false,
                dataType: "json",
                data: {
                    fBroadcastName: title,
                },
                success: function (data) {
                    if (data.status != 200) {
                        layer.tips("重复", e, {
                            tips: [2, 'red'],
                            tipsMore: true,
                        });
                        result = false;
                    } else {
                        result = true;
                    }
                },
            })
            return result;
        }
    }

    function confirm(value) {
        let fVolumeControl = $(value + " " + "input[name='fVolumeControl']").val();
        let boradcastto = $(value).find(".dropdown-menu.inner.selectpicker").find(".selected");
        let name = $(value + " " + "input[name='fBroadcastName']").val();
        let isflag = true;
        if(flag===0){
            var re = /^(?:[1-9]?\d|100)$/;
            if(!confirmName($("#advanceName2"))){
                isflag=false;
            }
            //判断音量是否为空
            if (!fVolumeControl) {
                layer.tips('音量不能为空!', value + " "
                    + "input[name='fVolumeControl']", {
                    tips: [2, 'red'],
                    tipsMore: true
                });
                isflag = false;
            } else if (!re.test(fVolumeControl)) {
                layer.tips('请输入0-100间的整数!', value + " "
                    + "input[name='fVolumeControl']", {
                    tips: [2, 'red'],
                    tipsMore: true
                })
            }
            //判断播发去向是否为空
            if (boradcastto.length == 0) {
                isflag = false;
                layer.tips('请选择播发去向', ".btn.selectpicker", {
                    tips: [2, 'red'],
                    tipsMore: true
                })
            }
            if (name == "" ||name == null) {
                isflag = false;
                layer.tips('请填写预案名称', value + " "
                    + "input[name='fBroadcastName']", {
                    tips: [2, 'red'],
                    tipsMore: true
                })
            }else{            	
            	$.ajax({
	   	          	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
	   	               type: 'post',
	   	               async: false,
	   	               data: {
	   	              	 "input":name,
	   	               },
	   	               success: function (data) {
	   	              	 
	   	              	 if(data.length != 0){
	   	              		 
	   	              		 layer.tips('存在敏感字'+ '\"' +data + '\"', $(value + " " + "input[name='fBroadcastName']"), {
	   	                           tips: [2, 'red'],
	   	                           tipsMore: true
	   	                       });
	   	                       flag = false;
	   	              	 }	   	                   
	   	               }
	   	          });   
            }
            let treeObj = $.fn.zTree.getZTreeObj("ztree");
            let nodes = treeObj.getCheckedNodes(true);
            if (nodes.length == 0) {
                isflag = false;
                layer.tips('请选择播发区域!', '.ztree', {
                    tips: [1, 'red'],
                    tipsMore: true
                })
            }
        }else{
            let re = /^(?:[1-9]?\d|100)$/;
            //判断音量是否为空
            if (!fVolumeControl) {
                layer.tips('音量不能为空!', value + " "
                    + "input[name='fVolumeControl']", {
                    tips: [2, 'red'],
                    tipsMore: true
                });
                isflag = false;
            } else if (!re.test(fVolumeControl)) {
                layer.tips('请输入0-100间的整数!', value + " "
                    + "input[name='fVolumeControl']", {
                    tips: [2, 'red'],
                    tipsMore: true
                })
            }
            if (name == "") {
                isflag = false;
                layer.tips('请填写预案名称', value + " "
                    + "input[name='fBroadcastName']", {
                    tips: [2, 'red'],
                    tipsMore: true
                })
            }
            let treeObj = $.fn.zTree.getZTreeObj("ztree");
            let nodes = treeObj.getCheckedNodes(true);
            if (nodes.length == 0) {
                isflag = false;
                layer.tips('请选择播发区域!', '.ztree', {
                    tips: [1, 'red'],
                    tipsMore: true
                })
            }
        }

    	/* var inputTextArea = $(form + " " +"textarea[name='tts']"); */
    	var inputTextArea = $("#text_for_video");
    	var inputfile =$("#inputAudioFile");
    	
        var inputTextAreaValue = inputTextArea.val();
        var inputfileValue =inputfile.val();
        
        var inputValue = null;
        var dom = null;
        if(inputTextAreaValue.length != 0){
        	inputValue = inputTextAreaValue;
        	dom = "#text_for_video";
        }else{
        	inputValue = inputfileValue;
        	dom = "#inputAudioFile";
        }
    	
        
    	$.ajax({
         	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
              type: 'post',
              async: false,
              data: {
             	 "input":inputValue,
              },
              success: function (data) {
             	 
             	 if(data.length != 0){
             		 
             		 layer.tips('存在敏感字'+ '\"' +data + '\"', $(dom), {
                          tips: [2, 'red'],
                          tipsMore: true
                      });
             		isflag = false;
             	 }
                  
              }
         });      	
        return isflag;
    }

$("#confirm").click(function () {
    if (confirm("#form_advance")) {
        var data = "";
        var nodes = $.fn.zTree.getZTreeObj("ztree").getCheckedNodes(true);
        $.each(nodes, function (i, item) {
            data = data + item.id;
            if (i < nodes.length - 1) {
                data = data + ',';
            }
        });
        var SlectLineData = $("#tab_advance").bootstrapTable('getSelections');

        if (flag === 0) {
            $('#fId').val('');
            let formDate= new FormData($("#form_advance")[0]);
            formDate.append("resourceId", data);
            $.ajax({
                url: "../broadcast/advance/insertOrUpdateAdvance.do",
                type: 'post',
                data: formDate,
                contentType: false,
                async: false,
                processData: false,
                success: function (data) {
                    if (data.status === 200) {
                        $("#advance_modal").modal('hide');
                        $('#tab_advance').bootstrapTable('refresh');
                        layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        } else {
            flag = 0;
            let formDate= new FormData($("#form_advance")[0]);
            formDate.append("resourceId", data);
            formDate.append("state", SlectLineData[0].fState);
            $.ajax({
                url: "../broadcast/advance/insertOrUpdateAdvance.do",
                type: 'post',
                data: formDate,
                contentType: false,
                async: false,
                processData: false,
                success: function (data) {
                    if (data.status === 200) {
                        $("#advance_modal").modal('hide');
                        $('#tab_advance').bootstrapTable('refresh');
                        layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        }
    }

})
    $("#delete").on("click", function () {
        var allSlectLineData = $("#tab_advance").bootstrapTable('getSelections');
        var ids = "";
        var count = 0;
        if (allSlectLineData.length == 0) {
            layer.msg("请选择要取消的记录!", {icon: 2});
        } else {
            for (i = 0; i < allSlectLineData.length; i++) {
                ids += allSlectLineData[i].fId + ",";
                count++;
            }
            layer.confirm("确定要取消这" + count + "条记录？", {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
                , icon: 3
            }, function () {
                $.ajax({
                    data: {
                        ids: ids
                    },
                    type: 'post', // 提交方式 get/post
                    url: "../broadcast/advance/deleteAdvance.do", // 需要提交的 url
                    success: function (data) {
                        if (data.status === 200) {
                            $('#tab_advance').bootstrapTable('refresh');
                            layer.msg(data.msg, {icon: 1});
                            $(table).bootstrapTable('refresh');
                        } else {
                            layer.msg(data.msg, {icon: 2});
                        }
                    }
                });
            }, function () {
                return;
            })
        }
    });
    $("#btn_tts").click(function () {
        let content = $("#text_for_video").val();
        if (content == "null" || content == '') {
            layer.msg("该输入要转换的文字", {icon: 2});
        }
        let s = $("#tts_source").attr("src");
        let value = s + "'" + content + "'";
        $("#tts_source").attr("src", value);
        $("#tts_audio")[0].load();
        $('audio').bind('ended', function () {
            $("#tts_source").attr("src", s);
        });

    });
    $("select[name='fProgramPass']").change(function () {
        let type = $(this).find("option:selected").attr("type");
        let $choose = $(this).find("option:selected").attr("number");
        if (type == "base") {
           // $("select[name='fControlDevice']").find("option").css("display", "");
           // $("select[name='fControlDevice']").find("option").eq(0).prop("selected", "true");
            if ($choose=="02") {
                $("#TTS").css("display", "")
            } else {
                $("#TTS").css("display", "none");
            }
            if ($choose == "00"){
                $("#localAudio").css("display", "")
            } else {
                $("#localAudio").css("display", "none");
            }

            if ($choose != "01"){
                $("select[name='fControlDevice']").find("option").css("display","none").eq(0).prop("selected", "true");
                $("select[name='fPassSelect']").find("option").remove();
            }
        } else if (type == "extra") {
            $("#localAudio").css("display", "none");
            $("#TTS").css("display", "none");
            let region = $(this).find("option:selected").attr("region");
            let regions = region.split(",");
            for (let r in regions) {
                let zTree = $.fn.zTree.getZTreeObj("ztree");
                let nodes = zTree.transformToArray(zTree.getNodes());
                if (nodes.length > 0) {
                    for (var i = 0; i < nodes.length; i++) {
                        if (regions[r] == nodes[i].id) {
                            nodes[i].checked = true;
                            zTree.updateNode(nodes[i]);
                        }
                    }
                }
                zTree.selectNode(Node, true);
                zTree.updateNode(Node);
            }
            $("select[name='fControlDevice']").val("");
            $("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true");
            $("select[name='fPassSelect']").find("option").remove();
        }
    });
    $('body').on('hidden.bs.modal', '.modal', function () {
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"});
        $("#TTS").css("display","none");
        $("select").find("option").eq(0).prop("selected",true);
        $("#localAudio").css("display","");
        document.getElementById("form_advance").reset();
        $(".selectpicker").selectpicker('refresh');
        $.fn.zTree.destroy("ztree");
        var setting2 = {
            check: {
                enable: true
            }

        };
        //构造节点数据
        var regionData = ${regionList};
        //调用API初始化ztree
        loadRegionTree("ztree", regionData);
        $('#title').html('新增');
    });
    $(".modal").on("click", ".show-tick", function () {
        $(".selectpicker").selectpicker('refresh');
    });

    $('.add_advance_modal  ').on('click', function () {
        nextdate();
    });

    function nextdate() {
        var curDate = new Date();
        var nextDate = new Date(curDate.getTime() + 24 * 60 * 60 * 1000); //后一天
        //alert(nextDate.format("yyyy-MM-dd HH:mm:ss"))
        $(".modal input[name='EffectiveTime']").val(nextDate.format("yyyy-MM-dd HH:mm:ss"))
    }
 /*   $("select[name='fProgramPass']").change(function () {
        var type=$(this).find("option:selected").attr("type");
        if (type=="base"){
            $("select[name='fControlDevice']").find("option").css("display","");
            $("select[name='fControlDevice']").find("option").eq(0).prop("selected","true")
        }else if (type=="extra"){
            $("select[name='fControlDevice']").val("");
            $("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true");
            $("select[name='fPassSelect']").find("option").remove();
        }
    });*/
    
    $("select[name='fControlDevice']").change(function () {
        $("select[name='fPassSelect']").find("option").remove();
        var deviceId=$(this).find("option:selected").attr("value");
        $.getJSON('${ctx}/broadcast/drill/selectDeviceChannel?deviceId='+deviceId,function (result) {
            var data=result.data;
            var fChannelContent=data.fChannelContent;
            <c:forEach items="${map}" var="map">
            if (fChannelContent.indexOf(${map.key})>-1){
                $("select[name='fPassSelect']").append("<option value='${map.key}'>${map.value}</option>");
            }
            </c:forEach>
        });
    });

    $("select[name='fBroadcastType']").change(function () {
        if($(this).find("option:selected").attr("value")==5){
            $("input[name='fVolumeControl']").attr("disabled","true").attr("value","100")
        }else{
            $("input[name='fVolumeControl']").removeAttr("disabled").attr("value","")
        }
    })
</script>
<script type="text/javascript">
    var enLang = {
        name: "en",
        month: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"],
        weeks: ["SUN", "MON", "TUR", "WED", "THU", "FRI", "SAT"],
        times: ["Hour", "Minute", "Second"],
        timetxt: ["Time", "Start Time", "End Time"],
        backtxt: "Back",
        clear: "Clear",
        today: "Now",
        yes: "Confirm",
        close: "Close",
    }

    jeDate(".jeinput", {
        format: "YYYY-MM-DD hh:mm:ss",
    });
</script>
</body>
</html>