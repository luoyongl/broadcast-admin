package cn.wtu.broadcast.openapi.provider;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wtu.broadcast.openapi.api.ModulationService;
import cn.wtu.broadcast.openapi.dao.TModulationMapper;
import cn.wtu.broadcast.openapi.dao.extend.TDictionaryExtMapper;
import cn.wtu.broadcast.openapi.model.TModulation;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.vo.ModulationParameter;

/**
 * 调制方式Service接口实现
 *
 * @author lxg
 * @since 2019-02-20
 */
@Service("modulationService")
public class ModulationServiceImpl extends ParentServiceImpl<TModulation> implements ModulationService {
	
    private final TModulationMapper tModulationMapper;
    
    private final TDictionaryExtMapper tDictionaryExtMapper;

    @Autowired
    public ModulationServiceImpl(TModulationMapper tModulationMapper,TDictionaryExtMapper tDictionaryExtMapper) {
        this.tModulationMapper = tModulationMapper;
        this.tDictionaryExtMapper=tDictionaryExtMapper;
    }

	@Override
	protected DBInterface<TModulation> getDao() {
		return tModulationMapper;
	}
	
    /**
     * 保存调制方式
     *
     * @param TModulation 厂商
     * @return 保存结果(影响的行数是否 > 0)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(TModulation TModulation) {
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        int result;

/*        if (TModulation.getfId() != null) {
            TModulation.setfOperatorId(sessionUser.getfId());
            TModulation.setfUpdateTime(time);
            result = TModulationMapper.updateByPrimaryKeySelective(TModulation);
            insertLog(OperationLogTypeEnum.UPDATE, "修改调制方式", result > 0 ? "成功" : "失败");
        } else {*/
            TModulation.setfCreatorId(sessionUser.getfId());
            TModulation.setfCreateTime(time);
            TModulation.setfDeleteFlag(false);
            result = tModulationMapper.insert(TModulation);
            insertLog(OperationLogTypeEnum.INSERT, "新增调制方式", result > 0 ? "成功" : "失败");
        return result > 0;
    }

    /**
     * 更新调制参数
     *
     * @param modulationParameter 调制方式
     * @author lxg
     * @since  2019/02/25
     */
	@Override
    @Transactional(rollbackFor = Exception.class)
	public void updateModulation(ModulationParameter modulationParameter) {
		//ServiceID  PCRPID DTMB DVB-C
		tDictionaryExtMapper.updateModulation(modulationParameter.getServiceID(), "ServiceID");
		tDictionaryExtMapper.updateModulation(modulationParameter.getPCRPID(),"PCRPID");
		tDictionaryExtMapper.updateModulation(modulationParameter.getDTMB(),"DTMB");
		tDictionaryExtMapper.updateModulation(modulationParameter.getDVBC(),"DVB-C");

	}
}
