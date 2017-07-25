<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en" style="height: 100%;">
  <head>
    <meta charset="UTF-8">
    <title>页面出错了</title>
    <style type="text/css">
		.vc-img {
		    width: 100%;
		    height: 100%;
		    position: relative;
		}
		.vc-img img {
		    width: 80%;
		    height: 400px;
		    position: absolute;
		    top: 15%;
		    left: 10%
		}
	</style>
  </head>
  <body style="height: 100%;">
	<div class="vc-img">
		<img src="${ctx}/static/images/500.png"/>
	</div>
  </body>
</html>
