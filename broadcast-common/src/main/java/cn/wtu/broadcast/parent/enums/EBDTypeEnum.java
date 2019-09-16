package cn.wtu.broadcast.parent.enums;

public enum EBDTypeEnum {
	EBMStateRequest("EBMStateRequest", "", "应急广播消息播发状态查询文件XML"),
	EBMStateResponse("EBMStateResponse", "", "应急广播消息播发状态反馈文件XML"),
	OMDRequest("OMDRequest", "", "运维数据请求文件XML"),
	EBRPSInfo("EBRPSInfo", "", "应急广播平台信息文件XML"),
	EBRSTInfo("EBRSTInfo", "", "台站前端信息文件XML"),
	EBRASInfo("EBRASInfo", "", "应急广播适配器信息文件XML"),
	EBRBSInfo("EBRBSInfo", "", "传输覆盖播出设备信息文件XML"),
	EBRDTInfo("EBRDTInfo", "", "平台设备及终端信息文件XML"),
	EBRPSState("EBRPSState", "", "应急广播平台状态文件XML"),
	EBRASState("EBRASState", "", "应急广播适配器状态文件XML"),
	EBRBSState("EBRBSState", "", "传输覆盖播出设备状态文件XML"),
	EBRDTState("EBRDTState", "", "平台设备及终端状态文件XML"),
	EBMBrdLog("EBMBrdLog", "", "播出记录文件XML"),
	ConnectionCheck("ConnectionCheck", "cn.wtu.broadcast.openapi.vo.connectioncheck.HeartBeatXmlModel", "心跳检测文件XML"),
	EBDNotify("EBDNotify", "", "处理结果通知文件XML"),
	EBDResponse("EBDResponse", "", "接收回执文件XML"),
	EBM("EBM", "cn.wtu.broadcast.openapi.vo.ebm.EBDXmlModel", "应急广播业务数据文件XML");

	private String code;
	private String xmlModelType;
	private String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	public String getXmlModelType() {
		return xmlModelType;
	}

	private EBDTypeEnum(String code, String xmlModelType, String desc) {
		this.code = code;
		this.xmlModelType = xmlModelType;
		this.desc = desc;
	}
	
	public static EBDTypeEnum getEnumByCode(String code) {
		for (EBDTypeEnum ebdypeEnum : EBDTypeEnum.values()) {
			if (code != null && code.equals(String.valueOf(ebdypeEnum.getCode()))) {
				return ebdypeEnum;
			}
		}

		return null;
	}
}
