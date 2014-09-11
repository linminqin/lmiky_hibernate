package com.lmiky.jdp.util;

import java.io.Serializable;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.SerializationUtils;

/**
 * 对象工具
 * @author lmiky
 * @date 2014-1-15
 */
public class ObjectUtils {

	/**
	 * 对象序列化为十六进制字符串
	 * @author lmiky
	 * @date 2014-1-15
	 * @param obj
	 * @return
	 */
	public static String serializeHexString(Serializable obj) {
		byte[] parameterBytes = SerializationUtils.serialize(obj);
		return Hex.encodeHexString(parameterBytes);
	}
	
	/**
	 * 将十六进制字符串反序列化为对象
	 * @author lmiky
	 * @date 2014-1-15
	 * @param obj
	 * @return
	 * @throws DecoderException 
	 */
	public static Object deserializeHexString(String hexString) throws DecoderException {
		return (Object) SerializationUtils.deserialize(Hex.decodeHex(hexString.toCharArray()));
	}
}
