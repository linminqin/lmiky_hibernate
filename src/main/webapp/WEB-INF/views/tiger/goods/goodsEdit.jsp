<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/common.jsp"%>
<div class="control-group">
	<label class="control-label">名称 <span class="req">*</span></label>
	<div class="controls">
		<input name="title" type="text" value="${pojo.title}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">说明 <span class="req">*</span></label>
	<div class="controls">
		<input name="content" type="text" value="${pojo.content}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">折扣价 <span class="req">*</span></label>
	<div class="controls">
		<input name="salePrice" type="text" value="${pojo.salePrice}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">市场价 <span class="req">*</span></label>
	<div class="controls">
		<input name="marketPrice" type="text" value="${pojo.marketPrice}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">优惠券折扣 <span class="req">*</span></label>
	<div class="controls">
		<input name="couponDiscount" type="text" value="${pojo.couponDiscount}" />
	</div>
</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary">提交</button>
	&nbsp;&nbsp;
	<button type="button" class="btn btn-primary"
		onclick="back('/tiger/goods/list.shtml')">返回</button>
</div>