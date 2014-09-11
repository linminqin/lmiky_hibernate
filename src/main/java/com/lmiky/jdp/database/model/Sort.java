package com.lmiky.jdp.database.model;

import java.io.Serializable;

/**
 * 排序
 * @author lmiky
 * @date 2013-4-15
 */
public class Sort implements Serializable {
	private static final long serialVersionUID = -970518902484210610L;
	// 排序方式
	public static final String SORT_TYPE_ASC = "asc"; // 升序
	public static final String SORT_TYPE_DESC = "desc"; // 降序

	private String propertyName;
	private String sortType;
	private Class<?> sortClass;// 被排序的对象类

	/**
	 * 
	 */
	public Sort() {

	}

	/**
	 * @param propertyName
	 * @param sortType
	 * @param sortClass
	 */
	public Sort(String propertyName, String sortType, Class<?> sortClass) {
		this.propertyName = propertyName;
		this.sortType = sortType;
		this.sortClass = sortClass;
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
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}

	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	/**
	 * @return the sortClass
	 */
	public Class<?> getSortClass() {
		return sortClass;
	}

	/**
	 * @param sortClass the sortClass to set
	 */
	public void setSortClass(Class<?> sortClass) {
		this.sortClass = sortClass;
	}
}
