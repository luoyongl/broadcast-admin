package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.vo.TerminalStatusVO;
import cn.wtu.broadcast.parent.service.api.ParentService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author: NewLinfeng
 * @Description:
 * @Date: Created in 14:41 on 2019/1/17.
 * @Modified_by:
 */
public interface TerminalStatusService extends ParentService<BDeviceInfo> {

    /**
     * @Description 查询终端播放状态的信息(实时状态和播放记录)
     * @Author: NewLinfeng
     * @Date: Created in 14:57 on 2019/1/17.
     * @param paramMap
     * @return
     */
    public PageInfo<TerminalStatusVO> queryPageByTeminalStatusType(Map<String, Object> paramMap);

    /**
     * @Description 查询终端播放状态的信息,按照时间段查
     * @Author: NewLinfeng
     * @Date: Created in 14:57 on 2019/1/23.
     * @param paramMap
     * @return
     */
    public PageInfo<TerminalStatusVO> queryPageByTerminalRecordListForTime(Map<String, Object> paramMap);

}
