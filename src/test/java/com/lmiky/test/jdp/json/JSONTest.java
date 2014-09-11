package com.lmiky.test.jdp.json;


import java.util.HashMap;
import java.util.Map;


import org.junit.Test;

import com.lmiky.jdp.json.util.JsonUtils;
import com.lmiky.test.BaseTest;

/**
 * @author lmiky
 * @date 2013-5-19
 */
public class JSONTest extends BaseTest {
	
	@Test
	public void testToJson() throws Exception {
		Map<String, String> retMap = new HashMap<String, String>();
		retMap.put("code", "0");
		retMap.put("msg", "收藏成功！");
		System.out.println(JsonUtils.toJson(retMap));
	}
	
}
