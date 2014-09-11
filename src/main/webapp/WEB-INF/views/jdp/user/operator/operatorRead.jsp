<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/common.jsp" %>
<div class="control-group">
	<label class="control-label read-control-label">名称：</label>
	<div class="controls">
		${pojo.name}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">登陆账号：</label>
	<div class="controls">
		${pojo.loginName}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">联系电话：</label>
	<div class="controls">
		${pojo.phone}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">邮箱：</label>
	<div class="controls">
		${pojo.email}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">创建时间：</label>
	<div class="controls">
		<fmt:formatDate value="${pojo.createTime}" pattern="${defaultDateTimeFormater }"/>
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">所属角色：</label>
	<div class="controls">
		<c:forEach items="${userRoles }" var="userRole">
			${userRole.name }&nbsp;
		</c:forEach>
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">说明：</label>
	<div class="controls">
		${pojo.description}
	</div>
</div>
<div class="form-actions">
	<button type="button" class="btn btn-primary"
		onclick="back('/operator/list.shtml')">返回</button>
</div>