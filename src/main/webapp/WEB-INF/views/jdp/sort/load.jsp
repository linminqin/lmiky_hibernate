<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<html>
<head>
	<%@ include file="/jdp/common/header.jsp"%>
	<%@ include file="/jdp/form/header.jsp" %>
	<script type="text/javascript">
		function initMultipleSelect() {
			//移到右边  
		    $("#addSelect").click(function () { 
		    	$.each($("#unselected > option:selected"), function() {
		    		var value = $(this).val();
		    		var option = $("#selected option[value='" + value + "']");
		    		if(option.length <= 0) {
			            $("#selected").append('<option value="' + value + '">' + $(this).html() + '</option>');  
			    	}
		    	});
		    });  
		  //移到左边  
		    $("#removeSelect").click(function () {  
		        $.each($("#selected > option:selected"), function() {
		            $(this).remove();  
		    	});
		    });  

		    //全部移到右边  
		    $("#addAllSelect").click(function () {  
		        $.each($("#unselected option"), function() {
		    		var value = $(this).val();
		    		var option = $("#selected option[value='" + value + "']");
		    		if(option.length <= 0) {
		    			$("#selected").append('<option value="' + $(this).val() + '">' + $(this).html() + '</option>');
		    		}
		    	});
		    });  
		    //全部移到左边
		    $("#removeAllSelect").click(function () {  
		    	$("#selected ").empty()
		    });  
		    //双击选项  
		    $('#unselected').dblclick(function () { //绑定双击事件  
		    	$.each($("#unselected > option:selected"), function() {
		    		var value = $(this).val();
		    		var option = $("#selected option[value='" + value + "']");
		    		if(option.length <= 0) {
		    			$("#selected").append('<option value="' + $(this).val() + '">' + $(this).html() + '</option>'); 
		    		}
		    	});
		    });  
		    //双击选项  
		    $('#selected').dblclick(function () {  
		    	$.each($("#selected > option:selected"), function() {
		    		$(this).remove(); 
		    	});
		    }); 
		    
		  	//上移动 
		   $("#upSelect").click(function () { 
		    	 if($("#selected > option:selected").length>0){    
		    		 $.each($("#selected > option:selected"), function() {
		    			 $(this).prev().before($(this)); 
				    });
		          }
		    }); 
		  	
		 //下移动
		   $("#downSelect").click(function () { 
		    	 if($("#selected > option:selected").length>0){    
		    		 var optionLenth = $("#selected > option:selected").length;
		    		 var optionIndexs = new Array(optionLenth);
		    		 var index = 0;
		    		 //从后面开始重新排序，否则多选的情况下，不会有效果
		    		 $.each($("#selected > option:selected"), function() {
		    			 optionIndexs[index] = $(this);
		    			 index++;
				    });
		    		for(var i=optionLenth-1; i>=0; i--) {
		    			 var option = optionIndexs[i];
		    			 $(option).next().after($(option));
		    		 }
		          }
		    }); 
		}
		
		$(document).ready(function(){
			initMultipleSelect();
		}); 
		
		function setSelected() {
			$("#groupSpan").html("");
			$.each($("#selected > option"), function() {
	    		$("#groupSpan").append('<input type="hidden" name="selectedPojos" value="' + $(this).val() + '"/>');
	    	});
			return true;
		} 
	</script>
	
</head>
<body class="alert-body">
	<%@ include file="/jdp/form/messages.jsp" %>
		<form id="mainForm" action="<c:url value="/sort/save.shtml"/>" method="post" onsubmit="return setSelected()">
		<input type="hidden" name="className" value="${className }"/>
		<input type="hidden" name="showName" value="${showName }"/>
		<jsp:include page="/jdp/include/propertyFilter.jsp">
			<jsp:param value="${className }" name="pojoClassName"/>
		</jsp:include>
		<span id="groupSpan" style="display: none;">
		</span>
		<table class="table-form full" >
	       	<tr>
				<td valign="top">
					<div style="float: left;">
					<div style="line-height: 25px;">排序前</div>
						<div>
							<select id="unselected" multiple="multiple" class="bian" style="height: 470px; width: 273px;">
								<c:forEach items="${pojos }" var="pojo">
									<option value="${pojo[0] }">${pojo[1] }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div style="float: left; width: 65px; text-align: center;">
							<div style="height: 100px;"></div>
							<div>
								&nbsp;<button type="button" id="addSelect"
									style="width: 30px;" ><i class="icon icon-step-forward"></i></button>&nbsp;
							</div>
							<div style="height: 20px;"></div>
							<div>
								&nbsp;<button type="button" id="addAllSelect"
									style="width: 30px;" ><i class="icon icon-fast-forward"></i></button>&nbsp;
							</div>
							<div style="height: 20px;"></div>
							<div>
								&nbsp;<button type="button" id="removeSelect"
									style="width: 30px;" ><i class="icon icon-step-backward"></i></button>&nbsp;
							</div>
							<div style="height: 20px;"></div>
							<div>
								&nbsp;<button type="button" id="removeAllSelect"
									style="width: 30px;" ><i class="icon-fast-backward"></i></button>&nbsp;
							</div>
							<div style="height: 20px;"></div>
							<div>
								&nbsp;<button type="button" id="upSelect"
									style="width: 30px;" ><i class="icon-chevron-up"></i></button>&nbsp;
							</div>
							<div style="height: 20px;"></div>
							<div>
								&nbsp;<button type="button" id="downSelect"
									style="width: 30px;" ><i class="icon-chevron-down"></i></button>&nbsp;
							</div>
					</div>
					<div style="float: left;">
						<div style="line-height: 25px;">排序后</div>
						<div>
							<select id="selected" multiple="multiple" class="bian" style="height: 470px; width: 273px;">
							</select>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" height="40">
					<button type="submit" class="btn btn-primary" >提交</button>
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="/jdp/common/scripts.jsp"%>
</body>
</html>