package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wtu.broadcast.openapi.api.BServerRuntimeInfoService;
import cn.wtu.broadcast.openapi.dao.BServerRuntimeInfoMapper;
import cn.wtu.broadcast.openapi.model.BServerRuntimeInfo;
import cn.wtu.broadcast.openapi.model.BServerRuntimeInfoExample;

@Service("bServerRuntimeInfoService")
public class BServerRuntimeInfoServiceImpl implements BServerRuntimeInfoService {
	
	private Logger logger = LoggerFactory.getLogger(BServerRuntimeInfoServiceImpl.class);
	
	@Autowired
	private BServerRuntimeInfoMapper bServerRuntimeInfoMapper;

	/**
	 * serverType null:所有   1：调控服务器  2：回传服务器 3：省级平台解析服务器   0：离线  1：在线
	 * serverState 0：离线   1：在线
	 */
	@Override
	public void updateBServerRuntimeInfoByType(Integer serverType, Integer serverState) {
		try {
			BServerRuntimeInfoExample example = new BServerRuntimeInfoExample();
			if(serverType != null){
				example.createCriteria().andFServerTypeEqualTo(serverType);	
			}
			List<BServerRuntimeInfo> list = bServerRuntimeInfoMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				for (BServerRuntimeInfo bServerRuntimeInfo : list) {
					if(bServerRuntimeInfo.getfServerState() != serverState){
						bServerRuntimeInfo.setfServerState(serverState);
						bServerRuntimeInfo.setfUpdateTime(new Date());
						bServerRuntimeInfoMapper.updateByPrimaryKey(bServerRuntimeInfo);
					}
				}
			} else {
				BServerRuntimeInfo bServerRuntimeInfo = new BServerRuntimeInfo();
				bServerRuntimeInfo.setfServerState(serverState);
				bServerRuntimeInfo.setfServerType(serverType);
				bServerRuntimeInfo.setfCreatTime(new Date());
				bServerRuntimeInfoMapper.insert(bServerRuntimeInfo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}		
	}	
}
