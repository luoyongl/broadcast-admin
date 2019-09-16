package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;


public interface DispatchHttpclientService {

	/**
     * 开启发送指令的操作
     * @param dispatchServerTomcatPort 调控服务器http请求地址的tomcat端口
     * @param broadcastTo 所选播发区域
     * @param broadcastType 广播类型
     * @param broadcastId 广播ID
     * 	@param adapterResourceCode 适配器资源码
     * @return
     */
	public BroadcastResult sendBroadcast(String dispatchServerTomcatPort, Integer broadcastType, Integer broadcastId,String adapterResourceCode);
	
	/**
	 * 停播
	 * @param dispatchServerTomcatPort 调控服务器http请求地址的tomcat端口
	 * @param broadcastId 广播ID
	 * @return
	 */
	public BroadcastResult stopBroadcast(String dispatchServerTomcatPort, Integer broadcastId);
	
}
