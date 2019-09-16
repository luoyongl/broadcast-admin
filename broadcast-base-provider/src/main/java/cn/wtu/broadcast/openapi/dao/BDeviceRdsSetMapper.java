package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceRdsSet;
import cn.wtu.broadcast.openapi.model.BDeviceRdsSetExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BDeviceRdsSetMapper extends DBInterface<BDeviceRdsSet>{
    int countByExample(BDeviceRdsSetExample example);

    int deleteByExample(BDeviceRdsSetExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceRdsSet record);

    int insertSelective(BDeviceRdsSet record);

    List<BDeviceRdsSet> selectByExample(BDeviceRdsSetExample example);

    BDeviceRdsSet selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceRdsSet record, @Param("example") BDeviceRdsSetExample example);

    int updateByExample(@Param("record") BDeviceRdsSet record, @Param("example") BDeviceRdsSetExample example);

    int updateByPrimaryKeySelective(BDeviceRdsSet record);

    int updateByPrimaryKey(BDeviceRdsSet record);
}