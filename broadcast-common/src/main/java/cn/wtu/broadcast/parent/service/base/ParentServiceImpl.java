package cn.wtu.broadcast.parent.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.service.api.ParentService;




/**
 * 版权：c-bons<br/>
 * 作者：win <br/>
 * 生成日期：2013-11-19 <br/>
 * 描述：父接口,仅提供增删改查基本方法 
 */
public abstract class ParentServiceImpl<T extends Serializable> implements
		ParentService<T> {

	/**
	 * 获取数据操作实例,不能为空,子类必须实现该方法 aren
	 */
	protected abstract DBInterface<T> getDao() ;

	/**
	 * 根据主键删除记录
	 *
	 * @param tid 主键id
	 * 
	 * @return 删除记录数 
	 */
	public int deleteByPrimaryKey(Integer tid)  throws BizException{
		return getDao().deleteByPrimaryKey(tid);
	}
	
	public int deleteByPrimaryKey(String tid)   throws BizException{
		return getDao().deleteByPrimaryKey(tid);
	}
    /**
     * 插入记录对象所有属性
     * 
     * @param t 记录对象
     * 
     * @return 含主键的记录对象
     */
	public T insert(T t)   throws BizException{
		getDao().insert(t);
		return t;
	}

    /**
     * 插入记录对象不为空的属性
     * 
     * @param t 记录对象
     * 
     * @return 含主键的记录对象
     */
	public T insertSelective(T t)   throws BizException{
		getDao().insertSelective(t);
		return t;
	}

    /**
     * 根据主键id查询记录对象
     * 
     *
     * 
     * @return 记录对象
     */
	public T selectByPrimaryKey(Integer id)   throws BizException{
		return getDao().selectByPrimaryKey(id);
	}
	/**
     * 根据主键id查询记录对象
     * 
     *
     * 
     * @return 记录对象
     */
	public T selectByPrimaryKey(String id)   throws BizException{
		return getDao().selectByPrimaryKey(id);
	}
	
    /**
     * 更新记录对象不为空的属性
     * 
     * @param t 记录对象
     * 
     * @return 更新记录数
     */
	public int updateByPrimaryKeySelective(T t)  throws BizException {
		return getDao().updateByPrimaryKeySelective(t);
	}

    /**
     * 更新记录对象所有属性
     * 
     * @param t 记录对象
     * 
     * @return 更新记录数
     */
	public int updateByPrimaryKey(T t)   throws BizException{
		return getDao().updateByPrimaryKeySelective(t);
	}

	
	public PageInfo<T> queryPageByParam(Map<String,Object> paramMap) throws BizException{
		PageHelper.startPage(Integer.valueOf(paramMap.get("pageNo").toString()),Integer.valueOf(paramMap.get("pageSize").toString()));
		List<T> dataList = getDao().queryPageByParam(paramMap);
		PageInfo<T> page = new PageInfo<T>(dataList);
		return page;
	}
}
