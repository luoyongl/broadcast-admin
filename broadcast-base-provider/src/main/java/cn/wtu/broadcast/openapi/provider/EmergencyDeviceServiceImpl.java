package cn.wtu.broadcast.openapi.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.EmergencyDeviceService;
import cn.wtu.broadcast.openapi.dao.BDeviceInfoMapper;
import cn.wtu.broadcast.openapi.dao.TAdministrativeDivisionMapper;
import cn.wtu.broadcast.openapi.dao.TManufacturerMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceInfoExtMapper;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInfoExample;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivisionExample;
import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.openapi.model.TManufacturerExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BDeviceInfoVo;
import cn.wtu.broadcast.openapi.vo.FrontDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.TerminalDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.TerminalDeviceVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;
import cn.wtu.broadcast.parent.utils.redis.Tool;

@Service("emergencyDeviceService")
public class EmergencyDeviceServiceImpl extends ParentServiceImpl<BDeviceInfo> implements EmergencyDeviceService {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(EmergencyDeviceServiceImpl.class);
	@Autowired
	private final BDeviceInfoMapper bDeviceInfoMapper;

	@Autowired
	private  TAdministrativeDivisionMapper tAdministrativeDivisionMapper;
	
	@Autowired
	private  TManufacturerMapper tManufacturerMapper;
	
	@Autowired
	private  BDeviceInfoExtMapper bDeviceInfoExtMapper;
	
	@Autowired
	public EmergencyDeviceServiceImpl(BDeviceInfoMapper bDeviceInfoMapper) {
		this.bDeviceInfoMapper = bDeviceInfoMapper;
	}

	@Override
	public PageInfo<BDeviceInfoVo> queryDevicePage(Map<String, Object> paramMap) {
		PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
		List<BDeviceInfoVo> deviceData = new ArrayList<BDeviceInfoVo>();
		try {
			deviceData = bDeviceInfoExtMapper.selectfrontAndTerminalDeviceList(paramMap);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		return new PageInfo<>(deviceData);
	}
	
	@Override
	public List<FrontDeviceExportVO> queryFrontExportDeviceInfo() {
		List<FrontDeviceExportVO> deviceData = new ArrayList<FrontDeviceExportVO>();
		try {
			deviceData = bDeviceInfoExtMapper.exportFrontDeviceInfo();
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		return deviceData;
	}

	@Override
	protected DBInterface<BDeviceInfo> getDao() {
		return (DBInterface<BDeviceInfo>) bDeviceInfoMapper;
	}

	@Override
	public boolean insertOrUpdateDevice(BDeviceInfo bDeviceInfo) {
		// TODO Auto-generated method stub
		boolean result = false;
		TUser sessionUser = getSessionUser();
		Date time = new Date();
		if (bDeviceInfo.getfId() != null) {
			bDeviceInfo.setfOperatorId(sessionUser.getfId());
			bDeviceInfo.setfUpdateTime(time);
			try {
				if (bDeviceInfoMapper.updateByPrimaryKeySelective(bDeviceInfo) == 1) {
					RedisDb.setObject((bDeviceInfo.getfDeviceResourceCode()).getBytes(), Tool.ObjectToByte(bDeviceInfo));
					result = true;
					insertLog(OperationLogTypeEnum.UPDATE, "修改设备信息", "成功");
				}
			}catch (Exception e){
				logger.error(e.getMessage(),e);
			}
		} else {
			bDeviceInfo.setfCreatorId(sessionUser.getfId());
			bDeviceInfo.setfCreateTime(time);
			//bDeviceInfo
			try {
				bDeviceInfo.setfDeviceState(String.valueOf(2));
				if (bDeviceInfoMapper.insertSelective(bDeviceInfo) == 1) {
					result = true;
					insertLog(OperationLogTypeEnum.INSERT, "新增设备信息", "成功");
				}
			}catch (Exception e){
				logger.error(e.getMessage(),e);
			}
		}
		return result;
	}

	@Override
	public int deleteAllByPrimaryKey(String[] ids) {
		int result = 0;
		 Date time = new Date();
	     TUser sessionUser = getSessionUser();
	     for(int i=0;i<ids.length;i++){
	    	 BDeviceInfo bDeviceInfo =new BDeviceInfo();
	    	 bDeviceInfo.setfDeleteFlag(true);
	    	 bDeviceInfo.setfId(Integer.parseInt(ids[i]));
	    	 bDeviceInfo.setfUpdateTime(time);
	    	 bDeviceInfo.setfOperatorId(sessionUser.getfId());
	    	 try {
	    		 result = result + bDeviceInfoMapper.updateByPrimaryKeySelective(bDeviceInfo);
				}catch (Exception e){
					logger.error(e.getMessage(),e);
				}
	     }
	     insertLog(OperationLogTypeEnum.DELETE, "删除设备", "删除了" + result + "个设备");
		return result;
	}

	@Override
	public List<TAdministrativeDivision> queryDivision() {
		TAdministrativeDivisionExample tAdministrativeDivisionExample = new TAdministrativeDivisionExample();
		tAdministrativeDivisionExample.createCriteria().andFDeleteFlagNotEqualTo(true);
		List<TAdministrativeDivision> list = tAdministrativeDivisionMapper.selectByExample(tAdministrativeDivisionExample);
		return list;
	}


	@Override
	public List<BDeviceInfo> selectDeviceForTelList(Byte type) {
		BDeviceInfoExample example=new BDeviceInfoExample();
		example.createCriteria().andFDeleteFlagEqualTo(false).andFDeviceTypeEqualTo(type);
		return bDeviceInfoMapper.selectByExample(example);
	}

	@Override
	public List<TManufacturer> queryManufacturer() {
		TManufacturerExample tManufacturerExample = new TManufacturerExample();
		tManufacturerExample.createCriteria().andFDeleteFlagNotEqualTo(true);
		List<TManufacturer> list = tManufacturerMapper.selectByExample(tManufacturerExample);
		return list;
	}

	@Override
	public int importExcel(List<TerminalDeviceVO> terminalDeviceList) {
		int count=0;
		if(!terminalDeviceList.isEmpty()){
			BDeviceInfo bDeviceInfo = new BDeviceInfo();
			for(int i=0;i<terminalDeviceList.size();i++){
				String s =terminalDeviceList.get(i).getfDeviceName();
				if(s==null){
					
				}else{
				String deviceTypeCode = terminalDeviceList.get(i).getfDeviceTypeCode();
				String locationCode = terminalDeviceList.get(i).getfLocationCode();
				String number = terminalDeviceList.get(i).getfNumber();
				if(deviceTypeCode.length()!=4||locationCode.length()!=12||number.length()!=2){
					//该条数据格式不正确，跳过
				}else{
				String deviceResourceCode = terminalDeviceList.get(i).getfDeviceTypeCode()+terminalDeviceList.get(i).getfLocationCode()+terminalDeviceList.get(i).getfNumber();
				bDeviceInfo.setfDeviceResourceCode(deviceResourceCode);
				bDeviceInfo.setfPhysicalCode(terminalDeviceList.get(i).getfPhysicalCode());
				bDeviceInfo.setfDeviceName(terminalDeviceList.get(i).getfDeviceName());
				bDeviceInfo.setfManufacturerInfo(terminalDeviceList.get(i).getfManufacturerInfo());
				bDeviceInfo.setfInstallAddress(terminalDeviceList.get(i).getfInstallAddress());
				bDeviceInfo.setfDeviceType((byte)1);
				bDeviceInfo.setfNumber(terminalDeviceList.get(i).getfNumber());
				Date time = new Date();
				bDeviceInfo.setfUpdateTime(time);
				bDeviceInfo.setfCreateTime(time);
				count+=bDeviceInfoMapper.insertSelective(bDeviceInfo);
			   }
			 }
			}
		}
		return count;
	}

	@Override
	public List<TerminalDeviceExportVO> queryTerminalExportDeviceInfo() {
		List<TerminalDeviceExportVO> deviceData = new ArrayList<TerminalDeviceExportVO>();
		try {
			deviceData = bDeviceInfoExtMapper.exportTerminalDeviceInfo();
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		return deviceData;
	}

	@Override
	public List<BDeviceInfoVo> selectDeviceForHandle(Map<String, Object> paramMap) {
		List<BDeviceInfoVo> deviceData = new ArrayList<BDeviceInfoVo>();
		try {
			deviceData = bDeviceInfoExtMapper.selectDeviceforhandle(paramMap);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		return deviceData;
	}

	@Override
	public Integer count(Integer fId) {
		BDeviceInfoExample example=new BDeviceInfoExample();
		example.createCriteria().andFLocationEqualTo(fId).andFDeviceTypeEqualTo((byte)1).andFDeleteFlagEqualTo(false);
		return bDeviceInfoMapper.selectByExample(example).size();
	}

	public List<String> getDeviceByConditions(Map<String, Object> map) {
		return bDeviceInfoExtMapper.getDeviceByConditions(map);
	}

	@Override
	public List<Map<String, Object>> getAllAdapter() {
		return bDeviceInfoExtMapper.getAllAdapters();
	}
}
