package com.lmiky.jdp.service;

import java.util.List;
import java.util.Map;

import com.lmiky.jdp.database.model.PropertyFilter;
import com.lmiky.jdp.database.model.Sort;
import com.lmiky.jdp.database.pojo.BasePojo;
import com.lmiky.jdp.service.exception.ServiceException;

/**
 * 业务接口
 * @author lmiky
 * @date 2013-4-15
 */
public interface BaseService {

	/**
	 * 根据主键获取对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, Long id) throws ServiceException;
	
	/**
	 * 根据属性获取对象
	 * @author lmiky
	 * @date 2014-8-13 下午5:32:32
	 * @param pojoClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, String propertyName, Object propertyValue) throws ServiceException;
	
	/**
	 * 根据属性获取对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws ServiceException;
	
	/**
	 * 根据属性获取对象
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> T find(Class<T> pojoClass, PropertyFilter... propertyFilters) throws ServiceException;
	
	/**
	 * 保存对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojo
	 * @throws ServiceException
	 */
	public <T extends BasePojo> void save(T pojo) throws ServiceException;
	
	/**
	 * 保存对象
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojos
	 * @throws ServiceException
	 */
	public <T extends BasePojo> void save(List<T> pojos) throws ServiceException;
	
	/**
	 * 修改单个属性
	 * @author lmiky
	 * @date 2014-1-26
	 * @param pojoClass
	 * @param id
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, Long id, String propertyName, Object propertyValue) throws ServiceException;
	
	/**
	 * 修改属性
	 * @author lmiky
	 * @date 2014-1-26
	 * @param pojoClass
	 * @param id
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, Long id, Map<String, Object> params) throws ServiceException;
	
	/**
	 * 根据条件修改
	 * @author lmiky
	 * @date 2014年8月13日 下午9:48:37
	 * @param pojoClass
	 * @param condition
	 * @param updateValue
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, Map<String, Object> condition, Map<String, Object> updateValue) throws ServiceException;
	
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
	 * @throws ServiceException
	 */
	public <T extends BasePojo> boolean update(Class<T> pojoClass, String conditionFieldName, Object conditionFieldValue, String updateFieldName, Object updateFieldValue) throws ServiceException;
	
	/**
	 * 删除对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojo
	 * @throws ServiceException
	 */
	public <T extends BasePojo> void delete(T pojo) throws ServiceException;
	
	/**
	 * 批量删除
	 * @author lmiky
	 * @date 2013-6-24
	 * @param pojos
	 * @throws ServiceException
	 */
	public <T extends BasePojo> void delete(List<T> pojos) throws ServiceException;
	
	/**
	 * 删除对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param id
	 * @throws ServiceException
	 */
	public <T extends BasePojo> void delete(Class<T> pojoClass, Long id) throws ServiceException;
	
	/**
	 * 批量删除对象
	 * @author lmiky
	 * @date 2013-6-24
	 * @param pojoClass
	 * @param ids
	 * @throws ServiceException
	 */
	public <T extends BasePojo> void delete(Class<T> pojoClass, Long[] ids) throws ServiceException;
	
	/**
	 * 批量删除
	 * @author lmiky
	 * @date 2014-8-13 下午5:16:48
	 * @param pojoClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> int delete(Class<T> pojoClass, String propertyName, Object propertyValue) throws ServiceException;
	
	/**
	 * 批量删除
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters 过滤条件
	 * @return	 删除数量
	 * @throws ServiceException
	 */
	public <T extends BasePojo> int delete(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws ServiceException;
	
	/**
	 * 批量删除
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> int delete(Class<T> pojoClass, PropertyFilter... propertyFilters) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2014-1-3
	 * @param pojoClass
	 * @param propertyFilter
	 * @param sort
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, PropertyFilter propertyFilter, Sort sort) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters	过滤条件
	 * @param sorts	排序
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, List<PropertyFilter> propertyFilters, List<Sort> sorts) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, PropertyFilter... propertyFilters) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param sorts
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, Sort... sorts) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param pageFirst 从第几条记录开始查询
	 * @param pageSize	查询几条记录
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, int pageFirst, int pageSize) throws ServiceException;
	
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
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass,  List<PropertyFilter> propertyFilters, List<Sort> sorts, int pageFirst, int pageSize) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param pageFirst
	 * @param pageSize
	 * @param propertyFilters
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, int pageFirst, int pageSize, PropertyFilter... propertyFilters) throws ServiceException;
	
	/**
	 * 查询对象列表
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param pageFirst
	 * @param pageSize
	 * @param sorts
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> List<T> list(Class<T> pojoClass, int pageFirst, int pageSize, Sort... sorts) throws ServiceException;
	
	/**
	 * 计算数量
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> int count(Class<T> pojoClass) throws ServiceException;
	
	/**
	 * 计算数量
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters	过滤条件
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> int count(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws ServiceException;
	
	/**
	 * 计算数量
	 * @author lmiky
	 * @date 2013-5-29
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> int count(Class<T> pojoClass, PropertyFilter... propertyFilters) throws ServiceException;
	
	/**
	 * 判断是否存在
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pojoClass
	 * @param propertyFilters	过滤条件
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> boolean exist(Class<T> pojoClass, List<PropertyFilter> propertyFilters) throws ServiceException;
	
	/**
	 * 判断是否存在
	 * @author lmiky
	 * @date 2013-5-30
	 * @param pojoClass
	 * @param propertyFilters
	 * @return
	 * @throws ServiceException
	 */
	public <T extends BasePojo> boolean exist(Class<T> pojoClass, PropertyFilter... propertyFilters) throws ServiceException;
	
}
