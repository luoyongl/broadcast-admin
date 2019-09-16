package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.openapi.model.TSystemConfigurationExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSystemConfigurationMapper extends DBInterface<TSystemConfiguration> {

    int countByExample(TSystemConfigurationExample example);

    int deleteByExample(TSystemConfigurationExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TSystemConfiguration record);

    int insertSelective(TSystemConfiguration record);

    List<TSystemConfiguration> selectByExample(TSystemConfigurationExample example);

    TSystemConfiguration selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TSystemConfiguration record, @Param("example") TSystemConfigurationExample example);

    int updateByExample(@Param("record") TSystemConfiguration record, @Param("example") TSystemConfigurationExample example);

    int updateByPrimaryKeySelective(TSystemConfiguration record);

    int updateByPrimaryKey(TSystemConfiguration record);
}