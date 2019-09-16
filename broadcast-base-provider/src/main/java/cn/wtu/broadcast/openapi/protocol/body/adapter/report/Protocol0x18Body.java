package cn.wtu.broadcast.openapi.protocol.body.adapter.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 任务开始上报(0x18)
 * 
 * @author Pr1p
 *
 */
public class Protocol0x18Body implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -829327885258677860L;

	// 保留，取值为”1111”
	//byte reserved;
	// BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	// BCD编码 92bit 23BCD, 23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	String reserved_and_front_code;
	
	/*
	 * //保留，取值为”1111” byte reserved;
	 */
	// BCD编码的应急广播消息标识符, 共35个数字，其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	String reserved_and_ebm_id;
	/*
	 * 1：应急广播县平台； 2：输入通道； 3：电话； 4：短信； 5：无线或卫星信号
	 */
	String program_resource;
	/*
	 * 应急广播类型： 0：保留； 1：发布系统演练； 2：模拟演练； 3：实际演练； 4：应急广播； 5：日常广播； 其他：保留；
	 */
	String ebm_class;
	/*
	 * 应急广播事件级别： 0：缺省； 1：1级（特别重大）； 2：2级（重大）； 3：3级（较大）； 4：4级（一般）； 其他：保留；
	 */
	String ebm_level;
	// 应急广播事件类型：详见附录A
	String ebm_type;
	// 输入通道编号
	String input_channel_id;
	// 输出通道数量
	String output_channel_number;
	//
	List<output_channel_Info> output_channels = new ArrayList<output_channel_Info>();

	public static class output_channel_Info {
		// 输出通道类型
		String output_channel_type;
		// 输出通道编号
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

	// 电话号码长度，不是电话和短信开播时该数据填0
	String tel_length;
	//
	String tel_number;
	// 参考本协议中的音量格式约定
	String volume;
	// 应急广播消息覆盖的资源码数量
	String resource_code_number;
	// 每个资源码长度
	String resource_code_length;
	//
	List<byte[]> resource_codes = new ArrayList<byte[]>();
	public String getReserved_and_front_code() {
		return reserved_and_front_code;
	}
	public void setReserved_and_front_code(String reserved_and_front_code) {
		this.reserved_and_front_code = reserved_and_front_code;
	}
	public String getReserved_and_ebm_id() {
		return reserved_and_ebm_id;
	}
	public void setReserved_and_ebm_id(String reserved_and_ebm_id) {
		this.reserved_and_ebm_id = reserved_and_ebm_id;
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
	public List<output_channel_Info> getOutput_channels() {
		return output_channels;
	}
	public void setOutput_channels(List<output_channel_Info> output_channels) {
		this.output_channels = output_channels;
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
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
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
	public List<byte[]> getResource_codes() {
		return resource_codes;
	}
	public void setResource_codes(List<byte[]> resource_codes) {
		this.resource_codes = resource_codes;
	}




	

}
