<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/common.jsp"%>
<html>
<head>
	<%@ include file="/jdp/form/header.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			var message = $("#messageTd").text();
			message = $.trim(message);
			if(message == '') {
				$("#messageTd").hide();
			}
		});
	</script>
</head>
<body>
	<form id="mainForm" action="<c:url value="/init/init.shtml"/>" method="post">
		<table height="90%" border="0" class="full">
			<tr>
				<td align="center" valign="middle">
					<table class="table-form" >
						<tr><td colspan="2" align="left" id="messageTd"><%@ include file="/jdp/form/messages.jsp" %></td></tr>
				       	<tr>
				       		<td colspan="2" class="bg01 title">
				       			&nbsp;<img src="${images }/jt-5.gif" width="16" height="16" align="absmiddle" />系统初始化
				       		</td>
				       	</tr>
						<tr>
							<td align="right" class="bg02">
								<label>姓名 <span class="req">*</span></label>
							</td>
							<td>
								<input name="name" type="text" class="larger bian"/>
							</td>
						</tr>
						<tr>
							<td align="right" class="bg02">
								<label>登陆账号 <span class="req">*</span></label>
							</td>
							<td>
								<input name="loginName" type="text" class="larger bian"/>
							</td>
						</tr>
						<tr>
							<td align="right" class="bg02">
								<label>登陆密码 <span class="req">*</span></label>
							</td>
							<td>
								<input name="password" type="password" class="larger bian"/>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" class="btnClass" style="cursor: pointer;" value="提交" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>