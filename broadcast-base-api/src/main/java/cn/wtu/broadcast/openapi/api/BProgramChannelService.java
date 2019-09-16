package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BProgramChannel;
import cn.wtu.broadcast.openapi.vo.BProgramChannelVO;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.service.api.ParentService;


public interface BProgramChannelService extends ParentService<BProgramChannel> {


	/**
	 * 批量删除数据
	 * @param idList id
	 * @return 删除的个数
	 */
	int deleteProgramByIds(List<Integer> idList);

	/**
	 * 新增节目通道
	 * @param bProgramChannel
	 * @return
	 */
	boolean addProgramChannel(BProgramChannel bProgramChannel);

	/**
	 * 修改节目通道
	 * @param bProgramChannel
	 * @param fId
	 * @return
	 */
    boolean updateProgramChannel(BProgramChannel bProgramChannel,String fId);

	/**
	 * 查询所有通道，用于通道号唯一教研
	 * @return
	 */
	List<BProgramChannel> getAll();

	PageInfo<BProgramChannelVO> queryPageByParams(Map<String,Object> paramMap) throws BizException;
}
