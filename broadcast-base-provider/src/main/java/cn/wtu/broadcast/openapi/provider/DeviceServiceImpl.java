package cn.wtu.broadcast.openapi.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.wtu.broadcast.openapi.api.DeviceService;
import cn.wtu.broadcast.openapi.dao.BTeletextTerminalMapper;
import cn.wtu.broadcast.openapi.model.BTeletextTerminal;
import cn.wtu.broadcast.openapi.model.BTeletextTerminalExample;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.parent.db.api.DBInterface;

@Service("deviceService")
public class DeviceServiceImpl extends ParentServiceImpl<TAdministrativeDivision> implements DeviceService{

	@Autowired
	private BTeletextTerminalMapper bTeletextTerminalMapper;
	@Override
	public List<BTeletextTerminal> selectAll() {
		BTeletextTerminalExample example=new BTeletextTerminalExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		List<BTeletextTerminal> list=  bTeletextTerminalMapper.selectByExample(example); 
		return list;
	}
	@Override
	protected DBInterface<TAdministrativeDivision> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
