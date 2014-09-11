package com.lmiky.jdp.cache;

import com.lmiky.jdp.cache.model.ObjectCache;

/**
 * 缓存工厂
 * @author lmiky
 * @date 2013-4-23
 */
public interface CacheFactory {
	/**
	 * 根据名称获取缓存
	 * @author lmiky
	 * @date 2013-4-22
	 * @param cacheName
	 * @return
	 */
	public ObjectCache getCache(String cacheName);
	
	/**
	 * 清楚所有缓存
	 * @author lmiky
	 * @date 2013-10-26
	 */
	public void clearAll();
	
	/**
	 * 初始化 
	 * @author lmiky
	 * @date 2013-4-22
	 */
	public void init();
	
	/**
	 * 销毁
	 * @author lmiky
	 * @date 2013-4-22
	 */
	public void destory();
}
