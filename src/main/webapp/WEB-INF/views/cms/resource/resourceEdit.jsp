<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/common.jsp"%>
<div class="control-group">
	<label class="control-label">标题 <span class="req">*</span></label>
	<div class="controls">
		<input name="title" type="text" value="${pojo.title}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">副标题</label>
	<div class="controls">
		<input name="subtitle" type="text" value="${pojo.subtitle}"/>
	</div>
</div>
<div class="control-group">
	<label class="control-label">作者 <span class="req">*</span></label>
	<div class="controls">
		<input name="author" type="text" value="${pojo.author}"/>
	</div>
</div>
<div class="control-group">
	<label class="control-label">来源</label>
	<div class="controls">
		<input name="source" type="text" value="${pojo.source}"/>
	</div>
</div>
<c:if test="${param[httpParamOpenMode] == editOpenMode }">
	<div class="control-group">
		<label class="control-label">创建时间 <span class="req">*</span></label>
		<div class="controls">
			<input name="createTime" type="text" value="<fmt:formatDate value="${pojo.createTime}" pattern="${defaultDateTimeFormater }"/>" onFocus="WdatePicker({readOnly:true, dateFmt:'${defaultDateTimeFormater}'})"/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">发布时间</label>
		<div class="controls">
			<input name="pubTime" type="text" value="<fmt:formatDate value="${pojo.pubTime}" pattern="${defaultDateTimeFormater }"/>" onFocus="WdatePicker({readOnly:true, dateFmt:'${defaultDateTimeFormater}'})"/>
		</div>
	</div>
</c:if>
<div class="control-group">
	<label class="control-label">所属栏目 <span class="req">*</span></label>
	<div class="controls">
		<input name="directoryName" id="directoryName" type="text" maxlength="256" value="${directory.name}" readonly="readonly" onclick="selectTree('directoryName', 'directoryId', 'com.lmiky.cms.directory.pojo.CmsDirectory', 300, 500, '请选择目录')"/>
	</div>
</div>
<div class="control-group">
	<label class="control-label">内容快照 <span class="req">*</span></label>
	<div class="controls">
		<div id="fileList" style="margin: 10px 0;">
			<c:forEach var="pictureSnapshot" items="${pojo.pictureSnapshots }">
				<div class="pictureSnapshotBlock" id="${pictureSnapshot.id}">
					<img src="${ctx}${pictureSnapshot.path}" class="pictureSnapshot" />
					<img src="${images}/cancel.png" class="pictureSnapshotCancel" onclick="deleteShotImg('${pictureSnapshot.id}')" />
					<input type="hidden" name="snapshots" value="${pictureSnapshot.path}"/>
				</div>
			</c:forEach>
		</div>
	    <input type="file" name="file" id="file">
	</div>
</div>
<div class="control-group">
	<div class="controls nolabel-full-controls">
		<textarea rows="30" name="content" style="width: 100%;" id="htmlContent">${pojo.content}</textarea>
	</div>
</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary">提交</button>
	&nbsp;&nbsp;
	<c:choose>
			<c:when test="${pojo.state == state_create || pojo.state == state_unpublish }">
				<lauthority:checkAuthority authorityCode="cms_resource_publish">
					<button type="button" class="btn btn-primary" onclick="actionForm('<c:url value="/cms/resource/publish.shtml"/>', '', false)">发布</button>
				</lauthority:checkAuthority>
			</c:when>
			<c:when test="${pojo.state == state_publish }">
				<lauthority:checkAuthority authorityCode="cms_resource_publish">
					<button type="button" class="btn btn-primary" onclick="actionForm('<c:url value="/cms/resource/unpublish.shtml"/>', '', false)">取消发布</button>
				</lauthority:checkAuthority>
			</c:when>
		</c:choose>
		&nbsp;&nbsp;
	<button type="button" class="btn btn-primary"
		onclick="back('/cms/resource/list.shtml')">返回</button>
</div>
<script type="text/javascript">
	/**
	 * 添加内容快照图片
	 */
	function appendUploadImageShot(filePath) {
		var divId = Date.now();
		$('#fileList').append('<div class="pictureSnapshotBlock" id="' + divId + '"></div>');
		$('#' + divId).append('<img src="${ctx}/' + filePath + '" class="pictureSnapshot" />');
		$('#' + divId).append('<img src="${images}/cancel.png" class="pictureSnapshotCancel" onclick="deleteShotImg(' + divId + ')" />');
		$('#' + divId).append('<input type="hidden" name="snapshots" value="' + filePath + '"/>');
	}
	
	/**
	 * 删除内容快照图片
	 */
	function deleteShotImg(divId) {
		$('#' + divId).remove();
	}
	
	//文件上传
	$(document).ready(function() {
		initImageUploadElement('file', function(file, data, response, filePath) {
			//用回调的机制，确保重新调整iframe大小是在显示完图片之后
			var callbacks = $.Callbacks();
			callbacks.add(appendUploadImageShot(filePath));	//显示图片
			callbacks.add(resizeIframe('contentFrame'));	//重新调整iframe大小
			callbacks.fire();
		});
	});
</script>