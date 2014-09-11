<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${script }/plugins/uploadify/jquery.uploadify.js" type="text/javascript"></script>
<script type="text/javascript">
	//上传图片
	//extendJsonData扩展信息，json格式，可以为空
	function uploadImg(uploaderId, successCallbackFuncName, extendJsonData) {
		$("#" + uploaderId).uploadify({
			height : 30,
			width : 150,
			swf : '<c:url value="/scripts/plugins/uploadify/uploadify.swf"/>',
			uploader : '<c:url value="/file/upload.do"/>?jsessionid=${pageContext.session.id}',
			fileObjName : 'fileData',
			fileTypeDesc : '图片',
			fileTypeExts : '*.gif; *.jpg; *.png; *.bmp',
			buttonText : '选取图片...',
			multi : false,
			formData: extendJsonData,
			onUploadSuccess : function(file, data, response) {
				var fun = eval(successCallbackFuncName);
	      	fun(file, data, response);
			}
		});
	}
	
	//上传文件
	//fileTypeExts：文件格式，多个之间以“;”隔开，比如'*.gif; *.jpg; *.png; *.bmp'
	function uploadFile(uploaderId, successCallbackFuncName, fileTypeExts, extendJsonData) {
		$("#" + uploaderId).uploadify({
			height : 30,
			width : 150,
			swf : '<c:url value="/scripts/plugins/uploadify/uploadify.swf"/>',
			uploader : '<c:url value="/file/upload.do"/>?jsessionid=${pageContext.session.id}',
			fileObjName : 'fileData',
			fileTypeDesc : '文件',
			fileTypeExts : fileTypeExts,
			buttonText : '选取文件...',
			multi : false,
			formData: extendJsonData,
			onUploadSuccess : function(file, data, response) {
				var fun = eval(successCallbackFuncName);
	      	fun(file, data, response);
			}
		});
	}
</script>