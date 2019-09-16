package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceOutputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceOutputChannelExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BDeviceOutputChannelMapper extends DBInterface<BDeviceOutputChannel>{
    int countByExample(BDeviceOutputChannelExample example);

    int deleteByExample(BDeviceOutputChannelExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceOutputChannel record);

    int insertSelective(BDeviceOutputChannel record);

    List<BDeviceOutputChannel> selectByExample(BDeviceOutputChannelExample example);

    BDeviceOutputChannel selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceOutputChannel record, @Param("example") BDeviceOutputChannelExample example);

    int updateByExample(@Param("record") BDeviceOutputChannel record, @Param("example") BDeviceOutputChannelExample example);

    int updateByPrimaryKeySelective(BDeviceOutputChannel record);

    int updateByPrimaryKey(BDeviceOutputChannel record);
}