<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData,cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionJson", RegionData.getZTreeListJson());
    request.setAttribute("regionMap", RegionData.getNameMapJson());
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>领用证书</title>
<%@include file="../common/css.jsp" %>
<style>
table{
  table-layout:fixed;
}
.modal .form-group{
  padding-right: 20px;
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
</style>
	</head>
	<body>
		<h4><b>当前位置:资源管理>>证书管理>>领用证书</b></h4>
		<div class="content_table">
			<div class="handle">
				<button class="btn btn-info" id="importCertificate" data-toggle="modal" data-target="#import_modal">导入</button>
				<button class="btn btn-info" data-toggle="modal" data-target="#receiveCertificate_modal">新增</button>
				<button class="btn btn-info" id="editCertificate">修改</button>
				<button class="btn btn-danger" id="deleteCertificate">删除</button>
			</div>
	    	<table data-height="450" id="tab_receiveCertificate" class="table table-hover" style="word-break:break-all; word-wrap:break-all;"></table>
		</div>
		
		<!-- 新增模态框（Modal） -->
		<div class="modal fade" id="receiveCertificate_modal" tabindex="-1" role="dialog"  aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
						<h4 class="modal-title" id="title">新增证书</h4>
					</div>
					<div class="modal-body col-sm-12">
						<div class="content col-sm-12">
						<form id="form_certificate" data-validator-option="{theme:'simple_right',timely:1,focusCleanup:true,stopOnError:true}">
						 <div class="form-group col-sm-9">
								<label class="col-sm-3 control-label">设备名称</label>
								<div class="col-sm-7">
									<select  class="form-control" name="fDeviceId">
									 <c:forEach items="${deviceList}" var="deviceList">
								 	<option value="${deviceList.fId}">${deviceList.fDeviceName}</option>
								 </c:forEach>
								</select>
								</div>
							</div>
							<div class="form-group col-sm-9">
								<label class="col-sm-3 control-label">证书编号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="fCertificatesNumber" data-rule="required;length(12)">
									<input type="hidden" id="fId" name="fId">
								</div>
							</div>
							<div class="form-group col-sm-9">
								<label class="col-sm-3 control-label">证书有效期</label>
								<div class="col-sm-7">
									<input type="text" id="certificatesPeriodOfValidity" name="certificatesPeriodOfValidity" class="jeinput data-YYYY-MM-DD_update1 form-control " placeholder="YYYY-MM-DD ">
								</div>
							</div>
					<!-- 		<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">私钥</label>
								<div class="col-sm-7">
								
									<input type="text" class="form-control " name="fPrivateKey">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label class="col-sm-5 control-label">公钥</label>
								<div class="col-sm-7">
									<input type="text" class="form-control " name="fPublicKey">
								</div>
							</div> -->
						<!-- 	<div class="form-group col-sm-6">
								<label class="col-sm-4 control-label">备注</label>
								<div class="col-sm-7">
									<input type="text" class="form-control " rows="3" name="fRemark">
								</div>
							</div> -->
							
							<div class="form-group col-sm-12">
								<label class="col-sm-2 control-label">私钥</label>
								<div class="col-sm-8">
									     <textarea class="form-control textarea" rows="3" name="fPrivateKey"
                                              data-rule="required;length(64)"></textarea>
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-2 control-label">公钥</label>
								<div class="col-sm-8">
									     <textarea class="form-control textarea" rows="3" name="fPublicKey"
                                              data-rule="required;length(128)"></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-info" id="confirm">确定</button>
						<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
					</div>
				</form>	
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		
	<div class="modal fade" id="import_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog import">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">导入</h4>
            </div>
            <form id="importForm"  action="../resourceManage/receiveCertificate/importExcel" method="post" enctype="multipart/form-data">
                <div class="modal-body col-sm-12">
                    <div class="form-group col-sm-12" style="padding: 10px">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">选择文件：</label>
                            <div  class="col-sm-3 control-label">
                            <input type="file" id="importFile" name="excelFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" >
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" id="import_confirm">确定</button>
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
		var flag=0;
		$(".modal-dialog").draggable();
		jeDate(".data-YYYY-MM-DD_update1",{
	        format: "YYYY-MM-DD",
	        multiPane:false,
	        isToday:true,                               //是否显示今天或本月
	    });
			var columns  =	[[{
				checkbox : true,
				valign:'middle',
			     }, {   field : 'fDeviceName',
						title :'设备名称',
						sortable : true,
						align : 'center',
						width :'10%',
						valign:'middle',
					},{   field : 'fDeviceResourceCode',
						title :'设备资源码',
						sortable : true,
						align : 'center',
						width :'12%',
						valign:'middle',
					},{field : 'fCertificatesNumber', 
					   title:'证书编号',
					   sortable : true,
					   align : 'center',
					   width :'12%',
					   valign:'middle',
					},{
						field : 'fCertificatesPeriodOfValidity',
						title :'证书有效期',
						sortable : true,
						align : 'center',
						width :'12%',
						valign:'middle',
						formatter:function(data,row,index){
							return ""+new Date(row.fEndDateOfValidity).format('yyyy-MM-dd');
						}
					},{
						field : 'fPrivateKey',
						title :'私钥',
						align : 'center',
						width :'25%',
						valign:'middle',
					},{
						field : 'fPublicKey',
						title :'公钥',
						align : 'center',
						valign:'middle',
					}]];
			
			$(function(){
				$('#tab_receiveCertificate').bootstrapTable({
					url :"../resourceManage/receiveCertificate/getCertificateList",
					method:'post',
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					sortable: true,
			        search: true, //是否显示表格搜索
			        columns: columns,
					classes:'table-no-bordered',
					clickToSelect: true,
					sortable : true, // 是否启用排序
					sortOrder : "asc", // 排序方式			
					pagination : true, // 是否显示分页（*）
					pageNumber : 1, // 初始化加载第一页，默认第一页
					pageSize : 5, // 每页的记录行数（*）
					pageList : [5,10,20], // 可供选择的每页的行数（*）
					showRefresh : true, // 是否显示刷新按钮
					sidePagination: 'server',
					queryParamsType:"",
					queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
			            return {//这里的params是table提供的
			            	Number: params.pageNumber,//从数据库第几条记录开始
			            	Size: params.pageSize, //找多少条
			            	searchText:params.searchText, //查询内容
			            	sortOrder:params.sortOrder, //排序方式
			         		sortName:params.sortName, //排序名称
			            };
			        },
			        responseHandler: function (result) {
			        	if(result.status === 200){
			        	}
			            return{
			            	total: result.data.total, 
			            	rows: result.data.list
			            };
			        },
				});
			});
			
			$('#form_certificate').on('valid.form', function(e, form){
				if(flag === 0){
					$('#fId').val('');
				$.ajax({
					url : "../resourceManage/receiveCertificate/insertOrUpdateCertificate.do",
					type : 'post',
					data:$('#form_certificate').serialize(),
					success :function(data){
						if (data.status === 200){
							$("#receiveCertificate_modal").modal('hide');
							$('#tab_receiveCertificate').bootstrapTable('refresh');
							layer.msg(data.msg, {icon: 1});
						}else{
							layer.msg(data.msg, {icon: 2});
						}
					}
				}); 
				} else{
					flag = 0;
					$.ajax({
						data:$("#form_certificate").serialize(),
						type : 'post',
						url : "../resourceManage/receiveCertificate/insertOrUpdateCertificate.do",
						success :function(data){
							if (data.status === 200){
								$("#receiveCertificate_modal").modal('hide');
								$('#tab_receiveCertificate').bootstrapTable('refresh');
								layer.msg(data.msg, {icon: 1});
							}else{
								layer.msg(data.msg, {icon: 2});
							}
						}
						}); 
				}
			
          });
			
			$("#editCertificate").on("click",function(){
				var SlectLineData = $("#tab_receiveCertificate").bootstrapTable('getSelections');
				if(SlectLineData.length>1){
					layer.msg('一次只能选择一项进行修改!', {icon: 2});
					return false;
				}else if(SlectLineData.length<=0){
					layer.msg('请先选择要修改的记录!', {icon: 2});
					return false;
				}else{
					$.each(SlectLineData[0],function(key,value){
							$("#receiveCertificate_modal [name='"+key+"']").val(value);
						})
					$("#certificatesPeriodOfValidity").val(""+new Date(SlectLineData[0].fEndDateOfValidity).format('yyyy-MM-dd'));
					$('#title').html('修改');
					$('#receiveCertificate_modal').modal();
					flag=1;
				}
			})
			
			$("#deleteCertificate").on("click",function(){
				var allSlectLineData = $("#tab_receiveCertificate").bootstrapTable('getSelections');
				var ids = "";
				var count=0;
				if(allSlectLineData.length==0){
					layer.msg('请先选择要删除的记录!', {icon: 2});
				}else{
					for(i=0;i<allSlectLineData.length;i++){
						ids += allSlectLineData[i].fId + ",";
						count=count+1;
					}
					layer.confirm("确定要删除这"+count+"条记录？",{
							title:['操作提示'],
						 	btn: ['确定','取消'] //按钮
						 	,icon:3
					},function(){
						$.ajax({
			        		data : {
			        			ids : ids
			        		},
			  	    		type: 'post', // 提交方式 get/post
			  	    		url : "../resourceManage/receiveCertificate/deleteCertificate.do", // 需要提交的 url
			  	            success:function(data){
			  	            	if (data.status === 200){
			        				$('#tab_receiveCertificate').bootstrapTable('refresh');
			  	            		layer.msg(data.msg,{icon: 1});
			  	            	$(table).bootstrapTable('refresh');
			  	            	}else{
			  	            		layer.msg(data.msg,{icon: 2});
			  	            	}
			  	            }
			  	    	});
					},function(){
						return;
					})		
			}
			});
			
			$("#import_confirm").on("click",function(){
				 //首先验证文件格式
		        var fileName = $("#importFile").val();
		        if (fileName === '') {
		        	layer.msg("请选择文件！", {icon: 2});
		            return false;
		        }
		        var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
		        if (fileType !== 'xls' && fileType !== 'xlsx') {
		        	layer.msg("文件格式不正确，请上传正确的excel文件！", {icon: 2});
		            return false;
		        }
		        var form = $("#importForm");
		            // mulitipart form,如文件上传类
		            var formData = new FormData();
		            formData.append("excelFile",document.getElementById("importFile").files[0]);
		            $.ajax({
		                type: form.attr('method'),
		                url: form.attr('action'),
		                data: formData,
		                dataType: "JSON",
		                mimeType: "multipart/form-data",
		                contentType: false,
		                cache: false,
		                processData: false,
		                success : function(data) {
		                	if (data.status === 200){
		                		$('#tab_receiveCertificate').bootstrapTable('refresh');
								layer.msg(data.msg, {icon: 1});
							}else{
								$('#tab_receiveCertificate').bootstrapTable('refresh');
								layer.msg(data.msg, {icon: 2});
							}
		                }
		            }); 
			})
			
    $('body').on('hidden.bs.modal', '.modal', function () {
        $(".modal-dialog").css({"top":"0","bottom":"0","left":"0","right":"0"})
    })
     $('#receiveCertificate_modal').on('hidden.bs.modal', function () {
        document.getElementById("form_certificate").reset();
        $('#title').html('新增');
    });


		</script>
	</body>
</html>
