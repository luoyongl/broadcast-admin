package cn.wtu.broadcast.openapi.api;

import java.util.List;

import cn.wtu.broadcast.openapi.model.BTeletextTerminal;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface BTeletextTerminalService extends ParentService<BTeletextTerminal>{
	public Boolean addTerminal(BTeletextTerminal bTeletextTerminal);
	
	public List<BTeletextTerminal> selectAll();
	
	public Boolean updateTerminal(BTeletextTerminal bTeletextTerminal);
	
	public int deleteimgTextTerminal(String id);

	public Boolean checkTextTerminal(String title);
}
