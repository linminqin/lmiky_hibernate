<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/taglibs.jsp" %>
<c:set var="isFavorited" value="${false}" />
<favorite:inMyMenu menuId="${param.menuId }">
	<c:set var="isFavorited" value="${true}" />
	<button type="button" class="btn" onClick="removeMyFavoriteMenu('${param.menuId }', this)"><i class="icon-star-empty"></i> 取消收藏</button>
</favorite:inMyMenu>
<c:if test="${!isFavorited }">
	<button type="button" class="btn" onClick="addMyFavoriteMenu('${param.menuId }', this)"><i class="icon-star"></i> 添加到收藏夹</button>
</c:if>