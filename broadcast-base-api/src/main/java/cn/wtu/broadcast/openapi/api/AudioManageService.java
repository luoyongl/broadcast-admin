package cn.wtu.broadcast.openapi.api;


import java.util.List;

import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface AudioManageService extends ParentService<BAudioData> {

    /**
     * 上传文件方法
     * @param bAudioData
     * @return
     */
    boolean uploadFile(BAudioData bAudioData);

    /**
     * 根据id列表删除文件
     * @param idList
     * @return
     */
    int deleteAudioByIds(List<Integer> idList,String del_path);

    /**
     * 更改音频名称
     * @param bAudioData
     * @return
     */
    boolean updateAudio(BAudioData bAudioData);

    List<BAudioData> getAll();

	boolean checkAudioUsed(Integer id);

	List<BAudioData> checkAudioname(String audioName);
	
	List<String> selectSensitiveWords();
}
 