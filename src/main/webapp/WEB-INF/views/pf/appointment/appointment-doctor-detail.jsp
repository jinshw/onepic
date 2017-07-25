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
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>医生号源页面</title>

    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/lib/weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-weui-app/css/jquery-weui.css">
    <link rel="stylesheet" href="${ctx}/static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
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

        /**号源区域样式**/
        .number-list {
            background-color: #FFFFFF;
        }

        .number-list .number-line-bar {
            height: 1rem;
            width: 100%;
            border-top: 1px solid #dfdfdf;
            font-size: 0.28rem;
            color: #656565;
            text-align: center;
            line-height: 1rem;
        }

        .number-list .number-line-bar span {
            /*margin: 0 0.32rem;*/
        }

        .num-count a, .number-surplus a {
            color: #2ed0bb;
        }

        .number-line-bar .num-date {
            position: absolute;
            left: 0.25rem;
        }

        .number-line-bar .num-week {
            position: absolute;
            left: 3rem;
        }

        .number-line-bar .num-halfday {
            position: absolute;
            right: 2.25rem;
        }

        .number-line-bar .num-count {
            position: absolute;
            left: 6rem;
        }

        .number-list .number-line-second {
            height: 0.8rem;
            width: 100%;
            border-top: 1px solid #dfdfdf;
            font-size: 0.28rem;
            color: #656565;
            text-align: center;
            line-height: 0.8rem;
            position: relative;
        }

        .number-line-second .number-time {
            position: absolute;
            left: 0.6rem;
        }

        .number-line-second .number-surplus {
            position: absolute;
            left: 5rem;
        }

        .number-line-second .fa-angle-right {
            position: absolute;
            right: 0.25rem;
            top: 0.26rem;
        }
        .number-day {
            display: none;
        }
        
        .fa-star-o, .fa-star {
    		color: #f0af41;
		}
    </style>
</head>
<body>
<div class="header">
    <div class="back">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area">
        <span id="titleName">${doctor.doctorName}</span>
    </div>
</div>
<c:if test="${doctor != null}" var="doc">
<div class="search-result">
    <div class="container">
    	<div class="content">
            <div class="header-img">
            	<c:choose>
            		<c:when test="${doctor.urlPic == '' || doctor.urlPic == null}">
            			<img src="${ctx}/static/images/doctor.png" alt="头像">
            		</c:when>
            		<c:otherwise>
            			<img src="${ctx}/${doctor.urlPic}" alt="头像">
            		</c:otherwise>
            	</c:choose>
            </div>
            <div class="center-content">
                <div class="line-bar">
                	<span class="label-left">名称：</span>
                    <span class="label-content" data-docId="${doctor.doctorId }">${doctor.doctorName}</span>
                </div>
                <div class="line-bar">
                    <span class="label-left">职称：</span>
                    <span class="label-content">${doctor.doctorTitle}</span>
                </div>
                <div class="line-bar" style="width:4.15rem">
                	<span class="label-left">特长：</span>
                    <span class="label-content">${fn:substring(doctor.betterFor,0,10)}...</span>
                </div>
                <div class="line-bar">
                    <span class="label-left">医院：</span>
                    <span class="label-content" data-hospId="${hospitalId }">${hospitalName}</span>
                </div>
                <div class="line-bar">
                    <span class="label-left">科室：</span>
                    <span class="label-content" data-deptId="${doctor.deptId }">${doctor.deptName}</span>
                </div>

            </div>
            <div class="follow-star" data-id="${doctor.doctorId}">
            <c:if test="${doctor.follow == '0'}">
                <i class="fa fa-star-o fa-lg"></i>
                <span>关注</span>
             </c:if>
             <c:if test="${doctor.follow == '1'}" >
	             <i class="fa fa-star fa-lg"></i>
	             <span>已关注</span>
             </c:if>
            </div>
    	</div>
    </div>
</div>
<c:forEach items="${doctor.regScheduleInfoBeanList}" var="regSchedule" varStatus="status">
<c:choose>
	<c:when test="${regSchedule.scheduleType == '全天'}">
	<c:choose>
		<c:when test="${fn:length(regSchedule.subList) != 0}">
			<div class="number-list">
			    <div class="number-line">
		        	<div class="number-line-bar">
			            <span class="num-date">${regSchedule.regDate }</span>
			            <span class="num-week">${regSchedule.regWeekDay }</span>
			            <span class="num-halfday">${regSchedule.scheduleType }</span>
			            <span class="num-count">
			            <c:set var="Count" scope="session" value="${0}"/>
			            <c:set var="nowTime"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /></c:set>
                        <c:forEach items="${regSchedule.subList}" var="count">
                        	<fmt:parseDate value="${count.regDate} ${fn:split(count.timeStr, '-')[1]}" var="dateC" pattern="yyyy-MM-dd HH:mm"/>
                        	<c:set var="subTimeC"><fmt:formatDate value="${dateC}" pattern="yyyy-MM-dd HH:mm:ss" /></c:set>
                        	<c:if test="${nowTime < subTimeC}">
                            	<c:set var="Count" scope="session" value="${Count + count.regleaveCount}"/>
                            </c:if>
                        </c:forEach>
			                余号：<a><c:out value="${Count}"/></a>
			            </span>
			        </div>
			        
			        <c:forEach items="${regSchedule.subList}" var="subList" varStatus="status">
			        	<fmt:parseDate value="${subList.regDate} ${fn:split(subList.timeStr, '-')[1]}" var="date" pattern="yyyy-MM-dd HH:mm"/>
						<c:set var="subTime"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss" /></c:set>
						<c:if test="${nowTime < subTime}">
							<div class="number-day" data-regFee="${subList.regFee }" data-treatFee="${subList.treatFee }">
					            <div class="number-line-second" data-scheduleNo="${subList.scheduleNo }">
					                <span class="number-time">${subList.timeStr }</span>
					                <span class="number-surplus">剩余号源：<a>${subList.regleaveCount }</a></span>
					                <i class="fa fa-angle-right"></i>
					            </div>
					        </div>
						</c:if>
			        </c:forEach>
			    </div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="number-list">
			    <div class="number-line">
		        	<div class="number-line-bar">
			            <span class="num-date">${regSchedule.regDate }</span>
			            <span class="num-week">${regSchedule.regWeekDay }</span>
			            <span class="num-halfday">上午</span>
			            <span class="num-count">
			                余号：<a>${regSchedule.regleaveCount }</a>
			            </span>
			        </div>
			        <div class="number-day" data-regFee="${regSchedule.regFee }" data-treatFee="${regSchedule.treatFee }">
			            <div class="number-line-second" data-scheduleNo="${regSchedule.scheduleNo }">
			                <span class="number-time">8:30-11:30</span>
			                <span class="number-surplus">剩余号源：<a>${regSchedule.regleaveCount }</a></span>
			                <i class="fa fa-angle-right"></i>
			            </div>
			        </div>
			    </div>
			</div>
			<div class="number-list">
			    <div class="number-line">
			        <div class="number-line-bar">
			            <span class="num-date">${regSchedule.regDate }</span>
			            <span class="num-week">${regSchedule.regWeekDay }</span>
			            <span class="num-halfday">下午</span>
			            <span class="num-count">
			                余号：<a>${regSchedule.regleaveCount }</a>
			            </span>
			        </div>
			        <div class="number-day" data-regFee="${regSchedule.regFee }" data-treatFee="${regSchedule.treatFee }">
			            <div class="number-line-second" data-scheduleNo="${regSchedule.scheduleNo }">
			                <span class="number-time">14:30-17:30</span>
			                <span class="number-surplus">剩余号源：<a>${regSchedule.regleaveCount }</a></span>
			                <i class="fa fa-angle-right"></i>
			            </div>
			        </div>
			    </div>
			</div>
		</c:otherwise>
	</c:choose>
	</c:when>
	<c:otherwise>
		<div class="number-list">
		    <div class="number-line">
		    <c:choose>
		    	<c:when test="${fn:length(regSchedule.subList) != 0}">
			        <div class="number-line-bar">
			            <span class="num-date">${regSchedule.regDate }</span>
			            <span class="num-week">${regSchedule.regWeekDay }</span>
			            <span class="num-halfday">${regSchedule.scheduleType }</span>
			            <span class="num-count">
			            <c:set var="Count" scope="session" value="${0}"/>
			            <c:set var="nowTime"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /></c:set>
			            <c:forEach items="${regSchedule.subList}" var="count">
			            	<fmt:parseDate value="${count.regDate} ${fn:split(count.timeStr, '-')[1]}" var="dateC" pattern="yyyy-MM-dd HH:mm"/>
			            	<c:set var="subTimeC"><fmt:formatDate value="${dateC}" pattern="yyyy-MM-dd HH:mm:ss" /></c:set>
			            	<c:if test="${nowTime < subTimeC}">
			            		<c:set var="Count" scope="session" value="${Count + count.regleaveCount}"/>
			            	</c:if>
			            </c:forEach>
			                余号：<a><c:out value="${Count}"/></a>
			            </span>
			        </div>
			        
			        <c:forEach items="${regSchedule.subList}" var="subList" varStatus="status">
			        	<fmt:parseDate value="${subList.regDate} ${fn:split(subList.timeStr, '-')[1]}" var="date" pattern="yyyy-MM-dd HH:mm"/>
			        	<c:set var="subTime"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss" /></c:set>
			        	<c:if test="${nowTime < subTime}">
					        <div class="number-day" data-regFee="${subList.regFee }" data-treatFee="${subList.treatFee }">
					            <div class="number-line-second" data-scheduleNo="${subList.scheduleNo }">
					                <span class="number-time">${subList.timeStr }</span>
					                <span class="number-surplus">剩余号源：<a>${subList.regleaveCount }</a></span>
					                <i class="fa fa-angle-right"></i>
					            </div>
					        </div>
				        </c:if>
			        </c:forEach>
			        </c:when>
		        <c:otherwise>
		        	<div class="number-line-bar">
			            <span class="num-date">${regSchedule.regDate }</span>
			            <span class="num-week">${regSchedule.regWeekDay }</span>
			            <c:if test="${regSchedule.scheduleType != 'A' && regSchedule.scheduleType != 'P'}">
			            <span class="num-halfday">${regSchedule.scheduleType }</span>
			            </c:if>
			            <c:if test="${regSchedule.scheduleType == 'A'}">
			            <span class="num-halfday">上午</span>
			            </c:if>
			            <c:if test="${regSchedule.scheduleType == 'P'}">
			            <span class="num-halfday">下午</span>
			            </c:if>
			            <span class="num-count">
			                余号：<a>${regSchedule.regleaveCount }</a>
			            </span>
			        </div>
			        <div class="number-day" data-regFee="${regSchedule.regFee }" data-treatFee="${regSchedule.treatFee }">
			            <div class="number-line-second" data-scheduleNo="${regSchedule.scheduleNo }">
			            	<c:if test="${regSchedule.scheduleType == '上午' || regSchedule.scheduleType == 'A'}" var="res">
			                <span class="number-time">8:30-11:30</span>
			                </c:if>
			                <c:if test="${regSchedule.scheduleType == '下午' || regSchedule.scheduleType == 'P'}" var="res">
			                <span class="number-time">14:30-17:30</span>
			                </c:if>
			                <span class="number-surplus">剩余号源：<a>${regSchedule.regleaveCount }</a></span>
			                <i class="fa fa-angle-right"></i>
			            </div>
			        </div>
		        </c:otherwise>
		    </c:choose>
		    </div>
		</div>
	</c:otherwise>
</c:choose>
</c:forEach>
</c:if>
<script src="${ctx}/static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/jquery-weui.js"></script>
<script src="${ctx}/static/js/ajaxRequest.js"></script>
<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    //返回
    $(".back").click(function () {
        window.history.go(-1);//回退
    });

    $(document).ready(function () {
        //点击一行背景颜色改变
        $(".number-line-second").click(function () {
        	var that = this;
        	//检查是否登录
			ajaxRequest.checkLogin().then(function (resp) {
				if(resp == '0') {
            		$(".number-line-second").css("background-color", "#FFFFFF");
		            $(that).css("background-color", "#f5f5f5");
		            var _hospitalId = $(".label-content:eq(3)").data("hospId");
					var _hospitalName = $(".label-content:eq(3)").text();
					var _deptId = $(".label-content:eq(4)").data("deptId");
					var _deptName = $(".label-content:eq(4)").text();
					var _doctorId = $(".label-content:eq(0)").data("docId");
					var _doctorName = $(".label-content:eq(0)").text();
					var _doctorTile = $(".label-content:eq(1)").text();
			        var _regDate = $(that).parent().prevAll().find(".num-date").text();
			        var _visitTime = $(that).find(".number-time").text();
			        var _regFee = $(that).parent().data("regFee");
			        var _treatFee = $(that).parent().data("treatFee");
			        var _Free = parseInt(_regFee)+parseInt(_treatFee);
			        var _scheduleFlag = $(that).parent().prevAll().find(".num-halfday").text();
			        var _scheduleNo = $(that).data("scheduleNo");
			        
			        // 创建Form
			        var form = $('<form></form>');
			        // 设置属性
			        form.attr('action', "initDetermine");
			        form.attr('method', 'post');
			        // form的target属性决定form在哪个页面提交
			        // _self -> 当前页面 _blank -> 新页面
			        form.attr('target', '_self');
			        // 创建Input
			        var hospitalIdInput = $("<input type='text' name='hospId'>");
			        var hospitalNameInput = $("<input type='text' name='hospName'>");
			        var deptIdInput = $("<input type='text' name='departId'>");
			        var deptNameInput = $("<input type='text' name='departName'>");
			        var doctorIdInput = $("<input type='text' name='doctorId'>");
			        var doctorNameInput = $("<input type='text' name='doctorName'>");
			        var doctorTileInput = $("<input type='text' name='doctorTile'>");
			        var regFeeInput = $("<input type='text' name='regFee'>");
			        var treatFeeInput = $("<input type='text' name='treatFee'>");
			        var scheduleFlagInput = $("<input type='text' name='scheduleFlag'>");
			        var scheduleNoInput = $("<input type='text' name='scheduleNo'>");
			        var regDateInput = $("<input type='text' name='regDate'>");
			        var visitTimeInput = $("<input type='text' name='visitTime'>");
			        hospitalIdInput.attr('value', _hospitalId);
			        hospitalNameInput.attr('value', _hospitalName);
			        deptIdInput.attr('value', _deptId);
			        deptNameInput.attr('value', _deptName);
			        doctorIdInput.attr('value', _doctorId);
			        doctorNameInput.attr('value', _doctorName);
			        doctorTileInput.attr('value', _doctorTile);
			        regFeeInput.attr('value', _regFee);
			        treatFeeInput.attr('value', _treatFee);
			        scheduleFlagInput.attr('value', _scheduleFlag);
			        scheduleNoInput.attr('value', _scheduleNo);
			        regDateInput.attr('value', _regDate);
			        visitTimeInput.attr('value', _visitTime);
			        // 附加到Form
			        form.append(hospitalIdInput);
			        form.append(hospitalNameInput);
			        form.append(deptIdInput);
			        form.append(deptNameInput);
			        form.append(doctorIdInput);
			        form.append(doctorNameInput);
			        form.append(doctorTileInput);
			        form.append(regFeeInput);
			        form.append(treatFeeInput);
			        form.append(scheduleFlagInput);
			        form.append(scheduleNoInput);
			        form.append(regDateInput);
			        form.append(visitTimeInput);
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

		//点击关注
        $(".follow-star").click(function(event){ 
            var _txt = $(this).children("span").html().trim();
	     	var typeId = $(this).data("id");
	     	var _doctorName = $(".label-content:eq(0)").text();
		    var _level = $(".label-content:eq(1)").text();
		    var _departName = $(".label-content:eq(4)").text();
		    var _hospitalId = $(".label-content:eq(3)").data("hospId");
			var _hospitalName = $(".label-content:eq(3)").text();
            if(_txt=="关注"){
            	var that = this;
	         ajaxRequest.getAjaxFollow({typeId:typeId, doctorName: _doctorName, level: _level, departName: _departName, hospitalId: _hospitalId, hospitalName: _hospitalName}).then(function (resp) {
                if(resp.state==200){
                 var appendStr='<i class="fa fa-star fa-lg">'
                          +'</i>'
                          +'<span>'
                          +'已关注'
                          +'</span>'
                    $(that).html(appendStr);    
                  }
                 });
	      } 
              event.stopPropagation();
        });

        $(".number-line-bar").click(function () {
            console.log("....KKK....");
            $(this).siblings(".number-day").fadeToggle();
        });
    });
</script>
</body>
</html>