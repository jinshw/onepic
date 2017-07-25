<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>我的挂号</title>

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
            /*color: #cd0200;*/
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
            top: -4px;
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
            width: 912px;
            height: 130px;
            line-height: 130px;
            border-bottom: 1px solid #dfdfdf;
            position: relative;
        }

        .number-line .num-val {
            margin-right: 10px;
        }

        .num-info-bottom {
            margin-bottom: 22px;
            box-shadow: 0 2px 10px #e0dfdf;
        }

        .num-total {
            color: #21b4a1;
        }

        .weui_input {
            width: 510px;
            height: 60px;
            border-bottom: 1px solid #dfdfdf;
        }

        .submit-bt {
            display: flex;
            justify-content: center;
            margin-top: 100px;
        }

        .weui_btn_primary {
            background-color: #2ed0bb;
            height: 80px;
            line-height:80px;
            width: 310px;
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

        .order-state {
            position: absolute;
            right: 0;
            color: #21b4a1;
        }

        .bt-pay, .bt-cancel {
            background-color: #2ed0bb;
            height: 106px;
            line-height: 106px;
            width: 406px;
            border: 1px solid #2ed0bb;
            font-size: 36px;
            border-radius: 8px;
            color: #FFFFFF;
            text-align: center;
        }

        .bt-pay {
            position: absolute;
            left: 45px;
            top: 25px;
        }

        .bt-cancel {
            position: absolute;
            right: 45px;
            top: 25px;
            background-color: #FF7E7E;
            border: 1px solid #FF7E7E;
        }

        .bt-cancel:active {
            background-color: #FF7E7E;
            border: 1px solid #FF7E7E;
        }

        .num-bottom-bt {
            position: relative;
            height: 160px;
        }
        
        /** 微信样式 **/
        .weui_toast {
		  position: fixed;
		  z-index: 50000;
		  width: 15.8em;
		  min-height: 15.8em;
		  top: 180px;
		  left: 50%;
		  margin-left: -3.8em;
		  background: rgba(40, 40, 40, 0.75);
		  text-align: center;
		  border-radius: 15px;
		  color: #FFFFFF;
		}
    	.weui_loading_toast .weui_toast_content {
		  margin-top: 70%;
		  font-size: 31px;
		}
		.weui_loading {
		  position: absolute;
		  width: 0px;
		  z-index: 1;
		  left: 50%;
		  top: 38%;
		}
		.weui_loading_leaf:before {
		  content: " ";
		  position: absolute;
		  width: 24.42px;
		  height: 9.24px;
		  background: #d1d1d5;
		  box-shadow: rgba(0, 0, 0, 0.0980392) 0px 0px 1px;
		  border-radius: 1px;
		  -webkit-transform-origin: left 50% 0px;
		          transform-origin: left 50% 0px;
		}
		.weui_loading_leaf_0:before {
		  -webkit-transform: rotate(0deg) translate(23.76px, 0px);
		          transform: rotate(0deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_1:before {
		  -webkit-transform: rotate(30deg) translate(23.76px, 0px);
		          transform: rotate(30deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_2:before {
		  -webkit-transform: rotate(60deg) translate(23.76px, 0px);
		          transform: rotate(60deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_3:before {
		  -webkit-transform: rotate(90deg) translate(23.76px, 0px);
		          transform: rotate(90deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_4:before {
		  -webkit-transform: rotate(120deg) translate(23.76px, 0px);
		          transform: rotate(120deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_5:before {
		  -webkit-transform: rotate(150deg) translate(23.76px, 0px);
		          transform: rotate(150deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_6:before {
		  -webkit-transform: rotate(180deg) translate(23.76px, 0px);
		          transform: rotate(180deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_7:before {
		  -webkit-transform: rotate(210deg) translate(23.76px, 0px);
		          transform: rotate(210deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_8:before {
		  -webkit-transform: rotate(240deg) translate(23.76px, 0px);
		          transform: rotate(240deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_9:before {
		  -webkit-transform: rotate(270deg) translate(23.76px, 0px);
		          transform: rotate(270deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_10:before {
		  -webkit-transform: rotate(300deg) translate(23.76px, 0px);
		          transform: rotate(300deg) translate(23.76px, 0px);
		}
		.weui_loading_leaf_11:before {
		  -webkit-transform: rotate(330deg) translate(23.76px, 0px);
		          transform: rotate(330deg) translate(23.76px, 0px);
		}
		.weui_toast {
		  left: 42%;
		  top: 35%;
		  margin-left: -3.8em;
		}
		.weui_dialog_title {
		    font-weight: 400;
		    font-size: 48px;
		}
		.weui_dialog_bd {
		    padding: 5px 20px;
		    font-size: 40px;
		    color: #888;
		    word-wrap: break-word;
		    word-break: break-all;
		}
		.weui_dialog_ft {
		    position: relative;
		    line-height: 102px;
		    margin-top: 49px;
		    font-size: 45px;
		    display: flex;
		}
		.weui_dialog {
		    position: fixed;
		    width: 85%;
		    background-color: #FAFAFC;
		    text-align: center;
		    border-radius: 12px;
		}
		.weui_toast_content {
		    margin: 20px 0 15px;
		    font-size: 35px;
		}
		.weui_icon_toast:before {
		    content: '\EA08';
		    color: #FFFFFF;
		    font-size: 100px;
		}
		.weui_icon_toast {
		    margin: 34px 0 0;
		    display: block;
		}
    </style>
</head>
<body>
<div class="header">
    <div class="back">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area">
        <span>我的挂号</span>
    </div>
</div>

<!--选择就诊人-->
<div class="number-info num-info-bottom">
    <div class="number-line">
        <span class="num-title">当前就诊人：</span>
        <input class="weui_input" id="patientId" type="text" value="">
    </div>
</div>

<div style="text-align: center;margin: 10px 0 20px 0;font-size: 34px;">
    如果有问题，请及时联系客服电话：18947736591
</div>

<div class="order-list">
    <div class="order-container">
        <div class="number-info">
            <div class="number-line">
                <span class="num-title">订单号：</span>
                <span class="num-val order-num" style="color:#21b4a1;">wx_20160820100128111222</span>
                <span class="order-state">已取消</span>
            </div>
        </div>
        <div class="number-info">
            <div class="number-line">
                <span class="num-title">医生名称：</span>
                <span class="num-val">王斌</span>
            </div>
        </div>
        <div class="number-info">
            <div class="number-line">
                <span class="num-title">就诊科室：</span>
                <span class="num-val">骨科—骨二科</span>
            </div>
        </div>
        <div class="number-info">
            <div class="number-line">
                <span class="num-title">就诊时间：</span>
                <span class="num-val">2016-08-10</span>
                <span class="num-val">8:00-10:00</span>
            </div>
        </div>
        <div class="number-info">
            <div class="number-line" style="text-align: right;">
                <span class="num-title">总计费用：</span>
                <span class="num-val num-total">7元</span>
            </div>
        </div>
        <div class="number-info num-info-bottom num-bottom-bt">
            <a href="javascript:;" class="bt-pay" style="margin-top: 0;">确认支付</a>
            <a href="javascript:;" class="bt-cancel" style="margin-top: 0;">取消支付</a>
        </div>
    </div>
</div>

<script src="../static/lib/jquery-weui-app2/lib/jquery-2.1.4.js"></script>
<script src="../static/lib/jquery-weui-app2/js/jquery-weui.js"></script>
<script src="${ctx}/static/js/app/ajaxRequest.js"></script>

<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    //返回
    $(".back").click(function () {
        window.jsobj.back(4);
    });

    var _items = ${data.patList};
    $("#patientId").select({
        title: "请选就诊人",
        items: _items,
        onChange: function(data){
         ajaxRequest.orderdetails({patientId:data.values}).then(function (resp) {
         if(resp.state==200){
          var _content = "";
		        for (var i = 0; i < resp.list.length; i++) {
		            _content = _content +
		                    '<div class="order-container">                                                                    ' +
		                    '    <div class="number-info">                                                                    ' +
		                    '        <div class="number-line">                                                                ' +
		                    '            <span class="num-title">订单号：</span>                                              ' +
		                    '            <span class="num-val order-num" style="color:#21b4a1;">' + resp.list[i].appointOrderId + '</span>';
		
		            if (resp.list[i].orderType == 0) {
		                _content = _content + '<span class="order-state">待支付</span>';
		            } else if (resp.list[i].orderType == 1) {
		                _content = _content + '<span class="order-state">已支付</span>';
		            } else if (resp.list[i].orderType == 2) {
		                _content = _content + '<span class="order-state">已取消</span>';
		            } else if (resp.list[i].orderType == 3){
		            	_content = _content + '<span class="order-state">已退费</span>';
		            } else if (resp.list[i].orderType == 4){
                        _content = _content + '<span class="order-state">已预约</span>';
                    }
		
		            _content = _content +
		                    '        </div>                                                                                   ' +
		                    '    </div>                                                                                       ' +
		                    '    <div class="number-info">                                                                    ' +
		                    '        <div class="number-line">                                                                ' +
		                    '            <span class="num-title">医生名称：</span>                                            ' +
		                    '            <span class="num-val">' +resp.list[i].doctorName + '</span>                                                    ' +
		                    '        </div>                                                                                   ' +
		                    '    </div>                                                                                       ' +
		                    '    <div class="number-info">                                                                    ' +
		                    '        <div class="number-line">                                                                ' +
		                    '            <span class="num-title">就诊科室：</span>                                            ' +
		                    '            <span class="num-val">' +resp.list[i].departName + '</span>                                             ' +
		                    '        </div>                                                                                   ' +
		                    '    </div>                                                                                       ' +
		                    '    <div class="number-info">                                                                    ' +
		                    '        <div class="number-line">                                                                ' +
		                    '            <span class="num-title">就诊时间：</span>                                            ' +
		                    '            <span class="num-val">' + resp.list[i].regDate + '</span>                                              ' +
		                    '            <span class="num-val">' + resp.list[i].visitTime + '</span>                                              ' +
		                    '        </div>                                                                                   ' +
		                    '    </div>                                                                                       ' +
		                    '    <div class="number-info">                                                                    ' +
		                    '        <div class="number-line" style="text-align: right;">                                     ' +
		                    '            <span class="num-title">总计费用：</span>                                            ' +
		                    '            <span class="num-val num-total">' + resp.list[i].fee + '元</span>                                           ' +
		                    '        </div>                                                                                   ' +
		                    '    </div>                                                                                       ' +
		                    '    <div class="number-info num-info-bottom num-bottom-bt">                                      ';
		                    if(resp.list[i].orderType == 0) {
		                    	_content = _content +
		                    	'        <a href="javascript:;" class="bt-pay" style="margin-top: 0;" data-orderTime="' + resp.list[i].orderTime.time + '">确认支付</a>                ' +
		                    	'        <a href="javascript:;" class="bt-cancel" style="margin-top: 0;" data-type="cancel" data-flag="0">取消支付</a>             ';
		                    } else if (resp.list[i].orderType == 1) {
		                    	_content = _content +
		                    	'        <a href="javascript:;" class="bt-cancel" style="margin-top: 0;" data-type="refund" data-flag="0">申请退费</a>             ';
		            		} if (resp.list[i].orderType == 4){
                                _content = _content +
                                        '<div style="float: left;margin-left: 0.2rem;margin-right:0.2rem;margin-top: 0.1rem;color: #f30000;">' +
                                        '取号地点：预约挂号窗口取号，取号时请带预约成功的订单号</div>';
                            }
		            		_content = _content +
		                    '    </div>                                                                                       ' +
		                    '</div>                                                                                           ';
		        }
		        $(".order-list").html(_content);
		        toDetailPage();
		        
		        toPay();
		        
		        toCancel();
		        }
         })
        }
    });
    function initList(arr) {
        var _content = "";
        for (var i = 0; i < arr.length; i++) {
            _content = _content +
                    '<div class="order-container">                                                                    ' +
                    '    <div class="number-info">                                                                    ' +
                    '        <div class="number-line">                                                                ' +
                    '            <span class="num-title">订单号：</span>                                              ' +
                    '            <span class="num-val order-num" style="color:#21b4a1;">' + arr[i].appointOrderId + '</span>';

            if (arr[i].orderType == 0) {
                _content = _content + '<span class="order-state">待支付</span>';
            } else if (arr[i].orderType == 1) {
                _content = _content + '<span class="order-state">已支付</span>';
            } else if (arr[i].orderType == 2) {
                _content = _content + '<span class="order-state">已取消</span>';
            } else if (arr[i].orderType == 3){
                _content = _content + '<span class="order-state">已退费</span>';
            } else if (arr[i].orderType == 4){
                _content = _content + '<span class="order-state">已预约</span>';
            }

            _content = _content +
                    '        </div>                                                                                   ' +
                    '    </div>                                                                                       ' +
                    '    <div class="number-info">                                                                    ' +
                    '        <div class="number-line">                                                                ' +
                    '            <span class="num-title">就诊人：</span>                                            ' +
                    '            <span class="num-val">' + arr[i].patientName + '</span>                                                    ' +
                    '        </div>                                                                                   ' +
                    '    </div>                                                                                       ' +
                    '    <div class="number-info">                                                                    ' +
                    '        <div class="number-line">                                                                ' +
                    '            <span class="num-title">医生名称：</span>                                            ' +
                    '            <span class="num-val">' + arr[i].doctorName + '</span>                                                    ' +
                    '        </div>                                                                                   ' +
                    '    </div>                                                                                       ' +
                    '    <div class="number-info">                                                                    ' +
                    '        <div class="number-line">                                                                ' +
                    '            <span class="num-title">就诊科室：</span>                                            ' +
                    '            <span class="num-val">' + arr[i].departName + '</span>                               ' +
                    '        </div>                                                                                   ' +
                    '    </div>                                                                                       ' +
                    '    <div class="number-info">                                                                    ' +
                    '        <div class="number-line">                                                                ' +
                    '            <span class="num-title">就诊医院：</span>                                            ' +
                    '            <span class="num-val">' + arr[i].hospName + '</span>                                 ' +
                    '        </div>                                                                                   ' +
                    '    </div>                                                                                       ' +
                    '    <div class="number-info">                                                                    ' +
                    '        <div class="number-line">                                                                ' +
                    '            <span class="num-title">就诊时间：</span>                                            ' +
                    '            <span class="num-val">' + arr[i].regDate + '</span>                                              ' +
                    '            <span class="num-val">' + arr[i].visitTime + '</span>                                              ' +
                    '        </div>                                                                                   ' +
                    '    </div>                                                                                       ' +
                    '    <div class="number-info">                                                                    ' +
                    '        <div class="number-line" style="text-align: right;">                                     ' +
                    '            <span class="num-title">总计费用：</span>                                            ' +
                    '            <span class="num-val num-total">' + arr[i].fee + '元</span>                                           ' +
                    '        </div>                                                                                   ' +
                    '    </div>                                                                                       ' +
                    '    <div class="number-info num-info-bottom num-bottom-bt">                                      ';
                    if(arr[i].orderType == 0) {
                    	_content = _content +
                    	'        <a href="javascript:;" class="bt-pay" style="margin-top: 0;" data-orderTime="' + arr[i].orderTime.time + '">确认支付</a>                ' +
                    	'        <a href="javascript:;" class="bt-cancel" style="margin-top: 0;" data-type="cancel" data-flag="0">取消支付</a>             ';
                    } else if (arr[i].orderType == 1) {
                    	_content = _content +
                    	'        <a href="javascript:;" class="bt-cancel" style="margin-top: 0;" data-type="refund" data-flag="0">申请退费</a>             ';
            		} else if (arr[i].orderType == 4){
                        _content = _content +
                                '<div style="float: left;margin-left: 0.2rem;margin-right:0.2rem;margin-top: 0.1rem;color: #f30000;">' +
                                '取号地点：预约挂号窗口取号，取号时请带预约成功的订单号</div>';
                    }
            		_content = _content +
                    '    </div>                                                                                       ' +
                    '</div>                                                                                           ';
        }
        $(".order-list").html(_content);
        toDetailPage();
        
        toPay();
        
        toCancel();
    }
    initList(${data.orderList});//初始化页面

	//判断订单是否已经超过30分钟
    function comptime(orderTimes) {
        var date = new Date();
        var nowDate = new Date();
        date.setTime(orderTimes);
        date.setMinutes(date.getMinutes()+30); //当前时间加30分钟  
        var a = (nowDate.getTime() - date.getTime())/3600/1000;
        return a;
    }

	function toPay() {
		//确认支付
        $(".bt-pay").click(function () {
            console.log(this);
            var _pfOrderNum = $($(this).parent().siblings(".number-info:eq(0)").find(".order-num")).text();
            var _longTypeDate = $(this).data("orderTime");
            var a = comptime(_longTypeDate);
            if(a < 0) {//订单未失效可以付款
            	window.location.href = "/core/appointApp/orderListToPay?pfOrderNum="+_pfOrderNum;
            } else {//订单失效自动取消
            	var that = this;
            	ajaxRequest.cancelAppointOrder({pfOrderNum:_pfOrderNum}).then(function (data) {
		        		console.log("订单取消数据",data);
		        		$($(that).parent().siblings(".number-info:eq(0)").find(".order-state")).text("已取消");
		        		$(that).next().remove();
		        		$(that).remove();
		        		$.alert("抱歉，已超过支付时间，请重新预约！", "提示！");
		        		
		        });
		    }
        });
	}


    /**
     * 跳转详情页面事件
     */
    function toDetailPage() {
        $(".order-num").click(function () {
        var appointOrderId=$(this).html();
            window.location.href ="/core/appointApp/initAppointOrderDetailsList?appointOrderId="+appointOrderId;
        });
    }
	
	//点击取消订单或申请退费
	function toCancel() {
		//取消支付
        $(".bt-cancel").click(function () {
            console.log(this);
            var type = $(this).data("type");
            if(type == 'cancel') {
            	var that = this;
				var _pfOrderNum = $($(this).parent().siblings(".number-info:eq(0)").find(".order-num")).text();
				if($(that).data("flag") == "0") {
					$.confirm("您确定要取消挂号吗?", "确认?", function() {
						$(that).attr("data-flag","1");
			        	ajaxRequest.cancelAppointOrder({pfOrderNum:_pfOrderNum}).then(function (data) {
			        		if(data.state==200){
			        			console.log("订单取消数据",data);
				        		$($(that).parent().siblings(".number-info:eq(0)").find(".order-state")).text("已取消");
				        		$(that).prev().remove();
				        		$(that).remove();
				        		$.toast("挂号已经取消!",300000);
			        		}else if(data.state==500){
								$.toast(data.msg, "forbidden");
								$(that).attr("data-flag","0");
							}
			        	});
		          	
			        }, function() {
			          //取消操作
			        });
				}
    		} else {
    			var that = this;
    			var _pfOrderNum = $($(this).parent().siblings(".number-info:eq(0)").find(".order-num")).text();
    			console.log("pfOrderNum ==== "+_pfOrderNum);
    			if($(that).data("flag") == "0") {
	    			$.confirm("您确定要退费吗?", "确认?", function() {
	    				$(that).attr("data-flag","1");
			        	ajaxRequest.refund({pfOrderNum:_pfOrderNum}).then(function (data) {
			        		if(data.state==200){
			        			console.log("订单退费数据",data);
				        		$($(that).parent().siblings(".number-info:eq(0)").find(".order-state")).text("已退费");
				        		$(that).remove();
				        		$.toast("费用已退还!");
							}else if(data.state==500){
								$.alert(data.msg, "提示");
								$(that).attr("data-flag","0");
							} else if(data.state==300){
								console.log("订单退费数据",data);
				        		$($(that).parent().siblings(".number-info:eq(0)").find(".order-state")).text("已退费");
				        		$(that).remove();
				        		$.alert(data.msg, "提示");
							}
			        	});
			        }, function() {
			          //取消操作
			        });
    			}
    		}
        });
	}

	//将日期格式转换成YYYY-MM-DD HH:MM:SS
	function curDateTime(d){  
	    var year = d.getFullYear(); 
	    var month = d.getMonth()+1;   
	    var date = d.getDate();   
	    var day = d.getDay();   
	    var hours = d.getHours();   
	    var minutes = d.getMinutes();   
	    var seconds = d.getSeconds();   
	    var ms = d.getMilliseconds();     
	    var curDateTime= year;  
	    if(month>9)  
	    curDateTime = curDateTime +"-"+month;  
	    else  
	    curDateTime = curDateTime +"-0"+month;  
	    if(date>9)  
	    curDateTime = curDateTime +"-"+date;  
	    else  
	    curDateTime = curDateTime +"-0"+date;  
	    if(hours>9)  
	    curDateTime = curDateTime +" "+hours;  
	    else  
	    curDateTime = curDateTime +" 0"+hours;  
	    if(minutes>9)  
	    curDateTime = curDateTime +":"+minutes;  
	    else  
	    curDateTime = curDateTime +":0"+minutes;  
	    if(seconds>9)  
	    curDateTime = curDateTime +":"+seconds;  
	    else  
	    curDateTime = curDateTime +":0"+seconds;  
	    return curDateTime;   
    }
    
</script>
</body>
</html>