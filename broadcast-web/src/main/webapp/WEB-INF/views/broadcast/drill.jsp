<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
    request.setAttribute("map", DictionaryConfig.getAllMap());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>广播演练</title>
    <%@include file="../common/css.jsp" %>
    <style>
        form {
            height: 99%;
        }

        .modal input[type='text'] {
            width: 60% !important;
        }

        .modal select {
            width: 60% !important;
        }

        .tab_modal {
            display: none;
        }

        .content_table {
            height: 100%;
        }

        .btn-group.bootstrap-select.show-tick.form-control {
            width: 60%;
            background: none;
        }

        .btn.dropdown-toggle.btn-default {
            background: none;
            color: #ffffff;
        }

        #infoModal .modal-dialog {
            overflow-y: scroll
        }

        table {
            table-layout: fixed;
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        #text_for_video {
            padding: 0 !important;
        }
    </style>
</head>
<body>
<h4>
    <b>当前位置:制作播发>>广播演练</b>
</h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li class="selected_tab shiji" onclick='resetValue()'><a>实际演练</a></li>
        <li class="moni" onclick='resetValue()'><a>模拟演练</a></li>
        <li class="system" onclick='resetValue()'><a>系统演练</a></li>
    </ul>
</div>
<div class="tab_modal show">
    <div class="content_table">
        <div class="handle">
            <button class="btn_add_drill btn btn btn-info" data-toggle="modal" data-target="drill_modal">新增</button>
            <button onclick="updateform()" class="btn_update btn btn-info">修改</button>
            <button onclick="deleteform()" class="btn btn-danger">取消</button>
        </div>
        <table data-height="400" id="tab_drill" class="table table-hover"></table>
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="drill_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">新增</h4>
            </div>
            <div class="modal-body col-sm-12">
                <div class="content col-sm-12">
                    <div class="content_left col-sm-8">
                        <form class="form_broadcast  form-inline">
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">节目通道</label>
                                <select class="col-sm-8 form-control" name="fProgramPass">
                                    <c:forEach items="${channelList}" var="channel">
                                        <option type="base" value="${channel.fId}"
                                                number="${channel.fThirdCode}">${channel.fDictionaryContent}</option>
                                    </c:forEach>
                                    <c:forEach items="${programList}" var="program">
                                        <option region="${program.fBroadcastArea}" type="extra"
                                                value="${program.fId}">${program.fPassName}</option>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">控制设备</label>
                                <select name="fControlDevice" class="col-sm-8 form-control">
                                    <option selected value="" disabled>请选择</option>
                                    <c:forEach items="${deviceInfos}" var="deviceInfos">
                                        <option value="${deviceInfos.fId}">
                                                ${deviceInfos.fDeviceName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">设备通道</label>
                                <select id="fChannelContent" class="col-sm-8 form-control" name="fPassSelect">
                                </select>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">音量控制</label>
                                <input autocomplete="off" maxlength="3"
                                       onKeyUp="comfirm_Volume($(this))" name="fVolumeControl"
                                       type="text" class="form-control col-sm-8" style="width: 60%;">
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">消息类型</label>
                                <select class="col-sm-8 form-control"
                                        name="fMessageType">
                                    <c:forEach items="${messagetypeList}" var="messageType">
                                        <option value="${messageType.fId}">${messageType.fDictionaryContent}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">消息级别</label>
                                <select class="col-sm-8 form-control"
                                        name="fMessageLevel">
                                    <c:forEach items="${messagegradeList}" var="messagegradeList">
                                        <option value="${messagegradeList.fId}">${messagegradeList.fDictionaryContent}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">有效期限</label>
                                <input name="EffectiveTime" type="text" style="width:60%;"
                                       class="jeinput form-control">
                            </div>
                            <%-- <div class="form-group pass col-sm-12">
                                <label class="col-sm-3">播发去向(可多选)</label>
                                <select name="fBroadcastTo" title="请选择"
                                        class="selectpicker show-tick form-control" multiple data-live-search="false">
                                    <c:forEach items="${broadcastDestinate}" var="broadcastDestinate">
                                        <option value="${broadcastDestinate.fId}">
                                                ${broadcastDestinate.fDictionaryContent}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div> --%>
                            
                            
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

                        </form>
                    </div>
                    <div class="content_right">
                        <label>播发区域</label>
                        <div class="right-tree" style="height:300px">
                            <ul id="ztree1" class="ztree"></ul>
                        </div>
                        <span id="msg_tip"></span>
                    </div>
                    <div class="null"></div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="form-group" style="width: 100%">
                    <div class="btn_modal show">
                        <button type="button" class="submit_drill add_braodcast_shiji btn btn-danger">开播</button>
                        <button type="button" style="display:none" class="update_drill btn btn-danger">确定</button>
                        <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                    </div>
                    <div class="btn_modal">
                        <button type="button" class="submit_drill add_braodcast_moni btn btn-danger">开播</button>
                        <button type="button" style="display:none" class="update_drill btn btn-danger">确定</button>
                        <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                    </div>
                    <div class="btn_modal">
                        <button type="button" class="submit_drill add_braodcast_system btn btn-danger">开播</button>
                        <button type="button" style="display:none" class="update_drill btn btn-danger">确定</button>
                        <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                    </div>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 详情模态框（Modal） -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog"
     aria-hidden="true">
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
                        <label class="col-sm-4 control-label">广播类型:</label>
                        <div class="col-sm-8">
                            <span id="fBroadcastType"></span>
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
                        <label class="col-sm-4 control-label">控制设备:</label>
                        <div class="col-sm-8">
                            <span id="fControlDevice"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">音量控制:</label>
                        <div class="col-sm-8">
                            <span id="fVolumeControl"></span>
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
                        <label class="col-sm-4 control-label">有效期限:</label>
                        <div class="col-sm-8">
                            <span id="feffectiveTime"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">节目通道:</label>
                        <div class="col-sm-8">
                            <span id="fRealProgramPass"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2 control-label">播发去向:</label>
                        <div class="col-sm-10">
                            <span id="fRealBroadcastTo"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2 control-label">播发区域:</label>
                        <div class="col-sm-10">
                            <span id="fRealArea"></span>
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
<script>
    $(function () {
        ztreeHeight();
        //刷新多选组件
        $(".selectpicker").selectpicker('refresh');
        //区域树
        refreshTree();
        $('#tab_drill').bootstrapTable({
            url: "${ctx}/broadcast/drill/selectPastList?fBroadcastType=3", // 请求后台的URL（*）
            method: 'post',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            sortable: true,
            search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
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
    })


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

    })
    $("select").change(function () {
        var text = $(this).find("option:selected").attr("value");
        $(this).attr("value", text);
    });


    $("select[name='fProgramPass']").change(function () {
        var type = $(this).find("option:selected").attr("type");
        let $choose = $(this).find("option:selected").attr("number");
        if (type == "base") {
            $("select[name='fControlDevice']").find("option").css("display", "");
            $("select[name='fControlDevice']").find("option").eq(0).prop("selected", "true");
            if ($choose == "02") {
                $("#TTS").css("display", "")
            } else {
                $("#TTS").css("display", "none");
                $("#text_for_video").val("");
            }
            if ($choose == "00") {
                $("#localAudio").css("display", "")
            } else {
                $("#localAudio").css("display", "none");
            }
            if ($choose != "01") {
                $("select[name='fControlDevice']").val("");
                $("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true");
                $("select[name='fPassSelect']").find("option").remove();
            }
        } else if (type == "extra") {
            $("#localAudio").css("display", "none");
            $("#TTS").css("display", "none");
            let region = $(this).find("option:selected").attr("region");
            let regions = region.split(",");
            for (let r in regions) {
                let zTree = $.fn.zTree.getZTreeObj("ztree1");
                let nodes = zTree.transformToArray(zTree.getNodes());
                if (nodes.length > 0) {
                    for (var i = 0; i < nodes.length; i++) {
                        if (regions[r] == nodes[i].id) {
                            nodes[i].checked = true;
                            zTree.updateNode(nodes[i]);
                        }
                    }
                }
               /*  $("select[name='fControlDevice']").val("");
                $("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true"); */
                $("select[name='fPassSelect']").find("option").remove();
            }
        }
    });
    /* $("select[name='fControlDevice']").change(function () {
        $("select[name='fPassSelect']").find("option").remove();
        var deviceId = $(this).find("option:selected").attr("value");
        let list = new Array(100);
        $.getJSON('${ctx}/broadcast/drill/selectDeviceChannel?deviceId=' + deviceId, function (result) {
            var data = result.data;
            var fChannelContent = data.fChannelContent;
            list = fChannelContent.split(",");
            <c:forEach items="${map}" var="maplist">
            var indexvalue =${maplist.key};
            if (list.indexOf(indexvalue.toString()) > -1) {
                $("select[name='fPassSelect']").append("<option value='${maplist.key}'>${maplist.value}</option>");
            }
            </c:forEach>
        })
    }); */

    $(".btn_add_drill").click(function () {
    	var stateCheck = broadcastServerStateCheck("${ctx}");
    	if(!stateCheck){
    		return;
    	}
       /*  $("select[name='fControlDevice']").val("");
        $("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true"); */
        $("select[name='fPassSelect']").find("option").remove();
        $('#drill_modal').modal('show');
    });
    $("input").prop("checked", true);
    var columns = [[{
        checkbox: true,
    }, {
        field: 'fId',
        title: '广播ID',
        align: 'center',
        width: "5%",
    }, {
        field: 'fRealMessageType',
        title: '消息类型',
        align: 'center',
        width: "10%",
    }, {
        field: 'fRealMessageLevel',
        title: '消息级别',
        align: 'center',
        width: "10%",
        sortable: true,

    }, {
        field: 'fRealMessageSource',
        title: '消息来源',
        align: 'center',
        width: "13%",

    }, {
        field: 'fRealArea',
        title: '播发区域',
        align: 'center',
        width: "13%",

    }, {
        field: 'fEffectiveTime',
        title: '有效期限',
        align: 'center',
        sortable: true,
        width: "15%",
        formatter: function (time) {
            return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : "";
        },
    }, {
        field: 'creator',
        title: '操作者',
        align: 'center',
        width: "8%",
    },
        {
            field: 'fState',
            title: '状态',
            align: 'center',
            width: "7%",
            sortable: true,
            formatter: function (value) {
                let style = "width:50px;text-align:center;display:inline-block";
                if (value == 0) {
                    return '<span  style=' + style + ' class="label label-info">无</span>';
                } else if (value == 1) {
                    return '<span  style=' + style + ' class="label label-warning">待审核</span>';
                } else if (value == 2) {
                    return '<span  style=' + style + ' class="label label-success">待播发</span>';
                } else if (value == 3) {
                    return '<span  style=' + style + ' class="label label-primary">正在播</span>';
                } else if (value == 4) {
                    return '<span  style=' + style + ' class="label label-default">已播发</span>';
                } else if (value == 5) {
                    return '<span style=' + style + ' class="label label-danger">不通过</span>';
                } else if (value == 7) {
                    return '<span  style=' + style + ' class="label label-default">已过期</span>';
                } else {
                    return '<span  style=' + style + ' class="label label-warning">未知</span>';
                }
            }
        },
        {
            title: '操作',
            align: 'center',
            events: {
                'click .edit-base-btn': function (e, val, row) {
                    let data = row;
                    if (data.fBroadcastType == 3) {
                        $('#fBroadcastType').text("实际演练");
                    } else if (data.fBroadcastType == 2) {
                        $('#fBroadcastType').text("模拟演练");
                    } else if (data.fBroadcastType == 1) {
                        $('#fBroadcastType').text("系统演练");
                    }
                    $('#fRealMessageSource').text(data.fRealMessageSource ? data.fRealMessageSource : "");
                    $('#fControlDevice').text(data.fRealControlDevice ? data.fRealControlDevice : "");
                    $('#fCreateTime').text(data.fCreateTime ? new Date(data.fCreateTime).format('yyyy-MM-dd HH:mm:ss') : "");
                    $('#fUpdtateTime').text(data.fUpdtateTime ? new Date(data.fUpdtateTime).format('yyyy-MM-dd HH:mm:ss') : "");
                    $('#fVolumeControl').text(data.fVolumeControl);
                    $('#fRealArea').text(data.fRealArea);
                    $('#fRealBroadcastTo').text(data.fRealBroadcastTo ? data.fRealBroadcastTo : "");
                    $('#creator').text(data.creator ? data.creator : "");
                    $('#operator').text(data.operator ? data.operator : "");
                    $('#fRealMessageLevel').text(data.fRealMessageLevel);
                    $('#fRealMessageType').text(data.fRealMessageType);
                    var frealProgramPass = data.fRealProgramPass;
					if(frealProgramPass != null){
						var programPassOfLineFeed = "";
						while(frealProgramPass.length>20){
							
							var tempProgramPass = frealProgramPass.substring(0,19);
							programPassOfLineFeed += tempProgramPass;
							frealProgramPass = frealProgramPass.replace(tempProgramPass, "");
						}
						programPassOfLineFeed +=frealProgramPass;
                        $('#fRealProgramPass').text(programPassOfLineFeed);
					}
                    $("#feffectiveTime").text(new Date(data.fEffectiveTime).format('yyyy-MM-dd HH:mm:ss'));
                    $('#infoModal').modal();
                }
            },
            formatter: function () {
                return '<button class="btn btn-info btn-sm edit-base-btn">详情</button>';
            },

        }]];

    $(".shiji").on("click", function () {
        $('#tab_drill').bootstrapTable('refresh', {
            url: "${ctx}/broadcast/drill/selectPastList?fBroadcastType=3"
        });
    })
    $(".moni").on("click", function () {
        $('#tab_drill').bootstrapTable('refresh', {
            url: "${ctx}/broadcast/drill/selectPastList?fBroadcastType=2"
        });
    })
    $(".system").on("click", function () {
        $('#tab_drill').bootstrapTable('refresh', {
            url: "${ctx}/broadcast/drill/selectPastList?fBroadcastType=1"
        });
    })
    $(".add_braodcast_shiji").on("click", function () {
        addBroadcast("实际演练", "${ctx}/broadcast/drill/addBroadCast?fBroadcastType=3", "#tab_drill")
    });
    $(".add_braodcast_moni").on("click", function () {
        addBroadcast("模拟演练", "${ctx}/broadcast/drill/addBroadCast?fBroadcastType=2", "#tab_drill")
    });

    $(".add_braodcast_system").on("click", function () {
        addBroadcast("系统演练", "${ctx}/broadcast/drill/addBroadCast?fBroadcastType=1", "#tab_drill")
    });

    function showcontent(value) {
        var name = value.fRealArea;
        var zTree_Menu = $.fn.zTree.getZTreeObj("ztree1");
        var nodes = zTree_Menu.transformToArray(zTree_Menu.getNodes());
        if (nodes.length > 0) {
            for (var i = 0; i < nodes.length; i++) {
                if (name.indexOf(nodes[i].name) >= 0) {
                    nodes[i].checked = true;
                    zTree_Menu.updateNode(nodes[i]);
                }
            }
        }
        $(".modal select[name='fProgramPass']").attr("value", value.fProgramPass).val(value.fProgramPass);
        $(".modal select[name='fRealControlDevice']").attr("value", value.fRealControlDevice).val(value.fRealControlDevice);
        $(".modal select[name='fMessageLevel']").attr("value", value.fMessageLevel).val(value.fMessageLevel);
        //$(".modal select[name='fBroadcastTo']").attr("value", value.fBroadcastTo);
        $(".modal input[name='EffectiveTime']").val(new Date(value.fEffectiveTime).format('yyyy-MM-dd HH:mm:ss'));
        $(".modal input[name='fVolumeControl']").val(value.fVolumeControl);
        /* var $option = $(".modal select[name='fBroadcastTo']").find("option");
        var str = '';
        var fBroadcastTo = (value.fBroadcastTo);
        if (fBroadcastTo != null && fBroadcastTo != "") {
            for (var i = 0; i < $option.length; i++) {
                if ((fBroadcastTo.indexOf($option[i].value)) > -1) {
                    var va = Trim($(".modal select[name='fBroadcastTo']").find("option[value='" + $option[i].value + "']").text())
                    str = str + va + ",";
                    $(".modal .dropdown-menu.inner.selectpicker").find("span").each(function () {
                        if (Trim($(this).text()) == va) {
                            $(this).parent().parent().addClass("selected");
                        }
                    })
                }
            }
        }
        $(".modal .filter-option").text(str.substr(0, str.length - 1)); */
    }

    //清除空格
    function Trim(str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }

    function resetValue() {
        refreshTree();
        $('select').each(function (i, j) {
            $(j).find("option:selected").attr("selected", false);
            $("input[name='fVolumeControl']").val("");
            $('input:checkbox').removeAttr('checked');
        })
    }


    function addBroadcast(title, url, table) {
    	
    	var sensitiveFlag = true;
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
        
    	/* $.ajax({
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
             		sensitiveFlag = false;
             	 }
                  
              }
         });    */
    	
        var flag = confirm(".form_broadcast");
        if (flag && sensitiveFlag == true) {
            layer.confirm('是否确定开播？', {
                title: ["操作提示"],
                icon: 3,
                btn: ['确定', '取消']
                //按钮
            }, function () {
                layer.load(2);
                $("#drill_modal").modal("hide");
                var data = "";
                var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
                $.each(nodes, function (i, item) {
                    data = data + item.id;
                    if (i < nodes.length - 1) {
                        data = data + ',';
                    }
                });
            //    let resourceId = data;
                let formDate= new FormData($(".form_broadcast")[0]);
                formDate.append("resourceId", data);
                $.ajax({
                    url: url,
                    type: 'post',
                    data: formDate,
                    contentType: false,
                    async: false,
                    processData: false,
                    success: function (data) {
                        layer.closeAll();
                        layer.msg(data.msg, {
                            icon: 1
                        });
                        $(table).bootstrapTable('refresh');
                    }
                });
            }, function () {
            })
        }

    }

    function deleteform() {
        var checked = $('#tab_drill').bootstrapTable('getSelections');
        var ids = "";
        if (checked.length == 0) {
            layer.msg("请选择要取消的的记录", {icon: 2});
        } else {
            layer.confirm('是否确定取消这' + checked.length + '条记录？', {
                title: ['操作提示'],
                icon: 3,
                btn: ['确定', '取消'] //按钮
            }, function () {
                for (var i = 0; i < checked.length; i++) {
                    ids += checked[i].fId + ",";
                }
                $.ajax({
                    async: false,
                    data: {
                        "fId": ids,
                    },
                    url: "${ctx}/broadcast/drill/deleteBroadcast",
                    type: "post",
                    success: function (data) {
                        $(".btn_update").removeClass("disabled");
                        $(".btn_update").css("opacity", "1");
                        layer.msg(data.msg, {icon: 1});
                        $("#tab_drill").bootstrapTable('refresh');
                    }
                })
            }, function () {
            })

        }
    }

    function confirm(value) {
        var fVolumeControl = $(value + " " + "input[name='fVolumeControl']").val();
        var boradcastto = $(value).find(".dropdown-menu.inner.selectpicker").find(".selected");
        var flag = true;
        var re = /^(?:[1-9]?\d|100)$/;
        //判断音量是否为空
        if (!fVolumeControl) {
            layer.tips('音量不能为空!', value + " "
                + "input[name='fVolumeControl']", {
                tips: [2, 'red'],
                tipsMore: true
            });
            flag = false;
        } else if (!re.test(fVolumeControl)) {
            layer.tips('请输入0-100间的整数!', value + " "
                + "input[name='fVolumeControl']", {
                tips: [2, 'red'],
                tipsMore: true
            })
        }
     /*    //判断播发去向是否为空
        if (boradcastto.length == 0) {
            flag = false;
            layer.tips('请选择播发去向', ".btn.selectpicker", {
                tips: [2, 'red'],
                tipsMore: true
            })
        } */
        var treeObj = $.fn.zTree.getZTreeObj("ztree1");
        var nodes = treeObj.getCheckedNodes(true);
        if (nodes.length == 0) {
            flag = false;
            layer.tips('请选择播发区域!', '.ztree', {
                tips: [4, 'red'],
                tipsMore: true
            })
        }
        return flag;
    }

    function comfirm_Volume(e) {
        var fVolumeControl = e.val();
        var re = /^(?:[1-9]?\d|100)$/;
        if (!re.test(fVolumeControl)) {
            layer.tips('请输入0-100间的整数!', e, {
                tips: [2, 'red'],
                tipsMore: true,
            })
        }
    }

    function ztreeHeight() {
        var width = $(".form_broadcast").height();
        $("#ztree1").css("height", width);
    }

    //重置ztree
    function refreshTree() {
        var regionData = ${regionList};
        loadRegionTree("ztree1", regionData);
    }

    //模态框拖动
    $(".modal-dialog").draggable();
    $('body').on('hidden.bs.modal', '.modal', function () {
        $('.modal input').val("");
        $(".add_braodcast_shiji").text("开播");
        $("#drill_modal h4").text("新增");
        $(".submit_drill").css("display", "");
        $(".update_drill").css("display", "none");
        $(".selectpicker.show-tick.form-control").selectpicker('refresh');
        $('.selectpicker').selectpicker('deselectAll');
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"});
        $("select").find("option").eq(0).prop("selected",true);
        $("#localAudio").css("display","");
        $("#TTS").css("display", "none");
        refreshTree();
    });
    $(".modal").on("click", ".show-tick", function () {
        $(".selectpicker.show-tick.form-control").selectpicker('refresh');

    });
    $('.btn_add_drill ').on('click', function () {
        nextdate();
    });

    function nextdate() {
        var curDate = new Date();
        var nextDate = new Date(curDate.getTime() + 24 * 60 * 60 * 1000); //后一天
        //alert(nextDate.format("yyyy-MM-dd HH:mm:ss"))
        $(".modal input[name='EffectiveTime']").val(nextDate.format("yyyy-MM-dd HH:mm:ss"))
    }
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