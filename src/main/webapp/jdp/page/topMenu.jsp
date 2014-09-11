<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/common.jsp" %>
<%@ page import="com.lmiky.jdp.system.menu.controller.MenuController" %>
<div id="header">
	<h1><a href="https://github.com/linminqin/lmiky">lmiky开发平台</a></h1>
</div>
<div id="user-nav" class="navbar navbar-inverse">
	<ul class="nav btn-group">
     	<li class="btn btn-inverse"><a title="" href="javascript: void(0)"><i class="icon icon-user"></i> <span class="text">${sessionScope.sessionInfo.userName }</span></a></li>
		<li class="btn btn-inverse"  onClick="openDialog('<c:url value="/"/>operator/toModifyPassword.shtml',  420, 300, '修改密码')"><a title="" href="#"><i class="icon icon-pencil"></i> <span class="text">修改密码</span></a></li>
		<li class="btn btn-inverse"><a title="" href="<c:url value="/sso/login/logout.shtml"/>"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
	</ul>
</div>
<div class="container_menu">
	<div id="menu-nav" class="navbar navbar-inverse" style="z-index: 20">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="<c:url value="/"/>"><span class="text"><%=MenuController.TOP_MENU_LABEL_MYINDEX %></span></a></li>
			<c:forEach items="${sessionScope.sessionInfo.topMenus }" var="topMenu" varStatus="status">
				<li class="btn btn-inverse"><a title="" href="<c:url value="/"/>${topMenu.leftMenus[0].subMenus[0].url }&${httpParamMenuFrom}=${topMenu.id}"><span class="text">${topMenu.label }</span></a></li>
			</c:forEach>
		</ul>
	</div>
</div>