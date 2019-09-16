package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.openapi.model.TManufacturerExample;
import java.util.List;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface TManufacturerMapper extends DBInterface<TManufacturer> {
    int countByExample(TManufacturerExample example);

    int deleteByExample(TManufacturerExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TManufacturer record);

    int insertSelective(TManufacturer record);

    List<TManufacturer> selectByExample(TManufacturerExample example);

    TManufacturer selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TManufacturer record, @Param("example") TManufacturerExample example);

    int updateByExample(@Param("record") TManufacturer record, @Param("example") TManufacturerExample example);

    int updateByPrimaryKeySelective(TManufacturer record);

    int updateByPrimaryKey(TManufacturer record);
}