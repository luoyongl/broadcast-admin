<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
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
<html>
<head>
    <meta charset="UTF-8">
    <title>应急广播</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .modal-content {
            background: rgba(30, 160, 248, 1);
            color: #FFFFFF;
        }

        #details_daily_broadcast_modal .modal-dialog {
            overflow-y: scroll;
        }

        .content_table {
            height: 92%;
        }

        .modal select {
            width: 60% !important;
        }

        .btn.dropdown-toggle.btn-default {
            background: none;
        }

        .page-size {
            color: white;
        }

        /*element.style {
            max-height: 60%!important;
            overflow: hidden;
            min-height: 80px;
        }*/

        .bootstrap-select.form-control:not([class*="span"]) {
            width: 60% !important;
        }

        .bootstrap-select.form-control {
            background: none !important;
        }

        .bootstrap-select > .btn {
            width: 100%;
            background: none !important;
        }

        .filter-option {
            color: white;
        }

        .caret {
            color: white;
        }

        .increaseDailyBroadcastInfo {
            border-bottom: 1.2px solid #4682B4 !important;
        }

        table {
            table-layout: fixed;
        }

        #tab_daily tbody tr td {
            width: 150px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
		.col-xs-12 {
			padding-left: 0;
			padding-right: 0;
		}
        
		/* 移动端样式 */
    	 @media screen and (max-width: 480px) {
    		body {
    			font-size: 12px!important;
    		}
    		h4 {
    			display: none;
    		}
    	 	.content_table {
			    height: auto!important;
			}
			.content_table td {
			    line-height: 30px!important;
			}
    	 	#modifyBroadcastBtn {
    	 		display: none;
    	 	}
    	 	.search {
    	 		display: none;
    	 	}
    	 	.fixed-table-toolbar .columns {
    	 		display: none;
    	 	}
    	 	.fixed-table-container {
    	 		width: auto!important;
    	 		height: auto!important;
			    padding-bottom: 10px!important;
    	 	}
    	 	.table {
    	 		width: auto!important;
    	 	}
    	 	
    	 	
    	 	#add_daily_broadcast_modal .content_left {
    	 		width: 100%;
    	 	}
    	 	#add_daily_broadcast_modal .content_right {
    	 		width: 80%;
    	 		padding-left: 10px;
    	 		padding-top: 10px;
    	 	}
    	 	#add_daily_broadcast_modal #TTS {
    	 		height: 50px;
    	 	}
    	 	#add_daily_broadcast_modal .form-group {
    	 		padding-left: 0px;
    	 		margin: 8px 0;
    	 	}
    	 	#add_daily_broadcast_modal .form-group label {
    	 		width: 78px;
    	 	}
    	 	#add_daily_broadcast_modal .form-group textarea {
    	 		float: left;
    	 		margin-left: 10px;
    	 	}
    	 	#add_daily_broadcast_modal .form-group button {
    	 		float: left;
    	 	}
    	 	#add_daily_broadcast_modal .form-group .form-control {
    	 		width: 60% !important;
    	 		display: inline-block;
    	 	}
    	 	#add_daily_broadcast_modal .form-group .control-label {
    	 		display: inline-block;
    	 	}
    	 	
    	 	#details_daily_broadcast_modal .form-group div {
    	 		display: inline-block;
    	 	}
    	 }
    </style>
</head>

<body>
<h4><b>当前位置:制作播发>>应急广播</b></h4>
<div class="content_table">
    <div class="handle">
        <button id="addBroadcastInfo" class="btn btn-info" data-toggle="modal" data-target="add_daily_broadcast_modal">
            新增
        </button>
        <button class="btn btn-info" id="modifyBroadcastBtn">修改</button>
        <button class="btn btn-danger" id="cancelBroadcastBtn">取消</button>
    </div>
    <table data-height="450" id="tab_daily" class="table table-hover"></table>
</div>

<!-- 添加模态框（Modal） -->
<div class="modal fade" id="add_daily_broadcast_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header increaseDailyBroadcastInfo">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="title">新增</h4>
            </div>
            <div class="modal-body col-sm-12">
                <div class="content col-sm-12">
                    <div class="content_left col-sm-8 col-xs-12">
                        <form class="form_broadcast  form-inline addDailyBroadCast">

                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">节目通道</label>
                                <select class="form-control" data-validate="required" id="bb" name="fProgramPass"
                                        style="width:60% !important">
                                    <c:forEach items="${channelList}" var="channel">
                                        <option type="base" value="${channel.fId}" number="${channel.fThirdCode}">${channel.fDictionaryContent}
                                        </option>
                                    </c:forEach>
                                    <c:forEach items="${programList}" var="program">
                                        <option region="${program.fBroadcastArea}" type="extra"
                                                value="${program.fId}">${program.fPassName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">控制设备</label>
                                <select class="form-control" data-validate="required" id="b" name="fControlDevice"
                                        style="width:60% !important">
                                    <option selected value="" disabled>请选择</option>
                                    <c:forEach items="${deviceInfos}" var="deviceInfo">
                                        <option value="${deviceInfo.fId}">
                                                ${deviceInfo.fDeviceName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">设备通道</label>
                                <select class="col-sm-8 form-control" name="fPassSelect">

                                </select>
                            </div>

                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">音量控制</label>
                                <input type="text" style="width:60%;opacity: 0.5" value="100" readonly="readonly"
                                       name="fVolumeControl" class="form-control fVolumeControl"/>
                            </div>

                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">消息类型</label>
                                <select class="form-control" style="width:60% !important" data-validate="required"
                                        id="aa" name="fMessageType">
                                    <c:forEach items="${messageList}" var="messageType">
                                        <option value="${messageType.fId}">
                                                ${messageType.fDictionaryContent}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">消息级别</label>
                                <select class="form-control" style="width:60% !important" data-validate="required"
                                        id="aa" name="fMessageLevel">
                                    <c:forEach items="${messageGradeList}" var="messageGrade">
                                        <option value="${messageGrade.fId}">
                                                ${messageGrade.fDictionaryContent}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">有效期限</label>
                                <input name="EffectiveTime" type="text" style="width:60%;"
                                       class="jeinput form-control">
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3">播发方式</label>
                                <select class="form-control" style="width:60% !important" data-validate="required"
                                         name="fBroadcastStyle">
                                        <option value="true">
                                                	单播
                                        </option>
                                        <option value="false">
                                                	组播
                                        </option>
                                </select>
                            </div>
                            
                           <%--  <div class="form-group pass col-sm-12">
                                <label class="col-sm-3">播发去向(可多选)</label>
                                <select name="fBroadcastTo" style="color:white" class="selectpicker form-control"
                                        title="请选择" multiple data-max-options="2" style="width:60% !important"
                                        data-validate="required">
                                    <c:forEach items="${broadcastDestinateList}" var="broadcastDestinate">
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
                    <div class="content_right col-xs-12">
                        <label>播发区域</label>
                        <div class="right-tree" style="height:300px">
                            <ul id="ztree1" class="ztree"></ul>
                        </div>
                    </div>
                    <div class="null"></div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="form-group" style="width: 100%">
                    <div class="btn_modal show">
                        <button id="hhhhhhh" type="button" class="beginBroadcastBtn btn btn-danger">开播</button>
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
<div class="modal fade" id="details_daily_broadcast_modal" tabindex="-1" role="dialog" aria-hidden="true">
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
                            <span id="fBroadcastType">应急广播</span>
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
                            <span id="fRealControlDevice"></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">音量控制:</label>
                        <div class="col-sm-8">
                            <span id="fVolumeControl2"></span>
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
<script type="text/javascript">
    var daily_data;
    var flag = 0;
    var chencked1;
    var loadingFlag;
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
        nextdate();
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
            if ($choose == "00"){
                $("#localAudio").css("display", "")
            } else {
                $("#localAudio").css("display", "none");
            }

            if ($choose != "01"){
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
                zTree.selectNode(Node, true);
                zTree.updateNode(Node);
            }


            //$("select[name='fControlDevice']").val("");
            //$("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true");
            $("select[name='fPassSelect']").find("option").remove();
        }
    });
  /*   $("select[name='fControlDevice']").change(function () {
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

    function paramsMatter(value, row, index) {
        var values = row.params;//获取当前字段的值
        //替换空格，因为字符串拼接的时候如果遇到空格，会自动将后面的部分截掉，所有这里用html的转义符
        //&nbsp;代替
        values = values.replace(/\s+/g, '&nbsp;')
        return "<span title=" + values + ">" + row.params + "</span>"
    }

    $("#modifyBroadcastBtn").on("click", function () {
        chencked1 = $("#tab_daily").bootstrapTable('getSelections');
        if (chencked1.length > 1) {
            //layer.alert('一次只能选择一项进行修改!', {title:"操作提示",icon: 2});
            layer.msg("一次只能选择一项进行修改", {icon: 2});
            return false;
        } else if (chencked1.length <= 0) {
            //layer.alert('请先选择要修改的记录!', {title:"操作提示",icon: 2});
            layer.msg("请选择要修改的记录", {icon: 2});
            return false;
        } else {
            let value = chencked1[0].fState;
            if (value == 2) {
                layer.msg("该记录待播发,无法修改", {icon: 2});
            } else if (value == 3) {
                layer.msg("该记录正在播发,无法修改", {icon: 2});
            } else if (value == 4) {
                layer.msg("该记录已播发,无法修改", {icon: 2});
            } else {
                showcontent(chencked1[0]);
                flag = 1;
                $('#title').html('修改');
                $('.beginBroadcastBtn').text('确定');
                $('#add_daily_broadcast_modal').modal('show');
            }

        }
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
        $(".modal input[name='fVolumeControl']").val(value.fVolumeControl);
   /*      var $option = $(".modal select[name='fBroadcastTo']").find("option");
        var str = '';
        var fBroadcastTo = (value.fBroadcastTo);
        if (fBroadcastTo != null && fBroadcastTo != "") {
            for (var i = 0; i < $option.length; i++) {
                if ((fBroadcastTo.indexOf($option[i].value)) > -1) {
                    let va = Trim($(".modal select[name='fBroadcastTo']").find("option[value='" + $option[i].value + "']").text())
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

    $("#cancelBroadcastBtn").on("click", function () {
        var rows = $("#tab_daily").bootstrapTable('getSelections');
        if (rows.length <= 0) {
            layer.msg("请选择要取消的记录", {icon: 2});
            return false;
        } else {
            $.each(rows[0], function (key, value) {
            })
            layer.confirm('是否确定取消这' + rows.length + '记录？', {
                title: ['操作提示'],
                icon: 3,
                btn: ['确定', '取消'] //按钮
            }, function () {
                for (var i = 0; i < rows.length; i++) {
                    $.ajax({
                        async: false,
                        data: {
                            "fId": rows[i].fId,
                        },
                        url: "${ctx}/broadcast/emergency/delete",
                        type: "post",
                        success: function (data) {

                            $("#tab_daily").bootstrapTable('refresh');
                        }
                    })
                }

                layer.msg("取消了" + rows.length + "记录", {icon: 1});
                $("#tab_daily").bootstrapTable('refresh');
            }, function () {
            })
        }
    });

    $(".beginBroadcastBtn").on("click", function () {
    	
    	var sensitiveFlag = true;
    
    
    	
        if (flag == 0 && sensitiveFlag == true) {
            var fVolumeControl = $("#fVolumeControl").val();
            var f = confirm(".addDailyBroadCast");
            if (f) {
                layer.confirm('是否确定开播？', {
                    title: ['操作提示'],
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    $("#add_daily_broadcast_modal").modal("hide");
                    /* loading 加载开始 */
                    var index = layer.load(1);
                    var data = "";
                    var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
                    $.each(nodes, function (i, item) {
                        data = data + item.id;
                        if (i < nodes.length - 1) {
                            data = data + ',';
                        }
                    });
                    let resourceId = data;
                    $.ajax({
                        url: "${ctx}/broadcast/emergency/startPlay/" + resourceId,
                        type: 'post',
                        data: new FormData($(".form_broadcast")[0]),
                        contentType: false,
                        async: false,
                        processData: false,
                        success: function (data) {
                        	/* loading 加载结束 */
                        	layer.close(index);
                            layer.msg(data.msg, {
                            });
                            $("#tab_daily").bootstrapTable('refresh');
                            $("input[name='fVolumeControl']").val("").focus();
                        }
                    });
                }, function () {
                })
            }

        } else if (flag == 1 && sensitiveFlag == true) {
            var update_fId = chencked1[0].fId;
            var f = confirm(".addDailyBroadCast");
            if (f) {
                layer.confirm('是否确定修改？', {
                    title: ['操作提示'],
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    $("#add_daily_broadcast_modal").modal("hide");
                    var data = "";
                    var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
                    $.each(nodes, function (i, item) {
                        data = data + item.id;
                        if (i < nodes.length - 1) {
                            data = data + ',';
                        }
                    });
                    let resourceId=data;
                    $.ajax({
                        url: "${ctx}/broadcast/emergency/update/resourceId?fId=" + update_fId,
                        type: 'post',
                        data: new FormData($(".form_broadcast")[0]),
                        success: function (data) {
                            layer.msg(data.msg, {
                                icon: 1
                            });
                            $("#tab_daily").bootstrapTable('refresh');
                            $("input[name='fVolumeControl']").val("").focus();
                        }
                    });
                }, function () {
                })
            }
        }
    })

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
       /*  //判断播发去向是否为空
        if (boradcastto.length == 0) {
            flag = false;
            layer.tips('请选择播发去向', ".btn.selectpicker", {
                tips: [2, 'red'],
                tipsMore: true
            })
        } */
        
        let treeObj = $.fn.zTree.getZTreeObj("ztree1");
        // let nodes = treeObj.transformToArray(treeObj.getNodes());
        let nodes = treeObj.getCheckedNodes(true);
        if (nodes.length == 0) {
            flag = false;
            layer.tips('请选择播发区域!', '.ztree', {
                tips: [4, 'red'],
                tipsMore: true
            })
        }
        
        return flag;
    }

    $("#addBroadcastInfo").on("click", function () {
    	var stateCheck = broadcastServerStateCheck("${ctx}");
    	if(!stateCheck){
    		return;
    	}
       /*  $("select[name='fControlDevice']").val("");
        $("select[name='fControlDevice']").find("option").css("display", "none").eq(0).prop("selected", "true"); */
        $("select[name='fPassSelect']").find("option").remove();

        flag = 0;
        if (flag == 0) {
            $('#title').html('新增');
            $('.beginBroadcastBtn').text('开播');
        }
        $('#add_daily_broadcast_modal').modal('show');
    });

    //清除空格
    function Trim(str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }


    //重置ztree
    function refreshTree() {
        var regionData = ${regionList};
        loadRegionTree("ztree1", regionData);
    }

    function resetValue() {
        refreshTree();
        $('select').each(function (i, j) {
            $(j).find("option:selected").attr("selected", false);
            $(j).find("option").first().attr("selected", true);
            $("input[name='fVolumeControl']").val("");
            $('.modal input:checkbox').removeAttr('checked');
        })
    }

    var columns = [
        [{
            field: 'a',
            checkbox: true
        }, {
            field: 'fId',
            title: '广播ID',
            width: "5%",
            align: 'center',
        }, {
            field: 'fRealMessageType',
            title: '消息类型',
            width: "10%",
            align: 'center',
        }, {
            field: 'fRealMessageLevel',
            title: '消息级别',
            width: "10%",
            sortable: true,
            align: 'center',
        }, {
            field: 'fRealMessageSource',
            title: '消息来源',
            width: "13%",
            align: 'center',
        }, {
            field: 'fRealArea',
            title: '播发区域',
            align: 'center',
            width: "13%",
        }, {
            field: 'fEffectiveTime',
            title: '有效期限',
            width: "15%",
            align: 'center',
            sortable: true,
            formatter: function (time) {
                return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : "";
            },
        }, {
            field: 'creator',
            title: '操作者',
            align: 'center',
            width: "8%",
        }, {
            field: 'fState',
            title: '状态',
            sortable: true,
            align: 'center',
            width: "7%",
            formatter: function (value) {
                if (value == 0) {
                    return '<span class="label label-info">未开播</span>';
                } else if (value == 1) {
                    return '<span class="label label-warning">待审核</span>';
                } else if (value == 2) {
                    return '<span class="label label-success">待播发</span>';
                } else if (value == 3) {
                    return '<span class="label label-primary">正在播</span>';
                } else if (value == 4) {
                    return '<span class="label label-default">已播发</span>';
                } else if (value == 5) {
                    return '<span class="label label-danger">不通过</span>';
                } else if (value == 7) {
                    return '<span class="label label-default">已过期</span>';
                } else {
                    return '<span class="label label-warning">未知</span>';
                }

            }
        }, {
            title: '操作',
            align: 'center',

            events: {
                'click .edit-base-btn': function (e, val, row) {
                    for (var i = 0; i < daily_data.length; i++) {
                        if (daily_data[i].fId == row.fId) {
                            $('#fBroadcastArea').text(daily_data[i].fBroadcastArea);
                            $('#fRealArea').text(daily_data[i].fRealArea);
                            $('#fVolumeControl2').text(daily_data[i].fVolumeControl);

                            $('#fPassSelect').text(daily_data[i].fPassSelect);
                            $('#fCreateTime').text(new Date(daily_data[i].fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                            $('#fRealMessageType').text(daily_data[i].fRealMessageType);


                            if (daily_data[i].fRealControlDevice != null) {
                                $('#fRealControlDevice').text(daily_data[i].fRealControlDevice);
                            } else {
                                $('#fRealControlDevice').text("");
                            }

                            if (daily_data[i].fRealBroadcastTo != null) {
                                $('#fRealBroadcastTo').text(daily_data[i].fRealBroadcastTo);
                            } else {
                                $('#fRealBroadcastTo').text("");
                            }

                            if (daily_data[i].fRealMessageSource != null) {
                                $('#fRealMessageSource').text(daily_data[i].fRealMessageSource);
                            } else {
                                $('#fRealMessageSource').text("");
                            }

                            if (daily_data[i].fUpdtateTime != null) {
                                $('#fUpdtateTime').text(new Date(daily_data[i].fUpdtateTime).format('yyyy-MM-dd HH:mm:ss'));
                            } else {
                                $('#fUpdtateTime').text("");
                            }

                            if (daily_data[i].creator != null) {
                                $('#creator').text(daily_data[i].creator);
                            } else {
                                $('#creator').text("");
                            }

                            if (daily_data[i].operator != null) {
                                $('#operator').text(daily_data[i].operator);
                            } else {
                                $('#operator').text("");
                            }
                            if (daily_data[i].fControlDevice != null) {
                                $('#fControlDevice').text(daily_data[i].fControlDevice);
                            } else {
                                $('#fControlDevice').text("");
                            }

							var frealProgramPass = daily_data[i].fRealProgramPass;
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
                            $('#fRealMessageLevel').text(daily_data[i].fRealMessageLevel);
                            $("#feffectiveTime").text(new Date(daily_data[i].fEffectiveTime).format('yyyy-MM-dd HH:mm:ss'));
                            $('#details_daily_broadcast_modal').modal('show');
                        }
                    }

                    for (var i = 0; i < daily_data.length; i++) {
                        if (daily_data[i].fId == row.fId) {
                            if (daily_data[i].fState == 0) {
                                $('#fDetailState').text("未开播");
                            } else if (daily_data[i].fState == 1) {
                                $('#fDetailState').text("待审核");
                            } else if (daily_data[i].fState == 2) {
                                $('#fDetailState').text("待播发");
                            } else if (daily_data[i].fState == 3) {
                                $('#fDetailState').text("正在播");
                            } else if (daily_data[i].fState == 4) {
                                $('#fDetailState').text("已播发");
                            } else {
                                $('#fDetailState').text("未知");
                            }

                            if (daily_data[i].fBroadcastType == 1) {
                                $('#fBroadcastType').text("应急广播");
                            }
                        }
                    }
                },
            },

            formatter: function () {
                return '<button id="dailyBroadcastDetail" class="btn btn-info btn-sm edit-base-btn">详情</button>';
            },
        }]
    ];

    function ztreeHeight() {
        var width = $(".addDailyBroadCast").height();
        $(".selectpicker").selectpicker('refresh');
        $("#ztree1").css("height", width);
    }

    $(function () {
        $(".modal-dialog").draggable();
        $(".selectpicker").selectpicker('refresh');
        var regionData =${regionList};
        ztreeHeight();
        loadRegionTree("ztree1", regionData);
        $('#tab_daily').bootstrapTable('refresh');
        $('#tab_daily').bootstrapTable({
            method: 'get',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            url: "${ctx}/broadcast/emergency/list",
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
                daily_data = result.data.list;
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },
        });
    });

    $('body').on('hidden.bs.modal', '.modal', function () {
        $('.modal input').val("");
        $('.modal input[name="fVolumeControl"]').val("100");
        $('.selectpicker').selectpicker('deselectAll');
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"});
        $("#TTS").css("display", "none");
        $("select[name='fPassType']").find("option").remove();
        $("select").find("option").eq(0).prop("selected",true);
        $("#localAudio").css("display","");
        refreshTree();
    });
    $(".modal").on("click", ".show-tick", function () {
        $(".selectpicker").selectpicker('refresh');
    });

    $('#addBroadcastInfo').on('click', function () {
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


