<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	var submitting = false;
	$(document).ready(function() {
		$("#mainForm").submit(function () {
			if(!beforeSubmitForm()) {
				submitting = false;
				return false;
			}
			submitting = true;
		});
	});
	
	//提交表单之前的操作，如果需要检查表单字段，则重载
	function beforeSubmitForm() {
		return true;
	}
	
	<c:if test="${openMode eq editOpenMode && not empty pojo.id && not empty lockTargetId}">
		window.onunload = unlock;
		function unlock() {
			//以下ajax方法IE会出问题，可能的原因是在页面关闭完成时，ajax还没完成连接，为了测试，在ajax之后执行alert方法，就会每次都完成连接解锁，所以要改为同步
			//var uncacheParam = new Date().getTime(); //防止页面缓存
			//$.get("${ctx }/lock/unlock.shtml?uncacheParam=" + uncacheParam, { target: '${lockTargetId }'} );
			
			//var url = "${ctx }/lock/unlock.shtml?target=${lockTargetId }";
			//window.open(url, "unlock", "left=10000,top=10000,width=1.height=1");
			
			//不是提交
			if(!submitting) {
				$.ajax({
					url: "${ctx }/lock/unlock.shtml",
					cache: false,
					async: false,
					data: { target: "${lockTargetId }"}
				});
			}
		}
	</c:if>
</script>