package cn.wtu.broadcast.openapi.api;

/**
 * 参数设置数据交互接口
 * @author yinjie
 */

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceOutputChannel;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.openapi.model.BDeviceRdsSet;
import cn.wtu.broadcast.openapi.model.BDeviceTerminalStatusQuery;
import cn.wtu.broadcast.openapi.vo.BWhitelistNewVO;
import cn.wtu.broadcast.parent.dto.IpOrPortInParameterStatusDto;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface ParameterConfigurationService extends ParentService<BDeviceParameterSet> {
	
	//查找适配器参数
	public BDeviceParameterSet findParameterSet(String resourceCode);
	
	//查找适配器表
	public BDeviceInfo findDeviceInfo(String resourceCode);
	
	//更新或插入音量数据
	public int updateOrInsertVolumeToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,Integer column,String resourceCode);
	
	//更新或插入功放开关值
	public int updateOrInsertSwitchNumberToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,Integer switchNumber,String resourceCode);
	
	//更新或插入回传地址
	public int updateOrInsertReturnAddressToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,String resourceCode,String returnIpValue,String returnPortValue);
	
	//更新或插入回传周期
	public int updateOrInsertReturnCycleToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,Integer datetime,String resourceCode);
	
	//更新或插入设置IP地址
	public int updateOrInsertIpAddressToBDeviceParameterSet(BDeviceParameterSet bDeviceParameterSet,
			String resourceCode,String ipAddressValue,String subnetMask,String ipGate);

	//增加RDS设置
	public int addRdsToDdeviceRdsSet(String resourceCode,Integer rdsPriority,Double rdsFrequency);
	
	//更新RDS设置
	public int updateRdsToDdeviceRdsSet(Integer rdsId,Integer rdsPriority,Double rdsFrequency);
	
	//删除RDS设置
	public int deleteRdsToDdeviceRdsSet(Integer rdsId);
	
	//RDS设置频点(删除) 注:这里使用资源编码对新增操作进行业务修改(以原先做法，会出现重复回显的情况)
	public int deleteRdsByResourceCode(String resourceCode);
	
	//根据资源编码查询RDS
	public List<BDeviceRdsSet> findBDeviceRdsSetByCode(String resourceCode);
	
	//增加TS设置
	public int addRdsToDdeviceTsSet(BDeviceParameterSet bDeviceParameterSet,String resourceCode,Integer frequency,Integer symbolRate,Integer QamNumber);
	
	//获取输入通道
	public List<BDeviceInputChannel> findInputChannelList(String resourceCode);
	
	//获取输入通道
	public List<BDeviceOutputChannel> findOutputChannelList(String resourceCode);
	
	//查询回复通道
	public BDeviceTerminalStatusQuery findParamResponse(String resourceCode);
	
	//更新或插入资源编码设置
	public int insertOrUpdateCodes(BDeviceParameterSet bDeviceParameterSet,String resourceCode);
	
	//更新或插入查询状态(状态类型)
	public int insertOrUpdateParameterStatus(BDeviceParameterSet bDeviceParameterSet,String resourceCode,String queryCodes);
	
	// 查询状态参数  目的：判断不同设备的回传IP和端口是否相同
	public IpOrPortInParameterStatusDto ipOrPortInParameterStatus(List<String> resourceCodes);
	
	/**
	 * 白名单更新  (新增)
	 * 1操作类型(增删改) 2账号  3姓名  4电话号码  5授权方式  6授权区域   7资源编码  8白名单id(删除)
	 * @param operCode
	 * @param account
	 * @param name
	 * @param phoneNumber
	 * @param permit
	 * @param areaCode
	 * @param sourceCode
	 * @return
	 */
	public int addWhiteList(int operCode,String account,String name,String phoneNumber,int permit,String areaCode,String resourceCode);

	//更新白名单操作(删除)
	public int deleteWhiteList(int id);
	
	//更新白名单查询操作
	public PageInfo<BWhitelistNewVO> queryPage(Map<String, Object> paramMap);
	
	//时钟校准
	public int addOrUpdateCalibrationTime(BDeviceParameterSet bDeviceParameterSet,String resourceCode);
}
