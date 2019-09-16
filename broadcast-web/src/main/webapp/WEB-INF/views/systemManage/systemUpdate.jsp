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
		<title>系统升级</title>
		<%@include file="../common/css.jsp" %>
		<style type="text/css">
			.content {
				height:92%;
				padding: 1% 1.5%;
				margin-top: 2.5%;
				width: 99%;
				border: 1px solid #FFFFFF;
				border-radius: 10px;
				overflow-y: scroll;
			}
		</style>
	</head>
	<body>
		<h4 style="display:block; margin-left: 2.5%;"><b>当前位置:系统管理>>系统升级</b></h4>
		<div class="content systemUpdate">
	    	<table id="tab_systemUpdate" class="table table-hover">
	    		<tr>
					<!-- <td></td>
					<td>201812061249</td>
					<td>版本一</td>
					<td>2018-12-06 15:50:23</td>
					<td>web端</td>
					<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#details_systemUpdate_modal">详情</button></td> -->
				</tr>
	    	</table>
		</div>
		<!-- 详情模态框（Modal） -->
		<div class="modal fade" id="details_systemUpdate_modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
						<h4 class="modal-title">详情（不可编辑）</h4>
					</div>
						<div class="modal-body-left col-sm-12">
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">广播类型</label>
								<div class="col-sm-8">
									<input type="text" class="form-control ">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">消息级别</label>
								<div class="col-sm-8">
									<input type="text" class="form-control ">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">广播音量</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">通道名称</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">循环次数</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">开机设备名称</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">消息发起人</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">消息时间</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">消息类型</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="null">

							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">文本信息</label>
								<div class="col-sm-8">
									<textarea class="form-control" rows="1" name=textarea></textarea>
								</div>
							</div>
							<div class="null">

							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">覆盖区域</label>
								<div class="col-sm-8">
									<textarea class="form-control" rows="1" name=textarea></textarea>
								</div>
							</div>
							<div class="null">

							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">审核结果</label>
								<div class="col-sm-8">
									<textarea class="form-control" rows="3" name=textarea></textarea>
								</div>
							</div>
							<div class="null">

							</div>
						</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" data-dismiss="modal">取消</button> 
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<%@include file="../common/js.jsp" %>
		<script type="text/javascript">
			$(function(){
				
				layer.confirm('是否检查版本更新？',{
        			title:['版本更新'],
       			 	btn: ['确定','取消'] //按钮
        		},function(){
        			var ii = layer.load();
        		    //此处用setTimeout演示ajax的回调
        		    setTimeout(function(){
        		    	layer.msg('该系统版本已经是最新版本');
        		      	layer.close(ii);
        		   		
        		    }, 3000);
        		},function(){})
        			
			});	
			
			var columns  =	[[{
						field : 'aa',
						title:'版本号',
						align : 'center',
						width: "20%",
					}, {
						field: 'bb',
						title: '版本名称',
						align: 'center',
						width: "20%",
					}, {
						field: 'cc',
						title: '更新日期',
						align: 'center',
						width: "20%",
					}, {
						field: 'dd',
						title: '更新类型',
						align: 'center',
						width: "20%",
					}, {
						field: 'ee',
						title: '详情',
						align: 'center',
						width: "20%",
				}]];
			
			$(function(){
				$('#tab_systemUpdate').bootstrapTable({
					//method: 'get',
	                sortable: true,
	                dataType: "json",
	                search: true, //是否显示表格搜索
	                columns: columns,
					classes:'table-no-bordered',
					//url: "${ctx}/broadcast/daily/selectDailyBroadcast",
					
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
				});
			});
		</script>
	</body>
</html>
