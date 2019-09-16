package cn.wtu.broadcast.controller.instruction;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.ParameterConfigurationService;
import cn.wtu.broadcast.openapi.api.ParameterIntegrationService;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.openapi.protocol.ProtocolTotalInfoUtil;
import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
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
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.cmd.RdsFrequencyPointVo;
import cn.wtu.broadcast.parent.vo.cmd.SetResourceCodeVo;
import cn.wtu.broadcast.parent.vo.cmd.SetReturnAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.SetStateQueryParameterVo;
import cn.wtu.broadcast.parent.vo.cmd.TerminalIpAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.TsFrequencyPointVo;

/**
 * 请求指令Controller 平台发指令给适配器
 *
 * @since 2019-06-10
 * 
 * @since 2019/7/15
 * 修改返回页面数据，从操作数据库转移至以回传数据为主
 * 
 */
@Controller
@RequestMapping("instruction/request")
@SuppressWarnings("unused")
public class RequestInstructionController {
	
	private static Logger logger = LoggerFactory.getLogger(RequestInstructionController.class);
	
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
			String compareReturnValues = compareReturnValues(addRdsToDdeviceTsSet);
			return new BroadcastResult(200,compareReturnValues,null);
			
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
			@RequestBody List<RdsFrequencyPointVo> rdsFrequencyPointVos) {
		try {
			int addRdsToDdeviceRdsSet =parameterIntegrationService.integrationSetRDSScanFrequencyPoint(resourceCodes, rdsFrequencyPointVos);
			String compareReturnValues = compareReturnValues(addRdsToDdeviceRdsSet);
			return new BroadcastResult(200,compareReturnValues,null);
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
			String compareReturnValues = compareReturnValues(ipAddress);
			return new BroadcastResult(200,compareReturnValues,null);
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
			int code = parameterIntegrationService.integrationUpdateResourceCode(setResourceCodeVo);
			String compareReturnValues = compareReturnValues(code);
			return new BroadcastResult(200,compareReturnValues,null);
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
			int integrationSetVolume = parameterIntegrationService.integrationSetVolume(resourceCodes, volume);
			String compareReturnValues = compareReturnValues(integrationSetVolume);
			return new BroadcastResult(200,compareReturnValues,null);
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
			String compareReturnValues = compareReturnValues(returnAddress);
			return new BroadcastResult(200,compareReturnValues,null);
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
			int integrationSetStateQueryParameter = parameterIntegrationService.integrationSetStateQueryParameter(resourceCodes, setStateQueryParameterVo);
			String compareReturnValues = compareReturnValues(integrationSetStateQueryParameter);
			return new BroadcastResult(200,compareReturnValues,null);
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
			int integrationSetTime = parameterIntegrationService.integrationSetTime(resourceCodes);
			String compareReturnValues = compareReturnValues(integrationSetTime);
			return new BroadcastResult(200,compareReturnValues,null);
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
			int integrationSetReturnCycle = parameterIntegrationService.integrationSetReturnCycle(resourceCodes, datetime);
			String compareReturnValues = compareReturnValues(integrationSetReturnCycle);
			return new BroadcastResult(200,compareReturnValues,null);
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
			int integrationSetTerminalPowerSwitch = parameterIntegrationService.integrationSetTerminalPowerSwitch(resourceCodes, switchNumber);
			String compareReturnValues = compareReturnValues(integrationSetTerminalPowerSwitch);
			return new BroadcastResult(200,compareReturnValues,null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return BroadcastResult.ok("设置失败");
		}
	}
	
	/**
	 * 提取一个公共比较方法
	 * @since 2019/7/15
	 */
	public String compareReturnValues(int value){
		if (value == -1) {
			return "指令发送成功，但出现未知错误";
		}else if (value == 0) {
			return "指令发送成功，且执行成功";
		}else if (value == 1) {
			return "指令发送成功，但出现数据长度错误";
		}else if (value == 2) {
			return "指令发送成功，但出现版本号错误";
		}else if (value == 3) {
			return "指令发送成功，但出现指令冲突错误";
		}else {
			return "指令发送成功，但出现保留状态";
		}
	}
}
