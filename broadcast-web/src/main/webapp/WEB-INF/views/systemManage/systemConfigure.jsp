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
    <title>系统配置</title>
    <%@include file="../common/css.jsp" %>
    <style>
        .form-group .control-label {
           margin-left: 20px;
            width: 20%;
        }
        .esp .control-label{
            width: 13%;
        }
        .content {
            height: auto;
            padding-bottom: 20px;
        }
    </style>
</head>
<body>
<h4><b>当前位置:系统管理>>系统配置</b></h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li class="selected_tab"><a>省级平台</a></li>
        <li><a>下发平台</a></li>
        <li><a>平台配置</a></li>
        <li><a>百度语音认证</a></li>
        <li><a>资源类型</a></li>
        <li><a>资源级别识别</a></li>        
        <li><a>资源子类型</a></li>        
<!--         <li><a>时区设置</a></li> -->
<!--         <li><a>IP音频协议</a></li> -->
    </ul>
</div>
<!-- 省级平台 -->
<div class="tab_modal show">
    <div class="content">
        <div class="row">
            <form class="form-inline">
                <div class="form-group col-sm-6">
                    <label class="control-label">服务器地址</label>
                    <input type="text" class="form-control" name="province_server_url" value="${config.province_server_url}" maxlength="256">
                </div>
                <div class="form-group col-sm-5">
                    <label class="control-label">服务器端口</label>
                    <input type="text" class="form-control" name="province_server_port" value="${config.province_server_port}" maxlength="256">
                </div>

                <div class="form-group col-sm-6">
                    <label class="control-label">通讯超时时间(s)</label>
                    <input type="text" class="form-control" name="province_server_timeout" value="${config.province_server_timeout}" maxlength="256">
                </div>
                <div class="form-group col-sm-5">
                    <label class="control-label">证书编号</label>
                    <input type="text" class="form-control" name="province_ssl_num" value="${config.province_ssl_num}" maxlength="256">
                </div>
                <div class="form-group col-sm-6">
                   <label class="control-label">公钥</label>
                   <textarea type="text" class="form-control" rows="3" cols="50" name="province_public_key"  maxlength="256">${config.province_public_key}</textarea>
               </div>
               <div class="form-group col-sm-6">
                    <label class="control-label"></label>
                    <button type="button" class="btn btn-default submit-btn">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 下发平台 -->
<div class="tab_modal esp">
    <div class="content">
        <div class="row">
            <form class="form-inline">
                <div class="form-group col-sm-12">
                    <label class="control-label">调控服务器IP地址</label>
                    <input type="text" class="form-control" name="transmit_server_url"
                           value="${config.transmit_server_url}" maxlength="256">
                    <label class="control-label">调控服务器IP端口</label>
                    <input type="text" class="form-control" name="transmit_server_port"
                           value="${config.transmit_server_port}" maxlength="256">
                </div>
                <div class="form-group col-sm-12">
                    <label class="control-label">音频服务器IP地址</label>
                    <input type="text" class="form-control" name="audio_server_ip"
                           value="${config.audio_server_ip}" maxlength="256">
                    <label class="control-label">音频服务器IP端口</label>
                    <input type="text" class="form-control" name="audio_server_port"
                           value="${config.audio_server_port}" maxlength="256">
                </div>
                <div class="form-group col-sm-12">
                    <label class="control-label">回传服务器IP地址</label>
                    <input type="text" class="form-control" name="return_server_ip"
                           value="${config.return_server_ip}" maxlength="256">
                    <label class="control-label">回传服务器IP端口</label>
                    <input type="text" class="form-control" name="return_server_port"
                           value="${config.return_server_port}" maxlength="256">
                </div>
                <div class="form-group col-sm-12">
                    <label class="control-label">有线TS适配器IP地址</label>
                    <input type="text" class="form-control" name="dvbc_adapter_ip"
                           value="${config.dvbc_adapter_ip}" maxlength="256">
                    <label class="control-label">有线TS适配器IP端口</label>
                    <input type="text" class="form-control" name="dvbc_adapter_port"
                           value="${config.dvbc_adapter_port}" maxlength="256">
                </div>
                <div class="form-group col-sm-12">
                    <label class="control-label">地面波TS适配器IP地址</label>
                    <input type="text" class="form-control" name="dtmb_adapter_ip"
                           value="${config.dtmb_adapter_ip}" maxlength="256">
                    <label class="control-label">地面波TS适配器IP端口</label>
                    <input type="text" class="form-control" name="dtmb_adapter_port"
                           value="${config.dtmb_adapter_port}" maxlength="256">
                </div>
                <div class="form-group col-sm-12">
                    <label class="control-label">IP流地址</label>
                    <input type="text" class="form-control" name="multicast_ip"
                           value="${config.multicast_ip}" maxlength="256">
                    <label class="control-label">IP流端口</label>
                    <input type="text" class="form-control" name="multicast_port"
                           value="${config.multicast_port}" maxlength="256">
                </div>
<!--                 <div class="form-group col-sm-12"> -->
<!--                     <label class="control-label">IP话筒TS端口</label> -->
<!--                     <input type="text" class="form-control" name="ts_port" -->
<%--                            value="${config.ts_port}" maxlength="256"> --%>
<!--                     <label class="control-label">IP话筒PID</label> -->
<!--                     <input type="text" class="form-control" name="pid" -->
<%--                            value="${config.pid}" maxlength="256"> --%>
<!--                 </div> -->
<!--                 <div class="form-group col-sm-12"> -->
<!--                     <label class="control-label">IP话筒端口</label> -->
<!--                     <input type="text" class="form-control" name="unicast_port" -->
<%--                            value="${config.unicast_port}" maxlength="256"> --%>
<!--                 </div> -->

                <div class="form-group col-sm-6">
                    <label class="control-label"></label>
                    <button type="button" class="btn btn-default submit-btn">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 平台配置 -->
<div class="tab_modal ">
    <div class="content">
        <div class="row">
            <form class="form-inline">
                <div class="form-group col-sm-5">
                    <label class="control-label">系统名称</label>
                    <input type="text" class="form-control" name="web_title" value="${config.web_title}" maxlength="256">
                </div>
                <div class="form-group col-sm-5">
                    <label class="control-label">平台资源编码</label>
                    <input type="text" class="form-control" maxlength="23" name="platform_resource_code" value="${config.platform_resource_code}" >
                </div>
                <div class="form-group col-sm-5">
                    <label class="control-label">证书编号</label>
                    <input type="text" class="form-control" name="certificate_number" value="${config.certificate_number}" maxlength="256">
                </div>
                <div class="form-group col-sm-5">
                    <label class="control-label">指令PID</label>
                    <input type="text" class="form-control" name="instruction_pid" value="${config.instruction_pid}" maxlength="256">
                </div>
                <div class="form-group col-sm-5">
                    <label class="control-label">公钥</label>
                    <textarea type="text" class="form-control" rows="5" cols="40" name="public_key" value="" maxlength="256">${config.public_key}</textarea>
                </div>
                <div class="form-group col-sm-5">
                    <label class="control-label">私钥</label>
                    <textarea type="text" class="form-control" rows="5" cols="40" name="private_key" value="" maxlength="256">${config.private_key}</textarea>
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label"></label>
                    <button type="button" class="btn btn-default submit-btn">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 百度语音认证 -->
<div class="tab_modal">
    <div class="content">
        <div class="row">
            <form class="form-inline">
                <div class="form-group col-sm-6">
                    <label class="control-label">AppID</label>
                    <input type="text" class="form-control" name="baidu_tts_appid" value="${config.baidu_tts_appid}" maxlength="256">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">APIKey</label>
                    <textarea type="text" class="form-control" rows="2" cols="20"  name="baidu_tts_apikey" value="" maxlength="256">${config.baidu_tts_apikey}</textarea>
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">SecretKey</label>
                    <textarea type="text" class="form-control" rows="3" cols="20" name="baidu_tts_secretkey" value="" maxlength="256">${config.baidu_tts_secretkey}</textarea>
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label"></label>
                    <button type="button" class="btn btn-default submit-btn">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 资源类型 -->
<div class="tab_modal">
    <div class="content">
        <div class="row">
            <form class="form-inline">
                <div class="form-group col-sm-6">
                    <label class="control-label">县平台</label>
                    <input type="text" class="form-control" name="platform_prefix" value="${config.platform_prefix}" >
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">适配器</label>
                    <input type="text" class="form-control" name="adapter_prefix" value="${config.adapter_prefix}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">终端</label>
                    <input type="text" class="form-control" name="terminal_prefix" value="${config.terminal_prefix}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label"></label>
                    <button type="button" class="btn btn-default submit-btn">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 资源级别识别 -->
<div class="tab_modal">
    <div class="content">
        <div class="row">
            <form class="form-inline">
                <div class="form-group col-sm-6">
                    <label class="control-label">县级</label>
                    <input type="text" class="form-control" name="province_level" value="${config.county_level}" >
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">乡级</label>
                    <input type="text" class="form-control" name="municipal_level" value="${config.township_level}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">村级</label>
                    <input type="text" class="form-control" name="county_level" value="${config.village_level}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label"></label>
                    <button type="button" class="btn btn-default submit-btn">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 资源子类型 -->
<div class="tab_modal">
    <div class="content">
        <div class="row">
            <form class="form-inline">
                <div class="form-group col-sm-6">
                    <label class="control-label">本机平台/系统/机构</label>
                    <input type="text" class="form-control" name="platform_system_mechanism" value="${config.platform_system_mechanism}" >
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">应急广播适配器</label>
                    <input type="text" class="form-control" name="emergency_Broadcasting_adapter" value="${config.emergency_Broadcasting_adapter}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">传输覆盖播出设备</label>
                    <input type="text" class="form-control" name="transmission_coverage" value="${config.transmission_coverage}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label">终端</label>
                    <input type="text" class="form-control" name="subtype_terminal" value="${config.subtype_terminal}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="control-label"></label>
                    <button type="button" class="btn btn-default submit-btn">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 时区设置 -->
<!-- <div class="tab_modal"> -->
<!--     <div class="content"> -->
<!--         <div class="row"> -->
<!--             <form class="form-inline"> -->
<!--                 <div class="form-group col-sm-6"> -->
<%--                     <label class="control-label">选择时区</label> <c:if test="${config.timeZone_set} == '0' ">checked="checked"</c:if> --%>
<%--                     <input type="radio" name="timeZone_set" value="0" <c:if test="${config.timeZone_set == '0'}">checked</c:if>/><font color="white">本地</font> --%>
<%--                     <input type="radio" name="timeZone_set" value="1" <c:if test="${config.timeZone_set == '1'}">checked</c:if>/><font color="white">UTC</font> --%>
<!--                 </div> -->
<!--                 <div class="form-group col-sm-6"> -->
<!--                     <label class="control-label"></label> -->
<!--                     <button type="button" class="btn btn-default submit-btn">确定</button> -->
<!--                 </div> -->
<!--             </form> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->
<!-- IP音频协议 -->
<!-- <div class="tab_modal"> -->
<!--     <div class="content"> -->
<!--         <div class="row"> -->
<!--             <form class="form-inline"> -->
<!--                 <div class="form-group col-sm-6"> -->
<%--                     <label class="control-label">选择协议</label> <c:if test="${config.timeZone_set} == '0' ">checked="checked"</c:if> --%>
<%--                     <input type="radio" name="protocol_set" value="0" <c:if test="${config.protocol_set == '0'}">checked</c:if>/><font color="white">HTTP</font> --%>
<%--                     <input type="radio" name="protocol_set" value="1" <c:if test="${config.protocol_set == '1'}">checked</c:if>/><font color="white">RTSP</font> --%>
<!--                 </div> -->
<!--                 <div class="form-group col-sm-6"> -->
<!--                     <label class="control-label"></label> -->
<!--                     <button type="button" class="btn btn-default submit-btn">确定</button> -->
<!--                 </div> -->
<!--             </form> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    $(function () {
        $('.submit-btn').click(function () {
            var data = $(this).parent().parent().serialize() + "&_method=put";
            layer.load(1);
            $.post('', data, function (result) {
                if (result.status === 200) {
                    layer.msg(result.msg, {icon: 1});
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
                layer.closeAll('loading');
            });
        });
        //初始化行政区域
        $('.init-btn').click(function () {
            layer.load(1);
            $.post('baseData/region/init', function (result) {
                if (result.status === 200) {
                    layer.msg(result.msg, {icon: 1});
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
                layer.closeAll('loading');
            });
        });
    });
</script>
</body>
</html>