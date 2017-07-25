<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>登录跳转</title>
    <script src="${ctx}/static/js/app/common-app.js"></script>
</head>
  
<body>
<script>
	alert("未登录，请先登录！"); //在页面上弹出对话框
	window.onload=function(){
		window.jsobj.Login();
	}
</script>
</body>
</html>
