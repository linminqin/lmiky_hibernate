package com.lmiky.test.jdp.init.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.init.service.InitService;
import com.lmiky.test.BaseTest;

/**
 * 初始化业务测试
 * @author lmiky
 * @date 2013-10-14
 */
public class InitServiceTest extends BaseTest {
	private InitService initService;

	@Test
	public void testInit() throws Exception {
		initService.init("管理员", "admin", "admin");
	}
	
	/**
	 * @return the initService
	 */
	public InitService getInitService() {
		return initService;
	}

	/**
	 * @param initService the initService to set
	 */
	@Resource(name="initService")
	public void setInitService(InitService initService) {
		this.initService = initService;
	}
}
