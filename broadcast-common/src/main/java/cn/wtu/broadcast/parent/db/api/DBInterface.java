package cn.wtu.broadcast.parent.db.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.parent.exceptions.DBException;

/**
 * 版权：c-bons<br/>
 * 作者：win <br/>
 * 生成日期：2013-11-19 <br/>
 * 描述：数据库操作父接口,提供增删改查基本方法
 */
public interface DBInterface<T extends Serializable> {

	/**
	 * 根据主键删除记录
	 * 
	 * @param tid
	 *            主键id
	 * 
	 * @return 删除记录数
	 */
	int deleteByPrimaryKey(Integer id) throws DBException;

	int deleteByPrimaryKey(String id) throws DBException;

	/**
	 * 插入记录对象所有属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 插入记录数
	 */
	int insert(T record) throws DBException;

	/**
	 * 插入记录对象不为空的属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 插入记录数
	 */
	int insertSelective(T record) throws DBException;

	/**
	 * 根据主键id查询记录对象
	 * 
	 * @param tid
	 *            主键id
	 * 
	 * @return 记录对象
	 */
	T selectByPrimaryKey(Integer id) throws DBException;

	/**
	 * 根据主键id查询记录对象
	 * 
	 * @param tid
	 *            主键id
	 * 
	 * @return 记录对象
	 */
	T selectByPrimaryKey(String id) throws DBException;

	/**
	 * 更新记录对象不为空的属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 更新记录数
	 */
	int updateByPrimaryKeySelective(T record) throws DBException;

	/**
	 * 更新记录对象所有属性
	 * 
	 * @param t
	 *            记录对象
	 * 
	 * @return 更新记录数
	 */
	int updateByPrimaryKey(T record) throws DBException;
	
	/**
	 * 查询带分页的信息
	 * @param paramMap
	 * @return
	 * @throws DBException
	 */
	List<T> queryPageByParam(Map<String,Object> paramMap) throws DBException;

}
