<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>预约挂号支付页面</title>

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
            height: 118px;
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
            font-size: 40px;
            text-align: center;
            line-height:  120px;
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
            top: 4px;
            font-size: 30px;
        }

        .number-info {
            width: 100%;
            background-color: #FFFFFF;
            display: flex;
            justify-content: center;
            color: #1a1a1a;
            font-size: 36px;
        }

        .number-line {
            width: 917px;
            height: 131px;
            line-height: 131px;
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
            height: 106px;
            line-height: 106px;
            width: 748px;
            border: 1px solid #2ed0bb;
            font-size: 38px;
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
        <i class="fa fa-angle-left" style="font-size:70px; line-height:88px;"></i>
    </div>
    <div class="area">
        <span>支付页面</span>
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
<div class="submit-bt" style="margin-top:0.5rem;">
    <a href="javascript:;" class="weui_btn weui_btn_primary" id="getBrandWCPayRequest">去支付</a>
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


    /**
     * 去支付
     */
    // 支付
    var appId = "${appId}";
    var partnerid = "${partnerid}";
    var prepayId = "${prepayId}";
    var packageValue = "${packageValue}";
    var nonceStr = "${nonceStr}";
    var timeStamp = "${timeStamp}";
    var paySign = "${paySign}";
/*     alert("appId ==" + appId + " , partnerid ==" + partnerid + " , prepayId =="+ prepayId + " , packageValue =="
    + packageValue + " , nonceStr==" + nonceStr + " , timeStamp ==" + timeStamp + " , paySign ==" + paySign); */

    $("#getBrandWCPayRequest").click(function () {
    	var nowTime = new Date().getTime();
	    var clickTime = $(this).attr("ctime");
	    if( clickTime != 'undefined' && (nowTime - clickTime < 10000)){
	        console.log('操作过于频繁，稍后再试');
	        return false;
	     }else{
	        $(this).attr("ctime",nowTime);
	        console.log('提交成功');
	        window.jsobj.goToPay(appId,partnerid,prepayId,nonceStr,timeStamp,packageValue,paySign);
	     }
    	/* $("#getBrandWCPayRequest").attr({"disabled":"disabled"});
        setTimeout(function(){
            $("#getBrandWCPayRequest").removeAttr("disabled");
        },10000); */
        //window.jsobj.goToPay(appId,partnerid,prepayId,nonceStr,timeStamp,packageValue,paySign);
        //window.jsobj.goToPay("wxb4ba3c02aa476ea1","1305176001","wx20161020103322623bdfe8ca0477335893","28538a1f60ec789daa16e0bc0ce08072","1476930802","Sign=WXPay","62465D0AADEFFF409A17F0B9ADF77E1B")
    });


</script>
</body>
</html>