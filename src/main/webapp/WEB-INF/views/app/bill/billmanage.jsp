<%--
  Created by IntelliJ IDEA.
  User: jinshw
  Date: 2016/7/31
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>账单管理</title>

    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui/lib/weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui/css/jquery-weui.css">
    <!--<link rel="stylesheet" href="../static/lib/jquery-weui/demos/css/demos.css">-->

    <style>
        /*[class*="weui-col-"] {
            border: 1px solid #ccc;
            height: 40px;
            line-height: 40px;
            text-align: center;
        }*/
        .result-table .table-header {
            /*border: 1px solid #ccc;*/
            height: 0.40rem;
            line-height: 0.40rem;
            text-align: center;
            color: #fff;
            background-color: #10ae63;
            margin-top: 0.10rem;
        }

        .result-table .table-tr {
            height: 0.40rem;
            line-height: 0.40rem;
            text-align: center;
            color: #000;
            border-bottom: 1px solid #CBCBCD;
        }

        /*.table-header {
            background-color: #19AA9D;
            margin-top:10px;
        }*/

        .weui_btn_primary {
            background-color: #10ae63;
        }

        .weui_cells {
            margin-top: 0px;
            /*font-size: 0.14rem;*/
        }

        .weui_cell {
            line-height: 0.3rem;
        }

        .table-tr {
            /*background-color: #f1f1f1;*/
            background-color: #FFFFFF;
        }

        .div-bt {
            width: 100%;
            height: 0.40rem;
            display: flex;
            font-size: 0.17rem;
        }

        .div-bt .div-child-bt {
            width: 50%;
            background-color: #FFFFFF;
            /*border-bottom: 2px solid #10ae63;*/
            line-height: 0.40rem;
            text-align: center;
        }

		.weui_cells_radio .weui_check:checked + .weui_icon_checked:before {
	    	display: block;
	    	content: '\EA08';
	    	color: #2ed0bb;
	    	font-size: 16px;
		}
		
		.toolbar .picker-button {
		  position: absolute;
		  right: 0;
		  box-sizing: border-box;
		  height: 0.48rem;
		  line-height: 0.48rem;
		  color: #2ed0bb;
		  z-index: 1;
		  padding: 0 .5rem;
		}
    </style>
<script>
    var CODE_VALUE = "${code}";
</script>
<script src="${ctx}/static/lib/jquery-weui/lib/jquery-2.1.4.js"></script>
<script src="${ctx}/static/lib/jquery-weui/js/jquery-weui.js"></script>
<script src="${ctx}/static/lib/layer-v2.3/layer.js"></script>
<script src="${ctx}/static/js/app/ajaxRequest.js"></script>
<script src="${ctx}/static/js/app/common-app.js"></script>
</head>
<body>
<div class="weui_cells weui_cells_form">
    <div class="weui_cell">
        <div class="weui_cell_hd"><label for="hospitalList" class="weui_label">就诊医院</label></div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" id="hospitalList" name="hospitalList" type="text" value="" placeholder="请选择就诊医院">
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd"><label for="patientList" class="weui_label">就诊人</label></div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" id="patientList" name="patientList" type="text" value="" placeholder="请选择就诊人" readonly>
        </div>
    </div>
</div>
<div class="weui-row weui-no-gutter">
    <!-- <div class="weui-col-50">
         <a href="javascript:;" class="weui_btn weui_btn_primary" style="margin:10px;" id="notPayBt">未支付</a>
     </div>
     <div class="weui-col-50">
         <a href="javascript:;" class="weui_btn weui_btn_default" style="margin:10px;" id="alreadyPayBt">已支付</a>
     </div>-->
    <div class="div-bt">
        <div class="div-child-bt" id="notPayBt" style="border-bottom:2px solid #2ed0bb;">
            未支付
        </div>
        <div class="div-child-bt" id="alreadyPayBt">已处理</div>
    </div>
</div>
<!--<div class="result-table">
    <div class="weui-row weui-no-gutter table-header">
        <div class="weui-col-30">账单流水号</div>
        <div class="weui-col-30">开单科室</div>
        <div class="weui-col-20">金额</div>
        <div class="weui-col-20">状态</div>
    </div>
    <div class="weui-row weui-no-gutter table-tr">
        <div class="weui-col-30">2016-07-15</div>
        <div class="weui-col-30">
            <div>普外科普外科普外科</div>
        </div>
        <div class="weui-col-20">300</div>
        <div class="weui-col-20">待付</div>
    </div>
</div>-->
<div id="notPayList">
    <!--<div class="weui_cells table-tr">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary ">
                <p>账单流水号：20160716</p>
                <p>开单科室：普通外科</p>
                <p>状态：待付</p>
            </div>
            <div class="weui_cell_ft">300元</div>
        </div>
    </div>
    <div class="weui_cells table-tr">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>账单流水号：20160716</p>
                <p>开单科室：普通外科</p>
                <p>状态：待付</p>
            </div>
            <div class="weui_cell_ft">300元</div>
        </div>
    </div>-->
</div>
<div id="alreadyPayList" style="display: none;">
    <!-- <div class="weui_cells table-tr">
         <div class="weui_cell">
             <div class="weui_cell_bd weui_cell_primary">
                 <p>账单流水号：20160716</p>
                 <p>开单科室：普通外科</p>
                 <p>状态：已支付</p>
             </div>
             <div class="weui_cell_ft">300元</div>
         </div>
     </div>
     <div class="weui_cells table-tr">
         <div class="weui_cell">
             <div class="weui_cell_bd weui_cell_primary">
                 <p>账单流水号：20160716</p>
                 <p>开单科室：普通外科</p>
                 <p>状态：已支付</p>
             </div>
             <div class="weui_cell_ft">300元</div>
         </div>
     </div>-->
</div>
<input hidden="hidden" value="notPay" id="payStateHidden"/>
<script src="${ctx}/static/js/app/billmanage.js"></script>
</body>
</html>
