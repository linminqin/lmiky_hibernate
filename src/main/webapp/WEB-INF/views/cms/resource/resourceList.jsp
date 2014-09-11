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
		<%@ include file="/jdp/view/header.jsp"%>
	</head>
	<body class="iframe-body">
					<form id="mainForm" action="<c:url value="/cms/resource/list.shtml"/>" method="post" class="form-vertical">
					<%@ include file="/jdp/view/field.jsp"%>
					<input type="hidden" name="directoryId" value="${directory.id }"/>
					<input type="hidden" name="opeFrom" value="<%=ResourceController.PUBLISH_OPE_FORM_VIEW%>"/>
					<div class="row-fluid" style="margin-top: 20px;">
						<lauthority:checkAuthority authorityCode="cms_directory_add">
							<button type="button" class="btn" onClick="parent.document.getElementById('menuFrame_cms_directory_load').contentWindow.addDirectory()"><i class="icon-plus"></i> 添加栏目</button>
						</lauthority:checkAuthority>
						<lauthority:checkAuthority authorityCode="cms_directory_modify">
							<button type="button" class="btn" onclick="parent.document.getElementById('menuFrame_cms_directory_load').contentWindow.updateDirectory()"/><i class="icon-plus"></i> 修改栏目</button>
						</lauthority:checkAuthority>
						<lauthority:checkAuthority authorityCode="cms_directory_modify">
							<button type="button" class="btn" onclick="parent.document.getElementById('menuFrame_cms_directory_load').contentWindow.sortDirectory()"/><i class="icon-plus"></i> 排序栏目</button>
						</lauthority:checkAuthority>
						<lauthority:checkAuthority authorityCode="cms_directory_delete">
							<button type="button" class="btn" onclick="parent.document.getElementById('menuFrame_cms_directory_load').contentWindow.deleteDirectory()"/><i class="icon-plus"></i> 删除栏目</button>
						</lauthority:checkAuthority>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<div class="widget-box border-radius">
								<div class="nopadding control-group">
										<label class="control-label"  style="width: 70px;">标题：</label>
										<lhtml:propertyFilter inputType="text" compareType="LIKE" propertyName="title" styleClass="medium"/>
										&nbsp;
										<label class="control-label"  style="width: 50px;">作者：</label>
										<lhtml:propertyFilter inputType="text" compareType="LIKE" propertyName="author" styleClass="medium"/>
										&nbsp;
										<label class="control-label"  style="width: 70px;">状态：</label>
										<lhtml:propertyFilter inputType="select" compareType="EQ" propertyName="state"  style="width: 144px;">
				            				<option value="">请选择</option>
				            				<option value="${state_create }">创建</option>
				            				<option value="${state_publish }">发布</option>
				            				<option value="${state_unpublish }">取消发布</option>
				            			</lhtml:propertyFilter>
										&nbsp;
										<label style="width: 50px; text-align: center;" class="control-label" >&nbsp;</label>
										<button type="submit" class="btn action-button">查询</button>
								</div>
								<div class="nopadding control-group">
										<label class="control-label"  style="width: 70px;">创建时间：</label>
										<lhtml:propertyFilter inputType="beginDate" compareType="GE" propertyName="createTime" styleClass="medium"/>
										&nbsp;
										<label style="width: 50px; text-align: center;" class="control-label" >-</label>
										<lhtml:propertyFilter inputType="endDate" compareType="LE" propertyName="createTime" styleClass="medium"/>
										&nbsp;
										<label class="control-label"  style="width: 70px;">发布时间：</label>
										<lhtml:propertyFilter inputType="beginDate" compareType="GE" propertyName="pubTime" styleClass="medium"/>
										&nbsp;
										<label style="width: 50px; text-align: center;" class="control-label" >-</label>
										<lhtml:propertyFilter inputType="endDate" compareType="LE" propertyName="pubTime" styleClass="medium"/>
								</div>
							</div>						
						</div>
					</div>
					<div class="row-fluid">
						<jsp:include page="/jdp/include/addMenu.jsp">
							<jsp:param value="cms_resource_add" name="authorityCode"/>
							<jsp:param value="cms/resource/load.shtml?${httpParamOpenMode }=${createOpenMode }&modulePath=${modulePath }&menuFrom=${param.menuFrom }&subMenuId=${param.subMenuId }&directoryId=${directory.id }" name="addUrl"/>
						</jsp:include>
						<jsp:include page="/jdp/include/batchDeleteMenu.jsp">
							<jsp:param value="cms_resource_delete" name="authorityCode"/>
							<jsp:param value="cms/resource/batchDelete.shtml" name="deleteUrl"/>
						</jsp:include>
					</div>
					<div class="row-fluid">
					<table class="listContent table table-bordered table-striped with-check table-hover">
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th class="sortable sorted_title"><a href="javascript:pageSort('title')">标题</a></th>
								<th style="width: 110px;" class="sortable sorted_createTime"><a href="javascript:pageSort('createTime')">创建时间</a></th>
								<th style="width: 110px;" class="sortable sorted_pubTime"><a href="javascript:pageSort('pubTime')">发布时间</a></th>
								<th style="width: 230px;">操作</th>
								<c:set var="colCount" value="5"/>
								<lauthority:checkAuthority
									authorityCode="cms_resource_delete">
									<c:set var="colCount" value="6"/>
									<th class="simpleCheckbox"><input type="checkbox"
										name="batctSelectDelete" id="batctSelectDelete" value=""
										onclick="batchSelectDelete()" /></th>
								</lauthority:checkAuthority>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.items}" varStatus="status">
									<tr>
										<td>${status.count + (page.currentPage - 1) * page.pageSize}</td>
										<td style="text-align: left;">${item.title}</td>
										<td><fmt:formatDate value="${item.createTime}" pattern="${defaultDateTimeFormater }"/></td>
										<td><fmt:formatDate value="${item.pubTime}" pattern="${defaultDateTimeFormater }"/></td>
										<td style="text-align: left;">
											<lauthority:checkAuthority authorityCode="cms_resource_load">
												<a href="javascript:void(0)"
														onclick="redirectPage('<c:url value="/cms/resource/load.shtml?id=${item.id}&${httpParamOpenMode }=${readOpenMode }"/>&modulePath=${modulePath }&directoryId=${directory.id }')">
													<i class="icon icon-circle-arrow-up"></i> 查看
												</a>
											</lauthority:checkAuthority>
											<lauthority:checkAuthority authorityCode="cms_resource_modify">
												&nbsp;
												<a href="javascript:void(0)"
														onclick="redirectPage('<c:url value="/cms/resource/load.shtml?id=${item.id}&${httpParamOpenMode }=${editOpenMode }"/>&modulePath=${modulePath }&directoryId=${directory.id }')">
													<i class="icon icon-edit"></i> 修改
												</a>
											</lauthority:checkAuthority>
											<lauthority:checkAuthority authorityCode="cms_resource_delete">
												&nbsp;
												<a href="javascript:void(0)"
														onclick="deletePojo('<c:url value="/cms/resource/delete.shtml?id=${item.id}&directoryId=${directory.id }"/>')">
													<i class="icon icon-trash"></i> 删除
												</a>
											</lauthority:checkAuthority>
											<c:choose>
												<c:when test="${item.state == state_create || item.state == state_unpublish }">
													<lauthority:checkAuthority authorityCode="cms_resource_publish">
														<a style="display: inline-block; width: 70px;" href="javascript:void(0)" onclick="executeAction('<c:url value="/cms/resource/publish.shtml"/>?id=${item.id}&directoryId=${directory.id }')">
															<i class="icon icon-resize-full"></i> 发布
														</a>
													</lauthority:checkAuthority>
												</c:when>
												<c:when test="${item.state == state_publish }">
													<lauthority:checkAuthority authorityCode="cms_resource_publish">
														<a style="display: inline-block; width: 70px;" href="javascript:void(0)" onclick="executeAction('<c:url value="/cms/resource/unpublish.shtml"/>?id=${item.id}&directoryId=${directory.id }')">
															<i class="icon icon-resize-small"></i> 取消发布
														</a>
													</lauthority:checkAuthority>
												</c:when>
											</c:choose>
										</td>
										<lauthority:checkAuthority authorityCode="cms_resource_delete">
											<td>
												<input type="checkbox" name="batchDeleteId" value="${item.id}" />
											</td>
										</lauthority:checkAuthority>
									</tr>
								</c:forEach>
									<tr>
										<td colspan="${colCount }" class="pageColumn"><%@ include file="/jdp/view/page.jsp" %></td>
									</tr>
							</tbody>
						</table>
						<%@ include file="/jdp/view/sort.jsp" %>
					</div>
				</form>
		<%@ include file="/jdp/common/scripts.jsp"%>
		<%@ include file="/jdp/view/scripts.jsp"%>
		<%@ include file="/jdp/common/date.jsp"%>
	</body>
</html>