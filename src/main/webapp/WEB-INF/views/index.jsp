<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lmiky.jdp.system.menu.model.SubMenu"%>
<%
	SubMenu subMenu = (SubMenu)request.getAttribute("welcomeMenu");
	if(subMenu != null) {
		request.getRequestDispatcher("/" + subMenu.getUrl()).forward(request, response);	
	}
%>