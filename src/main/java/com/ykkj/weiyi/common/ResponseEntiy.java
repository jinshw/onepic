package com.ykkj.weiyi.common;

/**
 * @文件名： ResponseEntiy.java
 * @功能: 封装返回信息
 * @描述: 规范化返回JSON格式
 * @创建人： sunzhilei
 * @创建时间： 2015年4月10日,下午6:19:36
 * @修改人:
 * @修改时间: <修改时间>
 * @修改内容: <修改内容>
 * @版本： v1.0
 */
public class ResponseEntiy<T> {

	/**
	 * 默认返回成功码
	 */
	String result = CommonConstant.OPERATE_SUCCESS;

	/**
	 * 消息
	 */
	String message;

	/**
	 * 表格总记录数（可选）
	 */
	long total;

	/**
	 * 列表数据或对象数据（可选）
	 */
	T rows;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T data) {
		this.rows = data;
	}

}
