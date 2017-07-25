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
    <title>我的信息</title>

    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/lib/weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/css/jquery-weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/css/app/myinfo-add.css">

</head>
<body>
<div class="header">
    <div class="back" id="backBt">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area">
        <span>添加就诊人</span>
    </div>
    <div class="right">
    </div>
</div>


<div class="myinfo-container">
<form   id="myform" method="post">
    <div class="myinfo-detail">
        <div class="line-bar-detail open-popup" data-target="#nameUpdateFull">
            <div class="line-content">
                <span class="left">真实姓名</span>
                <span class="right">
                    <input type="text" class="content-input" name="name" id="name" value="${op.patientName }">
                </span>
            </div>
        </div>
        <div class="line-bar-detail">
            <div class="line-content">
                <span class="left">证件类型</span>
                <span class="right">
                    <input type="text" class="content-input" name="idTypeId" id="idTypeId" value="${op.idType}">
                    <i class="fa fa-angle-right fa-lg"></i>
                </span>
            </div>
        </div>
        <div class="line-bar-detail open-popup" data-target="#idNumUpdateFull">
            <div class="line-content">
                <span class="left">证件号码</span>
                <span class="right">
                    <input type="text" class="content-input"  id="idNum" name="idNum" value="${op.idNum }">
                    <i class="fa fa-angle-right fa-lg"></i>
                </span>
            </div>
        </div>
        <div class="line-bar-detail">
            <div class="line-content">
                <span class="left">常驻城市</span>
                <span class="right">
                    <input type="text" class="content-input" id="cityId" name="cityId" value="${op.city }">
                    <i class="fa fa-angle-right fa-lg"></i>
                </span>
            </div>
        </div>
        <input type="hidden" value="${mobile}" id="userMobile" name="userMobile">
     
        <div class="line-bar-detail" style="height: 1.2rem;line-height: 1.2rem;">
            <div class="myinfo-save" id="myinfoSaveBt">保存</div>
        </div>
    </div>
    </form>  
    <input type="hidden" value="${flag}" id="flag" >
    <input type="hidden" value="${retMsg}" id="retMsg" >
</div>


<script src="${ctx}/static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/jquery-weui.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/city-picker.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/swiper.js"></script>
<script src="${ctx}/static/js/ajaxRequest.js"></script>
<script src="${ctx}/static/js/app/myinfo-add.js"></script>
<script src="${ctx}/static/lib/layer-v2.3/layer.js"></script>
</body>
<script type="text/javascript">
$(function(){ 
   var city = $("#cityId").val();
   var type =$("#idTypeId").val();
   if(city==""){
   document.getElementById("cityId").value="内蒙古  包头";
   }
   if(type==""){
   document.getElementById("idTypeId").value="身份证";
   }
}); 
</script>
</html>