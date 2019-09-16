package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BWhitelist;
import cn.wtu.broadcast.openapi.model.BWhitelistExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BWhitelistMapper extends DBInterface<BWhitelist>{
    int countByExample(BWhitelistExample example);

    int deleteByExample(BWhitelistExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BWhitelist record);

    int insertSelective(BWhitelist record);

    List<BWhitelist> selectByExample(BWhitelistExample example);

    BWhitelist selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BWhitelist record, @Param("example") BWhitelistExample example);

    int updateByExample(@Param("record") BWhitelist record, @Param("example") BWhitelistExample example);

    int updateByPrimaryKeySelective(BWhitelist record);

    int updateByPrimaryKey(BWhitelist record);
}