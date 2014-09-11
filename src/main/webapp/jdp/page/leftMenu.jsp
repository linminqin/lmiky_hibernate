<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="${script }/jquery.min.js" type="text/javascript"></script>
<c:set var="selectedLeftMenuId" value=""/>
<c:if test="${fn:contains(param.menuFrom, '-')}">
	<c:set var="selectedLeftMenuId" value="${fn:substringAfter(param.menuFrom, '-')}"/>
</c:if>
<div id="sidebar">
	<ul>
		<li id="menuLabel"><a href="javascript: void(0)"><span>${topMenu.label }</span><i class="icon-step-backward" style="float: right;" onclick="shrinkLeftMenu()"></i></a></li>
		<c:forEach items="${topMenu.leftMenus }" var="leftMenu" varStatus="status">
			<li class="submenu" id="leftMenu_${leftMenu.id }"><a href="#"><i class="icon icon-th-list"></i><span>${leftMenu.label }</span></a>
				<ul>
					<c:forEach items="${leftMenu.subMenus }" var="subMenuV">
						<li
							<c:if test="${subMenuV.id == subMenu.id && (empty selectedLeftMenuId || selectedLeftMenuId == leftMenu.id)}">
								class="active"
								<c:set var="selectedLeftMenuId" value="${leftMenu.id }"/>
							</c:if>
						>
							<c:choose>
								<c:when test="${subMenuV.type == 'link' }">
									<a href="<c:url value="/"/>${subMenuV.url }&${httpParamMenuFrom}=${topMenu.id}-${leftMenu.id}">${subMenuV.label }</a>
								</c:when>
								<c:when test="${subMenuV.type == 'dialog' }">
									<a href="javascript: void(0)" 
										onClick="openDialog('<c:url value="/"/>${subMenuV.url }&${httpParamMenuFrom}=${topMenu.id}-${leftMenu.id}', 
														<c:choose><c:when test="${not empty subMenuV.width}">${subMenuV.width }</c:when><c:otherwise>DEFAULT_DIALOG_WITH</c:otherwise></c:choose>,
														<c:choose><c:when test="${not empty subMenuV.height}">${subMenuV.height }</c:when><c:otherwise>DEFAULT_DIALOG_HEIGHT</c:otherwise></c:choose>, 
														'${subMenuV.label }')"
									>${subMenuV.label }</a>
								</c:when>
								<c:when test="${subMenuV.type == 'iframe' }">
									<iframe src="<c:url value="/"/>${subMenuV.iframeurl }&${httpParamMenuFrom}=${topMenu.id}-${leftMenu.id}" id="menuFrame_${subMenuV.id }" onload="resizeIframe('menuFrame_${subMenuV.id }')" frameborder="0"  width="98%" scrolling="no" style="margin: 2px;"></iframe>
								</c:when>
							</c:choose>
						</li>
					</c:forEach>
				</ul></li>
		</c:forEach>
	</ul>
</div>
<div id="sidebar-mini">
	<ul>
		<li><a href="javascript: void(0)"><i class="icon-step-forward" onclick="extendLeftMenu()"></i></a></li>
	</ul>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$('#leftMenu_${selectedLeftMenuId}').addClass('open');
	}); 
	
	function shrinkLeftMenu() {
		$('#sidebar').hide("fast", function() {
			$('#sidebar-mini').show("fast");
		});
		$('#content').css('margin-left', '15px');
	}
	
	function extendLeftMenu() {
		$('#sidebar-mini').hide("fast", function() {
			$('#sidebar').show("fast");
			$('#content').css('margin-left', '220px');
		});
	}
</script>
