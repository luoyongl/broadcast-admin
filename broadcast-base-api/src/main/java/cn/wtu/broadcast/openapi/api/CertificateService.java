package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BCertificates;
import cn.wtu.broadcast.openapi.vo.BCertificatesVO;
import cn.wtu.broadcast.openapi.vo.CertificateImpVO;
import cn.wtu.broadcast.parent.service.api.ParentService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface CertificateService extends ParentService<BCertificates>{
	boolean insertOrUpdateCertificate(BCertificates bCertificates);
	int deleteByPrimaryKey(String[] idArr); //返回删除的记录数 传入id字符串数组
	public PageInfo<BCertificatesVO> queryPage(Map<String, Object> paramMap);
	int importExcel(List<CertificateImpVO> list);
	List<String> queryDeviceNames();

	/**
	 * 根据资源编码传是否重复
	 * @return 指定资源编码对应设备数量
	 */
	Integer countByCode(String code);
}
