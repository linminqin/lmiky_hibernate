<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<%@ page import="com.lmiky.jdp.user.pojo.User"%>
<c:set var="yesValid" value="<%=User.VALID_YES%>" />
<c:set var="noValid" value="<%=User.VALID_NO%>" />
<html>
	<head>
		<title>${subMenu.label }</title>
		<%@ include file="/jdp/common/header.jsp"%>
		<%@ include file="/jdp/view/header.jsp"%>
	</head>
	<body>
		<%@ include file="/jdp/page/topMenu.jsp"%>
		<div class="container_content">
			<%@ include file="/jdp/page/leftMenu.jsp"%>
			<div id="content">
				<%@ include file="/jdp/page/location.jsp"%>
				<div class="container-fluid">
					<form id="mainForm" action="<c:url value="/capture/task/list.shtml"/>" method="post" class="form-vertical">
					<%@ include file="/jdp/view/field.jsp"%>
					<div class="row-fluid">
						<div class="span12">
							<div class="widget-box border-radius">
								<div class="nopadding control-group">
										<label class="control-label"  style="width: 50px;">名称：</label>
										<lhtml:propertyFilter inputType="text" compareType="LIKE" propertyName="name" styleClass="medium"/>
										&nbsp;
										<button type="submit" class="btn action-button">查询</button>
								</div>
							</div>						
						</div>
					</div>
					<div class="row-fluid">
						<jsp:include page="/jdp/include/addMenu.jsp">
							<jsp:param value="capture_task_add" name="authorityCode"/>
							<jsp:param value="capture/task/load.shtml?${httpParamOpenMode }=${createOpenMode }&modulePath=${modulePath }&menuFrom=${param.menuFrom }&subMenuId=${param.subMenuId }" name="addUrl"/>
						</jsp:include>
						<jsp:include page="/jdp/include/batchDeleteMenu.jsp">
							<jsp:param value="capture_task_delete" name="authorityCode"/>
							<jsp:param value="capture/task/batchDelete.shtml" name="deleteUrl"/>
						</jsp:include>
						<jsp:include page="/jdp/include/favoriteMenu.jsp">
							<jsp:param value="capture_task_load" name="menuId"/>
						</jsp:include>
					</div>
					<div class="row-fluid">
					<table class="listContent table table-bordered table-striped with-check table-hover">
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th class="sortable sorted_name"><a
									href="javascript:pageSort('name')">姓名</a></th>
								<th>操作</th>
								<c:set var="colCount" value="3"/>
								<lauthority:checkAuthority
									authorityCode="jdp_user_operator_delete">
									<c:set var="colCount" value="4"/>
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
										<td>${item.name}</td>
										<td>
											<lauthority:checkAuthority authorityCode="capture_task_load">
												<a href="javascript:void(0)"
														onclick="redirectPage('<c:url value="/capture/task/load.shtml?id=${item.id}&${httpParamOpenMode }=${readOpenMode }"/>&modulePath=${modulePath }&menuFrom=${param.menuFrom }&subMenuId=${param.subMenuId }')">
													<i class="icon icon-circle-arrow-up"></i> 查看
												</a>
											</lauthority:checkAuthority>
											<lauthority:checkAuthority authorityCode="capture_task_modify">
												&nbsp;
												<a href="javascript:void(0)"
														onclick="redirectPage('<c:url value="/capture/task/load.shtml?id=${item.id}&${httpParamOpenMode }=${editOpenMode }&modulePath=${modulePath }&menuFrom=${param.menuFrom }&subMenuId=${param.subMenuId }"/>')">
													<i class="icon icon-edit"></i> 修改
												</a>
											</lauthority:checkAuthority>
											<lauthority:checkAuthority authorityCode="capture_task_delete">
												&nbsp;
												<a href="javascript:void(0)"
														onclick="deletePojo('<c:url value="/capture/task/delete.shtml?id=${item.id}"/>')">
													<i class="icon icon-trash"></i> 删除
												</a>
											</lauthority:checkAuthority>
										</td>
										<lauthority:checkAuthority authorityCode="capture_task_delete">
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
				</div>
			</div>
			<%@ include file="/jdp/page/footer.jsp"%>
		</div>
		<%@ include file="/jdp/common/scripts.jsp"%>
		<%@ include file="/jdp/view/scripts.jsp"%>
	</body>
</html>