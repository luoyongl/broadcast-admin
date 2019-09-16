<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@page import="cn.wtu.broadcast.config.RegionData" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
	request.setAttribute("map", DictionaryConfig.getAllMap());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>定时广播</title>
		<%@include file="../common/css.jsp" %>
		<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css"> -->
		<style>
			.content{
				height:auto;
			} 
			
			.form-group {
			    margin: 1.5% 0px;
			    padding: 0;
			    padding-left: 15px;
			}
			
			.form-group {
	            padding-right: 1% !important;
	        }
			#add_schedule_modal .modal-dialog{
				width: 90%;	
				height:auto;	
			}	 
			#update_schedule_modal .modal-dialog{
				width: 90%;
			}
			.modal-body {
				padding: 0;
			}	
			 #detail_schedule_modal .modal-dialog{
			 	width: 80%;
			}  	
			   /*  height: 80%;
	    		overflow-y: scroll; */
			
			/* .btn-group .bootstrap-select .show-tick .form-control{ */
			.bootstrap-select {
				background : none;
				color : #ffffff; 
			} 
			
			/* .btn .dropdown-toggle .btn-default{ */
			.dropdown-toggle {
				background : none;
				color : #ffffff; 
			}   
	        /*改变日期样式*/
			table{
			  table-layout:fixed;
			}
			.scheduleType,.scheduleType_update{
				display:none;
			}
			
			.show{
				display:inline-block;
			}

			.content_table {
				height: 92%;
			}
			
			.col-sm-5 {
			    width: 26.666667%;
			} 
			#tab_schedule tbody tr td{
				  width:150px;
			      overflow: hidden; 
			      text-overflow:ellipsis;  
			      white-space: nowrap; 
			 }
			.col-sm-2 {
			    width: 12.666667%;
			}
			#detail_schedule_modal .col-sm-2 {
			    width: 15.666667%;
			}
			.col-sm-3 {
			    width: 24%;
			}
			.col-sm-4 {
			    width: 28.333333%;
			}
			.special .col-sm-3 {
			    width: 10%;
			}
			.col-sm-5 {
			    width: 39.666667%;
			}
			#detail_schedule_modal .col-sm-5 {
			    width: 32.666667%;
			}
			.col-sm-7 {
			    width: 35.333333%;
			}
			#detail_schedule_modal .col-sm-7 {
			    width: 50%; 
			} 
			
		</style>
	</head>
	<body>
		<h4><b>当前位置:制作播发>>定时广播</b></h4>
		<div class="content_table">
			<div class="handle">
				<button class="btn btn-info" data-toggle="modal" id="add_schedule" data-target="#add_schedule_modal">新增</button>
				<button class="btn btn-info" id="update_schedule" >修改</button>
				<button class="btn btn-danger" id="delete_schedule" >取消</button>
			</div>
			<table data-height="450" id="tab_schedule" class="table table-hover"></table>
		</div>
	<!-- 详情模态框（Modal） -->
	<div class="modal fade" id="detail_schedule_modal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" style="width: 65%;overflow-y: scroll;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title">详情</h4>
				</div>
				<div class="modal-body">
				<div class="content col-sm-12"></div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">计划名称：</label>
						<div class="col-sm-7">
							<span  name="fPlanName" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">演练类别：</label>
						<div class="col-sm-7">
							<span  name="fDrillCategory" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">消息类型：</label>
						<div class="col-sm-7">
							<span  name="fRealMessageType" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">消息级别：</label>
						<div class="col-sm-7">
							<span  name="fRealMessageLevel" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">音  源：</label>
						<div class="col-sm-7">
							<span  name="fAudioFileName" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">音量：</label>
						<div class="col-sm-7">
							<span  name="fVolume" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">开始日期：</label>
						<div class="col-sm-7">
							<span  name="fStartDate"  ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">结束日期：</label>
						<div class="col-sm-7">
							<span  name="fEndDate" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">开始时间：</label>
						<div class="col-sm-7">
							<span  name="fStartTime"  ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">结束时间：</label>
						<div class="col-sm-7">
							<span  name="fEndTime" ></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">创建者：</label>
						<div class="col-sm-7">
							<span  name="creator"></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">创建时间：</label>
						<div class="col-sm-7">
							<span  name="fCreateTime"></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">修改者：</label>
						<div class="col-sm-7">
							<span  name="operator"></span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-5 control-label">修改时间：</label>
						<div class="col-sm-7">
							<span  name="fUpdateTime"></span>
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">播发去向：</label>
						<div class="col-sm-10">
							<span  name="fRealBroadcastTo"></span>
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">播发区域：</label>
						<div class="col-sm-10">
							<span  name="fRealArea" ></span>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>	
	
	<!-- 新增模态框（Modal） -->
		<div class="modal fade" id="add_schedule_modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content" >
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
						<h4 class="modal-title" >新增</h4>
					</div>
					<form id="add_form" onsubmit="return true"  method="post">
						<div class="modal-body col-sm-12" >
						<div class="content col-sm-12"></div>
							<div class="modal-body-left col-sm-9" >
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label">计划名称</label>
									<div class="col-sm-8 ">
										<input type="text" id="fPlanName" maxlength="6" name="fPlanName" class="form-control ">
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label">演练类别</label>
									<div class="col-sm-8 ">
										<select class="form-control" id="fDrillCategory" name="fDrillCategory">
											<option value="5" >日常广播</option>
											<option value="3" >实际演练</option>
											<option value="2" >模拟演练</option>
											<option value="1" >系统演练</option>
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >消息类型</label>
									<div class="col-sm-8">
										<select class="form-control" id="fMessageType" name="fMessageType">
											<c:forEach items="${messageTypeList }" var="messageType">
												<option value="${messageType.fId }" <c:if test="selected='selected'">selected</c:if>>
													${messageType.fDictionaryContent }
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >消息级别</label>
									<div class="col-sm-8">
										<select class="form-control" id="fMessageLevel" name="fMessageLevel">
											<c:forEach items="${messageGradeList }" var="message">
												<option value="${message.fId }" <c:if test="selected='selected'">selected</c:if>>
													${message.fDictionaryContent }
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >控制设备</label>
									<div class="col-sm-8">
										<select class="form-control" id="fControlDevice" name="fControlDevice">
											<c:forEach items="${deviceList}" var="deviceInfos">
													<option value="${deviceInfos.fId}" <c:if test="selected='selected'">selected</c:if>>
														${deviceInfos.fDeviceName}
													</option>
											</c:forEach>  
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >设备通道</label>
									<div class="col-sm-8">
										<select id="fChannelContent" class="col-sm-8 form-control" name="fPassSelect">
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >音&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量</label>
									<div class="col-sm-8">
										<input type="text" maxlength="3" onKeyUp="comfirm_Volume($(this))" id="fVolume" name="fVolume" class="form-control">
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >音&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;源</label>
									<div class="col-sm-8">
										<select class="form-control" id="fAudioFile" name="fAudioFile">
											<c:forEach items="${bAudioDataList}" var="bVideoData">
												<option value="${bVideoData.fId}" <c:if test="selected='selected'">selected</c:if>>
													${bVideoData.fAudioName }
												</option>
											</c:forEach>
											<c:forEach items="${FMsettingList}" var="FMsetting">
												<option value="f${FMsetting.fId}" <c:if test="selected='selected'">selected</c:if>>
													${FMsetting.fDictionaryContent }
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								 <div class="form-group col-sm-6 ab">
									<label class="col-sm-4 control-label" >播发去向(可多选)</label>
									<div class="col-sm-8" >
										<select  id="fBroadcastTo1" name="fBroadcastTo" class="selectpicker show-tick form-control" multiple data-live-search="false">	
											<c:forEach items="${broadcastDestinate}" var="broadcastDestinate">
											<option value="${broadcastDestinate.fId}">
												${broadcastDestinate.fDictionaryContent}
											</option>
										</c:forEach>   
										</select>
									</div>
								</div>
								<div class="form-group col-sm-10">
									<label class="col-sm-3 control-label">定时类型</label>
									<div class="col-sm-8" >
										<input checked="checked"  value="0" type="radio"  name="a">单次
										<input type="radio" value="1" style='display: inline-block;margin: 0 0 0 80px;' name="a">重复
									</div>
								</div>
								<div class="scheduleType show">
									<!-- 内容1 -->
									<div class="form-group col-sm-6">
										<label class="col-sm-4 control-label" >时间点</label>
										<div class="jeinpbox col-sm-8">
			            					<input type="text" name="SingleBroadcastTime"  class="jeinput data-YYYY-MM-DD-HH-mm-ss_update1 form-control " placeholder="YYYY-MM-DD HH:mm:ss">
			            				</div>
									</div>
								</div>
								<!-- <div class="col-sm-10 scheduleType"> -->
								<div class="scheduleType">
									<!-- 内容2 -->
									<div class="form-group col-sm-6">
										<label class="col-sm-4 control-label" >日期设置</label>
										<div class="jeinpbox col-sm-8">
			            					<input type="text" id="fStartAndEndDate" name="fStartAndEndDate" class="jeinput data-YYYY-MM-DD_update1 form-control " placeholder="YYYY-MM-DD至YYYY-MM-DD">
			            				</div>
									</div>
								     <div class="form-group col-sm-6 ab">
										<label class="col-sm-4 control-label" >星期设置</label>
										<div class="col-sm-8" >
											<!-- <select class="selectpicker form-control">
											<select id="fChooseWeek" name="fChooseWeek" class="selectpicker show-tick form-control" multiple data-live-search="false" placeholder="hh-mm-ss至hh-mm-ss"> -->
											<select id="fChooseWeek1" name="fChooseWeek" class="selectpicker show-tick form-control" multiple data-live-search="false">	
												<option value="2">星期一</option>
											    <option value="3">星期二</option>
											    <option value="4">星期三</option>
											    <option value="5">星期四</option>
											    <option value="6">星期五</option>  
											    <option value="7">星期六</option>  
											    <option value="1">星期日</option>  
											</select>
										</div>
									</div>
									 <div class="form-group col-sm-6">
										<label class="col-sm-4 control-label">时段设置</label>
										<div class="jeinpbox col-sm-8">
			               					<input type="text" id="fStartAndEndTime" onKeyUp="comfirm_DateIntervalAdd($(this))" name="fStartAndEndTime" class="jeinput data-hh-mm-ss_update1 form-control" placeholder="hh:mm:ss至hh:mm:ss">
			               				</div>
									 </div>
									 <div class="form-group col-sm-6">
										<label class="col-sm-4 control-label">重复次数</label>
										<div class="col-sm-8">
											<input type="text" id="fRepeateTime" onKeyUp="comfirm_FRepeateTimeAdd($(this))" name="fRepeateTime" class="form-control">
										</div>
									 </div>
									 <!-- <div class="form-group col-sm-6">
										<label class="col-sm-4 control-label">时间间隔(s)</label>
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" name="fTimeInterval" class="form-control">
										</div>
									 </div>	 -->	
									 <div class="form-group special col-sm-3">
										<label class="col-sm-12 control-label">时间间隔设置</label>
									 </div>							
									<!--  <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" onKeyUp="comfirm_TimeIntervalAdd($(this))" name="fTimeIntervalDay" class="form-control">
										</div>
										<label class="col-sm-2 control-label">天</label>
									 </div>	 -->
									 <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" onKeyUp="comfirm_TimeIntervalAdd($(this))" name="fTimeIntervalHour" class="form-control">
										</div>
										<label class="col-sm-2 control-label">时</label>
									 </div>							
									 <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" onKeyUp="comfirm_TimeIntervalAdd($(this))" name="fTimeIntervalMinute" class="form-control">
										</div>
										<label class="col-sm-2 control-label">分</label>
									 </div>							
									 <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" onKeyUp="comfirm_TimeIntervalAdd($(this))" name="fTimeIntervalSecond" class="form-control">
										</div>
										<label class="col-sm-2 control-label">秒</label>
									 </div>							
								</div>				 
							</div>
							<div class="modal-body-right col-sm-3"  id="tree">
								<label>播发区域</label> 
								<div class="right-tree" style="height:300px">
									<!-- 展示ztree效果 :使用标准json数据构造ztree-->
									<ul id="ztree1" class="ztree"></ul>
									<!--ajax请求  <ul id="ztree3" class="ztree"></ul>-->
								</div>
							</div>
						</div>
						
						<div class="modal-footer ">
							<button type="button" class="btn btn-info" id="add_button" >确定</button>
							<button type="button" id="cancel" class="btn btn-info" data-dismiss="modal">取消</button>
						</div>

					</form>
				</div>
				<!-- /.modal-content -->
				
			</div>
			<!-- /.modal -->
		</div>
	
	<!-- 修改模态框（Modal） -->
		<div class="modal fade" id="update_schedule_modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content" >
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
						<h4 class="modal-title" id="title">修改</h4>
					</div>
					<form id="update_form" onsubmit="return true"  method="post">
						<div class="modal-body col-sm-12" >
						<div class="content col-sm-12"></div>
							<div class="modal-body-left col-sm-9">
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label">计划名称</label>
									<div class="col-sm-8 ">
										<input type="text" id="fPlanName" name="fPlanName" class="form-control ">
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label">演练类别</label>
									<div class="col-sm-8 ">
										<select class="form-control" id="fDrillCategory" name="fDrillCategory">
											<option value="1" <c:if test="selected='selected'">selected</c:if>>日常广播</option>
											<option value="2" <c:if test="selected='selected'">selected</c:if>>实际演练</option>
											<option value="3" <c:if test="selected='selected'">selected</c:if>>模拟演练</option>
											<option value="4" <c:if test="selected='selected'">selected</c:if>>系统演练</option>
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >消息类型</label>
									<div class="col-sm-8">
										<select class="form-control" id="fMessageType" name="fMessageType">
											<c:forEach items="${messageTypeList }" var="messageType">
												<option value="${messageType.fId }" <c:if test="selected='selected'">selected</c:if>>
													${messageType.fDictionaryContent }
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >消息级别</label>
									<div class="col-sm-8">
										<select class="form-control" id="fMessageLevel" name="fMessageLevel">
											<c:forEach items="${messageGradeList }" var="message">
												<option value="${message.fId }" <c:if test="selected='selected'">selected</c:if>>
													${message.fDictionaryContent }
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >控制设备</label>
									<div class="col-sm-8">
										<select class="form-control" id="fControlDevice" name="fControlDevice">
											<c:forEach items="${deviceList}" var="deviceInfos">
													<option value="${deviceInfos.fId}" <c:if test="selected='selected'">selected</c:if>>
														${deviceInfos.fDeviceName}
													</option>
											</c:forEach>  
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >设备通道</label>
									<div class="col-sm-8">
										<select class="form-control" id="fDeviceChannel" name="fDeviceChannel">
											 <c:forEach items="${deviceList}" var="channelSelect">
												  <option  value="${channelSelect.fId}" <c:if test="selected='selected'">selected</c:if>> 
												     ${channelSelect.fChannelContent}
												  </option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >音&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量</label>
									<div class="col-sm-8">
										<input type="text" maxlength="3" onKeyUp="comfirm_Volume($(this))" id="fVolume" name="fVolume" class="form-control">
									</div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-4 control-label" >音&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;源</label>
									<div class="col-sm-8">
										<select class="form-control" id="fAudioFile" name="fAudioFile">
											<c:forEach items="${bAudioDataList}" var="bVideoData">
												<option value="${bVideoData.fId}" <c:if test="selected='selected'">selected</c:if>>
													${bVideoData.fAudioName }
												</option>
											</c:forEach>
											<c:forEach items="${FMsettingList}" var="FMsetting">
												<option value="${FMsetting.fId}f" <c:if test="selected='selected'">selected</c:if>>
													${FMsetting.fDictionaryContent }
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								 <div class="form-group col-sm-6 a">
									<label class="col-sm-4 control-label" >播发去向(可多选)</label>
									<div class="col-sm-8" >
										<select  id="fBroadcastTo2" name="fBroadcastTo" class="selectpicker show-tick form-control" multiple data-live-search="false">	
											<c:forEach items="${broadcastDestinate}" var="broadcastDestinate">
											<option value="${broadcastDestinate.fId}">
												${broadcastDestinate.fDictionaryContent}
											</option>
										</c:forEach>   
										</select>
									</div>
								</div>								
								<div class="form-group col-sm-10">
									<label class="col-sm-3 control-label">定时类型</label>
									<div class="col-sm-8" >
										<input checked="checked" value="0" type="radio"  name="a">单次
										<input type="radio" value="1" style='display: inline-block;margin: 0 0 0 80px;' name="a">重复
									</div>
								</div>
								<div class="scheduleType_update show">
									<!-- 内容1 -->
									<div class="form-group col-sm-6">
										<label class="col-sm-4 control-label" >时间点</label>
										<div class="jeinpbox col-sm-8">
			            					<input type="text" name="SingleBroadcastTime"  class="jeinput data-YYYY-MM-DD-HH-mm-ss_update2 form-control " placeholder="YYYY-MM-DD HH:mm:ss">
			            				</div>
									</div>
								</div>
								<!-- <div class="col-sm-10 scheduleType"> -->
								<div class="scheduleType_update">
									<!-- 内容2 -->
									<div class="form-group col-sm-6">
										<label class="col-sm-4 control-label" >日期设置</label>
										<div class="jeinpbox col-sm-8">
			            					<input type="text" id="fStartAndEndDate" name="fStartAndEndDate" class="jeinput data-YYYY-MM-DD_update2 form-control " placeholder="YYYY-MM-DD至YYYY-MM-DD">
			            				</div>
									</div>
								     <div class="form-group col-sm-6 b">
										<label class="col-sm-4 control-label" >星期设置(可多选)</label>
										<div class="col-sm-8" >
											<!-- <select class="selectpicker form-control">
											<select id="fChooseWeek" name="fChooseWeek" class="selectpicker show-tick form-control" multiple data-live-search="false" placeholder="hh-mm-ss至hh-mm-ss"> -->
											<select id="fChooseWeek2" name="fChooseWeek" class="selectpicker show-tick form-control" multiple data-live-search="false">	
												<option value="2">星期一</option>
											    <option value="3">星期二</option>
											    <option value="4">星期三</option>
											    <option value="5">星期四</option>
											    <option value="6">星期五</option>  
											    <option value="7">星期六</option>  
											    <option value="1">星期日</option>  
											</select>
										</div>
									</div>
									 <div class="form-group col-sm-6">
										<label class="col-sm-4 control-label">时段设置</label>
										<div class="jeinpbox col-sm-8">
			               					<input type="text" id="fStartAndEndTime" name="fStartAndEndTime" onKeyUp="comfirm_DateIntervalAdd($(this))" class="jeinput data-hh-mm-ss_update2 form-control" placeholder="hh:mm:ss至hh:mm:ss">
			               				</div>
									 </div>
									 <!-- <div class="form-group col-sm-6">
										<label class="col-sm-4 control-label">时间间隔(s)</label>
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" name="fTimeInterval" class="form-control">
										</div>
									 </div> -->
									 <div class="form-group col-sm-6">
										<label class="col-sm-4 control-label">重复次数</label>
										<div class="col-sm-8">
											<input type="text" id="fRepeateTime" name="fRepeateTime" onKeyUp="comfirm_FRepeateTimeAdd($(this))" class="form-control">
										</div>
									 </div>
									 <div class="form-group special col-sm-3">
										<label class="col-sm-12 control-label">时间间隔设置</label>
									 </div>							
									 <!-- <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" name="fTimeIntervalDay" class="form-control">
										</div>
										<label class="col-sm-2 control-label">天</label>
									 </div> -->	
									 <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" onKeyUp="comfirm_TimeIntervalAdd($(this))" name="fTimeIntervalHour" class="form-control">
										</div>
										<label class="col-sm-2 control-label">时</label>
									 </div>							
									 <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" onKeyUp="comfirm_TimeIntervalAdd($(this))" name="fTimeIntervalMinute" class="form-control">
										</div>
										<label class="col-sm-2 control-label">分</label>
									 </div>							
									 <div class="form-group col-sm-3">
										<div class="col-sm-8">
											<input type="text" id="fTimeInterval" onKeyUp="comfirm_TimeIntervalAdd($(this))" name="fTimeIntervalSecond" class="form-control">
										</div>
										<label class="col-sm-2 control-label">秒</label>
									 </div>
								</div>				 
							</div>
							<!-- <div class="modal-body-right col-sm-3"  id="tree"> 
								<label>播发区域</label>
								<div class="right-tree" style="height:300px">
									展示ztree效果 :使用标准json数据构造ztree
									<ul id="ztree2" class="ztree"></ul>
									ajax请求  <ul id="ztree3" class="ztree"></ul>
								</div>
							</div> -->
							<div class="modal-body-right col-sm-3"  id="tree">
								<label>播发区域</label> 
								<div class="right-tree" style="height:300px">
									<!-- 展示ztree效果 :使用标准json数据构造ztree-->
									<ul id="ztree2" class="ztree"></ul>
									<!--ajax请求  <ul id="ztree3" class="ztree"></ul>-->
								</div>
							</div>
						</div>
						
						<div class="modal-footer ">
							<button type="button" class="btn btn-info" id="update_button" >确定</button>
							<button type="button" id="cancel" class="btn btn-info" data-dismiss="modal">取消</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
				
			</div>
			<!-- /.modal -->
		</div>
		
		<%@include file="../common/js.jsp" %>
		<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script> -->
		<!--<script src="../../js/common-tree.js"></script>-->
		<script type="text/javascript">
			$(".modal input[type='radio']").on('click',function(){;  
			var index=$(this).index();
			 $('.scheduleType').eq(index).addClass('show') //为选中项添加高亮
			  .siblings().removeClass('show').end;//去除其他项的高亮形式
			  $('.scheduleType_update').eq(index).addClass('show') //为选中项添加高亮
			  .siblings().removeClass('show').end;//去除其他项的高亮形式
			});

			jeDate(".data-YYYY-MM-DD_update1",{
		        format: "YYYY-MM-DD",
		        multiPane:false,
		        isToday:true,                               //是否显示今天或本月
		        range:" 至 "
		    });
		   jeDate(".data-hh-mm-ss_update1",{
		        format: "hh:mm:ss",
		        multiPane:false,
		        range:" 至 "
			});
		   jeDate(".data-YYYY-MM-DD-HH-mm-ss_update1",{
		        format: "YYYY-MM-DD hh:mm:ss"
		    });
		    jeDate(".data-YYYY-MM-DD_update2",{
		        format: "YYYY-MM-DD",
		        multiPane:false,
		        range:" 至 "
		    });
		   jeDate(".data-hh-mm-ss_update2",{
		        format: "hh:mm:ss",
		        multiPane:false,
		        range:" 至 "
			});
		   jeDate(".data-YYYY-MM-DD-HH-mm-ss_update2",{
		        format: "YYYY-MM-DD hh:mm:ss"
		    });
		</script>
	<script type="text/javascript">
		$(window).on('load', function () {
		    $('#fChooseWeek1').selectpicker({
		    	noneSelectedText : '请选择',
		    });
		    $('#fChooseWeek2').selectpicker({
		    	noneSelectedText : '请选择',
		    });
		    $('#fBroadcastTo1').selectpicker({
		    	noneSelectedText : '请选择',
		    });
		    $('#fBroadcastTo2').selectpicker({
		    	noneSelectedText : '请选择',
		    });
		});
		
		//用于提交验证
		var flag=1;  
		//日期设置全局变量
		var dateInterval = null;
		//时间间隔全局变量
		var timeInterval = null;
		//间隔秒数
		var second = null;
		//输入的间隔秒数
		var inSecond = null;
		var columns  =	[[{
					field : 'checkbox',
			        checkbox : true
				}, {
					field : 'fId',
					title : 'ID',
					align : 'center',
					width : '5%',
				}, {
					field : 'fPlanName',
					title:'计划名称',
					align : 'center',
					width : '8%',
				}, {
					field : 'fDrillCategory',
					title :'演练类别',
					align : 'center',
					width: '10%',
					sortable : true,
					formatter:function(data,row,index){
						if(data == 5)
							return "日常广播";
						else if(data == 3)
							return "实际演练";
						else if(data == 2)
							return "模拟演练";
						else if(data == 1)
							return "系统演练";
						else 
							return "其他";
					}
				},{
					field : 'fRealMessageType',
					title :'消息类型',
					align : 'center',
					width: '10%',
					/* width: '10%', */
					/* sortable : true, */
				},{
					field : 'fRealMessageLevel',
					title :'消息级别',
					align : 'center',
					width: '10%',
					/* width: '10%', */
					/* sortable : true, */
				},{
					field : 'fRealMessageSource',
					title :'消息来源',
					align : 'center',
					width: '13%',
					/* width: '10%', */
					/* sortable : true, */
				},{
					field : 'fstartDateTime',
					title :'开始时间',
					align : 'center',
					width: '15%',
					sortable : true,
					formatter: function (time) {
	                    //return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : '';
	                    return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : '';
					},
				}, {
					field : 'fendDateTime',
					title :'结束时间',
					align : 'center',
					width: '15%',
					sortable : true,
					formatter: function (time) {
	                    //return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : '';
	                    return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : '';
					},
				}, {
					field : 'creator',
					title : '操作者',
					align : 'center',
					width: '7%',
				},{
	                field: 'fReviewFlag',
	                title: '状态',
	                align: 'center',
	                width: '7%',
	                sortable : true,
	                formatter: function (value) {
	                	if(value == 1){
	                    return '<span class="label label-warning">待审核</span>';
	                	}else if(value == 2){
	                   		return '<span class="label label-success">已审核</span>';
	                    }else if(value == 5){
	                   		return '<span class="label label-danger">未通过</span>';
	                    }else if(value == 6){
	                   		return '<span class="label label-danger">已取消</span>';
	                    }
					}
	            },{
		            title: '操作',
		            align: 'center',
		            events: {
		                'click .edit-btn': function (e, val, row) {
		                	dataShowDetail(row);
		                    $('#detail_schedule_modal').modal('show');
		                },
		            },
		            formatter: function () {
		                return '<button class="btn btn-info btn-sm edit-btn">详情</button> '
		            }
		        }]]; 
		
		$(function() {
			$('#tab_schedule').bootstrapTable({
				method: 'get',
                dataType: "json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                search: true, //是否显示表格搜索
                columns: columns,
				classes:'table-no-bordered',
				url: "${ctx}/broadcast/schedule/getAllList",
				toolbar : '#toolbarComputer', // 工具按钮用哪个容器
				sortable : true, // 是否启用排序
				sortOrder : "asc", // 排序方式			
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
		         		pageNumber : params.pageNumber, // SQL语句起始索引
	                    pageSize : params.pageSize, // 每页显示数量                
	                    pageOrderName : params.sortOrder, //排序方式
	                    pageSortName : params.sortName, //排序名称
	                    search : params.searchText, //模糊查询
		            };
		        }, 				 
				responseHandler:function (result) {
						//result_data = result.data.list;
			        	 if(result.status === 200){	   
			        	}
		                return{
		                	total: result.data.total, 
		                	rows: result.data.list
		                }; 			            
				}
			});
			var regionData= ${regionList};
			loadRegionTree("ztree1",regionData);
			loadRegionTree("ztree2",regionData);
			/* alert("测试1");
			$(".modal-dialog").draggable();
			alert("测试2"); */
			$(".modal-dialog").draggable();
		});
		
		//新增
		$("#add_button").click(function(){
	        confirm("#add_form");
	        if(flag==0)
	            return;
	        layer.load(2); 
	        var data="";
	        var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
	        $.each(nodes, function (i, item) {
	            data = data + item.id;
	            if (i < nodes.length - 1) {
	                data = data + ',';
	            }
	        });
	        $.post('', $('#add_form').serialize()+'&areaIds='+data, function (result) {    
	        	if (result.status === 200){
					$("#add_schedule_modal").modal('hide');
					$('#tab_schedule').bootstrapTable('refresh');
					//layer.alert('定时广播新增成功!', {icon: 1});
					layer.msg(result.msg, {icon: 1});
					layer.closeAll('loading');
					document.getElementById("add_form").reset();
				}else{
					//layer.alert('定时广播新增失败，请重试!', {icon: 2});
					layer.msg(result.msg, {icon: 2});
					layer.closeAll('loading');
				}
	        });
	    });  
		
		//修改
		$("#update_schedule").click(function(){
			/* if(flag==0)
	            return false; */
	        var checked= $('#tab_schedule').bootstrapTable('getSelections');

	        if(checked.length==0){
	            layer.msg('请选择要修改的记录', {icon: 2});
	        }
	        else if(checked.length>1){
	            layer.msg('只能选择一个记录', {icon: 2});
	        }
	        else if(checked[0].fReviewFlag == 2){
	        	layer.msg('该记录已审核，不能修改', {icon: 2});
	        }
	        else{
	            //$("#update_button").attr("style","display:show;");
	            var arr = new Array();
		        var arr2 = new Array();
		        var arr3 = new Array();
		        var treeMap=new Map();
		        var regionList=${regionList};
				for (var i = 0; i< regionList.length; i++) {
							arr2.push(regionList[i].name);		
							arr3.push(regionList[i].id);
							treeMap.set(regionList[i].name, regionList[i].id);
				}
				var name=checked[0].fRealArea+"";
		        var zTree_Menu = $.fn.zTree.getZTreeObj("ztree2");
		        var nodes = zTree_Menu.transformToArray(zTree_Menu.getNodes());
		        console.log(nodes);
		        if (nodes.length>0) {
		            for(var i=0;i<nodes.length;i++){
		                if(name.indexOf(nodes[i].name) >= 0){
		                    nodes[i].checked = true;
		                    zTree_Menu.updateNode(nodes[i]);
		                }
		            }
		        }
	            dataReShow(checked);
	            $('#update_schedule_modal').modal('show');	 
	        }
	    })
		$("#update_button").click(function(){
					confirm("#update_form");
			        if(flag==0)
			            return;
	                layer.load(2); 
	                var checked= $('#tab_schedule').bootstrapTable('getSelections');
	            	//alert("测试");
	                $.post('${ctx}/broadcast/schedule/update?fId='+checked[0].fId,  $('#update_form').serialize() , function (result) {	                	
	                	if (result.status === 200){
	                		$("#update_schedule_modal").modal('hide');
							$('#tab_schedule').bootstrapTable('refresh');
							//layer.alert('定时广播修改成功!', {icon: 1});
							layer.msg(result.msg, {icon: 1});
							layer.closeAll('loading');
							//location.reload();
						}else{
							//layer.alert('定时广播修改失败，请重试!', {icon: 2});
							since = since + 1;
							layer.msg(result.msg, {icon: 2});
							layer.closeAll('loading');
						}
	                });	            	
             
	            })
	    
		//删除
		$("#delete_schedule").click(function(){
	        var checked= $('#tab_schedule').bootstrapTable('getSelections');
	        var del_ids = "";
	        if(checked.length==0){
	            layer.msg('请选择要删除的记录', {icon: 2});
	        }else{
	
	            layer.confirm('确认删除'+checked.length+"条数据?", {icon: 3, title: '操作提示'}, function (index) {
	                for(i=0;i<checked.length;i++){
	                    del_ids += checked[i].fId + ",";
	                }
	                layer.load(2);
	                $.post('', '_method=delete&ids=' + del_ids, function (result) {    
	                    if (result.status === 200){
							$('#tab_schedule').bootstrapTable('refresh');
							//layer.alert('定时广播删除成功!', {icon: 1});
							layer.msg(result.msg, {icon: 1});
							layer.closeAll('loading');
						}else{
							//layer.alert('定时广播删除失败，请重试!', {icon: 2});
							layer.msg(result.msg, {icon: 2});
							layer.closeAll('loading');
						}
	                });
	            });
	        }
	    })
	    
		//数据回显
		function dataReShow(checked){
			//$("#update_schedule_modal input[name='fPlanName']").val(checked[0].fPlanName);
			$.each(checked[0],function(key,value){
				$("#update_schedule_modal input[name='"+key+"']").val(value);
			});
			/* $("#update_schedule_modal input[name='fPlanName']").val(checked[0].fPlanName); */
			if(checked[0].fSingleBroadcastTime == null){
				$("#update_schedule_modal input[name='fStartAndEndDate']").val(new Date(checked[0].fStartDate).format('yyyy-MM-dd')+"至"+new Date(checked[0].fEndDate).format('yyyy-MM-dd'));
				$("#update_schedule_modal input[name='fStartAndEndTime']").val(new Date(checked[0].fStartTime).format('hh:mm:ss')+"至"+new Date(checked[0].fEndTime).format('hh:mm:ss'));				
			}
			if(checked[0].fSingleBroadcastTime != null){				
				$("#update_schedule_modal input[name='SingleBroadcastTime']").val(new Date(checked[0].fSingleBroadcastTime).format('yyyy-MM-dd hh:mm:ss'));
			}
			//$('#fChooseWeek2').selectpicker('val', checked[0].fChooseWeek);				
			//$('#fBroadcastTo2').selectpicker('val', checked[0].fBroadcastTo);
			//$("#fAudioFile").find("option[value="+checked[0].fAudioFile+"]").attr("selected",true); 
			//$("#fAudioFile").val(checked[0].fAudioFile);
			$("#update_schedule_modal select[name='fAudioFile']").val(checked[0].fAudioFile);
			//$("#fMessageType").find("option[value="+checked[0].fMessageType+"]").attr("selected",true); 
			//$("#fMessageType").val(checked[0].fMessageType);
			$("#update_schedule_modal select[name='fMessageType']").val(checked[0].fMessageType);
			$("#update_schedule_modal select[name='fMessageLevel']").val(checked[0].fMessageLevel);
			$("#update_schedule_modal select[name='fControlDevice']").val(checked[0].fControlDevice);
			//$("#fDrillCategory").val(checked[0].fDrillCategory);
			$("#update_schedule_modal select[name='fDrillCategory']").val(checked[0].fDrillCategory);
			var $option=$("#update_schedule_modal select[name='fChooseWeek']").find("option");
			var str='';
			var fChooseWeek=(checked[0].fChooseWeek);
			if(fChooseWeek!=null&&fChooseWeek!=""){
				for(var i=0;i<$option.length;i++){
					if((fChooseWeek.indexOf($option[i].value))>-1){						
						str=str+Trim($("#update_schedule_modal select[name='fChooseWeek']").find("option[value='"+$option[i].value+"']").text())+",";
					}
				} 
			}
			str = str.substr(0, str.length - 1); 
			$(".modal .b .filter-option").text(str);
			var $option1=$("#update_schedule_modal select[name='fBroadcastTo']").find("option");
			var str1='';
			var fBroadcastTo=(checked[0].fBroadcastTo);
			if(fBroadcastTo!=null&&fBroadcastTo!=""){
				for(var i=0;i<$option1.length;i++){
					if((fBroadcastTo.indexOf($option1[i].value))>-1){						
						str1=str1+Trim($("#update_schedule_modal select[name='fBroadcastTo']").find("option[value='"+$option1[i].value+"']").text())+",";
						if(Trim($(this).text())==str1){
                            $(this).parent().parent().addClass("selected");
                        }
					}
				} 
			}
			str1 = str1.substr(0, str1.length - 1);
			$(".modal .a .filter-option").text(str1);

			var daychecked = Math.floor(checked[0].fTimeInterval / 86400);
			var hourchecked = Math.floor((checked[0].fTimeInterval-daychecked*86400) / 3600);
			var minutechecked = Math.floor((checked[0].fTimeInterval-daychecked*86400-hourchecked*3600) / 60);
			var secondchecked = checked[0].fTimeInterval-daychecked*86400-hourchecked*3600-minutechecked*60
			/* $("#update_schedule_modal input[name='fTimeIntervalDay']").val(daychecked); */
			$("#update_schedule_modal input[name='fTimeIntervalHour']").val(hourchecked);
			$("#update_schedule_modal input[name='fTimeIntervalMinute']").val(minutechecked);
			$("#update_schedule_modal input[name='fTimeIntervalSecond']").val(secondchecked);
		}
		//清除空格
	     function Trim(str){ 
	          return str.replace(/(^\s*)|(\s*$)/g, ""); 
	    }
		
		//数据回显（详情）
		function dataShowDetail(checked){
			$.each(checked,function(key,value){
				$("#detail_schedule_modal span[name='"+key+"']").text(value!=null?value:"");
			});				
			//$("#update_schedule_modal input[name='fPlanName']").text(checked[0].fPlanName);
			$("#detail_schedule_modal span[name='fStartDate']").text(new Date(checked.fStartDate).format('yyyy-MM-dd'));	
			$("#detail_schedule_modal span[name='fEndDate']").text(new Date(checked.fEndDate).format('yyyy-MM-dd'));	
			$("#detail_schedule_modal span[name='fStartTime']").text(new Date(checked.fStartTime).format('HH:mm:ss'));	
			$("#detail_schedule_modal span[name='fEndTime']").text(new Date(checked.fEndTime).format('HH:mm:ss'));	
			$("#detail_schedule_modal span[name='fCreateTime']").text(new Date(checked.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
			$("#detail_schedule_modal span[name='fUpdateTime']").text(checked.fUpdateTime?new Date(checked.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'):"");
			if(checked.fDrillCategory == 1){
				$("#detail_schedule_modal span[name='fDrillCategory']").text("日常广播");
			}else if(checked.fDrillCategory == 2){
				$("#detail_schedule_modal span[name='fDrillCategory']").text("实际演练");
			}else if(checked.fDrillCategory == 3){
				$("#detail_schedule_modal span[name='fDrillCategory']").text("模拟演练");
			}else if(checked.fDrillCategory == 4){
				$("#detail_schedule_modal span[name='fDrillCategory']").text("系统演练");
			}
			if(checked.fFMFileName != null){
				$("#detail_schedule_modal span[name='fAudioFileName']").text(checked.fFMFileName);
			}
		}
		
		//校验
		 function confirm(value){
        	var fVolume=$(value+" "+"input[name='fVolume']").val();
        	let boradcastto= $(value).find(".dropdown-menu.inner.selectpicker").find(".selected");
        	flag=true;
        	var re=/^(?:[1-9]?\d|100)$/;
        	if(!fVolume){
        		layer.tips('音量不能为空!', 
        				value+" "+"input[name='fVolume']",{
    	    	    	tips: [2,'red'],
    	    	    	tipsMore: true
        	    	}
        	    );
        		flag=false;
	        	}else if(!re.test(fVolume)){
	            		layer.tips('请输入0-100间的整数!', 
	            				value+" "+"input[name='fVolume']",{
	                	    	tips: [2,'red'],
	                	    	tipsMore: true
	                	    }  	
	                	)
	        	} 
	        	var fPlanName=$(value+" "+"input[name='fPlanName']").val();
        		if(!fPlanName){
        			layer.tips('请填写完整计划名',$(value+" "+"input[name='fPlanName']"),{
            	    	tips: [2,'red'],
            	    	tipsMore: true
        	    	});
        			flag=false;
        		}else{        		
	        		$.ajax({
	   	          	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
	   	               type: 'post',
	   	               async: false,
	   	               data: {
	   	              	 "input":fPlanName,
	   	               },
	   	               success: function (data) {
	   	              	 
	   	              	 if(data.length != 0){
	   	              		 
	   	              		 layer.tips('存在敏感字'+ '\"' +data + '\"', $(value + " " +"input[name='fPlanName']"), {
	   	                           tips: [2, 'red'],
	   	                           tipsMore: true
	   	                       });
	   	                       flag = false;
	   	              	 }	   	                   
	   	               }
	   	          });   
        		}
        		//判断播发去向是否为空
                if (boradcastto.length==0){
                    flag=false;
                    layer.tips('请选择播发去向', $(value+" "+"select[name='fBroadcastTo']").next(), {
                        tips: [2, 'red'],
                        tipsMore: true
                    })
                } 
        		/* var fBroadcastTo=$(value+" "+"select[name='fBroadcastTo']").val(); */
        		//var fBroadcastTo = $('#fBroadcastTo2').selectpicker('val');
        		//if(!fBroadcastTo || fBroadcastTo == null){
        		//	layer.tips('请填写播发去向',$(value+" "+"select[name='fBroadcastTo']"),{ 
        		//	layer.tips('请填写播发去向',$(value+" "+"select[name='fBroadcastTo']").next(),{
            	//    	tips: [2,'red'],
            	//    	tipsMore: true
        	    //	});
        		//	flag=false;
        		//} 
        		/* var broadcastTo=$(value+" "+"select[name='fBroadcastTo']").val();
        		alert(broadcastTo);
        		if (broadcastTo == null){
        			alert("测试");
		            layer.tips('请选择播发去向', ".btn.selectpicker", {
		                tips: [2, 'red'],
		                tipsMore: true
		            })
		            flag=false;
		        } */
		        let treeObj = null;
		        let tr = null;
		        if(value == "#add_form"){
		       		treeObj = $.fn.zTree.getZTreeObj("ztree1");	
		       		tr = "ztree1";
		        } else{
		        	treeObj = $.fn.zTree.getZTreeObj("ztree2");	
		        	tr = "ztree2";
		        } 
		        let nodes=treeObj.getCheckedNodes(true);
		        if (nodes.length==0){
		            layer.tips('请选择播发区域!','#'+tr, {
		                tips: [2, 'red'],
		                tipsMore: true
		            })
		            flag=false;
		        }
        		var singleBroadcastTime=$(value+" "+"input[name='SingleBroadcastTime']").val();
        		var b = $(value+" "+"input[name='a']:checked").val();
        		if(!singleBroadcastTime && b == 0){
        			layer.tips('请填写完整时间点',$(value+" "+"input[name='SingleBroadcastTime']"),{
            	    	tips: [2,'red'],
            	    	tipsMore: true
        	    	});
        			flag=false;
        		}
        		var fStartAndEndDate=$(value+" "+"input[name='fStartAndEndDate']").val();
        		var a = $(value+" "+"input[name='a']:checked").val();
        		if(!fStartAndEndDate && a == 1){
        			layer.tips('请填写完整日期',$(value+" "+"input[name='fStartAndEndDate']"),{
            	    	tips: [2,'red'],
            	    	tipsMore: true
        	    	});
        			flag=false;
        		}
        		var fStartAndEndTime=$(value+" "+"input[name='fStartAndEndTime']").val();
        		timeInterval = fStartAndEndTime;
        		if(!fStartAndEndTime && a == 1){
        			layer.tips('请填写完整时段',$(value+" "+"input[name='fStartAndEndTime']"),{
            	    	tips: [2,'red'],
            	    	tipsMore: true
        	    	});
        			flag=false;
        		}
        		/* var fTimeIntervalDay=$(value+" "+"input[name='fTimeIntervalDay']").val(); */
        		var fTimeIntervalHour=$(value+" "+"input[name='fTimeIntervalHour']").val();
        		var fTimeIntervalMinute=$(value+" "+"input[name='fTimeIntervalMinute']").val();
        		var fTimeIntervalSecond=$(value+" "+"input[name='fTimeIntervalSecond']").val();
        		if(!fTimeIntervalHour && !fTimeIntervalMinute && !fTimeIntervalSecond && a == 1){
        			layer.tips('请填写完整时间间隔',$(value+" "+"input[name='fTimeIntervalSecond']"),{
            	    	tips: [2,'red'],
            	    	tipsMore: true
        	    	});
        			flag=false;
        		}
        		var fRepeateTime=$(value+" "+"input[name='fRepeateTime']").val();
        		if(!fRepeateTime && a == 1){
        			layer.tips('请填写完整重复次数',$(value+" "+"input[name='fRepeateTime']"),{
            	    	tips: [2,'red'],
            	    	tipsMore: true
        	    	});
        			flag=false;
        		}
        		
	        return flag;
        } 
		
        //刷新地域树
        $('body').on('hidden.bs.modal', '.modal', function () {
            //document.getElementById("add_form").reset();
            //document.getElementById("update_form").reset();
            $.fn.zTree.getZTreeObj("ztree1").checkAllNodes(false);
            $.fn.zTree.getZTreeObj("ztree2").checkAllNodes(false);
			$("#TTS").css("display","none");
            //$(".selectpicker").selectpicker('refresh');//对searchPayState这个下拉框进行重置刷新
            //$(".dropdown-menu.inner.selectpicker").find("li").removeClass("selected");
            /* $('select').each(function(i, j) {
    			$(j).find("option:selected").attr("selected", false);
    			$(j).find("option").first().attr("selected", true);
    			$("input[name='fVolumeControl']").val("");
    			$('input:checkbox').removeAttr('checked');
    		})  */
        });
       
        
        //动态验证(日期)
        function comfirm_DateIntervalAdd(e){
        	dateInterval = $("#add_form input[name='fStartAndEndDate']").val();
			if(dateInterval == null || dateInterval == ""){
           		layer.tips('请先填写日期设置!', 
        				e,{
            	    	tips: [2,'red'],
            	    	tipsMore: true,
            	    })
           	}
        }
        
		//动态验证(时段)
		function comfirm_TimeIntervalAdd(e){
			timeInterval = $("#add_form input[name='fStartAndEndTime']").val();
			if(timeInterval == null || timeInterval == ""){
           		layer.tips('请先填写时段设置!', 
        				e,{
            	    	tips: [2,'red'],
            	    	tipsMore: true,
            	    })
           	}
			time = timeInterval.split('至');
			var start_time = time[0];
			var end_time = time[1];
			
			var st =  start_time.split(':');
			var startSeconds = parseInt(st[0]) * 3600  + parseInt(st[1]) * 60  + parseInt(st[2]) ;
			
			var et =  end_time.split(':');
			var endSeconds = parseInt(et[0]) * 3600  + parseInt(et[1]) * 60  + parseInt(et[2]) ;

			second = endSeconds - startSeconds;
       		/* var inputSecond=e.val(); */
       		/* var fTimeIntervalDay = $("#add_form input[name='fTimeIntervalDay']").val(); */
       		var fTimeIntervalHour = $("#add_form input[name='fTimeIntervalHour']").val();
       		var fTimeIntervalMinute = $("#add_form input[name='fTimeIntervalMinute']").val();
       		var fTimeIntervalSecond = $("#add_form input[name='fTimeIntervalSecond']").val();
       		var inputSecond = fTimeIntervalHour*60*60 + fTimeIntervalMinute*60 + fTimeIntervalSecond*1;
       		inSecond = inputSecond;
       		if(inputSecond > second){
           		layer.tips('时间间隔过大，请输入正确的时间间隔!', 
        				e,{
            	    	tips: [2,'red'],
            	    	tipsMore: true,
            	    })
           	}
        }
		
		//动态验证(重复次数)
		function comfirm_FRepeateTimeAdd(e){
			if(inSecond == null || inSecond == ""){
           		layer.tips('请先填写时间间隔!', 
        				e,{
            	    	tips: [2,'red'],
            	    	tipsMore: true,
            	    })
           	}
			var number = Math.floor(second/inSecond);
       		var inNumber = e.val();
       		if(inNumber > number){
           		layer.tips('重复次数过多，请输入正确的重复次数!', 
        				e,{
            	    	tips: [2,'red'],
            	    	tipsMore: true,
            	    })
           	}
        }
		
		//动态验证音量
		function comfirm_Volume(e){
       		var fVolume=e.val();
           	var re=/^(?:[1-9]?\d|100)$/;
           	if(!re.test(fVolume)){
           		layer.tips('请输入0-100间的整数!', 
        				e,{
            	    	tips: [2,'red'],
            	    	tipsMore: true,
            	    })
           	}
        }
		$("select[name='fControlDevice']").change(function () {
			$("select[name='fPassSelect']").find("option").remove();
			var deviceId=$(this).find("option:selected").attr("value");
			$.getJSON('${ctx}/broadcast/drill/selectDeviceChannel?deviceId='+deviceId,function (result) {
				var data=result.data;
				var fChannelContent=data.fChannelContent;
				<c:forEach items="${map}" var="map">
				if (fChannelContent.indexOf(${map.key})>-1){
					$("select[name='fPassSelect']").append("<option value='${map.key}'>${map.value}</option>");
				}
				</c:forEach>
			})
		});

	</script>	
	</body>
</html>
