package cn.wtu.broadcast.controller.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.wtu.broadcast.openapi.api.BServerRuntimeInfoService;
import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.parent.utils.PropertiesUtil;
import cn.wtu.broadcast.parent.utils.httpclient.HttpClientCommonHelper;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;

/**
 * socket 线程类
 * 
 */
@Component
public class IPServerMonitorThread implements Runnable {

	public Logger logger = LoggerFactory.getLogger(IPServerMonitorThread.class);
	
	/**
	 * 与服务器建立连接的socket对象
	 */
	private Socket socket;
	/**
	 * 输出流，用于发送心跳
	 */
	private OutputStream outputStream;

	private BServerRuntimeInfoService bServerRuntimeInfoService;

	public IPServerMonitorThread(BServerRuntimeInfoService bServerRuntimeInfoService) {
		this.bServerRuntimeInfoService = bServerRuntimeInfoService;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String ipServerIP = RedisDb.getString("transmit_server_url");
				Integer ipServerport = Integer.valueOf(RedisDb.getString("transmit_server_port"));
				boolean ipTomcatCheck = ipTomcatServerMonitor(ipServerIP);
				boolean ipCheck = false;
				if (ipTomcatCheck) {
					ipCheck = ipServerMonitor(ipServerIP, ipServerport);
				}
				if (ipCheck && ipTomcatCheck) {
					// 1：调控服务器 2：回传服务器 3：省级平台解析服务器 0：离线 1：在线
					bServerRuntimeInfoService.updateBServerRuntimeInfoByType(1, 1);
				} else {
					// 1：调控服务器 2：回传服务器 3：省级平台解析服务器 0：离线 1：在线
					bServerRuntimeInfoService.updateBServerRuntimeInfoByType(1, 0);
				}
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage() + e);
			}
		}
	}

	/**
	 * 调控服务器是否正常的判断
	 * 
	 * @throws IOException
	 */
	private boolean ipServerMonitor(String ipServerIP, Integer ipServerport) throws Exception {
		boolean checkResult = true;
		try {
			// 创建一个客户端socket
			if (socket == null) {
				socket = new Socket(ipServerIP, ipServerport);
				if (!socket.getKeepAlive()) {
					// true，若长时间没有连接则断开
					socket.setKeepAlive(true);
				}
				if (!socket.getOOBInline()) {
					// true,允许发送紧急数据，不做处理
					socket.setOOBInline(true);
				}
				// 向服务器端传递信息
				outputStream = socket.getOutputStream();
				new Thread(new Runnable() {
					@Override
					public void run() {
						while (true) {
							try {
								// 10s发送一次心跳
								Thread.sleep(10 * 1000);
								outputStream.write(UDPUtil.hexToByte("8888"));
								outputStream.flush();
							} catch (Exception e) {
								break;
							}
						}
					}
				}).start();
			}
		} catch (Exception e) {
			// 更新调控服务器为异常
			logger.error("========调控服务器 {}:{} 当前IP离线 ======== ", ipServerIP, ipServerport);
			if(socket != null){
				socket.close();
				socket = null;
			}
			if(outputStream != null){
				outputStream.close();
			}
			checkResult = false;
		}

		return checkResult;
	}

	/**
	 * 省级平台解析服务器实时状态更新处理
	 */
	private boolean ipTomcatServerMonitor(String ipServerIP) {
		boolean ipTomcatCheck = false;
		try {
			Map<String, String> map = new HashMap<String, String>();
			String dispatchServerTomcatPort = PropertiesUtil.getProperty("dispatch.server.tomcat.port");
			String backMsg = HttpClientCommonHelper
					.sendPost("http://" + ipServerIP + ":" + dispatchServerTomcatPort + "/dispatch/heart", map, 5000);
			if (backMsg != null) {
				logger.info("========调控服务器 {}当前Tomcat在线 ======== ", ipServerIP);
				ipTomcatCheck = true;
			}
		} catch (Exception e) {
			logger.error("========调控服务器 {} 当前Tomcat离线 ======== ", ipServerIP);
		}
		return ipTomcatCheck;
	}
}
