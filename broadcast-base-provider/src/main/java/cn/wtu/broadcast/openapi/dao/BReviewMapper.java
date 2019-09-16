package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BReview;
import cn.wtu.broadcast.openapi.model.BReviewExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BReviewMapper extends DBInterface<BReview>{
    int countByExample(BReviewExample example);

    int deleteByExample(BReviewExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BReview record);

    int insertSelective(BReview record);

    List<BReview> selectByExample(BReviewExample example);

    BReview selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BReview record, @Param("example") BReviewExample example);

    int updateByExample(@Param("record") BReview record, @Param("example") BReviewExample example);

    int updateByPrimaryKeySelective(BReview record);

    int updateByPrimaryKey(BReview record);
}