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

//到绑卡页面
$(".pat-list .line-bar-detail").click(function () {
	console.log($(this).children("span"));
	var patientId = $(this).children("div").children("input").val()
    window.location.href = "toAddPatient?patientId="+patientId+"&flag=3";
});


$("#backBt").click(function () {
		window.jsobj.back(4);
});
