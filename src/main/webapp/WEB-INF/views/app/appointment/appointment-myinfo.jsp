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
    <title>绑定就诊人跳转</title>
    <script src="${ctx}/static/js/app/common-app.js"></script>
</head>
  
<body>
<script>
	var con;
	con = confirm("未绑定就诊卡，请先绑卡！"); //在页面上弹出对话框
	if(con == true) {
		window.location.href=window.jsobj.toVisitNumAdministration();
	} else {
		window.history.go(-1);//回退
	}
</script>
</body>
</html>
