<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<html style="height: 98%;">
<head>
	<%@ include file="/jdp/common/header.jsp"%>
	<%@ include file="/jdp/form/header.jsp" %>
	<script src="${script }/multipleSelect.js" type="text/javascript"></script>
	<style type="text/css">
		.messageDiv {
			margin-top: 5px;
		}
	</style>
	<script type="text/javascript">
			<c:choose>
				<c:when test="${empty authorizedList}">
					var userIndex = 0;
				</c:when>
				<c:otherwise>
					var userIndex = ${fn:length(authorizedList)};
				</c:otherwise>
			</c:choose>
			
			$(document).ready(function(){
				initMultipleSelect('groupSpan', 'user_', 'selectedOperators', userIndex);
			}); 
			</script>
</head>
<body class="alert-body" style="height: 100%;">
	<%@ include file="/jdp/form/messages.jsp" %>
	<form id="mainForm" action="<c:url value="/authority/authorize.shtml"/>" method="post">
			<input type="hidden" name="moduleType" value="${param.moduleType }"/>
			<input type="hidden" name="modulePath" value="${param.modulePath }"/>
			<span id="groupSpan" style="display: none;">
				<c:forEach items="${authorizedList }" var="authorizedUser" varStatus="status">
					<input type="hidden" id="user_${authorizedUser.id }" name="selectedOperators" value="${authorizedUser.id }"/>
				</c:forEach>
			</span>
			<table style="width: 100%; height: 100%;">
				<tr>
					<td valign="top" align="left">
						<div style="float: left;">
							<div style="line-height: 25px;">未选中角色：</div>
							<div>
								<select id="unselected" multiple="multiple" style="height: 430px; width: 265px;" class="bian">
									<c:forEach items="${unauthorizedList }" var="unauthorizedUser">
										<option value="${unauthorizedUser.id }">${unauthorizedUser.name }</option>
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
							<div style="line-height: 25px;">已选中角色：</div>
							<div>
								<select id="selected" multiple="multiple" style="height: 430px; width: 265px;" class="bian">
									<c:forEach items="${authorizedList }" var="authorizedUser">
										<option value="${authorizedUser.id }">${authorizedUser.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</td>
				</tr>
					<tr>
						<td align="center" height="30" class="form-actions">
							<button type="submit" class="btn btn-primary">提交</button>
						</td>
					</tr>
			</table>
		</form>
		<%@ include file="/jdp/common/scripts.jsp"%>
	</body>
</html>