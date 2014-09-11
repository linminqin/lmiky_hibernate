package com.lmiky.jdp.service.exception;
/**
 * 业务异常
 * @author lmiky
 * @date 2013-4-15
 */
public class ServiceException extends Exception {
	private static final long serialVersionUID = -4628275519657495446L;

	public ServiceException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}
}
