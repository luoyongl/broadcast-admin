package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.ReplyInstructionService;
import cn.wtu.broadcast.openapi.dao.BDeviceReturnInfoMapper;
import cn.wtu.broadcast.openapi.dao.BInstructionReplyStorageMapper;
import cn.wtu.broadcast.openapi.model.BDeviceReturnInfo;
import cn.wtu.broadcast.openapi.model.BDeviceReturnInfoExample;
import cn.wtu.broadcast.openapi.model.BInstructionReplyStorage;
import cn.wtu.broadcast.openapi.vo.ReplyInstructionVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

/**
 * 回传服务器存库接口实现类
 * @author yinjie
 *
 */

@Service
@Transactional
public class ReplyInstructionServiceImpl extends ParentServiceImpl<BInstructionReplyStorage> implements ReplyInstructionService{

	private static Logger logger = LoggerFactory.getLogger(ReplyInstructionServiceImpl.class);
	
	@Autowired
	private BInstructionReplyStorageMapper bInstructionReplyStorageMapper;
	
	@Autowired
	private BDeviceReturnInfoMapper bDeviceReturnInfoMapper;
	
	/**
	 * 回复服务器存库通用操作
	 */
	@Override
	public void addReplyInstructionToStorage(ReplyInstructionVO replyInstructionVO) {
		BInstructionReplyStorage bInstructionReplyStorage = new BInstructionReplyStorage();
		//包头标记
		bInstructionReplyStorage.setfHeadmark(replyInstructionVO.getfHeadmark());
		//协议版本号
		bInstructionReplyStorage.setfVersion(replyInstructionVO.getfVersion());
		//会话标识
		bInstructionReplyStorage.setfTag(replyInstructionVO.getfTag());
		//数据包类型
		bInstructionReplyStorage.setfPacktype(replyInstructionVO.getfPacktype());
		//数据源对象编码
		bInstructionReplyStorage.setfSource(replyInstructionVO.getfSource());
		//业务数据类型
		bInstructionReplyStorage.setfDatatype(replyInstructionVO.getfDatatype());
		//字符串格式下的json数据
		bInstructionReplyStorage.setfRespondInstructions(replyInstructionVO.getfRespondInstructions());
		try {
			bInstructionReplyStorageMapper.insertSelective(bInstructionReplyStorage);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}

	/**
	 * 回复服务器  查询指令应答 存库操作
	 */
	@Override
	public void addReplyInstructionToDeviceReturnInfo(BDeviceReturnInfo bDeviceReturnInfo) {
		try {
			bDeviceReturnInfo.setfCreateTime(new Date());
			bDeviceReturnInfoMapper.insertSelective(bDeviceReturnInfo);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}
	
	/**
	 * 回复服务器 删除操作(可以在查询的时候不进行重复显示)
	 */
	@Override
	public void deleteDataByResourceCode(String resourceCode) {
		BDeviceReturnInfoExample example = new BDeviceReturnInfoExample();
		example.createCriteria().andFResourceCodeEqualTo(resourceCode);
		List<BDeviceReturnInfo> infoList = bDeviceReturnInfoMapper.selectByExample(example);
		if (infoList.size() > 0) {
			try {
				for (BDeviceReturnInfo bDeviceReturnInfo : infoList) {
					bDeviceReturnInfo.setfDeleteFlag(true);
					bDeviceReturnInfoMapper.updateByPrimaryKeySelective(bDeviceReturnInfo);
				}
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}			
		}
	}
	
	@Override
	protected DBInterface<BInstructionReplyStorage> getDao() {
		return bInstructionReplyStorageMapper;
	}
	
}
