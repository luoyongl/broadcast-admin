package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.TRoleAndResourceLink;
import cn.wtu.broadcast.openapi.model.TRoleAndResourceLinkExample;

public interface TRoleAndResourceLinkMapper {
    int countByExample(TRoleAndResourceLinkExample example);

    int deleteByExample(TRoleAndResourceLinkExample example);

    int deleteByPrimaryKey(Integer fRoleResourcesId);

    int insert(TRoleAndResourceLink record);

    int insertSelective(TRoleAndResourceLink record);

    List<TRoleAndResourceLink> selectByExample(TRoleAndResourceLinkExample example);

    TRoleAndResourceLink selectByPrimaryKey(Integer fRoleResourcesId);

    int updateByExampleSelective(@Param("record") TRoleAndResourceLink record, @Param("example") TRoleAndResourceLinkExample example);

    int updateByExample(@Param("record") TRoleAndResourceLink record, @Param("example") TRoleAndResourceLinkExample example);

    int updateByPrimaryKeySelective(TRoleAndResourceLink record);

    int updateByPrimaryKey(TRoleAndResourceLink record);
}