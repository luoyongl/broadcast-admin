package cn.wtu.broadcast.controller.system;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.SystemInfoRecordService;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.enums.SystemInfoTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.util.HardwareInfoUtil;

/**
 * 系统状态
 *
 * @author sueua
 * @since 2019-01-22
 */
@Controller
@RequestMapping("/systemManage/serverState")
public class ServerStateController {

	private final SystemInfoRecordService systemInfoRecordService;

	@Autowired
	public ServerStateController(SystemInfoRecordService systemInfoRecordService) {
		this.systemInfoRecordService = systemInfoRecordService;
	}

	@GetMapping
	public String ui(){
		return "systemManage/serverStateUi";
	}

	/**
	 * 系统信息
	 */
	@GetMapping("/data")
	@ResponseBody
	public BroadcastResult data(){
		Map<String, Object> data = new HashMap<>();
		data.put("cpuUsedRatio", HardwareInfoUtil.getCpuCoreUseRatio());
		Map<String, Object> cpuParamMap = new HashMap<>(4);
		cpuParamMap.put(TableConst.PAGE_NO_STR, 1);
		cpuParamMap.put(TableConst.PAGE_SIZE_STR, 10);
		cpuParamMap.put("systemInfoType", SystemInfoTypeEnum.CPU);
		data.put("cpuUsedRecord", systemInfoRecordService.queryPageByParam(cpuParamMap).getList());
		Map<String, Object> memoryParamMap = new HashMap<>(4);
		memoryParamMap.put(TableConst.PAGE_NO_STR, 1);
		memoryParamMap.put(TableConst.PAGE_SIZE_STR, 10);
		memoryParamMap.put("systemInfoType", SystemInfoTypeEnum.MEMORY);
		data.put("memoryUsedRecord", systemInfoRecordService.queryPageByParam(memoryParamMap).getList());
		data.put("memoryUsedRatio", HardwareInfoUtil.getMemoryInfo());
		data.put("partitions", HardwareInfoUtil.getPartitionInfo());
		data.put("mysqlStatus", systemInfoRecordService.mysqlStatus());
		data.put("serverControl", systemInfoRecordService.getServerStateById(1));
		data.put("serverReturn", systemInfoRecordService.getServerStateById(2));
		data.put("serverResolve", systemInfoRecordService.getServerStateById(3));
		return BroadcastResult.ok(data);
	}

	/**
	 * 网卡信息,响应较慢,单独出来
	 */
	@GetMapping("/network")
	@ResponseBody
	public BroadcastResult networkInfo(){
		return BroadcastResult.ok(HardwareInfoUtil.getNetworkCardInfo());
	}
	
	/**
	 * @Desc 查询调控服务器状态
	 * @return
	 */
	@RequestMapping("/getBroadcastServerState")
	@ResponseBody
	public BroadcastResult getBroadcastServerState(Integer fServerType){
		Map<String, Object> data = new HashMap<>();
		data.put("broadcastServerState", systemInfoRecordService.getServerStateById(fServerType));
		return BroadcastResult.ok(data);
	}
}
