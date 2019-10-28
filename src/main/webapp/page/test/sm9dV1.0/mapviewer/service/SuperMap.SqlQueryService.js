define(function(require, exports, module) {
    BaseObject.SqlQueryService = BaseHelper.Class.create();
    BaseObject.SqlQueryService.prototype = BaseHelper.Class.inherit(BaseObject.Component, {
        initialize: function(globalMap, configData) {
            this.showAttrFlag = true;
            this.ID = this.getGUID();
            if (globalMap) {
                configData == null ? {}: configData;
                this.init(globalMap, configData)
            }
        },
        init: function(globalMap, configData) {
            this.configData = configData;
            this.globalMap = globalMap;
            var thisCallBack = this
        },
        execute: function (data, callback) {
            var thisCallBack = this;
            var datasetName = data.datasetName;
            var index = data.index;
            var fields = data.fields;
            var config=data.config;
            var attributeFilter = data.attributeFilter;
            this.refData = data.refData;
            var orderBy = data.orderBy;
            var groupBy = data.groupBy;
            var fromIndex = data.fromIndex || 0;
            var toIndex = data.toIndex || 10;
            var returnContent = data.returnContent;
            var queryParameter, getFeatureBySQLService, sqlParams;
            var datasetNames = [];
            var dataSourceName = data.dataSourceName || BaseObject.baseDatasource;
            var url =BaseObject.mapDataUrl;
            if (data.refData && data.refData.url)
                url = data.refData.url;

            if (typeof (datasetName) == "object") {
                for (var i in datasetName) {
                    if (this.globalMap.hashMapLayers[datasetName[i]] == undefined || typeof (this.globalMap.hashMapLayers[layerName[i]]) == "undefined") {
                        datasetNames.push(BaseObject.baseDatasource + ":" + datasetName[i])
                    } else {
                        dataSourceName = this.globalMap.hashMapLayers[datasetName[i]].DATASOURCE;
                        if (!dataSourceName) dataSourceName = this.globalMap.hashMapAllLayers[datasetName[i]].DATASOURCE;
                        datasetNames.push(dataSourceName + ":" + datasetName[i]);
                    }
                }
            } else {
                datasetNames.push(dataSourceName + ":" + datasetName)
            }
           
            queryParameter = new SuperMap.FilterParameter({
                fields: fields || null,
                attributeFilter: attributeFilter || "1=1 ",
                orderBy: orderBy,
                groupBy:groupBy
            });
         
            if ((fromIndex == 0 && toIndex == 0) || (fromIndex == null && toIndex == null) || (fromIndex == "" && toIndex == "")) {
                sqlParams = new SuperMap.GetFeaturesBySQLParameters({
                    queryParameter: queryParameter,
                    datasetNames: datasetNames,
                    returnContent: returnContent,
                })
            } else {
                sqlParams = new SuperMap.GetFeaturesBySQLParameters({
                    queryParameter: queryParameter,
                    datasetNames: datasetNames,
                    returnContent: returnContent,
                    fromIndex: fromIndex,
                    toIndex: toIndex
                })
            }
             
            L.supermap.featureService(url).getFeaturesBySQL(sqlParams,
            function (serviceResult) {
                thisCallBack.processCompleted(serviceResult,index,config);
                if (callback) callback(serviceResult);
            })
        },
        paging: function(start, end) {
            this.execute(this.layerName, this.fields, this.conditions, start, end, this.refData, this.orderBy)
        },
        processCompleted: function(queryEventArgs,index,config) {
            this.dispathEvent("processCompleted", {
                refData: this.refData,
                data: queryEventArgs,
                index:index,
                config:config
            })
        },
        processFailed: function(queryEventArgs) {
            this.dispathEvent("processFailed", {
                refData: this.refData,
                data: queryEventArgs
            })
        },
        initPosition: function() {},
        CLASS_NAME: "BaseObject.SqlQueryService"
    });
    module.exports = BaseObject.SqlQueryService
});