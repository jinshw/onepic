var BASE_URL_HTML = "/onepic";
;
(function($) {
    var ajaxRequest = {};

    ajaxRequest.getStake = function(obj) {// 获取桩号
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/main/getStake',
	    data : obj,
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    dtd.reject(data.message);
		}
	    },
	    error : function() {
		dtd.reject();
	    }
	});
	return dtd.promise();
    }
    ajaxRequest.initRoadDict = function(obj) {// 获取桩号
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/main/initRoadDict',
	    data : obj,
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    dtd.reject(data.message);
		}
	    },
	    error : function() {
		dtd.reject();
	    }
	});
	return dtd.promise();
    }
    ajaxRequest.getRoud = function(obj) {// 获取桩号
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/main/getRoud',
	    data : obj,
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    dtd.reject(data.message);
		}
	    },
	    error : function() {
		dtd.reject();
	    }
	});
	return dtd.promise();
    }
    ajaxRequest.getPointsByLocation = function(obj) {// 获取临近的两个桩号
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/main/getPointsByLocation',
	    data : obj,
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    dtd.reject(data.message);
		}
	    },
	    error : function() {
		dtd.reject();
	    }
	});
	return dtd.promise();
    }

    ajaxRequest.insertPlot = function(obj) {// 新增标注
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/plot/insert',
	    data : obj,
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    dtd.reject(data.message);
		}
	    },
	    error : function() {
		dtd.reject();
	    }
	});
	return dtd.promise();
    }

    ajaxRequest.findPlot = function(obj) {// 查询标注
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/plot/find',
	    data : obj,
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    dtd.reject(data.message);
		}
	    },
	    error : function() {
		dtd.reject();
	    }
	});
	return dtd.promise();
    }

    ajaxRequest.checkall = function(obj) {// 查询标注
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/hd/checkall',
	    data : {
		id : obj
	    },
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    dtd.reject(data.message);
		}
	    },
	    error : function() {
		dtd.reject();
	    }
	});
	return dtd.promise();
    }

    ajaxRequest.deletePlot = function(obj) {// 删除
	var dtd = $.Deferred();
	$.ajax({
	    url : BASE_URL_HTML + '/plot/delete',
	    data : obj,
	    type : 'post',
	    dataType : 'json',
	    success : function(data) {
		if (data.status == 200) {
		    dtd.resolve(data);
		} else if (data.status == 500) {
		    layer.msg(data.message)
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