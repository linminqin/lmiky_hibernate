<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/common.jsp"%>
<div class="control-group">
	<label class="control-label">名称 <span class="req">*</span></label>
	<div class="controls">
		<input name="title" type="text" value="${pojo.name}" />
	</div>
</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary">提交</button>
	&nbsp;&nbsp;
	<button type="button" class="btn btn-primary"
		onclick="back('/role/list.shtml')">返回</button>
</div>