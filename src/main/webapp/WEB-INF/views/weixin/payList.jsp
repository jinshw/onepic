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
    <title>测试支付列表页</title>
</head>
<body>
<div class="index_box">
    <div class="apply_name">微信js支付测试</div>
    <form action="pay" method="post">
        <div class="branch_con">
            <ul>
                <li><span class="name">测试支付列表页</span></li>
            </ul>
            <div>
                <span>code</span>
                <input type="text" name="code" value="${code}" />
            </div>
            <div>
                <span>outTradeNo</span>
                <input type="text" name="outTradeNo" id="outTradeNo" value="201611231321312" />
            </div>
            <div>
                <span>total</span>
                <input type="text" name="total" value="0.01" />
            </div>
            <div>
                <span>bodyStr</span>
                <input type="text" name="bodyStr" value="test" />
            </div>
			<div>
                <span>hospitalId</span>
                <input type="text" name="hospitalId" value="000001" />
            </div>
            <input type="submit" value="去支付详情页"></button>
        </div>
    </form>
</div>
<script>
        document.getElementById("outTradeNo").value = "2016"+parseInt( Math.random()*700 + 800,10);
</script>
</body>
</html>
