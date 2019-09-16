package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.vo.BDeviceInfoVo;
import cn.wtu.broadcast.openapi.vo.ExceptionDeviceExportVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * @date 2019-01-15
 * @author LiLinFeng
 * @description 设备信息service
 */
public interface BDeviceInfoService extends ParentService<BDeviceInfo> {

	/**
	 * @description 查询所有异常设备信息
	 * @param paramMap
	 * @return
	 * @author LiLinFeng
	 */
	PageInfo<BDeviceInfoVo> selectExceptionDeviceInfos(Map<String, Object> paramMap);


	/**
	 * @description 查询所有异常设备信息
	 * @return
	 * @author LiLinFeng
	 */
	List<ExceptionDeviceExportVO> queryExceptionDeviceInfos();
	
	/**
	 * 查询终端状态数量
	 * @param flag
	 * @return
	 */
	Integer selectState(Integer flag);

	/**
	 * 依据类型查询涉笔数量
	 * @param type 设备类型
	 * @return
	 */
	Integer selectDeviceType(Integer type);
	
	/**
	 * 通过设备资源编码更新设备状态
	 * @param deviceSourceCode
	 * @return
	 */
	Boolean updateDeviceStateBySourceCode(String deviceSourceCode, Byte deviceState);
	
	/**
	 * 启动回传服务器后自动将所有设备更新为离线状态，后面有回传的再将具体状态更新即可
	 * @return
	 */
	void updateAllDeceiveState();
	
	/**
	 * 回传时候获取到对应的设备以及广播信息
	 */
	Map<String, Object> getBDeviceInfoForReceive(Map<String, Object> paramMap);

	/**
	 * 查询所有设备信息
	 */
	List<BDeviceInfo> listAll();
	
	/**
	 * 查询出所有 正在广播和在线的设备(0,1)  
	 * 用于省平台测试时的设备展示  
	 *  2019-04-10  lxg
	 */
	public List<Integer> getAllDevices();
	
	BDeviceInfo getDeviceBySourceCode(String deviceSourceCode);
}
