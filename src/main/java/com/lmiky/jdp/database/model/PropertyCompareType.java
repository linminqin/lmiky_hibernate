package com.lmiky.jdp.database.model;

/**
 * 属性比较类型
 * @author lmiky
 * @date 2013-4-17
 */
public enum PropertyCompareType {
	/**
	 * 等于：=
	 */
	EQ,
	/**
	 * 不等于：!=
	 */
	NE,
	/**
	 * 大于：>
	 */
	GT,
	/**
	 * 大于等于：>=
	 */
	GE,
	/**
	 * 小于：<
	 */
	LT,
	/**
	 * 小于等于：<=
	 */
	LE,
	/**
	 * 模糊查询：%?%
	 */
	LIKE,
	/**
	 * 左模糊查询：%?
	 */
	LLIKE,
	/**
	 * 右模糊查询：?%
	 */
	RLIKE,
	/**
	 * 不匹配模糊查询：not like %?%
	 */
	NLIKE,
	/**
	 * 不匹配左模糊查询：not like %?
	 */
	NLLIKE, 
	/**
	 * 不匹配右模糊查询：not like ?%
	 */
	NRLIKE,
	/**
	 * 不为空：is not null
	 */
	NNULL,
	/**
	 * 不为空：is null
	 */
	NULL;
}