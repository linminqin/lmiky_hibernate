<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<html>
	<head>
		<title>${subMenu.label }</title>
		<%@ include file="/jdp/common/header.jsp"%>
		<%@ include file="/jdp/view/header.jsp"%>
		<%@ include file="/jdp/common/scripts.jsp"%>
	</head>
	<body>
		<%@ include file="/jdp/page/topMenu.jsp"%>
		<div class="container_content">
			<%@ include file="/jdp/page/leftMenu.jsp"%>
			<div id="content">
				<%@ include file="/jdp/page/location.jsp"%>
				<div class="container-fluid">
					<iframe src="" id="contentFrame" height="100%" onload="resizeIframe('contentFrame');" frameborder="0" scrolling="auto" width="100%"></iframe>
				</div>
			</div>
			<%@ include file="/jdp/page/footer.jsp"%>
		</div>
	</body>
</html>