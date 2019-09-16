/**
 * 日期格式化扩展
 */
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    var week = {
        "0": "日",
        "1": "一",
        "2": "二",
        "3": "三",
        "4": "四",
        "5": "五",
        "6": "六"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "星期" : "周") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};

function formatFileSize(size){
    if(size/(1024*1024*1024)>1){
		return (size/(1024*1024*1024)).toFixed(2) + "GB";
	}else if(size/(1024*1024>1)){
		return (size/(1024*1024)).toFixed(2) + "MB";
	}else if(size/(1024>1)){
		return (size/(1024)).toFixed(2) + "KB";
	}else{
		return size + "B";
	}
}

function broadcastServerStateCheck(ctx){
	var checkResult = false;
	$.ajax({
		async:false,
		data:{"fServerType":1},
		url:ctx + "/systemManage/serverState/getBroadcastServerState",
		type:"post",
		success:function(result){
            var data = result.data;
            var broadcastServerState = data.broadcastServerState;
            if(broadcastServerState == 1){
            	checkResult = true;
            } else {
            	layer.msg("调控服务器未启动，暂时无法制作与播发", {icon: 2});
            }
		}
	});
	
	return checkResult;
}
