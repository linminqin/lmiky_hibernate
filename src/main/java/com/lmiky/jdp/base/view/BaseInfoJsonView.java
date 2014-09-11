package com.lmiky.jdp.base.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.lmiky.jdp.base.controller.BaseController;
import com.lmiky.jdp.json.util.JsonUtils;
import com.lmiky.jdp.web.util.ResponseUtils;

/**
 * 基本信息视图
 * @author lmiky
 * @date 2014-1-11
 */
@Component
public class BaseInfoJsonView extends AbstractView {
	public static final String KEY_ERROR_INFO_KEY = BaseController.ERROR_INFO_KEY;
	public static final String KEY_MESSAGE_INFO_KEY = BaseController.MESSAGE_INFO_KEY;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		fillErrorInfo(map, request, response, resultMap);
		fillMessageInfo(map, request, response, resultMap);
		fillOtherInfo(map, request, response, resultMap);
		String json = JsonUtils.toJson(resultMap);
		ResponseUtils.write(response, json);
	}

	/**
	 * 填充提醒信息
	 * @author lmiky
	 * @date 2014-1-11
	 * @param map
	 * @param request
	 * @param response
	 * @param resultMap
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected void fillErrorInfo(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap)
			throws Exception {
		List<String> errorInfos = (List<String>) map.get(BaseController.ERROR_INFO_KEY);
		if (errorInfos == null) {
			errorInfos = new ArrayList<String>();
		}
		resultMap.put(KEY_ERROR_INFO_KEY, errorInfos);
	}
	
	/**
	 * 填充提醒信息
	 * @author lmiky
	 * @date 2014-1-11
	 * @param map
	 * @param request
	 * @param response
	 * @param resultMap
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected void fillMessageInfo(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap)
			throws Exception {
		List<String> messageInfos = (List<String>) map.get(BaseController.MESSAGE_INFO_KEY);
		if (messageInfos == null) {
			messageInfos = new ArrayList<String>();
		}
		resultMap.put(KEY_MESSAGE_INFO_KEY, messageInfos);
	}

	/**
	 * 填充其他信息
	 * @author lmiky
	 * @date 2014-1-11
	 * @param map
	 * @param request
	 * @param response
	 * @param resultMap
	 * @throws Exception
	 */
	protected void fillOtherInfo(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap)
			throws Exception {

	}
}
