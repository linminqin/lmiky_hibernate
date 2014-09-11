package com.lmiky.jdp.exception;
/**
 * 带编码的异常
 * @author lmiky
 * @date 2014-1-27
 */
public class BaseCodeException extends Exception {
	private static final long serialVersionUID = 6964382460357872032L;
	private int code;
	
	public BaseCodeException() {
		super();
	}
	
	public BaseCodeException(String message) {
		super(message);
	}
	
	public BaseCodeException(int code) {
		this();
		this.code = code;
	}
	
	public BaseCodeException(String message, int code) {
		this(message);
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
}
