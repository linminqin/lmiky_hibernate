<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		<c:if test="${not empty errorInfos}">
			<c:forEach var="error" items="${errorInfos}">
				alert('${error}');
			</c:forEach>
		</c:if>
		<c:if test="${not empty messageInfos}">
			<c:forEach var="msg" items="${messageInfos}">
				alert('${msg}');
			</c:forEach>
		</c:if>
	});
</script>