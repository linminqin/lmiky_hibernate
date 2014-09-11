<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/common.jsp" %>
<%@ page import="com.lmiky.jdp.area.controller.AreaController" %>
<script type="text/javascript">
	<!--
		function beforeSubmitForm() {
			//if($("input[name='name']").val() == "") {
			//	alert("名称不能为空!");
			//	return false;
			//}
			return true;
		}
	
		$(document).ready(function() {
			if('${flag}' == 'refresh') {
				<c:choose>
					<c:when test="${openMode == 'edit' or openMode == 'create'}">
						<c:if test="${not empty pojo.id}">
							parent.reAsyncChildNodes('<%=AreaController.AREA_TYPE_COUNTRY%>${param.parentId}', '<%=AreaController.AREA_TYPE_PROVINCE%>${pojo.id}');
						</c:if>
					</c:when>
					<c:otherwise>
						parent.reAsyncChildNodes('<%=AreaController.AREA_TYPE_COUNTRY%>${param.parentId}');
					</c:otherwise>
				</c:choose>
			}
		});
	//-->
</script>
<div class="control-group">
	<label  class="mini-control-label" style="width: 60px;">名称 <span class="req">*</span></label>
	<div class="controls mini-controls">
		<input name="name" type="text" value="${pojo.name}" class="larger"/>
	</div>
</div>
<div class="form-actions mini-form-actions">
	<button type="submit" class="btn btn-primary"><c:choose><c:when test="${openMode == 'edit'}">修改</c:when><c:otherwise>添加</c:otherwise></c:choose></button>
</div>