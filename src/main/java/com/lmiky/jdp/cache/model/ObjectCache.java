package com.lmiky.jdp.cache.model;

import java.io.Serializable;

import com.lmiky.jdp.cache.exception.CacheException;

/**
 * 对象缓存
 * @author lmiky
 * @date 2013-4-23
 */
public interface ObjectCache extends Serializable {
	/**
	 * 放入缓存
	 * @author
	 * @date 2013-4-23
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void put(String key, CacheData value) throws CacheException;
	
	/**
	 * 读取缓存
	 * @author
	 * @date 2013-4-23
	 * @param key
	 * @return
	 * @throws CacheException
	 */
	public CacheData get(String key) throws CacheException;
	
	/**
	 * 删除
	 * @author
	 * @date 2013-4-23
	 * @param key
	 * @throws CacheException
	 */
	public void remove(String key) throws CacheException;
}
