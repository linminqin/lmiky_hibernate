package com.lmiky.jdp.cache.ehcache.model;

import com.lmiky.jdp.cache.exception.CacheException;
import com.lmiky.jdp.cache.model.CacheData;
import com.lmiky.jdp.cache.model.ObjectCache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * 对象缓存模型
 * @author lmiky
 * @date 2013-4-22
 */
public class ObjectCacheImpl implements ObjectCache {
	private static final long serialVersionUID = -6789575390220937818L;
	
	private Cache cache;
	
	/**
	 * 
	 */
	public ObjectCacheImpl() {
		
	}
	/**
	 * @param cache
	 */
	public ObjectCacheImpl(Cache cache) {
		this.cache = cache;
	}
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.cache.model.ObjectCache#put(java.lang.String, com.lmiky.jdp.cache.model.CacheData)
	 */
	public void put(String key, CacheData value) throws CacheException {
		try {
			cache.put(new Element(key, value));
		} catch(Exception e) {
			throw new CacheException(e.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.cache.model.ObjectCache#get(java.lang.String)
	 */
	public CacheData get(String key) throws CacheException {
		try {
			Element element = cache.get(key);
			if(element == null) {
				return null;
			}
			return (CacheData) element.getObjectValue();
		} catch(Exception e) {
			throw new CacheException(e.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.cache.model.ObjectCache#remove(java.lang.String)
	 */
	public void remove(String key) throws CacheException {
		try {
			cache.remove(key);
		} catch(Exception e) {
			throw new CacheException(e.getMessage());
		}
	}
	
	/**
	 * @return the cache
	 */
	public Cache getCache() {
		return cache;
	}
	/**
	 * @param cache the cache to set
	 */
	public void setCache(Cache cache) {
		this.cache = cache;
	}
}
