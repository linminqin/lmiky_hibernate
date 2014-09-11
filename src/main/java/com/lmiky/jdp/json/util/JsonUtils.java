package com.lmiky.jdp.json.util;

import com.lmiky.jdp.json.JsonMapper;
import com.lmiky.jdp.util.Environment;
import com.lmiky.jdp.util.PropertiesUtils;

/**
 * json工具类
 * @author lmiky
 * @date 2013-5-19
 */
public class JsonUtils {
	private static JsonMapper jsonMapper = (JsonMapper)Environment.getBean(PropertiesUtils.getStringContextValue("json.jsonMapperName"));
	
	/**
	 * 将对象转为json字符串
	 * @author lmiky
	 * @date 2013-5-19
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		return jsonMapper.toJson(object);
	}
	
	/**
	 * 将json转为对象
	 * @author lmiky
	 * @date 2013-5-19
	 * @param json
	 * @param objectClass
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> objectClass) {
		return jsonMapper.fromJson(json, objectClass);
	}
	
}
