package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BCallandsmsRecord;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BCallandsmsRecordExtMapper extends DBInterface<BCallandsmsRecord>{

	public List<BCallandsmsRecord> selectRCallandsmsRecord(Map<String, Object> paramMap);
}