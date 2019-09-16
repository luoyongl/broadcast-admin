package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TDictionaryExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface TDictionaryMapper extends DBInterface<TDictionary>{
    int countByExample(TDictionaryExample example);

    int deleteByExample(TDictionaryExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TDictionary record);

    int insertSelective(TDictionary record);

    List<TDictionary> selectByExample(TDictionaryExample example);

    TDictionary selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TDictionary record, @Param("example") TDictionaryExample example);

    int updateByExample(@Param("record") TDictionary record, @Param("example") TDictionaryExample example);

    int updateByPrimaryKeySelective(TDictionary record);

    int updateByPrimaryKey(TDictionary record);
}