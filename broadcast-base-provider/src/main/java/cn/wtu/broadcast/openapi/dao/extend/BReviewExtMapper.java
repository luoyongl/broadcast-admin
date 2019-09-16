package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BReview;
import cn.wtu.broadcast.openapi.vo.BReviewLogExcelVO;
import cn.wtu.broadcast.openapi.vo.BReviewVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BReviewExtMapper extends DBInterface<BReview>{

	List<BReviewVO> selectReviewAll(Map<String, Object> paramMap);

	/**
	 * 广播数据表、审核处理表、定时广播表的联合查询
	 * @param paramMap
	 * @return
	 */
	List<BReviewVO> selectByAllInfos(Map<String, Object> paramMap);
	
	/**
	 * 广播数据表、审核处理表、定时广播表的联合查询,日志导出表格
	 * @param paramMap
	 * @return
	 */
	List<BReviewLogExcelVO> selectReviewLogInfos(Map<String, Object> paramMap);
}
