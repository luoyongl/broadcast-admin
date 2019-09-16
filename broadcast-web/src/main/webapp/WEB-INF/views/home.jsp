<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="${ctx}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/static/bootstrap/css/multiple-select.css">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/static/css/index.css">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/static/css/style.css">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/static/css/scroll.css"/>
    <title>${config.web_title}-平台首页</title>
    <%@include file="common/css.jsp" %>
    <style type="text/css">
        @media ( min-width: 1400px) {
            .headlogo img {
                width: 120px;
                height: 52px;
                margin-bottom: 5%
            }
            .headnav {
                display: inline-block;
                width:850px;
                float: left !important;
                margin-left:30%;
                position: absolute;
                left: 0;
                right: 0;
            }
            .slide {
                display: block;
                height: 5px;
                width: 102px;
                background: yellow;
                margin-top: 72px;
                margin-left: 7px;
            }
            .headlogo img {
                width: 100px;
            }
            .leftmenu {
                background: rgba(0, 0, 0, 0);
            }
        }
        @media ( max-width: 1400px) {
            .headnav {}
            .slide {
                display: block;
                height: 5px;
                width: 92px;
                background: yellow;
                margin-top: 65px;
                margin-left: 7px;
            }
            .headlogo img {
                width: 100px;
                height: 42px;
                margin-bottom: 5%;
            }
            .leftmenu {
                background: rgba(0, 0, 0, 0);

            }
        }

        .clearfix span {
            z-index: -1;
        }
        dt img {
            height: 70%;
            padding: 0;
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .left_home1 {
            height: 50%;
            border: 1px solid #0083f0;
            border-radius: 10px;
            margin: 10px 0;
            background: rgba(0, 0, 0, 0.3);
        }

        .left_home1 li {
            color: #0083f0;
        }

        #left_home1_beingBroadcastli {
            color: #0083f0;
            padding-left: 5%;
            padding: 10px;
            background: rgba(0, 0, 0, 0.3);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .left_home2 {
            height: 50%;
            border: 1px solid #0083f0;
            border-radius: 10px;
            margin: 10px 0;
            background: rgba(0, 0, 0, 0.3);
        }

        .left_home2 li {
            color: #0083f0;
            padding-left: 5%;
            padding: 10px;
            background: rgba(0, 0, 0, 0.5);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        video {
            position: fixed;
            right: 0px;
            bottom: 0px;
            min-width: 100%;
            min-height: 100%;
            height: auto;
            width: auto;
            z-index: -11;
        }

        .myscrollDiv {
            height: 88%;
        }

        .myscroll {
            width: 90%;
            height: 50%;
            margin-top: 8%;
            margin-left: 5%;
            line-height: 26px;
            font-size: 12px;

        }
        .myscroll li {
            margin-left: 0px;
        }

        .myscroll a {
            color: white;
            text-decoration: none;
        }

        .myscroll a:hover {
            color: #ED5565;
            text-decoration: underline;
        }
        
        .modal-body {
		    padding: 12px;
		}
		
		#beingBroadcastDetail{
			margin-top: 2px;
		}

        table {
            table-layout: fixed;
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        
        /* 移动端样式 */
        @media screen and (max-width: 480px) {
			body {
				background-attachment:fixed!important;
			}
            .head {
				height: 50px;
            	background: rgba(49, 110, 164, 1);
            	position: fixed;
				z-index: 1001;
            }
            .head .headlogo {
			    height: 50px;
			    text-align: left;
			    line-height: 50px;
			    padding-left: 1%;
			}
            .head .headlogo img {
            	width: 70px;
				height: 30px;
				margin: 0 0;
            }
            .head .headlogo h1 {
            	padding-left: 15px;
            	margin: 0 0;
            	line-height: 50px;
                font-size: 20px;
            }
            .head .headnav {
                width: 100%;
                margin: 0 0;
                padding: 5px 0 5px 0;
                position: fixed;
                left: 0;
                bottom: 0;
                border-top: 2px solid rgb(65, 142, 190);
                z-index: 1001;
                display: flex;
                justify-content: space-around; 
                background: rgba(65, 142, 180, 1);
            }
            .headnav.headnav li {
                margin: 0 0;
			    width: 60px;
			    line-height: 80px;
            }
            .head .headnav li a {
                width: auto;
                font-size: 12px;
                height: 45px;
                background-position-y: 10px!important;
            }
            .head .headlink {
            	width: auto!important;
            	margin: 5px 0;
            	display: inline-block!important;
            }
            .head .headlink li {
            	width: 50px;
            	height: 50px;
            }
            .head .headlink li a {
            	font-size: 10px;
            }
            #footer { 
                clear: both; 
            }
            .slide{
                display: none;
            }
            
            .webbody {
            	padding-top: 50px;
            	padding-bottom: 60px;
            }
            .leftmenu {
				width: 100%;
				height: auto!important;
                top: 0;
                left: 0;
                padding: 0px 5px;
                margin-top: 8px;
                overflow: unset;
                position: relative;
                background: rgba(0, 0, 0, 0)!important;
            }
            .leftmenu .leftmenu_0:nth-child(2) {
            	display: none;
            }
            
            .left {
                width: 100%;
            }
            .left_home1 {
                height: 100px!important;
                margin: 0 0;
            }
            .left_home1 .myscroll {
                margin-top: 0;
            }
            .left_home2 {
                display: none;
            }
            .leftmenu_0 {
            	overflow-x: scroll;
				white-space: nowrap;
            }
            .leftmenu_0 dl {
			    width: auto;
			    padding: 2px 5px;
			    margin: 0 0;
			    display: inline-block;
			}
			.leftmenu_0 dl dt {
				display: flex;
				justify-content:space-between; 
				align-items: center;
				text-indent: 0px;
				font-size: 10px;
			}
            .leftmenu_0 dl dt img {
            	height: 20px;
            	margin-left: 4px;
            }
			.leftmenu_0 dl dt a {
				height: 33px;
				line-height: 33px;
				width: auto;
				margin-left: 0px;
				margin-right: 4px;
				font-size: 12px;
			}
			
			.rightmain {
                width: 100%;
                height: auto;
                top: 0px;
                left: 0;
                padding: 5px 5px;
                overflow: unset;
                position: relative;
            }
			.rightmain .rightcontent {
			    height: auto;
			    padding: 0 0;
                overflow: unset;
			}
			#infoModal .form-group div {
				display: inline-block;
			}
        }
    </style>
</head>
<body>
<%-- <video autoplay loop="loop">
<source src="${ctx}/static/video/video.mp4" type="video/mp4">
</video>  --%>

<div class="head">
    <div class="headlogo pull-left" style="display: inline-block;">
        <img src="${ctx}/static/img/picture/logo1.png" style="display:inline-block">
        <h1>
            <a href="javascript:;">${config.web_title}</a>
        </h1>

    </div>
    <ul class="headnav pull-left">
        <li class="menu_0 current_menu"><a href="javascript:;"
                                           _link="${ctx}/main">平台首页</a></li>

        <c:forEach var="menu" items="${sessionScope.userMenu}" varStatus="status">
            <li class="menu_${status.index+1}">
                <a href="javascript:;" _link="${ctx}/${menu.menuPath}">${menu.menuName}</a>
            </li>
        </c:forEach>
        <span class="slide"></span>
    </ul>
    
    <ul class="headlink pull-right"
        style="width: 12%; display: inline-block;">
        <li class="link_0"><a href="javascript:;">${sessionScope.currentUser.fUsername}</a></li>
        <!-- <li class="link_1"><a href="javascript:;"><span class="ton">隐藏菜单</span></a></li> -->
        <!-- <li class="link_2"><a href="javascript:;">首页</a></li>
    <li class="link_3"><a href="javascript:;">帮助</a></li> -->
        <li class="link_4" onclick="javascript:document.getElementById('logout').click()">
            <a id="logout" href="${ctx}/account/logout">退出</a></li>
    </ul>
    <div id="footer"></div>
</div>
<!-- 头部页面结束 -->
<div class="webbody">
<div class="leftmenu">
    <div class="leftmenu_0">
        <div class="left_home1" style="height: 52%;">

            <ul>
                <li id="left_home1_beingBroadcastli"><b>正在播出信息</b></li>
            </ul>
            <div class="myscrollDiv">
                <div class="myscroll"
                     style="background-color:none;  white-space:nowrap; overflow: hidden; text-overflow:ellipsis;">
                    <ul id="beingBroadcastDetail" style="list-style:disc;">

                    </ul>
                </div>
            </div>
        </div>
        <div class="left_home2" style="height: 43%;">
            <ul>
                <li><b>终端信息统计</b></li>
                <div id="workingInfo" style="height: 100%;"></div>
            </ul>
        </div>
    </div>
    <!-- leftmenu_0 平台首页结束 -->
    <c:forEach var="menu" items="${sessionScope.userMenu}"
               varStatus="status">
        <div class="leftmenu_0 hidden">
            <c:forEach var="subMenu" items="${menu.children}">
                <c:choose>
                    <c:when test="${subMenu.children!=null}">
                        <dl>
                            <dt class="dropdown">
                                <c:if
                                        test="${subMenu.menuIco != null && subMenu.menuIco != ''}">
                                    <img src="${ctx}/static/${subMenu.menuIco}"/>
                                </c:if>
                                &nbsp;${subMenu.menuName}<span></span>
                            </dt>
                            <dd>
                                <ul class="clearfix">
                                    <span></span>
                                    <c:forEach var="grandMenu" items="${subMenu.children}">
                                        <li><a href="javascript:;"
                                               _link="${ctx}/${grandMenu.menuPath}">${grandMenu.menuName}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </dd>
                        </dl>
                    </c:when>
                    <c:otherwise>
                        <dl>
                            <dt>
                                <c:if
                                        test="${subMenu.menuIco != null && subMenu.menuIco != ''}">
                                    <img src="${ctx}/static/${subMenu.menuIco}"/>
                                </c:if>
                                &nbsp;<a href="javascript:;" _link="${ctx}/${subMenu.menuPath}">${subMenu.menuName}</a>
                            </dt>
                        </dl>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </c:forEach>
</div>
<!-- 左边导航结束 -->
<div class="rightmain" id="rightmain">
    <div class="rightcontent">
        <iframe src="${ctx}/main" id="main" name="main" frameborder="0"
                scrolling="auto" allowtransparency="true"></iframe>
    </div>
</div>
</div>
<!-- 详情模态框（Modal） -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="roleForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">详情</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">广播ID:</label>
                        <div class="col-sm-8">
                            <span id="fId"></span>
                        </div>
                    </div>
                    
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

              <!--       <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">播发去向:</label>
                        <div class="col-sm-8">
                            <span id="fRealBroadcastTo"></span>
                        </div>
                    </div> -->
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2 control-label">播发区域:</label>
                        <div class="col-sm-10">
                            <span id="fRealArea"></span>
                        </div>
                    </div>
                </div>
                <div class="modal-footer ">
                    <button type="button" id="stopPlay"  class="endBroadcastBtn btn btn-danger">停播</button>
                    <button type="button" id="beingBroadcastDetail_btn" class="btn btn-info" data-dismiss="modal">关闭</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<%@include file="common/js.jsp" %>

<script src="${ctx}/static/js/banner.js"></script>

<script type="text/javascript">
    var beingDetails;
    var fId1;
    var broadcastTo1;

    $(function () {
    	$(".modal-dialog").draggable();
      /*  $(".menu_1").children('a').attr("_link", "${ctx}/broadcast/emergency");
        $(".menu_2").children('a').attr("_link", "${ctx}/shenhe/shenheHandle");
        $(".menu_3").children('a').attr("_link", "${ctx}/monitor/terminalStatus");
        $(".menu_4").children('a').attr("_link", "${ctx}/effectEvaluate/statisticalTable");
        $(".menu_5").children('a').attr("_link", "${ctx}/resourceManage/region");
        $(".menu_6").children('a').attr("_link", "${ctx}/systemManage/systemConfigure");*/
        $('.myscroll').myScroll({
            speed: 40, //数值越大，速度越慢
            rowHeight: 26
            //li的高度
        });
    });
    
    //TODO 停播  2019/02/25 lxg  请求参数  fId  之后可能需要  广播类型  与ip指令 类似
    $("#stopPlay").click(function () {
         $.ajax({
			async:false,
			data:{"fId":fId1},
			url:"${ctx}/broadcast/emergency/stopPlay",
			type:"post",
			success:function(data){
                //alert("success");
			},
			error:function(data){
                //alert("error");
			}
		}) 
    });

$(".headnav.pull-left li").click(function(){
    let index=$(this).index();
    let link=$(".leftmenu_0").eq(index).find("dl").eq(0).find("a").attr("_link");
    $("#main").attr("src",link);
    //alert(link);
});

    $("#beingBroadcastDetailLi").on("click", function () {
        alert($(this).val());
    });


    //点击正在播发队列中的某条记录，显示该记录的详情信息
    function js_method(fId) {
        $.getJSON('${ctx}/selectBeingBroadcastInfo/' + fId, function (result) {
            var ii = layer.load(2);
            if (result.status === 200) {
                layer.close(ii);
                var data = result.data;
                if (data) {
                	$('#fId').text(data.fId);
                   
                	fId1=data.fId;
                	//broadcastTo1=data.fBroadcastTo;
                	//alert(broadcastTo1);
                    //$('#fControlDevice').text(data.fControlDevice);
                    $('#fCreateTime').text(new Date(data.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                    //$('#fUpdtateTime').text(new Date(data.fUpdtateTime).format('yyyy-MM-dd HH:mm:ss'));

                    if (data.fUpdtateTime != null) {
                        $('#fUpdtateTime').text(new Date(data.fUpdtateTime).format('yyyy-MM-dd HH:mm:ss'));
                    } else {
                        $('#fUpdtateTime').text("");
                    }

                    if (data.fRealMessageSource != null) {
                        $('#fRealMessageSource').text(data.fRealMessageSource);
                    } else {
                        $('#fRealMessageSource').text("");
                    }

                    if (data.fRealControlDevice != null) {
                        $('#fRealControlDevice').text(data.fRealControlDevice);
                    } else {
                        $('#fRealControlDevice').text("");
                    }
                    
              /*       if (data.fRealBroadcastTo != null) {
                        $('#fRealBroadcastTo').text(data.fRealBroadcastTo);
                    } else {
                        $('#fRealBroadcastTo').text("");
                    } */

                     if(data.fBroadcastType==1){
	                	$('#fBroadcastType').text("发布系统演练");
	                 }else if(data.fBroadcastType==2){
	                	$('#fBroadcastType').text("模拟演练");
	                 }else if(data.fBroadcastType==3){
	                	$('#fBroadcastType').text("实际演练");
	                 } else if(data.fBroadcastType==4){
	                	$('#fBroadcastType').text("应急广播");
	                 }else if(data.fBroadcastType==5){
	                	$('#fBroadcastType').text("日常广播");
	                 }else if(data.fBroadcastType==6){
	                	$('#fBroadcastType').text("升级广播");
	                 }else if(data.fBroadcastType==7){
	                	$('#fBroadcastType').text("广播预案-应急广播");
	                 }else if(data.fBroadcastType==8){
	                	$('#fBroadcastType').text("广播预案-日常广播");
	                 }else if(data.fBroadcastType==9){
	                	$('#fBroadcastType').text("广播预案-实际演练");
	                 }else if(data.fBroadcastType==10){
	                	$('#fBroadcastType').text("广播预案-系统演练");
	                 }else if(data.fBroadcastType==11){
	                	$('#fBroadcastType').text("广播预案-模拟演练");
	                 }else if(data.fBroadcastType==12){
	                	$('#fBroadcastType').text("定时广播");
	                 }
                    $('#fRealArea').text(data.fRealArea);
                    $('#creator').text(data.creator);
                    $('#operator').text(data.operator);
                    $('#fRealMessageLevel').text(data.fRealMessageLevel);
                    $('#fRealMessageType').text(data.fRealMessageType);
                    $('#fVolumeControl').text(data.fVolumeControl);
                    parent.$('#infoModal').modal('show');
                }
            } else {
                layer.msg(result.msg, {icon: 2});
            }

        });
    }


</script>
<script type="text/javascript">


    //JavaScript Document
    (function ($) {
        $.fn.myScroll = function (options) {
            //默认配置
            var defaults = {
                speed: 40, //滚动速度,值越大速度越慢
                rowHeight: 24
                //每行的高度
            };

            var opts = $.extend({}, defaults, options), intId = [];

            function marquee(obj, step) {

                obj.find("ul").animate({
                    marginTop: '-=1'
                }, 0, function () {
                    var s = Math.abs(parseInt($(this).css("margin-top")));
                    if (s >= step) {
                        $(this).find("li").slice(0, 1).appendTo($(this));
                        $(this).css("margin-top", 0);
                    }
                });
            }

            this.each(function (i) {
                var sh = opts["rowHeight"], speed = opts["speed"], _this = $(this);
                intId[i] = setInterval(
                    function () {
                        if (_this.find("ul").height() <= _this
                            .height()) {
                            clearInterval(intId[i]);
                        } else {
                            marquee(_this, sh);
                        }
                    }, speed);

                _this.hover(function () {
                    clearInterval(intId[i]);
                }, function () {
                    intId[i] = setInterval(function () {
                        if (_this.find("ul").height() <= _this
                            .height()) {
                            clearInterval(intId[i]);
                        } else {
                            marquee(_this, sh);
                        }
                    }, speed);
                });
            });
        }
    })(jQuery);

    echarts.init(document.getElementById('workingInfo')).setOption({
        legend: {
            // orient: 'vertical',
            top: 10,
            type: 'scroll',
            left: 'center',
            textStyle: {
                color: '#ffffff',
                fontSize: 10,
            },
        },
        tooltip : {
            trigger: 'item',
            //formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: {
            type: 'pie',
            radius: '60%',
            center: ['50%', '50%'],
            orient: 'vertical',
            left: 'left',
            label: {
                normal: {
                    show: true,                   
                    position: 'outside',
                    formatter: '{b}:{c}',
                    //模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。
                    //{d}数据会根据value值计算百分比
                    textStyle: {
                        align: 'center',
                        baseline: 'middle',
                        color: 'white',
                    }
                }
            }, 
            data: [{
               name: '广播',
               value: ${broadcasting_device},
            },{
               name: '在线',
               value: ${online_device},
            },{
               name: '离线',
               value: ${discon_device},
            },{
               name: '故障',
               value: ${malfunction_device}+${powerOutage},               
            }],
            itemStyle: {
                normal: {
                    label: {
                        show: true
                        //隐藏标示文字
                    },
                    labelLine: {
                        show: true
                        //隐藏标示线
                    },
                    color:function(params) {
                        //自定义颜色
                        var colorList = [
                            'blue','green','gray','red'
                        ];
                        return colorList[params.dataIndex];
                    }
                }
            }
        }
    });
</script>
<script type="text/javascript">
    //导航经过改变宽度和颜色
    $(".headnav li").click(
        function () {
            var index = $(this).index();
            if(index==0){
                $(".leftmenu").css("background","rgba(0, 0, 0, 0)");
            }else{
                $(".leftmenu").css("background","rgba(0, 0, 0, 0.4)");
            }
            $(this).addClass("current_menu").siblings().removeClass(
                'current_menu');
            //头部导航和左边导航对应
            $(".leftmenu").find(".leftmenu_0").eq(index).removeClass(
                "hidden").siblings().addClass('hidden');
            $(".leftmenu").find(".leftmenu_0").eq(index).find("dt")
                .removeClass("selected").eq(0).addClass("selected");
        });
    //左边导航点击上拉
    $(".leftmenu dl dt").click(function () {
        $(this).siblings('dd').slideToggle('fast').siblings('dt').end;//.end()
    });

    $("#stopPlay").click(function(){
        $("#infoModal").modal("hide");
    })

    var timer=setInterval(function () {
        $("#beingBroadcastDetail li").remove();
        $.getJSON('${ctx}/selectBeingBroadCast', function (result) {
            if (result.status === 200) {
                if (result.data != null&&result.data!="") {
                    beingDetails = result.data;
                    for (var i = 0; i < result.data.length; i++) {
                        var realType;
                        if (result.data[i].fBroadcastType == 1) {
                            realType= "系统演练";
                        } else if (result.data[i].fBroadcastType == 2) {
                            realType= "模拟演练";
                        } else if (result.data[i].fBroadcastType == 3) {
                            realType= "实际演练";
                        } else if (result.data[i].fBroadcastType == 4) {
                            realType= "应急广播";
                        } else if (result.data[i].fBroadcastType == 5) {
                            realType= "日常广播";
                        } else if (result.data[i].fBroadcastType == 6) {
                            realType= "升级广播";
                        } else if (row.fBroadcastType == 7) {
                            realType= "广播预案-应急广播";
                        } else if (result.data[i].fBroadcastType == 8) {
                            realType= "广播预案-日常广播";
                        } else if (result.data[i].fBroadcastType == 9) {
                            realType= "广播预案-实际演练";
                        } else if (result.data[i].fBroadcastType == 10) {
                            realType= "广播预案-系统演练";
                        } else if (result.data[i].fBroadcastType == 11) {
                            realType= "广播预案-模拟演练";
                        } else if (row.fBroadcastType == 12) {
                            realType= "定时广播";
                        }
                        $("#beingBroadcastDetail").append(
                            '<li id="beingBroadcastDetailLi" style="list-style-type:disc;">' +
                            '<a href="javascript:;" onclick="js_method(' + result.data[i].fId + ')" >' + '*' + result.data[i].fId+":"+realType + '在' + result.data[i].fRealArea + '正在播发' +
                            '</a>' +
                            '</li>');
                    }
                } else {
                    $("#beingBroadcastDetail").append("<li>没有正在播发的广播</li>");
                }
            }
        });
    },3000)
</script>
</body>
</html>