package cn.wtu.broadcast.openapi.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.TaskReportInstructionService;
import cn.wtu.broadcast.openapi.dao.BBroadcastDataMapper;
import cn.wtu.broadcast.openapi.dao.BInstructionSendreplyStorageMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastData;
import cn.wtu.broadcast.openapi.model.BInstructionSendreplyStorage;
import cn.wtu.broadcast.openapi.vo.TaskReportInstructionVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * 任务上报接口实现
 * @author yinjie
 * 这里因为有特殊用法，就不在api中写接口interface
 *
 */

@Service
@Transactional
public class TaskReportInstructionServiceImpl extends ParentServiceImpl<BInstructionSendreplyStorage> implements TaskReportInstructionService{

	private static Logger logger = LoggerFactory.getLogger(TaskReportInstructionServiceImpl.class);
	
	@Autowired
	private BInstructionSendreplyStorageMapper bInstructionSendreplyStorageMapper;
	
	@Autowired
	private BBroadcastDataMapper bBroadcastDataMapper;
	/**
	 * 任务上报回复入库实现
	 * @param protocolReplyCommonData
	 */
	@Override
	public void taskReturnToStorage(TaskReportInstructionVO taskReportInstructionVO){
		//转为json字符串
		BInstructionSendreplyStorage instructionSend = new BInstructionSendreplyStorage();
		
		instructionSend.setfRespondInstructions(taskReportInstructionVO.getProtocolReply());
		try {
			bInstructionSendreplyStorageMapper.insertSelective(instructionSend);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
		//下面需要向广播表进行数据insert
		BBroadcastData broadcastData = new BBroadcastData();
		//a :23个数字码 --> 设备广播对应设备id
		broadcastData.setfDeviceResourcecode(taskReportInstructionVO.getDeviceResourcecode());
		//b: 应急广播类型 --> 广播类型：枚举（应急，日常等等）
		broadcastData.setfBroadcastType(Byte.valueOf(taskReportInstructionVO.getBroadcastType()));
		//c:应急广播事件级别 -->消息级别（字典id）
		broadcastData.setfMessageLevel(Integer.valueOf(taskReportInstructionVO.getMessageLevel()));
		//d:应急广播事件类型 -->消息类型（字典id）
		broadcastData.setfMessageType(Integer.valueOf(taskReportInstructionVO.getMessageType()));
		//e:program_resource --> 消息来源（枚举）
		broadcastData.setfMessageSource(Integer.valueOf(taskReportInstructionVO.getMessageSource()));
		
		//存入广播表
		try {
			bBroadcastDataMapper.insertSelective(broadcastData);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
	}
	
	@Override
	protected DBInterface<BInstructionSendreplyStorage> getDao() {
		return bInstructionSendreplyStorageMapper;
	}
}
