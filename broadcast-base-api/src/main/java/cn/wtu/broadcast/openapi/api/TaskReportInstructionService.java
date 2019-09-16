package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BInstructionSendreplyStorage;
import cn.wtu.broadcast.openapi.vo.TaskReportInstructionVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * 任务上报接口
 * @author yinjie
 *
 */
public interface TaskReportInstructionService extends ParentService<BInstructionSendreplyStorage>{
	
	/**
	 * 任务上报回复入库实现
	 * @param protocolReplyCommonData
	 */
	public void taskReturnToStorage(TaskReportInstructionVO taskReportInstructionVO);
}
