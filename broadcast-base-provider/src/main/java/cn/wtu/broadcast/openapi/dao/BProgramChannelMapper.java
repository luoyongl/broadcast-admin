package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BProgramChannel;
import cn.wtu.broadcast.openapi.model.BProgramChannelExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BProgramChannelMapper extends DBInterface<BProgramChannel>{
    int countByExample(BProgramChannelExample example);

    int deleteByExample(BProgramChannelExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BProgramChannel record);

    int insertSelective(BProgramChannel record);

    List<BProgramChannel> selectByExample(BProgramChannelExample example);

    BProgramChannel selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BProgramChannel record, @Param("example") BProgramChannelExample example);

    int updateByExample(@Param("record") BProgramChannel record, @Param("example") BProgramChannelExample example);

    int updateByPrimaryKeySelective(BProgramChannel record);

    int updateByPrimaryKey(BProgramChannel record);
}