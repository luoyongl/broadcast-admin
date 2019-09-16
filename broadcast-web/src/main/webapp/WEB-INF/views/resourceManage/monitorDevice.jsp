<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData,cn.wtu.broadcast.config.SystemConfig" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    DictionaryConfig.getMap(request);
    request.setAttribute("regionJson", RegionData.getZTreeListJson());
    request.setAttribute("regionMap", RegionData.getNameMapJson());
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>监控设备</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .select-tree {
            display: none;
            position: absolute;
            padding: 5px 0;
            z-index: 999;
            border: 1px solid #d2d2d2;
            max-height: 300px;
            overflow-y: auto;
            background-color: #fff;
            border-radius: 2px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
            box-sizing: border-box;
            top: auto;
            bottom: 100%;
            margin-bottom: 4px;
        }

        .ztree li a.curSelectedNode {
            background-color: transparent;
            border: none;
        }

        .modal-dialog{
            width: 70%;
            height: 80%;
            overflow-y: scroll;
        }
        table{
            table-layout:fixed;
        }
        table tbody tr td{
            overflow: hidden;
            text-overflow:ellipsis;
            white-space: nowrap;
        }
        .btn.dropdown-toggle.btn-default {
            background: none;
            color: #ffffff;
        }
    </style>
</head>

<body>
<h4><b>当前位置:资源管理>>监控设备</b></h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li class="selected_tab"><a>监控服务器</a></li>
        <li><a>摄像头信息</a></li>
        <span class="driverspan"></span>
    </ul>
</div>


<div class="tab_modal show">
    <div class="content_table">
    <div class="handle">
        <button class="btn btn-info" data-toggle="modal" id="add_camera">新增</button>
        <button class="btn btn-info" data-toggle="modal" id="update_camera">修改</button>
        <button class="btn btn-danger" data-toggle="modal" id="delete_camera">删除</button>
        <button class="btn btn-info" data-toggle="modal" id="exportServer">导出</button>
    </div>
    <table id="tab_monitorDevice_camera" data-height="600" class="table table-hover"> </table>
    </div>
</div>
<div class="tab_modal">
    <div class="content_table">
    <div class="handle ">
        <button class="btn btn-info" data-toggle="modal" id="add_server">新增</button>
        <button class="btn btn-info" data-toggle="modal" id="update_server">修改</button>
        <button class="btn btn-danger" id="delete_server">删除</button>
        <button class="btn btn-info" data-toggle="modal" id="exportCamera">导出</button>
    </div>
    <table id="tab_monitorDevice_server" data-height="600" class="table table-hover"> </table>
    </div>
</div>


<!-- 服务详情模态框（Modal） -->
<div class="modal fade" id="xiangqing_server_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 60%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">详情</h4>
            </div>
            <div class="modal-body col-sm-12" style="padding: 20px">
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备编号:</label>
                    <div class="col-sm-8">
                        <span  name="fNumber" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">显示级别:</label>
                    <div class="col-sm-8">
                        <span  name="fDisplayLevel" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备名称:</label>
                    <div class="col-sm-8">
                        <span  name="fDeviceName" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备IP:</label>
                    <div class="col-sm-8">
                        <span  name="fDeviceIp" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">控制端口:</label>
                    <div class="col-sm-8">
                        <span  name="fDevicePort" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">登录名:</label>
                    <div class="col-sm-8">
                        <span  name="fLoginName" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">登录密码:</label>
                    <div class="col-sm-8">
                        <span  name="fLoginPassword" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">设备类型:</label>
                    <div class="col-sm-8">
                        <span  name="fDeviceModel" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">物理码:</label>
                    <div class="col-sm-8">
                        <span  name="fPhysicalCode" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">nvr绑定:</label>
                    <div class="col-sm-8">
                        <span  name="fNvr" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">安装地址:</label>
                    <div class="col-sm-8">
                        <span  name="fInstallAddress" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">经度:</label>
                    <div class="col-sm-8">
                        <span  name="fLongitude" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">纬度:</label>
                    <div class="col-sm-8">
                        <span  name="fDimension" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">通道型号:</label>
                    <div class="col-sm-8">
                        <span  name="fChannelModel" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">创建者:</label>
                    <div class="col-sm-8">
                        <span  name="fCreatorId" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">创建时间:</label>
                    <div class="col-sm-8">
                        <span  name="fCreateTime" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">操作者:</label>
                    <div class="col-sm-8">
                        <span  name="fOperatorId" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">修改时间:</label>
                    <div class="col-sm-8">
                        <span  name="fUpdateTime" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">所属区域:</label>
                    <div class="col-sm-8">
                        <span  name="fLocation" ></span>
                    </div>
                </div>
                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-8">
                        <span  name="fRemark" ></span>
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

<!-- 摄像头详情模态框（Modal） -->
<div class="modal fade" id="xiangqing_camera_modal" tabindex="-1" role="dialog"
aria-hidden="true">
<div class="modal-dialog" style="width: 60%">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
                    aria-hidden="true">&times;</button>
            <h4 class="modal-title">详情</h4>
        </div>
        <div class="modal-body" style="padding: 20px">
            <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">设备编号:</label>
            <div class="col-sm-8">
                <span  name="fNumber" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">显示级别:</label>
            <div class="col-sm-8">
                <span  name="fDisplayLevel" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">设备名称:</label>
            <div class="col-sm-8">
                <span  id="#fPassType" name="fDeviceName" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">设备IP:</label>
            <div class="col-sm-8">
                <span  name="fDeviceIp" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">控制端口:</label>
            <div class="col-sm-8">
                <span  name="fDevicePort" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">设备类型:</label>
            <div class="col-sm-8">
                <span  name="fDeviceModel" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">登录名:</label>
            <div class="col-sm-8">
                <span  name="fLoginName" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">登录密码:</label>
            <div class="col-sm-8">
                <span  name="fLoginPassword" ></span>
            </div>
        </div>

        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">物理码:</label>
            <div class="col-sm-8">
                <span  name="fPhysicalCode" ></span>
            </div>
        </div>


        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">安装地址:</label>
            <div class="col-sm-8">
                <span  name="fInstallAddress" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">经度:</label>
            <div class="col-sm-8">
                <span  name="fLongitude" ></span>
            </div>
        </div>
        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">纬度:</label>
            <div class="col-sm-8">
                <span  name="fDimension" ></span>
            </div>
        </div>


        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">创建者:</label>
            <div class="col-sm-8">
                <span  name="fCreatorId" ></span>
            </div>
        </div>

        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">创建时间:</label>
            <div class="col-sm-8">
                <span  name="fCreateTime" ></span>
            </div>
        </div>

        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">操作者:</label>
            <div class="col-sm-8">
                <span  name="fOperatorId" ></span>
            </div>
        </div>

        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">修改时间:</label>
            <div class="col-sm-8">
                <span  name="fUpdateTime" ></span>
            </div>
        </div>

        <div class="form-group col-sm-6">
            <label class="col-sm-4 control-label">所属区域:</label>
            <div class="col-sm-8">
                <span  name="fLocation" ></span>
            </div>
        </div>
        <div class="form-group col-sm-12">
            <label class="col-sm-2 control-label">备注:</label>
            <div class="col-sm-8">
                <span  name="fRemark" ></span>
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
<!-- 监控摄像头模态框（Modal） -->
<div class="modal fade" id="camera_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="camera_title">新增</h4>
            </div>

            <form id="camera_form">
            <div class="modal-body col-sm-12" style="padding: 20px">
                <div class="modal-body-left col-sm-9">
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备编号</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="camera_fNumber" name="fNumber"
                               onblur="fNumberChange1()" onkeyup="value=value.replace(/[\W]/g,'')" maxlength="10">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">显示级别</label>
                    <div class="col-sm-7">
                        <input class="form-control" name="fDisplayLevel" type="number" step="1" min="1" max="9"
                               oninput="if(value.length>1)value=value.slice(0,1)"/>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备名称</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fDeviceName" maxlength="6">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备IP</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fDeviceIp" maxlength="20">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">控制端口</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fDevicePort" maxlength="10">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">登录名</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fLoginName" maxlength="20">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">登录密码</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fLoginPassword" maxlength="20">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备类型</label>
                    <div class="col-sm-7">
                       <select class="form-control" name="fDeviceModel">
                           <c:forEach items="${deviceModelList}" var="deviceModel">
                               <option value="${deviceModel.fId}">${deviceModel.fDictionaryContent}</option>
                           </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">物理码</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fPhysicalCode" maxlength="15">
                    </div>
                </div>


                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">安装地址</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fInstallAddress" maxlength="20" >
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label" >经度</label>
                    <div class="col-sm-7">
                        <input type="text" id="camera_fLongitude"  class="form-control" name="fLongitude" maxlength="20" onblur="checkLong1()">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">纬度</label>
                    <div class="col-sm-7">
                        <input type="text" id="camera_fDimension" class="form-control " name="fDimension" onblur="checkLat1()">
                    </div>
                </div>
                   <div class="form-group col-sm-6">
                        <label class="col-sm-5 control-label">所属区域</label>
                        <div class="col-sm-7">
                            <input type="hidden" name="fLocation" id="fRespectiveRegion">
                            <input autocomplete="off" class="form-control" type="text" id="selectRegion" readonly
                                   required>
                            <div id="menuContent" class="select-tree">
                                <ul id="ztree" class="ztree"></ul>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-5 control-label"></label>
                        <div class="col-sm-7"></div>
                    </div>
                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label" style="margin-right: 3.5%">备注</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" style="height: 80px;color: black;resize:none;" name="fRemark" maxlength="150"></textarea>
                    </div>
                </div>
            </div>
                <div class="modal-body-right col-sm-3" style="display: flex;justify-content:center;align-items:center;">
                    <label id="image1" for="file1" style="padding: 100% 0;"><img src="${ctx}/static/img/picture/addPhoto.jpg" style="width: 100px;height: 100px;"></label>
                    <input type="file" id="file1" name="fDeviceImage" style="display: none" accept="image/*" />
                    <input style="display: none" name="fDeviceImage" id="camera_fDeviceImage">

                </div>
            </div>

       <%-- <div class="form-group col-sm-12" align="center">

        </div>--%>


            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="camera_submit" >确定</button>
                <button class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
            </form>
        </div>
    </div>
    <!-- /.modal-content -->
</div>


<!-- 监控服务模态框（Modal） -->
<div class="modal fade" id="server_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="server_title">新增</h4>
            </div>

            <form id="server_form">
            <div class="modal-body col-sm-12" style="padding: 20px">
                <div class="modal-body-left col-sm-9">
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备编号</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="server_fNumber" name="fNumber" onblur="fNumberChange2()"
                               onkeyup="value=value.replace(/[\W]/g,'')" maxlength="10">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备名称</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fDeviceName" maxlength="6">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备IP</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fDeviceIp" maxlength="20">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备端口</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fDevicePort" maxlength="10">
                    </div>
                </div>
				
				<div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">登录名</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fLoginName" maxlength="20">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">登录密码</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fLoginPassword" maxlength="20">
                    </div>
                </div>
                
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">设备类型</label>
                    <div class="col-sm-7">
                        <select class="form-control" name="fDeviceModel">
                            <c:forEach items="${deviceModelList}" var="deviceModel">
                                <option value="${deviceModel.fId}">${deviceModel.fDictionaryContent}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">物理码</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fPhysicalCode" maxlength="15">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">nvr绑定</label>
                    <div class="col-sm-7">
                        <select class="form-control" name="fNvr">
                            <option value="1">隆林县机房NVR</option>
                            <option value="2">NVR-村摄像头管理01</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">安装地址</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " name="fInstallAddress" maxlength="20">
                    </div>
                </div>


                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">经度</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " id="server_fLongitude" name="fLongitude" onblur="checkLong2()">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label" >纬度</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control " id="server_fDimension" name="fDimension" onblur="checkLat2()">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">显示级别</label>
                    <div class="col-sm-7">
                        <input class="form-control" name="fDisplayLevel" type="number" step="1" min="1" max="9"
                               oninput="if(value.length>1)value=value.slice(0,1)"/>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-5 control-label">通道型号</label>
                    <div class="col-sm-7">
                        <select class="form-control" name="fChannelModel">
                            <c:forEach items="${channelModelList}" var="channelModel">
                                <option value="${channelModel.fId}">${channelModel.fDictionaryContent}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                </br>

                   <div class="form-group col-sm-6">
                        <label class="col-sm-5 control-label">所属区域</label>
                        <div class="col-sm-7">
                            <input type="hidden" name="fLocation" id="fRespectiveRegion1">
                            <input autocomplete="off" class="form-control" type="text" id="selectRegion1" readonly
                                   required>
                            <div id="menuContent1" class="select-tree">
                                <ul id="ztree1" class="ztree"></ul>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-5 control-label"></label>
                        <div class="col-sm-7"></div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2 control-label" style="margin-right: 3.5%">备注</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" style="height: 80px;color: black;resize:none;" name="fRemark" maxlength="150"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-body-right col-sm-3" style="display: flex;justify-content:center;align-items:center;">
                    <label id="image2" for="file2" style="padding: 100% 0;"><img src="${ctx}/static/img/picture/addPhoto.jpg" style="width: 100px;height: 100px;"></label>
                    <input type="file" id="file2" name="fDeviceImage" style="display: none" accept="image/*" />
                    <input style="display: none" name="fDeviceImage" id="server_fDeviceImage">
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="server_submit">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
            </form>
        </div>
    </div>
    <!-- /.modal-content -->
</div>
</body>
<%@include file="../common/js.jsp" %>

<script type="text/javascript">
   /* var cameraUpload = 1;
    var serverUpload = 1;*/
    var fileUrl = 0;
    var flag1 = 0; //验证非空字段
    var flag_long1 = 0;
    var flag_lat1 = 0;
    var flag_long2 = 0;
    var flag_lat2 = 0;
    var jsonMap =JSON.parse('${dictionary}');
    var camera_flag = 0;  //  验证设备号是否重复
    var server_flag = 0;  //
    $("select").change(function(){
        var text=$(this).find("option:selected").attr("value");
        $(this).attr("value",text);
    });



    $(function() {


        $('#tab_monitorDevice_server').bootstrapTable({
            url: "${ctx}/resourceManage/monitorDevice/list/3",
            columns: columns_server,
            method: 'get',
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            search: true,
            classes: 'table table-no-bordered',
            showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            queryParamsType: "",
            pageList : [ 5, 10, 20], // 可供选择的每页的行数（*）
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            }

        });
        $('#tab_monitorDevice_camera').bootstrapTable({
            url: "${ctx}/resourceManage/monitorDevice/list/2",
            method: 'get',
            columns: columns_camera,
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            search: true,
            classes: 'table table-no-bordered',
            showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            queryParamsType: "",
            pageList : [ 5, 10, 20], // 可供选择的每页的行数（*）
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                };
            },
            responseHandler: function (result) {
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            }
        });

    });
    var columns_server = [
        [{
            checkbox:true
        }, {
            /* field: 'fChannelModel', */
            field: 'fDeviceName',
            /* title: '通道类型', */
            title: '设备名称',
            /* align: 'center', */
            align: 'center',
            width: '10%',
            /* formatter : function(data,row, index){
                return jsonMap[data];
            } */
        },{
            field: 'fDeviceImage',
            title: '设备图片',
            align: 'center',
            width: '10%',
            formatter: function (data, row, index) {
                if (data != null && data != "") {
                    return '<img  src=' + data + ' style="width:100px;height:100px;"/>'
                } else {
                    return '<img  src=' + "${ctx}/static/img/defaultPicture.png" + ' style="width:100px;height:100px;"/>'

                }
            }

        },  {
            field: 'fDeviceIp',
            title: 'IP',
            align: 'center',
            width: '10%',
            sortable:true,
        },{
            field: 'fDevicePort',
            /* title: '端口管理', */
            title: '管理端口',
            align: 'center',
            width: '10%',
            sortable:true,
        },{
            field: 'fLocation',
            title: '所属区域',
            width: '10%',
            align: 'center',
            formatter: function (data,row,index) {
                return regionMap[data];
            }
        },{
            field: 'fInstallAddress',
            title: '安装地址',
            width: '10%',
            align: 'center',
            formatter:function(data,row,index){
                var values = data;
                var span=document.createElement('span');
                span.setAttribute('title',values);
                span.innerHTML = data;
                return span.outerHTML;
            },
        },{
            field: 'fUpdateTime',
            title: '操作时间',
            align: 'center',
            width: '15%',
            sortable: true,
            formatter : function(time){
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            }
        }, {
            field: 'operator',
            title: '操作者',
            align: 'center',

        },{
            title: '操作',
            align: 'center',
            events: {
                'click .edit-btn': function (e, val, row) {

                    dataShow1(row,"#xiangqing_server_modal");
                    $('#xiangqing_server_modal').modal('show');

                },
            },
            formatter: function () {

                return '<button class="btn btn-info btn-sm edit-btn">详情</button> '
            }}]
    ];

    var columns_camera = [
        [{
            checkbox:true
        }, {
            field: 'fDeviceName',
            title: '设备名称',
            align: 'center',
            width:'10%',

        }, {
            field: 'fDeviceImage',
            title: '设备图片',
            align: 'center',
            width:'10%',
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
            field: 'fDeviceIp',
            title: 'IP',
            align: 'center',
            width:'10%',
            sortable:true,
        }, {
            field: 'fDevicePort',
            title: '管理端口',
            width:'10%',
            align: 'center',
        }, {
            field: 'fLocation',
            title: '所属区域',
            align: 'center',
            width:'10%',
            formatter: function (value) {
                return regionMap[value];
            }
        }, {
            field: 'fInstallAddress',
            title: '安装地址',
            width:'10%',
            align: 'center',
            formatter:function(data,row,index){
                var values = data;
                var span=document.createElement('span');
                span.setAttribute('title',values);
                span.innerHTML = data;
                return span.outerHTML;
            },
        }, {
            field: 'fUpdateTime',
            title: '操作时间',
            align: 'center',
            width:'15%',
            sortable: true,
            formatter : function(time){
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            }
        }, {
            field: 'operator',
            title: '操作者',
            align: 'center',

        },{
            title: '操作',
            align: 'center',
            width: '15%',
            events: {
                'click .edit-btn': function (e, val, row) {

                    dataShow1(row,"#xiangqing_camera_modal");
                    $('#xiangqing_camera_modal').modal('show');

                },
            },
            formatter: function () {

                return '<button class="btn btn-info btn-sm edit-btn">详情</button> '
            }
        }]
    ];


    document.getElementById('file1').onchange = function() {
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function() {
            document.getElementById('image1').getElementsByTagName('img')[0].src = fr.result;
        };
        fr.readAsDataURL(imgFile);

        var form = new FormData();
        form.append("file",document.getElementById("file1").files[0]);
        console.log("form:"+form)
        $.ajax({
            url: "${ctx}/common/upload?type="+1,
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                if(data.status==200){
                    fileUrl = data.msg;
                }
            },
            error: function (e) {
                layer.msg("上传失败");
                layer.closeAll('loading');
            }
        });
    };
    document.getElementById('file2').onchange = function() {
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function() {
            document.getElementById('image2').getElementsByTagName('img')[0].src = fr.result;
        };
        fr.readAsDataURL(imgFile);
        var form = new FormData();
        form.append("file",document.getElementById("file2").files[0]);
        $.ajax({
            url: "${ctx}/common/upload?type="+1,
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                if(data.status==200){
                    fileUrl = data.msg;
                }
            } ,
            error: function (e) {
                layer.msg("上传失败");
                layer.closeAll('loading');
            }
        });
    };


    $("#add_camera").click(function () {
        $("#camera_title").text("新增");
        $('#camera_modal').modal('show');
        $('#camera_submit').addClass("add_camera").removeClass("update_camera");

    });

    $("#camera_modal").on("click",".add_camera",function(){
        submmitCheck("#camera_form");
        if(camera_flag==0 || flag_lat1==0 || flag_long1==0 || flag1==0){
            return;
        }
        $("#camera_fDeviceImage").val(fileUrl);
        layer.load(2);
        $.ajax({
            type:'post',
            url:'${ctx}/resourceManage/monitorDevice/add/2',
            data:$('#camera_form').serialize(),
            async:false,
            success:function (result) {
                if (result.status == 200) {
                    $('#camera_modal').modal('hide');
                    $('#tab_monitorDevice_camera').bootstrapTable('refresh');
                    document.getElementById('camera_form').reset();
                    camera_flag=0;
                }
                layer.msg(result.msg,{icon: 1});
                layer.closeAll('loading');
            }
        })
    });

    //删除操作
    $("#delete_camera").click(function(){
        var checked= $('#tab_monitorDevice_camera').bootstrapTable('getSelections');
        var del_ids = "";
        if(checked.length==0){
            layer.msg('请选择要删除的记录', {icon: 2});
        }else{

            layer.confirm('确认删除'+checked.length+"条记录?", {icon: 3, title: '操作提示'}, function (index) {
                for(i=0;i<checked.length;i++){
                    del_ids += checked[i].fId + ",";
                }
                layer.load(2);
                $.post('${ctx}/resourceManage/monitorDevice/deleteCamera/'+del_ids+'/'+2,''  , function (result) {
                    if (result.status === 200) {
                        $('#tab_monitorDevice_camera').bootstrapTable('refresh');
                    }
                    layer.msg(result.msg,{icon: 1});
                    layer.closeAll('loading');
                });
            });
        }
    })



    $("#update_camera").click(function () {
        camera_flag=1;
        flag_long1=1;
        flag_lat1=1;
        var checked = $('#tab_monitorDevice_camera').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg('请选择要修改的记录', {icon: 2});
            return;
        }
        else if (checked.length > 1) {
            layer.msg('只能选择一个记录', {icon: 2});
            return;
        }else{

            $("#camera_title").text("修改");
            cameradataShow2(checked[0]);
            $('#camera_modal').modal('show');
            $('#camera_submit').addClass("update_camera").removeClass("add_camera");

        }
    });

    $("#camera_modal").on("click",".update_camera",function(){
        var checked = $('#tab_monitorDevice_camera').bootstrapTable('getSelections');
        submmitCheck("#camera_form");
        if(camera_flag==0 || flag_lat1==0 || flag_long1==0 || flag1==0){
            return;
        }
        $("#camera_fDeviceImage").val(fileUrl);
        layer.load(2);

        $.ajax({
            type:'post',
            url:'${ctx}/resourceManage/monitorDevice/updateCamera/'+checked[0].fId+'/'+2,
            data:$('#camera_form').serialize(),
            success:function (result) {
                if (result.status == 200) {
                    $('#camera_modal').modal('hide');
                    $('#tab_monitorDevice_camera').bootstrapTable('refresh');
                    document.getElementById('camera_form').reset();
                }
                layer.msg(result.msg,{icon: 1});
                layer.closeAll('loading');
            }
        })

    });

    //数据回显
    function cameradataShow1(checked){
        $("#server_modal input[name='fNumber']").val(checked.fNumber);
        $("#server_modal input[name='fDisplayLevel']").val(checked.fDisplayLevel);
        $("#server_modal input[name='fDeviceName']").val(checked.fDeviceName);
        $("#server_modal input[name='fDeviceIp']").val(checked.fDeviceIp);
        $("#server_modal input[name='fDevicePort']").val(checked.fDevicePort);
        $("#server_modal input[name='fLoginName']").val(checked.fLoginName);
        $("#server_modal input[name='fLoginPassword']").val(checked.fLoginPassword);
        $("#server_modal select[name='fNvr']").val(checked.fNvr);
        $("#server_modal select[name='fDeviceModel']").val(checked.fDeviceModel);
        $("#server_modal input[name='fPhysicalCode']").val(checked.fPhysicalCode);
        $("#server_modal select[name='fLocation']").val(checked.fLocation);
        $("#server_modal input[name='fInstallAddress']").val(checked.fInstallAddress);
        $("#server_modal input[name='fLongitude']").val(checked.fLongitude);
        $("#server_modal input[name='fDimension']").val(checked.fDimension);
        $("#server_modal textarea[name='fRemark']").val(checked.fRemark);
        document.getElementById('image2').getElementsByTagName('img')[0].src = checked.fDeviceImage;
        var regionId = checked.fLocation;
        if (regionId) {
            var checkNode = treeObj1.getNodeByParam("id", regionId);
            if (checkNode) {
                $('#selectRegion1').val(checkNode.name);
            }
        }
        //  $("#programProduce_modal span[name='fBroadcastArea']").text(checked.fBroadcastArea);
        // $("#camera_modal span[name='fDeviceImage']").text(jsonMap[checked.fDeviceImage]);
    }

    //数据回显
    function cameradataShow2(checked){
        $("#camera_modal input[name='fNumber']").val(checked.fNumber);
        $("#camera_modal input[name='fDisplayLevel']").val(checked.fDisplayLevel);
        $("#camera_modal input[name='fDeviceName']").val(checked.fDeviceName);
        $("#camera_modal input[name='fDeviceIp']").val(checked.fDeviceIp);
        $("#camera_modal input[name='fDevicePort']").val(checked.fDevicePort);
        $("#camera_modal input[name='fLoginName']").val(checked.fLoginName);
        $("#camera_modal input[name='fLoginPassword']").val(checked.fLoginPassword);
        $("#camera_modal select[name='fDeviceModel']").val(checked.fDeviceModel);
        $("#camera_modal input[name='fPhysicalCode']").val(checked.fPhysicalCode);
        $("#camera_modal select[name='fLocation']").val(checked.fLocation);
        $("#camera_modal input[name='fInstallAddress']").val(checked.fInstallAddress);
        $("#camera_modal input[name='fLongitude']").val(checked.fLongitude);
        $("#camera_modal input[name='fDimension']").val(checked.fDimension);
        $("#camera_modal textarea[name='fRemark']").val(checked.fRemark);
        document.getElementById('image1').getElementsByTagName('img')[0].src = checked.fDeviceImage;
        var regionId = checked.fLocation;
        if (regionId) {
            var checkNode = treeObj.getNodeByParam("id", regionId);
            if (checkNode) {
                $('#selectRegion').val(checkNode.name);
            }
        }
        //  $("#programProduce_modal span[name='fBroadcastArea']").text(checked.fBroadcastArea);
      // $("#camera_modal span[name='fDeviceImage']").text(jsonMap[checked.fDeviceImage]);
    }


    $("#add_server").click(function () {

        $("#server_title").text("新增");

        $('#server_modal').modal('show');
        $('#server_submit').addClass("add_server").removeClass("update_server");


    });

    $("#server_modal").on("click",".add_server",function(){

        submmitCheck("#server_form");
        if(server_flag==0 ||flag_long2==0 || flag_lat2==0 || flag1==0){
            return;
        }
        $("#server_fDeviceImage").val(fileUrl);
        layer.load(2);
        $.ajax({
            type:'post',
            url:'${ctx}/resourceManage/monitorDevice/add/3',
            data:$('#server_form').serialize(),
            success:function (result) {
                if (result.status == 200) {
                    $('#server_modal').modal('hide');
                    $('#tab_monitorDevice_server').bootstrapTable('refresh');
                    document.getElementById('server_form').reset();
                }
                layer.msg(result.msg,{icon: 1});
                layer.closeAll('loading');
            }
        })
    })

    //删除操作
    $("#delete_server").click(function(){
        var checked= $('#tab_monitorDevice_server').bootstrapTable('getSelections');
        var del_ids = "";
        if(checked.length==0){
            layer.msg('请选择要删除的记录', {icon: 2});
        }else{

            layer.confirm('确认删除'+checked.length+"条记录?", {icon: 3, title: '操作提示'}, function (index) {
                for(i=0;i<checked.length;i++){
                    del_ids += checked[i].fId + ",";
                }
                layer.load(2);
                $.post('${ctx}/resourceManage/monitorDevice/deleteCamera/'+del_ids+'/'+3,''  , function (result) {
                    if (result.status === 200) {
                        $('#tab_monitorDevice_server').bootstrapTable('refresh');
                    }
                    layer.msg(result.msg,{icon: 1});
                    layer.closeAll('loading');
                });
            });
        }
    })

    $("#update_server").click(function () {
        server_flag=1;
        flag_long2=1;
        flag_lat2=1;
        var checked = $('#tab_monitorDevice_server').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg('请选择要修改的记录', {icon: 2});
            return;
        }
        else if (checked.length > 1) {
            layer.msg('只能选择一条记录', {icon: 2});
            return;
        }else{

            $("#server_title").text("修改");
            cameradataShow1(checked[0]);
            $('#server_modal').modal('show');
            $('#server_submit').addClass("update_server").removeClass("add_server");

        }
    });

    $("#server_modal").on("click",".update_server",function(){
        var checked = $('#tab_monitorDevice_server').bootstrapTable('getSelections');
        submmitCheck("#server_form");
        if(server_flag==0 || flag_lat2==0 || flag_long2==0 || flag1==0 ){
            return;
        }
        $("#server_fDeviceImage").val(fileUrl);
        layer.load(2);

        $.ajax({
            type:'post',
            url:'${ctx}/resourceManage/monitorDevice/updateCamera/'+checked[0].fId+'/'+3,
            data:$('#server_form').serialize(),
            success:function (result) {
                if (result.status == 200) {
                    $('#server_modal').modal('hide');
                    $('#tab_monitorDevice_server').bootstrapTable('refresh');
                    document.getElementById('server_form').reset();
                    server_flag=0;
                }
                layer.msg(result.msg,{icon: 1});
                layer.closeAll('loading');
            }
        })

    });


    function dataShow1(checked,modal){
        $(modal+" span[name='fId']").text(checked.fId);
        $(modal+" span[name='fNumber']").text(checked.fNumber);
        $(modal+" span[name='fDisplayLevel']").text(checked.fDisplayLevel);
        $(modal+" span[name='fDeviceName']").text(checked.fDeviceName);
        $(modal+" span[name='fDeviceIp']").text(checked.fDeviceIp);
        $(modal+" span[name='fDevicePort']").text(checked.fDevicePort);
        $(modal+" span[name='fLoginName']").text(checked.fLoginName);
        $(modal+" span[name='fLoginPassword']").text(checked.fLoginPassword);
        $(modal+" span[name='fDeviceModel']").text(jsonMap[checked.fDeviceModel]);
        $(modal+" span[name='fPhysicalCode']").text(checked.fPhysicalCode);
        //所属区域n
        $(modal+" span[name='fLocation']").text(regionMap[checked.fLocation]);
        $(modal+" span[name='fInstallAddress']").text(checked.fInstallAddress);
        $(modal+" span[name='fLongitude']").text(checked.fLongitude);
        $(modal+" span[name='fDimension']").text(checked.fDimension);
        $(modal+" span[name='fRemark']").text(checked.fRemark);
        $(modal+" span[name='fDeviceImage']").text(checked.fDeviceImage);
        $(modal+" span[name='fNvr']").text(checked.fNvr);
        $(modal+" span[name='fChannelModel']").text(jsonMap[checked.fChannelModel]);
        $(modal +" span[name='fCreatorId']").text(checked.creator);
        $(modal +" span[name='fCreateTime']").text(new Date(checked.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
        /*$(modal +" span[name='fOperatorId']").text(checked.operator);
        $(modal +" span[name='fUpdateTime']").text(new Date(checked.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'));*/
        if(checked.fCreateTime!=checked.fUpdateTime){
            $(modal +" span[name='fOperatorId']").text(checked.operator);
            $(modal +" span[name='fUpdateTime']").text(new Date(checked.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'));
        }
      //  //  $("#programProduce_modal span[name='fBroadcastArea']").text(checked.fBroadcastArea);
      //  $("#programProduce_modal span[name='fMediaType']").text(jsonMap[checked.fMediaType]);

    }

    function fNumberChange1(){
        var name = document.getElementById("camera_fNumber").value;
        $.post('${ctx}/resourceManage/monitorDevice/check/'+2,{name:name},function (result) {

            if (result.data == "true") {
                camera_flag = 0;
                layer.tips('该设备号已存在',
                    '#camera_fNumber', {
                        tips: [2, 'red'],
                        tipsMore: true
                    }
                );
            } else {
                camera_flag = 1;
            }
        })
    }

    function fNumberChange2(){
        var name = document.getElementById("server_fNumber").value;
        // alert(1);
        $.post('${ctx}/resourceManage/monitorDevice/check/'+3,{name:name},function (result) {
            if (result.data == "true") {
                server_flag = 0;
                layer.tips('该设备号已存在',
                    '#server_fNumber', {
                        tips: [2, 'red'],
                        tipsMore: true
                    }
                );
            } else {
                server_flag = 1;
            }
        })
    }

    //校验经度是否符合规范
    //校验经度
    function checkLong1(){
        var longrg = /^(\-|\+)?(((\d|[1-9]\d|1[0-7]\d|0{1,3})\.\d{0,6})|(\d|[1-9]\d|1[0-7]\d|0{1,3})|180\.0{0,6}|180)$/;
        var lng = $("#camera_fLongitude").val();

        if(!longrg.test(lng)){
            flag_long1 = 0;
            layer.tips('经度整数部分为0-180,小数部分为0到6位!',
                '#camera_fLongitude', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
            //return '经度整数部分为0-180,小数部分为0到6位!';
        }else{
            flag_long1 = 1;
        }
        //alert(flag);
    }

    function checkLong2(){
        var longrg = /^(\-|\+)?(((\d|[1-9]\d|1[0-7]\d|0{1,3})\.\d{0,6})|(\d|[1-9]\d|1[0-7]\d|0{1,3})|180\.0{0,6}|180)$/;
        var lng = $("#server_fLongitude").val();
        if(!longrg.test(lng)){
            flag_long2 = 0;
            layer.tips('经度整数部分为0-180,小数部分为0到6位!',
                '#server_fLongitude', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
        }else{
            flag_long2 = 1;
        }
        //alert(flag);
    }

    //校验纬度是否符合规范
    //纬度
    function checkLat1(){
        var latreg = /^(\-|\+)?([0-8]?\d{1}\.\d{0,6}|90\.0{0,6}|[0-8]?\d{1}|90)$/;
        var lat = $("#camera_fDimension").val();
        if(!latreg.test(lat)){
            flag_lat1=0;
            layer.tips('纬度整数部分为0-90,小数部分为0到6位!\'',
                '#camera_fDimension', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
            //return '纬度整数部分为0-90,小数部分为0到6位!';
        }else{
            flag_lat1=1;
        }
        //return true;
    }

    function checkLat2(){
        var latreg = /^(\-|\+)?([0-8]?\d{1}\.\d{0,6}|90\.0{0,6}|[0-8]?\d{1}|90)$/;
        var lat = $("#server_fDimension").val();
        if(!latreg.test(lat)){
            flag_lat2=0;
            layer.tips('纬度整数部分为0-90,小数部分为0到6位!\'',
                '#server_fDimension', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
        }else{
            flag_lat2=1;
        }
        //return true;
    }

    function submmitCheck(str){

        flag1=1;
        var t = $(str).serializeArray();
        $.each(t,function(i,item){
            if('fDeviceImage'!=item['name'] && 'fLocation'!=item['name'] && item['value'] == '') {
                if(item['name']=='fRemark')
                    return;
                console.log(item);
                layer.msg('请确认所有信息已填完整', {icon: 2});
                flag1=0;
                //$(this).css("background", "Red");
                // $(this).siblings().css("background", "white");
                $("input[name="+item.name+"]").css({
                    'border': '1px solid red',
                });
                // return false;
            }
        })
    }

    function change(){
        var form = new FormData(document.getElementById("uploadForm"));
        $.ajax({
            url: "/upload",
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                fileUrl = data.msg;
            },
            error: function (e) {
                layer.msg("上传失败");
                layer.closeAll('loading');
            }
        });
    }

    $('input').on("focus",function(){
        $(this).css("border","1px solid #eceeef");
    })

    $('body').on('hidden.bs.modal', '.modal', function () {
        document.getElementById("camera_form").reset();
        document.getElementById("server_form").reset();
        $('.modal input').css("border","1px solid #eceeef");
        $("#tab_programProduce input[checked='checked']").attr("checked","false");
        document.getElementById('image1').getElementsByTagName('img')[0].src = "${ctx}/static/img/picture/addPhoto.jpg";
        document.getElementById('image2').getElementsByTagName('img')[0].src = "${ctx}/static/img/picture/addPhoto.jpg";
        fileUrl = "";
        $("#xiangqing_server_modal span").text("");
        $("#xiangqing_camera_modal span").text("");
        $(".modal-dialog").css({"top":"0","bottom":"0","left":"0","right":"0"});
    });


    $('#exportCamera').click(function () {
        layer.confirm('确认要导出所有记录吗？', {icon: 3, title: '操作提示'}, function (index){
            window.location.href = '${ctx}/resourceManage/monitorDevice/exportCamera';
            layer.close(index);
        });

    });

    $('#exportServer').click(function () {

        layer.confirm('确认要导出所有记录吗？', {icon: 3, title: '操作提示'}, function (index){
            window.location.href = '${ctx}/resourceManage/monitorDevice/exportServer';
            layer.close(index);
        });
    });

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
            treeId1 = 'ztree1'

        var treeObj1 = $.fn.zTree.init($("#" + treeId1), treeSetting1, nodes);
        $.each(treeObj1.getNodes(), function (index, node) {

                treeObj1.expandNode(node, true);
        });

        function hideMenu1() {
            $("#menuContent1").fadeOut("fast");
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
   $(".modal-dialog").draggable();
   $(".nav.nav-tabs li").click(function () {
       $('#tab_monitorDevice_server').bootstrapTable('refresh');
       $('#tab_monitorDevice_camera').bootstrapTable('refresh');
   })
</script>
</html>