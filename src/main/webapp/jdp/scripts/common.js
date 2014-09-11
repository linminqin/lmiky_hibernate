var DIALOG_RETURN_REFRESH_KEY = 'refresh';
var DIALOG_RETURN_REFRESH_VALUE_YES = '1001';
var DIALOG_RETURN_REFRESH_VALUE_NO = '1002';

//回车
$(document).keyup(function(event){
	if(event.keyCode ==13){
		//如果已经有submit按钮，会自动绑定回车事件
		if($("input[type='submit']").length > 0) {
			return;
		}
		if($("#mainForm").length  = 1) {
			submitForm();
		}
	}
});

//提交表单
function submitForm() {
	$("#mainForm").trigger("submit");
}

//提交表单动作
//clearParams：要清除的参数，以“,”分隔
//comfirm：是否询问
function actionForm(actionUrl, clearParams, comfirm) {
	if(comfirm == true) {
		if(!confirm(MESSAGE_OPERATE_CONFIRM)) {
			return;
		}
	}
	if(!!clearParams) {
		var clearParam = clearParams.split(",");
		for(var i=0; i<clearParam.length; i++) {
			$("[name='" + clearParam[i] + "']").val("");
		}
	}
	$("#mainForm").prop("action", actionUrl);
	submitForm();
}


//执行方法
function executeAction(actionUrl) {
	if(confirm(MESSAGE_OPERATE_CONFIRM)) {
		$("#mainForm").prop("action", actionUrl);
		submitForm();
	}
}

//删除记录
function deletePojo(deleteUrl) {
	if(confirm(MESSAGE_DELETE_CONFIRM)) {
		$("#mainForm").prop("action", deleteUrl);
		submitForm();
	}
}

//打开模态窗口
function openDialog(url, width, height, title, openDialogCallback) {
	if(title ==null || title == undefined) {
		title = '';
	}
	art.dialog.open(url, {title: title, width: width, height: height, close: function () {
		if(openDialogCallback && typeof(openDialogCallback) == "function") {
			openDialogCallback();
		}
	}}, false);
	
}

//获取控件左绝对位置
function getAbsoluteLeft(o) {
	oLeft = o.offsetLeft;
	while(o.offsetParent!=null) { 
		oParent = o.offsetParent;
		oLeft += oParent.offsetLeft;
		o = oParent;
	}
	return oLeft;
}

//获取控件上绝对位置
function getAbsoluteTop(o) {
	oTop = o.offsetTop;
	while(o.offsetParent!=null){
		oParent = o.offsetParent;
		oTop += oParent.offsetTop;  // Add parent top position
		o = oParent;
	}
	return oTop;
}

//获取对象的位置
function getObjPosition(obj){ 
	var point=new Array(0,0); 
	while(obj!=document.body){
		point[0]+=obj.offsetLeft;
		point[1]+=obj.offsetTop;
		obj=obj.offsetParent;
	}
	return point;
}

//判断鼠标是否在某个对象内	
function isMouseInObj(event,obj){ 
	event=event||window.event;
	var point1=new Array(event.clientX+document.body.scrollLeft,event.clientY+document.body.scrollTop); 
	var point2=getObjPosition(obj); 
	return( (point1[0]>=point2[0]) && point1[1]>=point2[1] && point1[0]-point2[0]<=obj.offsetWidth && point1[1]-point2[1]<=obj.offsetHeight );
} 

//调整frame高度
function resizeIframe(frameId, cb) {
	var frameObj = document.getElementById(frameId);
	if(!frameObj) {
		frameObj = parent.document.getElementById(frameId);
		if(!!frameObj) {
			$(frameObj).height(window.document.body.scrollHeight);
			if(cb && typeof(cb) == "function") {
				cb();
			}
		}
	} else {
		$(frameObj).height(frameObj.contentWindow.document.body.scrollHeight);
		if(cb && typeof(cb) == "function") {
			cb();
		}
	}
}