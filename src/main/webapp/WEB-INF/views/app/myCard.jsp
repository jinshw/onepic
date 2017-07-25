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
    <link rel="stylesheet" href="${ctx}/static/css/app/myinfo-oncard.css">

</head>
<body>
<input type="hidden" value="${op.patientId }" id = "patientId">
<input type="hidden" value="${op.otype }" id = "otype">
<input type="hidden" value="${op.id }" id = "id">
<div class="header">
    <div class="back" id="backBt">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area">
        <span>添加就诊人</span>
    </div>
    <div class="right">
        <a id="searchDoctorBt">保存</a>
    </div>
</div>

<div class="myinfo-container">

    <div class="myinfo-detail">
        <a href="javascript:;" class="line-bar-detail open-popup" data-target="#nameUpdateFull">
            <div class="line-content">
                <span class="left">真实姓名</span>
               <span class="right">
                    <input type="text" class="content-input" name="name" id="name" value="${op.patientName }">
                </span>
            </div>
        </a>
        <div class="line-bar-detail">
            <div class="line-content">
                <span class="left">证件类型</span>
                <span class="right">
                    <input type="text" class="content-input" value="${op.idType }" id="idTypeId">
                    <i class="fa fa-angle-right fa-lg"></i>
                </span>
            </div>
        </div>
        <a href="javascript:;" class="line-bar-detail open-popup" data-target="#idNumUpdateFull">
            <div class="line-content">
                <span class="left">证件号码</span>
                <span class="right">
                    <input type="text" class="content-input"  id="idNum" name="idNum" value="${op.idNum }" readOnly>
                    <i class="fa fa-angle-right fa-lg"></i>
                </span>
            </div>
        </a>
        <div class="line-bar-detail">
            <div class="line-content">
                <span class="left">常驻城市</span>
                <span class="right">
                    <input type="text" class="content-input" value="${op.city}" id="cityId">
                    <i class="fa fa-angle-right fa-lg"></i>
                </span>
            </div>
        </div>
    </div>
</div>
<div class="oncard-bt-bar">
    <div class="oncard-bt"  onclick="delPatient()">删除就诊人</div>
    <!--<div class="oncard-bt" id="createCardBt">在线建卡</div>-->
</div>
<div class="oncard-bt-bar">
    <div class="oncard-bt" id="bindingCardBt">绑定就诊卡</div>
    <!--<div class="oncard-bt" id="createCardBt">在线建卡</div>-->
</div>

<div class="title-bar">
    <div class="title-content">
        <div class="ver-line"></div>
        <div style="margin-left: 20px;">就诊卡列表</div>
    </div>
</div>

<div class="card-list">
<c:forEach items="${oucList}" var="ouc" varStatus="status">
    <div class="card-container">
        <div class="card-content" id ="test1">
            <div class="card-line-bar line-bar-start">
            <span class="line-left">
                 医院
            </span>
                <sapn class="line-right oncard-show" id="getHospitalName">
             <c:if test="${ouc.medicalcode ==000001}">包头市中心医院</c:if>       
             <c:if test="${ouc.medicalcode ==1002}">包头肿瘤医院</c:if>       
             <c:if test="${ouc.medicalcode ==1003}">包钢第三职工医院</c:if>       
                </sapn>
            </div>
        </div>
        <div class="card-content" id ="test1">
            <div class="card-line-bar line-bar-start">
            <span class="line-left">
                健康卡
            </span>
                <sapn class="line-right oncard-show" id="getMZh">
                    ${ouc.medicalcard }
                </sapn>
            </div>
        </div>
        <div class="card-content">
            <div class="card-line-bar">
            <span class="line-left">
                条形码
            </span>
                <img class="card-bar-code" src="${ctx}/static/images/wx/${ouc.barCode }">
            </div>
        </div>
        <div class="card-content">
            <div class="card-line-bar">
            <span class="line-left">
                二维码
            </span>
                <img class="card-qr-code" src="${ctx}/static/images/wx/${ouc.qrCode }">
            </div>
        </div>
        <div class="card-content">
            <div class="card-line-bar line-bar-end">
                <div class="save-bt">
                    解除绑定
                </div>
            </div>
        </div>
    </div>
</c:forEach>
</div>
<script src="${ctx}/static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/jquery-weui.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/city-picker.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/swiper.js"></script>
<script src="${ctx}/static/js/ajaxRequest.js"></script>
<script src="${ctx}/static/js/app/myinfo-oncard.js"></script>
<script src="${ctx}/static/lib/layer-v2.3/layer.js"></script>

</body>
</html>