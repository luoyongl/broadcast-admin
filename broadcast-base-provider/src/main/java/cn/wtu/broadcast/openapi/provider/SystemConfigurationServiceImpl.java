package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.dao.TSystemConfigurationMapper;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.openapi.model.TSystemConfigurationExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;

@Service("systemConfigurationService")
public class SystemConfigurationServiceImpl extends ParentServiceImpl<TSystemConfiguration>
		implements SystemConfigurationService {

	private static Logger logger = LoggerFactory.getLogger(SystemConfigurationServiceImpl.class);

	private final TSystemConfigurationMapper tSystemConfigurationMapper;

	@Autowired
	public SystemConfigurationServiceImpl(TSystemConfigurationMapper tSystemConfigurationMapper) {
		this.tSystemConfigurationMapper = tSystemConfigurationMapper;
	}

	/**
	 * 获取数据操作实例,不能为空,子类必须实现该方法
	 */
	@Override
	protected DBInterface<TSystemConfiguration> getDao() {
		return tSystemConfigurationMapper;
	}

	/**
	 * 查询全部配置
	 */
	@Override
	public List<TSystemConfiguration> selectList() {
		logger.info("查询全部配置");
		TSystemConfigurationExample tSystemConfigurationExample = new TSystemConfigurationExample();
		tSystemConfigurationExample.createCriteria().andFDeleteFlagEqualTo(false);
		return tSystemConfigurationMapper.selectByExample(tSystemConfigurationExample);
	}

	/**
	 * 更新配置
	 *
	 * @param configMap map封装的配置信息,key->f_configuration_name,value->
	 * f_configuration_value
	 * @return 影响的行数
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(Map<String, String> configMap) {
		TUser sessionUser = getSessionUser();
		int result = 0;
		for (Map.Entry<String, String> entry : configMap.entrySet()) {
			TSystemConfiguration tSystemConfiguration = new TSystemConfiguration();
			tSystemConfiguration.setfConfigurationValue(entry.getValue());
			tSystemConfiguration.setfOperatorId(sessionUser.getfId());
			tSystemConfiguration.setfUpdateTime(new Date());
			TSystemConfigurationExample example = new TSystemConfigurationExample();
			example.createCriteria().andFConfigurationNameEqualTo(entry.getKey());
			result = result + tSystemConfigurationMapper.updateByExampleSelective(tSystemConfiguration, example);
		}
		insertLog(OperationLogTypeEnum.UPDATE, "修改系统配置", "改变" + result + "条配置");
		if (result > 0) {
			// 刷新父类中的系统配置
			// .静态map
			reloadSystemConfig();

		}
		return result;
	}

	/**
	 * 通过配置名称查询对应的值
	 * 
	 * @param cName
	 * @return
	 */
	@Override
	public TSystemConfiguration selectDataByCName(String cName) {
		TSystemConfigurationExample example = new TSystemConfigurationExample();
		example.createCriteria().andFDeleteFlagEqualTo(false).andFConfigurationNameEqualTo(cName);
		List<TSystemConfiguration> list = tSystemConfigurationMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
