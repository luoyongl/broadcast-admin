package cn.wtu.broadcast.openapi.protocol.body.adapter.reply;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pr1p 查询输出通道回复(0x13)
 *
 */
public class Protocol0x13Body implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2368365025677407482L;
	/**
	 * 
	 */
	//private static final long serialVersionUID;
	
	//BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范 + 保留，取值为”1111”
	String front_code_reserved;
	//传输通道数量
	String output_channel_number;
	//
	List<output_channel_info> output_channels= new ArrayList<output_channel_info>();
	
	public static class output_channel_info {
	//通道号(唯一标识)
	String output_channel_id;
	//通道类型 1：调频 2：有线数字电视 3：地面数字电视 4:IP
	String output_channel_type;
	//Rds通道数量/ DVB_C通达数量  
	String sub_channel_number;
	//
	List<sub_channel_info> sub_channels =new ArrayList<sub_channel_info>();
	public static class sub_channel_info {
		//开播频点，单位MHZ，3个字节，采用BCD 码的方式表示 6个数字，其中小数点前4位，小数点后2 位。
		String sub_channel_freq;
		//传输通道状态。1：空闲；2：占用；3：故障
		String output_channel_state;
		//BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范 + 保留，取值为”1111”
		String ebm_id_reserved;
		public String getSub_channel_freq() {
			return sub_channel_freq;
		}
		public void setSub_channel_freq(String sub_channel_freq) {
			this.sub_channel_freq = sub_channel_freq;
		}
		public String getOutput_channel_state() {
			return output_channel_state;
		}
		public void setOutput_channel_state(String output_channel_state) {
			this.output_channel_state = output_channel_state;
		}
		public String getEbm_id_reserved() {
			return ebm_id_reserved;
		}
		public void setEbm_id_reserved(String ebm_id_reserved) {
			this.ebm_id_reserved = ebm_id_reserved;
		}
		
		
	}
	
	List<sub_channel_info1> sub_channels1 =new ArrayList<sub_channel_info1>();
	public static class sub_channel_info1{
		//TS流传输中原始网络ID
		String original_network_id;
		//TS流传输中传输流标识符
		String details_channel_transport_stream_id;
		//TS流传输中节目号
		String details_channel_program_number;
		//TS流传输中详情频道PCR标识
		String details_channel_pcr_pid;
		//
		String stream_number;

		List<stream_info> streams =new ArrayList<stream_info>();
		
		public static class stream_info {
			//该字段的取值范围和定义见GB/T 17975.1-2010的表37
			String stream_type;
			//基本PID
			String elementary_pid;
			public String getStream_type() {
				return stream_type;
			}
			public void setStream_type(String stream_type) {
				this.stream_type = stream_type;
			}
			public String getElementary_pid() {
				return elementary_pid;
			}
			public void setElementary_pid(String elementary_pid) {
				this.elementary_pid = elementary_pid;
			}			
			
		}
		//传输通道状态。1：空闲；2：占用；3：故障
		String output_channel_state;
		//BCD编码，23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范 + 保留，取值为”1111”
		String ebm_id_reserved;
		public String getOriginal_network_id() {
			return original_network_id;
		}
		public void setOriginal_network_id(String original_network_id) {
			this.original_network_id = original_network_id;
		}
		public String getDetails_channel_transport_stream_id() {
			return details_channel_transport_stream_id;
		}
		public void setDetails_channel_transport_stream_id(String details_channel_transport_stream_id) {
			this.details_channel_transport_stream_id = details_channel_transport_stream_id;
		}
		public String getDetails_channel_program_number() {
			return details_channel_program_number;
		}
		public void setDetails_channel_program_number(String details_channel_program_number) {
			this.details_channel_program_number = details_channel_program_number;
		}
		public String getDetails_channel_pcr_pid() {
			return details_channel_pcr_pid;
		}
		public void setDetails_channel_pcr_pid(String details_channel_pcr_pid) {
			this.details_channel_pcr_pid = details_channel_pcr_pid;
		}
		public String getStream_number() {
			return stream_number;
		}
		public void setStream_number(String stream_number) {
			this.stream_number = stream_number;
		}
		public List<stream_info> getStreams() {
			return streams;
		}
		public void setStreams(List<stream_info> streams) {
			this.streams = streams;
		}
		public String getOutput_channel_state() {
			return output_channel_state;
		}
		public void setOutput_channel_state(String output_channel_state) {
			this.output_channel_state = output_channel_state;
		}
		public String getEbm_id_reserved() {
			return ebm_id_reserved;
		}
		public void setEbm_id_reserved(String ebm_id_reserved) {
			this.ebm_id_reserved = ebm_id_reserved;
		}
		
		
	}
	public String getOutput_channel_id() {
		return output_channel_id;
	}
	public void setOutput_channel_id(String output_channel_id) {
		this.output_channel_id = output_channel_id;
	}
	public String getOutput_channel_type() {
		return output_channel_type;
	}
	public void setOutput_channel_type(String output_channel_type) {
		this.output_channel_type = output_channel_type;
	}
	public String getSub_channel_number() {
		return sub_channel_number;
	}
	public void setSub_channel_number(String sub_channel_number) {
		this.sub_channel_number = sub_channel_number;
	}
	public List<sub_channel_info> getSub_channels() {
		return sub_channels;
	}
	public void setSub_channels(List<sub_channel_info> sub_channels) {
		this.sub_channels = sub_channels;
	}
	public List<sub_channel_info1> getSub_channels1() {
		return sub_channels1;
	}
	public void setSub_channels1(List<sub_channel_info1> sub_channels1) {
		this.sub_channels1 = sub_channels1;
	}
	
	
	
	
	}

	public String getFront_code_reserved() {
		return front_code_reserved;
	}

	public void setFront_code_reserved(String front_code_reserved) {
		this.front_code_reserved = front_code_reserved;
	}

	public String getOutput_channel_number() {
		return output_channel_number;
	}

	public void setOutput_channel_number(String output_channel_number) {
		this.output_channel_number = output_channel_number;
	}

	public List<output_channel_info> getOutput_channels() {
		return output_channels;
	}

	public void setOutput_channels(List<output_channel_info> output_channels) {
		this.output_channels = output_channels;
	}


	
		
}
