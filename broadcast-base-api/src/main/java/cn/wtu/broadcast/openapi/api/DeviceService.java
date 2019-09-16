package cn.wtu.broadcast.openapi.api;

import java.util.List;
import cn.wtu.broadcast.openapi.model.BTeletextTerminal;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface DeviceService extends ParentService<TAdministrativeDivision> {
	
	public List<BTeletextTerminal> selectAll();

}
