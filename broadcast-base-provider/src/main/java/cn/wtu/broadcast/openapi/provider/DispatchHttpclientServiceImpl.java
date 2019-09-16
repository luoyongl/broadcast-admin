package cn.wtu.broadcast.openapi.provider;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.wtu.broadcast.openapi.api.DispatchHttpclientService;
import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.httpclient.HttpClientCommonHelper;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;

@Service("dispatchHttpclientService")
public class DispatchHttpclientServiceImpl implements DispatchHttpclientService {
	public static org.slf4j.Logger logger = LoggerFactory.getLogger(DispatchHttpclientServiceImpl.class);
	@Autowired
	private SystemConfigurationService systemConfigurationService;

	/**
	 * 开启发送指令的操作
	 * 
	 * @param dispatchServerTomcatPort 调控服务器http请求地址的tomcat端口
	 * @param broadcastTo 所选播发区域
	 * @param broadcastType 广播类型
	 * @param broadcastId 广播ID
	 * @return
	 */
	@Override
	public BroadcastResult sendBroadcast(String dispatchServerTomcatPort, Integer broadcastType,
			Integer broadcastId,String adapterResourceCode) {
		try {
			// 调控服务器的IP
			TSystemConfiguration systemConfiguration = systemConfigurationService
					.selectDataByCName("transmit_server_url");
			String ipServerIP = systemConfiguration.getfConfigurationValue();
			Map<String, String> map = new HashMap<String, String>();
			map.put("broadcastType", String.valueOf(broadcastType));
			map.put("broadcastId", String.valueOf(broadcastId));
			map.put("broadcastTomcatPath", System.getProperty("catalina.home"));
			RedisDb.setString("broadcastTomcatPath", System.getProperty("catalina.home"));
			map.put("adapterResourceCode", adapterResourceCode);
			String result = HttpClientCommonHelper.sendPost(
					"http://" + ipServerIP + ":" + dispatchServerTomcatPort + "/dispatch/sendBroadcast", map, 5000);
			if (result != null) {
				JSONObject json = JSONObject.parseObject(result);
				String status = String.valueOf(json.get("status"));
				String msg = String.valueOf(json.get("msg"));
				if ("200".equals(status)) {
					return BroadcastResult.build(200, "操作成功,待播发!");
				} else {
					return BroadcastResult.build(400, msg);
				}
			}
		} catch (Exception e) {
			return BroadcastResult.build(400, "调控服务器连接失败，暂时无法播发");
		}

		return BroadcastResult.build(400, "调控服务器开播操作失败");
	}

	/**
	 * 停播
	 * 
	 * @param dispatchServerTomcatPort 调控服务器http请求地址的tomcat端口
	 * @param broadcastTo 所选播发区域
	 * @param broadcastId 广播ID
	 * @return
	 */
	@Override
	public BroadcastResult stopBroadcast(String dispatchServerTomcatPort, Integer broadcastId) {
		try {
			// 调控服务器的IP
			TSystemConfiguration systemConfiguration = systemConfigurationService
					.selectDataByCName("transmit_server_url");
			String ipServerIP = systemConfiguration.getfConfigurationValue();
			Map<String, String> map = new HashMap<String, String>();
			map.put("broadcastId", String.valueOf(broadcastId));
			String result = HttpClientCommonHelper.sendPost(
					"http://" + ipServerIP + ":" + dispatchServerTomcatPort + "/dispatch/stopBroadcast", map, 5000);
			if (result != null) {
				JSONObject json = JSONObject.parseObject(result);
				String status = String.valueOf(json.get("status"));
				if ("200".equals(status)) {
					return BroadcastResult.build(200, "停播成功");
				}
			}
		} catch (Exception e) {
			return BroadcastResult.build(400, "调控服务器未启动，暂时无法播放");
		}

		return BroadcastResult.build(400, "调控服务器停播操作失败");
	}
}
