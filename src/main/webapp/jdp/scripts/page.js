function turnPage(pageNo) {
	$("#page_currentPage").val(pageNo);
	submitForm();
}

function reloadPage() {
	submitForm();
}