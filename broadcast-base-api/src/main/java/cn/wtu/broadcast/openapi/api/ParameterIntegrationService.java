package cn.wtu.broadcast.openapi.api;

import java.util.List;


import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.parent.service.api.ParentService;
import cn.wtu.broadcast.parent.vo.cmd.RdsFrequencyPointVo;
import cn.wtu.broadcast.parent.vo.cmd.SetResourceCodeVo;
import cn.wtu.broadcast.parent.vo.cmd.SetReturnAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.SetStateQueryParameterVo;
import cn.wtu.broadcast.parent.vo.cmd.TerminalIpAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.TsFrequencyPointVo;

/**
 * 指令整合业务层接口
 * 
 * @author yinjie
 * @since 2019/7/5
 *
 */

public interface ParameterIntegrationService extends ParentService<BDeviceParameterSet>{
	
	/**
	 * TS锁定频率设置
	 */
	public int integrationAddRdsToDdeviceTsSet(String resourceCodes,TsFrequencyPointVo tsFrequencyPointVos);
	
	/**
	 * 设置RDS扫描频点信息
	 */
	public int integrationSetRDSScanFrequencyPoint(String resourceCodes,List<RdsFrequencyPointVo> rdsFrequencyPointVos);
	
	/**
	 * 通用网络参数设置
	 */
	public int integrationSetNetworkParameter(TerminalIpAddressVo terminalIpAddressVo);
	
	/**
	 * 通用资源编码设置
	 */
	public int integrationUpdateResourceCode(List<SetResourceCodeVo> setResourceCodeVo);
	
	/**
	 * 设置音量
	 */
	public int integrationSetVolume(String resourceCodes,Integer volume);
	
	/**
	 * 通用回传参数设置（0x07）
	 */
	public int integrationSetCommonReturnParameter(String resourceCodes,SetReturnAddressVo setReturnAddressVo);
	
	/**
	 * 终端参数/状态查询指令（0x08）
	 */
	public int integrationSetStateQueryParameter(String resourceCodes,SetStateQueryParameterVo setStateQueryParameterVo);
	
	/**
	 * 通用时钟校准（0x09）
	 */
	public int integrationSetTime(String resourceCodes);
	
	/**
	 * 通用回传周期设置（0x0B）
	 */
	public int integrationSetReturnCycle(String resourceCodes,Integer datetime);
	
	/**
	 * 通用终端功放开关指令(0x3F)
	 */
	public int integrationSetTerminalPowerSwitch(String resourceCodes,Integer switchNumber);
}
