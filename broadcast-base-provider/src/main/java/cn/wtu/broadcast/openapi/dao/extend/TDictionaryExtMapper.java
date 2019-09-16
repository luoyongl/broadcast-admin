package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface TDictionaryExtMapper extends DBInterface<TDictionary> {
	
	List<TDictionary> selectPidList(Map<String, Object> param);

	void updateModulation(String content, String type);

	String getThirdCodeById(Integer fId);

	List<Integer> selectAdapterOrSoundDeviceIds(String type);
	
}