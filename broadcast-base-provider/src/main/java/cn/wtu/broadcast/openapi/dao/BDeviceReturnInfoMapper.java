package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceReturnInfo;
import cn.wtu.broadcast.openapi.model.BDeviceReturnInfoExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BDeviceReturnInfoMapper extends DBInterface<BDeviceReturnInfo>{
    int countByExample(BDeviceReturnInfoExample example);

    int deleteByExample(BDeviceReturnInfoExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceReturnInfo record);

    int insertSelective(BDeviceReturnInfo record);

    List<BDeviceReturnInfo> selectByExample(BDeviceReturnInfoExample example);

    BDeviceReturnInfo selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceReturnInfo record, @Param("example") BDeviceReturnInfoExample example);

    int updateByExample(@Param("record") BDeviceReturnInfo record, @Param("example") BDeviceReturnInfoExample example);

    int updateByPrimaryKeySelective(BDeviceReturnInfo record);

    int updateByPrimaryKey(BDeviceReturnInfo record);
}