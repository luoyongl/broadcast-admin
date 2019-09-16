package cn.wtu.broadcast.openapi.api;


import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BReview;
import cn.wtu.broadcast.openapi.vo.BReviewVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface ShenheHandleService  extends ParentService<BReview> {
	
	
	public PageInfo<BReviewVO> selectManualShenheHandle(Map<String, Object> paramMap);

	public boolean updateByFId(BReview bReview);

	public BReview selectByFId(Integer fId);
	
	/**
	 * 添加数据到审核表中，该方法已经作废，请使用addReviewThinkUserRole()
	 * @param bReview
	 * @return
	 * @date 2019-01-02
	 * @Author LiLinFeng
	 */
	public boolean addReview(BReview bReview);
	

	/**
	 * 添加数据到审核表中,考虑了角色权限
	 * @param bReview
	 * @return
	 * @date 2019-01-14
	 * @Author LiLinFeng
	 */
	public boolean addReviewThinkUserRole(BReview bReview, Byte state);

	public BReview selectByFReviewObjectId(Integer fReviewObjectId);
}
