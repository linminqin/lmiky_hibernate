package com.lmiky.jdp.database.dao;

import java.util.List;
import java.util.Map;

import com.lmiky.jdp.database.exception.DatabaseException;
import com.lmiky.jdp.database.model.PropertyFilter;
import com.lmiky.jdp.database.model.Sort;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * DAO接口
 * @author lmiky
 * @date 2013-4-15
 */
public interface BaseDAO {
	
	/**
	 * 根据主键获取对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param id
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, Long id) throws DatabaseException;
	
	/**
	 * 根据属性获取对象
	 * @author lmiky
	 * @date 2014-8-13 下午5:32:32
	 * @param pojoClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, String propertyName, Object propertyValue) throws DatabaseException;
	
	/**
	 * 根据属性获取对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws DatabaseException;
	
	/**
	 * 根据属性获取对象
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, PropertyFilter... propertyFilters) throws DatabaseException;
	
	/**
	 * 保存对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojo
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void save(T pojo) throws DatabaseException;
	
	/**
	 * 保存对象
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojos
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void save(List<T> pojos) throws DatabaseException;
	
	/**
	 * 添加对象
	 * @author lmiky
	 * @date 2013-8-16
	 * @param pojo
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void add(T pojo) throws DatabaseException;
	
	/**
	 * 添加对象
	 * @author lmiky
	 * @date 2013-8-16
	 * @param pojos
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void add(List<T> pojos) throws DatabaseException;
	
	/**
	 * 修改对象
	 * @author lmiky
	 * @date 2013-8-16
	 * @param pojo
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void update(T pojo) throws DatabaseException;
	
	/**
	 * 修改对象
	 * @author lmiky
	 * @date 2013-8-16
	 * @param pojos
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void update(List<T> pojos) throws DatabaseException;
	
	/**
	 * 修改单个属性
	 * @author lmiky
	 * @date 2014-1-26
	 * @param pojoClass
	 * @param id
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, Long id, String propertyName, Object propertyValue) throws DatabaseException;
	
	/**
	 * 修改属性
	 * @author lmiky
	 * @date 2014-1-26
	 * @param pojoClass
	 * @param id
	 * @param params
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, Long id, Map<String, Object> params) throws DatabaseException;
	
	/**
	 * 根据条件修改
	 * @author lmiky
	 * @date 2014年8月13日 下午9:48:37
	 * @param pojoClass
	 * @param condition
	 * @param updateValue
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, Map<String, Object> condition, Map<String, Object> updateValue) throws DatabaseException;
	
	/**
	 * 根据条件修改
	 * @author lmiky
	 * @date 2014年8月13日 下午9:56:15
	 * @param pojoClass
	 * @param conditionFieldName
	 * @param conditionFieldValue
	 * @param updateFieldName
	 * @param updateFieldValue
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, String conditionFieldName, Object conditionFieldValue, String updateFieldName, Object updateFieldValue) throws DatabaseException;
	
	/**
	 * 删除对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojo
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void delete(T pojo) throws DatabaseException;
	
	/**
	 * 批量删除对象s
	 * @author lmiky
	 * @date 2013-6-24
	 * @param pojos
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void delete(List<T> pojos) throws DatabaseException;
	
	/**
	 * 删除对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param id
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void delete(Class<T> pojoClass, Long id) throws DatabaseException;
	
	/**
	 * 批量删除对象
	 * @author lmiky
	 * @date 2013-6-24
	 * @param pojoClass
	 * @param ids
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> void delete(Class<T> pojoClass, Long[] ids) throws DatabaseException;
	
	/**
	 * 批量删除
	 * @author lmiky
	 * @date 2014-8-13 下午5:16:48
	 * @param pojoClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> int delete(Class<T> pojoClass, String propertyName, Object propertyValue) throws DatabaseException;
	
	/**
	 * 批量删除
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters 过滤条件
	 * @return	 删除数量
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> int delete(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws DatabaseException;
	
	/**
	 * 批量删除
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> int delete(Class<T> pojoClass, PropertyFilter... propertyFilters) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2014-1-3
	 * @param pojoClass
	 * @param propertyFilter
	 * @param sort
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, PropertyFilter propertyFilter, Sort sort) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters	过滤条件
	 * @param sorts	排序
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, List<PropertyFilter> propertyFilters, List<Sort> sorts) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, PropertyFilter... propertyFilters) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param sorts
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, Sort... sorts) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param pageFirst 从第几条记录开始查询
	 * @param pageSize	查询几条记录
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, int pageFirst, int pageSize) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters	过滤条件
	 * @param sorts	排序
	 * @param pageFirst	 从第几条记录开始查询
	 * @param pageSize	查询几条记录
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass,  List<PropertyFilter> propertyFilters, List<Sort> sorts, int pageFirst, int pageSize) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param pageFirst
	 * @param pageSize
	 * @param propertyFilters
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, int pageFirst, int pageSize, PropertyFilter... propertyFilters) throws DatabaseException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param pageFirst
	 * @param pageSize
	 * @param sorts
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, int pageFirst, int pageSize, Sort... sorts) throws DatabaseException;
	
	/**
	 * 计算数量
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> int count(Class<T> pojoClass) throws DatabaseException;
	
	/**
	 * 计算数量
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters	过滤条件
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> int count(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws DatabaseException;
	
	/**
	 * 计算数量
	 * @author lmiky
	 * @date 2014-8-13 下午5:38:22
	 * @param pojoClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> int count(Class<T> pojoClass, String propertyName, Object propertyValue) throws DatabaseException;
	
	/**
	 * 计算数量
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> int count(Class<T> pojoClass, PropertyFilter... propertyFilters) throws DatabaseException;
	
	/**
	 * 判断是否存在
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters	过滤条件
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> boolean exist(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws DatabaseException;
	
	/**
	 * 判断是否存在
	 * @author lmiky
	 * @date 2013-5-30
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> boolean exist(Class<T> pojoClass, PropertyFilter... propertyFilters) throws DatabaseException;
	
	/**
	 * 判断是否存在
	 * @author lmiky
	 * @date 2014-8-13 下午5:39:36
	 * @param pojoClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws DatabaseException
	 */
	public <T extends BasePojo> boolean exist(Class<T> pojoClass, String propertyName, Object propertyValue) throws DatabaseException;

}