package cn.wtu.broadcast.openapi.provider;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.ReviewLogService;
import cn.wtu.broadcast.openapi.dao.BReviewMapper;
import cn.wtu.broadcast.openapi.dao.extend.BReviewExtMapper;
import cn.wtu.broadcast.openapi.model.BReview;
import cn.wtu.broadcast.openapi.vo.BReviewLogExcelVO;
import cn.wtu.broadcast.openapi.vo.BReviewVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;


@Service("ReviewLogService")
public class ReviewLogServiceImpl extends ParentServiceImpl<BReview>  implements ReviewLogService{
	private static Logger logger = LoggerFactory.getLogger(ReviewLogServiceImpl.class);
	
	@Autowired
	BReviewMapper bReviewMapper;
	
	@Override
	protected DBInterface<BReview> getDao() {
		return null;
	}
	
	@Autowired
	private BReviewExtMapper reviewExtMapper;
	
	/**
	 * 查询所有自动手动数据
	 * 
	 */
	@Override
	public PageInfo<BReviewVO> selectManualAutoLog(Map<String, Object> paramMap) {
		PageInfo<BReviewVO> result = null;
		try {
			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
			/*BReviewExample bReviewExample = new BReviewExample();
			Criteria criteria = bReviewExample.createCriteria();
			criteria.andFIdIsNotNull();*/
			//List<BReview> bReviews = bReviewMapper.selectByExample(bReviewExample);
			List<BReviewVO> bReviews = reviewExtMapper.selectReviewAll(paramMap);
			if(bReviews != null){
				result = new PageInfo<>(bReviews);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		return result;
	}

	@Override
	public List<BReviewLogExcelVO> selectReviewLogInfos(Map<String, Object> paramMap) {
		List<BReviewLogExcelVO> bList = null;
		try {
			bList = reviewExtMapper.selectReviewLogInfos(paramMap);
		}catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
		return bList;
	}


}
