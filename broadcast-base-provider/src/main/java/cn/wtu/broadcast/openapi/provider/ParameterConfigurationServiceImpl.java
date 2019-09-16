package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import cn.wtu.broadcast.openapi.api.ParameterConfigurationService;
import cn.wtu.broadcast.openapi.dao.BDeviceInputChannelMapper;
import cn.wtu.broadcast.openapi.dao.BDeviceOutputChannelMapper;
import cn.wtu.broadcast.openapi.dao.BDeviceParameterSetMapper;
import cn.wtu.broadcast.openapi.dao.BDeviceRdsSetMapper;
import cn.wtu.broadcast.openapi.dao.BWhitelistMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceParameterSetExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceRdsSetExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceTerminalStatusQueryExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.BWhitelistExtMapper;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceInputChannelExample;
import cn.wtu.broadcast.openapi.model.BDeviceOutputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceOutputChannelExample;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSetExample;
import cn.wtu.broadcast.openapi.model.BDeviceRdsSet;
import cn.wtu.broadcast.openapi.model.BDeviceTerminalStatusQuery;
import cn.wtu.broadcast.openapi.model.BWhitelist;
import cn.wtu.broadcast.openapi.model.BWhitelistExample;
import cn.wtu.broadcast.openapi.vo.BWhitelistNewVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.dto.IpOrPortInParameterStatusDto;
import cn.wtu.broadcast.parent.enums.IpOrPortStatusEnum;
import cn.wtu.broadcast.parent.vo.cmd.IpOrPortInParameterStatusVO;

@Service("parameterConfigurationService")
@Transactional
public class ParameterConfigurationServiceImpl extends ParentServiceImpl<BDeviceParameterSet> implements ParameterConfigurationService{

	private static Logger logger = LoggerFactory.getLogger(ParameterConfigurationServiceImpl.class);
	
	@Autowired
	private BDeviceParameterSetExtMapper bDeviceParameterSetExtMapper;
	
	@Autowired
	private BDeviceParameterSetMapper bDeviceParameterSetMapper;
	
	@Autowired
	private BDeviceRdsSetMapper bDeviceRdsSetMapper;
	
	@Autowired
	private BDeviceInputChannelMapper bDeviceInputChannelMapper;
	
	@Autowired
	private BDeviceOutputChannelMapper bDeviceOutputChannelMapper;
	
	@Autowired
	private BDeviceRdsSetExtMapper bDeviceRdsSetExtMapper;
	
	@Autowired
	private BDeviceTerminalStatusQueryExtMapper bDeviceTerminalStatusQueryExtMapper;
	
	@Autowired
	private BWhitelistMapper bWhitelistMapper;
	
	@Autowired
	private  BWhitelistExtMapper bWhitelistExtMapper;
	
	//查询输出通道
	@Override
	public List<BDeviceOutputChannel> findOutputChannelList(String resourceCode) {
		List<BDeviceOutputChannel> outputChannels = Lists.newArrayList();
		try {
			BDeviceOutputChannelExample example = new BDeviceOutputChannelExample();
			example.createCriteria().andFDeviceResourceCodeEqualTo(resourceCode);
			outputChannels = bDeviceOutputChannelMapper.selectByExample(example);			
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return outputChannels;
	}

	//查询输入通道
	@Override
	public List<BDeviceInputChannel> findInputChannelList(String resourceCode) {
		List<BDeviceInputChannel> inputChannels = Lists.newArrayList();
		try {
			BDeviceInputChannelExample example = new BDeviceInputChannelExample();
			example.createCriteria().andFDeviceResourceCodeEqualTo(resourceCode);
			inputChannels = bDeviceInputChannelMapper.selectByExample(example);			
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return inputChannels;
	}

	//TS设置频点(新增)
	@Override
	public int addRdsToDdeviceTsSet(BDeviceParameterSet bDeviceParameterSet, String resourceCode,
			Integer frequency, Integer symbolRate, Integer QamNumber) {
		int count = 0;
		if (bDeviceParameterSet != null) {
			bDeviceParameterSet.setfTsSettingFrequency(frequency);
			bDeviceParameterSet.setfTsSettingSymbolRate(symbolRate);
			bDeviceParameterSet.setfTsSettingQam(QamNumber);
			BDeviceParameterSetExample example = new BDeviceParameterSetExample();
			example.createCriteria().andFDeviceResourceCodeEqualTo(bDeviceParameterSet.getfDeviceResourceCode());
			try {
				count = bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, example);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}else {
			BDeviceParameterSet parameterSet = new BDeviceParameterSet();
			parameterSet.setfDeviceResourceCode(resourceCode);
			parameterSet.setfTsSettingFrequency(frequency);
			parameterSet.setfTsSettingSymbolRate(symbolRate);
			parameterSet.setfTsSettingQam(QamNumber);
			try {
				count =  bDeviceParameterSetMapper.insertSelective(parameterSet);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}
	}

	//RDS设置频点(新增)
	@Override
	public int addRdsToDdeviceRdsSet(String resourceCode, Integer rdsPriority, Double rdsFrequency) {
		BDeviceRdsSet bDeviceRdsSet = new BDeviceRdsSet();
		bDeviceRdsSet.setfDeviceResourceCode(resourceCode);
		bDeviceRdsSet.setfRdsPriority(rdsPriority);
		bDeviceRdsSet.setfRdsFrequency(rdsFrequency);
		int count = 0;
		try {
			count = bDeviceRdsSetMapper.insertSelective(bDeviceRdsSet);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return count;
	}
	
	//RDS设置频点(更新)
	@Override
	public int updateRdsToDdeviceRdsSet(Integer rdsId,Integer rdsPriority,Double rdsFrequency) {
		BDeviceRdsSet rdsSet = bDeviceRdsSetMapper.selectByPrimaryKey(rdsId);
		rdsSet.setfRdsPriority(rdsPriority);
		rdsSet.setfRdsFrequency(rdsFrequency);
		int count = 0;
		try {
			return bDeviceRdsSetMapper.updateByPrimaryKey(rdsSet);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return count;
	}

	//RDS设置频点(删除)
	@Override
	public int deleteRdsToDdeviceRdsSet(Integer rdsId) {
		BDeviceRdsSet rdsSet = bDeviceRdsSetMapper.selectByPrimaryKey(rdsId);
		rdsSet.setfDeleteFlag(false);
		int count = 0;
		try {
			count = bDeviceRdsSetMapper.updateByPrimaryKey(rdsSet);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return count;
	}

	/**
	 * RDS设置频点(删除) 注:这里使用资源编码对新增操作进行业务修改(以原先做法，会出现重复回显的情况)
	 */
	@Override
	public int deleteRdsByResourceCode(String resourceCode) {
		List<BDeviceRdsSet> rdsSetList = null;
		try {
			rdsSetList = bDeviceRdsSetExtMapper.findBDeviceRdsSetByCode(resourceCode);
			if (rdsSetList != null) {
				for (BDeviceRdsSet rdsSet : rdsSetList) {
					rdsSet.setfDeleteFlag(true);
					bDeviceRdsSetMapper.updateByPrimaryKey(rdsSet);
				}						
			}
			return 0;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return rdsSetList.size();
	}
	
	//根据资源编码查询RDS
	@Override
	public List<BDeviceRdsSet> findBDeviceRdsSetByCode(String resourceCode) {
		List<BDeviceRdsSet> findBDeviceRdsSetByCode = Lists.newArrayList();
		try {
			findBDeviceRdsSetByCode = bDeviceRdsSetExtMapper.findBDeviceRdsSetByCode(resourceCode);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return findBDeviceRdsSetByCode;
	}
	
	//查询设备
	@Override
	public BDeviceInfo findDeviceInfo(String resourceCode) {
		BDeviceInfo findDeviceInfo = new BDeviceInfo();
		try {
			findDeviceInfo = bDeviceParameterSetExtMapper.findDeviceInfo(resourceCode);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return findDeviceInfo;
	}
	
	//设置IP地址
	@Override
	public int updateOrInsertIpAddressToBDeviceParameterSet(
			BDeviceParameterSet bDeviceParameterSet, String resourceCode, String ipAddressValue,
			String subnetMask, String ipGate) {
		int count = 0;
		if (bDeviceParameterSet != null) {
			//更新设备表中IP值以及  更新扩展表中子网掩码和网关
			bDeviceParameterSet.setfDeviceIp(ipAddressValue);
			bDeviceParameterSet.setfDeviceSubnetMask(subnetMask);
			bDeviceParameterSet.setfDeviceGateway(ipGate);
			BDeviceParameterSetExample example= new BDeviceParameterSetExample();
			example.createCriteria().andFDeviceResourceCodeEqualTo(bDeviceParameterSet.getfDeviceResourceCode());
			try {
				count = bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, example);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}else {
			//更新设备表中IP值以及  插入扩展表中子网掩码和网关
			BDeviceParameterSet parameterSet = new BDeviceParameterSet();
			parameterSet.setfDeviceResourceCode(resourceCode);
			parameterSet.setfDeviceIp(ipAddressValue);
			parameterSet.setfDeviceSubnetMask(subnetMask);
			parameterSet.setfDeviceGateway(ipGate);
			try {
				count = bDeviceParameterSetMapper.insertSelective(parameterSet);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}
	}
	
	//设置回传周期
	@Override
	public int updateOrInsertReturnCycleToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,
			Integer datetime, String resourceCode) {
		int count = 0;
		if (bDeviceParameterSet != null) {
			bDeviceParameterSet.setfAdapterRebackCycle(datetime);
			BDeviceParameterSetExample bDeviceParameterSetExample = new BDeviceParameterSetExample();
			bDeviceParameterSetExample.createCriteria().andFDeviceResourceCodeEqualTo(bDeviceParameterSet.getfDeviceResourceCode());
			try {
				count = bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, bDeviceParameterSetExample);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}else {
			BDeviceParameterSet bParameterSet = new BDeviceParameterSet();
			bParameterSet.setfDeviceResourceCode(resourceCode);
			bParameterSet.setfAdapterRebackCycle(datetime);
			try {
				count = bDeviceParameterSetMapper.insertSelective(bParameterSet);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}
	}
	
	//查找参数扩展
	/*@Override
	public BDeviceParameterSetExtend findParameterSetExtend(String resourceCode) {
		BDeviceParameterSetExtend findParameterSetExtend = bDeviceParameterSetExtMapper.findParameterSetExtend(resourceCode);
		return findParameterSetExtend;
	}*/
	
	//设置回传地址
	@Override
	public int updateOrInsertReturnAddressToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,
			String resourceCode, String returnIpValue, String returnPortValue) {
		int count = 0;
		if (bDeviceParameterSet != null) {
			String ipAndPortValue = returnIpValue + ":" + returnPortValue;
			bDeviceParameterSet.setfAdapterRebackAddress(ipAndPortValue);
			BDeviceParameterSetExample example = new BDeviceParameterSetExample();
			example.createCriteria().andFDeviceResourceCodeEqualTo(bDeviceParameterSet.getfDeviceResourceCode());
			try {
				count = bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, example);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}else {
			BDeviceParameterSet parameterSet = new BDeviceParameterSet();
			parameterSet.setfDeviceResourceCode(resourceCode);
			String ipAndPortValue = returnIpValue + ":" + returnPortValue;
			parameterSet.setfAdapterRebackAddress(ipAndPortValue);
			try {
				count = bDeviceParameterSetMapper.insertSelective(parameterSet);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}
	}
	
	//更新音量
	@Override
	public int updateOrInsertVolumeToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet, Integer volume,String resourceCode) {
		int count = 0;
		if (bDeviceParameterSet != null) {
			bDeviceParameterSet.setfVolume(volume);
			BDeviceParameterSetExample bDeviceParameterSetExample = new BDeviceParameterSetExample();
			bDeviceParameterSetExample.createCriteria().andFDeviceResourceCodeEqualTo(bDeviceParameterSet.getfDeviceResourceCode());
			try {
				count = bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, bDeviceParameterSetExample);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}else {
			BDeviceParameterSet bParameterSet = new BDeviceParameterSet();
			bParameterSet.setfDeviceResourceCode(resourceCode);
			bParameterSet.setfVolume(volume);
			int insertSelective = bDeviceParameterSetMapper.insertSelective(bParameterSet);
			return insertSelective;
		}
	}
	
	//功放开关
	@Override
	public int updateOrInsertSwitchNumberToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,
			Integer switchNumber, String resourceCode) {
		int count = 0;
		if (bDeviceParameterSet != null) {
			bDeviceParameterSet.setfDeviceSwitchOption(switchNumber);
			BDeviceParameterSetExample bDeviceParameterSetExample = new BDeviceParameterSetExample();
			bDeviceParameterSetExample.createCriteria().andFDeviceResourceCodeEqualTo(bDeviceParameterSet.getfDeviceResourceCode());
			try {
				count = bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, bDeviceParameterSetExample);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}else {
			BDeviceParameterSet bParameterSet = new BDeviceParameterSet();
			bParameterSet.setfDeviceResourceCode(resourceCode);
			bParameterSet.setfDeviceSwitchOption(switchNumber);
			try {
				count = bDeviceParameterSetMapper.insertSelective(bParameterSet);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}
	}
	
	//音量调节
	@Override
	public BDeviceParameterSet findParameterSet(String resourceCode) {
		BDeviceParameterSet findVolumeAdjust = new BDeviceParameterSet();
		try {
			findVolumeAdjust = bDeviceParameterSetExtMapper.findParameterSet(resourceCode);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return findVolumeAdjust;
	}
	
	//查询回复通道
	@Override
	public BDeviceTerminalStatusQuery findParamResponse(String resourceCode) {
		BDeviceTerminalStatusQuery bTerminalStatusQuery = new BDeviceTerminalStatusQuery();
		try {
			bTerminalStatusQuery = bDeviceTerminalStatusQueryExtMapper.findParamResponse(resourceCode);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return bTerminalStatusQuery;
	}

	//更新或插入资源编码设置
	@Override
	public int insertOrUpdateCodes(BDeviceParameterSet bDeviceParameterSet,String resourceCode) {
		int count = 0;
		try {
			if (bDeviceParameterSet != null) {
				return count;
			}else {
				BDeviceParameterSet bDeviceParameter = new BDeviceParameterSet();
				bDeviceParameter.setfDeviceResourceCode(resourceCode);
				count = bDeviceParameterSetMapper.insertSelective(bDeviceParameter);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return count;
	}
	
	//更新或插入查询状态(状态类型)
	@Override
	public int insertOrUpdateParameterStatus(BDeviceParameterSet bDeviceParameterSet, String resourceCode,
			String queryCodes) {
		int count = 0;
		if (bDeviceParameterSet != null) {
			bDeviceParameterSet.setfQueryCode(queryCodes);
			BDeviceParameterSetExample example = new BDeviceParameterSetExample();
			example.createCriteria().andFDeviceResourceCodeEqualTo(resourceCode);
			try {
				count = bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, example);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count; 
		}else {
			BDeviceParameterSet bDeviceParameter = new BDeviceParameterSet();
			bDeviceParameter.setfDeviceResourceCode(resourceCode);
			bDeviceParameter.setfQueryCode(queryCodes);
			try {
				count = bDeviceParameterSetMapper.insertSelective(bDeviceParameter);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}
	}
	
	/**
	 * 时钟校准
	 */
	@Override
	public int addOrUpdateCalibrationTime(BDeviceParameterSet bDeviceParameterSet,String resourceCode) {
		int count = 0;
		try {
			if (bDeviceParameterSet != null) {
				bDeviceParameterSet.setfCalibrationTime(new Date());
				count = bDeviceParameterSetMapper.updateByPrimaryKey(bDeviceParameterSet);
			}else{
				BDeviceParameterSet bDeviceParameter = new BDeviceParameterSet();
				bDeviceParameter.setfDeviceResourceCode(resourceCode);
				bDeviceParameter.setfCalibrationTime(new Date());
				count = bDeviceParameterSetMapper.insertSelective(bDeviceParameter);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return count;
	}
	
	// 查询状态参数  目的：判断不同设备的回传IP和端口是否相同
	@Override
	public IpOrPortInParameterStatusDto ipOrPortInParameterStatus(List<String> resourceCodes) {
		//传进来的资源编码数量大于等于2
		if (resourceCodes.size() > 1) {
			boolean flag = true;
			//ipOrPortVos -> ipOrPortVo
			List<IpOrPortInParameterStatusVO> ipOrPortVos = Lists.newArrayList();
			//ipOrPortDto -> ipOrPortVos
			IpOrPortInParameterStatusDto ipOrPortDto = new IpOrPortInParameterStatusDto();
			
			//统计空串数量
			int count = 0;
			
			for (String resourceCode : resourceCodes) {
				IpOrPortInParameterStatusVO ipOrPortVo = new IpOrPortInParameterStatusVO();
				BDeviceParameterSet findParameterSet = new BDeviceParameterSet();
				try {
					findParameterSet = bDeviceParameterSetExtMapper.findParameterSet(resourceCode);
				} catch (Exception e) {
					logger.error(e.getMessage() + e);
				}
				//判断IP端口字段是否存在值
				if(findParameterSet.getfAdapterRebackAddress() != null &&
						findParameterSet.getfAdapterRebackAddress() != ""){
					ipOrPortVo.setReturnIp(findParameterSet.getfAdapterRebackAddress().split(":")[0]);
					ipOrPortVo.setReturnPort(findParameterSet.getfAdapterRebackAddress().split(":")[1]);					
				}else {
					ipOrPortVo.setReturnIp("");
					ipOrPortVo.setReturnPort("");
					count = count++;
				}
				ipOrPortVos.add(ipOrPortVo);
			}
			//全部是空串
			if (count == ipOrPortVos.size()) {
				ipOrPortDto.setStatus(IpOrPortStatusEnum.nullStatus.getStatus());
				ipOrPortDto.setIpOrPortList(ipOrPortVos);
			}
			
			//循环遍历(两两比较)->不同则置为false
			for(int i = 0 ; i < ipOrPortVos.size() ; i++){
				IpOrPortInParameterStatusVO ipPortMainVO = ipOrPortVos.get(i);
				for(int j = i+1 ; j < ipOrPortVos.size() ; j++){
					IpOrPortInParameterStatusVO ipOrPortToVO = ipOrPortVos.get(j);
					if (!ipPortMainVO.getReturnPort().equals(ipOrPortToVO.getReturnPort())
							|| !ipPortMainVO.getReturnIp().equals(ipOrPortToVO.getReturnIp())) {
						flag = false;
					}
				}
			}
			//flag为true则说明ip和端口全部是相同的情况
			if (flag) {
				ipOrPortDto.setStatus(IpOrPortStatusEnum.okStatus.getStatus());
				ipOrPortDto.setIpOrPort(ipOrPortVos.get(0));
				return ipOrPortDto;
			}else {
				ipOrPortDto.setStatus(IpOrPortStatusEnum.errorsStatus.getStatus());
				ipOrPortDto.setIpOrPortList(ipOrPortVos);
				return ipOrPortDto;
			}
		}else {
			//传进来的资源编码数量为1(这里需要做处理是我需要向前台传IP和端口值,若为空则需要提示)
			String resourceCode = resourceCodes.get(0);
			
			IpOrPortInParameterStatusDto ipOrPortDto = new IpOrPortInParameterStatusDto();
			List<IpOrPortInParameterStatusVO> ipOrPortOneVos = Lists.newArrayList();
			
			BDeviceParameterSet findParameterSet = new BDeviceParameterSet();
			try {
				findParameterSet = bDeviceParameterSetExtMapper.findParameterSet(resourceCode);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}		
			IpOrPortInParameterStatusVO ipOrPortVo = new IpOrPortInParameterStatusVO();
			
			//ip和端口为空
			if (findParameterSet.getfAdapterRebackAddress() == null ||
					findParameterSet.getfAdapterRebackAddress() == "") {
				ipOrPortVo.setReturnIp("");
				ipOrPortVo.setReturnPort("");
				ipOrPortOneVos.add(ipOrPortVo);
				ipOrPortDto.setStatus(IpOrPortStatusEnum.nullStatus.getStatus());
				ipOrPortDto.setIpOrPortList(ipOrPortOneVos);
				return ipOrPortDto;
			}else{
				ipOrPortVo.setReturnIp(findParameterSet.getfAdapterRebackAddress().split(":")[0]);
				ipOrPortVo.setReturnPort(findParameterSet.getfAdapterRebackAddress().split(":")[1]);
				ipOrPortOneVos.add(ipOrPortVo);
				ipOrPortDto.setStatus(IpOrPortStatusEnum.okStatus.getStatus());
				ipOrPortDto.setIpOrPortList(ipOrPortOneVos);
				return ipOrPortDto;
			}
		}
	}
	
	/**
	 * 以下是对白名单更新相关操作
	 * 注： 设备表id(多个或一个),资源编码(多个或一个),授权区域码(多个或一个)[理解不同点]
	 * @param 1操作类型(增删改) 2账号  3姓名  4电话号码  5授权方式  6授权区域   7资源编码  8白名单id(删除)
	 * 
	 * 1.白名单更新新增和修改是相同处理
	 */
	@Override
	public int addWhiteList(int operCode, String account, String name, String phoneNumber, int permit, String areaCode,
			String resourceCode) {
		int count = 0;
		BWhitelistExample example = new BWhitelistExample();
		example.createCriteria().andFAssociatedIdEqualTo(account).andFDeleteFlagEqualTo(false);
		List<BWhitelist> bWhitelists = bWhitelistMapper.selectByExample(example);
		if (bWhitelists.size() > 1) {
			return -1;
		}
		if (bWhitelists.size() == 1) {
			BWhitelist bWhitelist = bWhitelists.get(0);
			bWhitelist.setfOperType(operCode);
			bWhitelist.setfAssociatedId(account);
			bWhitelist.setfName(name);
			bWhitelist.setfTelephoneNumber(phoneNumber);
			bWhitelist.setfPermit((byte)permit);
			bWhitelist.setfPermissionAreaCode(areaCode);
			bWhitelist.setfResourceCode(resourceCode);
			bWhitelist.setfUpdateTime(new Date());
			bWhitelist.setfOperatorId(getSessionUser().getfId());
			try {
				count = bWhitelistMapper.updateByPrimaryKeySelective(bWhitelist);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}else {
			BWhitelist bWhitelistNew = new BWhitelist();
			bWhitelistNew.setfOperType(operCode);
			bWhitelistNew.setfAssociatedId(account);
			bWhitelistNew.setfName(name);
			bWhitelistNew.setfTelephoneNumber(phoneNumber);
			bWhitelistNew.setfPermit((byte)permit);
			bWhitelistNew.setfPermissionAreaCode(areaCode);
			bWhitelistNew.setfResourceCode(resourceCode);
			bWhitelistNew.setfCreateTime(new Date());
			bWhitelistNew.setfOperatorId(getSessionUser().getfId());
			try {
				count = bWhitelistMapper.insertSelective(bWhitelistNew);
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
			return count;
		}
	}
	
	/**
	 * 2.白名单更新删除处理
	 */
	@Override
	public int deleteWhiteList(int id) {
		int count = 0;
		try {
			BWhitelist bWhitelist = bWhitelistMapper.selectByPrimaryKey(id);
			if (bWhitelist != null) {
				bWhitelist.setfDeleteFlag(true);
				bWhitelist.setfOperatorId(getSessionUser().getfId());
				bWhitelist.setfUpdateTime(new Date());
				count = bWhitelistMapper.updateByPrimaryKey(bWhitelist);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return count;
	}
	
	/**
	 * 3.白名单更新查询处理
	 */
	@Override
	public PageInfo<BWhitelistNewVO> queryPage(Map<String, Object> paramMap) {
		PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
        List<BWhitelistNewVO> dataList = bWhitelistExtMapper.selectWhiteNewList(paramMap);
        return new PageInfo<>(dataList);
	}
	
	
	@Override
	protected DBInterface<BDeviceParameterSet> getDao() {
		return bDeviceParameterSetExtMapper;
	}

}
