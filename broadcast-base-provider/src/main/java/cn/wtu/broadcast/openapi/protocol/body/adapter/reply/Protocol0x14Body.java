package cn.wtu.broadcast.openapi.protocol.body.adapter.reply;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Protocol0x14Body implements Serializable {

	private static final long serialVersionUID = -4889857251703219792L;
	
	//BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范 + 保留，取值为”1111”
	String front_code_reserved;
	
	//输入通道数量
	String input_channel_number;
	
	List<InputChannelInfo> input_channels = new ArrayList<InputChannelInfo>();
	
	public static class InputChannelInfo {
		//通道号(唯一标识)
		String input_channel_id;
		//通道名称长度
		String input_channel_name_length;
		//通道名称
		String input_channel_name;
		//同一分组编号的输入通道为互斥通道，不同分组编号的通道为并行通道。
		String input_channel_group;
		//输入通道状态。1：空闲；2：占用；3：故障
		String input_channel_state;
		public String getInput_channel_id() {
			return input_channel_id;
		}
		public void setInput_channel_id(String input_channel_id) {
			this.input_channel_id = input_channel_id;
		}
		public String getInput_channel_name_length() {
			return input_channel_name_length;
		}
		public void setInput_channel_name_length(String input_channel_name_length) {
			this.input_channel_name_length = input_channel_name_length;
		}
		public String getInput_channel_name() {
			return input_channel_name;
		}
		public void setInput_channel_name(String input_channel_name) {
			this.input_channel_name = input_channel_name;
		}
		public String getInput_channel_group() {
			return input_channel_group;
		}
		public void setInput_channel_group(String input_channel_group) {
			this.input_channel_group = input_channel_group;
		}
		public String getInput_channel_state() {
			return input_channel_state;
		}
		public void setInput_channel_state(String input_channel_state) {
			this.input_channel_state = input_channel_state;
		}
	}

	public String getFront_code_reserved() {
		return front_code_reserved;
	}

	public void setFront_code_reserved(String front_code_reserved) {
		this.front_code_reserved = front_code_reserved;
	}

	public String getInput_channel_number() {
		return input_channel_number;
	}

	public void setInput_channel_number(String input_channel_number) {
		this.input_channel_number = input_channel_number;
	}

	public List<InputChannelInfo> getInput_channels() {
		return input_channels;
	}

	public void setInput_channels(List<InputChannelInfo> input_channels) {
		this.input_channels = input_channels;
	}	
}
