package cn.wtu.broadcast.openapi.api;


import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BReview;
import cn.wtu.broadcast.openapi.vo.BReviewLogExcelVO;
import cn.wtu.broadcast.openapi.vo.BReviewVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface ReviewLogService extends ParentService<BReview> {
	
	/**
	 * 查询所有手动自动数据
	 * @param paramMap
	 * @return PageInfo<BReview>
	 * @author newlinfeng
	 */
	public PageInfo<BReviewVO> selectManualAutoLog(Map<String, Object> paramMap);
	
	/**
	 * 查询审核日志信息
	 * @param paramMap
	 * @return PageInfo<BReview>
	 * @author newlinfeng
	 */
	public List<BReviewLogExcelVO> selectReviewLogInfos(Map<String, Object> paramMap);
	
}
