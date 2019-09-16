package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.BBroadcastDeviceService;
import cn.wtu.broadcast.openapi.dao.BBroadcastDeviceMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastDevice;
import cn.wtu.broadcast.openapi.model.BBroadcastDeviceExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

@Transactional
@Service("bBroadcastDeviceService")
public class BBroadcastDeviceServiceImpl extends ParentServiceImpl<BBroadcastDevice> implements BBroadcastDeviceService {
	
	private final BBroadcastDeviceMapper broadcastDeviceMapper;
	 
	public BBroadcastDeviceServiceImpl(BBroadcastDeviceMapper broadcastDeviceMapper) {
		this.broadcastDeviceMapper = broadcastDeviceMapper;
	}

	protected DBInterface<BBroadcastDevice> getDao() {
		return broadcastDeviceMapper;
	}

	@Override
	public void updateReceiveInfoToTbl(Integer fDeviceId, Integer fBroadcastId, Boolean fIsTimingBroadcast) {
		BBroadcastDeviceExample example = new BBroadcastDeviceExample();
		example.createCriteria().andFBroadcastIdEqualTo(fBroadcastId).andFDeviceIdEqualTo(fDeviceId).andFIsTimingBroadcastEqualTo(fIsTimingBroadcast);
		List<BBroadcastDevice> list = broadcastDeviceMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			Date fDeviceAnswerTime = new Date();
			for (BBroadcastDevice bBroadcastDevice : list) {
				Date fBroadcastSendTim = bBroadcastDevice.getfBroadcastSendTime();
				long diff = fDeviceAnswerTime.getTime() - fBroadcastSendTim.getTime();
				// 如果响应时间大于10秒减去一个心跳时间
				if(diff > 10000){
					diff = diff - 5000;
				}
				bBroadcastDevice.setfDeviceAnswerTime(fDeviceAnswerTime);
				bBroadcastDevice.setfAnswerTimeNum(Integer.valueOf(String.valueOf(diff)));
				broadcastDeviceMapper.updateByPrimaryKey(bBroadcastDevice);
			}
		}
	}
}
