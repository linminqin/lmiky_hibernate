<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/taglibs.jsp" %>
<lauthority:checkAuthority authorityCode="${param.authorityCode }">
	<button type="button" class="btn" onClick="batchDelete('<c:url value="/" />${param.deleteUrl }')"><i class="icon-remove"></i> 批量删除</button>
</lauthority:checkAuthority>