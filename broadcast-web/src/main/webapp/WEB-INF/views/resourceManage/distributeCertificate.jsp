<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ page import="cn.wtu.broadcast.config.RegionData,cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("ctx", request.getContextPath());
	request.setAttribute("config", SystemConfig.getMap());
	request.setAttribute("regionJson", RegionData.getZTreeListJson());
	request.setAttribute("regionMap", RegionData.getNameMapJson());
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>领用证书</title>
	<%@include file="../common/css.jsp" %>
	<style>
		table{
			table-layout:fixed;
		}
	</style>
</head>
<body>
<h4><b>当前位置:资源管理>>证书管理>>发放证书</b></h4>
<div class="content_table" >
	<div class="handle">
		<button class="btn btn-info" id="distributeCertificate">发放</button>
	</div>
	<table data-height="450" id="tab_receiveCertificate" class="table table-hover" style="word-break:break-all; word-wrap:break-all;"></table>
</div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript">
	var flag=0;
	var columns  =	[[{
		checkbox : true,
		valign:'middle',
	     }, {   field : 'fDeviceName',
				title :'设备名称',
				sortable : true,
				align : 'center',
				width :'10%',
				valign:'middle',
			},{   field : 'fDeviceResourceCode',
				title :'设备资源码',
				sortable : true,
				align : 'center',
				width :'12%',
				valign:'middle',
			},{field : 'fCertificatesNumber', 
			   title:'证书编号',
			   sortable : true,
			   align : 'center',
			   width :'12%',
			   valign:'middle',
			},{
				field : 'fCertificatesPeriodOfValidity',
				title :'证书有效期',
				sortable : true,
				align : 'center',
				width :'10%',
				valign:'middle',
				formatter:function(data,row,index){
					return ""+new Date(row.fEndDateOfValidity).format('yyyy-MM-dd');
				}
			},{
				field : 'fPrivateKey',
				title :'私钥',
				align : 'center',
				width :'25%',
				valign:'middle',
			},{
				field : 'fPublicKey',
				title :'公钥',
				align : 'center',
				valign:'middle',
			}]];

	$(function(){
		$('#tab_receiveCertificate').bootstrapTable({
			url :"../resourceManage/receiveCertificate/getCertificateList",
			method:'post',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			sortable: true,
			search: true, //是否显示表格搜索
			columns: columns,
			classes:'table-no-bordered',
			clickToSelect: true,
			sortable : true, // 是否启用排序
			sortOrder : "asc", // 排序方式
			pagination : true, // 是否显示分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 5, // 每页的记录行数（*）
			pageList : [5,10,20], // 可供选择的每页的行数（*）
			showRefresh : true, // 是否显示刷新按钮
			sidePagination: 'server',
			queryParamsType:"",
			queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
				return {//这里的params是table提供的
					Number: params.pageNumber,//从数据库第几条记录开始
					Size: params.pageSize,//找多少条
					searchText:params.searchText, //查询内容
					sortOrder:params.sortOrder, //排序方式
					sortName:params.sortName, //排序名称
				};
			},
			responseHandler: function (result) {
				if(result.status === 200){
				}
				return{
					total: result.data.total,
					rows: result.data.list
				};
			},
		});
	});

	$("#distributeCertificate").on("click",function(){
		var SlectLineData = $("#tab_receiveCertificate").bootstrapTable('getSelections');
		if(SlectLineData.length<=0){
			layer.msg("请选择要发放的对象",{icon: 2});
			return false;
		}else{
			layer.confirm('是否要发放该证书？',{
				title:['发放证书'],
				btn: ['确定','取消'] //按钮
			},function(){
				var ii = layer.load();
				//此处用setTimeout演示ajax的回调
				setTimeout(function(){
					layer.msg('证书发放成功!');
					layer.close(ii);

				}, 3000);
			},function(){})
		}

	});
</script>
</body>
</html>
