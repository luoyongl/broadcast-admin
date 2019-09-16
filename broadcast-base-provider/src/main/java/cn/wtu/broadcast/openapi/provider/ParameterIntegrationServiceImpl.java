package cn.wtu.broadcast.openapi.provider;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.ParameterConfigurationService;
import cn.wtu.broadcast.openapi.api.ParameterIntegrationService;
import cn.wtu.broadcast.openapi.common.SendProtocolCallable;
import cn.wtu.broadcast.openapi.dao.BInstructionSendreplyStorageMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceParameterSetExtMapper;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.openapi.model.BInstructionSendreplyStorage;
import cn.wtu.broadcast.openapi.protocol.ProtocolReplyCommonData;
import cn.wtu.broadcast.openapi.protocol.ProtocolTotalInfoUtil;
import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.adapter.reply.Protocol0x12Body;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x05Body;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x06Body;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x07Body;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x08Body;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x09Body;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x0ABody;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x0BBody;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x3FBody;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.special.Protocol0x01Body;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.special.Protocol0x02Body;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.GeneralResponseEnum;
import cn.wtu.broadcast.parent.vo.cmd.RdsFrequencyPointVo;
import cn.wtu.broadcast.parent.vo.cmd.SetResourceCodeVo;
import cn.wtu.broadcast.parent.vo.cmd.SetReturnAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.SetStateQueryParameterVo;
import cn.wtu.broadcast.parent.vo.cmd.TerminalIpAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.TsFrequencyPointVo;
import net.sf.json.JSONObject;

/**
 * 指令整合业务层
 * 
 * @author yinjie
 * @since 2019/7/5
 * 目前是以数据库为返回值,后面等解析方法写好后进行修改(改进)
 * @since 2019/7/15
 * 提取公共发送指令方法，返回值以通用回复指令中的return code为值
 */

@Service("ParameterIntegrationService")
@SuppressWarnings("unused")
@Transactional
public class ParameterIntegrationServiceImpl extends ParentServiceImpl<BDeviceParameterSet> implements ParameterIntegrationService{

	private static Logger logger = LoggerFactory.getLogger(ParameterIntegrationServiceImpl.class);
	
	@Autowired
	private BDeviceParameterSetExtMapper bDeviceParameterSetExtMapper;
	
	@Autowired
	private BInstructionSendreplyStorageMapper bInstructionSendreplyStorageMapper;
	
	@Autowired
	private ParameterConfigurationService parameterConfigurationService;
	
	/**
	 * TS锁定频率设置
	 */
	@Override
	public int integrationAddRdsToDdeviceTsSet(String resourceCodes, TsFrequencyPointVo tsFrequencyPointVos) {
		try {
			int addRdsToDdeviceTsSet = 0;
			Protocol0x01Body protocol0x01Body = new Protocol0x01Body();
			protocol0x01Body.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			protocol0x01Body.freq = tsFrequencyPointVos.getFrequency();
			protocol0x01Body.symbol_rate = tsFrequencyPointVos.getSymbolRate();
			protocol0x01Body.qam = tsFrequencyPointVos.getQamNumber().byteValue();
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x01Body);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
									
			String[] resourceCode = resourceCodes.split(",");
			for (String resource : resourceCode) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resource);
				addRdsToDdeviceTsSet += parameterConfigurationService.addRdsToDdeviceTsSet(findParameterSet, resource,
						tsFrequencyPointVos.getFrequency(), tsFrequencyPointVos.getSymbolRate(),
						tsFrequencyPointVos.getQamNumber());
			}
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 设置RDS扫描频点信息
	 */
	@Override
	public int integrationSetRDSScanFrequencyPoint(String resourceCodes,
			List<RdsFrequencyPointVo> rdsFrequencyPointVos) {
		try {
			int addRdsToDdeviceRdsSet = 0;
			// RDS特殊指令
			Protocol0x02Body protocol0x02Body = new Protocol0x02Body();
			// 设置逻辑码
			protocol0x02Body.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			// 时间间隔 单位毫秒 默认 100ms
			protocol0x02Body.interval = 100;
			String[] resourceCode = resourceCodes.split(",");
			//预先处理上次资源编码对应下的数据(数据库表数据处理)
			for (String code : resourceCode) {
				parameterConfigurationService.deleteRdsByResourceCode(code);
			}
			for (RdsFrequencyPointVo rdsVo : rdsFrequencyPointVos) {
				Protocol0x02Body.FrequencyInfo frequencyInfo = new Protocol0x02Body.FrequencyInfo(
						rdsVo.getRdsFrequency().byteValue(), rdsVo.getRdsPriority().byteValue(),
						rdsVo.getRdsPointSequence());
				protocol0x02Body.frequencyInfos.add(frequencyInfo);
				for (int i = 0; i < resourceCode.length; i++) {
					addRdsToDdeviceRdsSet += parameterConfigurationService.addRdsToDdeviceRdsSet(resourceCode[i],
							rdsVo.getRdsPriority(), rdsVo.getRdsFrequency());
				}
			}
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x02Body);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 通用网络参数设置
	 */
	@Override
	public int integrationSetNetworkParameter(TerminalIpAddressVo terminalIpAddressVo) {
		try {
			int ipAddress = 0;
			// 通用网络参数设置
			Protocol0x0ABody protocol0x0ABody = new Protocol0x0ABody();
			// 设置逻辑码
			protocol0x0ABody.setResourceCode(terminalIpAddressVo.getResourceCode());
			protocol0x0ABody.ip = SendProtocolTools.ipToBytes(terminalIpAddressVo.getIpAddressValue());
			protocol0x0ABody.subnet_mask = SendProtocolTools.ipToBytes(terminalIpAddressVo.getSubnetMask());
			protocol0x0ABody.gateway = SendProtocolTools.ipToBytes(terminalIpAddressVo.getIpGate());
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x0ABody);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);

			BDeviceParameterSet findParameterSet = parameterConfigurationService
					.findParameterSet(terminalIpAddressVo.getResourceCode());
			ipAddress = parameterConfigurationService.updateOrInsertIpAddressToBDeviceParameterSet(findParameterSet,
					terminalIpAddressVo.getResourceCode(), terminalIpAddressVo.getIpAddressValue(),
					terminalIpAddressVo.getSubnetMask(), terminalIpAddressVo.getIpGate());
			
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 通用资源编码设置
	 */
	@Override
	public int integrationUpdateResourceCode(List<SetResourceCodeVo> setResourceCodeVo) {
		try {
			// 通用资源编码设置
			Protocol0x05Body protocol0x05Body = new Protocol0x05Body();
			for (SetResourceCodeVo setVo : setResourceCodeVo) {
				Protocol0x05Body.LogicAddress logicAddress = new Protocol0x05Body.LogicAddress(setVo.getPhysicalCode(),
						setVo.getResourceCode());
				protocol0x05Body.logicAddressInfo.add(logicAddress);
			}
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x05Body);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
			
			for (SetResourceCodeVo setresourceVo : setResourceCodeVo) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService
						.findParameterSet(setresourceVo.getResourceCode());
				parameterConfigurationService.insertOrUpdateCodes(findParameterSet, setresourceVo.getResourceCode());
			}
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 设置音量
	 */
	@Override
	public int integrationSetVolume(String resourceCodes, Integer volume) {
		try {
			// 通用音量设置
			Protocol0x06Body protocol0x06Body = new Protocol0x06Body();
			// 设置逻辑码
			protocol0x06Body.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			protocol0x06Body.volume = volume.byteValue();
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x06Body);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
			
			String[] resourceCode = resourceCodes.split(",");
			for (int i = 0; i < resourceCode.length; i++) {
				BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode[i]);
				parameterConfigurationService.updateOrInsertVolumeToBDeviceParameterSet(parameterSet, volume,
						resourceCode[i]);
			}
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 通用回传参数设置（0x07）
	 */
	@Override
	public int integrationSetCommonReturnParameter(String resourceCodes, SetReturnAddressVo setReturnAddressVo) {
		int returnAddress = 0;
		try {
			// 通用回传参数设置（0x07）
			Protocol0x07Body protocol0x07Body = new Protocol0x07Body();
			// 设置逻辑码
			protocol0x07Body.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			protocol0x07Body.reback_address = SendProtocolTools.ipAndPortToBytes(setReturnAddressVo.getReturnIpValue(),
					setReturnAddressVo.getReturnPortValue());
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x07Body);
			// TODO 发送指令
			String[] resourceCode = resourceCodes.split(",");
			
			for (int i = 0; i < resourceCode.length; i++) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resourceCode[i]);
				returnAddress += parameterConfigurationService.updateOrInsertReturnAddressToBDeviceParameterSet(
						findParameterSet, resourceCode[i], setReturnAddressVo.getReturnIpValue(),
						setReturnAddressVo.getReturnPortValue().toString());
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return returnAddress;
	}
	
	/**
	 * 终端参数/状态查询指令（0x08）
	 */
	@Override
	public int integrationSetStateQueryParameter(String resourceCodes,
			SetStateQueryParameterVo setStateQueryParameterVo) {
		try {
			// 终端参数/状态查询指令（0x08）
			Protocol0x08Body protocol0x08Body = new Protocol0x08Body();
			// 设置逻辑码
			protocol0x08Body.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			protocol0x08Body.reback_address = SendProtocolTools.ipAndPortToBytes(
					setStateQueryParameterVo.getReturnIpValue(), setStateQueryParameterVo.getReturnPortValue());
			// 设置查询信息类型
			protocol0x08Body.query_codes = SendProtocolTools.stringToBytes(setStateQueryParameterVo.getQueryCodes());
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x08Body);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
			
			String[] resourceCode = resourceCodes.split(",");
			for (String resource : resourceCode) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resource);
				parameterConfigurationService.insertOrUpdateParameterStatus(findParameterSet, resource,
						setStateQueryParameterVo.getQueryCodes());
			}
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 通用时钟校准（0x09）
	 */
	@Override
	public int integrationSetTime(String resourceCodes) {
		try {
			// 通用时钟校准（0x09）
			Protocol0x09Body protocol0x09Body = new Protocol0x09Body();
			// 设置逻辑码
			protocol0x09Body.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x09Body);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
			
			String[] resourceCode = resourceCodes.split(",");
			for (String resource : resourceCode) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resource);
				parameterConfigurationService.addOrUpdateCalibrationTime(findParameterSet, resource);
			}
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 通用回传周期设置（0x0B）
	 */
	@Override
	public int integrationSetReturnCycle(String resourceCodes, Integer datetime) {
		try {
			// 通用回传周期设置（0x0B）
			Protocol0x0BBody protocol0x0BBody = new Protocol0x0BBody();
			// 设置逻辑码
			protocol0x0BBody.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			// 单位s
			protocol0x0BBody.reback_cycle = datetime;
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x0BBody);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
			
			String[] resourceCode = resourceCodes.split(",");
			for (int i = 0; i < resourceCode.length; i++) {
				BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode[i]);
				parameterConfigurationService.updateOrInsertReturnCycleToBDeviceParameterSet(parameterSet, datetime,
						resourceCode[i]);
			}
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 通用终端功放开关指令(0x3F)
	 */
	@Override
	public int integrationSetTerminalPowerSwitch(String resourceCodes, Integer switchNumber) {
		try {
			// 通用终端功放开关指令(0x3F)
			Protocol0x3FBody protocol0x3FBody = new Protocol0x3FBody();
			// 1:表示关闭喇叭2：表示打开喇叭
			protocol0x3FBody.switch_option = switchNumber.byteValue();
			// 设置逻辑码
			protocol0x3FBody.setResourceCodes(Arrays.asList(resourceCodes.split(",")));
			byte[] completeCmdBys = ProtocolTotalInfoUtil.getProtocolByte(protocol0x3FBody);
			// TODO 发送指令
			int sendInstruction = sendInstruction(completeCmdBys);
			
			String[] resourceCode = resourceCodes.split(",");
			for (int i = 0; i < resourceCode.length; i++) {
				BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode[i]);
				parameterConfigurationService.updateOrInsertSwitchNumberToBDeviceParameterSet(parameterSet,
						switchNumber, resourceCode[i]);
			}
			return sendInstruction;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//这里返回保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	/**
	 * 发送指令(公共)
	 * 并且需要在该方法中存两次指令记录数据库
	 */
	public int sendInstruction(byte[] completeCmdBys){
		BInstructionSendreplyStorage instructionSend = new BInstructionSendreplyStorage();
		try {
			//一次设值存库
			instructionSend.setfSendDirectives(completeCmdBys.toString());
			SendProtocolCallable sendProtocolCallable = new SendProtocolCallable(completeCmdBys);
			FutureTask<ProtocolReplyCommonData> futureTask = new FutureTask<>(sendProtocolCallable);
			futureTask.run();
			// 方法会阻塞直到获得结果
			ProtocolReplyCommonData protocolReplyCommonData = futureTask.get(5, TimeUnit.SECONDS);
			//返回数据需要使用适配器回复数据
			Protocol0x12Body returnprotocol0x12Body =  (Protocol0x12Body)protocolReplyCommonData.getData();
			//二次设值存库
			instructionSend.setfRespondInstructions(JSONObject.fromObject(returnprotocol0x12Body).toString());
			try {
				//存库
				bInstructionSendreplyStorageMapper.insertSelective(instructionSend);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			//从该解析指令对象中取返回类型值(这里需要通用回复指令对象)
			String return_code = returnprotocol0x12Body.getReturn_code();
			//进行判断 或直接传到controller进行判断
			return Integer.valueOf(return_code);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		//没有成功,返回一个保留字
		return GeneralResponseEnum.reservedWord.getNumber();
	}
	
	@Override
	protected DBInterface<BDeviceParameterSet> getDao() {
		return bDeviceParameterSetExtMapper;
	}

}
