package com.lmiky.jdp.view.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;

import com.lmiky.jdp.base.controller.BaseController;
import com.lmiky.jdp.base.controller.BasePojoController;
import com.lmiky.jdp.constants.Constants;
import com.lmiky.jdp.database.model.PropertyFilter;
import com.lmiky.jdp.database.model.Sort;
import com.lmiky.jdp.database.pojo.BasePojo;
import com.lmiky.jdp.database.util.PropertyFilterUtils;
import com.lmiky.jdp.database.util.SortUtils;
import com.lmiky.jdp.session.model.SessionInfo;
import com.lmiky.jdp.web.page.model.Page;
import com.lmiky.jdp.web.page.service.PageService;
import com.lmiky.jdp.web.page.util.PageUtils;

/**
 * 视图
 * @author lmiky
 * @date 2013-4-15
 */
public abstract class ViewController<T extends BasePojo> extends BasePojoController<T> {
	protected PageService pageService;

	/**
	 * 列表查询
	 * @author lmiky
	 * @date 2013-4-17
	 * @param modelMap
	 * @param request
	 * @param resopnse
	 * @return
	 */
	public String executeList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse resopnse) throws Exception {
		return executeList(modelMap, request, resopnse, BaseController.REQUESTTYPE_NORMAL);
	}

	/**
	 * 列表查询
	 * @author lmiky
	 * @date 2013-4-17
	 * @param modelMap
	 * @param request
	 * @param resopnse
	 * @param requestTyp 请求方式
	 * @return
	 */
	public String executeList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse resopnse, String requestTyp) throws Exception {
		try {
			// 判断是否有登陆
			SessionInfo sessionInfo = getSessionInfo(modelMap, request);
			// 检查单点登陆
			checkSso(sessionInfo, modelMap, request);
			// 检查权限
			checkAuthority(modelMap, request, sessionInfo, getLoadAuthorityCode(modelMap, request));
			// 生成分页信息
			Page<T> page = generatePage(modelMap, request);
			resetPage(page, modelMap, request);
			// 生成过滤条件
			List<PropertyFilter> propertyFilters = generatePropertyFilters(modelMap, request);
			appendPropertyFilters(modelMap, request, propertyFilters);
			// 生成排序
			List<Sort> sorts = generateSorts(modelMap, request);
			appendSorts(modelMap, request, sorts);
			modelMap.put("sorts", sorts);
			// 查询分页内容，将分页信息设入页面
			modelMap.put("page", fillPage(page, modelMap, request, propertyFilters, sorts, null));
			appendListAttribute(modelMap, request, resopnse);
			//设置模块
			String modulePath = getModulePath(modelMap, request);
			modelMap.put(Constants.HTTP_PARAM_MODULE_PATH, modulePath);
			//设置菜单
			setMenuInfo(modelMap, request);
			return getExecuteListRet(modelMap, request, modulePath);
		} catch (Exception e) {
			return transactException(e, modelMap, request, resopnse, requestTyp);
		}
	}

	/**
	 * 生成分页对象
	 * @author lmiky
	 * @date 2013-4-17
	 * @param modelMap
	 * @param request
	 * @return
	 */
	protected Page<T> generatePage(ModelMap modelMap, HttpServletRequest request) {
		return PageUtils.generateFromHttpRequest(request);
	}

	/**
	 * 重新设置分页信息
	 * @author lmiky
	 * @date 2013-4-17
	 * @param page
	 * @param modelMap
	 * @param request
	 */
	protected void resetPage(Page<T> page, ModelMap modelMap, HttpServletRequest request) {
		page.pageAction();
	}
	
	/**
	 * 填充分页信息
	 * @author lmiky
	 * @date 2014-7-16
	 * @param page
	 * @param modelMap
	 * @param request
	 * @param propertyFilters
	 * @param sorts
	 * @param otherElements
	 * @return
	 */
	protected Page<T> fillPage(Page<T> page, ModelMap modelMap, HttpServletRequest request, List<PropertyFilter> propertyFilters, List<Sort> sorts, Map<String, Object> otherElements) {
		return pageService.fillPage(pojoClass, page, propertyFilters, sorts);
	}

	/**
	 * 生成查询过滤
	 * @author lmiky
	 * @date 2013-4-17
	 * @param modelMap
	 * @param request
	 * @return
	 */
	protected List<PropertyFilter> generatePropertyFilters(ModelMap modelMap, HttpServletRequest request) {
		return PropertyFilterUtils.generateFromHttpRequest(request, pojoClass);

	}

	/**
	 * 添加过滤条件
	 * @author lmiky
	 * @date 2013-5-12
	 * @param modelMap
	 * @param request
	 * @param propertyFilters
	 */
	protected void appendPropertyFilters(ModelMap modelMap, HttpServletRequest request, List<PropertyFilter> propertyFilters) {
	}

	/**
	 * 生成排序
	 * @author lmiky
	 * @date 2013-4-17
	 * @param modelMap
	 * @param request
	 * @param resopnse
	 * @return
	 */
	protected List<Sort> generateSorts(ModelMap modelMap, HttpServletRequest request) {
		List<Sort> sorts = SortUtils.generateFromHttpRequest(request, pojoClass);
		//当页面请求了排序方式，且排序值为空时，即表示以该字段的“无序”方式排序
		if (sorts.isEmpty() && !hasDefaultSortParam(modelMap, request)) {
			sorts = getDefaultSort(modelMap, request);
		}
		return sorts;
	}

	/**
	 * 是否请求中已带有默认的排序参数
	 * @author lmiky
	 * @date 2014-1-26
	 * @param modelMap
	 * @param request
	 * @return
	 */
	protected boolean hasDefaultSortParam(ModelMap modelMap, HttpServletRequest request) {
		String defaultSortParamName = getDefaultSortParamName(modelMap, request);
		if(StringUtils.isBlank(defaultSortParamName)) {
			return false;
		}
		String param = request.getParameter(Constants.HTTP_PARAM_SORT_TYPE_NAME_PREFIX + defaultSortParamName);
		if(param == null) {
			return false;
		}
		return true;
	}

	/**
	 * 获取默认排序的参数名
	 * @author lmiky
	 * @date 2014-1-26
	 * @param modelMap
	 * @param request
	 * @return
	 */
	protected String getDefaultSortParamName(ModelMap modelMap, HttpServletRequest request) {
		return "";
	}

	/**
	 * 获取默认排序
	 * @author lmiky
	 * @date 2013-4-17
	 * @param modelMap
	 * @param request
	 * @return
	 */
	protected List<Sort> getDefaultSort(ModelMap modelMap, HttpServletRequest request) {
		List<Sort> sorts = new ArrayList<Sort>();
		sorts.add(new Sort("id", Sort.SORT_TYPE_DESC, pojoClass));
		return sorts;
	}

	/**
	 * 添加排序
	 * @author lmiky
	 * @date 2013-5-12
	 * @param modelMap
	 * @param request
	 * @param sorts
	 * @return
	 */
	protected void appendSorts(ModelMap modelMap, HttpServletRequest request, List<Sort> sorts) {

	}

	/**
	 * 追加属性
	 * @author lmiky
	 * @date 2013-5-13
	 * @param modelMap
	 * @param request
	 * @param resopnse
	 * @throws Exception
	 */
	protected void appendListAttribute(ModelMap modelMap, HttpServletRequest request, HttpServletResponse resopnse) throws Exception {

	}

	/**
	 * 获取列表查询返回结果
	 * @author lmiky
	 * @date 2013-4-19
	 * @param modelMap
	 * @param request
	 * @param modulePath
	 * @return
	 */
	public String getExecuteListRet(ModelMap modelMap, HttpServletRequest request, String modulePath) {
		return getViewNamePrefix(modelMap, request, modulePath) + "List";
	}

	/**
	 * 获取视图前缀
	 * @author lmiky
	 * @date 2013-4-15
	 * @param modelMap
	 * @param request
	 * @param modulePath
	 * @return
	 */
	protected String getViewNamePrefix(ModelMap modelMap, HttpServletRequest request, String modulePath) {
		if (!StringUtils.isBlank(modulePath)) {
			modulePath = modulePath + "/";
		} else {
			modulePath = "";
		}
		String controllerName = getControllerName(modelMap, request);
		return modulePath + controllerName;
	}

	/**
	 * 获取视图名
	 * @author lmiky
	 * @date 2013-5-8
	 * @param modelMap
	 * @param request
	 * @return
	 */
	public String getControllerName(ModelMap modelMap, HttpServletRequest request) {
		return this.getClass().getSimpleName().toLowerCase().replace("controller", "");
	}

	/**
	 * 获取分页服务对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @return
	 */
	public PageService getPageService() {
		return pageService;
	}

	/**
	 * 设置分页服务对象
	 * @author lmiky
	 * @date 2013-4-16
	 * @param pageService
	 */
	@Resource(name = "pageService")
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	/**
	 * @return the pojoClass
	 */
	public Class<T> getPojoClass() {
		return pojoClass;
	}

	/**
	 * @param pojoClass the pojoClass to set
	 */
	public void setPojoClass(Class<T> pojoClass) {
		this.pojoClass = pojoClass;
	}

}
