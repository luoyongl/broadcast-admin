package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BInstructionSendreplyStorage;
import cn.wtu.broadcast.openapi.model.BInstructionSendreplyStorageExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BInstructionSendreplyStorageMapper extends DBInterface<BInstructionSendreplyStorage>{
    int countByExample(BInstructionSendreplyStorageExample example);

    int deleteByExample(BInstructionSendreplyStorageExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BInstructionSendreplyStorage record);

    int insertSelective(BInstructionSendreplyStorage record);

    List<BInstructionSendreplyStorage> selectByExample(BInstructionSendreplyStorageExample example);

    BInstructionSendreplyStorage selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BInstructionSendreplyStorage record, @Param("example") BInstructionSendreplyStorageExample example);

    int updateByExample(@Param("record") BInstructionSendreplyStorage record, @Param("example") BInstructionSendreplyStorageExample example);

    int updateByPrimaryKeySelective(BInstructionSendreplyStorage record);

    int updateByPrimaryKey(BInstructionSendreplyStorage record);
}