<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>基础数据</title>
    <%@include file="../common/css.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/js/jquery-treegrid/css/jquery.treegrid.css">
    <style>
        .modal-body {
            padding-right: 10px;
        }

        .map_title {
            border: solid 1px red !important;
            background: none;
            color: red;
        }

        .amap-marker-label {
            background: none !important;
        }

        label {
            text-align: left !important;
            height: 34px;
            line-height: 34px;
        }

        .table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
            vertical-align: middle !important;
        }

        .dtmb {
            margin: 1%;
            border: 1px solid #FFFFFF;
            border-radius: 10px;
            padding: 1%;
        }
        .dtmb .form-control{
            width: 50%!important;
        }
    </style>
</head>
<body>
<h4><b>当前位置:系统管理>>基础数据</b></h4>
<ul class="nav nav-tabs">
    <li class="selected_tab"><a>行政区域</a></li>
    <li><a>厂商管理</a></li>
    <li><a>调制方式</a></li>
    <c:forEach var="category" items="${dictCategories}">
        <li data-code="${category.fDictionaryCode}" data-id="${category.fId}">
            <a>${category.fDictionaryContent}</a></li>
    </c:forEach>
</ul>
<div class="tab_modal show">
    <div class="handle">
        &ensp;<button class="btn btn-danger" id="batchDelRegionBtn" style="display: none;">批量删除</button>
        <%--<button class="btn btn-info" id="initBtn">初始化</button>--%>
        <button class="btn btn-info" id="templateBtn">下载模板</button>
        <button class="btn btn-info" id="importBtn">导入</button>
        <input name="file" type="file" class="hidden" id="importFile" accept=".xls,.xlsx">
    </div>
    <table id="tab_region_data"></table>
</div>
<div class="tab_modal">
    <div class="handle">
        <button class="btn btn-danger" id="batchDelMfrBtn" style="display: none;">批量删除</button>
        <button class="btn btn-info" id="addMfrBtn">新增</button>
    </div>
    <table id="tab_mfr_data"></table>
</div>
<div class="tab_modal">
    <!-- 调制方式  lxg  2019-02-20 -->
    <form id="modulationMode_form" class="form-inline" onsubmit="return true" method="post">
      <!-- <div class="col-sm-12 "> -->
       <div class="form-group col-sm-5">
            <label class="col-sm-4 control-label">Service ID</label>
            <input type="text" class="form-control" name="fServiceId" value="1"/>
        </div>
        <div class="form-group col-sm-5">
            <label class="col-sm-4 control-label">PCR PID</label>
            <input type="text" class="form-control" name="fPcrPid" value="1"/>
        </div>
        <div class="col-sm-12 ">
            <div class="col-sm-12 form-group ">
                <label class="col-sm-12 control-label">DTMB: </label>
            </div>
            <div class="dtmb">
 
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">频率</label>
                    <input type="text" class="form-control" name="fDtmbCentreFrequency"  placeholder="506"  value=""/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">调制方式</label>
                    <select class="form-control" name="fDtmbModulation">
                        <option value="0">未定义</option>
                        <option value="1">4-QAM</option>
                        <option value="2">4-QAM-NR</option>
                        <option value="3">16-QAM</option>
                        <option selected="selected" value="4">32-QAM</option>
                        <option value="5">64-QAM</option>
                    </select>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">FEC前向纠错外码</label>
                    <input type="text" class="form-control" name="fDtmbFec" value="0"/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">子载波数量</label>
                    <input type="text" class="form-control" name="fDtmbNumberOfSubcarrier" value="1"/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">帧头模式</label>
                    <input type="text" class="form-control" name="fDtmbFrameHeaderMode" value="0"/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">交织模式</label>
                    <input type="text" class="form-control" name="fDtmbInterleavingMode" value="0"/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">其它频率标志</label>
                    <input type="text" class="form-control" name="fDtmbOtherFrequencyFlag" value="0"/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">单频网多频标志</label>
                    <input type="text" class="form-control" name="fDtmbSfnMfnFlag" value="0"/>
                </div>
                <div class="null"></div>
            </div>
            <div class="col-sm-12 form-group ">
                <label class="col-sm-12 control-label">DVB-C: </label>
            </div>
            <div class="dtmb">
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">频率</label>
                    <input type="text" class="form-control" name="fDvbcFrequency" placeholder="408" value=""/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">调制方式</label>
                    <select class="form-control" name="fDvbcModulation">
                        <option value="0">未定义</option>
                        <option value="1">16-QAM</option>
                        <option selected="selected" value="2">32-QAM</option>
                        <option value="3">64-QAM</option>
                        <option value="4">128-QAM</option>
                        <option value="5">256-QAM</option>
                    </select>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">符号率</label>
                    <input type="text" class="form-control" name="fDvbcSymbolRate" placeholder="6875" value=""/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">前向纠错外码</label>
                    <input type="text" class="form-control" name="fDvbcFecOuter" value="0"/>
                </div>
                <div class="form-group col-sm-5">
                    <label class="col-sm-4 control-label">前向纠错内码</label>
                    <input type="text" class="form-control" name="fDvbcFecInner" value="0"/>
                </div>
                <div class="null"></div>
            </div>
            <div class="form-group col-sm-6">
                <button id="btn_modulationMode" type="button" class="btn btn-info">确定</button>
            </div>
        </div>
    </form>
</div>
<div class="tab_modal">
    <div class="handle">
        <button class="btn btn-danger" id="batchDelBaseBtn" style="display: none;">批量删除</button>
        <button class="btn btn-info" id="addBaseBtn">新增</button>
    </div>
    <table id="tab_base_data"></table>
</div>
<!-- 新增模态框（Modal） -->
<div class="modal fade" id="baseModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <form id="baseForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">新增字典</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">选项名称</label>
                        <div class="col-sm-8">
                            <input type="hidden" id="fId" name="fId">
                            <input type="text" class="form-control" maxlength="320" id="fDictionaryContent"
                                   name="fDictionaryContent" required>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">选项代码</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" maxlength="320" id="fThirdCode"
                                   name="fThirdCode">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">排序</label>
                        <div class="col-sm-8">
                            <input type="number" min="0" max="100" class="form-control" id="fSort" name="fSort">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="confirmBase" class="btn btn-info">确定</button>
                    <button type="button" id="cancel" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<!-- 新增模态框（Modal） -->
<div class="modal fade" id="regionModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="regionForm" action="baseData/region" data-toggle="validator">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">名称</label>
                        <div class="col-sm-8">
                            <input type="hidden" id="regionId" name="fId">
                            <input type="hidden" id="fParentNode" name="fParentNode">
                            <input type="text" class="form-control" id="fName" name="fName" maxlength="40" required>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">编码</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="fCode" maxlength="12" name="fCode">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">排序</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" id="regionSort" name="fSort" min="0" max="100">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">经纬度</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fLongitude" name="fLongitude" maxlength="40"
                                   required style="border-bottom-right-radius: 0;border-top-right-radius: 0;">
                        </div>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fLatitude" name="fLatitude" maxlength="40"
                                   required style="border-bottom-left-radius: 0;border-top-left-radius: 0;">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <div id="container" class="map" style="width: 100%;height: 300px;"></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="confirmRegion" class="btn btn-info">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<!-- 厂商-新增模态框（Modal） -->
<div class="modal fade" id="mfrModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="mfrForm" action="baseData/mfr" data-toggle="validator">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">厂商名称</label>
                        <div class="col-sm-8">
                            <input type="hidden" id="mfrId" name="fId">
                            <input type="text" maxlength="32" class="form-control" id="fManufacturerName"
                                   name="fManufacturerName" required>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">厂商编号</label>
                        <div class="col-sm-8">
                            <input type="text" maxlength="16" class="form-control" id="fManufacturerNo"
                                   name="fManufacturerNo">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">厂商地址</label>
                        <div class="col-sm-8">
                            <input type="text" maxlength="128" class="form-control" id="fManufacturerAddress"
                                   name="fManufacturerAddress">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">联系人</label>
                        <div class="col-sm-8">
                            <input type="text" maxlength="32" class="form-control" id="fLinkman" name="fLinkman">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">联系电话</label>
                        <div class="col-sm-8">
                            <input type="text" maxlength="32" class="form-control" id="fTel" name="fTel">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">排序</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" id="mfrSort" name="fSort" min="0" max="100">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="mfrRegion" class="btn btn-info">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<%@include file="../common/js.jsp" %>
<script src="${ctx}/static/js/jquery-treegrid/js/jquery.treegrid.js"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap-table-treegrid.min.js"></script>
<script src="https://webapi.amap.com/maps?v=1.4.11&key=${config.amap_js_key}&plugin=AMap.Autocomplete"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/validator.min.js"></script>
<script type="text/javascript">
    $(function () {

        /**
         * 调制方式   lxg  2019-02-20
         */
        $('#btn_modulationMode').click(function () {
            $.ajax({
                url: "${ctx}/systemManage/baseData/modulationMode",
                type: 'post',
                data: $('#modulationMode_form').serialize(),
                success: function (data) {
                }
            });
        });

        /**
         * 繪製點
         * @param longitude 經度
         * @param latitude 緯度
         * @param title 標題
         */
        function markPoint(longitude, latitude, title) {
            var label = {};
            if (title) {
                label = {
                    offset: new AMap.Pixel(15, -20),
                    content: "<div class='map_title'>" + title + "</div>"
                };
            }
            map.clearMap();
            var marker = new AMap.Marker({
                position: [longitude, latitude],
                draggable: true,
                label: label
            });
            map.add(marker);
            marker.on('dragend', function (e) {
                setPosition(e.lnglat.getLng(), e.lnglat.getLat());
            });
        }

        /**
         * 初始地圖
         * @param longitude 經度
         * @param latitude 緯度
         * @param title 標題
         */
        function initMap(longitude, latitude, title) {
            map.clearMap();
            if (longitude && latitude) {
                map.setCenter([longitude, latitude]);
                if (title) {
                    markPoint(longitude, latitude, title);
                }
            }
            map.on('click', function (e) {
                markPoint(e.lnglat.getLng(), e.lnglat.getLat(), title);
                setPosition(e.lnglat.getLng(), e.lnglat.getLat());
            });
        }

        /**
         * 設置經緯度
         * @param longitude 經度
         * @param latitude 緯度
         */
        function setPosition(longitude, latitude) {
            $('#fLongitude').val(longitude).trigger('input');
            $('#fLatitude').val(latitude).trigger('input');
        }

        $('.nav.nav-tabs li').on('click', function () {
            var index = $(this).index();
            var $tabModal = $('.tab_modal'), length = $tabModal.length;
            if (index > length - 1) {
                index = length - 1;
            }
            $tabModal.eq(index).addClass('show').siblings().removeClass('show').end();
            if ($(this).data('id')) {
                changeDict($(this).data('code'), $(this).data('id'), $(this).text());
            }
        });
        var $baseTable = $('#tab_base_data'),
            code = '',//字典code
            name = '',//字典分类名称
            pid = 0;//字典父id
        //切换字典数据
        function changeDict(_code, _pid, _name) {
            code = _code;
            pid = _pid;
            name = _name;
            refreshBaseTable();
        }

        $baseTable.bootstrapTable({
            url: "",
            method: 'get',
            sortable: false,
            sidePagination: 'server',
            smartDisplay: false,
            columns: [[
                {
                    field: 'isChecked',
                    checkbox: true
                }, {
                    field: 'fDictionaryContent',
                    title: '选项名称',
                    align: 'center'
                }, {
                    field: 'fThirdCode',
                    title: '选项代码',
                    align: 'center'
                }, {
                    field: 'fSort',
                    title: '排序',
                    align: 'center',
                    width: '60',
                }, /*{
                    field: 'fCreateTime',
                    title: '创建时间',
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                    },
                    width: '15%'
                }, {
                    field: 'fUpdateTime',
                    title: '修改时间',
                    align: 'center',
                    formatter: function (time) {
                        return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : '';
                    },
                    width: '15%'
                },*/ {
                    title: '操作',
                    align: 'center',
                    width: '15%',
                    events: {
                        'click .edit-base-btn': function (e, val, row) {
                            $('#fId').val(row.fId);
                            $('#fDictionaryContent').val(row.fDictionaryContent);
                            $('#fThirdCode').val(row.fThirdCode);
                            $('#fSort').val(row.fSort);
                            $('.modal-title').html('修改' + name);
                            $('#baseModal').modal();
                        },
                        'click .del-base-btn': function (e, val, row) {
                            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                                delBase(row.fId, index);
                            });
                        }
                    },
                    formatter: function () {
                        return '<button class="btn btn-info btn-sm edit-base-btn">修改</button> <button class="btn btn-danger btn-sm del-base-btn">删除</button>';
                    }
                }]],
            formatNoMatches: function () {
                return '无记录';
            },
            onCheck: function () {
                handleBatchDeleteBaseBtn();
            },
            onUncheck: function () {
                handleBatchDeleteBaseBtn();
            },
            onCheckAll: function () {
                handleBatchDeleteBaseBtn();
            },
            onUncheckAll: function () {
                handleBatchDeleteBaseBtn();
            }
        });

        /**
         * 批量删除按钮是否显示
         */
        function handleBatchDeleteBaseBtn() {
            var checkRows = $baseTable.bootstrapTable('getSelections');
            var $batchDelBtn = $('#batchDelBaseBtn');
            if (checkRows.length > 0) {
                $batchDelBtn.show();
            } else {
                $batchDelBtn.hide();
            }
        }

        /**
         * 删除字典
         * @param dictId 字典id,多个以','分隔
         * @param index 弹出层index
         */
        function delBase(dictId, index) {
            layer.load(2);
            $.post('baseData/dict', '_method=delete&dictId=' + dictId, function (result) {
                if (result.status === 200) {
                    refreshBaseTable();
                    $('#batchDelBaseBtn').hide();
                }
                layer.msg(result.msg);
                layer.close(index);
                layer.closeAll('loading');
            });
        }

        /**
         * 批量删除字典对话框
         */
        $('#batchDelBaseBtn').click(function () {
            var dictId = '';
            var rows = $baseTable.bootstrapTable('getSelections');
            $.each(rows, function (i, item) {
                dictId = dictId + item.fId;
                if (i < rows.length - 1) {
                    dictId = dictId + ',';
                }
            });
            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                delBase(dictId, index);
            });
        });
        /**
         * 添加字典
         */
        $('#addBaseBtn').click(function () {
            $('#baseForm')[0].reset();
            $('#fId').val('');
            $('.modal-title').html('新增' + name);
            $('#baseModal').modal();
        });

        function refreshBaseTable() {
            $baseTable.bootstrapTable('refresh', {url: 'baseData/dict?code=' + code});
        }

        /**
         * 保存
         */
        $('#baseForm').validator().on('submit', function (e) {
            if (e.isDefaultPrevented()) {
                //验证不通过
            } else {
                e.preventDefault();
                $('#baseModal').modal('hide');
                var data = $('#baseForm').serialize();
                if (!$('#fId').val()) {
                    data = data + '&fDictionaryType=' + pid + '&fDictionaryCode=' + code;
                }
                layer.load(2);
                $.post('baseData/dict', data, function (result) {
                    if (result.status === 200) {
                        refreshBaseTable();
                    }
                    layer.msg(result.msg);
                    layer.closeAll('loading');
                });
            }
        });
        var $regionTable = $('#tab_region_data');
        $regionTable.bootstrapTable({
            url: "baseData/region",
            method: 'get',
            idField: 'fId',
            sortable: false,
            columns: [[
                {
                    field: 'isChecked',
                    checkbox: true
                }, {
                    field: 'fCode',
                    title: '编码',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fName',
                    title: '名称',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fLongitude',
                    title: '经度',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fLatitude',
                    title: '纬度',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fSort',
                    title: '排序',
                    width: "10%",
                    align: 'center'
                }/*, {
                    field: 'fCreateTime',
                    title: '创建时间',
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                    },
                    width: '150'
                }, {
                    field: 'fUpdateTime',
                    title: '修改时间',
                    align: 'center',
                    formatter: function (time) {
                        return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : '';
                    },
                    width: '150'
                }*/, {
                    title: '操作',
                    align: 'center',
                    events: {
                        'click .add-base-btn': function (e, val, row) {
                            $('#regionForm')[0].reset();
                            $('#regionId').val('');
                            $('#fParentNode').val(row.fId);
                            $('.modal-title').html('新增区域');
                            $('#regionModal').modal();
                            initMap(row.fLongitude, row.fLatitude);
                        },
                        'click .edit-base-btn': function (e, val, row) {
                            $('.modal-title').html('编辑区域');
                            $('#regionId').val(row.fId);
                            $('#fParentNode').val(row.fParentNode);
                            $('#fName').val(row.fName);
                            $('#fCode').val(row.fCode);
                            $('#regionSort').val(row.fSort);
                            $('#fLongitude').val(row.fLongitude);
                            $('#fLatitude').val(row.fLatitude);
                            $('#regionModal').modal();
                            initMap(row.fLongitude, row.fLatitude, row.fName);
                        },
                        'click .del-base-btn': function (e, val, row) {
                            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                                delRegion(row.fId, index);
                            });
                        }
                    },
                    formatter: function (value, row) {
                        if (row._level === 0) {
                            return '<button class="btn btn-info btn-sm add-base-btn">添加下级</button> <button class="btn btn-info btn-sm edit-base-btn">修改</button>';
                        } else if (row._level === 1) {
                            return '<button class="btn btn-info btn-sm add-base-btn">添加下级</button> <button class="btn btn-info btn-sm edit-base-btn">修改</button> <button class="btn btn-danger btn-sm del-base-btn">删除</button>';
                        } else {
                            return '<button class="btn btn-info btn-sm edit-base-btn">修改</button> <button class="btn btn-danger btn-sm del-base-btn">删除</button>';
                        }
                    }
                }]],
            treeShowField: 'fName',
            parentIdField: 'fParentNode',
            onLoadSuccess: function (data) {
                $regionTable.treegrid({
                    treeColumn: 2,
                    onChange: function () {
                        $regionTable.bootstrapTable('resetWidth');
                    }
                });
            },
            responseHandler: function (result) {
                return result.data;
            },
            formatNoMatches: function () {
                return '无记录';
            },
            onCheck: function () {
                handleBatchDeleteRegionBtn();
            },
            onUncheck: function () {
                handleBatchDeleteRegionBtn();
            },
            onCheckAll: function () {
                handleBatchDeleteRegionBtn();
            },
            onUncheckAll: function () {
                handleBatchDeleteRegionBtn();
            }
        });

        /**
         * 批量删除按钮是否显示
         */
        function handleBatchDeleteRegionBtn() {
            var checkRows = $regionTable.bootstrapTable('getSelections');
            var $batchDelBtn = $('#batchDelRegionBtn');
            if (checkRows.length > 0) {
                $batchDelBtn.show();
            } else {
                $batchDelBtn.hide();
            }
        }

        /**
         * 删除区域
         * @param regionId 区域id,多个以','分隔
         * @param index 弹出层index
         */
        function delRegion(regionId, index) {
            layer.load(2);
            $.post('baseData/region', '_method=delete&regionId=' + regionId, function (result) {
                if (result.status === 200) {
                    refreshRegionTable();
                    $('#batchDelRegionBtn').hide();
                }
                layer.msg(result.msg);
                layer.close(index);
                layer.closeAll('loading');
            });
        }

        /**
         * 批量删除区域对话框
         */
        $('#batchDelRegionBtn').click(function () {
            var regionId = '';
            var rows = $regionTable.bootstrapTable('getSelections');
            $.each(rows, function (i, item) {
                regionId = regionId + item.fId;
                if (i < rows.length - 1) {
                    regionId = regionId + ',';
                }
            });
            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                delRegion(regionId, index);
            });
        });

        function refreshRegionTable() {
            $regionTable.bootstrapTable('refresh');
        }

        /**
         * 保存
         */
        $('#regionForm').validator().on('submit', function (e) {
            if (e.isDefaultPrevented()) {
                //验证不通过
            } else {
                e.preventDefault();
                $('#regionModal').modal('hide');
                var data = $('#regionForm').serialize();
                layer.load(2);
                $.post('baseData/region', data, function (result) {
                    if (result.status === 200) {
                        refreshRegionTable();
                    }
                    layer.msg(result.msg);
                    layer.closeAll('loading');
                });
            }
        });
        //初始化行政区域
        $('#initBtn').click(function () {
            layer.load(1);
            $.post('baseData/region/init', function (result) {
                if (result.status === 200) {
                    layer.msg(result.msg, {icon: 1});
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
                layer.closeAll('loading');
            });
        });
        //下载模板
        $('#templateBtn').click(function () {
            window.open('baseData/region/template');
        });
        //导入区域
        $('#importBtn').click(function () {
            $('#importFile').click();
        });
        $('body').on('change', '#importFile', function () {
            var form = new FormData();
            form.append("file", document.getElementById("importFile").files[0]);
            var file = $("#importFile");
            file.after(file.clone().val(""));
            file.remove();
            layer.load(2);
            $.ajax({
                url: "baseData/region/import",
                type: "post",
                data: form,
                processData: false,
                contentType: false,
                success: function (result) {
                    layer.closeAll('loading');
                    if (result.status === 200) {
                        layer.msg(result.msg, {icon: 1});
                        refreshRegionTable();
                    } else {
                        layer.msg(result.msg, {icon: 2});
                    }
                },
                error: function () {
                    layer.msg("上传失败");
                    layer.closeAll('loading');
                }
            });
        });
        var $mfrTable = $('#tab_mfr_data');
        $mfrTable.bootstrapTable({
            url: "baseData/manufacturer",
            method: 'get',
            idField: 'fId',
            sortable: false,
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            columns: [[
                {
                    field: 'isChecked',
                    checkbox: true
                }, {
                    field: 'fManufacturerName',
                    title: '厂商名称',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fManufacturerNo',
                    title: '厂商编号',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fManufacturerAddress',
                    title: '厂商地址',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fLinkman',
                    title: '联系人',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fTel',
                    title: '联系电话',
                    align: 'center',
                    width: "15%",
                }, {
                    field: 'fSort',
                    title: '排序',
                    width: "5%",
                    align: 'center'
                }/*, {
                    field: 'fCreateTime',
                    title: '创建时间',
                    width: '150',
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                    }
                }, {
                    field: 'fUpdateTime',
                    title: '修改时间',
                    align: 'center',
                    width: '150',
                    formatter: function (time) {
                        return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : '';
                    }
                }*/, {
                    title: '操作',
                    align: 'center',
                    events: {
                        'click .edit-mfr-btn': function (e, val, row) {
                            $('.modal-title').html('编辑厂商');
                            $('#mfrId').val(row.fId);
                            $('#fManufacturerName').val(row.fManufacturerName);
                            $('#fManufacturerNo').val(row.fManufacturerNo);
                            $('#fManufacturerAddress').val(row.fManufacturerAddress);
                            $('#fLinkman').val(row.fLinkman);
                            $('#fTel').val(row.fTel);
                            $('#mfrSort').val(row.fSort);
                            $('#mfrModal').modal();
                        },
                        'click .del-mfr-btn': function (e, val, row) {
                            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                                delMfr(row.fId, index);
                            });
                        }
                    },
                    formatter: function () {
                        return '<button class="btn btn-info btn-sm edit-mfr-btn">修改</button> <button class="btn btn-danger btn-sm del-mfr-btn">删除</button>';
                    }
                }]],
            responseHandler: function (result) {
                return {total: result.data.total, rows: result.data.list};
            },
            formatNoMatches: function () {
                return '无记录';
            },
            onCheck: function () {
                handleBatchDeleteMfrBtn();
            },
            onUncheck: function () {
                handleBatchDeleteMfrBtn();
            },
            onCheckAll: function () {
                handleBatchDeleteMfrBtn();
            },
            onUncheckAll: function () {
                handleBatchDeleteMfrBtn();
            }
        });

        /**
         * 批量删除按钮是否显示
         */
        function handleBatchDeleteMfrBtn() {
            var checkRows = $mfrTable.bootstrapTable('getSelections');
            var $batchMfrBtn = $('#batchDelMfrBtn');
            if (checkRows.length > 0) {
                $batchMfrBtn.show();
            } else {
                $batchMfrBtn.hide();
            }
        }

        /**
         * 删除厂商
         * @param mfrId 厂商id,多个以','分隔
         * @param index 弹出层index
         */
        function delMfr(mfrId, index) {
            layer.load(2);
            $.post('baseData/manufacturer', '_method=delete&manufacturerId=' + mfrId, function (result) {
                if (result.status === 200) {
                    refreshMfrTable();
                    $('#batchDelMfrBtn').hide();
                }
                layer.msg(result.msg);
                layer.close(index);
                layer.closeAll('loading');
            });
        }

        /**
         * 批量删除厂商对话框
         */
        $('#batchDelMfrBtn').click(function () {
            var mfrId = '';
            var rows = $mfrTable.bootstrapTable('getSelections');
            $.each(rows, function (i, item) {
                mfrId = mfrId + item.fId;
                if (i < rows.length - 1) {
                    mfrId = mfrId + ',';
                }
            });
            layer.confirm('确认删除?', {icon: 3, title: '操作提示'}, function (index) {
                delMfr(mfrId, index);
            });
        });

        function refreshMfrTable() {
            $mfrTable.bootstrapTable('refresh');
        }

        /**
         * 保存
         */
        $('#mfrForm').validator().on('submit', function (e) {
            if (e.isDefaultPrevented()) {
                //验证不通过
            } else {
                e.preventDefault();
                $('#mfrModal').modal('hide');
                var data = $('#mfrForm').serialize();
                layer.load(2);
                $.post('baseData/manufacturer', data, function (result) {
                    if (result.status === 200) {
                        refreshMfrTable();
                    }
                    layer.msg(result.msg);
                    layer.closeAll('loading');
                });
            }
        });
        $('#addMfrBtn').click(function () {
            $('#mfrForm')[0].reset();
            $('#mfrId').val('');
            $('.modal-title').html('新增厂商');
            $('#mfrModal').modal();
        });
    });
    
    var map = new AMap.Map("container", {
        resizeEnable: true,
        zoom: 10
    });
    window.onload = function () {
        map.plugin(["AMap.ToolBar"], function () {
            map.addControl(new AMap.ToolBar());
        });
        if (location.href.indexOf('&guide=1') !== -1) {
            map.setStatus({scrollWheel: false})
        }
    };
</script>
</body>
</html>