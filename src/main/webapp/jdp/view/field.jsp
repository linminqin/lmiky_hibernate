<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/taglibs.jsp"%>
<%@ page import="com.lmiky.jdp.constants.Constants" %>
<input type="hidden" name="<%=Constants.HTTP_PARAM_MODULE_PATH %>" value="${modulePath }" />
<input type="hidden" name="<%=Constants.HTTP_PARAM_SUBMENU_ID %>" value="${subMenu.id }" />
<input type="hidden" name="<%=Constants.HTTP_PARAM_MENU_FROM %>" value="${param.menuFrom }" />