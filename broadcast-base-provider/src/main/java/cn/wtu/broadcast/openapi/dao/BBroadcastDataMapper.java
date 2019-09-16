package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BBroadcastData;
import cn.wtu.broadcast.openapi.model.BBroadcastDataExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BBroadcastDataMapper extends DBInterface<BBroadcastData> {
	int countByExample(BBroadcastDataExample example);

	int deleteByExample(BBroadcastDataExample example);

	int deleteByPrimaryKey(Integer fId);

	int insert(BBroadcastData record);

	int insertSelective(BBroadcastData record);

	List<BBroadcastData> selectByExample(BBroadcastDataExample example);

	BBroadcastData selectByPrimaryKey(Integer fId);

	int updateByExampleSelective(@Param("record") BBroadcastData record,
			@Param("example") BBroadcastDataExample example);

	int updateByExample(@Param("record") BBroadcastData record, @Param("example") BBroadcastDataExample example);

	int updateByPrimaryKeySelective(BBroadcastData record);

	int updateByPrimaryKey(BBroadcastData record);
}