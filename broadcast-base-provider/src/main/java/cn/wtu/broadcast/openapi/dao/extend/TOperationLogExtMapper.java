package cn.wtu.broadcast.openapi.dao.extend;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.TOperationLog;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface TOperationLogExtMapper extends DBInterface<TOperationLog>{
	  List<TOperationLog> selectBySearchInfoAndTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime,@Param("searchInfo") String searchInfo);
}
