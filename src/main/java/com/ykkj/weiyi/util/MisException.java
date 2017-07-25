package com.ykkj.weiyi.util;

/**
 * 自定义异常类，用于提示消息
 *
 * @作者： 张晓东
 * @创建日期： 2015年12月12日
 *
 * @修改记录（修改时间、作者、原因）：
 */
@SuppressWarnings("serial")
public class MisException extends RuntimeException {

	public MisException(String msg) {
		super(msg);
	}

	public MisException(Throwable throwable) {
		super(throwable);
	}

	public MisException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
