<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/common.jsp" %>
<div class="control-group">
	<label class="control-label read-control-label">名称：</label>
	<div class="controls">
		${pojo.name}
	</div>
</div>
<div class="form-actions">
	<button type="button" class="btn btn-primary"
		onclick="back('/role/list.shtml')">返回</button>
</div>