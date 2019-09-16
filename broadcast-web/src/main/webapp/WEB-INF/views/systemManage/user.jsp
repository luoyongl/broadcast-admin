<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.RegionData,cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionJson", RegionData.getZTreeListJson());
    request.setAttribute("regionMap", RegionData.getNameMapJson());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>账号管理</title>
    <%@include file="../common/css.jsp" %>
    <style>
        .select-tree {
            display: none;
            position: absolute;
            padding: 5px 0;
            z-index: 999;
            border: 1px solid #d2d2d2;
            max-height: 300px;
            overflow-y: auto;
            background-color: #fff;
            border-radius: 2px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
            box-sizing: border-box;
            top: auto;
            bottom: 100%;
            margin-bottom: 4px;
        }

        .ztree li a.curSelectedNode {
            background-color: transparent;
            border: none;
        }

        .content {
            height: auto;
        }

        label {
            text-align: left !important;
            height: 34px;
            line-height: 34px;
        }

        .modal-body {
            padding-right: 10px;
        }

        td, th {
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<h4><b>当前位置:系统管理>>账号管理</b></h4>
<div class="content">
    <div class="handle pull-right">
        <button class="btn btn-danger" id="batchDelBtn" style="display: none;">批量删除</button>
        <button class="btn btn-info" id="addBtn">新增</button>
        <button class="btn btn-info" id="exportBtn">导出</button>
    </div>
    <table id="tab_user" class="table table-hover"></table>
    <div class="col-md-12" style="float: none">
    </div>
</div>
<!-- 新增模态框（Modal） -->
<div class="modal fade" id="userModal" tabindex="-1" user="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="userForm" class="am-form" data-am-validator>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">账号</label>
                        <div class="col-sm-8">
                            <input type="hidden" id="fId" name="fId">
                            <input type="text" class="form-control" id="fAccount" name="fAccount" maxlength="20"
                                   required>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">用户名</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="fUsername" name="fUsername" maxlength="20"
                                   required>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">用户密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="fPassword" name="fPassword" maxlength="20"
                                   required>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">确认密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="checkpwd" name="checkpwd" maxlength="20"
                                   data-match="#fPassword" required>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">角色</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="roleId" id="roleId">
                                <option disabled selected>请选择</option>
                                <c:forEach items="${roles}" var="item">
                                    <option value="${item.fId}">${item.fRoleName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">单位</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="fSubordinateUnit" name="fSubordinateUnit"
                                   maxlength="64">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">职务</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="fDuties" name="fDuties" maxlength="16">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">电话</label>
                        <div class="col-sm-8">
                            <input type="text"  class="form-control" id="fTel" name="fTel" maxlength="16"
                                   required data-bv-regexp="true" pattern="[a-zA-Z0-9]+"
                                   data-bv-regexp-message="请输入正确的号码">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">自动审核</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="fIsAuditAutomatic" name="fIsAuditAutomatic">
                                <option value="false">否</option>
                                <option value="true">是</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">是否有效</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="fIsEffective" value="fIsEffective">
                                <option value="true">有效</option>
                                <option value="false">无效</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">所属区域</label>
                        <div class="col-sm-8">
                            <input type="hidden" name="fRespectiveRegion" id="fRespectiveRegion">
                            <input autocomplete="off" class="form-control" type="text" id="selectRegion"
                                   required>
                            <div id="menuContent" class="select-tree">
                                <ul id="ztree" class="ztree"></ul>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">排序</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" id="fSort" name="fSort" min="0" max="100">
                        </div>
                    </div>
                </div>
                <div class="modal-footer ">
                    <!-- <button type="button" id="resetBtn" class="btn btn-warning">重置密码</button> -->
                    <button type="submit" id="confirm" class="btn btn-info">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/validator.min.js" ></script>
<script type="text/javascript">
    $(function () {
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
                    enable: true,
                    chkStyle: "radio",
                    radioType: "all"
                },
                callback: {
                    onCheck: function (event, treeId, treeNode) {
                        $('#fRespectiveRegion').val(treeNode.id);
                        $('#selectRegion').val(treeNode.name);
                        $('#selectRegion').trigger("input");
                        hideMenu();
                    },
                    onClick: function (event, treeId, treeNode) {
                        $('#fRespectiveRegion').val(treeNode.id);
                        $('#selectRegion').val(treeNode.name);
                        $('#selectRegion').trigger("input");
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        zTree.checkNode(treeNode, !treeNode.checked, null, true);
                        hideMenu();
                    }
                }
            },
            treeId = 'ztree',
            regionMap = ${regionMap};
        var nodes = ${regionJson};
        var treeObj = $.fn.zTree.init($("#" + treeId), treeSetting, nodes);
        $.each(treeObj.getNodes(), function (index, node) {
            if (node.level === 0) {
                treeObj.expandNode(node, true);
            }
        });

        /**
         * 隐藏下拉树
         */
        function hideMenu() {
            $("#menuContent").fadeOut("fast");
        }

        var $bootstrapTable = $('#tab_user').bootstrapTable({
            url: "${ctx}/systemManage/user/list",
            method: 'get',
            sortable: false,
            search: true,
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            queryParamsType: '',
            classes: 'table table-no-bordered',
            columns: [[
                {
                    field: 'isChecked',
                    checkbox: true
                }, {
                    field: 'fAccount',
                    title: '账号',
                    align: 'center',
                    width: "7%",
                }, {
                    field: 'fUsername',
                    title: '用户名',
                    align: 'center',
                    width: "10%",
                }, {
                    field: 'fRespectiveRegion',
                    title: '所属区域',
                    align: 'center',
                    width: "15%",
                    formatter: function (value) {
                        return regionMap[value];
                    }
                }, {
                    field: 'fSubordinateUnit',
                    title: '单位',
                    align: 'center',
                    width: "7%",
                }, {
                    field: 'fDuties',
                    title: '职务',
                    align: 'center',
                    width: "7%",
                }, {
                    field: 'fTel',
                    title: '联系电话',
                    align: 'center',
                    width: "10%",
                }, {
                    field: 'fIsAuditAutomatic',
                    title: '自动审核',
                    align: 'center',
                    width: "5%",
                    formatter: function (value) {
                        return value ? "是" : "否";
                    }
                }, {
                    field: 'fIsEffective',
                    title: '是否有效',
                    align: 'center',
                    width: "5%",
                    formatter: function (value) {
                        return value ? "是" : "否";
                    }
                }, {
                    field: 'fCreateTime',
                    title: '创建时间',
                    width: "15%",
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                    }
                }, {
                    field: 'creator',
                    title: '创建人',
                    width: "7%",
                    align: 'center'
                }, {
                    title: '操作',
                    align: 'center',
                    events: {
                        'click .edit-btn': function (e, val, row) {
                            $.each(row, function (key, value) {
                                $('#userForm #' + key).val(value + "");
                            });
                            $('#userForm #fPassword').val("");
                            $('#userForm #checkpwd').val("");
                            var regionId = row.fRespectiveRegion;
                            if (regionId) {
                                var checkNode = treeObj.getNodeByParam("id", regionId);
                                if (checkNode) {
                                    $('#selectRegion').val(checkNode.name);
                                }else{
                                    $('#selectRegion').val('');
                                }
                            }
                          /*   $('#resetBtn').show(); */
                            $('.modal-title').html('编辑用户');
                            $('#userModal').modal();
                        },
                        'click .del-btn': function (e, val, row) {
                            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                                delUser(row.fId, index);
                            });
                        }
                    },
                    formatter: function () {
                        return '<button class="btn btn-info btn-sm edit-btn">修改</button> <button class="btn btn-danger btn-sm del-btn">删除</button>';
                    }
                }]],
            formatNoMatches: function () {
                return '无记录';
            },
            formatRecordsPerPage: function (pageNumber) {
                return '每页 ' + pageNumber + ' 条';
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return '当前 ' + pageFrom + ' 到 ' + pageTo + ' 条，共 ' + totalRows + ' 条记录,';
            },
            responseHandler: function (result) {
                return {total: result.data.total, rows: result.data.list};
            },
            onCheck: function () {
                handleBatchDeleteBtn();
            },
            onUncheck: function () {
                handleBatchDeleteBtn();
            },
            onCheckAll: function () {
                handleBatchDeleteBtn();
            },
            onUncheckAll: function () {
                handleBatchDeleteBtn();
            }
        });

        /**
         * 批量删除按钮是否显示
         */
        function handleBatchDeleteBtn() {
            var checkRows = $bootstrapTable.bootstrapTable('getSelections');
            var $batchDelBtn = $('#batchDelBtn');
            if (checkRows.length > 0) {
                $batchDelBtn.show();
            } else {
                $batchDelBtn.hide();
            }
        }

        /**
         * 批量删除用户对话框
         */
        $('#batchDelBtn').click(function () {
            var userId = '';
            var rows = $bootstrapTable.bootstrapTable('getSelections');
            $.each(rows, function (i, item) {
                userId = userId + item.fId;
                if (i < rows.length - 1) {
                    userId = userId + ',';
                }
            });
            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                delUser(userId, index);
            });
        });

        /**
         * 删除用户
         * @param userId 用户id,多个以','分隔
         * @param index 弹出层index
         */
        function delUser(userId, index) {
            layer.load(2);
            $.post('', '_method=delete&userId=' + userId, function (result) {
                if (result.status === 200) {
                    $bootstrapTable.bootstrapTable('refresh');
                    $('#batchDelBtn').hide();
                }
                layer.msg(result.msg);
                layer.close(index);
                layer.closeAll('loading');
            });
        }

        /**
         * 添加用户
         */
        $('#addBtn').click(function () {
           /*  $('#resetBtn').hide(); */
            $('#userForm')[0].reset();
            $('#fId').val('');
            $('.modal-title').html('新增用户');
            $('#userModal').modal();
        });

        /**
         * 保存
         */
         $('#userForm').validator({disable:false}).on('submit', function (e) {      	 
            if (e.isDefaultPrevented()) {
                //验证不通过           
            }else {         
                e.preventDefault();
                var data = $('#userForm').serialize();
                layer.load(2);
                $.post('', data, function (result) {
                    if (result.status === 200) {
                        $bootstrapTable.bootstrapTable('refresh');
                        $('#userModal').modal('hide');
                    }
                    layer.msg(result.msg);
                    layer.closeAll('loading');
                }); 
            }
        });   
        //选择区域
        $('#selectRegion').click(function () {
            var id = $('#fRespectiveRegion').val();
            if (id) {
                var checkNode = treeObj.getNodeByParam("id", id);
                if (checkNode) {
                    treeObj.checkNode(checkNode, true);
                }
            }
            $("#menuContent").css({width: $(this).outerWidth() + 'px'}).slideDown("fast");
            $("body").bind("mousedown", function (event) {
                if (!(event.target.id === "selectMethod" || event.target.id === "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
                    hideMenu();
                }
            });
        });
        /**
         * 重置密码
         */
      /*   $('#resetBtn').click(function () {
            var userId = $('#fId').val();
            if (userId) {
                layer.confirm('确认重置密码?', {icon: 3, title: '操作提示'}, function (index) {
                    $.post('user/reset', 'userId=' + userId, function (result) {
                        if (result.status === 200) {
                            $('#userModal').modal('hide');
                        }
                        layer.msg(result.msg);
                        layer.closeAll('loading');
                    });
                });
            }
        }); */

        $('#exportBtn').click(function () {
            window.location.href = 'user/export';
        });
    });


</script>
</body>
</html>
