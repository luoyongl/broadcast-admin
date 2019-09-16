package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.BProgramChannelService;
import cn.wtu.broadcast.openapi.dao.BProgramChannelMapper;
import cn.wtu.broadcast.openapi.dao.extend.BProgramChannelExtMapper;
import cn.wtu.broadcast.openapi.model.BProgramChannel;
import cn.wtu.broadcast.openapi.model.BProgramChannelExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BProgramChannelVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 节目制作service层实现方法
 * @author AYY
 *
 */
@Service("bProgramChannelService")
public class BProgramChannelServiceImpl extends ParentServiceImpl<BProgramChannel> implements BProgramChannelService{

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(AudioManageServiceImpl.class);

	private final BProgramChannelMapper bProgramChannelMapper;

	private final BProgramChannelExtMapper bProgramChannelExtMapper;

	@Autowired
	public BProgramChannelServiceImpl(BProgramChannelMapper bProgramChannelMapper, BProgramChannelExtMapper bProgramChannelExtMapper) {
		this.bProgramChannelMapper = bProgramChannelMapper;
		this.bProgramChannelExtMapper = bProgramChannelExtMapper;
	}

	@Override
	protected DBInterface<BProgramChannel> getDao() {
		return bProgramChannelMapper;
	}

	@Override
	@Transactional(rollbackFor = {Exception.class})
	public int deleteProgramByIds(List<Integer> idList) {
    	int result = 0;
		Date date = new Date();
		TUser sessionUser = getSessionUser();
		for(Integer id:idList){
			BProgramChannel bProgramChannel = new BProgramChannel();
			bProgramChannel.setfId(id);
			bProgramChannel.setfUpdateTime(date);
			bProgramChannel.setfDeleteFlag(true);
			bProgramChannel.setfOperatorId(sessionUser.getfId());
			try{
				result += bProgramChannelMapper.updateByPrimaryKeySelective(bProgramChannel);
			}catch (Exception e){
				logger.error(e.getMessage(),e);
			}

		}
		insertLog(OperationLogTypeEnum.DELETE,"删除节目通道","删除了"+result+"个节目通道");
		return result;
	}

	@Override
	public boolean addProgramChannel(BProgramChannel bProgramChannel) {

		Date date = new Date();
		TUser sessionUser = getSessionUser();
		bProgramChannel.setfCreateTime(date);
		bProgramChannel.setfUpdateTime(date);
		bProgramChannel.setfOperatorId(sessionUser.getfId());
		bProgramChannel.setfCreatorId(sessionUser.getfId());
		bProgramChannel.setfDeleteFlag(false);
		int i = 0;
		try{
			i = bProgramChannelMapper.insertSelective(bProgramChannel);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		if(i==1){
			insertLog(OperationLogTypeEnum.INSERT,"新增节目通道","新增了1个节目通道");
			return true;
		}else{
			insertLog(OperationLogTypeEnum.INSERT,"新增节目通道","新增失败");
			return false;
		}

	}

	@Override
	public boolean updateProgramChannel(BProgramChannel bProgramChannel,String fId) {

    	bProgramChannel.setfOperatorId(getSessionUser().getfId());
    	bProgramChannel.setfUpdateTime(new Date());
    	bProgramChannel.setfId(Integer.parseInt(fId));

		int i = 0;
		try{
			i = bProgramChannelMapper.updateByPrimaryKeySelective(bProgramChannel);
		}catch (Exception e){
			logger.error(e.getMessage());
		}
		if(i==1){
			insertLog(OperationLogTypeEnum.INSERT,"修改节目通道","修改了1个节目通道");
			return true;
		}else{
			insertLog(OperationLogTypeEnum.INSERT,"修改节目通道","修改失败");
			return false;
		}
	}

	@Override
	public List<BProgramChannel> getAll() {
		BProgramChannelExample example = new BProgramChannelExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		example.setOrderByClause("f_create_time desc");
		List<BProgramChannel> bProgramChannels = null;
		try{
			bProgramChannels = bProgramChannelMapper.selectByExample(example);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}

		return bProgramChannels;
	}

	@Override
	public PageInfo<BProgramChannelVO> queryPageByParams(Map<String, Object> paramMap) throws BizException {
		PageHelper.startPage((Integer) paramMap.get("pageNo"),(Integer) paramMap.get("pageSize"));
		List<BProgramChannelVO> bProgramChannels = null;
		try {
			bProgramChannels =  bProgramChannelExtMapper.selectProgramList(paramMap);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		return new PageInfo<>(bProgramChannels);
	}


}
