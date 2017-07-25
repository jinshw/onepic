<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>预约挂号</title>
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app2/lib/weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app2/css/jquery-weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/lib/dropload/dropload.css">
    <link rel="stylesheet" href="${ctx}/static/css/app/appointment.css">
    
    <script src="${ctx}/static/lib/jquery-weui-app2/lib/jquery-2.1.4.js"></script>
	<script src="${ctx}/static/lib/dropload/dropload.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app2/js/jquery-weui.js"></script>
    <script src="${ctx}/static/lib/layer-v2.3/layer.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app2/js/city-picker.js"></script>
    <script src="${ctx}/static/js/app/ajaxRequest.js"></script>
    <script src="${ctx}/static/js/app/common-app.js"></script>
    
    <style type="text/css">
        input[type=search] {
            border-radius: 5px;
            border: 1px solid #ebebeb;
            width: 832px;
            height: 90px;
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
            height: 20px;
            width: 020px;
            border-radius: 50%;
            background-color: #EBEBEB;
        }

        input[type=search]::-webkit-search-cancel-button:after {
            position: absolute;
            content: 'x';
            left: 25%;
            top: -12%;
            font-size: 20px;
            color: #fff;
        }

        .input-search {
            margin: 0 0 10px 0;
            text-indent: 56px;
            font-size: 36px;
            position: absolute;
            top: 0;
            left: 10px;
            font-family: 微软雅黑;
            text-align: left;
        }

        .span-search {
            position: absolute;
            right: 26px;
            top: 12px;
            font-size: 36px;
            color: #2ed0bb;
        }

        .search-icon {
            position: absolute;
            top: 24px;
            left: 20px;
        }

        .form-search {
            text-align: center;
            position: relative;
            height: 120px;
        }
        .dropload-refresh, .dropload-update, .dropload-load, .dropload-noData {
            height: 50px;
            line-height: 50px;
            text-align: center;
            font-size: 30px;
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
		
		/** layer **/
		.layui-layer-hui .layui-layer-content {
		    padding: 41px 20px;
		    text-align: center;
		}
		.layui-layer-dialog .layui-layer-content {
		    position: relative;
		    line-height: 31px;
		    word-break: break-all;
		    font-size: 37px;
		    overflow: auto;
		}
		.layui-layer {
			border-radius: 9px;
		}
		.content {
        	height: 2.2rem;
        }
		.func {
        	-moz-border-radius: 15px;
        	-webkit-border-radius: 12px;
        	borde-radius: 7px;
        	padding: 3px 6px 0px 6px;
        	font-size: 0.22rem;
        	margin: 0 0.08rem 0 0;
        }
		.header-img {
			top: 0.5rem;
		}
		.center-content {
			top: 16px;
		}
    </style>
    <script>
        var _cssText = document.querySelector("html").style.cssText;
        document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    </script>
</head>
<body>
<div class="header">
    <div class="back" style="z-index: 1000;">
        <i class="fa fa-angle-left" style="font-size: 60px;"></i>
    </div>
    <div class="area">
        <!--<input class="weui_input" id="areaId" type="text" value="" style="height: 0.50rem;
            text-align: right;
            position: absolute;
            top: 0.18rem;
            left: 0.80rem;
            width: 5.55rem;
            color: #2ed0bb;" onchange="areaChange(this)">-->
        <!-- <input class="weui_input" id="areaId" type="text" value="" style="height: 72px;
                text-align: right;
                position: absolute;
                top: 25px;
                left: 115px;
                width: 799px;
                opacity: 0;
                font-size: 46px;
                color: #2ed0bb;" onchange="areaChange(this)"> -->
        <span id="areaShow">医院列表</span>
        <!-- <i class="fa fa-angle-down fa-lg"></i> -->
    </div>
    <!-- <div class="search">
         <i class="fa fa-search" style="font-size: 0.4rem;"></i>
     </div>-->
</div>
<!--
<div class="weui_search_bar" id="search_bar">
    <form class="weui_search_outer" id="searchForm" action="initHospList">
        <div class="weui_search_inner">
            <i class="weui_icon_search"></i>
            <input type="search" class="weui_search_input" id="search_input" placeholder="输入医院名称快速定位" required
                   autocomplete="off"  name="hospitalName"  value="${hospitalName}"/>
            <a href="javascript:" class="weui_icon_clear" id="search_clear"></a>
        </div>
        <label for="search_input" class="weui_search_text" id="search_text">
            <i class="weui_icon_search"></i>
            <span>输入医院名称快速定位</span>
        </label>
    </form>
    <a href="javascript:" class="weui_search_cancel" id="search_cancel" style="font-size: 40px;
        text-align: center;
        line-height: 126px;
        display: block;
        width: 101px;
        height: 127px;
        margin: 0 auto;">取消</a>
</div>-->
<div id="search_bar">
    <form class="form-search" id="searchForm" action="/core/appointApp/initHospList">
        <input class="input-search" type="search" placeholder="输入医院名称快速定位" name="hospitalName" id="search_input" autocomplete="off" value="${hospitalName}">
        <span class="span-search" id="searchBt">搜索</span>
        <div class="search-icon">
            <i class="weui_icon_search"></i>
        </div>
    </form>
</div>

<div id="droploadId">
    <div class="main" id="main">
        <%-- <c:forEach items="${list }" var="hosp">
        	<c:if test="${hosp.hospitalId != '1017'}">
        		<div class="container" data-hosp-id="${hosp.hospitalId }" data-hosp-connHis="${hosp.connHis }">
	                <div class="content">
	                    <div class="header-img">
	                        <img src="${ctx}/${hosp.logoImg}" alt="头像">
	                    </div>
	                    <div class="center-content">
	                        <div class="title">
	                        	<c:choose>
	                                <c:when test="${fn:length(hosp.hospitalName) > 14 }">
	                                    ${fn:substring(hosp.hospitalName,0,14)}...
	                                </c:when>
	                                <c:otherwise>
	                                    ${hosp.hospitalName }
	                                </c:otherwise>
	                            </c:choose>
	                        </div>
	                        <div class="level">
	                            <span>等级：</span> ${hosp.hospGrade}
	                        </div>
	                        <div class="address">
	                            <span>地址：</span>
	                            <c:choose>
	                                <c:when test="${fn:length(hosp.hospAddress) > 12 }">
	                                 	${fn:substring(hosp.hospAddress,0,12)}...
	                                </c:when>
	                                <c:otherwise>
	                                	${hosp.hospAddress }
	                                </c:otherwise>
	                            </c:choose>
	                        </div>
	                    </div>
	                </div>
	            </div>
        	</c:if>
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
						'			<div class="title">' + cutstr(hospi.hospitalName, 28) + '</div>		' +
						'			<div class="level">                                     ' +
						'				<span>等级：</span>' + hospi.hospGrade +
						'			</div>                                                  ' +
						'			<div class="address">                                   ' +
						'				<span>地址：</span>' + cutstr(hospi.hospAddress, 24) +
						'			</div>                                                  ' +
						'			<div style="margin-top:10px">							';
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
                                    '	<div class="content">                                           ' +
                                    '		<div class="header-img">                                    ' +
                                    '			<img src="${ctx}/' + resp.list[j].logoImg + '" alt="头像"> ' +
                                    '		</div>                                                      ' +
                                    '		<div class="center-content">                                ' +
                                    '			<div class="title">' + cutstr(resp.list[j].hospitalName, 28) +
                                    '			</div>                                                  ' +
                                    '			<div class="level">                                     ' +
                                    '				<span>等级：</span> ' + resp.list[j].hospGrade +
                                    '			</div>                                                  ' +
                                    '			<div class="address">                                   ' +
                                    '				<span>地址：</span> ' + cutstr(resp.list[j].hospAddress, 24) +
                                    '			</div>                                                  ' +
									'			<div style="margin-top:10px">							';
									  if(func.appoint == 0 || resp.list[j].connHis == 2) {
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


    /* function areaChange(e) {
        $("#areaShow").html($(e).val());
    } */

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
    	window.jsobj.back(4);
    });
	
    function rollLoad() {
        $(".main .container").click(function () {
            $(".main .container").css("background-color", "");
            $(this).css("background-color", "#f5f5f5");

            var _connHis = $(this).data("hosp-connHis");

            if (_connHis == 0) {
                console.log(_connHis);
//			$.toast("即将开放，敬请期待！","text");
                layer.msg("即将开放，敬请期待！", {shadeClose: true, time: 1800, area: '480px'});
            } else {
            	$.showLoading();
                var hospitalId = $(this).data("hosp-id");
                console.log(hospitalId);
                //跳转到 选择科室页面
                window.location.href = "/core/appointApp/getDeptRegInfo?hospitalId=" + hospitalId + "&connHis=" + _connHis;
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
