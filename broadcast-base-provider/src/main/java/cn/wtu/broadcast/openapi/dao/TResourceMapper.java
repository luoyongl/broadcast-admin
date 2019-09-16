package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TResource;
import cn.wtu.broadcast.openapi.model.TResourceExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResourceMapper extends DBInterface<TResource> {

    int countByExample(TResourceExample example);

    int deleteByExample(TResourceExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TResource record);

    int insertSelective(TResource record);

    List<TResource> selectByExample(TResourceExample example);

    TResource selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByExample(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByPrimaryKeySelective(TResource record);

    int updateByPrimaryKey(TResource record);
}