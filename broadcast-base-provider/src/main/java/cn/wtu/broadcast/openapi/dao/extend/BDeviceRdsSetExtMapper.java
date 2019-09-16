package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BDeviceRdsSet;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BDeviceRdsSetExtMapper extends DBInterface<BDeviceRdsSet>{	
	//根据资源编码查询RDS
	List<BDeviceRdsSet> findBDeviceRdsSetByCode(@Param("resourceCode")String resourceCode);
}
