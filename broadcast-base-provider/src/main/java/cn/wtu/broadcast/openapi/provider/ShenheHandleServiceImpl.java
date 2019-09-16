package cn.wtu.broadcast.openapi.provider;


import cn.wtu.broadcast.openapi.api.ShenheHandleService;
import cn.wtu.broadcast.openapi.dao.BReviewMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastTimingExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.BReviewExtMapper;
import cn.wtu.broadcast.openapi.model.BReview;
import cn.wtu.broadcast.openapi.model.BReviewExample;
import cn.wtu.broadcast.openapi.model.BReviewExample.Criteria;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BReviewVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("shenheHandleService")
public class ShenheHandleServiceImpl extends ParentServiceImpl<BReview>  implements ShenheHandleService{
	private static Logger logger = LoggerFactory.getLogger(ShenheHandleServiceImpl.class);
	
	@Autowired
	BReviewMapper bReviewMapper;
	
	@Autowired
	BReviewExtMapper bReviewExtMapper;
	
	@Autowired
	BBroadcastTimingExtMapper bBroadcastTimingExtMapper;
	
	
	@Override
	protected DBInterface<BReview> getDao() {
		
		return null;
	}
	
	/**
	 * @Desc 查询手动审核信息
	 * @Author Li LinFeng
	 * @Date 2019-1-1
	 */
	@Override
	public PageInfo<BReviewVO> selectManualShenheHandle(Map<String, Object> paramMap) {
		PageInfo<BReviewVO> result = null;
		try {
			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
			
			
			
			List<BReviewVO> bReviews = bReviewExtMapper.selectByAllInfos(paramMap);
			if(bReviews != null){
				result = new PageInfo<>(bReviews);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return result;
	}

	/**
	 * @Desc 更新审核信息表的状态
	 * @Author Li LinFeng
	 * @Date 2019-1-2
	 */
	@Override
	public boolean updateByFId(BReview bReview) {
		
		TUser tUser = getSessionUser();
		bReview.setfReviewer(tUser.getfId());
		try {
			int count = bReviewMapper.updateByPrimaryKeySelective(bReview);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return false;
	}

	/**
	 * @Desc 根据fId查询该条数据
	 * @Author Li LinFeng
	 * @Date 2019-1-2
	 */
	@Override
	public BReview selectByFId(Integer fId) {
		BReviewExample bReviewExample = new BReviewExample();
		Criteria criteria = bReviewExample.createCriteria();
		criteria.andFIdEqualTo(fId);
		
		List<BReview> bReview =  bReviewMapper.selectByExample(bReviewExample);
		
		return bReview.get(0);
	}
	
	/**
	 * @Desc 根据fId查询该条数据
	 * @Author Li LinFeng
	 * @Date 2019-1-2
	 */
	@Override
	public BReview selectByFReviewObjectId(Integer fReviewObjectId) {
		BReviewExample bReviewExample = new BReviewExample();
		Criteria criteria = bReviewExample.createCriteria();
		criteria.andFReviewObjectIdEqualTo(fReviewObjectId);
		List<BReview> bReview =  bReviewMapper.selectByExample(bReviewExample);
		
		return bReview.get(0);
	}
	
	/**
	 * @Desc 此方法已经作废(广播数据插入到待审核列表中)，请使用addReviewThinkUserRole()方法
	 * @Author Li LinFeng
	 * @Date 2019-1-1
	 */
	@Override
	public boolean addReview(BReview bReview) {
		
	
		try {
			int count = bReviewMapper.insertSelective(bReview);
			if(count > 0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return false;
	}
	

	/**
	 * @Desc 广播数据插入到待审核列表中
	 * @Author Li LinFeng
	 * @Date 2019-1-14
	 */
	@Override
	public boolean addReviewThinkUserRole(BReview bReview, Byte state) {
		TUser tUser = getSessionUser();
		if(tUser.getfIsAuditAutomatic()==true){
			bReview.setfReviewResult(state);
		}
		
		try {
			int count = bReviewMapper.insertSelective(bReview);
			if(count > 0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return false;
	}

}
