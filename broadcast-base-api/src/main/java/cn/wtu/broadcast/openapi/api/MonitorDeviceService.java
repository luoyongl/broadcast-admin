package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.vo.CameraVo;
import cn.wtu.broadcast.openapi.vo.ConnectLineVO;
import cn.wtu.broadcast.openapi.vo.ServerVo;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-02 11:28
 */
public interface MonitorDeviceService extends ParentService<BDeviceInfo> {

    /**
     * 新增设备
     *
     * @param deviceInfo
     * @param type
     * @return
     */
    boolean add(BDeviceInfo deviceInfo, Byte type);

    /**
     * 更新设备
     *
     * @param deviceInfo
     * @return
     */
    boolean updateCamera(BDeviceInfo deviceInfo);

    /**
     * 根据id删除
     *
     * @param ids
     * @param type
     * @return
     */
    Integer deleteByIds(String ids, Byte type,String del_path);

    /**
     * 用于检测设备号重复
     *
     * @param type
     * @return
     */
    List<BDeviceInfo> getAll(Byte type);

    /**
     * 返回cameravo对象，用于导出表格
     *
     * @return
     */
    List<CameraVo> selectCameraList();

    /**
     * ServerVo，用于导出表格
     *
     * @return
     */
    List<ServerVo> selectServerList();

    /**
     * 查询用户设备
     *
     * @return 设备列表
     */
    List<Map<String,Object>> listUserDevice();
    
    /**
     * 获取正在播发的广播连线信息
     * 
     * @return 地图回传连接点信息
     */
    List<ConnectLineVO> getConnectInfo();
    
    /**
     * 获取摄像头信息
     *
     * @param type
     * @return
     */
    List<BDeviceInfo> getCameraInfo();
}
