<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		 trimDirectiveWhitespaces="true"%>
<%@ page import="cn.wtu.broadcast.config.SystemConfig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("ctx", request.getContextPath());
	request.setAttribute("config", SystemConfig.getMap());
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>审核处理</title>
	<%@include file="../common/css.jsp"%>
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
<h4>
	<b>当前位置:播发审核>>审核处理</b>
</h4>

<div class="content">

	<div class="tablemodelshenhe showshenhe">
		<table  data-height="450" id="tab_shenheLog1" class="table table-hover"></table>
	</div>
</div>


<!-- 详情模态框（Modal） -->
<div class="modal fade" id="details_shenheLog_modal" role="dialog"
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
							<span id="fRealMessageSource"></span>
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
							<span id="effectiveTime"></span>
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
					<div class="null"></div>
				</div>
				<div class="modal-footer ">
					<button id="shenheSuccessBtn1" type="button" class="btn btn-sm btn-danger">通过</button>
					<button id="shenheFaliedBtn1" type="button" class="btn btn-sm btn-warning">不通过</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<%@include file="../common/js.jsp"%>

<script type="text/javascript">

	var fId1;
	var fReviewObjectId1;
	var fBroadcastType1;
function success(row){
	$("#shenheSuccessBtn1").on("click",function(){
		var stateCheck = broadcastServerStateCheck("${ctx}");
    	if(!stateCheck){
    		return;
    	}		
		/*	layer.prompt({title: '审核意见', formType: 2}, function(text, index){
                layer.close(index);
                if(fBroadcastType1!=11){
                    $.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastState/' + fId1 +'/'+fReviewObjectId1+'/'+text, function (result) {
					if (result.status === 200) {

						if(result.data==true){
							layer.msg("审核通过",{icon: 1});
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}else{
							layer.msg("审核不通过",{icon: 1});
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}
					}
				});
			}else {
				$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastStateForTiming/' + fId1 +'/'+fReviewObjectId1+'/'+text, function (result) {
					if (result.status === 200) {

						if(result.data==true){
							layer.msg("审核通过",{icon: 1});
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}else{
							layer.msg("审核不通过",{icon: 1});
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}
					}
				});
			}

		});*/

		if(row.fReviewResult==0){
			layer.prompt({title: '审核意见', formType: 2}, function(text, index){
				layer.close(index);
				if(row.fBroadcastType!=12){
					$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastState/' + row.fId +'/'+row.fReviewObjectId+'/'+text, function (result) {
						if (result.status === 200) {
							layer.msg("审核通过",{icon: 1});
							$(".modal").modal("hide");
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}else{
							layer.msg(result.msg,{icon: 1});
							$(".modal").modal("hide");
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}
					});
				}else {
					$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastStateForTiming/' + row.fId +'/'+row.fReviewObjectId+'/'+text, function (result) {
						if (result.status === 200) {
								layer.msg("审核通过",{icon: 1});
								$(".modal").modal("hide");
								$("#tab_shenheLog1").bootstrapTable('refresh');
						}
					});
				}
			});

		}else if(row.fReviewResult==1){
			layer.confirm('您选择的是审核失败的广播，需要再次审核吗？',{
				title:['审核处理'],
				btn: ['继续','取消'] //按钮
			},function(){
				layer.prompt({title: '审核意见', formType: 2}, function(text, index){
					layer.close(index);
					$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastState/' + row.fId +'/'+row.fReviewObjectId+'/'+text, function (result) {
						if (result.status === 200) {

							if(result.data==true){
								layer.msg("审核通过",{icon: 1});
								$(".modal").modal("hide");
								$("#tab_shenheLog1").bootstrapTable('refresh');
							}else{
								layer.msg("审核过程出现异常",{icon: 1});
								$(".modal").modal("hide");
								$("#tab_shenheLog1").bootstrapTable('refresh');
							}
						}
					});
				});

			},function(){})
		}

	});
}
function fail(row){
	$("#shenheFaliedBtn1").on("click",function(){
		layer.prompt({title: '审核意见', formType: 2}, function(text, index){
			layer.close(index);

			if(row.fBroadcastType!=12){
				$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastStateFailed/' + row.fId +'/'+row.fReviewObjectId +'/'+text, function (result) {

					if (result.status === 200) {
						if(result.data==true){
							layer.msg("审核不通过",{icon: 1});
							$(".modal").modal("hide");
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}else{
							layer.msg("审核过程出现异常",{icon: 1});
							$(".modal").modal("hide");
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}
					}
				});
			}else {
				$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastStateFailedTiming/' + row.fId+'/'+row.fReviewObjectId +'/'+text, function (result) {

					if (result.status === 200) {
						if(result.data==true){
							layer.msg("审核不通过",{icon: 1});
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}else{
							layer.msg("审核过程出现异常",{icon: 1});
							$("#tab_shenheLog1").bootstrapTable('refresh');
						}
					}
				});
			}
		});
	});
}



	var columns1 = [ [
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
			width: "15%",
			align : 'center',
		} ,{
			field : 'fEffectiveTime',
			title : '有效时间',
			width: "15%",
			align : 'center',
			sortable : true,
			formatter : function(time,row,index) {
					let index_Date=new Date();
					let $Date=new Date(time);
					if ($Date.getTime()>index_Date.getTime()){
						return $Date.format('yyyy-MM-dd HH:mm:ss');
					}else {
						$.ajax('${ctx}/shenhe/shenheHandle/overTime/' + row.fId+"/"+row.fBroadcastType+"/"+row.fReviewObjectId)
					}
				}
		},{
			field : 'operator',
			title : '操作者',
			width: "7%",
			align : 'center',
			formatter: function (data, row, index) {
				if (data === null || data == "") {
					return row.creator;
				} else {
					return row.operator;
				}

			}
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
				}else{
					return '<span class="label label-danger">未知</span>';
				}

			}
		},{
			field : 'ee',
			title : '操作',
			align : 'center',
			events: {

				'click #shenheSuccessBtn': function (e, val, row) {
					var stateCheck = broadcastServerStateCheck("${ctx}");
			    	if(!stateCheck){
			    		return;
			    	}
					if(row.fReviewResult==0){
						layer.prompt({title: '审核意见', formType: 2}, function(text, index){
							layer.close(index);
							if(row.fBroadcastType!=12){
								$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastState/' + row.fId +'/'+row.fReviewObjectId+'/'+text, function (result) {
									if (result.status === 200) {
											layer.msg("审核通过",{icon: 1});
										$(".modal").modal("hide");
											$("#tab_shenheLog1").bootstrapTable('refresh');
									}else{
										layer.msg(result.msg,{icon: 1});
										$(".modal").modal("hide");
										$("#tab_shenheLog1").bootstrapTable('refresh');
									}
								});
							}else {
								$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastStateForTiming/' + row.fId +'/'+row.fReviewObjectId+'/'+text, function (result) {
									if (result.status === 200) {
										if(result.data==true){
											layer.msg("审核通过",{icon: 1});
											$(".modal").modal("hide");
											$("#tab_shenheLog1").bootstrapTable('refresh');
										}else{
											layer.msg(result.msg,{icon: 1});
											$(".modal").modal("hide");
											$("#tab_shenheLog1").bootstrapTable('refresh');
										}
									}
								});
							}



						});

					}else if(row.fReviewResult==1){
						layer.confirm('您选择的是审核失败的广播，需要再次审核吗？',{
							title:['审核处理'],
							btn: ['继续','取消'] //按钮
						},function(){

							layer.prompt({title: '审核意见', formType: 2}, function(text, index){
								layer.close(index);
								$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastState/' + row.fId +'/'+row.fReviewObjectId+'/'+text, function (result) {
									if (result.status === 200) {

										if(result.data==true){
											layer.msg("审核通过",{icon: 1});
											$(".modal").modal("hide");
											$("#tab_shenheLog1").bootstrapTable('refresh');
										}else{
											layer.msg("审核过程出现异常",{icon: 1});
											$(".modal").modal("hide");
											$("#tab_shenheLog1").bootstrapTable('refresh');
										}
									}
								});
							});

						},function(){})
					}

				},
				'click #shenheFaliedBtn': function (e, val, row) {
					layer.prompt({title: '审核意见', formType: 2}, function(text, index){
						layer.close(index);

						if(row.fBroadcastType!=12){
							$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastStateFailed/' + row.fId +'/'+row.fReviewObjectId +'/'+text, function (result) {

								if (result.status === 200) {
									if(result.data==true){
										layer.msg("审核不通过",{icon: 1});
										$("#tab_shenheLog1").bootstrapTable('refresh');
									}else{
										layer.msg("审核过程出现异常",{icon: 1});
										$("#tab_shenheLog1").bootstrapTable('refresh');
									}
								}
							});
						}else {
							$.getJSON('${ctx}/shenhe/shenheHandle/updateBroadcastStateFailedTiming/' + row.fId+'/'+row.fReviewObjectId +'/'+text, function (result) {

								if (result.status === 200) {
									if(result.data==true){
										layer.msg("审核不通过",{icon: 1});
										$("#tab_shenheLog1").bootstrapTable('refresh');
									}else{
										layer.msg("审核过程出现异常",{icon: 1});
										$("#tab_shenheLog1").bootstrapTable('refresh');
									}
								}
							});
						}
					});
				},

				'click .edit-base-btn': function (e, val, row) {
					if(row.fReviewResult==1){
						$("#shenheFaliedBtn1").attr("style","display:none;");
					}

					if(row.fReviewResult==0){
						$("#shenheFaliedBtn1").attr("style","display:;");
					}

					if (row) {
						fId1 = row.fId;
						fReviewObjectId1 = row.fReviewObjectId;
						fBroadcastType1 = row.fBroadcastType;
						$('#fId').text(row.fId);
						if(row.fBroadcastType==1){
							$('#fBroadcastType').text("系统演练");
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

						$('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
						$('#fVolumeControl').text(row.fVolumeControl);
						$('#fRealArea').text(row.fRealArea);
						$('#fRealMessageLevel').text(row.fRealMessageLevel);
						$('#fRealMessageType').text(row.fRealMessageType);
						$('#fVolumeControl').text(row.fVolumeControl);

						if(row.fRemark!=null){
							$('#fRemark').text(row.fRemark);
						}else{
							$('#fRemark').text("");
						}
						$('#fReviewResult').text("待审核");

						if(row.fRealControlDevice!=null){
							$('#fRealControlDevice').text(row.fRealControlDevice);
						}else{
							$('#fRealControlDevice').text("");
						}

						if(row.fRealMsgresource!=null){
							$('#fRealMessageSource').text(row.fRealMsgresource);
						}else{
							$('#fRealMessageSource').text("");
						}



						if(row.creator!=null){
							$('#creator').text(row.creator);
						}else{
							$('#creator').text("");
						}

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
						if(row.effectiveTime!=null){

							$('#effectiveTime').text(new Date(row.effectiveTime).format('yyyy-MM-dd HH:mm:ss'));
						}else{
							$('#effectiveTime').text("");
						}

						if(row.fRealBroadcastTo!=null){
							$('#fRealBroadcastTo').text(row.fRealBroadcastTo);
						}else{
							$('#fRealBroadcastTo').text("");
						}
						success(row);
						fail(row);
					}
					/*  }
               }); */

					for(var i=0; i<shenhe_data.length; i++){
						if(shenhe_data[i].fId==row.fId){
							if(shenhe_data[i].fReviewResult==0){
								//$('#fReviewResult').text("待审核");
								$("#fReviewResult").html('<span class="label label-danger">待审核</span>');
							}else if(shenhe_data[i].fReviewResult==1){
								$("#fReviewResult").html('<span class="label label-warning">审核失败</span>');
							}else{
								$('#fReviewResult').text("未知");
							}

						}
					}
				},

			},
			formatter : function() {
				return '<button id="shenheSuccessBtn" type="button" class="btn btn-sm btn-danger">通过</button> <button id="shenheFaliedBtn" type="button" class="btn btn-sm btn-warning">不通过</button> <button class="btn btn-info btn-sm edit-base-btn" data-toggle="modal" data-target="#details_shenheLog_modal">详情</button>';
			}
		} ] ];

	$(function() {
		$(".modal-dialog").draggable();
		$('#tab_shenheLog1').bootstrapTable({
			method: 'get',
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            sortable: true,
            dataType: "json",
            search: true, //是否显示表格搜索
            columns: columns1,
            classes:'table-no-bordered',
            url: "${ctx}/shenhe/shenheHandle/selectManualShenhe",
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
			queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
				return {//这里的params是table提供的
					pageNumber: params.pageNumber,//从数据库第几条记录开始
					pageSize: params.pageSize,//找多少条
					searchText:params.searchText, //查询内容
					sortOrder:params.sortOrder, //排序方式
					sortName:params.sortName, //排序名称
				};
			},
			responseHandler:function (result) {
				shenhe_data = result.data.list;
				if(result.status === 200){
					//layer.close(ii);
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
