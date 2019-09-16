package cn.wtu.broadcast.openapi.provider;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wtu.broadcast.openapi.dao.TOperationLogMapper;
import cn.wtu.broadcast.openapi.dao.TSystemConfigurationMapper;
import cn.wtu.broadcast.openapi.model.TOperationLog;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.openapi.model.TSystemConfigurationExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * @author sueua
 * @since 2018-12-15
 */
public abstract class ParentServiceImpl<T extends Serializable> extends cn.wtu.broadcast.parent.service.base.ParentServiceImpl<T> {

    /**
     * 系统配置
     */
    private static ConcurrentMap<String, String> systemConfig;

    private static TSystemConfigurationMapper tSystemConfigurationMapper;

    @Autowired
    private TOperationLogMapper tOperationLogMapper;

    @Autowired
    public void settSystemConfigurationMapper(TSystemConfigurationMapper tSystemConfigurationMapper) {
        ParentServiceImpl.tSystemConfigurationMapper = tSystemConfigurationMapper;
    }

    /**
     * 获取系统配置Map
     * @return 系统配置Map
     */
    public static ConcurrentMap<String, String> getSystemConfig() {
        if (systemConfig == null) {
            return reloadSystemConfig();
        }
        return systemConfig;
    }

    /**
     * 获取系统配置
     *
     * @param configName f_configuration_name
     * @return 配置值
     */
    public static String getSystemConfig(String configName) {
        if (systemConfig == null) {
            return reloadSystemConfig().get(configName);
        }
        return systemConfig.get(configName);
    }

    protected synchronized static ConcurrentMap<String, String> reloadSystemConfig() {
        TSystemConfigurationExample tSystemConfigurationExample = new TSystemConfigurationExample();
        tSystemConfigurationExample.createCriteria().andFDeleteFlagEqualTo(false);
        List<TSystemConfiguration> systemConfigurationList = tSystemConfigurationMapper.selectByExample(tSystemConfigurationExample);
        if(systemConfig==null){
            systemConfig = new ConcurrentHashMap<>();
        }else{
            systemConfig.clear();
        }
        systemConfigurationList.forEach(tSystemConfiguration -> {
            String value = tSystemConfiguration.getfConfigurationValue();
            //ConcurrentHashMap value不能为空
            systemConfig.put(tSystemConfiguration.getfConfigurationName(), value == null ? "" : value);
        });
        return systemConfig;
    }

    /**
     * 获取session中的用户
     */
    public TUser getSessionUser() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        if (tUser != null) {
            return tUser;
        } else {
            throw new BizException("用户未登录");
        }
    }

    /**
     * 插入操作日志
     *
     * @param operationLogTypeEnum 操作类型
     * @param fOperationContent    操作内容
     * @param fOperationResult     操作结果
     */
    public void insertLog(OperationLogTypeEnum operationLogTypeEnum, String fOperationContent, String fOperationResult) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        if (tUser != null) {
            TOperationLog tOperationLog = new TOperationLog();
            tOperationLog.setfIp(session.getHost());
            tOperationLog.setfOperationTime(new Date());
            tOperationLog.setfUserid(tUser.getfId());
            tOperationLog.setfUsername(tUser.getfUsername());
            tOperationLog.setfOperationType(operationLogTypeEnum.getValue());
            tOperationLog.setfOperationContent(fOperationContent);
            tOperationLog.setfOperationResult(fOperationResult);
            tOperationLogMapper.insert(tOperationLog);
        }
    }
}
