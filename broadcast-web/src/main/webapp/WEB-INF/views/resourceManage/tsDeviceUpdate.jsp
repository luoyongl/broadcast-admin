<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("regionList", RegionData.getUserZTreeList2Json());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="../common/css.jsp" %>
    <style>
        select {color: #ffffff !important;}
        .modal input {width: 80% !important}
        .modal-body {padding-top: 18px}
        table {
            table-layout: fixed;
        }
        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
    </style>
    <meta charset="UTF-8">
</head>
<body>
<h4>
    <b>当前位置:资源管理>>设备管理>>ts设备升级</b>
</h4>
<div class="content">
    <div class="handle">
        <button class="upgrade_updatefile_btn btn btn-info">升级</button>
        <button class="add_updatefile_btn btn btn-info">新增</button>
        <button class="update_updatefile_btn btn btn-info">修改</button>
        <button class="delete_updatefile_btn btn btn-danger">删除</button>
    </div>
    <table data-height="450" id="tab_updateFile" class="table table-hover">
    </table>
</div>

<!-- 升级模态框（Modal） -->
	<div class="modal fade" id="upgrade_updatefile_modal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">升级<h4>
					</div>
					<div class="modal-body">
						<div class="form-group col-sm-12" align="center">						
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

<!-- 新增模态框（Modal） -->
<div class="modal fade" id="add_updateFile_modal" tabindex="-1"
     role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">新增</h4>
            </div>
            <div class="modal-body col-sm-12">
                <form id="form_updatefile" class="form-inline">
                   <input type="hidden" name="fIpOrTs" value="1"/>
                   <div class="content_left col-sm-8">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">厂家</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="fManufacturerNumber" style="width:80%!important">
                                    <c:forEach items="${manufacturerList}" var="manufacturer">
                                        <option value="${manufacturer.fId}">${manufacturer.fManufacturerName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">设备类型</label>
                            <div class="col-sm-8">
                                 <select class="form-control" data-validate="required" style="width:80%!important"
                                        name="fDeviceType">
                                        <option value="4">适配器</option>
                                        <option value="5">音柱</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">硬件版本号</label>
                            <div class="col-sm-8">
                                <input name="fHardwareVersion" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">旧软件版本号</label>
                            <div class="col-sm-8">
                                <input name="fOldSoftwareVersion" type="text" class="form-control ">
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-4 control-label">升级文件</label>
                            <div class="col-sm-8 control-label">
                                <input id="update_file" type="file" title="请选择图片"/>
                                <input style="display: none;" name="fFileAddress" type="text"/>
                            </div>
                        </div>
                    </div>
                     <div class="content_right">
                            <label>&nbsp;播发区域</label>
                            <div class="right-tree" style="height:380px">
							<ul id="ztree" class="ztree"></ul>
						</div>
                        </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="updatefile_submit" type="button" class="add_updatefile btn btn-info">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 修改模态框（Modal） -->
<div class="modal fade" id="update_updateFile_modal" tabindex="-1"
     role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title">修改</h4>
            </div>
            <div class="modal-body col-sm-12">
                <form id="updatefile" class="form-inline">
                    <div class="modal-body-right col-sm-10 pull-left">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label">文件名称</label>
                            <div class="col-sm-9 control-label">
                                <input name="fFileName" type="text" class="form-control ">
                            </div>
                        </div>
                    </div>
                    <div class="null"></div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="update_updatefile btn btn-info">确定</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
    var fileUrl = 0;
    var fileName='';
    $(function () {
    	$(".modal-dialog").draggable();
        //页面加载完成后，执行这段代码----动态创建ztree
        var setting2 = {
            check: {
                enable: true
            }

        };
        //构造节点数据
        var regionData = ${regionList};
        //调用API初始化ztree
        loadRegionTree("ztree", regionData);
    });
    
    $(".upgrade_updatefile_btn").on("click", function () {
        //$("#updatefile_submit").addClass("add_updatefile").removeClass("update_updatefile");
        $("#upgrade_updatefile_modal").modal();
    })
    
    $(".add_updatefile_btn").on("click", function () {
        //$("#updatefile_submit").addClass("add_updatefile").removeClass("update_updatefile");
        $("#add_updateFile_modal").modal();
    })

    $(".update_updatefile_btn").on("click", function () {
        let checked = $('#tab_updateFile').bootstrapTable('getSelections');
        if (checked.length == 0) {
            layer.msg("请选择要修改的记录", {icon: 2});
        } else if (checked.length > 1) {
            layer.msg("一次只能修改一条记录", {icon: 2});
        } else {
            $("#update_updateFile_modal input[name='fFileName']").val(checked[0].fFileName);
            $("#update_updateFile_modal").modal();
            $(".update_updatefile").click(function () {
                let checkname=confirmName($("#update_updateFile_modal input[name='fFileName']"));
                if (!checkname) {
                    layer.confirm('是否确定修改？', {
                        title: ['操作提示'],
                        btn: ['确定', '取消'] //按钮
                    }, function () {
                        $.ajax({
                            url: "${ctx}/resourceManage/updateFile/UpdateFile?fId="+checked[0].fId,
                            type: 'post',
                            data:$("#updatefile").serialize(),
                            success: function (data) {
                                layer.msg(data.msg, {icon: 1});
                                $("#update_updateFile_modal").modal('hide');
                                $("#tab_updateFile").bootstrapTable('refresh');
                            }
                        });
                    }, function () {
                    })
                }
            })
        }
    })

    $(".modal").on("click", ".add_updatefile", function () {
        $('input[name="fFileAddress"]').val(fileUrl);
        let flag=confurmEmpty("#form_updatefile");
        let checkname=confirmName($('input[name="fFileName"]'));
        if (flag&&!checkname) {
            layer.confirm('是否确定新增？', {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
            }, function () {
                 var data = "";
                var nodes = $.fn.zTree.getZTreeObj("ztree").getCheckedNodes(true);
                $.each(nodes, function (i, item) {
                    data = data + item.id;
                    if (i < nodes.length - 1) {
                        data = data + ',';
                    }
                });
                let fBroadcastArea = data; 
                    $.ajax({
                        url: "${ctx}/resourceManage/tsDeviceUpdate/addUpdateFile",
                        type: 'post',
                        data:$("#form_updatefile").serialize()+"&fFileName="+fileName +"&fBroadcastArea="+fBroadcastArea ,
                        success: function (data) {
                            layer.msg(data.msg, {icon: 1});
                            $("#add_updateFile_modal").modal('hide');
                            $("#tab_updateFile").bootstrapTable('refresh');
                        }
                    });
            }, function () {
            })
        }
    })

    $('#update_file').change(function() {
        let form = new FormData();
        form.append("file",document.getElementById("update_file").files[0]);
        fileName=document.getElementById("update_file").files[0].name;
        $.ajax({
            url: "${ctx}/common/upload?type="+4,
            type: "post",
            data: form,
            async:false,
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
    });

    $(".delete_updatefile_btn").on("click", function () {
        var checked = $('#tab_updateFile').bootstrapTable('getSelections');
        var ids = "";
        if (checked.length == 0) {
            layer.msg("请选择要删除的记录", {icon: 2});
        } else {
            layer.confirm('是否确定删除这' + checked.length + '条记录？', {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
            }, function () {
                for (i = 0; i < checked.length; i++) {
                    ids += checked[i].fId + ",";
                }
                $.ajax({
                    async: false,
                    url: "${ctx}/resourceManage/updateFile/deleteFile?fId=" + ids,
                    type: "post",
                    success: function (data) {
                        layer.msg(data.msg, {icon: 1});
                        $("#tab_updateFile").bootstrapTable('refresh');
                    }
                })
            }, function () {
            })

        }
    })

    $(".Upgrade").on("click", function () {
        var checked = $('#tab_updateFile').bootstrapTable('getSelections');
        var ids = "";
        if (checked.length == 0) {
            layer.msg("请选择升级文件", {icon: 2});
        } else {
            layer.confirm('是否确定升级此文件对应的设备？', {
                title: ['操作提示'],
                btn: ['确定', '取消'] //按钮
            }, function () {
            	//跳转后台 返回升级结果
                layer.msg("升级成功", {icon: 1});
            }, function () {
            })

        }
    })

    function confurmEmpty(form) {
        var flag = true;
        var inputs = $(form + " " + "input[type='text']");
        for (var i = 0; i < inputs.length; i++) {
            if ($(inputs[i]).is(':visible')) {
                if (!inputs[i].value) {
                    layer.tips('请填写完整', $(form + " " + "input[type='text']")[i], {
                        tips: [2, 'red'],
                        tipsMore: true
                    });
                    flag = false;
                }
            }
        }
        if (!checkFile()) {
            flag = false;
        }
        ;
        return flag;
    }

    function confirmName(e){
        let result=false;
        let title=e.val();
        if(title!=null&&title!=""){
            $.ajax({
                url:"${ctx}/resourceManage/updateFile/checkUpdateFileName",
                type:"post",
                async:false,
                dataType:"json",
                data:{
                    title:title,
                },
                success:function(data){
                    if(data.status==400){
                        layer.tips(data.msg,e,{
                            tips: [2,'red'],
                            tipsMore: true,
                            time:800
                        });
                        result=true;
                    }else{
                        result=false;
                    }
                },
            })
            return result;
        }
    }

    function checkFile() {
        let flag=true;
        let checkfile=document.getElementById("update_file").files[0];
        if (checkfile ==undefined) {
            layer.tips('文件不能为空!',
                '#update_file', {
                    tips: [2, 'red'],
                    tipsMore: true
                }
            );
            flag = false;
        }
        return flag;
    }

    $("select").change(function () {
        var text = $(this).find("option:selected").attr("value");
        $(this).attr("value", text);
    });
    var columns = [
        [{
            checkbox: true
        }, {
            field: 'Realmanufacturer',
            title: '厂家名称',
            align: 'center',
            width: "10%",
        }, {
            field: 'fDeviceType',
            title: '设备类型',
            align: 'center',
            width: "10%",
            formatter: function (data) {
                if(data == 4){
                	return "适配器";
                }else if(data == 5){
                	return "音柱";
                }
            }
        }, {
            field: 'fHardwareVersion',
            title: '硬件版本号',
            align: 'center',
            width: "12%",
        }, {
            field: 'fOldSoftwareVersion',
            title: '旧软件版本号',
            align: 'center',
            width: "12%",
        }, {
            field: 'broadcastArea',
            title: '升级区域',
            align: 'center',
            width: "12%",
        },{
            field: 'fFileName',
            title: '文件名称',
            align: 'center',
            width: "15%",
        }, {
            field: 'fCreateTime',
            title: '创建时间',
            align: 'center',
            width: "15%",
            sortable: true,
            formatter: function (time) {
                return time ? new Date(time).format('yyyy-MM-dd HH:mm:ss') : "";
            },
        }, {
            field: 'operator',
            title: '操作者',
            align: 'center',
        }]
    ];

    $(function () {
        $('#tab_updateFile').bootstrapTable({
            url: "${ctx}/resourceManage/tsDeviceUpdate/selectUpdateFile",
            method: 'post',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            sortable: true,
            columns: columns,
            search: true, //是否显示表格搜索
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
            classes: 'table-no-bordered',
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                    fIpOrTs:1,//ip还是ts，0-ip,1-ts
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
</script>
</body>
</html>
