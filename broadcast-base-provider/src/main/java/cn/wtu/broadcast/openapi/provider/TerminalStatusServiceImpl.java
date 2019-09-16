package cn.wtu.broadcast.openapi.provider;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.TerminalStatusService;
import cn.wtu.broadcast.openapi.dao.extend.TerminalStatusExtMapper;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.vo.TerminalStatusVO;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * @Author: NewLinfeng
 * @Description:
 * @Date: Created in 14:58 on 2019/1/17.
 * @Modified_by:
 */
@Service("TerminalStatusService")
public class TerminalStatusServiceImpl implements TerminalStatusService {
    @SuppressWarnings("unused")
	@Autowired
    private TerminalStatusExtMapper terminalStatusExtMapper;

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(TerminalStatusServiceImpl.class);

	@Override
	public int deleteByPrimaryKey(Integer tid) throws BizException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String tid) throws BizException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BDeviceInfo insert(BDeviceInfo t) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BDeviceInfo insertSelective(BDeviceInfo t) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BDeviceInfo selectByPrimaryKey(Integer tid) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BDeviceInfo selectByPrimaryKey(String tid) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(BDeviceInfo t) throws BizException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(BDeviceInfo t) throws BizException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<BDeviceInfo> queryPageByParam(Map<String, Object> paramMap) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<TerminalStatusVO> queryPageByTeminalStatusType(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<TerminalStatusVO> queryPageByTerminalRecordListForTime(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * @param paramMap
     * @return
     * @Description 查询终端播放状态的信息(实时状态和播放记录)
     * @Author: NewLinfeng
     * @Date: Created in 15:00 on 2019/1/17.
     */
   /* @Override
    public PageInfo<TerminalStatusVO> queryPageByTeminalStatusType(Map<String, Object> paramMap) {
        //PageInfo<TerminalStatusVO> result = null;
        try {
            PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
            List<TerminalStatusVO> dataList = terminalStatusExtMapper.queryState(paramMap);
//            List<TerminalStatusVO> dataListRs = new ArrayList<TerminalStatusVO>();
            if (dataList != null) {
            	int length = dataList.size();            	
                for(int i = 0 ; i < length; i++) {
//                	TerminalStatusVO bo = dataList.get(i); 
                	if("147".equals(dataList.get(i).getfProgramPass())||"8".equals(dataList.get(i).getfProgramPass())) {
//                		bo.setfAudioUrl(dataList.get(i).getfTextUrl());
                		String url = dataList.get(i).getfTextUrl();
                		String urlOfLineFeed = "";
                		while(url.length()>30) {
                			String temp = url.substring(0, 29);
                			urlOfLineFeed += temp+"<br/>";
                			url = url.replace(temp, "");
                		}
                		urlOfLineFeed += url;               		
                		dataList.get(i).setfProgramPass(urlOfLineFeed);
                	}else {
                		dataList.get(i).setfProgramPass(dataList.get(i).getfAudioName());
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

    @Override
    public PageInfo<TerminalStatusVO> queryPageByTerminalRecordListForTime(Map<String, Object> paramMap) {
        PageInfo<TerminalStatusVO> result = null;
        List<TerminalStatusVO> dataList = null;
        try {
            dataList = terminalStatusExtMapper.queryPageByTerminalRecordListForTime(paramMap);
            if (dataList != null) {
                result = new PageInfo<>(dataList);
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }

        return result;
    }

    @Override
    public int deleteByPrimaryKey(Integer tid) throws BizException {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String tid) throws BizException {
        return 0;
    }

    @Override
    public BDeviceInfo insert(BDeviceInfo bDeviceInfo) throws BizException {
        return null;
    }

    @Override
    public BDeviceInfo insertSelective(BDeviceInfo bDeviceInfo) throws BizException {
        return null;
    }

    @Override
    public BDeviceInfo selectByPrimaryKey(Integer tid) throws BizException {
        return null;
    }

    @Override
    public BDeviceInfo selectByPrimaryKey(String tid) throws BizException {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BDeviceInfo bDeviceInfo) throws BizException {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(BDeviceInfo bDeviceInfo) throws BizException {
        return 0;
    }

    @Override
    public PageInfo<BDeviceInfo> queryPageByParam(Map<String, Object> paramMap) throws BizException {
        return null;
    }

    *//**
     * @param ss
     * @return
     * @Description 给字符串数组去重
     * @Author LiLinFeng
     *//*
    @SuppressWarnings("unused")
	private static String[] array_unique(String[] ss) {
        Set<String> set = new HashSet<String>(Arrays.asList(ss));
        return set.toArray(new String[set.size()]);
        //或者return new HashSet<String>(Arrays.asList(ss)).toArray(new String[0]);
    }*/

}
