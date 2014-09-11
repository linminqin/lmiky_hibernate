package com.lmiky.jdp.database.exception;
/**
 * 数据库异常
 * @author lmiky
 * @date 2013-4-15
 */
public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = -7687018460859180221L;
	
	/**
	 * 
	 */
	public DatabaseException() {
		super();
	}

	/**
	 * @param message
	 */
	public DatabaseException(String message) {
		super(message);
	}
}
