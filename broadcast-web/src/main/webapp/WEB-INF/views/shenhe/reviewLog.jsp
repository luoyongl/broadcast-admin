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
    <title>审核日志</title>
    <%@include file="../common/css.jsp" %>
    <style>
        .content {
			height: 99%;
			width: 99%;
		}

		.form-inline {
			position: fixed;
			width: 63%;
			margin-left: 1%;
			height: 100%;
		}

		.table {
			margin-bottom: auto;
		}

		.bootstrap-table {
			margin-top: 0.5%;
		}

		.fixed-table-loading {
			display: none;
		}

		.tablemodelshenhe {
			display: none;
		}

		.showshenhe {
			display: block;
		}

		.nav li {
			float: left;
			width: 5%;
			margin-top: 0.1%;
			margin-right: 0.5%;
			text-align: center;
		}

		.content {
			border: 1px solid #FFFFFF;
			border-radius: 10px;
			padding: 1% 1.5%;
		}

		#details_shenheLog_modal .modal-dialog {
			overflow-y: scroll;
		}



		table{
			table-layout:fixed;
		}

		#tab_shenheLog1 tbody tr td{
			width:150px;
			overflow: hidden;
			text-overflow:ellipsis;
			white-space: nowrap;
		}
    </style>
</head>
<body>
<h4><b>当前位置:播发审核>>审核日志</b></h4>
<div class="content">
    <div class="handle">
        <button type="button" id="reviewDataDownload" style="margin-left:0px" id="btn_download" class="btn btn-primary" >导出</button>
    </div>
    <table  data-height="450" id="tab_reviewLog" class="table table-hover"></table>
</div>

<!-- 详情模态框（Modal） -->
<div class="modal fade" id="details_shenheLog_modal" tabindex="-1" role="dialog"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="roleForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;</button>
                    <h4 class="modal-title">详情</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">广播类型:</label>
                        <div class="col-sm-8">
                            <span id="fBroadcastType"></span>
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
                            <span id="fRealMsgresource"></span>
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
                            <span id="fVolumeControl"></span>

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
                        <label class="col-sm-4 control-label">审核人:</label>
                        <div class="col-sm-8">
                            <span id="reviewer"></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">审核时间:</label>
                        <div class="col-sm-8">
                            <span id="fReviewTime"></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">审核结果:</label>
                        <div class="col-sm-8">
                            <span id="fReviewResult"></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">审核意见:</label>
                        <div class="col-sm-8">
                            <span id="fRemark"></span>
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
    var shenhe_data;

    $("#reviewDataDownload").on("click", function(){
        layer.confirm('确定要导出所有记录吗？',{
            title:['操作提示'],
            btn: ['确定','取消'] //按钮
        },function(){
            window.location.href = '${ctx}/shenhe/shenheLog/download';
            layer.close(index);
        },function(){})

    });


    var columns  =	[[
        {
            field : 'fReviewType',
            title : '广播类型',
            width: "10%",
			align : 'center',
            formatter:function(value, row, index){
                if(row.fBroadcastType==1){
                    return "系统演练";
                }else if(row.fBroadcastType==2){
                    return "模拟演练";
                }else if(row.fBroadcastType==3){
                    return "实际演练";
                } else if(row.fBroadcastType==4){
                    return "应急广播";
                }else if(row.fBroadcastType==5){
                    return "日常广播";
                }else if(row.fBroadcastType==6){
                    return "升级广播";
                }else if(row.fBroadcastType==7){
                    return "广播预案-应急广播";
                }else if(row.fBroadcastType==8){
                    return "广播预案-日常广播";
                }else if(row.fBroadcastType==9){
                    return "广播预案-实际演练";
                }else if(row.fBroadcastType==10){
                    return "广播预案-系统演练";
                }else if(row.fBroadcastType==11) {
                    return "广播预案-模拟演练";
                }else if(row.fBroadcastType==12){
                    return "定时广播";
                }
            }
        },{
            field: 'fReviewObjectId',
            title: '广播ID',
            width: "5%",
			align : 'center',
        },{
            field: 'fRealMessageType',
            title: '消息类型',
            width: "10%",
			align : 'center',
        },{
            field: 'fRealMessageLevel',
            title: '消息级别',
            width: "10%",
			align : 'center',
        },{
            field: 'fRealMsgresource',
            title: '消息来源',
            width: "13%",
			align : 'center',
        } ,{
            field: 'fRealArea',
            title: '播发区域',
            width: "13%",
			align : 'center',
        },{
            field : 'fReviewTime',
            title : '审核时间',
            width: "15%",
			align : 'center',
            sortable : true,
            formatter : function(time) {
                if(time!=null){
                    return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                }else {
                    return "";
                }

            },
        },{
            field : 'reviewer',
            title : '审核人',
            width: "7%",
			align : 'center',
        },
        {
            field : 'fReviewResult',
            title : '审核结果',
            width: "10%",
			align : 'center',
            formatter : function(value) {
                if(value==0){
                    return '<span class="label label-danger">待审核</span>';
                }else if(value==1){
                    return '<span class="label label-warning">不通过</span>';
                }else if(value==2){
                    return '<span class="label label-success">通过</span>';
                }else if(value==4){
                    return '<span class="label label-success">已过期</span>';
                }else {
                    return '<span class="label label-danger">未知状态</span>';
                }

            }
        },{
            field : 'ee',
            title : '操作',
            align : 'center',
            events:{
                'click .edit-base-btn': function (e, val, row) {
                    var data = shenhe_data;
                    for(var i=0; i<data.length; i++){
                        if(data[i].fId==row.fId){
                            $('#fId').text(data[i].fId);
                            $('#fCreateTime').text(new Date(data[i].fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                            $('#fVolumeControl').text(data[i].fVolumeControl);
                            $('#fRealArea').text(data[i].fRealArea);
                            $('#fRealMessageLevel').text(data[i].fRealMessageLevel);
                            $('#fRealMessageType').text(data[i].fRealMessageType);
                            if(data[i].fRemark!=null){
                                $('#fRemark').text(data[i].fRemark);
                            }else{
                                $('#fRemark').text("");
                            }
                            $('#fReviewResult').text("待审核");
                            if(data[i].reviewer!=null){
                                $('#reviewer').text(data[i].reviewer);
                            }else{
                                $('#reviewer').text("");
                            }
                            if(data[i].fRealControlDevice!=null){
                                $('#fRealControlDevice').text(data[i].fRealControlDevice);
                            }else{
                                $('#fRealControlDevice').text("");
                            }
                            if(data[i].fReviewTime!=null){
                                $('#fReviewTime').text(new Date(data[i].fReviewTime).format('yyyy-MM-dd HH:mm:ss'));
                            }else{
                                $('#fReviewTime').text("");
                            }
                            if(data[i].fRealMsgresource!=null){
                                $('#fRealMsgresource').text(data[i].fRealMsgresource);
                            }else{
                                $('#fRealMsgresource').text("");
                            }

                            if(data[i].fRealControlDevice!=null){
                                $('#fRealControlDevice').text(data[i].fRealControlDevice);
                            }else{
                                $('#fRealControlDevice').text("");
                            }
                            if(data[i].creator!=null){
                                $('#creator').text(data[i].creator);
                            }else{
                                $('#creator').text("");
                            }
                            if(data[i].operator!=null){
                                $('#operator').text(data[i].operator);
                            }else{
                                $('#operator').text("");
                            }
                            if(data[i].fUpdtateTime!=null){
                                $('#fUpdtateTime').text(new Date(data[i].fUpdtateTime).format('yyyy-MM-dd HH:mm:ss'));
                            }else{
                                $('#fUpdtateTime').text("");
                            }
                            if(shenhe_data[i].fId==row.fId){
                                if(shenhe_data[i].fReviewResult==0){
                                    $('#fReviewResult').text("待审核");
                                }else if(shenhe_data[i].fReviewResult==1){
                                    // $('#fReviewResult').text("不通过");
                                    $("#fReviewResult").html('<span class="label label-warning">不通过</span>');
                                }else if(shenhe_data[i].fReviewResult==2){

                                    $("#fReviewResult").html('<span class="label label-info">通过</span>');
                                }else{
                                    $('#fReviewResult').text("未知");
                                }

                            }

                            if(row.fBroadcastType==1){
                                $('#fBroadcastType').text("发布系统演练");
                            }else if(row.fBroadcastType==2){
                                $('#fBroadcastType').text("模拟演练");
                            }else if(row.fBroadcastType==3){
                                $('#fBroadcastType').text("实际演练");
                            } else if(row.fBroadcastType==4){
                                $('#fBroadcastType').text("应急广播");
                            }else if(row.fBroadcastType==5){
                                $('#fBroadcastType').text("日常广播");
                            }else if(row.fBroadcastType==6){
                                $('#fBroadcastType').text("升级广播");
                            }else if(row.fBroadcastType==7){
                                $('#fBroadcastType').text("广播预案-应急广播");
                            }else if(row.fBroadcastType==8){
                                $('#fBroadcastType').text("广播预案-日常广播");
                            }else if(row.fBroadcastType==9){
                                $('#fBroadcastType').text("广播预案-实际演练");
                            }else if(row.fBroadcastType==10){
                                $('#fBroadcastType').text("广播预案-系统演练");
                            }else if(row.fBroadcastType==11){
                                $('#fBroadcastType').text("广播预案-模拟演练");
                            }else if(row.fBroadcastType==12){
                                $('#fBroadcastType').text("定时广播");
                            }

                            /* if(shenhe_data[i].fBroadcastType==0){
                                 $('#fBroadcastType').text("应急广播");
                             }else if(shenhe_data[i].fBroadcastType==1){
                                 $('#fBroadcastType').text("日常广播");
                             }else if(shenhe_data[i].fBroadcastType==2){
                                 $('#fBroadcastType').text("实际演练");
                             }else if(shenhe_data[i].fBroadcastType==3){
                                 $('#fBroadcastType').text("模拟演练");
                             } else if(shenhe_data[i].fBroadcastType==4){
                                 $('#fBroadcastType').text("系统演练");
                             }else if(shenhe_data[i].fBroadcastType==5){
                                 $('#fBroadcastType').text("广播预案-应急广播");
                             }else if(shenhe_data[i].fBroadcastType==6){
                                 $('#fBroadcastType').text("广播预案-日常广播");
                             }else if(shenhe_data[i].fBroadcastType==7){
                                 $('#fBroadcastType').text("广播预案-实际演练");
                             }else if(shenhe_data[i].fBroadcastType==8){
                                 $('#fBroadcastType').text("广播预案-系统演练");
                             }else if(shenhe_data[i].fBroadcastType==9){
                                 $('#fBroadcastType').text("广播预案-模拟演练");
                             }else if(shenhe_data[i].fBroadcastType==10){
                                 $('#fBroadcastType').text("自定义");
                             }else if(shenhe_data[i].fBroadcastType==11){
                                 $('#fBroadcastType').text("定时广播");
                             }else{
                                 return "未知";
                             }*/


                            if(shenhe_data[i].fRealBroadcastTo!=null){
                                $('#fRealBroadcastTo').text(shenhe_data[i].fRealBroadcastTo);
                            }else{
                                $('#fRealBroadcastTo').text("");
                            }
                        }
                    }

                },
            },
            formatter : function() {
                return '<button class="btn btn-info btn-sm edit-base-btn" data-toggle="modal" data-target="#details_shenheLog_modal">详情</button>';
            }
        }
    ]];

    $(function() {
        $(".modal-dialog").draggable();
        $('#tab_reviewLog').bootstrapTable({
            method: 'get', 
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            sortable: true,
            dataType: "json",
            search: true, //是否显示表格搜索
            columns: columns,
            classes:'table-no-bordered',
            url: "${ctx}/shenhe/shenheLog/selectManualAutoLog",
            toolbar : '#toolbarComputer', // 工具按钮用哪个容器
            sortable : true, // 是否启用排序
            sortOrder : "desc", // 排序方式
            pagination : true, // 是否显示分页（*）
            pageNumber : 1, // 初始化加载第一页，默认第一页
            pageSize : 5, // 每页的记录行数（*）
            pageList : [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh : true, // 是否显示刷新按钮
            clickToSelect : true, // 是否启用点击选中行
            uniqueId : "index", // 每一行的唯一标识，一般为主键列表
            sidePagination:'server',
            queryParamsType: "",
            showExport: true,                     //是否显示导出
            exportDataType: "basic",              //basic', 'all', 'selected'.
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    sortOrder:params.sortOrder, //排序方式
                    sortName:params.sortName, //排序名称
                    searchText : params.searchText, //查询内容
                };
            },
            responseHandler:function (result) {
                shenhe_data = result.data.list;
                if(result.status === 200){
                }
                return{
                    total: result.data.total,
                    rows: result.data.list
                };
            }

        });
    });


</script>
</body>
</html>
