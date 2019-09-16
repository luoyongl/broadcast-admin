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
    <title>区域特色</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        .col-sm-1 {
            width: 9.333333%;
        }

        .nav.nav-tabs a {
            padding: 10px;
        }

        .btn-operate {
            margin-right: 10px;
        }

        .fileinput-button input {
            position: absolute;
            right: 0px;
            top: 0px;
        }

        .holder::-webkit-input-placeholder {
            color: white;
        }

        .holder::-moz-placeholder { /* Mozilla Firefox 19+ */
            color: white;
        }

        .holder:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
            color: white;
        }

        .holder:-ms-input-placeholder { /* Internet Explorer 10-11 */
            color: white;
        }

        .modal-body-right {
            padding: 0;
        }

        .content {
            height: 99%;
            width: 99%;
        }

        .text {
            border: 1px solid #ccc;
            height: 322px;
            width: 800px;
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

        .form-group {
            margin: 1% 0px;
            padding: 0px;
            padding-left: 0px;
        }

        #inputBox {
            width: 21%;
            height: 40px;
            border: 1px solid #FFFFFF;
            border-radius: 20px;
            position: relative;
            text-align: center;
            line-height: 40px;
            overflow: hidden;
            font-size: 16px;
        }

        .w-e-toolbar .w-e-menu {
            padding: 5px 10px !important;
        }

        table {
            table-layout: fixed;
        }

        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .tab_modal {
            height: 85%;
            overflow-y: scroll;
        }

        .tab_modal::-webkit-scrollbar { /*定义滚动条高宽及背景 高宽分别对应横竖滚动条的尺寸*/ 
            width: 4px; 
            height: 4px;
        }

        .tab_modal::-webkit-scrollbar-thumb { /*定义滑块 内阴影+圆角*/  
            border-radius: 5px;
            -webkit-box-shadow: inset 0 0 5px orange;
            background: rgba(0, 0, 0, 0.2);
        }

        .tab_modal::-webkit-scrollbar-track { /*定义滚动条轨道 内阴影+圆角*/  
            -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
            border-radius: 0;
            background: rgba(0, 0, 0, 0.1);
        }
    </style>

</head>
<body>
<h4><b>当前位置:系统管理>>区域特色</b></h4>
<div class="tab_driver">
    <ul class="nav nav-tabs">
        <li><a>简介一</a></li>
        <li><a>简介二</a></li>
        <li><a>简介三</a></li>
        <li><a>特色照片</a></li>
        <!-- <li><a>预览</a></li> -->
        <span class="driverspan"></span>
    </ul>
</div>

<div class="tab_modal show">
    <form id="add_form_one" onsubmit="return true"><!-- onsubmit="return true" method="post"  -->
	    <c:forEach items="${realOneList }" var="one">
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">标题</label>
	            <!-- <div class="col-sm-2">
	                <input type="text" id="fMainTitle" name="fMainTitle" class="form-control " placeholder="最多四个字符">
	            </div> -->
	            <div class="col-sm-2">
	                <input type="text" id="fMainTitle" name="fMainTitle" class="form-control" value="${one.fMainTitle }" placeholder="最多四个字符">
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">内容</label>
	            <!-- <div id="regionFeature_editor" class="col-sm-5"></div> -->
	            <!-- <div id="editor" class="col-sm-10">
	                <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p> -->
	                <!-- <div class="col-md-12 margin-b-60"> -->
	                <!-- <textarea class="xtl-editor-content" id="textarea1" style="margin: 0px;width: 100%;height: 100px;" name="content" placeholder="请输入内容"></textarea> -->
	                <!-- <textarea name="content" id="contect_text" class="editor" ></textarea> -->
	                <!-- </div> -->
	                <!-- <input style="display: none" type="text" name="fRichTextContent" id="fRichTextContent">
	                <input style="display: none" name="fImageUrl" id="fImageUrl">
	            </div> -->
	            <div class="col-sm-4">
	                <textarea class="textarea form-control" style="height:200px" id="fContent" name="fContent">${one.fContent }</textarea>
	            </div>
	        </div>
	        <div class="form-group col-sm-12"
	             style="display: flex;align-items:center; height:100px;">
	            <label class="col-sm-1">图片</label>
	            <label id="image3" for="file3" style="padding: 0% 0;">
	            <c:if test="${one.fImageUrl==null }">
	            <img
	                    src="${ctx}/static/img/picture/addPhoto.jpg"
	                    style="width: 100px;height: 100px;">
	            </c:if>
	            <c:if test="${one.fImageUrl!=null }">
	            <img
	                    src="${one.fImageUrl }"
	                    style="width: 100px;height: 100px;">
	            </c:if>
	            </label>
	            <input type="file" id="file3" name="fImageUrl" style="display: none" accept="image/*"/>
	            <input style="display: none" name="fImageUrl" id="camera_fDeviceImage_ones">
	        </div>
	    </c:forEach>
        <div class="form-group col-sm-12">
            <label class="col-sm-1"></label>
            <div class="col-sm-2">
                <button type="button" class="btn btn-info" id="add_button_one">保存</button>
                <!-- <button type="button" class="btn btn-info" id="review">预览</button> -->
                <a type="button" class="btn btn-info" href="${ctx}/systemManage/regionFeature/showreview"
                   target="view_window">预览</a>
                <!-- <button class="btn btn-danger" id="delete_region_one">删除</button> -->
            </div>
        </div>
    </form>
</div>

<div class="tab_modal">
    <form id="add_form_two" onsubmit="return true" method="post">
	    <c:forEach items="${twoList }" var="two">
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">标题</label>
	            <div class="col-sm-2">
	                <input type="text" id="fMainTitle" name="fMainTitle" class="form-control" value="${two.fMainTitle }" placeholder="最多四个字符">
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">内容</label>
	            <div class="col-sm-4">
	                <textarea class="textarea form-control" id="fContent" name="fContent">${two.fContent }</textarea>
	            </div>
	        </div>
	     </c:forEach>
        <div class="form-group col-sm-12">
            <label class="col-sm-1"></label>
            <div class="col-sm-2">
                <button type="button" class="btn btn-info" id="add_button_two">保存</button>
            </div>
        </div>
    </form>
</div>

<!-- <div class="tab_modal">
    <form id="review_form" onsubmit="return true"  method="post">
        <div class="form-group col-sm-12">
            <label class="col-sm-1">标题</label>
            <div class="col-sm-2">
                <input type="text" id="fMainTitle" name="fMainTitle" class="form-control" placeholder="最多四个字符">
            </div>
        </div>
        <div class="form-group col-sm-12">
            <label class="col-sm-1">内容</label>
            <div class="col-sm-4">
                <textarea class="textarea form-control" id="fContent" name="fContent"></textarea>
            </div>
        </div>
        <div class="form-group col-sm-12">
            <label class="col-sm-1"></label>
            <div class="col-sm-2">
                <button type="button" class="btn btn-info" id="review_button">预览</button>
            </div>
        </div>
    </form>
</div> -->

<div class="tab_modal">
    <form id="add_form_three" onsubmit="return true" method="post">
	    <c:forEach items="${threeList }" var="three">
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">总标题:</label>
	            <div class="col-sm-2">
	                <input type="text" id="fMainTitle" name="fMainTitle" class="form-control" value="${three.fMainTitle }" placeholder="最多支持四个字符">
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">内容概述:</label>
	            <div class="col-sm-4">
	                <textarea class="textarea form-control " id="fContent" name="fContent">${three.fContent }</textarea>
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">副标题一:</label>
	            <div class="col-sm-2">
	                <input type="text" id="fSubheadingOne" name="fSubheadingOne" class="form-control" value="${three.fSubheadingOne }"
	                       placeholder="最多支持四个字符">
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">内容概述:</label>
	            <div class="col-sm-4">
	                <textarea class="textarea form-control" id="fSubContentOne" name="fSubContentOne">${three.fSubContentOne }</textarea>
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">副标题二:</label>
	            <div class="col-sm-2">
	                <input type="text" id="fSubheadingTwo" name="fSubheadingTwo" class="form-control" value="${three.fSubheadingTwo }"
	                       placeholder="最多支持四个字符">
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">内容概述:</label>
	            <div class="col-sm-4">
	                <textarea id="fSubContentTwo" name="fSubContentTwo" class="textarea form-control">${three.fSubContentTwo }</textarea>
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">副标题三:</label>
	            <div class="col-sm-2">
	                <input type="text" id="fSubheadingThree" name="fSubheadingThree" class="form-control" value="${three.fSubheadingThree }"
	                       placeholder="最多支持四个字符">
	            </div>
	        </div>
	        <div class="form-group col-sm-12">
	            <label class="col-sm-1">内容概述:</label>
	            <div class="col-sm-4">
	                <textarea class="textarea form-control" id="fSubContentThree" name="fSubContentThree">${three.fSubContentThree }</textarea>
	            </div>
	        </div>
	    </c:forEach>
        <div class="form-group col-sm-12">
            <label class="col-sm-1"></label>
            <div class="col-sm-2">
                <button type="button" class="btn btn-info" id="add_button_three">保存</button>
            </div>
        </div>
    </form>
</div>

<div class="tab_modal">
    <div class="content_table">
        <div class="handle ">
            <button class="btn btn-info" data-toggle="modal" data-target="#add_region_modal" id="add_region">新增</button>
            <button class="btn btn-info" data-toggle="modal" id="update_region">修改</button>
            <button class="btn btn-danger" id="delete_region">删除</button>
        </div>
        <table id="tab_picture" data-height="450" class="table table-hover"></table>
    </div>
</div>

<div class="modal fade" id="add_region_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times;</button>
                <h4 class="modal-title">新增</h4>
            </div>
            <form id="add_form_four" onsubmit="return true" method="post">
                <div class="modal-body">
                    <div class="form-group col-sm-12"
                         style="display: flex;justify-content:center;align-items:center; height:100px;">
                        <label id="image1" for="file1" style="padding: 100% 0;"><img
                                src="${ctx}/static/img/picture/addPhoto.jpg"
                                style="width: 100px;height: 100px;"></label>
                        <input type="file" id="file1" name="fImageUrl" style="display: none" accept="image/*"/>
                        <input style="display: none" name="fImageUrl" id="camera_fDeviceImage">
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2">图片类型</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="fImageType">
                                <option>jpg</option>
                                <option>png</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2">图片描述</label>
                        <div class="col-sm-3">
                            <input type="text" id="fContent" name="fContent" class="form-control">
                        </div>
                    </div>
                </div>

                <div class="modal-footer bottom">
                    <button type="button" id="confirm_submit" class="btn btn-info">确定</button>
                    <button type="button" id="cancel" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<div class="modal fade" id="update_region_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times;</button>
                <h4 class="modal-title">修改</h4>
            </div>
            <form id="update_form_four" onsubmit="return true" method="post">
                <div class="modal-body">
                    <div class="form-group col-sm-12"
                         style="display: flex;justify-content:center;align-items:center; height:100px;">
                        <label id="image2" for="file2" style="padding: 100% 0;"><img
                                src="${ctx}/static/img/picture/addPhoto.jpg"
                                style="width: 100px;height: 100px;"></label>
                        <input type="file" id="file2" name="fImageUrl" style="display: none" accept="image/*"/>
                        <input style="display: none" name="fImageUrl" id="camera_fDeviceImage">
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2">图片类型</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="fImageType">
                                <option value="jpg" <c:if test="selected='selected'">selected</c:if>>jpg</option>
                                <option value="png" <c:if test="selected='selected'">selected</c:if>>png</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-2">图片描述</label>
                        <div class="col-sm-3">
                            <input type="text" id="fContent" name="fContent" class="form-control">
                        </div>
                    </div>
                </div>

                <div class="modal-footer bottom">
                    <button type="button" id="update_submit" class="btn btn-info">确定</button>
                    <button type="button" id="cancel" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    var fileUrl1 = null;
    var E = window.wangEditor;
    var editor = new E('#editor');
    //var editor = new E('#textarea1');
    //var editor = new E('#div1', '#div2');
    //开启debug模式
    editor.customConfig.debug = true;
    // 关闭粘贴内容中的样式
    editor.customConfig.pasteFilterStyle = false;
    // 忽略粘贴内容中的图片
    editor.customConfig.pasteIgnoreImg = true;
    // 使用 base64 保存图片
    //editor.customConfig.uploadImgShowBase64 = true;

    // 上传图片到服务器
    editor.customConfig.uploadFileName = 'myFile'; //设置文件上传的参数名称
    editor.customConfig.uploadImgServer = '${ctx}/systemManage/regionFeature/upload'; //设置上传文件的服务器路径
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024; // 将图片大小限制为 3M
    //自定义上传图片事件
    editor.customConfig.uploadImgHooks = {
        before: function (xhr, editor, files) {

        },
        success: function (xhr, editor, result) {
            //alert(result.data);
            fileUrl1 = result.data;
            console.log("上传成功");
        },
        fail: function (xhr, editor, result) {
            console.log("上传失败,原因是" + result);
        },
        error: function (xhr, editor) {
            console.log("上传出错");
        },
        timeout: function (xhr, editor) {
            console.log("上传超时");
        }
    };
    editor.create();
</script>
<script type="text/javascript">
    var fileUrl = null;
    var columns = [
        [{
            field: 'checkbox',
            checkbox: true,
            width: 20
        }, {
            field: 'fImageUrl',
            title: '特色图片',
            align: 'center',
            width: '20%',
            formatter: function (data, row, index) {
                return [
                    '<img  src=' + data + ' style="width:100px;height:100px;"/>'
                ]
            }
        }, {
            field: 'fContent',
            title: '图片描述',
            align: 'center',
            width: '70%'

        }, {
            field: 'fImageType',
            title: '图片类型',
            align: 'center',
        }/* , {
					field: 'd',
					title: '操作',
					align: 'center',
					width: '15%',
					formatter: function () {
		                return '<button class="btn btn-info btn-sm edit-btn">详情</button> '
		            }
				} */]
    ];

    $(function () {
        $('#tab_picture').bootstrapTable({
            method: 'get',
            sortable: true,
            dataType: "json",
            search: false, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            url: "${ctx}/systemManage/regionFeature/list",
            toolbar: '#toolbarComputer', // 工具按钮用哪个容器
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 3, // 每页的记录行数（*）
            pageList: [3, 5, 10], // 可供选择的每页的行数（*）
            showRefresh: false, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber, // SQL语句起始索引
                    pageSize: params.pageSize, // 每页显示数量
                    pageOrderName: params.sortOrder, //排序方式
                    pageSortName: params.sortName, //排序名称
                    search: params.searchText, //模糊查询
                };
            },
            responseHandler: function (result) {
                //result_data = result.data.list;
                if (result.status === 200) {
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            }
        });
        $(".modal-dialog").draggable();
    });


    //增加_简介一
    $("#add_button_one").click(function () {
        //alert(editor.txt.html());
        //alert(fileUrl1);
        //$("#fRichTextContent").val(editor.txt.html());
        //alert(editor.txt.html());
        //$("#fImageUrl").val(fileUrl1);
        $("#camera_fDeviceImage_ones").val(fileUrl);
        layer.load(2);
        $.post('${ctx}/systemManage/regionFeature/add?fBriefClassification=' + 1, $('#add_form_one').serialize(), function (result) {
            if (result.status === 200) {
                /* $("#add_schedule_modal").modal('hide');
                $('#tab_schedule').bootstrapTable('refresh'); */
                //layer.alert('定时广播新增成功!', {icon: 1});
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
                //document.getElementById("add_form_one").reset();
                //document.getElementById("editor").reset();
            } else {
                //layer.alert('定时广播新增失败，请重试!', {icon: 2});
                layer.msg(result.msg, {icon: 2});
                layer.closeAll('loading');
            }
        });
        editor.txt.html('<p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>');
        //alert("测试");
    });

    //增加_简介二
    $("#add_button_two").click(function () {
        $.post('${ctx}/systemManage/regionFeature/add?fBriefClassification=' + 2, $('#add_form_two').serialize(), function (result) {
            if (result.status === 200) {
                /* $("#add_schedule_modal").modal('hide');
                $('#tab_schedule').bootstrapTable('refresh'); */
                //layer.alert('定时广播新增成功!', {icon: 1});
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
                //document.getElementById("add_form_two").reset();
            } else {
                //layer.alert('定时广播新增失败，请重试!', {icon: 2});
                layer.msg(result.msg, {icon: 2});
                layer.closeAll('loading');
            }
        });
    });

    //预览
    /* $("#review_button").click(function(){
        alert("测试");
        $.post('${ctx}/systemManage/regionFeature/review?fBriefClassification='+ 2, $('#review_form').serialize(), function (result) {
		        	if (result.status === 200){
						/* $("#add_schedule_modal").modal('hide');
						$('#tab_schedule').bootstrapTable('refresh'); */
    //layer.alert('定时广播新增成功!', {icon: 1});
    /* layer.msg(result.msg, {icon: 1});
    layer.closeAll('loading');
    document.getElementById("reviews_form").reset();
}else{ */
    //layer.alert('定时广播新增失败，请重试!', {icon: 2});
    /*layer.msg(result.msg, {icon: 2});
    layer.closeAll('loading');
}
});
}); */

    //增加_简介三
    $("#add_button_three").click(function () {
        $.post('${ctx}/systemManage/regionFeature/add?fBriefClassification=' + 3, $('#add_form_three').serialize(), function (result) {
            if (result.status === 200) {
                /* $("#add_schedule_modal").modal('hide');
                $('#tab_schedule').bootstrapTable('refresh'); */
                //layer.alert('定时广播新增成功!', {icon: 1});
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
                //document.getElementById("add_form_three").reset();
            } else {
                //layer.alert('定时广播新增失败，请重试!', {icon: 2});
                layer.msg(result.msg, {icon: 2});
                layer.closeAll('loading');
            }
        });
    });
	//简介一_上传图片
	document.getElementById('file3').onchange = function () {
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function () {
            document.getElementById('image3').getElementsByTagName('img')[0].src = fr.result;
        };
        fr.readAsDataURL(imgFile);

        var form = new FormData();
        form.append("file", document.getElementById("file3").files[0]);
        console.log("form:" + form)
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

    //特色图片_上传图片_增加
    document.getElementById('file1').onchange = function () {
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function () {
            document.getElementById('image1').getElementsByTagName('img')[0].src = fr.result;
        };
        fr.readAsDataURL(imgFile);

        var form = new FormData();
        form.append("file", document.getElementById("file1").files[0]);
        console.log("form:" + form)
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

    //特色图片_上传图片_修改
    document.getElementById('file2').onchange = function () {
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function () {
            document.getElementById('image2').getElementsByTagName('img')[0].src = fr.result;
        };
        fr.readAsDataURL(imgFile);

        var form = new FormData();
        form.append("file", document.getElementById("file2").files[0]);
        console.log("form:" + form)
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

    //增加_特色图片
    $("#confirm_submit").click(function () {
        /* submmitCheck("#camera_form");
        if(camera_flag==0 || flag_lat1==0 || flag_long1==0 || flag1==0){
            return;
        } */
        //alert(fileUrl);
        $("#add_region_modal #camera_fDeviceImage").val(fileUrl);
        layer.load(2);
        $.ajax({
            type: 'post',
            url: '${ctx}/systemManage/regionFeature/addimage?fBriefClassification=' + 4,
            data: $('#add_form_four').serialize(),
            async: false,
            success: function (result) {
                if (result.status == 200) {
                    $('#add_region_modal').modal('hide');
                    $('#tab_picture').bootstrapTable('refresh');
                    document.getElementById('add_form_four').reset();
                    camera_flag = 0;
                }
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
            }
        })
    });

    //修改_特色图片
    $("#update_region").click(function () {
        var checked = $('#tab_picture').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg('请选择要修改的记录', {icon: 2});
            return;
        } else if (checked.length > 1) {
            layer.msg('只能选择一条记录', {icon: 2});
            return;
        } else {
            dataReShow(checked[0]);
            $('#update_region_modal').modal('show');
        }
    });


    $("#update_submit").click(function () {
        var checked = $('#tab_picture').bootstrapTable('getSelections');
        /* submmitCheck("#camera_form");
        if(camera_flag==0 || flag_lat1==0 || flag_long1==0 || flag1==0){
            return;
        } */
        $("#update_region_modal #camera_fDeviceImage").val(fileUrl);
        layer.load(2);
        $.ajax({
            type: 'post',
            url: '${ctx}/systemManage/regionFeature/update?fBriefClassification=' + 4 + '&fId=' + checked[0].fId,
            data: $('#update_form_four').serialize(),
            success: function (result) {
                if (result.status == 200) {
                    $('#update_region_modal').modal('hide');
                    $('#tab_picture').bootstrapTable('refresh');
                    document.getElementById('update_form_four').reset();
                }
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
            }
        })
    });

    //修改回显
    function dataReShow(checked) {
        $("#update_region_modal select[name='fImageType']").val(checked.fImageType);
        $("#update_region_modal input[name='fContent']").val(checked.fContent);
        document.getElementById('image2').getElementsByTagName('img')[0].src = checked.fImageUrl;
    }

    //删除图片
    $("#delete_region").click(function () {
        var checked = $('#tab_picture').bootstrapTable('getSelections');
        var del_ids = "";
        if (checked.length == 0) {
            layer.msg('请选择要删除的记录', {icon: 2});
        } else {
            layer.confirm('确认删除' + checked.length + "条记录?", {icon: 3, title: '操作提示'}, function (index) {
                for (i = 0; i < checked.length; i++) {
                    del_ids += checked[i].fId + ",";
                }
                layer.load(2);
                $.post('${ctx}/systemManage/regionFeature/delete?ids=' + del_ids + '&fBriefClassification=' + 4, function (result) {
                    if (result.status === 200) {
                        $('#tab_picture').bootstrapTable('refresh');
                    }
                    layer.msg(result.msg, {icon: 1});
                    layer.closeAll('loading');
                });
            });
        }
    })

    //删除简介一
    $("#delete_region_one").click(function () {
        alert("测试1");
        /* $.post('

        ${ctx}/systemManage/regionFeature/deleteReview?fBriefClassification=' + 1 , function (result) {
                    if (result.status === 200) { 
                        alert("测试2")
                    	$('#tab_picture').bootstrapTable('refresh'); 
	                    layer.msg(result.msg,{icon: 1});
	                    layer.closeAll('loading');
                     }
                }); */
        $.ajax({
            type: 'post',
            url: '${ctx}/systemManage/regionFeature/deleteReview?fBriefClassification=' + 1,
            success: function (result) {
                alert("测试2");
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
            }
        })
    })

</script>

<script type="text/javascript">
    /* $("#review").click(function(){
        alert("测试1");
        $.ajax({ */
    //dataType: "html",
    //async: true,
    //url: '${ctx}/systemManage/regionFeature/showreview',
    //type : 'get',
    //success: function (data) {
    //alert("测试2")
    /*alert(data);
    window.location.href=data;*/
    //},
    //error:function (data) {
    //}
    //})
    //})
</script>
</body>

</html>