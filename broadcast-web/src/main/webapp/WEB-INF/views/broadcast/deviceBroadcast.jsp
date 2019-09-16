<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig,cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ page import="cn.wtu.broadcast.config.DeviceBroadcastConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("dict", DictionaryConfig.getListMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
    request.setAttribute("map", DictionaryConfig.getAllMap());
    request.setAttribute("devMap", DeviceBroadcastConfig.getDeviceForRegion());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>设备广播</title>
    <%@include file="../common/css.jsp" %>
    <style>
        html {
            height: 100%;
        }

        .map_title {
            border: solid 1px red !important;
            background: none;
            color: red;
        }

        .amap-marker-label {
            border: none;
            background: none;
            padding: 0;
        }

        .form-group {
            padding-left: 0 !important;
        }

        label {
            text-align: left !important;
            height: 34px;
            line-height: 34px;
        }

        .modal-body {
            padding-top: 15px;
        }

        .bootstrap-select.form-control {
            background: none !important;
        }

        .btn.dropdown-toggle.selectpicker.btn-default {
            background: none !important;
            color: #ffffff;
        }

        @media (max-width: 1400px) {
            .modal .form-group {
                margin: 0 !important;
                padding: 0;
            }
        }

        table {
            table-layout: fixed;
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
    </style>
</head>
<body>
<h4><b>当前位置:制作播发>>设备广播</b></h4>
<div class="tab_modal show">
    <div class="content_table">
        <div class="handle">
            <button class="btn_add_drill btn btn btn-info" data-toggle="modal" data-target="#broadcastModal">新增</button>
            <button onclick="updateform()" class="btn_update btn btn-info">修改</button>
            <button onclick="deleteform()" class="btn btn-danger">取消</button>
        </div>
        <table data-height="400" id="tab_deviceBroadcast" class="table table-hover"></table>
    </div>
</div>
<div class="modal fade" id="broadcastModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="roleForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="col-sm-8" style="padding-right: 0">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">广播类型</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="fBroadcastType">
                                    <option value="4">应急广播</option>
                                    <option value="5">日常广播</option>
                                    <option value="3">实际演练</option>
                                    <option value="2">模拟演练</option>
                                    <option value="1">系统演练</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">节目通道</label>
                            <div class="col-sm-9">
                                <select class="form-control" data-validate="required" name="fProgramPass">
                                    <c:forEach items="${channelList}" var="channel">
                                        <option type="base" value="${channel.fId}"
                                                number="${channel.fThirdCode}">${channel.fDictionaryContent}</option>
                                    </c:forEach>
                                    <c:forEach items="${programList}" var="program">
                                        <option type="extra" region="${program.fBroadcastArea}"
                                                value="${program.fId}">${program.fPassName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">控制设备</label>
                            <div class="col-sm-9">
                                <select name="fControlDevice" class="col-sm-8 form-control">
                                    <option selected value="" disabled>请选择</option>
                                    <c:forEach items="${deviceInfos}" var="deviceInfos">
                                        <option value="${deviceInfos.fId}" style="display:none;">
                                                ${deviceInfos.fDeviceName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">设备通道</label>
                            <div class="col-sm-9">
                                <select id="fChannelContent" class="col-sm-8 form-control" name="fPassSelect">
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">音量控制</label>
                            <div class="col-sm-9">
                                <input type="text" name="fVolumeControl" disabled="disabled" value="100"
                                       onKeyUp="comfirm_Volume($(this))" class="form-control"/>

                            </div>
                        </div>

                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">消息类型</label>
                            <div class="col-sm-9">
                                <select class="form-control" data-validate="required" name="fMessageType">
                                    <c:forEach items="${dict.get('message_type')}" var="d">
                                        <option value="${d.fId}">${d.fDictionaryContent} </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">消息级别</label>
                            <div class="col-sm-9">
                                <select class="form-control" data-validate="required" name="fMessageLevel">
                                    <c:forEach items="${dict.get('message_grade')}" var="d">
                                        <option value="${d.fId}">${d.fDictionaryContent} </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3">有效期限</label>
                            <div class="col-sm-9">
                                <input name="EffectiveTime" type="text"
                                       class="jeinput form-control">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">播发设备</label>
                            <div class="col-sm-9">
                                <select name="fDeviceResourcecode" title="请选择"
                                        class="selectpicker show-tick form-control" multiple data-live-search="false">
                                </select>
                            </div>
                        </div>
                        <div id="TTS" style="display: none;" class="form-group  col-sm-12">
                                <textarea name="tts" id="text_for_video" class="col-sm-12 form-control" rows="2"
                                          cols="20"
                                          style="width:70%;height: 50px; resize: none;"
                                          placeholder="请输入需要转换的文字"></textarea>
                            <button id="btn_tts" type="button" class="btn btn-info" style="height: 50px;">试听</button>
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
                    <div class="col-sm-4">
                        <div class="right-tree" style="height:350px">
                            <ul id="ztree" class="ztree"></ul>
                        </div>
                    </div>
                </div>
                <div class="modal-footer" style="clear: both">
                    <button type="button" id="confirm" class="btn btn-info">确定</button>
                    <button type="button" id="cancel" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    var Flag = 0;
    $(function () {
        $(".modal-dialog").draggable();
        $(".selectpicker").selectpicker('refresh');
        treeId = 'ztree';
        deviceBroadZtree(treeId, ${regionList});
        $('#tab_deviceBroadcast').bootstrapTable({
            method: 'get',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            url: "${ctx}/broadcast/deviceBroadcast/List",
            toolbar: '#toolbarComputer', // 工具按钮用哪个容器
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容searchText
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },
        });
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

    })
    $("select").change(function () {
        let text = $(this).find("option:selected").attr("value");
        $(this).attr("value", text);
    });

    $("select[name='fProgramPass']").change(function () {
        let type = $(this).find("option:selected").attr("type");
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
            $("select[name='fControlDevice']").val("");
            $("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true");
            $("select[name='fPassSelect']").find("option").remove();
        }
    });
    $("select[name='fBroadcastType']").change(function () {
        if ($(this).find("option:selected").prop("value") == 4) {
            $("input[name='fVolumeControl']").prop("disabled", "true").attr("value", "100")
        } else {
            $("input[name='fVolumeControl']").removeProp("disabled").attr("value", "")
        }
    });
    $("select[name='fControlDevice']").change(function () {
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
    });
    $("#confirm").click(function () {
        if (confirm("#roleForm")) {
            layer.confirm('是否确定开播？', {
                title: ["操作提示"],
                icon: 3,
                btn: ['确定', '取消']
                //按钮
            }, function () {
                if (Flag == 0) {
                    layer.load(2);
                    $("#broadcastModal").modal("hide");
                    var data = "";
                    var nodes = $.fn.zTree.getZTreeObj("ztree").getCheckedNodes(true);
                    $.each(nodes, function (i, item) {
                        data = data + item.id;
                        if (i < nodes.length - 1) {
                            data = data + ',';
                        }
                    });
                    let type = $("select[name='fBroadcastType']").find("option:selected").attr("value");
                    if (type == 4) {
                        $.ajax({
                            url: "${ctx}/broadcast/emergency/startPlay/"+data,
                            type: 'post',
                            contentType: false,
                            async: false,
                            processData: false,
                            data: new FormData($("#roleForm")[0]),
                            success: function (data) {
                            	 layer.closeAll();
                            	if (data.status === 200) {
                                    $('#tab_advance').bootstrapTable('refresh');
                                    layer.msg(data.msg, {icon: 1});
                                } else {
                                    layer.msg(data.msg, {icon: 2});
                                }
                            }
                        });

                    } else if(type == 5){
                        let formDate = new FormData($("#roleForm")[0]);
                        $.ajax({
                            url: "${ctx}/broadcast/daily/addDailyBroadcast/"+data,
                            type: 'post',
                            data: formDate,
                            contentType: false,
                            async: false,
                            processData: false,
                            success: function (data) {
                            	 layer.closeAll();
                            	   if (data.status === 200) {
                                       $('#tab_deviceBroadcast').bootstrapTable('refresh');
                                       layer.msg(data.msg, {icon: 1});
                                   } else {
                                       layer.msg(data.msg, {icon: 2});
                                   }
                                   $("#tab_deviceBroadcast").bootstrapTable('refresh');
                            }
                        });
                    }else {
                    	 let formDate = new FormData($("#roleForm")[0]);
                         $.ajax({
                             url: "${ctx}/broadcast/drill/addBroadCast?fBroadcastType=type",
                             type: 'post',
                             data: formDate,
                             contentType: false,
                             async: false,
                             processData: false,
                             success: function (data) {
                                 layer.closeAll();
                                 if (data.status === 200) {
                                     $('#tab_deviceBroadcast').bootstrapTable('refresh');
                                     layer.msg(data.msg, {icon: 1});
                                 } else {
                                     layer.msg(data.msg, {icon: 2});
                                 }
                                 $("#tab_deviceBroadcast").bootstrapTable('refresh');
                             }
                         });
                    }
                }

            }, function () {
            })
        }
    });

    function confirm(value) {
        let fVolumeControl = $(value + " " + "input[name='fVolumeControl']").val();
        let boradcastto = $(value).find(".dropdown-menu.inner.selectpicker").find(".selected");
        let flag = true;
        let re = /^(?:[1-9]?\d|100)$/;
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
             		 
             		 layer.tips('存在字'+ '\"' +data + '\"', $(dom), {
                          tips: [2, 'red'],
                          tipsMore: true
                      });
             		flag = false;
             	 }
                  
              }
         }); 
    	
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

    $('body').on('hidden.bs.modal', '.modal', function () {
        $('.modal input').val("");
        $(".selectpicker.show-tick.form-control").selectpicker('refresh');
        $('.selectpicker').selectpicker('deselectAll');
        $('.modal input[name="fVolumeControl"]').val("100");
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"})
        $("#TTS").css("display", "none");
        $("select").find("option").eq(0).prop("selected",true);
        $("select[name='fProgramPass']").find("option").eq(0).prop("selected",true);
        $("#localAudio").css("display", "");

        Flag = 0;
        // refreshTree();
    });

    var columns = [[{
        checkbox: true,
        width: 20
    }, {
        field: 'fDeviceName',
        title: '设备名称',
        align: 'center',
        width: "10%",
    }, {
        field: 'fDeviceCode',
        title: '资源编码',
        align: 'center',
        width: "15%",
    }, {
        field: 'fId',
        title: '广播ID',
        align: 'center',
        width: "5%",
    }, {
        field: 'fBroadcastType',
        title: '广播类型',
        align: 'center',
        width: "8%",
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
        }
        }
    }, {
        field: 'fRealMessageType',
        title: '消息类型',
        align: 'center',
        width: "8%",
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
        width: "7%",
    },
        {
            field: 'fState',
            title: '状态',
            align: 'center',
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
        }/*,
        {
            title: '操作',
            align: 'center',
            width: '15%',
            width: 100,
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
                    $('#fRealProgramPass').text(data.fRealProgramPass);
                    $("#feffectiveTime").text(new Date(data.fEffectiveTime).format('yyyy-MM-dd HH:mm:ss'));
                    $('#infoModal').modal();
                }
            },
            formatter: function () {
                return '<button class="btn btn-info btn-sm edit-base-btn">详情</button>';
            },

        }*/]];


    function deviceBroadZtree(treeId, nodes) {
        var setting = {
            view: {
                showIcon: false
            },
            check: {
                enable: true,
                chkboxType: {"Y": "s", "N": "ps"}
                /* "Y": "s"  选中时会影响son,
                 * "N": "ps" 取消时会影响parent和son */
            },
            data: {
                simpleData: {
                    enable: true,//使用简单json数据构造ztree节点
                }
            },
            callback: {
                onCheck: function (event, treeId, treeNode) {
                    $("select[name='fDeviceResourcecode']").find("option").remove();
                    $(".selectpicker.show-tick.form-control").selectpicker('refresh');
                    var parentNode = treeNode.getParentNode();
                    var treeObj = $.fn.zTree.getZTreeObj(treeId);
                    var nodes = treeObj.getCheckedNodes(true);
                    for (var i = 0; i < nodes.length; i++) {
                        // alert("节点id:"+nodes[i].id+"节点名称"+nodes[i].name); //获取选中节点的值
                        <c:forEach items="${devMap}" var="mymap" >
                        if (${mymap.value.get("location")}==nodes[i].id){
                            var text = "${mymap.value.get("name")}";
                            var id = "${mymap.key}";
                            $("select[name='fDeviceResourcecode']").append("<option value=" + id + ">" + text + "</option>");
                            $(".selectpicker.show-tick.form-control").selectpicker('refresh');
                        }
                        </c:forEach>
                    }

                    if (treeNode.getCheckStatus().checked) {
                        if (parentNode && 2 === parentNode.check_Child_State) {
                        }
                    } else {
                        if (parentNode) {
                            treeObj.checkNode(parentNode, false, false, true);
                        }
                    }
                }
            }
        }, treeId;

        $.fn.zTree.destroy(treeId);
        $.fn.zTree.init($("#" + treeId), setting, nodes);
        $.fn.zTree.getZTreeObj(treeId).expandAll(true);//全部展开
    }

    function updateform() {
        Flag = 1;
        var checked = $('#tab_deviceBroadcast').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg("请选择要修改的记录", {icon: 2});
        } else if (checked.length > 1) {
            layer.msg("一次只能修改一条记录", {icon: 2});
        } else {
            let value = checked[0].fState;
            if (value == 2) {
                layer.msg("该记录待播发,无法修改", {icon: 2});
            } else if (value == 3) {
                layer.msg("该记录正在播发,无法修改", {icon: 2});
            } else if (value == 4) {
                layer.msg("该记录已播发,无法修改", {icon: 2});
            } else {
                showcontent(checked[0]);
                $(".modal h4").text("修改");
                $(".modal").modal();
                var update_fId = checked[0].fId;
                $("#confirm").on("click", function () {
                    if (Flag == 1) {
                        layer.confirm('是否确定修改该记录？', {
                            title: ["操作提示"],
                            icon: 3,
                            btn: ['确定', '取消']
                            //按钮
                        }, function () {
                            let type = $("select[name='fBroadcastType']").find("option:selected").attr("value");
                           // alert(type);
                            $(".modal").modal("hide");
                            if (type != 4) {
                                $.ajax({
                                    url: "${ctx}/broadcast/drill/updateBroadCast?fId=" + update_fId,
                                    type: 'post',
                                    data: new FormData($("#roleForm")[0]),
                                    contentType: false,
                                    async: false,
                                    processData: false,
                                    success: function (data) {
                                        layer.msg(data.msg, {
                                            icon: 1
                                        });
                                        $("#tab_deviceBroadcast").bootstrapTable('refresh');
                                    }
                                });
                            }else{
                                $.ajax({
                                    url: "${ctx}/broadcast/emergency/update/resourceId?fId=" + update_fId,
                                    type: 'post',
                                    data: new FormData($("#roleForm")[0]),
                                    contentType: false,
                                    async: false,
                                    processData: false,
                                    success: function (data) {
                                        layer.msg(data.msg, {
                                            icon: 1
                                        });
                                        $("#tab_deviceBroadcast").bootstrapTable('refresh');
                                    }
                                });
                            }

                        }, function () {
                        })
                    }
                })
            }

        }
    }

    function showcontent(value) {
        var name = value.fRealArea;
        $(".modal select[name='fProgramPass']").attr("value", value.fProgramPass).val(value.fProgramPass);
        $(".modal select[name='fRealControlDevice']").attr("value", value.fRealControlDevice).val(value.fRealControlDevice);
        $(".modal select[name='fMessageLevel']").attr("value", value.fMessageLevel).val(value.fMessageLevel);
        $(".modal input[name='fVolumeControl']").val(value.fVolumeControl);
        $(".modal input[name='EffectiveTime']").val(new Date(value.fEffectiveTime).format('yyyy-MM-dd HH:mm:ss'));
        var number = $(".modal select[name='fProgramPass']").find("option:selected").attr("number");
        if (number==00){
            $("#localAudio").css("display","");
        } else {
            $("#localAudio").css("display","none");
        }


    }
    function deleteform() {
        var checked = $('#tab_deviceBroadcast').bootstrapTable('getSelections');
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
                        layer.msg(data.msg, {icon: 1});
                        $("#tab_deviceBroadcast").bootstrapTable('refresh');
                    }
                })
            }, function () {
            })

        }
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
