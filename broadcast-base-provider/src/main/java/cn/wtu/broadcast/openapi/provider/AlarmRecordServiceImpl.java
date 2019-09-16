package cn.wtu.broadcast.openapi.provider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.AlarmRecordService;
import cn.wtu.broadcast.openapi.dao.BAlarmRecordMapper;
import cn.wtu.broadcast.openapi.dao.extend.AlarmRecordExtMapper;
import cn.wtu.broadcast.openapi.model.BAlarmRecord;
import cn.wtu.broadcast.openapi.model.BAlarmRecordExample;
import cn.wtu.broadcast.parent.constant.TableConst;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.AlarmTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * 告警记录service接口实现
 *
 * @author sueua
 * @date 2019/1/22
 */
@Service("alarmRecordService")
public class AlarmRecordServiceImpl extends ParentServiceImpl<BAlarmRecord> implements AlarmRecordService {

    private final BAlarmRecordMapper alarmRecordMapper;

    private final AlarmRecordExtMapper alarmRecordExtMapper;

    @Autowired
    public AlarmRecordServiceImpl(BAlarmRecordMapper alarmRecordMapper, AlarmRecordExtMapper alarmRecordExtMapper) {
        this.alarmRecordMapper = alarmRecordMapper;
        this.alarmRecordExtMapper = alarmRecordExtMapper;
    }

    /**
     * 获取数据操作实例,不能为空,子类必须实现该方法
     */
    @Override
    protected DBInterface<BAlarmRecord> getDao() {
        return alarmRecordMapper;
    }

    @Override
    public PageInfo<BAlarmRecord> queryPageByParam(Map<String, Object> param) throws BizException {
        if (param != null) {
            if (param.get(TableConst.PAGE_NO_STR) != null && param.get(TableConst.PAGE_SIZE_STR) != null) {
                PageHelper.startPage((Integer) param.get(TableConst.PAGE_NO_STR), (Integer) param.get(TableConst.PAGE_SIZE_STR));
            }
        }
        BAlarmRecordExample example = new BAlarmRecordExample();
        example.createCriteria().andFDeleteFlagEqualTo(false);
        example.setOrderByClause("f_id desc");
        List<BAlarmRecord> dataList = alarmRecordMapper.selectByExample(example);
        return new PageInfo<>(dataList);
    }

    /**
     * 获取百度饼图数据
     *
     * @return 百度饼图数据
     */
    @Override
    public Map<String, Object> getChartData() {
        Map<String, Object> map = new HashMap<>();
        Map<Object, String> alarmTypeMap = Arrays.stream(AlarmTypeEnum.values()).collect(Collectors.toMap(AlarmTypeEnum::getValue, AlarmTypeEnum::getDesc));
        List<Map<String, Object>> mapList = alarmRecordExtMapper.countGroupByType();
        mapList.forEach(item -> map.put(alarmTypeMap.get(((Integer)item.get("type")).byteValue()), item.get("count")));
        return map;
    }
}
