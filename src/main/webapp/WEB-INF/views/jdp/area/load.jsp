<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jdp/common/htmlDoctype.jsp"%>
<%@ include file="/jdp/common/common.jsp"%>
<%@page import="com.lmiky.jdp.form.controller.FormController"%>
<%@ page import="com.lmiky.jdp.area.controller.AreaController" %>
<html style="height: 98%;">
<head>
	<%@ include file="/jdp/common/header.jsp"%>
	<%@ include file="/jdp/form/header.jsp" %>
	<%@ include file="/jdp/common/tree.jsp" %>
	<script type="text/javascript">
		var zTreeObj;
		var selectedNodeId = '0';
		var treeSetting = {
			treeId: 'areaTree',
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
				url: '<c:url value="/area/treeList.shtml"/>',
				autoParam: ["id", "areaType"]
			},
			callback: {
				onClick: zTreeOnClick,
				onAsyncSuccess: zTreeOnAsyncSuccess
			}
		};
		function zTreeOnClick(event, treeId, treeNode) {
			setSelectedNodeId(treeNode);
			var areaId = treeNode.realId;
			if(treeNode.id == 0) {
				areaId = '';
			}
			var areaType = treeNode.areaType;
			var url = "";
			var parentRealId = "0";
			if(treeNode.id == 0 || "<%=AreaController.AREA_TYPE_COUNTRY %>" == areaType) {
				url = "country";
				parentRealId = "0";
			} else if("<%=AreaController.AREA_TYPE_PROVINCE %>" == areaType) {
				url = "province";
				parentRealId = treeNode.getParentNode().realId;
			} else if("<%=AreaController.AREA_TYPE_CITY %>" == areaType) {
				url = "city";
				parentRealId = treeNode.getParentNode().realId;
			}
			$("#contentForm").attr("src", "<c:url value="/"/>" + url + "/load.shtml?modulePath=${param.modulePath }&id=" + areaId + "&parentId=" + parentRealId + "&<%=FormController.HTTP_PARAM_FORM_OEPNMODE%>=<%=FormController.OPEN_MODE_EDIT%>");
		}  
		
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
		    if(treeNode.areaType == "<%=AreaController.AREA_TYPE_ROOT%>") {
		    	var nodes = zTreeObj.getNodes()[0].children;
				for(var i=0; i<nodes.length; i++) {
					var node = nodes[i];
					node.icon = "${css}/plugins/ztree/img/diy/1_close.png";
					zTreeObj.updateNode(node);
				}
		    } else {
		    	var nodes = treeNode.children;
		    	if(treeNode.children.length == 0) {
			    	treeNode.isParent = false;
			    	zTreeObj.updateNode(treeNode);
			    } else if(treeNode.areaType == "<%=AreaController.AREA_TYPE_COUNTRY%>") { 
					for(var i=0; i<nodes.length; i++) {
						var node = nodes[i];
						node.icon = "${css}/plugins/ztree/img/diy/8.png";
						zTreeObj.updateNode(node);
					}
			    }
		    }
		    if(treeNode.isParent == true) {
		    	var selectedNode = zTreeObj.getNodeByParam("id", selectedNodeId, null);
				if(selectedNode != null) {
					zTreeObj.selectNode(selectedNode);
				} else {
					zTreeObj.selectNode(treeNode);
				}
		    } else {
		    	zTreeObj.selectNode(treeNode);
		    }
		};
		
		/*
		var zTreeNodes = [  
        	{id:"0", name:"地区", icon:"${css}/plugins/ztree/img/diy/1_open.png", "areaType":"<%=AreaController.AREA_TYPE_ROOT%>", isParent: "true", open:true, children: [  
        	     <c:forEach items="${countries}" var="country" varStatus="status">
        	    	 {id:"<%=AreaController.AREA_TYPE_COUNTRY%>${country.id}", name:"${country.name}", "areaType":"<%=AreaController.AREA_TYPE_COUNTRY%>", icon:"${css}/plugins/ztree/img/diy/8.png", realId: "${country.id}", isParent: "true"}<c:if test="${!status.last}">,</c:if>
        	     </c:forEach>
             ]}  
        ]  
		*/

		var zTreeNodes = [  
        	{id:"0", name:"地区", icon:"${css}/plugins/ztree/img/diy/1_open.png", "areaType":"<%=AreaController.AREA_TYPE_ROOT%>", isParent: "true"}  
        ]  
		$(document).ready(function() {
			zTreeObj = $.fn.zTree.init($("#ztree"), treeSetting, zTreeNodes);
			var nodes = zTreeObj.getNodes();
			if (nodes.length>0) {
				var node = nodes[0];
				zTreeObj.selectNode(node);
				reAsyncChildNodes(node.id);
				zTreeOnClick(null, treeSetting.treeId, node);
			}
		});
		
		function reAsyncChildNodes(nodeId, reSelectedNodeId) {
			var node = null;
			if(nodeId != null && nodeId != undefined && nodeId != '') {
				node = zTreeObj.getNodeByParam("id", nodeId, null);
			}
			//如果isParent=false,则reAsyncChildNodes不会执行
			if(node != null && node.isParent == false) {
				node.isParent = true;
			}
			if(reSelectedNodeId != null && reSelectedNodeId != undefined && reSelectedNodeId != '') {
				setSelectedNodeIdById(reSelectedNodeId);
			}
			zTreeObj.reAsyncChildNodes(node, "refresh", false);
		}
		
		function setSelectedNodeId(node) {
			selectedNodeId = node.id;
		}
		
		function setSelectedNodeIdById(nodeId) {
			selectedNodeId = nodeId;
		}
		
	</script>
</head>
<body class="alert-body"  style="height: 100%;">
	<table class="table-form"  cellpadding="0" cellspacing="0" border="0" style="width: 100%; height:100%;">
		<tr>
			<td width="30%" valign="top">
				<ul id="ztree" class="ztree" style="overflow:auto;"></ul>
			</td>
			<td valign="top" >
				<iframe id="contentForm" style="width: 100%; height: 100%;" frameborder="0" src="" scrolling="no"/>
			</td>
		</tr>
	</table>
</body>
</html>