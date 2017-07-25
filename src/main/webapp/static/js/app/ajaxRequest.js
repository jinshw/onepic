var BASE_URL_HTML = "/core";
;(function($){
	var ajaxRequest = {};

	ajaxRequest.getPatientList = function(obj){//获取就诊人列表
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/billApp/getPatientList',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getHospitalList = function(obj){//获取医院列表
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/billApp/getHospitalList',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getPayList = function(obj){//获取支付列表（支付和未支付）
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/billApp/getPayList',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.toDetailPage = function(obj){//跳转到详情页
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/billApp/toDetailPage',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.addSysMessage = function(obj){//添加系统消息
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/megs/addSysMessage',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getPaidList = function(obj){//获取已支付列表信息（非中心医院）
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/billApp/getPaidList',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	/*******************诊间支付*******************/
	/******************************************** 华丽的分界线 ********************************************/
	/*******************预约挂号*******************/
	ajaxRequest.getHospPageList = function(obj){//医院列表分页查询
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/hospPageList',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				/*if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}*/
				dtd.resolve(data);
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getAjaxSeachHistory = function(obj){//切换历史
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/getAjaxSearchHistory',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getAjaxAttention = function(obj){//切换关注
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/getAjaxAttention',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getAjaxDelete = function(obj){//清除所有
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/cleanHistoryRecord',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getAjaxFollow = function(obj){//点击关注
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/lookAjaxFollow',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getAjaxCare = function(obj){//关注列表
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/app/getFollowList',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.delAjaxCare = function(obj){//删除关注列表
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/app/deleteFollow',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getAjaxLikeDocName = function(obj){//下拉刷新查询根据医生名字查询信息
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/getAjaxDoctorLikeDocName',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getDrRegScheduleInfoByDate = function(obj){//获取对应日期的医生挂号班别信息（非中心医院）
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/getDrRegScheduleInfoByDate',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				console.log(data);
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.cancelAppointOrder = function(obj){//取消订单支付
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/cancelAppointOrder',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
//				if(data.state==200){
					dtd.resolve(data);
//				}else if(data.state==500){
//					dtd.reject(data.msg);
//					$.toast(data.msg, "forbidden");
//				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.refund = function(obj){//订单退款
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/refund',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				console.log(data);
//				if(data.state==200){
					dtd.resolve(data);
//				}else if(data.state==500){
//					dtd.reject(data.msg);
////					$.toast(data.msg, "forbidden");
//					$.alert(data.msg, "提示");
//				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.orderdetails = function(obj){//订单详情
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/appointApp/initAppointAjaxOrderList',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				console.log(data);
				if(data.state==200){
					dtd.resolve(data);
				}else if(data.state==500){
					dtd.reject(data.msg);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	/*******************预约挂号*******************/
	/******************************************** 华丽的分界线 ********************************************/
	/*******************发现更多*******************/
	ajaxRequest.checkLogin = function(obj){//检查用户是否登录
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/findMoreApp/checkLogin',
			data:obj,
			type:'post',
			dataType:'text',
			success:function(data){
				console.log(data);
				dtd.resolve(data);
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.checkPatient = function(obj){//检查是否绑定就诊人
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/findMoreApp/checkPatient',
			data:obj,
			type:'post',
			dataType:'text',
			success:function(data){
				console.log(data);
				dtd.resolve(data);
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	window.ajaxRequest = ajaxRequest;
})($);