<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/taglibs.jsp" %>
<lauthority:checkAuthority authorityCode="${param.authorityCode }">
		<button type="button" class="btn" onClick="redirectPage('<c:url value="/" />${param.addUrl }')"><i class="icon-plus"></i> 添加</button>
</lauthority:checkAuthority>