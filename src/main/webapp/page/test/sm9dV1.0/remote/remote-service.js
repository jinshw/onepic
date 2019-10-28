//应用程序公共初始化模块
var requireHandler = null;
define(function (require, exports, module) {
    //全局模块句柄类
    requireHandler = require;
    var HttpConvert = (function () {
        var BASE_URL = BaseObject.adminUrl;
        var BASE_URL1 = BaseObject.mapDataEidtBusiUrl;
        var conllection = {
            getGisConfig: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            analyticMapInfo: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            getLayersByMapId: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            getLayersByCode: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            getLayersByCatalogCode: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            searchStatsIdxCategory: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            searchStatsIdxItem: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            searchStatsIdxResult: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            getAllLayers: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            getAllTitle: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params={sql:'#{FILTER_PARAMENTER}'}",
            searchByLayer: BASE_URL1 + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{ACCOUNT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            getUniqueValue: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params={sql:'#{FILTER_PARAMENTER}'}",
            getLayers: BASE_URL1 + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{GUID}/#{REMOTE_METHOD}",
            getFeatures: BASE_URL1 + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{GUID}/#{REMOTE_METHOD}",
            getSuggestions: BASE_URL1 + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            suggest: BASE_URL1 + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{GUID}/#{ACCOUNT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            searchByTree: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}&isAsync=#{IS_ASYNC}",
            searchByKeyword: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?",
            searchTreeByPID: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}&relationId=#{RELATION_GUID}",
            search: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{START}/#{LIMIT}/#{REMOTE_METHOD}?params=#{FILTER_PARAMENTER}",
            getServiceInfoById: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            getBanbh: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
            getMetadataByDatasetName: BASE_URL + "/#{RESOURCE_NAME}/#{RETURE_TYPE}/#{REMOTE_METHOD}?params={#{FILTER_PARAMENTER}}",
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
                replace("#{FILTER_PARAMENTER}", parameter.FILTER_PARAMENTER).

                replace("#{ACCOUNT}", parameter.ACCOUNT);
            }
            return item;
        }

        config.URIConllection = function () {

            return conllection;
        }

        return config;

    })();

    DFastUI.Remote.Service = BaseHelper.Class.create();
    DFastUI.Remote.Service.prototype = BaseHelper.Class.inherit(BaseHelper.GUID, {
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

        CLASS_NAME: "DFastUI.Remote.Service"
    });
    module.exports = new DFastUI.Remote.Service;
});


 
