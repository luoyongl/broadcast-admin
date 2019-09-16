<%--
  Created by IntelliJ IDEA.
  User: AYY
  Date: 2019/1/8
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.wtu.broadcast.config.RegionData" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("regionMap", RegionData.getNameMapJson());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>终端回传录音</title>
    <%@include file="../common/css.jsp" %>
    <style type="text/css">
        select{
            border: none;
            appearance: none;
            -moz-appearance: none;
            -webkit-appearance: none;
        }
        select::-ms-expand { display: none; }
        table {
            table-layout: fixed;
        }
        table tbody tr td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
    </style>
</head>
<body>
<h4><b>当前位置:监测监控>>终端回传录音</b></h4>
<div class="content">
    <div class="sound_content_left" style="border-right: 1px solid #0074D9">
        <table id="tab_terminalSound" class="table"></table>
    </div>

</div>

<%@include file="../common/js.jsp" %>
<script>
  var columns = [
      [{
          field:'',
          title:' ',
          width:20,
          formatter:function () {
              return '';
          }
      }, {
          field: 'fRealControlDevice',
          title: '设备名称',
          align: 'center',
          width: "10%",
      }, {
          field: 'fId',
          title: '广播ID',
          align: 'center',
          width: "5%",
      }, {
          field: 'fRealMessageSource',
          title: '广播来源',
          align: 'center',
          width: "15%",
      }, {
          field: 'fBroadcastType',
          title: '广播类型',
          align: 'center',
          width: "10%",
          formatter: function (value, row, index) {
              if (row.fBroadcastType == 1) {
              return "系统演练";
          } else if (row.fBroadcastType == 2) {
              return "模拟演练";
          } else if (row.fBroadcastType == 3) {
              return "实际演练";
          } else if (row.fBroadcastType == 4) {
              return "应急广播";
          } else if (row.fBroadcastType == 5) {
              return "日常广播";
          } else if (row.fBroadcastType == 6) {
              return "升级广播";
          } else if (row.fBroadcastType == 7) {
              return "广播预案-应急广播";
          } else if (row.fBroadcastType == 8) {
              return "广播预案-日常广播";
          } else if (row.fBroadcastType == 9) {
              return "广播预案-实际演练";
          } else if (row.fBroadcastType == 10) {
              return "广播预案-系统演练";
          } else if (row.fBroadcastType == 11) {
              return "广播预案-模拟演练";
          } else if (row.fBroadcastType == 12) {
              return "定时广播";
          }
          }
      }, {
          field: 'fRealMessageType',
          title: '消息类型',
          align: 'center',
          width: "10%",
      }, {
          field: 'fRealMessageLevel',
          title: '消息级别',
          align: 'center',
          width: "10%",
      }, {
          field: 'fVolumeControl',
          title: '音量',
          align: 'center',
          width: "5%",
      }, {
          field: 'fAudioByte',
          title: '试听',
          align: 'center',
          formatter: function (value,row,index) {
              let audioId=row.fReturnAudioId;
         return  '<audio controls="controls" controlsList="nodownload" style="width:80%;height:30px ;padding: 3px;">' +
             '<source  src="${ctx}/monitor/terminalSound/getAudio/'+audioId+'?type=3&PATHID=mp" type="audio/mpeg"></audio>';
          }
      }]
  ];
    $(function () {
        regionMap = ${regionMap};
        $('#tab_terminalSound').bootstrapTable({
            url: "${ctx}/monitor/terminalSound/selectTerminalSoundList?fBroadcastType=2&devType=4", // 请求后台的URL（*）
            method: 'post',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            search: true, //是否显示表格搜索
            columns: columns,
            classes: 'table-no-bordered',
            sortable: true, // 是否启用排序
            sortOrder: "desc", // 排序方式
            pagination: true, // 是否显示分页（*）
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 5, // 每页的记录行数（*）
            pageList: [5, 10, 20], // 可供选择的每页的行数（*）  */
            showRefresh: true, // 是否显示刷新按钮 */
            clickToSelect: true,
            sidePagination: 'server',
            queryParamsType: "",
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                return {//这里的params是table提供的
                    pageNumber: params.pageNumber,//从数据库第几条记录开始
                    pageSize: params.pageSize,//找多少条
                    searchText: params.searchText, //查询内容
                    sortOrder: params.sortOrder, //排序方式
                    sortName: params.sortName, //排序名称
                    fStartTime: $('input[name="fStartTime"]').val(),
                    fEndTime: $('input[name="fEndTime"]').val()
                };
            },
            responseHandler: function (result) {
                if (result.status === 200) {
                    //layer.close(ii);
                }
                terminalStatusRealRecord = result.data.list;
                return {
                    total: result.data.total,
                    rows: result.data.list
                };
            }
        });
    });

    $("table").on("change",".returnAudio",function () {
        var rowIndex=$(this).parent("td").parent("tr").attr("data-index");
        var getsrc=($(this).find("option:selected").attr("src"));
        var getTime=($(this).find("option:selected").attr("time"));
        console.log(getTime);
        console.log(new Date(getTime).format('yyyy-MM-dd HH:mm:ss'));
        $(".returntime").eq(rowIndex).text(new Date(getTime).format('yyyy-MM-dd HH:mm:ss'));
        $("audio").eq(rowIndex).attr("src",getsrc);
    })
    function Trim(str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
</script>
</body>
</html>

