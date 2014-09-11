package com.lmiky.jdp.json.jackson;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.stereotype.Component;

import com.lmiky.jdp.json.JsonMapper;
import com.lmiky.jdp.logger.util.LoggerUtils;

/**
 * jackson插件
 * @author lmiky
 * @date 2013-5-19
 */
@Component("jacksonJsonMapperImpl")
public class JsonMapperImpl implements JsonMapper {
	private ObjectMapper mapper;
	
	/* (non-Javadoc)
	 * @see com.lmiky.jdp.json.JsonMapper#init()
	 */
	@Override
	@PostConstruct
	public void init() {
		mapper = new ObjectMapper();
		//设置输出时包含属性的风格：所有属性
		mapper.setSerializationInclusion(Inclusion.ALWAYS);
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//禁止使用int代表Enum的order()來反序列化Enum,非常危險
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.json.JsonMapper#toJson(java.lang.Object)
	 */
	@Override
	public String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			LoggerUtils.error(String.format("将对象转为json字符串错误: %s", e));
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.json.JsonMapper#fromJson(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T> T fromJson(String json, Class<T> objectClass) {
		if(StringUtils.isBlank(json)) {
			return null;
		}
		try {
			return mapper.readValue(json, objectClass);
		} catch (Exception e) {
			LoggerUtils.warn("将json字符串转为对象错误: %s" + json, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.json.JsonMapper#destory()
	 */
	@Override
	@PreDestroy
	public void destory() {
		mapper = null;
	}

}
