package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BUpdateFile;
import cn.wtu.broadcast.openapi.model.BUpdateFileExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BUpdateFileMapper extends DBInterface<BUpdateFile>{
    int countByExample(BUpdateFileExample example);

    int deleteByExample(BUpdateFileExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BUpdateFile record);

    int insertSelective(BUpdateFile record);

    List<BUpdateFile> selectByExample(BUpdateFileExample example);

    BUpdateFile selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BUpdateFile record, @Param("example") BUpdateFileExample example);

    int updateByExample(@Param("record") BUpdateFile record, @Param("example") BUpdateFileExample example);

    int updateByPrimaryKeySelective(BUpdateFile record);

    int updateByPrimaryKey(BUpdateFile record);
}