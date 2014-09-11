<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/common.jsp"%>
<script type="text/javascript">
	<!--
		function changeUrl(url) {
			if(url != '') {
				$("#urlContent").attr("src", "<c:url value="/capture/task/urlContent.shtml"/>?url=" + url);
			}
		}
	//-->
</script>

<div class="control-group">
	<label class="control-label">名称 <span class="req">*</span></label>
	<div class="controls">
		<input name="name" type="text" value="${pojo.name}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">抓取地址 <span class="req">*</span></label>
	<div class="controls">
		<input name="captureUrl" type="text" value="${pojo.captureUrl}"  onblur="changeUrl(this.value)"/>
	</div>
</div>
<div class="control-group" style="padding:5px;">
	<iframe id="urlContent" src="" style="width: 100%; height: 100%;" frameborder="0" src="" scrolling="no"/></iframe>
</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary">提交</button>
	&nbsp;&nbsp;
	<button type="button" class="btn btn-primary"
		onclick="back('/capture/task/list.shtml')">返回</button>
</div>