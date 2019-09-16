package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceTerminalStatusQuery;
import cn.wtu.broadcast.openapi.model.BDeviceTerminalStatusQueryExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BDeviceTerminalStatusQueryMapper extends DBInterface<BDeviceTerminalStatusQuery>{
    int countByExample(BDeviceTerminalStatusQueryExample example);

    int deleteByExample(BDeviceTerminalStatusQueryExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceTerminalStatusQuery record);

    int insertSelective(BDeviceTerminalStatusQuery record);

    List<BDeviceTerminalStatusQuery> selectByExample(BDeviceTerminalStatusQueryExample example);

    BDeviceTerminalStatusQuery selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceTerminalStatusQuery record, @Param("example") BDeviceTerminalStatusQueryExample example);

    int updateByExample(@Param("record") BDeviceTerminalStatusQuery record, @Param("example") BDeviceTerminalStatusQueryExample example);

    int updateByPrimaryKeySelective(BDeviceTerminalStatusQuery record);

    int updateByPrimaryKey(BDeviceTerminalStatusQuery record);
}