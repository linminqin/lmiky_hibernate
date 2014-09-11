//选中/取消所有的删除框
function batchSelectDelete() {
	$("input[type='checkbox'][name='batchDeleteId']").prop("checked", $("#batctSelectDelete").prop("checked"));
}

//批量删除记录
function batchDelete(deleteUrl) {
	if(confirm(MESSAGE_BATCHDELETE_CONFIRM)) {
		$("#mainForm").prop("action", deleteUrl);
		submitForm();
	}
}
