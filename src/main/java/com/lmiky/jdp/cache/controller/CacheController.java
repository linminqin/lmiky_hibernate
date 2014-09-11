package com.lmiky.jdp.cache.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmiky.jdp.base.controller.BaseController;
import com.lmiky.jdp.cache.CacheFactory;

/**
 * 缓存
 * @author lmiky
 * @date 2013-10-26
 */
@Controller
@RequestMapping("/cache")
public class CacheController extends BaseController {
	private CacheFactory cacheFactory;

	
	/**
	 * 清除所有缓存
	 * @author lmiky
	 * @date 2013-10-26
	 * @param modelMap
	 * @param request
	 * @param resopnse
	 * @throws Exception
	 */
	@RequestMapping("/clearAll.shtml")
	public void clearAll(ModelMap modelMap, HttpServletRequest request, HttpServletResponse resopnse) throws Exception {
		cacheFactory.clearAll();
		resopnse.getWriter().write("success!");
		resopnse.getWriter().flush();
	}

	/**
	 * @return the cacheFactory
	 */
	public CacheFactory getCacheFactory() {
		return cacheFactory;
	}

	/**
	 * @param cacheFactory the cacheFactory to set
	 */
	@Resource(name="ehCacheFactory")
	public void setCacheFactory(CacheFactory cacheFactory) {
		this.cacheFactory = cacheFactory;
	}
}
