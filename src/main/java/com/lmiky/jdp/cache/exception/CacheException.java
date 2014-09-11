package com.lmiky.jdp.cache.exception;
/**
 * 缓存异常
 * @author lmiky
 * @date 2013-4-23
 */
public class CacheException extends Exception {
	private static final long serialVersionUID = 346439786719062677L;

	/**
	 * 
	 */
	public CacheException(){
		super();
	}
	
	/**
	 * @param message
	 */
	public CacheException(String message) {
		super(message);
	}
}
