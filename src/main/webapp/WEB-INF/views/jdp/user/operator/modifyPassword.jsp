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
			<%@ include file="/jdp/form/messages.jsp" %>
			<div class="row-fluid">
				<form id="mainForm" action="<c:url value="/operator/modifyPassword.shtml"/>" method="post" class="form-horizontal">
					<input type="hidden" name="modulePath" value="${param.modulePath }"/>
						<div class="form-table">
							<div class="nopadding" style="text-align: center;">
								<div class="control-group">
									<label class="mini-control-label" style="width: 60px;">旧密码 <span class="req">*</span></label>
									<div class="controls mini-controls">
										<input name="oldPassword" type="password" value=""  class="large"/>
									</div>
								</div>
								<div class="control-group">
									<label class="mini-control-label" style="width: 60px;">新密码 <span class="req">*</span></label>
									<div class="controls mini-controls">
										<input name="password" type="password" value=""   class="large"/>
									</div>
								</div>
								<div class="control-group">
									<label class="mini-control-label" style="width: 60px;">确认密码 <span class="req">*</span></label>
									<div class="controls mini-controls">
										<input name="confirmPassword" type="password" value=""   class="large"/>
									</div>
								</div>
								<div class="form-actions mini-form-actions">
									<button type="submit" class="btn btn-primary">提交</button>
								</div>
							</div>
						</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/jdp/common/scripts.jsp"%>
</body>
</html>