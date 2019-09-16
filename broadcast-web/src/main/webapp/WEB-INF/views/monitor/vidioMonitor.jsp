<%--
  Created by IntelliJ IDEA.
  User: AYY
  Date: 2019/1/8
  Time: 15:12
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
    <title></title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .home_content {
            height: 99%;
            width: 99%;
        }
        .handle_left,.handle_right{
            margin-left: 0;
            height: 100%;
        }
        .left_1,
        .right{
            border:1px solid #0083f0 ;
            border-radius: 10px;
        }
        .left_1{
            margin-bottom: 1%;
        }
        .left_1 ul{
        	margin-top:0;
        	margin-bottom: 0;
        }
        .left,.right{
            height: 100%;
        }
        .home_content li{
            list-style: none;
            color:#0083f0;
            padding:10px  ;
            background: rgba(0,0,0,0.3);
        }
        .handle_right button{
            margin: 5px 10px;
        }
        .sel{
        	margin-top: 10px;
        	margin-left: 10px;
        	height: 30px;
        }
    </style>
</head>

<body>
<div class="home_content">
    <div class="left" style="width: 75%;float: left;margin-right: 1%;">
        <div class="left_1" style="height: 90%;">
            <ul>
                <li><b style="color:white;">监控视屏</b></li>
            </ul>
            <div id="divPlugin" style="width:100%;height: 100%;"></div>
        </div>
        <div class="left_2" style="height: 10%;">
            <div class="handle_right col-sm-12" style="padding: 5%;">
                <button id="fullScreen" type="button" class="btn btn-info col-sm-2">全屏</button>
                <button id="singleScreen" type="button" class="btn btn-info col-sm-2">单屏</button>
                <button id="fourScreen" type="button" class="btn btn-info col-sm-2">四格</button>
                <button id="nineScreen" type="button" class="btn btn-info col-sm-2">九格</button>
                <button id="sixteenScreen" type="button" class="btn btn-info col-sm-2">十六格</button>
            </div>
        </div>
    </div>
    <div class="right" style="width: 23%;float: left;"">
	    <ul>
	        <li><b style="color:white;">监控设备</b></li>	        
	    </ul>
	    <div class="col-sm-12">
	    	<select id="cameraList" class="sel col-sm-10"></select>    	
	    </div>
        <div class="handle_right col-sm-12" style="padding: 5%;">           
            <button id="preview" type="button" class="btn btn-info col-sm-4">开始预览</button>
            <button id="canclePreview" type="button" class="btn btn-info col-sm-4">停止预览</button>
        </div>

	</div>
<div class="null">

</div>
</div>
<%@include file="../common/js.jsp" %>
<script src="${ctx}/static/js/webVideoCtrl.js"></script>
<script type="text/javascript">
	//全局保存当前选中窗口
	var g_iWndIndex = 0;
    $(function(){	
      	dateFormat = function (oDate, fmt) {
    	    var o = {
    	        "M+": oDate.getMonth() + 1, //月份
    	        "d+": oDate.getDate(), //日
    	        "h+": oDate.getHours(), //小时
    	        "m+": oDate.getMinutes(), //分
    	        "s+": oDate.getSeconds(), //秒
    	        "q+": Math.floor((oDate.getMonth() + 3) / 3), //季度
    	        "S": oDate.getMilliseconds()//毫秒
    	    };
    	    if(/(y+)/.test(fmt)) {
    	        fmt = fmt.replace(RegExp.$1, (oDate.getFullYear() + "").substr(4 - RegExp.$1.length));
    	    }
    	    for (var k in o) {
    	        if(new RegExp("(" + k + ")").test(fmt)) {
    	            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    	        }
    	    }
    	    return fmt;
    	};
   	    // 检查插件是否已经安装过
   	    if (-1 == WebVideoCtrl.I_CheckPluginInstall()) {
   	        alert("您还未安装过插件，下载WebComponents.exe安装！");
   	        return;
   	    }
   	    
   	    // 初始化插件参数及插入插件
   	    WebVideoCtrl.I_InitPlugin('100%', '100%', {
   	        iWndowType: 2,
   	        cbSelWnd: function (xmlDoc) {
   	            g_iWndIndex = $(xmlDoc).find("SelectWnd").eq(0).text();
   	
   	        }
   	    });
   	    WebVideoCtrl.I_InsertOBJECTPlugin("divPlugin");

     	// 检查插件是否最新
   	    if (-1 == WebVideoCtrl.I_CheckPluginVersion()) {
   	        alert("检测到新的插件版本，请将WebComponents.exe升级！");
   	        return;
   	    }

   	    // 窗口事件绑定
   	    $(window).bind({
   	        resize: function () {
   	            var $Restart = $("#restartDiv");
   	            if ($Restart.length > 0) {
   	                var oSize = getWindowSize();
   	                $Restart.css({
   	                    width: oSize.width + "px",
   	                    height: oSize.height + "px"
   	                });
   	            }
   	        }
   	    });
   	    //初始化日期时间
   	    var szCurTime = dateFormat(new Date(), "yyyy-MM-dd");
   	    $("#starttime").val(szCurTime + " 00:00:00");
   	    $("#endtime").val(szCurTime + " 23:59:59"); 
		
   		//获取摄像头设备信息
   		var cameraList = new Array();
   		$.ajax({
            url: "${ctx}/resourceManage/monitorDevice/getCameraInfo",
            type: "get",
            async: false, 
            success: function (data) {
            	cameraList = data.data;
            	//这里要用setTimeout调用登录和预览方法 ，如果直接调用  会打不开窗口 ，因为加载时需要时间的
           		var cameraIp,cameraPort,cameraLoginName,cameraPassword,cameraName;
           	    window.setTimeout(function(){
           		 	errorCameras = "";
           			for(var i=0;i<cameraList.length;i++){
           				cameraIp = cameraList[i].fDeviceIp;
           				cameraPort = cameraList[i].fDevicePort;
           				cameraLoginName = cameraList[i].fLoginName;
           				cameraPassword = cameraList[i].fLoginPassword;
           				cameraName = cameraList[i].fDeviceName;
           				$("#cameraList").prepend("<option value='" + cameraIp + "'>" + cameraName + "</option>");
           				var iRet = WebVideoCtrl.I_Login(cameraIp, 1, cameraPort, cameraLoginName, cameraPassword, {});
           			} 
           		    //var iRet = WebVideoCtrl.I_Login("10.177.3.166", 1, 80, "admin", "Admin123", {});
           		},100);
           	    window.setTimeout(function(){       		 
        	   		for(var i=0;i<cameraList.length;i++){
        	   		    successCameraIp = cameraList[i].fDeviceIp;
        	   		 	var iRet = WebVideoCtrl.I_StartRealPlay(successCameraIp, {
        	            	iWndIndex:i
        	        	}); 
        	   		} 
        	  /*  		var iRet = WebVideoCtrl.I_StartRealPlay("10.177.3.166", {
    	            	iWndIndex:0
    	        	});  */
           		
        		},500); 
            },
            error: function (e) {
                layer.msg("后台获取摄像头信息失败！");
            }
        });
    	
   	
 		// 窗口分割数
	   	function changeWndNum(iType) {
	   		iType = parseInt(iType, 10);
	   		WebVideoCtrl.I_ChangeWndNum(iType);
	   	}
 		
	   	$("#fullScreen").click(function () {  
	   		WebVideoCtrl.I_FullScreen(true);
	   	})
	   	$("#singleScreen").click(function () {  
	   		changeWndNum(1);
	   	})
	   	$("#fourScreen").click(function () {  
	   		changeWndNum(2);
	   	})
	   	$("#nineScreen").click(function () {  
	   		changeWndNum(3);
	   	})
	   	$("#sixteenScreen").click(function () {  
	   		changeWndNum(4);
	   	})
	   	$("#preview").click(function () {  
	   		var oWndInfo = WebVideoCtrl.I_GetWindowStatus(g_iWndIndex),
			szIP = $("#cameraList").val();
	   		//szIP = "10.177.3.166";
			if (oWndInfo != null) {// 已经在播放了，先停止
				WebVideoCtrl.I_Stop();
			}
			var iRet = WebVideoCtrl.I_StartRealPlay(szIP, {				
			});
			if (0 == iRet) {
				szInfo = "开始预览成功！";
			} else {
				alert("预览失败！请核查设备信息是否正确。");
				//layer.msg("预览失败",{icon: 2});
			}				
	   	})
	   	
	   	$("#canclePreview").click(function () {  
	   		var oWndInfo = WebVideoCtrl.I_GetWindowStatus(g_iWndIndex);
			if (oWndInfo != null) {
				var iRet = WebVideoCtrl.I_Stop();
			}
	   	})
	   	

		var unSelected = "white";
   	    var selected = "white";
   	    $("select").css("color", unSelected);
   	    $("option").css("color", selected);
   	    $("select").change(function () {
   	        var selItem = $(this).val();
   	        if (selItem == $(this).find('option:first').val()) {
   	            $(this).css("color", unSelected);
   	        } else {
   	            $(this).css("color", selected);
   	        }
   	    }); 


    })
</script>
</body>
</html>
