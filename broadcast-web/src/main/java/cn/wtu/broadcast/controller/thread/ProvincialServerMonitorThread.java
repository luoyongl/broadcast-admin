package cn.wtu.broadcast.controller.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BServerRuntimeInfoService;
import cn.wtu.broadcast.parent.utils.PropertiesUtil;
import cn.wtu.broadcast.parent.utils.httpclient.HttpClientCommonHelper;

/**
 * socket 线程类
 * 
 */
public class ProvincialServerMonitorThread implements Runnable {

	public Logger logger = LoggerFactory.getLogger(ProvincialServerMonitorThread.class);
	
	private BServerRuntimeInfoService bServerRuntimeInfoService;
	
	private static final String provincialServerHeart = PropertiesUtil.getProperty("provincial.server.heart");

	public ProvincialServerMonitorThread(BServerRuntimeInfoService bServerRuntimeInfoService) {
		this.bServerRuntimeInfoService = bServerRuntimeInfoService;
	}

	@Override
	public void run() {
		while(true){
			try {
				receiveServerMonitor();
				Thread.sleep(10000);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
		}
	}
	
	/**
	 * 省级平台解析服务器实时状态更新处理
	 */
	private void receiveServerMonitor() {
		try {
			String backMsg = HttpClientCommonHelper.sendPost(provincialServerHeart, 5000);
			if(backMsg != null){
				// 更新回传服务器为正常
				logger.info("========省级解析平台服务器当前在线========");
				// 1：调控服务器  2：回传服务器 3：省级平台解析服务器   0：离线  1：在线
				bServerRuntimeInfoService.updateBServerRuntimeInfoByType(3, 1);
			}
		} catch (Exception e) {
			// 更新回传服务器为异常
			logger.error("========省级解析平台服务器{}当前离线======== ", provincialServerHeart);
			// 1：调控服务器  2：回传服务器  3：省级平台解析服务器   0：离线  1：在线
			bServerRuntimeInfoService.updateBServerRuntimeInfoByType(3, 0);
		}
		
	}
}
