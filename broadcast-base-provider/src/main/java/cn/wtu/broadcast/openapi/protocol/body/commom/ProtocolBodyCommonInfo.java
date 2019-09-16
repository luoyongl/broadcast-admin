package cn.wtu.broadcast.openapi.protocol.body.commom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.wtu.broadcast.openapi.protocol.ProtocolHeadBodyData;
import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;

/**
 * 消息体公共部分
 * 
 * @author Lenovo
 *
 */
public class ProtocolBodyCommonInfo extends ProtocolHeadBodyData {

	//////////////////////////// 终端指令terminal通用部分//////////////////////////////////////

	// 要设置的终端编号的地址类型 8bit 1: 表示逻辑码寻址； 2：表示物理码寻址； 3~9：保留
	protected static byte resource_code_type = 1;
	// 需要配置的区域和终端编码的个数 8bit
	protected static byte resource_code_number;
	// 终端编码长度 8bit
	protected byte resource_code_length = 24 / 2;
	// 终端资源编码 BCD编码的资源码信息 resource_codes公共部分,提取到父类中
	protected static List<byte[]> resource_codes = new ArrayList<byte[]>();

	/**
	 * 设置资源编码 原来为23位,为了便于封装,在前面加0x0f
	 * 
	 * @param resourceCodeList
	 */
	public void setResourceCodes(List<String> resourceCodeList) {
		resource_code_number = (byte) resourceCodeList.size();
		for (String s : resourceCodeList) {
			if (s.length() == 23) {// 国标23字符，前4位填充‘F’
				s = "F" + s;
			}
			byte[] data = SendProtocolTools.strToHexBytes("F" + s);
			resource_codes.add(data);
		}
	}

	//////////////////////////// 适配器控制指令adapter通用部分////////////////////////////////////

	// 保留 4bit，取值为”1111”
	// byte reserved = 0x0f;
	// BCD编码 92bit 23BCD, 23个数字码其定义见GD/J XXXX-XXXX应急广播消息格式规范。
	// byte[] front_code;

	// 仅仅用于封装 reserved+front_code
	protected static byte[] reserved_and_frontCode;

	// public void setReservedAndFrontCode(String frontCode) {
	// reserved_and_frontCode = SendProtocolTools.StrToBCDBytes("F" +
	// frontCode);
	// }

	// byte reserved2 = 0x0f;
	// BCD编码的应急广播消息标识符； (当EBMID=0时的关机为全区域关机) 140bit = 35位BCD码
	// byte[] ebm_id;

	// 仅仅用于封装 reserved+front_code
	protected static byte[] reserved_and_ebmId;

	/**
	 * 用于生成 应急广播消息标识ebm_id=平台资源编码(92byte/23位Hex)+yyyyMMddHHmm
	 * 
	 * @param platformResourceCode
	 *            平台资源编码
	 */
	public void setReservedAndEbmId(String platformResourceCode) {

		SimpleDateFormat myFmt = new SimpleDateFormat("yyyyMMddHHmm");

		String s = platformResourceCode + myFmt.format(new Date());
		// F表示保留位0x0F
		reserved_and_ebmId = SendProtocolTools.strToHexBytes("F" + s);
	}

}
