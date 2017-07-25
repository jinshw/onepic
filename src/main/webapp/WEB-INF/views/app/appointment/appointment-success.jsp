<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>预约成功</title>

    <link rel="stylesheet" href="../static/lib/jquery-weui-app2/lib/weui.css">
    <link rel="stylesheet" href="../static/lib/jquery-weui-app2/css/jquery-weui.css">
    <link rel="stylesheet" href="../static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <style type="text/css">
        body {
            background-color: #f2f2f2;
            font-family: 微软雅黑;
        }

        a {
            color: #2d374b;
            text-decoration: none
        }

        a:hover {
            color: #cd0200;
            text-decoration: underline
        }

        a:link {
            text-decoration: none /*无下划线*/
        }

        .header {
            background-color: #2ed0bb;
            height: 88px;;
            width: 100%;
            margin-bottom: 20px;
            color: #FFFFFF;
            position: relative;
        }

        .main {
            width: 100%;
            background-color: #FFF;
        }

        .container {
            width: 100%;
            background-color: #FFFFFF;
        }

        .content {
            /*width:100%;*/
            height: 180px;
            border-bottom: 1px solid #dfdfdf;
            margin-left: 25px;
            margin-right: 25px;
            position: relative;
        }

        .container-bottom {
            box-shadow: 0 2px 10px #e0dfdf;
        }

        .header .back {
            position: absolute;
            top: 15px;
            left: 20px;
            z-index: 2;
        }

        .header .area {
            position: relative;
            /*background-color: #fff;*/
            font-size: 30px;
            text-align: center;
            line-height: 95px;
            color: #fefefe;
        }

        .title-bar {
            width: 100%;
            height: 57px;
            position: relative;
        }

        .title-bar .title-bar-icon {
            width: 2px;
            height: 20px;
            background-color: #ff8a6f;
            position: absolute;
            left: 24px;
            top: 10px;
        }

        .title-bar .title-bar-content {
            position: absolute;
            left: 38px;
            top: -4px;
            font-size: 30px;
        }

        .number-info {
            width: 100%;
            background-color: #FFFFFF;
            display: flex;
            justify-content: center;
            color: #1a1a1a;
            font-size: 38px;
        }

        .number-line {
            width: 85%;
            height: 112px;
            line-height: 112px;
            border-bottom: 1px solid #dfdfdf;
            position: relative;
        }

        .number-line .num-val {
            margin-right: 10px;
        }

        .num-info-bottom {
            margin-bottom: 20px;
            box-shadow: 0 2px 10px #e0dfdf;
        }

        .num-total {
            color: #21b4a1;
        }

        .weui_input {
            width: 565px;
            height: 60px;
            border-bottom: 1px solid #dfdfdf;
        }

        .submit-bt {
            display: flex;
            justify-content: center;
            margin-top: 100px;
        }

        .submit-bt .weui_btn_primary {
            background-color: #2ed0bb;
            height: 80px;
            line-height: 80px;
            width: 575px;
            border: 1px solid #2ed0bb;
            font-size: 30px;
            border-radius: 8px;
            color: #FFFFFF;
            text-align: center;
        }

        .weui_btn_primary:not(.weui_btn_disabled):active {
            color: hsla(0, 0%, 100%, .4);
            background-color: #21b4a1;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="back">
        <i class="fa fa-angle-left" style="font-size: 60px;"></i>
    </div>
    <div class="area">
        <span>预约成功</span>
    </div>
</div>

<div class="number-info">
    <div class="number-line">
        <span class="num-title">医院：</span>
        <span class="num-val" style="color:#21b4a1;">${hospName}</span>
    </div>
</div>
<div class="number-info">
    <div class="number-line">
        <span class="num-title">科室：</span>
        <span class="num-val">${departName}</span>
    </div>
</div>
<div class="number-info">
    <div class="number-line">
        <span class="num-title">医生：</span>
        <span class="num-val">${doctorName}</span>
        <span class="num-val">${doctorTile}</span>
    </div>
</div>
<div class="number-info">
    <div class="number-line">
        <span class="num-title">就诊时间：</span>
        <span class="num-val">${regDate}</span>
        <span class="num-val">${visitTime}</span>
    </div>
</div>
<div class="number-info">
    <div class="number-line">
        <span class="num-title">就诊人：</span>
        <span class="num-val">${patName}</span>
    </div>
</div>
<div class="number-info num-info-bottom">
    <div class="number-line" style="text-align: right;">
        <span class="num-title">总计费用：</span>
        <span class="num-val num-total">${fee}元</span>
    </div>
</div>
<div style="font-size: 38px;float: left;margin-left: 20px;margin-right: 20px;">
    取号地点：${payPrompt}
</div>

<script src="../static/lib/jquery-weui-app2/lib/jquery-2.1.4.js"></script>
<script src="../static/lib/jquery-weui-app2/js/jquery-weui.js"></script>
<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    //返回
    $(".back").click(function () {
        window.history.go(-1);//回退
    });

    var result = ${result};
    console.log(result);
    if (result.state == '500') {
        $.alert(result.msg,function () {
            window.history.go(-1);//回退
        }, "警告");
    }




</script>
</body>
</html>