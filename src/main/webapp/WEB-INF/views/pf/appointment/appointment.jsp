<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>预约挂号</title>
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/lib/weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/css/jquery-weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/lib/dropload/dropload.css">
    <link rel="stylesheet" href="${ctx}/static/css/appointment.css">
    <style type="text/css">
        .weui_search_bar:after {
            border-bottom: 0px solid #C7C7C7;
        }

        input[type=search] {
            border-radius: 5px;
            border: 1px solid #ebebeb;
            width: 6.45rem;
            height: 0.70rem;
            outline: none;
        }

        input[type=search]::-webkit-input-placeholder {
            color: #9B9B9B;
            text-align: center;
        }

        input[type=search]::-webkit-search-cancel-button {
            -webkit-appearance: none;
        }

        input[type=search]::-webkit-search-cancel-button {
            -webkit-appearance: none;
            position: relative;
            height: 0.20rem;
            width: 0.20rem;
            border-radius: 50%;
            background-color: #EBEBEB;
        }

        input[type=search]::-webkit-search-cancel-button:after {
            position: absolute;
            content: 'x';
            left: 25%;
            top: -12%;
            font-size: 0.20rem;
            color: #fff;
        }

        .input-search {
            margin: 0 0 0.10rem 0;
            text-indent: 0.56rem;
            font-size: 0.30rem;
            position: absolute;
            top: 0;
            left: 0.10rem;
            font-family: 微软雅黑;
            text-align: left;
        }

        .span-search {
            position: absolute;
            right: 0.18rem;
            top: 0.09rem;
            font-size: 0.30rem;
            color: #2ed0bb;
        }

        .search-icon {
            position: absolute;
            top: 0.19rem;
            left: 0.21rem;
        }

        .form-search {
            text-align: center;
            position: relative;
            height: 0.90rem;
        }

        .dropload-refresh, .dropload-update, .dropload-load, .dropload-noData {
            height: 0.50rem;
            line-height: 0.50rem;
            text-align: center;
            font-size: 0.3rem;
        }
        .content {
        	height: 2.1rem;
        }
        .func {
        	-moz-border-radius: 15px;
        	-webkit-border-radius: 12px;
        	borde-radius: 7px;
        	padding: 0px 6px 0px 6px;
        	font-size: 12px;
        	margin: 0 0.05rem 0 0;
        }
		.header-img {
			top: 0.4rem;
		}
    </style>
    <script src="${ctx}/static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
    <script src="${ctx}/static/lib/dropload/dropload.js"></script>
    <script src="${ctx}/static/lib/jquery-weui-app/js/jquery-weui.js"></script>
    <script src="${ctx}/static/lib/layer-v2.3/layer.js"></script>
    <script src="${ctx}/static/lib/jquery-weui-app/js/city-picker.js"></script>
    <script src="../static/js/ajaxRequest.js"></script>
    <script>
        var _cssText = document.querySelector("html").style.cssText;
        document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    </script>
</head>
<body>
<%--
<div class="header">
    <div class="back">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area" style="display:none">
        <input class="weui_input" id="areaId" type="text" value="" style="height: 0.50rem;
                text-align: right;
                position: absolute;
                top: 0.18rem;
                left: 0.80rem;
                width: 5.55rem;
                opacity: 0;
                color: #2ed0bb;" onchange="areaChange(this)">
        <span id="areaShow">包头</span>
        <i class="fa fa-angle-down fa-lg"></i>
    </div>
</div>
--%>

<div id="search_bar" style="margin-top: 15px;">
    <form class="form-search" id="searchForm" action="initHospList">
        <input class="input-search" type="search" name="hospitalName" id="search_input"
               autocomplete="off" value="${hospitalName}" placeholder="输入医院名称快速定位">
        <span class="span-search" id="searchBt">搜索</span>
        <div class="search-icon">
            <i class="weui_icon_search"></i>
        </div>
    </form>
</div>

<div id="droploadId">
    <div class="main" id="main">
        <%-- <c:forEach items="${list }" var="hosp">
            <div class="container" data-hosp-id="${hosp.hospitalId }" data-hosp-connHis="${hosp.connHis }">
                <div class="content">
                    <div class="header-img">
                        <img src="${ctx}/${hosp.logoImg}" alt="头像">
                    </div>
                    <div class="center-content">
                        <div class="title">
                                ${hosp.hospitalName}
                        </div>
                        <div class="level">
                            <span>等级：</span> ${hosp.hospGrade}
                        </div>
                        <div class="address">
                            <span>地址：</span>
                            <c:choose>
                                <c:when test="${fn:length(hosp.hospAddress) > 13 }">
                                    ${fn:substring(hosp.hospAddress,0,13)}...
                                </c:when>
                                <c:otherwise>
                                    ${hosp.hospAddress }
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div>
                        	<span class="func" style="border: 1px solid #E88637;color: #E88637;">挂号</span>
                        	<span class="func" style="border: 1px solid #F6D06F;color: #F6D06F;">诊间支付</span>
                        	<span class="func" style="border: 1px solid #4ED71A;color: #4ED71A;">家庭医生</span>
                        	<span class="func" style="border: 1px solid #1AD7D6;color: #1AD7D6;">咨询问诊</span>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach> --%>
    </div>
</div>

<script>
	var list = ${list};
	for(var i = 0; i < list.length; i++) {
		hospi = list[i];
		var func = hospitalFunc(hospi.hospitalId);
		var appendStr = '<div class="container" data-hosp-id="' + hospi.hospitalId + '" data-hosp-connHis="' + hospi.connHis + '">  ' +
						'	<div class="content">                                           ' +
						'		<div class="header-img">                                    ' +
						'			<img src="${ctx}/' + hospi.logoImg + '" alt="头像">		' +
						'		</div>                                                      ' +
						'		<div class="center-content">                                ' +
						'			<div class="title">' + hospi.hospitalName + '</div>		' +
						'			<div class="level">                                     ' +
						'				<span>等级：</span>' + hospi.hospGrade +
						'			</div>                                                  ' +
						'			<div class="address">                                   ' +
						'				<span>地址：</span>' + cutstr(hospi.hospAddress, 26) +
						'			</div>                                                  ' +
						'			<div>													';
						  if(func.appoint == 0 || hospi.connHis == 2) {
			appendStr = appendStr + '	<span class="func" style="border: 1px solid #F35656;color: #F35656;">挂号</span>';
						} if (func.bill == 0) {
			appendStr = appendStr + '	<span class="func" style="border: 1px solid #F69464;color: #F69464;">诊间支付</span>';		
						} if (func.familyDoctor == 0) {
			appendStr = appendStr + '	<span class="func" style="border: 1px solid #E7B734;color: #E7B734;">家庭医生</span>';		
						} if (func.consult == 0) {
			appendStr = appendStr + '	<span class="func" style="border: 1px solid #5ACF3F;color: #5ACF3F;">咨询问诊</span>';		
						}
			appendStr = appendStr + '</div>													' +
						'		</div>                                                      ' +
						'	</div>                                                          ' +
						'</div>                                                             ';
	       $("#main").append(appendStr);
	}
	

    $(function () {
        // dropload
        $('#droploadId').dropload({
            scrollArea: window,
            loadDownFn: function (me) {
                var hospName = $('#search_input').val();
                ajaxRequest.getHospPageList({hospName: hospName}).then(function (resp) {
                    if (resp.state == 200) {
                        for (var j = 0; j < resp.list.length; j++) {
                        	var func = hospitalFunc(resp.list[j].hospitalId);
                            console.log(resp.list[j].hospitalName);
                            var appendStr = '<div class="container" data-hosp-id="' + resp.list[j].hospitalId + '" data-hosp-connHis="' + resp.list[j].connHis + '">  ' +
											'	<div class="content">                                           	' +
											'		<div class="header-img">                                    	' +
											'			<img src="${ctx}/' + resp.list[j].logoImg + '" alt="头像"> 	' +
											'		</div>                                                      	' +
											'		<div class="center-content">                                	' +
											'			<div class="title">' + resp.list[j].hospitalName +'</div>	' +
											'			<div class="level">                                     	' +
											'				<span>等级：</span>' + resp.list[j].hospGrade +
											'			</div>                                                  	' +
											'			<div class="address">                                   	' +
											'				<span>地址：</span>' + cutstr(resp.list[j].hospAddress, 26) +
											'			</div>                                                  	' +
											'			<div>														';
											  if(func.appoint == 0 || resp.list[j].connHis == 2) {
								appendStr = appendStr + '	<span class="func" style="border: 1px solid #F35656;color: #F35656;">挂号</span>';
											} if (func.bill == 0) {
								appendStr = appendStr + '	<span class="func" style="border: 1px solid #F69464;color: #F69464;">诊间支付</span>';		
											} if (func.familyDoctor == 0) {
								appendStr = appendStr + '	<span class="func" style="border: 1px solid #E7B734;color: #E7B734;">家庭医生</span>';		
											} if (func.consult == 0) {
								appendStr = appendStr + '	<span class="func" style="border: 1px solid #5ACF3F;color: #5ACF3F;">咨询问诊</span>';		
											}
								appendStr = appendStr + '</div>														' +
											'		</div>                                                      	' +
											'	</div>                                                          	' +
											'</div>                                                             	';
                            $("#main").append(appendStr);
                            rollLoad();
                            // 每次数据加载完，必须重置
                            me.resetload();

                        }

                        if (resp.list.length == 0) {
                            // 每次数据加载完，必须重置
                            me.resetload();
                            // 无数据
                            me.noData();
                            // 锁定
//                            me.lock();
                        }
                    } else {
                        layer.msg("加载失败", {icon: 2, shadeClose: true, shade: 0.5, time: 1500});
                        // 即使加载出错，也得重置
                        me.resetload();
                    }
                });
            }
        });
    });


    function areaChange(e) {
        $("#areaShow").html($(e).val());
    }

    /*$("#areaId").select({
     title: "选择职业",
     items: ["内蒙古", "包头市区", "猎人", "学生", "记者", "其他"],
     onChange: function(d) {
     console.log(this, d);
     },
     onClose: function() {
     console.log("close");
     },
     onOpen: function() {
     console.log("open");
     },
     });*/

    $("#areaId").cityPicker({
        title: "选择城市",
        showDistrict: false
    });

    $("#searchBt").click(function () {
        $("#searchForm").submit();
    });

    //返回
    $(".back").click(function () {
        window.history.go(-1);
    });

    function rollLoad() {
        $(".main .container").click(function () {
            $(".main .container").css("background-color", "");
            $(this).css("background-color", "#f5f5f5");

            var _connHis = $(this).data("hosp-connHis");

            if (_connHis == 0) {
                console.log(_connHis);
//			$.toast("即将开放，敬请期待！","text");
                layer.msg("即将开放，敬请期待！");
            } else {
            	$.showLoading();
                var hospitalId = $(this).data("hosp-id");
                console.log(hospitalId);
                //跳转到 选择科室页面
                window.location.href = "/core/appoint/getDeptRegInfo?hospitalId=" + hospitalId + "&connHis=" + _connHis;
            }
        });
    }
    rollLoad();

    /**
     * js截取字符串，中英文都能用
     * @param str：需要截取的字符串
     * @param len: 需要截取的长度
     */
    function cutstr(str, len) {
        var str_length = 0;
        var str_len = 0;
        str_cut = new String();
        str_len = str.length;
        for (var i = 0; i < str_len; i++) {
            a = str.charAt(i);
            str_length++;
            if (escape(a).length > 4) {
                //中文字符的长度经编码之后大于4  
                str_length++;
            }
            str_cut = str_cut.concat(a);
            if (str_length >= len) {
                str_cut = str_cut.concat("...");
                return str_cut;
            }
        }
        //如果给定字符串小于指定长度，则返回源字符串；  
        if (str_length < len) {
            return str;
        }
    }
    
    /**
     * 设置医院可以使用的功能
     * @param id：医院id
     */
    function hospitalFunc(id){
    	var func;
    	switch(id)
    	{
    	case "000001":
    	func = {"appoint":"0","bill":"0","familyDoctor":"0","consult":"0"};
    	break;
    	case "1002":
    	func = {"appoint":"0","bill":"1","familyDoctor":"0","consult":"0"};
    	break;
    	case "1003":
    	func = {"appoint":"0","bill":"1","familyDoctor":"0","consult":"0"};
    	break;
    	default:
    	func = {"appoint":"1","bill":"1","familyDoctor":"1","consult":"1"};
    	}
    	return func;
    }
</script>
</body>
</html>
