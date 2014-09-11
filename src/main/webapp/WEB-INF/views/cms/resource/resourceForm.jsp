<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<%@ page import="com.lmiky.cms.resource.pojo.CmsResource,com.lmiky.cms.resource.controller.ResourceController" %>
<c:set var="state_create" value="<%=CmsResource.STATE_CREATE %>"/>
<c:set var="state_publish" value="<%=CmsResource.STATE_PUBLISH %>"/>
<c:set var="state_unpublish" value="<%=CmsResource.STATE_UNPUBLISH %>"/>
<html>
	<head>
		<title>${subMenu.label }</title>
		<%@ include file="/jdp/common/header.jsp"%>
		<%@ include file="/jdp/form/header.jsp"%>
		<%@ include file="/jdp/htmleditor/htmlEditorStyle.jsp"%>
		<%@ include file="/jdp/file/uploadStyle.jsp"%>
		<style type="text/css">
			.pictureSnapshotBlock {
				display: inline-block; 
				margin: 0 0 5px;
			}
			.pictureSnapshot {
				height: 120px; 
				width: 120px;
			}
			.pictureSnapshotCancel {
				position: relative; 
				top: -52px; 
				cursor: pointer; 
				margin-right: 10px;
			}
		</style>
	</head>
	<body class="iframe-body">
					<div class="row-fluid" style="margin-top: 20px;">
					<form:form id="mainForm" action="${ctx}/cms/resource/save.shtml" method="post" commandName="pojo" class="form-horizontal">
					<%@ include file="/jdp/form/field.jsp" %>
					<input type="hidden" id="directoryId" name="directoryId" value="${directory.id }"/>
					<input type="hidden" name="opeFrom" value="<%=ResourceController.PUBLISH_OPE_FORM_FORM%>"/>
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
					       				<c:when test="${param[httpParamOpenMode] == createOpenMode }">添加文章</c:when>
					       				<c:when test="${param[httpParamOpenMode] == editOpenMode }">修改文章</c:when>
					       				<c:otherwise>文章信息</c:otherwise>
					       			</c:choose>
								</h5>
							</div>
							<div class="row-fluid" style="padding-top: 10px;">
									<%@ include file="/jdp/form/messages.jsp" %>
									<jsp:include page="<%=(String)request.getAttribute(com.lmiky.jdp.form.controller.FormController.HTTP_PARAM_FORM_SUBFORM)%>" />
							</div>
						</div>						
					</div>
					</form:form>
				</div>
		<%@ include file="/jdp/common/scripts.jsp"%>
		<%@ include file="/jdp/common/date.jsp"%>
		<%@ include file="/jdp/htmleditor/htmlEditorScript.jsp"%>
		<%@ include file="/jdp/file/uploadScript.jsp"%>
	</body>
</html>