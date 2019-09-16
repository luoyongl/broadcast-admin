package cn.wtu.broadcast.controller.instruction;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.ParameterConfigurationService;
import cn.wtu.broadcast.openapi.api.ParameterIntegrationService;
import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.terminal.control.common.Protocol0x40Body;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.cmd.CertificateIssueVo;
import cn.wtu.broadcast.parent.vo.cmd.RdsFrequencyPointVo;
import cn.wtu.broadcast.parent.vo.cmd.SetResourceCodeVo;
import cn.wtu.broadcast.parent.vo.cmd.SetReturnAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.SetStateQueryParameterVo;
import cn.wtu.broadcast.parent.vo.cmd.TerminalIpAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.TsFrequencyPointVo;

/**
 * 终端请求指令Controller 平台发指令给适配器
 *
 * @since 2019-06-10
 */
@Controller
@RequestMapping("terminal/instruction")
@SuppressWarnings("unused")
public class TerminalRequestInstructionController {
	
	private static Logger logger = LoggerFactory.getLogger(TerminalRequestInstructionController.class);
	
	@Autowired
	private ParameterConfigurationService parameterConfigurationService;

	@Autowired
	private ParameterIntegrationService parameterIntegrationService;
	/**
	 * TS锁定频率设置
	 */
	@RequestMapping("/setTsLockFrequency")
	@ResponseBody
	public BroadcastResult setTsLockFrequency(
			@RequestParam(value = "resourceCodes", required = true) String resourceCodes,
			TsFrequencyPointVo tsFrequencyPointVos) {
		try {
			int addRdsToDdeviceTsSet = parameterIntegrationService.integrationAddRdsToDdeviceTsSet(resourceCodes, tsFrequencyPointVos);
			if (addRdsToDdeviceTsSet > 0) {
				return BroadcastResult.ok("新增成功");
			} else {
				return BroadcastResult.ok("新增失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("数据新增出现异常,新增失败");
		}
	}

	/**
	 * 设置RDS扫描频点信息
	 */
	@RequestMapping("/setRDSScanFrequencyPoint")
	@ResponseBody
	public BroadcastResult setRDSScanFrequencyPoint(
			@RequestParam(value = "resourceCodes", required = true) String resourceCodes,
			List<RdsFrequencyPointVo> rdsFrequencyPointVos) {
		try {
			int addRdsToDdeviceRdsSet =parameterIntegrationService.integrationSetRDSScanFrequencyPoint(resourceCodes, rdsFrequencyPointVos);
			if (addRdsToDdeviceRdsSet > 0) {
				return BroadcastResult.ok("设置成功");
			} else {
				return BroadcastResult.fail("新增设置失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("设置失败");
		}

	}

	/**
	 * 通用网络参数设置
	 */
	@RequestMapping("/setNetworkParameter")
	@ResponseBody
	public BroadcastResult setNetworkParameter(TerminalIpAddressVo terminalIpAddressVo) {
		try {
			int ipAddress = parameterIntegrationService.integrationSetNetworkParameter(terminalIpAddressVo);
			if (ipAddress > 0) {
				return BroadcastResult.ok("设置成功");
			} else {
				return BroadcastResult.fail("更新或插入失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("设置失败");
		}

	}

	/**
	 * 通用资源编码设置
	 */
	@RequestMapping("/updateResourceCode")
	@ResponseBody
	public BroadcastResult updateResourceCode(List<SetResourceCodeVo> setResourceCodeVo) {
		try {
			parameterIntegrationService.integrationUpdateResourceCode(setResourceCodeVo);
			return BroadcastResult.ok("更新资源编码设置成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("更新资源编码设置失败");
		}

	}

	/**
	 * 设置音量
	 */
	@RequestMapping("/setVolume")
	@ResponseBody
	public BroadcastResult setVolume(@RequestParam(value = "resourceCodes", required = true) String resourceCodes,
			@RequestParam(value = "volume") Integer volume) {
		try {
			parameterIntegrationService.integrationSetVolume(resourceCodes, volume);
			return BroadcastResult.ok();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("更新失败");
		}

	}

	/**
	 * 通用回传参数设置（0x07）
	 */
	@RequestMapping("/setCommonReturnParameter")
	@ResponseBody
	public BroadcastResult setCommonReturnParameter(
			@RequestParam(value = "resourceCodes", required = true) String resourceCodes,
			SetReturnAddressVo setReturnAddressVo) {
		try {
			int returnAddress = parameterIntegrationService.integrationSetCommonReturnParameter(resourceCodes, setReturnAddressVo);
			if (returnAddress > 0) {
				return BroadcastResult.ok();
			} else {
				return BroadcastResult.fail("插入或更新失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("设置失败");
		}

	}

	/**
	 * 终端参数/状态查询指令（0x08）
	 */
	@RequestMapping("/setStateQueryParameter")
	@ResponseBody
	public BroadcastResult setStateQueryParameter(
			@RequestParam(value = "resourceCodes", required = true) String resourceCodes,
			SetStateQueryParameterVo setStateQueryParameterVo) {
		try {
			parameterIntegrationService.integrationSetStateQueryParameter(resourceCodes, setStateQueryParameterVo);
			return BroadcastResult.ok("更新查询状态参数成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("更新查询状态参数失败");
		}

	}

	/**
	 * 通用时钟校准（0x09）
	 */
	@RequestMapping("/setTime")
	@ResponseBody
	public BroadcastResult setTime(@RequestParam(value = "resourceCodes", required = true) String resourceCodes) {
		try {
			parameterIntegrationService.integrationSetTime(resourceCodes);
			return BroadcastResult.ok("通用时钟校准成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.fail("通用时钟校准失败");
		}
	}

	/**
	 * 通用回传周期设置（0x0B）
	 */
	@RequestMapping("/setReturnCycle")
	@ResponseBody
	public BroadcastResult setReturnCycle(@RequestParam(value = "resourceCodes", required = true) String resourceCodes,
			@RequestParam(value = "datetime", required = true) Integer datetime) {
		try {
			parameterIntegrationService.integrationSetReturnCycle(resourceCodes, datetime);
			return BroadcastResult.ok("设置成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.ok("设置失败");
		}

	}

	/**
	 * 通用终端功放开关指令(0x3F)
	 */
	@RequestMapping("/setTerminalPowerSwitch")
	@ResponseBody
	public BroadcastResult setTerminalPowerSwitch(
			@RequestParam(value = "resourceCodes", required = true) String resourceCodes,
			@RequestParam(value = "switchNumber", required = true) Integer switchNumber) {
		try {
			parameterIntegrationService.integrationSetTerminalPowerSwitch(resourceCodes, switchNumber);
			return BroadcastResult.ok("设置成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.ok("设置失败");
		}
	}
	
	/**
	 * 通用证书更新(0x40)
	 */
	@RequestMapping("/setTerminalUpdateCertificate")
	@ResponseBody
	public BroadcastResult setTerminalUpdateCertificate(){
		
		//终端证书下发 0x40
		Protocol0x40Body protocol0x40Body = new Protocol0x40Body();
		CertificateIssueVo certificateIssueVo = null;
		
		//path和SMSN从页面获取,且格式如下
		String path = "00000000131D.00000000131E";
		String SMSN = "00000000131C";
		try {
			certificateIssueVo = IssueCertificateTool.getCertificateIssueVo(path,SMSN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        //获取证书链列表
		for (String string : certificateIssueVo.getCertificateLIST()) {
			byte[] certauth = SendProtocolTools.hexStringToByte(string);
			Protocol0x40Body.CertauthInfo certauthInfo = new Protocol0x40Body.CertauthInfo(certauth);
			protocol0x40Body.certauthInfos.add(certauthInfo);
		}
		
		//获取证书列表
		for (String string : certificateIssueVo.getCertCtx()) {
			byte[] certh = SendProtocolTools.hexStringToByte(string);
			Protocol0x40Body.CerthInfo certhInfo = new Protocol0x40Body.CerthInfo(certh);
			protocol0x40Body.certhInfos.add(certhInfo);
		}
				
		return null;
	}
}
