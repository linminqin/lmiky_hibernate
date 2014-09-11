<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/tld/lmiky-lhtml.tld" prefix="lhtml" %>
<%@ taglib uri="/WEB-INF/tld/lmiky-lauthority.tld" prefix="lauthority" %>
<%@ taglib uri="/WEB-INF/tld/lmiky-favorite.tld" prefix="favorite" %>
<%@ taglib uri="/WEB-INF/tld/lmiky-lresource.tld" prefix="lresource" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="script" value="${ctx}/jdp/scripts"/>
<c:set var="scriptPlugin" value="${script}/plugins"/>
<c:set var="css" value="${ctx}/jdp/themes/default/styles"/>
<c:set var="images" value="${ctx}/jdp/themes/default/img"/>