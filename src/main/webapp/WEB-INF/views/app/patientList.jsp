<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>就诊人列表</title>

    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/lib/weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/css/jquery-weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/css/app/patient-list.css">

</head>
<body>

<div class="header">
    <div class="back" id="backBt">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area">
        <span>就诊人管理</span>
    </div>
    <div class="right">
        <a id="searchDoctorBt" onclick="addPatient()">添加</a>
    </div>
</div>
<c:forEach items="${oplist}" var="oplist" varStatus="status">
<div class="pat-list">
    <div class="line-bar-detail">
        <div class="line-content">
           <input type="hidden" id ="patientId" value="${oplist.patientId}">
            <span class="left">${oplist.patientName}</span>
                <span class="right">
                  <c:if test="${oplist.bindcardcnt=='0'}">暂未绑定就诊卡</c:if>
                  <c:if test="${oplist.bindcardcnt!='0'}"> 绑定${oplist.bindcardcnt }张就诊卡</c:if>
                    <i class="fa fa-angle-right fa-lg"></i>
                </span>
        </div>
    </div>
    
</div>
</c:forEach>
<div class="pat-list">
    <div style="text-align: center;padding: 10px">
        <div>
            点击右上侧“<span style="color:#2ed0bb;">添加</span>”可以添加更多就诊人
        </div>
</div>
</div>

<script src="${ctx}/static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/jquery-weui.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/city-picker.js"></script>
<script src="${ctx}/static/js/ajaxRequest.js"></script>
<script src="${ctx}/static/js/app/patient-list.js"></script>
<script>
    $(document).on("open", ".weui-popup-modal", function () {
        console.log("open popup");
    }).on("close", ".weui-popup-modal", function () {
        console.log("close popup");
    });
    
    function addPatient(){
    var userMobile = ${op.mobile};
    if(userMobile!=null&&!""==userMobile){}
    window.location.href="toAddPatient?userMobile="+userMobile+"&flag=1";
    }
</script>
</body>
</html>