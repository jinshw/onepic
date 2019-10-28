//应用程序公共初始化模块
define(function (require, exports, module) {
    //全局模块句柄类

    var HttpConvert = (function () {

        var BASE_URL = BaseObject.adminUrl;



        var conllection = {
            search: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            searchByTree: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            searchTreeByPID: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}&&relationId=#{RELATION_GUID}",
            get: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{GUID}/#{REMOTE_METHOD}",
            getTemplate: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?#{FILTER_PARAMENTER}",
            searchByKeyword: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            add: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            update: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            mDelete: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{GUID}/#{REMOTE_METHOD}",
            searchByRelation: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}&relationId=#{RELATION_GUID}&relationType=#{RELATION_TYPE}",
            deleteRelation: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            addRelation: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}&relationId=#{RELATION_GUID}",
            searchByTreeRelation: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}&relationId=#{RELATION_GUID}&relationType=#{RELATION_TYPE}",
            getViewerHtml: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}"
        }

        var config = {};

        config.getURI = function (parameter) {

            var method = parameter.REMOTE_METHOD;
            if (method == "delete") method = "mDelete";
            var item = conllection[method];
            parameter.REMOTE_METHOD = parameter.REMOTE_METHOD + ".do";
            if (item) {
                item = item.replace("#{RESOURCE_NAME}", parameter.RESOURCE_NAME).
                replace("#{RETURE_TYPE}", parameter.RETURE_TYPE).
                replace("#{START}", parameter.START).
                replace("#{LIMIT}", parameter.LIMIT).
                replace("#{GUID}", parameter.GUID).
                replace("#{RELATION_GUID}", parameter.RELATION_GUID).
                replace("#{RELATION_TYPE}", parameter.RELATION_TYPE).
                replace("#{REMOTE_METHOD}", parameter.REMOTE_METHOD).
                replace("#{FILTER_PARAMENTER}", parameter.FILTER_PARAMENTER);
            }
            return item;
        }

        config.URIConllection = function () {

            return conllection;
        }

        return config;

    })();

    DFastUI_Map.Remote.Service = function () { };
    DFastUI_Map.Remote.Service.prototype = ({


        //构造函数
        initialize: function () {
        },

        getURI: function (id, parameter) {
            var url = HttpConvert.getURI(id, parameter);
            return url;
        },


        execute: function (parameter, callback) {
            var url = HttpConvert.getURI(parameter);
            this.ajax(url, callback);
        },



        ajax: function (url, callback) {
            $.ajax({
                url: encodeURI(url),
                type: "get",
                dataType: 'jsonp',
                jsonp: 'jsoncallback',
                data: null,
                timeout: 0,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (result) {
                    callback(result)
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    callback({
                        status: 0,
                        mssage: textStatus
                    });
                    alert(errorThrown)
                }
            })
        },

        CLASS_NAME: "DFastUI_Map.Remote.Service"
    });
    module.exports = new DFastUI_Map.Remote.Service;
});
$.ajaxSetup({
    contentType: "application/x-www-form-urlencoded; charset=utf-8"
});

 
