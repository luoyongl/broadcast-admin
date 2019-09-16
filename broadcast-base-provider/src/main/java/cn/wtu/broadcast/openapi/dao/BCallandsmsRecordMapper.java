package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BCallandsmsRecord;
import cn.wtu.broadcast.openapi.model.BCallandsmsRecordExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BCallandsmsRecordMapper extends DBInterface<BCallandsmsRecord> {
    int countByExample(BCallandsmsRecordExample example);

    int deleteByExample(BCallandsmsRecordExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BCallandsmsRecord record);

    int insertSelective(BCallandsmsRecord record);

    List<BCallandsmsRecord> selectByExample(BCallandsmsRecordExample example);

    BCallandsmsRecord selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BCallandsmsRecord record, @Param("example") BCallandsmsRecordExample example);

    int updateByExample(@Param("record") BCallandsmsRecord record, @Param("example") BCallandsmsRecordExample example);

    int updateByPrimaryKeySelective(BCallandsmsRecord record);

    int updateByPrimaryKey(BCallandsmsRecord record);
}