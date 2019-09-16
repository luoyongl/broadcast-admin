package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BAlarmRecord;
import cn.wtu.broadcast.openapi.model.BAlarmRecordExample;
import java.util.List;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BAlarmRecordMapper extends DBInterface<BAlarmRecord> {
    int countByExample(BAlarmRecordExample example);

    int deleteByExample(BAlarmRecordExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BAlarmRecord record);

    int insertSelective(BAlarmRecord record);

    List<BAlarmRecord> selectByExample(BAlarmRecordExample example);

    BAlarmRecord selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BAlarmRecord record, @Param("example") BAlarmRecordExample example);

    int updateByExample(@Param("record") BAlarmRecord record, @Param("example") BAlarmRecordExample example);

    int updateByPrimaryKeySelective(BAlarmRecord record);

    int updateByPrimaryKey(BAlarmRecord record);
}