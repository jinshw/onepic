<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>预约挂号支付页面</title>

    <link rel="stylesheet" href="../static/lib/jquery-weui-app/lib/weui.css">
    <link rel="stylesheet" href="../static/lib/jquery-weui-app/css/jquery-weui.css">
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
            height: 0.88rem;;
            width: 100%;
            margin-bottom: 0.2rem;
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
            height: 1.80rem;
            border-bottom: 1px solid #dfdfdf;
            margin-left: 0.25rem;
            margin-right: 0.25rem;
            position: relative;
        }

        .container-bottom {
            box-shadow: 0 2px 10px #e0dfdf;
        }

        .header .back {
            position: absolute;
            top: 0.15rem;
            left: 0.20rem;
            z-index: 2;
        }

        .header .area {
            position: relative;
            /*background-color: #fff;*/
            font-size: 0.3rem;
            text-align: center;
            line-height: 0.95rem;
            color: #fefefe;
        }

        .title-bar {
            width: 100%;
            height: 0.57rem;
            position: relative;
        }

        .title-bar .title-bar-icon {
            width: 0.02rem;
            height: 0.20rem;
            background-color: #ff8a6f;
            position: absolute;
            left: 0.24rem;
            top: 0.10rem;
        }

        .title-bar .title-bar-content {
            position: absolute;
            left: 0.38rem;
            top: -0.04rem;
            font-size: 0.3rem;
        }

        .number-info {
            width: 100%;
            background-color: #FFFFFF;
            display: flex;
            justify-content: center;
            color: #1a1a1a;
            font-size: 0.28rem;
        }

        .number-line {
            width: 7rem;
            height: 1rem;
            line-height: 1rem;
            border-bottom: 1px solid #dfdfdf;
            position: relative;
        }

        .number-line .num-val {
            margin-right: 0.1rem;
        }

        .num-info-bottom {
            margin-bottom: 0.2rem;
            box-shadow: 0 2px 10px #e0dfdf;
        }

        .num-total {
            color: #21b4a1;
        }

        .weui_input {
            width: 5.65rem;
            height: 0.60rem;
            border-bottom: 1px solid #dfdfdf;
        }

        .submit-bt {
            display: flex;
            justify-content: center;
            margin-top: 1rem;
        }

        .submit-bt .weui_btn_primary {
            background-color: #2ed0bb;
            height: 0.8rem;
            line-height: 0.8rem;
            width: 5.75rem;
            border: 1px solid #2ed0bb;
            font-size: 0.3rem;
            border-radius: 0.08rem;
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
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
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

<script src="../static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
<script src="../static/lib/jquery-weui-app/js/jquery-weui.js"></script>
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
    var timeStamp = "${timeStamp}";
    var nonceStr = "${nonceStr}";
    var package = "${packageWx}";
    var signType = "${signType}";
    var paySign = "${paySign}";
    /* alert("appId:" + appId + " timeStamp=" + timeStamp + " nonceStr=" + nonceStr + " package=" + package + " signType=" + signType + " paySign=" + paySign); */

    document.querySelector('#getBrandWCPayRequest').onclick = function () {
        if (typeof (WeixinJSBridge) == "undefined") {
            if (document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            } else if (document.attachEvent) {
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            onBridgeReady();
        }
    };
    function onBridgeReady() {
        WeixinJSBridge.invoke(
                'getBrandWCPayRequest', {
                    "appId": appId,     //公众号名称，由商户传入
                    "timeStamp": timeStamp,         //时间戳，自1970年以来的秒数
                    "nonceStr": nonceStr, //随机串
                    "package": package,
                    "signType": signType,         //微信签名方式：
                    "paySign": paySign //微信签名
                },
                function (res) {
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                        $.toast("支付成功！", function () {
                            console.log('close');
                            window.location.href = "http://www.yunju360.com/core/appoint/initAppointOrderList";
                        });
                    } else {
                        $.toast("支付失败！", "forbidden");
                    }
                    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回   ok，
                    // 但并不保证它绝对可靠。
                }
        );
    }

</script>
</body>
</html>