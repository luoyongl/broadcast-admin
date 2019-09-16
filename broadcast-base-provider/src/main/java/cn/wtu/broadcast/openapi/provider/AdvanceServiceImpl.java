package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.AdvanceService;
import cn.wtu.broadcast.openapi.dao.BBroadcastDataMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastData;
import cn.wtu.broadcast.openapi.model.BBroadcastDataExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("advanceService")
public class AdvanceServiceImpl extends ParentServiceImpl<BBroadcastData> implements AdvanceService {

	private final BBroadcastDataMapper bBroadcastDataMapper;

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(AdvanceServiceImpl.class);

	private final BBroadcastDataExtMapper bBroadcastDataExtMapper;

	@Autowired
	public AdvanceServiceImpl(BBroadcastDataMapper bBroadcastDataMapper,
			BBroadcastDataExtMapper bBroadcastDataExtMapper) {
		this.bBroadcastDataMapper = bBroadcastDataMapper;
		this.bBroadcastDataExtMapper = bBroadcastDataExtMapper;
	}

	@Override
	protected DBInterface<BBroadcastData> getDao() {
		return bBroadcastDataMapper;
	}

	/**
	 * 新增或更新预案信息 bBroadcastData
	 */
	@Override
	public boolean insertOrUpdateAdvance(BBroadcastData bBroadcastData) {
		boolean result = false;
		TUser sessionUser = getSessionUser();
		int a = (sessionUser.getfRespectiveRegion());
		bBroadcastData.setfMessageSource(a);
		Date time = new Date();
		try {
			if (bBroadcastData.getfId() != null) {
				//若为待审核状态，说明广播类型已减6转换为了真正的类型码，则修改时也要将从页面得到的类型码减6
				if(bBroadcastData.getfState() == BroadcastStateEnum.waitReview.getCode()){
					bBroadcastData.setfBroadcastType((byte)(bBroadcastData.getfBroadcastType()-6));
				}
				bBroadcastData.setfOperatorId(sessionUser.getfId());
				bBroadcastData.setfUpdtateTime(time);
				if (bBroadcastDataMapper.updateByPrimaryKeySelective(bBroadcastData) == 1) {
					result = true;
					insertLog(OperationLogTypeEnum.UPDATE, "修改广播预案", "成功");
				}
			} else {
				bBroadcastData.setfCreateId(sessionUser.getfId());
				bBroadcastData.setfDeleteFlag(false);
				bBroadcastData.setfCreateTime(time);
				if (bBroadcastDataMapper.insertSelective(bBroadcastData) == 1) {
					result = true;
					insertLog(OperationLogTypeEnum.INSERT, "新增广播预案", "成功");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 取消
	 */
	@Override
	public int deleteByPrimaryKey(String[] advanceIdArr, int cancelledState) {
		int result = 0;
		Date time = new Date();
		TUser sessionUser = getSessionUser();
		try {
			for (int i = 0; i < advanceIdArr.length; i++) {
				BBroadcastData bBroadcastData = new BBroadcastData();
				// 不确定 bBroadcastData.setfDeleteFlag(true);
				bBroadcastData.setfState((byte) cancelledState);
				bBroadcastData.setfId(Integer.parseInt(advanceIdArr[i]));
				bBroadcastData.setfUpdtateTime(time);
				bBroadcastData.setfOperatorId(sessionUser.getfId());
				result = result + bBroadcastDataMapper.updateByPrimaryKeySelective(bBroadcastData);
			}
			insertLog(OperationLogTypeEnum.DELETE, "删除广播预案", "删除了" + result + "个广播预案");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;

	}

	/**
	 * 后台分页查询
	 * 
	 * @return PageInfo<BroadCastDataVO>
	 */
	@Override
	public PageInfo<BroadCastDataVO> queryPage(Map<String, Object> paramMap) throws BizException {
		int a = (Integer) paramMap.get("pageNumber");
		int b = (Integer) paramMap.get("pageSize");
		// a=(a/b)+1; //将从第几条记录开始转化为页码数
		PageHelper.startPage(a, b);
		List<BroadCastDataVO> advanceData = new ArrayList<>();
		try {
			advanceData = bBroadcastDataExtMapper.selectBroadCastAdvance(paramMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new PageInfo<>(advanceData);
	}

	@Override
	public List<String> selectAllAdvanceName() {
		BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
		BBroadcastDataExample.Criteria selectAllAdvanceName = bBroadcastDataExample.createCriteria();
		selectAllAdvanceName.andFBroadcastNameIsNotNull().andFDeleteFlagNotEqualTo(true);
		List<BBroadcastData> advanceData = new ArrayList<>();
		List<String> advanceName = new ArrayList<>();
		try {
			advanceData = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		for (int i = 0; i < advanceData.size(); i++) {
			advanceName.add(advanceData.get(i).getfBroadcastName());
		}
		return advanceName;
	}

	@Override
	public BroadcastResult submitReview(BBroadcastData bBroadcastData) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override
	 * 
	 * @Transactional(rollbackFor = Exception.class) public BroadcastResult
	 * submitReview(BBroadcastData bBroadcastData) { Byte broadcastType =
	 * bBroadcastData.getfBroadcastType(); Byte RealBroadcastType =
	 * (byte)(broadcastType-6); TUser sessionUser = getSessionUser(); BReview
	 * bReview = new BReview();
	 * bReview.setfReviewObjectId(bBroadcastData.getfId());
	 * bReview.setfReviewType(RealBroadcastType); BroadcastResult
	 * broadcastResult = new BroadcastResult(); try {
	 * if(sessionUser.getfIsAuditAutomatic()==true){
	 * bBroadcastData.setfState((byte)BroadcastStateEnum.waitBroadcast.getCode()
	 * ); int temp = advanceService.updateByPrimaryKeySelective(bBroadcastData);
	 * if(temp == 1){
	 * bReview.setfBigClassification((byte)BigClassificationEnum.automatic.
	 * getCode());
	 * bReview.setfReviewResult((byte)ReviewResultEnum.waitBroading.getCode());
	 * bReview.setfRemark("自动审核权限测试"); boolean review_flag =
	 * shenheHandleService.addReview(bReview); if(review_flag){ broadcastResult
	 * = BroadcastResult.build(200, temp + "条预案已自动审核并提交到待播发列表"); }else{
	 * broadcastResult = BroadcastResult.fail(); } }else{ broadcastResult =
	 * BroadcastResult.fail(); } }else{ if(RealBroadcastType ==
	 * (byte)BroadcastTypeEnum.emergency.getCode()){
	 * bBroadcastData.setfState((byte)BroadcastStateEnum.waitBroadcast.getCode()
	 * ); int temp = advanceService.updateByPrimaryKeySelective(bBroadcastData);
	 * if(temp == 1){
	 * bReview.setfBigClassification((byte)BigClassificationEnum.automatic.
	 * getCode());
	 * bReview.setfReviewResult((byte)ReviewResultEnum.waitBroading.getCode());
	 * bReview.setfRemark("应急预案测试"); boolean review_flag =
	 * shenheHandleService.addReview(bReview); if(review_flag){ broadcastResult
	 * = BroadcastResult.build(200, temp + "条应急广播预案已提交到待播发列表"); }else{
	 * broadcastResult = BroadcastResult.fail(); } }else{ broadcastResult =
	 * BroadcastResult.fail(); } }else{ String broadcastType1="";
	 * bBroadcastData.setfState((byte) BroadcastStateEnum.waitReview.getCode());
	 * int temp = advanceService.updateByPrimaryKeySelective(bBroadcastData);
	 * if(temp == 1){
	 * bReview.setfBigClassification((byte)BigClassificationEnum.manual.getCode(
	 * ));
	 * bReview.setfReviewResult((byte)ReviewResultEnum.waitReview.getCode());
	 * bReview.setfRemark("其他预案测试"); boolean review_flag =
	 * shenheHandleService.addReview(bReview); if(review_flag){
	 * if(RealBroadcastType==((byte)BroadcastTypeEnum.practical.getCode())){
	 * broadcastType1="实际演练"; }else
	 * if(RealBroadcastType==((byte)BroadcastTypeEnum.simulate.getCode())){
	 * broadcastType1="模拟演练"; }else
	 * if(RealBroadcastType==((byte)BroadcastTypeEnum.system.getCode())){
	 * broadcastType1="系统演练"; }else{ broadcastType1="日常广播"; } broadcastResult =
	 * BroadcastResult.build(200, temp + "条"+broadcastType1+"预案已提交到待审核列表");
	 * }else{ broadcastResult = BroadcastResult.fail(); } } } } } catch
	 * (Exception e) { logger.error(e.getMessage(), e); } return
	 * broadcastResult; }
	 */
}
