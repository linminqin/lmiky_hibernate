package com.lmiky.test.jdp.cache;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.cache.CacheFactory;
import com.lmiky.jdp.cache.exception.CacheException;
import com.lmiky.jdp.cache.model.ObjectCache;
import com.lmiky.test.BaseTest;

/**
 * 类说明
 * @author lmiky
 * @date 2013-4-22
 */
public class CacheTest extends BaseTest {
	private CacheFactory cacheFactory;

	@Test
	public void test1() {
		System.out.println(cacheFactory);
	}
	
	@Test
	public void test2() {
		System.out.println(cacheFactory.getCache("formLockCache"));
	}
	
	@Test
	public void test3() throws CacheException {
		ObjectCache cache = cacheFactory.getCache("formLockCache");
		//cache.put("test", "test");
		System.out.println(cache.get("test"));
		for(int i=0; i<=30000; i++) {
			//cache.put("test" + i, "test" + i);
		}
		System.out.println(cache.get("test"));
	}
	
	/**
	 * @return the cacheFactory
	 */
	public CacheFactory getCacheFactory() {
		return cacheFactory;
	}

	/**
	 * @param cacheFactory the cacheFactory to set
	 */
	@Resource(name="ehCacheFactory")
	public void setCacheFactory(CacheFactory cacheFactory) {
		this.cacheFactory = cacheFactory;
	}
}
