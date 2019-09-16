package cn.wtu.broadcast.openapi.protocol.body.adapter.reply;

import java.io.Serializable;

public class Protocol0x12Body implements Serializable {

	private static final long serialVersionUID = -3673326237941144372L;
	// 执行结果代码,-1:未知错误,0:执行成功,1:数据长度错误,2:版本号错误,3:指令冲突错误,4~1000:保留,其他:保留
	String return_code;
	// 相应数据长度
	String return_data_length;
	// 执行结果描述
	String return_data;
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_data_length() {
		return return_data_length;
	}
	public void setReturn_data_length(String return_data_length) {
		this.return_data_length = return_data_length;
	}
	public String getReturn_data() {
		return return_data;
	}
	public void setReturn_data(String return_data) {
		this.return_data = return_data;
	}
}
