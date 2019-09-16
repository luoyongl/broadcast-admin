<%--
  Created by IntelliJ IDEA.
  User: AYY
  Date: 2019/1/5
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("regionMap", RegionData.getNameMapJson());
    request.setAttribute("regionJson", RegionData.getUserZTreeList2Json());
%>
<html>
<head>
    <title>短信告警</title>
    <%@include file="../common/css.jsp" %>
    <link href="${ctx}/static/css/dsSelect.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .col-sm-3 {
            padding: 0;
        }

        .modal-dialog {
            width: 65%;
            height: 60%;
        }

        /*table{
            table-layout: fixed;
        }*/
        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .content_table {
            height: 80% !important;
        }

        .left, .right {
            border: 1px solid #FFFFFF !important;
            padding: 10px 0 !important;
            border-radius: 5px !important;
            width: 30% !important;
            height: 100% !important;
        }

        .modal-body-left.col-sm-9 {
            padding: 1% 0 0 6%;
            height: 100% !important;
        }

        #driver_btn li {
            float: left;
        }

        .driver_left, .driver_right {
            width: 30%;
            text-align: center;
        }

        li {
            list-style: none;
        }

        table {
            font-size: 14px !important;
        }
    </style>
</head>
<body>
<h4><b>当前位置:系统管理>>短信告警</b></h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li class="selected_tab"><a>告警配置</a></li>
        <li><a>告警负责人</a></li>
        <li><a>告警记录</a></li>
    </ul>
</div>
<div class="tab_modal show" style="margin: 50px 0 0 0">
    <form class="col-sm-5 form-inline modal-body-left" style="display: inline-block;border: 1px solid #FFFFFF">
        <div class="col-sm-12" style="padding: 20px">
            <label class="col-sm-1"></label>
            <label class="control-label col-sm-3">IP地址</label>
            <div class="control-label col-sm-8">
                <input type="text" class="form-control" name="sms_server_ip" value="${config.sms_server_ip}">
            </div>
        </div>
        <div class="col-sm-12" style="padding: 20px">
            <label class="col-sm-1"></label>
            <label class="control-label col-sm-3">端口</label>
            <div class="control-label col-sm-8">
                <input type="text" class="form-control" name="sms_server_port" value="${config.sms_server_port}">
            </div>
        </div>
        <div class="col-sm-12" style="padding: 20px">
            <label class="col-sm-1"></label>
            <label class="control-label col-sm-3">用户名</label>
            <div class="control-label col-sm-8">
                <input type="text" class="form-control" name="sms_server_username"
                       value="${config.sms_server_username}">
            </div>
        </div>
        <div class="col-sm-12" style="padding: 20px">
            <label class="col-sm-1"></label>
            <label class="control-label col-sm-3">密码</label>
            <div class="control-label col-sm-8">
                <input type="text" class="form-control" name="sms_server_password"
                       value="${config.sms_server_password}">
            </div>
        </div>
        <div class="col-sm-12" align="center" style="padding: 20px">
            <label class="control-label col-sm-4"></label>
            <div class="col-sm-8" style="text-align: left">
                <button type="button" class="btn btn-default submit-btn">保存</button>
            </div>
        </div>
    </form>
    <span class="col-sm-1"></span>
    <form class="col-sm-5 form-inline modal-body-right"
          style="display: inline-block;float: left;border: 1px solid #FFFFFF">
        <div class="col-sm-12" style="padding: 20px">
            <label class="col-sm-1 control-label"></label>
            <label class="col-sm-3 control-label">短信测试</label>
            <div class="control-label col-sm-8">
                <input id="smsMobile" type="text" class="form-control " placeholder="请输入正确手机号">
            </div>
        </div>
        <div class="col-sm-12" style="padding: 5px">
            <label class="col-sm-1 control-label"></label>
            <div class="col-sm-11">
                <textarea id="smsText" placeholder="请输入测试文本"
                          style="width: 330px;height: 60px;color: black;resize:none;"></textarea>
            </div>
        </div>
        <div class="col-sm-12" align="center" style="padding:  10px 0 10px 0">
            <button type="button" class="btn btn-default" id="smsTestBtn">发送</button>
        </div>
    </form>
</div>
<div class="tab_modal">
    <div class="content_table">
        <div class="handle">
            <button id="add_button" class="btn btn-info" data-toggle="modal">新增</button>
            <button class="btn btn-danger" id="delete_btn">删除</button>
        </div>
        <table id="tab_SMSWaring_person" class="table table-hover"></table>
    </div>
</div>
<div class="tab_modal">
    <div class="content_table">
        <table id="tab_SMSWaring_record" class="table table-hover"></table>
    </div>
</div>
<!-- 人员选择模态框（Modal） -->
<div class="modal fade" id="select_person_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="server_title">新增</h4>
            </div>
            <div class="modal-body col-sm-12" style="padding: 15px">
                <div class="modal-body-left col-sm-9">
                    <div id="driver_btn">
                        <ul>
                            <li class="driver_left">待选</li>
                            <li style="width: 100px;height: 1px"></li>
                            <li class="driver_left">已选</li>
                            <div class="null"></div>
                        </ul>
                    </div>
                    <!--这一层div做限定，无需管-->
                    <div>
                        <div class="dsSelect" id="dsSelectTemp">
                        </div>
                    </div>
                    <div class="null"></div>
                </div>
                <div class="modal-body-right col-sm-3" style="padding: 5px;">
                    <label>播发区域</label>
                    <div class="right-tree">
                        <ul id="ztree1" class="ztree"></ul>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="submit_button">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
    <!-- /.modal-content -->
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript" src="${ctx}/static/js/dsSelect.js"></script>
<script type="text/javascript">
    $('.submit-btn').click(function () {
        var data = $(this).parent().parent().parent().serialize() + "&_method=put";
        layer.load(1);
        $.post('systemConfigure', data, function (result) {
            if (result.status === 200) {
                layer.msg(result.msg, {icon: 1});
            } else {
                layer.msg(result.msg, {icon: 2});
            }
            layer.closeAll('loading');
        });
    });
    $('#smsTestBtn').click(function () {
        var mobile = $('#smsMobile').val();
        var text = $('#smsText').val();
        if (!mobile) {
            layer.msg("请输入正确的手机号", {icon: 2});
            $('#smsMobile').focus();
            return false;
        }
        if (!text) {
            layer.msg("请输入测试文本", {icon: 2});
            $('#smsText').focus();
            return false;
        }
        layer.load(1);
        $.post('SMSWarning/test', 'mobile=' + mobile + '&text=' + text, function (result) {
                if (result.status === 200) {
                    layer.msg(result.msg, {icon: 1});
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
                layer.closeAll('loading');
            }
        )
        ;
    });
    var treeSetting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            view: {
                nameIsHTML: false,
                showTitle: false,
                showIcon: false,
                dblClickExpand: false
            },
            check: {
                chkStyle:"checkbox",
                enable: true,
                radioType: "all"
            },
            callback: {
                onCheck: function (event, treeId, treeNode) {
                   datas = [];
                    var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
                    for (var i = 0; i < nodes.length; i++) {
                        var key = nodes[i].id;
                        for (var j in area[key]) {
                           // alert(area[key])
                            datas.push({id: j, name: area[key][j]});
                        }
                    }
                    console.log(datas);
                    dsSelectObj.init();
                    dsSelectObj.setLeftData(datas, "name");
                }
            },
        },
        treeId1 = 'ztree1';
    regionMap = ${regionMap};
    var nodes = ${regionJson};
    var treeObj1 = $.fn.zTree.init($("#" + treeId1), treeSetting, nodes);
    $.each(treeObj1.getNodes(), function (index, node) {
        treeObj1.expandNode(node, true);
    });
    $(".modal-dialog").draggable();
    var area = "";
    var dsSelectObj = new dsSelect("dsSelectTemp");
    dsSelectObj.multiSelect = true;
    dsSelectObj.init();
    var datas = [];
    var datasR = [];
    dsSelectObj.setLeftData(datas, "name");
    dsSelectObj.setRightData(datasR, "name");

    function leftValues() {
        alert(JSON.stringify(dsSelectObj.getSelectLeftValus()));
    }

    function rightValues() {
        alert(JSON.stringify(dsSelectObj.getSelectRightValus()));
    }

    function disableButtons() {
        dsSelectObj.disableButtons();
    }

    function start() {
        dsSelectObj.restartButtons();
    }

    $(function () {
        $.getJSON('${ctx}/systemManage/SMSWarning/select/', function (result) {
            area = result.data;
        });
        $('#tab_SMSWaring_person').bootstrapTable({
            url: "${ctx}/systemManage/SMSWarning/list",
            columns: columns_person,
            method: 'get',
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            search: true,
            classes: 'table table-no-bordered',
            showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            queryParamsType: "",
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            formatNoMatches: function () {
                return '无记录';
            },
            formatRecordsPerPage: function (pageNumber) {
                return '每页 ' + pageNumber + ' 条';
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return '当前 ' + pageFrom + ' 到 ' + pageTo + ' 条，共 ' + totalRows + ' 条记录,';
            },
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
        $('#tab_SMSWaring_record').bootstrapTable({
            url: "",
            columns: columns_record,
            method: 'get',
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            search: true,
            classes: 'table table-no-bordered',
            showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            queryParamsType: "",
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            formatNoMatches: function () {
                return '无记录';
            },
            formatRecordsPerPage: function (pageNumber) {
                return '每页 ' + pageNumber + ' 条';
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return '当前 ' + pageFrom + ' 到 ' + pageTo + ' 条，共 ' + totalRows + ' 条记录,';
            },
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
    });
    var columns_person = [
        [{
            checkbox: true
        }, {
            field: 'fPrincipal',
            title: '联系人',
            align: 'center',
            width: "15%",
        }, {
            field: 'fArea',
            title: '区域',
            align: 'center',
            width: "20%",
            formatter: function (value) {
                return regionMap[value];
            }
        }, {
            field: 'fCareer',
            title: '职务',
            align: 'center',
            width: "15%",
        }, {
            field: 'fTelephone',
            title: '联系电话',
            align: 'center',
            width: "20%",
        }, {
            field: 'fUpdtateTime',
            title: '操作时间',
            sortable: true,
            align: 'center',
            width: "20%",
            formatter: function (time) {
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            }
        }, {
            field: 'operator',
            title: '操作者',
            align: 'center'
        }]
    ];
    var columns_record = [
        [{
            checkbox: true
        }, {
            field: 'fPrincipal',
            title: '告警ID',
            align: 'center',
            width: "12%",
        }, {
            field: 'fArea',
            title: '手机号',
            align: 'center',
            width: "12%",
            formatter: function (value) {
                return regionMap[value];
            }
        }, {
            field: 'fCareer',
            title: '告警类型',
            align: 'center',
            width: "10%",
        }, {
            field: 'fTelephone',
            title: '告警时间',
            align: 'center',
            width: "15%",
        }, {
            field: 'fTelephone',
            title: '短信内容',
            align: 'center',
            width: "20%",
        }, {
            field: 'fTelephone',
            title: '发送状态',
            align: 'center',
            width: "7%",
        }, {
            field: 'fTelephone',
            title: '结果描述',
            align: 'center',
        }]
    ];

    function refreshTree() {
        var regionData = ${regionList};
        loadRegionTree("ztree1", regionData);
    }

    $("#add_button").click(function () {
        $("#select_person_modal").modal('show');
    });

    function onCheck() {
          datas = [];
          var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
          for (var i = 0; i < nodes.length; i++) {
              var key = nodes[i].id;
              for (var j in area[key]) {
                   //alert(area[key])
                  datas.push({id: j, name: area[key][j]});
              }
          }
          dsSelectObj.init();
          dsSelectObj.setLeftData(datas, "name");
    }

    $("#submit_button").click(function () {
        var ids = "";
        var checked = dsSelectObj.getSelectRightValus();
        if (checked.length == 0) {
            layer.msg('请选择要新增的记录', {icon: 2});
            return;
        }
        for (var i = 0; i < checked.length; i++) {
            ids += checked[i].id + ",";
        }
        layer.load(2);
        $.post('', {ids: ids}, function (result) {
            if (result.status === 200) {
                $('#select_person_modal').modal('hide');
                $('#tab_SMSWaring_person').bootstrapTable('refresh');
                layer.msg(result.msg, {icon: 1});
            }
            layer.closeAll('loading');
        });
    });
    //删除操作
    $("#delete_btn").click(function () {
        var checked = $('#tab_SMSWaring_person').bootstrapTable('getSelections');
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
                        $('#tab_SMSWaring_person').bootstrapTable('refresh');
                    }
                    layer.msg(result.msg, {icon: 1});
                    layer.closeAll('loading');
                });
            });
        }
    })
    $('body').on('hidden.bs.modal', '.modal', function () {
        dsSelectObj.init();
        datas = "";
        datasR = "";
        $.fn.zTree.getZTreeObj("ztree1").checkAllNodes(false);
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"});
    });
</script>
</body>
</html>
