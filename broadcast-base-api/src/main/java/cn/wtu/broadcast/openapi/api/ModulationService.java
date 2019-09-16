package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.TModulation;
import cn.wtu.broadcast.parent.vo.ModulationParameter;

/**
 * 调制方式Service接口
 *
 * @author lxg
 * @since 2019-02-20
 */
public interface ModulationService {

    /**
     * 保存调制方式
     *
     * @param bModulation 调制方式
     * @return 保存结果(影响的行数是否 > 0)
     */
    boolean update(TModulation bModulation);
    
    //ServiceID  PCRPID DTMB DVB-C
	void updateModulation(ModulationParameter modulationParameter);
}
