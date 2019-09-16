<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>日志管理 </title>
	<link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${ctx}/static/css/rightmain.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/static/css/common.css"/>
    <link href="${ctx}/static/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/bootstrap/css/bootstrap-datetimepicker.min.css"/>
    <style>
    	h4 b{
			font-size: 14px!important;
			color: #FFFFFF;
		}
		label {
			color: #ffffff;
		}
        .content {
            height: auto;
        }

        td, th {
            vertical-align: middle !important;
        }
	   	@media (max-width:1400px){
			.form-group {
				margin: 2.5% 0;
				padding: 0;
				padding-left: 15px;
			}
			.modal .form-group {
				margin: 1% 0;
				padding: 0;
				padding-left: 15px;
			}
			.headlink.pull-right li>a {
				display: block;
				margin-top: 50%;
			}
			.headnav.pull-left li {
				margin: 0px 5px;
				border: 1px solid #ffffff;
				border-radius: 8%;
				background-image: linear-gradient(to top, #0083f0, #12255e 40%, #12255e 60%, #0083f0);
			}
			
				.headnav.pull-left a {
				background-repeat: no-repeat;
				background-size: 40% 40%!important;
				background-position-x: 48%!important;
				background-position-y: 10%!important;
			}
			
			.headlink.pull-right li {
				width: 60px;
				display: inline-block;
				background-repeat: no-repeat;
				background-size: 40% 40%!important;
				background-position-x: 48%!important;
				background-position-y: 10%!important;
			}
			dd>.clearfix span {
			 height:33px;
			} 
		}
		@media (min-width:1400px){
			.form-group {
				margin: 3.5% 0px;
				padding: 0;
				padding-left: 15px;
			}
			.headlink.pull-right li>a {
				display: block;
				margin-top: 60%;
			}
			.headnav.pull-left li {
				margin: 0 5px;
				border: 1px solid #ffffff;
				border-radius: 8%;
				background-image: linear-gradient(to top, #0083f0, #12255e 40%, #12255e 60%, #0083f0);
			}
			
				.headnav.pull-left a {
				background-repeat: no-repeat;
				background-size: 50% 50%!important;
				background-position-x: 48%!important;
				background-position-y: 18%!important;
			}
			
			.headlink.pull-right li {
				display: inline-block;
				background-repeat: no-repeat;
				background-size: 50% 50%!important;
				background-position-x: 48%!important;
				background-position-y: 18%!important;
			}
			dd>.clearfix span {
			 height:43px;
			}
		}
    </style>
</head>
<body>
<h4><b>当前位置:系统管理>>日志管理</b></h4>
<div class="content">
	 <div class="form-group form-inline">
         <label>选择搜索时间段：</label>
         <!--指定 date标记-->
        <div class='input-group date' id='datetimepicker1'>
	        <input type='text' placeholder="起始时间" class="form-control" id="startTime"/>
	        <span class="input-group-addon">
	            <span class="glyphicon glyphicon-calendar"></span>
	        </span>
    	</div>
         <label  class="date-label">--</label>
         <div class='input-group date' id='datetimepicker2'>
             <input type='text' placeholder="结束时间" class="form-control" id="endTime"/>
             <span class="input-group-addon">
                 <span class="glyphicon glyphicon-calendar"></span>
             </span>
         </div>
         <input type='text' placeholder="请输入搜索内容" class="form-control" id="searchInfo" />
         <button class="btn btn-info" id="searchBtn">查询</button>
         <div class="handle">
        	<button class="btn btn-info" id="exportBtn">导出表格</button>
   		 </div>
    </div>
    <table id="tab_log" class="table table-hover"></table>
</div>
</body>

<%@include file="../common/js.jsp" %>
<script src="${ctx}/static/js/moment-with-locales.js"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
    $(function () {	
   	 	$('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss',
            locale: 'zh-CN',
        });
    	$('#datetimepicker2').datetimepicker({
             format: 'YYYY-MM-DD HH:mm:ss',
             locale: 'zh-CN',
        });
    	var startTime =  "";
        var endTime = "";
        var searchInfo = "";      
        var $tabLog = $('#tab_log');
        var operationLogType = ${operationTypeMap};
        var $bootstrapTable = $tabLog.bootstrapTable({
            url: "${ctx}/systemManage/log/list",
            method: 'get',
            sortable: false,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            search: false, //是否显示表格搜索
            pagination: true,
            sidePagination: 'server',
            smartDisplay: false,
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的           	
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    startTime: startTime,
                    endTime: endTime,
                    searchInfo: searchInfo
                };
            },
            classes: 'table table-no-bordered',
            columns: [[
                {
                    field: 'isChecked',
                    title: '序号',
                    width: "5%",
                    align: 'center',
                    formatter: function (value, row, index) {
                        var pageSize = $tabLog.bootstrapTable('getOptions').pageSize;
                        var pageNumber = $tabLog.bootstrapTable('getOptions').pageNumber;
                        return pageSize * (pageNumber - 1) + index + 1;
                    }
                }, {
                    field: 'fUsername',
                    title: '操作人',
                    align: 'center',
                    width: "10%",
                }, {
                    field: 'fOperationTime',
                    title: '操作时间',
                    width: "20%",
                    align: 'center',
                    formatter: function (time) {
                        return new Date(time).format('yyyy-MM-dd HH:mm:ss');
                    }
                }, {
                    field: 'fOperationType',
                    title: '操作类型',
                    align: 'center',
                    width: "15%",
                    formatter: function (value) {
                        return operationLogType[value];
                    }
                }, {
                    field: 'fOperationContent',
                    title: '操作内容',
                    align: 'center',
                    width: "25%",
                }, {
                    field: 'fOperationResult',
                    title: '操作结果',
                    align: 'center'
                }]],
            formatNoMatches: function () {
                return '无记录';
            },
            formatRecordsPerPage: function (pageNumber) {
                return '每页 ' + pageNumber + ' 条';
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return '当前 ' + pageFrom + ' 到 ' + pageTo + ' 条，共 ' + totalRows + ' 条记录,';
            },
            responseHandler: function (result) {
                return {total: result.data.total, rows: result.data.list};
            }
        });

        $('#exportBtn').click(function () {
            window.location.href = 'log/download';
        });
        
        $('#searchBtn').click(function () {
            startTime =  $('#startTime').val();
            endTime = $('#endTime').val();
            searchInfo = $('#searchInfo').val();      
            $.ajax({
                type: "post",
                url: "${ctx}/systemManage/log/getSearchTableInfo",
                data: {              
                	startTime : startTime,
                	endTime : endTime,
                	searchInfo : searchInfo
                }, 
                dataType:"json",
                success : function(result) {
                   var data = new Object();
                   data.rows = result.data.list;
                   data.total = result.data.total;
                   $("#tab_log").bootstrapTable('load', data);
               }
           });  
        });
        
    });
</script>
</html>
