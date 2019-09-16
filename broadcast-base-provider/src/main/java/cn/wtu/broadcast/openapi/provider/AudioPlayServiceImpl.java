package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.AudioPlayService;
import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.api.BBroadcastDeviceService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.api.ThirdBroadcastDataService;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastDevice;
import cn.wtu.broadcast.openapi.thread.SendIPAudioThread;
import cn.wtu.broadcast.openapi.util.Ipdata;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.IpVO;

@Service("audioPlayService")
public class AudioPlayServiceImpl implements AudioPlayService {

	@Autowired
	private TAdministrativeDivisionService tAdministrativeDivisionService;
	@Autowired
	private BBroadcastDeviceService broadcastDeviceService;
	@Autowired
	private ThirdBroadcastDataService thirdBroadcastDataService;
	@Autowired
	private BBroadcastDataService broadcastService;
	
	@Autowired
	private BBroadcastDataExtMapper broadcastDataExtMapper;

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(ThirdBroadcastDataServiceImpl.class);

	/**
	 * @author lxg 根据广播选中的区域查询对应的设备
	 * @param resourceId
	 * @param broadcastfId
	 * @param type
	 */
	@Override
	@Transactional
	public void addDeviceByResourceIds(String resourceId, Integer broadcastfId, Integer type) {
		// 广播ID对应的区域下的所有适配器和音柱
		// 先判断区域是否是 县，是，所有的。
		// 不是，是否包含镇，包含，根据镇的找到村的区域，根据村查询出所有的适配器和音柱；是否包含村,包含村，根据村查询设备
		List<Integer> deviceIds = tAdministrativeDivisionService.getDeviceByrResourceIds(resourceId);
		// 遍历,插入到b_broadcast_device
		if (deviceIds.size() > 0) {
			for (Integer deviceId : deviceIds) {
				BBroadcastDevice broadcastDevice = new BBroadcastDevice();
				broadcastDevice.setfBroadcastId(broadcastfId);
				broadcastDevice.setfDeviceId(deviceId);
				broadcastDevice.setfIsTimingBroadcast(type == BroadcastTypeEnum.timing.getCode() ? true : false);
				broadcastDevice.setfBroadcastSendTime(new Date());
				broadcastDeviceService.insert(broadcastDevice);
			}
		}
	}

	/**
	 * @author lxg 将对应设备插入到设备广播表中
	 * @param resourceId
	 *            设备资源码
	 * @param broadcastfId
	 *            广播id
	 * @param type
	 */
	@Override
	@Transactional
	public void addDeviceResourceIds(String resourceId, Integer broadcastfId, Integer type) {
		// TODO 只添加对应的设备资源码到设备广播表中 每种广播中添加判断是否是设备广播
		String[] deviceIds = resourceId.split(",");
		// 遍历,插入到b_broadcast_device
		if (deviceIds.length > 0) {
			for (String deviceId : deviceIds) {
				BBroadcastDevice broadcastDevice = new BBroadcastDevice();
				broadcastDevice.setfBroadcastId(broadcastfId);
				broadcastDevice.setfDeviceId(Integer.parseInt(deviceId));
				broadcastDevice.setfIsTimingBroadcast(type == BroadcastTypeEnum.timing.getCode() ? true : false);
				broadcastDevice.setfBroadcastSendTime(new Date());
				broadcastDeviceService.insert(broadcastDevice);
			}
		}
	}

	public static int getTxtLen(String str) {
		int len = 0;
		char[] chars = str.toCharArray();
		// boolean isGB2312 = false;
		for (int i = 0; i < chars.length; i++) {
			byte[] bytes = ("" + chars[i]).getBytes();
			if (bytes.length != 1) {
				int[] ints = new int[2];
				ints[0] = bytes[0] & 0xff;
				ints[1] = bytes[1] & 0xff;

				if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40 && ints[1] <= 0xFE) {
					// isGB2312 = true;
					len += 2;
				} else {
					len += 1;
				}
			} else {
				len += 1;
			}
		}
		return len;
	}

	@Override
	public BroadcastResult ipPlayAudio(Integer broadcastType, Integer fId, String broadcastTomcatPath,
			String adapterResourceCode) {
		try {
			IpVO ipvo = thirdBroadcastDataService.getIpModelByBroadcastTypeAndId(broadcastType, fId);
			ipvo.setBroadcastTomcatPath(broadcastTomcatPath);
			String audioName = null;

			if (ipvo.getTextToAudioUrl() != null) {
				audioName = ipvo.getTextToAudioUrl().substring(ipvo.getTextToAudioUrl().lastIndexOf("/") + 1);
			} else {
				audioName = ipvo.getBroadcastAudioUrl().substring(ipvo.getBroadcastAudioUrl().lastIndexOf("/") + 1);
			}
			String audioUrl = broadcastTomcatPath + "/webapps/ROOT/upload/audio/" + audioName;
			ipvo.setBroadcastAudioUrl(audioUrl);
			ipvo.setAdapterResourceCode(adapterResourceCode);
			Ipdata.sendIPControl(ipvo);
			//true 代表单播
			if(!ipvo.getfBroadcastStyle()){
				Thread sendIPThread = new Thread(new SendIPAudioThread(fId, null, ipvo.getIpPlayPort(),broadcastService,broadcastDataExtMapper));
				sendIPThread.start();
			}
			// 线程播放vlc
			/*
			 * File file = new File(audioUrl); if (!file.exists()) {
			 * logger.error("音频url" + audioUrl); return
			 * BroadcastResult.fail("音频文件不存在,播发失败!"); }
			 */

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return BroadcastResult.ok();
	}

}
