package com.ykkj.weiyi.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class BeanOperateUtil {

	private Object currentObject;
	private String attribute;
	private Object value;
	private List<Object> values;

	private BeanOperateUtil(Object obj, String attribute) {
		this.currentObject = obj; // 保存当前的操作对象
		this.attribute = attribute;
	}

	/**
	 * 要设置通过反射操作的属性名称以及属性内容
	 * 
	 * @param obj包含实例化对象的类
	 * @param attribute要操作的属性名称
	 * @param value要设置的内容
	 */
	public BeanOperateUtil(Object obj, String attribute, List<Object> values) {
		this(obj, attribute);
		this.values = values;
		this.handleParameter(); // 直接进行参数的匹配
	}

	/**
	 * 要设置通过反射操作的属性名称以及属性内容
	 * 
	 * @param obj包含实例化对象的类
	 * @param attribute要操作的属性名称
	 * @param value要设置的内容
	 */
	public BeanOperateUtil(Object obj, String attribute, Object value) {
		this.currentObject = obj; // 保存当前的操作对象
		this.attribute = attribute;
		this.value = value;
		this.handleParameter(); // 直接进行参数的匹配
	}

	/**
	 * 因为具体的Bean操作对外部而言没有任何的意义，所以将其设置为私有操作
	 * 其目的是根据属性的结构进行拆分，而后调用相应的setter方法设置具体的内容
	 */
	private void handleParameter() {
		try {
			Object valueObject = null; // 最终设置的内容
			Field field = this.currentObject.getClass().getDeclaredField(this.attribute);
			switch (field.getType().getSimpleName()) {
				case "String": {
					valueObject = this.value;
					break ;
				}
				case "List": {
					valueObject = this.values; // 直接保存List集合
					break ;
				}
			}
			Method setMethod = this.currentObject.getClass().getMethod(
					"set" + StringUtils.initcap(this.attribute), field.getType());
			setMethod.invoke(this.currentObject, valueObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
