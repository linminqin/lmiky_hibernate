<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/common.jsp" %>
<div class="control-group">
	<label class="control-label read-control-label">名称：</label>
	<div class="controls">
		${pojo.title}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">说明：</label>
	<div class="controls">
		${pojo.content}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">折扣价：</label>
	<div class="controls">
		${pojo.salePrice}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">市场价：</label>
	<div class="controls">
		${pojo.marketPrice}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">惠券折扣：</label>
	<div class="controls">
		${pojo.couponDiscount}
	</div>
</div>
<div class="form-actions">
	<button type="button" class="btn btn-primary"
		onclick="back('/tiger/goods/list.shtml')">返回</button>
</div>