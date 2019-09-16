package cn.wtu.broadcast.parent.service.api;

import java.io.Serializable;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.parent.exceptions.BizException;

public interface ParentService<T extends Serializable> {

	/**
	 * 根据主键删除记录
	 * 
	 * @param tid
	 *            主键id
	 * 
	 * @return 删除记录数
	 */
	int deleteByPrimaryKey(Integer tid) throws BizException;

	int deleteByPrimaryKey(String tid) throws BizException;

	/**
	 * 插入记录对象所有属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 含主键的记录对象
	 */
	T insert(T t) throws BizException;

	/**
	 * 插入记录对象不为空的属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 含主键的记录对象
	 */
	T insertSelective(T t) throws BizException;

	/**
	 * 根据主键id查询记录对象
	 * 
	 * @param tid
	 *            主键id
	 * 
	 * @return 记录对象
	 */
	T selectByPrimaryKey(Integer tid) throws BizException;

	/**
	 * 根据主键id查询记录对象
	 * 
	 * @param tid
	 *            主键id
	 * 
	 * @return 记录对象
	 */
	T selectByPrimaryKey(String tid) throws BizException;

	/**
	 * 更新记录对象不为空的属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 更新记录数
	 */
	int updateByPrimaryKeySelective(T t) throws BizException;

	/**
	 * 更新记录对象所有属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 更新记录数
	 */
	int updateByPrimaryKey(T t) throws BizException;
	
	/**
	 * map 分页参数，必须传入 <pre> pageNo 第几页(必须填写，否则无法分页)  </pre> <pre> pageSize 每页多少条(必须填写，否则无法分页)</pre>
	 * 
	 * @param paramMap
	 * @return
	 * @throws BizException
	 */
	PageInfo<T> queryPageByParam(Map<String,Object> paramMap) throws BizException;


}
