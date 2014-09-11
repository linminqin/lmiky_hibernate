package com.lmiky.test.jdp.util;

import org.junit.Test;

import com.lmiky.jdp.util.StringUtils;
import com.lmiky.jdp.util.UUIDGenerator;
import com.lmiky.test.BaseTest;

/**
 * UUID生成器
 * @author lmiky
 * @date 2013-10-16
 */
public class UtilsTest extends BaseTest {
	
	@Test
	public void generate() {
		for(int i=0; i<50; i++) {
			System.out.println(UUIDGenerator.generateString());
		}
	}
	
	@Test
	public void getFirstLetterTest() {
		System.out.println(StringUtils.chinese2Spell("中国 中文 empty 靑淼"));
		System.out.println(StringUtils.chinese2Spell("people of china"));
		System.out.println(StringUtils.getChineseFirstLetterl("中国 中文 empty 靑淼"));
		System.out.println(StringUtils.getChineseFirstLetterl("people of china"));
	}
}
