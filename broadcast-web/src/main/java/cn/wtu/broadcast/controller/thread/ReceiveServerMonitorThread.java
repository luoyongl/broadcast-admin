package cn.wtu.broadcast.controller.thread;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BServerRuntimeInfoService;
import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.parent.utils.CRCUtil;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;

/**
 * socket 线程类
 * 
 */
public class ReceiveServerMonitorThread implements Runnable {

	public Logger logger = LoggerFactory.getLogger(ReceiveServerMonitorThread.class);
	
	private BServerRuntimeInfoService bServerRuntimeInfoService;

	public ReceiveServerMonitorThread(BServerRuntimeInfoService bServerRuntimeInfoService) {
		this.bServerRuntimeInfoService = bServerRuntimeInfoService;
	}

	@Override
	public void run() {
		while(true){
			try {
				String returnServerIp = RedisDb.getString("return_server_ip");
				Integer returnServerPort =  Integer.valueOf(RedisDb.getString("return_server_port"));
				receiveServerMonitor(returnServerIp, returnServerPort);
				Thread.sleep(10000);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
		}
	}
	
	/**
	 * 回传服务器实时状态更新处理
	 */
	private void receiveServerMonitor(String returnServerIp, Integer returnServerPort) {
		DatagramSocket datagramSocket;
		try {
			datagramSocket = new DatagramSocket();
			InetAddress inetAddress = InetAddress.getByName(returnServerIp);
			byte[] totalData = UDPUtil.hexToByte("8888");
			DatagramPacket sendDP = new DatagramPacket(totalData, totalData.length, inetAddress, returnServerPort);
			datagramSocket.send(sendDP);
			
			 //接收服务器反馈数据  
            byte[] backbuf = new byte[1024];  
            DatagramPacket backPacket = new DatagramPacket(backbuf, backbuf.length);  
            datagramSocket.setSoTimeout(10000);
            datagramSocket.receive(backPacket);
            String backMsg = CRCUtil.byteToHex(backPacket.getData(), backPacket.getLength());
			if(backMsg != null && "8888".equals(backMsg)){
				// 关闭资源
				datagramSocket.close();
				// 更新回传服务器为正常
				logger.info("回传服务器{}:{}当前在线", returnServerIp, returnServerPort);
				// 1：调控服务器  2：回传服务器 3：省级平台解析服务器   0：离线  1：在线
				bServerRuntimeInfoService.updateBServerRuntimeInfoByType(2, 1);
			}
		} catch (Exception e) {
			// 更新回传服务器为异常
			logger.error("========回传服务器 {}:{} 当前离线 ======== " , returnServerIp, returnServerPort);
			// 1：调控服务器  2：回传服务器  3：省级平台解析服务器   0：离线  1：在线
			bServerRuntimeInfoService.updateBServerRuntimeInfoByType(2, 0);
		}
		
	}
}
