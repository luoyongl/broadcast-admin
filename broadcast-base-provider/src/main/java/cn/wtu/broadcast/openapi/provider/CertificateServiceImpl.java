package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.CertificateService;
import cn.wtu.broadcast.openapi.dao.BCertificatesMapper;
import cn.wtu.broadcast.openapi.dao.BDeviceInfoMapper;
import cn.wtu.broadcast.openapi.dao.extend.BCertificatesExtMapper;
import cn.wtu.broadcast.openapi.model.BCertificates;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInfoExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BCertificatesVO;
import cn.wtu.broadcast.openapi.vo.CertificateImpVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("CertificateService")
public class CertificateServiceImpl extends ParentServiceImpl<BCertificates> implements CertificateService {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(CertificateServiceImpl.class);
	
	@Autowired
	private  BCertificatesExtMapper bCertificatesExtMapper;
	
	@Autowired
	private  BCertificatesMapper bCertificatesMapper;
	
	@Autowired
	private  BDeviceInfoMapper bDeviceInfoMapper;
	
	@Override
	public boolean insertOrUpdateCertificate(BCertificates bCertificates) {
		boolean result = false;
		TUser sessionUser = getSessionUser();
		Date time = new Date();
		if (bCertificates.getfId() != null) {
			bCertificates.setfOperatorId(sessionUser.getfId());
			bCertificates.setfUpdateTime(time);
			try {
				if (bCertificatesMapper.updateByPrimaryKeySelective(bCertificates) == 1) {
					result = true;
					insertLog(OperationLogTypeEnum.UPDATE, "修改证书信息", "成功");
				}
			}catch (Exception e){
				logger.error(e.getMessage(),e);
			}
		} else {
			bCertificates.setfCreatorId(sessionUser.getfId());
			bCertificates.setfCreateTime(time);
			try {
				if (bCertificatesMapper.insertSelective(bCertificates) == 1) {
					result = true;
					insertLog(OperationLogTypeEnum.INSERT, "新增证书信息", "成功");
				}
			}catch (Exception e){
				logger.error(e.getMessage(),e);
			}
		}
		return result;
	}

	@Override
	public int deleteByPrimaryKey(String[] idArr) {
		int result = 0;
		Date time = new Date();
		TUser sessionUser = getSessionUser();
		try {
			for (int i = 0; i < idArr.length; i++) {
				BCertificates bCertificates = new BCertificates();
				// 不确定 bBroadcastData.setfDeleteFlag(true);
				bCertificates.setfDeleteFlag(true);
				bCertificates.setfId(Integer.parseInt(idArr[i]));
				bCertificates.setfUpdateTime(time);
				bCertificates.setfOperatorId(sessionUser.getfId());
				result = result + bCertificatesMapper.updateByPrimaryKeySelective(bCertificates);
			}
			insertLog(OperationLogTypeEnum.DELETE, "删除证书", "删除了" + result + "个证书");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public PageInfo<BCertificatesVO> queryPage(Map<String, Object> paramMap) {
		PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
		List<BCertificatesVO> certificatesData = new ArrayList<BCertificatesVO>();
		try {
			certificatesData = bCertificatesExtMapper.selecteCertificatesVO(paramMap);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		return new PageInfo<>(certificatesData);
	}

	@Override
	protected DBInterface<BCertificates> getDao() {
		return bCertificatesMapper;
	}

	@Override
	public int importExcel(List<CertificateImpVO> list) {
		int count=0;
		try {
			if(!list.isEmpty()){
				BCertificates certificate = new BCertificates();
				BDeviceInfoExample example = new BDeviceInfoExample();
				//小于等于终端设备编号 包括前端和终端设备
				example.createCriteria().andFDeleteFlagNotEqualTo(true).andFDeviceTypeLessThanOrEqualTo((byte)DeviceTypeEnum.terminalDevice.getCode());
				List<BDeviceInfo> allDevice = bDeviceInfoMapper.selectByExample(example);
				for(int i=0;i<list.size();i++){
					int flag=0;
					int thisId=0;
					String thisDeviceName = list.get(i).getfDeviceName();
					if(!thisDeviceName.isEmpty()&&thisDeviceName!=""){
						for(int j=0;j<allDevice.size();j++){
							if(thisDeviceName.equals(allDevice.get(j).getfDeviceName())){
								flag=1;
								thisId=allDevice.get(j).getfId();
								break;
							}
						}
						if(flag==1&&thisId!=0){
							certificate.setfCertificatesNumber(list.get(i).getfCertificatesNumber());
							certificate.setfDeviceId(thisId);
							certificate.setfPrivateKey(list.get(i).getfPrivateKey());
							certificate.setfPublicKey(list.get(i).getfPublicKey());
							certificate.setfRemark(list.get(i).getfRemark());
							String certificatesPeriodOfValidity = list.get(i).getfDateOfValidity();
							if (certificatesPeriodOfValidity != null && certificatesPeriodOfValidity != "") {
								String date[] = certificatesPeriodOfValidity.split("至");
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
								certificate.setfStartDateOfValidity(dateFormat.parse(date[0]));
								certificate.setfEndDateOfValidity(dateFormat.parse(date[1]));
							}
							count+=bCertificatesMapper.insertSelective(certificate);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return count;
	}

	@Override
	public List<String> queryDeviceNames() {
		BDeviceInfoExample example = new BDeviceInfoExample();
		//小于等于终端设备编号 包括前端和终端设备
		example.createCriteria().andFDeleteFlagNotEqualTo(true).andFDeviceTypeLessThanOrEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
		List<BDeviceInfo> allDevice = new ArrayList<BDeviceInfo>();
		List<String> allDeviceName = new ArrayList<>();
		try {
			allDevice = bDeviceInfoMapper.selectByExample(example);
		for (int i = 0; i < allDevice.size(); i++) {
			allDeviceName.add(allDevice.get(i).getfDeviceName());
		}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return allDeviceName;
	}

	@Override
	public Integer countByCode(String code) {
		BDeviceInfoExample example=new BDeviceInfoExample();
		example.createCriteria().andFDeleteFlagEqualTo(false).andFDeviceResourceCodeEqualTo(code);
		return bDeviceInfoMapper.selectByExample(example).size();
	}
}
