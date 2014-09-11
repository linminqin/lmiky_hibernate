package com.lmiky.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 测试积累
 * @author lmiky
 * @date 2013-4-15
 */
@ContextConfiguration(locations={
		"classpath:config/applicationContext*.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {

}
