package cn.wtu.broadcast.controller.resourceManage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.fabric.xmlrpc.base.Param;

import cn.wtu.broadcast.config.DeviceBroadcastConfig;
import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.api.ParameterConfigurationService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceOutputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.openapi.model.BDeviceRdsSet;
import cn.wtu.broadcast.openapi.model.BDeviceTerminalStatusQuery;
import cn.wtu.broadcast.parent.dto.IpOrPortInParameterStatusDto;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.cmd.RdsFrequencyPointVo;
import cn.wtu.broadcast.parent.vo.cmd.SetReturnAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.TerminalIpAddressVo;
import cn.wtu.broadcast.parent.vo.cmd.TsFrequencyPointVo;

/**
 * 参数配置表相关操作
 * @author yinjie
 * @date 2019/6/25
 */

@Controller
@SuppressWarnings("unused")
@RequestMapping("/resourceManage/handUpdate/test")
public class ParameterConfigurationController {

	private Logger logger = LoggerFactory.getLogger(ParameterConfigurationController.class);	
	
	@Autowired
	private ParameterConfigurationService parameterConfigurationService;
	
	//获取设备参数(调节音量)
	@ResponseBody
	@RequestMapping("/findVolumeAdjust")
	public BroadcastResult findVolumeAdjust(@RequestParam(value = "resourceCode", required = true)String resourceCode){
		try {
			BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode);
			return BroadcastResult.ok(parameterSet);
		} catch (Exception e) {
			return BroadcastResult.fail("获取失败");
		}
	}
	
	
	//更新音量
	@ResponseBody
	@RequestMapping("/updateVolumeAdjust")
	public BroadcastResult updateVolumeAdjust(@RequestParam(value = "resourceCode", required = true)String resourceCode,
			@RequestParam(value = "volume",required = true)Integer volume){
		try {
			BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode);
			parameterConfigurationService.updateOrInsertVolumeToBDeviceParameterSet(parameterSet,volume,resourceCode);		
			return BroadcastResult.ok();
		} catch (Exception e) {
			return BroadcastResult.fail("更新失败");
		}
	}
	
	//功放开关
	@ResponseBody
	@RequestMapping("/setPowerSwitch")
	public BroadcastResult setPowerSwitch(@RequestParam(value = "resourceCode", required = true)String resourceCode,
			@RequestParam(value = "switchNumber",required = true)Integer switchNumber){
		try{
			BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode);
			parameterConfigurationService.updateOrInsertSwitchNumberToBDeviceParameterSet(parameterSet, switchNumber, resourceCode);
			return BroadcastResult.ok("设置成功");
		}catch(Exception e){
			return BroadcastResult.ok("设置失败");
		}
	}
	
	//设置回传地址
	@ResponseBody
	@RequestMapping("/setReturnAddress")
	public BroadcastResult setReturnAddress(@RequestParam(value = "resourceCodes", required = true)String resourceCodes,
			SetReturnAddressVo setReturnAddressVo){
		try {
			String[] resourceCode = resourceCodes.split(",");
			int returnAddress = 0;
			for(int i = 0;i < resourceCode.length ; i++){
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resourceCode[i]);
				returnAddress += parameterConfigurationService.updateOrInsertReturnAddressToBDeviceParameterSet(findParameterSet, resourceCode[i], 
						setReturnAddressVo.getReturnIpValue(), setReturnAddressVo.getReturnPortValue().toString());
			}
			if (returnAddress > 0) {
				return BroadcastResult.ok();
			}else {
				return BroadcastResult.fail("插入或更新失败");
			}
		} catch (Exception e) {
			return BroadcastResult.fail("设置失败");
		}
	}
	
	//设置回传周期
	@ResponseBody
	@RequestMapping("/setReturnCycle")
	public BroadcastResult setReturnCycle(@RequestParam(value = "resourceCode", required = true)String resourceCode,
			@RequestParam(value = "datetime",required = true)Integer datetime){
		try{
			BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode);
			parameterConfigurationService.updateOrInsertReturnCycleToBDeviceParameterSet(parameterSet, datetime, resourceCode);
			return BroadcastResult.ok("设置成功");
		}catch(Exception e){
			return BroadcastResult.ok("设置失败");
		}
	}
	
	//终端信息查询 TODO
	@ResponseBody
	@RequestMapping("/findTerminalInformation")
	public BroadcastResult findTerminalInformation(@RequestParam(value = "resourceCode", required = true)String resourceCode){
		try {
			BDeviceParameterSet parameterSet = parameterConfigurationService.findParameterSet(resourceCode);
			return BroadcastResult.ok(parameterSet);
		} catch (Exception e) {
			return BroadcastResult.fail("获取失败");
		}
	}
	
	//设置IP地址
	@ResponseBody
	@RequestMapping("/setTerminalIpAddress")
	public BroadcastResult setTerminalIpAddress(@RequestParam("terminalIpAddressVo")TerminalIpAddressVo terminalIpAddressVo){
		try {
			BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(terminalIpAddressVo.getResourceCode());
			int ipAddress = parameterConfigurationService.updateOrInsertIpAddressToBDeviceParameterSet(findParameterSet, terminalIpAddressVo.getResourceCode(),
					terminalIpAddressVo.getIpAddressValue(), terminalIpAddressVo.getSubnetMask(), terminalIpAddressVo.getIpGate());
			if (ipAddress > 0) {
				return BroadcastResult.ok("设置成功");
			}else {
				return BroadcastResult.fail("更新或插入失败");
			}
		} catch (Exception e) {
			return BroadcastResult.fail("设置失败");
		}
	}
	
	//RDS设置频点(新增)
	@ResponseBody
	@RequestMapping("/addRdsFrequencyPoint")
	public BroadcastResult addRdsFrequencyPoint(@RequestParam(value = "resourceCode", required = true)String resourceCodes,
			@RequestParam(value = "rdsFrequencyPointVos")List<RdsFrequencyPointVo> rdsFrequencyPointVos){
		try {
			String[] resourceCode = resourceCodes.split(",");
			int addRdsToDdeviceRdsSet = 0;
			for (RdsFrequencyPointVo rdsVo : rdsFrequencyPointVos) {
				for(int i = 0; i < resourceCode.length ; i++){
					addRdsToDdeviceRdsSet +=  parameterConfigurationService.addRdsToDdeviceRdsSet(resourceCode[i], rdsVo.getRdsPriority(), rdsVo.getRdsFrequency());
				}
			}
			if (addRdsToDdeviceRdsSet > 0) {
				return BroadcastResult.ok("设置成功");
			}else{
				return BroadcastResult.fail("新增设置失败");
			}
		} catch (Exception e) {
			return BroadcastResult.fail("设置失败");
		}
	}
	
	//RDS设置频点(修改)
	@ResponseBody
	@RequestMapping("/updateRdsFrequencyPoint")
	public BroadcastResult updateRdsFrequencyPoint(@RequestParam(value = "rdsId",required = true)Integer rdsId,
			@RequestParam(value = "rdsPriority",required = true)Integer rdsPriority,
			@RequestParam(value = "rdsFrequency",required = true)Double rdsFrequency){
		try {
			int addRdsToDdeviceRdsSet = parameterConfigurationService.updateRdsToDdeviceRdsSet(rdsId, rdsPriority, rdsFrequency);
			if (addRdsToDdeviceRdsSet > 0) {
				return BroadcastResult.ok("修改成功");
			}else{
				return BroadcastResult.fail("修改设置失败");
			}
		} catch (Exception e) {
			return BroadcastResult.fail("修改失败");
		}
	}
	
	//RDS设置频点(删除)
	@ResponseBody
	@RequestMapping("/deleteRdsFrequencyPoint")
	public BroadcastResult deleteRdsFrequencyPoint(@RequestParam(value = "rdsId",required = true)Integer rdsId){
		try {
			int addRdsToDdeviceRdsSet = parameterConfigurationService.deleteRdsToDdeviceRdsSet(rdsId);
			if (addRdsToDdeviceRdsSet > 0) {
				return BroadcastResult.ok("删除成功");
			}else{
				return BroadcastResult.fail("删除设置失败");
			}
		} catch (Exception e) {
			return BroadcastResult.fail("删除失败");
		}
	}
	
	//RDS查询回显页面
	@ResponseBody
	@RequestMapping("/findRdsFrequencyPoint")
	public BroadcastResult findRdsFrequencyPoint(@RequestParam(value = "resourceCode",required = true)String resourceCode){
		try {
			List<BDeviceRdsSet> bDeviceRdsSetsList = parameterConfigurationService.findBDeviceRdsSetByCode(resourceCode);
			return BroadcastResult.ok(bDeviceRdsSetsList);
		} catch (Exception e) {
			return BroadcastResult.fail("删除失败");
		}
	}
	
	//TS设置频点(新增)
	@ResponseBody
	@RequestMapping("/addTsFrequencyPoint")
	public BroadcastResult addTsFrequencyPoint(@RequestParam(value = "resourceCodes",required = true)String resourceCodes,
			@RequestParam(value = "tsFrequencyPointVos",required = true)TsFrequencyPointVo tsFrequencyPointVos){
		try {
			int addRdsToDdeviceTsSet = 0;
			String[] resourceCode = resourceCodes.split(",");
			for (String resource : resourceCode) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resource);
				addRdsToDdeviceTsSet += parameterConfigurationService.addRdsToDdeviceTsSet(findParameterSet, resource, tsFrequencyPointVos.getFrequency(), tsFrequencyPointVos.getSymbolRate(), tsFrequencyPointVos.getQamNumber());
			}
			if(addRdsToDdeviceTsSet > 0){
				return BroadcastResult.ok("新增成功");
			}else {
				return BroadcastResult.ok("新增失败");
			}
		} catch (Exception e) {
			return BroadcastResult.fail("数据新增出现异常,新增失败");
		}
	}
	
	//查询输入通道
	@ResponseBody
	@RequestMapping("/findInputChannelList")
	public BroadcastResult findInputChannelList(@RequestParam(value = "resourceCode", required = true)String resourceCode){
		try {
			List<BDeviceInputChannel> findInputChannelList = parameterConfigurationService.findInputChannelList(resourceCode);
			return BroadcastResult.ok(findInputChannelList);
		} catch (Exception e) {
			return BroadcastResult.fail("获取数据失败");
		}
	}
	
	//查询输出通道
	@ResponseBody
	@RequestMapping("/findOutputChannelList")
	public BroadcastResult findOutputChannelList(@RequestParam(value = "resourceCode", required = true)String resourceCode){
		try {
			List<BDeviceOutputChannel> findOutputChannelList = parameterConfigurationService.findOutputChannelList(resourceCode);
			return BroadcastResult.ok(findOutputChannelList);
		} catch (Exception e) {
			return BroadcastResult.fail("获取数据失败");
		}
	}
	
	/**
	 * 查询参数回复表 
	 * @since 2019/7/1
	 */
	@ResponseBody
	@RequestMapping("/findParamResponse")
	public BroadcastResult findParamResponse(@RequestParam(value = "resourceCode", required = true)String resourceCode){
		try {
			BDeviceTerminalStatusQuery bTerminalStatusQuery = parameterConfigurationService.findParamResponse(resourceCode);
			return BroadcastResult.ok(bTerminalStatusQuery);
		} catch (Exception e) {
			return BroadcastResult.fail("获取数据失败");
		}
	}
	
	/**
	 * 更新资源编码设置
	 * @since 2019/7/2
	 */
	@ResponseBody
	@RequestMapping("/insertOrUpdateResourceCodes")
	public BroadcastResult insertOrUpdateResourceCodes(@RequestParam(value = "resourceCodes", required = true)List<String> resourceCodes){
		try {
			for (String resource : resourceCodes) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resource);
				int count = parameterConfigurationService.insertOrUpdateCodes(findParameterSet,resource);				
			}
			return BroadcastResult.ok("更新资源编码设置成功");
		} catch (Exception e) {
			return BroadcastResult.fail("更新资源编码设置失败");
		}
	}
	
	/**
	 * 存储查询状态参数(状态类型)
	 * @since 2019/7/2
	 */
	@ResponseBody
	@RequestMapping("/insertOrUpdateParameterStatus")
	public BroadcastResult insertOrUpdateParameterStatus(@RequestParam(value = "resourceCodes", required = true)List<String> resourceCodes,
			@RequestParam(value = "queryCodes",required = true) String queryCodes){
		try {
			for (String resource : resourceCodes) {
				BDeviceParameterSet findParameterSet = parameterConfigurationService.findParameterSet(resource);
				parameterConfigurationService.insertOrUpdateParameterStatus(findParameterSet,resource,queryCodes);				
			}
			return BroadcastResult.ok("更新查询状态参数成功");
		} catch (Exception e) {
			return BroadcastResult.fail("更新查询状态参数失败");
		}
	}
	
	/**
	 * 查询状态参数
	 * 目的：判断不同设备的回传IP和端口是否相同
	 * @param : resourceCode
	 * @return : broadcast
	 * @since : 2019/7/3
	 * @author yinjie
	 */
	@RequestMapping("/ipOrPortInParameterStatus")
	@ResponseBody
	public BroadcastResult ipOrPortInParameterStatus(@RequestParam(value = "resourceCodes")String resourceCodes){
		try {
			List<String> resourceCode = Arrays.asList(resourceCodes.split(","));
			IpOrPortInParameterStatusDto ipOrPortDto = parameterConfigurationService.ipOrPortInParameterStatus(resourceCode);
			return new BroadcastResult(ipOrPortDto.getStatus(),null,ipOrPortDto);
		} catch (Exception e) {
			return BroadcastResult.fail("查询状态比较判断不成功") ;
		}
	}

	/**
	 * 以下是对白名单更新相关操作
	 * 注： 设备表id(多个或一个),资源编码(多个或一个),授权区域码(多个或一个)[理解不同点] 该参数现在不用
	 * @param 1操作类型(增删改) 2账号  3姓名  4电话号码  5授权方式  6授权区域   7资源编码  8白名单id(删除)
	 * 
	 */
	@RequestMapping("/addWhiteList")
	@ResponseBody
	public BroadcastResult addWhiteList(@RequestParam("operCode")int operCode,
			@RequestParam("account")String account,
			@RequestParam("username")String username,
			@RequestParam("phoneNumber")String phoneNumber,
			@RequestParam("permit")int permit,
			@RequestParam("areaCode")String areaCode,
			@RequestParam("resourceCode")String resourceCode){
		try {
			int count = parameterConfigurationService.addWhiteList(operCode, account,username, phoneNumber, permit, areaCode, resourceCode);
			if (count > 0) {
				return BroadcastResult.ok("更新了"+ count + "条数据");
			}
			return BroadcastResult.fail("没有更新的数据");
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return BroadcastResult.fail("更新失败");
		}
		
	}
	
	/**
	 * 白名单更新删除操作
	 */
	@RequestMapping("/deleteWhiteList")
	@ResponseBody
	public BroadcastResult deleteWhiteList(@RequestParam("whiteListId")String whiteListId){
		try {
			int count = 0;
			String[] listId = whiteListId.split(",");
			for (String whiteId : listId) {
				count += parameterConfigurationService.deleteWhiteList(Integer.valueOf(whiteId));				
			}
			if (count > 0) {
				return BroadcastResult.ok("删除了" + count + "条数据");
			}
			return BroadcastResult.fail("没有要删除的数据");
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return BroadcastResult.fail("删除失败");
		}
	}
	
	/**
	 * 白名单更新查询操作 (2019.7.15 白名单要与user表进行关联，暂时将白名单与user表账号进行关联，表字段进行修改,查询加入resourceCode字段)
	 */
	@RequestMapping("/selectwhitelist")
	@ResponseBody
	public BroadcastResult selectwhitelist(
			@RequestParam(defaultValue="desc", required=false) String sortOrder,
			@RequestParam(defaultValue="fCreateTime", required=false) String sortName,
			@RequestParam(defaultValue="resourceCode",required=false) String resourceCode,
			@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize){
		 Map<String, Object> paramMap = Maps.newHashMap();
	     paramMap.put("pageNumber", pageNumber);
	     paramMap.put("pageSize", pageSize);
	     paramMap.put("sortOrder",sortOrder);
	     paramMap.put("resourceCode", resourceCode);
	     if (sortName.equals("fCreateTime")) {
				paramMap.put("sortName", "f_create_time");
			}
	    return BroadcastResult.ok(parameterConfigurationService.queryPage(paramMap));
	}
}
