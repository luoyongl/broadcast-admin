package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BInstructionReplyStorage;
import cn.wtu.broadcast.openapi.model.BInstructionReplyStorageExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BInstructionReplyStorageMapper extends DBInterface<BInstructionReplyStorage>{
    int countByExample(BInstructionReplyStorageExample example);

    int deleteByExample(BInstructionReplyStorageExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BInstructionReplyStorage record);

    int insertSelective(BInstructionReplyStorage record);

    List<BInstructionReplyStorage> selectByExample(BInstructionReplyStorageExample example);

    BInstructionReplyStorage selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BInstructionReplyStorage record, @Param("example") BInstructionReplyStorageExample example);

    int updateByExample(@Param("record") BInstructionReplyStorage record, @Param("example") BInstructionReplyStorageExample example);

    int updateByPrimaryKeySelective(BInstructionReplyStorage record);

    int updateByPrimaryKey(BInstructionReplyStorage record);
}