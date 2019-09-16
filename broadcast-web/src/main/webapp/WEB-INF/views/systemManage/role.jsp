<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色管理 </title>
    <%@include file="../common/css.jsp" %>
    <style>
        .content {
            height: auto;
        }

        td, th {
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<h4><b>当前位置:系统管理>>角色管理</b></h4>
<div class="content">
    <div class="handle pull-right">
        <button class="btn btn-danger" id="batchDelBtn" style="display: none;">批量删除</button>
        <button class="btn btn-info" id="addBtn">新增</button>
    </div>
    <table id="tab_role"></table>
</div>
<!-- 新增模态框（Modal） -->
<div class="modal fade" id="roleModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="roleForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">新增角色</h4>
                </div>
                <div class="modal-body-left col-sm-7">
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">角色名称</label>
                        <div class="col-sm-8">
                            <input type="hidden" id="fId" name="fId">
                            <input type="text" class="form-control" id="fRoleName" name="fRoleName" maxlength="16">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">角色描述</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="fRoleDescription" name="fRoleDescription" maxlength="64">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">排序</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="fSort" name="fSort" min="0" max="100">
                        </div>
                    </div>
                </div>
                <div class="modal-body-right col-sm-5">
                    <ul id="ztree" class="ztree"></ul>
                </div>
                <div class="modal-footer ">
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
    $(function () {
        var resources = ${resources},
            $table = $('#tab_role'),
            treeSetting = {
                view: {
                    showIcon: false
                },
                check: {
                    enable: true
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                }
            },
            treeId = 'ztree';
        var $bootstrapTable = $table.bootstrapTable({
            url: "${ctx}/systemManage/role/list",
            method: 'get',
            sortable: false,
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
                    field: 'fRoleName',
                    title: '角色名称',
                    align: 'center',
                    width: '15%'
                }, {
                    field: 'fRoleDescription',
                    title: '角色描述',
                    align: 'center'
                }, {
                    field: 'fSort',
                    title: '排序',
                    align: 'center'
                }, {
                    field: 'fCreateTime',
                    title: '创建时间',
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                    },
                    width: '15%'
                }, {
                    title: '操作',
                    align: 'center',
                    width: '15%',
                    events: {
                        'click .edit-btn': function (e, val, row) {
                            $.getJSON('${ctx}/systemManage/role/' + row.fId, function (result) {
                                if (result.status === 200) {
                                    var role = result.data;
                                    if (role) {
                                        $('#fId').val(role.fId);
                                        $('#fRoleName').val(role.fRoleName);
                                        $('#fRoleDescription').val(role.fRoleDescription);
                                        $('#fSort').val(role.fSort);
                                        refreshTree(role.permissions);
                                        $('.modal-title').html('修改角色');
                                        $('#roleModal').modal();
                                    }
                                } else {
                                    layer.msg(result.msg, {icon: 2});
                                }
                            });
                        },
                        'click .del-btn': function (e, val, row) {
                            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                                delRole(row.fId, index);
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
         * 批量删除角色对话框
         */
        $('#batchDelBtn').click(function () {
            var roleId = '';
            var rows = $bootstrapTable.bootstrapTable('getSelections');
            $.each(rows, function (i, item) {
                roleId = roleId + item.fId;
                if (i < rows.length - 1) {
                    roleId = roleId + ',';
                }
            });
            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                delRole(roleId, index);
            });
        });

        /**
         * 删除角色
         * @param roleId 角色id,多个以','分隔
         * @param index 弹出层index
         */
        function delRole(roleId, index) {
            layer.load(2);
            $.post('', '_method=delete&roleId=' + roleId, function (result) {
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
         * 添加角色
         */
        $('#addBtn').click(function () {
            refreshTree(resources);
            $('#roleForm')[0].reset();
            $('#fId').val('');
            $('.modal-title').html('新增角色');
            $('#roleModal').modal();
        });
        /**
         * 保存
         */
        $('#confirm').click(function () {
            if (!$('#fRoleName').val()) {
                layer.msg('请输入角色名称', {icon: 2});
                $('#fRoleName').focus();
                return false;
            }
            var fSort = $('#fSort').val();
            if(!(/^\d+$/.test(fSort)) || fSort<0 || fSort>255){
                layer.msg('排序必须是一个整数,且范围是0到255', {icon: 2});
                $('#fSort').focus();
                return false;
            }
            $('#roleModal').modal('hide');
            var data = $('#roleForm').serialize() + '&resourceId=';
            var nodes = $.fn.zTree.getZTreeObj(treeId).getCheckedNodes(true);
            $.each(nodes, function (i, item) {
                data = data + item.id;
                if (i < nodes.length - 1) {
                    data = data + ',';
                }
            });
            layer.load(2);
            $.post('', data, function (result) {
                if (result.status === 200) {
                    $bootstrapTable.bootstrapTable('refresh');
                }
                layer.msg(result.msg);
                layer.closeAll('loading');
            });
        });

        /**
         * 同步重置zTree数据
         */
        function refreshTree(nodes) {
            $.fn.zTree.destroy(treeId);
            $.fn.zTree.init($("#" + treeId), treeSetting, nodes);
        }
    });
</script>
</body>
</html>
