package cn.wtu.broadcast.openapi.dao.extend;

import cn.wtu.broadcast.openapi.vo.TerminalStatusVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * @Author: NewLinfeng
 * @Description:
 * @Date: Created in 15:36 on 2019/1/17.
 * @Modified_by:
 */
public interface TerminalStatusExtMapper extends DBInterface<TerminalStatusVO> {

   /* List<TerminalStatusVO> queryPageByTeminalStatusType(Map<String, Object> paramMap);
    
    
    List<TerminalStatusVO> queryPageByTeminalRecordType(Map<String, Object> paramMap);

    *//**
     * @description 查询设备通道的协议类型
     * @param fBroadcastTo1
     * @return
     * @Author
     *//*
    String selectProtocolType(String fBroadcastTo1);

    List<TerminalStatusVO> queryPageByTerminalRecordListForTime(Map<String, Object> paramMap);

    List<TerminalStatusVO> queryState(Map<String, Object> paramMap);*/
}
