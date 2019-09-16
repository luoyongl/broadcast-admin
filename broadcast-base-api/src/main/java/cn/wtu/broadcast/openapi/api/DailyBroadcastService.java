package cn.wtu.broadcast.openapi.api;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.vo.BroadCastDataVO;

public interface DailyBroadcastService {

	public PageInfo<BroadCastDataVO> selectDailyBroadcastService(Map<String,Object> paramMap, Integer b);
}
