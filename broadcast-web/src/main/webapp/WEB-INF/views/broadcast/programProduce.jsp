<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("ctx", request.getContextPath());
    DictionaryConfig.getMap(request);
    request.setAttribute("map", DictionaryConfig.getAllMap());
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>节目制作</title>
    <%@include file="../common/css.jsp" %>
    <style>
        .form-group {
            padding-right: 1% !important;
        }

        .modal-dialog {
            width: 70%;
            height: 80%;
        }

        table {
            table-layout: fixed;
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        select {
            color: #FFFFFF !important;
        }

        #update_programProduce_modal, #add_programProduce_modal .form-group {
            margin: 3% 0;
        }
    </style>

</head>

<body>
<h4><b>当前位置:制作播发>>节目制作</b></h4>
<div>
    <div class="content_table">
        <div class="handle">
            <button class="btn btn-info" data-toggle="modal" data-target="#add_programProduce_modal">新增</button>
            <button id="update_btn" class="btn btn-info">修改</button>
            <button id="delete_btn" class="btn btn-danger">删除</button>
        </div>

        <!-- <table id="tab_programProduce" class="table table-hover"></table> -->
        <table id="tab_programProduce" data-height="450" class="table table-hover"/>
    </div>
</div>

<!-- 详情模态框（Modal） -->
<div class="modal fade" id="programProduce_modal" tabindex="-1" role="dialog"
     aria-hidden="true">
    <div class="modal-dialog" style="width: 65%;overflow-y: scroll;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title">详情</h4>
            </div>
            <div class="modal-body" style="padding: 15px">
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label ">节目名称:</label>
                    <div class="col-sm-8">
                        <span name="fPassName"></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label ">控制设备:</label>
                    <div class="col-sm-8">
                        <span name="fControlDeviceValue"></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备通道:</label>
                    <div class="col-sm-8">
                        <span id="#fPassType" name="fPassTypeValue"></span>
                    </div>
                </div>



                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">流媒体类型:</label>
                    <div class="col-sm-8">
                        <span name="fMediaType"></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">创建者:</label>
                    <div class="col-sm-8">
                        <span name="fCreatorId"></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">创建时间:</label>
                    <div class="col-sm-8">
                        <span name="fCreateTime"></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">操作者:</label>
                    <div class="col-sm-8">
                        <span name="fOperatorId"></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">修改时间:</label>
                    <div class="col-sm-8">
                        <span name="fUpdateTime"></span>
                    </div>
                </div>
                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label">音频文件:</label>
                    <div class="col-sm-8">
                        <span name="fMediaUrl"></span>
                    </div>
                </div>

                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label">播发区域:</label>
                    <div class="col-sm-8">
                        <span name="fBroadcastArea"></span>
                    </div>
                </div>
            </div>
            <div class="null"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 修改模态框（Modal） -->
<div class="modal fade" id="update_programProduce_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">修改</h4>
            </div>
            <form id="update_form" onsubmit="return true" method="post">
                <div class="modal-body col-sm-12 " style="padding: 20px">
                    <div class="modal-body-left col-sm-9">
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">节目名称</label>
                            <div class="col-sm-7">
                                <input type="text" id="update_pfPassName" class="form-control" name="fPassName"
                                       maxlength="6" onblur="passNameChange1()">
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">控制设备</label>
                            <div class="col-sm-7">
                                <select name="fControlDevice" class="form-control">
                                    <option selected value="" disabled>请选择</option>
                                    <c:forEach items="${deviceInfos}" var="deviceInfos">
                                        <option value="${deviceInfos.fId}">
                                                ${deviceInfos.fDeviceName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">设备通道</label>
                            <div class="col-sm-7">
                                <select class="form-control" name="fPassType">
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">流媒体类型</label>
                            <div class="col-sm-7">
                                <select class="form-control" name="fMediaType">
                                    <c:forEach items="${medaiTypeList}" var="medaiType">
                                        <option value="${medaiType.fId}">
                                                ${medaiType.fDictionaryContent}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">音频文件</label>
                            <div class="col-sm-7">
                                <select id="aaa" name="fMediaUrl" class="form-control">
                                    <c:forEach items="${audioList}" var="audio">
                                        <option value="${audio.fAudioUrl}" data="${audio.fAudioName}">
                                                ${audio.fAudioName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="modal-body-right col-sm-3" style="padding: 5px">
                        <label>播发区域</label>
                        <div class="right-tree" style="height:230px">
                            <ul id="ztree2" class="ztree"></ul>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button id="succUpdate_button" type="button" class="btn btn-info">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 新增模态框（Modal） -->
<div class="modal fade" id="add_programProduce_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">新增</h4>
            </div>
            <form id="add_form" onsubmit="return true" method="post">
                <div class="modal-body col-sm-12" style="padding: 20px">
                    <div class="modal-body-left col-sm-9">
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">节目名称</label>
                            <div class="col-sm-7">
                                <input type="text" id="add_fPassName" class="form-control" name="fPassName"
                                       maxlength="6" onblur="passNameChange()">
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">控制设备</label>
                            <div class="col-sm-7">
                                <select name="fControlDevice" class="form-control">
                                    <option selected value="" disabled>请选择</option>
                                    <c:forEach items="${deviceInfos}" var="deviceInfos">
                                        <option value="${deviceInfos.fId}">
                                                ${deviceInfos.fDeviceName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">设备通道</label>
                            <div class="col-sm-7">
                                <select class="form-control" name="fPassType">
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">流媒体类型</label>
                            <div class="col-sm-7">
                                <select class="form-control" name="fMediaType">
                                    <c:forEach items="${medaiTypeList}" var="medaiType">
                                        <option value="${medaiType.fId}">
                                                ${medaiType.fDictionaryContent}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">音频文件</label>
                            <div class="col-sm-7">
                                <select name="fMediaUrl" class="form-control">
                                    <c:forEach items="${audioList}" var="audio">
                                        <option value="${audio.fAudioUrl}">
                                                ${audio.fAudioName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div id="TTS" class="form-group  col-sm-12" style="margin: 0 0 0 14px;display: none">
                            <div col-sm-3>
								<textarea name="" id="text_for_video" class="col-sm-12 form-control"
                                          style="width:80%;height: 60px; resize: none;"
                                          placeholder="请输入需要转换的文字"></textarea>
                            </div>

                            <button id="btn_tts" type="button" class="btn btn-info" style="margin:25px 10px 10px 25px">试听
                            </button>
                            <audio id="tts_audio" style="display: none" controls autoplay>
                                <source id="tts_source" type="audio/mpeg"
                                        src="http://tts.baidu.com/text2audio/text2audio?lan=zh&amp;ie=UTF-8&amp;spd=5&amp;text=">
                            </audio>
                        </div>
                    </div>

                    <div class="modal-body-right col-sm-3" style="padding: 5px;">
                        <label>播发区域</label>
                        <div class="right-tree" style="height:230px">
                            <ul id="ztree1" class="ztree"></ul>
                        </div>

                    </div>
 
                </div>
                <div class="modal-footer">
                    <button id="add_button" type="button" class="btn btn-info">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>


<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    var add_flag = 0;
    var update_flag = 0;
    var flag = 1;  //验证验证码
    var flag1 = 1;  //验证是否有空字段，
    var jsonMap = JSON.parse('${dictionary}');

    function Trim(str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }

    var columns = [
        [{
            checkbox: true
        }/*, {
            field: 'fPcrpId',
            title: 'pid',
            align: 'center',
        }*/, {
            field: 'fPassName',
            title: '节目名称',
            align: 'center',
            width: "10%",
        }, {
            field: 'fControlDeviceValue',
            title: '控制设备',
            align: 'center',
            width: "13%",
        }, {
            field: 'fPassTypeValue',
            title: '设备通道',
            align: 'center',
            width: "25%",
        }, {
            field: 'fBroadcastArea',
            title: '播发区域',
            align: 'center',
            width: "13%",
            formatter: function (data, row, index) {
                var values = data;
                var span = document.createElement('span');
                span.setAttribute('title', values);
                span.innerHTML = data;
                return span.outerHTML;
            },
        }, {
            field: 'fUpdateTime',
            title: '操作时间',
            align: 'center',
            sortable: true,
            width: "15%",
            formatter: function (time) {
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            }
        }, {
            field: 'operator',
            title: '操作者',
            align: 'center',
            width: "8%",

        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .edit-btn': function (e, val, row) {
                    dataShow2(row);
                    $('#programProduce_modal').modal('show');
                }
            },
            formatter: function () {

                return '<button class="btn btn-info btn-sm edit-btn">详情</button> '
            }
        }
        ]
    ];

    $(function () {

        $('#tab_programProduce').bootstrapTable({
            url: "${ctx}/broadcast/programProduce/list",
            method: 'get',
            search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            toolbar: '#toolbarComputer', // 工具按钮用哪个容器
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: true, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            clickToSelect: true,
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
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            }


        });

        var regionData = ${regionList};
        loadRegionTree("ztree1", regionData);
        loadRegionTree("ztree2", regionData);

    });


    $(".modal select[name='fControlDevice']").change(function () {
        $("select[name='fPassType']").find("option").remove();
        let deviceId = $(this).find("option:selected").attr("value");
        let list = new Array(100);
        $.getJSON('${ctx}/broadcast/drill/selectDeviceChannel?deviceId=' + deviceId, function (result) {
            let data = result.data;
            let fChannelContent = data.fChannelContent;
            list = fChannelContent.split(",");
            <c:forEach items="${map}" var="maplist">
            var indexvalue =${maplist.key};
            if (list.indexOf(indexvalue.toString()) > -1) {
                $(".modal select[name='fPassType']").append("<option value='${maplist.key}'>${maplist.value}</option>");
            }
            </c:forEach>
        })
    });

    //新增操作
    $("#add_button").click(function () {
        submmitCheck("#add_form", "ztree1");
        if (add_flag == 0 || flag1 == 0 || flag == 0)
            return;
        var data = "";
        var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
        $.each(nodes, function (i, item) {
            data = data + item.id;
            if (i < nodes.length - 1) {
                data = data + ',';
            }
        });
        layer.load(2);
        $.post('', $('#add_form').serialize() + '&areaIds=' + data, function (result) {
            if (result.status === 200) {
                $('#add_programProduce_modal').modal('hide');
                $('#tab_programProduce').bootstrapTable('refresh');
                document.getElementById('add_form').reset();
            }
            layer.msg(result.msg, {icon: 1});
            layer.closeAll('loading');
        });
    });

    //删除操作
    $("#delete_btn").click(function () {

        var checked = $('#tab_programProduce').bootstrapTable('getSelections');
        var del_ids = "";
        if (checked.length == 0) {
            layer.msg('请选择要删除的记录', {icon: 2});
        } else {

            layer.confirm('确认删除' + checked.length + "条记录?", {icon: 3, title: '操作提示'}, function (index) {
                for (i = 0; i < checked.length; i++) {
                    del_ids += checked[i].fId + ",";
                }
                layer.load(2);
                $.post('', '_method=delete&ids=' + del_ids, function (result) {
                    if (result.status === 200) {
                        $('#tab_programProduce').bootstrapTable('refresh');
                    }
                    layer.msg(result.msg, {icon: 1});
                    layer.closeAll('loading');
                });
            });
        }
    })
    var cnt = 0;
    //更新操作
    $("#update_btn").click(function () {
        update_flag = 1;

        var checked = $('#tab_programProduce').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg('请选择要修改的记录', {icon: 2});
        } else if (checked.length > 1) {
            layer.msg('只能选择一个记录', {icon: 2});
        } else {
            dataShow(checked[0]);
            $('#update_programProduce_modal').modal('show');
        }
    })

    $("#succUpdate_button").click(function () {
        var checked = $('#tab_programProduce').bootstrapTable('getSelections');
        submmitCheck("#update_form", "ztree2");
        if (flag == 0) {
            return false;
        }
        if (update_flag == 0 || flag1 == 0) {
            return;
        }
        layer.load(2);
        var data = "";
        var nodes = $.fn.zTree.getZTreeObj("ztree2").getCheckedNodes(true);
        $.each(nodes, function (i, item) {
            data = data + item.id;
            if (i < nodes.length - 1) {
                data = data + ',';
            }
        });

        $.post('${ctx}/broadcast/programProduce/updateById?fId=' + checked[0].fId, $('#update_form').serialize() + '&areaIds=' + data, function (result) {
            if (result.status === 200) {
                $('#update_programProduce_modal').modal('hide');
                $('#tab_programProduce').bootstrapTable('refresh');
                update_flag = 0;
            }
            layer.msg(result.msg, {icon: 1});
            layer.closeAll('loading');
        });
    });

    //数据回显
    function dataShow(checked) {
        var name = checked.fBroadcastArea + "";
        var zTree_Menu = $.fn.zTree.getZTreeObj("ztree2");
        var nodes = zTree_Menu.transformToArray(zTree_Menu.getNodes());
        console.log(nodes);
        if (nodes.length > 0) {
            for (var i = 0; i < nodes.length; i++) {
                if (name.indexOf(nodes[i].name) >= 0) {
                    nodes[i].checked = true;
                    zTree_Menu.updateNode(nodes[i]);
                }
            }
        }


        $.each(checked, function (key, value) {
            $("#update_programProduce_modal input[name='" + key + "']").val(value);
            $("#update_programProduce_modal select[name='" + key + "']").val(value);
        });
        $("#update_programProduce_modal select[name='fControlDevice']").val(checked.fControlDeviceKey);
        $("#update_programProduce_modal select[name='fPassType']").val(checked.fPassTypeKey);
        $("#update_programProduce_modal select[name='fMediaUrl']").val(checked.urlValue);

    }

    //数据回显
    function dataShow2(checked) {
        $.each(checked, function (key, value) {
            if (key!='fUpdateTime' && key != 'fOperatorId') {
                $("#programProduce_modal span[name='" + key + "']").text(value?value:"");
            }
            if (key == 'fMediaType') {
                $("#programProduce_modal span[name='" + key + "']").text(jsonMap[value]?jsonMap[value]:"");
            }
        });
        $("#programProduce_modal span[name='fCreatorId']").text(checked.creator);
        $("#programProduce_modal span[name='fCreateTime']").text(new Date(checked.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
        if (checked.fCreateTime != checked.fUpdateTime) {
            $("#programProduce_modal span[name='fOperatorId']").text(checked.operator);
            $("#programProduce_modal span[name='fUpdateTime']").text(new Date(checked.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'));
        }

    }

    function submmitCheck(str, tree) {
        flag1 = 1;
        flag = true;
        var t = $(str).serializeArray();
        $.each(t, function (i, item) {
            if (item['value'] == '' && (item.name == 'fPassName' || item.name == 'fServiceId' || item.name == 'fPcrpId' || item.name == 'fOutputAddress' || item.name == 'fRdsOutput' || item.name == 'fOutputPort' || item.name == 'fModulation' || item.name == 'fPassNumber')) {

                layer.msg('请确认信息已填完整', {icon: 2,time:1000});
                flag1 = 0;

                $("input[name=" + item.name + "]").css({
                    'border': '1px solid red'
                });
            }
            var treeObj = $.fn.zTree.getZTreeObj(tree);
            var nodes = treeObj.getCheckedNodes(true);
            if (nodes.length == 0) {
                flag = false;
                /*layer.tips('请选择播发区域!', "#" + tree, {
                    tips: [1, 'red'],
                    tipsMore: true
                })*/
                layer.msg('请选择播发区域', {icon: 2,time:1000});
            }
        });
        
        var update_pfPassName = $("#update_pfPassName").val();
        var add_fPassName = $("#add_fPassName").val();
        if(update_pfPassName != "" && update_pfPassName != null){        
	    	$.ajax({
	          	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
	               type: 'post',
	               async: false,
	               data: {
	              	 "input":update_pfPassName,
	               },
	               success: function (data) {
	              	 
	              	 if(data.length != 0){
	              		 
	              		 layer.tips('存在敏感字'+ '\"' +data + '\"', $("#update_pfPassName"), {
	                           tips: [2, 'red'],
	                           tipsMore: true
	                       });
	                       flag = false;
	              	 }	   	                   
	               }
	          });   
        }else if(add_fPassName != "" && add_fPassName != null){
        	$.ajax({
	          	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
	               type: 'post',
	               async: false,
	               data: {
	              	 "input":add_fPassName,
	               },
	               success: function (data) {
	              	 
	              	 if(data.length != 0){
	              		 
	              		 layer.tips('存在敏感字'+ '\"' +data + '\"', $("#add_fPassName"), {
	                           tips: [2, 'red'],
	                           tipsMore: true
	                       });
	                       flag = false;
	              	 }	   	                   
	               }
	          });  
        }
        if (flag1 == 0)
            return false;
    }

    $('input').on("focus", function () {
        $(this).css("border", "1px solid #eceeef");
    })

    $('body').on('hidden.bs.modal', '.modal', function () {
        document.getElementById("add_form").reset();
        document.getElementById("update_form").reset();
        $('.modal input').css("border", "1px solid #eceeef");
        $("#tab_programProduce input[checked='checked']").attr("checked", "false");
        $.fn.zTree.getZTreeObj("ztree1").checkAllNodes(false);
        $.fn.zTree.getZTreeObj("ztree2").checkAllNodes(false);
        $("#programProduce_modal span").text("");
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"});
        $("select[name='fPassType']").find("option").remove();
    });

    function passNameChange() {
        var name = document.getElementById("add_fPassName").value;
        $.post('${ctx}/broadcast/programProduce/check', {name: name}, function (result) {
            if (result.data == "true") {
                add_flag = 0;
                layer.tips('该节目名称已存在',
                    '#add_fPassName', {
                        tips: [2, 'red'],
                        tipsMore: true
                    }
                );
            } else {
                add_flag = 1;
            }
        })

    }

    function passNameChange1() {
        var name = document.getElementById("update_pfPassName").value;
        $.post('${ctx}/broadcast/programProduce/check', {name: name}, function (result) {
            if (result.data == "true") {
                update_flag = 0;
                layer.tips('该节目名称已存在',
                    '#update_pfPassName', {
                        tips: [2, 'red'],
                        tipsMore: true
                    }
                );
            } else {
                update_flag = 1;
            }
        })

    }

    $("select").change(function () {
        var text = $(this).find("option:selected").attr("value");
        $(this).attr("value", text);
    });
    $(".modal-dialog").draggable();
</script>
</body>

</html>