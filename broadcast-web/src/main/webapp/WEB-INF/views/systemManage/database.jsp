<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>数据管理</title>
    <%@include file="../common/css.jsp" %>
    <style>
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

        .fixed-table-pagination {
            padding: 0 10px;
        }
    </style>
</head>
<body>
<h4>
    <b>当前位置:系统管理>>数据管理</b>
</h4>
<div class="content">
    <div class="handle pull-right">
        <button class="btn btn-danger" id="batchDelBtn" style="display: none;">批量删除</button>
        <button class="btn btn-info" id="backupBtn">备份</button>
        <button class="btn btn-info" id="recoverBtn">恢复</button>
        <button class="btn btn-info" id="configBtn">自动备份设置</button>
    </div>
    <table id="tab_database" class="table table-hover"></table>
</div>
<div class="modal fade" id="configModal" tabindex="-1" user="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <form id="configForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">自动备份配置</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">自动备份</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="autoBackup" id="autoBackup" required>
                                <option value="0">禁用</option>
                                <option value="1">启用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">备份方式</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="backupType" id="backupType" required>
                                <c:forEach items="${backupTypeEnums}" var="item">
                                    <option value="${item}">${item.desc}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label" id="backupTimeText">每天</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="backupTime" id="backupTime" required>
                                <option value="0">0点</option>
                                <option value="1">1点</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer ">
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
<script src="${ctx}/static/bootstrap/js/bootstrap-table-treegrid.min.js"></script>
<script type="text/javascript">
    $(function () {
        var autoBackup = '${config.backup_auto}', backupType = '${config.backup_type}',
            backupTime = '${config.backup_time}', backupTypeMap = ${backupTypeMap},
            weekArr = ['', '日', '一', '二', '三', '四', '五', '六'];
        var $bootstrapTable = $('#tab_database'), $autoBackup = $('#autoBackup'), $backupType = $('#backupType'),
            $backupTime = $('#backupTime');
        //监听自动备份
        // $autoBackup.change(function () {
        //     if ($(this).val() === '0') {
        //         $backupType.attr('disabled', true);
        //         $backupTime.attr('disabled', true);
        //     } else if ($(this).val() === '1') {
        //         $backupType.removeAttr('disabled');
        //         $backupTime.removeAttr('disabled');
        //     }
        // });
        //监听备份方式
        $backupType.change(function () {
            setBackupTimeText($(this).val())
        });

        function setBackupTimeText(value) {
            var text = $backupType.find("option[value='" + value + "']").text();
            $('#backupTimeText').html(text);
            $backupTime.html('');
            var html = '';
            if (value === 'EVERYDAY') {
                for (var i = 0; i < 24; i++) {
                    html += '<option value="' + i + '">' + i + '点</option>';
                }
            } else if (value === 'WEEKLY') {
                for (var i = 1; i <= 7; i++) {
                    html += '<option value="' + i + '">周' + weekArr[i] + '</option>';
                }
            } else if (value === 'MONTHLY') {
                for (var i = 1; i <= 31; i++) {
                    html += '<option value="' + i + '">' + i + '号</option>';
                }
                html += '<option value="${lastDate}">最后一天</option>';
            }
            $backupTime.html(html);
        }

        //赋值
        $autoBackup.val(autoBackup);
        $backupType.val(backupTypeMap[backupType]);
        setBackupTimeText(backupTypeMap[backupType]);
        $backupTime.val(backupTime);
        $bootstrapTable.bootstrapTable({
            url: "${ctx}/systemManage/database/files",
            method: 'get',
            sortable: false,
            search: true,
            pagination: true,
            sidePagination: 'client',
            smartDisplay: false,
            queryParamsType: '',
            classes: 'table table-no-bordered',
            columns: [[
                {
                    field: 'isChecked',
                    checkbox: true
                }, {
                    field: 'no',
                    title: '序号',
                    sortable: true,
                    align: "center",
                    width: "10%",
                    formatter: function (value, row, index) {
                        var pageSize = $bootstrapTable.bootstrapTable('getOptions').pageSize;
                        var pageNumber = $bootstrapTable.bootstrapTable('getOptions').pageNumber;
                        return pageSize * (pageNumber - 1) + index + 1;
                    }
                }, {
                    field: 'fileName',
                    title: '文件名',
                    align: 'center',
                    width: "50%",
                    
                }, {
                    field: 'fileSize',
                    title: '文件大小',
                    align: 'center',
                    width: "10%",
                }, {
                    field: 'createTime',
                    title: '创建时间',
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
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
                return result.data;
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
         * 备份
         */
        $('#backupBtn').click(function () {
            layer.confirm('确认备份数据?', {icon: 3, title: '操作提示'}, function (i) {
                layer.close(i);
                var index = parent.layer.msg("正在备份中,请耐心等候...", {icon: 16, time: 0, shade: 0.3});
                $.post('', function (result) {
                    parent.layer.close(index);
                    if (result.status === 200) {
                        layer.msg(result.msg);
                        $bootstrapTable.bootstrapTable('refresh');
                    } else {
                        layer.msg(result.msg, {icon: 2});
                    }
                });
            });
        });
        /**
         * 恢复
         */
        $('#recoverBtn').click(function () {
            var fileName;
            var checkRows = $bootstrapTable.bootstrapTable('getSelections');
            if (checkRows.length === 0) {
                layer.msg("请选择需要还原的文件", {icon: 2});
                return false;
            } else if (checkRows.length === 1) {
                fileName = checkRows[0].fileName;
            } else {
                layer.msg("只能选择一个文件进行还原", {icon: 2});
                return false;
            }
            layer.confirm('确认恢复?', {icon: 3, title: '操作提示'}, function (i) {
                layer.close(i);
                var index = parent.layer.msg("正在恢复数据中,请耐心等候...", {icon: 16, time: 0, shade: 0.3});
                $.post('database/recover', 'fileName=' + fileName, function (result) {
                    parent.layer.close(index);
                    if (result.status === 200) {
                        layer.msg(result.msg);
                    } else {
                        layer.msg(result.msg, {icon: 2});
                    }
                });
            });
        });
        /**
         * 批量删除文件对话框
         */
        $('#batchDelBtn').click(function () {
            var fileName = '';
            var rows = $bootstrapTable.bootstrapTable('getSelections');
            $.each(rows, function (i, item) {
                fileName = fileName + item.fileName;
                if (i < rows.length - 1) {
                    fileName = fileName + ',';
                }
            });
            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                layer.close(index);
                layer.load(2);
                $.post('', '_method=delete&fileName=' + fileName, function (result) {
                    layer.closeAll('loading');
                    if (result.status === 200) {
                        layer.msg(result.msg);
                        $bootstrapTable.bootstrapTable('refresh');
                    } else {
                        layer.msg(result.msg, {icon: 2});
                    }
                });
            });
        });
        /**
         * 打开配置modal
         */
        $('#configBtn').click(function () {
            $('#configModal').modal();
        });
        /**
         * 保存配置
         */
        $('#configForm').validator().on('submit', function (e) {
            if (e.isDefaultPrevented()) {
                //验证不通过
            } else {
                e.preventDefault();
                var data = $('#configForm').serialize();
                layer.load(2);
                $.post('', data + '&_method=put', function (result) {
                    if (result.status === 200) {
                        $('#configModal').modal('hide');
                    }
                    layer.msg(result.msg);
                    layer.closeAll('loading');
                });
            }
        });
    });
</script>
</body>
</html>
