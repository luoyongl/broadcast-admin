package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivisionExample;
import java.util.List;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface TAdministrativeDivisionMapper extends DBInterface<TAdministrativeDivision> {
    int countByExample(TAdministrativeDivisionExample example);

    int deleteByExample(TAdministrativeDivisionExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TAdministrativeDivision record);

    int insertSelective(TAdministrativeDivision record);

    List<TAdministrativeDivision> selectByExample(TAdministrativeDivisionExample example);

    TAdministrativeDivision selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TAdministrativeDivision record, @Param("example") TAdministrativeDivisionExample example);

    int updateByExample(@Param("record") TAdministrativeDivision record, @Param("example") TAdministrativeDivisionExample example);

    int updateByPrimaryKeySelective(TAdministrativeDivision record);

    int updateByPrimaryKey(TAdministrativeDivision record);
}