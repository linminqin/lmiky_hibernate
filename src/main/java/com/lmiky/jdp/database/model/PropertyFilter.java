package com.lmiky.jdp.database.model;

import java.io.Serializable;

/**
 * 属性过滤
 * @author lmiky
 * @date 2013-4-15
 */
public class PropertyFilter implements Serializable {
	private static final long serialVersionUID = -1369421021202517043L;
	private String propertyName; // 属性名
	private Object propertyValue; // 属性值
	private PropertyCompareType compareType; // 比较方式
	private boolean isCollectionField;		//是否集合字段
	private Class<?> compareClass;// 被比较的对象类

	/**
	 * 
	 */
	public PropertyFilter() {
		isCollectionField = false;
	}

	/**
	 * @param propertyName
	 * @param propertyValue
	 * @param compareType
	 * @param compareClass
	 */
	public PropertyFilter(String propertyName, Object propertyValue, PropertyCompareType compareType, Class<?> compareClass) {
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.compareType = compareType;
		isCollectionField = false;
		this.compareClass = compareClass;
	}
	
	/**
	 * @param propertyName
	 * @param propertyValue
	 * @param compareType
	 * @param isCollectionField
	 * @param compareClass
	 */
	public PropertyFilter(String propertyName, Object propertyValue, PropertyCompareType compareType, boolean isCollectionField, Class<?> compareClass) {
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.compareType = compareType;
		this.isCollectionField = isCollectionField;
		this.compareClass = compareClass;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return the propertyValue
	 */
	public Object getPropertyValue() {
		return propertyValue;
	}

	/**
	 * @param propertyValue the propertyValue to set
	 */
	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}

	/**
	 * @return the compareType
	 */
	public PropertyCompareType getCompareType() {
		return compareType;
	}

	/**
	 * @param compareType the compareType to set
	 */
	public void setCompareType(PropertyCompareType compareType) {
		this.compareType = compareType;
	}
	
	/**
	 * @return the isCollectionField
	 */
	public boolean isCollectionField() {
		return isCollectionField;
	}

	/**
	 * @param isCollectionField the isCollectionField to set
	 */
	public void setCollectionField(boolean isCollectionField) {
		this.isCollectionField = isCollectionField;
	}

	/**
	 * @return the compareClass
	 */
	public Class<?> getCompareClass() {
		return compareClass;
	}

	/**
	 * @param compareClass the compareClass to set
	 */
	public void setCompareClass(Class<?> compareClass) {
		this.compareClass = compareClass;
	}
}
