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
<div class="weui_search_bar" id="search_bar">
    <form class="weui_search_outer" id="searchForm" action="/core/appointApp/likedoctor">
        <div class="weui_search_inner">
            <i class="weui_icon_search"></i>
            <input name="docName" type="search" class="weui_search_input" id="search_input" placeholder="输入医生姓名" required
                   autocomplete="off"/>
            <a href="javascript:" class="weui_icon_clear" id="search_clear"></a>
        </div>
        <label for="search_input" class="weui_search_text" id="search_text">
            <i class="weui_icon_search"></i>
            <span>输入医生姓名</span>
        </label>
    </form>
    <a href="javascript:" class="weui_search_cancel" id="search_cancel" style="font-size: 0.28rem;
        text-align: center;
        line-height: 0.88rem;
        display: block;
        width: 0.7rem;
        height: 0.88rem;
        margin: 0 auto;">取消</a>
</div>

<div class="main" id="main">
    <div class="opt-bar">
        <div class="history-bt" data-show-ids="" data-hidd-ids="">历史</div>
        <div class="concern-bt">关注</div>
    </div>
    <div class="history-list"  data-flag="0">
    <c:forEach items="${shList}" var="sh">
        <div class="container">
            <div class="history-content">
            ${sh.content}
            </div>
        </div>
        </c:forEach>
        <div class="clear-history">
            清空搜索历史
            <i class="fa fa-remove fa-lg" id="removehistory"></i>
        </div>
    </div>
    <div class="concern-list" style="display: none;" data-flag="1">
        <%-- <div class="container">
            <div class="content">
                <div class="header-img">
                    <img src="${ctx}/static/images/doctor.png" alt="头像">
                </div>
                <div class="center-content">
                    <div class="title">
                        张帅
                    </div>
                    <div class="level">
                        <span>主任医师</span>
                        <span>普外科</span>
                    </div>
                    <div class="address">
                        <span>内蒙古包头市中心医院</span>
                    </div>
                </div>
            </div>
        </div> --%>
    </div>
</div>

<script src="../static/lib/jquery-weui-app2/lib/jquery-2.1.4.js"></script>
<script src="../static/lib/jquery-weui-app2/js/jquery-weui.js"></script>
<script src="../static/js/app/ajaxRequest.js"></script>
<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    
    //返回
    $(".back").click(function () {
        console.log("...back....");
        window.history.go(-1);//回退
    });

    $(document).ready(function () {
       	$(".history-bt").click(function () {
	    	$(".history-list").css("display", "block");
	        $(".concern-list").css("display", "none");
	        $(this).css("border-bottom", "1px solid #2ed0bb");
	        $(".concern-bt").css("border-bottom", "0px solid #2ed0bb");
	        ajaxRequest.getAjaxSeachHistory().then(function (resp) {
	          if(resp.state==200){
	          var appendStr = "";
	             for(var i=0;i<resp.list.length;i++){
		          appendStr = appendStr + ' <div class="container">'
		          +'<div class="history-content">'
		          +resp.list[i].content+'</div>'
		          +'</div>';
	          	 }
		         $(".history-list").children(".container").remove();
		         $(".clear-history").before(appendStr);
		         containerClick();
	           }
	        });
        });
        $(".concern-bt").click(function () {
            $(".concern-list").css("display", "block");
            $(".history-list").css("display", "none");
            $(this).css("border-bottom", "1px solid #2ed0bb");
            $(".history-bt").css("border-bottom", "0px solid #2ed0bb");
            var _hospitalId = $(".area").data("hospId");
            ajaxRequest.getAjaxAttention({hospitalId: _hospitalId}).then(function(resp) {
             if(resp.state==200){
             var appendStr="";
               for(var i=0;i<resp.list.length;i++){
                  appendStr=appendStr
			           +'<div class="container">'
			           +'	<div class="content">'
			           +'		<div class="header-img">'
			           +'			<img src="${ctx}/static/images/doctor.png" alt="头像">'
			           +'		</div>'
			           +'		<div class="center-content">'
			           +'			<div class="title">'+resp.list[i].docName+'</div>'
			           +'			<div class="level">'
                       +'				<span>'+resp.list[i].docTitle+'</span>'+'&nbsp&nbsp&nbsp&nbsp'
                       +'				<span>'+resp.list[i].departName+'</span>'
                       +'			</div>'
                       +'			<div class="address">'
                       +'				<span>'+resp.list[i].hospName+'</span>'
                       +'			</div>'
                       +'		</div>'
                       +'	</div>'
                       +'</div>';
                  }
                  $(".concern-list").html(appendStr);
                  containerClick();
              }	
            });
        });
        // 搜索事件
       	$("#searchForm").submit(function (e) {
           $.showLoading();
           var _val = $("#search_input").val().trim();
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
        });
        containerClick();
    });
    
    function containerClick() {
    	//检查是否登录
		ajaxRequest.checkLogin().then(function (resp) {
			if(resp == '0') {
				//点击一行背景颜色改变
		        $(".container").click(function () {
		        	var _parent = $(this).parent().data("flag");
		        	if(_parent == 0) {
			            var _val = $(this).text().trim();
			            console.log("val==" + _val);
		        	} else if(_parent == 1){
		        		var _val = $(this).find(".title").text().trim();
		        		console.log("val==" + _val);
		        	}
		        	$(".container").css("background-color", "#FFFFFF");
			        $(this).css("background-color", "#f5f5f5");
		            $("#search_input").val(_val);
			        // form 提交
			        $("#searchForm").trigger("submit");
		        });
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
    }
    // 清除历史记录
    $("#removehistory").click(function () {
      ajaxRequest.getAjaxDelete().then(function (resp) {
          if(resp.state==200){
             $(".container").html("");
          }
	  });
    });
</script>
</body>
</html>