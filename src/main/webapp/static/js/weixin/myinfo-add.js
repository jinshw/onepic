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

//新增就诊人信息保存
$("#myinfoSaveBt").click(function () {
	var flag = $("#flag").val();
	var name =  $("#name").val();
	var idTypeId =  $("#idTypeId").val();
	var idNum =  $("#idNum").val();
	var cityId =  $("#cityId").val();
		if(name==null||name==""){
		layer.msg("请填写姓名", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
		return;
	}
	if(idTypeId==null||idTypeId==""){
		layer.msg("请选择身份类型", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
		return;
	}
	if(idTypeId==null||idTypeId==""){
		layer.msg("请选择身份类型", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
		return;
	}
	if(!isCardID(idNum)){
		layer.msg("身份证格式不正确", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
		return;
	}
	if(cityId==null||cityId==""){
		layer.msg("请选择所在地", {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
		return;
	}
	if(flag==1){
		document.getElementById("myform").action = "/core/user/savepatient";
	}else{
		document.getElementById("myform").action = "/core/user/saveUserInfor";
	}
    $("#myform").submit();
});

function isCardID(sId){
	var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};
	 var iSum=0 ;
	 var info="" ;
	 if(!/^\d{17}(\d|x)$/i.test(sId)) return false;
	 sId=sId.replace(/x$/i,"a");
	 if(aCity[parseInt(sId.substr(0,2))]==null) return false;
	 sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2));
	 var d=new Date(sBirthday.replace(/-/g,"/")) ;
	 if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))return false;
	 for(var i = 17;i>=0;i --) iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;
	 if(iSum%11!=1) return false;
	 //aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女");//此次还可以判断出输入的身份证号的人性别
	 return true;
	}
$(function() {
	var flag = $("#flag").val();
	if(flag==3){
		document.getElementById("idNum").readOnly=true;
	}
	var retMsg = $("#retMsg").val(); 
  if(retMsg!=null&&retMsg!=""){
	  layer.msg(retMsg, {icon: 7, shadeClose: true, shade: 0.5, time: 1500});
  }
});

$("#backBt").click(function () {
	window.location.href = "/core/user/checkUserInfor";
});