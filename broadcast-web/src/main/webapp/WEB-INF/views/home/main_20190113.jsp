<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试-上传lxg</title>
</head>
<body>

<%-- <form id="itemForm"	action="${ctx}/upload" method="post" enctype="multipart/form-data"> --%>
<form id="itemForm"	action="${ctx}/upload" method="post" enctype="multipart/form-data">
  <input type="file" id="image" name="file"/>
  <input type="button" value="上传" onclick="fun()"/>
</form>

<script src="${ctx}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
function fun(){
	var form = new FormData();
	form.append("type","1");
	form.append("uploadfile",document.getElementById("image").files[0]);
	$.ajax({
	    url: "${ctx}/common/upload",
	    type: "post",
	    data: form,
	    processData: false,
	    contentType: false,
	    success: function (data) {
	       alert("1111");
	    },
	    error: function (e) {
	    	alert(e);
	    }
	});
}
</script>
</body>
</html>