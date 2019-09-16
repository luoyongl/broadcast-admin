package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BCertificates;
import cn.wtu.broadcast.openapi.model.BCertificatesExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BCertificatesMapper extends DBInterface<BCertificates>{
    int countByExample(BCertificatesExample example);

    int deleteByExample(BCertificatesExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BCertificates record);

    int insertSelective(BCertificates record);

    List<BCertificates> selectByExample(BCertificatesExample example);

    BCertificates selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BCertificates record, @Param("example") BCertificatesExample example);

    int updateByExample(@Param("record") BCertificates record, @Param("example") BCertificatesExample example);

    int updateByPrimaryKeySelective(BCertificates record);

    int updateByPrimaryKey(BCertificates record);
}