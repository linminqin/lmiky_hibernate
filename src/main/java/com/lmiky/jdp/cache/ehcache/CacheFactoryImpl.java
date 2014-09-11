package com.lmiky.jdp.cache.ehcache;


import net.sf.ehcache.CacheManager;

import com.lmiky.jdp.cache.CacheFactory;
import com.lmiky.jdp.cache.ehcache.model.ObjectCacheImpl;
import com.lmiky.jdp.cache.model.ObjectCache;
import com.lmiky.jdp.util.Environment;

/**
 * EHCache缓存工厂
 * @author lmiky
 * @date 2013-4-22
 */
public class CacheFactoryImpl implements CacheFactory {
	private CacheManager cacheManager;
	private String configPath;	//配置文件路径
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.cache.CacheFactory#getCache(java.lang.String)
	 */
	public ObjectCache getCache(String cacheName) {
		return new ObjectCacheImpl(cacheManager.getCache(cacheName));
	}
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.cache.CacheFactory#clearAll()
	 */
	public void clearAll() {
		cacheManager.clearAll();
	}
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.cache.CacheFactory#init()
	 */
	public void init() {
		cacheManager = new CacheManager(Environment.getClassPath() + configPath);
	}
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.cache.CacheFactory#destory()
	 */
	public void destory() {
		cacheManager.shutdown();
	}

	/**
	 * @return the configPath
	 */
	public String getConfigPath() {
		return configPath;
	}

	/**
	 * @param configPath the configPath to set
	 */
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}
}
