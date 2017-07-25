import $ from 'jquery'
import layer from '../../static/lib/layer.mobile-v2.0/layer_mobile/layer.js'

// var BASE_URL_HTML = "http://core.com/core";
var BASE_URL_HTML = "/core";
;
(function($) {
    var ajaxRequestWeb = {};

    ajaxRequestWeb.selAllCdc = function(obj) {//查询体检结构列表
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/selAllCdc',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }
    ajaxRequestWeb.selAppoinCount = function(obj) {//查询可以预约数量
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/selAppoinCount',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }
    ajaxRequestWeb.addAppoin = function(obj) {//预约提交
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/addAppoin',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }
    ajaxRequestWeb.selAppoint = function(obj) {//查看我的预约列表
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/selAppoint',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }
    ajaxRequestWeb.checkUser = function(obj) {//校验是否登录
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/checkUser',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                    window.location.href=BASE_URL_HTML+'/cdc/goByUser'
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }
    ajaxRequestWeb.selCdcById = function(obj) {//获取机构信息
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/selCdcById',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                    window.location.href=BASE_URL_HTML+'/cdc/goByUser'
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }

    ajaxRequestWeb.cancelAppoint = function(obj) {//取消预约
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/cancelAppoint',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }

    ajaxRequestWeb.selectWorkTypeDict = function(obj) {//查询工种
        var dtd = $.Deferred();
        $.ajax({
            url: BASE_URL_HTML + '/cdc/selectWorkTypeDict',
            data: obj,
            type: 'post',
            dataType: 'json',
            success: function(data) {
                if (data.state == 200) {
                    dtd.resolve(data);
                } else if (data.state == 500) {
                    dtd.reject(data.msg);
                    layer.open({
                      content: data.msg
                      ,skin: 'msg'
                      ,time: 3 
                    });
                }
            },
            error: function(data) {
                dtd.reject();
                layer.open({
                  content: data.msg
                  ,skin: 'msg'
                  ,time: 3 
                });
            }
        });
        return dtd.promise();
    }

    window.ajaxRequestWeb = ajaxRequestWeb;

})($);

export default window.ajaxRequestWeb;
