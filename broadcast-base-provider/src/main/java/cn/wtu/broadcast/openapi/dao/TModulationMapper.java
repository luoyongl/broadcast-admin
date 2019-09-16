package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.TModulation;
import cn.wtu.broadcast.openapi.model.TModulationExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface TModulationMapper extends DBInterface<TModulation>{
    int countByExample(TModulationExample example);

    int deleteByExample(TModulationExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TModulation record);

    int insertSelective(TModulation record);

    List<TModulation> selectByExample(TModulationExample example);

    TModulation selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TModulation record, @Param("example") TModulationExample example);

    int updateByExample(@Param("record") TModulation record, @Param("example") TModulationExample example);

    int updateByPrimaryKeySelective(TModulation record);

    int updateByPrimaryKey(TModulation record);
}