<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<%@ page import="com.lmiky.jdp.tree.controller.TreeController,com.lmiky.jdp.tree.pojo.BaseTreePojo" %>
<%@page import="com.lmiky.cms.directory.pojo.CmsDirectory"%>
<%@page import="com.lmiky.jdp.base.view.BaseInfoCodeJsonView"%>
<%@page import="com.lmiky.jdp.base.view.BaseCode"%>
<html>
	<head>
		<base target="_self"/>
		<%@ include file="/jdp/common/header.jsp"%>
		<%@ include file="/jdp/form/header.jsp" %>
		<%@ include file="/jdp/common/tree.jsp" %>
		<script type="text/javascript">
			var zTreeObj;
			var treeId = "ztree";
			var selectedNodeId;
			var treeSetting = {
				treeId: 'directoryTree',
				view: {
					showLine: false,
					showIcon: true,
					selectedMulti: false
				},
				check: {
					enable: false
				},
				async: {
					enable: true,
					url: '<c:url value="/cms/directory/treeList.shtml"/>',
					autoParam: ["id"]
				},
				callback: {
					onClick: zTreeOnClick,
					onAsyncSuccess: zTreeOnAsyncSuccess,
					onExpand: resizeMenuIframe
				}
			};
			function zTreeOnClick(event, treeId, treeNode) {
				setSelectedNodeId(treeNode);
				<lauthority:checkAuthority authorityCode="cms_resource_load">
					$("#contentFrame", window.parent.parent.document).attr("src", "<c:url value="/cms/resource/list.shtml"/>?modulePath=cms/resource&directoryId=" + treeNode.id);
				</lauthority:checkAuthority>
			}  
			
			function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
				if(!!selectedNodeId) {
					var node = zTreeObj.getNodeByParam("id", selectedNodeId, null);
					zTreeObj.selectNode(node);
				}
				var nodes = treeNode.children;
		    	if(treeNode.children.length == 0) {
			    	treeNode.isParent = false;
			    	zTreeObj.updateNode(treeNode);
			    }
		    	zTreeObj.expandNode(treeNode, true, false, false, true);
		    	resizeMenuIframe();
			}
			
			function resizeMenuIframe() {
				resizeIframe('menuFrame_cms_directory_load');
			}
			
			//如果只有一个顶层节点，则展开子节点，否则不展开
			var zTreeNodes = [  
				<c:choose>
					<c:when test="${fn:length(roots) > 1}">
						<c:forEach items="${roots}" var="node" varStatus="status">
			        		{id:"${node.id}", name:"${node.name}",
			        			<c:choose>
			        				<c:when test="${node.leaf == tree_leaf_yes}">isParent: "false"</c:when>
			        				<c:otherwise>isParent: "true"</c:otherwise>
			        			</c:choose>
			        		}<c:if test="${!status.last}">,</c:if>
			        	</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach items="${roots}" var="node" varStatus="status">
							{id:"${node.id}", name:"${node.name}", open:true,
			        			<c:choose>
			        				<c:when test="${node.leaf == tree_leaf_yes}">isParent: "false"</c:when>
			        				<c:otherwise>
			        					isParent: "true",
			        					children: [  
			        				    	<c:forEach items="${node.children}" var="children" varStatus="childStatus">
				        				    	{id:"${children.id}", name:"${children.name}",
								        			<c:choose>
								        				<c:when test="${children.leaf == 0}">isParent: "false"</c:when>
								        				<c:otherwise>isParent: "true"</c:otherwise>
								        			</c:choose>
								        		}<c:if test="${!childStatus.last}">,</c:if>
			        				    	</c:forEach>
			        				 	]
			        				</c:otherwise>
			        			</c:choose>
			        		}<c:if test="${!status.last}">,</c:if>
			        	</c:forEach>
					</c:otherwise>
	    		</c:choose>
	        ]   
			$(document).ready(function() {
				zTreeObj = $.fn.zTree.init($("#" + treeId), treeSetting, zTreeNodes);
				var nodes = zTreeObj.getNodes();
				if (nodes.length>0) {
					var node = nodes[0];
					zTreeObj.selectNode(node);
					zTreeOnClick(event, treeId, node);
				}
			});
			
			function setSelectedNodeId(node) {
				selectedNodeId = node.id;
			}
			
			function addDirectory() {
				var parentId = '';
				if(selectedNodeId != null) {
					parentId = selectedNodeId;
				}
				openDialog('<c:url value="/cms/directory/load.shtml?${httpParamOpenMode }=${createOpenMode }&modulePath=${modulePath }&parentId=' + parentId + '"/>', 400, 250, '添加目录', reAsyncNode);
			}
			
			function updateDirectory() {
				if(selectedNodeId != null) {
					openDialog('<c:url value="/cms/directory/load.shtml?${httpParamOpenMode }=${editOpenMode }&modulePath=${modulePath }&id=' + selectedNodeId + '"/>', 400, 250, '修改目录', reAsyncParentNode);
				} else {
					alert('请选择要修改的目录！');
				}
			}
			
			function sortDirectory() {
				if(selectedNodeId != null) {
					sort('<%=CmsDirectory.class.getName() %>', 'name', '<lhtml:propertyFilterNamed compareType="EQ" propertyName="parent.id"/>=' + selectedNodeId, 650, 610, '目录排序', reAsyncNode);
				} else {
					alert('请选择要排序的父目录！');
				}
			}
			
			function deleteDirectory() {
				if(selectedNodeId != null) {
					if(confirm('删除目录将一并删除所属文章列表，您确定要删除该目录？')) {
						$.getJSON('<c:url value="/cms/directory/delete.shtml"/>?id=' + selectedNodeId, function(json){
							if(json.errorInfos) {
								$.each(json.errorInfos, function(i, item) {
									alert(item);
								});	
							}
							if(json.messageInfos) {
								$.each(json.messageInfos, function(i, item) {
									alert(item);
								});	
							}
							if(json.<%=BaseInfoCodeJsonView.KEY_CODE_NAME%> == <%=BaseCode.CODE_SUCCESS%>) {
								var node = zTreeObj.getNodeByParam("id", selectedNodeId, null);
								var parentNode = node.getParentNode();
								var refreshId = null;
								if(parentNode != null) {
									refreshId = parentNode.id;
									selectedNodeId = refreshId;
									zTreeOnClick(event, treeId, parentNode)
								}
								reAsyncChildNodes(refreshId);
							}
						}); 	
					}
				} else {
					alert('请选择要删除的目录！');
				}
			}
			
			function reAsyncNode() {
				reAsyncChildNodes(selectedNodeId);
			}
			
			function reAsyncParentNode() {
				var node = null;
				if(selectedNodeId != null && selectedNodeId != undefined && selectedNodeId != '') {
					node = zTreeObj.getNodeByParam("id", selectedNodeId, null);
					var parentNode = node.getParentNode();
					var refreshId = null;
					if(parentNode != null) {
						refreshId = parentNode.id;
					}
					reAsyncChildNodes(refreshId);
				}
			}
			
			function reAsyncChildNodes(nodeId) {
				var node = null;
				if(nodeId != null && nodeId != undefined && nodeId != '') {
					node = zTreeObj.getNodeByParam("id", nodeId, null);
				}
				//如果isParent=false,则reAsyncChildNodes不会执行
				if(node != null && node.isParent == false) {
					node.isParent = true;
				}
				//parentNode = null 时，相当于从根节点 Root 进行异步加载
				zTreeObj.reAsyncChildNodes(node, "refresh", true);
			}
		</script>
	</head>
	<body class="iframe-body" style="min-height: 300px;" >
		<table  cellpadding="0" cellspacing="0" border="0" style="width: 100%; height:100%;">
			<tr>
				<td width="150" valign="top" style="height: 100%">
					<ul id="ztree" class="ztree" style="overflow:auto;"></ul>
				</td>
			</tr>
		</table>
		<%@ include file="/jdp/common/scripts.jsp"%>
	</body>
</html>