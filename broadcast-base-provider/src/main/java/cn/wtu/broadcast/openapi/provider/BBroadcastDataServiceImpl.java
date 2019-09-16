package cn.wtu.broadcast.openapi.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.dao.BBroadcastDataMapper;
import cn.wtu.broadcast.openapi.dao.BDeviceInfoMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastTempExtMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastTimingExtMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastData;
import cn.wtu.broadcast.openapi.model.BBroadcastDataExample;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInfoExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BBroadcastTempVO;
import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.utils.DateUtil;

/**
 * @author LY
 */
@Transactional
@Service("bBroadcastDataService")
public class BBroadcastDataServiceImpl extends ParentServiceImpl<BBroadcastData> implements BBroadcastDataService {

    private static Logger logger = LoggerFactory.getLogger(BBroadcastDataServiceImpl.class);

    private final BBroadcastDataMapper broadcastDataMapper;

    private final BBroadcastDataExtMapper broadcastDataExtMapper;

    @SuppressWarnings("unused")
    private final BBroadcastTimingExtMapper broadcastTimingExtMapper;

    private final BBroadcastTempExtMapper bBroadcastTempExtMapper;
    
    @Autowired
	private  BDeviceInfoMapper bDeviceInfoMapper;

    @Autowired
    public BBroadcastDataServiceImpl(BBroadcastDataMapper broadcastDataMapper,
                                     BBroadcastDataExtMapper broadcastDataExtMapper,
                                     BBroadcastTimingExtMapper broadcastTimingExtMapper,
                                     BBroadcastTempExtMapper bBroadcastTempExtMapper) {
        this.broadcastDataMapper = broadcastDataMapper;
        this.broadcastDataExtMapper = broadcastDataExtMapper;
        this.broadcastTimingExtMapper = broadcastTimingExtMapper;
        this.bBroadcastTempExtMapper=bBroadcastTempExtMapper;
    }

    @Override
    protected DBInterface<BBroadcastData> getDao() {
        return broadcastDataMapper;
    }

    /**
     * 根据广播类型和广播ID给广播设置状态  Lxg 2019-02-22
     *
     * @param broadcastType
     * @param fId
     * @param state
     */
    public void setStateByTypeAndFid(Integer broadcastType, Integer fId, Integer state) {
        //定时广播无 待播发 正在播 状态 --这是数据库表结构设置的原因
        //除了定时广播的其他广播,即在广播数据表中  lxg 2019/02/22
        if (broadcastType != BroadcastTypeEnum.timing.getCode()) {
            broadcastDataExtMapper.setStateByFid(state, fId);
        }
    }
    
    /**ip
     * 根据广播ID给广播设置状态  Lxg 2019-02-22
     * @param fId
     * @param state
     */
    public void setStateByFid(Integer fId, Integer state) {
            broadcastDataExtMapper.setStateByFid(state, fId);
    }

    @Override
    public Boolean addBroadCast(BBroadcastData bBroadcastData) {
        TUser tUser = getSessionUser();
        //bBroadcastData.setfOperatorId(tUser.getfId());
        //tUser.
        bBroadcastData.setfCreateId(tUser.getfId());
        bBroadcastData.setfMessageSource(tUser.getfRespectiveRegion().intValue());

        try {
            int count = broadcastDataMapper.insertSelective(bBroadcastData);
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Boolean addBroadCastThinkUserRole(BBroadcastData bBroadcastData, Byte state) {
        TUser tUser = getSessionUser();

        bBroadcastData.setfCreateId(tUser.getfId());

        bBroadcastData.setfMessageSource(tUser.getfRespectiveRegion().intValue());

        if (tUser.getfIsAuditAutomatic() == true) {
            bBroadcastData.setfState(state);
        }
        try {
            int count = broadcastDataMapper.insertSelective(bBroadcastData);
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param paramMap paramMap ：
     *                 参数 pageNumber 页码
     *                 pageSize 查多少条
     *                 fBroadcastType 广播类型
     *                 searchText 模糊查询内容
     *                 sortName 排序字段
     *                 sortOrder 排序方式
     * @return
     * @author LY
     */
    public PageInfo<BroadCastDataVO> queryPageByBroadcastType(Map<String, Object> paramMap) throws BizException {
        //PageInfo<BroadCastDataVO> result = null;
        try {
            PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
            List<BroadCastDataVO> dataList = broadcastDataExtMapper.queryPageByBroadcastType(paramMap);
            List<BroadCastDataVO> dataListRs = new ArrayList<BroadCastDataVO>();
            
            if (dataList != null) {
            	int length = dataList.size();
                for(int i = 0 ; i < length; i++) {
                	BroadCastDataVO bo = dataList.get(i); 
                	if("147".equals(dataList.get(i).getfProgramPass())||"8".equals(dataList.get(i).getfProgramPass())) {
                		bo.setfRealProgramPass(dataList.get(i).getfTextUrl());
                	}
                	dataListRs.add(bo);          	
                }             
            }
            return new PageInfo<>(dataList);
            
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
            return null;
        }
       
    }

    /**
     * 统计查询
     * @author yinjie
     */
    @Override
	public PageInfo<BroadCastDataVO> queryPageByBroadcastStatistics(Map<String, Object> paramMap) {
		try {
            PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
            List<BroadCastDataVO> dataList = broadcastDataExtMapper.queryPageByBroadcastStatistics(paramMap); 
            return new PageInfo<>(dataList);
            
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
            return null;
        }
	}
    @Override
    public BroadCastDataVO selectBroadCastById(Integer fId) {
        BroadCastDataVO result = null;
        try {
            result = broadcastDataExtMapper.selectBroadCastByFid(fId);
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }
        return result;
    }


    /**
     * @Desc 当审核通过或未通过后，更新广播数据表中的状态
     * @Author Li LinFeng
     * @Date 2019-1-2
     */
    @Override
    public boolean updateBroadcastState(BBroadcastData broadCastData) {
        try {
            int count = broadcastDataMapper.updateByPrimaryKeySelective(broadCastData);
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }

        return false;
    }


    /**
     * @return
     * @Desc 查询某个状态的播发信息
     * @Date 2019-01-04
     * @Author Li LinFeng
     */
    @Override
    public List<BroadCastDataVO> selectBeingBroadCast(int state) {
        List<BroadCastDataVO> list = null;
        try {
            list = broadcastDataExtMapper.queryPageByBroadcastState(state);
			/*BBroadcastDataExample example = new BBroadcastDataExample();
			Criteria criteria = example.createCriteria();
			criteria.andFStateEqualTo((byte)state);
			
			list = broadcastDataMapper.selectByExample(example);*/

        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }

        return list;
    }


    /**
     * @return
     * @Desc 查询待播发的广播信息
     * @Date 2019-01-04
     * @Author Li LinFeng
     */
    @Override
    public PageInfo<BBroadcastTempVO> selectwaitingBroadCast(Map<String, Object> paramMap, int code) {
        PageInfo<BBroadcastTempVO> result = null;
        paramMap.put("code", code);
        try {
            PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
            List<BBroadcastTempVO> dataList = bBroadcastTempExtMapper.selectBroadcast(paramMap);
            if (dataList != null) {
                result = new PageInfo<>(dataList);
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }
        return result;
    }

    @Override
    public int deleteBroadast(String fId) {
        TUser tUser = getSessionUser();
        BBroadcastData bBroadcastData = new BBroadcastData();
        bBroadcastData.setfOperatorId(tUser.getfId());
        bBroadcastData.setfDeleteFlag(true);
        int count = 0;
        String[] ids = fId.split(",");
        for (String id : ids) {
            try {
                bBroadcastData.setfId(Integer.parseInt(id));
                count += broadcastDataMapper.updateByPrimaryKeySelective(bBroadcastData);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return count;
    }


    @Override
    public Integer selectBroadByType(Integer rank) {
        BBroadcastDataExample example = new BBroadcastDataExample();
        example.createCriteria().andFMessageLevelEqualTo(rank).andFDeleteFlagEqualTo(false);
        return broadcastDataMapper.selectByExample(example).size();
    }

    @Override
    public Map<String, Integer> countBytime() {
        Map<String,Integer> bs=new HashMap<>();
        BBroadcastDataExample example=new BBroadcastDataExample();
        int index=0;
        for (index=0;index<24;index+=4){
            if (index==20){
                example.createCriteria().andFCreateTimeBetween(DateUtil.getCustomTime(index),DateUtil.getCustomTime(index+3));
            }else {
                example.createCriteria().andFCreateTimeBetween(DateUtil.getCustomTime(index),DateUtil.getCustomTime(index+4));
            }
            bs.put("time"+index,broadcastDataMapper.selectByExample(example).size());
        }
        return bs;
    }

    @Override
    public PageInfo<BroadCastDataVO> queryDeviceBroadcast(Map<String, Object> paramMap) {
        PageInfo<BroadCastDataVO> result = null;
        try {
            PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
            List<BroadCastDataVO> dataList = broadcastDataExtMapper.queryDeviceBroadcast(paramMap);
            if (dataList != null) {
                result = new PageInfo<>(dataList);
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }
        return result;
    }

	@Override
	public String queryAdapterCode(Integer adapterId) {
		String adapterResourceCode = "";
		 try {
				BDeviceInfoExample example=new BDeviceInfoExample();
				example.createCriteria().andFDeleteFlagEqualTo(false).andFDeviceTypeEqualTo((byte) DeviceTypeEnum.frontDevice.getCode()).andFIdEqualTo(adapterId);
				List<BDeviceInfo> adapter = bDeviceInfoMapper.selectByExample(example);
				if(adapter.size()!= 1){
					logger.error("适配器信息查询有误");
				}else{
					 adapterResourceCode = adapter.get(0).getfDeviceResourceCode();
				}
	        } catch (Exception e) {
	            logger.error(e.getMessage() + e);
	        }
		 return adapterResourceCode;
	}
}
