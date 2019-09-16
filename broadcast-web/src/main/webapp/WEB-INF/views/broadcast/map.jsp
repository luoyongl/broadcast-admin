<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig,cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("dict", DictionaryConfig.getListMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
    request.setAttribute("map", DictionaryConfig.getAllMap());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>地图广播</title>
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
    </style>
</head>
<body>
<div id="container" class="map" style="width: 100%;height: 100%"></div>
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
                            <label class="col-sm-3 control-label">播发去向</label>
                            <div class="col-sm-9">
                                <select name="fBroadcastTo" title="请选择"
                                        class="selectpicker show-tick form-control" multiple data-live-search="false">
                                    <c:forEach items="${dict.get('broadcast_destinate')}" var="d">
                                        <option value="${d.fId}">${d.fDictionaryContent}</option>
                                    </c:forEach>
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
<script type="text/javascript"
        src="https://webapi.amap.com/maps?v=1.4.12&key=${config.amap_js_key}&plugin=AMap.DistrictSearch,AMap.MouseTool"></script>
<script type="text/javascript">
    $(function () {
        $(".modal-dialog").draggable();
        $(".selectpicker").selectpicker('refresh');
        var regionPoints = ${regionPoints}, pointIdArr = [];
        if (regionPoints.length > 0) {
            var county = ${county};
            var mapObj = {
                resizeEnable: false,
                center: [county.longitude, county.latitude],//地图中心点
                zoom: 10,
                mapStyle: "amap://styles/blue",
                //zoomEnable: true,
                doubleClickZoom: false,
                scrollWheel: true,
                //showLabel: false //不显示地图文字标记
            };
            var map = new AMap.Map("container", mapObj);
            map.plugin(["AMap.ToolBar"], function () {
                map.addControl(new AMap.ToolBar());
            });
            //绘制点
            $.each(regionPoints, function (index, point) {
                //经纬度错误直接跳过
                if (!point.longitude || !point.latitude || isNaN(point.longitude) || isNaN(point.latitude)) {
                    return true;
                }
                if (index === 0 && point.pId === 0) {
                    return true;
                }
                var marker = new AMap.Marker({
                    position: [point.longitude, point.latitude],
                    label: {
                        offset: new AMap.Pixel(15, -20),
                        content: "<div class='map_title'>" + point.name + "</div>"
                    }
                });
                map.add(marker);
            });
            //绘制边界
            var district = null;
            var polygons = [];
            //加载行政区划插件
            if (!district) {
                //实例化DistrictSearch
                var opts = {
                    subdistrict: 0,   //获取边界不需要返回下级行政区
                    extensions: 'all',  //返回行政区边界坐标组等具体信息
                    level: 'district'  //查询行政级别为 市
                };
                district = new AMap.DistrictSearch(opts);
            }
            //行政区查询
            district.search(county.name, function (status, result) {
                map.remove(polygons);//清除上次结果
                polygons = [];
                var bounds = result.districtList[0].boundaries;
                if (bounds) {
                    for (var i = 0, l = bounds.length; i < l; i++) {
                        //生成行政区划polygon
                        var polygon = new AMap.Polygon({
                            strokeWeight: 2,
                            path: bounds[i],
                            fillOpacity: 0,
                            fillColor: '#80d8ff',
                            strokeColor: '#0091ea',
                        });
                        polygons.push(polygon);
                    }
                }
                map.add(polygons);
                //map.setFitView(polygons);//视口自适应
            });
            //绘制矩形
            var mouseTool = new AMap.MouseTool(map);
            mouseTool.rectangle({
                fillColor: '#00b0ff',
                strokeColor: '#80d8ff'
            });
            mouseTool.on('draw', function (e) {
                map.remove(e.obj);
                var path = e.obj.getPath();//矩形的四个端点
                if (path[0]) {
                    if (!path[0].Q || (path[0].Q === path[1].Q && path[0].R === path[1].R)) {
                        return false;
                    }
                } else {
                    return false;
                }
                pointIdArr = [];
                var treeObj = $.fn.zTree.getZTreeObj(treeId);
                treeObj.checkAllNodes(false);
                $.each(regionPoints, function (index, point) {
                    //经纬度错误直接跳过
                    if (!point.longitude || !point.latitude || isNaN(point.longitude) || isNaN(point.latitude)) {
                        return true;
                    }
                    if (point.id !== county.id) {
                        if (e.obj.contains([point.longitude, point.latitude])) {
                            pointIdArr.push(point.id);
                            var checkNode = treeObj.getNodeByParam("id", point.id);
                            if (checkNode) {
                                treeObj.checkNode(checkNode, true, true, true);
                            }
                            treeObj.expandAll(true);
                        }
                    }
                });
                if (pointIdArr.length > 0) {
                	var stateCheck = broadcastServerStateCheck("${ctx}");
                	if(!stateCheck){
                		return;
                	}
                    $('#broadcastModal').modal();
                } else {
                    layer.msg('未选择任何区域');
                }
            });
        } else {
            layer.msg('没有行政区域数据', {
                time: 0
            });
        }
        /*  var treeSetting = {
                  view: {
                      showIcon: false
                  },
                  check: {
                      enable: true,
                      chkboxType: {"Y": "s", "N": "p"}
                  },
                  data: {
                      simpleData: {
                          enable: true
                      }
                  },
                  callback: {
                      onCheck: function (event, treeId, treeNode) {
                          var parentNode = treeNode.getParentNode();
                          var treeObj = $.fn.zTree.getZTreeObj(treeId);
                          if (treeNode.getCheckStatus().checked) {
                              if (parentNode && 2 === parentNode.check_Child_State) {
                                  treeObj.checkNode(parentNode, true, false, true);
                              }
                          } else {
                              if (parentNode) {
                                  treeObj.checkNode(parentNode, false, false, true);
                              }
                          }
                      }
                  }
              },
              treeId = 'ztree';
          $.fn.zTree.init($("#" + treeId), treeSetting, regionPoints);*/
        treeId = 'ztree';
        loadRegionTree(treeId, ${regionList});
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
                let resourceId = data;
                let type = $("select[name='fBroadcastType']").find("option:selected").attr("value");
                if (type == 4) {
                    $.ajax({
                        url: "${ctx}/broadcast/emergency/startPlay/" + resourceId,
                        type: 'post',
                        contentType: false,
                        async: false,
                        processData: false,
                        data: new FormData($("#roleForm")[0]),
                        success: function (data) {
                            layer.closeAll();
                            layer.msg(data.msg, {
                                icon: 1
                            });
                        }
                    });

                } else {
                    let formDate= new FormData($("#roleForm")[0]);
                    formDate.append("resourceId", data);
                    $.ajax({
                        url: "${ctx}/broadcast/drill/addBroadCast",
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
                        }
                    });
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
        //判断播发去向是否为空
        if (boradcastto.length == 0) {
            flag = false;
            layer.tips('请选择播发去向', ".btn.selectpicker", {
                tips: [2, 'red'],
                tipsMore: true
            })
        }
        let treeObj = $.fn.zTree.getZTreeObj("ztree");
        let nodes = treeObj.getCheckedNodes(true);
        if (nodes.length == 0) {
            flag = false;
            layer.tips('请选择播发区域!', '#ztree', {
                tips: [4, 'red'],
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
             		 
             		 layer.tips('存在敏感字'+ '\"' +data + '\"', $(dom), {
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
        $("#localAudio").css("display","");
        $("select").find("option").eq(0).prop("selected",true);
        $("select[name='fProgramPass']").find("option").eq(0).prop("selected",true);
        // refreshTree();
    });

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
