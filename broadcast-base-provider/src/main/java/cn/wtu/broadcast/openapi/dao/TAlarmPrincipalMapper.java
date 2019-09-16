package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.TAlarmPrincipal;
import cn.wtu.broadcast.openapi.model.TAlarmPrincipalExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface TAlarmPrincipalMapper extends DBInterface<TAlarmPrincipal>{
    int countByExample(TAlarmPrincipalExample example);

    int deleteByExample(TAlarmPrincipalExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TAlarmPrincipal record);

    int insertSelective(TAlarmPrincipal record);

    List<TAlarmPrincipal> selectByExample(TAlarmPrincipalExample example);

    TAlarmPrincipal selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TAlarmPrincipal record, @Param("example") TAlarmPrincipalExample example);

    int updateByExample(@Param("record") TAlarmPrincipal record, @Param("example") TAlarmPrincipalExample example);

    int updateByPrimaryKeySelective(TAlarmPrincipal record);

    int updateByPrimaryKey(TAlarmPrincipal record);
}