package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TRole;
import cn.wtu.broadcast.openapi.model.TRoleExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRoleMapper extends DBInterface<TRole> {

    int countByExample(TRoleExample example);

    int deleteByExample(TRoleExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}