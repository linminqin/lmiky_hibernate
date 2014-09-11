package com.lmiky.jdp.util;

import java.util.UUID;

/**
 * 类说明
 * @author lmiky
 * @date 2013-4-24
 */
public class UUIDGenerator {
	
		/**
		 * 生成UUID字符串
		 * @author lmiky
		 * @date 2013-4-24
		 * @return
		 */
		public static synchronized String generateString() {
			return UUID.randomUUID().toString().replace("-", "");
		}
		
}
