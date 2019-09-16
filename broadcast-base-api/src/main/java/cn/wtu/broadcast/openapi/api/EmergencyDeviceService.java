package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.openapi.vo.BDeviceInfoVo;
import cn.wtu.broadcast.openapi.vo.FrontDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.TerminalDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.TerminalDeviceVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface EmergencyDeviceService extends ParentService<BDeviceInfo>{

	public PageInfo<BDeviceInfoVo> queryDevicePage(Map<String, Object> paramMap);

	public boolean insertOrUpdateDevice(BDeviceInfo bDeviceInfo);

	public int deleteAllByPrimaryKey(String[] ids);

	
	public List<TAdministrativeDivision> queryDivision();

	
	public List<BDeviceInfo> selectDeviceForTelList(Byte type);
	
	public List<TManufacturer> queryManufacturer();
	
	public int importExcel(List<TerminalDeviceVO> terminalDeviceList);

	List<TerminalDeviceExportVO> queryTerminalExportDeviceInfo();

	List<FrontDeviceExportVO> queryFrontExportDeviceInfo();

	List<BDeviceInfoVo> selectDeviceForHandle(Map<String, Object> paramMap);

	/**
	 * 查询音柱数量
	 * @param fId 区域id
	 * @return 音柱数目
	 */
	public Integer count(Integer fId);

	public List<String> getDeviceByConditions(Map<String, Object> map);
	
	public List<Map<String, Object>> getAllAdapter();
	
}
