package cn.wtu.broadcast.openapi.dao.extend;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BBroadcastData;
import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.openapi.vo.BroadcastingVO;
import cn.wtu.broadcast.openapi.vo.ConnectLineVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.vo.AudioVO;
import cn.wtu.broadcast.parent.vo.IpVO;

public interface BBroadcastDataExtMapper extends DBInterface<BBroadcastData> {

    /**
     * @param paramMap paramMap ：
     *                 参数 pageNumber页码
     *                 pageSize 查多少条
     *                 fBroadcastType 广播类型
     *                 searchText 模糊查询内容
     *                 sortName 排序字段
     *                 sortOrder 排序方式
     * @return
     * @author LY
     */
    List<BroadCastDataVO> queryPageByBroadcastType(Map<String, Object> paramMap);
    
    /**
     * 查询统计模块(复杂查询)
     * 
     * @return
     * @author yinjie
     */
    List<BroadCastDataVO> queryPageByBroadcastStatistics(Map<String, Object> paramMap);

    /**
     * 特殊情况 查询设备广播
     * @param paramMap 同上
     * @return
     */
    List<BroadCastDataVO> queryDeviceBroadcast(Map<String, Object> paramMap);

    /**
     * lxg-20190110 代码优化
     *
     * @param paramMap
     * @return
     */
    List<BroadCastDataVO> queryPageByBroadcastType22(Map<String, Object> paramMap);

    PageInfo<BroadCastDataVO> selectBoradcastForDaily(Integer b);

    BroadCastDataVO selectBroadCastByFid(Integer fId);

    //lxg  根据广播类型分页查询
    List<BBroadcastData> getListByBroadcastType(Map<String, Object> paramMap);


    List<BroadCastDataVO> selectBroadCastAdvance(Map<String, Object> paramMap);

    /**
     * @return
     * @Desc 查询待播发的广播信息
     * @Date 2019-01-04
     * @Author Li LinFeng
     */
    List<BroadCastDataVO> querywaitingBroadCast(Map<String, Object> paramMap);

    List<BroadCastDataVO> queryPageByBroadcastState(int fState);

	void setStateByFid(Integer fId,Integer state);

    int selectBroadcastTypeNum(int type);

    int sumBroDeviceNumByMessageLevel(int message_level);

    int sumResponceBroDeviceNumByMessageLevel(int message_level);

    int sumTotalAnswerTimeByMessageLevel(int message_level);

    double calculateCoverageByBroId(int broId);

    int sumBroNumBySendTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<BroadcastingVO> selectBroadcastingInfo(Map<String, Object> paramMap);
    
    String queryBroadcastDeviceResoucecode(Integer fId);
    
    //查询正在播发的地图连线信息
    List<ConnectLineVO> selectConnectInfo();

	IpVO queryIpvoData(Integer fId);
	
	AudioVO queryIpAudio(Integer fId);


}
