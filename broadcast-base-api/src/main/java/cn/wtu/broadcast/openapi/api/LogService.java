package cn.wtu.broadcast.openapi.api;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.TOperationLog;
import cn.wtu.broadcast.parent.service.api.ParentService;

/**
 * 日志service接口
 *
 * @author sueua
 * @since 2019-01-01
 */
public interface LogService extends ParentService<TOperationLog> {
	PageInfo<TOperationLog> selectSearchTableInfo(Map<String, Object> param);
}
