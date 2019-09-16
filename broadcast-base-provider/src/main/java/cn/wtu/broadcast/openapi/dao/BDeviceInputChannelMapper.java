package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceInputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceInputChannelExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BDeviceInputChannelMapper extends DBInterface<BDeviceInputChannel>{
    int countByExample(BDeviceInputChannelExample example);

    int deleteByExample(BDeviceInputChannelExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceInputChannel record);

    int insertSelective(BDeviceInputChannel record);

    List<BDeviceInputChannel> selectByExample(BDeviceInputChannelExample example);

    BDeviceInputChannel selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceInputChannel record, @Param("example") BDeviceInputChannelExample example);

    int updateByExample(@Param("record") BDeviceInputChannel record, @Param("example") BDeviceInputChannelExample example);

    int updateByPrimaryKeySelective(BDeviceInputChannel record);

    int updateByPrimaryKey(BDeviceInputChannel record);
}