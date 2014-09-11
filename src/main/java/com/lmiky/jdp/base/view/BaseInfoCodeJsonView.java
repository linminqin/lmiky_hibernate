package com.lmiky.jdp.base.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 基本信息结果码视图
 * @author lmiky
 * @date 2014-1-11
 */
@Component
public class BaseInfoCodeJsonView extends BaseInfoJsonView {
	public static final String KEY_CODE_NAME = "code";

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.base.view.BaseInfoJsonView#fillOtherInfo(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.util.Map)
	 */
	@Override
	protected void fillOtherInfo(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap)
			throws Exception {
		super.fillOtherInfo(map, request, response, resultMap);
		Integer codeValue = (Integer)map.get(KEY_CODE_NAME);
		resultMap.put(KEY_CODE_NAME, codeValue == null ? BaseCode.CODE_SUCCESS : codeValue.intValue());
	}
}
