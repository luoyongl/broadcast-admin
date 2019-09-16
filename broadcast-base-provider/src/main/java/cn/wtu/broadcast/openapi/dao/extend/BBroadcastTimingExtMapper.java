package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import cn.wtu.broadcast.openapi.vo.BroadcastTimingVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BBroadcastTimingExtMapper extends DBInterface<BBroadcastTiming>{

	List<BroadcastTimingVO> selectBoradcastAll(Map<String, Object> paramMap);

	void setStateByFid(Integer state, Integer fId);
}
