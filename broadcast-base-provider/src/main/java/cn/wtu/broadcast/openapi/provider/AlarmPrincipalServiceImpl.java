package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.AlarmPrincipalService;
import cn.wtu.broadcast.openapi.dao.TAlarmPrincipalMapper;
import cn.wtu.broadcast.openapi.dao.TUserMapper;
import cn.wtu.broadcast.openapi.dao.extend.TAlarmPrincipalExtMapper;
import cn.wtu.broadcast.openapi.model.TAlarmPrincipal;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.model.TUserExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-05 17:10
 */
@Service
public class AlarmPrincipalServiceImpl extends ParentServiceImpl<TAlarmPrincipal> implements AlarmPrincipalService {

    private static Logger logger = LoggerFactory.getLogger(AlarmPrincipalServiceImpl.class);

    private final TAlarmPrincipalMapper tAlarmPrincipalMapper;

    private final TAlarmPrincipalExtMapper tAlarmPrincipalExtMapper;

    private final TUserMapper tUserMapper;

    @Autowired
    public AlarmPrincipalServiceImpl(TAlarmPrincipalMapper tAlarmPrincipalMapper,TUserMapper tUserMapper,TAlarmPrincipalExtMapper tAlarmPrincipalExtMapper) {
        this.tAlarmPrincipalMapper = tAlarmPrincipalMapper;
        this.tUserMapper = tUserMapper;
        this.tAlarmPrincipalExtMapper = tAlarmPrincipalExtMapper;
    }

    @Override
    protected DBInterface<TAlarmPrincipal> getDao() {
        return tAlarmPrincipalMapper;
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer addPrincipal(List<Integer> ids) {
        Date date = new Date();
        TUser sessionUser = getSessionUser();
        int result = 0;
        int result1 = 0;
        for(Integer id:ids){
            TUser user = tUserMapper.selectByPrimaryKey(id);
            if(user==null){
                continue;
            }
            TAlarmPrincipal alarmPrincipal = new TAlarmPrincipal();
            alarmPrincipal.setfCreateTime(date);
            alarmPrincipal.setfUpdtateTime(date);
            alarmPrincipal.setfCreateId(sessionUser.getfId());
            alarmPrincipal.setfOperatorId(sessionUser.getfId());
            alarmPrincipal.setfDeleteFlag(false);
            alarmPrincipal.setfArea(user.getfRespectiveRegion());
            alarmPrincipal.setfPrincipal(user.getfUsername());
            alarmPrincipal.setfCareer(user.getfDuties());
            alarmPrincipal.setfTelephone(user.getfTel());
            user.setfIsLinkman(true);

            try{
                result1 += tUserMapper.updateByPrimaryKeySelective(user);
                result += tAlarmPrincipalMapper.insertSelective(alarmPrincipal);
            }catch (Exception e){
                logger.error(e.getMessage(),e);
            }
        }
        insertLog(OperationLogTypeEnum.UPDATE,"更新用户表（是告警负责人）","更新了"+result1+"个用户");
        insertLog(OperationLogTypeEnum.INSERT,"新增告警负责人","新增了"+result+"个告警负责人");
        return result;
    }

    @Override
    public Map<Integer,Map<Integer,String>> selectUserByRegionId(List<Integer> idList) {

        Map<Integer,Map<Integer,String>> userAreaMap = new HashMap<>();
        try{
            for(Integer id:idList){
                TUserExample example = new TUserExample();
                example.createCriteria().andFRespectiveRegionEqualTo(id).andFDeleteFlagEqualTo(false);
                List<TUser> users = tUserMapper.selectByExample(example);
                Map<Integer,String> userMap = new HashMap<>();
                users.forEach(user->{
                    userMap.put(user.getfId(),user.getfUsername());
                });
                userAreaMap.put(id,userMap);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return userAreaMap;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer deleteProgramByIds(List<Integer> idList) {
        int result = 0;
        int result1 = 0;
        Date date = new Date();
        TUser sessionUser = getSessionUser();
        for(Integer id:idList){
            TAlarmPrincipal principal = new TAlarmPrincipal();
            principal.setfId(id);
            principal.setfUpdtateTime(date);
            principal.setfDeleteFlag(true);
            principal.setfOperatorId(sessionUser.getfId());


            TAlarmPrincipal alarmPrincipal = tAlarmPrincipalMapper.selectByPrimaryKey(id);
            if(alarmPrincipal==null){
                continue;
            }
            TUser user = new TUser();
            user.setfIsLinkman(false);
            TUserExample example = new TUserExample();
            example.createCriteria().andFUsernameEqualTo(alarmPrincipal.getfPrincipal()).andFTelEqualTo(alarmPrincipal.getfTelephone());

            try{
                result1 += tUserMapper.updateByExampleSelective(user,example);
                result += tAlarmPrincipalMapper.updateByPrimaryKeySelective(principal);
            }catch (Exception e){
                logger.error(e.getMessage(),e);
            }

        }
        insertLog(OperationLogTypeEnum.UPDATE,"更新用户表（不是告警负责人）","更新了"+result1+"个用户");
        insertLog(OperationLogTypeEnum.DELETE,"删除告警负责人","删除了"+result+"个告警负责人");
        return result;
    }

    @Override
    public PageInfo<TAlarmPrincipal> queryPageByParam(Map<String, Object> paramMap) throws BizException {

        PageHelper.startPage((Integer) paramMap.get("pageNo"), (Integer) paramMap.get("pageSize"));
        List<TAlarmPrincipal> dataList = null;
        try {
            dataList = tAlarmPrincipalExtMapper.selectAlarmList(paramMap);
            if (dataList != null) {
                return new PageInfo<>(dataList);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
