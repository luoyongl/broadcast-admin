package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BTeletextTerminal;
import cn.wtu.broadcast.openapi.model.BTeletextTerminalExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BTeletextTerminalMapper extends DBInterface<BTeletextTerminal>{
    int countByExample(BTeletextTerminalExample example);

    int deleteByExample(BTeletextTerminalExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BTeletextTerminal record);

    int insertSelective(BTeletextTerminal record);

    List<BTeletextTerminal> selectByExample(BTeletextTerminalExample example);

    BTeletextTerminal selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BTeletextTerminal record, @Param("example") BTeletextTerminalExample example);

    int updateByExample(@Param("record") BTeletextTerminal record, @Param("example") BTeletextTerminalExample example);

    int updateByPrimaryKeySelective(BTeletextTerminal record);

    int updateByPrimaryKey(BTeletextTerminal record);
}