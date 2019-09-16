<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ page import="cn.wtu.broadcast.config.SystemConfig"%>
<%@ page import="cn.wtu.broadcast.config.RegionData"%>
<%@ page import="cn.wtu.broadcast.config.DeviceData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
    request.setAttribute("deviceList", DeviceData.getUserZTreeList2Json());

%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>图文发布</title>
<%@include file="../common/css.jsp"%>
<style>
.col-sm-7 {
	padding-left: 5px;
}

.modal-body {
	padding-top: 15px;
}

.form-group {
	padding-right: 1% !important;
}

.tab_modal {
	height: 0
}

#infoModal .modal-dialog {
	overflow-y: scroll
}

table td {
	vertical-align: middle !important;
}

#ztree1 {
	height: 275px;
	overflow-y: scroll;
}

#ztree1::-webkit-scrollbar {
	display: none;
}

#imgTextTerminal_modal input {
	width: 80% !important
}

#zimu_modal .form-group, #video_modal .form-group,
	#imgTextTerminal_modal .form-group {
	margin: 4% 0;
}

#imageAd_modal .form-group {
	margin: 2% 0;
}

.modal-footer {
	padding-top: 20px;
}

table {
	table-layout: fixed;
}

table tbody tr td {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

#table_content {
	padding: 1% 1.5%;
	margin-top: 1.5%;
	border: 1px solid #FFFFFF;
	border-radius: 10px;
}
</style>
</head>
<body>
	<h4>
		<b>当前位置:制作播发>>图文发布</b>
	</h4>
	<div class="tab_driver">
		<ul class="nav nav-tabs">
			<li id="zimu" class="selected_tab"><a>滚动字幕</a></li>
			<li id="picture"><a>图片广告</a></li>
			<li id="video"><a>视频管理</a></li>
			<li id="Terminal"><a>图文终端</a></li>
		</ul>
	</div>
	<!--
作者：m18871941615@163.com
时间：2018-12-03
描述：滚动字幕
-->
	<div id="table_content">
		<div class="tab_modal show">
			<div class="handle">
				<button class="btn_add_zimu btn btn-info">新增</button>
				<button class="btn_update_zimu btn btn-info">修改</button>
				<button onclick="deleteform('deleteZimu')" class="btn btn-danger">删除</button>
			</div>
		</div>
		<div class="tab_modal">
			<div class="handle">
				<button class="btn_add_image btn btn-info">新增</button>
				<button class="btn_update_image btn btn-info">修改</button>
				<button class="btn btn-danger" onclick="deleteform('deletePicture')">删除</button>
			</div>
		</div>
		<div class="tab_modal">
			<div class="handle">
				<button class="btn_add_video btn btn-info">新增</button>
				<button class="btn_update_video btn btn-info">修改</button>
				<button class="btn btn-danger" onclick="deleteform('deleteVideo')">删除</button>
			</div>
		</div>
		<div class="tab_modal">
			<div class="handle">
				<button class="btn_add_imgTextTerminal btn btn-info">新增</button>
				<button class="btn_update_imgTextTerminal btn btn-info">修改</button>
				<button class="btn btn-danger"
					onclick="deleteform('deleteimgTextTerminal')">删除</button>
			</div>
		</div>
		<table data-height="430" id="showtable" class="table table-hover"></table>
	</div>
	<!-- 字幕模态框（Modal） -->
	<div class="modal fade" id="zimu_modal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增</h4>
				</div>
				<div class="modal-body col-sm-12">
					<div class="modal-body-right col-sm-5 pull-right">
						<label>终端选择</label>
						<ul id="ztree1" class="ztree"></ul>
					</div>
					<form id="form_zimu" class="form-inline">
						<div class="height modal-body-left col-sm-7 pull-left">
							<div class="title form-group col-sm-12">
								<label class="col-sm-4 control-label">字幕标题</label>
								<div class="col-sm-8">
									<input name="fTitle" id="check_zimu" type="text"
										class="form-control">
									<!-- onKeyUp="confirm_zimu($(this),'checkZimu')" class="form-control"> -->
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">字幕内容</label>
								<div class="col-sm-8">
									<textarea name="fRemark" class="form-control"
										style="resize: none;"></textarea>
								</div>
							</div>
							<div class="null"></div>
						</div>
						<div class="null"></div>
					</form>
					<div class="null"></div>
				</div>
				<div class="modal-footer">
					<button id="submit_zimu" type="button" class="btn btn-info">确定</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


	<!--
      	作者：m18871941615@163.com
      	时间：2018-12-04
      	描述：图片模态框
      -->
	<div class="modal fade" id="imageAd_modal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增</h4>
				</div>
				<div class="modal-body col-sm-12">
					<div class="modal-body-left col-sm-5 pull-right">
						<label>终端选择</label>
						<ul class="ztree"></ul>
					</div>
					<form id="form_image" class="form-inline">
						<div class="modal-body-right col-sm-7 pull-left">
							<div class="title form-group col-sm-12">
								<label class="col-sm-4 control-label">图片名称</label>
								<div class="col-sm-8">
									<input name="fImageName" id="check_Picture" type="text"
										class="form-control">
									<!--  onKeyUp="confirm_zimu($(this),'checkPicture')" type="text" class="form-control"> -->
								</div>
							</div>
							<div class="form-group" style="width: 100%; position: relative;">
								<label class="col-sm-4 control-label">图片内容</label>
								<div class="col-sm-4 control-label">
									<input id="image_file" name="pic" type="file" title="请选择图片"
										accept="image/*" /> <input style="display: none" type="text"
										name="fAddress">
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">滚动间隔(s)</label>
								<div class="col-sm-8">
									<input name="fRollInterval" type="text" class="form-control">
								</div>
							</div>
							<div class="null"></div>
						</div>
						<div class="null"></div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="submit_image" type="button" class="btn btn-info">确定</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


	<!--
      	作者：m18871941615@163.com
      	时间：2018-12-05
      	描述：视频模态框
     -->
	<div class="modal fade" id="video_modal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增</h4>
				</div>
				<div class="modal-body col-sm-12">
					<div class="modal-body-left col-sm-5 pull-right">
						<label>终端选择</label>
						<ul class="ztree"></ul>
					</div>
					<form id="form_video" class="form-inline">
						<div class="modal-body-right col-sm-7 pull-left">
							<div class="title form-group col-sm-12">
								<label class="col-sm-4 control-label">视频名称</label>
								<div class="col-sm-8">
									<input name="fVideoName" id="check_Video" type="text"
										class="form-control">
									<!--  onKeyUp="confirm_zimu($(this),'checkVideo')" class="form-control"> -->
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">视频</label>
								<div class="col-sm-4 control-label">
									<input id="video_file" name="video" type="file" title="请选择视频"
										accept="video/*" /> <input style="display: none" type="text"
										name="fAddress">
								</div>
							</div>
						</div>
					</form>
					<div class="null"></div>
				</div>
				<div class="modal-footer">
					<button id="submit_video" type="button" class="btn btn-info">确定</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


	<!--
      	作者：m18871941615@163.com
      	时间：2018-12-05
      	描述：终端模态框
      -->
	<div class="modal fade" id="imgTextTerminal_modal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增</h4>
				</div>
				<div class="modal-body col-sm-12">
					<div class="modal-body-left col-sm-5 pull-right">
						<label>安装区域</label>
						<ul class="ztree"></ul>
					</div>
					<form id="form_imgTextTerminal" class="form-inline">
						<div class="modal-body-right col-sm-7 pull-left">
							<div class="title form-group col-sm-12">
								<label class="col-sm-4 control-label">终端名称</label>
								<div class="col-sm-8">
									<input name="fTerminalName" type="text" id="check_TextTerminal"
										class="form-control ">
									<!-- onKeyUp="confirm_zimu($(this),'checkTextTerminal')" class="form-control "> -->
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">MAC</label>
								<div class="col-sm-8">
									<input name="fMac" onKeyUp="confirm($(this))" type="text"
										class="form-control ">
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">资源编码</label>
								<div class="col-sm-8">
									<input name="fResourceCode" type="text" class="form-control ">
								</div>
							</div>
							<div class="form-group col-sm-12">
								<label class="col-sm-4 control-label">设备类型</label>
								<div class="col-sm-8">
									<select name="fDeviceType" class="form-control"
										style="width: 80% !important">
										<option value="0">字幕设备</option>
										<option value="1">图片设备</option>
										<option value="2">视频设备</option>
									</select>
								</div>
							</div>
							<div class="null"></div>
						</div>
						<div class="null"></div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="submit_Terminal" type="button" class="btn btn-info">确定</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 详情模态框（Modal） -->
	<div class="modal fade" id="infoModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">详情</h4>
					</div>
					<div class="modal-body">
						<div class="form-group col-sm-12">
							<label class="col-sm-2 control-label">标题:</label>
							<div class="col-sm-8">
								<span id="fContent"></span>
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
						<div class="form-group col-sm-6" id="ZimuContentDiv">
							<label class="col-sm-4 control-label">字幕内容:</label>
							<div class="col-sm-8">
								<span id="fZimuContent"></span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label">终端设备:</label>
							<div class="col-sm-8">
								<span id="fZimuDevice"></span>
							</div>
						</div>
						<div class="null"></div>
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
	<div class="modal fade" id="infoModal_tem" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">详情</h4>
					</div>
					<div class="modal-body">
						<div class="form-group col-sm-12">
							<label class="col-sm-2 control-label">终端名称:</label>
							<div class="col-sm-8">
								<span id="fTerminalName"></span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label">资源编码:</label>
							<div class="col-sm-8">
								<span id="fResourceCode"></span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label">设备类型:</label>
							<div class="col-sm-8">
								<span id="fDeviceType"></span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label">MAC:</label>
							<div class="col-sm-8">
								<span id="fMac"></span>
							</div>
						</div>						
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label">安装区域:</label>
							<div class="col-sm-8">
								<span id="fBroadcastArea"></span>
							</div>
						</div>
						<div class="null"></div>
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
	<div class="modal fade" id="previewImg" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">预览</h4>
					</div>
					<div class="modal-body">
						<div class="form-group col-sm-12"  align="center">
							<img id='imgForPreview' width='400px' height='400px'>
						</div>						
						<div class="null"></div>
					</div>
					<div class="modal-footer ">
						<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
					</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>	

<!-- 详情模态框（Modal） -->
	<div class="modal fade" id="previewVidio" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">预览</h4>
					</div>
					<div class="modal-body">
						<div class="form-group col-sm-12" align="center">
						<video id="vidioForPreview" controls preload="auto" width="500px" height="400px">
							<source type="video/mp4">
							</video>							
						</div>						
						<div class="null"></div>
					</div>
					<div class="modal-footer ">
						<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
					</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>	
	
	
	<%@include file="../common/js.jsp"%>
	<script>
    var fileUrl='';
    /**
     * 一下为check 添加是是否重复
     */
    /* $("#check_zimu").on("focus", function () {
        confirm_zimu($("#check_zimu"), "checkZimu");
    })
 */
    function confirm_zimu(e, url) {
        var result = false;
        var title = e.val();
        if (title != null && title != "") {
            $.ajax({
                url: "${ctx}/broadcast/graphicRelease/" + url,
                type: "post",
                async: false,
                dataType: "json",
                data: {
                    title: title,
                },
                success: function (data) {
                    if (data.status == 400) {
                        layer.tips(data.msg, e, {
                            tips: [2, 'red'],
                            tipsMore: true,
                            time: 800
                        });
                        result = true;
                    } else {
                        result = false;
                    }
                },
            })
            return result;
        }
    }
    var deviceList = '';    
    $('#zimu').on("click", function () {
        $('.ztree').removeAttr("id");
        $('#zimu_modal .ztree').attr("id", "ztree1");
        $.ajax({
            async: false,
            data: null,
            url: "${ctx}/deviceData/getUserZTreeList2Json",
            type: "post",
            success: function (data) {            	
            	var str = JSON.parse(data);            	
            	ztreeHeight();
            	refreshTreeOfDivice(str);
            }
        })
        $('#showtable').bootstrapTable('refreshOptions', {
            url: "${ctx}/broadcast/graphicRelease/selectZimu",
            columns: columns_zimu,
        })        
    })
    $('#picture').on("click", function () {
        $('.ztree').removeAttr("id");
        $('#imageAd_modal .ztree').attr("id", "ztree1");
        $.ajax({
            async: false,
            data: null,
            url: "${ctx}/deviceData/getUserZTreeList2Json",
            type: "post",
            success: function (data) {            	
            	$.ajax({
                    async: false,
                    data: null,
                    url: "${ctx}/deviceData/getUserZTreeList2Json",
                    type: "post",
                    success: function (data) {                    	
                    	var str = JSON.parse(data);                    	
                    	ztreeHeight();
                    	refreshTreeOfDivice(str);
                    }
                })
            }
        })     
        $('#showtable').bootstrapTable('refreshOptions', {
            url: "${ctx}/broadcast/graphicRelease/selectPicture",
            columns: columns_mageAd,
        })
    })
    $('#video').on("click", function () {
        $('.ztree').removeAttr("id");
        $('#video_modal .ztree').attr("id", "ztree1");
        $.ajax({
            async: false,
            data: null,
            url: "${ctx}/deviceData/getUserZTreeList2Json",
            type: "post",
            success: function (data) {
            	
            	$.ajax({
                    async: false,
                    data: null,
                    url: "${ctx}/deviceData/getUserZTreeList2Json",
                    type: "post",
                    success: function (data) {
                    	
                    	var str = JSON.parse(data);                    	
                    	ztreeHeight();
                    	refreshTreeOfDivice(str);
                    }
                })
            }
        })     
        $('#showtable').bootstrapTable('refreshOptions', {
            url: "${ctx}/broadcast/graphicRelease/selectVideo",
            columns: columns_video,
        })
    })
    $('#Terminal').on("click", function () {
        $('.ztree').removeAttr("id");
        $('#imgTextTerminal_modal .ztree').attr("id", "ztree1");
        refreshTree();
        $('#showtable').bootstrapTable('refreshOptions', {
            url: "${ctx}/broadcast/graphicRelease/selectimgTextTerminal",
            columns: columns_imgTextTerminal,
        })
    })
    $('.btn_add_zimu').on("click", function () {
        $('#zimu_modal h4').text("新增");
        $('#zimu_modal').modal();
        $('#submit_zimu').addClass("add_zimu").removeClass("update_zimu");
    })
    $(".modal-footer").on("click", ".add_zimu", function () {
        if (!confirm_zimu($("#check_zimu"), "checkZimu")) {
             $("#zimu_modal input[name='fAddress']").val(fileUrl); 
                applyform("#form_zimu", "addZimu", "#zimu_modal", "#showtable", "新增字幕", "");
        }
    })
    $(".btn_update_zimu").on("click", function () {
    	 $('#submit_zimu').removeClass("add_zimu").addClass("update_zimu");
        updateform('#zimu_modal', ".update_zimu", "#form_zimu", "updateZimu", "#showtable", "修改字幕",null, null);
    })
    $('.btn_add_image').on("click", function () {
        $('#submit_image').addClass("add_image").removeClass("update_image");
        $('#imageAd_modal').modal();
    })
    $('.modal-footer').on("click", ".add_image", function () {
        if (!confirm_zimu($("#check_Picture"), "checkPicture")) {
            $("#imageAd_modal input[name='fAddress']").val(fileUrl);
            if(checkFile("image_file")){
                applyform("#form_image", "addPicture", "#imageAd_modal", "#showtable", "上传图片");
            }

        }

    })
    $(".btn_update_image").on("click", function () {
        $('#submit_image').removeClass("add_image").addClass("update_image");
        updateform('#imageAd_modal', ".update_image", "#form_image", "updatePicture", "#showtable", "修改图片",null, null)
    })
    $(".btn_add_video").on("click", function () {
        $('#submit_video').addClass("add_video").removeClass("update_video");
        $('#video_modal').modal();
    })
    $('.modal-footer').on("click", ".add_video", function () {
        if (!confirm_zimu($("#check_Video"), "checkVideo")) {
            $("#video_modal input[name='fAddress']").val(fileUrl);
            if(checkFile("video_file")){
                applyform("#form_video", "addvideo", "#video_modal", "#showtable", "上传视频");
            }

        }

    })
    $(".btn_update_video").on("click", function () {
        $('#submit_video').removeClass("add_video").addClass("update_video");
        updateform('#video_modal', ".update_video", "#form_video", "updateVideo", "#showtable", "修改视频", null, null)
    })
    $('.btn_add_imgTextTerminal').on("click", function () {
        $('#submit_Terminal').removeClass("updateimgTextTerminal").addClass("addimgTextTerminal");
        $('#imgTextTerminal_modal').modal();
    })
    $(".modal-footer").on("click", ".addimgTextTerminal", function () {
        if (!confirm_zimu($("#check_TextTerminal"), "checkTextTerminal")) {
            applyform("#form_imgTextTerminal", "addimgTextTerminal", "#imgTextTerminal_modal", "#showtable", "新增终端");
        }
    })
    $(".btn_update_imgTextTerminal").on("click", function () {
        $('#submit_Terminal').addClass("updateimgTextTerminal").removeClass("addimgTextTerminal");
        updateform('#imgTextTerminal_modal', ".updateimgTextTerminal", "#form_imgTextTerminal", "updateimgTextTerminal", "#showtable", "修改终端", null, null);
    })

    function updateform(modal, btn, form, url, table, title, confirm, confirmUrl) {
        var checked = $('#showtable').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg("请选择要修改的记录", {icon: 2});
        } else if (checked.length > 1) {
            layer.msg("一次只能修改一条记录", {icon: 2});
        } else {
        	 var update_fId = checked[0].fId;
            $(modal + " " + "h4").text("修改");
            $(modal).modal();           
            $(btn).on("click",function () {
                if (confirm != null) {
                    if (!confirm_zimu(confirm, confirmUrl)) {
                        applyform(form, url + "?fId=" + update_fId, modal, table, title);
                    }
                } else {  
                    applyform(form, url + "?fId=" + update_fId, modal, table, title);
                }  
            })
        }
    }

    function deleteform(url) {
        var checked = $('#showtable').bootstrapTable('getSelections');
        var ids = "";
        if (checked.length == 0) {
            layer.msg("请选择要删除的记录", {icon: 2});
        } else {
            layer.confirm('是否确定删除这'+checked.length+'条记录？', {
                title: ['删除'],
                btn: ['确定', '取消'] //按钮
            }, function () {
                for (i = 0; i < checked.length; i++) {
                    ids += checked[i].fId + ",";
                }
                $.ajax({
                    async: false,
                    data: {
                        "fId": ids,
                    },
                    url: "${ctx}/broadcast/graphicRelease/" + url,
                    type: "post",
                    success: function (data) {
                        layer.msg(data.msg, {icon: 1});
                        $("#showtable").bootstrapTable('refresh');
                    }
                })
            }, function () {
            })

        }
    }

    function applyform(form, url, modal, table, title) {
        var flag = true;
        var inputs = $(form + " " + "input[type='text']");
        for (var i = 0; i < inputs.length; i++) {
            if ($(inputs[i]).is(':visible')) {
            	
            	var input = inputs[i].value;
            	
                if (!inputs[i].value) {
                    layer.tips('请填写完整', $(form + " " + "input[type='text']")[i], {
                        tips: [2, 'red'],
                        tipsMore: true
                    });
                    flag = false;
                }else{
                	$.ajax({
                   	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
                        type: 'post',
                        async: false,
                        data: {
                       	 "input":input,
                        },
                        success: function (data) {
                       	 
                       	 if(data.length != 0){
                       		 layer.tips('存在敏感字'+'\"'+data+'\"', $(form + " " + "input[type='text']")[i], {
                                    tips: [2, 'red'],
                                    tipsMore: true
                                });
                                flag = false;
                       	 }
                            
                        }
                   });
                        	
                }
            }                     
        }
        
	  if(url == "addZimu" || url.indexOf("updateZimu") != -1){
	        var inputTextArea = $(form + " " +"textarea[name='fRemark']");
	        var inputTextAreaValue = inputTextArea.val();
	    	$.ajax({
	          	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
	               type: 'post',
	               async: false,
	               data: {
	              	 "input":inputTextAreaValue,
	               },
	               success: function (data) {
	              	 
	              	 if(data.length != 0){
	              		 
	              		 layer.tips('存在敏感字'+ '\"' +data + '\"', $(form + " " +"textarea[name='fRemark']"), {
	                           tips: [2, 'red'],
	                           tipsMore: true
	                       });
	                       flag = false;
	              	 }
	                   
	               }
	          });      
	  } 
        let treeObj = $.fn.zTree.getZTreeObj("ztree1");
        let nodes=treeObj.getCheckedNodes(true);
        if (nodes.length==0){
            flag=false;
            layer.tips('请选择播发区域!','#ztree1', {
                tips: [4, 'red'],
                tipsMore: true
            })
        }
      
        if (flag) {
            layer.confirm("是否确定" + title + "？", {
                title: [title],
                btn: ['确定', '取消'] //按钮
            }, function () {
                var data = "";
                var nodes = $.fn.zTree.getZTreeObj("ztree1").getCheckedNodes(true);
                for (var i = 0; i < nodes.length; i++) {
                	 data += nodes[i].name  + ',';
                }
                data = data.substring(0,data.length-1);
               /*  $.each(nodes, function (i, item) {
                    data = data + item.id;
                    if (i < nodes.length - 1) {
                        data = data + ',';
                    }
                }); */
                $.ajax({
                    url: "${ctx}/broadcast/graphicRelease/" + url,
                    type: 'post',
                    async:false,
                    data: $(form).serialize() + "&resourceId=" + data,
                    success: function (data) {
                        layer.msg(data.msg, {
                            icon: 1
                        });
                        $(modal).modal('hide');
                        document.getElementById('form_zimu').reset();
                        document.getElementById('form_image').reset();
                        document.getElementById('form_video').reset();                       
                        document.getElementById('form_imgTextTerminal').reset();                       
                        $(table).bootstrapTable('refresh');
                        fileUrl='';
                    }
                });
            }, function () {
            })

        }
    }
    function checkFile(file_id) {
        let flag=true;
        let checkfile=document.getElementById(file_id).files[0];
        if (checkfile ==undefined) {
            layer.tips('文件不能为空!',
                '#'+file_id, {
                    tips: [1, 'red'],
                    tipsMore: true
                }
            );
            flag = false;
        }
        return flag;
    }
    function showContent(modal) {
        var checked = $('#showtable').bootstrapTable('getSelections');
        var name=checked[0].fBroadcastArea;
        var zTree_Menu = $.fn.zTree.getZTreeObj("ztree1");
        var nodes = zTree_Menu.transformToArray(zTree_Menu.getNodes());
        if (nodes.length>0) {
            for(var i=0;i<nodes.length;i++){
                if(name.indexOf(nodes[i].id) >= 0){
                    nodes[i].checked = true;
                    zTree_Menu.updateNode(nodes[i]);
                }
            }
        }
        var row = $('#showtable').bootstrapTable('getSelections');
        $(modal + " " + "input").parent().parent().css("display", "none");
        $(modal + " " + "input[name='fTitle']").val(row[0].fTitle);
        $(modal + " " + "input[name='fImageName']").val(row[0].fImageName);
        $(modal + " " + "input[name='fVideoName']").val(row[0].fVideoName);
        $(modal + " " + "input[name='fTerminalName']").val(row[0].fTerminalName);
        $(modal + " " + ".title").css("display", "block");
    }

    function confirm(e) {
        var va = e.val();
        var re = /^[A-F0-9]{2}(-[A-F0-9]{2}){5}$/;
        if (!re.test(va)) {
            layer.tips('请输入正确的mac地址',
                e, {
                    tips: [2, 'red'],
                    tipsMore: true,
                })
        }
    }

    /* $('#zimu_file').change(function () {
        upload("zimu_file",4);
    }); */
    $('#image_file').change(function () {
    	
        var imgFileValue = $("#image_file").val();     
        var flag = true;
        $.ajax({
          	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
               type: 'post',
               async: false,
               data: {
              	 "input":imgFileValue,
               },
               success: function (data) {
              	 
              	 if(data.length != 0){
              		 layer.tips('存在敏感字'+'\"'+data+'\"', $("#image_file"), {
                           tips: [2, 'red'],
                           tipsMore: true
                       });
                       flag = false;
              	 }
                   
               }
          });
        if(flag = true){
        	upload("image_file",1);
        }
    });
    $('#video_file').change(function () {
    	var vidioFileValue = $("#video_file").val(); 
    	var flag = true;
    	 $.ajax({
          	 url: "${ctx}/broadcast/graphicRelease/sensitiveWord",
               type: 'post',
               async: false,
               data: {
              	 "input":vidioFileValue,
               },
               success: function (data) {
              	 
              	 if(data.length != 0){
              		 layer.tips('存在敏感字'+'\"'+data+'\"', $("#video_file"), {
                           tips: [2, 'red'],
                           tipsMore: true
                       });
                       flag = false;
              	 }
                   
               }
          });
    	 if(flag = true){
        	upload("video_file",4);
    	 }
    });
    function upload(file_id,type){
        let form = new FormData();
        form.append("file", document.getElementById(file_id).files[0]);
        console.log("form:" + form)
        $.ajax({
            url: "${ctx}/common/upload?type=" + type,
            type: "post",
            data: form,
            async: false,
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
    }
    $('body').on('hidden.bs.modal', '.modal', function () {
        $('.modal input').val("");
        $('.modal .form-group').css("display", "block");
    });

    function resetValue() {
        $("input[class='jeinput']").val("");
    }

    //重置ztree
    function refreshTree() {
        var regionData = ${regionList};
        loadRegionTree("ztree1", regionData);
    }
    
    function refreshTreeOfDivice() {
        var deviceData = ${deviceList};
        //var deviceData = deviceList;
        loadRegionTree("ztree1", deviceData);
    }
    
    function refreshTreeOfDivice(deviceList) {
        //var deviceData = ${deviceList};
        var deviceData = deviceList;
        loadRegionTree("ztree1", deviceData);
    }

    function ztreeHeight() {
        $("#ztree1").css("height", "300px!important");
    }
    
    function showImg() {
        //var fileTag = document.getElementById('file');
       // fileTag.onchange = function () {
            var file = fileTag.files[0];
            var fileReader = new FileReader();
            fileReader.onloadend = function () {
                if (fileReader.readyState == fileReader.DONE) {
                    document.getElementById('imgForShow').setAttribute('src', fileReader.result);
                }
            };
            fileReader.readAsDataURL(file);
        //};
    };

</script>
	<script type="text/javascript">
    $(function () {
    	$.ajax({
            async: false,
            data: null,
            url: "${ctx}/deviceData/getUserZTreeList2Json",
            type: "post",
            success: function (data) {
            	
            	$.ajax({
                    async: false,
                    data: null,
                    url: "${ctx}/deviceData/getUserZTreeList2Json",
                    type: "post",
                    success: function (data) {
                    	
                    	var str = JSON.parse(data);                    	
                    	ztreeHeight();
                    	refreshTreeOfDivice(str);
                    }
                })

            }
        })     
        $('#showtable').bootstrapTable({
            method: 'post',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            sortable: true,
            search: true, //是否显示表格搜索
            columns: columns_zimu,
            classes: 'table-no-bordered',
            url: "${ctx}/broadcast/graphicRelease/selectZimu", // 请求后台的URL（*）
            toolbar: '#toolbarComputer', // 工具按钮用哪个容器
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）
            showRefresh: true, // 是否显示刷新按钮
            sidePagination: 'server',
            queryParamsType: "",
            clickToSelect: true,
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
                if (result.status === 200) {
                    //layer.close(ii);
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            },

        });
    });


    var columns_zimu = [
        [{
            checkbox: true
        }, {
            field: 'fId',
            title: 'fId',
            align: 'center',
            visible: false,
        }, {
            field: 'fTitle',
            title: '标题',
            width: '15%',
            align: 'left',
        },
        {
            field: 'fState',
            title: '状态',
            align: 'center',
            sortable: false,
            width: '15%',
            formatter: function (fState) {
                if (fState == "0") {
                    return '<span class="label label-default">&nbsp;已停止&nbsp;</span>';
                } else if (fState == "1") {
                    return '<span class="label label-warning">&nbsp;已发送&nbsp;</span>';
                } 
            }
        },{
            field: 'fCreateTime',
            title: '操作时间',
            align: 'center',
            sortable: true,
            width: '30%',
            formatter: function (time) {
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            },
        }, {
            field: 'creator',
            title: '操作者',
            align: 'center',
            width: '10%',
        }, {
            title: '操作',
            align: 'center',
            events: {
                'click .edit-base-btn': function (e, val, row) {
                    $.getJSON('${ctx}/broadcast/graphicRelease/selectZimu/' + row.fId, function (result) {
                        var ii = layer.load(2);
                        if (result.status === 200) {
                            layer.close(ii);
                            var data = result.data;
                            if (data) {
                                $('#fContent').text(data.fTitle);
                                $('#fZimuContent').text(data.fRemark?data.fRemark:"");
                                $('#fAddress').text(data.fAddress);
                                $('#fStartDate').text(new Date(data.fStartDate).format('yyyy-MM-dd'));
                                $('#fEndDate').text(new Date(data.fEndDate).format('yyyy-MM-dd'));
                                $('#fStartTime').text(new Date(data.fStartTime).format('HH:mm:ss'));
                                $('#fEndTime').text(new Date(data.fEndTime).format('HH:mm:ss'));
                                $('#fCreateTime').text(new Date(data.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                                $('#fUpdtateTime').text(data.fUpdateTime?new Date(data.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'):"");
                                $('#fRealArea').text(data.fRealArea);
                                $('#creator').text(data.creator);                              
                                $('#operator').text(data.operator?data.operator:"");
                                $('#fZimuDevice').text(data.fDevice);
                                $('#infoModal').modal();
                            }
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    })
                },
				'click .start-btn': function (e, val, row) {
					
					$.getJSON('${ctx}/broadcast/graphicRelease/selectZimu/' + row.fId, function (result) {
                        var ii = layer.load(2);
                        if (result.status === 200) {  
                        	layer.close(ii);
                        	var data = result.data;
                                $.ajax({
                                    url: "${ctx}/broadcast/graphicRelease/textPlay.do",
                                    type: 'post',
                                    data: {
                                    	textName: data.fTitle,
                                    	textContent: data.fRemark,
			                            resourceCodes: data.fResourceCode,
			                            fid:data.fId
                                    },
                                    success: function (data) {
                                        if (data.status === 200) {
                                            $('#zimu').bootstrapTable('refresh');
                                            layer.msg(data.msg, {icon: 1});
                                        } else {
                                            layer.msg(data.msg, {icon: 2});
                                        }
                                    }
                                });
                            }
                        else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    })					
                },
				'click .end-btn': function (e, val, row) {
					$.ajax({
						  url: " ${ctx}/broadcast/graphicRelease/stopPlay",
	                        type: 'post',
	                        data: {
	                        	fId: row.fId
	                        },
                        success: function (data) {
                            if (data.status === 200) {
                                $('#picture').bootstrapTable('refresh');
                                layer.msg(data.msg, {icon: 1});
                            } else {
                                layer.msg(data.msg, {icon: 2});
                            }
                        }
                    });
                }
            },
            formatter: function () {
                /* return '<button class="btn btn-info btn-sm edit-base-btn">详情'; */
            	return '<button class="btn btn-danger btn-sm start-btn">发布<button class="btn btn-danger btn-sm end-btn">停止<button class="btn btn-info btn-sm edit-base-btn">详情';
            }
        }]
    ];

    var columns_mageAd = [
        [{
            checkbox: true
        }, {
            field: 'fId',
            title: 'fId',
            align: 'center',
            visible: false,
        }, {
            field: 'fImageName',
            title: '图片名称',
            width: '10%',
            align: 'center',
        }, {
            field: 'fAddress',
            title: '图片',
            width: '15%',
            align: 'center',
            formatter: function (value, row, index) {
                return "<img width='100px' height='100px' src=" + value + ">";
            }
        },
        {
            field: 'fState',
            title: '状态',
            align: 'center',
            sortable: false,
            width: '10%',
            formatter: function (fState) {
                if (fState == "0") {
                    return '<span class="label label-default">&nbsp;已停止&nbsp;</span>';
                } else if (fState == "1") {
                    return '<span class="label label-warning">&nbsp;已发送&nbsp;</span>';
                } 
            }
        },{
            field: 'fCreateTime',
            title: '操作时间',
            align: 'center',
            width: '25%',
            sortable: true,
            formatter: function (time) {
                return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : "";
            },
        }, {
            field: 'creator',
            title: '操作者',
            align: 'center',
            width: '10%',
        }, {
            title: '操作',
            align: 'center',
            events: {
               'click .edit-base-btn': function (e, val, row) {
                    $.getJSON('${ctx}/broadcast/graphicRelease/selectPicture/' + row.fId, function (result) {
                        var ii = layer.load(2);
                        if (result.status === 200) {
                            layer.close(ii);
                            var data = result.data;
                            if (data) {
                                $('#fContent').text(data.fImageName);
                                window.document.getElementById('ZimuContentDiv').style.display = "none";
                                $('#fRemark').text(data.fRemark?data.fRemark:"");
                                $('#fAddress').text(data.fAddress);
                                $('#fStartDate').text(new Date(data.fSendStartDate).format('yyyy-MM-dd'));
                                $('#fEndDate').text(new Date(data.fSendEndDate).format('yyyy-MM-dd'));
                                $('#fStartTime').text(new Date(data.fSendStartTime).format('HH:mm:ss'));
                                $('#fEndTime').text(new Date(data.fSendEndTime).format('HH:mm:ss'));
                                $('#fCreateTime').text(new Date(data.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                                $('#fUpdtateTime').text(data.fUpdateTime?new Date(data.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'):"");
                                $('#fRealArea').text(data.fRealArea);
                                $('#creator').text(data.creator);
                                $('#operator').text(data.operator?data.operator:"");
                                $('#fZimuDevice').text(data.fDevice);
                                $('#infoModal').modal();
                            }
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    })
                }, 
                'click .preview-base-btn': function (e, val, row) {
                    $.getJSON('${ctx}/broadcast/graphicRelease/selectPicture/' + row.fId, function (result) {
                        var ii = layer.load(2);
                        if (result.status === 200) {
                            layer.close(ii);
                            var data = result.data;
                            if (data) {
                                $('#imgForPreview').attr("src", data.fAddress);
                                //$('#imgForPreview').attr("src", '${ctx}/static/img/picture/addPhoto.jpg');                               
                                $('#previewImg').modal();
                            }
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    })
                },                 
				'click .start-btn': function (e, val, row) {
										
					$.getJSON('${ctx}/broadcast/graphicRelease/selectPicture/' + row.fId, function (result) {
                        var ii = layer.load(2);
                        if (result.status === 200) {
                            layer.close(ii);
                            var data = result.data;
                            if (data) {
                            	 if(data.fResourceCode[0] == ","){
                                 	data.fResourceCode = data.fResourceCode.substring(1);
                                 }
                            	var imageInfo = {};
                            	imageInfo.fTitle = data.fTitle;
                            	imageInfo.fRemark = data.fRemark?data.fRemark:"";
                            	imageInfo.fAddress = data.fAddress;
                            	imageInfo.fStartDate = new Date(data.fStartDate).format('yyyy-MM-dd');
                            	imageInfo.fEndDate = new Date(data.fEndDate).format('yyyy-MM-dd');
                            	imageInfo.fStartTime = new Date(data.fStartTime).format('HH:mm:ss');
                            	imageInfo.fEndTime = new Date(data.fEndTime).format('HH:mm:ss');
                            	imageInfo.fCreateTime = new Date(data.fCreateTime).format('yyyy-MM-dd HH:mm:ss');
                            	imageInfo.fUpdateTime = data.fUpdateTime?new Date(data.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'):"";
                            	imageInfo.fRealArea = data.fRealArea;
                            	imageInfo.creator = data.creator;                              
                            	imageInfo.operator = data.operator?data.operator:"";
                            	imageInfo.fDevice = data.fDevice;
								
								$.ajax({
			                         url: "${ctx}/broadcast/graphicRelease/picturePlay",
			                         type: 'post',
			                         data: {
			                         	pictureName: data.fImageName,
			                         	pictureURL: data.fAddress,
			                            resourceCodes: data.fResourceCode,
			                            fid:data.fId
			                         },
			                         success: function (data) {
			                             if (data.status === 200) {
			                                 $('#picture').bootstrapTable('refresh');
			                                 layer.msg(data.msg, {icon: 1});
			                             } else {
			                                 layer.msg(data.msg, {icon: 2});
			                             }
			                         }
			                     });
                            }
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    })				 
                },
				'click .end-btn': function (e, val, row) {
					$.ajax({
						  url: " ${ctx}/broadcast/graphicRelease/stopPlay",
	                        type: 'post',
	                        data: {
	                        	fId: row.fId
	                        },
                        success: function (data) {
                            if (data.status === 200) {
                                $('#picture').bootstrapTable('refresh');
                                layer.msg(data.msg, {icon: 1});
                            } else {
                                layer.msg(data.msg, {icon: 2});
                            }
                        }
                    });
                }
            },
            formatter: function () {
                /* return '<button class="btn btn-info btn-sm edit-base-btn">详情'; */
            	return '<button class="btn btn-danger btn-sm start-btn">发布<button class="btn btn-danger btn-sm end-btn">停止'+
            	'<button class="btn btn-info btn-sm edit-base-btn">详情<button class="btn btn-info btn-sm preview-base-btn">预览';
            }
        }]
    ];

    var columns_video = [
        [{
            checkbox: true
        }, {
            field: 'fId',
            title: 'fId',
            align: 'center',
            visible: false,
        }, {
            field: 'fVideoName',
            title: '视频名称',
            width: '15%',
            align: 'left',
            sortable: false,
        },
        {
            field: 'fState',
            title: '状态',
            width: '15%',
            align: 'center',
            sortable: false,
            formatter: function (fState) {
                if (fState == "0") {
                    return '<span class="label label-default">&nbsp;已停止&nbsp;</span>';
                } else if (fState == "1") {
                    return '<span class="label label-warning">&nbsp;已发送&nbsp;</span>';
                } 
            }
        }, {
            field: 'fCreateTime',
            title: '操作时间',
            align: 'center',
            width: '30%',
            sortable: true,
            formatter: function (time) {
                return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : "";
            },
        }, {
            field: 'creator',
            title: '操作者',
            align: 'center',
            width: '10%',

        }, {
            title: '操作',
            align: 'center',
            events: {
               'click .edit-base-btn': function (e, val, row) {
                    $('#fAddress').text(row.fAddress);
                    window.document.getElementById('ZimuContentDiv').style.display = "none";
                    $('#fRemark').text(row.fRemark?row.fRemark:"");
                    $('#fContent').text(row.fVideoName);
                    $('#fStartDate').text(new Date(row.fSendStartDate).format('yyyy-MM-dd'));
                    $('#fEndDate').text(new Date(row.fSendEndDate).format('yyyy-MM-dd'));
                    $('#fStartTime').text(new Date(row.fSendStartTime).format('HH:mm:ss'));
                    $('#fEndTime').text(new Date(row.fSendEndTime).format('HH:mm:ss'));
                    $('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                    $('#fUpdtateTime').text(row.fUpdateTime?new Date(row.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'):"");
                    $('#creator').text(row.creator);
                    $('#operator').text(row.operator?row.operator:"");
                    $('#fRealArea').parent().parent().css("display", "none");
                    $('#fZimuDevice').text(row.fDevice);
                    $('#infoModal').modal();
               },
               'click .preview-base-btn': function (e, val, row) {
            	   $('#vidioForPreview').attr("src", row.fAddress);
                  //   $('#vidioForPreview').attr("src", '${ctx}/static/video/世界变迁.mp4');                             
                     $('#previewVidio').modal();
               },       
                'click .start-btn': function (e, val, row) {
                	$.getJSON('${ctx}/broadcast/graphicRelease/selectVideo/' + row.fId, function (result) {
                        var ii = layer.load(2);
                        if (result.status === 200) {
                            layer.close(ii);
                            var data = result.data;
                            if(data.fResourceCode[0] == ","){
                            	data.fResourceCode = data.fResourceCode.substring(1);
                            }
                            if (data) {
								$.ajax({
			                         url: "${ctx}/broadcast/graphicRelease/videoPlay",
			                         type: 'post',
			                         data: {
			                         	videoName: data.fVideoName,
			                         	videoURL: data.fAddress,
			                            resourceCodes: data.fResourceCode,
			                            fid:data.fId
			                         },
			                         success: function (data) {
			                             if (data.status === 200) {
			                                 $('#video').bootstrapTable('refresh');
			                                 layer.msg(data.msg, {icon: 1});
			                             } else {
			                                 layer.msg(data.msg, {icon: 2});
			                             }
			                         }
			                     });
                            }
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    })				 
                },
				'click .end-btn': function (e, val, row) {
					$.ajax({
                        url: " ${ctx}/broadcast/graphicRelease/stopVideoPlay",
                        type: 'post',
                        data: {
                        	fId: row.fId
                        },
                        success: function (data) {
                            if (data.status === 200) {
                                $('#video').bootstrapTable('refresh');
                                layer.msg(data.msg, {icon: 1});
                            } else {
                                layer.msg(data.msg, {icon: 2});
                            }
                        }
                    });
                }
            },
            formatter: function () {
                /* return '<button class="btn btn-info btn-sm edit-base-btn">详情'; */
            	return '<button class="btn btn-danger btn-sm start-btn">发布<button class="btn btn-danger btn-sm end-btn">停止'+
            	'<button class="btn btn-info btn-sm edit-base-btn">详情<button class="btn btn-info btn-sm preview-base-btn">预览';
            }
        }]
    ];

    var columns_imgTextTerminal = [
        [{
            checkbox: true
        }, {
            field: 'fId',
            title: 'fId',
            align: 'center',
            visible: false,
        }, {
            field: 'fTerminalName',
            title: '终端名称',
            width: '12%',
            align: 'left',
        }, {
            field: 'fResourceCode',
            title: '资源编码',
            width: '12%',
            align: 'center',
        }, {
            field: 'fDeviceType',
            title: '设备类型',
            align: 'center',
            width: '12%',
            formatter: function (value) {
                if (value == 0) {
                    return "字幕设备";
                } else if (value == 1) {
                    return "图片设备";
                } else if (value == 2) {
                    return "视频设备";
                }
            }
        }, {
            field: 'fMac',
            title: 'MAC',
            align: 'center',
            width: '10%',
        }, /*  {
            field: 'fBroadcastArea',
            title: '安装区域',
            align: 'center',
        }, */  {
            field: 'fCreateTime',
            title: '操作时间',
            align: 'center',
            sortable: true,
            width: '25%',
            formatter: function (time) {
                return new Date(time).format('yyyy-MM-dd HH:mm:ss');
            },
        }, {
            field: 'creator',
            title: '操作者',
            align: 'center',
            width: '12%',
        },{
            title: '操作',
            align: 'center',
            events: {
               'click .edit-base-btn': function (e, val, row) {
                    $('#fBroadcastArea').text(row.fBroadcastArea);
                    $('#fMac').text(row.fMac);
                    var fDeviceTypeStr = "";
                    if (row.fDeviceType == 0) {
                    	fDeviceTypeStr = "字幕设备";
                    } else if (row.fDeviceType == 1) {
                    	fDeviceTypeStr = "图片设备";
                    } else if (row.fDeviceType == 2) {
                    	fDeviceTypeStr = "视频设备";
                    }
                    $('#fDeviceType').text(fDeviceTypeStr);
                    $('#fTerminalName').text(row.fTerminalName);
                    $('#fResourceCode').text(row.fResourceCode);
                    $('#fCreateTime').text(new Date(row.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
                    $('#fUpdtateTime').text(row.fUpdateTime?new Date(row.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'):"");
                    $('#creator').text(row.creator);
                    $('#operator').text(row.operator?row.operator:"");
                    $('#infoModal_tem').modal();
               }
               },
	            formatter: function () {
	                /* return '<button class="btn btn-info btn-sm edit-base-btn">详情'; */
	            	return '<button class="btn btn-info btn-sm edit-base-btn">详情';
	            }
        }]
    ];
</script>

	<script type="text/javascript">
    var enLang = {
        name: "en",
        month: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"],
        weeks: ["SUN", "MON", "TUR", "WED", "THU", "FRI", "SAT"],
        times: ["Hour", "Minute", "Second"],
        timetxt: ["Time", "Start Time", "End Time"],
        backtxt: "Back",
        clear: "Clear",
        today: "Now",
        yes: "Confirm",
        close: "Close",
    }
    //模态框拖动
    $(".modal-dialog").draggable();
    $('body').on('hidden.bs.modal', '.modal', function () {
        $(".modal-dialog").css({"top":"0","bottom":"0","left":"0","right":"0"})
/*         refreshTreeOfDivice(); */
    });
</script>

</body>
</html>