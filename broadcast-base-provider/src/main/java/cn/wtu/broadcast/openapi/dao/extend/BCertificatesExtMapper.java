package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BCertificates;
import cn.wtu.broadcast.openapi.vo.BCertificatesVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BCertificatesExtMapper extends DBInterface<BCertificates>{

	List<BCertificatesVO> selecteCertificatesVO(Map<String, Object> paramMap);
}
