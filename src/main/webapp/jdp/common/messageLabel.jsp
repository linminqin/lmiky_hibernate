<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty errorInfos || not empty messageInfos}">
	<div class="row-fluid">
			<div class="messageDiv">
</c:if>
	<%-- Error Messages --%>
	<c:if test="${not empty errorInfos}">
	    <c:forEach var="error" items="${errorInfos}">
	       	<div class="alert alert-error">
				<button class="close" data-dismiss="alert">×</button>
				<c:out value="${error}"/>
			</div>
	    </c:forEach>
	</c:if>
	<%-- Success Messages --%>
	<c:if test="${not empty messageInfos}">
	   <c:forEach var="msg" items="${messageInfos}">
	   		<div class="alert alert-success">
				<button class="close" data-dismiss="alert">×</button>
				<c:out value="${msg}"/>
			</div>
	   </c:forEach>
	</c:if>
<c:if test="${not empty errorInfos || not empty messageInfos}">
			</div>
	</div>
</c:if>