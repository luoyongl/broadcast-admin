package cn.wtu.broadcast.openapi.protocol.body.terminal.control.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.commom.ProtocolBodyCommonInfo;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;

public class Protocol0x04Body extends ProtocolBodyCommonInfo {

	/**
	 * 该构造首先是给protocol_type赋值,然后生成ebm_id 140/4=35BCD ebm_id [保留位0x0f] 4+140
	 * 应急广播消息标识id=平台资源编码(92byte/23位Hex)+yyyymmdd+0000(四位顺序码)
	 */
	public Protocol0x04Body(String platformResourceCode, Integer fId, Date startDate) {

		protocol_type = ProtocolTypeEnum.Protocol0x04Body;

		String orderCode = "0000";
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyyMMdd");
		/*
		 * 顺序码 小于5位 2019/02/24 lxg
		 */
		if (fId < 10000) {
			orderCode = String.format("%04d", fId);
		} else {
			// 超过四位截取后四位
			orderCode = fId.toString().substring(fId.toString().length() - 4);
		}
		String s = platformResourceCode + myFmt.format(startDate) + orderCode;
		// F表示保留位0x0F
		reserved1_and_ebmId = SendProtocolTools.strToHexBytes("F" + s);
	}

	// 保留位4bit 取值为”1111”
	//byte reserved1 = 0x0f;
	// BCD编码的应急广播消息标识符； (当EBMID=0时的关机为全区域关机) 140bit = 35位BCD码
	//byte[] ebm_id;

	// 该字段用于封装 由于reserved1只有4bit且ebm_id 140bit 合并 144/4 = 36BCD = 18byte 测试专用
	// byte[] reserved1_and_ebmId = new
	// byte[]{0x11,0x22,0x33,0x44,0x11,0x22,0x33,0x44,0x11,0x22,0x33,0x44,0x11,0x22,0x33,0x44,0x11,0x22};
	byte[] reserved1_and_ebmId;

	// 8bit 1：开播；2：停播
	byte power_switch;
	// 应急广播类型：8bit 0：保留；1：发布系统演练；2：模拟演练；3：实际演练； 4：应急广播；5：日常广播；其他：保留；
	public byte ebm_class;
	// 应急广播事件类型 40bit
	byte[] ebm_type = new byte[5];
	// 应急广播事件级别：8bit 0：缺省；1：1级（特别重大）；2：2级（重大）； 3：3级（较大）；4：4级（一般）；其他：保留；
	public byte ebm_level;

	// start_time end_time 32bit UTC时间
	// byte[] start_time = new byte[]{0x20,0x19,0x06,0x06};
	// byte[] end_time = new byte[]{0x20,0x19,0x06,0x07};
	public byte[] start_time = new byte[4];
	public byte[] end_time = new byte[4];

	// 音量 8bit
	public byte volume;
	// 地址码类型8bit：1：逻辑码寻址；2：物理码寻址；
	// byte resource_code_type;
	// 应急广播消息覆盖的资源码数量 8bit
	// byte resource_code_number;
	// 每个资源码长度 8bit
	// byte resource_code_length = 24/2;
	// BCD编码的资源码信息（逻辑码寻址时，前四位为保留位，取值为（1111））
	// List<byte[]> resource_codes = new ArrayList<byte[]>();
	// 多语种数量8bit：取值范围为：0~0xF
	byte multilingual_content_number;
	// 语种内容集合
	List<LanguageInfo> languageInfos = new ArrayList<LanguageInfo>();

	public static class LanguageInfo {
		// 语种代码language_code 24bit
		int language_code;
		// 字符集类型8bit：0：GB 2312-1980；1：GB/T 18030-2005（可选）；2：GB
		// 13000-2010（可选）；3：GB 21669-2008（可选）；4：GB 16959-1997（可选）；其他：保留；
		byte coded_character_set;
		// 文本信息长度 16bit
		short text_length;
		// text_char “coded_character_set”格式的编码)的文本内容 Nbit
		byte[] text_char;
		// 发布机构名称信息长度8bit
		byte agency_name_length;
		// agency_name_char “coded_character_set”格式的编码)的文本内容 Nbit
		byte[] agency_name_char;
		// 辅助数据数量 8bit
		byte auxiliary_number;
		// 辅助数据内容集合
		List<AuxiliaryDataInfo> auxiliaryDataInfos = new ArrayList<AuxiliaryDataInfo>();

		public static class AuxiliaryDataInfo {

			/**
			 * MPEG-1 LayerI/II 音频文件 2 MPEG-1 LayerIII 音频文件 3 DRA 音频文件 4
			 * DRA+音频文件 5～40 预留 41 PNG 图片文件 42 JPEG 图片文件 43 GIF 图片文件 44～60 预留 61
			 * 音视频流 8bit
			 */
			byte auxiliary_data_type;
			// 辅助数据长度32bit 0：按控制设备参数下发
			int auxiliary_data_length;
			// 辅助数据
			byte[] auxiliary_data;

			public int getSize() {
				int len = 1 + 4;
				if (auxiliary_data != null) {
					auxiliary_data_length = auxiliary_data.length;
					len += auxiliary_data_length;
				}
				return len;
			}

			public byte[] converToBytes() {
				byte[] data = new byte[getSize()];
				int offSet = 0;
				data[offSet++] = auxiliary_data_type;
				data[offSet++] = (byte) ((auxiliary_data_length >> 24) & 0xff);
				data[offSet++] = (byte) ((auxiliary_data_length >> 16) & 0xff);
				data[offSet++] = (byte) ((auxiliary_data_length >> 8) & 0xff);
				data[offSet++] = (byte) ((auxiliary_data_length >> 0) & 0xff);
				System.arraycopy(auxiliary_data, 0, data, offSet, auxiliary_data_length);
				return data;
			}
		}

		public int getSize() {
			int len = 3 + 1 + 2 + 1 + 1;
			if (text_char != null) {
				text_length = (short) text_char.length;
				len += text_length;
			}
			if (agency_name_char != null) {
				agency_name_length = (byte) agency_name_char.length;
				len += agency_name_length;
			}
			if (auxiliaryDataInfos != null || auxiliaryDataInfos.size() > 0) {
				auxiliary_number = (byte) auxiliaryDataInfos.size();
				for (AuxiliaryDataInfo auxiliaryDataInfo : auxiliaryDataInfos) {
					len += auxiliaryDataInfo.getSize();
				}
			}
			return len;
		}

		public byte[] converToBytes() {
			byte[] data = new byte[getSize()];
			int offSet = 0;

			data[offSet++] = (byte) ((language_code >> 16) & 0xff);
			data[offSet++] = (byte) ((language_code >> 8) & 0xff);
			data[offSet++] = (byte) ((language_code >> 0) & 0xff);
			data[offSet++] = coded_character_set;

			data[offSet++] = (byte) (text_length >> 8);
			data[offSet++] = (byte) (text_length & 0xff);

			if (text_char != null) {
				System.arraycopy(text_char, 0, data, offSet, text_length);
				offSet += text_length;
			}

			data[offSet++] = agency_name_length;

			if (agency_name_char != null) {
				System.arraycopy(text_char, 0, data, offSet, agency_name_length);
				offSet += agency_name_length;
			}

			data[offSet++] = auxiliary_number;

			if (auxiliaryDataInfos != null) {
				for (AuxiliaryDataInfo auxiliaryDataInfo : auxiliaryDataInfos) {
					System.arraycopy(auxiliaryDataInfo.converToBytes(), 0, data, offSet, auxiliaryDataInfo.getSize());
					offSet += auxiliaryDataInfo.getSize();
				}
			}

			return data;
		}
	}

	// 输入通道编号 8bit
	byte input_channel_id;
	// 输出通道数量 8bit
	byte output_channel_number;
	// 输出通道编号 元素为8bit
	byte[] output_channel_ids;
	// 保留数据长度 16bit
	short private_data_length;
	// 各厂家可以自定义的数据 private_data
	byte[] private_data;

	/**
	 * 设置广播类型
	 * 
	 * @param EBMTypeStr
	 * @throws Exception
	 */
	public void setEBMType(String EBMTypeStr) throws Exception {
		if (EBMTypeStr.length() != 5) {
			throw new Exception("必须是5个字符!");
		}
		ebm_type = EBMTypeStr.getBytes("US-ASCII");
	}

	public int getSize() {
		primary_cmd_len = 18 + 1 + 1 + 5 + 1 + 4 + 4 + 1 + 1 + 1 + 1;

		if (resource_codes != null) {
			primary_cmd_len += resource_code_number * resource_code_length;
		}

		primary_cmd_len += 1;

		if (languageInfos != null) {
			for (LanguageInfo languageInfo : languageInfos) {
				primary_cmd_len += languageInfo.getSize();
			}
		}

		primary_cmd_len += 1 + 1;

		if (output_channel_ids != null) {
			output_channel_number = (byte) output_channel_ids.length;
			primary_cmd_len += output_channel_number;
		}

		primary_cmd_len += 2;

		if (private_data != null) {
			private_data_length = (byte) private_data.length;
			primary_cmd_len += private_data_length;
		}

		return primary_cmd_len;
	}

	public byte[] convertToBytes() {
		byte[] data = new byte[getSize()];
		int offSet = 0;

		System.arraycopy(reserved1_and_ebmId, 0, data, offSet, reserved1_and_ebmId.length);
		offSet += reserved1_and_ebmId.length;

		data[offSet++] = power_switch;
		data[offSet++] = ebm_class;

		System.arraycopy(ebm_type, 0, data, offSet, 5);
		offSet += 5;

		data[offSet++] = ebm_level;

		System.arraycopy(start_time, 0, data, offSet, 4);
		offSet += 4;
		System.arraycopy(end_time, 0, data, offSet, 4);
		offSet += 4;

		data[offSet++] = volume;
		data[offSet++] = resource_code_type;
		data[offSet++] = resource_code_number;
		data[offSet++] = resource_code_length;

		// 终端资源编码 BCD编码的资源码信息resource_codes
		if (resource_codes != null) {
			for (byte[] resource : resource_codes) {
				System.arraycopy(resource, 0, data, offSet, resource.length);
				offSet += resource.length;
			}
		}

		data[offSet++] = multilingual_content_number;

		if (languageInfos != null) {
			for (LanguageInfo languageInfo : languageInfos) {
				System.arraycopy(languageInfo.converToBytes(), 0, data, offSet, languageInfo.getSize());
				offSet += languageInfo.getSize();
			}
		}

		data[offSet++] = input_channel_id;
		data[offSet++] = output_channel_number;

		if (output_channel_ids != null) {
			System.arraycopy(output_channel_ids, 0, data, offSet, output_channel_ids.length);
			offSet += output_channel_ids.length;
		}

		data[offSet++] = (byte) (private_data_length >> 8);
		data[offSet++] = (byte) (private_data_length & 0xff);

		if (private_data != null) {
			System.arraycopy(private_data, 0, data, offSet, private_data.length);
		}

		return data;
	}
}
