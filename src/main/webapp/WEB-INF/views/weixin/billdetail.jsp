<%--
  Created by IntelliJ IDEA.
  User: jinshw
  Date: 2016/7/31
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>账单管理</title>

    <link rel="stylesheet" href="../static/lib/jquery-weui/lib/weui.css">
    <link rel="stylesheet" href="../static/lib/jquery-weui/css/jquery-weui.css">
    <!--<link rel="stylesheet" href="../static/lib/jquery-weui/demos/css/demos.css">-->

    <style>
        body {
            font-size: 16px;
        }

        .weui_cell_ft {
            color: #000;
        }

        .weui_btn_primary {
            background-color: #10ae63;
        }

        .bill-detail-bar {
            text-align: right;
            position: relative;
        }

        .bill-detail-bar .bill-detail-name {
            position: absolute;
            left: 75px;
        }

        .bill-detail-bar .bill-detail-num {
            margin-left: 10px;
        }
    </style>

</head>
<body>
<div class="weui_cells_title">账单详情</div>
<div class="weui_cells">
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>
                单号
            </p>
        </div>
        <div class="weui_cell_ft" id="billNum">2016071804</div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊人</p>
        </div>
        <div class="weui_cell_ft" id="patient">张三</div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊医院</p>
        </div>
        <div class="weui_cell_ft" id="hospital">包头市中心医院</div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊时间</p>
        </div>
        <div class="weui_cell_ft" id="visitsTime">2016-07-13</div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊科室</p>
        </div>
        <div class="weui_cell_ft" id="depart">普外科</div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary" id="billDetalList">
            <p>账单明细</p>
            <div class="bill-detail-bar">
                <span class="bill-detail-name">诊查费</span>
                <span class="bill-detail-num">20</span>元
            </div>
            <div class="bill-detail-bar">
                <span class="bill-detail-name">注射费</span>
                <span class="bill-detail-num">20</span>元
            </div>
            <div class="bill-detail-bar">
                <span class="bill-detail-name">心电图</span>
                <span class="bill-detail-num">20</span>元
            </div>
            <div class="bill-detail-bar">
                <span class="bill-detail-name">西药费</span>
                <span class="bill-detail-num">20</span>元
            </div>
            <div class="bill-detail-bar">
                <span class="bill-detail-name">诊查费</span>
                <span class="bill-detail-num">2022</span>元
            </div>
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p style="font-weight: bold;">费用总额</p>
        </div>
        <div class="weui_cell_ft" style="font-weight: bold;" id="total">260元</div>
    </div>
</div>
<div style="margin: 10px;">
    <a href="javascript:;" class="weui_btn weui_btn_primary" id="getBrandWCPayRequest">去支付</a>
</div>


<script src="../static/lib/jquery-weui/lib/jquery-2.1.4.js"></script>
<script src="../static/lib/jquery-weui/js/jquery-weui.js"></script>


<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 414 + "px !important";

    var _obj = ${list};
    console.log(_obj);
    var hospitalId = _obj.hospitalId;
    if(hospitalId == '000001'){
        $("#billNum").html(_obj.djh);
        $("#patient").html(_obj.patientName);//就诊人
        $("#hospital").html(_obj.hospitalName);
        $("#visitsTime").html(_obj.yysj);//就诊时间(现在传预约时间)
        $("#depart").html(_obj.kdks);//就诊科室
        $("#total").html(_obj.je);// 总金额

        var _billDetalList = "<p>账单明细</p>";
        var detailList = _obj.payInfoYZBeanList;
        var _detailObj;
        for (var i = 0; i < detailList.length; i++) {
            _detailObj = detailList[i];
            _billDetalList = _billDetalList +
                    '<div class="bill-detail-bar">' +
                    '<span class="bill-detail-name">' + _detailObj.mc + '</span>' +
                    '<span class="bill-detail-num">' + _detailObj.fmje + '</span>元' +
                    '</div>';
        }
        $("#billDetalList").html(_billDetalList);
    }else{
        var _detailObj = ${details};
        console.log("details----\n",_detailObj);
        $("#billNum").html(_obj.clinicSeq);
        $("#patient").html(_obj.patientName);//就诊人
        $("#hospital").html(_obj.hospitalName);
        $("#visitsTime").html();//就诊时间(现在传预约时间)
        $("#depart").html(_obj.deptName);//就诊科室
        $("#total").html(_obj.payAmout);// 总金额

        var _billDetalList = "<p>账单明细</p>";
        var detailList = _detailObj.list;
        var _detailObj;
        for (var i = 0; i < detailList.length; i++) {
            _detailObj = detailList[i];
            _billDetalList = _billDetalList +
                    '<div class="bill-detail-bar">' +
                    '<span class="bill-detail-name">' + _detailObj.typeName + '</span>' +
                    '<span class="bill-detail-num">' + _detailObj.typeAmout + '</span>元' +
                    '</div>';
        }
        $("#billDetalList").html(_billDetalList);
    }

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
                    alert(res.err_msg);
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                        $.toast("支付成功！", function () {
                            console.log('close');
                            window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx97d92d9c729a20b9&redirect_uri=http://www.ucom365.cn/core/bill/initList&response_type=code&scope=snsapi_userinfo&state=park";
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