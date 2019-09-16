package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TRoleAndUserAssociation;
import cn.wtu.broadcast.openapi.model.TRoleAndUserAssociationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleAndUserAssociationMapper {
    int countByExample(TRoleAndUserAssociationExample example);

    int deleteByExample(TRoleAndUserAssociationExample example);

    int deleteByPrimaryKey(Integer fRoleAndUserId);

    int insert(TRoleAndUserAssociation record);

    int insertSelective(TRoleAndUserAssociation record);

    List<TRoleAndUserAssociation> selectByExample(TRoleAndUserAssociationExample example);

    TRoleAndUserAssociation selectByPrimaryKey(Integer fRoleAndUserId);

    int updateByExampleSelective(@Param("record") TRoleAndUserAssociation record, @Param("example") TRoleAndUserAssociationExample example);

    int updateByExample(@Param("record") TRoleAndUserAssociation record, @Param("example") TRoleAndUserAssociationExample example);

    int updateByPrimaryKeySelective(TRoleAndUserAssociation record);

    int updateByPrimaryKey(TRoleAndUserAssociation record);
}