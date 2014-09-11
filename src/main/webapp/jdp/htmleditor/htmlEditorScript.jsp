<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script charset="utf-8" src="${scriptPlugin }/kindeditor/kindeditor-min.js" ></script>
<script charset="utf-8" src="${scriptPlugin }/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
var editor = null;
KindEditor.ready(function(K) {
	editor = K.create('#htmlContent', {
		uploadJson : '<c:url value="/kindEditorFile/upload.shtml"/>',
		allowFileManager : false
	});
});
</script>