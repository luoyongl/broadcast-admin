<%--
  Created by IntelliJ IDEA.
  User: LiLinFeng
  Date: 2019/01/16
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>异常设备记录</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .content_table{
            padding: 1% 1.5%;
            width: 100%;
            height:90%;
        }

    	#tab_exception_device tbody tr td{
			  width:150px;
		      overflow: hidden; 
		      text-overflow:ellipsis;  
		      white-space: nowrap; 
		}
        @media (max-width: 1400px) {
            .modal .form-group {
                margin: 0.5% 0;
                padding: 0;
                padding-left: 15px;
            }
        }
        /* 移动端样式 */
    	@media screen and (max-width: 480px) {
    		body {
    			font-size: 12px;
    		}
    		h4 {
    			display: none;
    		}
			.fixed-table-container {
				height: auto!important;
				padding-bottom: 10px!important;
			}
    		.fixed-table-container .fixed-table-body {
				height: auto!important;
			}
			.content_table {
				height: auto!important;
			}
			
			#infoModal .modal-body .col-sm-7 {
    			display: inline-block;
    		}
    	}
    </style>
</head>
<body>
<h4><b>当前位置:监测监控>>异常设备记录</b></h4>
<div class="content_table">
    <div class="handle pull-right">
        <button class="btn btn-info" id="edit" data-toggle="modal" data-target="#outExcel_exceptionDevice">导出</button>
    </div>
    
    <table data-height="450" id="tab_exception_device" class="table table-hover" ></table>
</div>

    <!-- 详情模态框（Modal） -->
    <div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog detail">
            <div class="modal-content">
                <form >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title">详情</h4>
                    </div>
                    <div class="modal-body">
                        <div class="content col-sm-12 col-md-12 col-lg-12">
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">设备编号:</label>
                                <div class="col-sm-7">
                                    <span id="fNumber"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">设备名称:</label>
                                <div class="col-sm-7">
                                    <span id="fDeviceName"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">设备IP:</label>
                                <div class="col-sm-7">
                                    <span id="fDeviceIp"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">设备端口:</label>
                                <div class="col-sm-7">
                                    <span id="fDevicePort"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">设备型号:</label>
                                <div class="col-sm-7">
                                    <span id="fRealDeviceModel"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">物理码:</label>
                                <div class="col-sm-7">
                                    <span id="fPhysicalCode"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">所属区域:</label>
                                <div class="col-sm-7">
                                    <span id="fRealArea"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">安装地址:</label>
                                <div class="col-sm-7">
                                    <span id="fInstallAddress"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6" id="div_state">
                                <label class="col-sm-5 control-label">设备状态:</label>
                                <div class="col-sm-7">
                                    <span id="fDeviceState"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6" id="div_url">
                                <label class="col-sm-5 control-label">URL:</label>
                                <div class="col-sm-7">
                                    <span id="fUrl"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6" id="div_pid">
                                <label class="col-sm-5 control-label">指令PID:</label>
                                <div class="col-sm-7">
                                    <span id="fAcceptCommandPid"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">经度:</label>
                                <div class="col-sm-7">
                                    <span id="fLongitude"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">纬度:</label>
                                <div class="col-sm-7">
                                    <span id="fDimension"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">显示级别:</label>
                                <div class="col-sm-7">
                                    <span id="fDisplayLevel"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">绑定证书:</label>
                                <div class="col-sm-7">
                                    <span id="fCertificate"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">设备资源码:</label>
                                <div class="col-sm-7">
                                    <span id="fDeviceResourceCode"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6" id="div_fm">
                                <label class="col-sm-5 control-label">设备频段:</label>
                                <div class="col-sm-7">
                                    <span id="fDeviceBand"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6" id="div_mainter">
                                <label class="col-sm-5 control-label">维护人员:</label>
                                <div class="col-sm-7">
                                    <span id="fMaintainer"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6" id="div_manufacturerInfo">
                                <label class="col-sm-5 control-label">厂商信息:</label>
                                <div class="col-sm-7">
                                    <span id="fRealFacture"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6" id="div_protocolType">
                                <label class="col-sm-5 control-label">协议类型:</label>
                                <div class="col-sm-7">
                                    <span id="fRealProtocol"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">创建者:</label>
                                <div class="col-sm-7">
                                    <span id="fCreatorName"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">创建时间:</label>
                                <div class="col-sm-7">
                                    <span id="fCreateTime"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">修改者:</label>
                                <div class="col-sm-7">
                                    <span id="fOperatorName"></span>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-5 control-label">修改时间:</label>
                                <div class="col-sm-7">
                                    <span id="fUpdateTime"></span>
                                </div>
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

	var exception_device_data;


    $("#edit").on("click", function(){
        layer.confirm('确认要导出所有记录吗？', {icon: 3, title: '操作提示'}, function (index){
            window.location.href = '${ctx}/monitor/exceptionDevice/exportExceptionDeviceExcel';
            layer.close(index);
        });
    });

    var columns  =	[[{
        field:'',
        title:' ',
        width:20,
        formatter:function () {
            return '';
        }
    },{
        field : 'fDeviceName',
        title :'设备名称',
        width: "15%",
		align : 'center',
    },{
        field : 'fRealDeviceModel',
        title:'设备类型',
        width: "15%",
		align : 'center',

    },{
        field : 'fDeviceResourceCode',
        title :'设备资源码',
        width: "15%",
		align : 'center',
    },{
        field : 'fRealDeviceModel',
        title :'设备型号',
        width: "15%",
		align : 'center',
    }, {
        field : 'fRealArea',
        title :'所在区域',
        width: "15%",
		align : 'center',
    },{
		field : 'fDeviceState',
		title :'设备状态',
		width: "10%",
		align : 'center',
		sortable : true,
			formatter: function (data,row,index) {
                if(data==0){
                	return "正在广播";
                }else if(data==1){
                	return "在线";
                }else if(data==2){
                	return "离线";
                }else if(data==3){
                	return '停电';
                }else if(data==4){
                	return '故障';
                }
            },
	}/*,{
        field : 'offlineTime',
        title :'离线时长',
        align : 'left',
        width : '170px'
    }*/,{
        field : 'details',
        title :'操作',
        width: "20%",
		align : 'center',
        events:{
            'click #exceptionDeviceDetails':function(e, val, row){

                var data = exception_device_data;
                for(var i=0; i<data.length; i++){
                    if(data[i].fId==row.fId){
                            $('#fNumber').text(data[i].fNumber?data[i].fNumber:"");
                            $('#fDeviceName').text(data[i].fDeviceName?data[i].fDeviceName:"");
                            $('#fDeviceIp').text(data[i].fDeviceIp?data[i].fDeviceIp:"");
                            $('#fDevicePort').text(data[i].fDevicePort?data[i].fDevicePort:"");
                            $('#fRealDeviceModel').text(data[i].fRealDeviceModel?data[i].fRealDeviceModel:"");
                            $('#fPhysicalCode').text(data[i].fPhysicalCode?data[i].fPhysicalCode:"");
                        if(data[i].fRealArea!=null){
                            $('#fRealArea').text(data[i].fRealArea);
                        }else{
                            $('#fRealArea').text("");
                        }

                        if(data[i].fInstallAddress!=null){
                            $('#fInstallAddress').text(data[i].fInstallAddress);
                        }else{
                            $('#fInstallAddress').text("");
                        }
                        if(data[i].fDeviceState!=null){
                            let text;
                            if(data[i].fDeviceState==0){
                                text= "正在广播";
                            }else if(data[i].fDeviceState==1){
                                text= "在线";
                            }else if(data[i].fDeviceState==2){
                                text= "离线";
                            }else if(data[i].fDeviceState==3){
                                text= '停电';
                            }else if(data[i].fDeviceState==4){
                                text= '故障';
                            }
                            $('#fDeviceState').text(text);
                        }else{
                            $('#fDeviceState').text("");
                        }

                        if(data[i].fUrl!=null){
                            $('#fUrl').text(data[i].fUrl);
                        }else{
                            $('#fUrl').text("");
                        }

                        if(data[i].fAcceptCommandPid!=null){
                            $('#fAcceptCommandPid').text(data[i].fAcceptCommandPid);
                        }else{
                            $('#fAcceptCommandPid').text("");
                        }


                        if(data[i].fAcceptCommandPid!=null){
                            $('#fAcceptCommandPid').text(data[i].fAcceptCommandPid);
                        }else{
                            $('#fAcceptCommandPid').text("");
                        }

                        if(data[i].fLongitude!=null){
                            $('#fLongitude').text(data[i].fLongitude);
                        }else{
                            $('#fLongitude').text("");
                        }

                        if(data[i].fDimension!=null){
                            $('#fDimension').text(data[i].fDimension);
                        }else{
                            $('#fDimension').text("");
                        }

                        if(data[i].fDisplayLevel!=null){
                            $('#fDisplayLevel').text(data[i].fDisplayLevel);
                        }else{
                            $('#fDisplayLevel').text("");
                        }

                        if(data[i].fCertificate!=null){
                            $('#fCertificate').text(data[i].fCertificate);
                        }else{
                            $('#fCertificate').text("");
                        }


                        if(data[i].fDeviceResourceCode!=null){
                            $('#fDeviceResourceCode').text(data[i].fDeviceResourceCode);
                        }else{
                            $('#fDeviceResourceCode').text("");
                        }

                        if(data[i].fDeviceBand!=null){
                            $('#fDeviceBand').text(data[i].fDeviceBand);
                        }else{
                            $('#fDeviceBand').text("");
                        }

                        if(data[i].fMaintainer!=null){
                            $('#fMaintainer').text(data[i].fMaintainer);
                        }else{
                            $('#fMaintainer').text("");
                        }

                        if(data[i].fRealFacture!=null){
                            $('#fRealFacture').text(data[i].fRealFacture);
                        }else{
                            $('#fRealFacture').text("");
                        }

                        if(data[i].fRealProtocol!=null){
                            $('#fRealProtocol').text(data[i].fRealProtocol);
                        }else{
                            $('#fRealProtocol').text("");
                        }

                        if(data[i].fCreatorName!=null){
                            $('#fCreatorName').text(data[i].fCreatorName);
                        }else{
                            $('#fCreatorName').text("");
                        }


                        if(data[i].fCreateTime!=null){
                            $('#fCreateTime').text(new Date(data[i].fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                        }else{
                            $('#fCreateTime').text("");
                        }

                        if(data[i].fOperatorName!=null){
                            $('#fOperatorName').text(data[i].fOperatorName);
                        }else{
                            $('#fOperatorName').text("");
                        }

                        if(data[i].fUpdateTime!=null){
                            $('#fUpdateTime').text(new Date(data[i].fUpdateTime).format('yyyy-MM-dd HH:mm:ss'));
                        }else{
                            $('#fUpdateTime').text("");
                        }

                        if(data[i].fRemark!=null){
                            $('#fRemark').text(data[i].fRemark);
                        }else{
                            $('#fRemark').text("");
                        }
                        $('#infoModal').modal('show');
                    }
                }


            }
        },
        formatter: function () {
        	return '<button id="exceptionDeviceDetails" class="btn btn-info btn-sm detail-btn">详情</button>';
        }
    }]];

    $(function(){
        $(".modal-dialog").draggable();
        $('#tab_exception_device').bootstrapTable({
            //url: "${ctx}/monitor/terminalStatus/getDeviceList?state=2",
            url: "${ctx}/monitor/exceptionDevice/selectExceptionDeviceInfos",
            columns: columns,
            method: 'get',
            // contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            search: true, //是否显示表格搜索
            classes: 'table-no-bordered',
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）  */
            showRefresh: true, // 是否显示刷新按钮 */
            clickToSelect: true,
            sidePagination: 'server',
            queryParamsType: "",
			queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
	            return {//这里的params是table提供的
	            	Number: params.pageNumber,//从数据库第几条记录开始
	            	Size: params.pageSize,//找多少条
	            	searchText:params.searchText, //查询内容searchText
	            	sortOrder:params.sortOrder, //排序方式
	         		sortName:params.sortName, //排序名称
	            };
	        }, 				 
			responseHandler:function (result) {
                exception_device_data=result.data.list;
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
