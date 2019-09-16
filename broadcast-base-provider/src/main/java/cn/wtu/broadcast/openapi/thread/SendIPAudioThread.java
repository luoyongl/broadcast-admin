package cn.wtu.broadcast.openapi.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.util.VlcCommend;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;

public class SendIPAudioThread implements Runnable {

	public static Logger logger = LoggerFactory.getLogger(SendIPAudioThread.class);

	private BBroadcastDataService broadcastService;
	private BBroadcastDataExtMapper broadcastDataExtMapper;

	private Integer fId;
	private String ip;
	private String port;

	public SendIPAudioThread(Integer fId, String ip, String port,BBroadcastDataService broadcastService,BBroadcastDataExtMapper broadcastDataExtMapper) {
		this.fId = fId;
		this.ip = ip;
		this.port = port;
		this.broadcastService = broadcastService;
		this.broadcastDataExtMapper = broadcastDataExtMapper;
	}

	@Override
	public synchronized void run() {
		// IP广播时候才更新数据库
		if (broadcastService != null) {
			// 更新广播数据表中的状态为正在播放 同时加入的待播放的数据表中
			broadcastService.setStateByFid(fId, BroadcastStateEnum.broadcasting.getCode());
		}
		try {
			VlcCommend.playTestWindows(fId, ip, port,broadcastDataExtMapper);
		} catch (Exception e) {
			logger.error("IP指令音频发送发送异常：" + e.getMessage() + e);
		}
		if (broadcastService != null) {
			// 更新广播数据表中的状态为播放结束 同时删除待播放列表中的相关数据
			broadcastService.setStateByFid(fId, BroadcastStateEnum.broadcasted.getCode());
			logger.info("广播{}正常播放完成, 状态更新为{}", fId, BroadcastStateEnum.broadcasted.getCode());
		}
	}
}