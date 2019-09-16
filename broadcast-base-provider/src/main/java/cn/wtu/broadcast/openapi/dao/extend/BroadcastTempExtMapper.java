package cn.wtu.broadcast.openapi.dao.extend;

/**

 */
public interface BroadcastTempExtMapper {
	
	
	Integer selectByBroadcastId(Integer broadcastId);
	
	void deleteBBroadcastTemp(Integer broadcastId);

}
