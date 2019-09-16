package cn.wtu.broadcast.openapi.provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.dao.BBroadcastDeviceMapper;
import cn.wtu.broadcast.openapi.dao.BDeviceInfoMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceInfoExtMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastDevice;
import cn.wtu.broadcast.openapi.model.BBroadcastDeviceExample;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInfoExample;
import cn.wtu.broadcast.openapi.vo.BDeviceInfoVo;
import cn.wtu.broadcast.openapi.vo.ExceptionDeviceExportVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;

@Service("bDeviceInfoService")
public class BDeviceInfoServiceImpl extends ParentServiceImpl<BDeviceInfo> implements BDeviceInfoService {

	private static Logger logger = LoggerFactory.getLogger(BBroadcastDataServiceImpl.class);

	@Autowired
	private BDeviceInfoExtMapper bDeviceInfoExtMapper;

	@Autowired
	private BDeviceInfoMapper bDeviceInfoMapper;

	@Autowired
	private BBroadcastDeviceMapper bBroadcastDeviceMapper;

	/**
	 * @param paramMap
	 * @return
	 * @description 查询所有异常设备信息
	 * @author LiLinFeng
	 * @date 2019-01-15
	 */
	@Override
	public PageInfo<BDeviceInfoVo> selectExceptionDeviceInfos(Map<String, Object> paramMap) {

		PageInfo<BDeviceInfoVo> list = null;
		try {
			PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
			List<BDeviceInfoVo> list1 = bDeviceInfoExtMapper.selectExceptionDeviceInfos(paramMap);
			if (list1 != null) {
				list = new PageInfo<>(list1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return list;
	}

	@Override
	public List<ExceptionDeviceExportVO> queryExceptionDeviceInfos() {

		List<ExceptionDeviceExportVO> list = null;
		try {
			list = bDeviceInfoExtMapper.queryExceptionDeviceInfos();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return list;
	}

	@Override
	public Integer selectState(Integer flag) {
		BDeviceInfoExample example = new BDeviceInfoExample();
		example.createCriteria().andFDeviceStateEqualTo(String.valueOf(flag)).andFDeleteFlagEqualTo(false)
				.andFDeviceTypeBetween((byte) DeviceTypeEnum.frontDevice.getCode(),
						(byte) DeviceTypeEnum.terminalDevice.getCode());
		List<BDeviceInfo> bDeviceInfo = bDeviceInfoMapper.selectByExample(example);
		return bDeviceInfo.size();
	}

	@Override
	public Integer selectDeviceType(Integer type) {
		BDeviceInfoExample example = new BDeviceInfoExample();
		example.createCriteria().andFDeviceTypeEqualTo((byte) type.intValue());
		return bDeviceInfoMapper.selectByExample(example).size();
	}

	@Override
	protected DBInterface<BDeviceInfo> getDao() {
		return bDeviceInfoMapper;
	}

	@Override
	public Boolean updateDeviceStateBySourceCode(String deviceSourceCode, Byte deviceState) {
		Boolean result = false;
		try {
			BDeviceInfoExample example = new BDeviceInfoExample();
			example.createCriteria().andFDeleteFlagEqualTo(false).andFDeviceResourceCodeEqualTo(deviceSourceCode);
			List<BDeviceInfo> bDeviceInfoList = bDeviceInfoMapper.selectByExample(example);
			if (bDeviceInfoList != null) {
				for (BDeviceInfo bDeviceInfo : bDeviceInfoList) {
					try {
						bDeviceInfo.setfDeviceState(String.valueOf(deviceState));
						bDeviceInfoMapper.updateByExample(bDeviceInfo, example);
					} catch (Exception e) {
						logger.error(e.getMessage() + e);
					}
				}
			}
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}

		return result;
	}

	@Override
	public void updateAllDeceiveState() {
		try {
			bDeviceInfoExtMapper.updateAllDeceiveState();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}

	}

	/**
	 * 通过设备资源ID查询到对应的广播ID和设备ID, 音频回传用
	 */
	@Override
	public Map<String, Object> getBDeviceInfoForReceive(Map<String, Object> paramMap) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("fDeviceId", 0);
		result.put("fBroadcastId", 0);
		String deviceSourceCode = String.valueOf(paramMap.get("deviceSourceCode"));
		BDeviceInfoExample example = new BDeviceInfoExample();
		example.createCriteria().andFDeleteFlagEqualTo(false).andFDeviceResourceCodeEqualTo(deviceSourceCode);
		List<BDeviceInfo> bDeviceInfoList = bDeviceInfoMapper.selectByExample(example);
		if (bDeviceInfoList != null) {
			Integer fDeviceId = bDeviceInfoList.get(0).getfId();
			result.put("fDeviceId", fDeviceId);
			// 查询对应的广播ID
			BBroadcastDeviceExample bbde = new BBroadcastDeviceExample();
			bbde.setOrderByClause("f_broadcast_send_time desc");
			bbde.createCriteria().andFDeviceIdEqualTo(fDeviceId);
			List<BBroadcastDevice> list = bBroadcastDeviceMapper.selectByExample(bbde);
			if (list != null) {
				BBroadcastDevice bBroadcastDevice = list.get(0);
				result.put("fBroadcastId", bBroadcastDevice.getfBroadcastId());
			}
		}

		return result;
	}

	@Override
	public List<BDeviceInfo> listAll() {
		BDeviceInfoExample example = new BDeviceInfoExample();
		example.createCriteria().andFDeleteFlagEqualTo(false).andFLocationIsNotNull().andFDeviceResourceCodeIsNotNull()
				.andFDeviceStateEqualTo(String.valueOf(1));
		return bDeviceInfoMapper.selectByExample(example);
	}

	/**
	 * 查询出所有 正在广播和在线的设备(0,1) 用于省平台测试时的设备展示 2019-04-10 lxg
	 */
	public List<Integer> getAllDevices() {
		return bDeviceInfoExtMapper.getAllDevices();
	}

	@Override
	public BDeviceInfo getDeviceBySourceCode(String deviceSourceCode) {
		PageHelper.startPage(1, 1);
		BDeviceInfoExample example = new BDeviceInfoExample();
		example.setOrderByClause(" f_id desc ");
		example.createCriteria().andFDeleteFlagNotEqualTo(true).andFDeviceResourceCodeEqualTo(deviceSourceCode);
		List<BDeviceInfo> bDeviceInfoList = bDeviceInfoMapper.selectByExample(example);
		if (bDeviceInfoList != null && bDeviceInfoList.size() > 0) {
			return bDeviceInfoList.get(0);
		}

		return null;
	}
}