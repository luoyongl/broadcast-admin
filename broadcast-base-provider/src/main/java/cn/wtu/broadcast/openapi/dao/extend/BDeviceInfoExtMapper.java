package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.vo.BDeviceInfoVo;
import cn.wtu.broadcast.openapi.vo.ExceptionDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.FrontDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.TerminalDeviceExportVO;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-02 11:55
 */
public interface BDeviceInfoExtMapper {

    List<BDeviceInfo> selectDeviceList(Map<String, Object> paramMap);
    List<BDeviceInfoVo> selectDeviceforhandle(Map<String, Object> paramMap);
    List<BDeviceInfoVo> selectfrontAndTerminalDeviceList(Map<String, Object> paramMap);
    List<FrontDeviceExportVO> exportFrontDeviceInfo();
    List<TerminalDeviceExportVO> exportTerminalDeviceInfo();

    /**
     * 查询用户设备
     * @param regionId 用户所属区域id
     * @return 设备列表
     */
    List<Map<String,Object>> listUserDevice(@Param("regionId") Integer regionId);
    
    /**
	 * @description 查询所有异常设备信息
	 * @param paramMap
	 * @return
	 * @author LiLinFeng
	 * @date 2019-01-15
	 */
	List<BDeviceInfoVo> selectExceptionDeviceInfos(Map<String, Object> paramMap);

    /**
     * @description 查询所有异常设备信息
     * @return
     * @author LiLinFeng
     * @date 2019-01-17
     */
    List<ExceptionDeviceExportVO> queryExceptionDeviceInfos();
    
	/**
	 * 启动回传服务器后自动将所有设备更新为离线状态，后面有回传的再将具体状态更新即可
	 * @return
	 */
	void updateAllDeceiveState();
	
	/**
	 * 
	 * @param regionIdlist
	 * @return 
	 */
	List<Integer> getDeviceByResourceId(List<String> regionIdlist);
	
	List<String> getDeviceByConditions(Map<String, Object> map);
	
	/**
	 * 查询出所有 正在广播和在线的设备(0,1)  
	 * 用于省平台测试时的设备展示   
	 * 2019-04-10  lxg
	 * @return
	 */
	List<Integer> getAllDevices();
	
	List<BDeviceInfo> selectCameraDevices();
	List<Map<String, Object>> getAllAdapters();
	
}
