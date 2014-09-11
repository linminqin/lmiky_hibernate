<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/common.jsp" %>
<div class="control-group">
	<label class="control-label read-control-label">标题：</label>
	<div class="controls">
		${pojo.title}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">副标题：</label>
	<div class="controls">
		${pojo.subtitle}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">作者：</label>
	<div class="controls">
		${pojo.author}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">来源：</label>
	<div class="controls">
		${pojo.source}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">创建时间：</label>
	<div class="controls">
		<fmt:formatDate value="${pojo.createTime}" pattern="${defaultDateTimeFormater }"/>
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">发布时间：</label>
	<div class="controls">
		<fmt:formatDate value="${pojo.pubTime}" pattern="${defaultDateTimeFormater }"/>
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">所属栏目：</label>
	<div class="controls">
		${directory.name}
	</div>
</div>
<div class="control-group">
	<label class="control-label read-control-label">内容快照：</label>
	<div class="controls">
		<div id="fileList" style="margin: 10px 0;">
			<c:forEach var="pictureSnapshot" items="${pojo.pictureSnapshots }">
				<div class="pictureSnapshotBlock" id="${pictureSnapshot.id}">
					<img src="${ctx}${pictureSnapshot.path}" class="pictureSnapshot" />
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<div class="control-group">
	<div class="controls nolabel-full-controls">
		${pojo.content}
	</div>
</div>
<div class="form-actions">
	<button type="button" class="btn btn-primary"
		onclick="back('/cms/resource/list.shtml')">返回</button>
</div>