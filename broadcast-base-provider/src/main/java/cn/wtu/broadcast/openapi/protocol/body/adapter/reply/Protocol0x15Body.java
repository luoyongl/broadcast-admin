package cn.wtu.broadcast.openapi.protocol.body.adapter.reply;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Protocol0x15Body implements Serializable {
	
	private static final long serialVersionUID = -3758676149117619973L;
	//保留，取值为”1111”
	/*byte reserved;*/
	//BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范
	String front_code_reserved;
	//记录数
	String record_number;
	
	List<RecordInfo> records = new ArrayList<RecordInfo>();

	public static class RecordInfo{
		//保留，取值为”1111”
		/*byte reserved;*/
	/*	byte reserved;*/
		//BCD编码的应急广播消息标识符, 共35个数字，其定义见GD/J XXXX-XXXX应急广播消息格式规范。
		/*byte[] ebm_id;*/
		String ebm_id_reserved;
		
		/*
		0：未处理
		1：等待播发，指未到消息播发时间
		2：播发中
		3：播发成功
		4：播发失败，包括播发全部失败、播发部分失败、未按要求播发等情况
		5：播发取消
		*/
		String task_state;

		/*
		1：应急广播县平台；
		2：输入通道；
		3：电话；
		4：短信；
		5：无线或卫星信号
		*/
		String   program_resource;
		/*
		应急广播类型：
		0：保留；
		1：发布系统演练；
		2：模拟演练；
		3：实际演练；
		4：应急广播；
		5：日常广播；
		其他：保留；
		*/
		String ebm_class;
		/*
		 应急广播事件级别：
		0：缺省；
		1：1级（特别重大）；
		2：2级（重大）；
		3：3级（较大）；
		4：4级（一般）；
		其他：保留；
		*/
		String ebm_level;
		//应急广播事件类型：详见附录A
		String ebm_type;
		//参考本协议中的时间格式约定
		String start_time;
		//参考本协议中的时间格式约定
		String end_time;
		//参考本协议中的音量格式约定
		String volume;
		//输入通道编号，program_resource取值为2时该通道号不为0，其余均为0
		String input_channel_id;
		//输出通道数量
		String output_channel_number;
		
		List<OutputChannelInfo> outputChannels = new ArrayList<OutputChannelInfo>();
		
		public static class OutputChannelInfo{
			//输出通道类型
			String output_channel_type;
			//输出通道编号
			String output_channel_id;
			public String getOutput_channel_type() {
				return output_channel_type;
			}
			public void setOutput_channel_type(String output_channel_type) {
				this.output_channel_type = output_channel_type;
			}
			public String getOutput_channel_id() {
				return output_channel_id;
			}
			public void setOutput_channel_id(String output_channel_id) {
				this.output_channel_id = output_channel_id;
			}
		}
		
		//电话号码长度
		String tel_length;
		
		String tel_number;
		
		//应急广播消息覆盖的资源码数量
		String resource_code_number;
		//每个资源码长度
		String resource_code_length;
		
		List<ResourceInfo> resource_codes = new ArrayList<ResourceInfo>();
		
		public static class ResourceInfo{
			
			//BCD编码的资源码信息（前四位是保留位，取值为“1111”）
			String resource_code;

			public String getResource_code() {
				return resource_code;
			}

			public void setResource_code(String resource_code) {
				this.resource_code = resource_code;
			}	
		}
		
		public String getEbm_id_reserved() {
			return ebm_id_reserved;
		}

		public void setEbm_id_reserved(String ebm_id_reserved) {
			this.ebm_id_reserved = ebm_id_reserved;
		}

		public String getTask_state() {
			return task_state;
		}

		public void setTask_state(String task_state) {
			this.task_state = task_state;
		}

		public String getProgram_resource() {
			return program_resource;
		}

		public void setProgram_resource(String program_resource) {
			this.program_resource = program_resource;
		}

		public String getEbm_class() {
			return ebm_class;
		}

		public void setEbm_class(String ebm_class) {
			this.ebm_class = ebm_class;
		}

		public String getEbm_level() {
			return ebm_level;
		}

		public void setEbm_level(String ebm_level) {
			this.ebm_level = ebm_level;
		}

		public String getEbm_type() {
			return ebm_type;
		}

		public void setEbm_type(String ebm_type) {
			this.ebm_type = ebm_type;
		}

		public String getStart_time() {
			return start_time;
		}

		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}

		public String getEnd_time() {
			return end_time;
		}

		public void setEnd_time(String end_time) {
			this.end_time = end_time;
		}

		public String getVolume() {
			return volume;
		}

		public void setVolume(String volume) {
			this.volume = volume;
		}

		public String getInput_channel_id() {
			return input_channel_id;
		}

		public void setInput_channel_id(String input_channel_id) {
			this.input_channel_id = input_channel_id;
		}

		public String getOutput_channel_number() {
			return output_channel_number;
		}

		public void setOutput_channel_number(String output_channel_number) {
			this.output_channel_number = output_channel_number;
		}

		public List<OutputChannelInfo> getOutputChannels() {
			return outputChannels;
		}

		public void setOutputChannels(List<OutputChannelInfo> outputChannels) {
			this.outputChannels = outputChannels;
		}

		public String getTel_length() {
			return tel_length;
		}

		public void setTel_length(String tel_length) {
			this.tel_length = tel_length;
		}

		public String getTel_number() {
			return tel_number;
		}

		public void setTel_number(String tel_number) {
			this.tel_number = tel_number;
		}

		public String getResource_code_number() {
			return resource_code_number;
		}

		public void setResource_code_number(String resource_code_number) {
			this.resource_code_number = resource_code_number;
		}

		public String getResource_code_length() {
			return resource_code_length;
		}

		public void setResource_code_length(String resource_code_length) {
			this.resource_code_length = resource_code_length;
		}

		public List<ResourceInfo> getResource_codes() {
			return resource_codes;
		}

		public void setResource_codes(List<ResourceInfo> resource_codes) {
			this.resource_codes = resource_codes;
		}
		
		
	}
	public String getFront_code_reserved() {
		return front_code_reserved;
	}

	public void setFront_code_reserved(String front_code_reserved) {
		this.front_code_reserved = front_code_reserved;
	}

	public String getRecord_number() {
		return record_number;
	}

	public void setRecord_number(String record_number) {
		this.record_number = record_number;
	}

	public List<RecordInfo> getRecords() {
		return records;
	}

	public void setRecords(List<RecordInfo> records) {
		this.records = records;
	}
	
}
