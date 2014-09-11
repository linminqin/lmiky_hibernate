package com.lmiky.jdp.sort.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lmiky.jdp.base.controller.BaseController;
import com.lmiky.jdp.database.model.PropertyFilter;
import com.lmiky.jdp.database.model.Sort;
import com.lmiky.jdp.database.pojo.BasePojo;
import com.lmiky.jdp.database.util.PropertyFilterUtils;
import com.lmiky.jdp.logger.model.OperateType;
import com.lmiky.jdp.logger.util.LoggerUtils;
import com.lmiky.jdp.service.BaseService;
import com.lmiky.jdp.session.model.SessionInfo;
import com.lmiky.jdp.sort.pojo.BaseSortPojo;
import com.lmiky.jdp.sort.service.SortService;

/**
 * 排序
 * @author lmiky
 * @date 2014-1-17
 */
@Controller
@RequestMapping("/sort")
public class SortController extends BaseController {

	/**
	 * 加载
	 * @author lmiky
	 * @date 2014-1-17
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param className
	 * @param showName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/load.shtml")
	public <T extends BaseSortPojo> String load(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "className", required = true) String className, @RequestParam(value = "showName", required = true) String showName)
			throws Exception {
		try {
			// 判断是否有登陆
			SessionInfo sessionInfo = getSessionInfo(modelMap, request);
			// 检查单点登陆
			checkSso(sessionInfo, modelMap, request);
			Class<T> sortClass = (Class<T>) Class.forName(className);
			List<Sort> sorts = new ArrayList<Sort>();
			sorts.add(new Sort(BaseSortPojo.POJO_FIELD_NAME_SORT, Sort.SORT_TYPE_DESC, sortClass));
			List<T> pojoList = service.list(sortClass, PropertyFilterUtils.generateFromHttpRequest(request, sortClass), sorts);
			//StringBuilder hql = new StringBuilder();
			//hql.append("select ").append(BasePojo.POJO_FIELD_NAME_ID).append(" as id, ").append(showName).append(" as name from ")
			//		.append(sortClass.getSimpleName()).append(" ");
			//hql.append("order by ").append(BaseSortPojo.POJO_FIELD_NAME_SORT).append(" ").append(Sort.SORT_TYPE_DESC);
			List<Object[]> pojos = new ArrayList<Object[]>();
			for(T t : pojoList) {
				Object[] object = new Object[2];
				object[0] = BeanUtils.getProperty(t, BasePojo.POJO_FIELD_NAME_ID);
				object[1] = BeanUtils.getProperty(t, showName);
				pojos.add(object);
			}
			modelMap.put("pojos", pojos);
			modelMap.put("className", className);
			modelMap.put("showName", showName);
			return "jdp/sort/load";
		} catch (Exception e) {
			return transactException(e, modelMap, request, response);
		}
	}

	/**
	 * 保存
	 * @author lmiky
	 * @date 2014-1-17
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param className
	 * @param showName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save.shtml")
	public <T extends BaseSortPojo> String save(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "className", required = true) String className, @RequestParam(value = "showName", required = true) String showName)
			throws Exception {
		try {
			// 判断是否有登陆
			SessionInfo sessionInfo = getSessionInfo(modelMap, request);
			// 检查单点登陆
			checkSso(sessionInfo, modelMap, request);
			Class<T> sortClass = (Class<T>) Class.forName(className);
			String[] selectedPojos = request.getParameterValues("selectedPojos");
			if (selectedPojos == null || selectedPojos.length == 0) {
				putMessage(modelMap, "请选择要排序的内容!");
			} else {
				List<PropertyFilter> propertyFilters = PropertyFilterUtils.generateFromHttpRequest(request, sortClass);
				((SortService) service).sort(sortClass, selectedPojos, propertyFilters);
				putMessage(modelMap, "保存成功!");
				LoggerUtils.save(request, className, null, sessionInfo.getUserId(), sessionInfo.getUserName(), OperateType.OPE_TYPE_SORT, this.getClass().getName(), null, service);
			}
			return load(modelMap, request, response, className, showName);
		} catch (Exception e) {
			return transactException(e, modelMap, request, response);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.lmiky.jdp.base.controller.BaseController#setService(com.lmiky.jdp.service.BaseService)
	 */
	@Resource(name = "sortService")
	public void setService(BaseService service) {
		super.setService(service);
	}
}