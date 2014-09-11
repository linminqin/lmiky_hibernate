<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.lmiky.jdp.constants.Constants" %>
<input type="hidden" name="<%=Constants.HTTP_PARAM_MODULE_PATH %>" value="${modulePath }" />
<input type="hidden" name="<%=Constants.HTTP_PARAM_SUBMENU_ID %>" value="${subMenu.id }" />
<input type="hidden" name="<%=Constants.HTTP_PARAM_MENU_FROM %>" value="${param.menuFrom }" />
<input type="hidden" name="${httpParamOpenMode }" value="${openMode }"/>
<c:if test="${not empty pojo.id}">
	<input type="hidden" name="id" value="${pojo.id}"/>
</c:if>