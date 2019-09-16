<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData,cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionJson", RegionData.getUserZTreeList2Json());
    request.setAttribute("regionMap", RegionData.getNameMapJson());
    request.setAttribute("config", SystemConfig.getMap());
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <title>应急设备</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .select-tree {
            display: none;
            position: absolute;
            padding: 5px 0;
            z-index: 999;
            border: 1px solid #d2d2d2;
            max-height: 100px;
            overflow-y: auto;
            background-color: #fff;
            border-radius: 2px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
            box-sizing: border-box;
            top: auto;
            bottom: 100%;
            margin-bottom: 4px;
        }

        .modal-dialog.import {
            width: 40%;

        }

        .modal-dialog {
            width: 70%;
            height: 80%;
            overflow-y: auto
        }

        .modal-dialog.detail {
            width: 50%;
            height: auto;
            overflow-y: auto
        }

        .handle.a {
            float: left;
        }

        .textarea {
            resize: none;
            border: 1;
            background-color: transparent;
            /*scrollbar-arrow-color:yellow;
            scrollbar-base-color:lightsalmon;
            overflow: hidden;*/
            color: #666464;
            height: auto;
            padding: 10px;
            font-size: 1.3em;
            color: #ccc;
            border: solid 1px #ccc;
            margin: 0 0 20px;
            -moz-box-shadow: inset 0 0 4px rgba(0, 0, 0, 0.2);
            -webkit-box-shadow: inset 0 0 4px rgba(0, 0, 0, 0.2);
            box-shadow: inner 0 0 4px rgba(0, 0, 0, 0.2);
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border-radius: 3px;
        }

        .file {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            background-color: #5bc0de;
            border-color: #46b8da;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }

        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }

        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }

        .file {
            padding: 6px 12px;
        }

        .btn-group.bootstrap-select.show-tick.form-control {
            width: 100%;
            background: none;
        }

        .btn.dropdown-toggle.btn-default {
            background: none;
            color: #ffffff;
        }

        .form-group.double {
            margin-left: 50px
        }

        .modal-dialog {
            width: 80%;
        }
    </style>
</head>

<body>
<h4><b>当前位置:资源管理>>应急设备</b></h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li id="headendEquipment" class="selected_tab"><a>前端设备</a></li>
        <li id="terminalEquipment"><a>终端设备</a></li>
<!--         <li id="transmitterEquipment"><a>发射机设备</a></li> -->
    </ul>
</div>


<div class="tab_modal show">
    <div class="content_table">
        <div class="handle">
            <button class="btn btn-info" data-toggle="modal" id="add_frontDevice" data-target="#frontDevice_modal">新增
            </button>
            <button class="btn btn-info" id="update_frontDevice">修改</button>
            <button class="btn btn-danger" id="deleteFront">删除</button>
            <button class="btn btn-info" id="frontExport">导出</button>
        </div>
        <table data-height="600" id="tab_frontDevice" class="table table-hover"></table>
    </div>
</div>
<div class="tab_modal">
    <div class="content_table">
        <div class="handle">
            <button class="btn btn-info" data-toggle="modal" data-target="#terminalDevice_modal">新增</button>
            <button class="btn btn-info" id="update_terminalDevice">修改</button>
            <button class="btn btn-danger" id="deleteTerminal">删除</button>
            <button class="btn btn-info" type="button" data-toggle="modal" data-target="#import_modal">导入</button>
            <button class="btn btn-info" id="terminalExport">导出</button>
        </div>
        <table id="tab_terminalDevice" data-height="600" class="table table-hover"></table>
    </div>
</div>
<!-- <div class="tab_modal"> -->
<!--     <div class="content_table"> -->
<!--         <div class="handle"> -->
<!--             <button class="btn btn-info" data-toggle="modal" id="add_transmitter" data-target="#transmitterEquipment_modal">新增 -->
<!--             </button> -->
<!--             <button class="btn btn-info" id="update_transmitter">修改</button> -->
<!--             <button class="btn btn-danger" id="delete_transmitter">删除</button> -->
  
<!--         </div> -->
<!--         <table data-height="600" id="tab_transmitter" class="table table-hover"></table> -->
<!--     </div> -->
<!-- </div> -->

<!-- 前端设备模态框（Modal） -->
<div class="modal fade" id="frontDevice_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="frontTitle">新增</h4>
            </div>
            <div class="modal-body col-sm-12">
                <div class="content col-sm-12">
                    <div class="modal-body-left col-sm-9">
                        <form id="form_frontDevice" class="form_device"
                              data-validator-option="{theme:'simple_right',timely:1,focusCleanup:true,stopOnError:true}">
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4  control-label">设备编号</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" name="fNumber"
                                           data-rule="required;length(2);fNumber;isNotzero"
                                           data-rule-fNumber="[/^[0-9a-zA_Z]+$/, '请输入字母或数字']"
                                           data-rule-isNotzero="[/^[0-9]*[1-9][0-9]*$/,'不能为00']">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">设备名称</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="hidden" id="fId" name="fId">
                                    <input type="text" class="form-control" name="fDeviceName">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">设备类型</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fDeviceModel">
                                        <c:forEach items="${frontDeviceList }" var="frontDevice">
                                            <%-- <option value="${frontDevice.fId}" number="${config.adapter_prefix}" --%>
                                            <option value="${frontDevice.fId}" number="${frontDevice.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${frontDevice.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">设备通道</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="selectpicker show-tick form-control" multiple
                                            data-live-search="false"
                                            data-validate="" name="fChannelContent" title="请选择">
                                        <c:forEach items="${devicechannelList }" var="devicechannelList">
                                            <option value="${devicechannelList.fId}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${devicechannelList.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">设备IP</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fDeviceIp"
                                           data-rule="required;ip"

                                           data-rule-ip="[/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,'请输入正确ip']">
                                </div>
                            </div>
                            <div class="form-group  col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">设备端口</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" min="0" class="form-control " name="fDevicePort">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">经度</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" class="form-control " name="fLongitude">
                                </div>
                            </div>
                            <div class="form-group  col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">纬度</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" class="form-control " name="fDimension">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">资源级别识别码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fResourceLevel">
                                        <c:forEach items="${resourceLevelList }" var="resourceLevel">
                                            <option value="${resourceLevel.fId}" number="${resourceLevel.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${resourceLevel.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4  control-label">资源类型顺序码</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" name="reTypeNumber">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">资源子类型码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fResourceSubtypes">
                                        <c:forEach items="${resourceSubtypesList }" var="resourceSubtypes">
                                            <option value="${resourceSubtypes.fId}" number="${resourceSubtypes.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${resourceSubtypes.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4  control-label">资源子类型顺序码</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" name="reSubtypeNumber">
                                </div>
                            </div>
                            
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">所属区域</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="hidden" name="fLocation" id="fRespectiveRegion1">
                                    <input autocomplete="off" class="form-control" type="text" id="selectRegion1"
                                           readonly
                                           required>
                                    <div id="menuContent1" class="select-tree">
                                        <ul id="ztree1" class="ztree"></ul>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">安装地址</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fInstallAddress">
                                </div>
                            </div>

                            <div class="form-group  col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">物理编码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fPhysicalCode"
                                           data-rule="required;length(12)" maxlength="12">
                                </div>
                            </div>
                            <div class="form-group  col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">资源编码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" readonly="readonly"
                                           name="fDeviceResourceCode">
                                </div>
                            </div>


                            <div class="form-group  col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">URL</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fUrl">
                                </div>
                            </div>
                            <div class="form-group  col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">显示级别</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" class="form-control " name="fDisplayLevel">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">绑定证书</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" name="fCertificate">
                                        <option value="0">请选择</option>
                                        <option value="1">000000000000</option>
                                        <option value="2">000000000001</option>
                                        <option value="3">000000000002</option>
                                        <option value="4">000000000003</option>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">协议类型</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select id="protocol" name="fProtocolType"
                                            class="selectpicker show-tick form-control" multiple
                                            data-live-search="false" title="请选择">
                                        <c:forEach items="${protocolTypeList}" var="protocolType">
                                            <option value="${protocolType.fId}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${protocolType.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">厂商信息</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" name="fManufacturerInfo">
                                        <c:forEach items="${manufacturerList }" var="manufacturer">
                                            <option value="${manufacturer.fManufacturerNo}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${manufacturer.fManufacturerName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group  col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5  col-md-5 col-lg-4 control-label">维护人员</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fMaintainer" data-rule="length(~8)">
                                </div>
                            </div>

                            <%--<div class="form-group col-sm-12 col-md-12 col-lg-12 ">
                                <label class="col-sm-2 col-md-2 col-lg-1 control-label">备注</label>
                                <div class="col-sm-9 col-md-9 col-lg-9">
                                    <textarea class="form-control textarea" rows="3" name="fRemark"
                                              data-rule="length(~200)"></textarea>
                                </div>
                            </div>--%>
                    </div>
                    <div class="modal-body-right col-sm-3"
                         style="display: flex;justify-content:center;align-items:center;">
                        <label id="image1" for="file1" style="padding:50px;"><img
                                src="${ctx}/static/img/picture/addPhoto.jpg"
                                style="width: 100px;height: 100px;"></label>
                        <input type="file" id="file1" name="fDeviceImage" style="display: none" accept="image/*"/>
                        <input style="display: none" name="fDeviceImage" id="front_fDeviceImage">
                    </div>
                </div>
                <div class="null"></div>
            </div>
            <div class="null"></div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-info" id="confirm">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
            </form>
        </div>
    </div>
    <!-- /.modal-content -->
</div>


<!-- 添加终端设备模态框（Modal） -->
<div class="modal fade" id="terminalDevice_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="terminalTitle">新增</h4>
            </div>
            <div class="modal-body col-sm-12 col-md-12 col-lg-12">
                <div class="content col-sm-12 col-md-12 col-lg-12">
                    <div class="modal-body-left col-sm-9">
                        <form id="form_terminalDevice" class="form_device"
                              data-validator-option="{theme:'simple_right',timely:1,focusCleanup:true}">
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">设备编号</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fNumber"
                                           data-rule="required;length(~2);fNumber;isNotzero"
                                           data-rule-fNumber="[/^[0-9a-zA_Z]+$/, '请输入字母或数字']"
                                           data-rule-isNotzero="[/^[0-9]*[1-9][0-9]*$/,'不能为00']">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">设备名称</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="hidden" id="fId2" name="fId">
                                    <input type="text" class="form-control " name="fDeviceName">
                                </div>
                            </div>

 							<div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">资源级别识别码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fResourceLevel">
                                        <c:forEach items="${resourceLevelList }" var="resourceLevel">
                                            <option value="${resourceLevel.fId}" number="${resourceLevel.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${resourceLevel.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4  control-label">资源类型顺序码</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" name="reTypeNumber">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">资源子类型码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fResourceSubtypes">
                                        <c:forEach items="${resourceSubtypesList }" var="resourceSubtypes">
                                            <option value="${resourceSubtypes.fId}" number="${resourceSubtypes.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${resourceSubtypes.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4  control-label">资源子类型顺序码</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" name="reSubtypeNumber">
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">设备IP</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fDeviceIp"
                                    data-rule="required;ip"
                                    data-rule-ip="[/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,'请输入正确ip']">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">设备端口</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" min="0" class="form-control " name="fDevicePort">
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">设备类型</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fDeviceModel">
                                        <c:forEach items="${terminalDeviceList }" var="terminalDevice">
                                            <%-- <option value="${terminalDevice.fId}" number="${config.terminal_prefix}" --%>
                                            <option value="${terminalDevice.fId}" number="${terminalDevice.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${terminalDevice.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">物理码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fPhysicalCode"
                                           data-rule="required;length(12)" maxlength="12">
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">经度</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" class="form-control " name="fLongitude">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">纬度</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" class="form-control " name="fDimension">
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">状态</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" name="fEnableState">
                                        <option value="1">启用</option>
                                        <option value="0">未启用</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">设备频段</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fDeviceBand">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">所属区域</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="hidden" name="fLocation" id="fRespectiveRegion">
                                    <input autocomplete="off" class="form-control" type="text" id="selectRegion"
                                           readonly
                                           required>
                                    <div id="menuContent" class="select-tree">
                                        <ul id="ztree" class="ztree"></ul>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">安装地址</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fInstallAddress">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">指令PID</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control " name="fAcceptCommandPid">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">显示级别</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="number" class="form-control " name="fDisplayLevel">
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">绑定证书</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" name="fCertificate">
                                        <option value="0">请选择</option>
                                        <option value="1">000000000000</option>
                                        <option value="2">000000000001</option>
                                        <option value="3">000000000002</option>
                                        <option value="4">000000000003</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">资源码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" readonly="readonly"
                                           name="fDeviceResourceCode">
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">协议类型</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select id="protocol2" name="fProtocolType"
                                            class="selectpicker show-tick form-control" multiple
                                            data-live-search="false" title="请选择">
                                        <c:forEach items="${protocolTypeList}" var="protocolType">
                                            <option value="${protocolType.fId}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${protocolType.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4 control-label">厂商信息</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" name="fManufacturerInfo">
                                        <c:forEach items="${manufacturerList }" var="manufacturer">
                                            <option value="${manufacturer.fManufacturerNo}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${manufacturer.fManufacturerName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group col-sm-12 col-md-12 col-lg-12 ">
                                <label class="col-sm-2 col-md-2 col-lg-1 control-label">备注</label>
                                <div class="col-sm-9 col-md-9 col-lg-9">
                                    <textarea class="form-control textarea" rows="3" name="fRemark"
                                              data-rule="length(0~200)"></textarea>
                                </div>
                            </div>
                    </div>
                    <div class="modal-body-right col-sm-3"
                         style="display: flex;justify-content:center;align-items:center;">
                        <label id="image2" for="file2" style="padding:50px;"><img
                                src="${ctx}/static/img/picture/addPhoto.jpg"
                                style="width: 100px;height: 100px;"></label>
                        <input type="file" id="file2" name="fDeviceImage" style="display: none" accept="image/*"/>
                        <input style="display: none" name="fDeviceImage" id="terminal_fDeviceImage">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-info" id="confirm2">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
            </form>
        </div>
    </div>
    <!-- /.modal-content -->
</div>


<!-- 发射机设备模态框（Modal） -->
<div class="modal fade" id="transmitterEquipment_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="transmitterTitle">新增</h4>
            </div>
            <div class="modal-body col-sm-12 col-md-12 col-lg-12">
                <div class="content col-sm-12 col-md-12 col-lg-12">
                  
                  <form id="form_transmitter" class="form_transmitter"
                        data-validator-option="{theme:'simple_right',timely:1,focusCleanup:true}">
                      <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">发射机编号</label>
                          <div class="col-sm-7 col-md-7 col-lg-7">
                              <input type="text" class="form-control " name="transmitterId" id="transmitterId"
                                     data-rule="required;length(~2);fNumber;isNotzero"
                                     data-rule-fNumber="[/^[0-9a-zA_Z]+$/, '请输入字母或数字']"  
                                     data-rule-isNotzero="[/^[0-9]*[1-9][0-9]*$/,'不能为00']">
                          </div>
                      </div>
                      <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">发射机名称</label>
                          <div class="col-sm-7 col-md-7 col-lg-7">
                              <input type="text" class="form-control " id="transmitterName">
                          </div>
                      </div>
                      
                      <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">资源级别识别码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fResourceLevel">
                                        <c:forEach items="${resourceLevelList }" var="resourceLevel">
                                            <option value="${resourceLevel.fId}" number="${resourceLevel.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${resourceLevel.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4  control-label">资源类型顺序码</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" name="reTypeNumber">
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-5 col-md-5 col-lg-4 control-label">资源子类型码</label>
                                <div class="col-sm-7 col-md-7 col-lg-7">
                                    <select class="form-control" data-validate="required" name="fResourceSubtypes">
                                        <c:forEach items="${resourceSubtypesList }" var="resourceSubtypes">
                                            <option value="${resourceSubtypes.fId}" number="${resourceSubtypes.fThirdCode}"
                                                    <c:if test="selected='selected'">selected</c:if>>
                                                    ${resourceSubtypes.fDictionaryContent}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6">
                                <label class="col-sm-4 col-md-5 col-lg-4  control-label">资源子类型顺序码</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type="text" class="form-control" name="reSubtypeNumber">
                                </div>
                            </div>
                      
                    <!--   <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">绑定适配器</label>
                          <div class="col-sm-7 col-md-7 col-lg-7">
                              <input type="text" class="form-control " name="adapterName">
                          </div>
                      </div> -->
                       <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">绑定适配器</label>
                          <div class="col-sm-7 col-md-7 col-lg-7">
                                <!-- <input name="fDeviceType" type="text" class="form-control "> -->
                                <select class="form-control" id="adapterSelect" name="fDeviceModel">                                   
                                    <c:forEach items="${adapterList}" var="adapter">
                                        <option value="${adapter.fId}" number="${config.adapter_prefix}"
                                                <c:if test="selected='selected'">selected</c:if>>${adapter.fDeviceName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                      <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">所属区域</label>
                          		<div class="col-sm-7 col-md-7 col-lg-7">
                                    <input type="hidden" name="fLocation" id="region">
                                    <input autocomplete="off" class="form-control" type="text" id="selectRegion3"
                                           readonly
                                           required>
                                    <div id="menuContent3" class="select-tree">
                                        <ul id="ztree3" class="ztree"></ul>
                                    </div>
                                </div>
                      </div>
                      <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">安装地址</label>
                          <div class="col-sm-7 col-md-7 col-lg-7">
                              <input type="text" class="form-control " id="transmitterInstallArea">
                          </div>
                      </div>
                      <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">物理编码</label>
                          <div class="col-sm-7 col-md-7 col-lg-7">
                              <input type="text" class="form-control " id="transmitterPhysicalCode">
                          </div>
                      </div>
                      <div class="form-group col-sm-6 col-md-6 col-lg-6">
                          <label class="col-sm-4 col-md-5 col-lg-4 control-label">资源编码</label>
                          <div class="col-sm-7 col-md-7 col-lg-7">
                              <input type="text" class="form-control " id="transmitterResourceCode" readonly="readonly" name="fDeviceResourceCode">
                          </div>
                      </div>
                      
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-info" id="confirm3">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
            </form>
        </div>
    </div>
    <!-- /.modal-content -->
</div>


<!-- 详情模态框（Modal） -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog detail">
        <div class="modal-content">
            <form>
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
                            <label class="col-sm-5 control-label">设备类型:</label>
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
                            <label class="col-sm-5 control-label">硬件版本:</label>
                            <div class="col-sm-7">
                                <span id="fHardwareVersion"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">软件版本:</label>
                            <div class="col-sm-7">
                                <span id="fSoftwareVersion"></span>
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
                                <span id="fEnableState"></span>
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
                        <div class="form-group col-sm-12">
                            <label class="col-sm-2 control-label">备注:</label>
                            <div class="col-sm-7">
                                <span id="fRemark"></span>
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

<!-- 详情模态框（Modal） -->
<div class="modal fade" id="infoModal_transmitter" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog detail">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">详情</h4>
                </div>
                <div class="modal-body">
                    <div class="content col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机编号:</label>
                            <div class="col-sm-7">
                                <span id="transmitterId2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机名称:</label>
                            <div class="col-sm-7">
                                <span id="transmitterName2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">绑定适配器:</label>
                            <div class="col-sm-7">
                                <span id="adapterName2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">所属区域:</label>
                            <div class="col-sm-7">
                                <span id="region2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">安装地址:</label>
                            <div class="col-sm-7">
                                <span id="installArea2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">物理编码:</label>
                            <div class="col-sm-7">
                                <span id="physicalCode2"></span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">资源编码:</label>
                            <div class="col-sm-7">
                                <span id="resourceCode2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机状态:</label>
                            <div class="col-sm-7">
                                <span id="transmitterState2"></span>
                            </div>
                        </div>

                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机输出频率:</label>
                            <div class="col-sm-7">
                                <span id="transmitterOutputFrequency2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">输出功率:</label>
                            <div class="col-sm-7">
                                <span id="outputPower2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">设备温度:</label>
                            <div class="col-sm-7">
                                <span id="equipmentTemperature2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机工作电压:</label>
                            <div class="col-sm-7">
                                <span id="transmitterOperatingVoltage2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机工作电流:</label>
                            <div class="col-sm-7">
                                <span id="transmitterOperatingCurrent2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">发射机反射功率:</label>
                            <div class="col-sm-7">
                                <span id="transmitterReflectionPower2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">左声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="leftChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">右声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="rightChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">和声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="harmonicChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">差声道调制度:</label>
                            <div class="col-sm-7">
                                <span id="differentialChannelModulation2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">RF锁定状态:</label>
                            <div class="col-sm-7">
                                <span id="rfLockInState2"></span>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-5 control-label">RF锁定状态:</label>
                            <div class="col-sm-7">
                                <span id="pllLockInState2"></span>
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

<div class="modal fade" id="import_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog import">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">导入</h4>
            </div>
            <form id="importForm" action="../resourceManage/emergencyDevice/importExcel" method="post"
                  enctype="multipart/form-data">
                <div class="modal-body col-sm-12">
                    <div class="form-group col-sm-12" style="padding: 10px">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">选择文件：</label>
                            <div class="col-sm-3 control-label">
                                <input type="file" id="importFile" name="textFile"
                                       accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
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

	$('#headendEquipment').on("click", function () {
	    $('#tab_frontDevice').bootstrapTable('refresh', {})
	})
	var count=0;
    $(function () {
        $(".selectpicker").selectpicker('refresh');
        //解决终端表格显示不正常的bug
        $("#tab_terminalDevice").bootstrapTable('refresh');
        $(".modal-dialog").draggable();
        // $('.modal').draggable();
    });
    var fileUrl = "";
    var flag = 0;  //标志新增或修改操作 0是新增 1是修改
    var changeflag=1;//标制修该按钮时 是否有过改动 0没有改动 1有改动
    var fCodeFlag='';
    var fnameFlage='';
    var columns_frontDevice = [
        [{
            checkbox: true,
        }, {
            field: 'fDeviceName',
            title: '设备名称',
            sortable: true,
            align: 'center',
            width: '10%'
        }, {
            field: 'fDeviceImage',
            title: '设备图片',
            align: 'center',
            width: '10%',
            formatter: function (data, row, index) {
                if (data != null && data != "") {
                    return [
                        '<img  src=' + data + ' style="width:100px;height:100px;"/>'
                    ]
                } else {
                    return [
                        '<img  src=' + "${ctx}/static/img/defaultPicture.png" + ' style="width:100px;height:100px;"/>'
                    ]
                }
            }
        }, {
            field: 'fDeviceResourceCode',
            title: '设备资源码',
            sortable: true,
            align: 'center',
            width: '15%'
        }, {
            field: 'fRealDeviceModel',
            title: '设备类型',
            align: 'center',
            sortable: true,
            width: '10%'
        }, {
            field: 'fRealArea',
            title: '所属区域',
            align: 'center',
            sortable: true,
            width: '13%',
            cellStyle: {
                css: {
                    "overflow": "hidden",
                    "text-overflow": "ellipsis",
                    "white-space": "nowrap"
                }
            }
        }, {
            field: '',
            title: '管理音柱数',
            align: 'center',
            width: '10%',
            formatter: function (data,row, index) {
                var fId = row.fLocation;
                $.ajaxSetup({async:false});
                $.getJSON("../resourceManage/emergencyDevice/count?fId=" + fId, function (result) {
                    count=result.data;
                });
                return count;
            }
        }, {
            field: 'fDeviceState',
            title: '设备状态',
            align: 'center',
            sortable: true,
            width: '5%',
            formatter: function (data, row, index) {
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
        }, {
            field: 'fUpdateTime',
            title: '操作日期',
            align: 'center',
            sortable: true,
            width: '15%',
            formatter: function (data, row, index) {
                if (data === null || data == "") {
                    return new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss');
                } else {
                    return new Date(data).format('yyyy-MM-dd HH:mm:ss');
                }
            },
        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .detail-btn': function (e, val, row) {
                    $.each(row, function (key, value) {
                        $("#" + key).text(value ? value : "");
                    })
                    $('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                    $('#fUpdateTime').text(row.fUpdateTime ? new Date(row.fUpdateTime).format('yyyy-MM-dd HH:mm:ss') : "");
                    $('#div_pid').attr("style", "display:none;");
                    $('#div_manufacturerInfo').attr("style", "display:none;");
                    $('#div_state').attr("style", "display:none;");
                    $('#div_fm').attr("style", "display:none;");
                    $('#infoModal').modal();
                }
            }, formatter: function () {
                return '<button class="btn btn-info btn-sm detail-btn">详情</button>';
            }
        }]];

    var columns_terminalDevice = [
        [{
            checkbox: true,
        }, {
            field: 'fDeviceName',
            title: '设备名称',
            sortable: true,
            align: 'center',
            width: '10%'
        }, {
            field: 'fDeviceImage',
            title: '设备图片',
            align: 'center',
            width: '10%',
            formatter: function (data, row, index) {
                if (data != null && data != "") {
                    return [
                        '<img  src=' + data + ' style="width:100px;height:100px;"/>'
                    ]
                } else {
                    return [
                        '<img  src=' + "${ctx}/static/img/defaultPicture.png" + ' style="width:100px;height:100px;"/>'
                    ]
                }

            }
        }, {
            field: 'fDeviceResourceCode',
            title: '设备资源码',
            sortable: true,
            align: 'center',
            width: '15%'
        }, {
            field: 'fRealDeviceModel',
            title: '设备类型',
            sortable: true,
            align: 'center',
            width: '10%'
        }, {
            field: 'fRealArea',
            title: '所属区域',
            sortable: true,
            align: 'center',
            width: '13%',
            cellStyle: {
                css: {
                    "overflow": "hidden",
                    "text-overflow": "ellipsis",
                    "white-space": "nowrap"
                }
            },

        }, {
            field: 'fRealFacture',
            title: '厂家信息',
            align: 'center',
            width: '13%'
        }, {
            field: 'fDeviceState',
            title: '设备状态',
            align: 'center',
            sortable: true,
            width: '5%',
            formatter: function (data, row, index) {
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
        }, {
            field: 'fUpdateTime',
            title: '操作时间',
            align: 'center',
            sortable: true,
            width: '15%',
            formatter: function (data, row, index) {
                if (data === null || data == "") {
                    return new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss');
                } else {
                    return new Date(data).format('yyyy-MM-dd HH:mm:ss');
                }
            },
        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .detail-btn': function (e, val, row) {
                    $.each(row, function (key, value) {
                        $("#" + key).text(value ? value : "");
                    })
                    $('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                    $('#fUpdateTime').text(row.fUpdateTime ? new Date(row.fUpdateTime).format('yyyy-MM-dd HH:mm:ss') : "");
                    $('#fEnableState').text((row.fEnableState == true) ? "启用" : "未启用");
                    $('#div_url').attr("style", "display:none;");
                    $('#div_mainter').attr("style", "display:none;");
                    $('#infoModal').modal();
                }
            }, formatter: function () {
                return '<button class="btn btn-info btn-sm detail-btn">详情</button>';
            }
        }]];
    
    var columns_transmitter = [
        [{
            checkbox: true,
        }, {
            field: 'transmitterId',
            title: '发射机编号',
            sortable: false,
            align: 'center',
            width: '10%'
        }, {
            field: 'transmitterName',
            title: '发射机名称',
            align: 'center',
            width: '10%',
        }, {
            field: 'adapterName',
            title: '绑定适配器',
            sortable: false,
            align: 'center',
            width: '15%'
        }, {
            field: 'region',
            title: '所属区域',
            sortable: false,
            align: 'center',
            width: '10%'
        }, {
            field: 'installArea',
            title: '安装地址',
            sortable: false,
            align: 'center',
            width: '13%',

        }, {
            field: 'physicalCode',
            title: '物理编码',
            align: 'center',
            width: '13%'
        }, {
            field: 'resourceCode',
            title: '',
            align: 'center',
            sortable: false,
            width: '5%',
        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .detail-btn': function (e, val, row) {

                	$('#transmitterId2').text(row.transmitterId);
                	$('#transmitterName2').text(row.transmitterName);
                	$('#adapterName2').text(row.adapterName);
                	$('#region2').text(row.region);
                	$('#installArea2').text(row.installArea);
                	$('#physicalCode2').text(row.physicalCode);
                	$('#resourceCode2').text(row.resourceCode);
                	$('#transmitterState2').text(row.transmitterState);
                	$('#transmitterOutputFrequency2').text(row.transmitterOutputFrequency);
                	$('#outputPower2').text(row.outputPower);
                	$('#equipmentTemperature2').text(row.equipmentTemperature);
                	$('#transmitterOperatingVoltage2').text(row.transmitterOperatingVoltage);
                	$('#transmitterOperatingCurrent2').text(row.transmitterOperatingCurrent);
                	$('#transmitterReflectionPower2').text(row.transmitterReflectionPower);
                	$('#leftChannelModulation2').text(row.leftChannelModulation);
                	$('#rightChannelModulation').text(row.rightChannelModulation);
                	$('#harmonicChannelModulation2').text(row.harmonicChannelModulation);
                	$('#differentialChannelModulation2').text(row.differentialChannelModulation);
                	$('#rfLockInState2').text(row.rfLockInState);
                	$('#pllLockInState2').text(row.pllLockInState);
                	$('#backTime2').text(row.backTime);
                    $('#infoModal_transmitter').modal();
                }
            }, formatter: function () {
                return '<button class="btn btn-info btn-sm detail-btn">详情</button>';
            }
        }]];

    $('#terminalDevice_modal').on('hidden.bs.modal', function () {
        document.getElementById("form_terminalDevice").reset();
        $('#terminalTitle').html('新增');
        $(".selectpicker").selectpicker('refresh');
        fnameFlage='';
        fCodeFlag='';
    });
    $('#frontDevice_modal').on('hidden.bs.modal', function () {
        $('#frontTitle').html('新增');
        document.getElementById("form_frontDevice").reset();
        $(".selectpicker").selectpicker('refresh');
        fnameFlage='';
        fCodeFlag='';
    });
//     $('#transmitterEquipment_modal').on('hidden.bs.modal', function () {
//         $('#transmitterTitle').html('新增');
//         document.getElementById("form_transmitter").reset();
//         $(".selectpicker").selectpicker('refresh');
//         fnameFlage='';
//         fCodeFlag='';
//     });
    
    
    $('#infoModal').on('hidden.bs.modal', function () {
        $('#div_url').attr("style", "display:block;");
        $('#div_mainter').attr("style", "display:block;");
        $('#div_pid').attr("style", "display:block;");
        $('#div_manufacturerInfo').attr("style", "display:block;");
        $('#div_protocolType').attr("style", "display:block;");
        $('#div_state').attr("style", "display:block;");
        $('#div_fm').attr("style", "display:block;");
        fnameFlage='';
        fCodeFlag='';
    });

    $(function () {
        $(".selectpicker").selectpicker('refresh');
        $('#tab_terminalDevice').bootstrapTable({
            url: "../resourceManage/emergencyDevice/getTerminalDeviceList",
            method: 'get',
            search: true, //是否显示表格搜索
            columns: columns_terminalDevice,
            classes: 'table-no-bordered',
            clickToSelect: true,
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: true, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    Number: params.pageNumber,//从数据库第几条记录开始
                    Size: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                if (result.status === 200) {
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },
        });

        $('#tab_frontDevice').bootstrapTable({
            url: "../resourceManage/emergencyDevice/getFrontDeviceList",
            method: 'get',
            search: true, //是否显示表格搜索
            columns: columns_frontDevice,
            classes: 'table-no-bordered',
            clickToSelect: true,
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: true, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    Number: params.pageNumber,//从数据库第几条记录开始
                    Size: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                if (result.status === 200) {
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },
        });
        
        //发射机(原先注释状态)
         /* $('#tab_transmitter').bootstrapTable({
            url: "${ctx}/monitor/transmitterEquipment/querytransmitterEquipment",
            method: 'get',
            search: true, //是否显示表格搜索
            columns: columns_transmitter,
            classes: 'table-no-bordered',
            clickToSelect: true,
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: true, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    Number: params.pageNumber,//从数据库第几条记录开始
                    Size: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                if (result.status === 200) {
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },
        }); */
    });


    $("#deleteFront").on("click", function () {
        var allSlectLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
        var ids = "";
        var count = 0;
        if (allSlectLineData.length == 0) {
            layer.msg('请先选择要删除的记录!', {icon: 2});
        } else {
            for (i = 0; i < allSlectLineData.length; i++) {
                ids += allSlectLineData[i].fId + ",";
                count = count + 1;
            }
            layer.confirm("确定要删除这" + count + "条记录？", {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
                , icon: 3
            }, function () {
                $.ajax({
                    data: {
                        ids: ids
                    },
                    type: 'post', // 提交方式 get/post
                    url: "../resourceManage/emergencyDevice/deleteFrontDevice.do", // 需要提交的 url
                    success: function (data) {
                        if (data.status === 200) {
                            $('#tab_frontDevice').bootstrapTable('refresh');
                            layer.msg(data.msg, {icon: 1});
                            $(table).bootstrapTable('refresh');
                        } else {
                            layer.msg(data.msg, {icon: 2});
                        }
                    }
                });
            }, function () {
                return;
            })
        }
    });

    $("#deleteTerminal").on("click", function () {
        var allSlectLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        var ids = "";
        var count = 0;
        if (allSlectLineData.length == 0) {
            layer.msg('请先选择要删除的记录!', {icon: 2});
        } else {
            for (i = 0; i < allSlectLineData.length; i++) {
                ids += allSlectLineData[i].fId + ",";
                count = count + 1;
            }
            layer.confirm("确定要删除这" + count + "条记录？", {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
                , icon: 3
            }, function () {
                $.ajax({
                    data: {
                        ids: ids
                    },
                    type: 'post', // 提交方式 get/post
                    url: "../resourceManage/emergencyDevice/deleteTerminalDevice.do", // 需要提交的 url
                    success: function (data) {
                        if (data.status === 200) {
                            $('#tab_terminalDevice').bootstrapTable('refresh');
                            layer.msg(data.msg, {icon: 1});
                        } else {
                            layer.msg(data.msg, {icon: 2});
                        }
                    }
                });
            }, function () {
                return;
            })
        }
    });
        
//     $("#delete_transmitter").on("click", function () {
//         var allSlectLineData = $("#tab_transmitter").bootstrapTable('getSelections');
//         var transmitterId = "";
//         var count = 0;
//         if (allSlectLineData.length == 0) {
//             layer.msg('请先选择要删除的记录!', {icon: 2});
//         } else {
//             for (i = 0; i < allSlectLineData.length; i++) {
//             	transmitterId += allSlectLineData[i].transmitterId ;
//                 count = count + 1;
//             }
//             layer.confirm("确定要删除这" + count + "条记录？", {
//                 title: ['操作提示'],
//                 btn: ['确定', '取消'] //按钮
//                 , icon: 3
//             }, function () {
//                 $.ajax({
//                     data: {
//                     	"transmitterId": transmitterId,
//                     },
//                     type: 'post', // 提交方式 get/post
//                     url: "${ctx}/resourceManage/emergencyDevice/deleteTransmitterInfo", // 需要提交的 url
//                     success: function (data) {
//                         if (data != 0) {
//                             $('#tab_transmitter').bootstrapTable('refresh');
//                             layer.msg("删除成功", {icon: 1});
//                         } else {
//                             layer.msg("删除失败", {icon: 2});
//                         }
//                     }
//                 });
//             }, function () {
//                 return;
//             })
//         }
//     });

    //清除空格
    function Trim(str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }

    $("#update_frontDevice").on("click", function () {
        flag = 1;
        var SlectLineData = $("#tab_frontDevice").bootstrapTable('getSelections');
        if (SlectLineData.length > 1) {
            layer.msg('一次只能选择一项进行修改!', {icon: 2});
            return false;
        } else if (SlectLineData.length <= 0) {
            layer.msg('请先选择要修改的记录!', {icon: 2});
            return false;
        } else {
            $.each(SlectLineData[0], function (key, value) {
                if (key != 'fDeviceImage') {
                    $("#frontDevice_modal [name='" + key + "']").val(value);
                } else {
                    if (value != null && value != "") {
                        document.getElementById('image1').getElementsByTagName('img')[0].src = SlectLineData[0].fDeviceImage;
                    } else {
                        document.getElementById('image1').getElementsByTagName('img')[0].src = "/static/img/defaultPicture.png";
                    }
                }
            });
            var regionId = SlectLineData[0].fLocation;
            if (regionId) {
                var checkNode = treeObj1.getNodeByParam("id", regionId);
                treeObj1.selectNode(checkNode,true);
                $.ajax({
                    url: "../resourceManage/emergencyDevice/selectNumber?fId=" +regionId,
                    type: "get",
                    async: false,
                    success: function (result) {
                        $('#fRespectiveRegion1').attr("number", (result.data).fCode);
                    }
                });
                $('#fRespectiveRegion1').attr("number");
                if (checkNode) {
                    $('#selectRegion1').val(checkNode.name);
                }
            }
            var str = SlectLineData[0].fProtocolType;
            if (str != null && str != "") {
                var arr = str.split(',');
                $('#protocol').selectpicker('val', arr);
            }
            fCodeFlag=SlectLineData[0].fDeviceResourceCode;
            fnameFlage=SlectLineData[0].fDeviceName;
            $('#frontTitle').html('修改');
            $('#frontDevice_modal').modal();
        }
    })

    $("#update_terminalDevice").on("click", function () {
        var SlectLineData = $("#tab_terminalDevice").bootstrapTable('getSelections');
        if (SlectLineData.length > 1) {
            layer.msg('一次只能选择一项进行修改!', {icon: 2});
            return false;
        } else if (SlectLineData.length <= 0) {
            layer.msg('请先选择要修改的记录!', {icon: 2});
            return false;
        } else {
            $.each(SlectLineData[0], function (key, value) {
                if (key != 'fDeviceImage') {
                    $("#terminalDevice_modal [name='" + key + "']").val(value);
                    if (key == "fEnableState") {
                        if (value == true) {
                            $("#terminalDevice_modal [name='" + key + "']").val(1);
                        } else {
                            $("#terminalDevice_modal [name='" + key + "']").val(0);
                        }
                    }
                } else {
                    if (value != null && value != "") {
                        document.getElementById('image2').getElementsByTagName('img')[0].src = SlectLineData[0].fDeviceImage;
                    } else {
                        document.getElementById('image2').getElementsByTagName('img')[0].src = "/static/img/defaultPicture.png";
                    }

                }
            })
            var regionId = SlectLineData[0].fLocation;
            if (regionId) {
                var checkNode = treeObj.getNodeByParam("id", regionId);
                treeObj.selectNode(checkNode,true);
                $.ajax({
                    url: "../resourceManage/emergencyDevice/selectNumber?fId=" +regionId,
                    type: "get",
                    async: false,
                    success: function (result) {
                        $('#fRespectiveRegion').attr("number", (result.data).fCode);
                    }
                });
                $('#fRespectiveRegion').attr("number");
                if (checkNode) {
                    $('#selectRegion').val(checkNode.name);
                }
            }
            var str = SlectLineData[0].fProtocolType;
            if (str != null && str != "") {
                var arr = str.split(',');
                $('#protocol2').selectpicker('val', arr);
            }

            fCodeFlag=SlectLineData[0].fDeviceResourceCode;
            fnameFlage=SlectLineData[0].fDeviceName;
            $('#terminalTitle').html('修改');
            $('#terminalDevice_modal').modal();
            flag = 1;
        }
    })
    
//     $("#update_transmitter").on("click", function () {
//         var SelectLineData = $("#tab_transmitter").bootstrapTable('getSelections');
//         if (SelectLineData.length > 1) {
//             layer.msg('一次只能选择一项进行修改!', {icon: 2});
//             return false;
//         } else if (SelectLineData.length <= 0) {
//             layer.msg('请先选择要修改的记录!', {icon: 2});
//             return false;
//         } else {
//             $.each(SelectLineData[0], function (key, value) {
//                 $("#transmitterEquipment_modal [name='" + key + "']").val(value);          
//             })
//             var regionId = SelectLineData[0].fLocation;
//             if (regionId) {
//                 var checkNode = treeObj.getNodeByParam("id", regionId);
//                 treeObj.selectNode(checkNode,true);
//                 $.ajax({
//                     url: "../resourceManage/emergencyDevice/selectNumber?Id=" +regionId,
//                     type: "get",
//                     async: false,
//                     success: function (result) {
//                         $('#region').attr("number", (result.data).fCode);
//                     }
//                 });
//                 $('#region').attr("number");
//                 if (checkNode) {
//                     $('#selectRegion').val(checkNode.name);
//                 }
//             }

//             $('#transmitterTitle').html('修改');
//             //document.getElementById("transmitterId").readOnly=true;
//             $('#transmitterEquipment_modal').modal();
//             flag = 1;
//         }
//     })
    
    $("#add_frontDevice").click(function () {
        flag = 0;
    });
    
//     $("#add_transmitter").click(function () {
//     	document.getElementById("transmitterId").readOnly=false;
//         flag = 0;
//     });    
    
    $("#frontExport").on("click", function () {
        layer.confirm('确认要导出所有记录吗？', {icon: 3, title: '操作提示'}, function (index) {
            window.location.href = '../resourceManage/emergencyDevice/exportFrontExcel';
            layer.close(index);
        });
    })

    $("#terminalExport").on("click", function () {
        layer.confirm('确认要导出所有记录吗？', {icon: 3, title: '操作提示'}, function (index) {
            window.location.href = '../resourceManage/emergencyDevice/exportTerminalExcel';
            layer.close(index);
        });
    })

    
//     $('#form_transmitter').on('valid.form', function (e, form) {
//         if (flag === 0) {
//             //var a = $('#form_transmitter').serialize();
//             $.ajax({
//                 url: "${ctx}/resourceManage/emergencyDevice/insertTransmitterInfo",
//                 type: 'post',
//                 //data: $('#form_transmitter').serialize(),
//                 data:{
//                 	"transmitterId":$("#transmitterId").val(),
//                 	"transmitterName":$("#transmitterName").val(),
//                 	"adapterId":$("#adapterSelect").val(),
//                 	"adapterName":$("#adapterSelect").find("option:selected").text(),
//                 	"region":$("#selectRegion3").val(),
//                 	"installArea":$("#transmitterInstallArea").val(),
//                 	"physicalCode":$("#transmitterPhysicalCode").val(),
//                 	"resourceCode":$("#transmitterResourceCode").val(),                	
//                 },
//                 success: function (data) {
//                     if (data != 200) {
//                         $("#transmitterEquipment_modal").modal('hide');
//                         $('#tab_transmitter').bootstrapTable('refresh');
//                         layer.msg("新增成功", {icon: 1});
//                     } else {
//                         layer.msg("新增失败", {icon: 2});
//                     }
//                 }
//             });
//         } else {
//             flag = 0;
//             $.ajax({
//                 data: $("#form_transmitter").serialize(),
//                 type: 'post',
//                 url: "${ctx}/resourceManage/emergencyDevice/updateTransmitterInfo",
//                 data:{
//                 	"transmitterId":$("#transmitterId").val(),
//                 	"transmitterName":$("#transmitterName").val(),
//                 	"adapterId":$("#adapterSelect").val(),
//                 	"adapterName":$("#adapterSelect").find("option:selected").text(),
//                 	"region":$("#selectRegion3").val(),
//                 	"installArea":$("#transmitterInstallArea").val(),
//                 	"physicalCode":$("#transmitterPhysicalCode").val(),
//                 	"resourceCode":$("#transmitterResourceCode").val(),                	
//                 },
//                 success: function (data) {
//                     if (data!= 0) {
//                         $("#transmitterEquipment_modal").modal('hide');
//                         $('#tab_transmitter').bootstrapTable('refresh');
//                         layer.msg("更新成功", {icon: 1});
//                     } else {
//                         layer.msg("更新失败", {icon: 2});
//                     }
//                 }
//             });
//         }
//     });
    
    
    
    $('#form_frontDevice').on('valid.form', function (e, form) {
        $("#front_fDeviceImage").val(fileUrl);
        if (flag === 0) {
            $('#fId').val('');
            $.ajax({
                url: "../resourceManage/emergencyDevice/insertOrUpdateFrontDevice.do",
                type: 'post',
                data: $('#form_frontDevice').serialize(),
                success: function (data) {
                    if (data.status === 200) {
                        $("#frontDevice_modal").modal('hide');
                        $('#tab_frontDevice').bootstrapTable('refresh');
                        layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        } else {
            flag = 0;
            $.ajax({
                data: $("#form_frontDevice").serialize(),
                type: 'post',
                url: "../resourceManage/emergencyDevice/insertOrUpdateFrontDevice.do",
                success: function (data) {
                    if (data.status === 200) {
                        $("#frontDevice_modal").modal('hide');
                        $('#tab_frontDevice').bootstrapTable('refresh');
                        layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        }

    });


    $('#form_terminalDevice').on('valid.form', function (e, form) {
        $("#terminal_fDeviceImage").val(fileUrl);
        if (flag === 0) {
            $('#fId2').val('');
            var a = $('#form_terminalDevice').serialize();
            $.ajax({
                url: "../resourceManage/emergencyDevice/insertOrUpdateTerminalDevice.do",
                type: 'post',
                data: $('#form_terminalDevice').serialize(),
                success: function (data) {
                    if (data.status === 200) {
                        $("#terminalDevice_modal").modal('hide');
                        $('#tab_terminalDevice').bootstrapTable('refresh');
                        layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        } else {
            flag = 0;
            $.ajax({
                data: $("#form_terminalDevice").serialize(),
                type: 'post',
                url: "../resourceManage/emergencyDevice/insertOrUpdateTerminalDevice.do",
                success: function (data) {
                    if (data.status === 200) {
                        $("#terminalDevice_modal").modal('hide');
                        $('#tab_terminalDevice').bootstrapTable('refresh');
                        layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        }

    });

    //上传图片
    document.getElementById('file1').onchange = function () {
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function () {
            document.getElementById('image1').getElementsByTagName('img')[0].src = fr.result;
        };
        fr.readAsDataURL(imgFile);

        var form = new FormData();
        form.append("file", document.getElementById("file1").files[0]);
        $.ajax({
            url: "${ctx}/common/upload?type=" + 1,
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data.status == 200) {
                    fileUrl = data.msg;
                }
            },
            error: function (e) {
                layer.msg("上传失败");
                layer.closeAll('loading');
            }
        });
    };

    //上传图片
    document.getElementById('file2').onchange = function () {
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function () {
            document.getElementById('image2').getElementsByTagName('img')[0].src = fr.result;
        };
        fr.readAsDataURL(imgFile);

        var form = new FormData();
        form.append("file", document.getElementById("file2").files[0]);
        $.ajax({
            url: "${ctx}/common/upload?type=" + 1,
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data.status == 200) {
                    fileUrl = data.msg;
                }
            },
            error: function (e) {
                layer.msg("上传失败");
                layer.closeAll('loading');
            }
        });
    };

    function fileNameTip() {
        var fileName = $("#importForm").find("input[name=textFile]").val();
        var e = $("#fileInput");
        layer.tips('文件名：' + fileName, e, {
            tips: [1, '#5bc0de'],
            tipsMore: true,
            time: 5000
        });
    }

    $("#import_confirm").on("click", function () {
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
        formData.append("textFile", document.getElementById("importFile").files[0]);
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: formData,
            dataType: "JSON",
            mimeType: "multipart/form-data",
            contentType: false,
            cache: false,
            processData: false,
            success: function (data) {
                if (data.status === 200) {
                    $('#tab_terminalDevice').bootstrapTable('refresh');
                    layer.msg(data.msg, {icon: 1});
                } else {
                    $('#tab_terminalDevice').bootstrapTable('refresh');
                    layer.msg(data.msg, {icon: 2});
                }
            }
        });
    })


    var treeSetting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            view: {
                nameIsHTML: false,
                showTitle: false,
                showIcon: false,
                dblClickExpand: false
            },
            check: {
                enable: true,
                chkStyle: "radio",
                radioType: "all"
            },
            callback: {
                onCheck: function (event, treeId, treeNode) {
                    $('#fRespectiveRegion').val(treeNode.id);
                    $('#selectRegion').val(treeNode.name);
                    $.ajax({
                        url: "../resourceManage/emergencyDevice/selectNumber?fId=" + treeNode.id,
                        type: "get",
                        async: false,
                        success: function (result) {
                            $('#fRespectiveRegion').attr("number", (result.data).fCode);
                        }
                    });
                    Resourcecoding("#terminalDevice_modal");
                    hideMenu();
                },
                onClick: function (event, treeId, treeNode) {
                    $('#fRespectiveRegion').val(treeNode.id);
                    $('#selectRegion').val(treeNode.name);
                    var zTree = $.fn.zTree.getZTreeObj(treeId);
                    zTree.checkNode(treeNode, !treeNode.checked, null, true);
                    hideMenu();
                }
            }
        },
        treeId = 'ztree',
        regionMap = ${regionMap};
    var nodes = ${regionJson};
    var treeObj = $.fn.zTree.init($("#" + treeId), treeSetting, nodes);
    $.each(treeObj.getNodes(), function (index, node) {
        if (node.level === 0) {
            treeObj.expandNode(node, true);
        }
    });

    function hideMenu() {
        $("#menuContent").fadeOut("fast");
    }

    //选择区域
    $('#selectRegion').click(function () {
        //alert("111")
        var id = $('#fRespectiveRegion').val();
        if (id) {
            var checkNode = treeObj.getNodeByParam("id", id);
            if (checkNode) {
                treeObj.checkNode(checkNode, true);
            }
        }
        $("#menuContent").css({width: $(this).outerWidth() + 'px'}).slideDown("fast");
        $("body").bind("mousedown", function (event) {
            if (!(event.target.id === "selectMethod" || event.target.id === "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
                hideMenu();
            }
        });
    });

    var treeSetting1 = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            view: {
                nameIsHTML: false,
                showTitle: false,
                showIcon: false,
                dblClickExpand: false
            },
            check: {
                enable: true,
                chkStyle: "radio",
                radioType: "all"
            },
            callback: {
                onCheck: function (event, treeId, treeNode) {
                    $('#fRespectiveRegion1').val(treeNode.id);
                    $('#selectRegion1').val(treeNode.name);
                    $.ajax({
                        url: "../resourceManage/emergencyDevice/selectNumber?fId=" + treeNode.id,
                        type: "get",
                        async: false,
                        success: function (result) {
                            $('#fRespectiveRegion1').attr("number", (result.data).fCode);
                        }
                    });
                    Resourcecoding("#frontDevice_modal");
                    hideMenu1();
                },
                onClick: function (event, treeId, treeNode) {
                    $('#fRespectiveRegion1').val(treeNode.id);
                    $('#selectRegion1').val(treeNode.name);
                    var zTree = $.fn.zTree.getZTreeObj(treeId);
                    zTree.checkNode(treeNode, !treeNode.checked, null, true);
                    hideMenu1();
                }
            }
        },
        treeId1 = 'ztree1';
        
        
        	 var treeSetting3 = {
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                view: {
                    nameIsHTML: false,
                    showTitle: false,
                    showIcon: false,
                    dblClickExpand: false
                },
                check: {
                    enable: true,
                    chkStyle: "radio",
                    radioType: "all"
                },
                callback: {
                    onCheck: function (event, treeId, treeNode) {
                        $('#region').val(treeNode.id);
                        $('#selectRegion3').val(treeNode.name);
                        $.ajax({
                            url: "../resourceManage/emergencyDevice/selectNumber?fId=" + treeNode.id,
                            type: "get",
                            async: false,
                            success: function (result) {
                                $('#region').attr("number", (result.data).fCode);//fRespectiveRegion3
                            }
                        });
                        Resourcecoding("#transmitterEquipment_modal");
                        hideMenu3();
                    },
                    onClick: function (event, treeId, treeNode) {
                        $('#region').val(treeNode.id);
                        $('#selectRegion3').val(treeNode.name);
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        zTree.checkNode(treeNode, !treeNode.checked, null, true);
                        hideMenu1();
                    }
                }
            },
            treeId3 = 'ztree3';

    var treeObj1 = $.fn.zTree.init($("#" + treeId1), treeSetting1, nodes);
    $.each(treeObj1.getNodes(), function (index, node) {
        treeObj1.expandNode(node, true);
    });
    
    var treeObj3 = $.fn.zTree.init($("#" + treeId3), treeSetting3, nodes);
    $.each(treeObj3.getNodes(), function (index, node) {
        treeObj3.expandNode(node, true);
    });

    function hideMenu1() {
        $("#menuContent1").fadeOut("fast");
    }
    function hideMenu3() {
        $("#menuContent3").fadeOut("fast");
    }

    //选择区域
    $('#selectRegion1').click(function () {
        var id = $('#fRespectiveRegion1').val();
        if (id) {
            var checkNode = treeObj1.getNodeByParam("id", id);
            if (checkNode) {
                treeObj1.checkNode(checkNode, true);
            }
        }
        $("#menuContent1").css({width: $(this).outerWidth() + 'px'}).slideDown("fast");
        $("body").bind("mousedown", function (event) {
            if (!(event.target.id === "selectMethod" || event.target.id === "menuContent" || $(event.target).parents("#menuContent1").length > 0)) {
                hideMenu1();
            }
        });
    });
    
    $('#selectRegion3').click(function () {
        var id = $('#region').val();//fRespectiveRegion3
        if (id) {
            var checkNode = treeObj1.getNodeByParam("id", id);
            if (checkNode) {
                treeObj1.checkNode(checkNode, true);
            }
        }
        $("#menuContent3").css({width: $(this).outerWidth() + 'px'}).slideDown("fast");
        $("body").bind("mousedown", function (event) {
            if (!(event.target.id === "selectMethod" || event.target.id === "menuContent" || $(event.target).parents("#menuContent3").length > 0)) {
                hideMenu1();
            }
        });
    });
    
    $('.form_device').validator({
        dataFilter: function (data) {
            let code=$(".form_device input[name='fDeviceResourceCode']").val();
            let name=$(".form_device input[name='fDeviceName']").val();
            if(flag==1&&code==fCodeFlag){
                return {"ok": ""};
            }else {
                if (data.status === 200) {
                    return {"ok": data.msg};
                } else {
                    return data.msg;
                }
            }
        },
        fields: {
          //  fDeviceName: "required;length(~10);remote[${ctx}/resourceManage/receiveCertificate/isOnlyName]",
            fDeviceResourceCode:"required;remote[${ctx}/resourceManage/receiveCertificate/isOnlyCode]"
        }
    });
$('.form_device').validator({  });
    $('body').on('hidden.bs.modal', '.modal', function () {
        $(".modal-dialog").css({"top": "0", "bottom": "0", "left": "0", "right": "0"})
    });
    $("#frontDevice_modal input[name='fNumber']").change(function () {
        Resourcecoding("#frontDevice_modal");
    });

    $("#frontDevice_modal select[name='fDeviceModel']").change(function () {
        Resourcecoding("#frontDevice_modal");
    });
    $("#terminalDevice_modal input[name='fNumber']").change(function () {
        Resourcecoding("#terminalDevice_modal");
    });

    $("#terminalDevice_modal select[name='fDeviceModel']").change(function () {
        Resourcecoding("#terminalDevice_modal");
    });

    $(".nav.nav-tabs").find("li").eq(1).click(function () {
        $("#tab_terminalDevice").bootstrapTable('refresh');
    });

    /**
     *
     * 合成资源编码方法
     * @param e 模态框标识 id or class
     * @constructor
     */
    function Resourcecoding(e) {
        let $number = $(e + " input[name='fNumber']").val();//$number != "" && (if语句)
        let $reTypeNumber = $(e + " input[name='reTypeNumber']").val();
        let $reSubtypeNumber = $(e + " input[name='reSubtypeNumber']").val();
        let $fDeviceModel = $(e + " select[name='fDeviceModel']").find("option:selected").attr("number");
        let $fResourceLevel = $(e + " select[name='fResourceLevel']").find("option:selected").attr("number");
        let $fResourceSubtypes = $(e + " select[name='fResourceSubtypes']").find("option:selected").attr("number");
        let $region = $(e + " input[name='fLocation']").attr("number");
        if ($reTypeNumber != "" && $reSubtypeNumber != "" && $fDeviceModel != "" && $fResourceLevel != "" && $fResourceSubtypes != "" && $region != undefined) {
            // alert($fDeviceModel+$region+$number);
            /* $(e + " input[name='fDeviceResourceCode']").val($fDeviceModel + $region + $number);
            $(e + " input[name='fDeviceResourceCode']").attr("value", $fDeviceModel + $region + $number); */
            $(e + " input[name='fDeviceResourceCode']").val($fResourceLevel + $region + $fDeviceModel + $reTypeNumber + $fResourceSubtypes + $reSubtypeNumber);
            $(e + " input[name='fDeviceResourceCode']").attr("value", $fResourceLevel + $region + $fDeviceModel + $reTypeNumber + $fResourceSubtypes + $reSubtypeNumber);
            //alert($(e+" input[name='fDeviceResourceCode']").val())
            let code=$(e + " input[name='fDeviceResourceCode']").val();
            let name=$(e + " input[name='fDeviceName']").val();
           // alert(code);
            if(flag==1&&code==fCodeFlag){
            }else {
                //alert("222")
                $.ajax({
                    url:"${ctx}/resourceManage/receiveCertificate/isOnlyCode",
                    data:{"fDeviceResourceCode": $(e + " input[name='fDeviceResourceCode']").attr("value")},
                    async:false,
                    success:function (result) {
                        if(result.status==400){
                            layer.msg("设备资源编码重复，请重新选择");
                        }else{
                            //alert("222");
                        }
                    }
                })
            }

        } else {
            $(e + " input[name='fDeviceResourceCode']").val("");
            $(e + " input[name='fDeviceResourceCode']").attr("value", "");
        }
    }
</script>
</body>
</html>