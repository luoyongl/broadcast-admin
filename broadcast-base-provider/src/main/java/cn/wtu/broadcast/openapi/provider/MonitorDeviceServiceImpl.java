package cn.wtu.broadcast.openapi.provider;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.MonitorDeviceService;
import cn.wtu.broadcast.openapi.dao.BDeviceInfoMapper;
import cn.wtu.broadcast.openapi.dao.TDictionaryMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceInfoExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.CameraVoExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.ServerVoExtMapper;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInfoExample;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.util.FileOperate;
import cn.wtu.broadcast.openapi.vo.CameraVo;
import cn.wtu.broadcast.openapi.vo.ConnectLineVO;
import cn.wtu.broadcast.openapi.vo.ServerVo;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-02 11:30
 */
@Service
public class MonitorDeviceServiceImpl extends ParentServiceImpl<BDeviceInfo> implements MonitorDeviceService {

    private static Logger logger = LoggerFactory.getLogger(AudioManageServiceImpl.class);

    private final BDeviceInfoMapper bDeviceInfoMapper;

    private final BDeviceInfoExtMapper bDeviceInfoExtMapper;

    private final CameraVoExtMapper cameraVoExtMapper;

    private final ServerVoExtMapper serverVoExtMapper;

    private final TDictionaryMapper tDictionaryMapper;
    
    private final BBroadcastDataExtMapper broadcastDataExtMapper;

    @Autowired
    public MonitorDeviceServiceImpl(BDeviceInfoMapper bDeviceInfoMapper, BDeviceInfoExtMapper bDeviceInfoExtMapper, CameraVoExtMapper cameraVoExtMapper, ServerVoExtMapper serverVoExtMapper,TDictionaryMapper tDictionaryMapper,BBroadcastDataExtMapper broadcastDataExtMapper) {
        this.bDeviceInfoMapper = bDeviceInfoMapper;
        this.bDeviceInfoExtMapper = bDeviceInfoExtMapper;
        this.cameraVoExtMapper = cameraVoExtMapper;
        this.serverVoExtMapper = serverVoExtMapper;
        this.tDictionaryMapper = tDictionaryMapper;
        this.broadcastDataExtMapper = broadcastDataExtMapper;
    }

    @Override
    protected DBInterface<BDeviceInfo> getDao() {
        return bDeviceInfoMapper;
    }

    @Override
    public boolean add(BDeviceInfo deviceInfo, Byte type) {
        Date date = new Date();
        TUser sessionUser = getSessionUser();

        deviceInfo.setfOperatorId(sessionUser.getfId());
        deviceInfo.setfUpdateTime(date);

        deviceInfo.setfCreateTime(date);
        deviceInfo.setfCreatorId(sessionUser.getfId());
        deviceInfo.setfDeleteFlag(false);
        deviceInfo.setfDeviceType(type);
        try {
            int result = bDeviceInfoMapper.insertSelective(deviceInfo);
            if (result == 1) {
                insertLog(OperationLogTypeEnum.INSERT, "新增监控设备", "成功");
                return true;
            } else {
                insertLog(OperationLogTypeEnum.INSERT, "新增监控设备", "失败");
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            insertLog(OperationLogTypeEnum.INSERT, "新增监控设备", "失败");
            return false;
        }

    }

    @Override
    public boolean updateCamera(BDeviceInfo deviceInfo) {
        deviceInfo.setfOperatorId(getSessionUser().getfId());
        deviceInfo.setfUpdateTime(new Date());
        try {
            int result = bDeviceInfoMapper.updateByPrimaryKeySelective(deviceInfo);
            if (result == 1) {
                insertLog(OperationLogTypeEnum.UPDATE, "修改监控设备", "成功");
                return true;
            } else {
                insertLog(OperationLogTypeEnum.UPDATE, "修改监控设备", "失败");
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            insertLog(OperationLogTypeEnum.UPDATE, "修改监控设备", "失败");
            return false;
        }
    }

    @Override
    public Integer deleteByIds(String ids, Byte type,String del_path) {
        TUser sessionUser = getSessionUser();
        Date date = new Date();
        int result = 0;
        String[] split = ids.split(",");
        for (String s : split) {
            BDeviceInfo bDeviceInfo = new BDeviceInfo();
            bDeviceInfo.setfId(Integer.parseInt(s));
            bDeviceInfo.setfOperatorId(sessionUser.getfId());
            bDeviceInfo.setfUpdateTime(date);
            bDeviceInfo.setfDeleteFlag(true);
            bDeviceInfo.setfDeviceType(type);
            BDeviceInfo deviceInfo = bDeviceInfoMapper.selectByPrimaryKey(Integer.parseInt(s));
            if(deviceInfo==null){
                break;
            }
            try {
                result += bDeviceInfoMapper.updateByPrimaryKeySelective(bDeviceInfo);
                FileOperate.deleteFile(del_path,deviceInfo.getfDeviceImage());
            } catch (Exception e) {
                insertLog(OperationLogTypeEnum.DELETE, "删除监控设备", "删除失败");
                logger.error(e.getMessage(), e);
            }

        }
        insertLog(OperationLogTypeEnum.DELETE, "删除监控设备", "删除了" + result + "个");

        return result;
    }

    @Override
    public List<BDeviceInfo> getAll(Byte type) {
        BDeviceInfoExample example = new BDeviceInfoExample();
        example.createCriteria().andFDeviceTypeEqualTo(type).andFDeleteFlagEqualTo(false);
        List<BDeviceInfo> bDeviceInfos = null;
        try {
            bDeviceInfos = bDeviceInfoMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return bDeviceInfos;
    }

    @Override
    public List<CameraVo> selectCameraList() {

        List<CameraVo> bDeviceInfos = null;
        try {
            bDeviceInfos = cameraVoExtMapper.selectCameraList();
            for(CameraVo device:bDeviceInfos){
                String channelModelId = device.getfChannelModel();
                if(channelModelId!=null){
                    TDictionary dictionary = tDictionaryMapper.selectByPrimaryKey(Integer.parseInt(channelModelId));
                    device.setfChannelModel(dictionary.getfDictionaryContent());
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return bDeviceInfos;
    }

    @Override
    public List<ServerVo> selectServerList() {

        List<ServerVo> bDeviceInfos = null;
        try {
            bDeviceInfos = serverVoExtMapper.selectServerList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return bDeviceInfos;
    }

    @Override
    public PageInfo<BDeviceInfo> queryPageByParam(Map<String, Object> paramMap) throws BizException {
        PageHelper.startPage((Integer) paramMap.get("pageNo"), (Integer) paramMap.get("pageSize"));
        List<BDeviceInfo> dataList = null;
        try {
            dataList = bDeviceInfoExtMapper.selectDeviceList(paramMap);
            if (dataList != null) {
                return new PageInfo<>(dataList);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 查询用户设备
     *
     * @return 设备列表
     */
    @Override
    public List<Map<String,Object>> listUserDevice() {
        TUser sessionUser = getSessionUser();
        if (sessionUser.getfRespectiveRegion() != null) {
            return bDeviceInfoExtMapper.listUserDevice(sessionUser.getfRespectiveRegion());
        } else {
            return Collections.emptyList();
        }
    }

	@Override
	public List<ConnectLineVO> getConnectInfo() {
		List<ConnectLineVO> connectLines = null;
		try {
			connectLines = broadcastDataExtMapper.selectConnectInfo();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
		return connectLines;
	}

	@Override
	public List<BDeviceInfo> getCameraInfo() {
		List<BDeviceInfo> cameraInfos = null;
		try {
			cameraInfos = bDeviceInfoExtMapper.selectCameraDevices();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
		return cameraInfos;
	}
}
