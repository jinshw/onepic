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
    <title>科室详情页</title>

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
            height: 0.88rem;
            width: 100%;
            margin-bottom: 0.2rem;
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
            /*border-bottom: 1px solid #dfdfdf;*/
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
            top: 0.18rem;
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
            height: 2.15rem;
            /*border-bottom: 1px solid #dfdfdf;*/
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
            top: 0.2rem;
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

        .fa-star-o, .fa-star {
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

        .number-day .number-line-second {
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

        .center-content .doctor-name {
            font-size: 0.3rem;
            color: #1a1a1a;
        }

        .center-content .doctor-level, .center-content .doctor-good {
            font-size: 0.28rem;
            color: #656565;
        }

        .number-icon {
            color: #39d3bf;
            border: 1px solid #39d3bf;
            font-size: 0.22rem;
            padding: 0px 0.05rem;
            border-radius: 5px;
            position: absolute;
            top: 0.2rem;
            right: 0;
        }

        .seven-day {
            width: 100%;
            height: 1.2rem;
            background-color: #FFFFFF;
            display: flex;
            font-size: 0.3rem;
            color: #1a1a1a;
            margin-bottom: 0.2rem;
        }

        .seven-day .day-item {
            background-color: #FFFFFF;
            width: 1.07rem;
            height: 100%;
            border: 1px solid #FFFFFF;
            position: relative;
        }

        .day-item .day-week {
            position: absolute;
            top: 0.12rem;
            width: 100%;
            height: 0.50rem;
            line-height: 0.50rem;
            text-align: center;
        }

        .day-item .day-num {
            position: absolute;
            bottom: 0.12rem;
            width: 100%;
            height: 0.5rem;
            line-height: 0.5rem;
            text-align: center;
        }

        .day-item .day-today {
            color: #2ed0bb;
        }

        .title-morning, .title-afternoon {
            width: 100%;
            height: 0.57rem;
            position: relative;
        }

        .title-morning .moring-icon {
            width: 0.02rem;
            height: 0.20rem;
            position: absolute;
            left: 0.24rem;
            top: 0.10rem;
            background-image: url(../static/images/vertical-line-icon01.png);
        }
        .title-afternoon .afternoon-icon {
            width: 0.02rem;
            height: 0.20rem;
            position: absolute;
            left: 0.24rem;
            top: 0.10rem;
            background-image: url(../static/images/vertical-line-icon02.png);
        }


        .title-morning .moring-content, .title-afternoon .moring-content {
            position: absolute;
            left: 0.36rem;
            top: -0.04rem;
            font-size: 0.3rem;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="back">
        <i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>
    </div>
    <div class="area">
        <span class="title-hospital" id="hospital"></span>
        —
        <span class="title-depart"></span>
    </div>
</div>

<div class="seven-day" id="dateList">
	<c:if test="${date != null}">
		<div class="day-item" data-day-id="${date[0].dayStr }" data-active = "1">
	        <a class="day-week day-today">${date[0].weekNum }</a>
	        <a class="day-num">${date[0].dayNum }</a>
	    </div>
		<c:forEach items="${date}" var="date" begin="1">
			<div class="day-item" data-day-id="${date.dayStr }" data-active = "0">
        		<a class="day-week">${date.weekNum }</a>
        		<a class="day-num">${date.dayNum }</a>
    		</div>
		</c:forEach>
	</c:if>
</div>

<div class="title-morning">
    <div class="moring-icon"></div>
    <div class="moring-content">上午</div>
</div>
<div class="search-result" id="moringList">
</div>
<div class="title-afternoon">
    <div class="afternoon-icon"></div>
    <div class="moring-content">下午</div>
</div>
<div class="search-result" id="afternoonList">
</div>

<script src="${ctx}/static/lib/jquery-weui-app/lib/jquery-2.1.4.js"></script>
<script src="${ctx}/static/lib/jquery-weui-app/js/jquery-weui.js"></script>
<script src="${ctx}/static/js/ajaxRequest.js"></script>
<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    
    var _obj = ${list};
    console.log(_obj);

	$(".title-hospital").html(_obj.hospitalName);
	$(".title-depart").html(_obj.deptName);
    
    var _noDoctor = '<div class="tip-no-doctor" style="font-size: 28px; text-align: center; color: #848484;">无医生记录</div>';
    
	//医生列表
	getDrRegScheduleData(_obj);
	
	 /**
	 * 获取对应日期的医生挂号班别信息
	 * @param respData
	 */
	function getDrRegScheduleData(respData) {
		var _doctorList = respData.list;
		var _doctorObj;
	    var doctorDiv = '',doctorMoringDiv = '',doctorDivafternoonDiv = '';
	    for(var i = 0; i < _doctorList.length; i++) {
	    	_doctorObj = _doctorList[i];
            var contentWidth = "2.15";
            if(_doctorObj.doctorTitle == ""){
                contentWidth = "1.7";
            }

			var urlPic = '';
			if(_doctorObj.urlPic == '') {
				urlPic = 'static/images/doctor.png';
			} else {
				urlPic = _doctorObj.urlPic;
			}

	    	doctorDiv = '<div class="container">' +
	    				'	<div class="content" style="height:'+ contentWidth +'rem">' +
	    				'		<div class="header-img">' +
	    				'			<img src="${ctx}/'+ urlPic +'" alt="头像">				' +
	    				'		</div>' +
	    				'		<div class="center-content">											' +
	    				'			<div class="line-bar">												' +
	    				'				<span class="doctor-name">' + _doctorObj.doctorName + '</span>	' +
	    				'			</div>																' +
	    				'			<div class="line-bar">												' +
	    				'				<span class="doctor-level">' + _doctorObj.doctorTitle + '</span>' +
	    				'			</div>																' +
	    				'			<div class="line-bar" style="width:4.15rem">' +
	    				'				<span class="doctor-good">' + cutstr(_doctorObj.betterFor,50) + '</span>' +
	    				'			</div>' +
	    				'		</div>';
	    	//出诊时间
	    	var _regScheduleList = _doctorList[i].regScheduleInfoBeanList;
	    	var _regScheduleObj;
	    	for(var j = 0; j < _regScheduleList.length; j++) {
	    		_regScheduleObj = _regScheduleList[j];
	    		//判断剩余号源是否大于0
				var regCount = '有号';
				/* if(_regScheduleObj.regleaveCount > 0) {
					regCount = '有号';
				} else {
					regCount = '无号';
				} */
    			//连接本地使用（消除无号医生信息）
    			var _tempMoringDivFlag = '', _tempAfternoonDivFlag = '';
	    		if(_regScheduleObj.scheduleType == '全天' || _regScheduleObj.scheduleType == '全日') {
	    			//上午
	    			doctorMoringDiv = doctorMoringDiv + doctorDiv +
	    				'		<a class="number-icon">' + regCount + '</a>														' +
	    				'		<div class="follow-star" data-id="' + _doctorObj.doctorId + '">									';
	    				if(_doctorObj.flag == 0){
	    			doctorMoringDiv = doctorMoringDiv +
	    				'				<i class="fa fa-star-o fa-lg"></i>														' +
	    				'				<span>关注</span>																			';
	    				} else if(_doctorObj.flag == 1) {
   					doctorMoringDiv = doctorMoringDiv +
	    				'				<i class="fa fa-star fa-lg" id="attid" value="' + _doctorObj.doctorId + '"></i>			' +
	    				'				<span>已关注</span>																		';
	    				}
	    			doctorMoringDiv = doctorMoringDiv +
	    				'		</div>																							' +
	    				'	</div>';
	    				
                    if(typeof(_regScheduleObj.subList) != "undefined" && _regScheduleObj.subList.length !=0 ){
                        for(var k=0;k<_regScheduleObj.subList.length;k++){
                        	
                        	var _numTime = _regScheduleObj.subList[k].regDate + " " + _regScheduleObj.subList[k].timeStr.split('-')[1] + ":00";
                        	var _numTimes = _numTime.substring(0,10).split('-');
                        	_numTime=_numTimes[1]+'-'+_numTimes[2]+'-'+_numTimes[0]+' '+_numTime.substring(10,19);
                        	
                        	if(Date.parse(new Date(Date.parse(_numTime.replace(/-/g, "/")))) > Date.parse(new Date())) {
                        		var time = parseInt(_regScheduleObj.subList[k].timeStr.split(':', 1)[0]);
	                        	if(time < 12) {
	                        		doctorMoringDiv = doctorMoringDiv +
		                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
		                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
		                                'data-regFee = "' + _regScheduleObj.subList[k].regFee + '"	data-treatFee = "' + _regScheduleObj.subList[k].treatFee + '"		' +
		                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.subList[k].scheduleNo + '">'+
		                                '		<div class="number-line-second">' +
		                                '			<span class="number-time">'+ _regScheduleObj.subList[k].timeStr +'</span>' +
		                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.subList[k].regleaveCount + '</a></span>' +
		                                '			<i class="fa fa-angle-right"></i>' +
		                                '		</div>' +
		                                '	</div>';
	                                _tempMoringDivFlag = _tempMoringDivFlag + '|' + k;
	                        	}
                        	}
                        }
                        if(_tempMoringDivFlag == ''){
	                        doctorMoringDiv = '';
	                    } else {
	                    	doctorMoringDiv = doctorMoringDiv + '</div>';
	                    }
                    }else{
                    	if(time_range("00:00","11:30",_regScheduleObj.regDate)) {
                    		doctorMoringDiv = doctorMoringDiv +
                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
                                'data-regFee = "' + _regScheduleObj.regFee + '"	data-treatFee = "' + _regScheduleObj.treatFee + '"		' +
                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.scheduleNo + '">'+
                                '		<div class="number-line-second">' +
                                '			<span class="number-time">8:30-11:30</span>' +
                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.regleaveCount + '</a></span>' +
                                '			<i class="fa fa-angle-right"></i>' +
                                '		</div>' +
                                '	</div></div>';
                    	} else {
                    		doctorMoringDiv = '';
                    	}
                    }
	    			 
	    			//下午
	    			doctorDivafternoonDiv  = doctorDivafternoonDiv + doctorDiv +
	    				'		<a class="number-icon">' + regCount + '</a>														' +
	    				'		<div class="follow-star" data-id="_doctorObj.doctorId">											';
	    				if(_doctorObj.flag == 0){
	    			doctorDivafternoonDiv = doctorDivafternoonDiv +
	    				'				<i class="fa fa-star-o fa-lg"></i>														' +
	    				'				<span>关注</span>																			';
	    				} else if(_doctorObj.flag == 1) {
   					doctorDivafternoonDiv = doctorDivafternoonDiv +
	    				'				<i class="fa fa-star fa-lg" id="attid" value="' + _doctorObj.doctorId + '"></i>			' +
	    				'				<span>已关注</span>																		';
	    				}
	    			doctorDivafternoonDiv = doctorDivafternoonDiv +
	    				'		</div>																							' +
	    				'	</div>' ;

                    if(typeof(_regScheduleObj.subList) != "undefined"  && _regScheduleObj.subList.length !=0 ){
                        for(var k=0;k<_regScheduleObj.subList.length;k++){
                        
                        	var _numTime = _regScheduleObj.subList[k].regDate + " " + _regScheduleObj.subList[k].timeStr.split('-')[1] + ":00";
                        	var _numTimes = _numTime.substring(0,10).split('-');
                        	_numTime=_numTimes[1]+'-'+_numTimes[2]+'-'+_numTimes[0]+' '+_numTime.substring(10,19);
                        	
                        	if(Date.parse(new Date(Date.parse(_numTime.replace(/-/g, "/")))) > Date.parse(new Date())) {
                        		var time = parseInt(_regScheduleObj.subList[k].timeStr.split(':', 1)[0]);
	                        	if(time >= 12) {
	                        		doctorDivafternoonDiv = doctorDivafternoonDiv +
		                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
		                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
		                                'data-regFee = "' + _regScheduleObj.subList[k].regFee + '"	data-treatFee = "' + _regScheduleObj.subList[k].treatFee + '"		' +
		                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.subList[k].scheduleNo + '">'+
		                                '		<div class="number-line-second">' +
		                                '			<span class="number-time">'+ _regScheduleObj.subList[k].timeStr +'</span>' +
		                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.subList[k].regleaveCount + '</a></span>' +
		                                '			<i class="fa fa-angle-right"></i>' +
		                                '		</div>' +
		                                '	</div>';
	                                _tempAfternoonDivFlag = _tempAfternoonDivFlag + '|' + k;
	                        	}
                        	}
                        }
                        if(_tempAfternoonDivFlag == ''){
	                        doctorDivafternoonDiv = '';
	                    } else {
	                    	doctorDivafternoonDiv = doctorDivafternoonDiv + '</div>';
	                    }
                    }else{
                    	if(time_range("00:00","17:30",_regScheduleObj.regDate)) {
                    		doctorDivafternoonDiv = doctorDivafternoonDiv +
                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
                                'data-regFee = "' + _regScheduleObj.regFee + '"	data-treatFee = "' + _regScheduleObj.treatFee + '"		' +
                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.scheduleNo + '">'+
                                '		<div class="number-line-second">' +
                                '			<span class="number-time">14:30-17:30</span>' +
                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.regleaveCount + '</a></span>' +
                                '			<i class="fa fa-angle-right"></i>' +
                                '		</div>' +
                                '	</div></div>';
                    	} else {
                    		doctorDivafternoonDiv = '';
                    	}
                    }
	    		}else if(_regScheduleObj.scheduleType == '上午' || _regScheduleObj.scheduleType == 'A') {
	    			//上午
	    			doctorMoringDiv = doctorMoringDiv + doctorDiv +
	    				'		<a class="number-icon">' + regCount + '</a>														' +
	    				'		<div class="follow-star" data-id="' + _doctorObj.doctorId + '">									';
	    				if(_doctorObj.flag == 0){
	    			doctorMoringDiv = doctorMoringDiv +
	    				'				<i class="fa fa-star-o fa-lg"></i>														' +
	    				'				<span>关注</span>																			';
	    				} else if(_doctorObj.flag == 1) {
   					doctorMoringDiv = doctorMoringDiv +
	    				'				<i class="fa fa-star fa-lg" id="attid" value="' + _doctorObj.doctorId + '"></i>			' +
	    				'				<span>已关注</span>																		';
	    				}
	    			doctorMoringDiv = doctorMoringDiv +
	    				'		</div>																							' +
	    				'	</div>' ;

                    if(typeof(_regScheduleObj.subList) != "undefined"  && _regScheduleObj.subList.length !=0 ){
                        for(var k=0;k<_regScheduleObj.subList.length;k++){
                        
                        	var _numTime = _regScheduleObj.subList[k].regDate + " " + _regScheduleObj.subList[k].timeStr.split('-')[1] + ":00";
                            var _numTimes = _numTime.substring(0,10).split('-');
                            _numTime=_numTimes[1]+'-'+_numTimes[2]+'-'+_numTimes[0]+' '+_numTime.substring(10,19);
                            
                            if(Date.parse(new Date(Date.parse(_numTime.replace(/-/g, "/")))) > Date.parse(new Date())) {
                            	var time = parseInt(_regScheduleObj.subList[k].timeStr.split(':', 1)[0]);
                                if(time < 12) {
                                	doctorMoringDiv = doctorMoringDiv +
		                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
		                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
		                                'data-regFee = "' + _regScheduleObj.subList[k].regFee + '"	data-treatFee = "' + _regScheduleObj.subList[k].treatFee + '"		' +
		                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.subList[k].scheduleNo + '">'+
		                                '		<div class="number-line-second">' +
		                                '			<span class="number-time">'+ _regScheduleObj.subList[k].timeStr +'</span>' +
		                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.subList[k].regleaveCount + '</a></span>' +
		                                '			<i class="fa fa-angle-right"></i>' +
		                                '		</div>' +
		                                '	</div>';
		                        	_tempMoringDivFlag = _tempMoringDivFlag + '|' + k;
                                }
                            }
                        }
                        if(_tempMoringDivFlag == ''){
                            doctorMoringDiv = '';
                        } else {
	                    	doctorMoringDiv = doctorMoringDiv + '</div>';
	                    }
                    }else{
                    	if(time_range("00:00","11:30",_regScheduleObj.regDate)) {
                    		doctorMoringDiv = doctorMoringDiv +
                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
                                'data-regFee = "' + _regScheduleObj.regFee + '"	data-treatFee = "' + _regScheduleObj.treatFee + '"		' +
                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.scheduleNo + '">'+
                                '		<div class="number-line-second">' +
                                '			<span class="number-time">8:30-11:30</span>' +
                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.regleaveCount + '</a></span>' +
                                '			<i class="fa fa-angle-right"></i>' +
                                '		</div>' +
                                '	</div></div>';
                    	} else {
                    		doctorMoringDiv = '';
                    	}
                            
                    }
	    		}else if(_regScheduleObj.scheduleType == '下午' || _regScheduleObj.scheduleType == 'P') {
	    			//下午
	    			doctorDivafternoonDiv  = doctorDivafternoonDiv + doctorDiv +
	    				'		<a class="number-icon">' + regCount + '</a>														' +
	    				'		<div class="follow-star" data-id="_doctorObj.doctorId">											';
	    				if(_doctorObj.flag == 0){
	    			doctorDivafternoonDiv = doctorDivafternoonDiv +
	    				'				<i class="fa fa-star-o fa-lg"></i>														' +
	    				'				<span>关注</span>																			';
	    				} else if(_doctorObj.flag == 1) {
   					doctorDivafternoonDiv = doctorDivafternoonDiv +
	    				'				<i class="fa fa-star fa-lg" id="attid" value="' + _doctorObj.doctorId + '"></i>			' +
	    				'				<span>已关注</span>																		';
	    				}
	    			doctorDivafternoonDiv = doctorDivafternoonDiv +
	    				'		</div>																							' +
	    				'	</div>' ;


	    			if(typeof(_regScheduleObj.subList) != "undefined" && _regScheduleObj.subList.length !=0 ){
                        for(var k=0;k<_regScheduleObj.subList.length;k++){
                        
                        	var _numTime = _regScheduleObj.subList[k].regDate + " " + _regScheduleObj.subList[k].timeStr.split('-')[1] + ":00";
                            var _numTimes = _numTime.substring(0,10).split('-');
                            _numTime=_numTimes[1]+'-'+_numTimes[2]+'-'+_numTimes[0]+' '+_numTime.substring(10,19);
                            
                            if(Date.parse( new Date(Date.parse(_numTime.replace(/-/g, "/"))) ) > Date.parse(new Date())) {
                                var time = parseInt(_regScheduleObj.subList[k].timeStr.split(':', 1)[0]);
                                if(time >= 12) {
                        			doctorDivafternoonDiv = doctorDivafternoonDiv +
		                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
		                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
		                                'data-regFee = "' + _regScheduleObj.subList[k].regFee + '"	data-treatFee = "' + _regScheduleObj.subList[k].treatFee + '"		' +
		                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.subList[k].scheduleNo + '">'+
		                                '		<div class="number-line-second">' +
		                                '			<span class="number-time">'+ _regScheduleObj.subList[k].timeStr +'</span>' +
		                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.subList[k].regleaveCount + '</a></span>' +
		                                '			<i class="fa fa-angle-right"></i>' +
		                                '		</div>' +
		                                '	</div>';
		                        	_tempAfternoonDivFlag = _tempAfternoonDivFlag + '|' + k;
                        		}
                        	}
                        }
                        if(_tempAfternoonDivFlag == ''){
                            doctorDivafternoonDiv = '';
                        } else {
	                    	doctorDivafternoonDiv = doctorDivafternoonDiv + '</div>';
	                    }
                    }else{
                    	if(time_range("00:00","17:30",_regScheduleObj.regDate)) {
                    		doctorDivafternoonDiv = doctorDivafternoonDiv +
                                '	<div class="number-day" data-doctor-name="' + _doctorObj.doctorName + '" 							' +
                                'data-doctor-level = "' + _doctorObj.doctorTitle + '" data-doctor-id = "' + _doctorObj.doctorId + '"	' +
                                'data-regFee = "' + _regScheduleObj.regFee + '"	data-treatFee = "' + _regScheduleObj.treatFee + '"		' +
                                'data-scheduleFlag = "A" data-scheduleNo = "' + _regScheduleObj.scheduleNo + '">'+
                                '		<div class="number-line-second">' +
                                '			<span class="number-time">14:30-17:30</span>' +
                                '			<span class="number-surplus">剩余号源：<a>' + _regScheduleObj.regleaveCount + '</a></span>' +
                                '			<i class="fa fa-angle-right"></i>' +
                                '		</div>' +
                                '	</div></div>';
                    	} else {
                    		doctorDivafternoonDiv = '';
                    	}
                    }
	    		}
	    		$("#moringList").html(doctorMoringDiv);
	    		$("#afternoonList").html(doctorDivafternoonDiv);
                $(".tip-no-doctor").remove();
	    	}
	    }
	    
	    $(".title-afternoon").show();
    	$(".title-morning").show();
	    //判断上下午数据
	    if(doctorMoringDiv == '' && doctorDivafternoonDiv == '') {
    		$(".title-morning").hide();
    		$(".title-afternoon").hide();
            var ndLength = $("#dateList").siblings(".tip-no-doctor").length;
            if(ndLength == 0){
                $("#dateList").after(_noDoctor);
                $("#moringList").html("");
                $("#afternoonList").html("");
            }
    	}
    	if (doctorMoringDiv == '') {
    		$(".title-morning").hide();
    	}
    	if (doctorDivafternoonDiv == '') {
    		$(".title-afternoon").hide();
    	}
    	
	    //点击关注
         $(".follow-star").click(function(event){ 
             var _txt = $(this).children("span").html().trim();
		     var typeId = $(this).data("id");
		     var _doctorName = $(this).parent().find(".doctor-name").text();
		     var _level = $(this).parent().find(".doctor-level").text();
		     var _departName = respData.deptName;
		     var _hospitalId = respData.hospitalId;
			 var _hospitalName = respData.hospitalName;
			 
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
	    
	    //点击一行背景颜色改变
        $(".number-line-second").click(function () {
            $(".number-line-second").css("background-color", "#FFFFFF");
            $(this).css("background-color", "#f5f5f5");
			$.showLoading();
            var that = this;
			//检查是否登录
			ajaxRequest.checkLogin().then(function (resp) {
				$.hideLoading();
				if(resp == '0') {
			        var _hospitalId = respData.hospitalId;
					var _hospitalName = respData.hospitalName;
					var _deptId = respData.deptId;
					var _deptName = respData.deptName;
					var _doctorId = $(that).parent().data("doctor-id");		
					var _doctorName = $(that).parent().data("doctor-name");		
					var _doctorTile = $(that).parent().data("doctor-level");		
					var _regDate = $(".seven-day .day-item[data-active=1]").data("day-id");
					var _visitTime = $(that).children().first().text();
					var _regFee = $(that).parent().data("regFee");
					var _treatFee = $(that).parent().data("treatFee");
					var _Free =	parseInt(_regFee)+parseInt(_treatFee);
					var _scheduleFlag = $(that).parent().data("scheduleFlag");
					var _scheduleNo = $(that).parent().data("scheduleNo");
					
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
			        form.appendTo("body").submit();
                    form.remove();
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

        // 医生展开
        $(".content").click(function () {
            console.log("....KKK....");
            $(this).siblings(".number-day").fadeToggle();
        });
	}
    //返回
    $(".back").click(function () {
    	console.log("...back....");
        window.history.go(-1);//回退
    });

    $(document).ready(function () {
        

        $(".seven-day .day-item").click(function () {
            $(".seven-day .day-item").css("background-color", "#FFFFFF");
            $(".seven-day .day-item").css("color", "#1a1a1a");
            $(".seven-day .day-item").attr("data-active","0");
            $(this).css("background-color", "#2ed0bb");
            $(this).css("color", "#FFFFFF");
            $(this).attr("data-active","1");
            var dayToday = $(this).children(".day-today");
            if (dayToday.length > 0) {
                dayToday.css("color", "#FFFFFF");
            } else {
                $(".day-today").css("color", "#2ed0bb");
            }
            
            $.showLoading();
            
            var _hospitalId = _obj.hospitalId;
            var _deptId = _obj.deptId;
            var _beginDate = $(this).data("day-id");
            var _hospitalName = _obj.hospitalName;
            var _deptName = _obj.deptName;
            
            ajaxRequest.getDrRegScheduleInfoByDate({hospitalId: _hospitalId, deptId: _deptId, beginDate: _beginDate,hospitalName: _hospitalName, deptName: _deptName}).then(function (data) {
            	console.log("获取数据成功",data);
            	getDrRegScheduleData(data);
            	setTimeout(function() { $.hideLoading();})
            });
        });

    });


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
	
	function time_range(beginTime, endTime, dateString) {
		var strb = beginTime.split(":");
		if (strb.length != 2) {
			return false;
		}

		var stre = endTime.split(":");
		if (stre.length != 2) {
			return false;
		}
		
		var l = new Date();
		var n = new Date();
		
		l.setFullYear(dateString.split('-')[0],dateString.split('-')[1]-1,dateString.split('-')[2]);
		if(l.toLocaleDateString() == n.toLocaleDateString()) {
			var b = new Date();
			var e = new Date();

			b.setHours(strb[0]);
			b.setMinutes(strb[1]);
			e.setHours(stre[0]);
			e.setMinutes(stre[1]);
	
			if (n.getTime() - b.getTime() > 0 && n.getTime() - e.getTime() < 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
</script>
</body>
</html>