package com.lmiky.jdp.util;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 属性工具
 * @author lmiky
 * @date 2013-4-17
 */
public class PropertyUtils {
	
	/**
	 * 获取类的所有属性和属性类别
	 * @author lmiky
	 * @date 2013-4-17
	 * @param clazz
	 * @return
	 */
	public static Map<String, Class<?>> getPropertiesClassType(Class<?> clazz) {
		PropertyDescriptor[] descriptors = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptors(clazz);
		Map<String, Class<?>> classTypes = new HashMap<String, Class<?>>();
		for(int i=0; i<descriptors.length; i++) {
			classTypes.put(descriptors[i].getName(), descriptors[i].getPropertyType());
		}
		return classTypes;
	}
	
	/**
	 * 获取类指定字段的类别
	 * @author lmiky
	 * @date 2013-4-17
	 * @param clazz
	 * @param property 属性
	 * @return
	 */
	public static Class<?> getPropertyClassType(Class<?> clazz, String property) {
		if(StringUtils.isBlank(property)) {
			return null;
		}
		PropertyDescriptor[] descriptors = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptors(clazz);
		for(int i=0; i<descriptors.length; i++) {
			if(descriptors[i].getName().equals(property)) {
				return descriptors[i].getPropertyType();
			}
		}
		return null;
	}

}
