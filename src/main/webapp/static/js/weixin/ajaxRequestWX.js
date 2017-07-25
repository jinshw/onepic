var BASE_URL_HTML = "/core";
;(function($){
	var ajaxRequest = {};

	ajaxRequest.getPatientList = function(obj){//获取就诊人列表
		var dtd = $.Deferred();
		$.ajax({
			url:BASE_URL_HTML+'/bill/getPatientList',
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
	

	window.ajaxRequest = ajaxRequest;
})($);