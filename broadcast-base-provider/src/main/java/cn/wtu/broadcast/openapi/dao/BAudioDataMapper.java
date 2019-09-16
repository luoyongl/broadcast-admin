package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.openapi.model.BAudioDataExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BAudioDataMapper extends DBInterface<BAudioData>{
    int countByExample(BAudioDataExample example);

    int deleteByExample(BAudioDataExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BAudioData record);

    int insertSelective(BAudioData record);

    List<BAudioData> selectByExample(BAudioDataExample example);

    BAudioData selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BAudioData record, @Param("example") BAudioDataExample example);

    int updateByExample(@Param("record") BAudioData record, @Param("example") BAudioDataExample example);

    int updateByPrimaryKeySelective(BAudioData record);

    int updateByPrimaryKey(BAudioData record);
}