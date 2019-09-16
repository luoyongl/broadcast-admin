<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="cn.wtu.broadcast.config.SystemConfig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
%>
<html>

<head>
<meta charset="UTF-8">
<title>查询统计</title>
<%@include file="../common/css.jsp"%>
<style>
	.form-control{
		color: #FFFFFF!important;
		width: 125px!important;
	}
	.form-group {
	    margin: 0.5% 0;
	    padding: 0;
	    padding-left: 15px;
	}
</style>
</head>

<body>
<h4><b>当前位置:效果评估>>查询统计</b></h4>
<div class="content_table">
	<div class="form-inline" id="handleform">
		<div class="form-group">
			<label>广播类型</label> <select class="form-control"
				class="form-control" id="broadcastType" name="broadcastType">
				<option value="">请选择</option>
				<option value="1">发布系统演练</option>
				<option value="2">模拟演练</option>
				<option value="3">实际演练</option>
				<option value="4">应急广播</option>
				<option value="5">日常广播</option>
				<option value="6">升级广播</option>
				<option value="7">广播预案-系统演练</option>
				<option value="8">广播预案-模拟演练</option>
				<option value="9">广播预案-实际广播</option>
				<option value="10">广播预案-应急广播</option>
				<option value="11">广播预案-日常广播</option>
				<option value="12">定时广播</option>
				<option value="13">图文广告</option>
			</select>
		</div>
		<div class="form-group">
			<label>消息类型</label> 
			<input type='text' placeholder="消息类型"
				class="form-control" id="messageType" name="messageType" />
		</div>
		<div class="form-group">
			<label>消息级别</label> 
			<input type='text' placeholder="消息级别"
				class="form-control" id="messageLevel" name="messageLevel" />
		</div>
		<div class="form-group">
			<label>消息来源</label> 
			<input type='text' placeholder="消息来源"
				class="form-control" id="source" name="source" />
		</div>
		<div class="form-group">
			<label>播发区域</label> 
			<input type='text' placeholder="播发区域"
				class="form-control" id="broadcastArea" name="broadcastArea" />
		</div>
		<div class="form-group">
			<label>操作者</label> 
			<input type='text' placeholder="操作者"
				class="form-control" id="Reviewer" name="Reviewer"
				style="margin-left: 15px" />
		</div>
		<div class="form-group">
			<label>有效起始时间</label> 
			<input type="text" id="effectiveStartTime" name="effectiveStartTime" class="jeinput data-YYYY-MM-DD-HH-mm-ss_update1 form-control " placeholder="有效起始时间">
		</div>
		<div class="form-group">
			<label>有效结束时间</label> 
			<input type="text" id="effectiveEndTime" name="effectiveEndTime" class="jeinput data-YYYY-MM-DD-HH-mm-ss_update2 form-control " placeholder="有效结束时间">
		</div>
		<div class="form-group">
			<label>状态</label> 
			<select class="form-control"
				class="form-control" id="auditResults" name="auditResults"
				style="min-width: 120px">
				<option value="">请选择</option>
				<option value="待审核">待审核</option>
				<option value="待播发">待播发</option>
				<option value="正在播">正在播</option>
				<option value="已播发">已播发</option>
				<option value="不通过">不通过</option>
				<option value="已过期">已过期</option>
			</select>
		</div>
		<div class="form-group" style="margin-left: 8px">
			<button class="btn btn-info" id="searchBtn" onclick="search();">查询</button>
		</div> 
	</div>
	<table data-height="450" id="tab_query" class="table table-hover"></table>
</div>
<!-- 详情模态框（Modal） -->
<div class="modal fade" id="details_broadcast_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title">详情</h4>
            </div>
            <div class="modal-body">
            	<form id="roleForm">
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
                        <label class="col-sm-4 control-label">有效时间:</label>
                        <div class="col-sm-8">
                            <span id="fEffectiveTime"></span>
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
           		</form>
            </div>
            <div class="modal-footer ">
                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<%@include file="../common/js.jsp"%>
<script src="${ctx}/static/js/moment-with-locales.js"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
var mySearchText;
var columns  =	[
    {
        field: 'fId',
        title: '广播ID',
		align : 'center',
    },{
        field : 'fReviewType',
        title : '广播类型',
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
        field: 'fRealMessageType',
        title: '消息类型',
		align : 'center',
    },{
        field: 'fRealMessageLevel',
        title: '消息级别',
		align : 'center',
    },{
        field: 'fRealMessageSource',
        title: '消息来源',
		align : 'center',
    } ,{
        field: 'fRealArea',
        title: '播发区域',
		align : 'center',
    },{
    	 field: 'fEffectiveTime',
         title: '有效时间',
         align: 'center',
         sortable: true,
         formatter: function (time) {
             return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : "";
         },
    },{
    	field: 'creator',
        title: '操作者',
        align: 'center'
    },
    {
    	field: 'fState',
        title: '状态',
        sortable: true,
        align: 'center',
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
    },{
        title : '操作',
        align : 'center',
        events:{
            'click .edit-base-btn': function (e, val, row) {
	             switch(row.fBroadcastType) {
		             case 1: $('#fBroadcastType').text("系统演练"); break;
		             case 2: $('#fBroadcastType').text("模拟演练"); break;
		             case 3: $('#fBroadcastType').text("实际演练"); break;
		             case 4: $('#fBroadcastType').text("应急广播"); break;
		             case 5: $('#fBroadcastType').text("日常广播"); break;
		             case 6: $('#fBroadcastType').text("升级广播"); break;
		             case 7: $('#fBroadcastType').text("广播预案-应急广播"); break;
		             case 8: $('#fBroadcastType').text("广播预案-日常广播"); break;
		             case 9: $('#fBroadcastType').text("广播预案-实际演练"); break;
		             case 10: $('#fBroadcastType').text("广播预案-系统演练"); break;
		             case 11: $('#fBroadcastType').text("广播预案-模拟演练"); break;
		             case 12: $('#fBroadcastType').text("定时广播"); break;
		             default: break;
		         } 
	             $('#fRealMessageType').text(row.fRealMessageType);
	             $('#fRealMessageLevel').text(row.fRealMessageLevel);
	             if(row.fRealMessageSource!=null){
	                 $('#fRealMessageSource').text(row.fRealMsgresource);
	             }else{
	                 $('#fRealMessageSource').text("");
	             }
	             if(row.fRealControlDevice!=null){
	                 $('#fRealControlDevice').text(row.fRealControlDevice);
	             }else{
	                 $('#fRealControlDevice').text("");
	             }
	             $('#fVolumeControl2').text(row.fVolumeControl2);
	             if(row.creator!=null){
	                 $('#creator').text(row.creator);
	             }else{
	                 $('#creator').text("");
	             }
	             $('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
	             if(row.operator!=null){
	                 $('#operator').text(row.operator);
	             }else{
	                 $('#operator').text("");
	             }
	             if(row.fUpdtateTime!=null){
	                 $('#fUpdtateTime').text(new Date(row.fUpdtateTime).format('yyyy-MM-dd HH:mm:ss'));
	             }else{
	                 $('#fUpdtateTime').text("");
	             }
	             $('#fEffectiveTime').text(new Date(row.fEffectiveTime).format('yyyy-MM-dd HH:mm:ss'));
                 $('#fRealProgramPass').text(row.fRealProgramPass);
	             if(row.fRealBroadcastTo!=null){
	                 $('#fRealBroadcastTo').text(row.fRealBroadcastTo);
	             }else{
	                 $('#fRealBroadcastTo').text("");
	             }
	             $('#fRealArea').text(row.fRealArea);
            }
        },
        formatter : function() {
            return '<button class="btn btn-info btn-sm edit-base-btn" data-toggle="modal" data-target="#details_broadcast_modal">详情</button>';
        }
    }
];
function refreshSearchText(){
	var text = new Array();
	text[0]="广播类型;"+$('#broadcastType') .val();//广播类型
	text[1]="消息类型;"+$('#messageType') .val();//消息类型
	text[2]="消息级别;"+$('#messageLevel') .val();//消息级别
	text[3]="消息来源;"+$('#source') .val();//消息来源
	text[4]="播发区域;"+$('#broadcastArea') .val();//播发区域
	text[5]="有效起始时间;"+$("#effectiveStartTime").val();//有效时间
	text[6]="有效结束时间;"+$("#effectiveEndTime").val();//有效时间
	text[7]="操作者;"+$('#Reviewer') .val();//操作者
	text[8]="状态;"+$('#auditResults option:selected').val();//状态 
    var conditions = "";
	$.each(text,function(i,item){
		conditions += item;
		if(i<text.length-1) conditions += ",";
	}); 
 	mySearchText = conditions;
	//mySearchText = text;
	//mySearchText = JSON.stringify(text);
    //console.log(mySearchText);
}
function search(){
	refreshSearchText();
    $('#tab_query').bootstrapTable('refresh');
}
$(function() {
	jeDate(".data-YYYY-MM-DD-HH-mm-ss_update1",{
        format: "YYYY-MM-DD hh:mm:ss"
    });
	jeDate(".data-YYYY-MM-DD-HH-mm-ss_update2",{
        format: "YYYY-MM-DD hh:mm:ss"
    });
    $('#tab_query').bootstrapTable({
        method: 'post', 
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        sortable: true,
        dataType: "json",
        search: false, //是否显示表格搜索
        columns: columns,
        classes:'table-no-bordered',
        url: "${ctx}/effectEvaluate/queryStatistics/implementComplexQuery",
        toolbar : '#handleform', // 工具按钮用哪个容器
        sortable : true, // 是否启用排序
        sortOrder : "desc", // 排序方式
        pagination : true, // 是否显示分页（*）
        pageNumber : 1, // 初始化加载第一页，默认第一页
        pageSize : 5, // 每页的记录行数（*）
        pageList : [5, 10, 20], // 可供选择的每页的行数（*）
        showRefresh : false, // 是否显示刷新按钮
        clickToSelect : true, // 是否启用点击选中行
        sidePagination:'server',
        queryParamsType: "",
        showExport: true,                     //是否显示导出
        exportDataType: "basic",              //basic', 'all', 'selected'.
        queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
        	refreshSearchText();
        	return {//这里的params是table提供的
                pageNumber: params.pageNumber,//从数据库第几条记录开始
                pageSize: params.pageSize,//找多少条
                sortOrder:params.sortOrder, //排序方式
                sortName:params.sortName, //排序名称
                searchText :mySearchText //查询内容
        	};
        },
        responseHandler:function (result) {
            if(result.status === 200){
	            return{
	                total: result.data.total,
	                rows: result.data.list
	            };
            }
        }
    });
});
</script>
</body>
</html>