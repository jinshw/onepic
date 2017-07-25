<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="description" content="">
    <title>挂号确定页面</title>

    <link rel="stylesheet" href="../static/lib/jquery-weui-app2/lib/weui.css">
    <link rel="stylesheet" href="../static/lib/jquery-weui-app2/css/jquery-weui.css">
    <link rel="stylesheet" href="../static/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../static/css/app/myinfo-add.css">
    
    <script src="${ctx}/static/lib/jquery-weui-app2/lib/jquery-2.1.4.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app2/js/jquery-weui.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app/js/city-picker.js"></script>
	<script src="${ctx}/static/lib/jquery-weui-app/js/swiper.js"></script>
	<script src="${ctx}/static/lib/layer_mobile/layer.js"></script>
	<script src="${ctx}/static/js/app/ajaxRequest.js"></script>
    
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
            color: #cd0200;
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
            margin-bottom: 19px;
        }

        .title-bar .title-bar-icon {
            width: 2px;
            height: 2px;
            background-color: #ff8a6f;
            position: absolute;
            left: 24px;
            top: 10px;
        }

        .title-bar .title-bar-content {
            position: absolute;
            left: 38px;
            top: 1px;
            font-size: 38px;
        }

        .number-info {
            width: 100%;
            height: 132px;
            background-color: #FFFFFF;
            display: flex;
            justify-content: center;
            color: #1a1a1a;
            font-size: 36px;
        }

        .number-line {
            width: 912px;
            height: 100px;
            margin-left: 3px;
            line-height: 66px;
            border-bottom: 1px solid #dfdfdf;
            position: relative;
            margin-top: 31px;
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
            width: 748px;
            height: 60px;
            border-bottom: 1px solid #dfdfdf;
        }

        .submit-bt {
            display: flex;
            justify-content: center;
            margin-top: 100px;
        }

        .submit-bt .weui_btn_primary {
            background-color: #2ed0bb;
            height: 106px;
            line-height: 106px;
            width:748px;
            border: 1px solid #2ed0bb;
            font-size: 38px;
            border-radius: 8px;
            color: #FFFFFF;
            text-align: center;
        }

        .weui_btn_primary:not(.weui_btn_disabled):active {
            color: hsla(0, 0%, 100%, 0.4);
            background-color: #21b4a1;
        }
        
        .add-pat{
            display: flex;
            justify-content: center;
            margin-top: 0.4rem;
        }
        .add-pat .weui_btn_primary {
            background-color: #fff;
            height: 0.8rem;
            line-height: 0.8rem;
            width: 5.75rem;
            border: 1px solid #1bc4ae;
            font-size: 0.3rem;
            border-radius: 0.08rem;
            color: #1bc4ae;
            text-align: center;
        }
        
        /** 微信样式 **/
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
		.layui-layer-hui .layui-layer-content {
		    padding: 30px 40px;
		    text-align: center;
		}
		.layui-layer-dialog .layui-layer-content {
		    position: relative;
		    line-height: 60px;
		    word-break: break-all;
		    font-size: 40px;
		    overflow: auto;
		}
		.layui-layer {
		    margin: 0;
		    padding: 0;
		    -webkit-background-clip: content;
		    border-radius: 9px;
		    animation-fill-mode: both;
		    animation-duration: .3s;
		}
		
		.layui-m-layerchild {
		font-size: 30px;
		}
		
		.layui-m-layer-msg .layui-m-layercont {
		padding: 50px 30px;
		}
		
		.layui-m-layer{
            z-index: 50!important;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="back">
        <i class="fa fa-angle-left" style="font-size:70px;line-height:88px;"></i>
    </div>
    <div class="area">
        <span class="title-hospital">${data.hospName}</span>
        —
        <span class="title-depart">${data.departName}</span>
    </div>
</div>

<div class="title-bar">
    <div class="title-bar-icon"></div>
    <div class="title-bar-content">挂号信息</div>
</div>
<form action="/core/appointApp/initToPay" method="post" id="form">
    <div class="number-info">
        <div class="number-line">
            <span class="num-title">医院：</span>
            <span class="num-val" style="color:#21b4a1;">${data.hospName}</span>
        </div>
    </div>
    <div class="number-info">
        <div class="number-line">
            <span class="num-title">科室：</span>
            <span class="num-val">${data.departName}</span>
        </div>
    </div>
    <div class="number-info">
        <div class="number-line">
            <span class="num-title">医生：</span>
            <span class="num-val">${data.doctorName}</span>
            <span class="num-val">${data.doctorTile}</span>
        </div>
    </div>
    <div class="number-info">
        <div class="number-line">
            <span class="num-title">就诊时间：</span>
            <span class="num-val">${data.regDate} ${data.visitTime}</span>
            <%--<span class="num-val">8:00-10:00</span>--%>
        </div>
    </div>
    <div class="number-info num-info-bottom">
        <div class="number-line" style="text-align: right;">
            <span class="num-title">总计费用：</span>
            <span class="num-val num-total">${data.fee}元</span>
        </div>
    </div>
    <!--选择就诊人-->
    <div class="title-bar">
        <div class="title-bar-icon"></div>
        <div class="title-bar-content">选择就诊人</div>
    </div>
    <div class="number-info num-info-bottom">
        <div class="number-line">
            <span class="num-title">就诊人：</span>
            <input class="weui_input" id="patientId" name="patName" type="text" value="">
        </div>
    </div>
    <%--隐藏域--%>
    <input type="text" hidden="hidden" name="hospId" id="hospId" value="${data.hospId}">
    <input type="text" hidden="hidden" name="hospName" id="hospName" value="${data.hospName}">
    <input type="text" hidden="hidden" name="departId" id="departId" value="${data.departId}">
    <input type="text" hidden="hidden" name="departName" id="departName" value="${data.departName}">
    <input type="text" hidden="hidden" name="doctorId" id="doctorId" value="${data.doctorId}">
    <input type="text" hidden="hidden" name="doctorName" id="doctorName" value="${data.doctorName}">
    <input type="text" hidden="hidden" name="doctorTile" id="doctorTile" value="${data.doctorTile}">
    <input type="text" hidden="hidden" name="regDate" id="regDate" value="${data.regDate}">
    <input type="text" hidden="hidden" name="visitTime" id="visitTime" value="${data.visitTime}">
    <input type="text" hidden="hidden" name="fee" id="fee" value="${data.fee}">
    <input type="text" hidden="hidden" name="patId" id="patId" value="">

    <input type="text" hidden="hidden" name="regFee" id="regFee" value="${data.regFee}">
    <input type="text" hidden="hidden" name="treatFee" id="treatFee" value="${data.treatFee}">
    <input type="text" hidden="hidden" name="scheduleFlag" id="scheduleFlag" value="${data.scheduleFlag}">
    <input type="text" hidden="hidden" name="scheduleNo" id="scheduleNo" value="${data.scheduleNo}">


    <div class="submit-bt">
        <input id="sureBt" type="button" class="weui_btn weui_btn_primary" value="确定">
    </div>
    <div class="add-pat">
        <input id="addPat" type="button" class="weui_btn weui_btn_primary" value="添加就诊人">
    </div>
</form>

<script>
    var _cssText = document.querySelector("html").style.cssText;
    document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
    //返回
    $(".back").click(function () {
        window.history.go(-1);//回退
    });

    var _items = ${data.list};
    console.log("....  ", _items.length);
    if (_items.length == 0) {
     //   $.confirm("您没有绑定就诊人，确认去绑定就诊人?", function () {
      //  	console.log("绑卡-确认");
       //     window.location.href=window.jsobj.toVisitNumAdministration();
             var _htmlContent = ''+
                    '<div class="header">                                                                                   '+
                    '	<div class="area">                                                                                  '+
                    '		<span>完善登录人信息</span>                                                                         '+
                    '	</div>                                                                                              '+
                    '	<div class="right">                                                                                 '+
                    '	</div>                                                                                              '+
                    '</div>                                                                                                 '+
                    '<div class="myinfo-container">                                                                         '+
                    '	<div class="myinfo-detail">                                                                         '+
                    '		<div class="line-bar-detail open-popup" data-target="#nameUpdateFull">                          '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">真实姓名</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" name="name" id="name" value="" placeholder="未填写不能挂号">                    '+
                    '		</span>                                                                                         '+
                    '			</div>                                                                                      '+
                    '		</div>                                                                                          '+
                    '		<div class="line-bar-detail">                                                                   '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">证件类型</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" name="idTypeId" value="身份证" id="idTypeId" readonly="">'+
                    '			<i class="fa fa-angle-right fa-lg"></i>                                                     '+
                    '		</span>                                                                                         '+
                    '			</div>                                                                                      '+
                    '		</div>                                                                                          '+
                    '		<div class="line-bar-detail open-popup" data-target="#idNumUpdateFull">                         '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">证件号码</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" id="idNum" name="idNum" value="" placeholder="未填写不能挂号">                  '+
                    '		</span>                                                                                         '+
                    '			</div>                                                                                      '+
                    '		</div>                                                                                          '+
                    '		<div class="line-bar-detail">                                                                   '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">常驻城市</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" id="cityId" name="cityId" value="内蒙古 包头" readonly="">    '+
                    '			<i class="fa fa-angle-right fa-lg"></i>                                                     '+
                    '		</span>                                                                                         '+
                    '			</div>                                                                                      '+
                    '		</div>                                                                                          '+
                    '                                                                                                       '+
                    '		<div class="line-bar-detail" style="height: 1.2rem;line-height: 1.2rem;">                       '+
                    '			<div class="myinfo-save" id="myinfoSaveBt">保存</div>                                       '+
                    '		</div>                                                                                          '+
                    '	</div>                                                                                              '+
                    '</div>                                                                                                 ';

            layer.open({
                type: 1
                ,content: _htmlContent
                ,anim: 'up'
                ,style: 'position:fixed; left:0; top:0; width:100%; height:100%; border: none; -webkit-animation-duration: .5s; animation-duration: .5s;',
                success:function (elem) {
                    console.log(elem)
                    // 选择城市
                    $("#cityId").cityPicker({
                        title: "选择城市",
                        showDistrict: false
                    });

                    // 选择证件类型
                    $("#idTypeId").select({
                        title: "选择证件类型",
                        items: [{title: "身份证", value: "1"}],
                        onChange: function (d) {
                            console.log(this, d);
                            // 在这里调用ajax 后台保存方法
                        },
                        onClose: function () {
                            console.log("close");
                            var idTypeId =  $("#idTypeId").val();
                            console.log("idTypeId=="+idTypeId)
                        },
                        onOpen: function () {
                            console.log("open");
                        }
                    });
                    // 关闭
                    $("#backBt").click(function () {
                        layer.closeAll();
                    });

                    //新增就诊人信息保存
                    $("#myinfoSaveBt").click(function() {
                        var name = $("#name").val();
                        var idTypeId = $("#idTypeId").val();
                        var idNum = $("#idNum").val();
                        var cityId = $("#cityId").val();
                        if (name == null || name == "") {
                            layer.open({
                                content: '请填写真实姓名',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }
                        if (idTypeId == null || idTypeId == "") {
                            layer.open({
                                content: '请选择身份类型',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }
                        if (!isCardID(idNum)) {
                            layer.open({
                                content: '身份证格式不正确',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }
                        if (cityId == null || cityId == "") {
                            layer.open({
                                content: '请选择所在地',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }

                        // ajax提交后台
                        console.log("name="+name,"idTypeId="+idTypeId,"idNum="+idNum,"cityId="+cityId)
                        $.ajax({
                            type:"POST",
                            url:"${ctx}/user/saveUserInforAjax",
                            dataType:'json',
                            data:{
                                cityId:cityId,
                                idNum:idNum,
                                idTypeId:idTypeId,
                                name:name
                            },
                            success:function (data) {
                                console.log(data)
                                layer.closeAll();
                                $.ajax({
                                    type:"POST",
                                    url:"${ctx}/appointApp/getPatList",
                                    dataType:'json',
                                    data:{
                                    },
                                    success:function (data) {
                                        console.log(data)
                                        if(data.state == 200){
                                            _items = data.list;
                                            $("#patientId").select("update",{
                                                title: "请选就诊人",
                                                items: _items
                                            });
                                        }
                                        layer.closeAll();
                                    },
                                    error:function (dd) {
                                        console.log("ajax req error")
                                        layer.open({
                                            content: dd.msg,
                                            skin: 'msg',
                                            time: 3 //3秒后自动关闭
                                        });
                                    }
                                })
                            },
                            error:function () {
                                console.log("ajax req error")
                            }

                        })

                    });

                }
            })
    //    }, function () {
            //取消操作
    //        console.log("绑卡-确认");
     //   });
    }else{
     $("#patientId").val(_items[0].title)
        $("#patientId").data('values',_items[0].value)
    }
    $("#patientId").select({
        title: "请选就诊人",
        items: _items
    });


        $(document).ready(function () {
        // 添加就诊人
        $('#addPat').click(function () {
            var _htmlDom = ''+
                    '<div class="header">                                                                                   '+
                    '	<div class="back" id="closeLayer">                                                                                 '+
                    '		<i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>                                          '+
                    '	</div>                                                                                                   '+
                    '	<div class="area">                                                                                  '+
                    '		<span>添加就诊人</span>                                                                         '+
                    '	</div>                                                                                              '+
                    '	<div class="right">                                                                                 '+
                    '	</div>                                                                                              '+
                    '</div>                                                                                                 '+
                    '<div class="myinfo-container">                                                                         '+
                    '	<div class="myinfo-detail">                                                                         '+
                    '		<div class="line-bar-detail open-popup" data-target="#nameUpdateFull">                          '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">真实姓名</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" name="name" id="name" value="" placeholder="未填写不能挂号">                    '+
                    '		</span>                                                                                         '+
                    '			</div>                                                                                      '+
                    '		</div>                                                                                          '+
                    '		<div class="line-bar-detail">                                                                   '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">证件类型</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" name="idTypeId" value="身份证" id="idTypeId" readonly="">'+
                    '			<i class="fa fa-angle-right fa-lg"></i>                                                     '+
                    '		</span>                                                                                         '+
                    '			</div>                                                                                      '+
                    '		</div>                                                                                          '+
                    '		<div class="line-bar-detail open-popup" data-target="#idNumUpdateFull">                         '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">证件号码</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" id="idNum" name="idNum" value="" placeholder="未填写不能挂号">                  '+
                    '		</span>'+
                    '			</div> '+
                    '		</div>'+

                    '		<div class="line-bar-detail">                                                                   '+
                    '			<div class="line-content">                                                                  '+
                    '				<span class="left">常驻城市</span>                                                      '+
                    '		<span class="right">                                                                            '+
                    '			<input type="text" class="content-input" id="cityId" name="cityId" value="内蒙古 包头" readonly="">    '+
                    '			<i class="fa fa-angle-right fa-lg"></i>                                                     '+
                    '		</span>                                                                                         '+
                    '			</div>                                                                                      '+
                    '		</div>                                                                                          '+
                    '                                                                                                       '+
                    '		<div class="line-bar-detail" style="height: 1.2rem;line-height: 1.2rem;">                       '+
                    '			<div class="myinfo-save" id="savePatBt">保存</div>                                       '+
                    '		</div>                                                                                          '+
                    '	</div>                                                                                              '+
                    '</div>                                                                                                 ';

            layer.open({
                type: 1
                ,content: _htmlDom
                ,anim: 'up'
                ,style: 'position:fixed; left:0; top:0; width:100%; height:100%; border: none; -webkit-animation-duration: .5s; animation-duration: .5s;',
                success:function (elem) {
                    console.log(elem)
                    $("#closeLayer").click(function () {
                        layer.closeAll()
                    })
                    
                    // 选择城市
                    $("#cityId").cityPicker({
                        title: "选择城市",
                        showDistrict: false
                    });

                    // 选择证件类型
                    $("#idTypeId").select({
                        title: "选择证件类型",
                        items: [{title: "身份证", value: "1"}],
                        onChange: function (d) {
                            console.log(this, d);
                            // 在这里调用ajax 后台保存方法
                        },
                        onClose: function () {
                            console.log("close");
                            var idTypeId =  $("#idTypeId").val();
                            console.log("idTypeId=="+idTypeId)
                        },
                        onOpen: function () {
                            console.log("open");
                        }
                    });
                    // 关闭
                    $("#backBt").click(function () {
                        layer.closeAll();
                    });

                    //新增就诊人信息保存
                    $("#savePatBt").click(function() {
                        var name = $("#name").val();
                        var idTypeId = $("#idTypeId").val();
                        var idNum = $("#idNum").val();
                        var cityId = $("#cityId").val();
                        if (name == null || name == "") {
                            layer.open({
                                content: '请填写真实姓名',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }
                        if (idTypeId == null || idTypeId == "") {
                            layer.open({
                                content: '请选择身份类型',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }
                        if (!isCardID(idNum)) {
                            layer.open({
                                content: '身份证格式不正确',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }
                        if (cityId == null || cityId == "") {
                            layer.open({
                                content: '请选择所在地',
                                skin: 'msg',
                                time: 3 //3秒后自动关闭
                            });
                            return;
                        }

                        // ajax提交后台
                        console.log("name="+name,"idTypeId="+idTypeId,"idNum="+idNum,"cityId="+cityId)
                        $.ajax({
                            type:"POST",
                            url:"${ctx}/user/savepatientAjax",
                            dataType:'json',
                            data:{
                                cityId:cityId,
                                idNum:idNum,
                                idTypeId:idTypeId,
                                name:name
                            },
                            success:function (data) {
                                console.log(data)
                                //layer.closeAll();
                                //location.reload()
                                layer.open({
                                    content: data.msg,
                                    skin: 'msg',
                                    time: 3 //3秒后自动关闭
                                });
                                if(data.state==200){
                                   $.ajax({
                                        type:"POST",
                                        url:"${ctx}/appointApp/getPatList",
                                        dataType:'json',
                                        data:{
                                        },
                                        success:function (data) {
                                            console.log(data)
                                            if(data.state == 200){
                                                _items = data.list;
                                                $("#patientId").select("update",{
                                                    title: "请选就诊人",
                                                    items: _items
                                                });
                                            }
                                            layer.closeAll();
                                        },
                                        error:function (dd) {
                                            console.log("ajax req error")
                                            layer.open({
                                                content: dd.msg,
                                                skin: 'msg',
                                                time: 3 //3秒后自动关闭
                                            });
                                        }
                                })
                                }

                               

                            },
                            error:function (dd) {
                                console.log("ajax req error")
                                layer.open({
                                    content: dd.msg,
                                    skin: 'msg',
                                    time: 3 //3秒后自动关闭
                                });
                            }

                        })

                    });

                }
            })
        })



    });



    $(document).ready(function () {

    });

    $("#sureBt").click(function () {
    	var that = this;
    	//检查是否登录
		ajaxRequest.checkLogin().then(function (resp) {
			if(resp == '0') {
	    		var _patId = $("#patientId").data("values");
	    		var _hospId = "${data.hospId}";
		    	if(typeof (_patId) == "undefined" || _patId == ""){
		            layer.msg("请选择就诊人！");
		            return false;
		        }
	    		//检查是否绑定就诊卡
				ajaxRequest.checkPatient({patId: _patId,hospId: _hospId}).then(function (resp) {
					if(resp == '0') {
			        /* $("#sureBt").attr({"disabled":"disabled"});
				        setTimeout(function(){
				            $("#sureBt").removeAttr("disabled");
				        },10000);
				        //获取就诊人ID
				        $("#patId").val(_patId);
						$("#form").submit(); */
					    var nowTime = new Date().getTime();
					    var clickTime = $(that).attr("ctime");
					    if( clickTime != 'undefined' && (nowTime - clickTime < 10000)){
					        console.log('操作过于频繁，稍后再试');
					        return false;
					     }else{
					        $(that).attr("ctime",nowTime);
					        console.log('提交成功');
					        $("#patId").val(_patId);
					        $("#form").submit();
					     }
					} else {
				///		$.confirm("未绑定就诊卡，确认去绑定就诊卡?", function() {
					  		//点击确认后的回调函数
				//	  		console.log("绑卡-确认");
					//  		window.location.href = "http://www.yunju360.com/core/user/checkUserInfor";
					//	}, function() {
					  		//点击取消后的回调函数
					  //		console.log("绑卡-取消");
					//	});
					console.log("绑卡-确认");
                            var _dom = ''+
                                    '<div class="header">                                                                                        '+
                                    '	<div class="back" id="closeLayer">                                                                                 '+
                                    '		<i class="fa fa-angle-left" style="font-size: 0.6rem;"></i>                                          '+
                                    '	</div>                                                                                                   '+
                                    '	<div class="area">                                                                                       '+
                                    '		<span>绑定就诊卡</span>                                                                              '+
                                    '	</div>                                                                                                   '+
                                    '	<div class="right">                                                                                      '+
                                    '	</div>                                                                                                   '+
                                    '</div>                                                                                                      '+
                                    '<div class="myinfo-container">                                                                              '+
                                    '	<div class="myinfo-detail">                                                                              '+
                                    '		<div class="line-bar-detail open-popup" data-target="">                                              '+
                                    '			<div class="line-content">                                                                       '+
                                    '				<span class="left">健康卡</span>                                                             '+
                                    '	<span class="right">                                                                                     '+
                                    '		<input type="text" class="content-input" value="" id="cardNum" placeholder="可以不填写/填写卡号">               '+
                                    '	</span>                                                                                                  '+
                                    '			</div>                                                                                           '+
                                    '		</div>                                                                                               '+
                                    '		<div class="line-bar-detail">                                                                        '+
                                    '			<div class="line-content">                                                                       '+
                                    '				<span class="left">医院</span>                                                               '+
                                    '	<span class="right">                                                                                     '+
                                    '		<input type="text" class="content-input" value="${data.hospName}" id="hospitalId" placeholder="选择医院" readonly="">'+
                                    '		<i class="fa fa-angle-right fa-lg"></i>                                                              '+
                                    '	</span>                                                                                                  '+
                                    '			</div>                                                                                           '+
                                    '		</div>                                                                                               '+
                                    '		<div class="line-bar-detail" style="height: 1.2rem;line-height: 1.2rem;">                            '+
                                    '			<div class="myinfo-save" id="saveCardBt">保存</div>                                              '+
                                    '		</div>                                                                                               '+
                                    '	</div>                                                                                                   '+
                                    '</div>                                                                                                      ';
                            layer.open({
                                type: 1,
                                content: _dom,
                                anim: 'up',
                                style: 'position:fixed; left:0; top:0; width:100%; height:100%; border: none; -webkit-animation-duration: .5s; animation-duration: .5s;',
                                success: function (elem) {
                                    console.log(elem)
                                    bindingHospList();
                                    // 执行绑卡绑定
                                    bindingSaveCard()
                                    $("#closeLayer").click(function () {
                                        layer.closeAll()
                                    })
                                }
                            })
					}
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
	});
	
	
	
	function isCardID(sId) {
        var aCity = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外" };
        var iSum = 0;
        var info = "";
        if (!/^\d{17}(\d|x)$/i.test(sId)) return false;
        sId = sId.replace(/x$/i, "a");
        if (aCity[parseInt(sId.substr(0, 2))] == null) return false;
        sBirthday = sId.substr(6, 4) + "-" + Number(sId.substr(10, 2)) + "-" + Number(sId.substr(12, 2));
        var d = new Date(sBirthday.replace(/-/g, "/"));
        if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())) return false;
        for (var i = 17; i >= 0; i--) iSum += (Math.pow(2, i) % 11) * parseInt(sId.charAt(17 - i), 11);
        if (iSum % 11 != 1) return false;
        //aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女");//此次还可以判断出输入的身份证号的人性别
        return true;
    }

    // 医院列表
    function bindingHospList() {
        $("#hospitalId").picker({
            title: "请选就诊人",
            cols: [
                {
                    textAlign: 'center',
                    values: ["包头市中心医院", "包头肿瘤医院", "包钢第三职工医院"]
                }
            ],
            onChange: function (p, v, dv) {
                console.log(p, v, dv);
            },
            onClose: function (p, v, d) {
                console.log("close");
            }
        });
    }


    // 保存绑定卡
    function bindingSaveCard() {

        $("#saveCardBt").click(function () {
            console.log(this);

//            var userid = $("#id").val();
            var idNum = $("#idNum").val();
            var hospitalName = $("#hospitalId").val();
            var cardNum = $("#cardNum").val();
            var patientId = $("#patientId").data("values");
            var pre_url = "/core/card/svbindcardYuYue";

            if(hospitalName == null || hospitalName == ''){
                layer.open({
                    content:"请选择医院"
                    ,skin: 'msg'
                    ,time: 3
                });
            }

            $.ajax({
                url: pre_url,
                type: 'POST',
                data: {"idNum":idNum,"hospitalName":hospitalName,"cardNum":cardNum,"patientId":patientId},
                dataType: 'json',
                timeout: 5000,
                error: function () { //出错处理
                    layer.open({
                        content:"系统异常，请重新操作"
                        ,skin: 'msg'
                        ,time: 3
                    });
                    setTimeout(function () {
                        layer.closeAll()
                    },1500);
                },
                //成功处理
                success: function (data) {                
                    if (data.message!="correct") {
                        //提示                       
                        layer.open({
                            content: data.message
                            ,skin: 'msg'
                            ,time: 3000
                        });
                        setTimeout(function () {
                            layer.closeAll()
                        },1500);
                    }else{
                        layer.open({
                            content: "绑卡成功"
                            ,skin: 'msg'
                            ,time: 3
                        });
                        setTimeout(function () {
                            layer.closeAll()
//                            window.location.reload(true)
                        },1500);
                    }
                }
            });

        });
    }
</script>
</body>
</html>