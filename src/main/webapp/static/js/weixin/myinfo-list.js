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
    items: [{title:"男",value:"2"},{title:"女",value:"2"}],
    onChange: function(d) {
        console.log(this, d);
        // 在这里调用ajax 后台保存方法
    },
    onClose: function() {
        console.log("close");
    },
    onOpen: function() {
        console.log("open");
    }
});

//选择出生日期
$("#birthdayId").calendar();

// 选择证件类型
$("#idTypeId").select({
    title: "选择证件类型",
    items: [{title:"身份证",value:"1"}],
    onChange: function(d) {
        console.log(this, d);
        // 在这里调用ajax 后台保存方法
    },
    onClose: function() {
        console.log("close");
    },
    onOpen: function() {
        console.log("open");
    }
});

// 选择城市
$("#cityId").cityPicker({
    title: "选择城市",
    showDistrict: false
});


// 长按事件
$.fn.longPress = function(fn) {
    var timeout = undefined;
    var $this = this;
    for(var i = 0;i<$this.length;i++){
        $this[i].addEventListener('touchstart', function(event) {
            timeout = setTimeout(fn, 800);
        }, false);
        $this[i].addEventListener('touchend', function(event) {
            clearTimeout(timeout);
        }, false);
    }
}
//删除就诊人
$(".pat-list .line-bar-detail").longPress(function(){
    $.confirm("您确定要删除该条数据吗?", "确认删除?", function() {
        $.toast("文件已经删除!");
    }, function() {
        //取消操作
    });
});

//添加就诊人
$("#addPatBt").click(function () {

    window.location.href = "myinfo-add.html";
});

//就诊人信息修改
$(".pat-list .line-bar-detail").click(function () {
    window.location.href = "myinfo-oncard.html";
});