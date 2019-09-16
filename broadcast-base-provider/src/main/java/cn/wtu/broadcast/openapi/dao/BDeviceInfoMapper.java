package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInfoExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BDeviceInfoMapper extends DBInterface<BDeviceInfo> {
    int countByExample(BDeviceInfoExample example);

    int deleteByExample(BDeviceInfoExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceInfo record);

    int insertSelective(BDeviceInfo record);

    List<BDeviceInfo> selectByExample(BDeviceInfoExample example);

    BDeviceInfo selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceInfo record, @Param("example") BDeviceInfoExample example);

    int updateByExample(@Param("record") BDeviceInfo record, @Param("example") BDeviceInfoExample example);

    int updateByPrimaryKeySelective(BDeviceInfo record);

    int updateByPrimaryKey(BDeviceInfo record);
}