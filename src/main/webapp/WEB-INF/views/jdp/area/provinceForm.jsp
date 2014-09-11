<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<html style="height: 98%;">
<head>
	<%@ include file="/jdp/common/header.jsp"%>
	<%@ include file="/jdp/form/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="${css}/view.css" />
	<script type="text/javascript">
		function addCity() {
			$("[name='parentId']").val("${pojo.id}");
			actionForm('<c:url value="/city/load.shtml"/>', 'id');
		}
	</script>
</head>
<body class="alert-body" style="height: 100%;">
				<div class="container-fluid nopadding">
					<div class="row-fluid nomargin">
						<form:form id="mainForm" action="${ctx}/province/save.shtml" method="post" commandName="pojo" class="form-horizontal">
							<%@ include file="/jdp/form/field.jsp" %>
							<input type="hidden" name="parentId" value="${param.parentId}"/>
							<input type="hidden" name="countryId" value="${param.parentId}"/>
							<div class="span12 nomargin">
								<div class="widget-box form-table" style="height: 500px;">
									<div class="widget-title">
										<span class="icon">
											<c:choose>
							       				<c:when test="${param[httpParamOpenMode] == createOpenMode }"><i class="icon-align-justify"></i></c:when>
							       				<c:when test="${param[httpParamOpenMode] == editOpenMode }"><i class="icon-edit"></i></c:when>
							       				<c:otherwise><i class="icon-align-justify"></i></c:otherwise>
							       			</c:choose>
										</span>
										<h5>省份管理</h5>
									</div>
									<div class="row-fluid" style="margin-top: 20px; margin-bottom: 20px; padding-left: 10px;">
										<c:if test="${openMode == 'edit'}">
											<lauthority:checkAuthority authorityCode="jdp_area_manage">
												<button type="button" class="btn" onClick="addCity()"><i class="icon-plus"></i> 添加子地市</button>
												<button type="button" class="btn" onClick="deletePojo('<c:url value="/province/delete.shtml"/>')"><i class="icon-remove"></i> 删除</button>
											</lauthority:checkAuthority>
										</c:if>
										<jsp:include page="/jdp/include/favoriteMenu.jsp">
											<jsp:param value="jdp_area_load" name="menuId"/>
										</jsp:include>
									</div>	
									<div class="row-fluid">
										<%@ include file="/jdp/form/messages.jsp" %>
										<jsp:include page="<%=(String)request.getAttribute(com.lmiky.jdp.form.controller.FormController.HTTP_PARAM_FORM_SUBFORM)%>" />
									</div>	
								</div>	
							</div>
						</form:form>
					</div>
				</div>
				<%@ include file="/jdp/common/scripts.jsp"%>
</body>
</html>