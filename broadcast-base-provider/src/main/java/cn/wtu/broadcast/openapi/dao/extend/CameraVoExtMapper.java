package cn.wtu.broadcast.openapi.dao.extend;

import cn.wtu.broadcast.openapi.vo.CameraVo;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;


/**
 * @description:
 * @author: AYY
 * @date: 2019-01-05 12:16
 */
public interface CameraVoExtMapper extends DBInterface<CameraVo> {
    List<CameraVo> selectCameraList();
}
