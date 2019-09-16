package cn.wtu.broadcast.openapi.dao.extend;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BDeviceParameterSetExtMapper extends DBInterface<BDeviceParameterSet>{	
	//查找适配器参数
	public BDeviceParameterSet findParameterSet(@Param("resourceCode") String resourceCode);
	
	//查找适配器表
	public BDeviceInfo findDeviceInfo(@Param("resourceCode") String resourceCode);
	
}
