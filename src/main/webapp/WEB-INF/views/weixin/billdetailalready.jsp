<%--
  Created by IntelliJ IDEA.
  User: jinshw
  Date: 2016/7/31
  Time: 22:46
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
        <div class="weui_cell_ft" id="billNum"></div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊人</p>
        </div>
        <div class="weui_cell_ft" id="patient"></div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊医院</p>
        </div>
        <div class="weui_cell_ft" id="hospital"></div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊时间</p>
        </div>
        <div class="weui_cell_ft" id="visitsTime"></div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p>就诊科室</p>
        </div>
        <div class="weui_cell_ft" id="depart"></div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary" id="billDetalList">
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_bd weui_cell_primary">
            <p style="font-weight: bold;">费用总额</p>
        </div>
        <div class="weui_cell_ft" style="font-weight: bold;" id="total"></div>
    </div>
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
                    '<span class="bill-detail-name">' + _detailObj.detailName + '</span>' +
                    '<span class="bill-detail-num">' + _detailObj.detailAmout + '</span>元' +
                    '</div>';
        }
        $("#billDetalList").html(_billDetalList);
    }

</script>
</body>
</html>