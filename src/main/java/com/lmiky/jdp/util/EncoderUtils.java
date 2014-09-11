package com.lmiky.jdp.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 编码
 * @author lmiky
 * @date 2014-1-23
 */
public class EncoderUtils {
	
	/**
	 * MD5加密
	 * @author lmiky
	 * @date 2014-1-23
	 * @param encodeStr
	 * @return
	 */
	public static String md5(String encodeStr) {
		return DigestUtils.md5Hex(encodeStr).toUpperCase();
	}
	
}
