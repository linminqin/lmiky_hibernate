<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sortDiv" style="display: none;">
	<c:forEach var="sort" items="${sorts }">
		<input type="hidden" name="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_SORT_ORDERBY_NAME %>" value="${sort.propertyName}"/>
		<input type="hidden" name="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_SORT_TYPE_NAME_PREFIX %>${sort.propertyName}" value="${sort.sortType}" />
	</c:forEach>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		<c:forEach var="sort" items="${sorts }">
			var sortObj = $(".sorted_${sort.propertyName}");
			$(sortObj).addClass("order-${sort.sortType}");
		</c:forEach>
	});

	function pageSort(sortItem) {
		var sortType ="";
		var sortValue ="";
		var sortObjs = $("input[name='<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_SORT_ORDERBY_NAME %>'][value='" + sortItem + "']");
		if(sortObjs.length > 0) {
			sortType = $("input[name='<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_SORT_TYPE_NAME_PREFIX %>" + sortItem + "']").val();
		}
		if(sortType == "") {
			sortValue = "asc";
		} else if(sortType == "asc") {
			sortValue = "desc";
		} else if(sortType == "desc") {
			sortValue = "";
		}
		
		var orderHtml = '<input type="hidden" name="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_SORT_ORDERBY_NAME %>" value="' + sortItem + '"/>' +
		'<input type="hidden" name="<%=com.lmiky.jdp.constants.Constants.HTTP_PARAM_SORT_TYPE_NAME_PREFIX %>' + sortItem + '" value="' + sortValue + '" />';
		$("#sortDiv").html(orderHtml);
		submitForm();
	}
</script>