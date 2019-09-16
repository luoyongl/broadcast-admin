<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
%>
<!DOCTYPE html>
<html lang="en">
<html>
	<head>
		<meta charset="UTF-8">
		<title>调度预案</title>
    <%@include file="../common/css.jsp" %>
    	<style>
        .form-group {
            padding-right: 1% !important;
        }

        .modal-dialog {
            width: 70%;
            height: 80%;
        }

		.text {
            border: 1px solid #ccc;
            height: 322px;
            width: 800px;
        }
        
		.textarea {
            resize: none;
            border: 1px solid #FFFFFF;
            background-color: transparent;
            /*scrollbar-arrow-color:yellow;
            scrollbar-base-color:lightsalmon;
            overflow: hidden;*/
            color: #FFFFFF;
            height: auto;
        }
		
        .form-group {
            margin: 1% 0px;
            padding: 0px;
            padding-left: 0px;
        }
        
        table {
            table-layout: fixed;
            word-break:break-all;
        }

       /* table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        } */

        select {
            color: #FFFFFF !important;
        }
    	</style>		
	</head>
	<body>
		<h4><b>当前位置:资源管理>>调度预案</b></h4>
	<div>
	    <div class="content_table">
	        <div class="handle">
	            <button class="btn btn-info" data-toggle="modal" data-target="#add_dispatch_modal">新增</button>
	            <button id="update_btn" class="btn btn-info">修改</button>
	            <button id="delete_btn" class="btn btn-danger">删除</button>
	        </div>
	        <table id="tab_dispatch" data-height="450" class="table table-hover"/>
	    </div>
	</div>
	
<!-- 新增模态框（Modal） -->
<div class="modal fade" id="add_dispatch_modal" tabindex="-1" role="dialog" aria-hidden="true">
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
                            <label class="col-sm-5 control-label">名称</label>
                            <div class="col-sm-7">
                                <input type="text" id="add_name" class="form-control" name="planName">
                            </div>
                        </div>                                                                                             
                    </div>
                    <div class="modal-body-left col-sm-9">
	                    <div class="form-group col-sm-6">
		                     <label class="col-sm-5 control-label">描述</label>
		                     <div class="col-sm-7">
		                         <!-- <input type="text" style="width:30em;height:5em" id="add_describe" class="form-control" name="planDescribe"> -->                                    
		                     	 <textarea class="textarea form-control" style="width:350%;height:100px;" id="add_describe" name="planDescribe"></textarea>
		                     </div>
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

<!-- 修改模态框（Modal） -->
<div class="modal fade" id="update_dispatch_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">修改</h4>
            </div>
            <form id="update_form" onsubmit="return true" method="post">
                <div class="modal-body col-sm-12" style="padding: 20px">
                    <div class="modal-body-left col-sm-9">
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">名称</label>
                            <div class="col-sm-7">
                                <input type="text" id="update_name" class="form-control" name="planName">
                            </div>
                        </div>                                                                                             
                    </div>
                    <div class="modal-body-left col-sm-9">
	                    <div class="form-group col-sm-6">
		                     <label class="col-sm-5 control-label">描述</label>
		                     <div class="col-sm-7">
		                         <!-- <input type="text" style="width:30em" id="update_describe" class="form-control" name="planDescribe"> -->                                    
		                     	 <textarea class="textarea form-control" style="width:350%;height:100px;" id="update_describe" name="planDescribe"></textarea>
		                     </div>
	                	</div> 
                	</div>
                </div>
              
                <div class="modal-footer">
                    <button id="update_button" type="button" class="btn btn-info">确定</button>
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
var columns  =	[
        [{
	        checkbox : true,
	        formatter : stateFormatter,
		},{
			field : 'fPlanId',
			visible : false,
		},{
			field : 'planName',
			title:'名称',
			align : 'center',
			width : '20%',
		},{
			field : 'planDescribe',
			title :'描述',
			align : 'center',
		}]
     ];

//默认选中
function stateFormatter(value, row, index) {
	    /* if (row.planName == "覆盖调度策略") */
	    if (row.planName == "补点调度策略")
	        return {
	            //disabled : true,//设置是否可用
	            checked : true//设置选中
	        };
	    return value;
	}


$(function () {
    $('#tab_dispatch').bootstrapTable({
        url: "${ctx}/resourceManage/dispatchPlan/selectPlanList",
        method: 'get',
        sortable: false,
        columns: columns,
        singleSelect: true,  // 单选checkbox
        search: true, //是否显示表格搜索
        sortable: true, // 是否启用排序
        sortOrder: "desc", // 排序方式
        pagination: true, // 是否显示分页（*）
        pageNumber: 1, // 初始化加载第一页，默认第一页
        pageSize: 10, // 每页的记录行数（*）
        pageList: [5, 10, 20], // 可供选择的每页的行数（*）
        showRefresh: true, // 是否显示刷新按钮
        sidePagination: 'server',
        queryParamsType: "",
        clickToSelect: true,
        classes: 'table-no-bordered',
        queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
            return {//这里的params是table提供的
                pageNumber: params.pageNumber,//从数据库第几条记录开始
                pageSize: params.pageSize,//找多少条
                searchText: params.searchText, //查询内容          
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

//更新操作
$("#update_btn").click(function () {
    var checked = $('#tab_dispatch').bootstrapTable('getSelections');
    if (checked.length == 0) {
        layer.msg('请选择要修改的记录', {icon: 2});
    } else if (checked.length > 1) {
        layer.msg('只能选择一个记录', {icon: 2});
    } else {
        dataShow(checked[0]);
        $('#update_dispatch_modal').modal('show');
    }
})

//数据回显
function dataShow(checked) {
    $.each(checked, function (key, value) {
    	if(key == "planName"){
    		$("#update_dispatch_modal input[name='" + key + "']").val(value);  
    	}
        $("#update_dispatch_modal textarea[name='" + key + "']").val(value);     
    });
}

//增加_策略
$("#add_button").click(function () {
    $.ajax({
        type: 'post',
        url: '${ctx}/resourceManage/dispatchPlan/addDispatchPlan',
        data: $('#add_form').serialize(),
        async: false,
        success: function (result) {
            if (result.status == 200) {
                $('#add_dispatch_modal').modal('hide');
                $('#tab_dispatch').bootstrapTable('refresh');
                document.getElementById('add_form').reset();
            }
            layer.msg(result.msg, {icon: 1});
            layer.closeAll('loading');
        }
    })
});

//修改_策略
$("#update_button").click(function () {
        var checked = $('#tab_dispatch').bootstrapTable('getSelections');
        layer.load(2);
        $.ajax({
            type: 'post',
            url: '${ctx}/resourceManage/dispatchPlan/updateDispatchPlan?fPlanId=' + checked[0].fPlanId,
            data: $('#update_form').serialize(),
            success: function (result) {
                if (result.status == 200) {
                    $('#update_dispatch_modal').modal('hide');
                    $('#tab_dispatch').bootstrapTable('refresh');
                    document.getElementById('update_form').reset();
                }
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
            }
        })
    });
    
//删除_策略
$("#delete_btn").click(function () {
    var checked = $('#tab_dispatch').bootstrapTable('getSelections');
    var del_ids = "";
    if (checked.length == 0) {
        layer.msg('请选择要删除的记录', {icon: 2});
    } else {
        layer.confirm('确认删除' + checked.length + "条记录?", {icon: 3, title: '操作提示'}, function (index) {
            for (i = 0; i < checked.length; i++) {
                del_ids += checked[i].fPlanId + ",";
            }
            layer.load(2);
            $.post('${ctx}/resourceManage/dispatchPlan/deleteDispatchPlan?fPlanIds=' + del_ids, function (result) {
                if (result.status === 200) {
                    $('#tab_dispatch').bootstrapTable('refresh');
                }
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
            });
        });
    }
})

</script>
	</body>
</html>

