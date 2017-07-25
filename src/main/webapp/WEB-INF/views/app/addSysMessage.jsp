<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/lib/weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/css/jquery-weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/css/app/myinfo-add.css">
    
    <script src="${ctx}/static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app/js/jquery-weui.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app/js/city-picker.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app/js/swiper.js"></script>
	<script src="${ctx}/static/js/ajaxRequest.js"></script>
	<script src="${ctx}/static/js/app/myinfo-add.js"></script>
	<script src="${ctx}/static/lib/layer-v2.3/layer.js"></script>
	<script src="${ctx}/static/js/app/ajaxRequest.js"></script>
	
	
</head>
<body>
<div>
系统消息标题:<input type="text" id = "smTitle" name = "smTitle">
</div>
<div>
系统消息内容：<textarea id = "smContent" name = "smContent"></textarea>
</div>
<div>
<input type="button" onclick="addMessage()" value="提交系统消息">
</div>
</body>
<script type="text/javascript">
function addMessage(){
    var smTitle = $("#smTitle").val();
     var smContent = $("#smContent").val();
   ajaxRequest.addSysMessage({smTitle: smTitle,smContent:smContent}).then(function (data) {
        alert(data.message);
   });
}
</script>
</html>