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
                values: ["包头中心医院", "包头肿瘤医院", "包头第一人民医院", "包头第二人民医院"]
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

        var _div = '' +
            '<div class="card-container">                                                              ' +
            '	<div class="card-content">                                                             ' +
            '		<div class="card-line-bar line-bar-start">                                         ' +
            '		<span class="line-left">                                                           ' +
            '			健康卡                                                                         ' +
            '		</span>                                                                            ' +
            '			<sapn class="line-right oncard-show">                                          ' +
            '				211021198702039911                                                         ' +
            '			</sapn>                                                                        ' +
            '		</div>                                                                             ' +
            '	</div>                                                                                 ' +
            '	<div class="card-content">                                                             ' +
            '		<div class="card-line-bar">                                                        ' +
            '		<span class="line-left">                                                           ' +
            '			医院                                                                           ' +
            '		</span>                                                                            ' +
            '			<sapn class="line-right oncard-show">                                          ' +
            '				包头市中心医院                                                             ' +
            '			</sapn>                                                                        ' +
            '		</div>                                                                             ' +
            '	</div>                                                                                 ' +
            '	<div class="card-content">                                                             ' +
            '		<div class="card-line-bar">                                                        ' +
            '		<span class="line-left">                                                           ' +
            '			条形码                                                                         ' +
            '		</span>                                                                            ' +
            '			<img class="card-bar-code" src="../../static/images/bar-code.jpg" alt="条形码">' +
            '		</div>                                                                             ' +
            '	</div>                                                                                 ' +
            '	<div class="card-content">                                                             ' +
            '		<div class="card-line-bar">                                                        ' +
            '		<span class="line-left">                                                           ' +
            '			二维码                                                                         ' +
            '		</span>                                                                            ' +
            '			<img class="card-qr-code" src="../../static/images/qr-code.png" alt="二维码">  ' +
            '		</div>                                                                             ' +
            '	</div>                                                                                 ' +
            '	<div class="card-content">                                                             ' +
            '		<div class="card-line-bar line-bar-end">                                           ' +
            '			<div class="save-bt">                                                          ' +
            '				解除绑定                                                                   ' +
            '			</div>                                                                         ' +
            '		</div>                                                                             ' +
            '	</div>                                                                                 ' +
            '</div>                                                                                    ';

        $(".card-list").children("div:first-child").remove();
        $(".card-list").prepend(_div);
        unbindingCard();//添加解除绑定事件
        bindingBarQRCode();

        $.toast("操作成功", function () {
            console.log('close');
        });
    });
}

// 解除绑定
function unbindingCard() {
    $(".save-bt").click(function () {
        // 调用ajax 成后执行
        $(this).parent().parent().parent().remove();
    });
}
unbindingCard();// 立即绑定

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