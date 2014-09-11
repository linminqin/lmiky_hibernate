<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<c:set var="redirect" value="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_LOGIN_REDIRECT%>" />
<html>
	<head>
		<title>${subMenu.label }</title>
		<%@ include file="/jdp/common/header.jsp"%>
		<link rel="stylesheet" href="${css}/unicorn.login.css" />
		<script type="text/javascript">
			function login() {
				$("#mainForm").submit();
			}
			
			function beforeLogin() {
				var passwordInput = document.getElementsByName("password")[0];
				var password = passwordInput.value;
				if (password && password != "") {
					password = hex_md5(password).toUpperCase();
					passwordInput.value = password;
				}
				return true;
			}
			
			$(document).ready(function() {
				var loginName = $("[name='loginName']").val();
				if(loginName == '') {
					$("[name='loginName']").focus();
				} else {
					$("[name='password']").focus();
				}
			});
		</script>
	</head>
<body>
        <div id="loginbox">       
        	<form id="mainForm" action="<c:url value="/sso/login/login.shtml"/>" method="post" onsubmit="return beforeLogin()">     
        		<input type="hidden" name="${redirect }" value="${param[redirect] }"/>
        		<c:choose>
	        		<c:when test="${not empty errorInfos }">
						<c:forEach items="${errorInfos }" var="errorInfo" varStatus="status">
							<c:if test="${!status.first }"><br/></c:if>
								<p class="text-error login-info">${errorInfo }</p>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p id="blackSpace">&nbsp;</p>
					</c:otherwise>
				</c:choose>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" name="loginName" value="${loginName }" placeholder="用户名" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password" name="password" value="" placeholder="密码" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left">记住账号：<input id="remember-login-name-checkbox" type="checkbox" name="rememberLoginName" class="bian" value="true" <c:if test="${ rememberLoginName}">checked="checked"</c:if>/></span>
                    <span class="pull-right"><input type="button" onClick="login()" class="btn btn-inverse" value="登录" /></span>
                </div>
            </form>
        </div>
        <%@ include file="/jdp/common/scripts.jsp"%>
		<script src="${script }/md5.js" " type="text/javascript"></script>
    </body>
</html>