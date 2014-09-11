<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/common.jsp"%>
<%@ page import="com.lmiky.jdp.system.menu.controller.MenuController" %>
<div id="breadcrumb">
	<a href="<c:url value="/"/>" ><i class="icon-home" style="margin-top: -1px;"></i><%=MenuController.TOP_MENU_LABEL_MYINDEX %></a>
	<a href="<c:url value="/"/>${subMenu.url }&${httpParamMenuFrom}=${param[httpParamMenuFrom]}" ></i>${subMenu.leftMenu.topMenu.label }</a>
	<a href="javascript: void(0)" class="current">${subMenu.label }</a>
</div>