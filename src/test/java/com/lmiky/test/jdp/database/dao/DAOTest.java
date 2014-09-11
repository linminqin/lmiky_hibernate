package com.lmiky.test.jdp.database.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.database.dao.BaseDAO;
import com.lmiky.test.BaseTest;

/**
 * DAO测试
 * @author lmiky
 * @date 2013-4-15
 */
public class DAOTest extends BaseTest{
	private BaseDAO baseDAO;
	
	@Test
	public void testGetDAO() {
		System.out.println(baseDAO);
	}

	/**
	 * @param dao the dao to set
	 */
	@Resource(name="baseDAO")
	public void setDao(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
}
