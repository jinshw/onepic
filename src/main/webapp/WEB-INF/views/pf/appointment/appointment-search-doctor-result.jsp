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
    <title>快速搜医生</title>

    <link rel="stylesheet" href="../static/lib/jquery-weui-app/lib/weui.css">
    <link rel="stylesheet" href="../static/lib/jquery-weui-app/css/jquery-weui.css">
    <link rel="stylesheet" href="../static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    
    <script src="../static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
	<script src="../static/lib/jquery-weui-app/js/jquery-weui.js"></script>
	<script src="${ctx}/static/lib/layer-v2.3/layer.js"></script>
	<script src="../static/js/ajaxRequest.js"></script>
    
    <style type="text/css">
        body {
            background-color: #f2f2f2;
            font-family: 微软雅黑;
        }

        .header {
            background-color: #2ed0bb;
            height: 0.88rem;;
            width: 100%;
            margin-bottom: 0.1rem;
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

        .header-img {
            height: 1.1rem;
            width: 1.1rem;
            border-radius: 50%;
            overflow: hidden;
            position: absolute;
            top: 0.35rem;
            border: 3px solid #fff;
            box-shadow: 0 4px 5px #d4d4d4;
        }

        .header-img img {
            height: 1.1rem;
            width: 1.1rem;
        }

        .center-content {
            position: absolute;
            left: 1.45rem;
            top: 0.2rem;
        }

        .center-content .title {
            font-size: 0.3rem;
            color: #1a1a1a;
        }

        .center-content .level, .center-content .address {
            font-size: 0.28rem;
            color: #656565;
        }

        .weui_search_bar {
            margin-bottom: 0.2rem;
        }

        .weui_search_bar:before {
            border-top: 0px solid #C7C7C7;
        }

        .opt-bar {
            display: flex;
            position: relative;
            height: 0.88rem;
        }

        .opt-bar .history-bt, .opt-bar .concern-bt {
            width: 2.5rem;
            /*height: 88px;*/
            line-height: 0.88rem;
            font-size: 0.28rem;
            color: #8c8c8c;
            text-align: center;
            position: absolute;
            /*border-bottom: 1px solid #2ed0bb;*/
        }

        .opt-bar .history-bt {
            left: 1rem;
            border-bottom: 1px solid #2ed0bb;
            color: #2ed0bb;
        }

        .opt-bar .concern-bt {
            right: 1rem;
        }

        /*搜索框样式自定义*/
        .weui_search_text {
            line-height: 0.8rem;
        }

        .weui_search_text span {
            font-size: 0.28rem;
        }

        .weui_icon_search:before {
            font-size: 0.28rem;
        }

        .weui_search_inner .weui_search_input {
            height: 0.8rem;
            line-height: 0.8rem;
            font-size: 0.28rem;
        }

        .weui_search_inner {
            padding-left: 0.6rem;
            padding-right: 0.3rem;
        }

        .weui_search_inner .weui_icon_search {
            top: 0.2rem;
            left: 0.1rem;
        }

        .weui_icon_clear:before {
            font-size: 0.28rem;
        }

        .weui_search_inner .weui_icon_clear {
            top: 0.26rem;
            right: 0;
            padding: 0 10px;
            line-height: 0.28rem;
        }

        .clear-history {
            font-size: 0.28rem;
            color: #8c8c8c;
            height: 0.8rem;
            width: 100%;
            line-height: 0.8rem;
            text-align: center;
            box-shadow: 0 2px 10px #e0dfdf;
        }

        .container .history-content {
            height: 1rem;
            border-bottom: 1px solid #dfdfdf;
            margin-left: 0.25rem;
            margin-right: 0.25rem;
            position: relative;
            line-height: 1rem;
            font-size: 0.28rem;
            color: #1a1a1a;
        }

        /** 搜索结果样式 **/
        .search-result .container {
            box-shadow: 0 2px 10px #e0dfdf;
            margin-bottom: 0.2rem;
        }

        .search-result .content {
            height: 2.5rem;
            border-bottom: 1px solid #dfdfdf;
            margin-left: 0.25rem;
            margin-right: 0.25rem;
            position: relative;
            font-size: 0.28rem;
        }

        .search-result .header-img {
            height: 1.1rem;
            width: 1.1rem;
            border-radius: 0.60rem;
            overflow: hidden;
            position: absolute;
            top: 0.7rem;
            border: 3px solid #fff;
            box-shadow: 0 4px 5px #d4d4d4;
        }

        .search-result .center-content {
            font-size: 0.28rem;
        }

        .search-result .label-left {
            color: #656565;
        }

        .search-result .label-content {
        }

        .search-result .follow-star {
            position: absolute;
            right: 0px;
            top: 1rem;
            color: #656565;
        }

        .fa-star-o {
            color: #f0af41;
        }

        .fa-star-o, .fa-star {
            color: #f0af41;
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
<%--<div class="weui_search_bar" id="search_bar">--%>
    <%--<form class="weui_search_outer" id="searchForm" action="likedoctor">--%>
        <%--<div class="weui_search_inner">--%>
            <%--<i class="weui_icon_search"></i>--%>
            <%--<input name="docName" type="search" class="weui_search_input" id="search_input" placeholder="输入医生姓名"--%>
                   <%--required--%>
                   <%--value="${docName}" autocomplete="off"/>--%>
            <%--<a href="javascript:" class="weui_icon_clear" id="search_clear"></a>--%>
        <%--</div>--%>
        <%--<label for="search_input" class="weui_search_text" id="search_text">--%>
            <%--<i class="weui_icon_search"></i>--%>
            <%--<span>输入医生姓名</span>--%>
        <%--</label>--%>
    <%--</form>--%>
    <%--<a href="javascript:" class="weui_search_cancel" id="search_cancel" style="font-size: 0.28rem;--%>
        <%--text-align: center;--%>
        <%--line-height: 0.88rem;--%>
        <%--display: block;--%>
        <%--width: 0.7rem;--%>
        <%--height: 0.88rem;--%>
        <%--margin: 0 auto;">取消</a>--%>
<%--</div>--%>

<div id="search_bar" style="margin-top: 15px;">
    <form class="form-search" id="searchForm" action="likedoctor">
        <input class="input-search" type="search" name="docName" id="search_input"
               autocomplete="off" value="${docName}" placeholder="输入医生姓名" required>
        <span class="span-search" id="searchBt">搜索</span>
        <div class="search-icon">
            <i class="weui_icon_search"></i>
        </div>
    </form>
</div>


<div class="search-result">
   <%-- <c:forEach items="${list}" var="doc" varStatus="status">
        <div class="container" data-index="${status.index}">  &lt;%&ndash; data-doctor="${status.current }" &ndash;%&gt;
            <div class="content">
                <div class="header-img">
                    <img src="${ctx}/static/images/doctor.png" alt="头像">
                </div>
                <div class="center-content">
                    <div class="line-bar">
                        <span class="label-left">名称：</span>
                        <span class="label-content">${doc.doctorName}</span>
                    </div>
                    <div class="line-bar">
                        <span class="label-left">职称：</span>
                        <span class="label-content">${doc.doctorTitle}</span>
                    </div>
                    <div class="line-bar">
                        <span class="label-left">擅长：</span>
                        <span class="label-content">${doc.betterFor}</span>
                    </div>
                    <div class="line-bar">
                        <span class="label-left">科室：</span>
                        <span class="label-content" data-deptId="${doc.deptId }">${doc.deptName}</span>
                    </div>
                    <div class="line-bar">
                        <span class="label-left">医院：</span>
                        <span class="label-content">${hospitalName}</span>
                    </div>
                </div>
                <div class="follow-star" data-id="${doc.doctorId}">
                    <c:if test="${doc.follow == '0'}">
                        <i class="fa fa-star-o fa-lg"></i>
                        <span>关注</span>
                    </c:if>
                    <c:if test="${doc.follow == '1'}">
                        <i class="fa fa-star fa-lg"></i>
                        <span>已关注</span>
                    </c:if>
                </div>
            </div>
        </div>
    </c:forEach>--%>
</div>


<div class="weui-infinite-scroll" id="scrollLoading" style="display: none;">
    <div class="infinite-preloader"></div>
    正在加载
</div>

<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";

    /*  var array = new Array();
    <c:forEach items="${list}" var="doctor"> 
     array.push(${doctor}); //js中可以使用此标签，将EL表达式中的值push到数组中
    </c:forEach>
     for(var i=0;i<array.length;i++) {
     console.log(array[i]);
     } */

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

        /* var _hospitalId = $(".area").data("hospId");
         var _hospitalName = $(".area").data("hospName");

         window.location.href = "getSearchHistory?hospitalId="+_hospitalId+"&hospitalName="+_hospitalName; */
        window.history.go(-1);//回退
    });

    //焦点移动到字符串末尾
    $("#search_input").click(function () {
        var t = $("#search_input").val();
        $("#search_input").val("").focus().val(t);
    });

    $("#searchBt").click(function () {
        var _val = $("#search_input").val().trim();
        if(_val != '') {
	        $.showLoading();
	        var form = $("#searchForm");
	        var _hospitalId = $(".area").data("hospId");
	        var _hospitalName = $(".area").data("hospName");
	        var hospitalId = $("<input type='text' hidden=\"hidden\" name='hospitalId' />");
	        hospitalId.attr('value', _hospitalId);
	        var hospitalName = $("<input type='text' hidden=\"hidden\" name='hospitalName' />");
	        hospitalName.attr('value', _hospitalName);
	        form.append(hospitalId);
	        form.append(hospitalName);
	        console.log(_val);
	        $("#searchForm").submit();
	    } else {
    		layer.msg("请填写医生姓名！", {icon: 0, shadeClose: true, shade: 0.5, time: 1800});
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
        /**
         * 滚动加载
         * @type {boolean}
         */
        /* var loading = false;
         $(document.body).infinite().on("infinite", function () {
         $("#scrollLoading").css('display', "block");
         if (loading) return;
         loading = true;
         setTimeout(function() {
         var docName=$('#search_input').val();
         ajaxRequest.getAjaxLikeDocName({docName:docName}).then(function (resp) {
         if (resp.state == 200) {
         var appendStr="";
         for (var j = 0; j < resp.list.length; j++) {
         var appendStr = appendStr
         +'<div class="container">'
         +'<div class="content">'
         +'<div class="header-img">'
         +'<img src="../static/images/header-test.png" alt="头像">'
         +'</div>'
         +'<div class="center-content">'
         +'<div class="line-bar">'
         +'<span class="label-left">名称：</span>'
         +'<span class="label-content">'+resp.list[j].doctorName
         +'</span>'
         +'</div>'
         +'<div class="line-bar">'
         +'<span class="label-left">职称：</span>'
         +'<span class="label-content">'+resp.list[j].doctorTitle
         +'</span>'
         +'</div>'
         +'<div class="line-bar">'
         +'<span class="label-left">擅长：</span>'
         +'<span class="label-content">'+resp.list[j].betterFor
         +'</span>'
         +'</div>'
         +'<div class="line-bar">'
         +'<span class="label-left">科室：</span>'
         +'<span class="label-content">'+resp.list[j].deptName
         +'</span>'
         +'</div>'
         +'<div class="line-bar">'
         +'<span class="label-left">医院：</span>'
         +'<span class="label-content">'+
        ${hospitalName}
         +'</span>'
         +'</div>'
         +'</div>'
         +'<div class="follow-star" data-id="'+ resp.list[j].id +'">';
         if(resp.list[j].flag == 1){
         appendStr = appendStr
         +'<i class="fa fa-star fa-lg"></i>'
         +'<span>已关注</span>'
         }
         if(resp.list[j].flag == 0){
         appendStr= appendStr
         +'<i class="fa fa-star-o fa-lg"></i>'
         +'<span>关注</span>'
         }
         +' </div>'
         +' </div>'
         +' </div>'
         }
         $(".search-result").append(appendStr);
         loading = false;
         $("#scrollLoading").css('display', "none");
         }
         });}, 2000);
         });*/
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
	            form.attr('action', "/core/appoint/getDoctorDetail");
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
				  		window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx11f1b9aae05f3bd2&redirect_uri=http://www.yunju360.com/juser/wx/redirect&response_type=code&scope=snsapi_base&state=mycenter#wechat_redirect";
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