<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty validateErrorInfos}">
	<div class="row-fluid">
			<div class="messageDiv">
				<c:forEach var="validateErrorInfo" items="${validateErrorInfos}">
					<script type="text/javascript">
						$(document).ready(function() {
							$("input[name='${validateErrorInfo.fieldName}']").parent().parent('.control-group').addClass("error");
						});
					</script>
					<div class="alert alert-error">
						<button class="close" data-dismiss="alert">×</button>
						<c:out value="${validateErrorInfo.errorDesc}" />
					</div>
				</c:forEach>
			</div>
	</div>
</c:if>
<%@ include file="/jdp/common/messageLabel.jsp"%>