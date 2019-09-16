package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TOperationLog;
import cn.wtu.broadcast.openapi.model.TOperationLogExample;
import java.util.List;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface TOperationLogMapper extends DBInterface<TOperationLog> {
    int countByExample(TOperationLogExample example);

    int deleteByExample(TOperationLogExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TOperationLog record);

    int insertSelective(TOperationLog record);

    List<TOperationLog> selectByExample(TOperationLogExample example);

    TOperationLog selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TOperationLog record, @Param("example") TOperationLogExample example);

    int updateByExample(@Param("record") TOperationLog record, @Param("example") TOperationLogExample example);

    int updateByPrimaryKeySelective(TOperationLog record);

    int updateByPrimaryKey(TOperationLog record);
}