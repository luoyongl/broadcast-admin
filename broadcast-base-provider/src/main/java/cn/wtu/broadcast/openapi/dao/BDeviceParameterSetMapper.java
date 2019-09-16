package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSetExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BDeviceParameterSetMapper extends DBInterface<BDeviceParameterSet>{
    int countByExample(BDeviceParameterSetExample example);

    int deleteByExample(BDeviceParameterSetExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceParameterSet record);

    int insertSelective(BDeviceParameterSet record);

    List<BDeviceParameterSet> selectByExample(BDeviceParameterSetExample example);

    BDeviceParameterSet selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceParameterSet record, @Param("example") BDeviceParameterSetExample example);

    int updateByExample(@Param("record") BDeviceParameterSet record, @Param("example") BDeviceParameterSetExample example);

    int updateByPrimaryKeySelective(BDeviceParameterSet record);

    int updateByPrimaryKey(BDeviceParameterSet record);
}