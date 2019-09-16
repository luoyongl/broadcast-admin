package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BDeviceReturnInfo;
import cn.wtu.broadcast.openapi.model.BInstructionReplyStorage;
import cn.wtu.broadcast.openapi.vo.ReplyInstructionVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * 回传服务器存库接口
 * @author yinjie
 *
 */

public interface ReplyInstructionService extends ParentService<BInstructionReplyStorage>{
	
	/**
	 * 回复服务器存库通用操作
	 */
	public void addReplyInstructionToStorage(ReplyInstructionVO replyInstructionVO);
	
	/**
	 * 回复服务器  查询指令应答 存库操作
	 */
	public void addReplyInstructionToDeviceReturnInfo(BDeviceReturnInfo bDeviceReturnInfo);
	
	/**
	 * 回复服务器 删除操作(可以在查询的时候不进行重复显示)
	 */
	public void deleteDataByResourceCode(String resourceCode);
}
