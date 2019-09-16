<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>电话名单</title>
    <%@include file="../common/css.jsp" %>
    <style>
        .content-table {
            padding: 1% 1.5%;
            border-radius: 10px;
            width: 99%;
            border: 1px solid #FFFFFF
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .modal-body {
            padding-top: 18px;
            margin-bottom: 10px
        }

        .modal .form-group {
            margin: 4% 0 !important;
        }

    </style>
</head>
<body>
<h4><b>当前位置:资源管理>>电话名单</b></h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li id="list" class="selected_tab"><a>白名单</a></li>
        <li id="sms"><a>短信记录</a></li>
        <li id="callRecord"><a>通话记录</a></li>
    </ul>
</div>
<div class="content-table">
    <div class="tab_modal show">
        <div class="handle">
            <button class="add_whitelist_btn btn btn-info" data-toggle="modal">新增</button>
            <button class="update_whitelist_btn btn btn-info">修改</button>
            <button class="delete_whitelist btn btn-danger">删除</button>
        </div>
    </div>
    <div class="tab_modal">
        <!-- <div class="handle">
            <button class="btn btn-danger">删除</button>
        </div> -->
    </div>
    <div class="tab_modal">
        <!-- <div class="handle">
            <button class="btn btn-danger">删除</button>
        </div> -->
    </div>
    <table data-height="450" id="show_table" class="table"></table>
</div>
<!-- 添加模态框（Modal） -->
<div class="modal fade" id="add_whiteList_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">新增</h4>
            </div>
            <div class="modal-body col-sm-12">
                <div class="col-sm-7">
                    <form class="form_whitelist  form-inline">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">电话号码</label>
                            <div class="col-sm-8">
                                <input style="width:85%!important" type="text" id="tel"
                                <%--onKeyUp="confirmtel($(this),'checkwhitelist')"--%> maxlength="15"
                                       name="fTelephoneNumber" class="form-control ">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">姓名</label>
                            <div class="col-sm-8">
                                <input maxlength="15" style="width:85%!important" type="text"
                                       name="fName" class="form-control ">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">设备</label>
                            <div class="col-sm-8">
                                <select name="fControlDevice" class="form-control" style="width:85%!important">
                                    <c:forEach items="${deviceInfos}" var="deviceInfos">
                                        <option value="${deviceInfos.fId}">
                                                ${deviceInfos.fDeviceName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">授权方式</label>
                            <div class="col-sm-8">
                                <label>
                                    <input type="checkbox" value="1" style="vertical-align:middle;"/>
                                    <sapn style="vertical-align:middle;">&nbsp;&nbsp;电话</sapn>
                                </label>
                                <label style="margin-left: 5%">
                                    <input type="checkbox" value="2" style="vertical-align:middle;"/>
                                    <sapn style="vertical-align:middle;">&nbsp;&nbsp;短信</sapn>
                                </label>
                                <label class="info" style="width: 20px;height: 20px;"></label>
                            </div>
                        </div>
                        <div class="null"></div>
                    </form>
                    <div class="null"></div>
                </div>
                <div class="col-sm-5">
                    <label>授权区域</label>
                    <div class="right-tree" style="height:200px">
                        <ul id="ztree1" class="ztree"></ul>
                    </div>
                </div>
                <div class="null"></div>
            </div>

            <div class="modal-footer">
                <div>
                    <button id="submit_whitelist" type="button" class="btn btn-info">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    <!-- /.modal-content -->
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    $('#list').on("click", function () {
        $('#show_table').bootstrapTable('refreshOptions', {
            url: "${ctx}/resourceManage/telephoneList/selectwhitelist",
            columns: columns_whiteList,
        })
    })
    $('#sms').on("click", function () {
        $('#show_table').bootstrapTable('refreshOptions', {
            url: "${ctx}/resourceManage/telephoneList/selectSms",
            columns: columns_SMSRecord,
        })
    })
    $('#callRecord').on("click", function () {
        $('#show_table').bootstrapTable('refreshOptions', {
            url: "${ctx}/resourceManage/telephoneList/selectRecord",
            columns: columns_callRecord,
        })
    })

    function confirmtel(e, url) {
        var result = false;
        var title = e.val();
        if (title != null && title != "") {
            $.ajax({
                url: "${ctx}/resourceManage/telephoneList/" + url,
                type: "post",
                async: false,
                dataType: "json",
                data: {
                    title: title,
                },
                success: function (data) {
                    if (data.status == 400) {
                        layer.tips(data.msg, e, {
                            tips: [2, 'red'],
                            tipsMore: true,
                            time: 800
                        });
                        result = true;
                    }
                }
            })
        }
        return result;
    }

    $(function () {
        refreshTree();
        $('#show_table').bootstrapTable({
            url: "${ctx}/resourceManage/telephoneList/selectwhitelist",
            columns: columns_whiteList,
            method: 'post',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            search: true, //是否显示表格搜索
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

    $(".add_whitelist_btn").on("click", function () {
        $("#add_whiteList_modal h4").text("新增");
        $("#add_whiteList_modal").modal();
        $('#submit_whitelist').addClass("add_whitelist").removeClass("update_whitelist");
        $(".modal").on("click", ".add_whitelist", function () {
            //alert(confirmtel($("#tel"), 'checkwhitelist'));
            if (confirmtel($("#tel"), 'checkwhitelist') == false) {
                applyform(".form_whitelist", "addwhiteList", "#add_whiteList_modal", '#show_table', '新增');
            }
        })
    }),

        $(".update_whitelist_btn").on("click", function () {
            $('#submit_whitelist').removeClass("add_whitelist").addClass("update_whitelist");
            var checked = $('#show_table').bootstrapTable('getSelections');
            if (checked.length == 0) {
                layer.msg("请选择要修改的记录", {icon: 2});
            } else if (checked.length > 1) {
                layer.msg("一次只能修改一条记录", {icon: 2});
            } else {
                $("#add_whiteList_modal" + " " + "h4").text("修改");
                $("#add_whiteList_modal").modal();
                showContent("#add_whiteList_modal");
                var update_fId = checked[0].fId;
                $(".modal").on("click", ".update_whitelist", function () {
                    applyform(".form_whitelist", "updatewhitelist/" + update_fId, "#add_whiteList_modal", '#show_table', '修改');
                })
            }
        })
    $(".delete_whitelist").on("click", function () {
        deleteform("deletewhitelist");
    })


    function showContent(modal) {
        var row = $('#show_table').bootstrapTable('getSelections');
        var name = row[0].fArea;
        var permit = row[0].fPermit;
        $(modal + " " + "input[name='fTelephoneNumber']").css("border", "none");
        $(modal + " " + "input[name='fTelephoneNumber']").attr("disabled", "disabled");
        $(modal + " " + "input[name='fTelephoneNumber']").val(row[0].fTelephoneNumber);
        $(modal + " " + "input[name='fName']").val(row[0].fName);
        var zTree_Menu = $.fn.zTree.getZTreeObj("ztree1");
        var nodes = zTree_Menu.transformToArray(zTree_Menu.getNodes());
        if (nodes.length > 0) {
            for (var i = 0; i < nodes.length; i++) {
                if (name.indexOf(nodes[i].id) >= 0) {
                    nodes[i].checked = true;
                    zTree_Menu.updateNode(nodes[i]);
                }
            }
        }
        if (permit == 1) {
            $(".form-group input[type='checkbox']").eq(0).prop("checked", "true");
        } else if (permit == 2) {
            $(".form-group input[type='checkbox']").eq(1).prop("checked", "true");
        } else {
            $(".form-group input[type='checkbox']").prop("checked", "true");
        }
    }

    function applyform(form, url, modal, table, title) {
        var fPermit;
        var area = "";
        var flag = comfirm_telephone($("input[name='fTelephoneNumber']"));
        var name_content = $("input[name='fName']").val();
        if (!name_content) {
            layer.tips('请填写姓名!', $("input[name='fName']"), {
                tips: [2, 'red'],
                tipsMore: true
            })
            flag = false;
        }
        var checknodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
        $.each(checknodes, function (i, item) {
            area = area + item.id;
            if (i < checknodes.length - 1) {
                area = area + ',';
            }
        });
        if (checknodes.length <= 0) {
            layer.tips('请选择播发区域!', '#ztree1', {
                tips: [1, 'red'],
                tipsMore: true
            })
            flag = false;
        }

        var permit = $(".form-group input[type='checkbox']:checked");
        if (permit.length == 0) {
            layer.tips('请选择授权方式!', '.info', {
                tips: [2, 'red'],
                tipsMore: true
            })
            flag = false;
        } else if (permit.length == 1) {
            fPermit = permit[0].value;
        } else {
            fPermit = 3;
        }
        if (flag) {
            layer.confirm("是否确定" + title + "？", {
                icon: 3,
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
            }, function () {
                $.ajax({
                    url: "${ctx}/resourceManage/telephoneList/" + url,
                    type: 'post',
                    data: $(form).serialize() + "&resourceId=" + area + "&fPermit=" + fPermit,
                    success: function (data) {
                        layer.msg(data.msg, {
                            icon: 1
                        });
                        $("#add_whiteList_modal").modal('hide');
                        $("#show_table").bootstrapTable('refresh');
                    }
                });
            }, function () {
            })

        }
    }

    function deleteform(url) {
        var checked = $('#show_table').bootstrapTable('getSelections');
        var ids = "";
        if (checked.length == 0) {
            layer.msg("请选择要删除的记录", {icon: 2});
        } else {
            layer.confirm('是否确定删除这' + checked.length + '条记录？', {
                icon: 3,
                title: ['提示操作'],
                btn: ['确定', '取消'] //按钮
            }, function () {
                for (i = 0; i < checked.length; i++) {
                    ids += checked[i].fId + ",";
                }
                $.ajax({
                    async: false,
                    data: {
                        "fId": ids,
                    },
                    url: "${ctx}/resourceManage/telephoneList/" + url + "?fId=" + ids,
                    type: "post",
                    success: function (data) {
                        layer.msg(data.msg, {icon: 1});
                        $("#show_table").bootstrapTable('refresh');
                    }
                })
            }, function () {
            })

        }
    }

    function comfirm_telephone(e) {
        var re = /(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}/;
        var input_value = e.val();
        var flag = true;
        if (!re.test(input_value)) {
            layer.tips('请正确填写', e, {
                tips: [2, 'red'],
            })
            flag = false;
        }
        return flag;
    }

    var columns_whiteList = [
        [{
            checkbox: true,
            width: 100
        }, {
            field: 'fName',
            title: '姓名',
            align: 'center',
            width: "15%"
        }, {
            field: 'fTelephoneNumber',
            title: '电话号码',
            align: 'center',
            width: "15%"
        }, {
            field: 'deviceName',
            title: '接入设备',
            align: 'center',
            width: "15%"
        }, {
            field: 'fPermit',
            title: '授权方式',
            align: 'center',
            width: "15%",
            formatter: function (data) {
                if (data == 1) {
                    return "<label style='width:100px' class='btn btn-info'>电话<label>";
                } else if (data == 2) {
                    return "<label style='width:100px' class='btn btn-info'>短信<label>";
                } else {
                    return "<label style='width:100px' class='btn btn-info'>电话和短信<label>";
                }
            }
        }, {
            field: 'fCreateTime',
            title: '操作时间',
            align: 'center',
            width: "15%",
            sortable: true,
            formatter: function (time) {
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            },
        }, {
            field: 'operator',
            title: '操作者',
            align: 'center',
        }]
    ];

    var columns_SMSRecord = [
        [{
            field: 'fId',
            title: '编号',
            align: 'center',
            width: "15%",
            formatter: function (value, row, index) {
                var pageSize = $('#show_table').bootstrapTable('getOptions').pageSize;
                var pageNumber = $('#show_table').bootstrapTable('getOptions').pageNumber;
                return pageSize * (pageNumber - 1) + index + 1;
            }
        }, {
            field: 'fName',
            title: '姓名',
            align: 'center',
            width: "15%",
        }, {
            field: 'fTelephoneNumber',
            title: '电话号码',
            align: 'center',
            width: "15%",
        }, {
            field: 'deviceName',
            title: '接入设备',
            align: 'center',
            width: "15%",
        }, {
            field: 'fCreateTime',
            title: '来短信时间',
            align: 'center',
            width: "15%",
            sortable: true,
            formatter: function (time) {
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            }
        }, {
            field: '',
            title: '短信内容',
            align: 'center',
            events: {
                'click .edit-base-btn': function (e, val, row) {
                    layer.prompt({
                        title: '短信内容',
                        formType: 2,
                        btn: ['关闭'],
                        success: function () {
                            $(".layui-layer.layui-layer-page.layui-layer-prompt textarea").val(row.fSmsContent);
                            $(".layui-layer.layui-layer-page.layui-layer-prompt textarea").attr("disabled", "disabled");
                        },
                        yes: function () {
                            layer.closeAll();
                        }
                    });
                }
            },
            formatter: function () {
                return '<button class="btn btn-info btn-sm edit-base-btn">详情';
            },
        }]
    ];

    var columns_callRecord = [
        [{
            field: 'bb',
            title: '编号',
            align: 'center',
            width: "10%",
            formatter: function (value, row, index) {
                var pageSize = $('#show_table').bootstrapTable('getOptions').pageSize;
                var pageNumber = $('#show_table').bootstrapTable('getOptions').pageNumber;
                return pageSize * (pageNumber - 1) + index + 1;
            }
        }, {
            field: 'fName',
            title: '姓名',
            align: 'center',
            width: "10%"
        }, {
            field: 'fTelephoneNumber',
            title: '电话号码',
            align: 'center',
            width: "15%"
        }, {
            field: 'deviceName',
            title: '接入设备',
            align: 'center',
            width: "15%"
        }, {
            field: 'fCreateTime',
            title: '来电时间',
            align: 'center',
            width: "15%",
            sortable: true,
            formatter: function (time) {
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            },
        }, {
            field: 'fCallTime',
            title: '通话时长',
            align: 'center',
            width: "15%",
            formatter: function (result) {
                var h = Math.floor(result / 3600) < 10 ? '0' + Math.floor(result / 3600) : Math.floor(result / 3600);
                var m = Math.floor((result / 60 % 60)) < 10 ? '0' + Math.floor((result / 60 % 60)) : Math.floor((result / 60 % 60));
                var s = Math.floor((result % 60)) < 10 ? '0' + Math.floor((result % 60)) : Math.floor((result % 60));
                return result = h + ":" + m + ":" + s;
            }
        }, {
            field: 'fAudioUrl',
            title: '试听',
            align: 'center',
            formatter: function (data, row, index) {
                return [
                    '<audio  src=' + data + ' controls="controls" style="width:80%;height:30px ;padding: 3px;"></audio>'
                ]
            }

        }]
    ];

    $("select").change(function () {
        var text = $(this).find("option:selected").attr("value");
        $(this).attr("value", text);
    });

    //重置ztree
    function refreshTree() {
        var regionData = ${regionList};
        loadRegionTree("ztree1", regionData);
    }

    $('body').on('hidden.bs.modal', '.modal', function () {
        $('.modal input[type="text"]').val("");
        $(".selectpicker").selectpicker('refresh');//对searchPayState这个下拉框进行重置刷新
        $(".modal input[name='fTelephoneNumber']").css("border", "1px solid #ffffff");
        $(".modal input[name='fTelephoneNumber']").attr("disabled", false);
        $(".form-group input[type='checkbox']").removeProp("checked");
        refreshTree();
    });
</script>
</body>
</html>