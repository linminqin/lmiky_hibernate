<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.lmiky.jdp.filemanager.controller.FileController, com.lmiky.jdp.filemanager.util.FileUtils" %>
<script charset="utf-8" src="${scriptPlugin }/uploadify/jquery.uploadify.min.js" ></script>
<script type="text/javascript">
	var imageFileNameExts = '*.jpg;*.jpeg;*.bmp;*.png;*.gif';
	var imageFileTypeExts = 'jpg,jpeg,bmp,png,gif';
	/**
	 * 初始化
	 * @param formField 上传文件表达字段
	 * @param uploadSuccessCallback 上传成功回调函数
	 * @param uploadCallback 上传回调函数
	 * @param saveFilePath 保持路径
	 * @param fileExtension 运行的文件后缀，多个之间以“,”分隔
	 */
	function initUploadElement(formFieldId, uploadSuccessCallback, uploadCallback, saveFilePath, fileExtension) {
		var filePath = '';
		if(saveFilePath != undefined && saveFilePath != null) {
			filePath = saveFilePath;
		}
		var fileExt = '';
		if(fileExtension != undefined && fileExtension != null) {
			fileExt = fileExtension;
		}
		$('#' + formFieldId).uploadify({
		    height: 30,
		    width: 120,
		    swf: '${scriptPlugin }/uploadify/uploadify.swf',
		    uploader: '<c:url value="/file/upload.shtml"/>',
		    fileObjName: 'file',
		    fileTypeDesc: '文件',
		    buttonText: '选取文件...',
		    multi: false,
		    removeTimeout: 0,
		    formData: {'filePath': filePath, 'fileExtension': fileExt},
		    onUploadSuccess: function(file, data, response) {
		    	var cb = defaultUploadCallback;
				if(uploadCallback && typeof(uploadCallback) == "function") {
					cb = uploadCallback;
				}
				cb(file, data, response, uploadSuccessCallback);
			}
		});
	}
	
	/**
	 * 图片上传初始化
	 * @param formField 上传文件表达字段
	 * @param uploadSuccessCallback 上传成功回调函数
	 * @param uploadCallback 上传回调函数
	 * @param saveFilePath 保持路径
	 */
	function initImageUploadElement(formFieldId, uploadSuccessCallback, uploadCallback, saveFilePath) {
		var filePath = '';
		if(saveFilePath != undefined && saveFilePath != null) {
			filePath = saveFilePath;
		}
		$('#' + formFieldId).uploadify({
		    height: 30,
		    width: 120,
		    swf: '${scriptPlugin }/uploadify/uploadify.swf',
		    uploader: '<c:url value="/file/upload.shtml"/>',
		    fileObjName: 'file',
		    fileTypeDesc: '图片',
	        fileTypeExts: imageFileNameExts,
		    buttonText: '选取图片...',
		    multi: false,
		    removeTimeout: 0,
		    formData: {'filePath': filePath, 'fileExtension': imageFileTypeExts},
		    onUploadSuccess: function(file, data, response) {
		    	var cb = defaultUploadCallback;
				if(uploadCallback && typeof(uploadCallback) == "function") {
					cb = uploadCallback;
				}
				cb(file, data, response, uploadSuccessCallback);
			}
		});
	}
	
	/**
	 * 上传成功默认回调函数
	 */
	function defaultUploadCallback(file, data, response, uploadSuccessCallback) {
		$json = jQuery.parseJSON(data);
		if ($json['<%=FileController.RETURN_KEY_NAME_CODE%>'] != <%=FileController.VALUE_NAME_ERROR_SUCCESS%>) {	//上传失败
	    	alert($json['<%=FileController.RETURN_KEY_NAME_MESSAGE%>']);
	    } else if(uploadSuccessCallback && typeof(uploadSuccessCallback) == "function") {	//自定义回调函数
	    	uploadSuccessCallback(file, data, response, $json.<%=FileController.RETURN_KEY_NAME_DATA%>.<%=FileController.RETURN_KEY_NAME_DATA_FILE_PATH%>);
	    } else {	//默认处理
	    	alert($json['<%=FileController.RETURN_KEY_NAME_MESSAGE%>']);
	    }
	}
</script>