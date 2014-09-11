<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
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
					<form id="mainForm" action="<c:url value="/logger/list.shtml"/>" method="post" class="form-vertical">
					<%@ include file="/jdp/view/field.jsp"%>
					<div class="row-fluid">
						<div class="span12">
							<div class="widget-box border-radius">
								<div class="nopadding control-group">
										<label class="control-label" style="width: 80px;">操作员名称：</label>
										<lhtml:propertyFilter inputType="text" compareType="LIKE" propertyName="userName" styleClass="medium"/>
										&nbsp;
										<button type="submit" class="btn action-button">查询</button>
								</div>
							</div>						
						</div>
					</div>
					<div class="row-fluid">
						<jsp:include page="/jdp/include/favoriteMenu.jsp">
							<jsp:param value="jdp_logger_load" name="menuId"/>
						</jsp:include>
					</div>
					<div class="row-fluid">
					<table class="listContent table table-bordered table-striped with-check table-hover">
						<thead>
							<tr>
								<th class="list_index">&nbsp;</th>
								<th class="sortable sorted_userName"><a href="javascript:pageSort('userName')">操作员名称</a></th>
								<th class="sortable sorted_logTime"><a href="javascript:pageSort('logTime')">操作时间</a></th>
								<th>内容</th>
								<th>IP地址</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.items}" varStatus="status">
									<tr>
										<td>${status.count + (page.currentPage - 1) * page.pageSize}</td>
										<td>${item.userName}</td>
										<td><fmt:formatDate value="${item.logTime}" pattern="${defaultDateTimeFormater }"/></td>
										<td>${item.logDesc}</td>
										<td>${item.ip}</td>
									</tr>
								</c:forEach>
									<tr>
										<td colspan="6" class="pageColumn"><%@ include file="/jdp/view/page.jsp" %></td>
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