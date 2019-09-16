package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import cn.wtu.broadcast.openapi.model.BBroadcastTimingExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BBroadcastTimingMapper extends DBInterface<BBroadcastTiming>{
    int countByExample(BBroadcastTimingExample example);

    int deleteByExample(BBroadcastTimingExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BBroadcastTiming record);

    int insertSelective(BBroadcastTiming record);

    List<BBroadcastTiming> selectByExample(BBroadcastTimingExample example);

    BBroadcastTiming selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BBroadcastTiming record, @Param("example") BBroadcastTimingExample example);

    int updateByExample(@Param("record") BBroadcastTiming record, @Param("example") BBroadcastTimingExample example);

    int updateByPrimaryKeySelective(BBroadcastTiming record);

    int updateByPrimaryKey(BBroadcastTiming record);
}