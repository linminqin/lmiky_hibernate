<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<html>
<head>
	<%@ include file="/jdp/common/header.jsp"%>
	<%@ include file="/jdp/form/header.jsp" %>
</head>
<body class="alert-body">
	<div id="mimi-content">
		<div class="container-fluid">
			<div class="row-fluid">
				<form:form id="mainForm" action="${ctx}/cms/directory/save.shtml" method="post" commandName="pojo" class="form-horizontal">
						<%@ include file="/jdp/form/field.jsp" %>
						<input type="hidden" name="parentId" value="${parentId }"/>
						<div class="form-table">
							<div class="nopadding" style="text-align: center;">
								<%@ include file="/jdp/form/messages.jsp" %>
								<jsp:include page="<%=(String)request.getAttribute(com.lmiky.jdp.form.controller.FormController.HTTP_PARAM_FORM_SUBFORM)%>" />
							</div>
						</div>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="/jdp/common/scripts.jsp"%>
</body>
</html>