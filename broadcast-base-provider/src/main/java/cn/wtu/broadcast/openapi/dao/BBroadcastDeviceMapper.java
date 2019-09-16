package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BBroadcastDevice;
import cn.wtu.broadcast.openapi.model.BBroadcastDeviceExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BBroadcastDeviceMapper extends DBInterface<BBroadcastDevice>{
    int countByExample(BBroadcastDeviceExample example);

    int deleteByExample(BBroadcastDeviceExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BBroadcastDevice record);

    int insertSelective(BBroadcastDevice record);

    List<BBroadcastDevice> selectByExample(BBroadcastDeviceExample example);

    BBroadcastDevice selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BBroadcastDevice record, @Param("example") BBroadcastDeviceExample example);

    int updateByExample(@Param("record") BBroadcastDevice record, @Param("example") BBroadcastDeviceExample example);

    int updateByPrimaryKeySelective(BBroadcastDevice record);

    int updateByPrimaryKey(BBroadcastDevice record);
}