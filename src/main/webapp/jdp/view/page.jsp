<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/taglibs.jsp" %>

<c:set var="pageSliderBegein" value="<%=com.lmiky.jdp.web.page.model.Page.SLIDER_BEGIN %>"/>
<c:set var="pageSliderCenter" value="<%=com.lmiky.jdp.web.page.model.Page.SLIDER_CENTER %>"/>
<c:set var="pageSliderEnd" value="<%=com.lmiky.jdp.web.page.model.Page.SLIDER_END %>"/>

<div class="dataTables_paginate">
				<span class="left">
					<span style="margin-right: 5px;">共 <span class="font_style3">${page.itemCount}</span> 条记录</span> 
					<span style="margin-left: 5px;">
					转到第 <input type="text" class="page-input" name="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_PAGE_CURRENTPAGE %>"  id="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_PAGE_CURRENTPAGE %>" value="${page.currentPage}"/> 页 
					<input type="hidden" name="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_PAGE_ACTION%>"  id="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_PAGE_ACTION%>" value="${page.action}"/>
					<button class="btn ui-button go"  onclick="document.forms.mainForm.submit()"><i class="icon-random"></i></button>
					</span>
				</span>
				<span class="btn-group right page_index">
				<c:choose>
					<c:when test="${page.pageCount <= pageSliderBegein + pageSliderCenter + pageSliderEnd}">
						<c:forEach var="pageIndex"  begin="1" end="${ page.pageCount}" varStatus="status">
							<a href="javascript: void(0)"  class="btn ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
					</c:when>
					<c:when test="${page.currentPage <= pageSliderBegein + 2}">
						<c:forEach var="pageIndex"  begin="1" end="${ page.currentPage + 1}" varStatus="status">
							<a href="javascript: void(0)"  class="btn ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
						<a href="javascript: void(0)"  class="btn disabled">...</a>
						<c:forEach var="pageIndex"  begin="${page.pageCount - pageSliderEnd + 1 }" end="${ page.pageCount}" varStatus="status">
							<a href="javascript: void(0)"  class="btn ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
					</c:when>
					<c:when test="${page.currentPage >= (page.pageCount - pageSliderEnd - 1)}">
						<c:forEach var="pageIndex"  begin="1" end="${ pageSliderBegein}" varStatus="status">
							<a href="javascript: void(0)"  class="fg-button ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
						<a href="javascript: void(0)"  class="btn disabled">...</a>
						<c:forEach var="pageIndex"  begin="${page.currentPage - 1 }" end="${ page.pageCount}" varStatus="status">
							<a href="javascript: void(0)"  class="btn ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="pageIndex"  begin="1" end="${ pageSliderBegein}" varStatus="status">
							<a href="javascript: void(0)"  class="btn ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
						<a href="javascript: void(0)"  class="btn disabled">...</a>
						<c:forEach var="pageIndex"  begin="${page.currentPage - 1}" end="${page.currentPage + 1 }" varStatus="status">
							<a href="javascript: void(0)"  class="btn ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
						<a href="javascript: void(0)"  class="btn disabled">...</a>
						<c:forEach var="pageIndex"  begin="${page.pageCount - pageSliderEnd + 1 }" end="${ page.pageCount}" varStatus="status">
							<a href="javascript: void(0)"  class="btn ui-button ui-state-default
							<c:if test="${page.currentPage ==  pageIndex}">ui-state-disabled</c:if>
							" onclick="turnPage(${pageIndex })">${pageIndex }</a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</span>

</div>
<script src="${script}/page.js"/>" type="text/javascript"></script>