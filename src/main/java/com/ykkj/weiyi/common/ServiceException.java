package com.ykkj.weiyi.common;

/**
 * 服务层异常
 * @author Administrator
 *
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -3911894802863290855L;

	public int errorCode = 500;// HttpStatus.INTERNAL_SERVER_ERROR.value();

	public ServiceException() {
	}

	public ServiceException(int errorCode) {
		this.errorCode = errorCode;
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
}