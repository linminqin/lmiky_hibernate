<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/common.jsp"%>
<div class="control-group">
	<label class="mini-control-label" style="width: 60px;">名称 <span class="req">*</span></label>
	<div class="controls mini-controls">
		<input name="name" type="text" value="${pojo.name}" class="large"/>
	</div>
</div>
<div class="form-actions mini-form-actions">
	<button type="submit" class="btn btn-primary">提交</button>
</div>