package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BBroadcastDevice;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * 广播设备表service接口
 *
 * @author lxg
 * @date 2019/03/28
 */
public interface BBroadcastDeviceService extends ParentService<BBroadcastDevice>{
	
	void updateReceiveInfoToTbl(Integer fDeviceId, Integer fBroadcastId, Boolean fIsTimingBroadcast);
	
}
