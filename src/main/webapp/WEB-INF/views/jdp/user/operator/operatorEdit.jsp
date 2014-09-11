<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/common.jsp"%>
<%@ page import="com.lmiky.jdp.user.pojo.User"%>
<script type="text/javascript">
	<!--
		function beforeSubmitForm() {
			//if($("input[name='name']").val() == "") {
			//	alert("姓名不能为空!");
			//	return false;
			//}
			return true;
		}
	//-->
	
	<c:choose>
		<c:when test="${empty userRoles}">
			var userIndex = 0;
		</c:when>
		<c:otherwise>
			var userIndex = ${fn:length(userRoles)};
		</c:otherwise>
	</c:choose>

	$(document).ready(function(){
		initMultipleSelect('groupSpan', 'role_', 'selectedRoles', userIndex);
	}); 
</script>

<span id="groupSpan" style="display: none;"> <c:forEach
		items="${userRoles }" var="userRole" varStatus="status">
		<input type="hidden" id="role_${userRole.id }" name="selectedRoles"
			value="${userRole.id }" />
	</c:forEach>
</span>
<div class="control-group">
	<label class="control-label">名称 <span class="req">*</span></label>
	<div class="controls">
		<input name="name" type="text" value="${pojo.name}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">登陆账号 <span class="req">*</span></label>
	<div class="controls">
		<input name="loginName" type="text" value="${pojo.loginName}" />
	</div>
</div>
<c:if test="${openMode == 'create'}">
	<div class="control-group">
		<label class="control-label">密码 <span class="req">*</span></label>
		<div class="controls">
			<input name="password" type="password" value="" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">确认密码 <span class="req">*</span></label>
		<div class="controls">
			<input name="confirmPassword" type="password" value="" />
		</div>
	</div>
</c:if>
<div class="control-group">
	<label class="control-label">联系电话</label>
	<div class="controls">
		<input name="phone" type="text" value="${pojo.phone}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">邮箱</label>
	<div class="controls">
		<input name="email" type="text" value="${pojo.email}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">是否可用</label>
	<div class="controls">
		<form:radiobutton path="valid" id="yesValid" value="<%=User.VALID_YES%>" />
		<label for="yesValid" class="mini-control-label" style="width: 20px;">是</label>
		&nbsp; 
		<form:radiobutton path="valid" id="noValid" value="<%=User.VALID_NO%>" />
		<label for="noValid" class="mini-control-label" style="width: 20px;">否</label>
	</div>
</div>
<div class="control-group">
	<label class="control-label">所属角色</label>
	<div class="controls">
		<div style="float: left;">
			<div style="line-height: 25px;">未选中角色</div>
			<div>
				<select id="unselected" multiple="multiple"
					style="height: 300px; width: 250px;">
					<c:forEach items="${noUserRoles }" var="userRole">
						<option value="${userRole.id }">${userRole.name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div style="float: left; width: 50px; text-align: center;">
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
		</div>
		<div style="float: left;">
			<div style="line-height: 25px;">已选中角色</div>
			<div>
				<select id="selected" multiple="multiple"
					style="height: 300px; width: 300px;">
					<c:forEach items="${userRoles }" var="userRole">
						<option value="${userRole.id }">${userRole.name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
</div>
<div class="control-group">
	<label class="control-label">说明</label>
	<div class="controls">
		<textarea name="description" maxlength="512" rows="5">${pojo.description}</textarea>
	</div>
</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary">提交</button>
	&nbsp;&nbsp;
	<button type="button" class="btn btn-primary"
		onclick="back('/operator/list.shtml')">返回</button>
</div>