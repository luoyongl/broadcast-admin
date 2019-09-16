<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>音频管理 </title>
    <%@include file="../common/css.jsp" %>
    <style>
        .form-group {
            padding-right: 1% !important;
        }
        table{
            table-layout:fixed;
        }
        table tbody tr td{
            overflow: hidden;
            text-overflow:ellipsis;
            white-space: nowrap;
        }
    </style>
</head>
<body>
<h4><b>当前位置:制作播发>>音频管理</b></h4>
<div>
    <div class="content_table">
    <div class="handle">
        <button class="btn btn-info" data-toggle="modal" data-target="#add_audio_modal">新增</button>
        <button class="btn btn-info" data-toggle="modal" id="update_btn">修改</button>
        <button class="btn btn-danger" id="delete_btn">删除</button>
    </div>
    <table id="tab_audioManage" data-height="450" class="table table-hover"></table>
    </div>
</div>
<!-- 详情模态框（Modal） -->
<div class="modal fade" id="audio_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 60%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">详情</h4>
            </div>
            <div class="modal-body" style="padding: 15px">

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">音频名称：</label>
                        <div class="col-sm-8">
                            <span  name="fAudioName" ></span>
                        </div>
                    </div>

           <!--          <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">时长：</label>
                        <div class="col-sm-8">
                            <span  name="fTime" ></span>
                        </div>
                    </div> -->

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">文件大小：</label>
                        <div class="col-sm-8">
                            <span  name="fAudioSize" ></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">码率：</label>
                        <div class="col-sm-8">
                            <span  name="fBitRate" ></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-6">
                        <label class="col-sm-4 control-label">采样率：</label>
                        <div class="col-sm-8">
                            <span  name="fSampleRate" ></span>
                        </div>
                    </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">创建者：</label>
                    <div class="col-sm-8">
                        <span  name="fCreatorId" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">创建时间：</label>
                    <div class="col-sm-8">
                        <span  name="fCreateTime" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">操作者：</label>
                    <div class="col-sm-8">
                        <span  name="fOperatorId" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label class="col-sm-4 control-label">修改时间：</label>
                    <div class="col-sm-8">
                        <span  name="fUpdateTime" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label">音频URL：</label>
                    <div class="col-sm-8">
                        <span  name="fAudioUrl" ></span>
                    </div>
                </div>

                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label">备注：</label>
                    <div class="col-sm-8">
                        <span  name="fRemark" style="display: inline-block" ></span>
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
<!--修改音频模态框-->
<div class="modal fade" id="update_audio_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">修改</h4>
            </div>
            <form id="update_form" method="post">
                <div class="modal-body col-sm-12" style="padding: 15px">

                    <div class="form-group col-sm-9" >
                        <label class="col-sm-3 control-label">音频名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="audioName" name="fAudioName" onblur="check()" maxlength="6">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" id="succUpdate_button">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>

                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!--添加音频模态框-->
<div class="modal fade" id="add_audio_modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">新增</h4>
            </div>
            <form id="uploadForm" enctype="multipart/form-data" method="post">
                <div class="modal-body col-sm-12">
                    <div class="form-group col-sm-12" style="padding: 10px">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-2 control-label">音频名称</label>
                            <div  class="col-sm-4 control-label">
                                <input id="fAudioName" name="fAudioName" class="form-control" maxlength="6"/>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-2 control-label">音频</label>
                            <div  class="col-sm-3 control-label">
                                <input id="uploadFile" type="file" name="files" multiple="multiple" accept="audio/x-mpeg">
                                <video style="display:none;"  controls="controls" id="aa"/>
                            </div>
                        </div>
                        <div class="col-sm-12 ">
                                <div class="col-sm-2">
                                    <label class="form-group">备注</label>
                                </div>
                                <div class="col-sm-9">
                                    <textarea id="fRemark" class="form-control" style="height: 80px;width: 400px;color: black;resize:none;" name="fRemark" maxlength="150"></textarea>
                                </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" id="upload">确定</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
</body>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">

    var update_flag = 0;
    $(function () {
        $('#tab_audioManage').bootstrapTable({
            url: "${ctx}/broadcast/audioManage/list",
            method: 'get',
            columns: columns,
            sortable: true, // 是否启用排序
            sortOrder: "asc", // 排序方式
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            search: true,
            pageList : [ 5, 10, 20], // 可供选择的每页的行数（*）
            classes: 'table table-no-bordered',
            showRefresh: true, // 是否显示刷新按钮
            clickToSelect: true, // 是否启用点击选中行
            uniqueId: "index", // 每一行的唯一标识，一般为主键列表
            queryParamsType: "",
            formatNoMatches: function () {
                return '无记录';
            },
            formatRecordsPerPage: function (pageNumber) {
                return '每页 ' + pageNumber + ' 条';
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return '当前 ' + pageFrom + ' 到 ' + pageTo + ' 条，共 ' + totalRows + ' 条记录,';
            },
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
                daily_data = result.data.list;

                if (result.status === 200) {
                    //layer.close(ii);
                }
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            }


        });

    });

    //key:operaterId   value:userName
    var userJsonMap = {};


    var columns = [[{
        checkbox: true
    }, {
        field: 'fAudioName',
        title: '音频名称',
        align: 'center',
        sortable: true,
        width: "10%",
    }, {
        field: 'fAudioType',
        title: '音频类型',
        align: 'center',
        sortable: true,
        width: "10%",
    },{
        field: 'fAudioSize',
        title: '音频大小',
        align: 'center',
        sortable: true,
        width: "10%",
        formatter: function (data, row, index) {
        	return formatFileSize(parseInt(data));
        }
    },{
        field: 'fBitRate',
        title: '码率',
        align: 'center',
        sortable: true,
        width: "10%",
        formatter: function (data, row, index) {
            return data+'Kbps';
        }
    },{
        field: 'fSampleRate',
        title: '采样率',
        align: 'center',
        sortable: true,
        width: "10%",
        formatter: function (data, row, index) {
            return parseInt(data)/1000 + "KHZ";
        }
    } /*, {
        field: 'fTime',
        title: '时长',
        align: 'center',
        sortable: true,
        width: 100,
        formatter: function (data, row, index) {
            return getTime(data);
        }
    }*/, {
        field: 'fUpdateTime',
        title: '操作时间',
        align: 'center',
        sortable: true,
        width: "15%",
        formatter : function(time){
           /* if(time==null){
                return new Date(fCreateTime).format('yyyy-MM-dd HH:mm:ss');
            }*/
            return new Date(time).format('yyyy-MM-dd HH:mm:ss');
        }
    }, {
        field: 'operator',
        title: '操作者',
        align: 'center',
        width: "8%",

    },{
        title: '操作',
        align: 'center',
       width: "7%",
        events: {
            'click .edit-btn': function (e, val, row) {

                dataShow(row);
                $('#audio_modal').modal('show');

            },
        },
        formatter: function () {

            return '<button class="btn btn-info btn-sm edit-btn">详情</button> '
        }
    }, {
        field: 'fAudioUrl',
        title: '试听',
        align: 'center',
       // height: '20px',
        formatter: function (data, row, index) {
            return [
                '<audio  src=' + data + ' controls="controls" style="width:80%;height:30px ;padding: 3px;"></audio>'
            ]
        }

    }
    ]];
	
    function getFileName(o){
        var pos=o.lastIndexOf("\\");
        return o.substring(pos+1);  
    }

    var second = 0;   //文件时长
    $("#upload").click(function () {
        var fileSize = getFileSize("uploadFile");  //文件大小
        if (fileSize == -1) {
            layer.tips('文件不能为空!',
                '#uploadFile', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
            return;
        } else if (fileSize == 0) {
            layer.tips('文件不能为空!',
                '#uploadFile', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
            return;
        } else if (fileSize >= 31) {
            layer.msg("文件不能超过31M", {icon: 2});
            return;
        }
    	var sensitiveWordList = new Array(); 
    	var fAudioName = $("#fAudioName").val();
    	var file = $("#uploadFile").val();
    	var fileName = getFileName(file);
    	$.ajax({
             type: "get",
             async: false,
             url: "${ctx}/broadcast/audioManage/getSensitiveWords",
             dataType:"json",
             success : function(result) {
                sensitiveWordList = result.data;
            }
        });
   	   if(sensitiveWordList.length!=0){
          	for(var i=0;i<sensitiveWordList.length;i++){
          		var sensitiveWord = sensitiveWordList[i].value;
          		if(fAudioName.indexOf(sensitiveWord) != -1 ){
          			layer.tips('音频名称含有敏感字，无法上传',
         	                '#fAudioName',{
         	                    tips: [2,'red'],
         	                    tipsMore: true
         	                }
          	        );
          			return;
          		}
          		if(fileName.indexOf(sensitiveWord) != -1 ){
          			layer.tips('上传文件名含有敏感字，无法上传',
         	                '#uploadFile',{
         	                    tips: [2,'red'],
         	                    tipsMore: true
         	                }
          	        );
          			return;
          		}
          	}
        }
        uploadFile();
    });
	
    //获取上传文件的大小
    function getFileSize(eleId) {
        try {
            var size = 0;
            size = $('#' + eleId)[0].files[0].size;//byte
            size = size / 1024;//kb
            size = size / 1024;//mb
            //alert('上传文件大小为' + size + 'M');
            return size;
        } catch (e) {
            //layer.msg("错误：" + e);
            return -1;
        }
    }

    //上传文件方法
    function uploadFile() {  
        var fAudioName = $("#fAudioName").val();
        var fRemark = $("#fRemark").val();
        var form = new FormData();
        if(fAudioName.length==0){
            layer.tips('请输入音频名称',
                '#fAudioName',{
                    tips: [2,'red'],
                    tipsMore: true
                }
            );
            return;
        }
        if(fRemark.length==0){
            fRemark=null;
        }
        var formData = new FormData($("#uploadForm")[0]);  //重点：要用这种方法接收表单的参数
            layer.load(2);
                $.ajax({
                	/*url: "${ctx}/ftp/ftpUpload",*/
                	url: "${ctx}/broadcast/ftps/upload/" + second +"/"+fAudioName+"/"+fRemark,
                    type: "post",
                    data: formData,
                    processData : false,
                    // 告诉jQuery不要去设置Content-Type请求头
                    contentType : false,
                    async : false,
                    success: function (data) {
                        $('#add_audio_modal').modal('hide');
                        $('#tab_audioManage').bootstrapTable('refresh');
                        layer.msg(data.msg, {icon: 1});
                        layer.closeAll('loading');
                        document.getElementById('uploadForm').reset();
                    },
                    error: function (e) {
                        layer.msg("上传失败");
                        layer.closeAll('loading');
                    }
                });

            second = 0;

    }


    //删除操作
    $("#delete_btn").click(function () {

        var checked = $('#tab_audioManage').bootstrapTable('getSelections');
        var del_ids = "";
        if (checked.length == 0) {
            layer.msg('请选择要删除的记录', {icon: 2});
        } else {
            layer.confirm('确认删除'+checked.length+"条记录?", {icon: 3, title: '操作提示'}, function (index) {
            	for (var i = 0; i < checked.length; i++) {
                    del_ids += checked[i].fId + ",";
                }
               layer.load(2);
               $.post('${ctx}/broadcast/audioManage/checkUsed/'+del_ids, '', function (result) {
                   	if(result){
                   		 layer.msg("所选音频文件正在使用，无法删除", {icon: 2});
                   		 layer.closeAll('loading');
                   	}else{
                   	     $.post('', '_method=delete&ids=' + del_ids, function (result) {
                             $('#tab_audioManage').bootstrapTable('refresh');
                             layer.msg(result.msg, {icon: 1});
                             layer.closeAll('loading');
                         });
                   	}

               });

            });
        }
    });


    //更新操作
    $("#update_btn").click(function () {
        var checked = $('#tab_audioManage').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg('请选择要修改的记录', {icon: 2});
            return;
        }
        else if (checked.length > 1) {
            layer.msg('只能选择一个记录', {icon: 2});
            return;
        }
        else {
            //dataShow(checked[0]);
            $("#audioName").val(checked[0].fAudioName);
            $('#update_audio_modal').modal('show');


        }
    })

    $("#succUpdate_button").click(function () {
        var checked = $('#tab_audioManage').bootstrapTable('getSelections');
        var audioName = $("#audioName").val();
        var sensitiveWordList = new Array(); 
    	$.ajax({
             type: "get",
             async: false,
             url: "${ctx}/broadcast/audioManage/getSensitiveWords",
             dataType:"json",
             success : function(result) {
                sensitiveWordList = result.data;
            }
        });
   	   if(sensitiveWordList.length!=0){
          	for(var i=0;i<sensitiveWordList.length;i++){
          		var sensitiveWord = sensitiveWordList[i].value;
          		if(audioName.indexOf(sensitiveWord) != -1 ){
          			layer.tips('修改名称含有敏感字，无法修改',
         	                '#audioName',{
         	                    tips: [2,'red'],
         	                    tipsMore: true
         	                }
          	        );
          			return;
          		}        	
          	}
        }
        if (audioName.length == 0) {
            layer.tips('音频名不能为空!',
                '#audioName', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
            return;
        }/*else if(audioName.substr(audioName.length-4,audioName.length)!=".mp3"){
            layer.tips('文件格式只能是.mp3!',
                '#audioName',{
                    tips: [2,'red'],
                    tipsMore: true
                }
            );
            return;
        }
*/
        //if(update_flag==0) return;
        layer.load(2);
        $.post('${ctx}/broadcast/audioManage/update/'+audioName+'/'+checked[0].fId, '', function (result) {
            if (result.status === 200) {
                $('#update_audio_modal').modal('hide');
                $('#tab_audioManage').bootstrapTable('refresh');
                layer.msg(result.msg, {icon: 1});
                layer.closeAll('loading');
                document.getElementById('update_form').reset();
                update_flag=0;
            }
            layer.closeAll('loading');
        });
    })
    //获取上传文件时间
    function myFunction(ele) {
        second=parseInt(document.getElementById(ele).duration);
        alert(second);
    }




    function check(){
        var audioName = document.getElementById("audioName").value;
       // alert(audioName)
        $.ajax({
            type: 'post',
            url: '${ctx}/broadcast/audioManage/getAll/',
            data: {name: audioName},
            success: function (result) {
                if (result.data == "true") {
                    update_flag = 0;
                    layer.tips('该音频文件名已存在，请更换音频名继续修改',
                        '#audioName', {
                            tips: [2, 'red'],
                            tipsMore: true
                        }
                    );
                } else {
                    update_flag = 1;
                }
            }
        });
    }


    function changeFile1(ele,index) {
        var video = document.getElementById(ele).files[0];
        var url = URL.createObjectURL(video);
        document.getElementById("aa").src = url;

    }
    //将音乐时长秒转换为小时和分钟，秒
    function getTime(data) {
        var hour = parseInt(data / 3600);
        var minute = parseInt(data / 60);
        var second = parseInt(data % 60);
        if (hour != 0) {
            return hour + "小时" + minute + "分" + second + "秒";
        } else if (minute != 0) {
            return minute + "分" + second + "秒";
        } else {
            return second + "秒"
        }
    }

    function dataShow(checked){
        if(checked.fAudioName=='null') checked.fAudioName="";
        if(checked.fRemark=='null') checked.fRemark="";
        $("#audio_modal span[name='fId']").text(checked.fId);
        $("#audio_modal span[name='fAudioName']").text(checked.fAudioName);
        $("#audio_modal span[name='fAudioUrl']").text(checked.fAudioUrl);
        $("#audio_modal span[name='fTime']").text(checked.fTime+'秒');
        $("#audio_modal span[name='fBitRate']").text(checked.fBitRate+'Kbps');
        $("#audio_modal span[name='fSampleRate']").text(checked.fSampleRate+'KHZ');
        if(checked.fCreateTime!=checked.fUpdateTime){
            $("#audio_modal span[name='fOperatorId']").text(checked.operator);
            $("#audio_modal span[name='fUpdateTime']").text(new Date(checked.fUpdateTime).format('yyyy-MM-dd HH:mm:ss'));
        }
        $("#audio_modal span[name='fCreatorId']").text(checked.creator);
        $("#audio_modal span[name='fCreateTime']").text(new Date(checked.fCreateTime).format('yyyy-MM-dd HH:mm:ss'));
        $("#audio_modal span[name='fRemark']").text(checked.fRemark);
        $("#audio_modal span[name='fAudioSize']").text(formatFileSize(parseInt(checked.fAudioSize)));

    }

    $('body').on('hidden.bs.modal', '.modal', function () {
        document.getElementById("uploadForm").reset();
        $("#audio_modal span").text("");
        $(".modal-dialog").css({"top":"0","bottom":"0","left":"0","right":"0"});
    });
    $(".modal-dialog").draggable();

</script>
</html>
