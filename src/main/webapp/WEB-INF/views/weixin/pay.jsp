<%--
  Created by IntelliJ IDEA.
  User: jinshw
  Date: 2016/8/3
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>测试支付</title>
    <link rel="stylesheet" href="../static/lib/jquery-weui/lib/weui.css">
    <link rel="stylesheet" href="../static/lib/jquery-weui/css/jquery-weui.css">
    <script src="../static/lib/jquery-weui/lib/jquery-2.1.4.js"></script>
    <script src="../static/lib/jquery-weui/js/jquery-weui.js"></script>
</head>
<body>
<div class="index_box">
    <div class="apply_name">微信js支付测试</div>
    <div class="branch_con">
        <ul>
            <li><span class="name">测试支付信息</span></li>
        </ul>
        <p class="cz_btn"><a href="javascript:pay();" class="btn_1">立即支付</a></p>
        <button id="getBrandWCPayRequest">立即支付</button>
    </div>
</div>
</body>
<script type="text/javascript">
    alert(window.location.href);


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
                    alert(res.err_msg);
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                        $.toast("支付成功！", function() {
                            console.log('close');
                            window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx97d92d9c729a20b9&redirect_uri=http://www.ucom365.cn/core/wxpay/payListInit&response_type=code&scope=snsapi_userinfo&state=park";
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
</html>
