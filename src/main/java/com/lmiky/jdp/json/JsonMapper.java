package com.lmiky.jdp.json;
/**
 * JSON映射
 * @author lmiky
 * @date 2013-5-19
 */
public interface JsonMapper {
	
	/**
	 * 初始化
	 * @author lmiky
	 * @date 2013-5-19
	 */
	public void init();
	
	/**
	 * 将对象转为json格式
	 * @author lmiky
	 * @date 2013-5-19
	 * @param object
	 * @return
	 */
	public String toJson(Object object);	
	
	/**
	 * 将json转为对象
	 * @author lmiky
	 * @date 2013-5-19
	 * @param json
	 * @param objectClass
	 * @return
	 */
	public <T> T fromJson(String json, Class<T> objectClass);	
	
	/**
	 * 销毁
	 * @author lmiky
	 * @date 2013-5-19
	 */
	public void destory();
}
