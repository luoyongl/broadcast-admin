package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.parent.vo.IpVO;

public interface ThirdBroadcastDataService {
	IpVO getIpModelByBroadcastTypeAndId(Integer broadcastType,Integer fId);
}
