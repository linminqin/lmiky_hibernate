package com.lmiky.jdp.exception;
/**
 * 解析异常
 * @author lmiky
 * @date 2013-10-13
 */
public class ParseException extends Exception {
	private static final long serialVersionUID = -2132945671965137771L;

	/**
	 * 
	 */
	public ParseException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public ParseException(String message) {
		super(message);
	}
}
