package cn.wtu.broadcast.openapi.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.AudioManageService;
import cn.wtu.broadcast.openapi.dao.BAudioDataMapper;
import cn.wtu.broadcast.openapi.dao.TDictionaryMapper;
import cn.wtu.broadcast.openapi.dao.extend.BAudioDataExtMapper;
import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.openapi.model.BAudioDataExample;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TDictionaryExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.util.FileOperate;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

@Service
public class AudioManageServiceImpl extends ParentServiceImpl<BAudioData> implements AudioManageService {

	private static Logger logger = LoggerFactory.getLogger(AudioManageServiceImpl.class);

	private final BAudioDataMapper bAudioDataMapper;

	private final BAudioDataExtMapper bAudioDataExtMapper;
	
	private final TDictionaryMapper tDictionaryMapper;

	@Autowired
	public AudioManageServiceImpl(BAudioDataMapper bAudioDataMapper, BAudioDataExtMapper bAudioDataExtMapper,TDictionaryMapper tDictionaryMapper) {
		this.bAudioDataMapper = bAudioDataMapper;
		this.bAudioDataExtMapper = bAudioDataExtMapper;
		this.tDictionaryMapper = tDictionaryMapper;
	}

	@Override
	protected DBInterface<BAudioData> getDao() {

		return bAudioDataMapper;
	}

	@Override
	public boolean uploadFile(BAudioData bAudioData) {
		TUser sessionUser = getSessionUser();
		bAudioData.setfCreatorId(sessionUser.getfId());
		bAudioData.setfOperatorId(sessionUser.getfId());
		int i = 0;
		try {
			i = bAudioDataMapper.insertSelective(bAudioData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (i == 1) {
			insertLog(OperationLogTypeEnum.INSERT, "上传MP3文件", "上传成功");
			return true;
		} else {
			insertLog(OperationLogTypeEnum.INSERT, "上传MP3文件", "上传失败");
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int deleteAudioByIds(List<Integer> idList, String del_path) {
		// TODO 判断开播
		int result = 0;
		Date date = new Date();
		for (Integer id : idList) {
			BAudioData bAudioData = new BAudioData();
			bAudioData.setfId(id);
			bAudioData.setfOperatorId(getSessionUser().getfId());
			bAudioData.setfUpdateTime(date);
			bAudioData.setfDeleteFlag(true);
			BAudioData audioData = bAudioDataMapper.selectByPrimaryKey(id);
			if (audioData == null) {
				break;
			}
			try {
				result += bAudioDataMapper.updateByPrimaryKeySelective(bAudioData);
				FileOperate.deleteFile(del_path, audioData.getfAudioUrl());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		insertLog(OperationLogTypeEnum.DELETE, "删除音频", "删除了" + result + "个音频");
		return result;
	}

	@Override
	public boolean updateAudio(BAudioData bAudioData) {
		BAudioData audioData = null;
		try {
			audioData = bAudioDataMapper.selectByPrimaryKey(bAudioData.getfId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		String name = bAudioData.getfAudioName();
		if (audioData != null) {
			audioData.setfAudioName(name);
			audioData.setfOperatorId(getSessionUser().getfId());
			audioData.setfUpdateTime(new Date());
		}

		int i = 0;
		try {
			i = bAudioDataMapper.updateByPrimaryKeySelective(audioData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (i == 1) {
			insertLog(OperationLogTypeEnum.UPDATE, "修改音频文件名", "成功");
			return true;
		} else {
			insertLog(OperationLogTypeEnum.UPDATE, "修改音频文件名", "失败");
			return false;
		}

	}

	@Override
	public List<BAudioData> getAll() {
		BAudioDataExample example = new BAudioDataExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		List<BAudioData> AudioList = null;
		try {
			AudioList = bAudioDataMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return AudioList;
	}

	@Override
	public PageInfo<BAudioData> queryPageByParam(Map<String, Object> paramMap) throws BizException {
		PageHelper.startPage((Integer) paramMap.get("pageNo"), (Integer) paramMap.get("pageSize"));
		List<BAudioData> dataList = null;
		try {
			dataList = bAudioDataExtMapper.selectAudioList(paramMap);
			for(BAudioData data : dataList){
				String url = data.getfAudioUrl();
				String type = url.substring(url.lastIndexOf(".")+1);
				data.setfAudioType(type);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new PageInfo<>(dataList);
	}

	@Override
	public boolean checkAudioUsed(Integer id) {
		// TODO Auto-generated method stub
		if(bAudioDataExtMapper.selectUsedAudio(id.intValue())>0){
			return true;
		}
		return false;
	}

	@Override
	public List<BAudioData> checkAudioname(String audioName) {
		BAudioDataExample example=new BAudioDataExample();
		example.createCriteria().andFAudioNameEqualTo(audioName).andFDeleteFlagEqualTo(false);
		return bAudioDataMapper.selectByExample(example);
	}

	@Override
	public List<String> selectSensitiveWords() {
		// TODO Auto-generated method stub
		List<String> sensitiveWords = new ArrayList<String>();
		TDictionaryExample example=new TDictionaryExample();
		TDictionaryExample.Criteria criteria= example.createCriteria();
		criteria.andFDictionaryTypeEqualTo(202);
		List<TDictionary> selectData = tDictionaryMapper.selectByExample(example);
		for(TDictionary data : selectData){
			sensitiveWords.add(data.getfDictionaryContent());
		}
		return sensitiveWords;
	}
}
