package com.lmiky.jdp.sort.pojo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 基本排序实体类
 * @author lmiky
 * @date 2013-10-24
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseSortPojo extends BasePojo {
	public static final String POJO_FIELD_NAME_SORT = "sort";
	
	public static int DEFAULT_SORT = 0;
	
	private Integer sort = DEFAULT_SORT;

	/**
	 * @return the sort
	 */
	@Column(name="sort")
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
