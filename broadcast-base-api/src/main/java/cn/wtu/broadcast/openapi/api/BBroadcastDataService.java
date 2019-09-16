package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BBroadcastData;
import cn.wtu.broadcast.openapi.vo.BBroadcastTempVO;
import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.parent.service.api.ParentService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 广播数据表service接口
 *
 * @author lxg
 * @date 2018/12/18
 */
public interface BBroadcastDataService extends ParentService<BBroadcastData> {
	/**
	 * 根据广播类型和广播ID给广播设置状态  Lxg 2019-02-22
	 * @param broadcastType
	 * @param fId
	 * @param state
	 */
	public void setStateByTypeAndFid(Integer broadcastType,Integer fId,Integer state);
	
	/**ip
	 * 根据广播ID给广播设置状态  Lxg 2019-02-22
	 * @param fId
	 * @param state
	 */
	public void setStateByFid(Integer fId,Integer state);

	/**
	 * 开播,此方法已经作废，请使用考虑到角色权限的addBroadCastThinkUserRole()方法
	 * @param bBroadcastData
	 * @return 
	 * @author LiLinFeng
	 * @Date 2019-01-14
	 */
	public Boolean addBroadCast(BBroadcastData bBroadcastData);
	
	/**
	 * 开播，addBroadCastThinkUserRole()方法
	 * @param bBroadcastData
	 * @return 
	 * @author LiLinFeng
	 * @Date 2019-01-14
	 */
	public Boolean addBroadCastThinkUserRole(BBroadcastData bBroadcastData, Byte state);

	/**
	 * 
	 * @param paramMap
	 * paramMap ：
	 * 参数 pageNumber 页码
	 * pageSize 查多少条
	 * fBroadcastType 广播类型
	 * searchText 模糊查询内容
	 * sortName 排序字段
	 * sortOrder 排序方式
	 * @author LY
	 * @return 
	 */
	public PageInfo<BroadCastDataVO> queryPageByBroadcastType(Map<String, Object> paramMap);
	
	/**
	 * 多条件进行查询
	 * @author yinjie
	 * datetime 2019/7/1
	 */
	public PageInfo<BroadCastDataVO> queryPageByBroadcastStatistics(Map<String, Object> paramMap);

	public BroadCastDataVO selectBroadCastById(Integer id);

	
	boolean updateBroadcastState(BBroadcastData broadCastData);
	
	/**
	 * 取消广播操作
	 * @param fId
	 * @return
	 */
	public int  deleteBroadast(String fId);
	
	/**
	 * @Desc 查询正在播出的广播信息
	 * @Date 2019-01-04
	 * @Author Li LinFeng
	 * @return
	 */
	public List<BroadCastDataVO> selectBeingBroadCast(int state);

	/**
	 * @Desc 查询待播发的广播信息
	 * @Date 2019-01-04
	 * @Author Li LinFeng
	 * @return
	 */
	public PageInfo<BBroadcastTempVO> selectwaitingBroadCast(Map<String, Object> paramMap, int code);

	/**
	 * 根据广播级别查询对应数量
	 * @param rank
	 * @return 对应登记广播数量
	 */
	Integer selectBroadByType(Integer rank);

	/**
	 * 获取某一时间前广播数量
	 * @return
	 */
	Map<String,Integer> countBytime();


	/**
	 * 查询设备广播
	 * @param paramMap
	 * @return
	 */
	public PageInfo<BroadCastDataVO> queryDeviceBroadcast(Map<String, Object> paramMap);
	

	/**
	 * 根据适配器的设备id查询资源码
	 * @param adapterId 适配器id
	 * @return
	 */
	public String queryAdapterCode(Integer adapterId);

}
