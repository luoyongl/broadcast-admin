package cn.wtu.broadcast.openapi.dao.extend;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BDeviceTerminalStatusQuery;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BDeviceTerminalStatusQueryExtMapper extends DBInterface<BDeviceTerminalStatusQuery>{	
	//查询回复通道
	BDeviceTerminalStatusQuery findParamResponse(@Param("resourceCode")String resourceCode);
}
