package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BSystemInfoRecord;
import cn.wtu.broadcast.openapi.model.BSystemInfoRecordExample;
import java.util.List;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BSystemInfoRecordMapper extends DBInterface<BSystemInfoRecord> {
    int countByExample(BSystemInfoRecordExample example);

    int deleteByExample(BSystemInfoRecordExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BSystemInfoRecord record);

    int insertSelective(BSystemInfoRecord record);

    List<BSystemInfoRecord> selectByExample(BSystemInfoRecordExample example);

    BSystemInfoRecord selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BSystemInfoRecord record, @Param("example") BSystemInfoRecordExample example);

    int updateByExample(@Param("record") BSystemInfoRecord record, @Param("example") BSystemInfoRecordExample example);

    int updateByPrimaryKeySelective(BSystemInfoRecord record);

    int updateByPrimaryKey(BSystemInfoRecord record);
}