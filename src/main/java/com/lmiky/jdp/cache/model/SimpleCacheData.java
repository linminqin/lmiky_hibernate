package com.lmiky.jdp.cache.model;

/**
 * 简单缓存数据
 * @author lmiky
 * @date 2013-6-16
 */
public class SimpleCacheData<T> extends CacheData {
	private static final long serialVersionUID = 7611366933778913246L;
	private T value;
	public SimpleCacheData(T value) {
		this.value = value;
	}
	/**
	 * 获取数据值
	 * @author lmiky
	 * @date 2013-6-16
	 * @return
	 */
	public T getValue() {
		return value;
	}
}
