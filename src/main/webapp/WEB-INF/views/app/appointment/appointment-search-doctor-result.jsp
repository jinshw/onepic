<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>快速搜医生</title>

    <link rel="stylesheet" href="../static/lib/jquery-weui-app2/lib/weui.css">
    <link rel="stylesheet" href="../static/lib/jquery-weui-app2/css/jquery-weui.css">
    <link rel="stylesheet" href="../static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <%-- <link rel="stylesheet" href="${ctx}/static/lib/layer-v2.3/skin/layer.css"> --%>
    
    <script src="../static/lib/jquery-weui-app2/lib/jquery-2.1.4.js"></script>
	<script src="../static/lib/jquery-weui-app2/js/jquery-weui.js"></script>
	<script src="../static/lib/layer-v2.3/layer.js"></script>
	<script src="../static/js/app/ajaxRequest.js"></script>
   
    <style type="text/css">
        body {
            background-color: #f2f2f2;
            font-family: 微软雅黑;
        }

        .header {
            background-color: #2ed0bb;
            height: 118px;
            width: 100%;
            margin-bottom: 25px;
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


        .header-img {
            height:146px;
            width: 146px;
            border-radius: 50%;
            overflow: hidden;
            position: absolute;
            top:35px;
            border: 3px solid #fff;
            box-shadow: 0 4px 5px #d4d4d4;
        }

        .header-img img {
            height:146px;
            width: 146px;
        }

        .center-content {
            position: absolute;
            left: 188px;
            top: 20px;
        }

        .center-content .title {
            font-size: 30px;
            color: #1a1a1a;
        }

        .center-content .level, .center-content .address {
            font-size: 28px;
            color: #656565;
        }

        .weui_search_bar {
            margin-bottom: 20px;
        }

        .weui_search_bar:before {
            border-top: 0px solid #C7C7C7;
        }

        .opt-bar {
            display: flex;
            position: relative;
            height: 88px;
        }

        .opt-bar .history-bt, .opt-bar .concern-bt {
            width: 250px;
            /*height: 88px;*/
            line-height: 88px;
            font-size: 28px;
            color: #8c8c8c;
            text-align: center;
            position: absolute;
            /*border-bottom: 1px solid #2ed0bb;*/
        }

        .opt-bar .history-bt {
            left: 100px;
            border-bottom: 1px solid #2ed0bb;
            color: #2ed0bb;
        }

        .opt-bar .concern-bt {
            right: 100px;
        }

        /*搜索框样式自定义*/
        .weui_search_text {
            line-height: 80px;
        }

        .weui_search_text span {
            font-size: 28px;
        }

        .weui_icon_search:before {
            font-size: 36px;
        }

        .weui_search_inner .weui_search_input {
            height:80px;
            line-height: 80px;
            font-size: 28px;
        }

        .weui_search_inner {
            padding-left:60px;
            padding-right: 30px;
        }

        .weui_search_inner .weui_icon_search {
            top: 20px;
            left: 10px;
        }

        .weui_icon_clear:before {
            font-size: 28px;
        }

        .weui_search_inner .weui_icon_clear {
            top: 26px;
            right: 0;
            padding: 0 10px;
            line-height: 28px;
        }

        .clear-history {
            font-size: 28px;
            color: #8c8c8c;
            height: 80px;
            width: 100%;
            line-height: 80px;
            text-align: center;
            box-shadow: 0 2px 10px #e0dfdf;
        }

        .container .history-content {
            height: 100px;
            border-bottom: 1px solid #dfdfdf;
            margin-left: 25px;
            margin-right: 25px;
            position: relative;
            line-height:100px;
            font-size: 28px;
            color: #1a1a1a;
        }

        /** 搜索结果样式 **/
        .search-result{
            margin-top:26px;
        }
        .search-result .container {
            box-shadow: 0 2px 10px #e0dfdf;
            margin-bottom: 20px;
        }

        .search-result .content {
            height: 323px;
            border-bottom: 1px solid #dfdfdf;
            margin-left: 25px;
            margin-right: 25px;
            position: relative;
            font-size:36px;
        }

        .search-result .header-img {
            height: 146px;
            width: 146px;
            border-radius: 100px;
            overflow: hidden;
            position: absolute;
            top: 70px;
            border: 3px solid #fff;
            box-shadow: 0 4px 5px #d4d4d4;
        }

        .search-result .center-content {
            font-size: 36px;
        }

        .search-result .label-left {
            color: #656565;
        }

        .search-result .label-content {
        }

        .search-result .follow-star {
            position: absolute;
            right: 0px;
            top: 100px;
            color: #656565;
        }

        .fa-star-o {
            color: #f0af41;
        }

        .fa-star-o, .fa-star {
            color: #f0af41;
        }

        input[type=search]     {
            border-radius: 5px;
            border: 1px solid #ebebeb;
            width: 840px;
            height: 90px;
            outline: none;
        }

        input[type=search]::-webkit-input-placeholder{
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
            width: 20px;
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
            text-indent:56px;
            font-size:36px;
            position: absolute;
            top: 0;
            left: 10px;
            font-family: 微软雅黑;
            text-align: left;
        }

        .span-search {
            position: absolute;
            right:21px;
            top: 14px;
            font-size: 36px;
            color: #2ed0bb;
        }

        .search-icon {
            position: absolute;
            top: 28px;
            left: 40px;
        }

        .form-search {
            text-align: center;
            position: relative;
            height: 90px;
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
		
		/** layer **/
		.layui-layer-msg {
		    min-width: 180px;
		    border: 3px solid #D3D4D3;
		    box-shadow: none;
		}
		.layui-layer {
		    margin: 0;
		    padding: 0;
		    background-color: #fff;
		    -webkit-background-clip: content;
		    border-radius: 9px;
		    animation-fill-mode: both;
		    animation-duration: .3s;
		}
		.layui-layer-dialog .layui-layer-padding {
		    padding: 40px 40px 40px 90px;
		    text-align: left;
		}
		.layui-layer-dialog .layui-layer-content {
		    position: relative;
		    line-height: 31px;
		    word-break: break-all;
		    font-size: 37px;
		    overflow: auto;
		}
		.layui-layer-dialog .layui-layer-content .layui-layer-ico {
		    position: absolute;
		    top: 42px;
		    left: 34px;
		    width: 30px;
		    height: 30px;
		}
    </style>
</head>
<body>
<div class="header">
    <div class="back">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area" data-hospId="${hospitalId }" data-hospName="${hospitalName }">
        <span>快速搜医生</span>
    </div>
</div>
<div id="search_bar" style="margin-top: 15px;">
    <form class="form-search" id="searchForm" action="/core/appointApp/likedoctor">
        <input class="input-search" type="search" name="docName" id="search_input"
               autocomplete="off" value="${docName}" placeholder="输入医生姓名" required>
        <span class="span-search" id="searchBt">搜索</span>
        <div class="search-icon">
            <i class="weui_icon_search"></i>
        </div>
    </form>
</div>

<div class="search-result">
</div>

<div class="weui-infinite-scroll" id="scrollLoading" style="display: none;">
    <div class="infinite-preloader"></div>
    正在加载
</div>
<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";

    var list = ${listJson};
    if (typeof (list.doctorList) != 'undefined' && list.doctorList != "") {
        var doctorList = list.doctorList;
        var docDiv = "",contentHeight=0;
        for (var k = 0; k < doctorList.length; k++) {
            contentHeight = 3;//初始化
            
            var urlPic = '';
			if(doctorList[k].urlPic == '') {
				urlPic = 'static/images/doctor.png';
			} else {
				urlPic = doctorList[k].urlPic;
			}
            
            docDiv = docDiv +
                            '<div class="container" data-index="'+k+'">'+
                            '<div class="content" style="height:'+ contentHeight +'rem" ><div class="header-img">'+
                            '   <img src="${ctx}/'+ urlPic +'" alt="头像"></div>'+
                            ' <div class="center-content">'+
                            '<div class="line-bar">'+
                            '    <span class="label-left">名称：</span>'+
                            '    <span class="label-content">'+doctorList[k].doctorName+'</span>'+
                            '</div>'+
                            '<div class="line-bar">'+
                            '    <span class="label-left">职称：</span>'+
                            '    <span class="label-content">'+doctorList[k].doctorTitle+'</span>'+
                            '</div>'+
                            '<div class="line-bar" style="width:4.1rem;">'+
                            '    <span class="label-left">擅长：</span>'+
                            '    <span class="label-content">'+cutstr(doctorList[k].betterFor,46)+'</span>'+
                            '</div>'+
                            '<div class="line-bar">'+
                            '    <span class="label-left">科室：</span>'+
                            '    <span class="label-content" data-deptId="'+doctorList[k].deptId+'">'+doctorList[k].deptName+'</span>'+
                            '</div>'+
                            '<div class="line-bar">'+
                            '    <span class="label-left">医院：</span>'+
                            '    <span class="label-content">${hospitalName}</span>'+
                            '</div>'+
                            '</div>'+
                            ' <div class="follow-star" data-id="'+doctorList[k].doctorId+'">';
                            

                            if(doctorList[k].follow == '0'){
                                docDiv = docDiv + '<i class="fa fa-star-o fa-lg"></i><span>关注</span>';
                            }else if(doctorList[k].follow == '1'){
                                docDiv = docDiv + '<i class="fa fa-star fa-lg"></i><span>已关注</span>';
                            }

                docDiv = docDiv + "</div></div></div>";
        }
        $(".search-result").html(docDiv);
        containerClick();
    }
    //返回
    $(".back").click(function () {
        console.log("...back....");
        window.history.go(-1);//回退
    });
    //焦点移动到字符串末尾
    $("#search_input").click(function () {
        var t = $("#search_input").val();
        $("#search_input").val("").focus().val(t);
    });
    //按钮搜索
    $("#searchBt").click(function () {
    	var _val = $("#search_input").val().trim();
    	if(_val != '') {
    		$.showLoading();
		    var form = $("#searchForm");
		    var _hospitalId = $(".area").data("hospId");
		    var _hospitalName = $(".area").data("hospName");
		    var hospitalId = $("<input type='text' hidden='hidden' name='hospitalId' />");
		    hospitalId.attr('value', _hospitalId);
		    var hospitalName = $("<input type='text' hidden='hidden' name='hospitalName' />");
		    hospitalName.attr('value', _hospitalName);
		    form.append(hospitalId);
		    form.append(hospitalName);
		    $("#searchForm").submit();
    	} else {
    		layer.msg("请填写医生姓名！", {icon: 0, shadeClose: true, shade: 0.5, time: 1800, area: '450px'});
    	}
    });
    $(document).ready(function () {
        // 搜索事件
        $("#searchForm").submit(function (e) {
            $.showLoading();
            var _val = $("#search_input").val().trim();
            var form = $("#searchForm");
            var _hospitalId = $(".area").data("hospId");
            var _hospitalName = $(".area").data("hospName");
            var hospitalId = $("<input type='text' hidden='hidden' name='hospitalId' />");
            hospitalId.attr('value', _hospitalId);
            var hospitalName = $("<input type='text' hidden='hidden' name='hospitalName' />");
            hospitalName.attr('value', _hospitalName);
            form.append(hospitalId);
            form.append(hospitalName);
        });
        //点击关注
        $(".follow-star").click(function (event) {
            var _txt = $(this).children("span").html().trim();
            var typeId = $(this).data("id");
            var _doctorName = $(this).prev().find(".line-bar:eq(0)").find(".label-content").text();
            var _level = $(this).prev().find(".line-bar:eq(1)").find(".label-content").text();
            var _departName = $(this).prev().find(".line-bar:eq(3)").find(".label-content").text();
            var _hospitalId = $(".area").data("hospId");
            var _hospitalName = $(".area").data("hospName");
            if (_txt == "关注") {
                var that = this;
                ajaxRequest.getAjaxFollow({
                    typeId: typeId,
                    doctorName: _doctorName,
                    level: _level,
                    departName: _departName,
                    hospitalId: _hospitalId,
                    hospitalName: _hospitalName
                }).then(function (resp) {
                    if (resp.state == 200) {
                        var appendStr = '<i class="fa fa-star fa-lg">'
                                + '</i>'
                                + '<span>'
                                + '已关注'
                                + '</span>'
                        $(that).html(appendStr);
                    }
                });
            }
            event.stopPropagation();
        });
        containerClick();
    });
	function containerClick() {
		//点击一行背景颜色改变
        $(".container").click(function () {
        	var that = this;
        	//检查是否登录
			ajaxRequest.checkLogin().then(function (resp) {
				if(resp == '0') {
		            $(".container").css("background-color", "#FFFFFF");
		            $(that).css("background-color", "#f5f5f5");
		
		            // 创建Form
		            var form = $('<form></form>');
		            // 设置属性 跳转医生详情页
		            form.attr('action', "/core/appointApp/getDoctorDetail");
		            form.attr('method', 'post');
		            form.attr('target', '_self');
		
		            var _doctorName = $(that).find(".line-bar:eq(0)").find(".label-content").text();
		            var _deptId = $(that).find(".line-bar:eq(3)").find(".label-content").data("deptId");
		            var _hospitalId = $(".area").data("hospId");
		            var _hospitalName = $(".area").data("hospName");
		
		            var doctorName = $("<input type='text' hidden='hidden' name='doctorName' />");
		            doctorName.attr('value', _doctorName);
		            var deptId = $("<input type='text' hidden='hidden' name='deptId' />");
		            deptId.attr('value', _deptId);
		            var hospitalId = $("<input type='text' hidden='hidden' name='hospitalId' />");
		            hospitalId.attr('value', _hospitalId);
		            var hospitalName = $("<input type='text' hidden='hidden' name='hospitalName' />");
		            hospitalName.attr('value', _hospitalName);
		
		
		            form.append(doctorName);
		            form.append(deptId);
		            form.append(hospitalId);
		            form.append(hospitalName);
		
		            // 提交表单
		            form.submit();
				} else {
					$.confirm("未登录，请先登录！", function() {
				  		//点击确认后的回调函数
				  		console.log("登录-确认");
				  		window.jsobj.Login();
					}, function() {
				  		//点击取消后的回调函数
				  		console.log("登录-取消");
					});
				}
			});
        });
	}
</script>
</body>
</html>