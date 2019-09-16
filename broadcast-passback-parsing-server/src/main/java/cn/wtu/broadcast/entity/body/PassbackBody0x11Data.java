package cn.wtu.broadcast.entity.body;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.wtu.broadcast.entity.PassbackBodyData;

/**
 * 查询指令应答
 * @author Lenovo
 *
 */
public class PassbackBody0x11Data extends PassbackBodyData implements Serializable{

	private static final long serialVersionUID = 1121401218057767310L;
/*	0：表示终端成功接收并且正确处理；
	13：表示请求数据包出现错误；
	60：表示终端出现错误，无法处理。
	参见错误代码列表。*/
	private String resultCode;
	
	//结果描述的长度，如果无结果描述则长度为0。
	
	private String resultDescLength;
	
	// 对查询结果进行描述。
	
	private String resultDesc;
	
	//查询参数的个数。
	
	private String queryParameterNumber;
	
	//
	private List<queryContext> context =new ArrayList<queryContext>() ;
	
	public static class queryContext{
		//参数标识 1
		private String parameterTag;
		//参数标识1 内容长度
		private String parameterBodyLength;
		//参数标识1 内容描述
		private String parameterBody;
		//表E.5 终端状态 查询 （应答）回传参数 状态数据 定义
		private String bodyIndex;
		// 主频率,kHZ(4B)+符号率 ,kBPS(4B)+QAM(1B)
		private String frequency;
		// 信号强度(1B)+信号质量 (1B)
		private String signalStrength;
		private String signalQuality;
		//终端输出音量，效果为终端可输出最大音量的百分比，取值范围： 0-100 。
		private String localVolume;
		//IP地址（ 4字节 ）
		private String localIpaddr;
		// 子网掩码（ 4 字节 ）
		private String localNetmask;
		// 网关 （4 字节 ）
		private String localGateway;
		//一 是 IP+ 端口，二是域名 端口， 用 内容中 第一个 字节 标识。 三是短信号码。
		private String addressType;
/*		 三种方式
		 如果第一个 字节 为 0x01 ，表示 采用方式一， IPIP 4 字节 端口(2字节) */
		//端口
		private String backPort;
		
		//IP
		private String backIpaddr;

		// 如果第一个 字节 为 0x02表示 采用方式 二 第二个 字节 标记域名长度 n 域名 n
		// 域名长度 n
		private String backHostLength;
		// 域名
		private String backHost;
		// 如果第一个 字节 为0x03 ，表示采用方式三，随后的第二字节表示短信号码的长度（通常为
		// 11 个字节的数字），第三字节开始的为短信号码。
		// 短信号码的长度
		private String backPhoneLength;
		// 短信号码
		private String backPhone;
		//终端资源编码 ,字段 必备项(IP, TS, RDS)
		private String localSource;
		//物理地址编码 ,字段 必备项(IP, TS, RDS)
		// 第1 个 字节 标识物理 地址编码的长度值 后面 （长度 1 ）个字节终端唯一标识，出厂时生成，固定不变。
		private String localPhysicsAddressLength;
		//
		private String localPhysicsAddress;
		// 终端当前所处工作状态。
		// 1：空闲 ，终端在线，但未进行任何广播操作；
		// 2：工作，终端进行广播中
		// 3：故障 终端 处于故障状态。
		private String localWorkState;
		// 故障代码，标识终端故障类型， 1个 字节， 由厂家自行定义。
		private String faultCode;
		//QAM
		private String QAM;
		// 频点数(1B)+{频点序号 1(1B)+优先级 1(1B)+频率 1(3B)+...}
		private String frequencyListNumber;
		List<frequencyList> frequencyList =new ArrayList<frequencyList>();
		public static class frequencyList{
			private String frequencyIndex;
			private String frequencyPriority;
			public String getFrequencyIndex() {
				return frequencyIndex;
			}
			public void setFrequencyIndex(String frequencyIndex) {
				this.frequencyIndex = frequencyIndex;
			}
			public String getFrequencyPriority() {
				return frequencyPriority;
			}
			public void setFrequencyPriority(String frequencyPriority) {
				this.frequencyPriority = frequencyPriority;
			}
			
		}
		// 指令频点(3B)+节目频点 (3B)
		private String frequencyContrl;
		private String frequencyChannel;
		// 是否启用,0 禁用， 1 ：启用(1B)+(维持周期（ 2B)
		private String keepEnable;
		private String keepCycle;
		public String getParameterTag() {
			return parameterTag;
		}
		public void setParameterTag(String parameterTag) {
			this.parameterTag = parameterTag;
		}
		public String getParameterBodyLength() {
			return parameterBodyLength;
		}
		public void setParameterBodyLength(String parameterBodyLength) {
			this.parameterBodyLength = parameterBodyLength;
		}
		public String getParameterBody() {
			return parameterBody;
		}
		public void setParameterBody(String parameterBody) {
			this.parameterBody = parameterBody;
		}
		public String getBodyIndex() {
			return bodyIndex;
		}
		public void setBodyIndex(String bodyIndex) {
			this.bodyIndex = bodyIndex;
		}
		public String getFrequency() {
			return frequency;
		}
		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}
		public String getSignalStrength() {
			return signalStrength;
		}
		public void setSignalStrength(String signalStrength) {
			this.signalStrength = signalStrength;
		}
		public String getSignalQuality() {
			return signalQuality;
		}
		public void setSignalQuality(String signalQuality) {
			this.signalQuality = signalQuality;
		}
		public String getLocalVolume() {
			return localVolume;
		}
		public void setLocalVolume(String localVolume) {
			this.localVolume = localVolume;
		}
		public String getLocalIpaddr() {
			return localIpaddr;
		}
		public void setLocalIpaddr(String localIpaddr) {
			this.localIpaddr = localIpaddr;
		}
		public String getLocalNetmask() {
			return localNetmask;
		}
		public void setLocalNetmask(String localNetmask) {
			this.localNetmask = localNetmask;
		}
		public String getLocalGateway() {
			return localGateway;
		}
		public void setLocalGateway(String localGateway) {
			this.localGateway = localGateway;
		}
		public String getAddressType() {
			return addressType;
		}
		public void setAddressType(String addressType) {
			this.addressType = addressType;
		}
		public String getBackPort() {
			return backPort;
		}
		public void setBackPort(String backPort) {
			this.backPort = backPort;
		}
		public String getBackIpaddr() {
			return backIpaddr;
		}
		public void setBackIpaddr(String backIpaddr) {
			this.backIpaddr = backIpaddr;
		}
		public String getBackHostLength() {
			return backHostLength;
		}
		public void setBackHostLength(String backHostLength) {
			this.backHostLength = backHostLength;
		}
		public String getBackHost() {
			return backHost;
		}
		public void setBackHost(String backHost) {
			this.backHost = backHost;
		}
		public String getBackPhoneLength() {
			return backPhoneLength;
		}
		public void setBackPhoneLength(String backPhoneLength) {
			this.backPhoneLength = backPhoneLength;
		}
		public String getBackPhone() {
			return backPhone;
		}
		public void setBackPhone(String backPhone) {
			this.backPhone = backPhone;
		}
		public String getLocalSource() {
			return localSource;
		}
		public void setLocalSource(String localSource) {
			this.localSource = localSource;
		}
		public String getLocalPhysicsAddressLength() {
			return localPhysicsAddressLength;
		}
		public void setLocalPhysicsAddressLength(String localPhysicsAddressLength) {
			this.localPhysicsAddressLength = localPhysicsAddressLength;
		}
		public String getLocalPhysicsAddress() {
			return localPhysicsAddress;
		}
		public void setLocalPhysicsAddress(String localPhysicsAddress) {
			this.localPhysicsAddress = localPhysicsAddress;
		}
		public String getLocalWorkState() {
			return localWorkState;
		}
		public void setLocalWorkState(String localWorkState) {
			this.localWorkState = localWorkState;
		}
		public String getFaultCode() {
			return faultCode;
		}
		public void setFaultCode(String faultCode) {
			this.faultCode = faultCode;
		}
		public String getQAM() {
			return QAM;
		}
		public void setQAM(String qAM) {
			QAM = qAM;
		}
		public String getFrequencyListNumber() {
			return frequencyListNumber;
		}
		public void setFrequencyListNumber(String frequencyListNumber) {
			this.frequencyListNumber = frequencyListNumber;
		}
		public List<frequencyList> getFrequencyList() {
			return frequencyList;
		}
		public void setFrequencyList(List<frequencyList> frequencyList) {
			this.frequencyList = frequencyList;
		}
		public String getFrequencyContrl() {
			return frequencyContrl;
		}
		public void setFrequencyContrl(String frequencyContrl) {
			this.frequencyContrl = frequencyContrl;
		}
		public String getFrequencyChannel() {
			return frequencyChannel;
		}
		public void setFrequencyChannel(String frequencyChannel) {
			this.frequencyChannel = frequencyChannel;
		}
		public String getKeepEnable() {
			return keepEnable;
		}
		public void setKeepEnable(String keepEnable) {
			this.keepEnable = keepEnable;
		}
		public String getKeepCycle() {
			return keepCycle;
		}
		public void setKeepCycle(String keepCycle) {
			this.keepCycle = keepCycle;
		}
		


		
		
		

		
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescLength() {
		return resultDescLength;
	}

	public void setResultDescLength(String resultDescLength) {
		this.resultDescLength = resultDescLength;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getQueryParameterNumber() {
		return queryParameterNumber;
	}

	public void setQueryParameterNumber(String queryParameterNumber) {
		this.queryParameterNumber = queryParameterNumber;
	}

	public List<queryContext> getContext() {
		return context;
	}

	public void setContext(List<queryContext> context) {
		this.context = context;
	}
	
	
	
	
	
}
