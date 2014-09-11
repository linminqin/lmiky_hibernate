<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<html>
	<head>
		<title>${subMenu.label }</title>
		<%@ include file="/jdp/common/header.jsp"%>
		<%@ include file="/jdp/form/header.jsp"%>
	</head>
	<body>
		<%@ include file="/jdp/page/topMenu.jsp"%>
		<div class="container_content">
			<%@ include file="/jdp/page/leftMenu.jsp"%>
			<div id="content">
				<%@ include file="/jdp/page/location.jsp"%>
				<div class="container-fluid">
					<div class="row-fluid">
					<form:form id="mainForm" action="${ctx}/capture/task/save.shtml" method="post" commandName="pojo" class="form-horizontal">
					<%@ include file="/jdp/form/field.jsp" %>
					<div class="span12 nomargin">
						<div class="widget-box form-table">
							<div class="widget-title">
								<span class="icon">
									<c:choose>
					       				<c:when test="${param[httpParamOpenMode] == createOpenMode }"><i class="icon-align-justify"></i></c:when>
					       				<c:when test="${param[httpParamOpenMode] == editOpenMode }"><i class="icon-edit"></i></c:when>
					       				<c:otherwise><i class="icon-align-justify"></i></c:otherwise>
					       			</c:choose>
								</span>
								<h5>
									<c:choose>
					       				<c:when test="${param[httpParamOpenMode] == createOpenMode }">添加任务</c:when>
					       				<c:when test="${param[httpParamOpenMode] == editOpenMode }">修改任务</c:when>
					       				<c:otherwise>任务信息</c:otherwise>
					       			</c:choose>
								</h5>
							</div>
							<div class="nopadding">
									<%@ include file="/jdp/form/messages.jsp" %>
									<jsp:include page="<%=(String)request.getAttribute(com.lmiky.jdp.form.controller.FormController.HTTP_PARAM_FORM_SUBFORM)%>" />
							</div>
						</div>						
					</div>
					</form:form>
				</div>
				</div>
			</div>
			<%@ include file="/jdp/page/footer.jsp"%>
		</div>
		<%@ include file="/jdp/common/scripts.jsp"%>
		<script src="${script }/multipleSelect.js" type="text/javascript"></script>
	</body>
</html>