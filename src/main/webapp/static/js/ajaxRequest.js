var BASE_URL_HTML = "/onepic";
;(function($){
	var ajaxRequest = {};

	ajaxRequest.getStake = function(obj){//获取桩号
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/main/getStake',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.status==200){
					dtd.resolve(data);
				}else if(data.status==500){
					dtd.reject(data.message);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.initRoadDict = function(obj){//获取桩号
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/main/initRoadDict',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.status==200){
					dtd.resolve(data);
				}else if(data.status==500){
					dtd.reject(data.message);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getRoud = function(obj){//获取桩号
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/main/getRoud',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.status==200){
					dtd.resolve(data);
				}else if(data.status==500){
					dtd.reject(data.message);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}
	ajaxRequest.getPointsByLocation = function(obj){//获取临近的两个桩号
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/main/getPointsByLocation',
			data:obj,
			type:'post',
			dataType:'json',
			success:function(data){
				if(data.status==200){
					dtd.resolve(data);
				}else if(data.status==500){
					dtd.reject(data.message);
				}
			},
			error : function() {
				dtd.reject();
			}
		});
		return dtd.promise();
	}




	window.ajaxRequest = ajaxRequest;
})($);