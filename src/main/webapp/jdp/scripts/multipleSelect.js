//selectedItemsGroupId：以选中的选项列表所处的父标签ID
//selectedItemInputIdPrefix：以选中的选项的标签ID
//selectedItemInputName：提交到表单的选中项的标签名称
//selectedItemCount：当前已选中的选项数

var selectedItemCount_v = 0;

function initMultipleSelect(selectedItemsGroupId, selectedItemInputIdPrefix, selectedItemInputName, selectedItemCount) {
	
	selectedItemCount_v = selectedItemCount;
	
	//移到右边  
    $("#addSelect").click(function () { 
    	$.each($("#unselected > option:selected"), function() {
    		$("#" + selectedItemsGroupId).append('<input type="hidden" id="' + selectedItemInputIdPrefix + $(this).val() + '" name="' + selectedItemInputName + '" value="' + $(this).val() + '"/>');
    		selectedItemCount_v = selectedItemCount_v + 1;
            $(this).appendTo("#selected");  
    	});
    });  
  //移到左边  
    $("#removeSelect").click(function () {  
        $.each($("#selected > option:selected"), function() {
        	$("#" + selectedItemsGroupId + " #" + selectedItemInputIdPrefix + $(this).val()).remove();
    		selectedItemCount_v = selectedItemCount_v - 1;
            $(this).appendTo("#unselected");  
    	});
    });  

    //全部移到右边  
    $("#addAllSelect").click(function () {  
        $.each($("#unselected option"), function() {
    		$("#" + selectedItemsGroupId).append('<input type="hidden" id="' + selectedItemInputIdPrefix + $(this).val() + '" name="' + selectedItemInputName + '" value="' + $(this).val() + '"/>');
    		selectedItemCount_v = selectedItemCount_v + 1;
            $(this).appendTo("#selected");  
    	});
    });  
    //全部移到左边
    $("#removeAllSelect").click(function () {  
        $.each($("#selected option"), function() {
        	$("#" + selectedItemsGroupId + " #" + selectedItemInputIdPrefix + $(this).val()).remove();
    		selectedItemCount_v = selectedItemCount_v - 1;
            $(this).appendTo("#unselected");  
    	});
    });  
    //双击选项  
    $('#unselected').dblclick(function () { //绑定双击事件  
    	$.each($("#unselected > option:selected"), function() {
    		$("#" + selectedItemsGroupId).append('<input type="hidden" id="' + selectedItemInputIdPrefix + $(this).val() + '" name="' + selectedItemInputName + '" value="' + $(this).val() + '"/>');
    		selectedItemCount_v = selectedItemCount_v + 1;
            $(this).appendTo("#selected");  
    	});
    });  
    //双击选项  
    $('#selected').dblclick(function () {  
    	$.each($("#selected > option:selected"), function() {
        	$("#" + selectedItemsGroupId + " #" + selectedItemInputIdPrefix + $(this).val()).remove();
    		selectedItemCount_v = selectedItemCount_v - 1;
            $(this).appendTo("#unselected");  
    	});
    }); 
}