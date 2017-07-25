/**
 * Created by Administrator on 2016/8/15 0015.
 */
// rem 适配
var _cssText = document.querySelector("html").style.cssText;
document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";

//修改名称
function updateName() {
    var nameVal = $("#nameUpdateVal").val()
    alert(nameVal);
    // 调用ajax 保存数据

    $("#nameShowId").html(nameVal);
}
// 修改证件号码
function updateIdNum() {
    var idNumVal = $("#idNumUpdateVal").val()
    alert(idNumVal);
    // 调用ajax 保存数据

    $("#idNumShowId").html(idNumVal);
}

// 选择性别
$("#sexId").select({
    title: "选择性别",
    items: [{title: "男", value: "2"}, {title: "女", value: "2"}],
    onChange: function (d) {
        console.log(this, d);
        // 在这里调用ajax 后台保存方法
    },
    onClose: function () {
        console.log("close");
    },
    onOpen: function () {
        console.log("open");
    }
});

//选择出生日期
$("#birthdayId").calendar();

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
    },
    onOpen: function () {
        console.log("open");
    }
});

// 选择城市
$("#cityId").cityPicker({
    title: "选择城市",
    showDistrict: false
});

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

$("#bindingCardBt").click(function () {
    console.log("bindingCardBt...");
    var _div = '' +
        '<div class="card-container">                                                                                            ' +
        '	<div class="card-content">                                                                                           ' +
        '		<div class="card-line-bar">                                                                                      ' +
        '		<span class="line-left">                                                                                         ' +
        '			医院                                                                                                         ' +
        '		</span>                                                                                                          ' +
        '			<sapn class="line-right">                                                                                    ' +
        '			<span>                                                                                                       ' +
        '				<input type="text" class="content-input" value="" id="hospitalId" placeholder="选择医院" readonly="">    ' +
        '			</span>                                                                                                      ' +
        '				<i class="fa fa-angle-right fa-lg"></i>                                                                  ' +
        '			</sapn>                                                                                                      ' +
        '		</div>                                                                                                           ' +
        '	</div>                                                                                                               ' +
        '	<div class="card-content">                                                                                           ' +
        '		<div class="card-line-bar line-bar-start">                                                                       ' +
        '		<span class="line-left">                                                                                         ' +
        '			健康卡                                                                                                       ' +
        '		</span>                                                                                                          ' +
        '			<sapn class="line-right">                                                                                    ' +
        '				<input type="text" class="content-input" value="" id="cardNum" placeholder="填写卡号">                   ' +
        '			</sapn>                                                                                                      ' +
        '		</div>                                                                                                           ' +
        '	</div>                                                                                                               ' +
        '	<div class="card-content">                                                                                           ' +
        '		<div class="card-line-bar">                                                                                      ' +
        '		<span class="line-left">                                                                                         ' +
        '			条形码                                                                                                       ' +
        '		</span>                                                                                                          ' +
        '			<sapn class="line-right">                                                                                    ' +
        '				保存后自动生成                                                                                           ' +
        '			</sapn>                                                                                                      ' +
        '		</div>                                                                                                           ' +
        '	</div>                                                                                                               ' +
        '	<div class="card-content">                                                                                           ' +
        '		<div class="card-line-bar">                                                                                      ' +
        '		<span class="line-left">                                                                                         ' +
        '			二维码                                                                                                       ' +
        '		</span>                                                                                                          ' +
        '			<sapn class="line-right">                                                                                    ' +
        '				保存后自动生成                                                                                           ' +
        '			</sapn>                                                                                                      ' +
        '		</div>                                                                                                           ' +
        '	</div>                                                                                                               ' +
        '	<div class="card-content">                                                                                           ' +
        '		<div class="card-line-bar line-bar-end">                                                                         ' +
        '			<div class="save-bt" id="saveCardBt">                                                                                        ' +
        '				保存                                                                                                     ' +
        '			</div>                                                                                                       ' +
        '		</div>                                                                                                           ' +
        '	</div>                                                                                                               ' +
        '</div>                                                                                                                  ';


    $(".card-list").prepend(_div);
    bindingHospList();
    bindingSaveCard();
});

// 保存绑定卡
function bindingSaveCard() {

    $("#saveCardBt").click(function () {
        console.log(this);
        
        var userid = $("#id").val();
        var idNum = $("#idNum").val();
        var hospitalName = $("#hospitalId").val();
        var cardNum = $("#cardNum").val();
        var patientId = $("#patientId").val();
        var pre_url = "/core/card/svbindcard";
        
        //注册
        $.ajax({
            url: pre_url,
            type: 'POST',
            data: {"userid":userid,"idNum":idNum,"hospitalName":hospitalName,"cardNum":cardNum,"patientId":patientId},
            dataType: 'json',
            timeout: 5000,
            beforeSend:function(){
            	var index = layer.load(3);
           },
            error: function () { //出错处理  
            	layer.msg("系统异常，请重新操作", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
            	 setTimeout(getNow,1500);
            },
            //成功处理
            success: function (data) {
            	if (data.message!="correct") {
            		layer.msg(data.message, {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
            		 setTimeout(getNow,1500);
                }else{
					layer.msg("绑卡成功", {icon: 6, shadeClose: true, shade: 0.5, time: 1500});
            		 setTimeout(getNow,1500);
				} 
            }
        });
        
    });
}

//刷新当前页面
function getNow(){
	window.location.href= "/core/user/toAddPatient?flag=3&patientId=" + $("#patientId").val();
}
// 解除绑定

    $(".save-bt").click(function () {
        // 调用ajax 成后执行
    	var mzh  = $(this).parent().parent().parent().find("#getMZh").text();
    	var hospitalName  = $(this).parent().parent().parent().children(":first").find("#getHospitalName").text().trim();
    	var userid = $("#id").val();
    	var idNum = $("#idNum").val();
    	var patientId = $("#patientId").val();
    	var pre_url = "/core/card/delbindcard";
    	$.ajax({
            url: pre_url,
            type: 'POST',
            data: {"mzh":mzh,"hospitalName":hospitalName,"userid":userid,"idNum":idNum,"patientId":patientId},
            dataType: 'json',
            timeout: 5000,
            error: function () { //出错处理  
            },
            //成功处理
            success: function (data) {
            	if (data.sate=="200") {
            		 layer.msg(data.message, {icon: 6, shadeClose: true, shade: 0.5, time: 1500});
                } else {
                	layer.msg(data.message, {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
					setTimeout(getNow,1500);
                }
            }
        });
    });



//条形码
function bindingBarQRCode() {
    $(".card-bar-code").unbind("click").click(function () {
        console.log($(this).attr("src"));
        var _src = $(this).attr("src");
        previewImg(_src);
    });
    $(".card-qr-code").unbind("click").click(function () {
        console.log($(this).attr("src"));
        var _src = $(this).attr("src");
        previewImg(_src);
    });
}
bindingBarQRCode();

function previewImg(src) {
    var ps = $.photoBrowser({
        items: [
            src
        ],
        onSlideChange: function (index) {
            console.log(this, index);
        },

        onOpen: function () {
            console.log("onOpen", this);
        },
        onClose: function () {
            console.log("onClose", this);
        }
    });
    ps.open();
}

//新增就诊人信息保存
$("#myinfoSaveBt").click(function () {
    
});

function delPatient(){
	var patientId = $("#patientId").val();
	var otype = $("#otype").val();
	var idNum = $("#idNum").val();
	if(otype==1){
		layer.msg("本人信息，不可删除", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
	}else{
	    $.confirm("您确定要删除该条数据吗?", "确认删除?", function() {
	    	window.location.href="delPatient?patientId="+patientId+"&idNum="+idNum;
	    }, function() {
	        //取消操作
	    });
	}
};


$("#searchDoctorBt").click(function(){
	var name = document.getElementById("name").value;
    var cityId = document.getElementById("cityId").value;
    var patientId = document.getElementById("patientId").value;
    var ajaxURL = "updatePatient";
    var result;
    $.ajax({
        type: "POST",
        async: false,
        data: {"name": name, "city": cityId,"patientId":patientId},
        url: ajaxURL,
        dataType: "json",
        success: function (data) {
			layer.msg("保存成功", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
            $("name").val(data.name);
            $("cityId").val(data.city);
        }
    });
})


$("#backBt").click(function () {
	window.location.href = "/core/user/checkUserInfor";
});