/**
 * Created by jinshw on 2016/7/30.
 */
var _saveDetailMap = {},
    _saveNotPayMap = {},
    _savePayMap = {};


var _cssText = document.querySelector("html").style.cssText;
document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 414 + "px !important";

$("#showTooltips").click(function () {
    var tel = $('#tel').val();
    var code = $('#code').val();
    if (!tel || !/1[3|4|5|7|8]\d{9}/.test(tel)) $.toptip('请输入手机号');
    else if (!code || !/\d{6}/.test(code)) $.toptip('请输入六位手机验证码');
    else $.toptip('提交成功', 'success');
});

var patientListItems = [];
$("#payStateHidden").val("notPay");
var hospitalListItems = [];
ajaxRequest.getHospitalList().then(function (resp) {
    if (resp.state == 200) {
        console.log("获取医院列表成功", resp);
        for (var j = 0; j < resp.list.length; j++) {
            hospitalListItems.push({title: resp.list[j].hospitalName, value: resp.list[j].hospitalId});
        }
        $("#hospitalList").select({
            title: "选择医院",
            items: hospitalListItems,
            onClose: function () {
                console.log("close...");
            },
            onChange: function (d) {
                // 重置就诊人输入条件
                $("#patientList").val("");
                var patientListItems = [];
            	ajaxRequest.getPatientList({hospitalId: d.values}).then(function (data) {
                    if (data.state == 200) {
                        console.log("成功！", data);
                        for (var i = 0; i < data.list.length; i++) {
                            patientListItems.push({
                                title: data.list[i].patientname + "  " + data.list[i].medicalcard,
                                value: data.list[i].medicalcard
                            });
                        }
                        $("#patientList").select({
                            title: "选择就诊人",
                            items: patientListItems,
                            onChange: function (d) {
                                console.log("就诊人onChange.......");
                                // 获取列表数据
                                var _payState = $("#payStateHidden").val();
                                var _patientCode = $("#patientList").data("values");
                                var _hospitalId = $("#hospitalList").data("values");
                                var medicalcard = $("#patientList").data("values");

                                $.showLoading();
                                
                                //获取支付列表（已支付和未支付）
                                ajaxRequest.getPayList({
                                    payState: _payState,
                                    patientCode: _patientCode,
                                    hospitalId: _hospitalId,
                                    medicalcard: medicalcard
                                }).then(function (respData) {
                                    console.log("respData==\n", respData);
                                    if (_hospitalId == '000001') {
                                        getPayListDatas(respData);
                                    } else {
                                        getNotPayListDatas(respData);
                                    }
                                    $.hideLoading();
                                });
                            },
                            onClose: function () {
                                console.log("关闭");
                            },
                            onOpen: function () {
                                console.log("open");
                            }
                        });
                        $("#patientList").select("update", {items: patientListItems});
                        
                        if(d.values != "000001"){
                            layer.msg("即将开放，敬请期待！", {icon: 5, shadeClose: true, shade: 0.5, time: 1800});
                            $("#notPayList").empty();
                            $("#alreadyPayList").empty();
                            $("#patientList").select("update", {items: []});
                        }
                    } else {
                        console.log("获取就诊人列表失败！");
                    }
                });
            }
        });

    } else {
        console.log("获取医院列表失败");
    }
});

/**
 * 获取中心医院数据
 * @param respData
 */
function getPayListDatas(respData) {
    var list = respData.list;
    var brid = respData.brid;
    var _djObj;
    var payDiv = '', notPayDiv = '', alreadyPayDiv = '';
//    var yzList, yzObj;
    for (var i = 0; i < list.length; i++) {
        _djObj = list[i];

//        yzList = list[i].payInfoYZZXBeanList;
//        for (var j = 0; j < yzList.length; j++) {
//        	yzObj = yzList[j];
//        }

        _djObj.hospitalId = $("#hospitalList").data("values");
        _djObj.hospitalName = $("#hospitalList").val();
        _djObj.patientId = $("#patientList").data("values");
        _djObj.patientName = $("#patientList").val().split("  ")[0];
        _saveDetailMap[i] = JSON.stringify(_djObj);
        payDiv = '<div class="weui_cells table-tr" data-list="' + i + '">' +
            '<div class="weui_cell">' +
            '<div class="weui_cell_bd weui_cell_primary ">' +
            '<p>' + _djObj.djh + '</p>' +
            '<p>开单科室：' + _djObj.kdks + '</p>';
        if (_djObj.djZfzt == "0") {
            payDiv = payDiv + "<p>状态：待付</p>" +
                '</div>' +
                '<div class="weui_cell_ft">' + _djObj.djJe + '元</div>' +
                '</div>' +
                '</div>';
            notPayDiv = notPayDiv + payDiv;
        } else if (_djObj.djZfzt == "1") {
            payDiv = payDiv + "<p>状态：已支付</p>" +
                '</div>' +
                '<div class="weui_cell_ft">' + _djObj.djJe + '元</div>' +
                '</div>' +
                '</div>';
            alreadyPayDiv = alreadyPayDiv + payDiv;
        } else if (_djObj.djZfzt == "2") {
        	payDiv = payDiv + "<p>状态：已退款</p>" +
            '</div>' +
            '<div class="weui_cell_ft">' + _djObj.djJe + '元</div>' +
            '</div>' +
            '</div>';
        	alreadyPayDiv = alreadyPayDiv + payDiv;
        }
    }
    $("#notPayList").html(notPayDiv);
    $("#alreadyPayList").html(alreadyPayDiv);

    $(".table-tr").click(function () {
        console.log(this);
        $(this).css("background-color", "#f3f2f2");
        var payStateHidden = $("#payStateHidden").val();
        var _value = $(this).data("list");

        console.log("_value===", _value);
        console.log("value===", _saveDetailMap[_value]);

        var hospitalId = $("#hospitalList").data("values");

        //检查是否登录
		ajaxRequest.checkLogin().then(function (resp) {
			if(resp == '0') {
				// 包头市中心医院 （特殊：一次调用全部返回）
		        if (hospitalId == "000001") {
		            // 创建Form
		            var form = $('<form></form>');
		            // 设置属性
		            if (payStateHidden == "notPay") {
		                form.attr('action', "toDetailPage");
		            } else if (payStateHidden == "alreadyPay") {
		                form.attr('action', "toDetailAlreadyPage");
		            }
		            form.attr('method', 'post');
		            // form的target属性决定form在哪个页面提交
		            // _self -> 当前页面 _blank -> 新页面
		            form.attr('target', '_self');
		            // 创建Input
		            var my_input = $("<input type='text' name='list' />");
		            var code = $("<input type='text' name='code' />");
		            var bridInput = $("<input type='text' name='brid'/>");
		            my_input.attr('value', _saveDetailMap[_value]);
		            code.attr('value', CODE_VALUE);
		            bridInput.attr('value', brid);
		            // 附加到Form
		            form.append(my_input);
		            form.append(code);
		            form.append(bridInput);
		            // 提交表单
		            form.submit();
		        }
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

/**
 * 获取未支付订单列表（非中心医院）
 * @param respData
 */
function getNotPayListDatas(respData) {
    var list = respData.list;
    var brid = respData.brid;
    var _djObj;
    var payDiv = '', notPayDiv = '', alreadyPayDiv = '';
    var fmList, fmObj;
    for (var i = 0; i < list.length; i++) {
        _djObj = list[i];
        _djObj.hospitalId = $("#hospitalList").data("values");
        _djObj.hospitalName = $("#hospitalList").val();
        _djObj.patientId = $("#patientList").data("values");
        _djObj.patientName = $("#patientList").val();


        _saveNotPayMap[i] = JSON.stringify(_djObj);
        notPayDiv = notPayDiv + '<div class="weui_cells table-tr" data-list="' + i + '">' +
            '<div class="weui_cell">' +
            '<div class="weui_cell_bd weui_cell_primary ">' +
            '<p>' + _djObj.clinicSeq + '</p>' +
            '<p>开单科室：' + _djObj.deptName + '</p>' +
            "<p>状态：待付</p>" +
            '</div>' +
            '<div class="weui_cell_ft">' + _djObj.payAmout + '元</div>' +
            '</div>' +
            '</div>';
    }
    $("#notPayList").html(notPayDiv);
    // $("#alreadyPayList").html(alreadyPayDiv);

    $("#notPayList .table-tr").click(function () {
        console.log(this);
        $(this).css("background-color", "#f3f2f2");
        var payStateHidden = $("#payStateHidden").val();
        var _value = $(this).data("list");

        console.log("_value===", _value);
        console.log("value===", _saveNotPayMap[_value]);

        var hospitalId = $("#hospitalList").data("values");
        var medicalcard = $("#patientList").data("values");
        var hospitalName = $("#hospitalList").val();
        var patientName = $("#patientList").val();

      //检查是否登录
		ajaxRequest.checkLogin().then(function (resp) {
			if(resp == '0') {
				// 创建Form
		        var form = $('<form></form>');
		        // 设置属性
		        form.attr('action', "getNoPayDetail");
		        form.attr('method', 'post');
		        // form的target属性决定form在哪个页面提交
		        // _self -> 当前页面 _blank -> 新页面
		        form.attr('target', '_self');
		        // 创建Input
		        var my_input = $("<input type='text' name='list' />");
		        var code = $("<input type='text' name='code' />");
		        var bridInput = $("<input type='text' name='patientId'/>");
		        var healthCardNo = $("<input type='text' name='healthCardNo'/>");
		        var hospitalNameInput = $("<input type='text' name='hospitalName'/>");
		        var patientNameInput = $("<input type='text' name='patientName'/>");
		        my_input.attr('value', _saveNotPayMap[_value]);
		        code.attr('value', CODE_VALUE);
		        bridInput.attr('value', brid);
		        healthCardNo.attr('value', medicalcard);
		        hospitalNameInput.attr('value', hospitalName);
		        patientNameInput.attr('value', patientName);
		        // 附加到Form
		        form.append(my_input);
		        form.append(code);
		        form.append(bridInput);
		        form.append(healthCardNo);
		        form.append(hospitalNameInput);
		        form.append(patientNameInput);
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

/**
 * 获取已支付列表（非中心医院）
 * @param respData
 */
function getPayList(respData) {
    var list = respData.list;
    var brid = respData.brid;
    var _djObj;
    var alreadyPayDiv = '';
    var fmList, fmObj;
    for (var i = 0; i < list.length; i++) {
        _djObj = list[i];
        _djObj.hospitalId = $("#hospitalList").data("values");
        _djObj.hospitalName = $("#hospitalList").val();
        _djObj.patientId = $("#patientList").data("values");
        _djObj.patientName = $("#patientList").val();


        _savePayMap[i] = JSON.stringify(_djObj);
        alreadyPayDiv = alreadyPayDiv + '<div class="weui_cells table-tr" data-list="' + i + '">' +
            '<div class="weui_cell">' +
            '<div class="weui_cell_bd weui_cell_primary ">' +
            '<p>' + _djObj.clinicSeq + '</p>' +
            '<p>开单科室：' + _djObj.deptName + '</p>' +
            "<p>状态：已付</p>" +
            '</div>' +
            '<div class="weui_cell_ft">' + _djObj.payAmout + '元</div>' +
            '</div>' +
            '</div>';
    }
    $("#alreadyPayList").html(alreadyPayDiv);

    $("#alreadyPayList .table-tr").click(function () {
        console.log(this);
        $(this).css("background-color", "#f3f2f2");
        var payStateHidden = $("#payStateHidden").val();
        var _value = $(this).data("list");

        console.log("_value===", _value);
        console.log("value===", _savePayMap[_value]);

        var hospitalId = $("#hospitalList").data("values");
        var medicalcard = $("#patientList").data("values");
        var hospitalName = $("#hospitalList").val();
        var patientName = $("#patientList").val();

        //检查是否登录
		ajaxRequest.checkLogin().then(function (resp) {
			if(resp == '0') {
				// 创建Form
		        var form = $('<form></form>');
		        // 设置属性
		        form.attr('action', "getPaidDetail");
		        form.attr('method', 'post');
		        // form的target属性决定form在哪个页面提交
		        // _self -> 当前页面 _blank -> 新页面
		        form.attr('target', '_self');
		        // 创建Input
		        var my_input = $("<input type='text' name='list' />");
		        var code = $("<input type='text' name='code' />");
		        var bridInput = $("<input type='text' name='patientId'/>");
		        var healthCardNo = $("<input type='text' name='healthCardNo'/>");
		        var hospitalNameInput = $("<input type='text' name='hospitalName'/>");
		        var patientNameInput = $("<input type='text' name='patientName'/>");
		        my_input.attr('value', _saveNotPayMap[_value]);
		        // my_input.attr('value', _savePayMap[_value]);
		        code.attr('value', CODE_VALUE);
		        bridInput.attr('value', brid);
		        healthCardNo.attr('value', medicalcard);
		        hospitalNameInput.attr('value', hospitalName);
		        patientNameInput.attr('value', patientName);
		        // 附加到Form
		        form.append(my_input);
		        form.append(code);
		        form.append(bridInput);
		        form.append(healthCardNo);
		        form.append(hospitalNameInput);
		        form.append(patientNameInput);
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

$("#notPayBt").click(function () {
    $(this).css("border-bottom", "2px solid #2ed0bb");
    $("#alreadyPayBt").css("border-bottom", "");

    $("#alreadyPayList").css("display", "none");
    $("#notPayList").css("display", "block");
    $("#payStateHidden").val("notPay");

    var _hospitalId = $("#hospitalList").data("values");
    var medicalcard = $("#patientList").data("values");
    if (_hospitalId == null){
        layer.msg("请选择就诊医院", {icon: 5, shadeClose: true, shade: 0.5, time: 1800});
        return false;
    }
    if(medicalcard == null){
        layer.msg("请选择就诊人", {icon: 5, shadeClose: true, shade: 0.5, time: 1800});
        return false;
    }

    /*
     $(this).removeClass("weui_btn_default").addClass("weui_btn_primary");
     $("#alreadyPayBt").removeClass("weui_btn_primary").addClass("weui_btn_default");
     $("#alreadyPayList").css("display", "none");
     $("#notPayList").css("display", "block");
     */
});
$("#alreadyPayBt").click(function () {
//	        $(this).removeClass("weui_btn_default").addClass("weui_btn_primary");
//	        $("#notPayBt").removeClass("weui_btn_primary").addClass("weui_btn_default");
    $(this).css("border-bottom", "2px solid #2ed0bb");
    $("#notPayBt").css("border-bottom", "");
    $("#alreadyPayList").css("display", "block");
    $("#notPayList").css("display", "none");
    $("#payStateHidden").val("alreadyPay");
    var _hospitalId = $("#hospitalList").data("values");
    var medicalcard = $("#patientList").data("values");

    if (_hospitalId == null){
        layer.msg("请选择就诊医院", {icon: 5, shadeClose: true, shade: 0.5, time: 1800});
        return false;
    }
    if(medicalcard == null){
        layer.msg("请选择就诊人", {icon: 5, shadeClose: true, shade: 0.5, time: 1800});
        return false;
    }

    if(_hospitalId == '000001') {
    	
    } else {
    	/*ajaxRequest.getPaidList({hospitalId: _hospitalId, medicalcard: medicalcard}).then(function (data) {
            getPayList(data);
        });*/
    }
});

function bindRefundClick(){
	$("#refund").click(function () {
		var that = this;
		$.confirm("您确定要退费吗?", "确认?", function() {
			var _billOrderId = $(that).data("flag");
			ajaxRequest.billRefund({billOrderId: _billOrderId}).then(function (data){
				if(data.state==200){
					console.log("订单退费数据",data);
	        		$(that).remove();
	        		$.toast("费用已退还!");
				} else if(data.state==500){
					$.alert(data.msg, "提示");
				}
			});
		} , function() {
	          //取消操作
        });
	});
}

/**
 * 乘法运算，避免数据相乘小数点后产生多位数和计算精度损失。
 * 
 * @param num1被乘数 | num2乘数
 */
function numMulti(num1, num2) {
	var baseNum = 0;
	try {
		baseNum += num1.toString().split(".")[1].length;
	} catch (e) {
	}
	try {
		baseNum += num2.toString().split(".")[1].length;
	} catch (e) {
	}
	return Number(num1.toString().replace(".", "")) * Number(num2.toString().replace(".", "")) / Math.pow(10, baseNum);
};