<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
    request.setAttribute("regionMap", RegionData.getNameMapJson());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="../common/css.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/css/jquery-ui.min.css">
    <style>
   		.none {
   			display: none;
   		}
        table {
            table-layout: fixed;
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        .modal .col-md-4 {
        	padding-right: 10px;
   			padding-left: 10px;
        }
        .modal .col-sm-5,.col-sm-6 {
        	margin: 0;
        }
        .modal .form-group {
        	padding-left: 0!important;
        }
        .modal table {
		    color: #FFF;
		}
        
        .btn-default {
		    color: #fff;
		    background-color: #bbb;
		}
		.modal-body {
			padding: 10px;
		}
		#volume_turnning>span {
			background: transparent!important;
		}
		.bootstrap-select {
		    background: none;
		    color: #ffffff;
		}
		.dropdown-toggle {
		    background: none;
		    color: #ffffff;
		}
		.trg{
		    width: 0;
		    height: 0;
		    border-left: 3px solid transparent;
		    border-right: 3px solid transparent;
		    border-top: 6px solid #FFF;;
		    position: absolute;
		    left:145px;
		    top:14px;
		}
    </style>
</head>
<body>
<h4>
    <b>当前位置:资源管理>>设备管理>>设备参数配置</b>
</h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li id="headendEquipment" class="selected_tab"><a>前端设备</a></li>
        <li id="terminalEquipment"><a>终端设备</a></li>
    </ul>
</div>
<!-- 前端设备 -->
<div class="tab_modal show">
    <div class="content_table">
	    <div id="front-tool">
	    	<div>
				<label>筛选数据：</label>
				<input id="frontDevice_search" class="form-control" name="frontDevice_search" placeholder="模糊搜索"
					style="width:200px;display:inline-block;"/>	
			</div>
			<div style="display:inline-block;">
				<label>适配器操作：</label>
				<div class="btn-group">
					<button type="button" class="btn btn-info" onclick="openRebackAdapterModal()">设置回传参数</button>
					<button type="button" class="btn btn-info" onclick="whitelistUpdate()">更新白名单</button>
				</div>
			</div>
		</div>
    	<table data-height="410" id="tab_frontDevice" class="table"></table>
    </div>
	<!-- 适配器操作 -->
	<div class="panel content" id="adapterHandlePanel" style="margin: 8px 0 0 0;background-color: rgba(0,0,0,0);">
		<div class="panel-heading" style="color: #fff;">适配器操作</div>
		<div class="panel-body">
			<button type="button" class="btn btn-info" onclick="openAdapterCertificateModal()">证书更新</button>
			<button type="button" class="btn btn-info" onclick="openQueryBroadcastWindow()">播发记录查询</button>
			<button type="button" class="btn btn-info" onclick="searchinputchannel()">查询输入通道</button>
			<button type="button" class="btn btn-info" onclick="searchoutputchannel()">查询输出通道</button>
			<button type="button" class="btn btn-info" onclick="searchrfaultinfo()">查询故障</button>
		</div>
	</div>
</div>
<!-- 终端设备 -->
<div class="tab_modal">
    <div class="content_table">
	    <div id="terminal-tool">
			<div>
				<label>筛选数据：</label>
				<div style="display:inline-block;">
					<!-- 模拟select点击框的text值显示-->
					<input id="terminalDeviceRegion_name" name="terminalDeviceRegion_name" class="form-control" type="text" 
						placeholder="选择区域" title="点击选择" style="cursor: default;width:200px;" readonly />
					<!-- 存储 模拟select的value值 -->
					<input type="hidden" name="terminalDeviceRegion_id" id="terminalDeviceRegion_id" />	
					<!-- zTree树状图 定位在其下方 -->
					<div id="terminalDeviceRegionTreeDiv" style="display:none;background-color: white;position:absolute;z-index:9999;border: 1px solid #DDDDDD">  							        	
					    <ul id="terminalDeviceRegionTree" class="ztree"></ul>	        
					</div>
				</div>
				<input id="terminalDevice_search" class="form-control" name="terminalDevice_search" placeholder="模糊搜索"
					style="width:200px;display:inline-block;"/>	
			</div>
			<div>
				<label>修改参数：</label>
				<div class="btn-group">
					<button type="button" class="btn btn-info" onclick="openSetResourcecodeModal()">设置设备资源编码</button>
					<button type="button" class="btn btn-info" onclick="openSetIPModal()">设置本机网络参数</button>
				</div>
			</div>
			<div>
				<label>批量操作：</label>
				<div class="btn-group">
					<button type="button" class="btn btn-info" onclick="selectAllTerminalDevice()">全选</button>
					<button type="button" class="btn btn-info" onclick="openVolumeModal()">音量调节</button>
				    <button type="button" class="btn btn-info" onclick="updateBrdFunc(2)">功放开</button>
				    <button type="button" class="btn btn-info" onclick="updateBrdFunc(1)">功放关</button>
					<button type="button" class="btn btn-info" onclick="openRebackAddressModal()">回传地址</button>
					<button type="button" class="btn btn-info" onclick="openRebackCycleModal()">回传周期</button>
					<button type="button" class="btn btn-info" onclick="clockCalibration()">时钟校准</button>
					<button type="button" class="btn btn-info" onclick="openTSModal()">TS频点</button>
					<button type="button" class="btn btn-info" onclick="openRDSModal()">RDS频点</button>
					<button type="button" class="btn btn-info" onclick="openMaintainModal()">启用/禁用维持</button>
				</div>
			</div>
		</div>
    	<table id="tab_terminalDevice" class="table"></table>
    </div>
    <!-- 终端操作 -->
	<div class="panel content" id="ebrdtHandlePanel" style="margin: 8px 0 0 0;background-color: rgba(0,0,0,0);">
		<div class="panel-heading" style="color: #fff;">终端操作</div>
		<div class="panel-body">
			<button type="button" class="btn btn-info" onclick="openTerminalCertificateModal()">证书更新</button>
			
			<button type="button" class="btn btn-info" onclick="openAskEbrdtInfoModal()">状态参数查询</button>
			<button type="button" class="btn btn-info" onclick="openInfoRebackModal()">查询回复</button>
		</div>
	</div>
</div>


<!-- 终端证书更新模态框 -->
<div class="modal fade" id="terminalCertificateModal" tabindex="-1" role="dialog" aria-hidden="false">
	<div class="modal-dialog" style="width: 300px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" align="left">证书更新</h4>
			</div>
			<div class="modal-body">
				<p>空</p>
			</div>
			<div class="modal-footer" style="text-align: center;">
				<button id="updateTerminalCertificateBtn" type="button" class="btn btn-info">更新</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 设备编码设置 -->
<div class="modal fade" id="resourceCodeModal" tabindex="-1" role="dialog" aria-hidden="false">
	<div class="modal-dialog" style="width: 500px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" align="left">设备编码设置</h4>
			</div>
			<div class="modal-body">
				<form id="resourceCodeForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 col-md-3 col-lg-3 control-label">资源编码：</label>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<input id='resCode' name="resCode" class="form-control" 
								data-rule="required;length(23);number"
								data-rule-number="[/^[0-9]*$/,'请填写数字']"
								placeholder="请输入新的资源编码"/>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;">
				<button id="resetResourceCodeBtn" type="button" class="btn btn-info">确认</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 音量调节模态框 -->
<div class="modal fade" id="volumeModal" tabindex="-1" role="dialog" aria-labelledby="volumeModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="volumeModalLabel" class="modal-title" align="left">音量调节</h4>
			</div>
			<div class="modal-body">
				<div id="volume_turnning">
					<label for="volume_spinner">音量：</label>
					<input id="volume_spinner" name="value" style="width: 30px; margin-right: .4em;">
					<div id="volume_slider" style="width: 250px; margin-left: 10px; display: inline-block;"></div>
				</div>
			</div>
			<div class="modal-footer" style="text-align: center;" id="volumeFootModal">
				<button id="volumeAdjustBtn" type="button" class="btn btn-info">保存</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 设置回传地址模态框 -->
<div class="modal fade" id="rebackAddressModal" tabindex="-1" role="dialog" aria-labelledby="rebackAddressModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="rebackAddressModalLabel" class="modal-title" align="left">回传地址</h4>
			</div>
			<div class="modal-body">
				<form id="rebackAddrForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">回传IP：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='rebackIp1' name="rebackIp1" class="form-control"
								data-rule="required; ip"
								data-rule-ip="[/^(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])$/, '格式错误']"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">回传端口：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='rebackPort1' name="rebackPort1" class="form-control"
								data-rule="required; port"
								data-rule-port="[/^([0-9]|[1-9]\d{1,3}|[1-5]\d{4}|6[0-4]\d{4}|65[0-4]\d{2}|655[0-2]\d|6553[0-5])$/, '格式错误']"/>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="ebrdtRebackAddrSet" type="button" class="btn btn-info">保存</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 设置回传周期模态框 -->
<div class="modal fade" id="rebackCycleModal" tabindex="-1" role="dialog" aria-labelledby="rebackModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 id="rebackModalLabel" class="modal-title" align="left">回传周期</h4>
			</div>
			<div class="modal-body">
				<form id="rebackCycleForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">回传周期：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='rebaclCycle1' name="rebaclCycle1" class="form-control"
								data-rule="required;"/>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="ebrdtRebackCycleSet" type="button" class="btn btn-info">保存</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 状态参数查询模态框 -->
<div class="modal fade" id="askModal" tabindex="-1" role="dialog" aria-labelledby="askModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 300px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 id="askModalLabel" class="modal-title" align="left">终端信息查询</h4>
			</div>
			<div class="modal-body" style="height: 350px;padding-left: 10px;">
				<ul id="ztree2" class="ztree"></ul>
			</div>
			<div class="modal-footer" style="text-align: center;">
				<button type="button" class="btn btn-info" id="askEbrdtInfo">请求</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 查询回复模态框 -->
<div class="modal fade" id="infoRebackModal" tabindex="-1" role="dialog" aria-labelledby="infoRebackModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 450px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="infoRebackModalLabel" class="modal-title" align="left">查询回复</h4>
			</div>
			<div class="modal-body">
				<div style="margin: 0 auto; height: 300px;">
					<table id="infoRebackTable" type="table"></table>
					<pre id="infoRebackPre"></pre>
				</div>
			</div>
			<div class="modal-footer" style="text-align: center;">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 设置IP地址模态框 -->
<div class="modal fade" id="SetEbrdtIPWindow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="myModalLabel" class="modal-title" align="left">设置终端IP</h4>
			</div>
			<div class="modal-body">
				<form id="IPAddrForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">IP地址:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='newIPAddress' name="newIPAddress" class="form-control" 
								data-rule="required; ip"
								data-rule-ip="[/^(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])$/, '格式错误']"
								placeholder="请输入新的IP地址"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">子网掩码:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='txtsubNetMask' name="txtsubNetMask" class="form-control" 
								data-rule="required; ip"
								data-rule-ip="[/^(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])$/, '格式错误']"
								placeholder="请输入新的子网掩码"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">网关地址:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='txtgateWay' name="txtgateWay" class="form-control" 
								data-rule="required; ip"
								data-rule-ip="[/^(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])$/, '格式错误']"
								placeholder="请输入新的网关地址"/>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="setedrdtIPCmd" type="button" class="btn btn-info">确定</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- RDS设置频点模态框 -->
<div class="modal fade" id="rdsTableModal" tabindex="-1" role="dialog" aria-labelledby="rdsTableModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 id="rdsTableModalLabel" class="modal-title" align="left">设置RDS扫描频点信息</h4>
			</div>
			<div class="modal-body" style="height: 350px;overflow-y: auto;">
				<div id="RDSToolBar">
					<button onclick="addRdsFreq()" class="btn btn-info">新增</button>
					<button onclick="delRds()" class="btn btn-danger" style="margin-left:4px;">删除</button>
				</div>
				<table id="RDSTable" class="table"></table>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="setScandPointRDS" type="button" class="btn btn-info">设置</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 新增RDS频点模态框 -->
<div class="modal fade" id="addFreqModal" tabindex="-1" role="dialog" aria-labelledby="addFreqModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 id="addFreqModalLabel" class="modal-title" align="left">新增频率</h4>
			</div>
			<div class="modal-body">
				<form id="addFreqForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">频率：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='newFreq' name="newFreq" class="form-control"
								data-rule="required;"/>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="addFreqBtn" type="button" class="btn btn-info">保存</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 设置采用/禁用维持指令模态框 -->
<div class="modal fade" id="maintainModal" tabindex="-1" role="dialog" aria-labelledby="maintainModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="maintainModalLabel" class="modal-title" align="left">设置采用/禁用维持</h4>
			</div>
			<div class="modal-body">
				<form id="maintainForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">是否启用：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<select id="isMantain" name="qam" class="form-control selectpicker show-tick" 
								data-rule="required;">
								<option value="0">禁用</option>
								<option value="1">启用</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">维持周期：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id="mantainCycle" name="symbolRate" class="form-control" 
								data-rule="required;"/>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="setMaintain" type="button" class="btn btn-info">设置</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- TS设置频点模态框 -->
<div class="modal fade" id="tsModal" tabindex="-1" role="dialog" aria-labelledby="tsModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="tsModalLabel" class="modal-title" align="left">TS设置</h4>
			</div>
			<div class="modal-body">
				<form id="frmTsForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">频率：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id="TSfreq" name="TSfreq" class="form-control"
								data-rule="required;" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">符号率：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id="TSsymbolRate" name="symbolRate" class="form-control" 
								data-rule="required;"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">QAM：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<select id="TSqam" name="qam" class="form-control selectpicker show-tick" 
								data-rule="required;">
								<option value="0">16</option>
								<option value="1">32</option>
								<option value="2">64</option>
								<option value="3">128</option>
								<option value="4">256</option>
							</select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="setScandPointTS" type="button" class="btn btn-info">设置</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 适配器证书更新模态框 -->
<div class="modal fade" id="adapterCertificateModal" tabindex="-1" role="dialog" aria-hidden="false">
	<div class="modal-dialog" style="width: 300px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" align="left">证书更新</h4>
			</div>
			<div class="modal-body">
				<p>空</p>
			</div>
			<div class="modal-footer" style="text-align: center;">
				<button id="updateAdapterCertificateBtn" type="button" class="btn btn-info">更新</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 设置回传参数模态框 -->
<div class="modal fade" id="rebackAdapterModal" tabindex="-1" role="dialog" aria-labelledby="rebackAdapterModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="rebackAdapterModalLabel" class="modal-title" align="left">回传参数设置</h4>
			</div>
			<div class="modal-body">
				<form id="adapterRebackSetForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">回传IP：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='rebackIp-adapter' name="rebackIp" class="form-control"
								data-rule="required; ip"
								data-rule-ip="[/^(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])$/, '格式错误']"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">回传端口：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='rebackPort-adapter' name="rebackPort" class="form-control"
								data-rule="required; port"
								data-rule-port="[/^([0-9]|[1-9]\d{1,3}|[1-5]\d{4}|6[0-4]\d{4}|65[0-4]\d{2}|655[0-2]\d|6553[0-5])$/, '格式错误']"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">回传周期：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='rebackCycle-adapter' name="rebackCycle" class="form-control"
								data-rule="required;"/>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="adapterRebackSet" type="button" class="btn btn-info">保存</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 更新白名单模态框 -->
<div class="modal fade" id="updateWhiteListModal" tabindex="-1" role="dialog" aria-labelledby="updateWhiteListModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 800px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="updateWhiteListModalLabel" class="modal-title" align="left">更新白名单</h4>
			</div>
			<div class="modal-body">
				<div id="whiteList-tool">
					<button class="btn btn-info" onclick="addNewWhiteListFunc()">新增</button>
					<button class="btn btn-danger" onclick="delWhiteListFunc()">删除</button>
				</div>
    			<table id="whiteListTable" class="table"></table>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 白名单新增、修改模态框 -->
<div class="modal fade" id="newWhiteListModal" tabindex="-1" role="dialog" aria-labelledby="newWhiteListModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="newWhiteListModalLabel" class="modal-title" align="left">新增</h4>
			</div>
			<div class="modal-body">
				<form id="updateWhiteListForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">账号：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<select id="whiteList_account" name="whiteList_account" class="form-control selectpicker show-tick" data-rule="required;">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">用户名：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='whiteList_username' name="whiteList_username" class="form-control" readonly/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">许可类型：</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<select id="permission_type" class="selectpicker show-tick form-control" name="permission_type">
								<option value="1">短信</option>
	                            <option value="2">电话</option>
	                            <option value="3">短信和电话</option>
                            </select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="updateWhiteListBtn" type="button" class="btn btn-info">保存</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>
<!-- 播发记录查询模态框 -->
<div class="modal fade" id="queryBroadcastlogModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 500px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="myModalLabel" class="modal-title" align="left">查询播发记录</h4>
			</div>
			<div class="modal-body">
				<form id="queryBroadcastlogForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">适配器编码:</label>
						<label class="col-sm-5 col-md-5 col-lg-5 control-label" id="QBAdapterID"></label>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">适配器名称:</label>
						<label class="col-sm-5 col-md-5 col-lg-5 control-label" id="QBAdapterName"></label>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">广播ID:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='ebm_id' name='ebm_id' class="form-control" type="text"  />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">任务类型:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<select id="chooseTaskType" class="selectpicker show-tick form-control" name="cobQBTaskType">
								<option value="0">全部节目</option>
	                            <option value="1">日常节目</option>
	                            <option value="2">应急节目</option>
                            </select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">开始时间:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='txtstarttime' name='txtstarttime' class="form-control jeinput1" type="text" 
								placeholder="开始时间" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">结束时间:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='txtendtime' name='txtendtime' class="form-control jeinput2" type="text" 
								placeholder="结束时间" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="btnQueryboroadcastCmd" type="button" class="btn btn-info">查询</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 查询输入输出通道模态框 -->
<div class="modal fade" id="queryInputOutputChannelModal" tabindex="-1" role="dialog" aria-labelledby="queryInputOutputChannelModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="queryInputOutputChannelModalLabel" class="modal-title" align="left">查询输入通道</h4>
			</div>
			<div class="modal-body">
				<form id="queryInputOutputChannelForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">传输通道号:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<input id='channel_id' name="channel_id" class="form-control" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-4 col-lg-4 control-label">输入通道状态:</label>
						<div class="col-sm-5 col-md-5 col-lg-5">
							<select id="channel_state" name="channel_state" class="selectpicker show-tick form-control">
								<option value="0">查询全部</option>
	                            <option value="1">查询空闲</option>
	                            <option value="2">查询占用</option>
	                            <option value="3">查询故障</option>
                            </select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button id="btnQueryInputChannelCmd" type="button" class="btn btn-info">请求</button>
				<button id="btnQueryOutputChannelCmd" type="button" class="btn btn-info">请求</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 查询输入输出通道结果模态框 -->
<div class="modal fade" id="queryChannelResultModal" tabindex="-1" role="dialog" aria-labelledby="queryChannelResultModalLabel" aria-hidden="false">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 id="queryChannelResultModalLabel" class="modal-title" align="left">输入通道</h4>
			</div>
			<div class="modal-body">
				<table id="inputChannelResultTable" class="table"></table>
				<table id="outputChannelResultTable" class="table"></table>
			</div>
			<div class="modal-footer" style="text-align: center;" id="footModal">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<%@include file="../common/js.jsp" %>
<script type="text/javascript">
	var allSelectedLineData;			//一级bootstraptable所有选中的行对象
	var allRegionData =${regionList};	//区域树的json数据
	var regionMap = ${regionMap};		//区域树的map数据
	var rebackIPParam;					//状态参数查询时，后台回传的IP
	var rebackPortParam;				//状态参数查询时，后台回传的Port
	$(function () {
		//initZtree1();
    	initZtree2();
    	//initZtree3();
    	//initZtree("whiteListZtree","whiteListZtreeDiv","whiteListZtree_name","whiteListZtree_id",allRegionData);
    	initZtree("terminalDeviceRegionTree","terminalDeviceRegionTreeDiv","terminalDeviceRegion_name","terminalDeviceRegion_id",allRegionData);
        initTerminalDeviceTable();
        initFrontDeviceTable();
        initJeDate();
        initSelect();
    });
	/**
	 * 全选终端设备
	 */
	function selectAllTerminalDevice(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
        	$("#tab_terminalDevice").bootstrapTable('checkAll');
        } else {
        	$("#tab_terminalDevice").bootstrapTable('uncheckAll');
        }
	}
	/**
	 * 通用证书更新(0x40)
	 * 终端证书更新
	 */
	function openTerminalCertificateModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择要更新证书的设备!', {icon: 2});
        } else {
        	layer.confirm("确定要更新证书？", {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
                , icon: 3
            },function(){
            	//**打印**//
    			alert("resourceCode:" + getSelectedResourceCodesByTableId("tab_terminalDevice"));
    	    	$.ajax({
                    url: "${ctx}",
                    type: 'post',
                    async: false,
                    data:{
                    	"resourceCode": getSelectedResourceCodesByTableId("tab_terminalDevice")
                    },
                    success: function (data) {
                    	if (data.status === 200) {
                    		layer.msg(data.msg, {icon: 1});
                    		$("#tab_terminalDevice").bootstrapTable('refresh');
                        } else {
                            layer.msg(data.msg, {icon: 2});
                        }
                    }
                });
            },function(){return;});
        	//$("#terminalCertificateModal").modal('show');
        }
	}
	/**
	 * 通用资源编码设置（0x05）
	 * 设备资源编码设置
	 */
	function openSetResourcecodeModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
        	document.getElementById("resourceCodeForm").reset();
    		$("#resourceCodeModal").modal('show');
        }
	}
	$("#resetResourceCodeBtn").on("click",function(){
		$("#resourceCodeForm").isValid(function(){
			allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
			//**打印**//
			alert("physicalCode:" + allSelectedLineData[0].fPhysicalCode + ",resourceCode:" + getSelectedResourceCodesByTableId("tab_terminalDevice"));
	    	$.ajax({
                url: "${ctx}/instruction/request/updateResourceCode",
                type: 'post',
                async: false,
                data:{
                	"physicalCode": allSelectedLineData[0].fPhysicalCode,
                	"resourceCode": getSelectedResourceCodesByTableId("tab_terminalDevice")
                },
                success: function (data) {
                	$("#resourceCodeModal").modal('hide');
                	if (data.status === 200) {
                		layer.msg(data.msg, {icon: 1});
                		$("#tab_terminalDevice").bootstrapTable('refresh');
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
		});
	});
	/**
	 * 通用音量设置（0x06）
	 * 音量调节, 无回传、默认音量100
	 */
	function openVolumeModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else {
        	var spinner = $( "#volume_spinner" ).spinner({
    	    	min: 0,
    	      	max: 100,
    	      	step: 1,
    	    	spin: function( event, ui ) {
    	    		slider.slider( "value", ui.value );
    	    	}
    	    });
    	    var slider = $( "#volume_slider" ).slider({
    	      min: 0,
    	      max: 100,
    	      step: 1,//增量
    	      slide: function( event, ui ) {
    	        spinner.spinner( "value", ui.value );
    	      }
    	    });
    	    $("#volume_spinner").on("keyup", function(){
    	    	var spanvalue = $("#volume_spinner").val();
    	    	spinner.spinner( "value", spanvalue );
    	     	slider.slider( "value", spanvalue );
    	    });
    	    //初始默认音量100
    	    spinner.spinner( "value", "100");
    	    slider.slider( "value", "100");
    		$("#volumeModal").modal('show');
        }
	    $("#volumeAdjustBtn").one("click",function(){
	    	//**打印**//
	    	alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice") + ",volume:" + spinner.spinner( "value" ));
	    	$.ajax({
                url: "${ctx}/instruction/request/setVolume",
                type: 'post',
                async: true,
                data:{
                	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice"),
                	"volume": spinner.spinner( "value" )
                },
                success: function (data) {
                	$("#volumeModal").modal('hide');
                	if (data.status === 200) {
                		layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
	    });
	}
	/**
     * 功放开关(0x3F)
     * @param powerSwitch 1:关,2:开
     */
	function updateBrdFunc(powerSwitch){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
            return;
        }
      	//**打印**//
    	alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice") + ",switchNumber:" + powerSwitch);
		$.ajax({
		    url: "${ctx}/instruction/request/setTerminalPowerSwitch",
		    type: 'post',
		    async: false,
		    data:{
		    	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice"),
		    	"switchNumber": powerSwitch
		    },
		    success: function (data) {
		    	if (data.status === 200) {
		    		if(powerSwitch==2){
		      	layer.msg("功放打开完成", {icon: 1});
		    		}else if(powerSwitch==1){
		    			layer.msg("功放关闭完成", {icon: 1});
		    		}
		        } else {
		            layer.msg(data.msg, {icon: 2});
		        }
		    }
		});
	}
	/**
	 * 通用回传参数设置（0x07）
	 * 设置回传地址(IP,Port)
	 */
	function openRebackAddressModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else {
        	document.getElementById("rebackAddrForm").reset();
    		$("#rebackAddressModal").modal('show');
        }
	}
	$("#ebrdtRebackAddrSet").on("click",function(){
   		$("#rebackAddrForm").isValid(function(){
   			//**打印**//
   			alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice") + ",returnIpValue:" + $("#rebackIp1").val() + ",returnPortValue:" + $("#rebackPort1").val());
   	    	$.ajax({
   	            url: "${ctx}/instruction/request/setCommonReturnParameter",
   	            type: 'post',
   	            async: false,
   	            data:{
   	            	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice"),
   	           		"returnIpValue": $("#rebackIp1").val(),
   	           		"returnPortValue": $("#rebackPort1").val()
   	            },
   	            success: function (data) {
   	            	$("#rebackAddressModal").modal('hide');
   	            	if (data.status === 200) {
   	            		layer.msg(data.msg, {icon: 1});
   	                } else {
   	                    layer.msg(data.msg, {icon: 2});
   	                }
   	            }
   	        });
   		});
	});
	/**
	 * 设置回传周期（0x0B）
	 */
	function openRebackCycleModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else {
        	document.getElementById("rebackCycleForm").reset();
    		$("#rebackCycleModal").modal('show');
        }
	}
	$("#ebrdtRebackCycleSet").on("click",function(){
		$("#rebackCycleForm").isValid(function(){
			//**打印**//
			alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice") + ",datetime:" + $("#rebaclCycle1").val());
	    	$.ajax({
	            url: "${ctx}/instruction/request/setReturnCycle",
	            type: 'post',
	            async: false,
	            data:{
	            	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice"),
	            	"datetime": $("#rebaclCycle1").val()
	            },
	            success: function (data) {
	            	$("#rebackCycleModal").modal('hide');
	            	if (data.status === 200) {
	            		layer.msg(data.msg, {icon: 1});
	                } else {
	                    layer.msg(data.msg, {icon: 2});
	                }
	            }
	        });
		});
	});
	/**
	 * 终端参数/状态查询指令（0x08）
	 * 状态参数查询
	 */
	function openAskEbrdtInfoModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
            return;
        } 
       	//获得IP和Port
       	rebackIPParam = "10.177.3.205";
       	rebackPortParam = "8088";
		$("#askModal").modal('show');
	}
	$("#askEbrdtInfo").on("click",function(){
        var ztreeNodes = $.fn.zTree.getZTreeObj("ztree2").getCheckedNodes(true);
        if(ztreeNodes.length > 0) {
        	var queryCodes = "";
        	$.each(ztreeNodes, function (i, item) {
            	if(item.fThirdCode != "00") {
            		queryCodes += item.fThirdCode;
                	if(i < ztreeNodes.length-1) queryCodes += ",";
            	}
            });
        	//**打印**//
        	alert(queryCodes);
        	$.ajax({
                url: "${ctx}/instruction/request/setStateQueryParameter",
                type: 'post',
                async: false,
                data:{
                	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice"),
                	"returnIpValue": rebackIPParam,
                	"returnPortValue": rebackPortParam,
                	"queryCodes": queryCodes
                },
                success: function (data) {
                	$("#askModal").modal('hide');
                	if (data.status === 200) {
                		layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        } else {
        	layer.msg("请选择查询项", {icon: 2});
        }
	});
	/**
	 * 查询回复
	 */
	function openInfoRebackModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        }else {
        	//**打印**//
        	alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice"));
	    	$.ajax({
                url: "${ctx}/resourceManage/handUpdate/test/findParamResponse",
                type: 'post',
                async: false,
                data:{
                	"resourceCode": getSelectedResourceCodesByTableId("tab_terminalDevice")
                },
                success: function (data) {
                	if (data.status === 200) {
                		//查询回复展示
                		$("#infoRebackPre").html(JSON.stringify(data.data,null,2));
						$("#infoRebackModal").modal('show');
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        }
	}
	/**
	 * 时钟校准（0x09）
	 */
	function clockCalibration(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else {
        	//**打印**//
        	alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice"));
	    	$.ajax({
                url: "${ctx}/instruction/request/setTime",
                type: 'post',
                async: false,
                data:{
                	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice")
                },
                success: function (data) {
                	if (data.status === 200) {
                		layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        }
	}
	/**
	 * 通用网络参数设置（0x0A）
	 * 本机网络参数设置
	 */
	function openSetIPModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
        	document.getElementById("IPAddrForm").reset();
        	$("#SetEbrdtIPWindow").modal('show');
        }
	}
	$("#setedrdtIPCmd").on("click",function(){
		$("#IPAddrForm").isValid(function(){
			//**打印**//
			alert("resourceCode:" + getSelectedResourceCodesByTableId("tab_terminalDevice") + ",ipAddressValue:" + $("#newIPAddress").val() + ",subnetMask:" + $("#txtsubNetMask").val() + ",ipGate:" + $("#txtgateWay").val());
	    	$.ajax({
	            url: "${ctx}/instruction/request/setNetworkParameter",
	            type: 'post',
	            async: false,
	            data:{
	            	"resourceCode": getSelectedResourceCodesByTableId("tab_terminalDevice"),
	            	"ipAddressValue": $("#newIPAddress").val(),
	            	"subnetMask": $("#txtsubNetMask").val(),
	            	"ipGate": $("#txtgateWay").val()
	            },
	            success: function (data) {
	            	$("#SetEbrdtIPWindow").modal('hide');
	            	if (data.status === 200) {
	            		layer.msg(data.msg, {icon: 1});
	                } else {
	                    layer.msg(data.msg, {icon: 2});
	                }
	            }
	        });
		});
	});
	/**
	 * TS设置频点（0x01）
	 * 锁定频率设置
	 */
	function openTSModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else {
        	document.getElementById("frmTsForm").reset();
        	$("#tsModal").modal('show');
        }
	}
	$("#setScandPointTS").on("click",function(){
		$("#frmTsForm").isValid(function(){
			//**打印**//
			alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice") + ",frequency:" + $("#TSfreq").val() + ",symbolRate:" + $("#TSsymbolRate").val() + ",qamNumber:" + $("#TSqam").val());
	    	$.ajax({
	            url: "${ctx}/instruction/request/setTsLockFrequency",
	            type: 'post',
	            async: false,
	            data:{
	            	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice"),
	            	"frequency": $("#TSfreq").val(),
	            	"symbolRate": $("#TSsymbolRate").val(),
	            	"qamNumber": $("#TSqam").val()
	            },
	            success: function (data) {
	            	$("#tsModal").modal('hide');
	            	if (data.status === 200) {
	            		layer.msg(data.msg, {icon: 1});
	                } else {
	                    layer.msg(data.msg, {icon: 2});
	                }
	            }
	        });
		});
	});
	/**
	 * RDS设置频点（0x02）
	 * 设置扫描频点信息
	 */
	function openRDSModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length == 1){
			//var loadData = [{"rdsPriority":"1","rdsFrequency":"100"},{"rdsPriority":"2","rdsFrequency":"200"},{"rdsPriority":"3","rdsFrequency":"300"},{"rdsPriority":"4","rdsFrequency":"400"},{"rdsPriority":"5","rdsFrequency":"500"}];
        	var loadData = new Array();
        	$.ajax({
                url: "${ctx}/resourceManage/handUpdate/test/findRdsFrequencyPoint",
                type: 'post',
                async: false,
                data:{
                	"resourceCode": getSelectedResourceCodesByTableId("tab_terminalDevice")
                },
                success: function (data) {
                	if (data.status === 200) {
                		$.each(data.data,function(i,item){
                			loadData.push({
                				"rdsPriority": item.fRdsPriority,
                				"rdsFrequency": item.fRdsFrequency
                			});
                		});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        	initRDSTable(loadData);
        	$("#rdsTableModal").modal('show');
        } else{
        	layer.msg("批量操作将重置优先级，请重新添加优先级！", {icon: 2});
        	initRDSTable([]);
        	$("#rdsTableModal").modal('show');
        }
	}
	//RDS设置按钮
	$("#setScandPointRDS").on("click",function(){
		var rdsFrequencyPoint = [];
		var allData = $("#RDSTable").bootstrapTable("getData");
		$.each(allData, function(i, item){
			rdsFrequencyPoint.push({
				"rdsPointSequence": item.rdsPriority,
				"rdsPriority": item.rdsPriority,
				"rdsFrequency": item.rdsFrequency
			});
		});
    	$.ajax({
            url: "${ctx}/instruction/request/setRDSScanFrequencyPoint?resourceCodes="+getSelectedResourceCodesByTableId("tab_terminalDevice"),
            type: 'post',
            async: false,
            data: JSON.stringify(rdsFrequencyPoint),
            contentType: "application/json",
            success: function (data) {
            	$("#rdsTableModal").modal('hide');
 				//$("#RDSTable").bootstrapTable("load",[]);//清空表格数据
            	if (data.status === 200) {
            		layer.msg(data.msg, {icon: 1});
                } else {
                    layer.msg(data.msg, {icon: 2});
                }
            }
        });
	});
	function addRdsFreq(){
		$("#rdsTableModal").modal('hide');
		document.getElementById("addFreqForm").reset();
		$("#addFreqModal").modal('show');
	}
	$("#addFreqModal").on("shown.bs.modal", function(){$("#newFreq").focus();});
	$("#addFreqModal").on('hidden.bs.modal',function(){$("#rdsTableModal").modal('show');});
	$("#addFreqBtn").on("click",function(){
		$("#addFreqForm").isValid(function(){
			var newId = $("#RDSTable").bootstrapTable("getData").length;
			var newFreq = $("#newFreq").val();
			$("#RDSTable").bootstrapTable('insertRow', {
		        index: 0,	//插到最前
		        //index: newId,	//插到最后
		        row: {
		        	"rdsPriority": 1,
		            "rdsFrequency": newFreq
		        }
		    });
			refreshPriority();
			$("#addFreqModal").modal('hide');
		});
	});
	function delRds(){
		var allSelectedRows_RDSTable = $("#RDSTable").bootstrapTable("getSelections");
		if(allSelectedRows_RDSTable.length == 0) return;
		$('#RDSTable').bootstrapTable("remove", {
            field: 'checkbox',
            values: [true]
        });
		refreshPriority();
	}
	/**
	 * RDS设置（0x02）
	 * 设置采用/禁用维持指令
	 */
	function openMaintainModal(){
		allSelectedLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else {
        	document.getElementById("maintainForm").reset();
        	$("#mantainCycle").parent().parent().addClass("none");
        	$("#maintainModal").modal('show');
        }
	}
	$("#isMantain").on("change", function(){
		var flag = $("#isMantain").val();
		if(flag == 0) {
			$("#mantainCycle").parent().parent().addClass("none");
		} else if(flag == 1){
			$("#mantainCycle").val("");
			$("#mantainCycle").parent().parent().removeClass("none");
		}
	});
	$("#setMaintain").on("click", function(){
		if($("#isMantain").val() == 0) {
			$("#mantainCycle").val("0");
		}
		$("#maintainForm").isValid(function(){
			//**打印**//
			alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_terminalDevice") + ",isMantain:" + $("#isMantain").val() + ",mantainCycle:" + $("#mantainCycle").val());
	    	$.ajax({
	            url: "${ctx}",
	            type: 'post',
	            async: false,
	            data:{
	            	"resourceCodes": getSelectedResourceCodesByTableId("tab_terminalDevice"),
	            	"isMantain": $("#isMantain").val(),
	            	"mantainCycle": $("#mantainCycle").val()
	            },
	            success: function (data) {
					$("#maintainModal").modal('hide');
	            	if (data.status === 200) {
	            		layer.msg(data.msg, {icon: 1});
	                } else {
	                    layer.msg(data.msg, {icon: 2});
	                }
	            }
	        });
		});
	})
	
	/**
	 * 适配器证书更新指令（0x41）
	 * 适配器证书更新
	 */
	function openAdapterCertificateModal(){
		allSelectedLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择要更新证书的设备!', {icon: 2});
        } else {
        	layer.confirm("确定要更新证书？", {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
                , icon: 3
            },function(){
            	//**打印**//
    			alert("resourceCode:" + getSelectedResourceCodesByTableId("tab_frontDevice"));
    	    	$.ajax({
                    url: "${ctx}",
                    type: 'post',
                    async: false,
                    data:{
                    	"resourceCode": getSelectedResourceCodesByTableId("tab_frontDevice")
                    },
                    success: function (data) {
                    	if (data.status === 200) {
                    		layer.msg(data.msg, {icon: 1});
                    		$("#tab_frontDevice").bootstrapTable('refresh');
                        } else {
                            layer.msg(data.msg, {icon: 2});
                        }
                    }
                });
            },function(){return;});
        	//$("#adapterCertificateModal").modal('show');
        }
	}
	/**
	 * 回传参数设置(0x0D)
	 * 设置回传参数-适配器
	 */
	function openRebackAdapterModal(){
		allSelectedLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
		if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
			document.getElementById("adapterRebackSetForm").reset();
			$("#rebackAdapterModal").modal('show');
        }
	}
	$("#adapterRebackSet").on("click", function(){
		$("#adapterRebackSetForm").isValid(function(){
			//**打印**//
			alert("resourceCodes:" + getSelectedResourceCodesByTableId("tab_frontDevice") + ",rebackIp:" + $("#rebackIp-adapter").val() + ",rebackPort:" + $("#rebackPort-adapter").val() + ",rebackCycle:" + $("#rebackCycle-adapter").val());
	    	$.ajax({
	            url: "${ctx}",
	            type: 'post',
	            async: false,
	            data:{
	            	"resourceCodes": getSelectedResourceCodesByTableId("tab_frontDevice"),
	            	"rebackIp": $("#rebackIp-adapter").val(),
	            	"rebackPort": $("#rebackPort-adapter").val(),
	            	"rebackCycle": $("#rebackCycle-adapter").val()
	            },
	            success: function (data) {
	            	$("#tsModal").modal('hide');
	            	if (data.status === 200) {
	            		layer.msg(data.msg, {icon: 1});
	                } else {
	                    layer.msg(data.msg, {icon: 2});
	                }
	            }
	        });
		});
	})
	/**
	 * 更新白名单(0x0C)
	 */
	function whitelistUpdate(){
		allSelectedLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
        	loadWhiteListTable(getSelectedResourceCodesByTableId("tab_frontDevice"));
        	$("#updateWhiteListModal").modal('show');
        }
	}
	//新增白名单
	function addNewWhiteListFunc(){
       	var accountList;					//存放账号列表
       	var accountNameList = new Array();	//账号名
       	var userNameList = new Array();		//用户名
       	var userRegionList = new Array();	//用户区域
       	var userPhoneList = new Array();	//用户区域
       	var ifBreak = false;	//若为true，账号列表获取失败退出本方法

       	$.ajax({
	        url: "${ctx}/systemManage/user/list",
	        type: 'get',
	        async: false,//需要同步请求
	        success: function (data) {
	        	if (data.status === 200) {
	        		accountList = data.data.list;
	        		if(accountList.length==0){
	        			layer.msg("账户列表为空", {icon: 2});
	 	        		ifBreak = true;
	        		}
	            } else {
	                layer.msg("获取账号列表失败"+data.msg, {icon: 2});
	        		ifBreak = true;
	            }
	        }
	    });
       	if(ifBreak) return;
       	
       	//成功获取账号列表，开始初始化newWhiteListModal模态框
       	$("#whiteList_account").empty();//清空option
       	$.each(accountList,function(i,item){
       		accountNameList[i] = item.fAccount;
       		$("#whiteList_account").append("<option value="+i+">"+accountNameList[i]+"</option>");
       		userNameList[i] = item.fUsername;
       		userRegionList[i] = item.fRespectiveRegion;
       		userPhoneList[i] = item.fTel;
       	});
       	$("#whiteList_username").val(userNameList[0]);
		$("#newWhiteListModalLabel").html("新增");
		$("#updateWhiteListModal").modal('hide');
		$("#newWhiteListModal").modal('show');

		//每次新增Modal关闭后
		$("#newWhiteListModal").off("hidden.bs.modal").on("hidden.bs.modal",function(){
			loadWhiteListTable(getSelectedResourceCodesByTableId("tab_frontDevice"));//刷新白名单table
			$("#updateWhiteListModal").modal('toggle');//打开updateWhiteListModal
		});
		//select切换option时，同步其他input框数据
		$("#whiteList_account").off("change").on("change",function(){
			$("#whiteList_username").val(userNameList[$("#whiteList_account").val()]);
		});
		//新增请求
		$("#updateWhiteListBtn").off("click").on("click", function(){
			var accountIndex = $("#whiteList_account").val();
			$.ajax({
		        url: "${ctx}/resourceManage/handUpdate/test/addWhiteList",
		        type: 'post',
		        async: false,
		        data:{
		        	"operCode": 1,//操纵类型 1：增加 2：修改 3：删除
		        	"account": accountNameList[accountIndex],
		        	"username": userNameList[accountIndex],
		        	"phoneNumber": userPhoneList[accountIndex],
		        	"permit": $("#permission_type").val(),
		        	"areaCode": userRegionList[accountIndex],
		        	"resourceCode": getSelectedResourceCodesByTableId("tab_frontDevice")
		        },
		        success: function (data) {
		        	$("#newWhiteListModal").modal('hide');
		        	if (data.status === 200) {
		        		layer.msg(data.msg, {icon: 1});
		            } else {
 		                layer.msg(data.msg, {icon: 2});
		            }
		        }
		    });
		});
	}
	//修改白名单
	function updateWhiteListFunc(row){
		//每次修改Modal关闭后
		$("#newWhiteListModal").off("hidden.bs.modal").on("hidden.bs.modal",function(){
			$("#whiteList_account").parent().parent().css("display","block");
			$("#whiteList_username").parent().parent().css("display","block");
			loadWhiteListTable(getSelectedResourceCodesByTableId("tab_frontDevice"));//刷新白名单table
			$("#updateWhiteListModal").modal('toggle');//打开updateWhiteListModal
		});
		//修改newWhiteListModalLabel模态框
		$("#newWhiteListModalLabel").html("修改");
		$("#whiteList_account").parent().parent().css("display","none");
		$("#whiteList_username").parent().parent().css("display","none");
		$("#permission_type").val(row.fPermit);
		$("#updateWhiteListModal").modal('hide');
		$("#newWhiteListModal").modal('show');
		//修改请求
		$("#updateWhiteListBtn").off("click").on("click", function(){
			var accountIndex = $("#whiteList_account").val();
			$.ajax({
		        url: "${ctx}/resourceManage/handUpdate/test/addWhiteList",
		        type: 'post',
		        async: false,
		        data:{
		        	"operCode": 2,//操纵类型 1：增加 2：修改 3：删除
		        	"account": row.fAssociatedId,
		        	"username": row.fUsername,
		        	"phoneNumber": row.fTelephoneNumber,
		        	"permit": $("#permission_type").val(),
		        	"areaCode": row.fPermissionAreaCode,
		        	"resourceCode": getSelectedResourceCodesByTableId("tab_frontDevice")
		        },
		        success: function (data) {
		        	$("#newWhiteListModal").modal('hide');
		        	if (data.status === 200) {
		        		layer.msg(data.msg, {icon: 1});
		            } else {
 		                layer.msg(data.msg, {icon: 2});
		            }
		        }
		    });
		});
	}
	//删除白名单(批量删除和单个删除)
	function delWhiteListFunc(row){
		var whiteListIds = "";
		var allSelectedLineData_whiteList = $("#whiteListTable").bootstrapTable('getSelections');
		if(row==undefined) {//批量删除
			if(allSelectedLineData_whiteList.length == 0) {
				layer.msg("未选择", {icon: 2});
				return;
			}
			$.each(allSelectedLineData_whiteList,function(i,item){
				whiteListIds += item.fId;
				if(i<allSelectedLineData_whiteList.length-1) whiteListIds+=",";
			});
		}else{//单个删除
			whiteListIds = row.fId;
		}
		$.ajax({
	        url: "${ctx}/resourceManage/handUpdate/test/deleteWhiteList",
	        type: 'post',
	        async: false,
	        data:{
	        	"whiteListId": whiteListIds
	        },
	        success: function (data) {
	        	if (data.status === 200) {
	        		loadWhiteListTable(getSelectedResourceCodesByTableId("tab_frontDevice"));//刷新白名单table
	        		layer.msg(data.msg, {icon: 1});
	            } else {
	                layer.msg(data.msg, {icon: 2});
	            }
	        }
	    });
	}
	/**
	 * 播发记录查询(0x10)
	 */
	function openQueryBroadcastWindow(){
		allSelectedLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
        if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
			$("#QBAdapterID").html(allSelectedLineData[0].fDeviceResourceCode);
			$("#QBAdapterName").html(allSelectedLineData[0].fDeviceName);
			document.getElementById("queryBroadcastlogForm").reset();
			$("#queryBroadcastlogModal").modal('show');
        }
	}
	$("#btnQueryboroadcastCmd").on("click", function(){
		layer.msg("操作成功", {icon: 1});
	});
	/**
	 * 查询输入通道（0x0F）
	 */
	function searchinputchannel(){
		allSelectedLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
		if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
        	document.getElementById("queryInputOutputChannelForm").reset();
        	$("#queryInputOutputChannelModalLabel").html("查询输入通道");
        	$(".form-group:has(#channel_state) label").html("输入通道状态:");
        	$("#btnQueryOutputChannelCmd").css("display","none");
        	$("#btnQueryInputChannelCmd").css("display","inline-block");
        	$("#queryInputOutputChannelModal").modal('show');
        }
	}
	$("#btnQueryInputChannelCmd").on("click", function(){
		//**打印**//
		alert(getSelectedResourceCodesByTableId(tab_frontDevice));
		$.ajax({
	        url: "${ctx}/",
	        type: 'post',
	        async: false,
	        data:{
	        	"resourceCodes": getSelectedResourceCodesByTableId("tab_frontDevice"),
	        	"permission_area": $("#orgCode").val(),
	        	"permission_type": $("#permission_type").val()
	        },
	        success: function (data) {
	        	$("#queryInputOutputChannelModal").modal('hide');
	        	$("#queryChannelResultModalLabel").html("输入通道");
	    		$("#queryChannelResultModal").modal('show');
	        	if (data.status === 200) {
	        		layer.msg(data.msg, {icon: 1});
	            } else {
	                layer.msg(data.msg, {icon: 2});
	            }
	        }
	    });
	});
	/**
	 * 查询输出通道(0x0E)
	 */
	function searchoutputchannel(){
		allSelectedLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
		if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
        	document.getElementById("queryInputOutputChannelForm").reset();
        	$("#queryInputOutputChannelModalLabel").html("查询输出通道");
        	$(".form-group:has(#channel_state) label").html("输出通道状态:");
        	$("#btnQueryOutputChannelCmd").css("display","inline-block");
        	$("#btnQueryInputChannelCmd").css("display","none");
        	$("#queryInputOutputChannelModal").modal('show');
        }
	}
	$("#btnQueryOutputChannelCmd").on("click", function(){
		//**打印**//
		alert(getSelectedResourceCodesByTableId(tab_frontDevice));
		$.ajax({
	        url: "${ctx}/",
	        type: 'post',
	        async: false,
	        data:{
	        	"resourceCodes": getSelectedResourceCodesByTableId("tab_frontDevice"),
	        	"permission_area": $("#orgCode").val(),
	        	"permission_type": $("#permission_type").val()
	        },
	        success: function (data) {
	        	$("#queryInputOutputChannelModal").modal('hide');
	    		$("#queryChannelResultModalLabel").html("输出通道");
	    		$("#queryChannelResultModal").modal('show');
	        	if (data.status === 200) {
	        		layer.msg(data.msg, {icon: 1});
	            } else {
	                layer.msg(data.msg, {icon: 2});
	            }
	        }
	    });
	});
	/**
	 * 查询故障（0x11）
	 */
	function searchrfaultinfo(){
		allSelectedLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
		if (allSelectedLineData.length == 0) {
            layer.msg('请先选择设备!', {icon: 2});
        } else if(allSelectedLineData.length > 1){
        	layer.msg('请选择单个设备!', {icon: 2});
        } else {
			layer.msg("操作成功", {icon: 1});
        }
	}
	/**
	 * 绑定terminalDeviceRegion_id输入框change事件
	 */
	$("#terminalDeviceRegion_id").on("change",function(){
		$('#tab_terminalDevice').bootstrapTable("refresh");
	    var selectedNodes = $.fn.zTree.getZTreeObj("terminalDeviceRegionTree").getCheckedNodes(true);
	    if(selectedNodes.length==0){
	    	$('#tab_terminalDevice').bootstrapTable("uncheckAll");
	    }else{
	    	$('#tab_terminalDevice').bootstrapTable("checkAll");
	    }
	});
	/**
	 * 根据table获取资源编码
	 * @param tableId bootstrapTable的id
	 * @return resourceCodes 资源编码
	 */
	function getSelectedResourceCodesByTableId(tableId){
		var resourceCodes = "";
		var all_Select_LineData = $("#" + tableId).bootstrapTable('getSelections');
		$.each(all_Select_LineData, function (i, item) {
			resourceCodes += item.fDeviceResourceCode;
			if(i<all_Select_LineData.length-1) resourceCodes += ",";
	    });
		return resourceCodes;
	}
	/**
	 * 初始化#ztree2(查询参数树)
	 */
	function initZtree2(){
		var treeId = "ztree2";
		var zTreeNodes = [];
    	zTreeNodes.push({
			"id": 1,
			"pId": 0,
			"name": "全选",
			"fThirdCode": "00"
		});
		<c:forEach items="${requestScope.queryCode }" var="queryCode"> 
			zTreeNodes.push({
				"id": "${queryCode.fSort + 1 }",
				"pId": 1,
				"name": "${queryCode.fDictionaryContent }",
				"fThirdCode": "${queryCode.fThirdCode }"
			});
        </c:forEach> 
        var setting = {
				check: {
		            enable: true,
		            chkboxType: {"Y": "s", "N": "ps"}
		        },
				data: {
					simpleData: {
						enable: true,//使用简单json数据构造ztree节点
					}
				},
		        view: {
		    		fontCss : {color:"#fff"},
		    		showIcon: false
		    	}
		 };
		$.fn.zTree.destroy(treeId);
        $.fn.zTree.init($("#" + treeId), setting, zTreeNodes);
        $.fn.zTree.getZTreeObj(treeId).expandAll(true);//全部展开
	}
	/**
	 * 初始化日期插件
	 */
	function initJeDate(){
		jeDate(".jeinput1", {
	        format: "YYYY-MM-DD hh:mm:ss",
	    });
		jeDate(".jeinput2", {
	        format: "YYYY-MM-DD hh:mm:ss",
	    });
	}
	/**
	 * 初始化bootstrap-select
	 */
	function initSelect() {
	    $(window).on('load', function() {
		    $('#chooseTaskType').selectpicker('refresh'); 
		    $('#TSqam').selectpicker('refresh'); 
	    });
	}
	/**
	 * 初始化#tab_terminalDevice终端设备
	 */
	function initTerminalDeviceTable(){
	    $('#tab_terminalDevice').bootstrapTable({
	        url: "../resourceManage/handUpdate/getTerminalDeviceListByDivisions",
	        method: 'get',
	        ajaxOptions: {
	     	   async: false
	        },
	        search: false, //是否显示表格搜索
	        columns: columns_terminalDevice,
	        classes: 'table-no-bordered',
            toolbar: "#terminal-tool",
	        clickToSelect: true,
	        sortable: true, // 是否启用排序
	        sortOrder: "asc", // 排序方式
	        pagination: true, // 是否显示分页（*）
	        pageNumber: 1, // 初始化加载第一页，默认第一页
	        pageSize: 5, // 每页的记录行数（*）
	        pageList: [5, 10, 20], // 可供选择的每页的行数（*）
	        showRefresh: false, // 是否显示刷新按钮
	        sidePagination: 'server',
	        queryParamsType: "",
	        queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
	            return {//这里的params是table提供的
	                Number: params.pageNumber,//从数据库第几条记录开始
	                Size: params.pageSize,//找多少条
	                searchText: $("#terminalDevice_search").val(), //查询内容
 	                //searchText: params.searchText, //查询内容
	                sortOrder: params.sortOrder, //排序方式
	                sortName: params.sortName, //排序名称
	                divisions: function(){
	             	    var dataArray = new Array();
	                    var nodes = $.fn.zTree.getZTreeObj("terminalDeviceRegionTree").getCheckedNodes(true);
	                    //var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
	                    $.each(nodes, function (i, item) {
	                        dataArray[i] = item.id;
	                    });
	                    //console.log(dataArray);
	                    return dataArray;
	                }
	            };
	        },
	        responseHandler: function (result) {
	            if (result.status === 200) {
		            return {
		                total: result.data.total,
		                rows: result.data.list
		            };
	            }
	        }
	    });
		$("#terminalDevice_search").on("input",function(){
			 $('#tab_terminalDevice').bootstrapTable("refresh");
		});
	}
	/**
	 * 初始化#tab_frontDevice前端设备
	 */
	function initFrontDeviceTable(){
        $('#tab_frontDevice').bootstrapTable({
            url: "../resourceManage/handUpdate/getFrontDeviceListByDivisions",
            method: 'get',
            search: false, //是否显示表格搜索
            columns: columns_frontDevice,
            classes: 'table-no-bordered',
            toolbar: "#front-tool",
            clickToSelect: true,
            singleSelect: true,//单选
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: false, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    Number: params.pageNumber,//从数据库第几条记录开始
                    Size: params.pageSize,//找多少条
                    //searchText: params.searchText, //查询内容
	                searchText: $("#frontDevice_search").val(), //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                if (result.status === 200) {
	                return {
	                    total: result.data.total,
	                    rows: result.data.list
	                };
                }
            }
        });
		$("#frontDevice_search").on("input",function(){
			 $('#tab_frontDevice').bootstrapTable("refresh");
		});
	}
	/**
	 * 初始化#whiteList前端设备
	 * @param resourceCode 白名单设备的resourceCode
	 */
	function loadWhiteListTable(resourceCode){
		$('#whiteListTable').bootstrapTable("destroy");
        $('#whiteListTable').bootstrapTable({
            url: "../resourceManage/handUpdate/test/selectwhitelist",
            method: 'get',
            ajaxOptions: {
	     	   async: false
	        },
            search: false, //是否显示表格搜索
            columns: columns_whiteList,
            classes: 'table-no-bordered',
            toolbar: "#whiteList-tool",
            clickToSelect: false,
            //singleSelect: true,//单选
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: false, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                	pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                    resourceCode: resourceCode
                };
            },
            responseHandler: function (result) {
                if (result.status === 200) {
	                return {
	                    total: result.data.total,
	                    rows: result.data.list
	                };
                }
            }
        });
	}
	
	/**
	 * 初始化#RDSTable(RDS优先级表格)
	 */
	function initRDSTable(loadData){
		$('#RDSTable').bootstrapTable("destroy");
		$('#RDSTable').bootstrapTable({
			data: loadData,
			//data: [{"rdsPriority":"1","rdsFrequency":"100"},{"rdsPriority":"2","rdsFrequency":"200"},{"rdsPriority":"3","rdsFrequency":"300"},{"rdsPriority":"4","rdsFrequency":"400"},{"rdsPriority":"5","rdsFrequency":"500"}],
			toolbar: '#RDSToolBar',
			search: false, //是否显示表格搜索
            classes: 'table-no-bordered',
            clickToSelect: false,
            sortable: false, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: false, // 是否显示分页（*）
            showRefresh: false, // 是否显示刷新按钮
			formatNoMatches: function(){
		        return "请添加频率";
		    },
			columns: [{
				field: 'checkbox',
	            checkbox: true,
				width: "50px",
	        }, {
	        	field: 'rdsPriority',
	            align : 'center',
	            title: '优先级'
	        }, {
	            field: 'rdsFrequency',
	            align : 'center',
	            title: '频率'
	        }, {
	            title: '操作', 
	            align : 'center',
				width: "150px",
	            formatter: function () {
	                return '<button class="btn btn-info btn-sm detail-btn up-btn">上移</button><button class="btn btn-info btn-sm detail-btn down-btn">下移</button>';
	            },
	            events: {
	                'click .up-btn': function (e, val, row, index) {
	                	//点击上移
	              		var $tr = $(this).parents("tr");
	        	        if ($tr.index() == 0){
	        	        	alert("首行数据不可上移");
	        	        }else{
	        	            var prevFreq = $tr.prev().children().eq(2).html();
	        	            var freq = $tr.children().eq(2).html();
	        	        	$("#RDSTable").bootstrapTable("updateCell",{
	        	        		index: index-1,
	        	        		field: "rdsFrequency",
	        	        		value: freq
	        	        	});
	        	        	$("#RDSTable").bootstrapTable("updateCell",{
	        	        		index: index,
	        	        		field: "rdsFrequency",
	        	        		value: prevFreq
	        	        	});
	        	        } 
	                },
	                'click .down-btn': function (e, val, row, index) {
	        	        //下移
	        	        var $tr = $(this).parents("tr"); 
	        	        if ($tr.index() == $("#RDSTable").bootstrapTable("getData").length - 1) {
	        	        	alert("末行数据不可下移");
	        	        } else{ 
	        	            var nextFreq = $tr.next().children().eq(2).html();
	        	            var freq = $tr.children().eq(2).html();
	        	        	$("#RDSTable").bootstrapTable("updateCell",{
	        	        		index: index+1,
	        	        		field: "rdsFrequency",
	        	        		value: freq
	        	        	});
	        	        	$("#RDSTable").bootstrapTable("updateCell",{
	        	        		index: index,
	        	        		field: "rdsFrequency",
	        	        		value: nextFreq
	        	        	});
	        	        }
	                }
	            }
	        }]
		});
	}
	
	/**
	 * 初始化#RDSTable优先级序列,新增和删除频率时要调用
	 */
    function refreshPriority(){
    	var allSlectLine = $("#RDSTable").bootstrapTable("getData");
    	$.each(allSlectLine, function (i, item) {
    		$("#RDSTable").bootstrapTable("updateRow",{
        		index: i,
        		row: {
        			"rdsPriority": i+1,
        			"rdsFrequency": item.rdsFrequency
        		}
        	});
    	});
    }
	
	var columns_frontDevice = [ [
			{
				field: 'a',
				checkbox : true
			}, 
			{
				field : 'fDeviceName',
				title : '设备名称',
				align : 'center'
			},
			{
				field : 'fDeviceResourceCode',
				title : '设备资源码',
				width: "200px",
				align : 'center'
			},
			{
				field : 'fRealDeviceModel',
				title : '设备类型',
				align : 'center'
			},
			{
				field : 'fPhysicalCode',
				title : '物理编码',
				width: "120px",
				align : 'center'
			},
			{
				field : 'fRealArea',
				title : '所属区域',
				align : 'center',
				cellStyle : {
					css : {
						"overflow" : "hidden",
						"text-overflow" : "ellipsis",
						"white-space" : "nowrap"
					}
				}
			},
			{
				field : 'fDeviceState',
				title : '设备状态',
				align : 'center',
				formatter : function(data, row, index) {
					if (data == 0) {
						return "正在广播";
					} else if (data == 1) {
						return "在线";
					} else if (data == 2) {
						return "离线";
					} else if (data == 3) {
						return "停电";
					} else if (data == 4) {
						return "故障";
					}
				},
			},
			{
				field : 'fDeviceIp',
				title : '设备IP',
				width: "120px",
				align : 'center'
			},
			{
				field : 'fDevicePort',
				title : '设备端口',
				align : 'center'
			}
	] ];

	var columns_terminalDevice = [
			{
				field: 'a',
				checkbox : true
			}, 
			{
				field : 'fDeviceName',
				title : '设备名称',
				align : 'center'
			},
			{
				field : 'fDeviceResourceCode',
				title : '设备资源码',
				width: "200px",
				align : 'center'
			},
			{
				field : 'fRealDeviceModel',
				title : '设备类型',
				align : 'center'
			},
			{
				field : 'fPhysicalCode',
				title : '物理编码',
				width: "120px",
				align : 'center'
			},
			{
				field : 'fRealArea',
				title : '所属区域',
				align : 'center',
				cellStyle : {
					css : {
						"overflow" : "hidden",
						"text-overflow" : "ellipsis",
						"white-space" : "nowrap"
					}
				}
			},
			{
				field : 'fDeviceState',
				title : '设备状态',
				align : 'center',
				formatter : function(data, row, index) {
					if (data == 0) {
						return "正在广播";
					} else if (data == 1) {
						return "在线";
					} else if (data == 2) {
						return "离线";
					} else if (data == 3) {
						return "停电";
					} else if (data == 4) {
						return "故障";
					}
				},
			},
			{
				field : 'fDeviceIp',
				title : '设备IP',
				width: "120px",
				align : 'center'
			},
			{
				field : 'fDevicePort',
				title : '设备端口',
				align : 'center'
			}
	];
	var columns_whiteList = [
		{
			field: 'a',
			align : 'center',
			checkbox : true
		}, 
		{
			field: 'fAssociatedId',
			title : '账号',
			align : 'center'
		}, 
		{
			field: 'fUsername',
			title : '姓名',
			align : 'center'
		}, 
		{
			field: 'fTelephoneNumber',
			title : '电话',
			width: "120px",
			align : 'center'
		}, 
		{
			field: 'fPermit',
			title : '许可类型',
			align : 'center',
			formatter : function(data, row, index) {
				switch(data){
					case 1: return "短信"; break;
					case 2: return "电话"; break;
					case 3: return "短信和电话"; break;
					default: return "-";
				}
	        }
		}, 
		{
			field: 'fPermissionAreaCode',
			title : '授权区域',
			align : 'center',
            formatter: function (data, row, index) {
                return regionMap[data];
            }
		}, 
		{
			field : 'b',
			title : '操作',
			width: "105px",
			align : 'center',
			events:{
	            'click .edit-base-btn': function (e, val, row) {
	            	updateWhiteListFunc(row);
	            },
	            'click .del-base-btn': function (e, val, row) {
	            	delWhiteListFunc(row);
	            }
			},
			formatter : function() {
	            return '<button class="btn btn-info btn-sm edit-base-btn">修改</button><button class="btn btn-danger btn-sm del-base-btn">删除</button>';
	        }
		}
	];
	
	/**
	 * 自定义下拉框集成ztree
	 * <input id="inputId" name="inputId" class="form-control" type="text" readonly style="cursor: default;" />
	 * <input id="inputHideId" name="inputHideId" type="hidden" />
	 * <div id="treeDivId" style="display:none;background-color: white;position:absolute;z-index:9999;border: 1px solid #DDDDDD">
	 *   <ul id="treeId" class="ztree"></ul>
	 * </div>
	 * @param {String} treeId 用于承接ztree的ul的id
	 * @param {String} treeDivId 用于承接ztree的div的id
	 * @param {String} inputId 接受显示选中文字的input的id
	 * @param {String} inputHideId 接受选中文字对应的id的input的id（一个hidden的input）
	 * @param {Array} treeDataList 形成树形需要的数据数组
	 */
	function initZtree(treeId,treeDivId,inputId,inputHideId,treeDataList) {
		$("#"+inputId).off("click").on("click",function(){
			//console.log("inputclick");
			showTree(treeId,treeDivId,inputId);
		}); 
		var setting = {
			check : {
				enable : true,
				chkboxType : {
					"Y" : "s",
					"N" : "ps"
				}
			},
			data : {
				simpleData : {
					enable : true
				}
			},
			callback : {
				onCheck : function(event, treeId, treeNode) {
					var names = "";
					var codes = "";
					var nodes = $.fn.zTree.getZTreeObj(treeId).getCheckedNodes(true);
					$.each(nodes, function(i, item) {
						names += item.name;
						codes += item.id;
						if (i < nodes.length - 1) {
							names += ",";
							codes += ",";
						}
					});
					$('#'+inputId).val(names);
					$('#'+inputHideId).val(codes);
					$('#'+inputId).trigger("change");
					$('#'+inputHideId).trigger("change");
				}
			},
			view : {
				fontCss : {
					fontSize : "14px"
				},
				showIcon : false
			}
		};
		$.fn.zTree.destroy(treeId);
		$.fn.zTree.init($("#" + treeId), setting, treeDataList);//初始组织树状图
		$.fn.zTree.getZTreeObj(treeId).expandAll(true);//全部展开
	}
	//下拉框显示 隐藏
	function showTree(treeId,treeDivId,inputId) {
		$("#"+treeDivId).width($("#"+inputId).outerWidth());
		if ($('#'+treeDivId).css('display') == 'none') {
			$('#'+treeDivId).css('display', 'block');
		} else {
			$('#'+treeDivId).css('display', 'none');
		}
		$("body").off("mousedown").on("mousedown", function(event){
			onBodyDownByActionType(event,treeId,treeDivId);
		});
	}
	function hideTree(treeId,treeDivId) {
		$('#'+treeDivId).css('display', 'none');
		$("body").off("mousedown");
	}

	//区域外点击事件
	function onBodyDownByActionType(event,treeId,treeDivId) {
		var isChildFlag = isChild(event.target,$("#"+treeDivId)[0]);
		//console.log("isChildFlag:"+isChildFlag);
		if (!isChildFlag){
			hideTree(treeId,treeDivId);
		}
	}
	function isChild(obj,parentObj){
	    while (obj != undefined && obj != null && obj.tagName.toUpperCase() != 'BODY'){
	        if (obj == parentObj){
	            return true;
	        }
	        obj = obj.parentNode;
	    }
	    return false;
	}
</script>
</body>
</html> 