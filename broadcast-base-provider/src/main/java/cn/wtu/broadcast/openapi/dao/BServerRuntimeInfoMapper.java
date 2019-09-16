package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BServerRuntimeInfo;
import cn.wtu.broadcast.openapi.model.BServerRuntimeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BServerRuntimeInfoMapper {
    int countByExample(BServerRuntimeInfoExample example);

    int deleteByExample(BServerRuntimeInfoExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BServerRuntimeInfo record);

    int insertSelective(BServerRuntimeInfo record);

    List<BServerRuntimeInfo> selectByExample(BServerRuntimeInfoExample example);

    BServerRuntimeInfo selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BServerRuntimeInfo record, @Param("example") BServerRuntimeInfoExample example);

    int updateByExample(@Param("record") BServerRuntimeInfo record, @Param("example") BServerRuntimeInfoExample example);

    int updateByPrimaryKeySelective(BServerRuntimeInfo record);

    int updateByPrimaryKey(BServerRuntimeInfo record);
}