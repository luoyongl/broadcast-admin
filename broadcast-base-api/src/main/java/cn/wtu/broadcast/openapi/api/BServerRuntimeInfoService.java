package cn.wtu.broadcast.openapi.api;

/**
 * 系统运行service接口
 */
public interface BServerRuntimeInfoService {
	
	public void updateBServerRuntimeInfoByType(Integer serverType, Integer serverState);
	
}
