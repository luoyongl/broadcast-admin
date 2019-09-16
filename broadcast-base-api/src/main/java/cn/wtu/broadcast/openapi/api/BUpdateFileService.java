package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BUpdateFile;
import cn.wtu.broadcast.openapi.vo.BUpdateFileVO;
import cn.wtu.broadcast.parent.service.api.ParentService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface BUpdateFileService extends ParentService<BUpdateFile> {

    public Boolean addUpdateFile(BUpdateFile bUpdateFile);

    public PageInfo<BUpdateFileVO> queryPage(Map<String, Object> paramMap,Integer fIpOrTs);

    public int deleteFile(String fId);

    /**
     * @param title 传入的标题
     * @return true 代表有重复
     * & false 代表没有重复 默认为false
     */
    public Boolean checkUpdateFileName(String title);


}
