package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;

/**
 * 音频播放业务层service
 */
public interface AudioPlayService {
	
	/**
	 * 根据广播选中的区域查询对应的设备
	 * 
	 * @param resourceId
	 * @param broadcastfId
	 * @param type
	 */
	public void addDeviceByResourceIds(String resourceId, Integer broadcastfId, Integer type);

	public void addDeviceResourceIds(String resourceId, Integer broadcastfId, Integer type);

	public BroadcastResult ipPlayAudio(Integer broadcastType, Integer broadcastId, String broadcastTomcatPath,String adapterResourceCode);

}
